package willatendo.missinglinks.server.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import willatendo.missinglinks.server.block.MissingBlocks;
import willatendo.missinglinks.server.util.MissingLinks2Utils;
import willatendo.simplelibrary.server.registry.ItemRegistry;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;

public final class MissingItems {
    public static final ItemRegistry ITEMS = SimpleRegistry.createItem(MissingLinks2Utils.ID);

    static {
        List<SimpleHolder<? extends Block>> exceptions = List.of();
        MissingBlocks.BLOCKS.getEntriesView().stream().filter(simpleHolder -> !exceptions.contains(simpleHolder)).forEach(simpleHolder -> ITEMS.registerItem(simpleHolder.getId().getPath(), properties -> new BlockItem(simpleHolder.get(), properties.useBlockDescriptionPrefix())));
    }
}
