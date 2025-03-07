package willatendo.fossilslegacy.server.registry;

import net.minecraft.core.Registry;
import willatendo.fossilslegacy.server.command_type.CommandType;
import willatendo.fossilslegacy.server.dinopedia_entry.line.DinopediaLineType;
import willatendo.fossilslegacy.server.pattern.information.PatternInformationType;
import willatendo.fossilslegacy.server.pregnancy_types.PregnancyType;
import willatendo.simplelibrary.server.util.SimpleRegistryBuilder;
import willatendo.simplelibrary.server.util.SimpleUtils;

public final class FABuiltInRegistries {
    public static final Registry<CommandType> COMMAND_TYPES = SimpleUtils.createRegistry(FARegistries.COMMAND_TYPES, SimpleRegistryBuilder.of().sync());
    public static final Registry<DinopediaLineType<?>> DINOPEDIA_LINE_TYPES = SimpleUtils.createRegistry(FARegistries.DINOPEDIA_LINE_TYPE, SimpleRegistryBuilder.of().sync());
    public static final Registry<PregnancyType> PREGNANCY_TYPES = SimpleUtils.createRegistry(FARegistries.PREGNANCY_TYPES, SimpleRegistryBuilder.of().sync());
    public static final Registry<PatternInformationType<?>> PATTERN_INFORMATION_TYPES = SimpleUtils.createRegistry(FARegistries.PATTERN_INFORMATION_TYPE, SimpleRegistryBuilder.of().sync());

    public static void init() {
    }
}
