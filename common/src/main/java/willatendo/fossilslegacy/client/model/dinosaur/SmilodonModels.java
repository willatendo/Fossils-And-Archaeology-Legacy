package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class SmilodonModels {
    public static final JsonModel SMILODON_MODEL = SmilodonModels.createSmilodonBodyLayer().withWalkAnimations(FAUtils.resource("smilodon_walk")).withSitAnimations(FAUtils.resource("smilodon_sit")).withHeadPieces("neck").build();
    public static final JsonModel LEGACY_SMILODON_MODEL = SmilodonModels.createLegacySmilodonBodyLayer().withSitAnimations(BuiltInAnimationTypes.LEGACY_SMILODON_SIT.getId()).withShakeAnimations(BuiltInAnimationTypes.LEGACY_SMILODON_SHAKE.getId()).withTailAnimations(BuiltInAnimationTypes.LEGACY_SMILODON_TAIL.getId()).overrideReset().build();

    private static JsonModel.Builder createSmilodonBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 64);

        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(32, 15, -1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F).build(), JsonPose.offset(2.5F, 18.0F, -2.5F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(34, 0, -1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F).build(), JsonPose.offset(-2.5F, 18.0F, -2.5F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(40, 24, -1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F).build(), JsonPose.offset(2.5F, 18.0F, 8.5F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(40, 33, -1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F).build(), JsonPose.offset(-2.5F, 18.0F, 8.5F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(24, 41, -1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F).build(), JsonPose.offset(0.0F, 14.0F, 11.0F));
        builder.addOrReplaceChild("neck", elementBuilder -> elementBuilder.addBox(24, 30, -3.0F, -4.0F, -2.0F, 4.0F, 7.0F, 4.0F).addOrReplaceChild("head", subElement1Builder -> subElement1Builder.addBox(0, 30, -5.0F, -3.0F, -5.0F, 6.0F, 6.0F, 6.0F).addBox(34, 9, -4.0F, -1.0F, -8.0F, 4.0F, 3.0F, 3.0F).addBox(0, 42, -3.0F, 2.0F, -8.0F, 2.0F, 1.0F, 3.0F).addBox(16, 42, -5.0F, -4.0F, -2.0F, 1.0F, 1.0F, 2.0F).addBox(32, 24, -1.0F, 2.0F, -8.0F, 1.0F, 2.0F, 2.0F).addBox(32, 41, -4.0F, 2.0F, -8.0F, 1.0F, 2.0F, 2.0F).addBox(38, 42, -4.0F, 4.0F, -8.0F, 1.0F, 1.0F, 2.0F).addBox(44, 15, -1.0F, 4.0F, -8.0F, 1.0F, 1.0F, 2.0F).addBox(10, 42, 0.0F, -4.0F, -2.0F, 1.0F, 1.0F, 2.0F).build(), JsonPose.offset(1.0F, -2.0F, -2.0F)).build(), JsonPose.offset(1.0F, 13.0F, -5.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 15, -4.0F, -3.25F, -0.25F, 8.0F, 7.0F, 8.0F).addBox(0, 0, -5.0F, -4.25F, -7.25F, 10.0F, 8.0F, 7.0F).build(), JsonPose.offset(0.0F, 14.25F, 2.25F));

        return builder;
    }

    private static JsonModel.Builder createLegacySmilodonBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 32);

        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(0, 0, -2.5F, -1.5F, -4.0F, 5.0F, 4.0F, 4.0F, true).build(), JsonPose.offset(0.0F, 15.0F, -3.0F));
        builder.addOrReplaceChild("right_ear", elementBuilder -> elementBuilder.addBox(6, 8, -2.5F, -2.5F, -3.0F, 1.0F, 1.0F, 2.0F, true).build(), JsonPose.offset(0.0F, 15.0F, -3.0F));
        builder.addOrReplaceChild("left_ear", elementBuilder -> elementBuilder.addBox(6, 8, 1.5F, -2.5F, -3.0F, 1.0F, 1.0F, 2.0F, true).build(), JsonPose.offset(0.0F, 15.0F, -3.0F));
        builder.addOrReplaceChild("nose", elementBuilder -> elementBuilder.addBox(18, 0, -1.0F, -1.0F, -7.0F, 2.0F, 1.0F, 3.0F).build(), JsonPose.offset(0.0F, 15.0F, -3.0F));
        builder.addOrReplaceChild("snout", elementBuilder -> elementBuilder.addBox(18, 5, -2.0F, 0.0F, -7.0F, 4.0F, 2.0F, 3.0F).build(), JsonPose.offset(0.0F, 15.0F, -3.0F));
        builder.addOrReplaceChild("jaw", elementBuilder -> elementBuilder.addBox(48, 7, -1.0F, 0.0F, -3.5F, 2.0F, 1.0F, 3.0F).build(), JsonPose.offsetAndRotation(0.0F, 16.5F, -6.0F, 0.1745329F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_tooth_top", elementBuilder -> elementBuilder.addBox(44, 14, -1.5F, 2.0F, -6.0F, 1.0F, 2.0F, 1.0F, true).build(), JsonPose.offset(0.0F, 15.0F, -3.0F));
        builder.addOrReplaceChild("right_tooth_bottom", elementBuilder -> elementBuilder.addBox(44, 17, -1.5F, 4.0F, -6.0F, 1.0F, 2.0F, 1.0F, true).build(), JsonPose.offset(0.0F, 15.0F, -3.0F));
        builder.addOrReplaceChild("left_tooth_top", elementBuilder -> elementBuilder.addBox(44, 14, 0.5F, 2.0F, -6.0F, 1.0F, 2.0F, 1.0F, true).build(), JsonPose.offset(0.0F, 15.0F, -3.0F));
        builder.addOrReplaceChild("left_tooth_bottom", elementBuilder -> elementBuilder.addBox(44, 17, 0.5F, 4.0F, -6.0F, 1.0F, 2.0F, 1.0F, true).build(), JsonPose.offset(0.0F, 15.0F, -3.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 11, -3.5F, -2.5F, -3.0F, 7.0F, 6.0F, 4.0F, true).build(), JsonPose.offset(0.0F, 15.0F, 0.0F));
        builder.addOrReplaceChild("back", elementBuilder -> elementBuilder.addBox(0, 21, -2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 6.0F, true).build(), JsonPose.offset(0.0F, 16.0F, 1.0F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(44, 7, -0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 14.0F, 6.5F, 0.5576792F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_front_leg", elementBuilder -> elementBuilder.addBox(40, 0, -1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, true).build(), JsonPose.offset(-1.5F, 19.0F, -2.0F));
        builder.addOrReplaceChild("right_back_leg", elementBuilder -> elementBuilder.addBox(56, 0, -1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, true).build(), JsonPose.offset(-1.5F, 19.0F, 6.0F));
        builder.addOrReplaceChild("left_front_leg", elementBuilder -> elementBuilder.addBox(32, 0, -1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, true).build(), JsonPose.offset(1.5F, 19.0F, -2.0F));
        builder.addOrReplaceChild("left_back_leg", elementBuilder -> elementBuilder.addBox(48, 0, -1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, true).build(), JsonPose.offset(1.5F, 19.0F, 6.0F));

        return builder;
    }
}
