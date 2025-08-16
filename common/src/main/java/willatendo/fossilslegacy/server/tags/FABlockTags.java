package willatendo.fossilslegacy.server.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FABlockTags {
    private static final TagRegister<Block> BLOCK_TAGS = TagRegister.create(Registries.BLOCK, FAUtils.ID);
    private static final TagRegister<Block> C_BLOCK_TAGS = TagRegister.create(Registries.BLOCK, "neoforge");

    public static final TagKey<Block> NEEDS_WOOD_TOOL = C_BLOCK_TAGS.register("needs_wood_tool");
    public static final TagKey<Block> NEEDS_GOLD_TOOL = C_BLOCK_TAGS.register("needs_gold_tool");
    public static final TagKey<Block> NEEDS_NETHERITE_TOOL = C_BLOCK_TAGS.register("needs_netherite_tool");

    public static final TagKey<Block> ANKYLOSAURUS_SPAWNABLE = BLOCK_TAGS.register("spawnable/ankylosaurus");
    public static final TagKey<Block> ARAUCARIA_LOGS = BLOCK_TAGS.register("araucaria_logs");
    public static final TagKey<Block> ARAUCARIOXYLON_LOGS = BLOCK_TAGS.register("araucarioxylon_logs");
    public static final TagKey<Block> ARCHAEOPTERIS_LOGS = BLOCK_TAGS.register("archaeopteris_logs");
    public static final TagKey<Block> BARYONYX_SPAWNABLE = BLOCK_TAGS.register("spawnable/baryonyx");
    public static final TagKey<Block> BRACHIOSAURUS_SPAWNABLE = BLOCK_TAGS.register("spawnable/brachiosaurus");
    public static final TagKey<Block> CALAMITES_LOGS = BLOCK_TAGS.register("calamites_logs");
    public static final TagKey<Block> CARNOTAURUS_SPAWNABLE = BLOCK_TAGS.register("spawnable/carnotaurus");
    public static final TagKey<Block> COMPSOGNATHUS_SPAWNABLE = BLOCK_TAGS.register("spawnable/compsognathus");
    public static final TagKey<Block> CORDAITES_LOGS = BLOCK_TAGS.register("cordaites_logs");
    public static final TagKey<Block> CRYOLOPHOSAURUS_SPAWNABLE = BLOCK_TAGS.register("spawnable/cryolophosaurus");
    public static final TagKey<Block> CULTIVATORS = BLOCK_TAGS.register("cultivators");
    public static final TagKey<Block> CYCAD_PLANTABLE_ON = BLOCK_TAGS.register("cycad_plantable_on");
    public static final TagKey<Block> DILOPHOSAURUS_SPAWNABLE = BLOCK_TAGS.register("spawnable/dilophosaurus");
    public static final TagKey<Block> DIMETRODON_SPAWNABLE = BLOCK_TAGS.register("spawnable/dimetrodon");
    public static final TagKey<Block> DODO_SPAWNABLE = BLOCK_TAGS.register("spawnable/dodo");
    public static final TagKey<Block> DRYOSAURUS_SPAWNABLE = BLOCK_TAGS.register("spawnable/dryosaurus");
    public static final TagKey<Block> EATABLE_FERN = BLOCK_TAGS.register("eatable_fern");
    public static final TagKey<Block> EATABLE_LEAVES = BLOCK_TAGS.register("eatable_leaves");
    public static final TagKey<Block> ELASMOTHERIUM_SPAWNABLE = BLOCK_TAGS.register("spawnable/elasmotherium");
    public static final TagKey<Block> FEEDER = BLOCK_TAGS.register("feeder");
    public static final TagKey<Block> GALLIMIMUS_SPAWNABLE = BLOCK_TAGS.register("spawnable/gallimimus");
    public static final TagKey<Block> GINKGO_LOGS = BLOCK_TAGS.register("ginkgo_logs");
    public static final TagKey<Block> JURASSIC_FERN_PLANTABLE_ON = BLOCK_TAGS.register("jurassic_fern_plantable_on");
    public static final TagKey<Block> LLAMA_STATUES = BLOCK_TAGS.register("llama_statues");
    public static final TagKey<Block> LEPIDODENDRON_LOGS = BLOCK_TAGS.register("lepidodendron_logs");
    public static final TagKey<Block> MAMMOTH_SPAWNABLE = BLOCK_TAGS.register("spawnable/mammoth");
    public static final TagKey<Block> METASEQUOIA_LOGS = BLOCK_TAGS.register("metasequoia_logs");
    public static final TagKey<Block> MINEABLE_WITH_ANCIENT_HOE = BLOCK_TAGS.register("mineable/ancient_hoe");
    public static final TagKey<Block> MOA_SPAWNABLE = BLOCK_TAGS.register("spawnable/moa");
    public static final TagKey<Block> NEEDS_SCARAB_GEM_TOOL = BLOCK_TAGS.register("needs_scarab_gem_tool");
    public static final TagKey<Block> PACHYCEPHALOSAURUS_SPAWNABLE = BLOCK_TAGS.register("spawnable/pachycephalosaurus");
    public static final TagKey<Block> PERMAFROST_FROSTABLE = BLOCK_TAGS.register("permafrost_frostable");
    public static final TagKey<Block> PTERANODON_SPAWNABLE = BLOCK_TAGS.register("spawnable/pteranodon");
    public static final TagKey<Block> SIGILLARIA_LOGS = BLOCK_TAGS.register("sigillaria_logs");
    public static final TagKey<Block> SMILODON_SPAWNABLE = BLOCK_TAGS.register("spawnable/smilodon");
    public static final TagKey<Block> SPINOSAURUS_SPAWNABLE = BLOCK_TAGS.register("spawnable/spinosaurus");
    public static final TagKey<Block> SPINOSAURUS_UNBREAKABLES = BLOCK_TAGS.register("unbreakable/spinosaurus");
    public static final TagKey<Block> STEGOSAURUS_SPAWNABLE = BLOCK_TAGS.register("spawnable/stegosaurus");
    public static final TagKey<Block> THERIZINOSAURUS_SPAWNABLE = BLOCK_TAGS.register("spawnable/therizinosaurus");
    public static final TagKey<Block> TRICERATOPS_SPAWNABLE = BLOCK_TAGS.register("spawnable/triceratops");
    public static final TagKey<Block> TYRANNOSAURUS_SPAWNABLE = BLOCK_TAGS.register("spawnable/tyrannosaurus");
    public static final TagKey<Block> TYRANNOSAURUS_UNBREAKABLES = BLOCK_TAGS.register("unbreakable/tyrannosaurus");
    public static final TagKey<Block> VELOCIRAPTOR_SPAWNABLE = BLOCK_TAGS.register("spawnable/velociraptor");
    public static final TagKey<Block> WOLLEMIA_LOGS = BLOCK_TAGS.register("wollemia_logs");
    public static final TagKey<Block> ZAMITES_PLANTABLE_ON = BLOCK_TAGS.register("zamites_plantable_on");
}
