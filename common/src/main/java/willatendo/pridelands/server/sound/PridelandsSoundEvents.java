package willatendo.pridelands.server.sound;

import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import willatendo.pridelands.server.utils.PridelandsUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class PridelandsSoundEvents {
    public static final SimpleRegistry<SoundEvent> SOUND_EVENTS = SimpleRegistry.create(Registries.SOUND_EVENT, PridelandsUtils.ID);

    public static final SimpleHolder<SoundEvent> BONGO_HIT = SOUND_EVENTS.register("block.bongo.hit", () -> SoundEvent.createVariableRangeEvent(PridelandsUtils.resource("block.bongo.hit")));
}
