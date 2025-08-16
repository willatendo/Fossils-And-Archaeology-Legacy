package willatendo.fossilslegacy.server.block;

import net.minecraft.world.level.block.grower.TreeGrower;
import willatendo.fossilslegacy.server.feature.FAConfiguredFeatures;

import java.util.Optional;

public final class FATreeGrowers {
    public static final TreeGrower ARAUCARIA = new TreeGrower("araucaria", Optional.empty(), Optional.of(FAConfiguredFeatures.ARAUCARIA), Optional.empty());
    public static final TreeGrower ARAUCARIOXYLON = new TreeGrower("araucarioxylon", Optional.empty(), Optional.of(FAConfiguredFeatures.ARAUCARIOXYLON), Optional.empty());
    public static final TreeGrower ARCHAEOPTERIS = new TreeGrower("archaeopteris", Optional.empty(), Optional.of(FAConfiguredFeatures.ARCHAEOPTERIS), Optional.empty());
    public static final TreeGrower CALAMITES = new TreeGrower("calamites", Optional.empty(), Optional.of(FAConfiguredFeatures.CALAMITES), Optional.empty());
    public static final TreeGrower CORDAITES = new TreeGrower("cordaites", Optional.of(FAConfiguredFeatures.MEGA_CORDAITES), Optional.of(FAConfiguredFeatures.CORDAITES), Optional.empty());
    public static final TreeGrower GINKGO = new TreeGrower("ginkgo", Optional.empty(), Optional.of(FAConfiguredFeatures.GINKGO), Optional.empty());
    public static final TreeGrower LEPIDODENDRON = new TreeGrower("lepidodendron", Optional.empty(), Optional.of(FAConfiguredFeatures.LEPIDODENDRON), Optional.empty());
    public static final TreeGrower METASEQUOIA = new TreeGrower("metasequoia", Optional.of(FAConfiguredFeatures.METASEQUOIA), Optional.of(FAConfiguredFeatures.METASEQUOIA_SAPLING), Optional.empty());
    public static final TreeGrower SIGILLARIA = new TreeGrower("sigillaria", Optional.empty(), Optional.of(FAConfiguredFeatures.SIGILLARIA), Optional.empty());
    public static final TreeGrower WOLLEMIA = new TreeGrower("wollemia", Optional.empty(), Optional.of(FAConfiguredFeatures.WOLLEMIA), Optional.empty());
}
