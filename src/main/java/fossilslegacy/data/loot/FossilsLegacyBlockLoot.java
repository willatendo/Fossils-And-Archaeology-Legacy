package fossilslegacy.data.loot;

import java.util.stream.Collectors;

import fossilslegacy.server.block.FossilsLegacyBlocks;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class FossilsLegacyBlockLoot extends VanillaBlockLoot {
	@Override
	protected void generate() {
		this.add(FossilsLegacyBlocks.FOSSIL_ORE.get(), noDrop());
		this.dropSelf(FossilsLegacyBlocks.SKULL_BLOCK.get());
		this.dropSelf(FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get());
		this.dropSelf(FossilsLegacyBlocks.ANALYZER.get());
		this.dropSelf(FossilsLegacyBlocks.CULTIVATOR.get());
		this.dropSelf(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get());
		this.add(FossilsLegacyBlocks.JURASSIC_FERN.get(), block -> this.createDoublePlantWithSeedDrops(block, FossilsLegacyBlocks.JURASSIC_FERN.get()));
		this.dropSelf(FossilsLegacyBlocks.DRUM.get());
		this.dropSelf(FossilsLegacyBlocks.FEEDER.get());
		this.add(FossilsLegacyBlocks.PERMAFROST.get(), noDrop());
		this.add(FossilsLegacyBlocks.ICED_STONE.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.COBBLESTONE));
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> FossilsLegacyUtils.ID.equals(ForgeRegistries.BLOCKS.getKey(block).getNamespace())).collect(Collectors.toSet());
	}
}
