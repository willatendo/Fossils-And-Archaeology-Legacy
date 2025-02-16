package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class GallimimusModels {
    public static final JsonModel GALLIMIMUS_MODEL = GallimimusModels.createGallimimusBodyLayer().withWalkAnimations(FAUtils.resource("gallimimus_walk")).withHeadPieces("neck").build();

    private static JsonModel.Builder createGallimimusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(128, 128);

        builder.addOrReplaceChild("left_leg", elementBuilder -> elementBuilder.addBox(36, 49, -2.0F, 11.0F, -1.0F, 3.0F, 2.0F, 4.0F).addBox(28, 41, -2.0F, 1.0F, 1.0F, 2.0F, 10.0F, 2.0F).addBox(40, 0, -3.0F, -3.0F, -3.0F, 4.0F, 7.0F, 5.0F).build(), JsonPose.offset(6.0F, 11.0F, 1.0F));
        builder.addOrReplaceChild("right_leg", elementBuilder -> elementBuilder.addBox(0, 41, -1.0F, -3.0F, -3.0F, 4.0F, 7.0F, 5.0F).addBox(50, 49, 0.0F, 1.0F, 1.0F, 2.0F, 10.0F, 2.0F).addBox(0, 53, -1.0F, 11.0F, -1.0F, 3.0F, 2.0F, 4.0F).build(), JsonPose.offset(-6.0F, 11.0F, 1.0F));
        builder.addOrReplaceChild("neck", elementBuilder -> elementBuilder.addBox(18, 41, -1.0F, -11.0F, -2.0F, 2.0F, 14.0F, 3.0F).addOrReplaceChild("head", subElementBuilder -> subElementBuilder.addBox(28, 55, -1.0F, -1.0F, -9.0F, 2.0F, 3.0F, 4.0F).addBox(40, 12, -2.0F, -3.0F, -5.0F, 4.0F, 5.0F, 5.0F).build(), JsonPose.offset(0.0F, -9.0F, 0.0F)).build(), JsonPose.offset(0.0F, 6.0F, -10.0F));
        builder.addOrReplaceChild("tail", elementBuilder -> elementBuilder.addBox(36, 36, -2.0F, -2.0F, 0.0F, 4.0F, 7.0F, 6.0F).addBox(0, 0, -1.0F, -2.0F, 6.0F, 2.0F, 4.0F, 18.0F).build(), JsonPose.offset(0.0F, 7.0F, 5.0F));
        builder.addOrReplaceChild("right_arm", elementBuilder -> elementBuilder.addBox(56, 36, -1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F).build(), JsonPose.offset(-3.0F, 10.0F, -9.0F));
        builder.addOrReplaceChild("left_arm", elementBuilder -> elementBuilder.addBox(40, 55, -1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F).build(), JsonPose.offset(3.0F, 10.0F, -9.0F));
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(36, 22, -2.5F, -19.0F, -11.0F, 5.0F, 8.0F, 6.0F).addBox(0, 22, -4.0F, -19.0F, -5.0F, 8.0F, 9.0F, 10.0F).build(), JsonPose.offset(0.0F, 24.0F, 0.0F));

        return builder;
    }
}
