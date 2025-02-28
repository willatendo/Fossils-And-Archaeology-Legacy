package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;

public final class IchthyosaurusModels {
    public static final JsonModel ICHTHYOSAURUS_MODEL = IchthyosaurusModels.createIchthyosaurusBodyLayer().withHeadPieces("head").build();

    public static JsonModel.Builder createIchthyosaurusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 64);

        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(0, 32, -1.5F, 0.0F, -12.0F, 3.0F, 3.0F, 6.0F).addBox(0, 20, -3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F).build(), JsonPose.offset(0.0F, 20.0F, -7.0F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(24, 31, -2.0F, -2.0F, 5.0F, 4.0F, 4.0F, 6.0F).addBox(40, 0, -1.0F, -5.0F, 9.0F, 2.0F, 10.0F, 3.0F).addBox(24, 20, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 5.0F).build(), JsonPose.offset(0.0F, 20.0F, 5.0F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(0, 41, 0.0F, -1.0F, -1.0F, 6.0F, 2.0F, 3.0F).build(), JsonPose.offset(4.0F, 23.0F, -5.0F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(40, 13, -6.0F, -1.0F, -1.0F, 6.0F, 2.0F, 3.0F).build(), JsonPose.offset(-4.0F, 23.0F, -5.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(32, 41, 0.0F, -1.0F, -1.0F, 4.0F, 1.0F, 3.0F).build(), JsonPose.offset(4.0F, 24.0F, 2.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(18, 41, -4.0F, -1.0F, -1.0F, 4.0F, 1.0F, 3.0F).build(), JsonPose.offset(-4.0F, 24.0F, 2.0F));
        builder.addOrReplaceChild("bb_main", elementBuilder -> elementBuilder.addBox(0, 0, -4.0F, -8.0F, -7.0F, 8.0F, 8.0F, 12.0F).addBox(44, 31, -1.0F, -12.0F, 0.0F, 2.0F, 4.0F, 3.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }
}
