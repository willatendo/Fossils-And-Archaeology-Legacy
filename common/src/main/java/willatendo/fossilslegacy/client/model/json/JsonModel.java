package willatendo.fossilslegacy.client.model.json;

import com.google.common.collect.Maps;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.api.client.BuiltInAnimationType;
import willatendo.fossilslegacy.client.model.dinosaur.base.DinosaurModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.util.interfaces.FloatDownEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JsonModel extends DinosaurModel<Dinosaur> {
    private final Optional<JsonModelLoader.AnimationHolder> animationHolder;
    private final List<ModelPart> headPieces;
    private final Map<String, ModelPart> loadedParts = Maps.newHashMap();

    public JsonModel(ResourceLocation id, ModelPart root) {
        super(root);
        this.animationHolder = JsonModelLoader.getAnimations(id);
        this.headPieces = JsonModelLoader.getHead(id, root);
        if (JsonAnimationLoader.hasBuiltInParts(id)) {
            for (String part : JsonAnimationLoader.getBuiltInParts(id)) {
                this.loadedParts.put(part, root.getChild(part));
            }
        }
    }

    public ModelPart get(String name) {
        return this.loadedParts.get(name);
    }

    private Optional<ModelPart> set(ModelPart root, String name) {
        if (root.children.containsKey(name)) {
            return Optional.of(root.getChild(name));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void prepareMobModel(Dinosaur dinosaur, float limbSwing, float limbSwingAmount, float partialTick) {
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
        }
    }

    @Override
    public void setupAnim(Dinosaur dinosaur, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

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
                } else {

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
