package willatendo.pridelands.data.model;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import willatendo.pridelands.data.PridelandsBlockFamilies;
import willatendo.pridelands.data.PridelandsLanguageProvider;
import willatendo.pridelands.data.PridelandsModelTemplates;
import willatendo.pridelands.data.PridelandsTextureSlot;
import willatendo.pridelands.server.block.PridelandsBlocks;
import willatendo.pridelands.server.utils.PridelandsUtils;
import willatendo.simplelibrary.data.model.SimpleBlockModelGenerator;

import java.util.Map;

public class PridelandsBlockModelGenerator extends SimpleBlockModelGenerator {
    public PridelandsBlockModelGenerator(BlockModelGenerators blockModelGenerators) {
        super(blockModelGenerators, PridelandsUtils.ID);
        this.blockModelGenerators.fullBlockModelCustomGenerators = Map.of(PridelandsBlocks.OUTSTONE.get(), BlockModelGenerators::createMirroredCubeGenerator, PridelandsBlocks.PRIDESTONE.get(), BlockModelGenerators::createMirroredCubeGenerator);
    }

    @Override
    public void run() {
        this.createBlockFamilies(PridelandsBlockFamilies.getAllFamilies());
        this.blockModelGenerators.createTrivialCube(PridelandsBlocks.CRACKED_PRIDESTONE_BRICKS.get());
        this.blockModelGenerators.createTrivialCube(PridelandsBlocks.PRIDESTONE_COAL_ORE.get());
        this.blockModelGenerators.createTrivialCube(PridelandsBlocks.PRIDESTONE_SILVER_ORE.get());
        this.blockModelGenerators.createTrivialCube(PridelandsBlocks.PRIDESTONE_PEACOCK_ORE.get());
        this.blockModelGenerators.createTrivialCube(PridelandsBlocks.OUTSTONE_NUKA_ORE.get());
        this.blockModelGenerators.createTrivialCube(PridelandsBlocks.OUTSTONE_KIVULITE_ORE.get());
        this.blockModelGenerators.createTrivialCube(PridelandsBlocks.PRIDELANDS_PORTAL_FRAME.get());
        this.blockModelGenerators.createTrivialCube(PridelandsBlocks.OUTLANDS_PORTAL_FRAME.get());
        this.blockModelGenerators.woodProvider(PridelandsBlocks.RAFIKI_TREE_LOG.get()).logWithHorizontal(PridelandsBlocks.RAFIKI_TREE_LOG.get()).wood(PridelandsBlocks.RAFIKI_TREE_WOOD.get());
        this.blockModelGenerators.createTrivialCube(PridelandsBlocks.RAFIKI_TREE_BARK.get());
        this.createPortalBlock(PridelandsBlocks.PRIDELANDS_PORTAL.get());
        this.createFurRug(PridelandsBlocks.FUR_RUG.get());
        this.createFurRug(PridelandsBlocks.WHITE_FUR_RUG.get());
        this.createFurRug(PridelandsBlocks.ORANGE_FUR_RUG.get());
        this.createFurRug(PridelandsBlocks.MAGENTA_FUR_RUG.get());
        this.createFurRug(PridelandsBlocks.LIGHT_BLUE_FUR_RUG.get());
        this.createFurRug(PridelandsBlocks.YELLOW_FUR_RUG.get());
        this.createFurRug(PridelandsBlocks.LIME_FUR_RUG.get());
        this.createFurRug(PridelandsBlocks.PINK_FUR_RUG.get());
        this.createFurRug(PridelandsBlocks.GRAY_FUR_RUG.get());
        this.createFurRug(PridelandsBlocks.LIGHT_GRAY_FUR_RUG.get());
        this.createFurRug(PridelandsBlocks.CYAN_FUR_RUG.get());
        this.createFurRug(PridelandsBlocks.PURPLE_FUR_RUG.get());
        this.createFurRug(PridelandsBlocks.BLUE_FUR_RUG.get());
        this.createFurRug(PridelandsBlocks.BROWN_FUR_RUG.get());
        this.createFurRug(PridelandsBlocks.GREEN_FUR_RUG.get());
        this.createFurRug(PridelandsBlocks.RED_FUR_RUG.get());
        this.createFurRug(PridelandsBlocks.BLACK_FUR_RUG.get());
        this.createBananaCakeBlock(PridelandsBlocks.BANANA_CAKE.get());
        this.createBananaCandleCake(Blocks.CANDLE, PridelandsBlocks.BANANA_CANDLE_CAKE.get());
        this.createBananaCandleCake(Blocks.WHITE_CANDLE, PridelandsBlocks.WHITE_BANANA_CANDLE_CAKE.get());
        this.createBananaCandleCake(Blocks.ORANGE_CANDLE, PridelandsBlocks.ORANGE_BANANA_CANDLE_CAKE.get());
        this.createBananaCandleCake(Blocks.MAGENTA_CANDLE, PridelandsBlocks.MAGENTA_BANANA_CANDLE_CAKE.get());
        this.createBananaCandleCake(Blocks.LIGHT_BLUE_CANDLE, PridelandsBlocks.LIGHT_BLUE_BANANA_CANDLE_CAKE.get());
        this.createBananaCandleCake(Blocks.YELLOW_CANDLE, PridelandsBlocks.YELLOW_BANANA_CANDLE_CAKE.get());
        this.createBananaCandleCake(Blocks.LIME_CANDLE, PridelandsBlocks.LIME_BANANA_CANDLE_CAKE.get());
        this.createBananaCandleCake(Blocks.PINK_CANDLE, PridelandsBlocks.PINK_BANANA_CANDLE_CAKE.get());
        this.createBananaCandleCake(Blocks.GRAY_CANDLE, PridelandsBlocks.GRAY_BANANA_CANDLE_CAKE.get());
        this.createBananaCandleCake(Blocks.LIGHT_GRAY_CANDLE, PridelandsBlocks.LIGHT_GRAY_BANANA_CANDLE_CAKE.get());
        this.createBananaCandleCake(Blocks.CYAN_CANDLE, PridelandsBlocks.CYAN_BANANA_CANDLE_CAKE.get());
        this.createBananaCandleCake(Blocks.PURPLE_CANDLE, PridelandsBlocks.PURPLE_BANANA_CANDLE_CAKE.get());
        this.createBananaCandleCake(Blocks.BLUE_CANDLE, PridelandsBlocks.BLUE_BANANA_CANDLE_CAKE.get());
        this.createBananaCandleCake(Blocks.BROWN_CANDLE, PridelandsBlocks.BROWN_BANANA_CANDLE_CAKE.get());
        this.createBananaCandleCake(Blocks.GREEN_CANDLE, PridelandsBlocks.GREEN_BANANA_CANDLE_CAKE.get());
        this.createBananaCandleCake(Blocks.RED_CANDLE, PridelandsBlocks.RED_BANANA_CANDLE_CAKE.get());
        this.createBananaCandleCake(Blocks.BLACK_CANDLE, PridelandsBlocks.BLACK_BANANA_CANDLE_CAKE.get());
        this.createBongo(PridelandsBlocks.ACACIA_BONGO.get());
        this.createBongo(PridelandsBlocks.BANANA_BONGO.get());
        this.createBongo(PridelandsBlocks.DEAD_WOOD_BONGO.get());
        this.createBongo(PridelandsBlocks.MANGO_BONGO.get());
        this.createBongo(PridelandsBlocks.PASSION_BONGO.get());
        this.createBongo(PridelandsBlocks.RAINFOREST_BONGO.get());
        this.createWideTorch(PridelandsBlocks.HYENA_BONE_TORCH.get(), PridelandsBlocks.HYENA_BONE_WALL_TORCH.get());
    }

