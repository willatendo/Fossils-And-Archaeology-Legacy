package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class PachycephalosaurusModels {
    public static final JsonModel PACHYCEPHALOSAURUS_MODEL = PachycephalosaurusModels.createPachycephalosaurusBodyLayer().withWalkAnimations(FAUtils.resource("pachycephalosaurus_walk")).withHeadPieces("head").build();

    private static JsonModel.Builder createPachycephalosaurusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 64);

        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(21, 9, -2.0F, -2.0F, 0.0F, 4.0F, 5.0F, 7.0F).addBox(0, 16, -1.0F, -2.0F, 7.0F, 2.0F, 3.0F, 11.0F).build(), JsonPose.offset(0.0F, 12.0F, 4.0F));
        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(21, 25, -2.0F, -5.0F, -7.0F, 4.0F, 6.0F, 5.0F).addBox(14, 36, -2.0F, -5.0F, -2.0F, 4.0F, 8.0F, 2.0F).addBox(0, 23, -1.5F, -2.0F, -8.0F, 3.0F, 3.0F, 1.0F).addBox(0, 30, -2.0F, -6.0F, -5.0F, 4.0F, 1.0F, 5.0F).addBox(20, 0, -3.0F, -5.0F, -4.0F, 6.0F, 1.0F, 5.0F).build(), JsonPose.offset(0.0F, 12.0F, -7.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(36, 6, -1.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F).addBox(0, 0, -1.0F, 3.0F, 1.0F, 2.0F, 4.0F, 2.0F).addBox(34, 21, -1.0F, 7.0F, -1.0F, 3.0F, 2.0F, 4.0F).build(), JsonPose.offset(3.0F, 15.0F, 1.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(42, 0, -2.0F, 7.0F, -1.0F, 3.0F, 2.0F, 4.0F).addBox(35, 32, -2.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F).addBox(15, 19, -1.0F, 3.0F, 1.0F, 2.0F, 4.0F, 2.0F).build(), JsonPose.offset(-3.0F, 15.0F, 1.0F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(39, 27, 0.0F, 3.0F, -1.0F, 2.0F, 3.0F, 2.0F).addBox(26, 39, 0.0F, -1.0F, -2.0F, 2.0F, 4.0F, 3.0F).build(), JsonPose.offset(2.0F, 15.0F, -5.0F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(13, 30, -2.0F, 3.0F, -1.0F, 2.0F, 3.0F, 2.0F).addBox(0, 16, -2.0F, -1.0F, -2.0F, 2.0F, 4.0F, 3.0F).build(), JsonPose.offset(-2.0F, 15.0F, -5.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -3.0F, -14.0F, -4.0F, 6.0F, 8.0F, 8.0F).addBox(0, 36, -2.0F, -14.0F, -7.0F, 4.0F, 7.0F, 3.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }
}