package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class CarnotaurusModels {
    public static final JsonModel CARNOTAURUS_MODEL = CarnotaurusModels.createCarnotaurusBodyLayer(FAUtils.resource("carnotaurus")).withWalkAnimations(FAUtils.resource("carnotaurus_walk")).withHeadPieces("neck").build();
    public static final JsonModel LEGACY_CARNOTAURUS_MODEL = CarnotaurusModels.createLegacyCarnotaurusBodyLayer(FAUtils.resource("legacy_carnotaurus")).withWalkAnimations(BuiltInAnimationTypes.LEGACY_CARNOTAURUS_WALK.getId()).build();

    public static JsonModel.Builder createCarnotaurusBodyLayer(ResourceLocation modelId) {
        JsonModel.Builder builder = JsonModel.builder(modelId, 64, 64);

        builder.addOrReplaceChild("neck", elementBuilder -> elementBuilder.addBox(24, 37, -2.0F, -6.0F, -3.0F, 4.0F, 9.0F, 4.0F).addOrReplaceChild("head", subElementBuilder -> subElementBuilder.addBox(0, 29, -3.0F, -3.0F, -6.0F, 6.0F, 5.0F, 6.0F).addBox(24, 29, -3.0F, 2.0F, -6.0F, 6.0F, 2.0F, 6.0F).addBox(14, 40, -4.0F, -4.0F, -2.0F, 3.0F, 2.0F, 2.0F).addBox(14, 44, 1.0F, -4.0F, -2.0F, 3.0F, 2.0F, 2.0F).build(), JsonPose.offset(0.0F, -3.0F, -3.0F)).build(), JsonPose.offset(0.0F, 12.0F, -7.0F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(30, 0, -1.0F, -3.0F, 8.0F, 2.0F, 4.0F, 8.0F).addBox(26, 15, -2.0F, -3.0F, 0.0F, 4.0F, 6.0F, 8.0F).build(), JsonPose.offset(0.0F, 13.0F, 6.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(40, 37, -2.0F, -3.0F, -2.0F, 3.0F, 6.0F, 4.0F).addBox(0, 50, -1.0F, 3.0F, 0.0F, 2.0F, 3.0F, 2.0F).addBox(48, 29, -2.0F, 6.0F, -2.0F, 3.0F, 2.0F, 4.0F).build(), JsonPose.offset(-4.0F, 16.0F, 3.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(0, 40, -1.0F, -3.0F, -2.0F, 3.0F, 6.0F, 4.0F).addBox(14, 48, -1.0F, 3.0F, 0.0F, 2.0F, 3.0F, 2.0F).addBox(40, 47, -1.0F, 6.0F, -2.0F, 3.0F, 2.0F, 4.0F).build(), JsonPose.offset(4.0F, 16.0F, 3.0F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(50, 5, 0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 3.0F).build(), JsonPose.offset(3.0F, 15.0F, -6.0F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(50, 0, -1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 3.0F).build(), JsonPose.offset(-3.0F, 15.0F, -6.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -4.0F, -14.0F, -1.0F, 8.0F, 8.0F, 7.0F).addBox(0, 15, -3.0F, -14.0F, -8.0F, 6.0F, 7.0F, 7.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }

    public static JsonModel.Builder createLegacyCarnotaurusBodyLayer(ResourceLocation modelId) {
        JsonModel.Builder builder = JsonModel.builder(modelId, 64, 64);

        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(0, 0, 0.0F, 0.0F, 0.0F, 8.0F, 7.0F, 8.0F).build(), JsonPose.offset(-4.5F, 2.5F, -27.0F));
        builder.addOrReplaceChild("horn_1", elementBuilder -> elementBuilder.addBox(24, 0, 0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F).build(), JsonPose.offsetAndRotation(-6.5F, 1.5F, -23.0F, 0.0F, -0.0F, 0.3490658503988659F));
        builder.addOrReplaceChild("horn_2", elementBuilder -> elementBuilder.addBox(24, 0, 0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F).build(), JsonPose.offsetAndRotation(2.5F, 2.5F, -23.0F, 0.0F, -0.0F, -0.3490658503988659F));
        builder.addOrReplaceChild("jaw", elementBuilder -> elementBuilder.addBox(0, 15, 0.0F, 0.0F, 0.0F, 6.0F, 1.0F, 7.0F).build(), JsonPose.offset(-3.5F, 9.0F, -26.0F));
        builder.addOrReplaceChild("teeth", elementBuilder -> elementBuilder.addBox(34, 59, 0.0F, 0.0F, 0.0F, 8.0F, 4.0F, 1.0F).build(), JsonPose.offsetAndRotation(-4.5F, 10.4F, -27.0F, 1.5707963267948966F, -0.0F, 0.0F));
        builder.addOrReplaceChild("neck", elementBuilder -> elementBuilder.addBox(20, 4, 0.0F, 0.0F, 0.0F, 5.0F, 6.0F, 12.0F).build(), JsonPose.offsetAndRotation(-3.0F, 2.5F, -20.0F, -0.4363323129985824F, -0.0F, 0.0F));
        builder.addOrReplaceChild("upper_body", elementBuilder -> elementBuilder.addBox(0, 23, 0.0F, 0.0F, 0.0F, 7.0F, 9.0F, 10.0F).build(), JsonPose.offsetAndRotation(-4.0F, 5.5F, -13.0F, -0.001549108791234052F, -0.0F, 0.0F));
        builder.addOrReplaceChild("lower_body", elementBuilder -> elementBuilder.addBox(0, 43, 0.0F, 0.0F, 0.0F, 9.0F, 10.0F, 8.0F).build(), JsonPose.offsetAndRotation(-5.0F, 5.5F, -6.0F, -0.03490658503988659F, -0.0F, 0.0F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(0, 0, 0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F).build(), JsonPose.offsetAndRotation(-6.0F, 11.5F, -13.0F, 0.8726646259971648F, -0.0F, 0.0F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(0, 0, 0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F).build(), JsonPose.offsetAndRotation(3.0F, 11.5F, -13.0F, 0.8726646259971648F, -0.0F, 0.0F));
        builder.addOrReplaceChild("right_thigh", elementBuilder -> elementBuilder.addBox(44, 0, 0.0F, 0.0F, 0.0F, 4.0F, 7.0F, 6.0F).addOrReplaceChild("right_leg", subElement1Builder -> subElement1Builder.addBox(52, 51, 0.0F, 0.0F, 0.0F, 2.0F, 7.0F, 3.0F).addOrReplaceChild("right_foot", subElement2Builder -> subElement2Builder.addBox(34, 51, 0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 6.0F).build(), JsonPose.offsetAndRotation(-1.0F, 6.5F, -3.0F, 0.2617993877991494F, -0.0F, 0.0F)).build(), JsonPose.offsetAndRotation(2.0F, 6.5F, 4.0F, -0.2617993877991494F, -0.0F, 0.0F)).build(), JsonPose.offsetAndRotation(-9.0F, 9.5F, -4.0F, -0.17453292519943295F, -0.0F, 0.0F));
        builder.addOrReplaceChild("left_thigh", elementBuilder -> elementBuilder.addBox(44, 0, 0.0F, 0.0F, 0.0F, 4.0F, 7.0F, 6.0F).addOrReplaceChild("left_leg", subElement1Builder -> subElement1Builder.addBox(52, 51, 0.0F, 0.0F, 0.0F, 2.0F, 7.0F, 3.0F).addOrReplaceChild("left_foot", subElement2Builder -> subElement2Builder.addBox(34, 51, 0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 6.0F).build(), JsonPose.offsetAndRotation(0.0F, 6.5F, -3.0F, 0.2617993877991494F, -0.0F, 0.0F)).build(), JsonPose.offsetAndRotation(0.0F, 6.5F, 4.0F, -0.2617993877991494F, -0.0F, 0.0F)).build(), JsonPose.offsetAndRotation(4.0F, 9.5F, -4.0F, -0.17453292519943295F, -0.0F, 0.0F));
        builder.addOrReplaceChild("tail_1", elementBuilder -> elementBuilder.addBox(26, 36, 0.0F, 0.0F, -1.0F, 7.0F, 6.0F, 9.0F).build(), JsonPose.offsetAndRotation(-4.0F, 6.0F, 1.0F, -0.03717861098961725F, -0.0F, 0.0F));
        builder.addOrReplaceChild("tail_2", elementBuilder -> elementBuilder.addBox(34, 22, 0.0F, 0.0F, -1.0F, 5.0F, 5.0F, 9.0F).build(), JsonPose.offset(-3.0F, 6.5F, 9.5F));
        builder.addOrReplaceChild("tail_3", elementBuilder -> elementBuilder.addBox(25, 22, 0.0F, 0.0F, -1.0F, 3.0F, 3.0F, 6.0F).build(), JsonPose.offsetAndRotation(-2.0F, 7.0F, 18.5F, -0.03717861098961725F, -0.0F, 0.0F));

        return builder;
    }
}
