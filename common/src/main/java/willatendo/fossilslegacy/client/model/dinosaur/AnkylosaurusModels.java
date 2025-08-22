package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class AnkylosaurusModels {
    public static final JsonModel ANKYLOSAURUS_MODEL = AnkylosaurusModels.createAnkylosaurusBodyLayer().withWalkAnimations(FAUtils.resource("ankylosaurus_walk")).withSleepAnimations(FAUtils.resource("ankylosaurus_sleep")).withHeadPieces("head").build();

    private static JsonModel.Builder createAnkylosaurusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(128, 128);
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -5F, -10F, -8F, 10F, 10F, 16F).build(), JsonPose.offset(0F, 21F, -1F));
        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(0, 26, -4F, -4F, -8F, 8F, 7F, 8F).addBox(22, 41, 2F, 1F, -2F, 3F, 3F, 2F).addBox(58, 34, -5F, 1F, -2F, 3F, 3F, 2F).addBox(58, 20, 2F, -6F, -3F, 3F, 4F, 3F).addBox(58, 27, -5F, -6F, -3F, 3F, 4F, 3F).addBox(54, 39, -2F, -1F, -10F, 4F, 5F, 3F).build(), JsonPose.offset(0F, 16F, -9F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(0, 41, -3F, -1F, 13F, 6F, 4F, 5F).addBox(32, 39, -2F, -2F, 7F, 4F, 4F, 7F).addBox(32, 26, -3F, -3F, 0F, 6F, 6F, 7F).build(), JsonPose.offset(0F, 15F, 7F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(52, 50, -2F, 2F, -2F, 3F, 5F, 4F).addBox(0, 50, -2F, -3F, -3F, 4F, 5F, 5F).build(), JsonPose.offset(6F, 17F, 4F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(52, 11, -1F, 2F, -2F, 3F, 5F, 4F).addBox(18, 50, -2F, -3F, -3F, 4F, 5F, 5F).build(), JsonPose.offset(-6F, 17F, 4F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(36, 50, -2F, -2F, -2F, 4F, 7F, 4F).build(), JsonPose.offset(5F, 19F, -5F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(52, 0, -2F, -2F, -2F, 4F, 7F, 4F).build(), JsonPose.offset(-5F, 19F, -5F));
        return builder;
    }
}
