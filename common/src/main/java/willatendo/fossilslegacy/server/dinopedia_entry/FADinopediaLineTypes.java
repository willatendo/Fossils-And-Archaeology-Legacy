package willatendo.fossilslegacy.server.dinopedia_entry;

import com.mojang.serialization.MapCodec;
import willatendo.fossilslegacy.server.dinopedia_entry.line.BuiltInDinopediaLines;
import willatendo.fossilslegacy.server.dinopedia_entry.line.CustomDinopediaLine;
import willatendo.fossilslegacy.server.dinopedia_entry.line.DinopediaLine;
import willatendo.fossilslegacy.server.dinopedia_entry.line.DinopediaLineType;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FADinopediaLineTypes {
    public static final SimpleRegistry<DinopediaLineType<?>> DINOPEDIA_LINE_TYPES = SimpleRegistry.create(FARegistries.DINOPEDIA_LINE_TYPE, FAUtils.ID);

    public static final SimpleHolder<DinopediaLineType<BuiltInDinopediaLines>> BUILT_IN = FADinopediaLineTypes.register("built_in", BuiltInDinopediaLines.CODEC);
    public static final SimpleHolder<DinopediaLineType<CustomDinopediaLine>> CUSTOM = FADinopediaLineTypes.register("custom", CustomDinopediaLine.CODEC);

    private static <T extends DinopediaLine> SimpleHolder<DinopediaLineType<T>> register(String id, MapCodec<T> codec) {
        return DINOPEDIA_LINE_TYPES.register(id, () -> () -> codec);
    }
}
