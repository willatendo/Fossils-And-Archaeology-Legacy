package willatendo.fossilslegacy.experiments.server.sound;

import net.minecraft.sounds.SoundEvent;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;

import static willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents.SOUND_EVENTS;

public class FossilsExperimentsSoundEvents {
    public static final SimpleHolder<SoundEvent> CARNOTAURUS_AMBIENT = SOUND_EVENTS.register("entity.carnotaurus.ambient", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.carnotaurus.ambient")));
    public static final SimpleHolder<SoundEvent> CARNOTAURUS_HURT = SOUND_EVENTS.register("entity.carnotaurus.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.carnotaurus.hurt")));
    public static final SimpleHolder<SoundEvent> CARNOTAURUS_DEATH = SOUND_EVENTS.register("entity.carnotaurus.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.carnotaurus.death")));
    public static final SimpleHolder<SoundEvent> CRYOLOPHOSAURUS_AMBIENT = SOUND_EVENTS.register("entity.cryolophosaurus.ambient", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.cryolophosaurus.ambient")));
    public static final SimpleHolder<SoundEvent> CRYOLOPHOSAURUS_HURT = SOUND_EVENTS.register("entity.cryolophosaurus.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.cryolophosaurus.hurt")));
    public static final SimpleHolder<SoundEvent> CRYOLOPHOSAURUS_DEATH = SOUND_EVENTS.register("entity.cryolophosaurus.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.cryolophosaurus.death")));
    public static final SimpleHolder<SoundEvent> THERIZINOSAURUS_AMBIENT = SOUND_EVENTS.register("entity.therizinosaurus.ambient", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.therizinosaurus.ambient")));
    public static final SimpleHolder<SoundEvent> THERIZINOSAURUS_HURT = SOUND_EVENTS.register("entity.therizinosaurus.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.therizinosaurus.hurt")));
    public static final SimpleHolder<SoundEvent> THERIZINOSAURUS_DEATH = SOUND_EVENTS.register("entity.therizinosaurus.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.therizinosaurus.death")));

    public static void init() {
    }
}
