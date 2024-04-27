package willatendo.fossilslegacy;

import net.fabricmc.api.ModInitializer;
import willatendo.fossilslegacy.server.config.FabricConfigHelper;
import willatendo.fossilslegacy.server.event.BasicEvents;
import willatendo.fossilslegacy.server.event.ModCallbacks;
import willatendo.fossilslegacy.server.event.ModEvents;
import willatendo.simplelibrary.server.registry.FabricRegister;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.ArrayList;
import java.util.List;

public class FossilsLegacyFabricMod implements ModInitializer {
    @Override
    public void onInitialize() {
        List<SimpleRegistry<?>> simpleRegistries = new ArrayList<SimpleRegistry<?>>();
        FossilsLegacyMod.onInitialize(simpleRegistries);
        FabricRegister.register(simpleRegistries.toArray(SimpleRegistry[]::new));

        FabricConfigHelper.loadConfig();

        BasicEvents.attributeInit();
        ModCallbacks.callbacks();
        ModEvents.commonSetup();
    }
}
