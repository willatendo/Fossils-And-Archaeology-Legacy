package willatendo.fossilslegacy.client.model.json;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public record JsonModel(Optional<JsonModel.Animations> animations, List<JsonElement> jsonElements, Optional<List<String>> headPieces, Optional<Boolean> overrideReset, int textureWidth, int textureHeight) {
    public static final Codec<JsonModel> CODEC = RecordCodecBuilder.create(instance -> instance.group(JsonModel.Animations.CODEC.optionalFieldOf("animations").forGetter(JsonModel::animations), Codec.list(JsonElement.CODEC).fieldOf("elements").forGetter(JsonModel::jsonElements), Codec.list(Codec.STRING).optionalFieldOf("head_pieces").forGetter(JsonModel::headPieces), Codec.BOOL.optionalFieldOf("override_reset").forGetter(JsonModel::overrideReset), Codec.INT.fieldOf("texture_width").forGetter(JsonModel::textureWidth), Codec.INT.fieldOf("texture_height").forGetter(JsonModel::textureHeight)).apply(instance, JsonModel::new));

    public boolean isOverrideReset() {
        return this.overrideReset().orElse(false);
    }

    public LayerDefinition createModel() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition root = meshDefinition.getRoot();
        this.jsonElements().forEach(element -> this.loadElement(element, root));
        return LayerDefinition.create(meshDefinition, this.textureWidth(), this.textureHeight());
    }

    private void loadElement(JsonElement element, PartDefinition parent) {
        CubeListBuilder cubeListBuilder = CubeListBuilder.create();
        element.boxes().forEach(box -> {
            cubeListBuilder.texOffs(box.textureXOffset(), box.textureYOffset()).addBox(box.xOrigin(), box.yOrigin(), box.zOrigin(), box.xDimension(), box.yDimension(), box.zDimension());
            if (box.isMirrored()) {
                cubeListBuilder.mirror();
            }
        });
        PartDefinition partDefinition = parent.addOrReplaceChild(element.id(), cubeListBuilder, element.jsonPose().toPartPose());
        if (element.hasChild()) {
            element.jsonElements().get().forEach(child -> this.loadElement(child, partDefinition));
        }
    }

    public List<String> getLoadParts() {
        List<String> loadParts = new ArrayList<>();
        this.jsonElements().forEach(jsonElement -> this.getLoadParts(jsonElement, loadParts));
        return loadParts;
    }

    private void getLoadParts(JsonElement jsonElement, List<String> loadParts) {
        loadParts.add(jsonElement.id());
        if (jsonElement.hasChild()) {
            jsonElement.jsonElements().get().forEach(child -> this.getLoadParts(child, loadParts));
        }
    }

    public static JsonModel.Builder builder(int textureWidth, int textureHeight) {
        return new JsonModel.Builder(textureWidth, textureHeight);
    }

    public record Animations(Optional<List<ResourceLocation>> idleAnimations, Optional<List<ResourceLocation>> walkAnimations, Optional<List<ResourceLocation>> swimAnimations, Optional<List<ResourceLocation>> flyAnimations, Optional<List<ResourceLocation>> floatDownAnimations, Optional<List<ResourceLocation>> headAnimations, Optional<List<ResourceLocation>> shakeAnimations, Optional<List<ResourceLocation>> sitAnimations, Optional<List<ResourceLocation>> tailAnimations, Optional<List<ResourceLocation>> landAnimations) {
        public static final Codec<JsonModel.Animations> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.list(ResourceLocation.CODEC).optionalFieldOf("idle").forGetter(Animations::idleAnimations), Codec.list(ResourceLocation.CODEC).optionalFieldOf("walk").forGetter(Animations::walkAnimations), Codec.list(ResourceLocation.CODEC).optionalFieldOf("swim").forGetter(Animations::swimAnimations), Codec.list(ResourceLocation.CODEC).optionalFieldOf("fly").forGetter(Animations::flyAnimations), Codec.list(ResourceLocation.CODEC).optionalFieldOf("float_down").forGetter(Animations::floatDownAnimations), Codec.list(ResourceLocation.CODEC).optionalFieldOf("head").forGetter(Animations::headAnimations), Codec.list(ResourceLocation.CODEC).optionalFieldOf("shake").forGetter(Animations::shakeAnimations), Codec.list(ResourceLocation.CODEC).optionalFieldOf("sit").forGetter(Animations::sitAnimations), Codec.list(ResourceLocation.CODEC).optionalFieldOf("tail").forGetter(Animations::tailAnimations), Codec.list(ResourceLocation.CODEC).optionalFieldOf("land").forGetter(Animations::landAnimations)).apply(instance, JsonModel.Animations::new));

        public boolean hasAnimations() {
            return this.hasAnimation(this.walkAnimations) || this.hasAnimation(this.swimAnimations) || this.hasAnimation(this.flyAnimations) || this.hasAnimation(this.floatDownAnimations) || this.hasAnimation(this.headAnimations) || this.hasAnimation(this.shakeAnimations) || this.hasAnimation(this.sitAnimations) || this.hasAnimation(this.tailAnimations) || this.hasAnimation(this.landAnimations);
        }

        private boolean hasAnimation(Optional<List<ResourceLocation>> animations) {
            return animations.isPresent() && !animations.get().isEmpty();
        }

        public AnimationHolder toAnimationHolder() {
            return new AnimationHolder(this.walkAnimations().orElse(List.of()), this.swimAnimations().orElse(List.of()), this.flyAnimations().orElse(List.of()), this.floatDownAnimations().orElse(List.of()), this.headAnimations().orElse(List.of()), this.shakeAnimations().orElse(List.of()), this.sitAnimations().orElse(List.of()), this.tailAnimations().orElse(List.of()), this.landAnimations().orElse(List.of()));
        }
    }

    public static final class Builder {
        private final List<JsonElement> jsonElements = new ArrayList<>();
        private final List<ResourceLocation> idleAnimation = new ArrayList<>();
        private final List<ResourceLocation> walkAnimation = new ArrayList<>();
        private final List<ResourceLocation> swimAnimation = new ArrayList<>();
        private final List<ResourceLocation> flyAnimation = new ArrayList<>();
        private final List<ResourceLocation> floatDownAnimation = new ArrayList<>();
        private final List<ResourceLocation> headAnimation = new ArrayList<>();
        private final List<ResourceLocation> shakeAnimation = new ArrayList<>();
        private final List<ResourceLocation> sitAnimation = new ArrayList<>();
        private final List<ResourceLocation> tailAnimation = new ArrayList<>();
        private final List<ResourceLocation> landAnimation = new ArrayList<>();
        private final List<String> headPieces = new ArrayList<>();
        private final int textureWidth;
        private final int textureHeight;
        private boolean overrideReset = false;

        private Builder(int textureWidth, int textureHeight) {
            this.textureWidth = textureWidth;
            this.textureHeight = textureHeight;
        }

        public Builder withElement(JsonElement jsonElement) {
            this.jsonElements.add(jsonElement);
            return this;
        }

        public Builder addOrReplaceChild(String name, Function<JsonElement.Builder, JsonElement> jsonElement, JsonPose jsonPose) {
            this.jsonElements.add(jsonElement.apply(JsonElement.builder(name, jsonPose)));
            return this;
        }

        public Builder withIdleAnimations(ResourceLocation... animations) {
            this.walkAnimation.addAll(List.of(animations));
            return this;
        }

        public Builder withWalkAnimations(ResourceLocation... animations) {
            this.walkAnimation.addAll(List.of(animations));
            return this;
        }

        public Builder withSwimAnimations(ResourceLocation... animations) {
            this.swimAnimation.addAll(List.of(animations));
            return this;
        }

        public Builder withFlyAnimations(ResourceLocation... animations) {
            this.flyAnimation.addAll(List.of(animations));
            return this;
        }

        public Builder withFloatDownAnimations(ResourceLocation... animations) {
            this.floatDownAnimation.addAll(List.of(animations));
            return this;
        }

        public Builder withHeadAnimations(ResourceLocation... animations) {
            this.headAnimation.addAll(List.of(animations));
            return this;
        }

        public Builder withShakeAnimations(ResourceLocation... animations) {
            this.shakeAnimation.addAll(List.of(animations));
            return this;
        }

        public Builder withSitAnimations(ResourceLocation... animations) {
            this.sitAnimation.addAll(List.of(animations));
            return this;
        }

        public Builder withTailAnimations(ResourceLocation... animations) {
            this.tailAnimation.addAll(List.of(animations));
            return this;
        }

        public Builder withLandAnimations(ResourceLocation... animations) {
            this.landAnimation.addAll(List.of(animations));
            return this;
        }

        public Builder withHeadPieces(String... headPiece) {
            this.headPieces.addAll(List.of(headPiece));
            return this;
        }

        public Builder overrideReset() {
            this.overrideReset = true;
            return this;
        }

        public JsonModel build() {
            JsonModel.Animations animations = new JsonModel.Animations(this.idleAnimation.isEmpty() ? Optional.empty() : Optional.of(this.idleAnimation), this.walkAnimation.isEmpty() ? Optional.empty() : Optional.of(this.walkAnimation), this.swimAnimation.isEmpty() ? Optional.empty() : Optional.of(this.swimAnimation), this.flyAnimation.isEmpty() ? Optional.empty() : Optional.of(this.flyAnimation), this.floatDownAnimation.isEmpty() ? Optional.empty() : Optional.of(this.floatDownAnimation), this.headAnimation.isEmpty() ? Optional.empty() : Optional.of(this.headAnimation), this.shakeAnimation.isEmpty() ? Optional.empty() : Optional.of(this.shakeAnimation), this.sitAnimation.isEmpty() ? Optional.empty() : Optional.of(this.sitAnimation), this.tailAnimation.isEmpty() ? Optional.empty() : Optional.of(this.tailAnimation), this.landAnimation.isEmpty() ? Optional.empty() : Optional.of(this.landAnimation));
            return new JsonModel(animations.hasAnimations() ? Optional.of(animations) : Optional.empty(), this.jsonElements, this.headPieces.isEmpty() ? Optional.empty() : Optional.of(this.headPieces), this.overrideReset ? Optional.of(true) : Optional.empty(), this.textureWidth, this.textureHeight);
        }
    }
}
