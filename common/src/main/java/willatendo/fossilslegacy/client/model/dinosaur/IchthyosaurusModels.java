package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class IchthyosaurusModels {
    public static final JsonModel ICHTHYOSAURUS_MODEL = IchthyosaurusModels.createIchthyosaurusBodyLayer().withIdleAnimations(FAUtils.resource("ichthyosaurus_idle")).withSwimAnimations(BuiltInAnimationTypes.ICHTHYOSAUR_BODY_SWIM.getId(), FAUtils.resource("ichthyosaurus_swim")).withHeadPieces("head").build();

    public static JsonModel.Builder createIchthyosaurusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 64);

        builder.addOrReplaceChild("whole", elementBuilder -> elementBuilder.addBox(44, 31, -1.0F, -5.0F, 0.0F, 2.0F, 4.0F, 3.0F).addBox(0, 0, -4.0F, -1.0F, -7.0F, 8.0F, 8.0F, 12.0F).addOrReplaceChild("right_leg", subElementBuilder -> subElementBuilder.addBox(18, 41, -4.0F, -1.0F, -1.0F, 4.0F, 1.0F, 3.0F).build(), JsonPose.offset(-4.0F, 7.0F, 2.0F)).addOrReplaceChild("left_leg", subElementBuilder -> subElementBuilder.addBox(32, 41, 0.0F, -1.0F, -1.0F, 4.0F, 1.0F, 3.0F).build(), JsonPose.offset(4.0F, 7.0F, 2.0F)).addOrReplaceChild("right_arm", subElementBuilder -> subElementBuilder.addBox(40, 13, -6.0F, -1.0F, -1.0F, 6.0F, 2.0F, 3.0F).build(), JsonPose.offset(-4.0F, 6.0F, -5.0F)).addOrReplaceChild("left_arm", subElementBuilder -> subElementBuilder.addBox(0, 41, 0.0F, -1.0F, -1.0F, 6.0F, 2.0F, 3.0F).build(), JsonPose.offset(4.0F, 6.0F, -5.0F)).addOrReplaceChild("tail", subElementBuilder -> subElementBuilder.addBox(24, 31, -2.0F, -2.0F, 5.0F, 4.0F, 4.0F, 6.0F).addBox(40, 0, -1.0F, -5.0F, 9.0F, 2.0F, 10.0F, 3.0F).addBox(24, 20, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 5.0F).build(), JsonPose.offset(0.0F, 3.0F, 5.0F)).addOrReplaceChild("head", subElementBuilder -> subElementBuilder.addBox(0, 32, -1.5F, 0.0F, -12.0F, 3.0F, 3.0F, 6.0F).addBox(0, 20, -3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F).build(), JsonPose.offset(0.0F, 3.0F, -7.0F)).build(), JsonPose.offset(0.0F, 17.0F, 0.0F));

        return builder;
    }
}
