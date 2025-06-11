package willatendo.fossilslegacy.server.dinopedia_entry.line;

import com.mojang.serialization.MapCodec;

public interface DinopediaLineType<T extends DinopediaLine> {
    MapCodec<T> codec();
}
