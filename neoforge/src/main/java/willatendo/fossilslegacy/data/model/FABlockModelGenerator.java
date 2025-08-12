package willatendo.fossilslegacy.data.model;

import net.minecraft.client.color.item.GrassColorSource;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.*;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import willatendo.fossilslegacy.data.FABlockFamilies;
import willatendo.fossilslegacy.data.FAModelTemplates;
import willatendo.fossilslegacy.data.FATextureSlot;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.blocks.*;
import willatendo.fossilslegacy.server.block.properties.FABlockStateProperties;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.data.model.SimpleBlockModelGenerator;

public class FABlockModelGenerator extends SimpleBlockModelGenerator {
    public FABlockModelGenerator(BlockModelGenerators blockModelGenerators) {
        super(blockModelGenerators, FAUtils.ID);
    }

    @Override
    public void run() {
        this.createBlockFamilies(FABlockFamilies.getAllFamilies());
        this.createTrivialCube(FABlocks.CENOZOIC_FOSSIL_ORE.get());
        this.createTrivialCube(FABlocks.MESOZOIC_FOSSIL_ORE.get());
        this.createTrivialCube(FABlocks.PALAEOZOIC_FOSSIL_ORE.get());
        this.createTrivialCube(FABlocks.DEEPSLATE_CENOZOIC_FOSSIL_ORE.get());
        this.createTrivialCube(FABlocks.DEEPSLATE_MESOZOIC_FOSSIL_ORE.get());
        this.createTrivialCube(FABlocks.DEEPSLATE_PALAEOZOIC_FOSSIL_ORE.get());
        this.createTrivialCube(FABlocks.AMBER_ORE.get());
        this.createTrivialCube(FABlocks.DEEPSLATE_AMBER_ORE.get());
        this.createTrivialCube(FABlocks.PLANT_FOSSIL_ORE.get());
        this.createTrivialCube(FABlocks.DEEPSLATE_PLANT_FOSSIL_ORE.get());
        this.createTrivialCube(FABlocks.RELIC_IN_STONE.get());
        this.createTrivialCube(FABlocks.RELIC_IN_DEEPSLATE.get());
        this.createFrozenLeech(FABlocks.FROZEN_LEECH.get());
        this.createTrivialCube(FABlocks.LEECH_IN_ICE.get());
        this.createSkull(FABlocks.SKULL_BLOCK.get(), this.modLocation("block/skull_front"));
        this.createSkull(FABlocks.SKULL_LANTERN_BLOCK.get(), this.modLocation("block/skull_lantern_front"));
        this.createAnalyzer(FABlocks.DNA_ANALYZER.get());
        this.createDNACoder(FABlocks.DNA_CODER.get());
        this.createDNAHybridizer(FABlocks.DNA_HYBRIDIZER.get());
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
        this.createShatteredCultivator(FABlocks.WHITE_SHATTERED_CULTIVATOR.get(), "white");
        this.createShatteredCultivator(FABlocks.ORANGE_SHATTERED_CULTIVATOR.get(), "orange");
        this.createShatteredCultivator(FABlocks.MAGENTA_SHATTERED_CULTIVATOR.get(), "magenta");
        this.createShatteredCultivator(FABlocks.LIGHT_BLUE_SHATTERED_CULTIVATOR.get(), "light_blue");
        this.createShatteredCultivator(FABlocks.YELLOW_SHATTERED_CULTIVATOR.get(), "yellow");
        this.createShatteredCultivator(FABlocks.LIME_SHATTERED_CULTIVATOR.get(), "lime");
        this.createShatteredCultivator(FABlocks.PINK_SHATTERED_CULTIVATOR.get(), "pink");
        this.createShatteredCultivator(FABlocks.GRAY_SHATTERED_CULTIVATOR.get(), "gray");
        this.createShatteredCultivator(FABlocks.LIGHT_GRAY_SHATTERED_CULTIVATOR.get(), "light_gray");
        this.createShatteredCultivator(FABlocks.CYAN_SHATTERED_CULTIVATOR.get(), "cyan");
        this.createShatteredCultivator(FABlocks.PURPLE_SHATTERED_CULTIVATOR.get(), "purple");
        this.createShatteredCultivator(FABlocks.BLUE_SHATTERED_CULTIVATOR.get(), "blue");
        this.createShatteredCultivator(FABlocks.BROWN_SHATTERED_CULTIVATOR.get(), "brown");
        this.createShatteredCultivator(FABlocks.GREEN_SHATTERED_CULTIVATOR.get(), "green");
        this.createShatteredCultivator(FABlocks.RED_SHATTERED_CULTIVATOR.get(), "red");
        this.createShatteredCultivator(FABlocks.BLACK_SHATTERED_CULTIVATOR.get(), "black");
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
        this.createSmallCage(FABlocks.SMALL_CAGE.get());
        this.createMediumCage(FABlocks.MEDIUM_CAGE.get());
        this.createStraightTrack(FABlocks.STRAIGHT_TRACK.get());
        this.createCornerTrack(FABlocks.CORNER_TRACK.get());
        this.createRampTrack(FABlocks.RAMP_TRACK.get());
        this.createCycadHead(FABlocks.CYCAD_HEAD.get());
        this.createCycadLog(FABlocks.CYCAD_LOG.get());
        this.createCooksonia(FABlocks.COOKSONIA.get());
        this.createClaytosmunda(FABlocks.CLAYTOSMUNDA.get());
        this.createCycadeoidea(FABlocks.CYCADEOIDEA.get());
        this.createTrivialCube(FABlocks.NIPA.get());
        this.createTrivialCube(FABlocks.ONYCHIOPSIS.get());
        this.createTrivialCube(FABlocks.PACHYPTERIS.get());
        this.createTrivialCube(FABlocks.PACHYPODIUM.get());
        this.createTrivialCube(FABlocks.WILLIAMSONIA.get());
        this.createMacrotaeniopteris(FABlocks.MACROTAENIOPTERIS.get());
        this.createDipteris(FABlocks.DIPTERIS.get());
        this.createZamitesHead(FABlocks.ZAMITES_HEAD.get());
        this.blockModelGenerators.woodProvider(FABlocks.ARAUCARIA_LOG.get()).logWithHorizontal(FABlocks.ARAUCARIA_LOG.get()).wood(FABlocks.ARAUCARIA_WOOD.get());
        this.blockModelGenerators.woodProvider(FABlocks.STRIPPED_ARAUCARIA_LOG.get()).logWithHorizontal(FABlocks.STRIPPED_ARAUCARIA_LOG.get()).wood(FABlocks.STRIPPED_ARAUCARIA_WOOD.get());
        this.blockModelGenerators.createHangingSign(FABlocks.STRIPPED_ARAUCARIA_LOG.get(), FABlocks.ARAUCARIA_HANGING_SIGN.get(), FABlocks.ARAUCARIA_WALL_HANGING_SIGN.get());
        this.createPlantWithDefaultItem(FABlocks.ARAUCARIA_SAPLING.get(), FABlocks.POTTED_ARAUCARIA_SAPLING.get(), SimpleBlockModelGenerator.PlantType.NOT_TINTED);
        this.blockModelGenerators.createTintedLeaves(FABlocks.ARAUCARIA_LEAVES.get(), TexturedModel.LEAVES, -10380959);
        this.blockModelGenerators.woodProvider(FABlocks.ARCHAEOPTERIS_LOG.get()).logWithHorizontal(FABlocks.ARCHAEOPTERIS_LOG.get()).wood(FABlocks.ARCHAEOPTERIS_WOOD.get());
        this.blockModelGenerators.woodProvider(FABlocks.STRIPPED_ARCHAEOPTERIS_LOG.get()).logWithHorizontal(FABlocks.STRIPPED_ARCHAEOPTERIS_LOG.get()).wood(FABlocks.STRIPPED_ARCHAEOPTERIS_WOOD.get());
        this.blockModelGenerators.createHangingSign(FABlocks.STRIPPED_ARCHAEOPTERIS_LOG.get(), FABlocks.ARCHAEOPTERIS_HANGING_SIGN.get(), FABlocks.ARCHAEOPTERIS_WALL_HANGING_SIGN.get());
        this.createPlantWithDefaultItem(FABlocks.ARCHAEOPTERIS_SAPLING.get(), FABlocks.POTTED_ARCHAEOPTERIS_SAPLING.get(), SimpleBlockModelGenerator.PlantType.NOT_TINTED);
        this.blockModelGenerators.createTintedLeaves(FABlocks.ARCHAEOPTERIS_LEAVES.get(), TexturedModel.LEAVES, -12012264);
        this.blockModelGenerators.woodProvider(FABlocks.CALAMITES_LOG.get()).logWithHorizontal(FABlocks.CALAMITES_LOG.get()).wood(FABlocks.CALAMITES_WOOD.get());
        this.blockModelGenerators.woodProvider(FABlocks.STRIPPED_CALAMITES_LOG.get()).logWithHorizontal(FABlocks.STRIPPED_CALAMITES_LOG.get()).wood(FABlocks.STRIPPED_CALAMITES_WOOD.get());
        this.blockModelGenerators.createHangingSign(FABlocks.STRIPPED_CALAMITES_LOG.get(), FABlocks.CALAMITES_HANGING_SIGN.get(), FABlocks.CALAMITES_WALL_HANGING_SIGN.get());
        this.createPlantWithDefaultItem(FABlocks.CALAMITES_SAPLING.get(), FABlocks.POTTED_CALAMITES_SAPLING.get(), SimpleBlockModelGenerator.PlantType.NOT_TINTED);
        this.blockModelGenerators.createTintedLeaves(FABlocks.CALAMITES_LEAVES.get(), TexturedModel.LEAVES, -12012264);
        this.blockModelGenerators.woodProvider(FABlocks.GINKGO_LOG.get()).logWithHorizontal(FABlocks.GINKGO_LOG.get()).wood(FABlocks.GINKGO_WOOD.get());
        this.blockModelGenerators.woodProvider(FABlocks.STRIPPED_GINKGO_LOG.get()).logWithHorizontal(FABlocks.STRIPPED_GINKGO_LOG.get()).wood(FABlocks.STRIPPED_GINKGO_WOOD.get());
        this.blockModelGenerators.createHangingSign(FABlocks.STRIPPED_GINKGO_LOG.get(), FABlocks.GINKGO_HANGING_SIGN.get(), FABlocks.GINKGO_WALL_HANGING_SIGN.get());
        this.createPlantWithDefaultItem(FABlocks.GINKGO_SAPLING.get(), FABlocks.POTTED_GINKGO_SAPLING.get(), SimpleBlockModelGenerator.PlantType.NOT_TINTED);
        this.blockModelGenerators.createTintedLeaves(FABlocks.GINKGO_LEAVES.get(), TexturedModel.LEAVES, 0xD8C12E);
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
        this.blockModelGenerators.woodProvider(FABlocks.ARAUCARIOXYLON_LOG.get()).logWithHorizontal(FABlocks.ARAUCARIOXYLON_LOG.get()).wood(FABlocks.ARAUCARIOXYLON_WOOD.get());
        this.blockModelGenerators.woodProvider(FABlocks.STRIPPED_ARAUCARIOXYLON_LOG.get()).logWithHorizontal(FABlocks.STRIPPED_ARAUCARIOXYLON_LOG.get()).wood(FABlocks.STRIPPED_ARAUCARIOXYLON_WOOD.get());
        this.blockModelGenerators.createHangingSign(FABlocks.STRIPPED_ARAUCARIOXYLON_LOG.get(), FABlocks.ARAUCARIOXYLON_HANGING_SIGN.get(), FABlocks.ARAUCARIOXYLON_WALL_HANGING_SIGN.get());
        this.createPlantWithDefaultItem(FABlocks.ARAUCARIOXYLON_SAPLING.get(), FABlocks.POTTED_ARAUCARIOXYLON_SAPLING.get(), SimpleBlockModelGenerator.PlantType.NOT_TINTED);
        this.blockModelGenerators.createTintedLeaves(FABlocks.ARAUCARIOXYLON_LEAVES.get(), TexturedModel.LEAVES, -12012264);
        this.blockModelGenerators.woodProvider(FABlocks.CORDAITES_LOG.get()).logWithHorizontal(FABlocks.CORDAITES_LOG.get()).wood(FABlocks.CORDAITES_WOOD.get());
        this.blockModelGenerators.woodProvider(FABlocks.STRIPPED_CORDAITES_LOG.get()).logWithHorizontal(FABlocks.STRIPPED_CORDAITES_LOG.get()).wood(FABlocks.STRIPPED_CORDAITES_WOOD.get());
        this.blockModelGenerators.createHangingSign(FABlocks.STRIPPED_CORDAITES_LOG.get(), FABlocks.CORDAITES_HANGING_SIGN.get(), FABlocks.CORDAITES_WALL_HANGING_SIGN.get());
        this.createPlantWithDefaultItem(FABlocks.CORDAITES_SAPLING.get(), FABlocks.POTTED_CORDAITES_SAPLING.get(), SimpleBlockModelGenerator.PlantType.NOT_TINTED);
        this.blockModelGenerators.createTintedLeaves(FABlocks.CORDAITES_LEAVES.get(), TexturedModel.LEAVES, -12012264);
        this.blockModelGenerators.woodProvider(FABlocks.WOLLEMIA_LOG.get()).logWithHorizontal(FABlocks.WOLLEMIA_LOG.get()).wood(FABlocks.WOLLEMIA_WOOD.get());
        this.blockModelGenerators.woodProvider(FABlocks.STRIPPED_WOLLEMIA_LOG.get()).logWithHorizontal(FABlocks.STRIPPED_WOLLEMIA_LOG.get()).wood(FABlocks.STRIPPED_WOLLEMIA_WOOD.get());
        this.blockModelGenerators.createHangingSign(FABlocks.STRIPPED_WOLLEMIA_LOG.get(), FABlocks.WOLLEMIA_HANGING_SIGN.get(), FABlocks.WOLLEMIA_WALL_HANGING_SIGN.get());
        this.createPlantWithDefaultItem(FABlocks.WOLLEMIA_SAPLING.get(), FABlocks.POTTED_WOLLEMIA_SAPLING.get(), SimpleBlockModelGenerator.PlantType.NOT_TINTED);
        this.blockModelGenerators.createTintedLeaves(FABlocks.WOLLEMIA_LEAVES.get(), TexturedModel.LEAVES, -10380959);
        this.block(MultiVariantGenerator.multiVariant(FABlocks.TAR.get(), Variant.variant().with(VariantProperties.MODEL, FAModelTemplates.TEMPLATE_LIQUID.create(FABlocks.TAR.get(), new TextureMapping().put(TextureSlot.PARTICLE, this.mcLocation("block/bedrock")), this.modelOutput))));
    }

