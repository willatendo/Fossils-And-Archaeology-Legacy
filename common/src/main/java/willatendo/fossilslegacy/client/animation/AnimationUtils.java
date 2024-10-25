package willatendo.fossilslegacy.client.animation;

import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.util.interfaces.FlyingDinosaur;
import willatendo.fossilslegacy.server.entity.util.interfaces.ShakingEntity;

public final class AnimationUtils {
    protected static void legacyBrachiosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setXRot("front_left_thigh", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("front_left_calf", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("front_right_thigh", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("front_right_calf", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("back_left_thigh", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("back_left_calf", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("back_right_thigh", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("back_right_calf", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
    }

    protected static void carnotaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setXRot("right_thigh", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("left_thigh", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
    }

    protected static void cryolophosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setXRot("right_thigh", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("left_thigh", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
    }

    protected static void dilophosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setXRot("right_thigh", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("left_leg", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.372F);
        jsonModel.setXRot("left_foot", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("left_thigh", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("right_leg", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.372F);
        jsonModel.setXRot("right_foot", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
    }

    protected static void mosasaurusSwimAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setYRot("body", (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * -0.0872664625997165 * limbSwingAmount + 0));
        jsonModel.setYRot("tail_1", (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * 0.174532925199433 * limbSwingAmount + 0));
        jsonModel.setYRot("tail_2", (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * -0.174532925199433 * limbSwingAmount + 0));
        jsonModel.setYRot("tail_3", (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * 0.174532925199433 * limbSwingAmount + 0));
        jsonModel.setYRot("right_front_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * -0.174532925199433 * limbSwingAmount + -1.0471975511966));
        jsonModel.setYRot("left_front_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * 0.174532925199433 * limbSwingAmount + 1.0471975511966));
        jsonModel.setYRot("right_back_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * -0.174532925199433 * limbSwingAmount + -0.872664625997165));
        jsonModel.setYRot("left_back_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * 0.174532925199433 * limbSwingAmount + 0.872664625997165));
        jsonModel.setYRot("tail_3_spike", (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * 0.174532925199433 * limbSwingAmount + 0));
        jsonModel.setYRot("tail_2_spike", (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * -0.174532925199433 * limbSwingAmount + 0));
    }

    protected static void pteranodonFlyingAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        if (dinosaur instanceof FlyingDinosaur flyingDinosaur) {
            if (flyingDinosaur.shouldFly() && !flyingDinosaur.shouldLand()) {
                float airPitch = (float) -(flyingDinosaur.getAirPitch() * (Math.PI / 180.0F));
                float airAngle = (float) -(flyingDinosaur.getAirAngle() * (Math.PI / 180.0F));

                jsonModel.setPos("root", 0, 4, 3);
                jsonModel.setXRot("root", airPitch);
                jsonModel.setZRot("root", airAngle);
            }
        }
    }

    protected static void legacyPteranodonFlyingAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        if (dinosaur instanceof FlyingDinosaur flyingDinosaur) {
            float airPitch = (float) -(flyingDinosaur.getAirPitch() * (Math.PI / 180.0F));
            float airAngle = (float) -(flyingDinosaur.getAirAngle() * (Math.PI / 180.0F));

            jsonModel.setXRot("left_wing_1", -1.570796F + airPitch);
            jsonModel.setXRot("left_wing_1", -1.570796F + airPitch);
            jsonModel.setXRot("left_wing_2", 1.570796F + airPitch);
            jsonModel.setXRot("right_wing_1", 1.570796F - airPitch);
            jsonModel.setXRot("right_wing_2", -1.570796F - airPitch);
            jsonModel.setXRot("body", 1.570796F + airPitch);
            jsonModel.setXRot("neck_1", 1.570796F + airPitch);
            jsonModel.setXRot("neck_2", 1.570796F + airPitch);
            jsonModel.setXRot("tail", 1.570796F + airPitch);
            jsonModel.setXRot("crown", 0.4859298F + airPitch);
            jsonModel.setXRot("head", 1.570796F + airPitch);
            jsonModel.setXRot("upper_mouth", airPitch);
            jsonModel.setXRot("lower_mouth", 0.1356083F + airPitch);
            jsonModel.setXRot("left_leg", 1.570796F + airPitch);
            jsonModel.setXRot("right_leg", 1.570796F + airPitch);

            jsonModel.setZRot("body", airAngle);
            jsonModel.setZRot("neck_1", airAngle);
            jsonModel.setZRot("neck_2", airAngle);
            jsonModel.setZRot("left_wing_1", 2.792527F + airAngle);
            jsonModel.setZRot("left_wing_2", airAngle);
            jsonModel.setZRot("right_wing_1", -2.792527F + airAngle);
            jsonModel.setZRot("right_wing_2", airAngle);
            jsonModel.setZRot("tail", airAngle);
            jsonModel.setZRot("crown", airAngle);
            jsonModel.setZRot("head", airAngle);
            jsonModel.setZRot("upper_mouth", airAngle);
            jsonModel.setZRot("lower_mouth", airAngle);
            jsonModel.setZRot("left_leg", airAngle);
            jsonModel.setZRot("right_leg", airAngle);
        }
    }

    protected static void legacyPteranodonHeadAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setYRot("crown", -netHeadYaw / 57.29578F);
        jsonModel.setYRot("upper_mouth", -netHeadYaw / 57.29578F);
        jsonModel.setYRot("lower_mouth", -netHeadYaw / 57.29578F);
        jsonModel.setYRot("head", -netHeadYaw / 57.29578F);
    }

    protected static void legacyPteranodonWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setXRot("right_leg", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.271F);
        jsonModel.setXRot("left_leg", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.271F);
    }

    protected static void stegosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setYRot("tail_1", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.349065850398866F * limbSwingAmount);
        jsonModel.setYRot("tail_2", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.436332312998582F * limbSwingAmount);
        jsonModel.setYRot("tail_3", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.488692190558412F * limbSwingAmount);
        jsonModel.setXRot("left_front_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount);
        jsonModel.setXRot("right_front_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonModel.setXRot("left_front_foot", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.872664625997162F);
        jsonModel.setXRot("right_front_foot", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.872664625997162F);
        jsonModel.setXRot("left_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonModel.setYRot("left_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonModel.setXRot("right_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount);
        jsonModel.setYRot("right_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonModel.setXRot("left_back_foot", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 1.22173047639603F);
        jsonModel.setYRot("left_back_foot", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonModel.setXRot("right_back_foot", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 1.22173047639603F);
        jsonModel.setYRot("right_back_foot", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonModel.setYRot("back_plates_1", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.488692190558412F * limbSwingAmount);
        jsonModel.setYRot("back_plates_2", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.349065850398866F * limbSwingAmount);
        jsonModel.setZRot("back_plates_2", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonModel.setZRot("thagomizer", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonModel.setZRot("back_plates_3", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
    }

    protected static void therizinosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setXRot("right_thigh", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("left_thigh", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
    }

    protected static void legacyTriceratopsWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setYRot("lower_body", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonModel.setYRot("back", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.261799387799149F * limbSwingAmount);
        jsonModel.setYRot("tail", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.349065850398866F * limbSwingAmount);
        jsonModel.setXRot("right_front_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount);
        jsonModel.setYRot("right_front_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonModel.setXRot("right_front_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        jsonModel.setYRot("right_front_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonModel.setXRot("left_front_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonModel.setYRot("left_front_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonModel.setXRot("left_front_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        jsonModel.setYRot("left_front_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonModel.setXRot("right_back_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonModel.setYRot("right_back_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonModel.setXRot("right_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        jsonModel.setYRot("right_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonModel.setXRot("left_back_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount);
        jsonModel.setYRot("left_back_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonModel.setXRot("left_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        jsonModel.setYRot("left_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
    }

    protected static void tyrannosaurusHeadAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setYRot("head", -netHeadYaw / 57.29578F);
        jsonModel.setYRot("snout", -netHeadYaw / 57.29578F);
        jsonModel.setYRot("jaw", -netHeadYaw / 57.29578F);
    }

    protected static void tyrannosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setXRot("left_thigh", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("right_leg", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.6108652F);
        jsonModel.setXRot("right_foot", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("right_thigh", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("left_leg", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.6108652F);
        jsonModel.setXRot("left_foot", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        if (Math.abs(jsonModel.getXRot("right_thigh")) >= 0.174532F) {
            AnimationUtils.tyrannosaurusRunPose(jsonModel);
        } else {
            AnimationUtils.tyrannosaurusStandPose(jsonModel);
        }
    }

    protected static void tyrannosaurusWalkModelPrep(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float partialTick) {
    }

    protected static void legacyVelociraptorWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setXRot("left_thigh", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("right_leg", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 0.9948377F);
        jsonModel.setXRot("right_foot", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("right_hook_1", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.8726646F);
        jsonModel.setXRot("right_hook_2", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 2.617994F);
        jsonModel.setXRot("right_thigh", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("left_leg", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount + 0.9948377F);
        jsonModel.setXRot("left_foot", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("left_hook_1", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.8726646F);
        jsonModel.setXRot("left_hook_2", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 2.617994F);
        jsonModel.setXRot("right_bicep", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("right_hand", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount + 0.994461F);
        jsonModel.setXRot("left_bicep", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("left_hand", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 0.994461F);
    }

    protected static void mammothWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setXRot("right_arm", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("left_arm", Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("right_leg", Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("left_leg", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("nose_top", -0.1897142F);
        jsonModel.setXRot("nose_bottom", -0.5986789F);
    }

    protected static void smilodonShakeModelPrep(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float partialTick) {
        if (dinosaur instanceof ShakingEntity shakingEntity) {
            float headAngle = shakingEntity.getHeadRollAngle(partialTick) + shakingEntity.getBodyRollAngle(partialTick, 0.0F);
            jsonModel.setZRot("head", headAngle);
            jsonModel.setZRot("right_ear", headAngle);
            jsonModel.setZRot("left_ear", headAngle);
            jsonModel.setZRot("left_tooth_bottom", headAngle);
            jsonModel.setZRot("left_tooth_top", headAngle);
            jsonModel.setZRot("right_tooth_bottom", headAngle);
            jsonModel.setZRot("right_tooth_top", headAngle);
            jsonModel.setZRot("snout", headAngle);
            jsonModel.setZRot("jaw", headAngle);
            jsonModel.setZRot("nose", headAngle);
            jsonModel.setZRot("body", shakingEntity.getBodyRollAngle(partialTick, -0.08F));
            jsonModel.setZRot("back", shakingEntity.getBodyRollAngle(partialTick, -0.16F));
            jsonModel.setZRot("tail", shakingEntity.getBodyRollAngle(partialTick, -0.2F));
        }
    }

    protected static void smilodonSitModelPrep(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        if (dinosaur.isOrderedToSit()) {
            jsonModel.setPos("body", 0.0F, 17.0F, 0.0F);
            jsonModel.setXRot("body", -0.314F);
            jsonModel.setYRot("body", 0.0F);
            jsonModel.setPos("back", 0.0F, 20.0F, -1.0F);
            jsonModel.setXRot("back", -0.7853982F);
            jsonModel.setPos("tail", 0.0F, 23.0F, 4.5F);
            jsonModel.setPos("left_front_leg", -1.5F, 25.0F, 1.0F);
            jsonModel.setXRot("left_front_leg", 4.712389F);
            jsonModel.setPos("left_back_leg", 1.5F, 25.0F, 1.0F);
            jsonModel.setXRot("left_back_leg", 4.712389F);
            jsonModel.setXRot("right_front_leg", 5.811947F);
            jsonModel.setPos("right_front_leg", -1.5F, 20.0F, -2.0F);
            jsonModel.setXRot("right_back_leg", 5.811947F);
            jsonModel.setPos("right_back_leg", 1.5F, 20.0F, -2.0F);
        }
    }

    protected static void smilodonTailAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setYRot("tail", Mth.cos(limbSwing * 0.6662f) * 1.4F * limbSwingAmount);
    }

    protected static void smilodonWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setPos("body", 0.0F, 15.0F, 0.0F);
        jsonModel.setPos("back", 0.0F, 16.0F, 1.0F);
        jsonModel.setXRot("back", 0.0F);
        jsonModel.setXRot("body", 0.0F);

        jsonModel.setPos("tail", 0.0F, 14.0F, 6.5F);
        jsonModel.setPos("left_front_leg", -1.5F, 19.0F, 6.0F);
        jsonModel.setPos("left_back_leg", 1.5F, 19.0F, 6.0F);
        jsonModel.setPos("right_front_leg", -1.5F, 19.0F, -2.0F);
        jsonModel.setPos("right_back_leg", 1.5F, 19.0F, -2.0F);
        jsonModel.setXRot("left_front_leg", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("left_back_leg", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("right_front_leg", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("right_back_leg", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
    }

    private static void tyrannosaurusRunPose(JsonModel jsonModel) {
        AnimationUtils.tyrannosaurusRunPose(jsonModel, 20.0F);
    }

    private static void tyrannosaurusRunPose(JsonModel jsonModel, float moves) {
        if (jsonModel.getY("body") > 7) {
            jsonModel.subtractY("body", 2.0F / moves);
        } else {
            jsonModel.setY("body", 7);
        }

        if (jsonModel.getZ("body") > -4) {
            jsonModel.subtractZ("body", 3.0F / moves);
        } else {
            jsonModel.setZ("body", -4);
        }

        if (jsonModel.getXRot("body") < 0) {
            jsonModel.addXRot("body", 0.9948377F / moves);
        } else {
            jsonModel.setXRot("body", 0);
        }

        if (jsonModel.getZ("neck") > 0) {
            jsonModel.subtractZ("neck", 2.0F / moves);
        } else {
            jsonModel.setZ("neck", 0);
        }

        if (jsonModel.getXRot("neck") < 0) {
            jsonModel.addXRot("neck", 0.4068249F / moves);
        } else {
            jsonModel.setXRot("neck", 0);
        }

        if (jsonModel.getY("right_arm") < 14) {
            jsonModel.addY("right_arm", 4.0F / moves);
        } else {
            jsonModel.setY("right_arm", 14);
        }

        if (jsonModel.getY("left_arm") < 14) {
            jsonModel.addY("left_arm", 4.0F / moves);
        } else {
            jsonModel.setY("left_arm", 14);
        }

        if (jsonModel.getXRot("tail_base") < -0.2260139F) {
            jsonModel.addXRot("tail_base", (0.7684471F - 0.2260139F) / moves);
        } else {
            jsonModel.setXRot("tail_base", -0.2260139F);
        }

        if (jsonModel.getY("tail_mid") > 11) {
            jsonModel.subtractY("tail_mid", 4.0F / moves);
        } else {
            jsonModel.setY("tail_mid", 11);
        }

        if (jsonModel.getZ("tail_mid") < 14) {
            jsonModel.addZ("tail_mid", 2.0F / moves);
        } else {
            jsonModel.setZ("tail_mid", 14);
        }

        if (jsonModel.getXRot("tail_mid") < -0.1356083F) {
            jsonModel.addXRot("tail_mid", (0.5424333F - 0.1356083F) / moves);
        } else {
            jsonModel.setXRot("tail_mid", -0.1356083F);
        }

        if (jsonModel.getY("tail_end") > 13) {
            jsonModel.subtractY("tail_end", 7.0F / moves);
        } else {
            jsonModel.setY("tail_end", 13);
        }

        if (jsonModel.getZ("tail_end") < 22) {
            jsonModel.addZRot("tail_end", 3.0F / moves);
        } else {
            jsonModel.setZ("tail_end", 22);
        }

        if (jsonModel.getXRot("tail_end") < 0) {
            jsonModel.addXRot("tail_end", 0.3616222F / moves);
        } else {
            jsonModel.setXRot("tail_end", 0);
        }

        if (jsonModel.getY("head") < 7) {
            jsonModel.addY("head", 7.0F / moves);
        } else {
            jsonModel.setY("head", 7);
        }

        if (jsonModel.getZ("head") > -14) {
            jsonModel.subtractZ("head", 6.0F / moves);
        } else {
            jsonModel.setZ("head", -14);
        }

        if (jsonModel.getY("snout") < 7) {
            jsonModel.addY("snout", 7.0F / moves);
        } else {
            jsonModel.setY("snout", 7);
        }

        if (jsonModel.getZ("snout") > -14) {
            jsonModel.subtractZ("snout", 6.0F / moves);
        } else {
            jsonModel.setZ("snout", -14);
        }

        if (jsonModel.getY("jaw") < 7) {
            jsonModel.addY("jaw", 6.0F / moves);
        } else {
            jsonModel.setY("jaw", 7);
        }

        if (jsonModel.getZ("jaw") > -14) {
            jsonModel.subtractZ("jaw", 6.0F / moves);
        } else {
            jsonModel.setZ("jaw", -14);
        }
    }

    private static void tyrannosaurusStandPose(JsonModel jsonModel) {
        AnimationUtils.tyrannosaurusStandPose(jsonModel, 20.0F);
    }

    private static void tyrannosaurusStandPose(JsonModel jsonModel, float moves) {
        if (jsonModel.getY("body") < 9) {
            jsonModel.addY("body", 2.0F / moves);
        } else {
            jsonModel.setY("body", 9);
        }

        if (jsonModel.getZ("body") < -1) {
            jsonModel.addZ("body", 3.0F / moves);
        } else {
            jsonModel.setZ("body", -1);
        }

        if (jsonModel.getXRot("body") > -0.9948377F) {
            jsonModel.subtractXRot("body", 0.9948377F / moves);
        } else {
            jsonModel.setXRot("body", -0.9948377F);
        }

        if (jsonModel.getZ("neck") < 2) {
            jsonModel.addZ("neck", 2.0F / moves);
        } else {
            jsonModel.setZ("neck", 2);
        }

        if (jsonModel.getXRot("neck") > -0.4068249F) {
            jsonModel.subtractXRot("neck", 0.4068249F / moves);
        } else {
            jsonModel.setXRot("neck", -0.4068249F);
        }

        if (jsonModel.getY("right_arm") > 10) {
            jsonModel.subtractY("right_arm", 4.0F / moves);
        } else {
            jsonModel.setY("right_arm", 10);
        }

        if (jsonModel.getY("left_arm") > 10) {
            jsonModel.subtractY("left_arm", 4.0F / moves);
        } else {
            jsonModel.setY("left_arm", 10);
        }

        if (jsonModel.getXRot("tail_base") > -0.7684471F) {
            jsonModel.subtractXRot("tail_base", (0.7684471F - 0.2260139F) / moves);
        } else {
            jsonModel.setXRot("tail_base", -0.7684471F);
        }

        if (jsonModel.getY("tail_mid") < 15) {
            jsonModel.addY("tail_mid", 4.0F / moves);
        } else {
            jsonModel.setY("tail_mid", 15);
        }

        if (jsonModel.getZ("tail_mid") > 12) {
            jsonModel.subtractZ("tail_mid", 2.0F / moves);
        } else {
            jsonModel.setZ("tail_mid", 12);
        }

        if (jsonModel.getXRot("tail_mid") > -0.5424333F) {
            jsonModel.subtractXRot("tail_mid", (0.5424333F - 0.1356083F) / moves);
        } else {
            jsonModel.setXRot("tail_mid", -0.5424333F);
        }

        if (jsonModel.getY("tail_end") < 20) {
            jsonModel.addY("tail_end", 7.0F / moves);
        } else {
            jsonModel.setY("tail_end", 20);
        }

        if (jsonModel.getZ("tail_end") > 19) {
            jsonModel.addZ("tail_end", 3.0F / moves);
        } else {
            jsonModel.setX("tail_end", 19);
        }

        if (jsonModel.getXRot("tail_end") < -0.3616222F) {
            jsonModel.addXRot("tail_end", (0.3616222F - 2.8368E-15F) / moves);
        } else {
            jsonModel.setXRot("tail_end", -0.3616222F);
        }

        if (jsonModel.getY("head") > 0) {
            jsonModel.subtractY("head", 7.0F / moves);
        } else {
            jsonModel.setY("head", 0);
        }

        if (jsonModel.getZ("head") < -8) {
            jsonModel.addZ("head", 6.0F / moves);
        } else {
            jsonModel.setZ("head", -8);
        }

        if (jsonModel.getY("snout") > 1) {
            jsonModel.subtractY("snout", 7.0F / moves);
        } else {
            jsonModel.setY("snout", 1);
        }

        if (jsonModel.getZ("snout") < -8) {
            jsonModel.addZ("snout", 6.0F / moves);
        } else {
            jsonModel.setZ("snout", -8);
        }

        if (jsonModel.getY("jaw") > 1) {
            jsonModel.subtractY("jaw", 6.0F / moves);
        } else {
            jsonModel.setY("jaw", 1);
        }

        if (jsonModel.getZ("jaw") < -8) {
            jsonModel.addZ("jaw", 6.0F / moves);
        } else {
            jsonModel.setZ("jaw", -8);
        }
    }
}
