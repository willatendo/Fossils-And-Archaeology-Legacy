package willatendo.fossilslegacy.server.json_model;

import com.mojang.serialization.MapCodec;
import willatendo.fossilslegacy.client.model.json.JsonModel;

public class BuiltInJsonModelType implements JsonModelType<JsonModel> {
    @Override
    public MapCodec<JsonModel> codec() {
        return null;
    }
}
