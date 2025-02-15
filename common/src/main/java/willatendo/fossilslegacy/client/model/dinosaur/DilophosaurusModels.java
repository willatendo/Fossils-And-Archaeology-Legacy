package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class DilophosaurusModels {
    public static final JsonModel DILOPHOSAURUS_MODEL = DilophosaurusModels.createDilophosaurusBodyLayer(FAUtils.resource("dilophosaurus")).withWalkAnimations(FAUtils.resource("dilophosaurus_walk")).withHeadPieces("head").build();
    public static final JsonModel LEGACY_DILOPHOSAURUS_MODEL = DilophosaurusModels.createLegacyDilophosaurusBodyLayer(FAUtils.resource("legacy_dilophosaurus")).withWalkAnimations(BuiltInAnimationTypes.LEGACY_DILOPHOSAURUS_WALK.getId()).build();

    private static JsonModel.Builder createDilophosaurusBodyLayer(ResourceLocation modelId) {
        JsonModel.Builder builder = JsonModel.builder(modelId, 64, 64);

        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(22, 29, -2.0F, -2.0F, 0.0F, 4.0F, 5.0F, 6.0F).addBox(22, 17, -1.0F, -2.0F, 6.0F, 2.0F, 3.0F, 9.0F).build(), JsonPose.offset(0.0F, 11.0F, 5.0F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(14, 52, -1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F).build(), JsonPose.offset(2.0F, 13.0F, -8.0F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(22, 52, -1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F).build(), JsonPose.offset(-2.0F, 13.0F, -8.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(48, 0, -1.0F, 8.0F, -2.0F, 3.0F, 2.0F, 5.0F).addBox(46, 52, -1.0F, 4.0F, 1.0F, 2.0F, 4.0F, 2.0F).addBox(30, 0, -1.0F, -3.0F, -3.0F, 3.0F, 7.0F, 6.0F).build(), JsonPose.offset(3.0F, 14.0F, 1.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(44, 21, -2.0F, 8.0F, -2.0F, 3.0F, 2.0F, 5.0F).addBox(48, 7, -1.0F, 4.0F, 1.0F, 2.0F, 4.0F, 2.0F).addBox(0, 30, -2.0F, -3.0F, -3.0F, 3.0F, 7.0F, 6.0F).build(), JsonPose.offset(-3.0F, 14.0F, 1.0F));
        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(0, 43, 0.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F).addBox(42, 29, 0.0F, -5.0F, -11.0F, 4.0F, 3.0F, 6.0F).addBox(0, 52, 0.0F, -5.0F, -5.0F, 4.0F, 5.0F, 3.0F).addBox(30, 52, -4.0F, -6.0F, -2.0F, 4.0F, 7.0F, 0.0F).addBox(38, 52, 4.0F, -6.0F, -2.0F, 4.0F, 7.0F, 0.0F).addBox(18, 40, 3.0F, -8.0F, -11.0F, 0.0F, 3.0F, 9.0F).addBox(36, 40, 1.0F, -8.0F, -11.0F, 0.0F, 3.0F, 9.0F).addOrReplaceChild("jaw", subElementBuilder -> subElementBuilder.addBox(44, 13, -2.0F, 0.0F, -6.0F, 4.0F, 2.0F, 6.0F).build(), JsonPose.offset(2.0F, -2.0F, -5.0F)).build(), JsonPose.offset(-2.0F, 9.0F, -9.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -3.0F, -15.0F, -4.0F, 6.0F, 8.0F, 9.0F).addBox(0, 17, -2.0F, -15.0F, -11.0F, 4.0F, 6.0F, 7.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }

    private static JsonModel.Builder createLegacyDilophosaurusBodyLayer(ResourceLocation modelId) {
        JsonModel.Builder builder = JsonModel.builder(modelId, 64, 32);

        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(0, 20, -3.0F, 0.0F, -6.0F, 6.0F, 6.0F, 6.0F, true).build(), JsonPose.offset(0.0F, 4.0F, -10.0F));
        builder.addOrReplaceChild("snout", elementBuilder -> elementBuilder.addBox(0, 0, -2.0F, 0.0F, -12.0F, 4.0F, 4.0F, 6.0F, true).build(), JsonPose.offset(0.0F, 4.0F, -10.0F));
        builder.addOrReplaceChild("jaw", elementBuilder -> elementBuilder.addBox(1, 10, -1.5F, 4.0F, -11.0F, 3.0F, 1.0F, 7.0F, true).build(), JsonPose.offset(0.0F, 4.0F, -10.0F));
        builder.addOrReplaceChild("crest_right", elementBuilder -> elementBuilder.addBox(18, 11, -2.0F, -4.0F, -10.0F, 0.0F, 4.0F, 10.0F, true).build(), JsonPose.offset(0.0F, 4.0F, -10.0F));
        builder.addOrReplaceChild("crest_left", elementBuilder -> elementBuilder.addBox(18, 11, 2.0F, -4.0F, -10.0F, 0.0F, 4.0F, 10.0F, true).build(), JsonPose.offset(0.0F, 4.0F, -10.0F));
        builder.addOrReplaceChild("spike_right", elementBuilder -> elementBuilder.addBox(16, -5, 0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 5.0F, true).build(), JsonPose.offsetAndRotation(-3.0F, 4.0F, -10.0F, 0.0F, -0.5235988F, 0.0F));
        builder.addOrReplaceChild("spike_left", elementBuilder -> elementBuilder.addBox(16, -5, 0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 5.0F, true).build(), JsonPose.offsetAndRotation(3.0F, 4.0F, -10.0F, 0.0F, 0.5235988F, 0.0F));
        builder.addOrReplaceChild("hood_right", elementBuilder -> elementBuilder.addBox(24, 27, -1.0F, 3.0F, 0.0F, 9.0F, 5.0F, 0.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 4.0F, -10.0F, 0.0F, 3.141593F, -1.570796F));
        builder.addOrReplaceChild("hood_left", elementBuilder -> elementBuilder.addBox(24, 27, -1.0F, 3.0F, 0.0F, 9.0F, 5.0F, 0.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 4.0F, -10.0F, 0.0F, 0.0F, 1.570796F));
        builder.addOrReplaceChild("neck", elementBuilder -> elementBuilder.addBox(42, 21, -2.0F, -1.5F, -7.0F, 4.0F, 4.0F, 7.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 10.0F, -6.0F, -0.7063936F, 0.0F, 0.0F));
        builder.addOrReplaceChild("upper_body", elementBuilder -> elementBuilder.addBox(40, 0, -3.0F, -3.0F, -6.5F, 6.0F, 6.0F, 6.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 11.5F, -1.0F, -0.2602438F, 0.0F, 0.0F));
        builder.addOrReplaceChild("lower_body", elementBuilder -> elementBuilder.addBox(32, 5, -4.0F, -0.5F, -4.5F, 8.0F, 8.0F, 8.0F, true).build(), JsonPose.offset(0.0F, 9.0F, 2.0F));
        builder.addOrReplaceChild("tail_base", elementBuilder -> elementBuilder.addBox(44, 0, -2.0F, -0.5F, 0.0F, 4.0F, 4.0F, 6.0F, true).build(), JsonPose.offset(0.0F, 9.0F, 5.5F));
        builder.addOrReplaceChild("tail_end", elementBuilder -> elementBuilder.addBox(36, 0, -1.0F, -0.5F, 0.0F, 2.0F, 2.0F, 12.0F, true).build(), JsonPose.offset(0.0F, 10.0F, 11.5F));
        builder.addOrReplaceChild("right_thigh", elementBuilder -> elementBuilder.addBox(24, 2, 0.0F, -1.5F, -2.5F, 3.0F, 5.0F, 5.0F, true).build(), JsonPose.offset(4.0F, 13.0F, 3.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(24, 12, 0.0F, 2.0F, 2.0F, 2.0F, 7.0F, 2.0F, true).build(), JsonPose.offsetAndRotation(4.0F, 13.0F, 3.0F, -0.3717861F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_foot", elementBuilder -> elementBuilder.addBox(35, 21, 0.0F, 9.0F, -3.0F, 3.0F, 2.0F, 4.0F, true).build(), JsonPose.offset(4.0F, 13.0F, 3.0F));
        builder.addOrReplaceChild("left_thigh", elementBuilder -> elementBuilder.addBox(24, 2, -3.0F, -1.5F, -2.5F, 3.0F, 5.0F, 5.0F, true).build(), JsonPose.offset(-4.0F, 13.0F, 3.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(24, 12, -2.0F, 2.0F, 2.0F, 2.0F, 7.0F, 2.0F, true).build(), JsonPose.offsetAndRotation(-4.0F, 13.0F, 3.0F, -0.3717861F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_foot", elementBuilder -> elementBuilder.addBox(35, 21, -3.0F, 9.0F, -3.0F, 3.0F, 2.0F, 4.0F, true).build(), JsonPose.offset(-4.0F, 13.0F, 3.0F));
        builder.addOrReplaceChild("right_biceps", elementBuilder -> elementBuilder.addBox(14, 10, 0.0F, -1.0F, -2.0F, 2.0F, 3.0F, 3.0F, true).build(), JsonPose.offset(3.0F, 11.0F, -5.5F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(0, 10, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, true).build(), JsonPose.offsetAndRotation(4.0F, 11.5F, -5.5F, -0.2602503F, 0F, 0F));
        builder.addOrReplaceChild("left_biceps", elementBuilder -> elementBuilder.addBox(14, 10, -2.0F, -1.0F, -2.0F, 2.0F, 3.0F, 3.0F, true).build(), JsonPose.offset(-3.0F, 11.0F, -5.5F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(0, 10, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, true).build(), JsonPose.offsetAndRotation(-4.0F, 11.5F, -5.5F, -0.2602503F, 0F, 0F));

        return builder;
    }
}
