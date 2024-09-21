package willatendo.fossilslegacy.client.model.json;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.api.client.BuiltInAnimationType;
import willatendo.fossilslegacy.client.animation.AnimationUtils;
import willatendo.fossilslegacy.client.model.dinosaur.base.DinosaurModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.util.interfaces.FloatDownEntity;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.Optional;

public class JsonModel extends DinosaurModel<Dinosaur> {
    private final Optional<JsonModelLoader.AnimationHolder> animationHolder;
    private final List<ModelPart> headPieces;
    public Optional<ModelPart> leftWing1 = Optional.empty();
    public Optional<ModelPart> leftWing2 = Optional.empty();
    public Optional<ModelPart> rightWing1 = Optional.empty();
    public Optional<ModelPart> rightWing2 = Optional.empty();
    public Optional<ModelPart> body = Optional.empty();
    public Optional<ModelPart> neck1 = Optional.empty();
    public Optional<ModelPart> neck2 = Optional.empty();
    public Optional<ModelPart> tail = Optional.empty();
    public Optional<ModelPart> crown = Optional.empty();
    public Optional<ModelPart> head = Optional.empty();
    public Optional<ModelPart> upperMouth = Optional.empty();
    public Optional<ModelPart> lowerMouth = Optional.empty();
    public Optional<ModelPart> leftLeg = Optional.empty();
    public Optional<ModelPart> rightLeg = Optional.empty();
    public Optional<ModelPart> frontRightThigh = Optional.empty();
    public Optional<ModelPart> frontLeftCalf = Optional.empty();
    public Optional<ModelPart> frontLeftThigh = Optional.empty();
    public Optional<ModelPart> frontRightCalf = Optional.empty();
    public Optional<ModelPart> backRightThigh = Optional.empty();
    public Optional<ModelPart> backLeftCalf = Optional.empty();
    public Optional<ModelPart> backLeftThigh = Optional.empty();
    public Optional<ModelPart> backRightCalf = Optional.empty();
    public Optional<ModelPart> rightThigh = Optional.empty();
    public Optional<ModelPart> leftThigh = Optional.empty();
    public Optional<ModelPart> rightFoot = Optional.empty();
    public Optional<ModelPart> leftFoot = Optional.empty();
    public Optional<ModelPart> rightFrontFlipper = Optional.empty();
    public Optional<ModelPart> leftFrontFlipper = Optional.empty();
    public Optional<ModelPart> rightBackFlipper = Optional.empty();
    public Optional<ModelPart> leftBackFlipper = Optional.empty();
    public Optional<ModelPart> tail1 = Optional.empty();
    public Optional<ModelPart> tail2 = Optional.empty();
    public Optional<ModelPart> tail2Spike = Optional.empty();
    public Optional<ModelPart> tail3 = Optional.empty();
    public Optional<ModelPart> tail3Spike = Optional.empty();
    public Optional<ModelPart> leftFrontLeg = Optional.empty();
    public Optional<ModelPart> leftFrontFoot = Optional.empty();
    public Optional<ModelPart> rightFrontLeg = Optional.empty();
    public Optional<ModelPart> rightFrontFoot = Optional.empty();
    public Optional<ModelPart> leftBackLeg = Optional.empty();
    public Optional<ModelPart> leftBackFoot = Optional.empty();
    public Optional<ModelPart> rightBackLeg = Optional.empty();
    public Optional<ModelPart> rightBackFoot = Optional.empty();
    public Optional<ModelPart> backPlates1 = Optional.empty();
    public Optional<ModelPart> backPlates2 = Optional.empty();
    public Optional<ModelPart> backPlates3 = Optional.empty();
    public Optional<ModelPart> thagomizer = Optional.empty();
    public Optional<ModelPart> lowerBody = Optional.empty();
    public Optional<ModelPart> back = Optional.empty();
    public Optional<ModelPart> rightFrontThigh = Optional.empty();
    public Optional<ModelPart> leftFrontThigh = Optional.empty();
    public Optional<ModelPart> rightBackThigh = Optional.empty();
    public Optional<ModelPart> leftBackThigh = Optional.empty();
    public Optional<ModelPart> snout = Optional.empty();
    public Optional<ModelPart> jaw = Optional.empty();
    public Optional<ModelPart> leftHook1 = Optional.empty();
    public Optional<ModelPart> leftHook2 = Optional.empty();
    public Optional<ModelPart> leftBicep = Optional.empty();
    public Optional<ModelPart> leftHand = Optional.empty();
    public Optional<ModelPart> rightHook1 = Optional.empty();
    public Optional<ModelPart> rightHook2 = Optional.empty();
    public Optional<ModelPart> rightBicep = Optional.empty();
    public Optional<ModelPart> rightHand = Optional.empty();
    public Optional<ModelPart> leftArm = Optional.empty();
    public Optional<ModelPart> rightArm = Optional.empty();
    public Optional<ModelPart> noseTop = Optional.empty();
    public Optional<ModelPart> noseBottom = Optional.empty();
    public Optional<ModelPart> leftEar = Optional.empty();
    public Optional<ModelPart> rightEar = Optional.empty();
    public Optional<ModelPart> leftToothTop = Optional.empty();
    public Optional<ModelPart> leftToothBottom = Optional.empty();
    public Optional<ModelPart> rightToothTop = Optional.empty();
    public Optional<ModelPart> rightToothBottom = Optional.empty();
    public Optional<ModelPart> nose = Optional.empty();
    public Optional<ModelPart> neck = Optional.empty();
    public Optional<ModelPart> tailBase = Optional.empty();
    public Optional<ModelPart> tailMid = Optional.empty();
    public Optional<ModelPart> tailEnd = Optional.empty();

