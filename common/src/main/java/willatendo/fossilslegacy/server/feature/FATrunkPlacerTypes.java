package willatendo.fossilslegacy.server.feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import willatendo.fossilslegacy.server.feature.trunkplacer.ForkedThickTrunkPlacer;
import willatendo.fossilslegacy.server.feature.trunkplacer.SigillariaTrunkPlacer;
import willatendo.fossilslegacy.server.feature.trunkplacer.StraightBranchingTrunkPlacer;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FATrunkPlacerTypes {
    public static final SimpleRegistry<TrunkPlacerType<?>> TRUNK_PLACER_TYPES = SimpleRegistry.create(Registries.TRUNK_PLACER_TYPE, FossilsLegacyUtils.ID);

    public static final SimpleHolder<TrunkPlacerType<ForkedThickTrunkPlacer>> FORKED_THICK_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("forked_thick_trunk_placer", () -> new TrunkPlacerType(ForkedThickTrunkPlacer.CODEC));
    public static final SimpleHolder<TrunkPlacerType<SigillariaTrunkPlacer>> SIGILLARIA_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("sigillaria_trunk_placer", () -> new TrunkPlacerType(SigillariaTrunkPlacer.CODEC));
    public static final SimpleHolder<TrunkPlacerType<SigillariaTrunkPlacer>> STRAIGHT_BRANCHING_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("straight_branching_trunk_placer", () -> new TrunkPlacerType(StraightBranchingTrunkPlacer.CODEC));
}
