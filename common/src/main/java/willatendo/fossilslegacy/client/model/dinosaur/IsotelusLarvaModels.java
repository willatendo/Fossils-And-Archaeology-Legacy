package willatendo.fossilslegacy.client.model.dinosaur;

import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonPose;

public final class IsotelusLarvaModels {
    public static final JsonModel ISOTELUS_LARVA_MODEL = IsotelusLarvaModels.createIsotelusLarvaBodyLayer().build();

    private static JsonModel.Builder createIsotelusLarvaBodyLayer() {
        JsonModel.Builder builder = JsonModel.builder(16, 16);
        builder.addOrReplaceChild("body", elementBuilder -> elementBuilder.addBox(0, 0, -1F, -2F, -2F, 2F, 2F, 4F).addBox(0, 5, -1F, -1F, -3F, 0F, 1F, 1F).addBox(0, 6, 1F, -1F, -3F, 0F, 1F, 1F).build(), JsonPose.offset(0F, 24F, 0F));
        return builder;
    }
}
