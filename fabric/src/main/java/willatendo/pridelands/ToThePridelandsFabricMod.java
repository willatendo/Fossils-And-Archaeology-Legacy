package willatendo.pridelands;

import net.fabricmc.api.ModInitializer;
import willatendo.pridelands.server.event.ModEvents;
import willatendo.simplelibrary.server.event.registry.FabricSimpleRegistryRegister;

public class ToThePridelandsFabricMod implements ModInitializer {
    @Override
    public void onInitialize() {
        ToThePridelandsMod.onInitialize(new FabricSimpleRegistryRegister());

        ModEvents.commonSetup();
    }
}
