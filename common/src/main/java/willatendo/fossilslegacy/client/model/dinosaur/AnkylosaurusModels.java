package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class AnkylosaurusModels {
    public static final JsonModel ANKYLOSAURUS_MODEL = AnkylosaurusModels.createAnkylosaurusBodyLayer(FAUtils.resource("ankylosaurus")).withWalkAnimations(FAUtils.resource("ankylosaurus_walk")).withHeadPieces("head").build();

    public static JsonModel.Builder createAnkylosaurusBodyLayer(ResourceLocation modelId) {
        JsonModel.Builder builder = JsonModel.builder(modelId, 128, 128);

        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(0, 26, -4.0F, -4.0F, -8.0F, 8.0F, 7.0F, 8.0F).addBox(22, 41, 2.0F, 1.0F, -2.0F, 3.0F, 3.0F, 2.0F).addBox(58, 34, -5.0F, 1.0F, -2.0F, 3.0F, 3.0F, 2.0F).addBox(58, 20, 2.0F, -6.0F, -3.0F, 3.0F, 4.0F, 3.0F).addBox(58, 27, -5.0F, -6.0F, -3.0F, 3.0F, 4.0F, 3.0F).addBox(54, 39, -2.0F, -1.0F, -10.0F, 4.0F, 5.0F, 3.0F).build(), JsonPose.offset(0.0F, 16.0F, -9.0F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(0, 41, -3.0F, -1.0F, 13.0F, 6.0F, 4.0F, 5.0F).addBox(32, 39, -2.0F, -2.0F, 7.0F, 4.0F, 4.0F, 7.0F).addBox(32, 26, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 7.0F).build(), JsonPose.offset(0.0F, 15.0F, 7.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(52, 50, -2.0F, 2.0F, -2.0F, 3.0F, 5.0F, 4.0F).addBox(0, 50, -2.0F, -3.0F, -3.0F, 4.0F, 5.0F, 5.0F).build(), JsonPose.offset(6.0F, 17.0F, 4.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(52, 11, -1.0F, 2.0F, -2.0F, 3.0F, 5.0F, 4.0F).addBox(18, 50, -2.0F, -3.0F, -3.0F, 4.0F, 5.0F, 5.0F).build(), JsonPose.offset(-6.0F, 17.0F, 4.0F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(36, 50, 8.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F).build(), JsonPose.offset(-5.0F, 19.0F, -5.0F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(52, 0, -2.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F).build(), JsonPose.offset(-5.0F, 19.0F, -5.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -5.0F, -13.0F, -9.0F, 10.0F, 10.0F, 16.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }
}