    public void createPortalBlock(Block block) {
        ResourceLocation texture = TextureMapping.getBlockTexture(block);
        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(PropertyDispatch.property(BlockStateProperties.HORIZONTAL_AXIS).select(Direction.Axis.X, Variant.variant().with(VariantProperties.MODEL, PridelandsModelTemplates.NETHER_PORTAL_NS.createWithSuffix(block, "_ns", new TextureMapping().put(TextureSlot.PARTICLE, texture).put(PridelandsTextureSlot.PORTAL, texture), this.modelOutput))).select(Direction.Axis.Z, Variant.variant().with(VariantProperties.MODEL, PridelandsModelTemplates.NETHER_PORTAL_EW.createWithSuffix(block, "_ew", new TextureMapping().put(TextureSlot.PARTICLE, texture).put(PridelandsTextureSlot.PORTAL, texture), this.modelOutput)))));
    }

    public void createFurRug(Block block) {
        ResourceLocation resourcelocation = ModelTemplates.CARPET.create(block, TextureMapping.wool(block), this.modelOutput);
        this.block(BlockModelGenerators.createSimpleBlock(block, resourcelocation));
    }

    public void createBananaCandleCake(Block candleBlock, Block candleCakeBlock) {
        ResourceLocation model = ModelTemplates.CANDLE_CAKE.create(candleCakeBlock, this.bananaCandleCake(candleBlock, false), this.modelOutput);
        ResourceLocation litModel = ModelTemplates.CANDLE_CAKE.createWithSuffix(candleCakeBlock, "_lit", this.bananaCandleCake(candleBlock, true), this.modelOutput);
        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(candleCakeBlock).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.LIT, litModel, model)));
    }

    private TextureMapping bananaCandleCake(Block candleBlock, boolean lit) {
        return (new TextureMapping()).put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(PridelandsBlocks.BANANA_CAKE.get(), "_side")).put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(PridelandsBlocks.BANANA_CAKE.get(), "_bottom")).put(TextureSlot.TOP, TextureMapping.getBlockTexture(PridelandsBlocks.BANANA_CAKE.get(), "_top")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(PridelandsBlocks.BANANA_CAKE.get(), "_side")).put(TextureSlot.CANDLE, TextureMapping.getBlockTexture(candleBlock, lit ? "_lit" : ""));
    }

    public void createBananaCakeBlock(Block block) {
        this.registerSimpleFlatItemModel(block.asItem());
        ResourceLocation model = PridelandsModelTemplates.CAKE.create(block, this.bananaCake(block, false), this.modelOutput);
        ResourceLocation modelSlice1 = PridelandsModelTemplates.CAKE_SLICE1.createWithSuffix(block, "_slice1", this.bananaCake(block, true), this.modelOutput);
        ResourceLocation modelSlice2 = PridelandsModelTemplates.CAKE_SLICE2.createWithSuffix(block, "_slice2", this.bananaCake(block, true), this.modelOutput);
        ResourceLocation modelSlice3 = PridelandsModelTemplates.CAKE_SLICE3.createWithSuffix(block, "_slice3", this.bananaCake(block, true), this.modelOutput);
        ResourceLocation modelSlice4 = PridelandsModelTemplates.CAKE_SLICE4.createWithSuffix(block, "_slice4", this.bananaCake(block, true), this.modelOutput);
        ResourceLocation modelSlice5 = PridelandsModelTemplates.CAKE_SLICE5.createWithSuffix(block, "_slice5", this.bananaCake(block, true), this.modelOutput);
        ResourceLocation modelSlice6 = PridelandsModelTemplates.CAKE_SLICE6.createWithSuffix(block, "_slice6", this.bananaCake(block, true), this.modelOutput);
        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(PropertyDispatch.property(BlockStateProperties.BITES).select(0, Variant.variant().with(VariantProperties.MODEL, model)).select(1, Variant.variant().with(VariantProperties.MODEL, modelSlice1)).select(2, Variant.variant().with(VariantProperties.MODEL, modelSlice2)).select(3, Variant.variant().with(VariantProperties.MODEL, modelSlice3)).select(4, Variant.variant().with(VariantProperties.MODEL, modelSlice4)).select(5, Variant.variant().with(VariantProperties.MODEL, modelSlice5)).select(6, Variant.variant().with(VariantProperties.MODEL, modelSlice6))));
    }

    private TextureMapping bananaCake(Block block, boolean hasInside) {
        TextureMapping textureMapping = new TextureMapping();
        if (hasInside) {
            textureMapping.put(TextureSlot.INSIDE, TextureMapping.getBlockTexture(block, "_inner"));
        }
        return textureMapping.put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block, "_side")).put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(block, "_bottom")).put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side"));
    }

    public void createBongo(Block block) {
        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, PridelandsModelTemplates.BONGO.create(block, new TextureMapping().put(TextureSlot.TOP, PridelandsUtils.resource("block/bongo_top")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block)), this.modelOutput))));
    }

    public void createWideTorch(Block torchBlock, Block wallTorchBlock) {
        TextureMapping textureMapping = TextureMapping.torch(torchBlock);
        this.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(torchBlock, PridelandsModelTemplates.WIDE_TORCH.create(torchBlock, textureMapping, this.modelOutput)));
        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(wallTorchBlock, Variant.variant().with(VariantProperties.MODEL, PridelandsModelTemplates.WIDE_WALL_TORCH.create(wallTorchBlock, textureMapping, this.modelOutput))).with(BlockModelGenerators.createTorchHorizontalDispatch()));
        this.blockModelGenerators.registerSimpleFlatItemModel(torchBlock);
    }
}
