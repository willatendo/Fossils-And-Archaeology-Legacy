package willatendo.fossilslegacy.server.core.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.entity.commands.CommandType;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.entity.variants.PregnancyType;
import willatendo.fossilslegacy.server.entity.variants.StoneTabletVariant;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.item.dinopedia.DinopediaEntry;
import willatendo.fossilslegacy.server.item.dinopedia.DinopediaType;
import willatendo.fossilslegacy.server.item.dinopedia.line.DinopediaLineType;
import willatendo.fossilslegacy.server.item.feederfood.FeederFood;
import willatendo.fossilslegacy.server.recipe.AnalyzerResult;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyRegistries {
    public static final ResourceKey<Registry<AnalyzerResult>> ANALYZER_RESULT = ResourceKey.createRegistryKey(FossilsLegacyUtils.resource("analyzer_result"));
    public static final ResourceKey<Registry<CoatType>> COAT_TYPES = ResourceKey.createRegistryKey(FossilsLegacyUtils.resource("coat_types"));
    public static final ResourceKey<Registry<CommandType>> COMMAND_TYPES = ResourceKey.createRegistryKey(FossilsLegacyUtils.resource("command_type"));
    public static final ResourceKey<Registry<DinopediaEntry>> DINOPEDIA_ENTRY = ResourceKey.createRegistryKey(FossilsLegacyUtils.resource("dinopedia_entry"));
    public static final ResourceKey<Registry<DinopediaType>> DINOPEDIA_TYPE = ResourceKey.createRegistryKey(FossilsLegacyUtils.resource("dinopedia_type"));
    public static final ResourceKey<Registry<DinopediaLineType<?>>> DINOPEDIA_LINE_TYPE = ResourceKey.createRegistryKey(FossilsLegacyUtils.resource("dinopedia_line_type"));
    public static final ResourceKey<Registry<EggVariant>> EGG_VARIANTS = ResourceKey.createRegistryKey(FossilsLegacyUtils.resource("egg_variants"));
    public static final ResourceKey<Registry<FeederFood>> FEEDER_FOOD = ResourceKey.createRegistryKey(FossilsLegacyUtils.resource("feeder_food"));
    public static final ResourceKey<Registry<FossilVariant>> FOSSIL_VARIANTS = ResourceKey.createRegistryKey(FossilsLegacyUtils.resource("fossil_variants"));
    public static final ResourceKey<Registry<PregnancyType>> PREGNANCY_TYPES = ResourceKey.createRegistryKey(FossilsLegacyUtils.resource("pregnancy_types"));
    public static final ResourceKey<Registry<StoneTabletVariant>> STONE_TABLET_VARIANTS = ResourceKey.createRegistryKey(FossilsLegacyUtils.resource("stone_tablet_variants"));
}
