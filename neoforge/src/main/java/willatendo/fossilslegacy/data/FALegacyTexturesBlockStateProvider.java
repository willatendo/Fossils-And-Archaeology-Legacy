package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.blocks.CultivatorBlock;
import willatendo.fossilslegacy.server.block.blocks.FeederBlock;
import willatendo.simplelibrary.data.SimpleBlockStateProvider;

public class FALegacyTexturesBlockStateProvider extends SimpleBlockStateProvider {
    public FALegacyTexturesBlockStateProvider(PackOutput packOutput, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, modId, existingFileHelper);
        for (DyeColor dyeColor : DyeColor.values()) {
            existingFileHelper.trackGenerated(this.modLoc("block/" + dyeColor.getName() + "_cultivator_top"), ModelProvider.TEXTURE);
            existingFileHelper.trackGenerated(this.modLoc("block/" + dyeColor.getName() + "_cultivator_side_off"), ModelProvider.TEXTURE);
            existingFileHelper.trackGenerated(this.modLoc("block/" + dyeColor.getName() + "_cultivator_side_on"), ModelProvider.TEXTURE);
        }
    }

    @Override
    protected void registerStatesAndModels() {
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
        this.horizontalBlock(FABlocks.FEEDER.get(), blockState -> this.models().cube("feeder" + (blockState.getValue(FeederBlock.HAS_FOOD) ? "_full" : "_empty"), this.mcLoc("block/iron_block"), this.modLoc("block/feeder_top" + (blockState.getValue(FeederBlock.HAS_FOOD) ? "_full" : "_empty")), this.modLoc("block/feeder_front"), this.modLoc("block/feeder_side"), this.modLoc("block/feeder_side"), this.modLoc("block/feeder_side")).texture("particle", this.modLoc("block/feeder_side")));
        this.simpleBlock(FABlocks.PALAEONTOLOGY_TABLE.get(), this.models().cubeBottomTop("palaeontology_table", this.modLoc("block/palaeontology_table_side"), this.modLoc("block/palaeontology_table_bottom"), this.modLoc("block/palaeontology_table_top")).texture("particle", this.modLoc("block/palaeontology_table_side")));
    }

    private void cultivator(Block block, String color) {
        this.getVariantBuilder(block).partialState().with(CultivatorBlock.ACTIVE, false).addModels(new ConfiguredModel(this.models().cube(color + "_cultivator", this.modLoc("block/cultivator_bottom"), this.modLoc("block/" + color + "_cultivator_top"), this.modLoc("block/" + color + "_cultivator_side_off"), this.modLoc("block/" + color + "_cultivator_side_off"), this.modLoc("block/" + color + "_cultivator_side_off"), this.modLoc("block/" + color + "_cultivator_side_off")).texture("particle", this.modLoc("block/" + color + "_cultivator_side_off")).renderType("translucent"))).partialState().with(CultivatorBlock.ACTIVE, true).addModels(new ConfiguredModel(this.models().cube(color + "_cultivator_active", this.modLoc("block/cultivator_bottom"), this.modLoc("block/" + color + "_cultivator_top"), this.modLoc("block/" + color + "_cultivator_side_on"), this.modLoc("block/" + color + "_cultivator_side_on"), this.modLoc("block/" + color + "_cultivator_side_on"), this.modLoc("block/" + color + "_cultivator_side_on")).texture("particle", this.modLoc("block/" + color + "_cultivator_side_on")).renderType("translucent")));
    }
}
