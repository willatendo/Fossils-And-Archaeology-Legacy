package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class MosasaurusModels {
    public static final JsonModel MOSASAURUS_MODEL = MosasaurusModels.createMosasaurusBodyLayer(FAUtils.resource("mosasaurus")).withWalkAnimations(FAUtils.resource("mosasaurus_walk")).withSwimAnimations(FAUtils.resource("mosasaurus_swim")).withHeadPieces("head").build();
    public static final JsonModel MOSASAURUS_LEGACY_MODEL = MosasaurusModels.createLegacyMosasaurusBodyLayer(FAUtils.resource("legacy_mosasaurus")).withWalkAnimations(BuiltInAnimationTypes.LEGACY_MOSASAURUS_SWIM.getId()).withSwimAnimations(BuiltInAnimationTypes.LEGACY_MOSASAURUS_SWIM.getId()).build();

    private static JsonModel.Builder createMosasaurusBodyLayer(ResourceLocation modelId) {
        JsonModel.Builder builder = JsonModel.builder(modelId, 128, 128);

        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(36, 35, -3.0F, -3.0F, 0.0F, 6.0F, 7.0F, 7.0F).addBox(38, 0, -2.0F, 2.0F, 5.0F, 4.0F, 5.0F, 9.0F).addBox(0, 51, -2.0F, -6.0F, 5.0F, 4.0F, 8.0F, 5.0F).build(), JsonPose.offset(0.0F, 16.0F, 9.0F));
        builder.addOrReplaceChild("left_front_flipper", elementBuilder -> elementBuilder.addBox(52, 49, 0.0F, -2.0F, -1.0F, 2.0F, 5.0F, 7.0F).build(), JsonPose.offset(5.0F, 21.0F, -7.0F));
        builder.addOrReplaceChild("right_front_flipper", elementBuilder -> elementBuilder.addBox(18, 58, -2.0F, -2.0F, -1.0F, 2.0F, 5.0F, 7.0F).build(), JsonPose.offset(-5.0F, 21.0F, -7.0F));
        builder.addOrReplaceChild("left_back_flipper", elementBuilder -> elementBuilder.addBox(62, 35, -1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 6.0F).build(), JsonPose.offset(5.0F, 21.0F, 5.0F));
        builder.addOrReplaceChild("right_back_flipper", elementBuilder -> elementBuilder.addBox(0, 64, -1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 6.0F).build(), JsonPose.offset(-5.0F, 21.0F, 5.0F));
        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(36, 20, -4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 7.0F).addBox(0, 40, -3.0F, -3.0F, -14.0F, 6.0F, 4.0F, 7.0F).addBox(56, 61, -2.0F, 1.0F, -13.0F, 4.0F, 1.0F, 6.0F).addOrReplaceChild("jaw", subElementBuilder -> subElementBuilder.addBox(26, 49, -3.0F, -1.0F, -7.0F, 6.0F, 2.0F, 7.0F).addBox(36, 61, -2.0F, -2.0F, -6.0F, 4.0F, 1.0F, 6.0F).build(), JsonPose.offset(0.0F, 2.0F, -7.0F)).build(), JsonPose.offset(0.0F, 18.0F, -10.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -5.0F, -11.0F, -10.0F, 10.0F, 11.0F, 9.0F).addBox(0, 20, -4.0F, -11.0F, -1.0F, 8.0F, 10.0F, 10.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }

    private static JsonModel.Builder createLegacyMosasaurusBodyLayer(ResourceLocation modelId) {
        JsonModel.Builder builder = JsonModel.builder(modelId, 64, 32);

        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(0, 24, -3.0F, -2.0F, -4.0F, 6.0F, 4.0F, 4.0F).build(), JsonPose.offset(1.0F, 19.0F, 0.0F));
        builder.addOrReplaceChild("upper_jaw", elementBuilder -> elementBuilder.addBox(17, 22, -2.0F, -1.0F, -9.0F, 4.0F, 1.0F, 5.0F).build(), JsonPose.offset(1.0F, 19.0F, 0.0F));
        builder.addOrReplaceChild("upper_teeth", elementBuilder -> elementBuilder.addBox(0, 16, -2.0F, 0.0F, -9.0F, 4.0F, 2.F, 6.0F).build(), JsonPose.offset(1.0F, 19.0F, 0.0F));
        builder.addOrReplaceChild("lower_jaw", elementBuilder -> elementBuilder.addBox(0, 7, -1.0F, 0.0F, -8.0F, 2.0F, 2.0F, 6.0F).build(), JsonPose.offset(1.0F, 19.0F, 0.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(32, 0, -4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 8.0F).build(), JsonPose.offset(1.0F, 16.0F, 0.0F));
        builder.addOrReplaceChild("right_front_flipper", elementBuilder -> elementBuilder.addBox(0, 0, -4.0F, 0.0F, 0.0F, 4.0F, 1.0F, 6.0F).build(), JsonPose.offsetAndRotation(-3.0F, 20.0F, 0.0F, -0.34907F, -1.0472F, -0.43633F));
        builder.addOrReplaceChild("left_front_flipper", elementBuilder -> elementBuilder.addBox(0, 0, 0.0F, 0.0F, 0.0F, 4.0F, 1.0F, 6.0F).build(), JsonPose.offsetAndRotation(5.0F, 20.0F, 0.0F, -0.34907F, 1.0472F, 0.43633F));
        builder.addOrReplaceChild("right_back_flipper", elementBuilder -> elementBuilder.addBox(20, 1, -3.0F, 0.0F, 0.0F, 3.0F, 1.0F, 5.0F).build(), JsonPose.offsetAndRotation(-2.0F, 20.0F, 7.0F, -0.34907F, -0.87266F, -0.43633F));
        builder.addOrReplaceChild("left_back_flipper", elementBuilder -> elementBuilder.addBox(20, 1, 0.0F, 0.0F, 0.0F, 3.0F, 1.0F, 5.0F).build(), JsonPose.offsetAndRotation(4.0F, 20.0F, 7.0F, -0.34907F, 0.87266F, 0.43633F));
        builder.addOrReplaceChild("tail_1", elementBuilder -> elementBuilder.addBox(35, 14, -3.0F, -2.0F, -4.0F, 6.0F, 4.0F, 6.0F).build(), JsonPose.offset(1.0F, 19.0F, 11.0F));
        builder.addOrReplaceChild("tail_2", elementBuilder -> elementBuilder.addBox(36, 24, -2.0F, -1.0F, -4.0F, 4.0F, 2.0F, 6.0F).build(), JsonPose.offset(1.0F, 19.0F, 16.0F));
        builder.addOrReplaceChild("tail_2_spike", elementBuilder -> elementBuilder.addBox(26, 22, 0.0F, -3.0F, -4.0F, 1.0F, 2.0F, 6.0F).build(), JsonPose.offset(1.0F, 19.0F, 16.0F));
        builder.addOrReplaceChild("tail_3", elementBuilder -> elementBuilder.addBox(16, 8, -1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 6.0F).build(), JsonPose.offset(1.0F, 19.0F, 21.0F));
        builder.addOrReplaceChild("tail_3_spike", elementBuilder -> elementBuilder.addBox(26, 23, 0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 5.0F).build(), JsonPose.offset(1.0F, 19.0F, 20.0F));

        return builder;
    }
}
