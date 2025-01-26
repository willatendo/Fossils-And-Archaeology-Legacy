package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.block.CultivatorBlock;
import willatendo.fossilslegacy.server.block.FeederBlock;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.simplelibrary.data.SimpleBlockStateProvider;

public class FossilsLegacyLegacyTexturesBlockStateProvider extends SimpleBlockStateProvider {
    public FossilsLegacyLegacyTexturesBlockStateProvider(PackOutput packOutput, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, modId, existingFileHelper);
        for (DyeColor dyeColor : DyeColor.values()) {
            existingFileHelper.trackGenerated(this.modLoc("block/" + dyeColor.getName() + "_cultivator_top"), ModelProvider.TEXTURE);
            existingFileHelper.trackGenerated(this.modLoc("block/" + dyeColor.getName() + "_cultivator_side_off"), ModelProvider.TEXTURE);
            existingFileHelper.trackGenerated(this.modLoc("block/" + dyeColor.getName() + "_cultivator_side_on"), ModelProvider.TEXTURE);
        }
    }

    @Override
    protected void registerStatesAndModels() {
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
        this.horizontalBlock(FossilsLegacyBlocks.FEEDER.get(), blockState -> this.models().cube("feeder" + (blockState.getValue(FeederBlock.HAS_FOOD) ? "_full" : "_empty"), this.mcLoc("block/iron_block"), this.modLoc("block/feeder_top" + (blockState.getValue(FeederBlock.HAS_FOOD) ? "_full" : "_empty")), this.modLoc("block/feeder_front"), this.modLoc("block/feeder_side"), this.modLoc("block/feeder_side"), this.modLoc("block/feeder_side")).texture("particle", this.modLoc("block/feeder_side")));
        this.simpleBlock(FossilsLegacyBlocks.PALAEONTOLOGY_TABLE.get(), this.models().cubeBottomTop("palaeontology_table", this.modLoc("block/palaeontology_table_side"), this.modLoc("block/palaeontology_table_bottom"), this.modLoc("block/palaeontology_table_top")).texture("particle", this.modLoc("block/palaeontology_table_side")));
    }

    private void cultivator(Block block, String color) {
        this.getVariantBuilder(block).partialState().with(CultivatorBlock.ACTIVE, false).addModels(new ConfiguredModel(this.models().cube(color + "_cultivator", this.modLoc("block/cultivator_bottom"), this.modLoc("block/" + color + "_cultivator_top"), this.modLoc("block/" + color + "_cultivator_side_off"), this.modLoc("block/" + color + "_cultivator_side_off"), this.modLoc("block/" + color + "_cultivator_side_off"), this.modLoc("block/" + color + "_cultivator_side_off")).texture("particle", this.modLoc("block/" + color + "_cultivator_side_off")).renderType("translucent"))).partialState().with(CultivatorBlock.ACTIVE, true).addModels(new ConfiguredModel(this.models().cube(color + "_cultivator_active", this.modLoc("block/cultivator_bottom"), this.modLoc("block/" + color + "_cultivator_top"), this.modLoc("block/" + color + "_cultivator_side_on"), this.modLoc("block/" + color + "_cultivator_side_on"), this.modLoc("block/" + color + "_cultivator_side_on"), this.modLoc("block/" + color + "_cultivator_side_on")).texture("particle", this.modLoc("block/" + color + "_cultivator_side_on")).renderType("translucent")));
    }
}
