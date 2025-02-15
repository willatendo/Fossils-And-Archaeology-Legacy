package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class BrachiosaurusModels {
    public static final JsonModel BRACHIOSAURUS_MODEL = BrachiosaurusModels.createBrachiosaurusBodyLayer().withWalkAnimations(FAUtils.resource("brachiosaurus_walk")).withHeadPieces("neck").build();
    public static final JsonModel LEGACY_BRACHIOSAURUS_MODEL = BrachiosaurusModels.createLegacyBrachiosaurusBodyLayer().withWalkAnimations(BuiltInAnimationTypes.LEGACY_BRACHIOSAURUS_WALK.getId()).build();

    private static JsonModel.Builder createBrachiosaurusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(128, 128);

        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(0, 51, -3.0F, -3.0F, 0.0F, 6.0F, 5.0F, 6.0F).addBox(30, 21, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, 10.0F).build(), JsonPose.offset(0.0F, 17.0F, 8.0F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(62, 49, -2.0F, 4.0F, -2.0F, 4.0F, 6.0F, 3.0F).addBox(58, 21, -2.0F, -3.0F, -2.0F, 4.0F, 7.0F, 4.0F).build(), JsonPose.offset(-5.0F, 14.0F, -3.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(46, 53, -2.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F).build(), JsonPose.offset(-4.0F, 16.0F, 4.0F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(62, 58, -2.0F, 4.0F, -2.0F, 4.0F, 6.0F, 3.0F).addBox(58, 10, -2.0F, -3.0F, -2.0F, 4.0F, 7.0F, 4.0F).build(), JsonPose.offset(5.0F, 14.0F, -3.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(54, 35, -2.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F).build(), JsonPose.offset(4.0F, 16.0F, 4.0F));
        builder.addOrReplaceChild("neck", elementBuilder -> elementBuilder.addBox(0, 21, -4.0F, -6.0F, -5.0F, 8.0F, 11.0F, 7.0F).addBox(30, 35, -3.0F, -12.0F, -7.0F, 6.0F, 12.0F, 6.0F).addBox(40, 0, -2.0F, -23.0F, -8.0F, 4.0F, 13.0F, 5.0F).addOrReplaceChild("head", subElementBuilder -> subElementBuilder.addBox(24, 53, -3.0F, -2.0F, 3.0F, 6.0F, 6.0F, 5.0F).addBox(58, 0, -2.0F, -4.0F, 0.0F, 4.0F, 4.0F, 6.0F).addBox(0, 62, -2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 5.0F).build(), JsonPose.offset(0.0F, -22.0F, -12.0F)).build(), JsonPose.offset(0.0F, 12.0F, -4.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 39, -4.0F, -13.0F, 4.0F, 8.0F, 8.0F, 4.0F).addBox(0, 0, -5.0F, -16.0F, -6.0F, 10.0F, 11.0F, 10.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }

    private static JsonModel.Builder createLegacyBrachiosaurusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 32);

        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(48, 14, -2.0F, -1.0F, -4.0F, 4.0F, 3.0F, 4.0F, true).build(), JsonPose.offset(0.0F, -6.0F, -10.5F));
        builder.addOrReplaceChild("snout", elementBuilder -> elementBuilder.addBox(50, 8, -1.5F, -1.0F, -6.5F, 3.0F, 2.0F, 4.0F, true).build(), JsonPose.offsetAndRotation(0.0F, -6.0F, -11.0F, 0.2617994F, 0.0F, 0.0F));
        builder.addOrReplaceChild("crest", elementBuilder -> elementBuilder.addBox(52, 0, -1.0F, -3.0F, -5.0F, 2.0F, 4.0F, 4.0F, true).build(), JsonPose.offset(0.0F, -6.0F, -11.0F));
        builder.addOrReplaceChild("neck_1", elementBuilder -> elementBuilder.addBox(22, 0, -1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, true).build(), JsonPose.offsetAndRotation(0.0F, -6.0F, -10.5F, -0.7853982F, 0.0F, 0.0F));
        builder.addOrReplaceChild("neck_2", elementBuilder -> elementBuilder.addBox(22, 0, -1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, true).build(), JsonPose.offsetAndRotation(0.0F, -4.5F, -9.0F, -0.9599311F, 0.0F, 0.0F));
        builder.addOrReplaceChild("neck_3", elementBuilder -> elementBuilder.addBox(22, 0, -1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, true).build(), JsonPose.offsetAndRotation(0.0F, -3.0F, -8.0F, -1.23464F, 0.0F, 0.0F));
        builder.addOrReplaceChild("neck_4", elementBuilder -> elementBuilder.addBox(22, 0, -1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, true).build(), JsonPose.offsetAndRotation(0.0F, -1.5F, -7.5F, -1.343904F, 0.0F, 0.0F));
        builder.addOrReplaceChild("neck_5", elementBuilder -> elementBuilder.addBox(22, 0, -1.5F, 0.0F, 2.0F, 3.0F, 2.0F, 2.0F, true).build(), JsonPose.offsetAndRotation(0.0F, -1.5F, -7.5F, -1.343904F, 0.0F, 0.0F));
        builder.addOrReplaceChild("neck_6", elementBuilder -> elementBuilder.addBox(22, 0, -1.5F, 0.0F, 4.0F, 3.0F, 2.0F, 2.0F, true).build(), JsonPose.offsetAndRotation(0.0F, -1.5F, -7.5F, -1.343904F, 0.0F, 0.0F));
        builder.addOrReplaceChild("neck_7", elementBuilder -> elementBuilder.addBox(22, 0, -1.5F, 0.0F, 6.0F, 3.0F, 2.0F, 2.0F, true).build(), JsonPose.offsetAndRotation(0.0F, -1.5F, -7.5F, -1.343904F, 0.0F, 0.0F));
        builder.addOrReplaceChild("neck_8", elementBuilder -> elementBuilder.addBox(34, 11, -2.0F, -1.0F, -0.5F, 4.0F, 3.0F, 3.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 6.0F, -6.5F, -0.9637522F, 0.0F, 0.0F));
        builder.addOrReplaceChild("lower_neck_1", elementBuilder -> elementBuilder.addBox(32, 24, -2.5F, -0.5F, -0.5F, 5.0F, 4.0F, 4.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 7.0F, -5.0F, -0.8377581F, 0.0F, 0.0F));
        builder.addOrReplaceChild("lower_neck_2", elementBuilder -> elementBuilder.addBox(10, 21, -3.0F, 0.0F, 0.0F, 6.0F, 6.0F, 5.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 7.0F, -5.0F, -0.3907885F, 0.0F, 0.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -4.0F, 0.0F, 0.0F, 8.0F, 7.0F, 6.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 8.0F, -3.0F, -0.1115358F, 0.0F, 0.0F));
        builder.addOrReplaceChild("lower_body", elementBuilder -> elementBuilder.addBox(28, 0, -3.5F, 0.0F, 0.0F, 7.0F, 6.0F, 5.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 9.0F, 2.0F, -0.3346075F, 0.0F, 0.0F));
        builder.addOrReplaceChild("front_right_thigh", elementBuilder -> elementBuilder.addBox(50, 21, 0.0F, 0.0F, -2.0F, 3.0F, 7.0F, 4.0F, true).build(), JsonPose.offset(3.0F, 12.0F, -3.5F));
        builder.addOrReplaceChild("front_right_calf", elementBuilder -> elementBuilder.addBox(0, 24, 0.5F, 7.0F, -2.0F, 2.0F, 5.0F, 3.0F, true).build(), JsonPose.offset(3.0F, 12.0F, -3.5F));
        builder.addOrReplaceChild("front_left_thigh", elementBuilder -> elementBuilder.addBox(50, 21, -3.0F, 0.0F, -2.0F, 3.0F, 7.0F, 4.0F, true).build(), JsonPose.offset(-3.0F, 12.0F, -3.5F));
        builder.addOrReplaceChild("front_left_calf", elementBuilder -> elementBuilder.addBox(0, 24, -2.5F, 7.0F, -2.0F, 2.0F, 5.0F, 3.0F, true).build(), JsonPose.offset(-3.0F, 12.0F, -3.5F));
        builder.addOrReplaceChild("back_right_thigh", elementBuilder -> elementBuilder.addBox(50, 21, -1.0F, 0.0F, -2.0F, 3.0F, 5.0F, 4.0F, true).build(), JsonPose.offset(3.0F, 14.0F, 4.5F));
        builder.addOrReplaceChild("back_right_calf", elementBuilder -> elementBuilder.addBox(0, 24, -0.5F, 5.0F, -1.0F, 2.0F, 5.0F, 3.0F, true).build(), JsonPose.offset(3.0F, 14.0F, 4.5F));
        builder.addOrReplaceChild("back_left_thigh", elementBuilder -> elementBuilder.addBox(50, 21, -2.0F, 0.0F, -2.0F, 3.0F, 5.0F, 4.0F, true).build(), JsonPose.offset(-3.0F, 14.0F, 4.5F));
        builder.addOrReplaceChild("back_left_calf", elementBuilder -> elementBuilder.addBox(0, 24, -1.5F, 5.0F, -1.0F, 2.0F, 5.0F, 3.0F, true).build(), JsonPose.offset(-3.0F, 14.0F, 4.5F));
        builder.addOrReplaceChild("tail_base", elementBuilder -> elementBuilder.addBox(0, 13, -2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 4.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 11.0F, 6.0F, -0.7064018F, 0.0F, 0.0F));
        builder.addOrReplaceChild("tail_mid", elementBuilder -> elementBuilder.addBox(18, 13, -2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 4.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 14.0F, 8.0F, -0.5576873F, 0.0F, 0.0F));
        builder.addOrReplaceChild("tail_end", elementBuilder -> elementBuilder.addBox(34, 17, -1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 4.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 16.5F, 10.5F, -0.3717943F, 0.0F, 0.0F));

        return builder;
    }
}