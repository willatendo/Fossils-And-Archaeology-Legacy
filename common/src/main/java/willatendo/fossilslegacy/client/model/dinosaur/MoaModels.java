package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class MoaModels {
    public static final JsonModel MOA_MODEL = MoaModels.createMoaBodyLayer().withWalkAnimations(FAUtils.resource("moa_walk")).withHeadPieces("neck").build();

    private static JsonModel.Builder createMoaBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 64);

        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(18, 43, -2.0F, 3.0F, -0.5F, 2.0F, 5.0F, 2.0F).addBox(34, 36, -2.0F, -1.0F, -1.5F, 2.0F, 4.0F, 3.0F).build(), JsonPose.offset(-1.0F, 16.0F, 1.5F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(24, 36, -1.0F, -1.0F, -1.5F, 2.0F, 4.0F, 3.0F).addBox(10, 42, -1.0F, 3.0F, -0.5F, 2.0F, 5.0F, 2.0F).build(), JsonPose.offset(2.0F, 16.0F, 1.5F));
        builder.addOrReplaceChild("neck", elementBuilder -> elementBuilder.addBox(34, 0, -1.0F, -13.0F, -2.5F, 2.0F, 15.0F, 3.0F).addOrReplaceChild("head", subElementBuilder -> subElementBuilder.addBox(34, 18, -2.0F, -3.0F, -3.25F, 4.0F, 4.0F, 4.0F).addBox(0, 42, -1.0F, -2.0F, -6.25F, 2.0F, 2.0F, 3.0F).build(), JsonPose.offset(0.0F, -12.0F, -1.25F)).build(), JsonPose.offset(0.0F, 9.0F, -4.5F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 17, -4.0F, -9.0F, -5.0F, 8.0F, 2.0F, 9.0F).addBox(0, 28, -3.0F, -16.0F, 3.0F, 6.0F, 8.0F, 6.0F).addBox(0, 0, -4.0F, -17.0F, -5.0F, 8.0F, 8.0F, 9.0F).addBox(24, 28, -3.0F, -8.0F, 3.0F, 6.0F, 2.0F, 6.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }
}