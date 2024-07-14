package willatendo.fossilslegacy.server.feature.trunkplacer;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyTrunkPlacerTypes {
    public static final SimpleRegistry<TrunkPlacerType<?>> TRUNK_PLACER_TYPES = SimpleRegistry.create(Registries.TRUNK_PLACER_TYPE, FossilsLegacyUtils.ID);

    public static final SimpleHolder<TrunkPlacerType<ForkedThickTrunkPlacer>> FORKED_THICK_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("forked_thick_trunk_placer", () -> new TrunkPlacerType(ForkedThickTrunkPlacer.CODEC));
}
