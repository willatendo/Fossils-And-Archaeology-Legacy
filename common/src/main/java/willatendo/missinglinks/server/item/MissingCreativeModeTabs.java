package willatendo.missinglinks.server.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import willatendo.missinglinks.server.block.MissingBlocks;
import willatendo.missinglinks.server.util.MissingLinks2Utils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.SimpleUtils;

public final class MissingCreativeModeTabs {
    public static final SimpleRegistry<CreativeModeTab> CREATIVE_MODE_TABS = SimpleRegistry.create(Registries.CREATIVE_MODE_TAB, MissingLinks2Utils.ID);

    public static final SimpleHolder<CreativeModeTab> MISSING_BLOCKS = CREATIVE_MODE_TABS.register("missing_blocks", () -> SimpleUtils.create(MissingLinks2Utils.ID, "missing_blocks", Blocks.STONE::asItem, (itemDisplayParameters, output) -> {
        output.accept(MissingBlocks.ANDESITE_BUTTON.get());
        output.accept(MissingBlocks.ANDESITE_PRESSURE_PLATE.get());
        output.accept(MissingBlocks.ANDESITE_LEVER.get());
        output.accept(MissingBlocks.CALCITE_STAIRS.get());
        output.accept(MissingBlocks.CALCITE_SLAB.get());
        output.accept(MissingBlocks.CALCITE_WALL.get());
        output.accept(MissingBlocks.CALCITE_BUTTON.get());
        output.accept(MissingBlocks.CALCITE_PRESSURE_PLATE.get());
        output.accept(MissingBlocks.CALCITE_LEVER.get());
        output.accept(MissingBlocks.COBBLED_DEEPSLATE_BUTTON.get());
        output.accept(MissingBlocks.COBBLED_DEEPSLATE_PRESSURE_PLATE.get());
        output.accept(MissingBlocks.COBBLED_DEEPSLATE_LEVER.get());
        output.accept(MissingBlocks.COBBLESTONE_BUTTON.get());
        output.accept(MissingBlocks.COBBLESTONE_PRESSURE_PLATE.get());
        output.accept(MissingBlocks.DIORITE_BUTTON.get());
        output.accept(MissingBlocks.DIORITE_PRESSURE_PLATE.get());
        output.accept(MissingBlocks.DIORITE_LEVER.get());
        output.accept(MissingBlocks.GRANITE_BUTTON.get());
        output.accept(MissingBlocks.GRANITE_PRESSURE_PLATE.get());
        output.accept(MissingBlocks.GRANITE_LEVER.get());
        output.accept(MissingBlocks.TUFF_BUTTON.get());
        output.accept(MissingBlocks.TUFF_PRESSURE_PLATE.get());
        output.accept(MissingBlocks.TUFF_LEVER.get());
        output.accept(MissingBlocks.STONE_LEVER.get());
        output.accept(MissingBlocks.STONE_WALL.get());
    }).build());
}
