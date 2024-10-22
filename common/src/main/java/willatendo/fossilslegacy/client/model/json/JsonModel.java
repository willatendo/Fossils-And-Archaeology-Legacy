package willatendo.fossilslegacy.client.model.json;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import willatendo.fossilslegacy.api.client.BuiltInAnimationType;
import willatendo.fossilslegacy.client.animation.json.JsonAnimationLoader;
import willatendo.fossilslegacy.client.model.dinosaur.base.DinosaurModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.util.interfaces.FloatDownEntity;

import java.util.List;
import java.util.Optional;

public class JsonModel<T extends Entity> extends DinosaurModel<T> {
    private final Optional<JsonModelLoader.AnimationHolder> animationHolder;
    private final List<ModelPart> headPieces;
    private final LoadedParts loadedParts;
    private final boolean colored;
    private int color = -1;

    public JsonModel(ResourceLocation id, boolean colored, ModelPart root) {
        super(root);
        this.animationHolder = JsonModelLoader.getAnimations(id);
        this.headPieces = JsonModelLoader.getHeadPieces(id, root);
        this.loadedParts = new LoadedParts(JsonModelLoader.getLoadParts(id), root);
        this.colored = colored;
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
    public void prepareMobModel(T entity, float limbSwing, float limbSwingAmount, float partialTick) {
        if (entity instanceof Dinosaur dinosaur) {
            if (this.animationHolder.isPresent()) {
                JsonModelLoader.AnimationHolder animationHolder = this.animationHolder.get();
                if (animationHolder.walkAnimation().isPresent()) {
                    if (JsonAnimationLoader.isBuiltIn(animationHolder.walkAnimation().get())) {
                        BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animationHolder.walkAnimation().get());
                        if (builtInAnimationType.canUse(dinosaur)) {
                            builtInAnimationType.prepareMobModel(dinosaur, this, limbSwing, limbSwingAmount, partialTick);
                        }
                    }
                }
                if (animationHolder.tailAnimation().isPresent()) {
                    if (JsonAnimationLoader.isBuiltIn(animationHolder.sitAnimation().get())) {
                        BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animationHolder.tailAnimation().get());
                        if (builtInAnimationType.canUse(dinosaur)) {
                            builtInAnimationType.prepareMobModel(dinosaur, this, limbSwing, limbSwingAmount, partialTick);
                        }
                    }
                }
                if (animationHolder.sitAnimation().isPresent()) {
                    if (JsonAnimationLoader.isBuiltIn(animationHolder.sitAnimation().get())) {
                        BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animationHolder.sitAnimation().get());
                        if (builtInAnimationType.canUse(dinosaur)) {
                            builtInAnimationType.prepareMobModel(dinosaur, this, limbSwing, limbSwingAmount, partialTick);
                        }
                    }
                }
                if (animationHolder.shakeAnimation().isPresent()) {
                    if (JsonAnimationLoader.isBuiltIn(animationHolder.shakeAnimation().get())) {
                        BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animationHolder.shakeAnimation().get());
                        if (builtInAnimationType.canUse(dinosaur)) {
                            builtInAnimationType.prepareMobModel(dinosaur, this, limbSwing, limbSwingAmount, partialTick);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        if (entity instanceof Dinosaur dinosaur) {
            if (this.animationHolder.isPresent()) {
                JsonModelLoader.AnimationHolder animationHolder = this.animationHolder.get();
                if (animationHolder.headAnimation().isPresent()) {
                    if (JsonAnimationLoader.isBuiltIn(animationHolder.headAnimation().get())) {
                        BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animationHolder.headAnimation().get());
                        if (builtInAnimationType.canUse(dinosaur)) {
                            builtInAnimationType.setupAnim(dinosaur, this, limbSwing, limbSwingAmount, netHeadYaw);
                        }
                    }
                } else {
                    netHeadYaw = Mth.clamp(netHeadYaw, -30.0F, 30.0F);
                    headPitch = Mth.clamp(headPitch, -25.0F, 45.0F);
                    for (ModelPart modelPart : this.headPieces) {
                        modelPart.yRot = netHeadYaw * 0.017453292F;
                        modelPart.xRot = headPitch * 0.017453292F;
                    }
                }

                if (animationHolder.flyAnimation().isPresent()) {
                    if (JsonAnimationLoader.isBuiltIn(animationHolder.flyAnimation().get())) {
                        BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animationHolder.flyAnimation().get());
                        if (builtInAnimationType.canUse(dinosaur)) {
                            builtInAnimationType.setupAnim(dinosaur, this, limbSwing, limbSwingAmount, netHeadYaw);
                        }
                    }
                }

                if (animationHolder.swimAnimation().isPresent() && dinosaur.isInWaterOrBubble()) {
                    if (JsonAnimationLoader.isBuiltIn(animationHolder.swimAnimation().get())) {
                        BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animationHolder.swimAnimation().get());
                        if (builtInAnimationType.canUse(dinosaur)) {
                            builtInAnimationType.setupAnim(dinosaur, this, limbSwing, limbSwingAmount, netHeadYaw);
                        }
                    } else {
                        animationHolder.swimAnimation().ifPresent(resourceLocation -> this.animateWalk(JsonAnimationLoader.getAnimation(resourceLocation), limbSwing, limbSwingAmount, 2.0F, 2.5F));
                    }
                } else {
                    if (animationHolder.walkAnimation().isPresent()) {
                        if (JsonAnimationLoader.isBuiltIn(animationHolder.walkAnimation().get())) {
                            BuiltInAnimationType builtInAnimationType = JsonAnimationLoader.getBuiltIn(animationHolder.walkAnimation().get());
                            if (builtInAnimationType.canUse(dinosaur)) {
                                builtInAnimationType.setupAnim(dinosaur, this, limbSwing, limbSwingAmount, netHeadYaw);
                            }
                        } else {
                            animationHolder.walkAnimation().ifPresent(resourceLocation -> this.animateWalk(JsonAnimationLoader.getAnimation(resourceLocation), limbSwing, limbSwingAmount, 2.0F, 2.5F));
                        }
                    }
                }

                if (dinosaur instanceof FloatDownEntity floatDownEntity) {
                    animationHolder.floatAnimation().ifPresent(resourceLocation -> this.animate(floatDownEntity.getFallAnimationState(), JsonAnimationLoader.getAnimation(resourceLocation), ageInTicks));
                }
            } else {
                netHeadYaw = Mth.clamp(netHeadYaw, -30.0F, 30.0F);
                headPitch = Mth.clamp(headPitch, -25.0F, 45.0F);
                for (ModelPart modelPart : this.headPieces) {
                    modelPart.yRot = netHeadYaw * 0.017453292F;
                    modelPart.xRot = headPitch * 0.017453292F;
                }
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
