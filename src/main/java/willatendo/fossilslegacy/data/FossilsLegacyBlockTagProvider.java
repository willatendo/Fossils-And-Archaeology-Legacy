package willatendo.fossilslegacy.data;

import java.util.concurrent.CompletableFuture;

import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlockTags;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.simplelibrary.data.tags.SimpleBlockTagsProvider;

public class FossilsLegacyBlockTagProvider extends SimpleBlockTagsProvider {
	public FossilsLegacyBlockTagProvider(FabricDataOutput fabricDataOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
		super(fabricDataOutput, provider, modId, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(BlockTags.NEEDS_IRON_TOOL).add(FossilsLegacyBlocks.FOSSIL_ORE.get(), FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get());
		this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(FossilsLegacyBlocks.FOSSIL_ORE.get(), FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get(), FossilsLegacyBlocks.SKULL_BLOCK.get(), FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get(), FossilsLegacyBlocks.ANALYZER.get(), FossilsLegacyBlocks.CULTIVATOR.get(), FossilsLegacyBlocks.FEEDER.get(), FossilsLegacyBlocks.ICED_STONE.get());
		this.tag(BlockTags.MINEABLE_WITH_AXE).add(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get(), FossilsLegacyBlocks.DRUM.get());
		this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(FossilsLegacyBlocks.PERMAFROST.get());
		this.tag(FossilsLegacyBlockTags.EATABLE_FERN).add(FossilsLegacyBlocks.JURASSIC_FERN.get());
		this.tag(FossilsLegacyBlockTags.EATABLE_LEAVES).addTags(BlockTags.LEAVES);
		this.tag(FossilsLegacyBlockTags.FEEDER).add(FossilsLegacyBlocks.FEEDER.get());
		this.tag(FossilsLegacyBlockTags.JURASSIC_FERN_PLANTABLE_ON).addTag(BlockTags.DIRT);
		this.tag(FossilsLegacyBlockTags.PERMAFROST_FROSTABLE).add(Blocks.STONE, Blocks.GRANITE, Blocks.ANDESITE, Blocks.DIORITE);
		this.tag(FossilsLegacyBlockTags.TYRANNOSAURUS_UNBREAKABLES).add(FossilsLegacyBlocks.FEEDER.get(), Blocks.BEDROCK, Blocks.IRON_BLOCK, Blocks.IRON_BARS, Blocks.IRON_TRAPDOOR, Blocks.IRON_DOOR, Blocks.CHAIN, Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN, Blocks.END_PORTAL_FRAME, Blocks.NETHER_PORTAL, Blocks.END_PORTAL, Blocks.END_GATEWAY, Blocks.ENCHANTING_TABLE, Blocks.EMERALD_BLOCK, Blocks.REDSTONE_BLOCK, Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.BARRIER, Blocks.STRUCTURE_BLOCK, Blocks.STRUCTURE_VOID, Blocks.SPAWNER, Blocks.TRIAL_SPAWNER, Blocks.LIGHT, Blocks.COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.REPEATING_COMMAND_BLOCK).addTags(BlockTags.ANVIL);
		;
	}
}
