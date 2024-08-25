package willatendo.fossilslegacy.data;

import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.tags.TagBuilder;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagFile;
import net.minecraft.tags.TagKey;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.extensions.ITagAppenderExtension;
import org.jetbrains.annotations.Nullable;

import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class DataDrivenTagsProvider<T> implements DataProvider {
    protected final PackOutput.PathProvider pathProvider;
    private final CompletableFuture<HolderLookup.Provider> lookupProvider;
    private final CompletableFuture<Void> contentsDone;
    private final CompletableFuture<TagsProvider.TagLookup<T>> parentProvider;
    protected final ResourceKey<? extends Registry<T>> registryKey;
    protected final Map<ResourceLocation, TagBuilder> builders;
    protected final String modId;
    protected final @Nullable ExistingFileHelper existingFileHelper;
    private final ExistingFileHelper.IResourceType resourceType;
    private final ExistingFileHelper.IResourceType elementResourceType;

    public DataDrivenTagsProvider(PackOutput packOutput, ResourceKey<? extends Registry<T>> registryKey, CompletableFuture<HolderLookup.Provider> p_256513_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        this(packOutput, registryKey, p_256513_, CompletableFuture.completedFuture(TagsProvider.TagLookup.empty()), modId, existingFileHelper);
    }

    public DataDrivenTagsProvider(PackOutput packOutput, ResourceKey<? extends Registry<T>> registryKey, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<T>> parentProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        this.contentsDone = new CompletableFuture();
        this.builders = Maps.newLinkedHashMap();
        this.pathProvider = packOutput.createRegistryTagsPathProvider(registryKey);
        this.registryKey = registryKey;
        this.parentProvider = parentProvider;
        this.lookupProvider = lookupProvider;
        this.modId = modId;
        this.existingFileHelper = existingFileHelper;
        this.resourceType = new ExistingFileHelper.ResourceType(PackType.SERVER_DATA, ".json", Registries.tagsDirPath(registryKey));
        this.elementResourceType = new ExistingFileHelper.ResourceType(PackType.SERVER_DATA, ".json", CommonHooks.prefixNamespace(registryKey.location()));
    }

    protected @Nullable Path getPath(ResourceLocation id) {
        return this.pathProvider.json(id);
    }

    public String getName() {
        return "Tags for " + String.valueOf(this.registryKey.location()) + " mod id " + this.modId;
    }

    protected abstract void addTags(HolderLookup.Provider provider);

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        return this.createContentsProvider().thenApply(provider -> {
            this.contentsDone.complete(null);
            return provider;
        }).thenCombineAsync(this.parentProvider, (provider, tagLookup) -> {
            record CombinedData<T>(HolderLookup.Provider contents, TagsProvider.TagLookup<T> parent) {
            }

            return new CombinedData(provider, tagLookup);
        }, Util.backgroundExecutor()).thenCompose(combinedData -> {
            Predicate<ResourceLocation> predicate = resourceLocation -> true;
            Predicate<ResourceLocation> predicate1 = resourceLocation -> this.builders.containsKey(resourceLocation) || combinedData.parent.contains(TagKey.create(this.registryKey, resourceLocation));
            return CompletableFuture.allOf(this.builders.entrySet().stream().map((entry) -> {
                ResourceLocation resourcelocation = entry.getKey();
                TagBuilder tagbuilder = entry.getValue();
                List<TagEntry> tagEntries = tagbuilder.build();
                List<TagEntry> tagEntries1 = Stream.concat(tagEntries.stream(), tagbuilder.getRemoveEntries()).filter((tagEntry) -> !tagEntry.verifyIfPresent(predicate, predicate1)).filter(this::missing).toList();
                if (!tagEntries1.isEmpty()) {
                    throw new IllegalArgumentException(String.format(Locale.ROOT, "Couldn't define tag %s as it is missing following references: %s", resourcelocation, tagEntries1.stream().map(Objects::toString).collect(Collectors.joining(","))));
                } else {
                    Path path = this.getPath(resourcelocation);
                    if (path == null) {
                        return CompletableFuture.completedFuture(null);
                    } else {
                        List<TagEntry> removed = tagbuilder.getRemoveEntries().toList();
                        return DataProvider.saveStable(cachedOutput, combinedData.contents, TagFile.CODEC, new TagFile(tagEntries, tagbuilder.isReplace(), removed), path);
                    }
                }
            }).toArray((x$0) -> {
                return new CompletableFuture[x$0];
            }));
        });
    }

    private boolean missing(TagEntry reference) {
        if (!reference.isRequired()) {
            return false;
        } else {
            return this.existingFileHelper == null || !this.existingFileHelper.exists(reference.getId(), reference.isTag() ? this.resourceType : this.elementResourceType);
        }
    }

    protected TagAppender<T> tag(TagKey<T> tagKey) {
        TagBuilder tagbuilder = this.getOrCreateRawBuilder(tagKey);
        return new TagAppender(tagbuilder, this.modId);
    }

    protected TagBuilder getOrCreateRawBuilder(TagKey<T> tagKey) {
        if (this.existingFileHelper != null) {
            this.existingFileHelper.trackGenerated(tagKey.location(), this.resourceType);
        }

        return this.builders.computeIfAbsent(tagKey.location(), resourceLocation -> TagBuilder.create());
    }

    public CompletableFuture<TagsProvider.TagLookup<T>> contentsGetter() {
        return this.contentsDone.thenApply(v -> tagKey -> Optional.ofNullable(this.builders.get(tagKey.location())));
    }

    protected CompletableFuture<HolderLookup.Provider> createContentsProvider() {
        return this.lookupProvider.thenApply(provider -> {
            this.builders.clear();
            this.addTags(provider);
            return provider;
        });
    }

    @FunctionalInterface
    public interface TagLookup<T> extends Function<TagKey<T>, Optional<TagBuilder>> {
        static <T> TagsProvider.TagLookup<T> empty() {
            return tagKey -> Optional.empty();
        }

        default boolean contains(TagKey<T> tagKey) {
            return this.apply(tagKey).isPresent();
        }
    }

    public static class TagAppender<T> implements ITagAppenderExtension<T> {
        private final TagBuilder builder;
        private final String modId;

        protected TagAppender(TagBuilder tagBuilder, String modId) {
            this.builder = tagBuilder;
            this.modId = modId;
        }

        public final TagAppender<T> add(ResourceKey<T> resourceKey) {
            this.builder.addElement(resourceKey.location());
            return this;
        }

        @SafeVarargs
        public final TagAppender<T> add(ResourceKey<T>... resourceKeys) {
            for (int i = 0; i < resourceKeys.length; ++i) {
                ResourceKey<T> resourcekey = resourceKeys[i];
                this.builder.addElement(resourcekey.location());
            }

            return this;
        }

        public final TagAppender<T> addAll(List<ResourceKey<T>> resourceKeys) {
            Iterator<ResourceKey<T>> iterator = resourceKeys.iterator();

            while (iterator.hasNext()) {
                ResourceKey<T> resourcekey = iterator.next();
                this.builder.addElement(resourcekey.location());
            }

            return this;
        }

        public TagAppender<T> addOptional(ResourceLocation resourceLocation) {
            this.builder.addOptionalElement(resourceLocation);
            return this;
        }

        public TagAppender<T> addTag(TagKey<T> tagKey) {
            this.builder.addTag(tagKey.location());
            return this;
        }

        public TagAppender<T> addOptionalTag(ResourceLocation resourceLocation) {
            this.builder.addOptionalTag(resourceLocation);
            return this;
        }

        public TagAppender<T> add(TagEntry tagEntry) {
            this.builder.add(tagEntry);
            return this;
        }

        public TagBuilder getInternalBuilder() {
            return this.builder;
        }

        public String getModID() {
            return this.modId;
        }
    }
}
