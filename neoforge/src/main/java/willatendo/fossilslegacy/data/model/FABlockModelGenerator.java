package willatendo.fossilslegacy.data.model;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.*;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.data.FABlockFamilies;
import willatendo.fossilslegacy.data.FAModelTemplates;
import willatendo.fossilslegacy.data.FATextureSlot;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.blocks.*;
import willatendo.fossilslegacy.server.block.properties.FABlockStateProperties;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.data.model.SimpleBlockModelGenerator;

import java.util.List;

public class FABlockModelGenerator extends SimpleBlockModelGenerator {
    public FABlockModelGenerator(BlockModelGenerators blockModelGenerators) {
        super(blockModelGenerators, FAUtils.ID);
    }

    @Override
    public void run() {
        this.createBlockFamilies(FABlockFamilies.getAllFamilies());
        this.createFossil(FABlocks.FOSSIL_ORE.get(), false, "shells", "raptor_leg", "tyrannosaurus_skull");
        this.createFossil(FABlocks.DEEPSLATE_FOSSIL_ORE.get(), true, "shells", "anomalocaris", "trilobite");
        this.createSkull(FABlocks.SKULL_BLOCK.get(), this.modLocation("block/skull_front"));
        this.createSkull(FABlocks.SKULL_LANTERN_BLOCK.get(), this.modLocation("block/skull_lantern_front"));
        this.createAnalyzer(FABlocks.ANALYZER.get());
        this.createCultivator(FABlocks.WHITE_CULTIVATOR.get(), "white");
        this.createCultivator(FABlocks.ORANGE_CULTIVATOR.get(), "orange");
        this.createCultivator(FABlocks.MAGENTA_CULTIVATOR.get(), "magenta");
        this.createCultivator(FABlocks.LIGHT_BLUE_CULTIVATOR.get(), "light_blue");
        this.createCultivator(FABlocks.YELLOW_CULTIVATOR.get(), "yellow");
        this.createCultivator(FABlocks.LIME_CULTIVATOR.get(), "lime");
        this.createCultivator(FABlocks.PINK_CULTIVATOR.get(), "pink");
        this.createCultivator(FABlocks.GRAY_CULTIVATOR.get(), "gray");
        this.createCultivator(FABlocks.LIGHT_GRAY_CULTIVATOR.get(), "light_gray");
        this.createCultivator(FABlocks.CYAN_CULTIVATOR.get(), "cyan");
        this.createCultivator(FABlocks.PURPLE_CULTIVATOR.get(), "purple");
        this.createCultivator(FABlocks.BLUE_CULTIVATOR.get(), "blue");
        this.createCultivator(FABlocks.BROWN_CULTIVATOR.get(), "brown");
        this.createCultivator(FABlocks.GREEN_CULTIVATOR.get(), "green");
        this.createCultivator(FABlocks.RED_CULTIVATOR.get(), "red");
        this.createCultivator(FABlocks.BLACK_CULTIVATOR.get(), "black");
        this.createArchaeologyWorkbench(FABlocks.ARCHAEOLOGY_WORKBENCH.get());
        this.createPalaeontologyTable(FABlocks.PALAEONTOLOGY_TABLE.get());
        this.createGeneModificationTable(FABlocks.DNA_RECOMBINATOR.get());
        this.createJurassicFern(FABlocks.JURASSIC_FERN.get());
        this.createHorsetail(FABlocks.SHORT_HORSETAIL.get());
        this.createTallHorsetail(FABlocks.TALL_HORSETAIL.get());
        this.createDrum(FABlocks.DRUM.get());
        this.createFeeder(FABlocks.FEEDER.get());
        this.createAxolotlSpawn(FABlocks.AXOLOTLSPAWN.get());
        this.createTimeMachine(FABlocks.TIME_MACHINE.get());
        this.createCauldron(FABlocks.RAW_CHICKEN_SOUP_CAULDRON.get(), this.modLocation("block/raw_chicken_soup"));
        this.createCauldron(FABlocks.COOKED_CHICKEN_SOUP_CAULDRON.get(), this.modLocation("block/cooked_chicken_soup"));
        this.createCauldron(FABlocks.RAW_BERRY_MEDLEY_CAULDRON.get(), this.modLocation("block/raw_berry_medley"));
        this.createCauldron(FABlocks.COOKED_BERRY_MEDLEY_CAULDRON.get(), this.modLocation("block/cooked_berry_medley"));
        this.createBasic(FABlocks.PERMAFROST.get());
        this.createBasic(FABlocks.ICED_STONE.get());
        this.createMayanVase(FABlocks.MAYAN_VASE.get(), this.modLocation("block/mayan_pot_side"));
        this.createMayanVase(FABlocks.MAYAN_JADE_VASE.get(), this.modLocation("block/mayan_pot_side_jade"));
        this.createMayanVase(FABlocks.MAYAN_OCELOT_VASE.get(), this.modLocation("block/mayan_pot_side_ocelot"));
        this.createMayanVase(FABlocks.MAYAN_VILLAGER_VASE.get(), this.modLocation("block/mayan_pot_side_villager"));
        this.createLlamaStatue(FABlocks.IRON_LLAMA_STATUE.get(), this.modLocation("block/iron_llama_statue"), this.mcLocation("block/iron_block"));
        this.createLlamaStatue(FABlocks.COPPER_LLAMA_STATUE.get(), this.modLocation("block/copper_llama_statue"), this.mcLocation("block/copper_block"));
        this.createLlamaStatue(FABlocks.EXPOSED_COPPER_LLAMA_STATUE.get(), this.modLocation("block/exposed_copper_llama_statue"), this.mcLocation("block/exposed_copper"));
        this.createLlamaStatue(FABlocks.WEATHERED_COPPER_LLAMA_STATUE.get(), this.modLocation("block/weathered_copper_llama_statue"), this.mcLocation("block/weathered_copper"));
        this.createLlamaStatue(FABlocks.OXIDIZED_COPPER_LLAMA_STATUE.get(), this.modLocation("block/oxidized_copper_llama_statue"), this.mcLocation("block/oxidized_copper"));
        this.createLlamaStatue(FABlocks.WAXED_COPPER_LLAMA_STATUE.get(), this.modLocation("block/copper_llama_statue"), this.mcLocation("block/copper_block"));
        this.createLlamaStatue(FABlocks.WAXED_EXPOSED_COPPER_LLAMA_STATUE.get(), this.modLocation("block/exposed_copper_llama_statue"), this.mcLocation("block/exposed_copper"));
        this.createLlamaStatue(FABlocks.WAXED_WEATHERED_COPPER_LLAMA_STATUE.get(), this.modLocation("block/weathered_copper_llama_statue"), this.mcLocation("block/weathered_copper"));
        this.createLlamaStatue(FABlocks.WAXED_OXIDIZED_COPPER_LLAMA_STATUE.get(), this.modLocation("block/oxidized_copper_llama_statue"), this.mcLocation("block/oxidized_copper"));
        this.createDecorationPost(FABlocks.WHITE_DECORATION_POST.get(), Blocks.WHITE_CONCRETE);
        this.createDecorationPost(FABlocks.ORANGE_DECORATION_POST.get(), Blocks.ORANGE_CONCRETE);
        this.createDecorationPost(FABlocks.MAGENTA_DECORATION_POST.get(), Blocks.MAGENTA_CONCRETE);
        this.createDecorationPost(FABlocks.LIGHT_BLUE_DECORATION_POST.get(), Blocks.LIGHT_BLUE_CONCRETE);
        this.createDecorationPost(FABlocks.YELLOW_DECORATION_POST.get(), Blocks.YELLOW_CONCRETE);
        this.createDecorationPost(FABlocks.LIME_DECORATION_POST.get(), Blocks.LIME_CONCRETE);
        this.createDecorationPost(FABlocks.PINK_DECORATION_POST.get(), Blocks.PINK_CONCRETE);
        this.createDecorationPost(FABlocks.GRAY_DECORATION_POST.get(), Blocks.GRAY_CONCRETE);
        this.createDecorationPost(FABlocks.LIGHT_GRAY_DECORATION_POST.get(), Blocks.LIGHT_GRAY_CONCRETE);
        this.createDecorationPost(FABlocks.CYAN_DECORATION_POST.get(), Blocks.CYAN_CONCRETE);
        this.createDecorationPost(FABlocks.PURPLE_DECORATION_POST.get(), Blocks.PURPLE_CONCRETE);
        this.createDecorationPost(FABlocks.BLUE_DECORATION_POST.get(), Blocks.BLUE_CONCRETE);
        this.createDecorationPost(FABlocks.BROWN_DECORATION_POST.get(), Blocks.BROWN_CONCRETE);
        this.createDecorationPost(FABlocks.GREEN_DECORATION_POST.get(), Blocks.GREEN_CONCRETE);
        this.createDecorationPost(FABlocks.RED_DECORATION_POST.get(), Blocks.RED_CONCRETE);
        this.createDecorationPost(FABlocks.BLACK_DECORATION_POST.get(), Blocks.BLACK_CONCRETE);
        this.basic(FABlocks.SMALL_CAGE.get(), FAModelTemplates.TEMPLATE_SMALL_CAGE, new TextureMapping());
        this.blockModelGenerators.woodProvider(FABlocks.ARCHAEOPTERIS_LOG.get()).logWithHorizontal(FABlocks.ARCHAEOPTERIS_LOG.get()).wood(FABlocks.ARCHAEOPTERIS_WOOD.get());
        this.blockModelGenerators.woodProvider(FABlocks.STRIPPED_ARCHAEOPTERIS_LOG.get()).logWithHorizontal(FABlocks.STRIPPED_ARCHAEOPTERIS_LOG.get()).wood(FABlocks.STRIPPED_ARCHAEOPTERIS_WOOD.get());
        this.blockModelGenerators.createHangingSign(FABlocks.STRIPPED_ARCHAEOPTERIS_LOG.get(), FABlocks.ARCHAEOPTERIS_HANGING_SIGN.get(), FABlocks.ARCHAEOPTERIS_WALL_HANGING_SIGN.get());
        this.createPlantWithDefaultItem(FABlocks.ARCHAEOPTERIS_SAPLING.get(), FABlocks.POTTED_ARCHAEOPTERIS_SAPLING.get(), SimpleBlockModelGenerator.PlantType.NOT_TINTED);
        this.createBranch(FABlocks.ARCHAEOPTERIS_LEAVES.get(), FAUtils.resource("block/archaeopteris_leaves"), FAUtils.resource("block/archaeopteris_log"), -12012264);
        this.blockModelGenerators.woodProvider(FABlocks.CALAMITES_LOG.get()).logWithHorizontal(FABlocks.CALAMITES_LOG.get()).wood(FABlocks.CALAMITES_WOOD.get());
        this.blockModelGenerators.woodProvider(FABlocks.STRIPPED_CALAMITES_LOG.get()).logWithHorizontal(FABlocks.STRIPPED_CALAMITES_LOG.get()).wood(FABlocks.STRIPPED_CALAMITES_WOOD.get());
        this.blockModelGenerators.createHangingSign(FABlocks.STRIPPED_CALAMITES_LOG.get(), FABlocks.CALAMITES_HANGING_SIGN.get(), FABlocks.CALAMITES_WALL_HANGING_SIGN.get());
        this.createPlantWithDefaultItem(FABlocks.CALAMITES_SAPLING.get(), FABlocks.POTTED_CALAMITES_SAPLING.get(), SimpleBlockModelGenerator.PlantType.NOT_TINTED);
        this.blockModelGenerators.createTintedLeaves(FABlocks.CALAMITES_LEAVES.get(), TexturedModel.LEAVES, -12012264);
        this.blockModelGenerators.woodProvider(FABlocks.LEPIDODENDRON_LOG.get()).logWithHorizontal(FABlocks.LEPIDODENDRON_LOG.get()).wood(FABlocks.LEPIDODENDRON_WOOD.get());
        this.blockModelGenerators.woodProvider(FABlocks.STRIPPED_LEPIDODENDRON_LOG.get()).logWithHorizontal(FABlocks.STRIPPED_LEPIDODENDRON_LOG.get()).wood(FABlocks.STRIPPED_LEPIDODENDRON_WOOD.get());
        this.blockModelGenerators.createHangingSign(FABlocks.STRIPPED_LEPIDODENDRON_LOG.get(), FABlocks.LEPIDODENDRON_HANGING_SIGN.get(), FABlocks.LEPIDODENDRON_WALL_HANGING_SIGN.get());
        this.createPlantWithDefaultItem(FABlocks.LEPIDODENDRON_SAPLING.get(), FABlocks.POTTED_LEPIDODENDRON_SAPLING.get(), SimpleBlockModelGenerator.PlantType.NOT_TINTED);
        this.blockModelGenerators.createTintedLeaves(FABlocks.LEPIDODENDRON_LEAVES.get(), TexturedModel.LEAVES, -12012264);
        this.blockModelGenerators.woodProvider(FABlocks.SIGILLARIA_LOG.get()).logWithHorizontal(FABlocks.SIGILLARIA_LOG.get()).wood(FABlocks.SIGILLARIA_WOOD.get());
        this.blockModelGenerators.woodProvider(FABlocks.STRIPPED_SIGILLARIA_LOG.get()).logWithHorizontal(FABlocks.STRIPPED_SIGILLARIA_LOG.get()).wood(FABlocks.STRIPPED_SIGILLARIA_WOOD.get());
        this.blockModelGenerators.createHangingSign(FABlocks.STRIPPED_SIGILLARIA_LOG.get(), FABlocks.SIGILLARIA_HANGING_SIGN.get(), FABlocks.SIGILLARIA_WALL_HANGING_SIGN.get());
        this.createPlantWithDefaultItem(FABlocks.SIGILLARIA_SAPLING.get(), FABlocks.POTTED_SIGILLARIA_SAPLING.get(), SimpleBlockModelGenerator.PlantType.NOT_TINTED);
        this.blockModelGenerators.createTintedLeaves(FABlocks.SIGILLARIA_LEAVES.get(), TexturedModel.LEAVES, -12012264);
        this.block(MultiVariantGenerator.multiVariant(FABlocks.TAR.get(), Variant.variant().with(VariantProperties.MODEL, FAModelTemplates.TEMPLATE_LIQUID.create(FABlocks.TAR.get(), new TextureMapping().put(TextureSlot.PARTICLE, this.mcLocation("block/bedrock")), this.modelOutput))));
    }

