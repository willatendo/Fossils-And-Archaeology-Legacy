package willatendo.fossilslegacy.server;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.IdMap;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Optional;

public interface RegistryHolder<T> extends IdMap<T> {
    T getOrThrow(ResourceKey<T> resourceKey);

    Holder<T> getHolderOrThrow(ResourceKey<T> resourceKey);

    Optional<Holder.Reference<T>> getHolder(ResourceKey<T> resourceKey);

    Optional<HolderSet.Named<T>> getTag(TagKey<T> tagKey);

    Iterable<Holder<T>> getTagOrEmpty(TagKey<T> tagKey);

    ResourceLocation getKey(T value);

    T get(ResourceLocation resourceLocation);

    IdMap<Holder<T>> asHolderIdMap();

    Registry<T> registry();


    public static record BasicRegistryHolder<T>(Registry<T> registry) implements RegistryHolder<T> {
        @Override
        public T getOrThrow(ResourceKey<T> resourceKey) {
            return this.registry.getOrThrow(resourceKey);
        }

        @Override
        public Holder<T> getHolderOrThrow(ResourceKey<T> resourceKey) {
            return this.registry.getHolderOrThrow(resourceKey);
        }

        @Override
        public Optional<Holder.Reference<T>> getHolder(ResourceKey<T> resourceKey) {
            return this.registry.getHolder(resourceKey);
        }

        @Override
        public Optional<HolderSet.Named<T>> getTag(TagKey<T> tagKey) {
            return this.registry.getTag(tagKey);
        }

        @Override
        public Iterable<Holder<T>> getTagOrEmpty(TagKey<T> tagKey) {
            return this.registry.getTagOrEmpty(tagKey);
        }

        @Override
        public ResourceLocation getKey(T value) {
            return this.registry.getKey(value);
        }

        @Override
        public T get(ResourceLocation resourceLocation) {
            return this.registry.get(resourceLocation);
        }

        @Override
        public IdMap<Holder<T>> asHolderIdMap() {
            return this.registry.asHolderIdMap();
        }

        @Override
        public int getId(T value) {
            return this.registry.getId(value);
        }

        @Override
        public T byId(int id) {
            return this.registry.byId(id);
        }

        @Override
        public int size() {
            return this.registry.size();
        }

        @NotNull
        @Override
        public Iterator<T> iterator() {
            return this.registry.iterator();
        }
    }
}
