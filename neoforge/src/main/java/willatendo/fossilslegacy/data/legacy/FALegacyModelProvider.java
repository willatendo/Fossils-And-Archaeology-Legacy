package willatendo.fossilslegacy.data.legacy;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.blocks.FeederBlock;
import willatendo.fossilslegacy.server.block.properties.FABlockStateProperties;

import java.util.stream.Stream;

public class FALegacyModelProvider extends ModelProvider {
    public FALegacyModelProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.listElements().filter(blockReference -> blockReference.is(FABlocks.WHITE_CULTIVATOR.getId()) && blockReference.is(FABlocks.ORANGE_CULTIVATOR.getId()) && blockReference.is(FABlocks.MAGENTA_CULTIVATOR.getId()) && blockReference.is(FABlocks.LIGHT_BLUE_CULTIVATOR.getId()) && blockReference.is(FABlocks.YELLOW_CULTIVATOR.getId()) && blockReference.is(FABlocks.LIME_CULTIVATOR.getId()) && blockReference.is(FABlocks.PINK_CULTIVATOR.getId()) && blockReference.is(FABlocks.GRAY_CULTIVATOR.getId()) && blockReference.is(FABlocks.LIGHT_GRAY_CULTIVATOR.getId()) && blockReference.is(FABlocks.CYAN_CULTIVATOR.getId()) && blockReference.is(FABlocks.PURPLE_CULTIVATOR.getId()) && blockReference.is(FABlocks.BLUE_CULTIVATOR.getId()) && blockReference.is(FABlocks.BROWN_CULTIVATOR.getId()) && blockReference.is(FABlocks.GREEN_CULTIVATOR.getId()) && blockReference.is(FABlocks.RED_CULTIVATOR.getId()) && blockReference.is(FABlocks.BLACK_CULTIVATOR.getId()) && blockReference.is(FABlocks.FEEDER.getId()) && blockReference.is(FABlocks.PALAEONTOLOGY_TABLE.getId()));
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return BuiltInRegistries.ITEM.listElements().filter(itemReference -> itemReference.is(FABlocks.WHITE_CULTIVATOR.getId()) && itemReference.is(FABlocks.ORANGE_CULTIVATOR.getId()) && itemReference.is(FABlocks.MAGENTA_CULTIVATOR.getId()) && itemReference.is(FABlocks.LIGHT_BLUE_CULTIVATOR.getId()) && itemReference.is(FABlocks.YELLOW_CULTIVATOR.getId()) && itemReference.is(FABlocks.LIME_CULTIVATOR.getId()) && itemReference.is(FABlocks.PINK_CULTIVATOR.getId()) && itemReference.is(FABlocks.GRAY_CULTIVATOR.getId()) && itemReference.is(FABlocks.LIGHT_GRAY_CULTIVATOR.getId()) && itemReference.is(FABlocks.CYAN_CULTIVATOR.getId()) && itemReference.is(FABlocks.PURPLE_CULTIVATOR.getId()) && itemReference.is(FABlocks.BLUE_CULTIVATOR.getId()) && itemReference.is(FABlocks.BROWN_CULTIVATOR.getId()) && itemReference.is(FABlocks.GREEN_CULTIVATOR.getId()) && itemReference.is(FABlocks.RED_CULTIVATOR.getId()) && itemReference.is(FABlocks.BLACK_CULTIVATOR.getId()) && itemReference.is(FABlocks.FEEDER.getId()) && itemReference.is(FABlocks.PALAEONTOLOGY_TABLE.getId()));
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModelGenerators, ItemModelGenerators itemModelGenerators) {
        this.generateBlockModels(blockModelGenerators);
    }

    private void generateBlockModels(BlockModelGenerators blockModelGenerators) {
        this.createCultivator(blockModelGenerators, FABlocks.WHITE_CULTIVATOR.get(), "white");
        this.createCultivator(blockModelGenerators, FABlocks.ORANGE_CULTIVATOR.get(), "orange");
        this.createCultivator(blockModelGenerators, FABlocks.MAGENTA_CULTIVATOR.get(), "magenta");
        this.createCultivator(blockModelGenerators, FABlocks.LIGHT_BLUE_CULTIVATOR.get(), "light_blue");
        this.createCultivator(blockModelGenerators, FABlocks.YELLOW_CULTIVATOR.get(), "yellow");
        this.createCultivator(blockModelGenerators, FABlocks.LIME_CULTIVATOR.get(), "lime");
        this.createCultivator(blockModelGenerators, FABlocks.PINK_CULTIVATOR.get(), "pink");
        this.createCultivator(blockModelGenerators, FABlocks.GRAY_CULTIVATOR.get(), "gray");
        this.createCultivator(blockModelGenerators, FABlocks.LIGHT_GRAY_CULTIVATOR.get(), "light_gray");
        this.createCultivator(blockModelGenerators, FABlocks.CYAN_CULTIVATOR.get(), "cyan");
        this.createCultivator(blockModelGenerators, FABlocks.PURPLE_CULTIVATOR.get(), "purple");
        this.createCultivator(blockModelGenerators, FABlocks.BLUE_CULTIVATOR.get(), "blue");
        this.createCultivator(blockModelGenerators, FABlocks.BROWN_CULTIVATOR.get(), "brown");
        this.createCultivator(blockModelGenerators, FABlocks.GREEN_CULTIVATOR.get(), "green");
        this.createCultivator(blockModelGenerators, FABlocks.RED_CULTIVATOR.get(), "red");
        this.createCultivator(blockModelGenerators, FABlocks.BLACK_CULTIVATOR.get(), "black");
        this.createFeeder(blockModelGenerators, FABlocks.FEEDER.get());
        this.createPalaeontologyTable(blockModelGenerators, FABlocks.PALAEONTOLOGY_TABLE.get());
    }

    private void createCultivator(BlockModelGenerators blockModelGenerators, Block cultivator, String color) {
        this.createActiveType(blockModelGenerators, cultivator, ModelTemplates.CUBE.create(cultivator, new TextureMapping().put(TextureSlot.DOWN, this.modLocation("block/cultivator_bottom")).put(TextureSlot.EAST, this.modLocation("block/" + color + "_cultivator_side_off")).put(TextureSlot.NORTH, this.modLocation("block/" + color + "_cultivator_side_off")).put(TextureSlot.PARTICLE, this.modLocation("block/" + color + "_cultivator_side_off")).put(TextureSlot.SOUTH, this.modLocation("block/" + color + "_cultivator_side_off")).put(TextureSlot.UP, this.modLocation("block/" + color + "_cultivator_to")).put(TextureSlot.WEST, this.modLocation("block/" + color + "_cultivator_side_off")), blockModelGenerators.modelOutput), ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(cultivator).withSuffix("_active"), new TextureMapping().put(TextureSlot.DOWN, this.modLocation("block/cultivator_bottom")).put(TextureSlot.EAST, this.modLocation("block/" + color + "_cultivator_side_on")).put(TextureSlot.NORTH, this.modLocation("block/" + color + "_cultivator_side_on")).put(TextureSlot.PARTICLE, this.modLocation("block/" + color + "_cultivator_side_on")).put(TextureSlot.SOUTH, this.modLocation("block/" + color + "_cultivator_side_on")).put(TextureSlot.UP, this.modLocation("block/" + color + "_cultivator_to")).put(TextureSlot.WEST, this.modLocation("block/" + color + "_cultivator_side_on")), blockModelGenerators.modelOutput), FABlockStateProperties.ACTIVE, false);
    }

    private void createFeeder(BlockModelGenerators blockModelGenerators, Block feeder) {
        this.createActiveType(blockModelGenerators, feeder, ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(feeder).withSuffix("_empty"), new TextureMapping().put(TextureSlot.DOWN, this.mcLocation("block/iron_block")).put(TextureSlot.EAST, this.modLocation("block/feeder_side")).put(TextureSlot.NORTH, this.modLocation("block/feeder_front")).put(TextureSlot.PARTICLE, this.modLocation("block/feeder_side")).put(TextureSlot.SOUTH, this.modLocation("block/feeder_side")).put(TextureSlot.UP, this.modLocation("block/feeder_top_empty")).put(TextureSlot.WEST, this.modLocation("block/feeder_side")), blockModelGenerators.modelOutput), ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(feeder).withSuffix("_full"), new TextureMapping().put(TextureSlot.DOWN, this.mcLocation("block/iron_block")).put(TextureSlot.EAST, this.modLocation("block/feeder_side")).put(TextureSlot.NORTH, this.modLocation("block/feeder_front")).put(TextureSlot.PARTICLE, this.modLocation("block/feeder_side")).put(TextureSlot.SOUTH, this.modLocation("block/feeder_side")).put(TextureSlot.UP, this.modLocation("block/feeder_top_full")).put(TextureSlot.WEST, this.modLocation("block/feeder_side")), blockModelGenerators.modelOutput), FeederBlock.HAS_FOOD, true);
    }

    private void createPalaeontologyTable(BlockModelGenerators blockModelGenerators, Block palaeontologyTable) {
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(palaeontologyTable, Variant.variant().with(VariantProperties.MODEL, ModelTemplates.CUBE_BOTTOM_TOP.create(palaeontologyTable, new TextureMapping().put(TextureSlot.BOTTOM, this.modLocation("block/palaeontology_table_bottom")).put(TextureSlot.PARTICLE, this.modLocation("block/palaeontology_table_side")).put(TextureSlot.SIDE, this.modLocation("block/palaeontology_table_side")).put(TextureSlot.TOP, this.modLocation("block/palaeontology_table_top")), blockModelGenerators.modelOutput))));
    }

    private void createActiveType(BlockModelGenerators blockModelGenerators, Block block, ResourceLocation inactive, ResourceLocation active, BooleanProperty booleanProperty, boolean directional) {
        MultiVariantGenerator multiVariantGenerator = MultiVariantGenerator.multiVariant(block, Variant.variant()).with(BlockModelGenerators.createBooleanModelDispatch(booleanProperty, active, inactive));
        if (directional) {
            multiVariantGenerator.with(BlockModelGenerators.createHorizontalFacingDispatch());
        }
        blockModelGenerators.blockStateOutput.accept(multiVariantGenerator);
    }
}
