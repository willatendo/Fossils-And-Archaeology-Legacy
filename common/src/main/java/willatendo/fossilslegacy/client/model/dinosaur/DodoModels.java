package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class DodoModels {
    public static final JsonModel DODO_MODEL = DodoModels.createDodoBodyLayer().withWalkAnimations(FAUtils.resource("dodo_walk")).withFloatDownAnimations(FAUtils.resource("dodo_float_down")).withHeadPieces("head").build();

    private static JsonModel.Builder createDodoBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 64);

        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -4.0F, -4.0F, -12.0F, 8.0F, 8.0F, 8.0F).addBox(24, 0, -2.0F, -5.0F, -5.0F, 4.0F, 5.0F, 3.0F).build(), JsonPose.offset(0.0F, 17.0F, 8.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(2, 0, 0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 0.0F).addBox(22, 16, -1.0F, 3.0F, -3.0F, 3.0F, 0.0F, 3.0F).build(), JsonPose.offset(1.0F, 21.0F, 1.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(9, 16, -2.0F, 3.0F, -3.0F, 3.0F, 0.0F, 3.0F).addBox(0, 0, -1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 0.0F).build(), JsonPose.offset(-1.0F, 21.0F, 1.0F));
        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(0, 16, -2.0F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F).addBox(16, 16, -1.0F, -5.0F, -7.0F, 2.0F, 3.0F, 5.0F).build(), JsonPose.offset(0.0F, 15.0F, -4.0F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(22, 24, 0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 4.0F).build(), JsonPose.offset(4.0F, 15.0F, -2.0F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(12, 24, -1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 4.0F).build(), JsonPose.offset(-4.0F, 15.0F, -2.0F));

        return builder;
    }
}