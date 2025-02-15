package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class SpinosaurusModels {
    public static final JsonModel SPINOSAURUS_MODEL = SpinosaurusModels.createSpinosaurusBodyLayer().withWalkAnimations(FAUtils.resource("spinosaurus_walk")).withSwimAnimations(FAUtils.resource("spinosaurus_swim")).withHeadPieces("neck").build();

    private static JsonModel.Builder createSpinosaurusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(128, 128);

        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(74, 34, -1.0F, 2.0F, 0.0F, 1.0F, 6.0F, 2.0F).addBox(56, 69, -1.0F, -2.0F, -2.0F, 2.0F, 7.0F, 3.0F).build(), JsonPose.offset(3.0F, 13.0F, -8.0F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(66, 69, -1.0F, -2.0F, -2.0F, 2.0F, 7.0F, 3.0F).addBox(74, 42, 0.0F, 2.0F, 0.0F, 1.0F, 6.0F, 2.0F).build(), JsonPose.offset(-3.0F, 13.0F, -8.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(62, 15, -1.0F, -3.0F, -3.0F, 3.0F, 7.0F, 5.0F).addBox(38, 72, -1.0F, 2.0F, 1.0F, 2.0F, 6.0F, 2.0F).addBox(22, 65, -1.0F, 8.0F, -1.0F, 3.0F, 2.0F, 4.0F).build(), JsonPose.offset(3.0F, 14.0F, 3.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(0, 69, -2.0F, 8.0F, -1.0F, 3.0F, 2.0F, 4.0F).addBox(46, 72, -1.0F, 2.0F, 1.0F, 2.0F, 6.0F, 2.0F).addBox(62, 50, -2.0F, -3.0F, -3.0F, 3.0F, 7.0F, 5.0F).build(), JsonPose.offset(-3.0F, 14.0F, 3.0F));
        builder.addOrReplaceChild("neck", elementBuilder -> elementBuilder.addBox(60, 0, -2.0F, -7.0F, -4.0F, 4.0F, 11.0F, 4.0F).addOrReplaceChild("head", subElement1Builder -> subElement1Builder.addBox(42, 64, -2.0F, -2.0F, -3.0F, 4.0F, 5.0F, 3.0F).addBox(0, 59, -2.0F, -2.0F, -10.0F, 4.0F, 3.0F, 7.0F).addBox(22, 46, -0.5F, -3.0F, -5.0F, 1.0F, 1.0F, 4.0F).addBox(62, 62, -1.0F, 1.0F, -9.0F, 2.0F, 1.0F, 6.0F).addOrReplaceChild("jaw", subElement2Builder -> subElement2Builder.addBox(62, 27, -1.0F, -2.0F, -6.0F, 2.0F, 1.0F, 6.0F).addBox(36, 12, -2.0F, -1.0F, -7.0F, 4.0F, 2.0F, 7.0F).build(), JsonPose.offset(0.0F, 2.0F, -3.0F)).build(), JsonPose.offset(0.0F, -5.0F, -4.0F)).build(), JsonPose.offset(0.0F, 12.0F, -11.0F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(36, 0, -2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 8.0F).addBox(32, 21, -1.0F, -2.0F, 8.0F, 2.0F, 3.0F, 13.0F).addBox(22, 51, -0.5F, -7.0F, 0.0F, 1.0F, 5.0F, 9.0F).addBox(42, 51, -0.5F, 1.0F, 0.0F, 1.0F, 4.0F, 9.0F).addBox(0, 46, -0.5F, 1.0F, 9.0F, 1.0F, 3.0F, 10.0F).addBox(32, 37, -0.5F, -6.0F, 9.0F, 1.0F, 4.0F, 10.0F).build(), JsonPose.offset(0.0F, 12.0F, 7.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -3.0F, -16.0F, -5.0F, 6.0F, 9.0F, 12.0F).addBox(56, 64, -0.5F, -18.0F, 5.0F, 1.0F, 2.0F, 2.0F).addBox(0, 21, -0.5F, -25.0F, -10.0F, 1.0F, 10.0F, 15.0F).addBox(14, 71, -0.5F, -27.0F, -1.0F, 1.0F, 2.0F, 5.0F).addBox(26, 71, -0.5F, -26.0F, -8.0F, 1.0F, 1.0F, 5.0F).addBox(54, 37, -2.0F, -15.0F, -11.0F, 4.0F, 7.0F, 6.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }
}
