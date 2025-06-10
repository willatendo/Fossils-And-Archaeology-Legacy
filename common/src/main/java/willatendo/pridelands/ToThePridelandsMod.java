package willatendo.pridelands;

import willatendo.pridelands.server.block.PridelandsBlocks;
import willatendo.pridelands.server.item.PridelandsCreativeModeTabs;
import willatendo.pridelands.server.item.PridelandsItems;
import willatendo.pridelands.server.particles.PridelandsParticles;
import willatendo.pridelands.server.sound.PridelandsSoundEvents;
import willatendo.simplelibrary.server.event.registry.SimpleRegistryRegister;

public final class ToThePridelandsMod {
    public static void onInitialize(SimpleRegistryRegister simpleRegistryRegister) {
        simpleRegistryRegister.register(PridelandsParticles.PARTICLE_TYPES);
        simpleRegistryRegister.register(PridelandsSoundEvents.SOUND_EVENTS);
        simpleRegistryRegister.register(PridelandsBlocks.BLOCKS);
        simpleRegistryRegister.register(PridelandsItems.ITEMS);
        simpleRegistryRegister.register(PridelandsCreativeModeTabs.CREATIVE_MODE_TABS);
    }
}
