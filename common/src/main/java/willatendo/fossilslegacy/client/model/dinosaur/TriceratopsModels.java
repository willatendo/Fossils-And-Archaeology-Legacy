package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class TriceratopsModels {
    public static final JsonModel TRICERATOPS_MODEL = TriceratopsModels.createTriceratopsBodyLayer().withWalkAnimations(FAUtils.resource("triceratops_walk")).withSleepAnimations(FAUtils.resource("triceratops_sleep")).withHeadPieces("head").build();
    public static final JsonModel LEGACY_TRICERATOPS_MODEL = TriceratopsModels.createLegacyTriceratopsBodyLayer().withWalkAnimations(BuiltInAnimationTypes.LEGACY_TRICERATOPS_WALK.getId()).build();

    private static JsonModel.Builder createTriceratopsBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(128, 128);

        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(50, 62, -1.0F, 4.0F, -2.0F, 3.0F, 6.0F, 4.0F).addBox(50, 49, -2.0F, -3.0F, -3.0F, 3.0F, 7.0F, 6.0F).build(), JsonPose.offset(-5.0F, 14.0F, 4.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(50, 62, -2.0F, 4.0F, -2.0F, 3.0F, 6.0F, 4.0F).addBox(50, 49, -1.0F, -3.0F, -3.0F, 3.0F, 7.0F, 6.0F, true).build(), JsonPose.offset(5.0F, 14.0F, 4.0F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(0, 50, -2.5F, -4.0F, 0.0F, 5.0F, 9.0F, 5.0F).addBox(0, 36, -2.0F, 0.0F, 5.0F, 4.0F, 5.0F, 9.0F).addBox(38, 0, -2.0F, -5.0F, 6.0F, 4.0F, 5.0F, 9.0F).build(), JsonPose.offset(0.0F, 14.0F, 7.0F));
        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(30, 35, -3.5F, -3.6667F, -6.2111F, 7.0F, 7.0F, 7.0F).addBox(0, 22, -6.5F, -9.6667F, -1.2111F, 13.0F, 12.0F, 2.0F).addBox(30, 22, -7.5F, -10.6667F, -1.3111F, 15.0F, 13.0F, 0.0F).addBox(38, 14, -1.5F, -0.6667F, -9.2111F, 3.0F, 4.0F, 3.0F).addBox(26, 36, 0.0F, -2.6667F, -9.2111F, 0.0F, 2.0F, 2.0F).addBox(60, 28, -3.5F, -6.6667F, -6.2111F, 1.0F, 2.0F, 5.0F).addBox(20, 63, -3.5F, -6.6667F, -11.2111F, 1.0F, 2.0F, 5.0F).addBox(60, 28, 2.5F, -6.6667F, -6.2111F, 1.0F, 2.0F, 5.0F).addBox(20, 63, 2.5F, -6.6667F, -11.2111F, 1.0F, 2.0F, 5.0F).build(), JsonPose.offset(0.0F, 14.6667F, -8.7889F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(58, 35, -1.5F, -3.0F, -1.5F, 3.0F, 11.0F, 3.0F).build(), JsonPose.offset(-4.5F, 16.0F, -5.5F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(60, 14, -1.5F, -3.0F, -1.5F, 3.0F, 11.0F, 3.0F).build(), JsonPose.offset(4.5F, 16.0F, -5.5F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -4.0F, -16.0F, -4.0F, 8.0F, 11.0F, 11.0F).addBox(26, 49, -4.0F, -15.0F, -8.0F, 8.0F, 10.0F, 4.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }

    private static JsonModel.Builder createLegacyTriceratopsBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 32);

        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(42, 0, -3.0F, -3.0F, -2.0F, 6.0F, 5.0F, 5.0F).build(), JsonPose.offset(0.0F, 20.0F, -1.0F));
        builder.addOrReplaceChild("lower_body", elementBuilder -> elementBuilder.addBox(48, 10, -2.5F, -0.2F, 0.0F, 5.0F, 4.0F, 3.0F).build(), JsonPose.offsetAndRotation(0.0F, 18.0F, 2.0F, -0.2712F, 0.0F, 0.0F));
        builder.addOrReplaceChild("back", elementBuilder -> elementBuilder.addBox(54, 17, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F, 2.0F).build(), JsonPose.offsetAndRotation(0.0F, 18.0F, 2.0F, -0.4519F, 0.0F, 0.0F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(54, 21, -1.0F, 2.0F, 4.0F, 2.0F, 1.0F, 3.0F).build(), JsonPose.offsetAndRotation(0.0F, 18.0F, 2.0F, -0.1808F, 0.0F, 0.0F));
        builder.addOrReplaceChild("crest", elementBuilder -> elementBuilder.addBox(20, 0, -4.0F, -8.0F, 0.0F, 8.0F, 7.0F, 1.0F).build(), JsonPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -0.4F, 0.0F, 0.0F));
        builder.addOrReplaceChild("crest_overlay", elementBuilder -> elementBuilder.addBox(20, 8, -5.0F, -9.0F, 0.0F, 10.0F, 8.0F, 1.0F).build(), JsonPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -0.4F, 0.0F, 0.0F));
        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(0, 0, -2.0F, -3.0F, -2.0F, 4.0F, 4.0F, 6.0F).build(), JsonPose.offsetAndRotation(0.0F, 21.0F, -5.0F, 0.1396F, 0.0F, 0.0F));
        builder.addOrReplaceChild("mouth", elementBuilder -> elementBuilder.addBox(0, 10, -1F, -2.5F, -3.0F, 2.0F, 3.0F, 3.0F).build(), JsonPose.offsetAndRotation(0.0F, 21.0F, -5.0F, 0.81364F, 0.0F, 0.0F));
        builder.addOrReplaceChild("nose_horn", elementBuilder -> elementBuilder.addBox(24, 24, -0.5F, 2.0F, -3.0F, 1.0F, 1.0F, 2.0F).build(), JsonPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -1.13F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_horn_base", elementBuilder -> elementBuilder.addBox(24, 27, -2.0F, -4.0F, -3.0F, 1.0F, 1.0F, 4.0F).build(), JsonPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -0.31642F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_horn", elementBuilder -> elementBuilder.addBox(33, 27, -2.0F, -4.0F, -6.0F, 1.0F, 1.0F, 4.0F).build(), JsonPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -0.31642F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_horn_base", elementBuilder -> elementBuilder.addBox(24, 27, 1.0F, -4.0F, -3.0F, 1.0F, 1.0F, 4.0F).build(), JsonPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -0.31642F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_horn", elementBuilder -> elementBuilder.addBox(33, 27, 1.0F, -4.0F, -6.0F, 1.0F, 1.0F, 4.0F).build(), JsonPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -0.31642F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_front_thigh", elementBuilder -> elementBuilder.addBox(0, 20, -4.0F, 1.0F, -2.0F, 2.0F, 2.0F, 2.0F).build(), JsonPose.offset(0.0F, 19.0F, -2.0F));
        builder.addOrReplaceChild("right_front_leg", elementBuilder -> elementBuilder.addBox(8, 19, -3.0F, 1.0F, -6.0F, 1.0F, 2.0F, 3.0F).build(), JsonPose.offsetAndRotation(0.0F, 18.0F, -2.0F, 1.0F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_front_thigh", elementBuilder -> elementBuilder.addBox(0, 16, 2.0F, 2.0F, -2.0F, 2.0F, 2.0F, 2.0F).build(), JsonPose.offset(0.0F, 18.0F, -2.0F));
        builder.addOrReplaceChild("left_front_leg", elementBuilder -> elementBuilder.addBox(16, 19, 2.0F, 1.0F, -6.0F, 1.0F, 2.0F, 3.0F).build(), JsonPose.offsetAndRotation(0.0F, 18.0F, -2.0F, 1.0F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_back_thigh", elementBuilder -> elementBuilder.addBox(0, 24, -4.0F, 0.0F, -2.0F, 2.0F, 4.0F, 4.0F).build(), JsonPose.offset(0.0F, 18.0F, 2.0F));
        builder.addOrReplaceChild("right_back_leg", elementBuilder -> elementBuilder.addBox(24, 19, -3.0F, 2.0F, -5.0F, 1.0F, 2.0F, 3.0F).build(), JsonPose.offsetAndRotation(0.0F, 18.0F, 2.0F, 1.0F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_back_thigh", elementBuilder -> elementBuilder.addBox(12, 24, 2.0F, 0.0F, -2.0F, 2.0F, 4.0F, 4.0F).build(), JsonPose.offset(0.0F, 18.0F, 2.0F));
        builder.addOrReplaceChild("left_back_leg", elementBuilder -> elementBuilder.addBox(32, 19, 2.0F, 2.0F, -5.0F, 1.0F, 2.0F, 3.0F).build(), JsonPose.offsetAndRotation(0.0F, 18.0F, 2.0F, 1.0F, 0.0F, 0.0F));

        return builder;
    }
}