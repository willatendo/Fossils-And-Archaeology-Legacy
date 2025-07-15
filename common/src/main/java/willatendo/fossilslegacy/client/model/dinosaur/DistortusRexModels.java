package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class DistortusRexModels {
    public static final JsonModel DISTORTUS_REX_MODEL = DistortusRexModels.createDistortusBodyLayer().withWalkAnimations(FAUtils.resource("distortus_rex_walk")).withHeadPieces("head").build();

    private static JsonModel.Builder createDistortusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(256, 256);
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(22, 119, -1F, 1F, -1F, 2F, 9F, 3F).build(), JsonPose.offset(4F, 1F, -11F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(110, 120, -1F, 1F, -1F, 2F, 9F, 3F).build(), JsonPose.offset(-4F, 1F, -11F));
        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(74, 27, -5F, 5F, -5F, 10F, 3F, 3F).addBox(120, 120, -2F, 0F, -10F, 4F, 5F, 2F).addOrReplaceChild("jaw", subElement1Builder -> subElement1Builder.addBox(100, 28, -5F, 0F, -3F, 10F, 3F, 3F).addBox(50, 89, -2F, 0F, -5F, 4F, 3F, 2F).build(), JsonPose.offset(0F, 5F, -5F)).addBox(38, 114, -5F, 0F, -8F, 10F, 5F, 6F).addBox(0, 71, -6F, -8F, -11F, 12F, 8F, 13F).build(), JsonPose.offset(0F, -8F, -12F));
        builder.addOrReplaceChild("right_front_leg", elementBuilder -> elementBuilder.addBox(50, 71, -2F, 14F, -3F, 5F, 14F, 4F).addBox(78, 95, -3F, -5F, -3F, 6F, 19F, 6F).build(), JsonPose.offset(-9F, -4F, -8F));
        builder.addOrReplaceChild("left_front_leg", elementBuilder -> elementBuilder.addBox(92, 120, -3F, 14F, -3F, 5F, 14F, 4F).addBox(102, 95, -3F, -5F, -3F, 6F, 19F, 6F).build(), JsonPose.offset(9F, -4F, -8F));
        builder.addOrReplaceChild("left_back_leg", elementBuilder -> elementBuilder.addBox(74, 0, -5F, -8F, -5F, 8F, 16F, 11F).addBox(0, 119, -5F, 8F, -1F, 4F, 8F, 7F).addBox(112, 0, -5F, 16F, -5F, 6F, 3F, 11F).build(), JsonPose.offset(10F, 5F, 10F));
        builder.addOrReplaceChild("right_back_leg", elementBuilder -> elementBuilder.addBox(112, 14, -1F, 16F, -5F, 6F, 3F, 11F).addBox(0, 92, -3F, -8F, -5F, 8F, 16F, 11F).addBox(70, 120, 1F, 8F, -1F, 4F, 8F, 7F).build(), JsonPose.offset(-10F, 5F, 10F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(70, 65, -5F, -7F, 0F, 10F, 14F, 16F).addBox(70, 34, -3F, -7F, 16F, 6F, 7F, 24F).build(), JsonPose.offset(0F, -1F, 17F));
        builder.addOrReplaceChild("bb_main", elementBuilder -> elementBuilder.addBox(0, 34, -8F, -33F, -2F, 16F, 18F, 19F).addBox(0, 0, -7F, -37F, -14F, 14F, 11F, 23F).addBox(38, 95, -4F, -26F, -14F, 8F, 7F, 12F).build(), JsonPose.offset(0F, 24F, 0F));
        return builder;
    }
}