    private ResourceLocation basic(Block block, ModelTemplate modelTemplate, TextureMapping textureMapping) {
        ResourceLocation model = modelTemplate.create(block, textureMapping, this.modelOutput);
        this.block(BlockModelGenerators.createSimpleBlock(block, model));
        return model;
    }

    private void createBasic(Block block) {
        this.block(BlockModelGenerators.createSimpleBlock(block, ModelTemplates.CUBE_ALL.create(block, TextureMapping.cube(block), this.modelOutput)));
    }

    private void createFrozenLeech(Block leechInIce) {
        this.block(MultiVariantGenerator.multiVariant(leechInIce, Variant.variant().with(VariantProperties.MODEL, FAModelTemplates.TEMPLATE_FROZEN_LEECH.create(leechInIce, new TextureMapping().put(TextureSlot.TEXTURE, this.mcLocation("block/packed_ice")), this.modelOutput))).with(BlockModelGenerators.createHorizontalFacingDispatch()));
    }

    private void createSkull(Block skull, ResourceLocation frontTexture) {
        this.block(MultiVariantGenerator.multiVariant(skull, Variant.variant().with(VariantProperties.MODEL, ModelTemplates.CUBE.create(skull, new TextureMapping().put(TextureSlot.DOWN, this.modLocation("block/skull")).put(TextureSlot.EAST, this.modLocation("block/skull_crack")).put(TextureSlot.NORTH, frontTexture).put(TextureSlot.PARTICLE, this.modLocation("block/skull_crack")).put(TextureSlot.SOUTH, this.modLocation("block/skull_crack")).put(TextureSlot.UP, this.modLocation("block/skull")).put(TextureSlot.WEST, this.modLocation("block/skull_crack")), this.modelOutput))).with(BlockModelGenerators.createHorizontalFacingDispatch()));
    }

