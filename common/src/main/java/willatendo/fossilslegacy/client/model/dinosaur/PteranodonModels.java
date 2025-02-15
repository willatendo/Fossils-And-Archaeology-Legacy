package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class PteranodonModels {
    public static final JsonModel PTERANODON_MODEL = PteranodonModels.createPteranodonBodyLayer().withWalkAnimations(FAUtils.resource("pteranodon_walk")).withFlyAnimations(FAUtils.resource("pteranodon_fly"), BuiltInAnimationTypes.PTERANODON_BODY_FLY.getId()).withLandAnimations(FAUtils.resource("pteranodon_land")).withHeadPieces("head").build();
    public static final JsonModel LEGACY_PTERANODON_MODEL = PteranodonModels.createLegacyPteranodonBodyLayer().withWalkAnimations(BuiltInAnimationTypes.LEGACY_PTERANODON_WALK.getId()).withHeadAnimations(BuiltInAnimationTypes.LEGACY_PTERANODON_HEAD.getId()).build();
    public static final JsonModel LEGACY_FLYING_PTERANODON_MODEL = PteranodonModels.createLegacyFlyingPteranodonBodyLayer().withFlyAnimations(BuiltInAnimationTypes.LEGACY_PTERANODON_FLY.getId()).build();
    public static final JsonModel LEGACY_LANDING_PTERANODON_MODEL = PteranodonModels.createLegacyLandingPteranodonBodyLayer().build();

    private static JsonModel.Builder createPteranodonBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 64);

        builder.addOrReplaceChild("whole", elementBuilder -> elementBuilder.addOrReplaceChild("body", subElementBuilder -> subElementBuilder.addBox(0, 0, -3.0F, -4.0F, -2.0F, 6.0F, 9.0F, 5.0F).build(), JsonPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 0.7854F, 0.0F, 0.0F)).addOrReplaceChild("left_leg", subElementBuilder -> subElementBuilder.addBox(0, 41, -1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F).build(), JsonPose.offset(1.5F, 2.0F, 0.0F)).addOrReplaceChild("right_leg", subElementBuilder -> subElementBuilder.addBox(8, 41, -1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F).build(), JsonPose.offset(-1.5F, 2.0F, 0.0F)).addOrReplaceChild("neck", subElement1Builder -> subElement1Builder.addBox(40, 36, -1.0F, -7.0F, -2.0F, 2.0F, 8.0F, 4.0F).addOrReplaceChild("head", subElement2Builder -> subElement2Builder.addBox(0, 24, -2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 5.0F).addBox(0, 14, -1.0F, -1.0F, -13.0F, 2.0F, 1.0F, 9.0F).addBox(22, 0, -1.0F, 0.0F, -13.0F, 2.0F, 1.0F, 9.0F).addBox(18, 26, -1.0F, -4.0F, -4.0F, 2.0F, 2.0F, 7.0F).build(), JsonPose.offset(0.0F, -6.0F, -1.0F)).build(), JsonPose.offset(0.0F, -3.0F, -5.0F)).addOrReplaceChild("right_wing", subElement1Builder -> subElement1Builder.addBox(22, 10, -10.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F).addBox(0, 35, -10.0F, 1.0F, 0.0F, 10.0F, 6.0F, 0.0F).addOrReplaceChild("right_wing_tip", subElement2Builder -> subElement2Builder.addBox(22, 18, -10.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F).addBox(36, 26, -10.0F, 1.0F, 0.0F, 10.0F, 5.0F, 0.0F).build(), JsonPose.offsetAndRotation(-10.0F, 1.0F, 0.0F, 0.0F, 2.0944F, 0.0F)).build(), JsonPose.offsetAndRotation(-3.0F, -3.0F, -4.0F, 1.5708F, 0.0F, -1.0472F)).addOrReplaceChild("left_wing", subElement1Builder -> subElement1Builder.addBox(22, 14, 0.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F).addBox(20, 35, 0.0F, 1.0F, 0.0F, 10.0F, 6.0F, 0.0F).addOrReplaceChild("left_wing_tip", subElement2Builder -> subElement2Builder.addBox(22, 22, 0.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F).addBox(40, 31, 0.0F, 1.0F, 0.0F, 10.0F, 5.0F, 0.0F).build(), JsonPose.offsetAndRotation(10.0F, 1.0F, 0.0F, 0.0F, -2.0944F, 0.0F)).build(), JsonPose.offsetAndRotation(3.0F, -3.0F, -4.0F, 1.5708F, 0.0F, 1.0472F)).build(), JsonPose.offset(0.0F, 18.0F, 0.0F));

        return builder;
    }

    private static JsonModel.Builder createLegacyPteranodonBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 32);

        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(0, 23, -2.0F, -5.0F, -1.0F, 4.0F, 5.0F, 4.0F).build(), JsonPose.offsetAndRotation(0.0F, 14.0F, -4.0F, 1.571F, 0.0F, 0.0F));
        builder.addOrReplaceChild("crown", elementBuilder -> elementBuilder.addBox(16, 22, -1.0F, -5.0F, -1.0F, 2.0F, 4.0F, 6.0F).build(), JsonPose.offsetAndRotation(0.0F, 14.0F, -4.0F, 0.698F, 0.0F, 0.0F));
        builder.addOrReplaceChild("lower_mouth", elementBuilder -> elementBuilder.addBox(44, 9, -1.0F, -1.0F, -12.0F, 2.0F, 1.0F, 8.0F).build(), JsonPose.offset(0.0F, 14.0F, -4.0F));
        builder.addOrReplaceChild("upper_mouth", elementBuilder -> elementBuilder.addBox(44, 0, -1.0F, -2.0F, -12.0F, 2.0F, 1.0F, 8.0F).build(), JsonPose.offset(0.0F, 14.0F, -4.0F));
        builder.addOrReplaceChild("neck_1", elementBuilder -> elementBuilder.addBox(8, 16, -1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F).build(), JsonPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 1.130069F, 0.0F, 0.0F));
        builder.addOrReplaceChild("neck_2", elementBuilder -> elementBuilder.addBox(0, 16, -1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F).build(), JsonPose.offsetAndRotation(0.0F, 14.0F, -3.0F, 1.446489F, 0.0F, 0.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -2.0F, -3.0F, -2.0F, 4.0F, 7.0F, 4.0F).build(), JsonPose.offsetAndRotation(0.0F, 18.0F, 2.0F, 0.587636F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_wing_1", elementBuilder -> elementBuilder.addBox(16, 7, 0.0F, 0.0F, -1.0F, 8.0F, 6.0F, 1.0F).build(), JsonPose.offsetAndRotation(-2.0F, 16.0F, 1.0F, -0.349F, 2.269F, -0.524F));
        builder.addOrReplaceChild("right_wing_2", elementBuilder -> elementBuilder.addBox(46, 18, -1.0F, -1.0F, -1.0F, 8.0F, 4.0F, 1.0F).build(), JsonPose.offsetAndRotation(-6.9F, 20.0F, -4.0F, 2.541F, -0.419F, -3.002F));
        builder.addOrReplaceChild("left_wing_1", elementBuilder -> elementBuilder.addBox(16, 0, 0.0F, 0.0F, 0.0F, 8.0F, 6.0F, 1.0F).build(), JsonPose.offsetAndRotation(2.0F, 16.0F, 1.0F, 0.349F, 0.873F, 0.542F));
        builder.addOrReplaceChild("left_wing_2", elementBuilder -> elementBuilder.addBox(46, 23, -1.0F, -1.0F, 0.0F, 8.0F, 4.0F, 1.0F).build(), JsonPose.offsetAndRotation(6.9F, 20.0F, -4.0F, 0.583F, -0.419F, -0.140F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(40, 4, -1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F).build(), JsonPose.offsetAndRotation(-1.0F, 22.0F, 2.0F, -0.2712166F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(40, 0, 0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F).build(), JsonPose.offsetAndRotation(1.0F, 22.0F, 2.0F, -0.2712166F, 0.0F, 0.0F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(0, 11, -2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 2.0F).build(), JsonPose.offsetAndRotation(0.0F, 20.0F, 5.0F, 0.2260139F, 0.0F, 0.0F));

        return builder;
    }

    private static JsonModel.Builder createLegacyLandingPteranodonBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 32);

        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(0, 23, -2.0F, -4.0F, 0.0F, 4.0F, 5.0F, 4.0F).build(), JsonPose.offsetAndRotation(0.0F, 16.0F, -5.0F, 2.12453F, 0.0F, 0.0F));
        builder.addOrReplaceChild("crown", elementBuilder -> elementBuilder.addBox(16, 22, -1.0F, -4.0F, -2.0F, 2.0F, 4.0F, 6.0F).build(), JsonPose.offsetAndRotation(0.0F, 13.0F, -6.0F, 1.084867F, 0.0F, 0.0F));
        builder.addOrReplaceChild("lower_mouth", elementBuilder -> elementBuilder.addBox(44, 9, -1.0F, 0.0F, -8.0F, 2.0F, 1.0F, 8.0F).build(), JsonPose.offsetAndRotation(0.0F, 16.0F, -8.0F, 0.7684471F, 0.0F, 0.0F));
        builder.addOrReplaceChild("upper_mouth", elementBuilder -> elementBuilder.addBox(44, 0, -1.0F, -1.0F, -8.0F, 2.0F, 1.0F, 8.0F).build(), JsonPose.offsetAndRotation(0.0F, 17.0F, -9.0F, 0.5235988F, 0.0F, 0.0F));
        builder.addOrReplaceChild("neck_1", elementBuilder -> elementBuilder.addBox(8, 16, -1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F).build(), JsonPose.offsetAndRotation(0.0F, 16.0F, 0.0F, 1.130069F, 0.0F, 0.0F));
        builder.addOrReplaceChild("neck_2", elementBuilder -> elementBuilder.addBox(0, 16, -1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F).build(), JsonPose.offsetAndRotation(0.0F, 15.0F, -3.0F, 1.446489F, 0.0F, 0.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -2.0F, -3.0F, -2.0F, 4, 7.0F, 4.0F).build(), JsonPose.offsetAndRotation(0.0F, 17.0F, 2.0F, 0.587636F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_wing_1", elementBuilder -> elementBuilder.addBox(16, 7, 0.0F, 0.0F, -1.0F, 8.0F, 6.0F, 1.0F).build(), JsonPose.offsetAndRotation(-2.0F, 14.0F, 1.0F, 2.617994F, -0.4363323F, -2.792527F));
        builder.addOrReplaceChild("right_wing_2", elementBuilder -> elementBuilder.addBox(46, 18, 0.0F, 0.0F, 0.0F, 8.0F, 4.0F, 1.0F).build(), JsonPose.offsetAndRotation(-8.0F, 11.0F, 5.0F, -0.6108652F, 3.141593F, 0.0F));
        builder.addOrReplaceChild("left_wing_1", elementBuilder -> elementBuilder.addBox(16, 0, 0.0F, 0.0F, 0.0F, 8.0F, 6.0F, 1.0F).build(), JsonPose.offsetAndRotation(2.0F, 14.0F, 1.0F, -2.617994F, -2.740167F, 2.792527F));
        builder.addOrReplaceChild("left_wing_2", elementBuilder -> elementBuilder.addBox(46, 23, 0.0F, 0.0F, -1.0F, 8.0F, 4.0F, 1.0F).build(), JsonPose.offsetAndRotation(8.0F, 11.0F, 5.0F, 0.6108652F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(40, 4, -1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F).build(), JsonPose.offsetAndRotation(-1.0F, 21.0F, 2.0F, 0.2712166F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(40, 0, 0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F).build(), JsonPose.offsetAndRotation(1.0F, 21.0F, 2.0F, -0.2712166F, 0.0F, 0.0F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(0, 11, -1.0F, 0.0F, -2.0F, 2.0F, 3.0F, 2.0F).build(), JsonPose.offsetAndRotation(0.0F, 19.0F, 5.0F, 0.2260139F, 0.0F, 0.0F));

        return builder;
    }

    private static JsonModel.Builder createLegacyFlyingPteranodonBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 32);

        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(0, 23, -2.0F, -13.0F, -1.0F, 4.0F, 5.0F, 4.0F).build(), JsonPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        builder.addOrReplaceChild("crown", elementBuilder -> elementBuilder.addBox(16, 22, -1.0F, -10.0F, -9.0F, 2.0F, 4.0F, 6.0F).build(), JsonPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 0.4859298F, 0.0F, 0.0F));
        builder.addOrReplaceChild("lower_mouth", elementBuilder -> elementBuilder.addBox(44, 9, -1.0F, -2.0F, -20.0F, 2.0F, 1.0F, 8.0F).build(), JsonPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 0.1356083F, 0.0F, 0.0F));
        builder.addOrReplaceChild("upper_mouth", elementBuilder -> elementBuilder.addBox(44, 0, -1.0F, -1.0F, -21.0F, 2.0F, 1.0F, 8.0F).build(), JsonPose.offset(0.0F, 23.0F, 0.0F));
        builder.addOrReplaceChild("neck_1", elementBuilder -> elementBuilder.addBox(8, 16, -1.0F, -7.0F, -1.0F, 2.0F, 4.0F, 2.0F).build(), JsonPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        builder.addOrReplaceChild("neck_2", elementBuilder -> elementBuilder.addBox(0, 16, -1.0F, -11.0F, -1.0F, 2.0F, 4.0F, 2.0F).build(), JsonPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -2.0F, -3.5F, -2.0F, 4.0F, 7.0F, 4.0F).build(), JsonPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_wing_1", elementBuilder -> elementBuilder.addBox(16, 7, 2.0F, -3.0F, -1.0F, 8.0F, 6.0F, 1.0F).build(), JsonPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, -2.792527F));
        builder.addOrReplaceChild("right_wing_2", elementBuilder -> elementBuilder.addBox(46, 18, 9.0F, -3.0F, -4.0F, 8.0F, 4.0F, 1.0F).build(), JsonPose.offsetAndRotation(0.0F, 23.0F, 0.0F, -1.570796F, 3.141593F, 0.0F));
        builder.addOrReplaceChild("left_wing_1", elementBuilder -> elementBuilder.addBox(16, 0, 2.0F, -3.0F, 0.0F, 8.0F, 6.0F, 1.0F).build(), JsonPose.offsetAndRotation(0.0F, 23.0F, 0.0F, -1.570796F, 3.141593F, 2.792527F));
        builder.addOrReplaceChild("left_wing_2", elementBuilder -> elementBuilder.addBox(46, 23, 9.0F, -3.0F, 3.0F, 8.0F, 4.0F, 1.0F).build(), JsonPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(40, 4, -2.0F, 3.0F, -2.0F, 1.0F, 3.0F, 1.0F).build(), JsonPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(40, 0, 1.0F, 3.0F, -2.0F, 1.0F, 3.0F, 1.0F).build(), JsonPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(0, 11, -2.0F, 2.0F, 0.0F, 4.0F, 3.0F, 2.0F).build(), JsonPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));

        return builder;
    }
}
