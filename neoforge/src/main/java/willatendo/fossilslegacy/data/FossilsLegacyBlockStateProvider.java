package willatendo.fossilslegacy.data;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.block.*;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.DinosaurCommand;

public class FossilsLegacyBlockStateProvider extends BlockStateProvider {
    public FossilsLegacyBlockStateProvider(PackOutput packOutput, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, modId, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlock(FossilsLegacyBlocks.FOSSIL_ORE.get());
        this.simpleBlock(FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get());
        this.horizontalBlock(FossilsLegacyBlocks.SKULL_BLOCK.get(), blockState -> this.models().cube("skull_block", this.modLoc("block/skull"), this.modLoc("block/skull"), this.modLoc("block/skull_front"), this.modLoc("block/skull_crack"), this.modLoc("block/skull_crack"), this.modLoc("block/skull_crack")).texture("particle", this.modLoc("block/skull_crack")));
        this.horizontalBlock(FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get(), blockState -> this.models().cube("skull_lanturn_block", this.modLoc("block/skull"), this.modLoc("block/skull"), this.modLoc("block/skull_lanturn_front"), this.modLoc("block/skull_crack"), this.modLoc("block/skull_crack"), this.modLoc("block/skull_crack")).texture("particle", this.modLoc("block/skull_crack")));
        this.horizontalBlock(FossilsLegacyBlocks.ANALYZER.get(), blockState -> this.models().cube("analyzer" + (blockState.getValue(AnalyzerBlock.ACTIVE) ? "_active" : ""), this.modLoc("block/analyzer_top"), this.modLoc("block/analyzer_top"), this.modLoc("block/analyzer_front_" + (blockState.getValue(ArchaeologyWorkbenchBlock.ACTIVE) ? "on" : "off")), this.modLoc("block/analyzer_side"), this.modLoc("block/analyzer_side"), this.modLoc("block/analyzer_side")).texture("particle", this.modLoc("block/analyzer_side")));
        this.cultivator(FossilsLegacyBlocks.WHITE_CULTIVATOR.get(), "white");
        this.cultivator(FossilsLegacyBlocks.ORANGE_CULTIVATOR.get(), "orange");
        this.cultivator(FossilsLegacyBlocks.MAGENTA_CULTIVATOR.get(), "magenta");
        this.cultivator(FossilsLegacyBlocks.LIGHT_BLUE_CULTIVATOR.get(), "light_blue");
        this.cultivator(FossilsLegacyBlocks.YELLOW_CULTIVATOR.get(), "yellow");
        this.cultivator(FossilsLegacyBlocks.LIME_CULTIVATOR.get(), "lime");
        this.cultivator(FossilsLegacyBlocks.PINK_CULTIVATOR.get(), "pink");
        this.cultivator(FossilsLegacyBlocks.GRAY_CULTIVATOR.get(), "gray");
        this.cultivator(FossilsLegacyBlocks.LIGHT_GRAY_CULTIVATOR.get(), "light_gray");
        this.cultivator(FossilsLegacyBlocks.CYAN_CULTIVATOR.get(), "cyan");
        this.cultivator(FossilsLegacyBlocks.PURPLE_CULTIVATOR.get(), "purple");
        this.cultivator(FossilsLegacyBlocks.BLUE_CULTIVATOR.get(), "blue");
        this.cultivator(FossilsLegacyBlocks.BROWN_CULTIVATOR.get(), "brown");
        this.cultivator(FossilsLegacyBlocks.GREEN_CULTIVATOR.get(), "green");
        this.cultivator(FossilsLegacyBlocks.RED_CULTIVATOR.get(), "red");
        this.cultivator(FossilsLegacyBlocks.BLACK_CULTIVATOR.get(), "black");
        this.horizontalBlock(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get(), blockState -> this.models().cube("archaeology_workbench" + (blockState.getValue(ArchaeologyWorkbenchBlock.ACTIVE) ? "_active" : ""), this.modLoc("block/archaeology_workbench_bottom"), this.modLoc("block/archaeology_workbench_top_" + (blockState.getValue(ArchaeologyWorkbenchBlock.ACTIVE) ? "on" : "off")), this.modLoc("block/archaeology_workbench_books"), this.modLoc("block/archaeology_workbench_side"), this.modLoc("block/archaeology_workbench_side"), this.modLoc("block/archaeology_workbench_side")).texture("particle", this.modLoc("block/archaeology_workbench_side")));
        this.getVariantBuilder(FossilsLegacyBlocks.JURASSIC_FERN.get()).partialState().with(JurassicFernBlock.GROWTH, 0).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().crop("fern_lower_0", this.modLoc("block/fern_lower_0")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 1).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().crop("fern_lower_1", this.modLoc("block/fern_lower_1")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 2).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().crop("fern_lower_2", this.modLoc("block/fern_lower_2")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 3).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().crop("fern_lower_3", this.modLoc("block/fern_lower_3")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 4).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().crop("fern_lower_4", this.modLoc("block/fern_lower_4")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 5).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().crop("fern_lower_5", this.modLoc("block/fern_lower_5")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 0).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().crop("fern_upper_0", this.modLoc("block/fern_upper_4")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 1).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().crop("fern_upper_1", this.modLoc("block/fern_upper_4")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 2).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().crop("fern_upper_2", this.modLoc("block/fern_upper_4")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 3).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().crop("fern_upper_3", this.modLoc("block/fern_upper_4")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 4).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().crop("fern_upper_4", this.modLoc("block/fern_upper_4")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 5).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().crop("fern_upper_5", this.modLoc("block/fern_upper_5")).renderType(this.mcLoc("cutout"))));
        this.getVariantBuilder(FossilsLegacyBlocks.DRUM.get()).partialState().with(DrumBlock.DINOSAUR_ORDER, DinosaurCommand.FOLLOW).addModels(new ConfiguredModel(this.models().cube("drum_follow", this.mcLoc("block/spruce_planks"), this.modLoc("block/drum_follow"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side")).texture("particle", this.modLoc("block/drum_side")))).partialState().with(DrumBlock.DINOSAUR_ORDER, DinosaurCommand.FREE_MOVE).addModels(new ConfiguredModel(this.models().cube("drum_free_move", this.mcLoc("block/spruce_planks"), this.modLoc("block/drum_free_move"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side")).texture("particle", this.modLoc("block/drum_side")))).partialState().with(DrumBlock.DINOSAUR_ORDER, DinosaurCommand.STAY).addModels(new ConfiguredModel(this.models().cube("drum_stay", this.mcLoc("block/spruce_planks"), this.modLoc("block/drum_stay"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side")).texture("particle", this.modLoc("block/drum_side"))));
        this.horizontalBlock(FossilsLegacyBlocks.FEEDER.get(), blockState -> this.models().cube("feeder" + (blockState.getValue(FeederBlock.HAS_FOOD) ? "_full" : "_empty"), this.mcLoc("block/iron_block"), this.modLoc("block/feeder_top" + (blockState.getValue(FeederBlock.HAS_FOOD) ? "_full" : "_empty")), this.modLoc("block/feeder_front"), this.modLoc("block/feeder_side"), this.modLoc("block/feeder_side"), this.modLoc("block/feeder_side")).texture("particle", this.modLoc("block/feeder_side")));
        this.simpleBlock(FossilsLegacyBlocks.PERMAFROST.get());
        this.simpleBlock(FossilsLegacyBlocks.ICED_STONE.get());
        this.simpleBlock(FossilsLegacyBlocks.AXOLOTLSPAWN.get(), this.models().withExistingParent("axolotlspawn", this.mcLoc("block/frogspawn")).texture("texture", this.modLoc("block/axolotlspawn")).texture("particle", this.modLoc("block/axolotlspawn")).renderType(this.mcLoc("cutout")));
        this.simpleBlock(FossilsLegacyBlocks.TIME_MACHINE.get(), this.models().withExistingParent("time_machine", this.modLoc("block/template_time_machine")));
        this.cauldron(FossilsLegacyBlocks.RAW_CHICKEN_SOUP_CAULDRON.get(), "raw_chicken_soup");
        this.cauldron(FossilsLegacyBlocks.COOKED_CHICKEN_SOUP_CAULDRON.get(), "cooked_chicken_soup");
        this.cauldron(FossilsLegacyBlocks.RAW_BERRY_MEDLEY_CAULDRON.get(), "raw_berry_medley");
        this.cauldron(FossilsLegacyBlocks.COOKED_BERRY_MEDLEY_CAULDRON.get(), "cooked_berry_medley");
    }

    private void cultivator(Block block, String color) {
        this.getVariantBuilder(block).partialState().with(CultivatorBlock.ACTIVE, false).addModels(new ConfiguredModel(this.models().cube(color + "_cultivator", this.modLoc("block/cultivator_bottom"), this.modLoc("block/" + color + "_cultivator_top"), this.modLoc("block/" + color + "_cultivator_side_off"), this.modLoc("block/" + color + "_cultivator_side_off"), this.modLoc("block/" + color + "_cultivator_side_off"), this.modLoc("block/" + color + "_cultivator_side_off")).texture("particle", this.modLoc("block/" + color + "_cultivator_side_off")))).partialState().with(CultivatorBlock.ACTIVE, true).addModels(new ConfiguredModel(this.models().cube(color + "_cultivator_active", this.modLoc("block/cultivator_bottom"), this.modLoc("block/" + color + "_cultivator_top"), this.modLoc("block/" + color + "_cultivator_side_on"), this.modLoc("block/" + color + "_cultivator_side_on"), this.modLoc("block/" + color + "_cultivator_side_on"), this.modLoc("block/" + color + "_cultivator_side_on")).texture("particle", this.modLoc("block/" + color + "_cultivator_side_on"))));
    }

    private void cauldron(Block block, String liquid) {
        VariantBlockStateBuilder.PartialBlockstate partialBlockstate = this.getVariantBuilder(block).partialState();
        for (int level = 1; level < 9; level++) {
            partialBlockstate.with(SoupCauldronBlock.LEVEL, level).addModels(new ConfiguredModel(this.models().withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath() + "_" + level, this.modLoc("block/template_soup_cauldron_" + level)).texture("content", this.modLoc("block/" + liquid))));
        }
    }
}