    private void createAnalyzer(Block analyzer) {
        ResourceLocation inactive = ModelTemplates.CUBE.create(analyzer, new TextureMapping().put(TextureSlot.DOWN, this.modLocation("block/analyzer_top")).put(TextureSlot.EAST, this.modLocation("block/analyzer_side")).put(TextureSlot.NORTH, this.modLocation("block/analyzer_front_off")).put(TextureSlot.PARTICLE, this.modLocation("block/analyzer_side")).put(TextureSlot.SOUTH, this.modLocation("block/analyzer_back")).put(TextureSlot.UP, this.modLocation("block/analyzer_top")).put(TextureSlot.WEST, this.modLocation("block/analyzer_side")), this.modelOutput);
        ResourceLocation active = ModelTemplates.CUBE.createWithSuffix(analyzer, "_active", new TextureMapping().put(TextureSlot.DOWN, this.modLocation("block/analyzer_top")).put(TextureSlot.EAST, this.modLocation("block/analyzer_side")).put(TextureSlot.NORTH, this.modLocation("block/analyzer_front_on")).put(TextureSlot.PARTICLE, this.modLocation("block/analyzer_side")).put(TextureSlot.SOUTH, this.modLocation("block/analyzer_back")).put(TextureSlot.UP, this.modLocation("block/analyzer_top")).put(TextureSlot.WEST, this.modLocation("block/analyzer_side")), this.modelOutput);
        this.createActiveType(analyzer, inactive, active, FABlockStateProperties.ACTIVE, true);
    }

    private void createDNACoder(Block dnaCoder) {
        ResourceLocation inactive = ModelTemplates.CUBE.create(dnaCoder, new TextureMapping().put(TextureSlot.DOWN, this.modLocation("block/dna_coder_top")).put(TextureSlot.EAST, this.modLocation("block/dna_coder_side")).put(TextureSlot.NORTH, this.modLocation("block/dna_coder_front_off")).put(TextureSlot.PARTICLE, this.modLocation("block/dna_coder_side")).put(TextureSlot.SOUTH, this.modLocation("block/dna_coder_back")).put(TextureSlot.UP, this.modLocation("block/dna_coder_top")).put(TextureSlot.WEST, this.modLocation("block/dna_coder_side")), this.modelOutput);
        ResourceLocation active = ModelTemplates.CUBE.createWithSuffix(dnaCoder, "_active", new TextureMapping().put(TextureSlot.DOWN, this.modLocation("block/dna_coder_top")).put(TextureSlot.EAST, this.modLocation("block/dna_coder_side")).put(TextureSlot.NORTH, this.modLocation("block/dna_coder_front_on")).put(TextureSlot.PARTICLE, this.modLocation("block/dna_coder_side")).put(TextureSlot.SOUTH, this.modLocation("block/dna_coder_back")).put(TextureSlot.UP, this.modLocation("block/dna_coder_top")).put(TextureSlot.WEST, this.modLocation("block/dna_coder_side")), this.modelOutput);
        this.createActiveType(dnaCoder, inactive, active, FABlockStateProperties.ACTIVE, true);
    }

    private void createDNAHybridizer(Block dnaHybridizer) {
        ResourceLocation inactive = FAModelTemplates.TEMPLATE_DNA_HYBRIDIZER.create(dnaHybridizer, new TextureMapping().put(TextureSlot.FRONT, this.modLocation("block/dna_hybridizer_front_off")), this.modelOutput);
        ResourceLocation active = FAModelTemplates.TEMPLATE_DNA_HYBRIDIZER.createWithSuffix(dnaHybridizer, "_active", new TextureMapping().put(TextureSlot.FRONT, this.modLocation("block/dna_hybridizer_front_on")), this.modelOutput);
        this.createActiveType(dnaHybridizer, inactive, active, DNAHybridizerBlock.ACTIVE, true);
    }

