package willatendo.fossilslegacy.api.data;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.api.client.BuiltInAnimationType;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public record EntityModelHolder(ResourceLocation id, LayerDefinition layerDefinition, Optional<Boolean> overrideReset, Map<String, List<ResourceLocation>> animations, Map<String, List<BuiltInAnimationType>> builtInAnimations, String... headPieces) {

    public static Builder builder(ResourceLocation id, LayerDefinition layerDefinition) {
        return new Builder(id, layerDefinition);
    }

    public static class Builder {
        private final ResourceLocation id;
        private final LayerDefinition layerDefinition;
        private final Map<String, List<ResourceLocation>> animations = Maps.newHashMap();
        private final Map<String, List<BuiltInAnimationType>> builtInAnimations = Maps.newHashMap();
        private final List<String> headPieces = Lists.newArrayList();
        private Optional<Boolean> overrideReset = Optional.empty();

        protected Builder(ResourceLocation id, LayerDefinition layerDefinition) {
            this.id = id;
            this.layerDefinition = layerDefinition;
        }

        public Builder withAnimation(String type, ResourceLocation... animations) {
            this.animations.put(type, List.of(animations));
            return this;
        }

        public Builder withBuiltInAnimation(String type, BuiltInAnimationType... animations) {
            this.builtInAnimations.put(type, List.of(animations));
            return this;
        }

        public Builder withHeadPeices(String... headPeices) {
            this.headPieces.addAll(List.of(headPeices));
            return this;
        }

        public Builder overrideReset() {
            this.overrideReset = Optional.of(true);
            return this;
        }

        public EntityModelHolder build() {
            return new EntityModelHolder(this.id, this.layerDefinition, this.overrideReset, this.animations, this.builtInAnimations, this.headPieces.toArray(String[]::new));
        }
    }
}