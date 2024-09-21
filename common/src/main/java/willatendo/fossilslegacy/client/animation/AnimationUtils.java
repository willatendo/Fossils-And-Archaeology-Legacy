package willatendo.fossilslegacy.client.animation;

import com.google.common.collect.Maps;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.api.client.BuiltInAnimationType;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.util.interfaces.FlyingDinosaur;
import willatendo.fossilslegacy.server.entity.util.interfaces.ShakingEntity;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.Map;
import java.util.Optional;

public class AnimationUtils {
    private static final Map<ResourceLocation, BuiltInAnimationType> BUILT_IN_ANIMATIONS = Maps.newHashMap();

    public static BuiltInAnimationType get(ResourceLocation id) {
        return BUILT_IN_ANIMATIONS.get(id);
    }

    protected static void legacyBrachiosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setXRot(jsonModel.frontRightThigh, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.frontRightCalf, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.frontLeftThigh, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.frontLeftCalf, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.backLeftThigh, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.backLeftCalf, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.backRightThigh, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.backRightCalf, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
    }

    protected static void carnotaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setXRot(jsonModel.rightThigh, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.leftThigh, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
    }

    protected static void cryolophosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setXRot(jsonModel.leftThigh, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.rightThigh, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
    }

    protected static void dilophosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setXRot(jsonModel.leftThigh, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.leftLeg, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.372F);
        AnimationUtils.setXRot(jsonModel.leftFoot, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.rightThigh, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.rightLeg, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.372F);
        AnimationUtils.setXRot(jsonModel.rightFoot, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
    }