    public JsonModel(ResourceLocation id, ModelPart root) {
        super(root);
        this.animationHolder = JsonModelLoader.getAnimations(id);
        this.headPieces = JsonModelLoader.getHead(id, root);

        this.leftWing1 = this.set(root, "left_wing_1");
        this.leftWing2 = this.set(root, "left_wing_2");
        this.rightWing1 = this.set(root, "right_wing_1");
        this.rightWing2 = this.set(root, "right_wing_2");
        this.body = this.set(root, "body");
        this.neck1 = this.set(root, "neck_1");
        this.neck2 = this.set(root, "neck_2");
        this.tail = this.set(root, "tail");
        this.crown = this.set(root, "crown");
        this.head = this.set(root, "head");
        this.upperMouth = this.set(root, "upper_mouth");
        this.lowerMouth = this.set(root, "lower_mouth");
        this.leftLeg = this.set(root, "left_leg");
        this.rightLeg = this.set(root, "right_leg");
        this.frontRightThigh = this.set(root, "front_right_thigh");
        this.frontRightCalf = this.set(root, "front_right_calf");
        this.frontLeftThigh = this.set(root, "front_left_thigh");
        this.frontLeftCalf = this.set(root, "front_left_calf");
        this.backRightCalf = this.set(root, "back_right_calf");
        this.backLeftThigh = this.set(root, "back_left_thigh");
        this.backLeftCalf = this.set(root, "back_left_calf");
        this.rightThigh = this.set(root, "right_thigh");
        this.leftThigh = this.set(root, "left_thigh");
        this.rightFoot = this.set(root, "right_foot");
        this.leftFoot = this.set(root, "left_foot");
        this.rightFrontFlipper = this.set(root, "right_front_flipper");
        this.leftFrontFlipper = this.set(root, "left_front_flipper");
        this.rightBackFlipper = this.set(root, "right_back_flipper");
        this.leftBackFlipper = this.set(root, "left_back_flipper");
        this.tail1 = this.set(root, "tail_1");
        this.tail2 = this.set(root, "tail_2");
        this.tail2Spike = this.set(root, "tail_2_spike");
        this.tail3 = this.set(root, "tail_3");
        this.tail3Spike = this.set(root, "tail_3_spike");
        this.leftFrontLeg = this.set(root, "left_front_leg");
        this.leftFrontFoot = this.set(root, "left_front_foot");
        this.rightFrontLeg = this.set(root, "right_front_leg");
        this.rightFrontFoot = this.set(root, "right_front_foot");
        this.leftBackLeg = this.set(root, "left_back_leg");
        this.leftBackFoot = this.set(root, "left_back_foot");
        this.rightBackLeg = this.set(root, "right_back_leg");
        this.rightBackFoot = this.set(root, "right_back_foot");
        this.backPlates1 = this.set(root, "back_plates_1");
        this.backPlates2 = this.set(root, "back_plates_2");
        this.backPlates3 = this.set(root, "back_plates_3");
        this.thagomizer = this.set(root, "thagomizer");
        this.lowerBody = this.set(root, "lower_body");
        this.back = this.set(root, "back");
        this.rightFrontThigh = this.set(root, "right_front_thigh");
        this.leftFrontThigh = this.set(root, "left_front_thigh");
        this.rightBackThigh = this.set(root, "right_back_thigh");
        this.leftBackThigh = this.set(root, "left_back_thigh");
        this.snout = this.set(root, "snout");
        this.jaw = this.set(root, "jaw");
        this.leftHook1 = this.set(root, "left_hook_1");
        this.leftHook2 = this.set(root, "left_hook_2");
        this.leftBicep = this.set(root, "left_bicep");
        this.leftHand = this.set(root, "left_hand");
        this.rightHook1 = this.set(root, "right_hook_1");
        this.rightHook2 = this.set(root, "right_hook_2");
        this.rightBicep = this.set(root, "right_bicep");
        this.rightHand = this.set(root, "right_hand");
        this.leftLeg = this.set(root, "left_leg");
        this.rightLeg = this.set(root, "right_leg");
        this.noseTop = this.set(root, "nose_top");
        this.noseBottom = this.set(root, "nose_bottom");
        this.leftEar = this.set(root, "left_ear");
        this.rightEar = this.set(root, "right_ear");
        this.leftToothTop = this.set(root, "left_tooth_top");
        this.leftToothBottom = this.set(root, "left_tooth_bottom");
        this.rightToothTop = this.set(root, "right_tooth_top");
        this.rightToothBottom = this.set(root, "right_tooth_bottom");
        this.nose = this.set(root, "nose");
        this.neck = this.set(root, "neck");
        this.tailBase = this.set(root, "tail_base");
        this.tailMid = this.set(root, "tail_mid");
        this.tailEnd = this.set(root, "tail_end");
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
                if (AnimationUtils.isBuiltIn(animationHolder.walkAnimation().get())) {
                    BuiltInAnimationType builtInAnimationType = AnimationUtils.get(animationHolder.walkAnimation().get());
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
                if (AnimationUtils.isBuiltIn(animationHolder.headAnimation().get())) {
                    BuiltInAnimationType builtInAnimationType = AnimationUtils.get(animationHolder.headAnimation().get());
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
                if (AnimationUtils.isBuiltIn(animationHolder.flyAnimation().get())) {
                    BuiltInAnimationType builtInAnimationType = AnimationUtils.get(animationHolder.flyAnimation().get());
                    if (builtInAnimationType.canUse(dinosaur)) {
                        builtInAnimationType.setupAnim(dinosaur, this, limbSwing, limbSwingAmount, netHeadYaw);
                    }
                } else {

                }
            }

            if (animationHolder.swimAnimation().isPresent() && dinosaur.isInWaterOrBubble()) {
                if (AnimationUtils.isBuiltIn(animationHolder.swimAnimation().get())) {
                    BuiltInAnimationType builtInAnimationType = AnimationUtils.get(animationHolder.swimAnimation().get());
                    if (builtInAnimationType.canUse(dinosaur)) {
                        builtInAnimationType.setupAnim(dinosaur, this, limbSwing, limbSwingAmount, netHeadYaw);
                    }
                } else {
                    animationHolder.swimAnimation().ifPresent(resourceLocation -> this.animateWalk(JsonAnimationLoader.getAnimation(resourceLocation), limbSwing, limbSwingAmount, 2.0F, 2.5F));
                }
            } else {
                if (animationHolder.walkAnimation().isPresent()) {
                    if (AnimationUtils.isBuiltIn(animationHolder.walkAnimation().get())) {
                        BuiltInAnimationType builtInAnimationType = AnimationUtils.get(animationHolder.walkAnimation().get());
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
