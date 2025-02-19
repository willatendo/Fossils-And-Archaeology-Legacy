package willatendo.fossilslegacy.server.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.analyzer_result.AnalyzerResult;
import willatendo.fossilslegacy.server.ancient_axe_bonus.AncientAxeBonus;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.command_type.CommandType;
import willatendo.fossilslegacy.server.dinopedia_entry.DinopediaEntry;
import willatendo.fossilslegacy.server.dinopedia_entry.line.DinopediaLineType;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.feeder_food.FeederFood;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.fuel.FuelEntry;
import willatendo.fossilslegacy.server.jewel_recovery.JewelRecovery;
import willatendo.fossilslegacy.server.pregnancy_types.PregnancyType;
import willatendo.fossilslegacy.server.stone_tablet_variant.StoneTabletVariant;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FARegistries {
    public static final ResourceKey<Registry<AnalyzerResult>> ANALYZER_RESULT = ResourceKey.createRegistryKey(FAUtils.resource("analyzer_result"));
    public static final ResourceKey<Registry<AncientAxeBonus>> ANCIENT_AXE_BONUS = ResourceKey.createRegistryKey(FAUtils.resource("ancient_axe_bonus"));
    public static final ResourceKey<Registry<CoatType>> COAT_TYPES = ResourceKey.createRegistryKey(FAUtils.resource("coat_types"));
    public static final ResourceKey<Registry<CommandType>> COMMAND_TYPES = ResourceKey.createRegistryKey(FAUtils.resource("command_type"));
    public static final ResourceKey<Registry<DinopediaEntry>> DINOPEDIA_ENTRY = ResourceKey.createRegistryKey(FAUtils.resource("dinopedia_entry"));
    public static final ResourceKey<Registry<DinopediaType>> DINOPEDIA_TYPE = ResourceKey.createRegistryKey(FAUtils.resource("dinopedia_type"));
    public static final ResourceKey<Registry<DinopediaLineType<?>>> DINOPEDIA_LINE_TYPE = ResourceKey.createRegistryKey(FAUtils.resource("dinopedia_line_type"));
    public static final ResourceKey<Registry<FeederFood>> FEEDER_FOOD = ResourceKey.createRegistryKey(FAUtils.resource("feeder_food"));
    public static final ResourceKey<Registry<FossilVariant>> FOSSIL_VARIANTS = ResourceKey.createRegistryKey(FAUtils.resource("fossil_variants"));
    public static final ResourceKey<Registry<FuelEntry>> FUEL_ENTRY = ResourceKey.createRegistryKey(FAUtils.resource("fuel_entry"));
    public static final ResourceKey<Registry<JewelRecovery>> JEWEL_RECOVERY = ResourceKey.createRegistryKey(FAUtils.resource("jewel_recovery"));
    public static final ResourceKey<Registry<PregnancyType>> PREGNANCY_TYPES = ResourceKey.createRegistryKey(FAUtils.resource("pregnancy_types"));
    public static final ResourceKey<Registry<StoneTabletVariant>> STONE_TABLET_VARIANTS = ResourceKey.createRegistryKey(FAUtils.resource("stone_tablet_variants"));
}