    protected static void mosasaurusSwimAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setYRot(jsonModel.body, (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * -0.0872664625997165 * limbSwingAmount + 0));
        AnimationUtils.setYRot(jsonModel.tail1, (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * 0.174532925199433 * limbSwingAmount + 0));
        AnimationUtils.setYRot(jsonModel.tail2, (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * -0.174532925199433 * limbSwingAmount + 0));
        AnimationUtils.setYRot(jsonModel.tail3, (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * 0.174532925199433 * limbSwingAmount + 0));
        AnimationUtils.setYRot(jsonModel.rightFrontFlipper, (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * -0.174532925199433 * limbSwingAmount + -1.0471975511966));
        AnimationUtils.setYRot(jsonModel.leftFrontFlipper, (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * 0.174532925199433 * limbSwingAmount + 1.0471975511966));
        AnimationUtils.setYRot(jsonModel.rightBackFlipper, (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * -0.174532925199433 * limbSwingAmount + -0.872664625997165));
        AnimationUtils.setYRot(jsonModel.leftBackFlipper, (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * 0.174532925199433 * limbSwingAmount + 0.872664625997165));
        AnimationUtils.setYRot(jsonModel.tail3Spike, (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * 0.174532925199433 * limbSwingAmount + 0));
        AnimationUtils.setYRot(jsonModel.tail2Spike, (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * -0.174532925199433 * limbSwingAmount + 0));
    }

    protected static void pteranodonWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setXRot(jsonModel.rightLeg, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.271F);
        AnimationUtils.setXRot(jsonModel.leftLeg, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.271F);
    }

    protected static void pteranodonHeadAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setYRot(jsonModel.crown, -netHeadYaw / 57.29578F);
        AnimationUtils.setYRot(jsonModel.upperMouth, -netHeadYaw / 57.29578F);
        AnimationUtils.setYRot(jsonModel.lowerMouth, -netHeadYaw / 57.29578F);
        AnimationUtils.setYRot(jsonModel.head, -netHeadYaw / 57.29578F);
    }

    protected static void pteranodonFlyingAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        if (dinosaur instanceof FlyingDinosaur flyingDinosaur) {
            float airPitch = (float) -(flyingDinosaur.getAirPitch() * (Math.PI / 180.0F));
            float airAngle = (float) -(flyingDinosaur.getAirAngle() * (Math.PI / 180.0F));

            AnimationUtils.setXRot(jsonModel.leftWing1, -1.570796F + airPitch);
            AnimationUtils.setXRot(jsonModel.leftWing1, -1.570796F + airPitch);
            AnimationUtils.setXRot(jsonModel.leftWing2, 1.570796F + airPitch);
            AnimationUtils.setXRot(jsonModel.rightWing1, 1.570796F - airPitch);
            AnimationUtils.setXRot(jsonModel.rightWing2, -1.570796F - airPitch);
            AnimationUtils.setXRot(jsonModel.body, 1.570796F + airPitch);
            AnimationUtils.setXRot(jsonModel.neck1, 1.570796F + airPitch);
            AnimationUtils.setXRot(jsonModel.neck2, 1.570796F + airPitch);
            AnimationUtils.setXRot(jsonModel.tail, 1.570796F + airPitch);
            AnimationUtils.setXRot(jsonModel.crown, 0.4859298F + airPitch);
            AnimationUtils.setXRot(jsonModel.head, 1.570796F + airPitch);
            AnimationUtils.setXRot(jsonModel.upperMouth, airPitch);
            AnimationUtils.setXRot(jsonModel.lowerMouth, 0.1356083F + airPitch);
            AnimationUtils.setXRot(jsonModel.leftLeg, 1.570796F + airPitch);
            AnimationUtils.setXRot(jsonModel.rightLeg, 1.570796F + airPitch);

            AnimationUtils.setZRot(jsonModel.body, airAngle);
            AnimationUtils.setZRot(jsonModel.neck1, airAngle);
            AnimationUtils.setZRot(jsonModel.neck2, airAngle);
            AnimationUtils.setZRot(jsonModel.leftWing1, 2.792527F + airAngle);
            AnimationUtils.setZRot(jsonModel.leftWing2, airAngle);
            AnimationUtils.setZRot(jsonModel.rightWing1, -2.792527F + airAngle);
            AnimationUtils.setZRot(jsonModel.rightWing2, airAngle);
            AnimationUtils.setZRot(jsonModel.tail, airAngle);
            AnimationUtils.setZRot(jsonModel.crown, airAngle);
            AnimationUtils.setZRot(jsonModel.head, airAngle);
            AnimationUtils.setZRot(jsonModel.upperMouth, airAngle);
            AnimationUtils.setZRot(jsonModel.lowerMouth, airAngle);
            AnimationUtils.setZRot(jsonModel.leftLeg, airAngle);
            AnimationUtils.setZRot(jsonModel.rightLeg, airAngle);
        }
    }

    protected static void stegosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setYRot(jsonModel.tail1, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.349065850398866F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.tail2, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.436332312998582F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.tail3, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.488692190558412F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.leftFrontLeg, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.rightFrontLeg, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.leftFrontFoot, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.872664625997162F);
        AnimationUtils.setXRot(jsonModel.rightFrontFoot, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.872664625997162F);
        AnimationUtils.setXRot(jsonModel.leftBackLeg, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.leftBackLeg, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.rightBackLeg, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.rightBackLeg, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.leftBackFoot, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 1.22173047639603F);
        AnimationUtils.setYRot(jsonModel.leftBackFoot, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.rightBackFoot, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 1.22173047639603F);
        AnimationUtils.setYRot(jsonModel.rightBackFoot, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.backPlates1, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.488692190558412F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.backPlates2, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.349065850398866F * limbSwingAmount);
        AnimationUtils.setZRot(jsonModel.backPlates2, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setZRot(jsonModel.thagomizer, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setZRot(jsonModel.backPlates3, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
    }

    protected static void therizinosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setXRot(jsonModel.leftThigh, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.rightThigh, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
    }

    protected static void legacyTriceratopsWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setYRot(jsonModel.lowerBody, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.back, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.261799387799149F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.tail, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.349065850398866F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.rightFrontThigh, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.rightFrontThigh, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.rightFrontLeg, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        AnimationUtils.setYRot(jsonModel.rightFrontLeg, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.leftFrontThigh, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.leftFrontThigh, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.leftFrontLeg, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        AnimationUtils.setYRot(jsonModel.leftFrontLeg, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.rightBackThigh, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.rightBackThigh, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.rightBackLeg, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        AnimationUtils.setYRot(jsonModel.rightBackLeg, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.leftBackThigh, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.leftBackThigh, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.leftBackLeg, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        AnimationUtils.setYRot(jsonModel.leftBackLeg, Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
    }

    protected static void tyrannosaurusHeadAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setYRot(jsonModel.head, -netHeadYaw / 57.29578F);
        AnimationUtils.setYRot(jsonModel.snout, -netHeadYaw / 57.29578F);
        AnimationUtils.setYRot(jsonModel.jaw, -netHeadYaw / 57.29578F);
    }

    protected static void tyrannosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setXRot(jsonModel.rightThigh, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.rightLeg, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.6108652F);
        AnimationUtils.setXRot(jsonModel.rightFoot, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.leftThigh, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.leftLeg, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.6108652F);
        AnimationUtils.setXRot(jsonModel.leftFoot, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
    }

    protected static void tyrannosaurusWalkModelPrep(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float partialTick) {
        if (Math.abs(AnimationUtils.getXRot(jsonModel.rightThigh)) >= 0.174532F) {
            AnimationUtils.tyrannosaurusRunPose(jsonModel);
        } else {
            AnimationUtils.tyrannosaurusStandPose(jsonModel);
        }
    }

    protected static void legacyVelociraptorWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setXRot(jsonModel.rightThigh, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.rightLeg, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 0.9948377F);
        AnimationUtils.setXRot(jsonModel.rightFoot, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.rightHook1, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.8726646F);
        AnimationUtils.setXRot(jsonModel.rightHook2, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 2.617994F);
        AnimationUtils.setXRot(jsonModel.leftThigh, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.leftLeg, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount + 0.9948377F);
        AnimationUtils.setXRot(jsonModel.leftFoot, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.leftHook1, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.8726646F);
        AnimationUtils.setXRot(jsonModel.leftHook2, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 2.617994F);
        AnimationUtils.setXRot(jsonModel.rightBicep, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.rightHand, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount + 0.994461F);
        AnimationUtils.setXRot(jsonModel.leftBicep, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.leftHand, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 0.994461F);
    }

    protected static void mammothWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setXRot(jsonModel.rightArm, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.leftArm, Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.rightLeg, Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.leftLeg, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.noseTop, -0.1897142F);
        AnimationUtils.setXRot(jsonModel.noseBottom, -0.5986789F);
    }

    protected static void smilodonShakeAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float partialTick) {
        if (dinosaur instanceof ShakingEntity shakingEntity) {
            float headAngle = shakingEntity.getHeadRollAngle(partialTick) + shakingEntity.getBodyRollAngle(partialTick, 0.0F);
            AnimationUtils.setZRot(jsonModel.head, headAngle);
            AnimationUtils.setZRot(jsonModel.rightEar, headAngle);
            AnimationUtils.setZRot(jsonModel.leftEar, headAngle);
            AnimationUtils.setZRot(jsonModel.leftToothBottom, headAngle);
            AnimationUtils.setZRot(jsonModel.leftToothTop, headAngle);
            AnimationUtils.setZRot(jsonModel.rightToothBottom, headAngle);
            AnimationUtils.setZRot(jsonModel.rightToothTop, headAngle);
            AnimationUtils.setZRot(jsonModel.snout, headAngle);
            AnimationUtils.setZRot(jsonModel.jaw, headAngle);
            AnimationUtils.setZRot(jsonModel.nose, headAngle);
            AnimationUtils.setZRot(jsonModel.body, shakingEntity.getBodyRollAngle(partialTick, -0.08F));
            AnimationUtils.setZRot(jsonModel.back, shakingEntity.getBodyRollAngle(partialTick, -0.16F));
            AnimationUtils.setZRot(jsonModel.tail, shakingEntity.getBodyRollAngle(partialTick, -0.2F));
        }
    }

    protected static void smilodonSitAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setPos(jsonModel.body, 0.0F, 17.0F, 0.0F);
        AnimationUtils.setXRot(jsonModel.body, -0.314F);
        AnimationUtils.setYRot(jsonModel.body, 0.0F);
        AnimationUtils.setPos(jsonModel.back, 0.0F, 20.0F, -1.0F);
        AnimationUtils.setXRot(jsonModel.back, -0.7853982F);
        AnimationUtils.setPos(jsonModel.tail, 0.0F, 23.0F, 4.5F);
        AnimationUtils.setPos(jsonModel.leftFrontLeg, -1.5F, 25.0F, 1.0F);
        AnimationUtils.setXRot(jsonModel.leftFrontLeg, 4.712389F);
        AnimationUtils.setPos(jsonModel.leftBackLeg, 1.5F, 25.0F, 1.0F);
        AnimationUtils.setXRot(jsonModel.leftBackLeg, 4.712389F);
        AnimationUtils.setXRot(jsonModel.rightFrontLeg, 5.811947F);
        AnimationUtils.setPos(jsonModel.rightFrontLeg, -1.5F, 20.0F, -2.0F);
        AnimationUtils.setXRot(jsonModel.rightBackLeg, 5.811947F);
        AnimationUtils.setPos(jsonModel.rightBackLeg, 1.5F, 20.0F, -2.0F);
    }

    protected static void smilodonTailAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setYRot(jsonModel.tail, Mth.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount);
    }

    protected static void smilodonWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setPos(jsonModel.body, 0.0F, 15.0F, 0.0F);
        AnimationUtils.setPos(jsonModel.back, 0.0F, 16.0F, 1.0F);
        AnimationUtils.setXRot(jsonModel.back, 0.0F);
        AnimationUtils.setXRot(jsonModel.body, 0.0F);

        AnimationUtils.setPos(jsonModel.tail, 0.0F, 14.0F, 6.5F);
        AnimationUtils.setPos(jsonModel.leftFrontLeg, -1.5F, 19.0F, 6.0F);
        AnimationUtils.setPos(jsonModel.leftBackLeg, 1.5F, 19.0F, 6.0F);
        AnimationUtils.setPos(jsonModel.rightFrontLeg, -1.5F, 19.0F, -2.0F);
        AnimationUtils.setPos(jsonModel.rightBackLeg, 1.5F, 19.0F, -2.0F);
        AnimationUtils.setXRot(jsonModel.leftFrontLeg, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.leftBackLeg, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.rightFrontLeg, Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.rightBackLeg, Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
    }

    private static void tyrannosaurusRunPose(JsonModel jsonModel) {
        AnimationUtils.tyrannosaurusRunPose(jsonModel, 20.0F);
    }

    private static void tyrannosaurusRunPose(JsonModel jsonModel, float moves) {
        if (AnimationUtils.getY(jsonModel.body) > 7) {
            AnimationUtils.subtractY(jsonModel.body, 2.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.body, 7);
        }

        if (AnimationUtils.getZ(jsonModel.body) > -4) {
            AnimationUtils.subtractZ(jsonModel.body, 3.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.body, -4);
        }

        if (AnimationUtils.getXRot(jsonModel.body) < 0) {
            AnimationUtils.addXRot(jsonModel.body, 0.9948377F / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.body, 0);
        }

        if (AnimationUtils.getZ(jsonModel.neck) > 0) {
            AnimationUtils.subtractZ(jsonModel.neck, 2.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.neck, 0);
        }

        if (AnimationUtils.getXRot(jsonModel.neck) < 0) {
            AnimationUtils.addXRot(jsonModel.neck, 0.4068249F / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.neck, 0);
        }

        if (AnimationUtils.getY(jsonModel.rightArm) < 14) {
            AnimationUtils.addY(jsonModel.rightArm, 4.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.rightArm, 14);
        }

        if (AnimationUtils.getY(jsonModel.leftArm) < 14) {
            AnimationUtils.addY(jsonModel.leftArm, 4.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.leftArm, 14);
        }

        if (AnimationUtils.getXRot(jsonModel.tailBase) < -0.2260139F) {
            AnimationUtils.addXRot(jsonModel.tailBase, (0.7684471F - 0.2260139F) / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.tailBase, -0.2260139F);
        }

        if (AnimationUtils.getY(jsonModel.tailMid) > 11) {
            AnimationUtils.subtractY(jsonModel.tailMid, 4.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.tailMid, 11);
        }

        if (AnimationUtils.getZ(jsonModel.tailMid) < 14) {
            AnimationUtils.addZ(jsonModel.tailMid, 2.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.tailMid, 14);
        }

        if (AnimationUtils.getXRot(jsonModel.tailMid) < -0.1356083F) {
            AnimationUtils.addXRot(jsonModel.tailMid, (0.5424333F - 0.1356083F) / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.tailMid, -0.1356083F);
        }

        if (AnimationUtils.getY(jsonModel.tailEnd) > 13) {
            AnimationUtils.subtractY(jsonModel.tailEnd, 7.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.tailEnd, 13);
        }

        if (AnimationUtils.getZ(jsonModel.tailEnd) < 22) {
            AnimationUtils.addZRot(jsonModel.tailEnd, 3.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.tailEnd, 22);
        }

        if (AnimationUtils.getXRot(jsonModel.tailEnd) < 0) {
            AnimationUtils.addXRot(jsonModel.tailEnd, 0.3616222F / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.tailEnd, 0);
        }

        if (AnimationUtils.getY(jsonModel.head) < 7) {
            AnimationUtils.addY(jsonModel.head, 7.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.head, 7);
        }

        if (AnimationUtils.getZ(jsonModel.head) > -14) {
            AnimationUtils.subtractZ(jsonModel.head, 6.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.head, -14);
        }

        if (AnimationUtils.getY(jsonModel.snout) < 7) {
            AnimationUtils.addY(jsonModel.snout, 7.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.snout, 7);
        }

        if (AnimationUtils.getZ(jsonModel.snout) > -14) {
            AnimationUtils.subtractZ(jsonModel.snout, 6.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.snout, -14);
        }

        if (AnimationUtils.getY(jsonModel.jaw) < 7) {
            AnimationUtils.addY(jsonModel.jaw, 6.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.jaw, 7);
        }

        if (AnimationUtils.getZ(jsonModel.jaw) > -14) {
            AnimationUtils.subtractZ(jsonModel.jaw, 6.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.jaw, -14);
        }
    }

    private static void tyrannosaurusStandPose(JsonModel jsonModel) {
        AnimationUtils.tyrannosaurusStandPose(jsonModel, 20.0F);
    }

    private static void tyrannosaurusStandPose(JsonModel jsonModel, float moves) {
        if (AnimationUtils.getY(jsonModel.body) < 9) {
            AnimationUtils.addY(jsonModel.body, 2.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.body, 9);
        }

        if (AnimationUtils.getZ(jsonModel.body) < -1) {
            AnimationUtils.addZ(jsonModel.body, 3.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.body, -1);
        }

        if (AnimationUtils.getXRot(jsonModel.body) > -0.9948377F) {
            AnimationUtils.subtractXRot(jsonModel.body, 0.9948377F / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.body, -0.9948377F);
        }

        if (AnimationUtils.getZ(jsonModel.neck) < 2) {
            AnimationUtils.addZ(jsonModel.neck, 2.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.neck, 2);
        }

        if (AnimationUtils.getXRot(jsonModel.neck) > -0.4068249F) {
            AnimationUtils.subtractXRot(jsonModel.neck, 0.4068249F / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.neck, -0.4068249F);
        }

        if (AnimationUtils.getY(jsonModel.rightArm) > 10) {
            AnimationUtils.subtractY(jsonModel.rightArm, 4.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.rightArm, 10);
        }

        if (AnimationUtils.getY(jsonModel.leftArm) > 10) {
            AnimationUtils.subtractY(jsonModel.leftArm, 4.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.leftArm, 10);
        }

        if (AnimationUtils.getXRot(jsonModel.tailBase) > -0.7684471F) {
            AnimationUtils.subtractXRot(jsonModel.tailBase, (0.7684471F - 0.2260139F) / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.tailBase, -0.7684471F);
        }

        if (AnimationUtils.getY(jsonModel.tailMid) < 15) {
            AnimationUtils.addY(jsonModel.tailMid, 4.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.tailMid, 15);
        }

        if (AnimationUtils.getZ(jsonModel.tailMid) > 12) {
            AnimationUtils.subtractZ(jsonModel.tailMid, 2.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.tailMid, 12);
        }

        if (AnimationUtils.getXRot(jsonModel.tailMid) > -0.5424333F) {
            AnimationUtils.subtractXRot(jsonModel.tailMid, (0.5424333F - 0.1356083F) / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.tailMid, -0.5424333F);
        }

        if (AnimationUtils.getY(jsonModel.tailEnd) < 20) {
            AnimationUtils.addY(jsonModel.tailEnd, 7.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.tailEnd, 20);
        }

        if (AnimationUtils.getZ(jsonModel.tailEnd) > 19) {
            AnimationUtils.addZ(jsonModel.tailEnd, 3.0F / moves);
        } else {
            AnimationUtils.setX(jsonModel.tailEnd, 19);
        }

        if (AnimationUtils.getXRot(jsonModel.tailEnd) < -0.3616222F) {
            AnimationUtils.addXRot(jsonModel.tailEnd, (0.3616222F - 2.8368E-15F) / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.tailEnd, -0.3616222F);
        }

        if (AnimationUtils.getY(jsonModel.head) > 0) {
            AnimationUtils.subtractY(jsonModel.head, 7.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.head, 0);
        }

        if (AnimationUtils.getZ(jsonModel.head) < -8) {
            AnimationUtils.addZ(jsonModel.head, 6.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.head, -8);
        }

        if (AnimationUtils.getY(jsonModel.snout) > 1) {
            AnimationUtils.subtractY(jsonModel.snout, 7.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.snout, 1);
        }

        if (AnimationUtils.getZ(jsonModel.snout) < -8) {
            AnimationUtils.addZ(jsonModel.snout, 6.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.snout, -8);
        }

        if (AnimationUtils.getY(jsonModel.jaw) > 1) {
            AnimationUtils.subtractY(jsonModel.jaw, 6.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.jaw, 1);
        }

        if (AnimationUtils.getZ(jsonModel.jaw) < -8) {
            AnimationUtils.addZ(jsonModel.jaw, 6.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.jaw, -8);
        }
    }

    public static float getX(Optional<ModelPart> part) {
        if (part.isPresent()) {
            return part.get().x;
        } else {
            return 0.0F;
        }
    }

    public static float getY(Optional<ModelPart> part) {
        if (part.isPresent()) {
            return part.get().y;
        } else {
            return 0.0F;
        }
    }

    public static float getZ(Optional<ModelPart> part) {
        if (part.isPresent()) {
            return part.get().z;
        } else {
            return 0.0F;
        }
    }

    private static void setX(Optional<ModelPart> part, float angle) {
        if (part.isPresent()) {
            part.get().x = angle;
        }
    }

    private static void setY(Optional<ModelPart> part, float angle) {
        if (part.isPresent()) {
            part.get().y = angle;
        }
    }

    private static void setZ(Optional<ModelPart> part, float angle) {
        if (part.isPresent()) {
            part.get().z = angle;
        }
    }

    private static void addX(Optional<ModelPart> part, float angle) {
        if (part.isPresent()) {
            part.get().x += angle;
        }
    }

    private static void addY(Optional<ModelPart> part, float angle) {
        if (part.isPresent()) {
            part.get().y += angle;
        }
    }

    private static void addZ(Optional<ModelPart> part, float angle) {
        if (part.isPresent()) {
            part.get().z += angle;
        }
    }

    private static void subtractX(Optional<ModelPart> part, float angle) {
        if (part.isPresent()) {
            part.get().x -= angle;
        }
    }

    private static void subtractY(Optional<ModelPart> part, float angle) {
        if (part.isPresent()) {
            part.get().y -= angle;
        }
    }

    private static void subtractZ(Optional<ModelPart> part, float angle) {
        if (part.isPresent()) {
            part.get().z -= angle;
        }
    }

    public static float getXRot(Optional<ModelPart> part) {
        if (part.isPresent()) {
            return part.get().xRot;
        } else {
            return 0.0F;
        }
    }

    public static float getYRot(Optional<ModelPart> part) {
        if (part.isPresent()) {
            return part.get().yRot;
        } else {
            return 0.0F;
        }
    }

    public static float getZRot(Optional<ModelPart> part) {
        if (part.isPresent()) {
            return part.get().zRot;
        } else {
            return 0.0F;
        }
    }

    private static void setXRot(Optional<ModelPart> part, float angle) {
        if (part.isPresent()) {
            part.get().xRot = angle;
        }
    }

    private static void setYRot(Optional<ModelPart> part, float angle) {
        if (part.isPresent()) {
            part.get().yRot = angle;
        }
    }

    private static void setZRot(Optional<ModelPart> part, float angle) {
        if (part.isPresent()) {
            part.get().zRot = angle;
        }
    }

    private static void addXRot(Optional<ModelPart> part, float angle) {
        if (part.isPresent()) {
            part.get().xRot += angle;
        }
    }

    private static void addYRot(Optional<ModelPart> part, float angle) {
        if (part.isPresent()) {
            part.get().yRot += angle;
        }
    }

    private static void addZRot(Optional<ModelPart> part, float angle) {
        if (part.isPresent()) {
            part.get().zRot += angle;
        }
    }

    private static void subtractXRot(Optional<ModelPart> part, float angle) {
        if (part.isPresent()) {
            part.get().xRot -= angle;
        }
    }

    private static void subtractYRot(Optional<ModelPart> part, float angle) {
        if (part.isPresent()) {
            part.get().yRot -= angle;
        }
    }

    private static void subtractZRot(Optional<ModelPart> part, float angle) {
        if (part.isPresent()) {
            part.get().zRot -= angle;
        }
    }

    private static void setPos(Optional<ModelPart> part, float x, float y, float z) {
        if (part.isPresent()) {
            part.get().setPos(x, y, z);
        }
    }

    public static boolean isBuiltIn(ResourceLocation id) {
        return BUILT_IN_ANIMATIONS.containsKey(id);
    }

    public static void register(ResourceLocation id, BuiltInAnimationType builtInAnimationType) {
        BUILT_IN_ANIMATIONS.put(id, builtInAnimationType);
    }
}
