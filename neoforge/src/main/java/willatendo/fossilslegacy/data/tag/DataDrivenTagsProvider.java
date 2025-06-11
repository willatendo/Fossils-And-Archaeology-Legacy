package willatendo.fossilslegacy.data.tag;

import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagBuilder;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagFile;
import net.minecraft.tags.TagKey;
import net.neoforged.neoforge.common.extensions.ITagAppenderExtension;

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
    private final CompletableFuture<DataDrivenTagsProvider.TagLookup<T>> parentProvider;
    protected final ResourceKey<? extends Registry<T>> registryKey;
    protected final Map<ResourceLocation, TagBuilder> builders;
    protected final String modId;

    protected DataDrivenTagsProvider(PackOutput output, ResourceKey<? extends Registry<T>> registryKey, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId) {
        this(output, registryKey, lookupProvider, CompletableFuture.completedFuture(DataDrivenTagsProvider.TagLookup.empty()), modId);
    }

    protected DataDrivenTagsProvider(PackOutput output, ResourceKey<? extends Registry<T>> registryKey, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<DataDrivenTagsProvider.TagLookup<T>> parentProvider, String modId) {
        this.contentsDone = new CompletableFuture<>();
        this.builders = Maps.newLinkedHashMap();
        this.pathProvider = output.createRegistryTagsPathProvider(registryKey);
        this.registryKey = registryKey;
        this.parentProvider = parentProvider;
        this.lookupProvider = lookupProvider;
        this.modId = modId;
    }

    protected Path getPath(ResourceLocation id) {
        return this.pathProvider.json(id);
    }

    @Override
    public String getName() {
        return "Tags for " + this.registryKey.location() + " mod id " + this.modId;
    }

    protected abstract void addTags(HolderLookup.Provider provider);

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        return this.createContentsProvider().thenApply((provider) -> {
            this.contentsDone.complete(null);
            return provider;
        }).thenCombineAsync(this.parentProvider, (provider, tagLookup) -> {
            record CombinedData<T>(HolderLookup.Provider contents, DataDrivenTagsProvider.TagLookup<T> parent) {
            }

            return new CombinedData(provider, tagLookup);
        }, Util.backgroundExecutor()).thenCompose((combinedData) -> {
            Predicate<ResourceLocation> predicate = resourceLocation -> true;
            Predicate<ResourceLocation> predicate1 = resourceLocation -> this.builders.containsKey(resourceLocation) || combinedData.parent.contains(TagKey.create(this.registryKey, resourceLocation));
            return CompletableFuture.allOf(this.builders.entrySet().stream().map(entry -> {
                ResourceLocation resourcelocation = entry.getKey();
                TagBuilder tagbuilder = entry.getValue();
                List<TagEntry> tagEntries1 = tagbuilder.build();
                List<TagEntry> tagEntries2 = Stream.concat(tagEntries1.stream(), tagbuilder.getRemoveEntries()).filter(tagEntry -> tagEntry.getId().getNamespace().equals(this.modId) && !tagEntry.verifyIfPresent(predicate, predicate1)).toList();
                if (!tagEntries2.isEmpty()) {
                    throw new IllegalArgumentException(String.format(Locale.ROOT, "Couldn't define tag %s as it is missing following references: %s", resourcelocation, tagEntries2.stream().map(Objects::toString).collect(Collectors.joining(","))));
                } else {
                    Path path = this.getPath(resourcelocation);
                    if (path == null) {
                        return CompletableFuture.completedFuture(null);
                    } else {
                        List<TagEntry> removed = tagbuilder.getRemoveEntries().toList();
                        return DataProvider.saveStable(cachedOutput, combinedData.contents, TagFile.CODEC, new TagFile(tagEntries1, tagbuilder.isReplace(), removed), path);
                    }
                }
            }).toArray(CompletableFuture[]::new));
        });
    }

    protected DataDrivenTagsProvider.TagAppender<T> tag(TagKey<T> tagKey) {
        TagBuilder tagbuilder = this.getOrCreateRawBuilder(tagKey);
        return new DataDrivenTagsProvider.TagAppender<>(tagbuilder);
    }

    protected TagBuilder getOrCreateRawBuilder(TagKey<T> tag) {
        return this.builders.computeIfAbsent(tag.location(), resourceLocation -> TagBuilder.create());
    }

    public CompletableFuture<DataDrivenTagsProvider.TagLookup<T>> contentsGetter() {
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
        static <T> DataDrivenTagsProvider.TagLookup<T> empty() {
            return tagKey -> Optional.empty();
        }

        default boolean contains(TagKey<T> key) {
            return this.apply(key).isPresent();
        }
    }

    public static class TagAppender<T> implements ITagAppenderExtension<T> {
        private final TagBuilder builder;

        protected TagAppender(TagBuilder builder) {
            this.builder = builder;
        }

        public final DataDrivenTagsProvider.TagAppender<T> add(ResourceKey<T> key) {
            this.builder.addElement(key.location());
            return this;
        }

        @SafeVarargs
        public final DataDrivenTagsProvider.TagAppender<T> add(ResourceKey<T>... keys) {
            for (ResourceKey<T> resourcekey : keys) {
                this.builder.addElement(resourcekey.location());
            }

            return this;
        }

        public final DataDrivenTagsProvider.TagAppender<T> addAll(List<ResourceKey<T>> keys) {
            for (ResourceKey<T> key : keys) {
                this.builder.addElement(key.location());
            }

            return this;
        }

        public DataDrivenTagsProvider.TagAppender<T> addOptional(ResourceLocation resourceLocation) {
            this.builder.addOptionalElement(resourceLocation);
            return this;
        }

        public DataDrivenTagsProvider.TagAppender<T> addTag(TagKey<T> tagKey) {
            this.builder.addTag(tagKey.location());
            return this;
        }

        public DataDrivenTagsProvider.TagAppender<T> addOptionalTag(ResourceLocation resourceLocation) {
            this.builder.addOptionalTag(resourceLocation);
            return this;
        }

        public DataDrivenTagsProvider.TagAppender<T> add(TagEntry tagEntry) {
            this.builder.add(tagEntry);
            return this;
        }

        public TagBuilder getInternalBuilder() {
            return this.builder;
        }
    }
}
