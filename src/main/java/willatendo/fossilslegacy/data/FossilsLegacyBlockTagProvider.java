package willatendo.fossilslegacy.data;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlockTags;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;

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
		this.tag(FossilsLegacyBlockTags.BRACHIOSAURUS_RESISTANT).add(FossilsLegacyBlocks.FEEDER.get(), Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.SAND, Blocks.SANDSTONE, Blocks.STONE, Blocks.IRON_BLOCK, Blocks.IRON_BARS, Blocks.IRON_DOOR, Blocks.IRON_TRAPDOOR, Blocks.CHAIN, Blocks.NETHERITE_BLOCK, Blocks.COPPER_BLOCK, Blocks.WAXED_COPPER_BLOCK, Blocks.EXPOSED_COPPER, Blocks.WAXED_EXPOSED_COPPER, Blocks.WEATHERED_COPPER, Blocks.WEATHERED_COPPER, Blocks.OXIDIZED_COPPER, Blocks.WAXED_OXIDIZED_COPPER, Blocks.CUT_COPPER, Blocks.WAXED_CUT_COPPER, Blocks.EXPOSED_CUT_COPPER, Blocks.WAXED_EXPOSED_CUT_COPPER, Blocks.WEATHERED_CUT_COPPER, Blocks.WEATHERED_CUT_COPPER, Blocks.OXIDIZED_CUT_COPPER, Blocks.WAXED_OXIDIZED_CUT_COPPER, Blocks.BLACK_CONCRETE, Blocks.BLUE_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.CYAN_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.GREEN_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE, Blocks.LIME_CONCRETE, Blocks.MAGENTA_CONCRETE, Blocks.ORANGE_CONCRETE, Blocks.PINK_CONCRETE, Blocks.PURPLE_CONCRETE, Blocks.RED_CONCRETE, Blocks.WHITE_CONCRETE, Blocks.YELLOW_CONCRETE, Blocks.RAW_IRON_BLOCK, Blocks.LODESTONE);
	}
}
