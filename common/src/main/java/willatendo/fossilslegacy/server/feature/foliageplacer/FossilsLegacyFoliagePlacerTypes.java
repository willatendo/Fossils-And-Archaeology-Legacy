package willatendo.fossilslegacy.server.feature.foliageplacer;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyFoliagePlacerTypes {
    public static final SimpleRegistry<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = SimpleRegistry.create(Registries.FOLIAGE_PLACER_TYPE, FossilsLegacyUtils.ID);

    public static final SimpleHolder<FoliagePlacerType<LepidodendronFoliagePlacer>> LEPIDODENDRON_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("lepidodendron_foliage_placer", () -> new FoliagePlacerType(LepidodendronFoliagePlacer.CODEC));
}
