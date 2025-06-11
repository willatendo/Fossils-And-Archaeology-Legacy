package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class DryosaurusModels {
    public static final JsonModel DRYOSAURUS_MODEL = DryosaurusModels.createDryosaurusBodyLayer().withWalkAnimations(FAUtils.resource("dryosaurus_walk")).withHeadPieces("neck").build();

    private static JsonModel.Builder createDryosaurusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 64);

        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(0, 16, -1F, -2F, 6F, 2F, 3F, 9F).addBox(22, 16, -2F, -2F, 0F, 4F, 4F, 6F).build(), JsonPose.offset(0, 15, 4));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(16, 28, -1F, -1F, -1F, 1F, 4F, 2F).build(), JsonPose.offset(-2, 18, -7));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(38, 9, 0F, -1F, -1F, 1F, 4F, 2F).build(), JsonPose.offset(2, 18, -7));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(24, 36, -1F, 3F, 0F, 2F, 4F, 2F).addBox(0, 36, -2F, -2F, -2F, 3F, 5F, 4F).build(), JsonPose.offset(-3, 17, 0));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(30, 0, -1F, -2F, -2F, 3F, 5F, 4F).addBox(30, 9, -1F, 3F, 0F, 2F, 4F, 2F).build(), JsonPose.offset(3, 17, 0));
        builder.addOrReplaceChild("neck", elementBuilder -> elementBuilder.addBox(14, 36, -1F, -5F, -2F, 2F, 7F, 3F).addBox(32, 36, -1F, -5F, -7F, 2F, 3F, 2F).addBox(0, 28, -2F, -6F, -5F, 4F, 4F, 4F).build(), JsonPose.offset(0, 15, -9));
        builder.addOrReplaceChild("bb_main", elementBuilder -> elementBuilder.addBox(0, 0, -3F, -12F, -5F, 6F, 7F, 9F).addBox(22, 26, -2F, -11F, -9F, 4F, 6F, 4F).build(), JsonPose.offset(0, 24, 0));

        return builder;
    }
}
