package willatendo.pridelands;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import willatendo.pridelands.server.utils.PridelandsUtils;
import willatendo.simplelibrary.server.event.registry.NeoforgeSimpleRegistryRegister;

@Mod(PridelandsUtils.ID)
public class ToThePridelandsNeoforgeMod {
    public ToThePridelandsNeoforgeMod(IEventBus iEventBus) {
        ToThePridelandsMod.onInitialize(new NeoforgeSimpleRegistryRegister(iEventBus));
    }
}
