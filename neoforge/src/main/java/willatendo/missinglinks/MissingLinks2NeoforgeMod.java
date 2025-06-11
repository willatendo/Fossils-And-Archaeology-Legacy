package willatendo.missinglinks;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import willatendo.missinglinks.server.util.MissingLinks2Utils;
import willatendo.simplelibrary.server.event.registry.NeoforgeSimpleRegistryRegister;

@Mod(MissingLinks2Utils.ID)
public class MissingLinks2NeoforgeMod {
    public MissingLinks2NeoforgeMod(IEventBus iEventBus) {
        MissingLinks2Mod.onInitialize(new NeoforgeSimpleRegistryRegister(iEventBus));
    }
}
