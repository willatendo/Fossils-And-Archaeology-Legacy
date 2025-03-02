package willatendo.fossilslegacy.client.model.json;

import net.minecraft.resources.ResourceLocation;

import java.util.List;

public record AnimationHolder(List<ResourceLocation> walkAnimation, List<ResourceLocation> swimAnimation, List<ResourceLocation> flyAnimation, List<ResourceLocation> floatAnimation, List<ResourceLocation> headAnimation, List<ResourceLocation> shakeAnimation, List<ResourceLocation> sitAnimation, List<ResourceLocation> tailAnimation, List<ResourceLocation> landAnimation) {
    public static final AnimationHolder EMPTY = new AnimationHolder(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of());

    public boolean hasWalkAnimations() {
        return !this.walkAnimation().isEmpty();
    }

    public boolean hasSwimAnimations() {
        return !this.swimAnimation().isEmpty();
    }

    public boolean hasFlyAnimations() {
        return !this.flyAnimation().isEmpty();
    }

    public boolean hasFloatAnimations() {
        return !this.floatAnimation().isEmpty();
    }

    public boolean hasHeadAnimations() {
        return !this.headAnimation().isEmpty();
    }

    public boolean hasShakeAnimations() {
        return !this.shakeAnimation().isEmpty();
    }

    public boolean hasSitAnimations() {
        return !this.sitAnimation().isEmpty();
    }

    public boolean hasTailAnimations() {
        return !this.tailAnimation().isEmpty();
    }

    public boolean hasLandAnimations() {
        return !this.landAnimation().isEmpty();
    }
}
