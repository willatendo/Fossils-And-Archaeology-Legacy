package willatendo.fossilslegacy.server.item.dinopedia.line;

import com.mojang.serialization.MapCodec;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyDinopediaLineTypes {
    public static final SimpleRegistry<DinopediaLineType<?>> DINOPEDIA_LINE_TYPES = SimpleRegistry.create(FossilsLegacyRegistries.DINOPEDIA_LINE_TYPE, FossilsLegacyUtils.ID);

    public static final SimpleHolder<DinopediaLineType<BuiltInDinopediaLines>> BUILT_IN = FossilsLegacyDinopediaLineTypes.register("built_in", BuiltInDinopediaLines.CODEC);
    public static final SimpleHolder<DinopediaLineType<CustomDinopediaLine>> CUSTOM = FossilsLegacyDinopediaLineTypes.register("custom", CustomDinopediaLine.CODEC);

    private static <T extends DinopediaLine> SimpleHolder<DinopediaLineType<T>> register(String id, MapCodec<T> codec) {
        return DINOPEDIA_LINE_TYPES.register(id, () -> () -> codec);
    }
}
