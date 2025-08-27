package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class BaryonyxModels {
    public static final JsonModel BARYONYX_MODEL = BaryonyxModels.createBaryonyxBodyLayer().withWalkAnimations(FAUtils.resource("baryonyx_walk")).withSleepAnimations(FAUtils.resource("baryonyx_sleep")).withHeadPieces("neck").build();

    private static JsonModel.Builder createBaryonyxBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 64);
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 32, -2F, -3F, -9F, 4F, 6F, 6F).addBox(0, 0, -3F, -4F, -3F, 6F, 7F, 12F).addBox(26, 31, 0F, -8F, -1F, 0F, 4F, 10F).build(), JsonPose.offset(0F, 13F, 0F));
        builder.addOrReplaceChild("neck", elementBuilder -> elementBuilder.addBox(18, 45, -1F, -7F, -3F, 2F, 9F, 4F).addBox(20, 32, 0F, -7F, 1F, 0F, 6F, 3F).addOrReplaceChild("head", subElement1Builder -> subElement1Builder.addBox(36, 0, -2F, -3F, -5F, 4F, 5F, 5F).addBox(0, 44, -1F, -2F, -12F, 2F, 2F, 7F).addOrReplaceChild("lower_jaw", subElement2Builder -> subElement2Builder.addBox(36, 10, -1F, 0F, -7F, 2F, 2F, 7F).addBox(46, 31, -0.5F, 0F, -6F, 1F, 1F, 6F).addBox(46, 31, -0.5F, -1F, -6F, 1F, 1F, 6F).build(), JsonPose.offset(0F, 0F, -5F)).build(), JsonPose.offset(0F, -5F, -2F)).build(), JsonPose.offset(0F, 11F, -8F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(26, 19, -2F, -2F, 0F, 4F, 4F, 8F).addBox(0, 19, -1F, -2F, 8F, 2F, 2F, 11F).addBox(0, 53, 0F, -6F, 0F, 0F, 4F, 5F).build(), JsonPose.offset(0F, 11F, 9F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(50, 25, -1F, 3F, -0.5F, 2F, 4F, 2F).addBox(54, 0, -1F, -2F, -1.5F, 2F, 5F, 3F).build(), JsonPose.offset(-2F, 14F, -6.5F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(54, 8, -1F, -2F, -1.5F, 2F, 5F, 3F).addBox(38, 55, -1F, 3F, -0.5F, 2F, 4F, 2F).build(), JsonPose.offset(2F, 14F, -6.5F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(46, 38, -1F, 8F, -2F, 3F, 2F, 4F).addBox(10, 53, -1F, 3F, 0F, 2F, 5F, 2F).addBox(30, 45, -1F, -3F, -2F, 3F, 6F, 4F).build(), JsonPose.offset(3F, 14F, 4F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(44, 45, -2F, -3F, -2F, 3F, 6F, 4F).addBox(30, 55, -1F, 3F, 0F, 2F, 5F, 2F).addBox(50, 19, -2F, 8F, -2F, 3F, 2F, 4F).build(), JsonPose.offset(-3F, 14F, 4F));
        return builder;
    }
}
