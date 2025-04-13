package willatendo.fossilslegacy.client.model.json;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.api.client.BuiltInAnimationType;
import willatendo.fossilslegacy.client.animation.json.JsonAnimationLoader;
import willatendo.fossilslegacy.client.state.*;

import java.util.List;

public class JsonTypeModel extends EntityModel<DinosaurRenderState> {
    private final AnimationHolder animationHolder;
    private final List<ModelPart> headPieces;
    private final LoadedParts loadedParts;
    private final boolean overrideReset;

    public JsonTypeModel(ResourceLocation id, boolean overrideReset, ModelPart root) {
        super(root);
        this.animationHolder = JsonModelLoader.getAnimations(id);
        this.headPieces = JsonModelLoader.getHeadPieces(id, root);
        this.loadedParts = new LoadedParts(JsonModelLoader.getLoadParts(id), root);
        this.overrideReset = overrideReset;
    }

    public ModelPart get(String name) {
        return this.loadedParts.get(name);
    }

    public float getX(String name) {
        return this.loadedParts.getX(name);
    }

    public float getY(String name) {
        return this.loadedParts.getY(name);
    }

    public float getZ(String name) {
        return this.loadedParts.getZ(name);
    }

    public void setX(String name, float angle) {
        this.loadedParts.setX(name, angle);
    }

    public void setY(String name, float angle) {
        this.loadedParts.setY(name, angle);
    }

    public void setZ(String name, float angle) {
        this.loadedParts.setZ(name, angle);
    }

    public void addX(String name, float angle) {
        this.loadedParts.addX(name, angle);
    }

    public void addY(String name, float angle) {
        this.loadedParts.addY(name, angle);
    }

    public void addZ(String name, float angle) {
        this.loadedParts.addZ(name, angle);
    }

    public void subtractX(String name, float angle) {
        this.loadedParts.subtractX(name, angle);
    }

    public void subtractY(String name, float angle) {
        this.loadedParts.subtractY(name, angle);
    }

    public void subtractZ(String name, float angle) {
        this.loadedParts.subtractZ(name, angle);
    }

    public float getXRot(String name) {
        return this.loadedParts.getXRot(name);
    }

    public float getYRot(String name) {
        return this.loadedParts.getYRot(name);
    }

    public float getZRot(String name) {
        return this.loadedParts.getZRot(name);
    }

    public void setXRot(String name, float angle) {
        this.loadedParts.setXRot(name, angle);
    }

    public void setYRot(String name, float angle) {
        this.loadedParts.setYRot(name, angle);
    }

    public void setZRot(String name, float angle) {
        this.loadedParts.setZRot(name, angle);
    }

    public void addXRot(String name, float angle) {
        this.loadedParts.addXRot(name, angle);
    }

    public void addYRot(String name, float angle) {
        this.loadedParts.addYRot(name, angle);
    }

    public void addZRot(String name, float angle) {
        this.loadedParts.addZRot(name, angle);
    }

    public void subtractXRot(String name, float angle) {
        this.loadedParts.subtractXRot(name, angle);
    }

    public void subtractYRot(String name, float angle) {
        this.loadedParts.subtractYRot(name, angle);
    }

    public void subtractZRot(String name, float angle) {
        this.loadedParts.subtractZRot(name, angle);
    }

    public void setPos(String name, float x, float y, float z) {
        this.loadedParts.setPos(name, x, y, z);
    }

    @Override
    public void setupAnim(DinosaurRenderState dinosaurRenderState) {
        if (dinosaurRenderState.isTranquilized && this.animationHolder.hasSleepAnimations()) {
            this.resetPose();
            for (ResourceLocation animation : this.animationHolder.sleepAnimation()) {
                this.applyStatic(JsonAnimationLoader.getAnimation(animation));
            }
            return;
        }

        if (dinosaurRenderState instanceof TyrannosaurusRenderState tyrannosaurusRenderState) {
            if (tyrannosaurusRenderState.knockedOut) {
                return;
            }
        }

        if (!this.overrideReset) {
            this.resetPose();
        }

        if (dinosaurRenderState instanceof SmilodonRenderState smilodonRenderState) {
            if (this.animationHolder.hasSitAnimations()) {
                for (ResourceLocation animation : this.animationHolder.sitAnimation()) {
                    if (!JsonAnimationLoader.isBuiltIn(animation)) {
                        this.animate(smilodonRenderState.sitAnimationState, JsonAnimationLoader.getAnimation(animation), dinosaurRenderState.ageInTicks);
                    }
                }
            }
        }

        if (!this.animationHolder.hasSitAnimations() || !dinosaurRenderState.isOrderedToSit) {
            if (this.animationHolder.hasHeadAnimations()) {
                for (ResourceLocation animation : this.animationHolder.headAnimation()) {
                    if (JsonAnimationLoader.isBuiltIn(animation)) {
                        BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animation);
                        if (builtInAnimationType.canUse(dinosaurRenderState)) {
                            builtInAnimationType.setupAnim(dinosaurRenderState, this, dinosaurRenderState.walkAnimationPos, dinosaurRenderState.walkAnimationSpeed, dinosaurRenderState.yRot);
                        }
                    }
                }
            } else {
                if (dinosaurRenderState instanceof PteranodonRenderState pteranodonRenderState) {
                    if (!pteranodonRenderState.shouldFly && !pteranodonRenderState.shouldLand) {
                        this.standardHead(pteranodonRenderState.yRot, pteranodonRenderState.xRot);
                    }
                } else {
                    this.standardHead(dinosaurRenderState.yRot, dinosaurRenderState.xRot);
                }
            }

            if (this.animationHolder.hasFlyAnimations()) {
                for (ResourceLocation animation : this.animationHolder.flyAnimation()) {
                    if (JsonAnimationLoader.isBuiltIn(animation)) {
                        BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animation);
                        if (builtInAnimationType.canUse(dinosaurRenderState)) {
                            builtInAnimationType.setupAnim(dinosaurRenderState, this, dinosaurRenderState.walkAnimationPos, dinosaurRenderState.walkAnimationSpeed, dinosaurRenderState.yRot);
                        }
                    } else {
                        if (dinosaurRenderState instanceof PteranodonRenderState pteranodonRenderState) {
                            this.animate(pteranodonRenderState.flyingAnimationState, JsonAnimationLoader.getAnimation(animation), pteranodonRenderState.ageInTicks);
                        }
                    }
                }
            }

