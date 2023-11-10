package willatendo.fossilslegacy.server.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.SimpleUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FossilsLegacyBlockTags {
	public static final TagRegister<Block> BLOCK_TAGS = SimpleUtils.create(Registries.BLOCK, FossilsLegacyUtils.ID);

	public static final TagKey<Block> JURASSIC_FERN_PLANTABLE_ON = BLOCK_TAGS.register("jurassic_fern_plantable_on");
	public static final TagKey<Block> NEEDS_GEM_TOOL = BLOCK_TAGS.register("needs_gem_tool");
	public static final TagKey<Block> PERMAFROST_FROSTABLE = BLOCK_TAGS.register("permafrost_frostable");
}
