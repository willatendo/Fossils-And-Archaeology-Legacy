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

import java.util.Map;

public final class AnimationUtils {
    public static final Map<ResourceLocation, BuiltInAnimationType> VALUES = Maps.newHashMap();

    protected static void legacyBrachiosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setXRot(jsonModel.get("front_left_thigh"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("front_left_calf"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("front_right_thigh"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("front_right_calf"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("back_left_thigh"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("back_left_calf"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("back_right_thigh"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("back_right_calf"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
    }

    protected static void carnotaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setXRot(jsonModel.get("right_thigh"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_thigh"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
    }

    protected static void cryolophosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setXRot(jsonModel.get("right_thigh"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_thigh"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
    }

    protected static void dilophosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setXRot(jsonModel.get("right_thigh"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_leg"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.372F);
        AnimationUtils.setXRot(jsonModel.get("left_foot"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_thigh"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("right_leg"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.372F);
        AnimationUtils.setXRot(jsonModel.get("right_foot"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
    }

    protected static void mosasaurusSwimAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setYRot(jsonModel.get("body"), (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * -0.0872664625997165 * limbSwingAmount + 0));
        AnimationUtils.setYRot(jsonModel.get("tail_1"), (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * 0.174532925199433 * limbSwingAmount + 0));
        AnimationUtils.setYRot(jsonModel.get("tail_2"), (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * -0.174532925199433 * limbSwingAmount + 0));
        AnimationUtils.setYRot(jsonModel.get("tail_3"), (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * 0.174532925199433 * limbSwingAmount + 0));
        AnimationUtils.setYRot(jsonModel.get("right_front_flipper"), (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * -0.174532925199433 * limbSwingAmount + -1.0471975511966));
        AnimationUtils.setYRot(jsonModel.get("left_front_flipper"), (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * 0.174532925199433 * limbSwingAmount + 1.0471975511966));
        AnimationUtils.setYRot(jsonModel.get("right_back_flipper"), (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * -0.174532925199433 * limbSwingAmount + -0.872664625997165));
        AnimationUtils.setYRot(jsonModel.get("left_back_flipper"), (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * 0.174532925199433 * limbSwingAmount + 0.872664625997165));
        AnimationUtils.setYRot(jsonModel.get("tail_3_spike"), (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * 0.174532925199433 * limbSwingAmount + 0));
        AnimationUtils.setYRot(jsonModel.get("tail_2_spike"), (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * -0.174532925199433 * limbSwingAmount + 0));
    }

    protected static void pteranodonFlyingAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        if (dinosaur instanceof FlyingDinosaur flyingDinosaur) {
            float airPitch = (float) -(flyingDinosaur.getAirPitch() * (Math.PI / 180.0F));
            float airAngle = (float) -(flyingDinosaur.getAirAngle() * (Math.PI / 180.0F));

            AnimationUtils.setXRot(jsonModel.get("left_wing_1"), -1.570796F + airPitch);
            AnimationUtils.setXRot(jsonModel.get("left_wing_1"), -1.570796F + airPitch);
            AnimationUtils.setXRot(jsonModel.get("left_wing_2"), 1.570796F + airPitch);
            AnimationUtils.setXRot(jsonModel.get("right_wing_1"), 1.570796F - airPitch);
            AnimationUtils.setXRot(jsonModel.get("right_wing_2"), -1.570796F - airPitch);
            AnimationUtils.setXRot(jsonModel.get("body"), 1.570796F + airPitch);
            AnimationUtils.setXRot(jsonModel.get("neck_1"), 1.570796F + airPitch);
            AnimationUtils.setXRot(jsonModel.get("neck_2"), 1.570796F + airPitch);
            AnimationUtils.setXRot(jsonModel.get("tail"), 1.570796F + airPitch);
            AnimationUtils.setXRot(jsonModel.get("crown"), 0.4859298F + airPitch);
            AnimationUtils.setXRot(jsonModel.get("head"), 1.570796F + airPitch);
            AnimationUtils.setXRot(jsonModel.get("upper_mouth"), airPitch);
            AnimationUtils.setXRot(jsonModel.get("lower_mouth"), 0.1356083F + airPitch);
            AnimationUtils.setXRot(jsonModel.get("left_leg"), 1.570796F + airPitch);
            AnimationUtils.setXRot(jsonModel.get("right_leg"), 1.570796F + airPitch);

            AnimationUtils.setZRot(jsonModel.get("body"), airAngle);
            AnimationUtils.setZRot(jsonModel.get("neck_1"), airAngle);
            AnimationUtils.setZRot(jsonModel.get("neck_2"), airAngle);
            AnimationUtils.setZRot(jsonModel.get("left_wing_1"), 2.792527F + airAngle);
            AnimationUtils.setZRot(jsonModel.get("left_wing_2"), airAngle);
            AnimationUtils.setZRot(jsonModel.get("right_wing_1"), -2.792527F + airAngle);
            AnimationUtils.setZRot(jsonModel.get("right_wing_2"), airAngle);
            AnimationUtils.setZRot(jsonModel.get("tail"), airAngle);
            AnimationUtils.setZRot(jsonModel.get("crown"), airAngle);
            AnimationUtils.setZRot(jsonModel.get("head"), airAngle);
            AnimationUtils.setZRot(jsonModel.get("upper_mouth"), airAngle);
            AnimationUtils.setZRot(jsonModel.get("lower_mouth"), airAngle);
            AnimationUtils.setZRot(jsonModel.get("left_leg"), airAngle);
            AnimationUtils.setZRot(jsonModel.get("right_leg"), airAngle);
        }
    }

    protected static void pteranodonHeadAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setYRot(jsonModel.get("crown"), -netHeadYaw / 57.29578F);
        AnimationUtils.setYRot(jsonModel.get("upper_mouth"), -netHeadYaw / 57.29578F);
        AnimationUtils.setYRot(jsonModel.get("lower_mouth"), -netHeadYaw / 57.29578F);
        AnimationUtils.setYRot(jsonModel.get("head"), -netHeadYaw / 57.29578F);
    }

    protected static void pteranodonWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setXRot(jsonModel.get("right_leg"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.271F);
        AnimationUtils.setXRot(jsonModel.get("left_leg"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.271F);
    }

    protected static void stegosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setYRot(jsonModel.get("tail_1"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.349065850398866F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.get("tail_2"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.436332312998582F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.get("tail_3"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.488692190558412F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_front_leg"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("right_front_leg"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_front_foot"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.872664625997162F);
        AnimationUtils.setXRot(jsonModel.get("right_front_foot"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.872664625997162F);
        AnimationUtils.setXRot(jsonModel.get("left_back_leg"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.get("left_back_leg"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("right_back_leg"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.get("right_back_leg"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_back_foot"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 1.22173047639603F);
        AnimationUtils.setYRot(jsonModel.get("left_back_foot"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("right_back_foot"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 1.22173047639603F);
        AnimationUtils.setYRot(jsonModel.get("right_back_foot"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.get("back_plates_1"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.488692190558412F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.get("back_plates_2"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.349065850398866F * limbSwingAmount);
        AnimationUtils.setZRot(jsonModel.get("back_plates_2"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setZRot(jsonModel.get("thagomizer"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setZRot(jsonModel.get("back_plates_3"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
    }

    protected static void therizinosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setXRot(jsonModel.get("right_thigh"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_thigh"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
    }

    protected static void legacyTriceratopsWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setYRot(jsonModel.get("lower_body"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.get("back"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.261799387799149F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.get("tail"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.349065850398866F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("right_front_thigh"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.get("right_front_thigh"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("right_front_leg"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        AnimationUtils.setYRot(jsonModel.get("right_front_leg"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_front_thigh"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.get("left_front_thigh"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_front_leg"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        AnimationUtils.setYRot(jsonModel.get("left_front_leg"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("right_back_thigh"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.get("right_back_thigh"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("right_back_leg"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        AnimationUtils.setYRot(jsonModel.get("right_back_leg"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_back_thigh"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount);
        AnimationUtils.setYRot(jsonModel.get("left_back_thigh"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_back_leg"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        AnimationUtils.setYRot(jsonModel.get("left_back_leg"), Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
    }

    protected static void tyrannosaurusHeadAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setYRot(jsonModel.get("head"), -netHeadYaw / 57.29578F);
        AnimationUtils.setYRot(jsonModel.get("snout"), -netHeadYaw / 57.29578F);
        AnimationUtils.setYRot(jsonModel.get("jaw"), -netHeadYaw / 57.29578F);
    }

    protected static void tyrannosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setXRot(jsonModel.get("left_thigh"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("right_leg"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.6108652F);
        AnimationUtils.setXRot(jsonModel.get("right_foot"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("right_thigh"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_leg"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.6108652F);
        AnimationUtils.setXRot(jsonModel.get("left_foot"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
    }

    protected static void tyrannosaurusWalkModelPrep(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float partialTick) {
        if (Math.abs(AnimationUtils.getXRot(jsonModel.get("left_thigh"))) >= 0.174532F) {
            AnimationUtils.tyrannosaurusRunPose(jsonModel);
        } else {
            AnimationUtils.tyrannosaurusStandPose(jsonModel);
        }
    }

    protected static void legacyVelociraptorWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setXRot(jsonModel.get("left_thigh"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("right_leg"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 0.9948377F);
        AnimationUtils.setXRot(jsonModel.get("right_foot"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("right_hook_1"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.8726646F);
        AnimationUtils.setXRot(jsonModel.get("right_hook_2"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 2.617994F);
        AnimationUtils.setXRot(jsonModel.get("right_thigh"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_leg"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount + 0.9948377F);
        AnimationUtils.setXRot(jsonModel.get("left_foot"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_hook_1"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.8726646F);
        AnimationUtils.setXRot(jsonModel.get("left_hook_2"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 2.617994F);
        AnimationUtils.setXRot(jsonModel.get("right_bicep"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("right_hand"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount + 0.994461F);
        AnimationUtils.setXRot(jsonModel.get("left_bicep"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_hand"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 0.994461F);
    }

    protected static void mammothWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setXRot(jsonModel.get("right_arm"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_arm"), Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("right_leg"), Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_leg"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("nose_top"), -0.1897142F);
        AnimationUtils.setXRot(jsonModel.get("nose_bottom"), -0.5986789F);
    }

    protected static void smilodonShakeModelPrep(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float partialTick) {
        if (dinosaur instanceof ShakingEntity shakingEntity) {
            float headAngle = shakingEntity.getHeadRollAngle(partialTick) + shakingEntity.getBodyRollAngle(partialTick, 0.0F);
            AnimationUtils.setZRot(jsonModel.get("head"), headAngle);
            AnimationUtils.setZRot(jsonModel.get("right_ear"), headAngle);
            AnimationUtils.setZRot(jsonModel.get("left_ear"), headAngle);
            AnimationUtils.setZRot(jsonModel.get("left_tooth_bottom"), headAngle);
            AnimationUtils.setZRot(jsonModel.get("left_tooth_top"), headAngle);
            AnimationUtils.setZRot(jsonModel.get("right_tooth_bottom"), headAngle);
            AnimationUtils.setZRot(jsonModel.get("right_tooth_top"), headAngle);
            AnimationUtils.setZRot(jsonModel.get("snout"), headAngle);
            AnimationUtils.setZRot(jsonModel.get("jaw"), headAngle);
            AnimationUtils.setZRot(jsonModel.get("nose"), headAngle);
            AnimationUtils.setZRot(jsonModel.get("body"), shakingEntity.getBodyRollAngle(partialTick, -0.08F));
            AnimationUtils.setZRot(jsonModel.get("back"), shakingEntity.getBodyRollAngle(partialTick, -0.16F));
            AnimationUtils.setZRot(jsonModel.get("tail"), shakingEntity.getBodyRollAngle(partialTick, -0.2F));
        }
    }

    protected static void smilodonSitModelPrep(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        if (dinosaur.isOrderedToSit()) {
            AnimationUtils.setPos(jsonModel.get("body"), 0.0F, 17.0F, 0.0F);
            AnimationUtils.setXRot(jsonModel.get("body"), -0.314F);
            AnimationUtils.setYRot(jsonModel.get("body"), 0.0F);
            AnimationUtils.setPos(jsonModel.get("back"), 0.0F, 20.0F, -1.0F);
            AnimationUtils.setXRot(jsonModel.get("back"), -0.7853982F);
            AnimationUtils.setPos(jsonModel.get("tail"), 0.0F, 23.0F, 4.5F);
            AnimationUtils.setPos(jsonModel.get("left_front_leg"), -1.5F, 25.0F, 1.0F);
            AnimationUtils.setXRot(jsonModel.get("left_front_leg"), 4.712389F);
            AnimationUtils.setPos(jsonModel.get("left_back_leg"), 1.5F, 25.0F, 1.0F);
            AnimationUtils.setXRot(jsonModel.get("left_back_leg"), 4.712389F);
            AnimationUtils.setXRot(jsonModel.get("right_front_leg"), 5.811947F);
            AnimationUtils.setPos(jsonModel.get("right_front_leg"), -1.5F, 20.0F, -2.0F);
            AnimationUtils.setXRot(jsonModel.get("right_back_leg"), 5.811947F);
            AnimationUtils.setPos(jsonModel.get("right_back_leg"), 1.5F, 20.0F, -2.0F);
        }
    }

    protected static void smilodonTailAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setYRot(jsonModel.get("tail"), Mth.cos(limbSwing * 0.6662f) * 1.4F * limbSwingAmount);
    }

    protected static void smilodonWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        AnimationUtils.setPos(jsonModel.get("body"), 0.0F, 15.0F, 0.0F);
        AnimationUtils.setPos(jsonModel.get("back"), 0.0F, 16.0F, 1.0F);
        AnimationUtils.setXRot(jsonModel.get("back"), 0.0F);
        AnimationUtils.setXRot(jsonModel.get("body"), 0.0F);

        AnimationUtils.setPos(jsonModel.get("tail"), 0.0F, 14.0F, 6.5F);
        AnimationUtils.setPos(jsonModel.get("left_front_leg"), -1.5F, 19.0F, 6.0F);
        AnimationUtils.setPos(jsonModel.get("left_back_leg"), 1.5F, 19.0F, 6.0F);
        AnimationUtils.setPos(jsonModel.get("right_front_leg"), -1.5F, 19.0F, -2.0F);
        AnimationUtils.setPos(jsonModel.get("right_back_leg"), 1.5F, 19.0F, -2.0F);
        AnimationUtils.setXRot(jsonModel.get("left_front_leg"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("left_back_leg"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("right_front_leg"), Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        AnimationUtils.setXRot(jsonModel.get("right_back_leg"), Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
    }

    private static void tyrannosaurusRunPose(JsonModel jsonModel) {
        AnimationUtils.tyrannosaurusRunPose(jsonModel, 20.0F);
    }

    private static void tyrannosaurusRunPose(JsonModel jsonModel, float moves) {
        if (AnimationUtils.getY(jsonModel.get("body")) > 7) {
            AnimationUtils.subtractY(jsonModel.get("body"), 2.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.get("body"), 7);
        }

        if (AnimationUtils.getZ(jsonModel.get("body")) > -4) {
            AnimationUtils.subtractZ(jsonModel.get("body"), 3.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.get("body"), -4);
        }

        if (AnimationUtils.getXRot(jsonModel.get("body")) < 0) {
            AnimationUtils.addXRot(jsonModel.get("body"), 0.9948377F / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.get("body"), 0);
        }

        if (AnimationUtils.getZ(jsonModel.get("neck")) > 0) {
            AnimationUtils.subtractZ(jsonModel.get("neck"), 2.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.get("neck"), 0);
        }

        if (AnimationUtils.getXRot(jsonModel.get("neck")) < 0) {
            AnimationUtils.addXRot(jsonModel.get("neck"), 0.4068249F / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.get("neck"), 0);
        }

        if (AnimationUtils.getY(jsonModel.get("right_arm")) < 14) {
            AnimationUtils.addY(jsonModel.get("right_arm"), 4.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.get("right_arm"), 14);
        }

        if (AnimationUtils.getY(jsonModel.get("left_arm")) < 14) {
            AnimationUtils.addY(jsonModel.get("left_arm"), 4.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.get("left_arm"), 14);
        }

        if (AnimationUtils.getXRot(jsonModel.get("tail_base")) < -0.2260139F) {
            AnimationUtils.addXRot(jsonModel.get("tail_base"), (0.7684471F - 0.2260139F) / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.get("tail_base"), -0.2260139F);
        }

        if (AnimationUtils.getY(jsonModel.get("tail_mid")) > 11) {
            AnimationUtils.subtractY(jsonModel.get("tail_mid"), 4.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.get("tail_mid"), 11);
        }

        if (AnimationUtils.getZ(jsonModel.get("tail_mid")) < 14) {
            AnimationUtils.addZ(jsonModel.get("tail_mid"), 2.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.get("tail_mid"), 14);
        }

        if (AnimationUtils.getXRot(jsonModel.get("tail_mid")) < -0.1356083F) {
            AnimationUtils.addXRot(jsonModel.get("tail_mid"), (0.5424333F - 0.1356083F) / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.get("tail_mid"), -0.1356083F);
        }

        if (AnimationUtils.getY(jsonModel.get("tail_end")) > 13) {
            AnimationUtils.subtractY(jsonModel.get("tail_end"), 7.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.get("tail_end"), 13);
        }

        if (AnimationUtils.getZ(jsonModel.get("tail_end")) < 22) {
            AnimationUtils.addZRot(jsonModel.get("tail_end"), 3.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.get("tail_end"), 22);
        }

        if (AnimationUtils.getXRot(jsonModel.get("tail_end")) < 0) {
            AnimationUtils.addXRot(jsonModel.get("tail_end"), 0.3616222F / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.get("tail_end"), 0);
        }

        if (AnimationUtils.getY(jsonModel.get("head")) < 7) {
            AnimationUtils.addY(jsonModel.get("head"), 7.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.get("head"), 7);
        }

        if (AnimationUtils.getZ(jsonModel.get("head")) > -14) {
            AnimationUtils.subtractZ(jsonModel.get("head"), 6.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.get("head"), -14);
        }

        if (AnimationUtils.getY(jsonModel.get("snout")) < 7) {
            AnimationUtils.addY(jsonModel.get("snout"), 7.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.get("snout"), 7);
        }

        if (AnimationUtils.getZ(jsonModel.get("snout")) > -14) {
            AnimationUtils.subtractZ(jsonModel.get("snout"), 6.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.get("snout"), -14);
        }

        if (AnimationUtils.getY(jsonModel.get("jaw")) < 7) {
            AnimationUtils.addY(jsonModel.get("jaw"), 6.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.get("jaw"), 7);
        }

        if (AnimationUtils.getZ(jsonModel.get("jaw")) > -14) {
            AnimationUtils.subtractZ(jsonModel.get("jaw"), 6.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.get("jaw"), -14);
        }
    }

    private static void tyrannosaurusStandPose(JsonModel jsonModel) {
        AnimationUtils.tyrannosaurusStandPose(jsonModel, 20.0F);
    }

    private static void tyrannosaurusStandPose(JsonModel jsonModel, float moves) {
        if (AnimationUtils.getY(jsonModel.get("body")) < 9) {
            AnimationUtils.addY(jsonModel.get("body"), 2.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.get("body"), 9);
        }

        if (AnimationUtils.getZ(jsonModel.get("body")) < -1) {
            AnimationUtils.addZ(jsonModel.get("body"), 3.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.get("body"), -1);
        }

        if (AnimationUtils.getXRot(jsonModel.get("body")) > -0.9948377F) {
            AnimationUtils.subtractXRot(jsonModel.get("body"), 0.9948377F / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.get("body"), -0.9948377F);
        }

        if (AnimationUtils.getZ(jsonModel.get("neck")) < 2) {
            AnimationUtils.addZ(jsonModel.get("neck"), 2.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.get("neck"), 2);
        }

        if (AnimationUtils.getXRot(jsonModel.get("neck")) > -0.4068249F) {
            AnimationUtils.subtractXRot(jsonModel.get("neck"), 0.4068249F / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.get("neck"), -0.4068249F);
        }

        if (AnimationUtils.getY(jsonModel.get("right_arm")) > 10) {
            AnimationUtils.subtractY(jsonModel.get("right_arm"), 4.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.get("right_arm"), 10);
        }

        if (AnimationUtils.getY(jsonModel.get("left_arm")) > 10) {
            AnimationUtils.subtractY(jsonModel.get("left_arm"), 4.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.get("left_arm"), 10);
        }

        if (AnimationUtils.getXRot(jsonModel.get("tail_base")) > -0.7684471F) {
            AnimationUtils.subtractXRot(jsonModel.get("tail_base"), (0.7684471F - 0.2260139F) / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.get("tail_base"), -0.7684471F);
        }

        if (AnimationUtils.getY(jsonModel.get("tail_mid")) < 15) {
            AnimationUtils.addY(jsonModel.get("tail_mid"), 4.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.get("tail_mid"), 15);
        }

        if (AnimationUtils.getZ(jsonModel.get("tail_mid")) > 12) {
            AnimationUtils.subtractZ(jsonModel.get("tail_mid"), 2.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.get("tail_mid"), 12);
        }

        if (AnimationUtils.getXRot(jsonModel.get("tail_mid")) > -0.5424333F) {
            AnimationUtils.subtractXRot(jsonModel.get("tail_mid"), (0.5424333F - 0.1356083F) / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.get("tail_mid"), -0.5424333F);
        }

        if (AnimationUtils.getY(jsonModel.get("tail_end")) < 20) {
            AnimationUtils.addY(jsonModel.get("tail_end"), 7.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.get("tail_end"), 20);
        }

        if (AnimationUtils.getZ(jsonModel.get("tail_end")) > 19) {
            AnimationUtils.addZ(jsonModel.get("tail_end"), 3.0F / moves);
        } else {
            AnimationUtils.setX(jsonModel.get("tail_end"), 19);
        }

        if (AnimationUtils.getXRot(jsonModel.get("tail_end")) < -0.3616222F) {
            AnimationUtils.addXRot(jsonModel.get("tail_end"), (0.3616222F - 2.8368E-15F) / moves);
        } else {
            AnimationUtils.setXRot(jsonModel.get("tail_end"), -0.3616222F);
        }

        if (AnimationUtils.getY(jsonModel.get("head")) > 0) {
            AnimationUtils.subtractY(jsonModel.get("head"), 7.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.get("head"), 0);
        }

        if (AnimationUtils.getZ(jsonModel.get("head")) < -8) {
            AnimationUtils.addZ(jsonModel.get("head"), 6.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.get("head"), -8);
        }

        if (AnimationUtils.getY(jsonModel.get("snout")) > 1) {
            AnimationUtils.subtractY(jsonModel.get("snout"), 7.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.get("snout"), 1);
        }

        if (AnimationUtils.getZ(jsonModel.get("snout")) < -8) {
            AnimationUtils.addZ(jsonModel.get("snout"), 6.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.get("snout"), -8);
        }

        if (AnimationUtils.getY(jsonModel.get("jaw")) > 1) {
            AnimationUtils.subtractY(jsonModel.get("jaw"), 6.0F / moves);
        } else {
            AnimationUtils.setY(jsonModel.get("jaw"), 1);
        }

        if (AnimationUtils.getZ(jsonModel.get("jaw")) < -8) {
            AnimationUtils.addZ(jsonModel.get("jaw"), 6.0F / moves);
        } else {
            AnimationUtils.setZ(jsonModel.get("jaw"), -8);
        }
    }

    public static float getX(ModelPart part) {
        return part.x;
    }

    public static float getY(ModelPart part) {
        return part.y;
    }

    public static float getZ(ModelPart part) {
        return part.z;
    }

    private static void setX(ModelPart part, float angle) {
        part.x = angle;
    }

    private static void setY(ModelPart part, float angle) {
        part.y = angle;
    }

    private static void setZ(ModelPart part, float angle) {
        part.z = angle;
    }

    private static void addX(ModelPart part, float angle) {
        part.x += angle;
    }

    private static void addY(ModelPart part, float angle) {
        part.y += angle;
    }

    private static void addZ(ModelPart part, float angle) {
        part.z += angle;
    }

    private static void subtractX(ModelPart part, float angle) {
        part.x -= angle;
    }

    private static void subtractY(ModelPart part, float angle) {
        part.y -= angle;
    }

    private static void subtractZ(ModelPart part, float angle) {
        part.z -= angle;
    }

    public static float getXRot(ModelPart part) {
        return part.xRot;
    }

    public static float getYRot(ModelPart part) {
        return part.yRot;
    }

    public static float getZRot(ModelPart part) {
        return part.zRot;
    }

    private static void setXRot(ModelPart modelPart, float angle) {
        modelPart.xRot = angle;
    }

    private static void setYRot(ModelPart part, float angle) {
        part.yRot = angle;
    }

    private static void setZRot(ModelPart part, float angle) {
        part.zRot = angle;
    }

    private static void addXRot(ModelPart part, float angle) {
        part.xRot += angle;
    }

    private static void addYRot(ModelPart part, float angle) {
        part.yRot += angle;
    }

    private static void addZRot(ModelPart part, float angle) {
        part.zRot += angle;
    }

    private static void subtractXRot(ModelPart part, float angle) {
        part.xRot -= angle;
    }

    private static void subtractYRot(ModelPart part, float angle) {
        part.yRot -= angle;
    }

    private static void subtractZRot(ModelPart part, float angle) {
        part.zRot -= angle;
    }

    private static void setPos(ModelPart part, float x, float y, float z) {
        part.setPos(x, y, z);
    }
}