    private void basic(Block block, ModelTemplate modelTemplate, TextureMapping textureMapping) {
        this.block(BlockModelGenerators.createSimpleBlock(block, modelTemplate.create(block, textureMapping, this.modelOutput)));
    }

    private void createBasic(Block block) {
        this.block(BlockModelGenerators.createSimpleBlock(block, ModelTemplates.CUBE_ALL.create(block, TextureMapping.cube(block), this.modelOutput)));
    }

    private void createFossil(Block fossil, boolean deepslate, String... variantNames) {
        List<Variant> variants = Lists.newArrayList();
        for (int i = 0; i < variantNames.length; i++) {
            String variantName = variantNames[i];
            String blockId = BuiltInRegistries.BLOCK.getKey(fossil).getPath();
            String texturePath = deepslate ? "block/deepslate_" + variantName + "_" + blockId.replace("deepslate_", "") : "block/" + variantName + "_" + blockId;
            ResourceLocation model = ModelTemplates.CUBE_ALL.create(this.modLocation(texturePath), TextureMapping.cube(this.modLocation(texturePath)), this.modelOutput);
            variants.add(Variant.variant().with(VariantProperties.MODEL, model));
            if (i == 0) {
                this.blockModelGenerators.registerSimpleItemModel(fossil, model);
            }
        }
        this.block(MultiVariantGenerator.multiVariant(fossil, variants.toArray(Variant[]::new)));
    }

