package willatendo.fossilslegacy.data;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.blocks.*;
import willatendo.simplelibrary.data.SimpleBlockStateProvider;

public class FABlockStateProvider extends SimpleBlockStateProvider {
    public FABlockStateProvider(PackOutput packOutput, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, modId, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.fossil(FABlocks.FOSSIL_ORE.get(), false);
        this.fossil(FABlocks.DEEPSLATE_FOSSIL_ORE.get(), true);
        this.horizontalBlock(FABlocks.SKULL_BLOCK.get(), blockState -> this.models().cube("skull_block", this.modLoc("block/skull"), this.modLoc("block/skull"), this.modLoc("block/skull_front"), this.modLoc("block/skull_crack"), this.modLoc("block/skull_crack"), this.modLoc("block/skull_crack")).texture("particle", this.modLoc("block/skull_crack")));
        this.horizontalBlock(FABlocks.SKULL_LANTERN_BLOCK.get(), blockState -> this.models().cube("skull_lantern_block", this.modLoc("block/skull"), this.modLoc("block/skull"), this.modLoc("block/skull_lantern_front"), this.modLoc("block/skull_crack"), this.modLoc("block/skull_crack"), this.modLoc("block/skull_crack")).texture("particle", this.modLoc("block/skull_crack")));
        this.horizontalBlock(FABlocks.ANALYZER.get(), blockState -> this.models().cube("analyzer" + (blockState.getValue(AnalyzerBlock.ACTIVE) ? "_active" : ""), this.modLoc("block/analyzer_top"), this.modLoc("block/analyzer_top"), this.modLoc("block/analyzer_front_" + (blockState.getValue(AnalyzerBlock.ACTIVE) ? "on" : "off")), this.modLoc("block/analyzer_back"), this.modLoc("block/analyzer_side"), this.modLoc("block/analyzer_side")).texture("particle", this.modLoc("block/analyzer_side")));
        this.cultivator(FABlocks.WHITE_CULTIVATOR.get(), "white");
        this.cultivator(FABlocks.ORANGE_CULTIVATOR.get(), "orange");
        this.cultivator(FABlocks.MAGENTA_CULTIVATOR.get(), "magenta");
        this.cultivator(FABlocks.LIGHT_BLUE_CULTIVATOR.get(), "light_blue");
        this.cultivator(FABlocks.YELLOW_CULTIVATOR.get(), "yellow");
        this.cultivator(FABlocks.LIME_CULTIVATOR.get(), "lime");
        this.cultivator(FABlocks.PINK_CULTIVATOR.get(), "pink");
        this.cultivator(FABlocks.GRAY_CULTIVATOR.get(), "gray");
        this.cultivator(FABlocks.LIGHT_GRAY_CULTIVATOR.get(), "light_gray");
        this.cultivator(FABlocks.CYAN_CULTIVATOR.get(), "cyan");
        this.cultivator(FABlocks.PURPLE_CULTIVATOR.get(), "purple");
        this.cultivator(FABlocks.BLUE_CULTIVATOR.get(), "blue");
        this.cultivator(FABlocks.BROWN_CULTIVATOR.get(), "brown");
        this.cultivator(FABlocks.GREEN_CULTIVATOR.get(), "green");
        this.cultivator(FABlocks.RED_CULTIVATOR.get(), "red");
        this.cultivator(FABlocks.BLACK_CULTIVATOR.get(), "black");
        this.horizontalBlock(FABlocks.ARCHAEOLOGY_WORKBENCH.get(), blockState -> this.models().cube("archaeology_workbench" + (blockState.getValue(ArchaeologyWorkbenchBlock.ACTIVE) ? "_active" : ""), this.modLoc("block/archaeology_workbench_bottom"), this.modLoc("block/archaeology_workbench_top_" + (blockState.getValue(ArchaeologyWorkbenchBlock.ACTIVE) ? "on" : "off")), this.modLoc("block/archaeology_workbench_books"), this.modLoc("block/archaeology_workbench_books"), this.modLoc("block/archaeology_workbench_side"), this.modLoc("block/archaeology_workbench_side")).texture("particle", this.modLoc("block/archaeology_workbench_side")));
        this.simpleBlock(FABlocks.PALAEONTOLOGY_TABLE.get(), this.models().cubeBottomTop("palaeontology_table", this.modLoc("block/palaeontology_table_side"), this.modLoc("block/lepidodendron_planks"), this.modLoc("block/palaeontology_table_top")).texture("particle", this.modLoc("block/palaeontology_table_side")));
        this.horizontalBlock(FABlocks.GENE_MODIFICATION_TABLE.get(), blockState -> blockState.getValue(GeneModificationBlock.ACTIVE) ? this.models().withExistingParent("gene_modification_table", this.modLoc("template_gene_modification_table")).texture("front", this.modLoc("block/gene_modification_table_front_on")) : this.models().withExistingParent("gene_modification_table", this.modLoc("template_gene_modification_table")).texture("front", this.modLoc("block/gene_modification_table_front_off")));
        this.getVariantBuilder(FABlocks.JURASSIC_FERN.get()).partialState().with(JurassicFernBlock.GROWTH, 0).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_lower_0", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_lower_0")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_lower_0")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 1).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_lower_1", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_lower_1")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_lower_1")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 2).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_lower_2", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_lower_2")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_lower_2")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 3).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_lower_3", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_lower_3")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_lower_3")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 4).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_lower_4", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_lower_4")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_lower_4")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 5).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_lower_5", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_lower_5")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_lower_5")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 0).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_upper_0", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_upper_4")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_upper_4")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 1).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_upper_1", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_upper_4")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_upper_4")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 2).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_upper_2", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_upper_4")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_upper_4")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 3).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_upper_3", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_upper_4")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_upper_4")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 4).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_upper_4", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_upper_4")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_upper_4")).renderType(this.mcLoc("cutout")))).partialState().with(JurassicFernBlock.GROWTH, 5).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().withExistingParent("jurassic_fern_upper_5", this.modLoc("block/template_colored_crop")).texture("crop", this.modLoc("block/jurassic_fern_colored_upper_5")).texture("crop_leaves", this.modLoc("block/jurassic_fern_leaves_upper_5")).renderType(this.mcLoc("cutout"))));
        this.getVariantBuilder(FABlocks.DRUM.get()).partialState().with(DrumBlock.COMMAND_TYPE_PROPERTY, "follow").addModels(new ConfiguredModel(this.models().cube("drum_follow", this.mcLoc("block/spruce_planks"), this.modLoc("block/drum_follow"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side")).texture("particle", this.modLoc("block/drum_side")))).partialState().with(DrumBlock.COMMAND_TYPE_PROPERTY, "free_move").addModels(new ConfiguredModel(this.models().cube("drum_free_move", this.mcLoc("block/spruce_planks"), this.modLoc("block/drum_free_move"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side")).texture("particle", this.modLoc("block/drum_side")))).partialState().with(DrumBlock.COMMAND_TYPE_PROPERTY, "stay").addModels(new ConfiguredModel(this.models().cube("drum_stay", this.mcLoc("block/spruce_planks"), this.modLoc("block/drum_stay"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side"), this.modLoc("block/drum_side")).texture("particle", this.modLoc("block/drum_side"))));
        this.horizontalBlock(FABlocks.FEEDER.get(), blockState -> this.models().cube("feeder" + (blockState.getValue(FeederBlock.HAS_FOOD) ? "_full" : "_empty"), this.mcLoc("block/smooth_stone"), this.modLoc("block/feeder_top" + (blockState.getValue(FeederBlock.HAS_FOOD) ? "_full" : "_empty")), this.modLoc("block/feeder_front"), this.modLoc("block/feeder_side"), this.modLoc("block/feeder_side"), this.modLoc("block/feeder_side")).texture("particle", this.modLoc("block/feeder_side")));
        this.simpleBlock(FABlocks.PERMAFROST.get());
        this.simpleBlock(FABlocks.ICED_STONE.get());
        this.simpleBlock(FABlocks.AXOLOTLSPAWN.get(), this.models().withExistingParent("axolotlspawn", this.mcLoc("block/frogspawn")).texture("texture", this.modLoc("block/axolotlspawn")).texture("particle", this.modLoc("block/axolotlspawn")).renderType(this.mcLoc("cutout")));
        this.simpleBlock(FABlocks.TIME_MACHINE.get(), this.models().withExistingParent("time_machine", this.modLoc("block/template_time_machine")));
        this.cauldron(FABlocks.RAW_CHICKEN_SOUP_CAULDRON.get(), "raw_chicken_soup");
        this.cauldron(FABlocks.COOKED_CHICKEN_SOUP_CAULDRON.get(), "cooked_chicken_soup");
        this.cauldron(FABlocks.RAW_BERRY_MEDLEY_CAULDRON.get(), "raw_berry_medley");
        this.cauldron(FABlocks.COOKED_BERRY_MEDLEY_CAULDRON.get(), "cooked_berry_medley");
        this.mayanVase(FABlocks.MAYAN_VASE.get(), "mayan_pot_side");
        this.mayanVase(FABlocks.MAYAN_JADE_VASE.get(), "mayan_pot_side_jade");
        this.mayanVase(FABlocks.MAYAN_OCELOT_VASE.get(), "mayan_pot_side_ocelot");
        this.mayanVase(FABlocks.MAYAN_VILLAGER_VASE.get(), "mayan_pot_side_villager");
        this.horizontalBlock(FABlocks.IRON_LLAMA_STATUE.get(), this.models().withExistingParent("iron_llama_statue", this.modLoc("block/template_llama")).texture("texture", this.modLoc("block/iron_llama_statue")).texture("particle", this.mcLoc("block/iron_block")));
        this.horizontalBlock(FABlocks.COPPER_LLAMA_STATUE.get(), this.models().withExistingParent("copper_llama_statue", this.modLoc("block/template_llama")).texture("texture", this.modLoc("block/copper_llama_statue")).texture("particle", this.mcLoc("block/copper_block")));
        this.horizontalBlock(FABlocks.EXPOSED_COPPER_LLAMA_STATUE.get(), this.models().withExistingParent("exposed_copper_llama_statue", this.modLoc("block/template_llama")).texture("texture", this.modLoc("block/exposed_copper_llama_statue")).texture("particle", this.mcLoc("block/exposed_copper")));
        this.horizontalBlock(FABlocks.WEATHERED_COPPER_LLAMA_STATUE.get(), this.models().withExistingParent("weathered_copper_llama_statue", this.modLoc("block/template_llama")).texture("texture", this.modLoc("block/weathered_copper_llama_statue")).texture("particle", this.mcLoc("block/weathered_copper")));
        this.horizontalBlock(FABlocks.OXIDIZED_COPPER_LLAMA_STATUE.get(), this.models().withExistingParent("oxidized_copper_llama_statue", this.modLoc("block/template_llama")).texture("texture", this.modLoc("block/oxidized_copper_llama_statue")).texture("particle", this.mcLoc("block/oxidized_copper")));
        this.horizontalBlock(FABlocks.WAXED_COPPER_LLAMA_STATUE.get(), this.models().withExistingParent("waxed_copper_llama_statue", this.modLoc("block/template_llama")).texture("texture", this.modLoc("block/copper_llama_statue")).texture("particle", this.mcLoc("block/copper_block")));
        this.horizontalBlock(FABlocks.WAXED_EXPOSED_COPPER_LLAMA_STATUE.get(), this.models().withExistingParent("waxed_exposed_copper_llama_statue", this.modLoc("block/template_llama")).texture("texture", this.modLoc("block/exposed_copper_llama_statue")).texture("particle", this.mcLoc("block/exposed_copper")));
        this.horizontalBlock(FABlocks.WAXED_WEATHERED_COPPER_LLAMA_STATUE.get(), this.models().withExistingParent("waxed_weathered_copper_llama_statue", this.modLoc("block/template_llama")).texture("texture", this.modLoc("block/weathered_copper_llama_statue")).texture("particle", this.mcLoc("block/weathered_copper")));
        this.horizontalBlock(FABlocks.WAXED_OXIDIZED_COPPER_LLAMA_STATUE.get(), this.models().withExistingParent("waxed_oxidized_copper_llama_statue", this.modLoc("block/template_llama")).texture("texture", this.modLoc("block/oxidized_copper_llama_statue")).texture("particle", this.mcLoc("block/oxidized_copper")));
        this.simpleBlock(FABlocks.LEPIDODENDRON_PLANKS.get());
        this.simpleBlock(FABlocks.LEPIDODENDRON_SAPLING.get(), this.models().cross("lepidodendron_sapling", this.modLoc("block/lepidodendron_sapling")).renderType("cutout"));
        this.logBlock(FABlocks.LEPIDODENDRON_LOG.get());
        this.logBlock(FABlocks.STRIPPED_LEPIDODENDRON_LOG.get());
        this.woodBlock(FABlocks.LEPIDODENDRON_WOOD.get(), this.modLoc("block/lepidodendron_log"));
        this.woodBlock(FABlocks.STRIPPED_LEPIDODENDRON_WOOD.get(), this.modLoc("block/stripped_lepidodendron_log"));
        this.simpleBlock(FABlocks.LEPIDODENDRON_LEAVES.get(), this.models().withExistingParent("lepidodendron_leaves", this.mcLoc("block/leaves")).texture("all", this.modLoc("block/lepidodendron_leaves")).renderType("cutout"));
        this.stairsBlock(FABlocks.LEPIDODENDRON_STAIRS.get(), this.modLoc("block/lepidodendron_planks"));
        this.signBlock(FABlocks.LEPIDODENDRON_SIGN.get(), FABlocks.LEPIDODENDRON_WALL_SIGN.get(), this.modLoc("block/lepidodendron_planks"));
        this.doorBlockWithRenderType(FABlocks.LEPIDODENDRON_DOOR.get(), this.modLoc("block/lepidodendron_door_bottom"), this.modLoc("block/lepidodendron_door_top"), "cutout");
        this.hangingSignBlock(FABlocks.LEPIDODENDRON_HANGING_SIGN.get(), FABlocks.LEPIDODENDRON_WALL_HANGING_SIGN.get(), this.modLoc("block/stripped_lepidodendron_log"));
        this.pressurePlateBlock(FABlocks.LEPIDODENDRON_PRESSURE_PLATE.get(), this.modLoc("block/lepidodendron_planks"));
        this.fenceBlock(FABlocks.LEPIDODENDRON_FENCE.get(), this.modLoc("block/lepidodendron_planks"));
        this.trapdoorBlockWithRenderType(FABlocks.LEPIDODENDRON_TRAPDOOR.get(), this.modLoc("block/lepidodendron_trapdoor"), true, "cutout");
        this.fenceGateBlock(FABlocks.LEPIDODENDRON_FENCE_GATE.get(), this.modLoc("block/lepidodendron_planks"));
        this.simpleBlock(FABlocks.POTTED_LEPIDODENDRON_SAPLING.get(), this.models().withExistingParent("potted_lepidodendron_sapling", this.mcLoc("block/flower_pot_cross")).texture("plant", this.modLoc("block/lepidodendron_sapling")).renderType("cutout"));
        this.buttonBlock(FABlocks.LEPIDODENDRON_BUTTON.get(), this.modLoc("block/lepidodendron_planks"));
        this.slabBlock(FABlocks.LEPIDODENDRON_SLAB.get(), this.modLoc("block/lepidodendron_planks"), this.modLoc("block/lepidodendron_planks"));
        this.simpleBlock(FABlocks.SIGILLARIA_PLANKS.get());
        this.simpleBlock(FABlocks.SIGILLARIA_SAPLING.get(), this.models().cross("sigillaria_sapling", this.modLoc("block/sigillaria_sapling")).renderType("cutout"));
        this.logBlock(FABlocks.SIGILLARIA_LOG.get());
        this.logBlock(FABlocks.STRIPPED_SIGILLARIA_LOG.get());
        this.woodBlock(FABlocks.SIGILLARIA_WOOD.get(), this.modLoc("block/sigillaria_log"));
        this.woodBlock(FABlocks.STRIPPED_SIGILLARIA_WOOD.get(), this.modLoc("block/stripped_sigillaria_log"));
        this.simpleBlock(FABlocks.SIGILLARIA_LEAVES.get(), this.models().withExistingParent("sigillaria_leaves", this.mcLoc("block/leaves")).texture("all", this.modLoc("block/sigillaria_leaves")).renderType("cutout"));
        this.stairsBlock(FABlocks.SIGILLARIA_STAIRS.get(), this.modLoc("block/sigillaria_planks"));
        this.signBlock(FABlocks.SIGILLARIA_SIGN.get(), FABlocks.SIGILLARIA_WALL_SIGN.get(), this.modLoc("block/sigillaria_planks"));
        this.doorBlock(FABlocks.SIGILLARIA_DOOR.get(), this.modLoc("block/sigillaria_door_bottom"), this.modLoc("block/sigillaria_door_top"));
        this.hangingSignBlock(FABlocks.SIGILLARIA_HANGING_SIGN.get(), FABlocks.SIGILLARIA_WALL_HANGING_SIGN.get(), this.modLoc("block/stripped_sigillaria_log"));
        this.pressurePlateBlock(FABlocks.SIGILLARIA_PRESSURE_PLATE.get(), this.modLoc("block/sigillaria_planks"));
        this.fenceBlock(FABlocks.SIGILLARIA_FENCE.get(), this.modLoc("block/sigillaria_planks"));
        this.trapdoorBlock(FABlocks.SIGILLARIA_TRAPDOOR.get(), this.modLoc("block/sigillaria_trapdoor"), true);
        this.fenceGateBlock(FABlocks.SIGILLARIA_FENCE_GATE.get(), this.modLoc("block/sigillaria_planks"));
        this.simpleBlock(FABlocks.POTTED_SIGILLARIA_SAPLING.get(), this.models().withExistingParent("potted_sigillaria_sapling", this.mcLoc("block/flower_pot_cross")).texture("plant", this.modLoc("block/sigillaria_sapling")).renderType("cutout"));
        this.buttonBlock(FABlocks.SIGILLARIA_BUTTON.get(), this.modLoc("block/sigillaria_planks"));
        this.slabBlock(FABlocks.SIGILLARIA_SLAB.get(), this.modLoc("block/sigillaria_planks"), this.modLoc("block/sigillaria_planks"));
        this.simpleBlock(FABlocks.CALAMITES_PLANKS.get());
        this.simpleBlock(FABlocks.CALAMITES_SAPLING.get(), this.models().cross("calamites_sapling", this.modLoc("block/calamites_sapling")).renderType("cutout"));
        this.logBlock(FABlocks.CALAMITES_LOG.get());
        this.logBlock(FABlocks.STRIPPED_CALAMITES_LOG.get());
        this.woodBlock(FABlocks.CALAMITES_WOOD.get(), this.modLoc("block/calamites_log"));
        this.woodBlock(FABlocks.STRIPPED_CALAMITES_WOOD.get(), this.modLoc("block/stripped_calamites_log"));
        this.simpleBlock(FABlocks.CALAMITES_LEAVES.get(), this.models().withExistingParent("calamites_leaves", this.mcLoc("block/leaves")).texture("all", this.modLoc("block/calamites_leaves")).renderType("cutout"));
        this.stairsBlock(FABlocks.CALAMITES_STAIRS.get(), this.modLoc("block/calamites_planks"));
        this.signBlock(FABlocks.CALAMITES_SIGN.get(), FABlocks.CALAMITES_WALL_SIGN.get(), this.modLoc("block/calamites_planks"));
        this.doorBlock(FABlocks.CALAMITES_DOOR.get(), this.modLoc("block/calamites_door_bottom"), this.modLoc("block/calamites_door_top"));
        this.hangingSignBlock(FABlocks.CALAMITES_HANGING_SIGN.get(), FABlocks.CALAMITES_WALL_HANGING_SIGN.get(), this.modLoc("block/stripped_calamites_log"));
        this.pressurePlateBlock(FABlocks.CALAMITES_PRESSURE_PLATE.get(), this.modLoc("block/calamites_planks"));
        this.fenceBlock(FABlocks.CALAMITES_FENCE.get(), this.modLoc("block/calamites_planks"));
        this.trapdoorBlock(FABlocks.CALAMITES_TRAPDOOR.get(), this.modLoc("block/calamites_trapdoor"), true);
        this.fenceGateBlock(FABlocks.CALAMITES_FENCE_GATE.get(), this.modLoc("block/calamites_planks"));
        this.simpleBlock(FABlocks.POTTED_CALAMITES_SAPLING.get(), this.models().withExistingParent("potted_calamites_sapling", this.mcLoc("block/flower_pot_cross")).texture("plant", this.modLoc("block/calamites_sapling")).renderType("cutout"));
        this.buttonBlock(FABlocks.CALAMITES_BUTTON.get(), this.modLoc("block/calamites_planks"));
        this.slabBlock(FABlocks.CALAMITES_SLAB.get(), this.modLoc("block/calamites_planks"), this.modLoc("block/calamites_planks"));
    }

    private void fossil(Block block, boolean deepslate) {
        ConfiguredModel[] configuredModels;
        if (deepslate) {
            configuredModels = new ConfiguredModel[]{new ConfiguredModel(this.models().cubeAll("deepslate_shells_fossil_ore", this.modLoc("block/deepslate_shells_fossil_ore"))), new ConfiguredModel(this.models().cubeAll("deepslate_anomalocaris_fossil_ore", this.modLoc("block/deepslate_anomalocaris_fossil_ore"))), new ConfiguredModel(this.models().cubeAll("deepslate_trilobite_fossil_ore", this.modLoc("block/deepslate_trilobite_fossil_ore")))};
        } else {
            configuredModels = new ConfiguredModel[]{new ConfiguredModel(this.models().cubeAll("shells_fossil_ore", this.modLoc("block/shells_fossil_ore"))), new ConfiguredModel(this.models().cubeAll("raptor_leg_fossil_ore", this.modLoc("block/raptor_leg_fossil_ore"))), new ConfiguredModel(this.models().cubeAll("tyrannosaurus_skull_fossil_ore", this.modLoc("block/tyrannosaurus_skull_fossil_ore")))};
        }
        this.simpleBlock(block, configuredModels);
    }

    private void cultivator(Block block, String color) {
        this.getVariantBuilder(block).forAllStates(blockState -> ConfiguredModel.builder().modelFile(this.model(blockState.getValue(CultivatorBlock.ACTIVE), color)).build());
    }

    private BlockModelBuilder model(boolean active, String color) {
        String name = active ? color + "_cultivator_active" : color + "_cultivator";
        String parent = active ? "block/template_cultivator_active" : "block/template_cultivator";
        return this.models().withExistingParent(name, this.modLoc(parent)).texture("side", this.modLoc("block/" + color + "_cultivator_side")).texture("top", this.modLoc("block/" + color + "_cultivator_top")).renderType("translucent");
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
}