            if (dinosaurRenderState instanceof PteranodonRenderState pteranodonRenderState) {
                if (this.animationHolder.hasLandAnimations()) {
                    for (ResourceLocation animation : this.animationHolder.landAnimation()) {
                        this.animate(pteranodonRenderState.landAnimationState, JsonAnimationLoader.getAnimation(animation), pteranodonRenderState.ageInTicks);
                    }
                }
            }

            if (this.animationHolder.hasSwimAnimations() && dinosaurRenderState.inWater) {
                for (ResourceLocation animation : this.animationHolder.swimAnimation()) {
                    if (JsonAnimationLoader.isBuiltIn(animation)) {
                        BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animation);
                        if (builtInAnimationType.canUse(dinosaurRenderState)) {
                            builtInAnimationType.setupAnim(dinosaurRenderState, this, dinosaurRenderState.walkAnimationPos, dinosaurRenderState.walkAnimationSpeed, dinosaurRenderState.yRot);
                        }
                    } else {
                        this.animateWalk(JsonAnimationLoader.getAnimation(animation), dinosaurRenderState.walkAnimationPos, dinosaurRenderState.walkAnimationSpeed, 2.0F, 2.5F);
                    }
                }
            } else {
                if (this.animationHolder.hasWalkAnimations()) {
                    if (dinosaurRenderState instanceof PteranodonRenderState pteranodonRenderState) {
                        if (!pteranodonRenderState.shouldFly && !pteranodonRenderState.shouldLand) {
                            this.animateWalk(this.animationHolder, dinosaurRenderState, dinosaurRenderState.walkAnimationPos, dinosaurRenderState.walkAnimationSpeed, dinosaurRenderState.yRot);
                        }
                    } else {
                        this.animateWalk(this.animationHolder, dinosaurRenderState, dinosaurRenderState.walkAnimationPos, dinosaurRenderState.walkAnimationSpeed, dinosaurRenderState.yRot);
                    }
                }
            }

            if (dinosaurRenderState instanceof DodoRenderState dodoRenderState) {
                if (this.animationHolder.hasFloatAnimations()) {
                    for (ResourceLocation animation : this.animationHolder.floatAnimation()) {
                        this.animate(dodoRenderState.fallAnimationState, JsonAnimationLoader.getAnimation(animation), dinosaurRenderState.ageInTicks);
                    }
                }
            }
        } else {
            if (dinosaurRenderState instanceof PteranodonRenderState pteranodonRenderState) {
                if (!pteranodonRenderState.shouldFly && !pteranodonRenderState.shouldLand) {
                    this.standardHead(pteranodonRenderState.yRot, pteranodonRenderState.xRot);
                }
            } else {
                this.standardHead(dinosaurRenderState.yRot, dinosaurRenderState.xRot);
            }
        }
    }

    private void standardHead(float netHeadYaw, float headPitch) {
        netHeadYaw = Mth.clamp(netHeadYaw, -30.0F, 30.0F);
        headPitch = Mth.clamp(headPitch, -25.0F, 45.0F);
        for (ModelPart modelPart : this.headPieces) {
            modelPart.yRot = netHeadYaw * 0.017453292F;
            modelPart.xRot = headPitch * 0.017453292F;
        }
    }

    private void animateWalk(AnimationHolder animationHolder, DinosaurRenderState dinosaurRenderState, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        for (ResourceLocation animation : animationHolder.walkAnimation()) {
            if (JsonAnimationLoader.isBuiltIn(animation)) {
                BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animation);
                if (builtInAnimationType.canUse(dinosaurRenderState)) {
                    builtInAnimationType.setupAnim(dinosaurRenderState, this, limbSwing, limbSwingAmount, netHeadYaw);
                }
            } else {
                this.animateWalk(JsonAnimationLoader.getAnimation(animation), limbSwing, limbSwingAmount, 2.0F, 2.5F);
            }
        }
    }
}
