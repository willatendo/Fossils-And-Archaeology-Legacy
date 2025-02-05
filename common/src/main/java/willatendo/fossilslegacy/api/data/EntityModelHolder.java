package willatendo.fossilslegacy.api.data;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.api.client.BuiltInAnimationType;

import java.util.List;
import java.util.Map;

public record EntityModelHolder(ResourceLocation id, LayerDefinition layerDefinition, boolean colored, boolean overrideReset, Map<String, ResourceLocation[]> animations, Map<String, BuiltInAnimationType[]> builtInAnimations, String... headPieces) {

    public static Builder builder(ResourceLocation id, LayerDefinition layerDefinition) {
        return new Builder(id, layerDefinition);
    }

    public static class Builder {
        private final ResourceLocation id;
        private final LayerDefinition layerDefinition;
        private final Map<String, ResourceLocation[]> animations = Maps.newHashMap();
        private final Map<String, BuiltInAnimationType[]> builtInAnimations = Maps.newHashMap();
        private final List<String> headPieces = Lists.newArrayList();
        private boolean colored = false;
        private boolean overrideReset = false;

        protected Builder(ResourceLocation id, LayerDefinition layerDefinition) {
            this.id = id;
            this.layerDefinition = layerDefinition;
        }

        public Builder withAnimation(String type, ResourceLocation... id) {
            this.animations.put(type, id);
            return this;
        }

        public Builder withBuiltInAnimation(String type, BuiltInAnimationType... id) {
            this.builtInAnimations.put(type, id);
            return this;
        }

        public Builder withHeadPeices(String... headPeices) {
            this.headPieces.addAll(List.of(headPeices));
            return this;
        }

        public Builder colored() {
            this.colored = true;
            return this;
        }

        public Builder overrideReset() {
            this.overrideReset = true;
            return this;
        }

        public EntityModelHolder build() {
            return new EntityModelHolder(this.id, this.layerDefinition, this.colored, this.overrideReset, this.animations, this.builtInAnimations, this.headPieces.toArray(String[]::new));
        }
    }
}