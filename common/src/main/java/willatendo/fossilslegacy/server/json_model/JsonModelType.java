package willatendo.fossilslegacy.server.json_model;

import com.mojang.serialization.MapCodec;
import willatendo.fossilslegacy.client.model.json.JsonModel;

public interface JsonModelType<T extends JsonModel> {
    MapCodec<T> codec();
}
