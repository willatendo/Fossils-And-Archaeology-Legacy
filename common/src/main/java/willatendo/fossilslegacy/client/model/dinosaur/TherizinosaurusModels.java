package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class TherizinosaurusModels {
    public static final JsonModel THERIZINOSAURUS_MODEL = TherizinosaurusModels.createTherizinosaurusBodyLayer(FAUtils.resource("therizinosaurus")).withWalkAnimations(FAUtils.resource("therizinosaurus_walk")).withHeadPieces("neck").build();
    public static final JsonModel LEGACY_THERIZINOSAURUS_MODEL = TherizinosaurusModels.createLegacyTherizinosaurusBodyLayer(FAUtils.resource("legacy_therizinosaurus")).withWalkAnimations(BuiltInAnimationTypes.LEGACY_THERIZINOSAURUS_WALK.getId()).build();

    public static JsonModel.Builder createTherizinosaurusBodyLayer(ResourceLocation modelId) {
        JsonModel.Builder builder = JsonModel.builder(modelId, 128, 128);

        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(24, 54, -1.0F, 4.0F, 0.0F, 2.0F, 5.0F, 3.0F).addBox(46, 24, -1.0F, 9.0F, -2.0F, 3.0F, 2.0F, 5.0F).addBox(26, 20, -2.0F, -4.0F, -3.0F, 4.0F, 8.0F, 6.0F).build(), JsonPose.offset(4.0F, 13.0F, -1.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(50, 0, -2.0F, 9.0F, -2.0F, 3.0F, 2.0F, 5.0F).addBox(30, 0, -2.0F, -4.0F, -3.0F, 4.0F, 8.0F, 6.0F).addBox(34, 55, -1.0F, 4.0F, 0.0F, 2.0F, 5.0F, 3.0F).build(), JsonPose.offset(-4.0F, 13.0F, -1.0F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(54, 55, -1.0F, 3.0F, -1.0F, 2.0F, 5.0F, 3.0F).addBox(22, 40, 0.0F, 8.0F, 1.0F, 1.0F, 4.0F, 1.0F).addBox(34, 14, 0.0F, 6.0F, -2.0F, 1.0F, 5.0F, 1.0F).addBox(42, 14, 0.0F, 8.0F, -0.5F, 1.0F, 4.0F, 1.0F).addBox(12, 53, -1.0F, -2.0F, -2.0F, 2.0F, 5.0F, 4.0F).build(), JsonPose.offset(3.0F, 6.0F, -9.0F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(0, 53, -1.0F, -2.0F, -1.5F, 2.0F, 5.0F, 4.0F).addBox(44, 55, -1.0F, 3.0F, -0.5F, 2.0F, 5.0F, 3.0F).addBox(30, 14, -1.0F, 6.0F, -1.5F, 1.0F, 5.0F, 1.0F).addBox(38, 14, -1.0F, 8.0F, 1.5F, 1.0F, 4.0F, 1.0F).addBox(18, 40, -1.0F, 8.0F, 0.0F, 1.0F, 4.0F, 1.0F).build(), JsonPose.offset(-3.0F, 6.0F, -9.5F));
        builder.addOrReplaceChild("neck", elementBuilder -> elementBuilder.addBox(26, 34, -1.0F, -11.0F, -3.0F, 2.0F, 15.0F, 5.0F).addOrReplaceChild("head", subElementBuilder -> subElementBuilder.addBox(50, 7, -1.0F, -2.0F, -8.0F, 2.0F, 3.0F, 4.0F).addBox(40, 34, -2.0F, -4.0F, -4.0F, 4.0F, 5.0F, 5.0F).build(), JsonPose.offset(0.0F, -9.0F, 0.0F)).build(), JsonPose.offset(0.0F, 4.0F, -9.0F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(40, 44, -2.0F, 0.0F, 3.0F, 4.0F, 7.0F, 4.0F).addBox(46, 14, -1.0F, 3.0F, 7.0F, 2.0F, 4.0F, 6.0F).addBox(0, 40, -3.0F, -4.0F, 0.0F, 6.0F, 10.0F, 3.0F).build(), JsonPose.offset(0.0F, 11.0F, 3.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -3.0F, -19.0F, -6.0F, 6.0F, 11.0F, 9.0F).addBox(0, 20, -2.0F, -23.0F, -11.0F, 4.0F, 11.0F, 9.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }

    public static JsonModel.Builder createLegacyTherizinosaurusBodyLayer(ResourceLocation modelId) {
        JsonModel.Builder builder = JsonModel.builder(modelId, 64, 64);

        builder.addOrReplaceChild("lower_body", elementBuilder -> elementBuilder.addBox(32, 0, -4.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F).addOrReplaceChild("upper_body", subElement1Builder -> subElement1Builder.addBox(40, 16, -3.0F, -2.0F, -6.0F, 6.0F, 6.0F, 6.0F).addOrReplaceChild("neck", subElement2Builder -> subElement2Builder.addBox(22, 0, -1.0F, -12.0F, -1.5F, 2.0F, 12.0F, 3.0F).addOrReplaceChild("head", subElement3Builder -> subElement3Builder.addBox(0, 0, -2.0F, -2.0F, -7.0F, 4.0F, 3.0F, 7.0F).addOrReplaceChild("jaw", subElement4Builder -> subElement4Builder.addBox(0, 10, -1.5F, 0.0F, -6.0F, 3.0F, 1.0F, 6.0F).build(), JsonPose.offsetAndRotation(0.0F, 0.9F, -0.5F, -0.08272860254978959F, -0.0F, 0.0F)).build(), JsonPose.offsetAndRotation(0.0F, -11.0F, 0.5F, -0.32707469782899573F, -0.0F, 0.0F)).build(), JsonPose.offsetAndRotation(0.0F, 0.5F, -4.5F, 0.888547119527152F, -0.0F, 0.0F)).build(), JsonPose.offsetAndRotation(0.0F, 2.1F, 0.2F, 0.05305800859483734F, -0.0F, 0.0F)).addOrReplaceChild("right_upper_arm", subElement2Builder -> subElement2Builder.addBox(38, 16, -2.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F).addOrReplaceChild("right_lower_arm", subElement3Builder -> subElement3Builder.addBox(30, 16, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F).addOrReplaceChild("right_lower_feather", subElement4Builder -> subElement4Builder.addBox(46, 50, 0.0F, -0.5F, 2.0F, 1.0F, 5.0F, 3.0F).addOrReplaceChild("right_front_claw", subElement5Builder -> subElement5Builder.addBox(18, 10, -0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F).build(), JsonPose.offsetAndRotation(1.0F, 2.9F, 0.2F, 0.33161255787892263F, 0.0F, 0.0F)).addOrReplaceChild("right_middle_claw", subElement5Builder -> subElement5Builder.addBox(18, 10, -0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F).build(), JsonPose.offsetAndRotation(0.9F, 3.2F, 0.2F, 0.767944870877505F, -0.0F, 0.0F)).build(), JsonPose.offset(-0.99F, 0.2F, -0.15F)).addOrReplaceChild("right_back_claw", subElement4Builder -> subElement4Builder.addBox(18, 10, -0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F).build(), JsonPose.offsetAndRotation(-0.2F, 3.4F, 0.0F, 1.0995574287564276F, 0.0F, 0.0F)).build(), JsonPose.offsetAndRotation(-0.9F, 3.0F, 0.5F, -0.8552113334772213F, -0.0F, 0.0F)).addOrReplaceChild("right_upper_feather", subElement3Builder -> subElement3Builder.addBox(46, 49, -0.5F, -2.0F, 0.0F, 1.0F, 6.0F, 3.0F).build(), JsonPose.offset(-1.3F, 2.4F, 0.9F)).build(), JsonPose.offsetAndRotation(-3.0F, -0.1F, -5.1F, 0.5235987755982988F, -0.0F, 0.0F)).addOrReplaceChild("left_upper_arm", subElement2Builder -> subElement2Builder.addBox(38, 16, 0.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F).addOrReplaceChild("left_lower_arm", subElement3Builder -> subElement3Builder.addBox(30, 16, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F).addOrReplaceChild("left_lower_feather", subElement4Builder -> subElement4Builder.addBox(46, 50, 1.0F, -0.5F, 2.0F, 1.0F, 5.0F, 3.0F, true).addOrReplaceChild("left_front_claw", subElement5Builder -> subElement5Builder.addBox(18, 10, -0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F).build(), JsonPose.offsetAndRotation(1.0F, 2.9F, 0.2F, 0.33161255787892263F, 0.0F, 0.0F)).addOrReplaceChild("left_middle_claw", subElement5Builder -> subElement5Builder.addBox(18, 10, -0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F).build(), JsonPose.offsetAndRotation(1.1F, 3.2F, 0.2F, 0.767944870877505F, -0.0F, 0.0F)).build(), JsonPose.offset(-0.99F, 0.2F, -0.15F)).addOrReplaceChild("left_back_claw", subElement4Builder -> subElement4Builder.addBox(18, 10, -0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F).build(), JsonPose.offsetAndRotation(0.2F, 3.4F, 0.0F, 1.0995574287564276F, 0.0F, 0.0F)).build(), JsonPose.offsetAndRotation(0.9F, 3.0F, 0.5F, -0.8552113334772213F, -0.0F, 0.0F)).addOrReplaceChild("left_upper_feather", subElement3Builder -> subElement3Builder.addBox(46, 49, -0.5F, -2.0F, 0.0F, 1.0F, 6.0F, 3.0F, true).build(), JsonPose.offset(1.3F, 2.4F, 0.9F)).build(), JsonPose.offsetAndRotation(3.0F, 0.1F, -5.1F, 0.5235987755982988F, -0.0F, 0.0F)).addOrReplaceChild("tail_1", subElement1Builder -> subElement1Builder.addBox(44, 28, -2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 6.0F).addOrReplaceChild("tail_2", subElement2Builder -> subElement2Builder.addBox(44, 38, -1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 8.0F).build(), JsonPose.offsetAndRotation(0.0F, 1.6F, 5.5F, -0.09791297336714784F, -0.0F, 0.0F)).build(), JsonPose.offsetAndRotation(0.0F, 0.8F, 7.5F, 0.162315623764424F, -0.0F, 0.0F)).build(), JsonPose.offsetAndRotation(0.0F, 8.2F, 1.0F, -0.4993387096482221F, -0.0F, 0.0F));
        builder.addOrReplaceChild("right_thigh", subElement1Builder -> subElement1Builder.addBox(1, 18, -3.0F, -1.0F, -2.0F, 3.0F, 6.0F, 4.0F).addOrReplaceChild("right_leg", subElement2Builder -> subElement2Builder.addBox(0, 28, -1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 3.0F).addOrReplaceChild("right_foot", subElement3Builder -> subElement3Builder.addBox(10, 28, -2.0F, 0.0F, -5.0F, 3.0F, 2.0F, 6.0F).build(), JsonPose.offsetAndRotation(0.1F, 4.0F, 1.2F, 0.13962634015954636F, -0.0F, 0.0F)).build(), JsonPose.offsetAndRotation(-1.1F, 3.8F, 1.3F, -0.05235987755982988F, -0.0F, 0.0F)).build(), JsonPose.offsetAndRotation(-4.0F, 13.9F, 4.0F, -0.08726646259971647F, -0.0F, 0.0F));
        builder.addOrReplaceChild("left_thigh", subElement1Builder -> subElement1Builder.addBox(1, 18, 0.0F, -1.0F, -2.0F, 3.0F, 6.0F, 4.0F).addOrReplaceChild("left_leg", subElement2Builder -> subElement2Builder.addBox(0, 28, -1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 3.0F).addOrReplaceChild("left_foot", subElement3Builder -> subElement3Builder.addBox(10, 28, -1.0F, 0.0F, -5.0F, 3.0F, 2.0F, 6.0F).build(), JsonPose.offsetAndRotation(-0.1F, 4.0F, 1.2F, 0.13962634015954636F, -0.0F, 0.0F)).build(), JsonPose.offsetAndRotation(1.1F, 3.8F, 1.3F, -0.05235987755982988F, -0.0F, 0.0F)).build(), JsonPose.offsetAndRotation(4.0F, 13.9F, 4.0F, -0.08726646259971647F, -0.0F, 0.0F));

        return builder;
    }
}