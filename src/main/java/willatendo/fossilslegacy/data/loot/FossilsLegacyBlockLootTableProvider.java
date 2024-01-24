package willatendo.fossilslegacy.data.loot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;

public class FossilsLegacyBlockLootTableProvider extends FabricBlockLootTableProvider {
	public FossilsLegacyBlockLootTableProvider(FabricDataOutput fabricDataOutput) {
		super(fabricDataOutput);
	}

	@Override
	public void generate() {
		this.add(FossilsLegacyBlocks.FOSSIL_ORE.get(), noDrop());
		this.add(FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get(), noDrop());
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
		this.add(FossilsLegacyBlocks.AXOLOTLSPAWN.get(), noDrop());
	}
}
