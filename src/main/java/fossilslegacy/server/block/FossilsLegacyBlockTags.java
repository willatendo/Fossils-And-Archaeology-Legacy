package fossilslegacy.server.block;

import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class FossilsLegacyBlockTags {
	public static final TagKey<Block> NEEDS_GEM_TOOL = create("needs_gem_tool");
	public static final TagKey<Block> PERMAFROST_FROSTABLE = create("permafrost_frostable");

	public static TagKey<Block> create(String name) {
		return TagKey.create(Registries.BLOCK, FossilsLegacyUtils.resource(name));
	}
}
