package willatendo.fossilslegacy.server.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FossilsLegacyBlockTags {
    public static final TagRegister<Block> BLOCK_TAGS = TagRegister.create(Registries.BLOCK, FossilsLegacyUtils.ID);

    public static final TagKey<Block> EATABLE_FERN = BLOCK_TAGS.register("eatable_fern");
    public static final TagKey<Block> EATABLE_LEAVES = BLOCK_TAGS.register("eatable_leaves");
    public static final TagKey<Block> FEEDER = BLOCK_TAGS.register("feeder");
    public static final TagKey<Block> JURASSIC_FERN_PLANTABLE_ON = BLOCK_TAGS.register("jurassic_fern_plantable_on");
    public static final TagKey<Block> LEPIDODENDRON_LOGS = BLOCK_TAGS.register("lepidodendron_logs");
    public static final TagKey<Block> PERMAFROST_FROSTABLE = BLOCK_TAGS.register("permafrost_frostable");
    public static final TagKey<Block> SIGILLARIA_LOGS = BLOCK_TAGS.register("sigillaria_logs");
    public static final TagKey<Block> CALAMITES_LOGS = BLOCK_TAGS.register("calamites_logs");
    public static final TagKey<Block> TYRANNOSAURUS_UNBREAKABLES = BLOCK_TAGS.register("tyrannosaurus_unbreakables");
    public static final TagKey<Block> SPINOSAURUS_UNBREAKABLES = BLOCK_TAGS.register("spinosaurus_unbreakables");
}
