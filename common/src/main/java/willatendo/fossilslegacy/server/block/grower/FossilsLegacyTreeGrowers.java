package willatendo.fossilslegacy.server.block.grower;

import net.minecraft.world.level.block.grower.TreeGrower;
import willatendo.fossilslegacy.server.feature.FossilsLegacyConfiguredFeatures;

import java.util.Optional;

public class FossilsLegacyTreeGrowers {
    public static final TreeGrower LEPIDODENDRON = new TreeGrower("lepidodendron", 0.1F, Optional.empty(), Optional.empty(), Optional.of(FossilsLegacyConfiguredFeatures.LEPIDODENDRON), Optional.empty(), Optional.empty(), Optional.empty());
}
