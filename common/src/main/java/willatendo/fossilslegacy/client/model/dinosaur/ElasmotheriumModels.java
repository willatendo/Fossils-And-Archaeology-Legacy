package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;

public final class ElasmotheriumModels {
    public static final JsonModel ELASMOTHERIUM_MODEL = ElasmotheriumModels.createElasmotheriumBodyLayer().withHeadPieces("head").build();

    private static JsonModel.Builder createElasmotheriumBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(128, 128);

        builder.addOrReplaceChild("back_left_leg", elementBuilder -> elementBuilder.addBox(32, 48, -2.0F, -4.0F, -2.0F, 3.0F, 8.0F, 5.0F).addBox(58, 0, -2.0F, 4.0F, 0.0F, 3.0F, 4.0F, 3.0F).build(), JsonPose.offset(4.0F, 16.0F, 11.0F));
        builder.addOrReplaceChild("front_left_leg", elementBuilder -> elementBuilder.addBox(52, 37, -3.0F, 4.0F, -2.0F, 4.0F, 7.0F, 4.0F).addBox(0, 43, -1.0F, -4.0F, -3.0F, 2.0F, 8.0F, 6.0F).build(), JsonPose.offset(5.0F, 13.0F, -1.0F));
        builder.addOrReplaceChild("front_right_leg", elementBuilder -> elementBuilder.addBox(0, 57, -1.0F, 4.0F, -2.0F, 4.0F, 7.0F, 4.0F).addBox(16, 43, -1.0F, -4.0F, -3.0F, 2.0F, 8.0F, 6.0F).build(), JsonPose.offset(-5.0F, 13.0F, -1.0F));
        builder.addOrReplaceChild("back_right_leg", elementBuilder -> elementBuilder.addBox(60, 21, -1.0F, 4.0F, 0.0F, 3.0F, 4.0F, 3.0F).addBox(48, 48, -1.0F, -4.0F, -2.0F, 3.0F, 8.0F, 5.0F).build(), JsonPose.offset(-4.0F, 16.0F, 11.0F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(16, 57, -1.0F, -2.0F, -1.0F, 2.0F, 10.0F, 2.0F).build(), JsonPose.offset(0.0F, 13.0F, 16.0F));
        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(32, 37, -3.0F, -2.0F, 0.0F, 6.0F, 7.0F, 4.0F).addBox(36, 12, -2.0F, 0.0F, -3.0F, 4.0F, 5.0F, 3.0F).addBox(50, 12, -1.0F, -5.0F, -2.0F, 2.0F, 5.0F, 4.0F).build(), JsonPose.offset(0.0F, 12.0F, -12.0F));
        builder.addOrReplaceChild("bb_main", elementBuilder -> elementBuilder.addBox(0, 22, -4.0F, -18.0F, -5.0F, 8.0F, 13.0F, 8.0F).addBox(0, 0, -3.0F, -15.0F, 3.0F, 6.0F, 10.0F, 12.0F).addBox(36, 0, -4.0F, -16.0F, -8.0F, 8.0F, 9.0F, 3.0F).addBox(32, 22, -2.0F, -20.0F, -3.0F, 4.0F, 5.0F, 10.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }
}
