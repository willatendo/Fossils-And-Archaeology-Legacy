package fossilslegacy.server.game_event;

import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class FossilLegacyGameEvents {
	public static final DeferredRegister<GameEvent> GAME_EVENTS = DeferredRegister.create(Registries.GAME_EVENT, FossilsLegacyUtils.ID);

	public static final RegistryObject<GameEvent> CULTIVATOR_SHATTER = GAME_EVENTS.register("cultivator_shatter", () -> new GameEvent("cultivator_shatter", 16));
}
