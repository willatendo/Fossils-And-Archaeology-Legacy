package willatendo.missinglinks;

import willatendo.missinglinks.server.block.MissingBlocks;
import willatendo.missinglinks.server.item.MissingCreativeModeTabs;
import willatendo.missinglinks.server.item.MissingItems;
import willatendo.simplelibrary.server.event.registry.SimpleRegistryRegister;

public final class MissingLinks2Mod {
    public static void onInitialize(SimpleRegistryRegister simpleRegistryRegister) {
        simpleRegistryRegister.register(MissingBlocks.BLOCKS);
        simpleRegistryRegister.register(MissingItems.ITEMS);
        simpleRegistryRegister.register(MissingCreativeModeTabs.CREATIVE_MODE_TABS);
    }
}
