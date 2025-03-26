package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class ElasmotheriumModels {
    public static final JsonModel ELASMOTHERIUM_MODEL = ElasmotheriumModels.createElasmotheriumBodyLayer().withWalkAnimations(FAUtils.resource("elasmotherium_walk")).withHeadPieces("head").build();

    private static JsonModel.Builder createElasmotheriumBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(128, 128);
        builder.addOrReplaceChild("back_left_leg", elementBuilder -> elementBuilder.addBox(32, 48, -2F, -4F, -2F, 3F, 8F, 5F).addBox(58, 0, -2F, 4F, 0F, 3F, 4F, 3F).build(), JsonPose.offset(4F, 16F, 6F));
        builder.addOrReplaceChild("front_left_leg", elementBuilder -> elementBuilder.addBox(52, 37, -3F, 4F, -2F, 4F, 7F, 4F).addBox(0, 43, -1F, -4F, -3F, 2F, 8F, 6F).build(), JsonPose.offset(5F, 13F, -6F));
        builder.addOrReplaceChild("front_right_leg", elementBuilder -> elementBuilder.addBox(0, 57, -1F, 4F, -2F, 4F, 7F, 4F).addBox(16, 43, -1F, -4F, -3F, 2F, 8F, 6F).build(), JsonPose.offset(-5F, 13F, -6F));
        builder.addOrReplaceChild("back_right_leg", elementBuilder -> elementBuilder.addBox(60, 21, -1F, 4F, 0F, 3F, 4F, 3F).addBox(48, 48, -1F, -4F, -2F, 3F, 8F, 5F).build(), JsonPose.offset(-4F, 16F, 6F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(16, 57, -1F, -2F, -1F, 2F, 10F, 2F).build(), JsonPose.offset(0F, 13F, 11F));
        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(32, 37, -3F, -3F, -4F, 6F, 7F, 4F).addBox(36, 12, -2F, -1F, -7F, 4F, 5F, 3F).addBox(50, 12, -1F, -6F, -6F, 2F, 5F, 4F).build(), JsonPose.offset(0F, 13F, -13F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 22, -4F, -18F, -10F, 8F, 13F, 8F).addBox(0, 0, -3F, -15F, -2F, 6F, 10F, 12F).addBox(36, 0, -4F, -16F, -13F, 8F, 9F, 3F).addBox(32, 22, -2F, -20F, -8F, 4F, 5F, 10F).build(), JsonPose.offset(0F, 24F, 0F));
        return builder;
    }
}
