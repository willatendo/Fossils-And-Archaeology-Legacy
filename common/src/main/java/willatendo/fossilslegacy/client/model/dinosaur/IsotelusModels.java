package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;

public final class IsotelusModels {
    public static final JsonModel ISOTELUS_MODEL = IsotelusModels.createIsotelusBodyLayer().build();

    private static JsonModel.Builder createIsotelusBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(64, 64);
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -4F, -2F, -4F, 8F, 2F, 12F).addBox(14, 7, 2F, -7F, -6F, 0F, 7F, 7F).addBox(0, 7, -2F, -7F, -6F, 0F, 7F, 7F).build(), JsonPose.offset(0F, 24F, 0F));
        return builder;
    }
}
