package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class TyrannosaurusModels {
    public static final JsonModel TYRANNOSAURUS_MODEL = TyrannosaurusModels.createTyrannosaurusBodyLayer().withWalkAnimations(FAUtils.resource("tyrannosaurus_walk")).withHeadPieces("neck").build();
    public static final JsonModel KNOCKED_OUT_TYRANNOSAURUS_MODEL = TyrannosaurusModels.createKnockedOutTyrannosaurusBodyLayer().build();
    public static final JsonModel LEGACY_TYRANNOSAURUS_MODEL = TyrannosaurusModels.createLegacyTyrannosaurusBodyLayer().withWalkAnimations(BuiltInAnimationTypes.LEGACY_TYRANNOSAURUS_WALK.getId()).withHeadAnimations(BuiltInAnimationTypes.LEGACY_TYRANNOSAURUS_HEAD.getId()).overrideReset().build();
    public static final JsonModel LEGACY_KNOCKED_OUT_TYRANNOSAURUS_MODEL = TyrannosaurusModels.createLegacyKnockedOutTyrannosaurusBodyLayer().build();

    private static JsonModel.Builder createTyrannosaurusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(128, 128);

        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(0, 34, -3.0F, -3.0F, 0.0F, 6.0F, 7.0F, 7.0F).addBox(0, 19, -2.0F, -3.0F, 7.0F, 4.0F, 4.0F, 11.0F).build(), JsonPose.offset(0.0F, 10.0F, 8.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(56, 14, -2.0F, 9.0F, -2.0F, 3.0F, 2.0F, 5.0F).addBox(56, 28, -2.0F, 5.0F, 1.0F, 2.0F, 4.0F, 2.0F).addBox(46, 34, -2.0F, -4.0F, -3.0F, 4.0F, 9.0F, 6.0F).build(), JsonPose.offset(4.0F, 13.0F, 4.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(0, 48, -2.0F, -4.0F, -3.0F, 4.0F, 9.0F, 6.0F).addBox(60, 0, 0.0F, 5.0F, 1.0F, 2.0F, 4.0F, 2.0F).addBox(56, 21, -1.0F, 9.0F, -2.0F, 3.0F, 2.0F, 5.0F).build(), JsonPose.offset(-4.0F, 13.0F, 4.0F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(34, 14, -1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F).build(), JsonPose.offset(3.0F, 14.0F, -6.0F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(42, 14, -1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F).build(), JsonPose.offset(-3.0F, 14.0F, -6.0F));
        builder.addOrReplaceChild("neck", elementBuilder -> elementBuilder.addBox(26, 34, -2.0F, -9.0F, -4.0F, 4.0F, 12.0F, 6.0F).addOrReplaceChild("head", subElement1Builder -> subElement1Builder.addBox(34, 0, -3.0F, -4.0F, -6.0F, 6.0F, 7.0F, 7.0F).addBox(46, 49, -2.0F, -3.0F, -13.0F, 4.0F, 4.0F, 7.0F).addBox(20, 52, -2.0F, 1.0F, -13.0F, 4.0F, 2.0F, 7.0F).build(), JsonPose.offset(0.0F, -5.0F, -3.0F)).build(), JsonPose.offset(0.0F, 11.0F, -7.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -4.0F, -17.0F, -1.0F, 8.0F, 10.0F, 9.0F).addBox(30, 19, -3.0F, -17.0F, -8.0F, 6.0F, 8.0F, 7.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }

    private static JsonModel.Builder createKnockedOutTyrannosaurusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(128, 128);

        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(0, 34, -3.0F, 4.0F, 0.0F, 6.0F, 7.0F, 7.0F).addBox(0, 19, -2.0F, 4.0F, 7.0F, 4.0F, 4.0F, 11.0F).build(), JsonPose.offset(0.0F, 10.0F, 8.0F));

        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(56, 14, -2.0F, 10.0F, -2.0F, 3.0F, 2.0F, 5.0F).addBox(56, 28, -2.0F, 6.0F, 1.0F, 2.0F, 4.0F, 2.0F).addBox(46, 34, -2.0F, -3.0F, -3.0F, 4.0F, 9.0F, 6.0F).build(), JsonPose.offsetAndRotation(6.0F, 21.0F, 4.0F, -1.5708F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(0, 48, -2.0F, -4.0F, -3.0F, 4.0F, 9.0F, 6.0F).addBox(60, 0, 0.0F, 5.0F, 1.0F, 2.0F, 4.0F, 2.0F).addBox(56, 21, -1.0F, 9.0F, -2.0F, 3.0F, 2.0F, 5.0F).build(), JsonPose.offsetAndRotation(-6.0F, 21.0F, 3.0F, -1.5708F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(34, 14, -1.0F, 6.0F, -1.0F, 2.0F, 3.0F, 2.0F).build(), JsonPose.offset(3.0F, 14.0F, -6.0F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(42, 14, -1.0F, 6.0F, -1.0F, 2.0F, 3.0F, 2.0F).build(), JsonPose.offset(-3.0F, 14.0F, -6.0F));
        builder.addOrReplaceChild("neck", elementBuilder -> elementBuilder.addBox(26, 34, -2.0F, -8.0F, -4.0F, 4.0F, 12.0F, 6.0F).addOrReplaceChild("head", subElement1Builder -> subElement1Builder.addBox(34, 0, -3.0F, -3.0F, -6.0F, 6.0F, 7.0F, 7.0F).addBox(46, 49, -2.0F, -2.0F, -13.0F, 4.0F, 4.0F, 7.0F).addBox(20, 52, -2.0F, 2.0F, -13.0F, 4.0F, 2.0F, 7.0F).build(), JsonPose.offsetAndRotation(0.0F, -5.0F, -2.0F, -1.5708F, 0.0F, 0.0F)).build(), JsonPose.offsetAndRotation(0.0F, 17.0F, -7.0F, 1.5708F, 0.0F, 0.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -4.0F, -10.0F, -1.0F, 8.0F, 10.0F, 9.0F).addBox(30, 19, -3.0F, -10.0F, -8.0F, 6.0F, 8.0F, 7.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }

    private static JsonModel.Builder createLegacyTyrannosaurusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 32);

        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(0, 16, -4.0F, 0.0F, -6.0F, 8.0F, 8.0F, 6.0F).build(), JsonPose.offsetAndRotation(0.0F, 0.0F, -8.0F, -7.905835E-16F, 0.0F, 0.0F));
        builder.addOrReplaceChild("snout", elementBuilder -> elementBuilder.addBox(34, 18, -4.0F, 1.0F, -11.0F, 6.0F, 6.0F, 8.0F).build(), JsonPose.offset(1.0F, 0.0F, -8.0F));
        builder.addOrReplaceChild("jaw", elementBuilder -> elementBuilder.addBox(12, 23, -4.0F, 6.0F, -10.0F, 4.0F, 2.0F, 7.0F).build(), JsonPose.offset(2.0F, 1.0F, -8.0F));
        builder.addOrReplaceChild("neck", elementBuilder -> elementBuilder.addBox(1, 0, -5.0F, 0.0F, -6.0F, 8.0F, 11.0F, 12.0F).build(), JsonPose.offsetAndRotation(1.0F, 6.0F, 2.0F, -0.4068249F, 0.0F, 0.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(4, 2, -3.0F, 0.0F, -10.0F, 6.0F, 8.0F, 10.0F).build(), JsonPose.offsetAndRotation(0.0F, 9.0F, -1.0F, -0.9948377F, 0.0F, 0.0F));
        builder.addOrReplaceChild("tail_base", elementBuilder -> elementBuilder.addBox(4, 4, -3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 10.0F).build(), JsonPose.offsetAndRotation(0.0F, 8.0F, 6.0F, -0.7684471F, 0.0F, 0.0F));
        builder.addOrReplaceChild("tail_mid", elementBuilder -> elementBuilder.addBox(5, 2, -2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 10.0F).build(), JsonPose.offsetAndRotation(0.0F, 15.0F, 12.0F, -0.5424333F, 0.0F, 0.0F));
        builder.addOrReplaceChild("tail_end", elementBuilder -> elementBuilder.addBox(10, 6, -1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 6.0F).build(), JsonPose.offsetAndRotation(0.0F, 20.0F, 19.0F, -0.3616222F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_thigh", elementBuilder -> elementBuilder.addBox(40, 2, -4.0F, -4.0F, -4.0F, 4.0F, 8.0F, 8.0F).build(), JsonPose.offset(-4.0F, 14.0F, 2.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(0, 9, -2.0F, 0.0F, 3.0F, 2.0F, 8.0F, 3.0F).build(), JsonPose.offsetAndRotation(-4.0F, 14.0F, 2.0F, -0.6108652F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_foot", elementBuilder -> elementBuilder.addBox(36, 0, -3.0F, 8.0F, -5.0F, 3.0F, 2.0F, 8.0F).build(), JsonPose.offset(-4.0F, 14.0F, 2.0F));
        builder.addOrReplaceChild("left_thigh", elementBuilder -> elementBuilder.addBox(40, 2, 0.0F, -4.0F, -4.0F, 4.0F, 8.0F, 8.0F).build(), JsonPose.offset(4.0F, 14.0F, 2.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(0, 9, 0.0F, 0.0F, 3.0F, 2.0F, 8.0F, 3.0F).build(), JsonPose.offsetAndRotation(4.0F, 14.0F, 2.0F, -0.6108652F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_foot", elementBuilder -> elementBuilder.addBox(36, 0, 0.0F, 8.0F, -5.0F, 3.0F, 2.0F, 8.0F).build(), JsonPose.offset(4.0F, 14.0F, 2.0F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(34, 0, -2.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F).build(), JsonPose.offsetAndRotation(-2.0F, 10.0F, -9.0F, 0.6328388F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(34, 0, 0.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F).build(), JsonPose.offsetAndRotation(2.0F, 10.0F, -9.0F, 0.6328388F, 0.0F, 0.0F));

        return builder;
    }

    private static JsonModel.Builder createLegacyKnockedOutTyrannosaurusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 32);

        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(0, 16, -4.0F, 0.0F, -6.0F, 8.0F, 8.0F, 6.0F).build(), JsonPose.offsetAndRotation(0.0F, 16.0F, -8.0F, -7.905835E-16F, 0.0F, 0.0F));
        builder.addOrReplaceChild("snout", elementBuilder -> elementBuilder.addBox(34, 18, -4.0F, 1.0F, -11.0F, 6.0F, 6.0F, 8.0F).build(), JsonPose.offset(1.0F, 16.0F, -8.0F));
        builder.addOrReplaceChild("jaw", elementBuilder -> elementBuilder.addBox(12, 23, -4.0F, 6.0F, -10.0F, 4.0F, 2.0F, 7.0F).build(), JsonPose.offset(2.0F, 16.0F, -8.0F));
        builder.addOrReplaceChild("neck", elementBuilder -> elementBuilder.addBox(1, 0, -5.0F, 0.0F, -6.0F, 8.0F, 11.0F, 12.0F).build(), JsonPose.offset(1.0F, 13.0F, 4.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(4, 2, -3.0F, 0.0F, -10.0F, 6.0F, 8.0F, 10.0F).build(), JsonPose.offsetAndRotation(0.0F, 13.0F, -1.0F, 0.3164194F, 0.0F, 0.0F));
        builder.addOrReplaceChild("tail_base", elementBuilder -> elementBuilder.addBox(4, 4, -3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 10.0F).build(), JsonPose.offsetAndRotation(0.0F, 14.0F, 9.0F, -0.3616222F, 0.4972305F, 0.0F));
        builder.addOrReplaceChild("tail_mid", elementBuilder -> elementBuilder.addBox(5, 2, -2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 10.0F).build(), JsonPose.offsetAndRotation(2.0F, 17.0F, 16.0F, -0.4520277F, 1.6273F, 0.0F));
        builder.addOrReplaceChild("tail_end", elementBuilder -> elementBuilder.addBox(10, 6, -1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 6.0F).build(), JsonPose.offsetAndRotation(12.0F, 22.0F, 11.0F, 0.0F, -0.4520277F, 0.0F));
        builder.addOrReplaceChild("right_thigh", elementBuilder -> elementBuilder.addBox(40, 2, -4.0F, -4.0F, -4.0F, 4.0F, 8.0F, 8.0F).build(), JsonPose.offset(-2.0F, 19.0F, 5.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(0, 9, -1.0F, -3.0F, 0.0F, 2.0F, 8.0F, 3.0F).build(), JsonPose.offsetAndRotation(-4.0F, 25.0F, 4.0F, 1.570796F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_foot", elementBuilder -> elementBuilder.addBox(36, 0, -2.0F, 0.0F, -6.0F, 3.0F, 2.0F, 8.0F).build(), JsonPose.offset(-6.0F, 23.0F, 4.0F));
        builder.addOrReplaceChild("left_thigh", elementBuilder -> elementBuilder.addBox(40, 2, 0.0F, -4.0F, -4.0F, 4.0F, 8.0F, 8.0F).build(), JsonPose.offset(2.0F, 19.0F, 5.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(0, 9, -1.0F, -3.0F, 0.0F, 2.0F, 8.0F, 3.0F).build(), JsonPose.offsetAndRotation(4.0F, 25.0F, 4.0F, 1.570796F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_foot", elementBuilder -> elementBuilder.addBox(36, 0, -1.0F, 0.0F, -6.0F, 3.0F, 2.0F, 8.0F).build(), JsonPose.offset(6.0F, 23.0F, 4.0F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(34, 0, -2.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F).build(), JsonPose.offsetAndRotation(-2.0F, 22.0F, -4.0F, 0.994461F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(34, 0, 0.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F).build(), JsonPose.offsetAndRotation(2.0F, 22.0F, -4.0F, 1.039664F, 0.0F, 0.0F));

        return builder;
    }
}