    private void createCultivator(Block cultivator, String color) {
        this.createActiveType(cultivator, FAModelTemplates.TEMPLATE_CULTIVATOR.create(cultivator, new TextureMapping().put(TextureSlot.SIDE, this.modLocation("block/" + color + "_cultivator_side")).put(TextureSlot.TOP, this.modLocation("block/" + color + "_cultivator_top")), this.modelOutput), FAModelTemplates.TEMPLATE_CULTIVATOR_ACTIVE.create(ModelLocationUtils.getModelLocation(cultivator).withSuffix("_active"), new TextureMapping().put(TextureSlot.SIDE, this.modLocation("block/" + color + "_cultivator_side")).put(TextureSlot.TOP, this.modLocation("block/" + color + "_cultivator_top")), this.modelOutput), FABlockStateProperties.ACTIVE, false);
    }

    private void createShatteredCultivator(Block cultivator, String color) {
        ResourceLocation model = FAModelTemplates.TEMPLATE_SHATTERED_CULTIVATOR.create(cultivator, new TextureMapping().put(TextureSlot.SIDE, this.modLocation("block/" + color + "_shattered_cultivator_side")), this.modelOutput);
        this.block(MultiVariantGenerator.multiVariant(cultivator, Variant.variant().with(VariantProperties.MODEL, model)));
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
        this.blockModelGenerators.registerSimpleTintedItemModel(horsetail, ModelTemplates.FLAT_ITEM.create(horsetail, new TextureMapping().put(TextureSlot.LAYER0, plant2Texture), this.modelOutput), new GrassColorSource());
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
        this.blockModelGenerators.registerSimpleTintedItemModel(tallHorsetail, ModelTemplates.FLAT_ITEM.create(tallHorsetail, new TextureMapping().put(TextureSlot.LAYER0, plant3Texture), this.modelOutput), new GrassColorSource());
        ResourceLocation plant1Model = FAModelTemplates.TEMPLATE_PLANT_1.create(ModelLocationUtils.getModelLocation(tallHorsetail).withSuffix("_1"), new TextureMapping().put(FATextureSlot.PLANT_1, plant1Texture), this.modelOutput);
        ResourceLocation plant2Model = FAModelTemplates.TEMPLATE_PLANT_2.create(ModelLocationUtils.getModelLocation(tallHorsetail).withSuffix("_2"), new TextureMapping().put(FATextureSlot.PLANT_2, plant2Texture), this.modelOutput);
        ResourceLocation plant3Model = FAModelTemplates.TEMPLATE_PLANT_3.create(ModelLocationUtils.getModelLocation(tallHorsetail).withSuffix("_3"), new TextureMapping().put(FATextureSlot.PLANT_3, plant3Texture), this.modelOutput);
        ResourceLocation stem1Model = FAModelTemplates.TEMPLATE_PLANT_1.create(ModelLocationUtils.getModelLocation(tallHorsetail).withSuffix("_stem_1"), new TextureMapping().put(FATextureSlot.PLANT_1, stemTexture), this.modelOutput);
        ResourceLocation stem2Model = FAModelTemplates.TEMPLATE_PLANT_2.create(ModelLocationUtils.getModelLocation(tallHorsetail).withSuffix("_stem_2"), new TextureMapping().put(FATextureSlot.PLANT_2, stemTexture), this.modelOutput);
        ResourceLocation stem3Model = FAModelTemplates.TEMPLATE_PLANT_3.create(ModelLocationUtils.getModelLocation(tallHorsetail).withSuffix("_stem_3"), new TextureMapping().put(FATextureSlot.PLANT_3, stemTexture), this.modelOutput);
        this.block(MultiPartGenerator.multiPart(tallHorsetail).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem1Model)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem1Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem1Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem1Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem2Model)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem2Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem2Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem2Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem3Model)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem3Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem3Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Variant.variant().with(VariantProperties.MODEL, stem3Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant1Model)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant1Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant1Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 1, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant1Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant2Model)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant2Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant2Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 2, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant2Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant3Model)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant3Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant3Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(HorsetailBlock.AMOUNT, 3).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).term(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Variant.variant().with(VariantProperties.MODEL, plant3Model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)));
    }

    private void createSmallCage(Block smallCage) {
        ResourceLocation closed = FAModelTemplates.TEMPLATE_SMALL_CAGE.create(smallCage, new TextureMapping(), this.modelOutput);
        ResourceLocation open = FAModelTemplates.TEMPLATE_SMALL_CAGE_OPEN.createWithSuffix(smallCage, "_open", new TextureMapping(), this.modelOutput);
        this.block(MultiVariantGenerator.multiVariant(smallCage, Variant.variant()).with(PropertyDispatch.property(SmallCageBlock.OPEN).select(true, Variant.variant().with(VariantProperties.MODEL, open)).select(false, Variant.variant().with(VariantProperties.MODEL, closed))).with(BlockModelGenerators.createHorizontalFacingDispatch()));
    }

    private void createMediumCage(Block mediumCage) {
        ResourceLocation bottom = FAModelTemplates.TEMPLATE_MEDIUM_CAGE_BOTTOM.createWithSuffix(mediumCage, "_bottom", new TextureMapping(), this.modelOutput);
        ResourceLocation top = FAModelTemplates.TEMPLATE_MEDIUM_CAGE_TOP.createWithSuffix(mediumCage, "_top", new TextureMapping(), this.modelOutput);
        ResourceLocation bottomOpenLeft = FAModelTemplates.TEMPLATE_MEDIUM_CAGE_BOTTOM_OPEN_LEFT.createWithSuffix(mediumCage, "_bottom_open_left", new TextureMapping(), this.modelOutput);
        ResourceLocation bottomOpenRight = FAModelTemplates.TEMPLATE_MEDIUM_CAGE_BOTTOM_OPEN_RIGHT.createWithSuffix(mediumCage, "_bottom_open_right", new TextureMapping(), this.modelOutput);
        ResourceLocation topOpenLeft = FAModelTemplates.TEMPLATE_MEDIUM_CAGE_TOP_OPEN_LEFT.createWithSuffix(mediumCage, "_top_open_left", new TextureMapping(), this.modelOutput);
        ResourceLocation topOpenRight = FAModelTemplates.TEMPLATE_MEDIUM_CAGE_TOP_OPEN_RIGHT.createWithSuffix(mediumCage, "_top_open_right", new TextureMapping(), this.modelOutput);
        this.block(MultiVariantGenerator.multiVariant(mediumCage, Variant.variant()).with(PropertyDispatch.properties(MediumCageBlock.HORIZONTAL_FACING, MediumCageBlock.OPEN, MediumCageBlock.PART, MediumCageBlock.HALF).select(Direction.NORTH, false, 1, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.MODEL, bottom)).select(Direction.NORTH, false, 2, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottom)).select(Direction.NORTH, false, 3, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottom)).select(Direction.NORTH, false, 4, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottom)).select(Direction.NORTH, false, 1, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.MODEL, top)).select(Direction.NORTH, false, 2, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, top)).select(Direction.NORTH, false, 3, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, top)).select(Direction.NORTH, false, 4, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, top)).select(Direction.EAST, false, 1, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.MODEL, bottom)).select(Direction.EAST, false, 2, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottom)).select(Direction.EAST, false, 3, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottom)).select(Direction.EAST, false, 4, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottom)).select(Direction.EAST, false, 1, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.MODEL, top)).select(Direction.EAST, false, 2, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, top)).select(Direction.EAST, false, 3, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, top)).select(Direction.EAST, false, 4, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, top)).select(Direction.SOUTH, false, 1, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.MODEL, bottom)).select(Direction.SOUTH, false, 2, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottom)).select(Direction.SOUTH, false, 3, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottom)).select(Direction.SOUTH, false, 4, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottom)).select(Direction.SOUTH, false, 1, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.MODEL, top)).select(Direction.SOUTH, false, 2, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, top)).select(Direction.SOUTH, false, 3, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, top)).select(Direction.SOUTH, false, 4, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, top)).select(Direction.WEST, false, 1, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.MODEL, bottom)).select(Direction.WEST, false, 2, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottom)).select(Direction.WEST, false, 3, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottom)).select(Direction.WEST, false, 4, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottom)).select(Direction.WEST, false, 1, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.MODEL, top)).select(Direction.WEST, false, 2, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, top)).select(Direction.WEST, false, 3, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, top)).select(Direction.WEST, false, 4, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, top)).select(Direction.NORTH, true, 1, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.MODEL, bottomOpenLeft)).select(Direction.NORTH, true, 2, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.MODEL, bottomOpenRight)).select(Direction.NORTH, true, 3, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottom)).select(Direction.NORTH, true, 4, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottom)).select(Direction.NORTH, true, 1, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.MODEL, topOpenLeft)).select(Direction.NORTH, true, 2, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.MODEL, topOpenRight)).select(Direction.NORTH, true, 3, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, top)).select(Direction.NORTH, true, 4, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, top)).select(Direction.EAST, true, 1, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.MODEL, bottom)).select(Direction.EAST, true, 2, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottomOpenLeft)).select(Direction.EAST, true, 3, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottom)).select(Direction.EAST, true, 4, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottomOpenRight)).select(Direction.EAST, true, 1, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.MODEL, top)).select(Direction.EAST, true, 2, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, topOpenLeft)).select(Direction.EAST, true, 3, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, top)).select(Direction.EAST, true, 4, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, topOpenRight)).select(Direction.SOUTH, true, 1, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.MODEL, bottom)).select(Direction.SOUTH, true, 2, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottom)).select(Direction.SOUTH, true, 3, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottomOpenRight)).select(Direction.SOUTH, true, 4, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottomOpenLeft)).select(Direction.SOUTH, true, 1, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.MODEL, top)).select(Direction.SOUTH, true, 2, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, top)).select(Direction.SOUTH, true, 3, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, topOpenRight)).select(Direction.SOUTH, true, 4, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, topOpenLeft)).select(Direction.WEST, true, 1, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottomOpenRight)).select(Direction.WEST, true, 2, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottom)).select(Direction.WEST, true, 3, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottomOpenLeft)).select(Direction.WEST, true, 4, DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, bottom)).select(Direction.WEST, true, 1, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, topOpenRight)).select(Direction.WEST, true, 2, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, top)).select(Direction.WEST, true, 3, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, topOpenLeft)).select(Direction.WEST, true, 4, DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true).with(VariantProperties.MODEL, top))));
        this.registerSimpleItemModel(mediumCage, FAUtils.resource("item/medium_cage"));
    }

    private void createStraightTrack(Block straightTrack) {
        this.block(MultiVariantGenerator.multiVariant(straightTrack, Variant.variant().with(VariantProperties.MODEL, ModelTemplates.RAIL_FLAT.extend().renderType("cutout").build().create(straightTrack, new TextureMapping().put(TextureSlot.RAIL, this.modLocation("block/straight_track")), this.modelOutput))).with(BlockModelGenerators.createHorizontalFacingDispatch()));
        this.blockModelGenerators.registerSimpleFlatItemModel(straightTrack);
    }

    private void createCornerTrack(Block cornerTrack) {
        ResourceLocation part1 = ModelTemplates.RAIL_FLAT.extend().renderType("cutout").build().createWithSuffix(cornerTrack, "_part_1", new TextureMapping().put(TextureSlot.RAIL, this.modLocation("block/corner_track_1")), this.modelOutput);
        ResourceLocation part2 = ModelTemplates.RAIL_FLAT.extend().renderType("cutout").build().createWithSuffix(cornerTrack, "_part_2", new TextureMapping().put(TextureSlot.RAIL, this.modLocation("block/corner_track_2")), this.modelOutput);
        ResourceLocation part3 = ModelTemplates.RAIL_FLAT.extend().renderType("cutout").build().createWithSuffix(cornerTrack, "_part_3", new TextureMapping().put(TextureSlot.RAIL, this.modLocation("block/corner_track_3")), this.modelOutput);
        ResourceLocation part4 = ModelTemplates.RAIL_FLAT.extend().renderType("cutout").build().createWithSuffix(cornerTrack, "_part_4", new TextureMapping().put(TextureSlot.RAIL, this.modLocation("block/corner_track_4")), this.modelOutput);
        ResourceLocation part5 = ModelTemplates.RAIL_FLAT.extend().renderType("cutout").build().createWithSuffix(cornerTrack, "_part_5", new TextureMapping().put(TextureSlot.RAIL, this.modLocation("block/corner_track_5")), this.modelOutput);
        ResourceLocation part6 = ModelTemplates.RAIL_FLAT.extend().renderType("cutout").build().createWithSuffix(cornerTrack, "_part_6", new TextureMapping().put(TextureSlot.RAIL, this.modLocation("block/corner_track_6")), this.modelOutput);
        ResourceLocation part7 = ModelTemplates.RAIL_FLAT.extend().renderType("cutout").build().createWithSuffix(cornerTrack, "_part_7", new TextureMapping().put(TextureSlot.RAIL, this.modLocation("block/corner_track_7")), this.modelOutput);
        ResourceLocation part8 = ModelTemplates.RAIL_FLAT.extend().renderType("cutout").build().createWithSuffix(cornerTrack, "_part_8", new TextureMapping().put(TextureSlot.RAIL, this.modLocation("block/corner_track_8")), this.modelOutput);
        ResourceLocation part9 = ModelTemplates.RAIL_FLAT.extend().renderType("cutout").build().createWithSuffix(cornerTrack, "_part_9", new TextureMapping().put(TextureSlot.RAIL, this.modLocation("block/corner_track_9")), this.modelOutput);
        this.block(MultiVariantGenerator.multiVariant(cornerTrack, Variant.variant()).with(PropertyDispatch.property(CornerTrackBlock.PART).select(1, Variant.variant().with(VariantProperties.MODEL, part1)).select(2, Variant.variant().with(VariantProperties.MODEL, part2)).select(3, Variant.variant().with(VariantProperties.MODEL, part3)).select(4, Variant.variant().with(VariantProperties.MODEL, part4)).select(5, Variant.variant().with(VariantProperties.MODEL, part5)).select(6, Variant.variant().with(VariantProperties.MODEL, part6)).select(7, Variant.variant().with(VariantProperties.MODEL, part7)).select(8, Variant.variant().with(VariantProperties.MODEL, part8)).select(9, Variant.variant().with(VariantProperties.MODEL, part9))).with(BlockModelGenerators.createHorizontalFacingDispatch()));
        this.blockModelGenerators.registerSimpleItemModel(cornerTrack, ModelTemplates.FLAT_ITEM.create(cornerTrack, new TextureMapping().put(TextureSlot.LAYER0, this.modLocation("block/corner_track")), this.modelOutput));
    }

    private void createRampTrack(Block rampTrack) {
        ResourceLocation part1 = FAModelTemplates.TEMPLATE_RAIL_RAMP_1.createWithSuffix(rampTrack, "_1", new TextureMapping().put(TextureSlot.RAIL, this.modLocation("block/straight_track")), this.modelOutput);
        ResourceLocation part2 = FAModelTemplates.TEMPLATE_RAIL_RAMP_2.createWithSuffix(rampTrack, "_2", new TextureMapping().put(TextureSlot.RAIL, this.modLocation("block/straight_track")), this.modelOutput);
        ResourceLocation part3 = FAModelTemplates.TEMPLATE_RAIL_RAMP_3.createWithSuffix(rampTrack, "_3", new TextureMapping().put(TextureSlot.RAIL, this.modLocation("block/straight_track")), this.modelOutput);
        ResourceLocation part4 = FAModelTemplates.TEMPLATE_RAIL_RAMP_4.createWithSuffix(rampTrack, "_4", new TextureMapping().put(TextureSlot.RAIL, this.modLocation("block/straight_track")), this.modelOutput);
        this.block(MultiVariantGenerator.multiVariant(rampTrack, Variant.variant()).with(PropertyDispatch.property(RampTrackBlock.PART).select(1, Variant.variant().with(VariantProperties.MODEL, part1)).select(2, Variant.variant().with(VariantProperties.MODEL, part2)).select(3, Variant.variant().with(VariantProperties.MODEL, part3)).select(4, Variant.variant().with(VariantProperties.MODEL, part4))).with(BlockModelGenerators.createHorizontalFacingDispatch()));
        this.blockModelGenerators.registerSimpleItemModel(rampTrack, ModelTemplates.FLAT_ITEM.create(rampTrack, new TextureMapping().put(TextureSlot.LAYER0, this.modLocation("block/straight_track")), this.modelOutput));
    }

    private void createCycadHead(Block cycadHead) {
        ResourceLocation headCone = FAModelTemplates.TEMPLATE_CYCAD_HEAD_CONE.createWithSuffix(cycadHead, "_cone", new TextureMapping().put(TextureSlot.SIDE, this.modLocation("block/cycad_log")).put(TextureSlot.TOP, this.modLocation("block/cycad_log_top_1")).put(FATextureSlot.HEAD, this.modLocation("block/cycad_head")).put(FATextureSlot.LEAVES, this.modLocation("block/cycad_leaves")), this.modelOutput);
        ResourceLocation headNoCone = FAModelTemplates.TEMPLATE_CYCAD_HEAD_NO_CONE.createWithSuffix(cycadHead, "_no_cone", new TextureMapping().put(TextureSlot.SIDE, this.modLocation("block/cycad_log")).put(TextureSlot.TOP, this.modLocation("block/cycad_log_top_1")).put(FATextureSlot.LEAVES, this.modLocation("block/cycad_leaves")), this.modelOutput);
        this.block(MultiVariantGenerator.multiVariant(cycadHead, Variant.variant()).with(BlockModelGenerators.createBooleanModelDispatch(CycadHeadBlock.HAS_CONE, headCone, headNoCone)));
        this.blockModelGenerators.registerSimpleTintedItemModel(cycadHead, headCone, new GrassColorSource());
    }

    private void createZamitesHead(Block zamitesHead) {
        ResourceLocation model = this.basic(zamitesHead, FAModelTemplates.TEMPLATE_ZAMITES_HEAD, new TextureMapping().put(TextureSlot.SIDE, this.modLocation("block/cycad_log")).put(TextureSlot.TOP, this.modLocation("block/cycad_log_top_1")).put(FATextureSlot.HEAD, this.modLocation("block/cycad_head")).put(FATextureSlot.LEAVES, this.modLocation("block/cycad_leaves")));
        this.blockModelGenerators.registerSimpleTintedItemModel(zamitesHead, model, new GrassColorSource());
    }

    private void createCycadLog(Block cycadLog) {
        ResourceLocation model1 = FAModelTemplates.TEMPLATE_CYCAD_LOG_1.createWithSuffix(cycadLog, "_1", new TextureMapping().put(TextureSlot.SIDE, this.modLocation("block/cycad_log")).put(TextureSlot.TOP, this.modLocation("block/cycad_log_top_1")), this.modelOutput);
        ResourceLocation model2 = FAModelTemplates.TEMPLATE_CYCAD_LOG_2.createWithSuffix(cycadLog, "_2", new TextureMapping().put(TextureSlot.SIDE, this.modLocation("block/cycad_log")).put(TextureSlot.TOP, this.modLocation("block/cycad_log_top_2")), this.modelOutput);
        ResourceLocation model3 = FAModelTemplates.TEMPLATE_CYCAD_LOG_3.createWithSuffix(cycadLog, "_3", new TextureMapping().put(TextureSlot.SIDE, this.modLocation("block/cycad_log")).put(TextureSlot.TOP, this.modLocation("block/cycad_log_top_3")), this.modelOutput);
        this.block(MultiVariantGenerator.multiVariant(cycadLog, Variant.variant()).with(PropertyDispatch.property(CycadLogBlock.SIZE).select(1, Variant.variant().with(VariantProperties.MODEL, model1)).select(2, Variant.variant().with(VariantProperties.MODEL, model2)).select(3, Variant.variant().with(VariantProperties.MODEL, model3))));
        this.blockModelGenerators.registerSimpleItemModel(cycadLog, model3);
    }

    private void createCooksonia(Block cooksonia) {
        ResourceLocation model1 = FAModelTemplates.TEMPLATE_COOKSONIA_1.createWithSuffix(cooksonia, "_1", new TextureMapping().put(TextureSlot.TEXTURE, this.modLocation("block/cooksonia")), this.modelOutput);
        ResourceLocation model2 = FAModelTemplates.TEMPLATE_COOKSONIA_2.createWithSuffix(cooksonia, "_2", new TextureMapping().put(TextureSlot.TEXTURE, this.modLocation("block/cooksonia")), this.modelOutput);
        ResourceLocation model3 = FAModelTemplates.TEMPLATE_COOKSONIA_3.createWithSuffix(cooksonia, "_3", new TextureMapping().put(TextureSlot.TEXTURE, this.modLocation("block/cooksonia")), this.modelOutput);
        ResourceLocation model4 = FAModelTemplates.TEMPLATE_COOKSONIA_4.createWithSuffix(cooksonia, "_4", new TextureMapping().put(TextureSlot.TEXTURE, this.modLocation("block/cooksonia")), this.modelOutput);
        this.blockStateOutput.accept(MultiPartGenerator.multiPart(cooksonia).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 1, 2, 3, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH), Variant.variant().with(VariantProperties.MODEL, model1)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 1, 2, 3, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST), Variant.variant().with(VariantProperties.MODEL, model1).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 1, 2, 3, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH), Variant.variant().with(VariantProperties.MODEL, model1).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 1, 2, 3, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST), Variant.variant().with(VariantProperties.MODEL, model1).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 2, 3, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH), Variant.variant().with(VariantProperties.MODEL, model2)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 2, 3, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST), Variant.variant().with(VariantProperties.MODEL, model2).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 2, 3, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH), Variant.variant().with(VariantProperties.MODEL, model2).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 2, 3, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST), Variant.variant().with(VariantProperties.MODEL, model2).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 3, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH), Variant.variant().with(VariantProperties.MODEL, model3)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 3, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST), Variant.variant().with(VariantProperties.MODEL, model3).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 3, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH), Variant.variant().with(VariantProperties.MODEL, model3).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 3, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST), Variant.variant().with(VariantProperties.MODEL, model3).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH), Variant.variant().with(VariantProperties.MODEL, model4)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST), Variant.variant().with(VariantProperties.MODEL, model4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH), Variant.variant().with(VariantProperties.MODEL, model4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST), Variant.variant().with(VariantProperties.MODEL, model4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)));
        this.blockModelGenerators.registerSimpleItemModel(cooksonia, ModelTemplates.FLAT_ITEM.create(this.modLocation("item/cooksonia"), new TextureMapping().put(TextureSlot.LAYER0, this.modLocation("item/cooksonia")), this.modelOutput));
    }

    private void createClaytosmunda(Block claytosmunda) {
        this.basic(claytosmunda, FAModelTemplates.TEMPLATE_CLAYTOSMUNDA, new TextureMapping().put(FATextureSlot.SHORT_LEAVES, this.modLocation("block/short_claytosmunda_fern")).put(FATextureSlot.TALL_LEAVES, this.modLocation("block/tall_claytosmunda_fern")));
        this.blockModelGenerators.registerSimpleFlatItemModel(claytosmunda);
    }

    private void createCycadeoidea(Block claytosmunda) {
        ResourceLocation model = this.basic(claytosmunda, FAModelTemplates.TEMPLATE_CYCADEOIDEA, new TextureMapping().put(TextureSlot.TEXTURE, this.modLocation("block/cycadeoidea")));
        this.blockModelGenerators.registerSimpleTintedItemModel(claytosmunda, model, new GrassColorSource());
    }

    private void createMacrotaeniopteris(Block macrotaeniopteris) {
        ResourceLocation stem1 = FAModelTemplates.TEMPLATE_MACROTAENIOPTERIS_STEM_1.createWithSuffix(macrotaeniopteris, "_stem_1", new TextureMapping().put(TextureSlot.TEXTURE, this.modLocation("block/macrotaeniopteris_plant")), this.modelOutput);
        ResourceLocation leaf1 = FAModelTemplates.TEMPLATE_MACROTAENIOPTERIS_LEAF_1.createWithSuffix(macrotaeniopteris, "_leaf_1", new TextureMapping().put(TextureSlot.TEXTURE, this.modLocation("block/macrotaeniopteris_plant")), this.modelOutput);
        ResourceLocation stem2 = FAModelTemplates.TEMPLATE_MACROTAENIOPTERIS_STEM_2.createWithSuffix(macrotaeniopteris, "_stem_2", new TextureMapping().put(TextureSlot.TEXTURE, this.modLocation("block/macrotaeniopteris_plant")), this.modelOutput);
        ResourceLocation leaf2 = FAModelTemplates.TEMPLATE_MACROTAENIOPTERIS_LEAF_2.createWithSuffix(macrotaeniopteris, "_leaf_2", new TextureMapping().put(TextureSlot.TEXTURE, this.modLocation("block/macrotaeniopteris_plant")), this.modelOutput);
        ResourceLocation stem3 = FAModelTemplates.TEMPLATE_MACROTAENIOPTERIS_STEM_3.createWithSuffix(macrotaeniopteris, "_stem_3", new TextureMapping().put(TextureSlot.TEXTURE, this.modLocation("block/macrotaeniopteris_plant")), this.modelOutput);
        ResourceLocation leaf3 = FAModelTemplates.TEMPLATE_MACROTAENIOPTERIS_LEAF_3.createWithSuffix(macrotaeniopteris, "_leaf_3", new TextureMapping().put(TextureSlot.TEXTURE, this.modLocation("block/macrotaeniopteris_plant")), this.modelOutput);
        ResourceLocation stem4 = FAModelTemplates.TEMPLATE_MACROTAENIOPTERIS_STEM_4.createWithSuffix(macrotaeniopteris, "_stem_4", new TextureMapping().put(TextureSlot.TEXTURE, this.modLocation("block/macrotaeniopteris_plant")), this.modelOutput);
        ResourceLocation leaf4 = FAModelTemplates.TEMPLATE_MACROTAENIOPTERIS_LEAF_4.createWithSuffix(macrotaeniopteris, "_leaf_4", new TextureMapping().put(TextureSlot.TEXTURE, this.modLocation("block/macrotaeniopteris_plant")), this.modelOutput);
        ResourceLocation stem5 = FAModelTemplates.TEMPLATE_MACROTAENIOPTERIS_STEM_5.createWithSuffix(macrotaeniopteris, "_stem_5", new TextureMapping().put(TextureSlot.TEXTURE, this.modLocation("block/macrotaeniopteris_plant")), this.modelOutput);
        ResourceLocation leaf5 = FAModelTemplates.TEMPLATE_MACROTAENIOPTERIS_LEAF_5.createWithSuffix(macrotaeniopteris, "_leaf_5", new TextureMapping().put(TextureSlot.TEXTURE, this.modLocation("block/macrotaeniopteris_plant")), this.modelOutput);
        this.block(MultiVariantGenerator.multiVariant(macrotaeniopteris).with(PropertyDispatch.properties(MacrotaeniopterisBlock.HALF, MacrotaeniopterisBlock.AMOUNT).select(DoubleBlockHalf.LOWER, 1, Variant.variant().with(VariantProperties.MODEL, stem1)).select(DoubleBlockHalf.UPPER, 1, Variant.variant().with(VariantProperties.MODEL, leaf1)).select(DoubleBlockHalf.LOWER, 2, Variant.variant().with(VariantProperties.MODEL, stem2)).select(DoubleBlockHalf.UPPER, 2, Variant.variant().with(VariantProperties.MODEL, leaf2)).select(DoubleBlockHalf.LOWER, 3, Variant.variant().with(VariantProperties.MODEL, stem3)).select(DoubleBlockHalf.UPPER, 3, Variant.variant().with(VariantProperties.MODEL, leaf3)).select(DoubleBlockHalf.LOWER, 4, Variant.variant().with(VariantProperties.MODEL, stem4)).select(DoubleBlockHalf.UPPER, 4, Variant.variant().with(VariantProperties.MODEL, leaf4)).select(DoubleBlockHalf.LOWER, 5, Variant.variant().with(VariantProperties.MODEL, stem5)).select(DoubleBlockHalf.UPPER, 5, Variant.variant().with(VariantProperties.MODEL, leaf5))).with(BlockModelGenerators.createHorizontalFacingDispatch()));
        this.blockModelGenerators.registerSimpleFlatItemModel(macrotaeniopteris);
    }

    private void createDipteris(Block dipteris) {
        ResourceLocation model = FAModelTemplates.TEMPLATE_DIPTERIS.create(dipteris, new TextureMapping().put(TextureSlot.TEXTURE, this.modLocation("block/dipteris")), this.modelOutput);
        this.block(MultiVariantGenerator.multiVariant(dipteris, Variant.variant().with(VariantProperties.MODEL, model)).with(BlockModelGenerators.createHorizontalFacingDispatch()));
        this.blockModelGenerators.registerSimpleTintedItemModel(dipteris, model, new GrassColorSource());
    }

    private void createDrum(Block drum) {
        ResourceLocation followModel = ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(drum).withSuffix("_follow"), new TextureMapping().put(TextureSlot.DOWN, this.mcLocation("block/spruce_planks")).put(TextureSlot.EAST, this.modLocation("block/drum_side")).put(TextureSlot.NORTH, this.modLocation("block/drum_side")).put(TextureSlot.PARTICLE, this.modLocation("block/drum_side")).put(TextureSlot.SOUTH, this.modLocation("block/drum_side")).put(TextureSlot.UP, this.modLocation("block/drum_follow")).put(TextureSlot.WEST, this.modLocation("block/drum_side")), this.modelOutput);
        this.blockModelGenerators.registerSimpleItemModel(drum, followModel);
        this.block(MultiVariantGenerator.multiVariant(drum).with(PropertyDispatch.property(DrumBlock.COMMAND_TYPE_PROPERTY).select("follow", Variant.variant().with(VariantProperties.MODEL, followModel)).select("stay", Variant.variant().with(VariantProperties.MODEL, ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(drum).withSuffix("_stay"), new TextureMapping().put(TextureSlot.DOWN, this.mcLocation("block/spruce_planks")).put(TextureSlot.EAST, this.modLocation("block/drum_side")).put(TextureSlot.NORTH, this.modLocation("block/drum_side")).put(TextureSlot.PARTICLE, this.modLocation("block/drum_side")).put(TextureSlot.SOUTH, this.modLocation("block/drum_side")).put(TextureSlot.UP, this.modLocation("block/drum_stay")).put(TextureSlot.WEST, this.modLocation("block/drum_side")), this.modelOutput))).select("free_move", Variant.variant().with(VariantProperties.MODEL, ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(drum).withSuffix("_free_move"), new TextureMapping().put(TextureSlot.DOWN, this.mcLocation("block/spruce_planks")).put(TextureSlot.EAST, this.modLocation("block/drum_side")).put(TextureSlot.NORTH, this.modLocation("block/drum_side")).put(TextureSlot.PARTICLE, this.modLocation("block/drum_side")).put(TextureSlot.SOUTH, this.modLocation("block/drum_side")).put(TextureSlot.UP, this.modLocation("block/drum_free_move")).put(TextureSlot.WEST, this.modLocation("block/drum_side")), this.modelOutput)))));
    }

    private void createFeeder(Block feeder) {
        ResourceLocation emptyModel = ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(feeder).withSuffix("_empty"), new TextureMapping().put(TextureSlot.DOWN, this.mcLocation("block/smooth_stone")).put(TextureSlot.EAST, this.modLocation("block/feeder_side")).put(TextureSlot.NORTH, this.modLocation("block/feeder_front")).put(TextureSlot.PARTICLE, this.modLocation("block/feeder_side")).put(TextureSlot.SOUTH, this.modLocation("block/feeder_side")).put(TextureSlot.UP, this.modLocation("block/feeder_top_empty")).put(TextureSlot.WEST, this.modLocation("block/feeder_side")), this.modelOutput);
        this.blockModelGenerators.registerSimpleItemModel(feeder, emptyModel);
        this.createActiveType(feeder, emptyModel, ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(feeder).withSuffix("_full"), new TextureMapping().put(TextureSlot.DOWN, this.mcLocation("block/smooth_stone")).put(TextureSlot.EAST, this.modLocation("block/feeder_side")).put(TextureSlot.NORTH, this.modLocation("block/feeder_front")).put(TextureSlot.PARTICLE, this.modLocation("block/feeder_side")).put(TextureSlot.SOUTH, this.modLocation("block/feeder_side")).put(TextureSlot.UP, this.modLocation("block/feeder_top_full")).put(TextureSlot.WEST, this.modLocation("block/feeder_side")), this.modelOutput), FeederBlock.HAS_FOOD, true);
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
}
