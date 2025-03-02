package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class VelociraptorModels {
    public static final JsonModel VELOCIRAPTOR_MODEL = VelociraptorModels.createVelociraptorBodyLayer().withWalkAnimations(FAUtils.resource("velociraptor_walk")).withHeadPieces("head").build();
    public static final JsonModel LEGACY_VELOCIRAPTOR_MODEL = VelociraptorModels.createLegacyVelociraptorBodyLayer().withWalkAnimations(BuiltInAnimationTypes.LEGACY_VELOCIRAPTOR_WALK.getId()).overrideReset().build();

    private static JsonModel.Builder createVelociraptorBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 64);

        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(0, 6, -1.375F, 8.625F, -1.75F, 2.0F, 0.0F, 3.0F).addBox(31, 4, -0.375F, 3.625F, 0.25F, 1.0F, 5.0F, 1.0F).addBox(9, 26, -1.375F, -0.375F, -1.75F, 2.0F, 4.0F, 3.0F).addBox(0, 8, 0.625F, 6.625F, -1.75F, 0.0F, 2.0F, 3.0F).build(), JsonPose.offset(-2.625F, 15.375F, -2.25F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(19, 26, -0.625F, -0.375F, -1.75F, 2.0F, 4.0F, 3.0F).addBox(0, 10, -0.625F, 6.625F, -1.75F, 0.0F, 2.0F, 3.0F).addBox(0, 3, -0.625F, 8.625F, -1.75F, 2.0F, 0.0F, 3.0F).addBox(29, 27, -0.625F, 3.625F, 0.25F, 1.0F, 5.0F, 1.0F).build(), JsonPose.offset(2.625F, 15.375F, -2.25F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(0, 29, -0.5F, 0.0F, -1.25F, 1.0F, 2.0F, 2.0F).addBox(13, 6, -0.5F, 2.0F, -0.25F, 1.0F, 2.0F, 1.0F).build(), JsonPose.offset(2.0F, 16.0F, -6.75F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(16, 26, -0.5F, 2.0F, -0.25F, 1.0F, 2.0F, 1.0F).addBox(27, 0, -0.5F, 0.0F, -1.25F, 1.0F, 2.0F, 2.0F).build(), JsonPose.offset(-2.0F, 16.0F, -6.75F));
        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(19, 9, -1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F).addBox(17, 19, -1.5F, -5.0F, -4.5F, 3.0F, 4.0F, 3.0F).addBox(26, 17, -1.0F, -4.0F, -7.5F, 2.0F, 2.0F, 3.0F).addBox(26, 23, -1.0F, -2.0F, -7.5F, 2.0F, 1.0F, 3.0F).addBox(0, 0, -1.5F, -5.0F, 1.5F, 3.0F, 0.0F, 3.0F).addBox(12, 20, 1.5F, -5.0F, 1.5F, 0.0F, 4.0F, 2.0F).addBox(14, 9, -1.5F, -5.0F, 1.5F, 0.0F, 4.0F, 2.0F).build(), JsonPose.offset(0.0F, 14.0F, -7.5F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(17, 2, -1.5F, 0.1667F, 0.1667F, 3.0F, 3.0F, 4.0F).addBox(0, 0, -1.0F, 0.1667F, 4.1667F, 2.0F, 2.0F, 9.0F).addBox(7, 0, -2.0F, 0.1667F, 10.1667F, 4.0F, 0.0F, 6.0F).build(), JsonPose.offset(0.0F, 13.8333F, -0.1667F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 11, -2.0F, -10.0F, -6.0F, 4.0F, 5.0F, 6.0F).addBox(0, 22, -1.5F, -10.0F, -9.0F, 3.0F, 4.0F, 3.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }

    private static JsonModel.Builder createLegacyVelociraptorBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 32);

        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(0, 17, -3.0F, -7.0F, -8.0F, 6.0F, 7.0F, 8.0F).build(), JsonPose.offsetAndRotation(0.0F, 5.0F, -3.0F, 0.08726646F, 0.0F, 0.0F));
        builder.addOrReplaceChild("snout", elementBuilder -> elementBuilder.addBox(44, 22, -2.0F, -4.0F, -6.0F, 4.0F, 4.0F, 6.0F).build(), JsonPose.offsetAndRotation(0.0F, 5.0F, -11.0F, 0.08726646F, 0.0F, 0.0F));
        builder.addOrReplaceChild("jaw", elementBuilder -> elementBuilder.addBox(23, 0, -2.0F, 0.0F, -5.0F, 4.0F, 1.0F, 6.0F).build(), JsonPose.offset(0.0F, 5.0F, -10.0F));
        builder.addOrReplaceChild("neck", elementBuilder -> elementBuilder.addBox(3, 1, -2.0F, 0.0F, -6.0F, 4.0F, 4.0F, 6.0F).build(), JsonPose.offsetAndRotation(0.0F, 10.0F, -5.0F, -2.094395F, 0.0F, 0.0F));
        builder.addOrReplaceChild("upper_body", elementBuilder -> elementBuilder.addBox(3, 2, -3.0F, -6.0F, -5.0F, 6.0F, 6.0F, 6.0F).build(), JsonPose.offsetAndRotation(0.0F, 16.0F, -4.0F, -0.5235988F, 0.0F, 0.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -3.0F, -3.0F, -6.0F, 8.0F, 6.0F, 7.0F).build(), JsonPose.offset(-1.0F, 13.0F, 3.0F));
        builder.addOrReplaceChild("lower_body", elementBuilder -> elementBuilder.addBox(3, 1, -2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 6.0F).build(), JsonPose.offsetAndRotation(0.0F, 10.0F, 4.0F, -0.5235988F, 0.0F, 0.0F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(20, 11, -1.0F, 0.0F, 6.0F, 2.0F, 2.0F, 12.0F).build(), JsonPose.offsetAndRotation(0.0F, 10.0F, 4.0F, -0.6981317F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_thigh", elementBuilder -> elementBuilder.addBox(48, 12, -3.0F, -1.0F, -2.0F, 3.0F, 5.0F, 5.0F).build(), JsonPose.offset(-4.0F, 14.0F, 0.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(14, 8, -2.0F, 4.0F, -7.0F, 2.0F, 2.0F, 7.0F).build(), JsonPose.offsetAndRotation(-4.0F, 14.0F, 0.0F, 0.994461F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_foot", elementBuilder -> elementBuilder.addBox(30, 26, -3.0F, 8.0F, -3.0F, 3.0F, 2.0F, 4.0F).build(), JsonPose.offset(-4.0F, 14.0F, 1.0F));
        builder.addOrReplaceChild("right_hook_1", elementBuilder -> elementBuilder.addBox(32, 7, -1.0F, 5.0F, 3.0F, 1.0F, 1.0F, 3.0F).build(), JsonPose.offsetAndRotation(-4.0F, 14.0F, 0.0F, -0.8726646F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_hook_2", elementBuilder -> elementBuilder.addBox(32, 7, -1.0F, -5.0F, 5.0F, 1.0F, 1.0F, 1.0F).build(), JsonPose.offsetAndRotation(-4.0F, 14.0F, 0.0F, -2.6529F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_bicep", elementBuilder -> elementBuilder.addBox(43, 11, -2.0F, -1.0F, -1.0F, 2.0F, 3.0F, 3.0F).build(), JsonPose.offset(-3.0F, 12.0F, -6.0F));
        builder.addOrReplaceChild("right_hand", elementBuilder -> elementBuilder.addBox(20, 18, -2.0F, 2.0F, -4.0F, 2.0F, 2.0F, 4.0F).build(), JsonPose.offsetAndRotation(-3.0F, 12.0F, -6.0F, 0.994461F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_thigh", elementBuilder -> elementBuilder.addBox(48, 1, 0.0F, -1.0F, -2.0F, 3.0F, 5.0F, 5.0F).build(), JsonPose.offset(4.0F, 14.0F, 0.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(14, 8, 0.0F, 4.0F, -7.0F, 2.0F, 2.0F, 7.0F).build(), JsonPose.offsetAndRotation(4.0F, 14.0F, 0.0F, 0.994461F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_foot", elementBuilder -> elementBuilder.addBox(30, 26, 0.0F, 8.0F, -3.0F, 3.0F, 2.0F, 4.0F).build(), JsonPose.offset(4.0F, 14.0F, 1.0F));
        builder.addOrReplaceChild("left_hook_1", elementBuilder -> elementBuilder.addBox(32, 7, 0.0F, 5.0F, 3.0F, 1.0F, 1.0F, 3.0F).build(), JsonPose.offsetAndRotation(4.0F, 14.0F, 0.0F, -0.8726646F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_hook_2", elementBuilder -> elementBuilder.addBox(32, 7, 0.0F, -5.0F, 5.0F, 1.0F, 1.0F, 1.0F).build(), JsonPose.offsetAndRotation(4.0F, 14.0F, 0.0F, -2.6529F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_bicep", elementBuilder -> elementBuilder.addBox(43, 0, 0.0F, -1.0F, -1.0F, 2.0F, 3.0F, 3.0F).build(), JsonPose.offset(3.0F, 12.0F, -6.0F));
        builder.addOrReplaceChild("left_hand", elementBuilder -> elementBuilder.addBox(20, 18, 0.0F, 2.0F, -4.0F, 2.0F, 2.0F, 4.0F).build(), JsonPose.offsetAndRotation(3.0F, 12.0F, -6.0F, 0.994461F, 0.0F, 0.0F));

        return builder;
    }
}