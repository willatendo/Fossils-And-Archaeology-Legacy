package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class MammothModels {
    public static final JsonModel MAMMOTH_MODEL = MammothModels.createMammothBodyLayer().withWalkAnimations(FAUtils.resource("mammoth_walk")).withHeadPieces("head").build();
    public static final JsonModel LEGACY_MAMMOTH_MODEL = MammothModels.createLegacyMammothBodyLayer().withWalkAnimations(BuiltInAnimationTypes.LEGACY_MAMMOTH_WALK.getId()).build();

    private static JsonModel.Builder createMammothBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 64);

        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(12, 48, -1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F).build(), JsonPose.offset(2.5F, 17.0F, -2.5F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(0, 48, -1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F).build(), JsonPose.offset(-2.5F, 17.0F, -2.5F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(52, 15, -1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F).build(), JsonPose.offset(2.0F, 18.0F, 9.5F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(24, 53, -1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F).build(), JsonPose.offset(-2.0F, 18.0F, 9.5F));
        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(38, 0, -3.0F, -5.0F, -6.0F, 6.0F, 8.0F, 7.0F).addBox(38, 25, 3.0F, -5.0F, -1.0F, 5.0F, 7.0F, 0.0F).addBox(48, 25, -8.0F, -5.0F, -1.0F, 5.0F, 7.0F, 0.0F).addBox(48, 54, 2.0F, 1.0F, -5.0F, 2.0F, 7.0F, 2.0F).addBox(24, 48, 2.0F, 6.0F, -7.0F, 2.0F, 2.0F, 2.0F).addBox(0, 58, 2.0F, 4.0F, -9.0F, 2.0F, 4.0F, 2.0F).addBox(56, 54, -4.0F, 1.0F, -5.0F, 2.0F, 7.0F, 2.0F).addBox(16, 58, -4.0F, 6.0F, -7.0F, 2.0F, 2.0F, 2.0F).addBox(8, 58, -4.0F, 4.0F, -9.0F, 2.0F, 4.0F, 2.0F).addOrReplaceChild("tuff_1", subElementBuilder -> subElementBuilder.addBox(32, 43, 0.0F, -1.5F, -3.5F, 0.0F, 3.0F, 7.0F).build(), JsonPose.offsetAndRotation(0.0F, -6.5F, -2.5F, 0.0F, 0.7854F, 0.0F)).addOrReplaceChild("tuff_2", subElementBuilder -> subElementBuilder.addBox(38, 15, 0.0F, -1.5F, -3.5F, 0.0F, 3.0F, 7.0F).build(), JsonPose.offsetAndRotation(0.0F, -6.5F, -2.5F, 0.0F, -0.7854F, 0.0F)).addOrReplaceChild("trunk", subElement1Builder -> subElement1Builder.addBox(36, 54, -1.5F, -1.5F, -3.0F, 3.0F, 6.0F, 3.0F).addOrReplaceChild("trunk_end", subElement2Builder -> subElement2Builder.addBox(46, 43, -1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F).build(), JsonPose.offset(0.0F, 4.5F, -1.5F)).build(), JsonPose.offset(0.0F, -0.5F, -6.0F)).build(), JsonPose.offset(0.0F, 10.0F, -5.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 32, -4.0F, -14.0F, 4.0F, 8.0F, 8.0F, 8.0F).addBox(0, 0, -5.0F, -17.0F, -5.0F, 10.0F, 10.0F, 9.0F).addBox(0, 19, -5.0F, -7.0F, -5.0F, 10.0F, 4.0F, 9.0F).addBox(32, 32, -4.0F, -6.0F, 4.0F, 8.0F, 3.0F, 8.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }

    private static JsonModel.Builder createLegacyMammothBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 32);

        builder.addOrReplaceChild("head", elementBuilder -> elementBuilder.addBox(46, 11, -2.0F, -3.0F, -3.5F, 4.0F, 5.0F, 5.0F, true).build(), JsonPose.offset(0.0F, 15.5F, -1.5F));
        builder.addOrReplaceChild("hair", elementBuilder -> elementBuilder.addBox(42, 21, -2.5F, -4.0F, -4.0F, 5.0F, 5.0F, 6.0F, true).build(), JsonPose.offset(0.0F, 15.5F, -1.5F));
        builder.addOrReplaceChild("hair_tuff_1", elementBuilder -> elementBuilder.addBox(8, 24, 0.0F, -7.0F, -2.5F, 0.0F, 3.0F, 5.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 15.5F, -1.5F, 0.0F, 0.7853982F, 0.0F));
        builder.addOrReplaceChild("hair_tuff_2", elementBuilder -> elementBuilder.addBox(8, 24, 0.0F, -7.0F, -2.5F, 0.0F, 3.0F, 5.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 15.5F, -1.5F, 0.0F, -0.7853982F, 0.0F));
        builder.addOrReplaceChild("front_hair", elementBuilder -> elementBuilder.addBox(0, 0, -3.5F, -2.5F, 0.5F, 7.0F, 9.0F, 7.0F, true).build(), JsonPose.offset(0.0F, 16.0F, -4.0F));
        builder.addOrReplaceChild("back_hair", elementBuilder -> elementBuilder.addBox(30, 8, -3.0F, 4.0F, 3.0F, 6.0F, 2.0F, 3.0F, true).build(), JsonPose.offset(0.0F, 16.0F, 0.0F));
        builder.addOrReplaceChild("right_tooth", elementBuilder -> elementBuilder.addBox(30, 5, 0.0F, 1.0F, -9.5F, 0.0F, 7.0F, 8.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 15.5F, -1.5F, 0.0F, 0.0F, 0.5235988F));
        builder.addOrReplaceChild("left_tooth", elementBuilder -> elementBuilder.addBox(30, 5, 0.0F, 1.0F, -9.5F, 0.0F, 7.0F, 8.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 15.5F, -1.5F, 0.0F, 0.0F, -0.5235988F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(18, 20, -3.0F, -2.0F, -3.0F, 6.0F, 6.0F, 6.0F, true).build(), JsonPose.offset(0.0F, 16F, 0.0F));
        builder.addOrReplaceChild("back", elementBuilder -> elementBuilder.addBox(30, 0, -3.0F, 0.0F, 3.0F, 6.0F, 4.0F, 3.0F, true).build(), JsonPose.offset(0.0F, 16.0F, 0.0F));
        builder.addOrReplaceChild("nose_top", elementBuilder -> elementBuilder.addBox(0, 21, -1.0F, 1.0F, -3.5F, 2.0F, 4.0F, 2.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 15.5F, -1.5F, -0.1897142F, 0.0F, 0.0F));
        builder.addOrReplaceChild("nose_bottom", elementBuilder -> elementBuilder.addBox(0, 27, -1.0F, 5.0F, -1.5F, 2.0F, 3.0F, 2.0F, true).build(), JsonPose.offsetAndRotation(0.0F, 15.5F, -1.5F, -0.5986789F, 0.0F, 0.0F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(56, 0, -1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, true).build(), JsonPose.offset(1.5F, 17.0F, -1.0F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(48, 0, -1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, true).build(), JsonPose.offset(-1.5F, 17.0F, -1.0F));
        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(56, 0, -1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, true).build(), JsonPose.offset(-1.5F, 17.0F, 4.5F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(48, 0, -1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, true).build(), JsonPose.offset(1.5F, 17.0F, 4.5F));

        return builder;
    }
}
