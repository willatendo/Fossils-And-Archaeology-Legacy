package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class DimetrodonModels {
    public static final JsonModel DIMETRODON_MODEL = DimetrodonModels.createDimetrodonBodyLayer().withWalkAnimations(FAUtils.resource("dimetrodon_walk")).withHeadPieces("head").build();

    private static JsonModel.Builder createDimetrodonBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 64);

        builder.addOrReplaceChild("leg", elementBuilder -> elementBuilder.addBox(32, 21, 1.0F, -2.0F, 0.0F, 4.0F, 5.0F, 8.0F).addBox(44, 0, 2.0F, 0.0F, 8.0F, 2.0F, 3.0F, 8.0F).build(), JsonPose.offset(-3.0F, 19.0F, 7.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -1.0F, 11.0F, -7.0F, 8.0F, 7.0F, 14.0F).addBox(0, 21, 2.0F, 0.0F, -7.0F, 2.0F, 11.0F, 14.0F).addBox(32, 34, 2.0F, -2.0F, -5.0F, 2.0F, 2.0F, 10.0F).build(), JsonPose.offset(-3.0F, 4.0F, 0.0F));
        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(44, 11, -1.5F, -2.0F, -10.0F, 3.0F, 4.0F, 6.0F).addBox(44, 54, -0.5F, 2.0F, -9.0F, 1.0F, 1.0F, 4.0F).addBox(18, 46, -1.5F, -2.0F, -4.0F, 3.0F, 5.0F, 4.0F).addOrReplaceChild("jaw", subElementBuilder -> subElementBuilder.addBox(0, 46, -1.5F, 0.0F, -6.0F, 3.0F, 1.0F, 6.0F).build(), JsonPose.offset(0.0F, 2.0F, -4.0F)).build(), JsonPose.offset(0.0F, 16.0F, -7.0F));
        builder.addOrReplaceChild("left_front_leg", elementBuilder -> elementBuilder.addBox(32, 46, -2.0F, -2.0F, -1.0F, 3.0F, 5.0F, 3.0F).build(), JsonPose.offset(4.0F, 21.0F, -5.0F));
        builder.addOrReplaceChild("right_front_leg", elementBuilder -> elementBuilder.addBox(0, 53, -1.0F, -2.0F, -1.0F, 3.0F, 5.0F, 3.0F).build(), JsonPose.offset(-4.0F, 21.0F, -5.0F));
        builder.addOrReplaceChild("left_back_leg", elementBuilder -> elementBuilder.addBox(44, 46, -2.0F, -2.0F, -1.0F, 3.0F, 5.0F, 3.0F).build(), JsonPose.offset(4.0F, 21.0F, 4.0F));
        builder.addOrReplaceChild("right_back_leg", elementBuilder -> elementBuilder.addBox(32, 54, -1.0F, -2.0F, -1.0F, 3.0F, 5.0F, 3.0F).build(), JsonPose.offset(-4.0F, 21.0F, 4.0F));

        return builder;
    }
}
