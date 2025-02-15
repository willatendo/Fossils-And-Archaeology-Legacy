package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class StegosaurusModels {
    public static final JsonModel STEGOSAURUS_MODEL = StegosaurusModels.createStegosaurusBodyLayer().withWalkAnimations(FAUtils.resource("stegosaurus_walk")).withHeadPieces("head").build();
    public static final JsonModel LEGACY_STEGOSAURUS_MODEL = StegosaurusModels.createLegacyStegosaurusBodyLayer().withWalkAnimations(BuiltInAnimationTypes.LEGACY_STEGOSAURUS_WALK.getId()).build();

    private static JsonModel.Builder createStegosaurusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(128, 128);

        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(62, 51, -2.0F, -5.0F, -4.0F, 4.0F, 11.0F, 7.0F).addBox(84, 24, -2.0F, 6.0F, 0.0F, 3.0F, 6.0F, 3.0F).build(), JsonPose.offset(6.0F, 12.0F, 3.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(84, 51, -1.0F, 4.0F, 0.0F, 3.0F, 6.0F, 3.0F).addBox(0, 67, -2.0F, -7.0F, -4.0F, 4.0F, 11.0F, 7.0F).build(), JsonPose.offset(-6.0F, 14.0F, 3.0F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(82, 0, -1.5F, -1.0F, -1.5F, 3.0F, 9.0F, 3.0F).build(), JsonPose.offset(3.5F, 16.0F, -9.5F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(84, 12, -1.5F, -1.0F, -1.5F, 3.0F, 9.0F, 3.0F).build(), JsonPose.offset(-3.5F, 16.0F, -9.5F));
        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(32, 66, -2.0F, -2.0F, -9.0F, 4.0F, 5.0F, 9.0F).build(), JsonPose.offset(0.0F, 12.0F, -13.0F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(0, 50, -2.0F, -4.0F, 0.0F, 6.0F, 7.0F, 10.0F).addBox(50, 0, -1.0F, -4.0F, 10.0F, 4.0F, 3.0F, 12.0F).addBox(58, 69, 3.0F, -10.0F, 0.0F, 0.0F, 6.0F, 10.0F).addBox(60, 15, 2.0F, -10.0F, 10.0F, 0.0F, 6.0F, 12.0F).addBox(78, 69, -1.0F, -10.0F, 0.0F, 0.0F, 6.0F, 10.0F).addBox(62, 33, 0.0F, -10.0F, 10.0F, 0.0F, 6.0F, 12.0F).build(), JsonPose.offset(-1.0F, 8.0F, 9.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -5.0F, -20.0F, -6.0F, 10.0F, 13.0F, 15.0F).addBox(32, 50, -4.0F, -16.0F, -13.0F, 8.0F, 9.0F, 7.0F).addBox(0, 28, 3.0F, -27.0F, -6.0F, 0.0F, 7.0F, 15.0F).addBox(22, 80, 2.0F, -23.0F, -13.0F, 0.0F, 7.0F, 7.0F).addBox(30, 28, -3.0F, -27.0F, -6.0F, 0.0F, 7.0F, 15.0F).addBox(36, 80, -2.0F, -23.0F, -13.0F, 0.0F, 7.0F, 7.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }

    private static JsonModel.Builder createLegacyStegosaurusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 32);

        builder.addOrReplaceChild("front_body", elementBuilder -> elementBuilder.addBox(46, 14, -2.0F, 2.0F, -4.0F, 5.0F, 5.0F, 4.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 14.0F, -6.0F, 0.1745329F, 0.0F, 0.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(20, 0, -3.0F, 0.0F, 0.0F, 7.0F, 8.0F, 8.0F, true).build(), JsonPose.offset(0.0F, 14.0F, -6.0F));
        builder.addOrReplaceChild("back_plates_1", elementBuilder -> elementBuilder.addBox(0, 0, 0.0F, -2.5F, 8.0F, 1.0F, 5.0F, 3.0F, true).build(), JsonPose.offset(0.0F, 14.0F, -1.0F));
        builder.addOrReplaceChild("back_body", elementBuilder -> elementBuilder.addBox(32, 24, -0.5F, 3.5F, -8.0F, 2.0F, 3.0F, 5.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 14.0F, -6.0F, 0.1745329F, 0.0F, 0.0F));
        builder.addOrReplaceChild("back_plates_2", elementBuilder -> elementBuilder.addBox(12, 13, -0.5F, -3.5F, 2.0F, 2.0F, 5.0F, 4.0F, true).build(), JsonPose.offset(0.0F, 14.0F, -1.0F));
        builder.addOrReplaceChild("tail_1", elementBuilder -> elementBuilder.addBox(46, 23, -2.0F, 1.5F, 2.0F, 5.0F, 5.0F, 4.0F, true).build(), JsonPose.offset(0.0F, 14.0F, -1.0F));
        builder.addOrReplaceChild("back_plates_3", elementBuilder -> elementBuilder.addBox(0, 13, -0.5F, -3.0F, -3.0F, 2.0F, 5.0F, 4.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 14.0F, -6.0F, 0.2617994F, 0.0F, 0.0F));
        builder.addOrReplaceChild("tail_2", elementBuilder -> elementBuilder.addBox(32, 16, -1.0F, 2.0F, 4.5F, 3.0F, 3.0F, 4.0F, true).build(), JsonPose.offset(0.0F, 14.0F, -1.0F));
        builder.addOrReplaceChild("tail_3", elementBuilder -> elementBuilder.addBox(52, 6, -0.5F, 2.5F, 7.5F, 2.0F, 2.0F, 4.0F, true).build(), JsonPose.offset(0.0F, 14.0F, -1.0F));
        builder.addOrReplaceChild("thagomizer", elementBuilder -> elementBuilder.addBox(0, 0, -0.5F, -5.0F, 0.0F, 2.0F, 5.0F, 8.0F, true).build(), JsonPose.offset(0.0F, 14.0F, -6.0F));
        builder.addOrReplaceChild("right_front_leg", elementBuilder -> elementBuilder.addBox(44, 0, -1.0F, -1.5F, -2.0F, 2.0F, 3.0F, 3.0F, true).build(), JsonPose.offset(4.0F, 20.0F, -6.0F));
        builder.addOrReplaceChild("right_front_foot", elementBuilder -> elementBuilder.addBox(12, 0, -0.5F, 0.0F, -4.0F, 1.0F, 2.0F, 3.0F, true).build(), JsonPose.offsetAndRotation(4.0F, 20.0F, -6.0F, 0.8726646F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_front_leg", elementBuilder -> elementBuilder.addBox(54, 0, -2.0F, -1.5F, -2.0F, 2.0F, 3.0F, 3.0F, true).build(), JsonPose.offset(-2.0F, 20.0F, -6.0F));
        builder.addOrReplaceChild("left_front_foot", elementBuilder -> elementBuilder.addBox(20, 0, -1.5F, 0.0F, -4.0F, 1.0F, 2.0F, 3.0F, true).build(), JsonPose.offsetAndRotation(-2.0F, 20.0F, -6.0F, 0.8726646F, 0.0F, 0.0F));
        builder.addOrReplaceChild("right_back_leg", elementBuilder -> elementBuilder.addBox(14, 22, -1.0F, -2.5F, -2.0F, 2.0F, 5.0F, 5.0F, true).build(), JsonPose.offset(4.0F, 19.0F, 1.0F));
        builder.addOrReplaceChild("right_back_foot", elementBuilder -> elementBuilder.addBox(24, 16, -0.5F, 2.5F, -4.0F, 1.0F, 2.0F, 3.0F, true).build(), JsonPose.offsetAndRotation(4.0F, 19.0F, 1.0F, 1.22173F, 0F, 0F));
        builder.addOrReplaceChild("left_back_leg", elementBuilder -> elementBuilder.addBox(0, 22, -2.0F, -2.5F, -2.0F, 2.0F, 5.0F, 5.0F, true).build(), JsonPose.offset(-2.0F, 19.0F, 1.0F));
        builder.addOrReplaceChild("left_back_foot", elementBuilder -> elementBuilder.addBox(24, 21, -1.5F, 2.5F, -4.0F, 1.0F, 2.0F, 3.0F, true).build(), JsonPose.offsetAndRotation(-2.0F, 19.0F, 1.0F, 1.22173F, 0F, 0F));

        return builder;
    }
}
