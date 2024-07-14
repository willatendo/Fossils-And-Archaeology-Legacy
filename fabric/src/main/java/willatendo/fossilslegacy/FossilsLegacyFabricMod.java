package willatendo.fossilslegacy;

import net.fabricmc.api.ModInitializer;
import willatendo.fossilslegacy.network.FossilsLegacyPackets;
import willatendo.fossilslegacy.server.config.FabricConfigHelper;
import willatendo.fossilslegacy.server.event.ModCallbacks;
import willatendo.fossilslegacy.server.event.ModEvents;
import willatendo.simplelibrary.server.event.FabricSimpleRegistryRegister;

public class FossilsLegacyFabricMod implements ModInitializer {
    @Override
    public void onInitialize() {
        FossilsLegacyMod.onInitialize(new FabricSimpleRegistryRegister());

        FabricConfigHelper.loadConfig();

        FossilsLegacyPackets.registerClientToServerPackets();

        ModCallbacks.callbacks();
        ModEvents.commonSetup();
    }
}