    private void createSkull(Block skull, ResourceLocation frontTexture) {
        this.block(MultiVariantGenerator.multiVariant(skull, Variant.variant().with(VariantProperties.MODEL, ModelTemplates.CUBE.create(skull, new TextureMapping().put(TextureSlot.DOWN, this.modLocation("block/skull")).put(TextureSlot.EAST, this.modLocation("block/skull_crack")).put(TextureSlot.NORTH, frontTexture).put(TextureSlot.PARTICLE, this.modLocation("block/skull_crack")).put(TextureSlot.SOUTH, this.modLocation("block/skull_crack")).put(TextureSlot.UP, this.modLocation("block/skull")).put(TextureSlot.WEST, this.modLocation("block/skull_crack")), this.modelOutput))).with(BlockModelGenerators.createHorizontalFacingDispatch()));
    }

    private void createAnalyzer(Block analyzer) {
        this.createActiveType(analyzer, ModelTemplates.CUBE.create(analyzer, new TextureMapping().put(TextureSlot.DOWN, this.modLocation("block/analyzer_top")).put(TextureSlot.EAST, this.modLocation("block/analyzer_side")).put(TextureSlot.NORTH, this.modLocation("block/analyzer_front_off")).put(TextureSlot.PARTICLE, this.modLocation("block/analyzer_side")).put(TextureSlot.SOUTH, this.modLocation("block/analyzer_back")).put(TextureSlot.UP, this.modLocation("block/analyzer_top")).put(TextureSlot.WEST, this.modLocation("block/analyzer_side")), this.modelOutput), ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(analyzer).withSuffix("_active"), new TextureMapping().put(TextureSlot.DOWN, this.modLocation("block/analyzer_top")).put(TextureSlot.EAST, this.modLocation("block/analyzer_side")).put(TextureSlot.NORTH, this.modLocation("block/analyzer_front_on")).put(TextureSlot.PARTICLE, this.modLocation("block/analyzer_side")).put(TextureSlot.SOUTH, this.modLocation("block/analyzer_back")).put(TextureSlot.UP, this.modLocation("block/analyzer_top")).put(TextureSlot.WEST, this.modLocation("block/analyzer_side")), this.modelOutput), FABlockStateProperties.ACTIVE, true);
    }

    private void createCultivator(Block cultivator, String color) {
        this.createActiveType(cultivator, FAModelTemplates.TEMPLATE_CULTIVATOR.create(cultivator, new TextureMapping().put(TextureSlot.SIDE, this.modLocation("block/" + color + "_cultivator_side")).put(TextureSlot.TOP, this.modLocation("block/" + color + "_cultivator_top")), this.modelOutput), FAModelTemplates.TEMPLATE_CULTIVATOR_ACTIVE.create(ModelLocationUtils.getModelLocation(cultivator).withSuffix("_active"), new TextureMapping().put(TextureSlot.SIDE, this.modLocation("block/" + color + "_cultivator_side")).put(TextureSlot.TOP, this.modLocation("block/" + color + "_cultivator_top")), this.modelOutput), FABlockStateProperties.ACTIVE, false);
    }

    private void createArchaeologyWorkbench(Block archeologyWorkbench) {
        this.createActiveType(archeologyWorkbench, ModelTemplates.CUBE.create(archeologyWorkbench, new TextureMapping().put(TextureSlot.DOWN, this.modLocation("block/archaeology_workbench_bottom")).put(TextureSlot.EAST, this.modLocation("block/archaeology_workbench_side")).put(TextureSlot.NORTH, this.modLocation("block/archaeology_workbench_books")).put(TextureSlot.PARTICLE, this.modLocation("block/archaeology_workbench_side")).put(TextureSlot.SOUTH, this.modLocation("block/archaeology_workbench_books")).put(TextureSlot.UP, this.modLocation("block/archaeology_workbench_top_off")).put(TextureSlot.WEST, this.modLocation("block/archaeology_workbench_side")), this.modelOutput), ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(archeologyWorkbench).withSuffix("_active"), new TextureMapping().put(TextureSlot.DOWN, this.modLocation("block/archaeology_workbench_bottom")).put(TextureSlot.EAST, this.modLocation("block/archaeology_workbench_side")).put(TextureSlot.NORTH, this.modLocation("block/archaeology_workbench_books")).put(TextureSlot.PARTICLE, this.modLocation("block/archaeology_workbench_side")).put(TextureSlot.SOUTH, this.modLocation("block/archaeology_workbench_books")).put(TextureSlot.UP, this.modLocation("block/archaeology_workbench_top_on")).put(TextureSlot.WEST, this.modLocation("block/archaeology_workbench_side")), this.modelOutput), FABlockStateProperties.ACTIVE, true);
    }

    private void createPalaeontologyTable(Block palaeontologyTable) {
        this.block(MultiVariantGenerator.multiVariant(palaeontologyTable, Variant.variant().with(VariantProperties.MODEL, ModelTemplates.CUBE_BOTTOM_TOP.create(palaeontologyTable, new TextureMapping().put(TextureSlot.BOTTOM, this.modLocation("block/lepidodendron_planks")).put(TextureSlot.PARTICLE, this.modLocation("block/palaeontology_table_side")).put(TextureSlot.SIDE, this.modLocation("block/palaeontology_table_side")).put(TextureSlot.TOP, this.modLocation("block/palaeontology_table_top")), this.modelOutput))));
    }

    private void createActiveType(Block block, ResourceLocation inactive, ResourceLocation active, BooleanProperty booleanProperty, boolean directional) {
        MultiVariantGenerator multiVariantGenerator = MultiVariantGenerator.multiVariant(block, Variant.variant()).with(BlockModelGenerators.createBooleanModelDispatch(booleanProperty, active, inactive));
        if (directional) {
            multiVariantGenerator.with(BlockModelGenerators.createHorizontalFacingDispatch());
        }
        this.block(multiVariantGenerator);
    }

    private void createGeneModificationTable(Block geneModificationTable) {
        this.block(MultiVariantGenerator.multiVariant(geneModificationTable, Variant.variant().with(VariantProperties.MODEL, FAModelTemplates.TEMPLATE_DNA_RECOMBINATOR.create(geneModificationTable, new TextureMapping().put(TextureSlot.FRONT, this.modLocation("block/dna_recombinator_front")), this.modelOutput))).with(BlockModelGenerators.createHorizontalFacingDispatch()));
    }

    private void createJurassicFern(Block jurassicFern) {
        this.blockModelGenerators.registerSimpleItemModel(jurassicFern, ModelTemplates.FLAT_ITEM.create(jurassicFern, new TextureMapping().put(TextureSlot.LAYER0, this.modLocation("block/fern_lower_3")), this.modelOutput));
        this.block(MultiVariantGenerator.multiVariant(jurassicFern).with(PropertyDispatch.properties(JurassicFernBlock.HALF, JurassicFernBlock.GROWTH).select(DoubleBlockHalf.LOWER, 0, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(jurassicFern, DoubleBlockHalf.LOWER, 0))).select(DoubleBlockHalf.LOWER, 1, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(jurassicFern, DoubleBlockHalf.LOWER, 1))).select(DoubleBlockHalf.LOWER, 2, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(jurassicFern, DoubleBlockHalf.LOWER, 2))).select(DoubleBlockHalf.LOWER, 3, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(jurassicFern, DoubleBlockHalf.LOWER, 3))).select(DoubleBlockHalf.LOWER, 4, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(jurassicFern, DoubleBlockHalf.LOWER, 4))).select(DoubleBlockHalf.LOWER, 5, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(jurassicFern, DoubleBlockHalf.LOWER, 5))).select(DoubleBlockHalf.UPPER, 0, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(jurassicFern, DoubleBlockHalf.UPPER, 0))).select(DoubleBlockHalf.UPPER, 1, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(jurassicFern, DoubleBlockHalf.UPPER, 1))).select(DoubleBlockHalf.UPPER, 2, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(jurassicFern, DoubleBlockHalf.UPPER, 2))).select(DoubleBlockHalf.UPPER, 3, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(jurassicFern, DoubleBlockHalf.UPPER, 3))).select(DoubleBlockHalf.UPPER, 4, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(jurassicFern, DoubleBlockHalf.UPPER, 4))).select(DoubleBlockHalf.UPPER, 5, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(jurassicFern, DoubleBlockHalf.UPPER, 5)))));
    }

    private ResourceLocation createJurassicFernModel(Block jurassicFern, DoubleBlockHalf doubleBlockHalf, int growthStage) {
        int i = (doubleBlockHalf == DoubleBlockHalf.UPPER && growthStage < 4) ? 4 : growthStage;
        return FAModelTemplates.TEMPLATE_COLORED_CROP.create(ModelLocationUtils.getModelLocation(jurassicFern).withSuffix("_" + doubleBlockHalf.getSerializedName() + "_" + growthStage), new TextureMapping().put(TextureSlot.CROP, this.modLocation("block/jurassic_fern_colored_" + doubleBlockHalf.getSerializedName() + "_" + i)).put(FATextureSlot.CROP_LEAVES, this.modLocation("block/jurassic_fern_leaves_" + doubleBlockHalf.getSerializedName() + "_" + i)), this.modelOutput);
    }

    private void createHorsetail(Block horsetail) {
        ResourceLocation plant1Texture = this.modLocation("block/horsetail_1");
        ResourceLocation plant2Texture = this.modLocation("block/horsetail_2");
        ResourceLocation plant3Texture = this.modLocation("block/horsetail_3");
        this.blockModelGenerators.registerSimpleTintedItemModel(horsetail, ModelTemplates.FLAT_ITEM.create(horsetail, new TextureMapping().put(TextureSlot.LAYER0, plant2Texture), this.modelOutput), ItemModelUtils.constantTint(-12012264));
        ResourceLocation plant1Model = FAModelTemplates.TEMPLATE_PLANT_1.create(ModelLocationUtils.getModelLocation(horsetail).withSuffix("_1"), new TextureMapping().put(FATextureSlot.PLANT_1, plant1Texture), this.modelOutput);
        ResourceLocation plant2Model = FAModelTemplates.TEMPLATE_PLANT_2.create(ModelLocationUtils.getModelLocation(horsetail).withSuffix("_2"), new TextureMapping().put(FATextureSlot.PLANT_1, plant1Texture).put(FATextureSlot.PLANT_2, plant2Texture), this.modelOutput);
        ResourceLocation plant3Model = FAModelTemplates.TEMPLATE_PLANT_3.create(ModelLocationUtils.getModelLocation(horsetail).withSuffix("_3"), new TextureMapping().put(FATextureSlot.PLANT_1, plant1Texture).put(FATextureSlot.PLANT_2, plant2Texture).put(FATextureSlot.PLANT_3, plant3Texture), this.modelOutput);
        this.block(MultiPartGenerator.multiPart(horsetail).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH), Variant.variant().with(VariantProperties.MODEL, plant1Model)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST), Variant.variant().with(VariantProperties.MODEL, plant1Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH), Variant.variant().with(VariantProperties.MODEL, plant1Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST), Variant.variant().with(VariantProperties.MODEL, plant1Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH), Variant.variant().with(VariantProperties.MODEL, plant2Model)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST), Variant.variant().with(VariantProperties.MODEL, plant2Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH), Variant.variant().with(VariantProperties.MODEL, plant2Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST), Variant.variant().with(VariantProperties.MODEL, plant2Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH), Variant.variant().with(VariantProperties.MODEL, plant3Model)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST), Variant.variant().with(VariantProperties.MODEL, plant3Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH), Variant.variant().with(VariantProperties.MODEL, plant3Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST), Variant.variant().with(VariantProperties.MODEL, plant3Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)));
    }

    private void createTallHorsetail(Block tallHorsetail) {
        ResourceLocation stemTexture = this.modLocation("block/horsetail_stem");
        ResourceLocation plant1Texture = this.modLocation("block/horsetail_1");
        ResourceLocation plant2Texture = this.modLocation("block/horsetail_2");
        ResourceLocation plant3Texture = this.modLocation("block/horsetail_3");
        this.blockModelGenerators.registerSimpleTintedItemModel(tallHorsetail, ModelTemplates.FLAT_ITEM.create(tallHorsetail, new TextureMapping().put(TextureSlot.LAYER0, plant3Texture), this.modelOutput), ItemModelUtils.constantTint(-12012264));
        ResourceLocation plant1Model = FAModelTemplates.TEMPLATE_PLANT_1.create(ModelLocationUtils.getModelLocation(tallHorsetail).withSuffix("_1"), new TextureMapping().put(FATextureSlot.PLANT_1, plant1Texture), this.modelOutput);
        ResourceLocation plant2Model = FAModelTemplates.TEMPLATE_PLANT_2.create(ModelLocationUtils.getModelLocation(tallHorsetail).withSuffix("_2"), new TextureMapping().put(FATextureSlot.PLANT_2, plant2Texture), this.modelOutput);
        ResourceLocation plant3Model = FAModelTemplates.TEMPLATE_PLANT_3.create(ModelLocationUtils.getModelLocation(tallHorsetail).withSuffix("_3"), new TextureMapping().put(FATextureSlot.PLANT_3, plant3Texture), this.modelOutput);
        ResourceLocation stem1Model = FAModelTemplates.TEMPLATE_PLANT_1.create(ModelLocationUtils.getModelLocation(tallHorsetail).withSuffix("_stem_1"), new TextureMapping().put(FATextureSlot.PLANT_1, stemTexture), this.modelOutput);
        ResourceLocation stem2Model = FAModelTemplates.TEMPLATE_PLANT_2.create(ModelLocationUtils.getModelLocation(tallHorsetail).withSuffix("_stem_2"), new TextureMapping().put(FATextureSlot.PLANT_2, stemTexture), this.modelOutput);
        ResourceLocation stem3Model = FAModelTemplates.TEMPLATE_PLANT_3.create(ModelLocationUtils.getModelLocation(tallHorsetail).withSuffix("_stem_3"), new TextureMapping().put(FATextureSlot.PLANT_3, stemTexture), this.modelOutput);
        this.block(MultiPartGenerator.multiPart(tallHorsetail).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem1Model)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem1Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem1Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem1Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem2Model)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem2Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem2Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem2Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem3Model)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem3Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem3Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem3Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant1Model)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant1Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant1Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant1Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant2Model)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant2Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant2Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant2Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant3Model)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant3Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant3Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant3Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)));
    }

    private void createDrum(Block drum) {
        ResourceLocation followModel = ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(drum).withSuffix("_follow"), new TextureMapping().put(TextureSlot.DOWN, this.mcLocation("block/spruce_planks")).put(TextureSlot.EAST, this.modLocation("block/drum_side")).put(TextureSlot.NORTH, this.modLocation("block/drum_side")).put(TextureSlot.PARTICLE, this.modLocation("block/drum_side")).put(TextureSlot.SOUTH, this.modLocation("block/drum_side")).put(TextureSlot.UP, this.modLocation("block/drum_follow")).put(TextureSlot.WEST, this.modLocation("block/drum_side")), this.modelOutput);
        this.blockModelGenerators.registerSimpleItemModel(drum, followModel);
        this.block(MultiVariantGenerator.multiVariant(drum).with(PropertyDispatch.property(DrumBlock.COMMAND_TYPE_PROPERTY).select("follow", Variant.variant().with(VariantProperties.MODEL, followModel)).select("stay", Variant.variant().with(VariantProperties.MODEL, ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(drum).withSuffix("_stay"), new TextureMapping().put(TextureSlot.DOWN, this.mcLocation("block/spruce_planks")).put(TextureSlot.EAST, this.modLocation("block/drum_side")).put(TextureSlot.NORTH, this.modLocation("block/drum_side")).put(TextureSlot.PARTICLE, this.modLocation("block/drum_side")).put(TextureSlot.SOUTH, this.modLocation("block/drum_side")).put(TextureSlot.UP, this.modLocation("block/drum_stay")).put(TextureSlot.WEST, this.modLocation("block/drum_side")), this.modelOutput))).select("free_move", Variant.variant().with(VariantProperties.MODEL, ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(drum).withSuffix("_free_move"), new TextureMapping().put(TextureSlot.DOWN, this.mcLocation("block/spruce_planks")).put(TextureSlot.EAST, this.modLocation("block/drum_side")).put(TextureSlot.NORTH, this.modLocation("block/drum_side")).put(TextureSlot.PARTICLE, this.modLocation("block/drum_side")).put(TextureSlot.SOUTH, this.modLocation("block/drum_side")).put(TextureSlot.UP, this.modLocation("block/drum_free_move")).put(TextureSlot.WEST, this.modLocation("block/drum_side")), this.modelOutput)))));
    }

    private void createFeeder(Block feeder) {
        ResourceLocation emptyModel = ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(feeder).withSuffix("_empty"), new TextureMapping().put(TextureSlot.DOWN, this.mcLocation("block/smooth_stone")).put(TextureSlot.EAST, this.modLocation("block/feeder_side")).put(TextureSlot.NORTH, this.modLocation("block/feeder_front")).put(TextureSlot.PARTICLE, this.modLocation("block/feeder_side")).put(TextureSlot.SOUTH, this.modLocation("block/feeder_side")).put(TextureSlot.UP, this.modLocation("block/feeder_top_empty")).put(TextureSlot.WEST, this.modLocation("block/feeder_side")), this.modelOutput);
        this.blockModelGenerators.registerSimpleItemModel(feeder, emptyModel);
        this.createActiveType(feeder, emptyModel, ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(feeder).withSuffix("_full"), new TextureMapping().put(TextureSlot.DOWN, this.mcLocation("block/smooth_stone")).put(TextureSlot.EAST, this.modLocation("block/feeder_side")).put(TextureSlot.NORTH, this.modLocation("block/feeder_front")).put(TextureSlot.PARTICLE, this.modLocation("block/feeder_side")).put(TextureSlot.SOUTH, this.modLocation("block/feeder_side")).put(TextureSlot.UP, this.modLocation("block/feeder_top_empty")).put(TextureSlot.WEST, this.modLocation("block/feeder_side")), this.modelOutput), FeederBlock.HAS_FOOD, true);
    }

    private void createAxolotlSpawn(Block axolotlSpawn) {
        this.blockModelGenerators.registerSimpleFlatItemModel(axolotlSpawn);
        this.block(BlockModelGenerators.createSimpleBlock(axolotlSpawn, FAModelTemplates.FROGSPAWN.create(axolotlSpawn, new TextureMapping().put(TextureSlot.TEXTURE, this.modLocation("block/axolotlspawn")).put(TextureSlot.PARTICLE, this.modLocation("block/axolotlspawn")), this.modelOutput)));
    }

    private void createTimeMachine(Block timeMachine) {
        this.block(BlockModelGenerators.createSimpleBlock(timeMachine, FAModelTemplates.TEMPLATE_TIME_MACHINE.create(timeMachine, new TextureMapping(), this.modelOutput)));
    }

    private void createCauldron(Block cauldron, ResourceLocation texture) {
        this.block(MultiVariantGenerator.multiVariant(cauldron).with(PropertyDispatch.property(SoupCauldronBlock.LEVEL).select(1, Variant.variant().with(VariantProperties.MODEL, this.createCauldronModel(cauldron, FAModelTemplates.TEMPLATE_SOUP_CAULDRON_1, 1, texture))).select(2, Variant.variant().with(VariantProperties.MODEL, this.createCauldronModel(cauldron, FAModelTemplates.TEMPLATE_SOUP_CAULDRON_2, 2, texture))).select(3, Variant.variant().with(VariantProperties.MODEL, this.createCauldronModel(cauldron, FAModelTemplates.TEMPLATE_SOUP_CAULDRON_3, 3, texture))).select(4, Variant.variant().with(VariantProperties.MODEL, this.createCauldronModel(cauldron, FAModelTemplates.TEMPLATE_SOUP_CAULDRON_4, 4, texture))).select(5, Variant.variant().with(VariantProperties.MODEL, this.createCauldronModel(cauldron, FAModelTemplates.TEMPLATE_SOUP_CAULDRON_5, 5, texture))).select(6, Variant.variant().with(VariantProperties.MODEL, this.createCauldronModel(cauldron, FAModelTemplates.TEMPLATE_SOUP_CAULDRON_6, 6, texture))).select(7, Variant.variant().with(VariantProperties.MODEL, this.createCauldronModel(cauldron, FAModelTemplates.TEMPLATE_SOUP_CAULDRON_7, 7, texture))).select(8, Variant.variant().with(VariantProperties.MODEL, this.createCauldronModel(cauldron, FAModelTemplates.TEMPLATE_SOUP_CAULDRON_8, 8, texture)))));
    }

    private ResourceLocation createCauldronModel(Block cauldron, ModelTemplate modelTemplate, int i, ResourceLocation texture) {
        return modelTemplate.create(ModelLocationUtils.getModelLocation(cauldron).withSuffix("_" + i), new TextureMapping().put(TextureSlot.CONTENT, texture), this.modelOutput);
    }

    private void createMayanVase(Block mayanVase, ResourceLocation texture) {
        this.block(MultiVariantGenerator.multiVariant(mayanVase, Variant.variant().with(VariantProperties.MODEL, FAModelTemplates.TEMPLATE_VASE.create(mayanVase, new TextureMapping().put(TextureSlot.SIDE, texture), this.modelOutput))));
    }

    private void createLlamaStatue(Block llama, ResourceLocation texture, ResourceLocation particle) {
        this.block(MultiVariantGenerator.multiVariant(llama, Variant.variant().with(VariantProperties.MODEL, FAModelTemplates.TEMPLATE_LLAMA.create(llama, new TextureMapping().put(TextureSlot.TEXTURE, texture).put(TextureSlot.PARTICLE, particle), this.modelOutput))).with(BlockModelGenerators.createHorizontalFacingDispatch()));
    }

    private void createDecorationPost(Block decorationPost, Block concrete) {
        this.block(MultiVariantGenerator.multiVariant(decorationPost, Variant.variant().with(VariantProperties.MODEL, FAModelTemplates.TEMPLATE_DECORATION_PLAQUE_POST.create(decorationPost, new TextureMapping().put(FATextureSlot.POST, TextureMapping.getBlockTexture(concrete)), this.modelOutput))));
    }

    public void createBranch(Block block, ResourceLocation leavesTexture, ResourceLocation logTexture, int tint) {
        ResourceLocation branch = FAModelTemplates.TEMPLATE_BRANCH.create(block, new TextureMapping().put(FATextureSlot.LEAVES, leavesTexture).put(FATextureSlot.LOG, logTexture), this.modelOutput);
        ResourceLocation bothBranch = FAModelTemplates.TEMPLATE_BRANCH_DUAL.create(ModelLocationUtils.getModelLocation(block, "_both"), new TextureMapping().put(FATextureSlot.LEAVES, leavesTexture).put(FATextureSlot.LOG, logTexture), this.modelOutput);
        ResourceLocation highBranch = FAModelTemplates.TEMPLATE_BRANCH_HIGH.create(ModelLocationUtils.getModelLocation(block, "_high"), new TextureMapping().put(FATextureSlot.LEAVES, leavesTexture).put(FATextureSlot.LOG, logTexture), this.modelOutput);
        ResourceLocation lowBranch = FAModelTemplates.TEMPLATE_BRANCH_LOW.create(ModelLocationUtils.getModelLocation(block, "_low"), new TextureMapping().put(FATextureSlot.LEAVES, leavesTexture).put(FATextureSlot.LOG, logTexture), this.modelOutput);
        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, branch), Variant.variant().with(VariantProperties.MODEL, bothBranch), Variant.variant().with(VariantProperties.MODEL, highBranch), Variant.variant().with(VariantProperties.MODEL, lowBranch)).with(BlockModelGenerators.createHorizontalFacingDispatch()));
        this.blockModelGenerators.registerSimpleTintedItemModel(block, branch, ItemModelUtils.constantTint(tint));
    }
}
