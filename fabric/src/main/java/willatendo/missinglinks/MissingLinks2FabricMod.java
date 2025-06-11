package willatendo.missinglinks;

import net.fabricmc.api.ModInitializer;
import willatendo.simplelibrary.server.event.registry.FabricSimpleRegistryRegister;

public class MissingLinks2FabricMod implements ModInitializer {
    @Override
    public void onInitialize() {
        MissingLinks2Mod.onInitialize(new FabricSimpleRegistryRegister());
    }
}
