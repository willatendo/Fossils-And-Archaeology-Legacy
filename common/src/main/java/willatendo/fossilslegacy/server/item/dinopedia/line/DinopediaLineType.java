package willatendo.fossilslegacy.server.item.dinopedia.line;

import com.mojang.serialization.MapCodec;

public interface DinopediaLineType<T extends DinopediaLine> {
    MapCodec<T> codec();
}
