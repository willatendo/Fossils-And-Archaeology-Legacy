package willatendo.fossilslegacy.client.model.json;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.api.client.BuiltInAnimationType;
import willatendo.fossilslegacy.client.animation.json.JsonAnimationLoader;
import willatendo.fossilslegacy.client.model.dinosaur.DinosaurModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.util.interfaces.AnimatedSittingEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.FloatDownEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.FlyingDinosaur;

import java.util.List;
import java.util.Optional;

public class JsonModel<T extends Dinosaur> extends DinosaurModel<T> {
    private final Optional<JsonModelLoader.AnimationHolder> animationHolder;
    private final List<ModelPart> headPieces;
    private final LoadedParts loadedParts;
    private final boolean colored;
    private final boolean overrideReset;
    private int color = -1;

    public JsonModel(ResourceLocation id, boolean colored, boolean overrideReset, ModelPart root) {
        super(root);
        this.animationHolder = JsonModelLoader.getAnimations(id);
        this.headPieces = JsonModelLoader.getHeadPieces(id, root);
        this.loadedParts = new LoadedParts(JsonModelLoader.getLoadParts(id), root);
        this.colored = colored;
        this.overrideReset = overrideReset;
    }

    public boolean isColored() {
        return this.colored;
    }

    public void setColor(int color) {
        this.color = color;
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
    public void prepareMobModel(T dinosaur, float limbSwing, float limbSwingAmount, float partialTick) {
        if (this.animationHolder.isPresent()) {
            JsonModelLoader.AnimationHolder animationHolder = this.animationHolder.get();
            if (animationHolder.hasWalkAnimations()) {
                for (ResourceLocation animation : animationHolder.walkAnimation()) {
                    if (JsonAnimationLoader.isBuiltIn(animation)) {
                        BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animation);
                        if (builtInAnimationType.canUse(dinosaur)) {
                            builtInAnimationType.prepareMobModel(dinosaur, this, limbSwing, limbSwingAmount, partialTick);
                        }
                    }
                }
            }
            if (animationHolder.hasTailAnimations()) {
                for (ResourceLocation animation : animationHolder.tailAnimation()) {
                    if (JsonAnimationLoader.isBuiltIn(animation)) {
                        BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animation);
                        if (builtInAnimationType.canUse(dinosaur)) {
                            builtInAnimationType.prepareMobModel(dinosaur, this, limbSwing, limbSwingAmount, partialTick);
                        }
                    }
                }
            }
            if (animationHolder.hasSitAnimations()) {
                for (ResourceLocation animation : animationHolder.sitAnimation()) {
                    if (JsonAnimationLoader.isBuiltIn(animation)) {
                        BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animation);
                        if (builtInAnimationType.canUse(dinosaur)) {
                            builtInAnimationType.prepareMobModel(dinosaur, this, limbSwing, limbSwingAmount, partialTick);
                        }
                    }
                }
            }
            if (animationHolder.hasShakeAnimations()) {
                for (ResourceLocation animation : animationHolder.shakeAnimation()) {
                    if (JsonAnimationLoader.isBuiltIn(animation)) {
                        BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animation);
                        if (builtInAnimationType.canUse(dinosaur)) {
                            builtInAnimationType.prepareMobModel(dinosaur, this, limbSwing, limbSwingAmount, partialTick);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void setupAnim(Dinosaur dinosaur, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!this.overrideReset) {
            this.root().getAllParts().forEach(ModelPart::resetPose);


            if (this.animationHolder.isPresent()) {
                JsonModelLoader.AnimationHolder animationHolder = this.animationHolder.get();

                if (!animationHolder.hasSitAnimations() || !dinosaur.isOrderedToSit()) {
                    if (animationHolder.hasHeadAnimations()) {
                        for (ResourceLocation animation : animationHolder.headAnimation()) {
                            if (JsonAnimationLoader.isBuiltIn(animation)) {
                                BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animation);
                                if (builtInAnimationType.canUse(dinosaur)) {
                                    builtInAnimationType.setupAnim(dinosaur, this, limbSwing, limbSwingAmount, netHeadYaw);
                                }
                            }
                        }
                    } else {
                        if (dinosaur instanceof FlyingDinosaur flyingDinosaur) {
                            if (!flyingDinosaur.shouldFly() && !flyingDinosaur.shouldLand()) {
                                this.standardHead(netHeadYaw, headPitch);
                            }
                        } else {
                            this.standardHead(netHeadYaw, headPitch);
                        }
                    }

                    if (animationHolder.hasFlyAnimations()) {
                        for (ResourceLocation animation : animationHolder.flyAnimation()) {
                            if (JsonAnimationLoader.isBuiltIn(animation)) {
                                BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animation);
                                if (builtInAnimationType.canUse(dinosaur)) {
                                    builtInAnimationType.setupAnim(dinosaur, this, limbSwing, limbSwingAmount, netHeadYaw);
                                }
                            } else {
                                if (dinosaur instanceof FlyingDinosaur flyingDinosaur) {
                                    this.animate(flyingDinosaur.getFlyingAnimationState(), JsonAnimationLoader.getAnimation(animation), ageInTicks);
                                }
                            }
                        }
                    }

                    if (dinosaur instanceof FlyingDinosaur flyingDinosaur) {
                        if (animationHolder.hasLandAnimations()) {
                            for (ResourceLocation animation : animationHolder.landAnimation()) {
                                this.animate(flyingDinosaur.getLandingAnimationState(), JsonAnimationLoader.getAnimation(animation), ageInTicks);
                            }
                        }
                    }

                    if (animationHolder.hasSwimAnimations() && dinosaur.isInWaterOrBubble()) {
                        for (ResourceLocation animation : animationHolder.swimAnimation()) {
                            if (JsonAnimationLoader.isBuiltIn(animation)) {
                                BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animation);
                                if (builtInAnimationType.canUse(dinosaur)) {
                                    builtInAnimationType.setupAnim(dinosaur, this, limbSwing, limbSwingAmount, netHeadYaw);
                                }
                            } else {
                                this.animateWalk(JsonAnimationLoader.getAnimation(animation), limbSwing, limbSwingAmount, 2.0F, 2.5F);
                            }
                        }
                    } else {
                        if (animationHolder.hasWalkAnimations()) {
                            if (dinosaur instanceof FlyingDinosaur flyingDinosaur) {
                                if (!flyingDinosaur.shouldFly() && !flyingDinosaur.shouldLand()) {
                                    this.animateWalk(animationHolder, dinosaur, limbSwing, limbSwingAmount, netHeadYaw);
                                }
                            } else {
                                this.animateWalk(animationHolder, dinosaur, limbSwing, limbSwingAmount, netHeadYaw);
                            }
                        }
                    }

                    if (dinosaur instanceof AnimatedSittingEntity animatedSittingEntity) {
                        if (animationHolder.hasSitAnimations()) {
                            for (ResourceLocation animation : animationHolder.sitAnimation()) {
                                if (!JsonAnimationLoader.isBuiltIn(animation)) {
                                    this.animate(animatedSittingEntity.getSitAnimationState(), JsonAnimationLoader.getAnimation(animation), ageInTicks);
                                }
                            }

                        }
                    }

                    if (dinosaur instanceof FloatDownEntity floatDownEntity) {
                        if (animationHolder.hasFloatAnimations()) {
                            for (ResourceLocation animation : animationHolder.floatAnimation()) {
                                this.animate(floatDownEntity.getFallAnimationState(), JsonAnimationLoader.getAnimation(animation), ageInTicks);
                            }
                        }
                    }
                }
            } else {
                if (dinosaur instanceof FlyingDinosaur flyingDinosaur) {
                    if (!flyingDinosaur.shouldFly() && !flyingDinosaur.shouldLand()) {
                        this.standardHead(netHeadYaw, headPitch);
                    }
                } else {
                    this.standardHead(netHeadYaw, headPitch);
                }
            }
        } else if (this.animationHolder.isPresent()) {
            JsonModelLoader.AnimationHolder animationHolder = this.animationHolder.get();
            for (ResourceLocation animation : animationHolder.walkAnimation()) {
                if (JsonAnimationLoader.isBuiltIn(animation)) {
                    BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animation);
                    if (builtInAnimationType.canUse(dinosaur)) {
                        builtInAnimationType.setupAnim(dinosaur, this, limbSwing, limbSwingAmount, netHeadYaw);
                    }
                }
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

    private void animateWalk(JsonModelLoader.AnimationHolder animationHolder, Dinosaur dinosaur, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        for (ResourceLocation animation : animationHolder.walkAnimation()) {
            if (JsonAnimationLoader.isBuiltIn(animation)) {
                BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animation);
                if (builtInAnimationType.canUse(dinosaur)) {
                    builtInAnimationType.setupAnim(dinosaur, this, limbSwing, limbSwingAmount, netHeadYaw);
                }
            } else {
                this.animateWalk(JsonAnimationLoader.getAnimation(animation), limbSwing, limbSwingAmount, 2.0F, 2.5F);
            }
        }
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        if (this.colored) {
            this.root().render(poseStack, vertexConsumer, packedLight, packedOverlay, FastColor.ARGB32.multiply(color, this.color));
        } else {
            super.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        }
    }
}
