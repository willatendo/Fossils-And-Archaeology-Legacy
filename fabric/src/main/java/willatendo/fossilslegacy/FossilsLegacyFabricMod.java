package willatendo.fossilslegacy;

import net.fabricmc.api.ModInitializer;
import willatendo.fossilslegacy.network.FossilsLegacyPackets;
import willatendo.fossilslegacy.server.event.ModCallbacks;
import willatendo.fossilslegacy.server.event.ModEvents;
import willatendo.simplelibrary.server.event.registry.FabricSimpleRegistryRegister;

public class FossilsLegacyFabricMod implements ModInitializer {
    @Override
    public void onInitialize() {
        FossilsLegacyMod.onInitialize(new FabricSimpleRegistryRegister());

        FossilsLegacyPackets.registerClientToServerPackets();

        ModCallbacks.callbacks();
        ModEvents.commonSetup();
    }
}
