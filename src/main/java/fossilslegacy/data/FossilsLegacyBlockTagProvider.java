package fossilslegacy.data;

import java.util.concurrent.CompletableFuture;

import fossilslegacy.server.block.FossilsLegacyBlockTags;
import fossilslegacy.server.block.FossilsLegacyBlocks;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class FossilsLegacyBlockTagProvider extends BlockTagsProvider {
	public FossilsLegacyBlockTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
		super(packOutput, provider, modId, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(BlockTags.NEEDS_IRON_TOOL).add(FossilsLegacyBlocks.FOSSIL_ORE.get());
		this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(FossilsLegacyBlocks.FOSSIL_ORE.get(), FossilsLegacyBlocks.SKULL_BLOCK.get(), FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get(), FossilsLegacyBlocks.ANALYZER.get(), FossilsLegacyBlocks.CULTIVATOR.get(), FossilsLegacyBlocks.FEEDER.get(), FossilsLegacyBlocks.ICED_STONE.get());
		this.tag(BlockTags.MINEABLE_WITH_AXE).add(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get(), FossilsLegacyBlocks.DRUM.get());
		this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(FossilsLegacyBlocks.PERMAFROST.get());
		this.tag(FossilsLegacyBlockTags.PERMAFROST_FROSTABLE).add(Blocks.STONE, Blocks.GRANITE, Blocks.ANDESITE, Blocks.DIORITE);
		this.tag(FossilsLegacyBlockTags.JURASSIC_FERN_PLANTABLE_ON).addTag(BlockTags.DIRT);
	}
}
