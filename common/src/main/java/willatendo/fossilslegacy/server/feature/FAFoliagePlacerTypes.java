package willatendo.fossilslegacy.server.feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import willatendo.fossilslegacy.server.feature.foliageplacer.NoLeavesFoliagePlacer;
import willatendo.fossilslegacy.server.feature.foliageplacer.BranchedFoliagePlacer;
import willatendo.fossilslegacy.server.feature.foliageplacer.LepidodendronFoliagePlacer;
import willatendo.fossilslegacy.server.feature.foliageplacer.SigillariaFoliagePlacer;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FAFoliagePlacerTypes {
    public static final SimpleRegistry<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = SimpleRegistry.create(Registries.FOLIAGE_PLACER_TYPE, FAUtils.ID);

    public static final SimpleHolder<FoliagePlacerType<NoLeavesFoliagePlacer>> NO_LEAVES_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("no_leaves_foliage_placer", () -> new FoliagePlacerType<>(NoLeavesFoliagePlacer.CODEC));
    public static final SimpleHolder<FoliagePlacerType<BranchedFoliagePlacer>> BRANCHED_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("branched_foliage_placer", () -> new FoliagePlacerType<>(BranchedFoliagePlacer.CODEC));
    public static final SimpleHolder<FoliagePlacerType<LepidodendronFoliagePlacer>> LEPIDODENDRON_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("lepidodendron_foliage_placer", () -> new FoliagePlacerType<>(LepidodendronFoliagePlacer.CODEC));
    public static final SimpleHolder<FoliagePlacerType<SigillariaFoliagePlacer>> SIGILLARIA_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("sigillaria_foliage_placer", () -> new FoliagePlacerType<>(SigillariaFoliagePlacer.CODEC));
}
