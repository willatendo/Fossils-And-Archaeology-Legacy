package willatendo.fossilslegacy.server.block;

import net.minecraft.world.level.block.grower.TreeGrower;
import willatendo.fossilslegacy.server.feature.FAConfiguredFeatures;

import java.util.Optional;

public final class FATreeGrowers {
    public static final TreeGrower ARCHAEOPTERIS = new TreeGrower("archaeopteris", 0.1F, Optional.empty(), Optional.empty(), Optional.of(FAConfiguredFeatures.ARCHAEOPTERIS), Optional.empty(), Optional.empty(), Optional.empty());
    public static final TreeGrower CALAMITES = new TreeGrower("calamites", 0.1F, Optional.empty(), Optional.empty(), Optional.of(FAConfiguredFeatures.CALAMITES), Optional.empty(), Optional.empty(), Optional.empty());
    public static final TreeGrower GINKGO = new TreeGrower("ginkgo", 0.1F, Optional.empty(), Optional.empty(), Optional.of(FAConfiguredFeatures.GINKGO), Optional.empty(), Optional.empty(), Optional.empty());
    public static final TreeGrower LEPIDODENDRON = new TreeGrower("lepidodendron", 0.1F, Optional.empty(), Optional.empty(), Optional.of(FAConfiguredFeatures.LEPIDODENDRON), Optional.empty(), Optional.empty(), Optional.empty());
    public static final TreeGrower SIGILLARIA = new TreeGrower("sigillaria", 0.1F, Optional.empty(), Optional.empty(), Optional.of(FAConfiguredFeatures.SIGILLARIA), Optional.empty(), Optional.empty(), Optional.empty());
}
