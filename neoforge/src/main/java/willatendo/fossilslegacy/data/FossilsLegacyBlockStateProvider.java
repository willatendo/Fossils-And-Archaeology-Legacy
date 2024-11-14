package willatendo.fossilslegacy.data;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.block.*;

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
        this.horizontalBlock(FossilsLegacyBlocks.ANALYZER.get(), blockState -> this.models().cube("analyzer" + (blockState.getValue(AnalyzerBlock.ACTIVE) ? "_active" : ""), this.modLoc("block/analyzer_top"), this.modLoc("block/analyzer_top"), this.modLoc("block/analyzer_front_" + (blockState.getValue(AnalyzerBlock.ACTIVE) ? "on" : "off")), this.modLoc("block/analyzer_side"), this.modLoc("block/analyzer_side"), this.modLoc("block/analyzer_side")).texture("particle", this.modLoc("block/analyzer_side")));
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
        this.simpleBlock(FossilsLegacyBlocks.PALAEONTOLOGY_TABLE.get(), this.models().cubeBottomTop("palaeontology_table", this.modLoc("block/palaeontology_table_side"), this.modLoc("block/palaeontology_table_bottom"), this.modLoc("block/palaeontology_table_top")).texture("particle", this.modLoc("block/palaeontology_table_side")));
        this.horizontalBlock(FossilsLegacyBlocks.GENE_MODIFICATION_TABLE.get(), blockState -> blockState.getValue(GeneModificationBlock.ACTIVE) ? this.models().withExistingParent("gene_modification_table", this.modLoc("template_gene_modification_table")).texture("front", this.modLoc("block/gene_modification_table_front_on")) : this.models().withExistingParent("gene_modification_table", this.modLoc("template_gene_modification_table")).texture("front", this.modLoc("block/gene_modification_table_front_off")));
        this.getVariantBuilder(FossilsLegacyBlocks.JURASSIC_FERN.get()).partialState().with(JurassicFernBlock.GROWTH, 0).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_lower_0", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_lower_0")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_lower_0")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 1).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_lower_1", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_lower_1")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_lower_1")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 2).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_lower_2", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_lower_2")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_lower_2")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 3).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_lower_3", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_lower_3")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_lower_3")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 4).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_lower_4", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_lower_4")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_lower_4")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 5).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_lower_5", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_lower_5")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_lower_5")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 0).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_upper_0", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_upper_4")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_upper_4")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 1).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_upper_1", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_upper_4")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_upper_4")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 2).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_upper_2", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_upper_4")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_upper_4")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 3).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_upper_3", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_upper_4")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_upper_4")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 4).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_upper_4", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_upper_4")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_lower_0")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 5).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_upper_5", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_upper_5")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_upper_5")).renderType(this.mcLoc("cutout"))));
        this.getVariantBuilder(FossilsLegacyBlocks.DRUM.get()).partialState().with(DrumBlock.COMMAND_TYPE_PROPERTY, "follow").addModels(new ConfiguredModel(this.models().cube("drum_follow", this.mcLoc("block/spruce_planks"), this.modLoc("block/drum_follow"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side")).texture("particle", this.modLoc("block/drum_side")))).partialState().with(DrumBlock.COMMAND_TYPE_PROPERTY, "free_move").addModels(new ConfiguredModel(this.models().cube("drum_free_move", this.mcLoc("block/spruce_planks"), this.modLoc("block/drum_free_move"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side")).texture("particle", this.modLoc("block/drum_side")))).partialState().with(DrumBlock.COMMAND_TYPE_PROPERTY, "stay").addModels(new ConfiguredModel(this.models().cube("drum_stay", this.mcLoc("block/spruce_planks"), this.modLoc("block/drum_stay"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side")).texture("particle", this.modLoc("block/drum_side"))));
        this.horizontalBlock(FossilsLegacyBlocks.FEEDER.get(), blockState -> this.models().cube("feeder" + (blockState.getValue(FeederBlock.HAS_FOOD) ? "_full" : "_empty"), this.mcLoc("block/iron_block"), this.modLoc("block/feeder_top" + (blockState.getValue(FeederBlock.HAS_FOOD) ? "_full" : "_empty")), this.modLoc("block/feeder_front"), this.modLoc("block/feeder_side"), this.modLoc("block/feeder_side"), this.modLoc("block/feeder_side")).texture("particle", this.modLoc("block/feeder_side")));
        this.simpleBlock(FossilsLegacyBlocks.PERMAFROST.get());
        this.simpleBlock(FossilsLegacyBlocks.ICED_STONE.get());
        this.simpleBlock(FossilsLegacyBlocks.AXOLOTLSPAWN.get(), this.models().withExistingParent("axolotlspawn", this.mcLoc("block/frogspawn")).texture("texture", this.modLoc("block/axolotlspawn")).texture("particle", this.modLoc("block/axolotlspawn")).renderType(this.mcLoc("cutout")));
        this.simpleBlock(FossilsLegacyBlocks.TIME_MACHINE.get(), this.models().withExistingParent("time_machine", this.modLoc("block/template_time_machine")));
        this.cauldron(FossilsLegacyBlocks.RAW_CHICKEN_SOUP_CAULDRON.get(), "raw_chicken_soup");
        this.cauldron(FossilsLegacyBlocks.COOKED_CHICKEN_SOUP_CAULDRON.get(), "cooked_chicken_soup");
        this.cauldron(FossilsLegacyBlocks.RAW_BERRY_MEDLEY_CAULDRON.get(), "raw_berry_medley");
        this.cauldron(FossilsLegacyBlocks.COOKED_BERRY_MEDLEY_CAULDRON.get(), "cooked_berry_medley");
        this.mayanVase(FossilsLegacyBlocks.MAYAN_VASE.get(), "mayan_pot_side");
        this.mayanVase(FossilsLegacyBlocks.MAYAN_JADE_VASE.get(), "mayan_pot_side_jade");
        this.mayanVase(FossilsLegacyBlocks.MAYAN_OCELOT_VASE.get(), "mayan_pot_side_ocelot");
        this.mayanVase(FossilsLegacyBlocks.MAYAN_VILLAGER_VASE.get(), "mayan_pot_side_villager");
        this.simpleBlock(FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get());
        this.simpleBlock(FossilsLegacyBlocks.LEPIDODENDRON_SAPLING.get(), this.models().cross("lepidodendron_sapling", this.modLoc("block/lepidodendron_sapling")).renderType("cutout"));
        this.logBlock(FossilsLegacyBlocks.LEPIDODENDRON_LOG.get());
        this.logBlock(FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_LOG.get());
        this.woodBlock(FossilsLegacyBlocks.LEPIDODENDRON_WOOD.get(), this.modLoc("block/lepidodendron_log"));
        this.woodBlock(FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_WOOD.get(), this.modLoc("block/stripped_lepidodendron_log"));
        this.simpleBlock(FossilsLegacyBlocks.LEPIDODENDRON_LEAVES.get(), this.models().withExistingParent("lepidodendron_leaves", this.mcLoc("block/leaves")).texture("all", this.modLoc("block/lepidodendron_leaves")).renderType("cutout"));
        this.stairsBlock(FossilsLegacyBlocks.LEPIDODENDRON_STAIRS.get(), this.modLoc("block/lepidodendron_planks"));
        this.signBlock(FossilsLegacyBlocks.LEPIDODENDRON_SIGN.get(), FossilsLegacyBlocks.LEPIDODENDRON_WALL_SIGN.get(), this.modLoc("block/lepidodendron_planks"));
        this.doorBlockWithRenderType(FossilsLegacyBlocks.LEPIDODENDRON_DOOR.get(), this.modLoc("block/lepidodendron_door_bottom"), this.modLoc("block/lepidodendron_door_top"), "cutout");
        this.hangingSignBlock(FossilsLegacyBlocks.LEPIDODENDRON_HANGING_SIGN.get(), FossilsLegacyBlocks.LEPIDODENDRON_WALL_HANGING_SIGN.get(), this.modLoc("block/stripped_lepidodendron_log"));
        this.pressurePlateBlock(FossilsLegacyBlocks.LEPIDODENDRON_PRESSURE_PLATE.get(), this.modLoc("block/lepidodendron_planks"));
        this.fenceBlock(FossilsLegacyBlocks.LEPIDODENDRON_FENCE.get(), this.modLoc("block/lepidodendron_planks"));
        this.trapdoorBlockWithRenderType(FossilsLegacyBlocks.LEPIDODENDRON_TRAPDOOR.get(), this.modLoc("block/lepidodendron_trapdoor"), true, "cutout");
        this.fenceGateBlock(FossilsLegacyBlocks.LEPIDODENDRON_FENCE_GATE.get(), this.modLoc("block/lepidodendron_planks"));
        this.simpleBlock(FossilsLegacyBlocks.POTTED_LEPIDODENDRON_SAPLING.get(), this.models().withExistingParent("potted_lepidodendron_sapling", this.mcLoc("block/flower_pot_cross")).texture("plant", this.modLoc("block/lepidodendron_sapling")).renderType("cutout"));
        this.buttonBlock(FossilsLegacyBlocks.LEPIDODENDRON_BUTTON.get(), this.modLoc("block/lepidodendron_planks"));
        this.slabBlock(FossilsLegacyBlocks.LEPIDODENDRON_SLAB.get(), this.modLoc("block/lepidodendron_planks"), this.modLoc("block/lepidodendron_planks"));
        this.simpleBlock(FossilsLegacyBlocks.SIGILLARIA_PLANKS.get());
        this.simpleBlock(FossilsLegacyBlocks.SIGILLARIA_SAPLING.get(), this.models().cross("sigillaria_sapling", this.modLoc("block/sigillaria_sapling")).renderType("cutout"));
        this.logBlock(FossilsLegacyBlocks.SIGILLARIA_LOG.get());
        this.logBlock(FossilsLegacyBlocks.STRIPPED_SIGILLARIA_LOG.get());
        this.woodBlock(FossilsLegacyBlocks.SIGILLARIA_WOOD.get(), this.modLoc("block/sigillaria_log"));
        this.woodBlock(FossilsLegacyBlocks.STRIPPED_SIGILLARIA_WOOD.get(), this.modLoc("block/stripped_sigillaria_log"));
        this.simpleBlock(FossilsLegacyBlocks.SIGILLARIA_LEAVES.get(), this.models().withExistingParent("sigillaria_leaves", this.mcLoc("block/leaves")).texture("all", this.modLoc("block/sigillaria_leaves")).renderType("cutout"));
        this.stairsBlock(FossilsLegacyBlocks.SIGILLARIA_STAIRS.get(), this.modLoc("block/sigillaria_planks"));
        this.signBlock(FossilsLegacyBlocks.SIGILLARIA_SIGN.get(), FossilsLegacyBlocks.SIGILLARIA_WALL_SIGN.get(), this.modLoc("block/sigillaria_planks"));
        this.doorBlock(FossilsLegacyBlocks.SIGILLARIA_DOOR.get(), this.modLoc("block/sigillaria_door_bottom"), this.modLoc("block/sigillaria_door_top"));
        this.hangingSignBlock(FossilsLegacyBlocks.SIGILLARIA_HANGING_SIGN.get(), FossilsLegacyBlocks.SIGILLARIA_WALL_HANGING_SIGN.get(), this.modLoc("block/stripped_sigillaria_log"));
        this.pressurePlateBlock(FossilsLegacyBlocks.SIGILLARIA_PRESSURE_PLATE.get(), this.modLoc("block/sigillaria_planks"));
        this.fenceBlock(FossilsLegacyBlocks.SIGILLARIA_FENCE.get(), this.modLoc("block/sigillaria_planks"));
        this.trapdoorBlock(FossilsLegacyBlocks.SIGILLARIA_TRAPDOOR.get(), this.modLoc("block/sigillaria_trapdoor"), true);
        this.fenceGateBlock(FossilsLegacyBlocks.SIGILLARIA_FENCE_GATE.get(), this.modLoc("block/sigillaria_planks"));
        this.simpleBlock(FossilsLegacyBlocks.POTTED_SIGILLARIA_SAPLING.get(), this.models().withExistingParent("potted_sigillaria_sapling", this.mcLoc("block/flower_pot_cross")).texture("plant", this.modLoc("block/sigillaria_sapling")).renderType("cutout"));
        this.buttonBlock(FossilsLegacyBlocks.SIGILLARIA_BUTTON.get(), this.modLoc("block/sigillaria_planks"));
        this.slabBlock(FossilsLegacyBlocks.SIGILLARIA_SLAB.get(), this.modLoc("block/sigillaria_planks"), this.modLoc("block/sigillaria_planks"));
        this.simpleBlock(FossilsLegacyBlocks.CALAMITES_PLANKS.get());
        this.simpleBlock(FossilsLegacyBlocks.CALAMITES_SAPLING.get(), this.models().cross("calamites_sapling", this.modLoc("block/calamites_sapling")).renderType("cutout"));
        this.logBlock(FossilsLegacyBlocks.CALAMITES_LOG.get());
        this.logBlock(FossilsLegacyBlocks.STRIPPED_CALAMITES_LOG.get());
        this.woodBlock(FossilsLegacyBlocks.CALAMITES_WOOD.get(), this.modLoc("block/calamites_log"));
        this.woodBlock(FossilsLegacyBlocks.STRIPPED_CALAMITES_WOOD.get(), this.modLoc("block/stripped_calamites_log"));
        this.simpleBlock(FossilsLegacyBlocks.CALAMITES_LEAVES.get(), this.models().withExistingParent("calamites_leaves", this.mcLoc("block/leaves")).texture("all", this.modLoc("block/calamites_leaves")).renderType("cutout"));
        this.stairsBlock(FossilsLegacyBlocks.CALAMITES_STAIRS.get(), this.modLoc("block/calamites_planks"));
        this.signBlock(FossilsLegacyBlocks.CALAMITES_SIGN.get(), FossilsLegacyBlocks.CALAMITES_WALL_SIGN.get(), this.modLoc("block/calamites_planks"));
        this.doorBlock(FossilsLegacyBlocks.CALAMITES_DOOR.get(), this.modLoc("block/calamites_door_bottom"), this.modLoc("block/calamites_door_top"));
        this.hangingSignBlock(FossilsLegacyBlocks.CALAMITES_HANGING_SIGN.get(), FossilsLegacyBlocks.CALAMITES_WALL_HANGING_SIGN.get(), this.modLoc("block/stripped_calamites_log"));
        this.pressurePlateBlock(FossilsLegacyBlocks.CALAMITES_PRESSURE_PLATE.get(), this.modLoc("block/calamites_planks"));
        this.fenceBlock(FossilsLegacyBlocks.CALAMITES_FENCE.get(), this.modLoc("block/calamites_planks"));
        this.trapdoorBlock(FossilsLegacyBlocks.CALAMITES_TRAPDOOR.get(), this.modLoc("block/calamites_trapdoor"), true);
        this.fenceGateBlock(FossilsLegacyBlocks.CALAMITES_FENCE_GATE.get(), this.modLoc("block/calamites_planks"));
        this.simpleBlock(FossilsLegacyBlocks.POTTED_CALAMITES_SAPLING.get(), this.models().withExistingParent("potted_calamites_sapling", this.mcLoc("block/flower_pot_cross")).texture("plant", this.modLoc("block/calamites_sapling")).renderType("cutout"));
        this.buttonBlock(FossilsLegacyBlocks.CALAMITES_BUTTON.get(), this.modLoc("block/calamites_planks"));
        this.slabBlock(FossilsLegacyBlocks.CALAMITES_SLAB.get(), this.modLoc("block/calamites_planks"), this.modLoc("block/calamites_planks"));
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

    private void mayanVase(Block block, String sideTexture) {
        String name = this.name(block);
        this.simpleBlock(block, this.models().withExistingParent(name, this.modLoc("block/template_vase")).texture("bottom", this.modLoc("block/mayan_pot_bottom")).texture("inside", this.modLoc("block/mayan_pot_inside")).texture("side", this.modLoc("block/" + sideTexture)).texture("top", this.modLoc("block/mayan_pot_top")));
    }

    public void woodBlock(RotatedPillarBlock block, ResourceLocation texture) {
        this.axisBlock(block, texture, texture);
    }

    public void hangingSignBlock(CeilingHangingSignBlock ceilingHangingSignBlock, WallHangingSignBlock wallHangingSignBlock, ResourceLocation texture) {
        ModelFile sign = this.models().sign(this.name(ceilingHangingSignBlock), texture);
        this.hangingSignBlock(ceilingHangingSignBlock, wallHangingSignBlock, sign);
    }

    public void hangingSignBlock(CeilingHangingSignBlock ceilingHangingSignBlock, WallHangingSignBlock wallHangingSignBlock, ModelFile sign) {
        this.simpleBlock(ceilingHangingSignBlock, sign);
        this.simpleBlock(wallHangingSignBlock, sign);
    }

    public void fenceBlock(FenceBlock block, ResourceLocation texture) {
        String baseName = this.key(block).toString();
        this.fourWayBlock(block, this.models().fencePost(baseName + "_post", texture), this.models().fenceSide(baseName + "_side", texture));
        this.models().fenceInventory(baseName + "_inventory", texture);
    }

    public void buttonBlock(ButtonBlock block, ResourceLocation texture) {
        ModelFile button = this.models().button(this.name(block), texture);
        ModelFile buttonPressed = this.models().buttonPressed(this.name(block) + "_pressed", texture);
        this.buttonBlock(block, button, buttonPressed);
        this.models().buttonInventory(this.name(block) + "_inventory", texture);
    }

    private String name(Block block) {
        return this.key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
}
