package fossilslegacy.data;

import fossilslegacy.server.block.AnalyzerBlock;
import fossilslegacy.server.block.ArchaeologyWorkbenchBlock;
import fossilslegacy.server.block.CultivatorBlock;
import fossilslegacy.server.block.DrumBlock;
import fossilslegacy.server.block.FeederBlock;
import fossilslegacy.server.block.FossilsLegacyBlocks;
import fossilslegacy.server.utils.DinosaurOrder;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

public class FossilsLegacyBlockStateProvider extends BlockStateProvider {
	public FossilsLegacyBlockStateProvider(PackOutput packedOutput, String modId, ExistingFileHelper existingFileHelper) {
		super(packedOutput, modId, existingFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		this.simpleBlock(FossilsLegacyBlocks.FOSSIL_ORE.get());
		this.horizontalBlock(FossilsLegacyBlocks.SKULL_BLOCK.get(), blockState -> this.models().cube("skull_block", this.modLoc("block/skull"), this.modLoc("block/skull"), this.modLoc("block/skull_front"), this.modLoc("block/skull_crack"), this.modLoc("block/skull_crack"), this.modLoc("block/skull_crack")).texture("particle", this.modLoc("block/skull_crack")));
		this.horizontalBlock(FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get(), blockState -> this.models().cube("skull_lanturn_block", this.modLoc("block/skull"), this.modLoc("block/skull"), this.modLoc("block/skull_lanturn_front"), this.modLoc("block/skull_crack"), this.modLoc("block/skull_crack"), this.modLoc("block/skull_crack")).texture("particle", this.modLoc("block/skull_crack")));
		this.horizontalBlock(FossilsLegacyBlocks.ANALYZER.get(), blockState -> this.models().cube("analyzer" + (blockState.getValue(AnalyzerBlock.ACTIVE) ? "_active" : ""), this.modLoc("block/analyzer_top"), this.modLoc("block/analyzer_top"), this.modLoc("block/analyzer_front_" + (blockState.getValue(ArchaeologyWorkbenchBlock.ACTIVE) ? "on" : "off")), this.modLoc("block/analyzer_side"), this.modLoc("block/analyzer_side"), this.modLoc("block/analyzer_side")).texture("particle", this.modLoc("block/analyzer_side")));
		this.getVariantBuilder(FossilsLegacyBlocks.CULTIVATOR.get()).partialState().with(CultivatorBlock.ACTIVE, false).addModels(new ConfiguredModel(this.models().cube("cultivator", this.modLoc("block/cultivator_bottom"), this.modLoc("block/cultivator_top"), this.modLoc("block/cultivator_side_off"), this.modLoc("block/cultivator_side_off"), this.modLoc("block/cultivator_side_off"), this.modLoc("block/cultivator_side_off")).texture("particle", this.modLoc("block/cultivator_side_off")))).partialState().with(CultivatorBlock.ACTIVE, true).addModels(new ConfiguredModel(this.models().cube("cultivator_active", this.modLoc("block/cultivator_bottom"), this.modLoc("block/cultivator_top"), this.modLoc("block/cultivator_side_on"), this.modLoc("block/cultivator_side_on"), this.modLoc("block/cultivator_side_on"), this.modLoc("block/cultivator_side_on")).texture("particle", this.modLoc("block/cultivator_side_on"))));
		this.horizontalBlock(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get(), blockState -> this.models().cube("archaeology_workbench" + (blockState.getValue(ArchaeologyWorkbenchBlock.ACTIVE) ? "_active" : ""), this.mcLoc("block/spruce_planks"), this.modLoc("block/archaeology_workbench_top_" + (blockState.getValue(ArchaeologyWorkbenchBlock.ACTIVE) ? "on" : "off")), this.modLoc("block/archaeology_workbench_books"), this.modLoc("block/archaeology_workbench_side"), this.modLoc("block/archaeology_workbench_side"), this.modLoc("block/archaeology_workbench_side")).texture("particle", this.modLoc("block/archaeology_workbench_side")));
		this.getVariantBuilder(FossilsLegacyBlocks.DRUM.get()).partialState().with(DrumBlock.DINOSAUR_ORDER, DinosaurOrder.FOLLOW).addModels(new ConfiguredModel(this.models().cube("drum_follow", this.mcLoc("block/spruce_planks"), this.modLoc("block/drum_follow"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side")).texture("particle", this.modLoc("block/drum_side")))).partialState().with(DrumBlock.DINOSAUR_ORDER, DinosaurOrder.FREE_MOVE).addModels(new ConfiguredModel(this.models().cube("drum_free_move", this.mcLoc("block/spruce_planks"), this.modLoc("block/drum_free_move"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side")).texture("particle", this.modLoc("block/drum_side")))).partialState().with(DrumBlock.DINOSAUR_ORDER, DinosaurOrder.STAY).addModels(new ConfiguredModel(this.models().cube("drum_stay", this.mcLoc("block/spruce_planks"), this.modLoc("block/drum_stay"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side")).texture("particle", this.modLoc("block/drum_side"))));
		this.horizontalBlock(FossilsLegacyBlocks.FEEDER.get(), blockState -> this.models().cube("feeder" + (blockState.getValue(FeederBlock.HAS_FOOD) ? "_full" : "_empty"), this.mcLoc("block/iron_block"), this.modLoc("block/feeder_top" + (blockState.getValue(FeederBlock.HAS_FOOD) ? "_full" : "_empty")), this.modLoc("block/feeder_front"), this.modLoc("block/feeder_side"), this.modLoc("block/feeder_side"), this.modLoc("block/feeder_side")).texture("particle", this.modLoc("block/feeder_side")));
		this.simpleBlock(FossilsLegacyBlocks.PERMAFROST.get());
		this.simpleBlock(FossilsLegacyBlocks.ICED_STONE.get());
	}
}
