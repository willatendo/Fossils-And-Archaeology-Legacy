package willatendo.fossilslegacy.server.core.registry;

import net.minecraft.core.Registry;
import willatendo.fossilslegacy.server.entity.commands.CommandType;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;
import willatendo.fossilslegacy.server.entity.variants.PregnancyType;
import willatendo.fossilslegacy.server.item.dinopedia.line.DinopediaLineType;
import willatendo.simplelibrary.server.util.SimpleRegistryBuilder;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class FossilsLegacyBuiltInRegistries {
    public static final Registry<CommandType> COMMAND_TYPES = SimpleUtils.createRegistry(FossilsLegacyRegistries.COMMAND_TYPES, SimpleRegistryBuilder.of().sync());
    public static final Registry<DinopediaLineType<?>> DINOPEDIA_LINE_TYPES = SimpleUtils.createRegistry(FossilsLegacyRegistries.DINOPEDIA_LINE_TYPE, SimpleRegistryBuilder.of().sync());
    public static final Registry<EggVariant> EGG_VARIANTS = SimpleUtils.createRegistry(FossilsLegacyRegistries.EGG_VARIANTS, SimpleRegistryBuilder.of().sync());
    public static final Registry<PregnancyType> PREGNANCY_TYPES = SimpleUtils.createRegistry(FossilsLegacyRegistries.PREGNANCY_TYPES, SimpleRegistryBuilder.of().sync());

    public static void init() {
    }
}
