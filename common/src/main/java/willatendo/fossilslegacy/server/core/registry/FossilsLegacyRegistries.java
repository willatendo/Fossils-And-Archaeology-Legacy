package willatendo.fossilslegacy.server.core.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.entity.commands.CommandType;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.entity.variants.PregnancyType;
import willatendo.fossilslegacy.server.entity.variants.StoneTabletVariant;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyRegistries {
    public static final ResourceKey<Registry<CoatType>> COAT_TYPES = ResourceKey.createRegistryKey(FossilsLegacyUtils.resource("coat_types"));
    public static final ResourceKey<Registry<CommandType>> COMMAND_TYPES = ResourceKey.createRegistryKey(FossilsLegacyUtils.resource("command_type"));
    public static final ResourceKey<Registry<EggVariant>> EGG_VARIANTS = ResourceKey.createRegistryKey(FossilsLegacyUtils.resource("egg_variants"));
    public static final ResourceKey<Registry<FossilVariant>> FOSSIL_VARIANTS = ResourceKey.createRegistryKey(FossilsLegacyUtils.resource("fossil_variants"));
    public static final ResourceKey<Registry<PregnancyType>> PREGNANCY_TYPES = ResourceKey.createRegistryKey(FossilsLegacyUtils.resource("pregnancy_types"));
    public static final ResourceKey<Registry<StoneTabletVariant>> STONE_TABLET_VARIANTS = ResourceKey.createRegistryKey(FossilsLegacyUtils.resource("stone_tablet_variants"));
}
