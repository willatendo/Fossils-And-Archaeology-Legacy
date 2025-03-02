package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FutabasaurusModels {
    public static final JsonModel FUTABASAURUS_MODEL = FutabasaurusModels.createFutabasaurusBodyLayer().withWalkAnimations(FAUtils.resource("futabasaurus_walk")).withSwimAnimations(FAUtils.resource("futabasaurus_swim")).withHeadPieces("neck", "middle_neck", "head").build();
    public static final JsonModel LEGACY_FUTABASAURUS_MODEL = FutabasaurusModels.createLegacyFutabasaurusBodyLayer().withWalkAnimations(BuiltInAnimationTypes.LEGACY_FUTABASAURUS_SWIM.getId()).withSwimAnimations(BuiltInAnimationTypes.LEGACY_FUTABASAURUS_SWIM.getId()).overrideReset().build();

    private static JsonModel.Builder createFutabasaurusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 64);

        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(35, 33, -3.0F, -6.0F, -11.0F, 6.0F, 5.0F, 5.0F).addBox(0, 0, -2.0F, -5.0F, -6.0F, 4.0F, 3.0F, 4.0F).build(), JsonPose.offset(0.0F, 24.0F, 17.0F));
        builder.addOrReplaceChild("neck", elementBuilder -> elementBuilder.addBox(24, 0, -3.0F, -2.5F, -10.0F, 6.0F, 5.0F, 10.0F).addOrReplaceChild("middle_neck", subElement1Builder -> subElement1Builder.addBox(0, 0, -2.0F, -1.5F, -16.0F, 4.0F, 3.0F, 16.0F).addOrReplaceChild("head", subElement2Builder -> subElement2Builder.addBox(32, 15, -3.0F, -2.5F, -8.0F, 6.0F, 5.0F, 8.0F).build(), JsonPose.offset(0.0F, 0.0F, -16.0F)).build(), JsonPose.offset(0.0F, 0.0F, -10.0F)).build(), JsonPose.offset(0.0F, 20.5F, -6.0F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(0, 38, -5.0F, -1.0F, -2.0F, 5.0F, 2.0F, 4.0F).build(), JsonPose.offset(-4.0F, 23.0F, -3.0F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(32, 43, 0.0F, -1.0F, -2.0F, 5.0F, 2.0F, 4.0F).build(), JsonPose.offset(4.0F, 23.0F, -3.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(18, 39, -5.0F, -1.0F, -2.0F, 5.0F, 2.0F, 4.0F).build(), JsonPose.offset(-4.0F, 23.0F, 3.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(0, 44, 0.0F, -1.0F, -2.0F, 5.0F, 2.0F, 4.0F).build(), JsonPose.offset(4.0F, 23.0F, 3.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 19, -4.0F, -7.0F, -6.0F, 8.0F, 7.0F, 12.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }

    private static JsonModel.Builder createLegacyFutabasaurusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 32);

        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(0, 22, -2.0F, -2.0F, -6.0F, 4.0F, 4.0F, 6.0F).build(), JsonPose.offsetAndRotation(0.0F, 9.0F, -15.0F, 0.49723F, 0.0F, 0.0F));
        builder.addOrReplaceChild("neck_1", elementBuilder -> elementBuilder.addBox(20, 23, -3.0F, 0.0F, -4.0F, 6.0F, 5.0F, 4.0F).build(), JsonPose.offsetAndRotation(0.0F, 17.0F, 0.0F, -0.99446F, 0.0F, 0.0F));
        builder.addOrReplaceChild("neck_2", elementBuilder -> elementBuilder.addBox(47, 23, -2.0F, -2.0F, -6.0F, 4.0F, 4.0F, 5.0F).build(), JsonPose.offsetAndRotation(0.0F, 16.0F, -4.0F, -0.88974F, 0.0F, 0.0F));
        builder.addOrReplaceChild("neck_3", elementBuilder -> elementBuilder.addBox(35, 3, -1.0F, -2.0F, -5.0F, 2.0F, 3.0F, 5.0F).build(), JsonPose.offsetAndRotation(0.0F, 12.73333F, -8.0F, -0.58764F, 0.0F, 0.0F));
        builder.addOrReplaceChild("neck_4", elementBuilder -> elementBuilder.addBox(35, 3, -1.0F, -2.0F, -5.0F, 2.0F, 3.0F, 5.0F).build(), JsonPose.offsetAndRotation(0.0F, 10.0F, -11.0F, -0.13561F, 0.0F, 0.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -4.0F, -4.0F, -4.0F, 8.0F, 6.0F, 8.0F).build(), JsonPose.offset(0.0F, 20.0F, 0.0F));
        builder.addOrReplaceChild("front_right_flipper", elementBuilder -> elementBuilder.addBox(44, 13, 0.0F, 0.0F, 0.0F, 6.0F, 1.0F, 4.0F).build(), JsonPose.offsetAndRotation(-3.0F, 21.0F, -3.0F, -0.5236F, -2.35619F, 0.0F));
        builder.addOrReplaceChild("front_left_flipper", elementBuilder -> elementBuilder.addBox(44, 18, 0.0F, 0.0F, -4.0F, 6.0F, 1.0F, 4.0F).build(), JsonPose.offsetAndRotation(3.0F, 21.0F, -3.0F, 0.5236F, -0.7854F, 0.0F));
        builder.addOrReplaceChild("back_right_flipper", elementBuilder -> elementBuilder.addBox(48, 0, 0.0F, 0.0F, 0.0F, 5.0F, 1.0F, 3.0F).build(), JsonPose.offsetAndRotation(-3.0F, 21.0F, 4.0F, -0.5236F, -2.0944F, 0.0F));
        builder.addOrReplaceChild("back_left_flipper", elementBuilder -> elementBuilder.addBox(48, 4, 0.0F, 0.0F, -3.0F, 5.0F, 1.0F, 3.0F).build(), JsonPose.offsetAndRotation(3.0F, 21.0F, 4.0F, 0.5236F, -1.0472F, 0.0F));
        builder.addOrReplaceChild("tail_1", elementBuilder -> elementBuilder.addBox(0, 14, -3.0F, -5.0F, 2.0F, 6.0F, 5.0F, 3.0F).build(), JsonPose.offsetAndRotation(0.0F, 20.0F, 0.0F, -0.45203F, 0.0F, 0.0F));
        builder.addOrReplaceChild("tail_2", elementBuilder -> elementBuilder.addBox(18, 14, -2.0F, -2.0F, 0.0F, 4.0F, 3.0F, 6.0F).build(), JsonPose.offsetAndRotation(0.0F, 20.0F, 5.0F, -0.27122F, 0.0F, 0.0F));
        builder.addOrReplaceChild("tail_3", elementBuilder -> elementBuilder.addBox(24, 0, -1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F).build(), JsonPose.offsetAndRotation(0.0F, 21.0F, 11.0F, -0.18081F, 0.0F, 0.0F));

        return builder;
    }
}