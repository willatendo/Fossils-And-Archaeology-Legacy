package willatendo.fossilslegacy.server.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.gameevent.GameEvent;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FAGameEvents {
    public static final SimpleRegistry<GameEvent> GAME_EVENTS = SimpleRegistry.create(Registries.GAME_EVENT, FAUtils.ID);

    public static final SimpleHolder<GameEvent> CULTIVATOR_SHATTER = GAME_EVENTS.register("cultivator_shatter", () -> new GameEvent(16));
}
