package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class CompsognathusModels {
    public static final JsonModel COMPSOGNATHUS_MODEL = CompsognathusModels.createCompsognathusBodyLayer().withWalkAnimations(FAUtils.resource("compsognathus_walk")).withHeadPieces("head").build();

    private static JsonModel.Builder createCompsognathusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(32, 32);

        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(0, 0, -1.0F, -2.0F, 4.0F, 2.0F, 2.0F, 8.0F).addBox(12, 0, -1.5F, -2.0F, 0.0F, 3.0F, 3.0F, 4.0F).build(), JsonPose.offset(0.0F, 18.0F, 1.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(0, 0, -1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F).addBox(14, 10, 0.0F, 3.0F, 1.0F, 1.0F, 3.0F, 0.0F).addBox(5, 0, 0.0F, 6.0F, 0.0F, 1.0F, 0.0F, 1.0F).build(), JsonPose.offset(-2.0F, 18.0F, -1.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(0, 18, -1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F).addBox(5, 1, -1.0F, 6.0F, 0.0F, 1.0F, 0.0F, 1.0F).addBox(12, 10, -1.0F, 3.0F, 1.0F, 1.0F, 3.0F, 0.0F).build(), JsonPose.offset(2.0F, 18.0F, -1.0F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(0, 10, -0.5F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F).build(), JsonPose.offset(-1.5F, 18.5F, -4.5F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(12, 0, -0.5F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F).build(), JsonPose.offset(1.5F, 18.5F, -4.5F));
        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(20, 13, -1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F).addBox(12, 14, -1.0F, -3.0F, -5.0F, 2.0F, 3.0F, 4.0F).build(), JsonPose.offset(0.0F, 16.0F, -5.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 10, -2.0F, -8.0F, -3.0F, 4.0F, 4.0F, 4.0F).addBox(17, 7, -1.0F, -8.0F, -6.0F, 2.0F, 3.0F, 3.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }
}
