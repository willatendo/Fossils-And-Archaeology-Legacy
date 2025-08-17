package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;

public final class IndominusRexModels {
    public static final JsonModel INDOMINUS_REX_MODEL = IndominusRexModels.createIndominusRexBodyLayer().withHeadPieces("neck").build();

    private static JsonModel.Builder createIndominusRexBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(128, 128);
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(34, 18, -3F, -3F, 0F, 6F, 7F, 8F).addBox(0, 52, -1F, -5F, 0F, 0F, 2F, 8F).addBox(0, 62, 1F, -5F, 0F, 0F, 2F, 8F).addBox(0, 0, -2F, -3F, 8F, 4F, 4F, 14F).build(), JsonPose.offset(0F, 10F, 8F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(62, 9, -2F, 9F, -2F, 3F, 2F, 5F).addBox(50, 65, -2F, 5F, 1F, 2F, 4F, 2F).addBox(0, 37, -2F, -4F, -3F, 4F, 9F, 6F).build(), JsonPose.offset(4F, 13F, 4F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(20, 48, -2F, -4F, -3F, 4F, 9F, 6F).addBox(26, 71, 0F, 5F, 1F, 2F, 4F, 2F).addBox(62, 16, -1F, 9F, -2F, 3F, 2F, 5F).build(), JsonPose.offset(-4F, 13F, 4F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(40, 65, -1F, -3F, -1F, 2F, 6F, 3F).addOrReplaceChild("lower_left_arm", subElement1Builder -> subElement1Builder.addBox(50, 71, -1F, 0F, -1F, 2F, 4F, 2F).build(), JsonPose.offset(0F, 3F, 1F)).build(), JsonPose.offset(3F, 14F, -6F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(16, 71, -1F, -3F, -1F, 2F, 6F, 3F).addOrReplaceChild("lower_right_arm", subElement1Builder -> subElement1Builder.addBox(0, 72, -1F, 0F, -1F, 2F, 4F, 2F).build(), JsonPose.offset(0F, 3F, 1F)).build(), JsonPose.offset(-3F, 14F, -6F));
        builder.addOrReplaceChild("neck", elementBuilder -> elementBuilder.addBox(40, 48, -2F, -9F, -3F, 4F, 12F, 5F).addBox(16, 63, 1F, -11F, -2F, 0F, 2F, 6F).addBox(28, 63, -1F, -11F, -2F, 0F, 2F, 6F).addBox(16, 52, -1F, -9F, 2F, 0F, 5F, 2F).addBox(34, 71, 1F, -9F, 2F, 0F, 5F, 2F).addOrReplaceChild("head", subElement1Builder -> subElement1Builder.addBox(36, 0, -3F, -5F, -6F, 6F, 7F, 7F).addBox(58, 61, -2F, -5F, -13F, 4F, 5F, 7F).addBox(20, 37, -1F, -7F, -6F, 0F, 2F, 7F).addBox(62, 23, 1F, -7F, -6F, 0F, 2F, 7F).addOrReplaceChild("lower_jaw", subElement2Builder -> subElement2Builder.addBox(62, 0, -2F, -7F, -6F, 4F, 2F, 7F).build(), JsonPose.offset(0F, 7F, -7F)).build(), JsonPose.offset(0F, -5F, -3F)).build(), JsonPose.offset(0F, 11F, -7F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 18, -4F, -17F, -1F, 8F, 10F, 9F).addBox(34, 33, -3F, -17F, -8F, 6F, 8F, 7F).addBox(58, 48, -1F, -19F, -3F, 0F, 2F, 11F).addBox(60, 33, 1F, -19F, -3F, 0F, 2F, 11F).build(), JsonPose.offset(0F, 24F, 0F));
        return builder;
    }
}
