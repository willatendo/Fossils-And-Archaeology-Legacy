package willatendo.fossilslegacy.server.sound;

import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;

public class FossilsLegacySoundEvents {
    public static final SimpleRegistry<SoundEvent> SOUND_EVENTS = SimpleRegistry.create(Registries.SOUND_EVENT, FossilsLegacyUtils.ID);

    public static final SimpleHolder<SoundEvent> BRACHIOSAURUS_AMBIENT = SOUND_EVENTS.register("entity.brachiosaurus.ambient", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.brachiosaurus.ambient")));
    public static final SimpleHolder<SoundEvent> BRACHIOSAURUS_HURT = SOUND_EVENTS.register("entity.brachiosaurus.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.brachiosaurus.hurt")));
    public static final SimpleHolder<SoundEvent> BRACHIOSAURUS_DEATH = SOUND_EVENTS.register("entity.brachiosaurus.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.brachiosaurus.death")));
    public static final SimpleHolder<SoundEvent> CARNOTAURUS_AMBIENT = SOUND_EVENTS.register("entity.carnotaurus.ambient", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.carnotaurus.ambient")));
    public static final SimpleHolder<SoundEvent> CARNOTAURUS_HURT = SOUND_EVENTS.register("entity.carnotaurus.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.carnotaurus.hurt")));
    public static final SimpleHolder<SoundEvent> CARNOTAURUS_DEATH = SOUND_EVENTS.register("entity.carnotaurus.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.carnotaurus.death")));
    public static final SimpleHolder<SoundEvent> CRYOLOPHOSAURUS_AMBIENT = SOUND_EVENTS.register("entity.cryolophosaurus.ambient", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.cryolophosaurus.ambient")));
    public static final SimpleHolder<SoundEvent> CRYOLOPHOSAURUS_HURT = SOUND_EVENTS.register("entity.cryolophosaurus.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.cryolophosaurus.hurt")));
    public static final SimpleHolder<SoundEvent> CRYOLOPHOSAURUS_DEATH = SOUND_EVENTS.register("entity.cryolophosaurus.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.cryolophosaurus.death")));
    public static final SimpleHolder<SoundEvent> DILOPHOSAURUS_AMBIENT = SOUND_EVENTS.register("entity.dilophosaurus.ambient", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.dilophosaurus.ambient")));
    public static final SimpleHolder<SoundEvent> DILOPHOSAURUS_CALL = SOUND_EVENTS.register("entity.dilophosaurus.call", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.dilophosaurus.call")));
    public static final SimpleHolder<SoundEvent> DILOPHOSAURUS_HURT = SOUND_EVENTS.register("entity.dilophosaurus.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.dilophosaurus.hurt")));
    public static final SimpleHolder<SoundEvent> DILOPHOSAURUS_DEATH = SOUND_EVENTS.register("entity.dilophosaurus.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.dilophosaurus.death")));
    public static final SimpleHolder<SoundEvent> MAMMOTH_AMBIENT = SOUND_EVENTS.register("entity.mammoth.ambient", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.mammoth.ambient")));
    public static final SimpleHolder<SoundEvent> MAMMOTH_HURT = SOUND_EVENTS.register("entity.mammoth.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.mammoth.hurt")));
    public static final SimpleHolder<SoundEvent> MAMMOTH_DEATH = SOUND_EVENTS.register("entity.mammoth.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.mammoth.death")));
    public static final SimpleHolder<SoundEvent> FUTABASAURUS_AMBIENT = SOUND_EVENTS.register("entity.futabasaurus.ambient", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.plesiosaurus.ambient")));
    public static final SimpleHolder<SoundEvent> FUTABASAURUS_HURT = SOUND_EVENTS.register("entity.futabasaurus.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.futabasaurus.hurt")));
    public static final SimpleHolder<SoundEvent> FUTABASAURUS_DEATH = SOUND_EVENTS.register("entity.futabasaurus.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.futabasaurus.death")));
    public static final SimpleHolder<SoundEvent> PTERANODON_AMBIENT = SOUND_EVENTS.register("entity.pteranodon.ambient", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.futabasaurus.ambient")));
    public static final SimpleHolder<SoundEvent> PTERANODON_HURT = SOUND_EVENTS.register("entity.pteranodon.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.pteranodon.hurt")));
    public static final SimpleHolder<SoundEvent> PTERANODON_DEATH = SOUND_EVENTS.register("entity.pteranodon.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.pteranodon.death")));
    public static final SimpleHolder<SoundEvent> SMILODON_AMBIENT = SOUND_EVENTS.register("entity.smilodon.ambient", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.smilodon.ambient")));
    public static final SimpleHolder<SoundEvent> SMILODON_HURT = SOUND_EVENTS.register("entity.smilodon.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.smilodon.hurt")));
    public static final SimpleHolder<SoundEvent> SMILODON_DEATH = SOUND_EVENTS.register("entity.smilodon.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.smilodon.death")));
    public static final SimpleHolder<SoundEvent> STEGOSAURUS_AMBIENT = SOUND_EVENTS.register("entity.stegosaurus.ambient", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.stegosaurus.ambient")));
    public static final SimpleHolder<SoundEvent> STEGOSAURUS_HURT = SOUND_EVENTS.register("entity.stegosaurus.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.stegosaurus.hurt")));
    public static final SimpleHolder<SoundEvent> STEGOSAURUS_DEATH = SOUND_EVENTS.register("entity.stegosaurus.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.stegosaurus.death")));
    public static final SimpleHolder<SoundEvent> THERIZINOSAURUS_AMBIENT = SOUND_EVENTS.register("entity.therizinosaurus.ambient", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.therizinosaurus.ambient")));
    public static final SimpleHolder<SoundEvent> THERIZINOSAURUS_HURT = SOUND_EVENTS.register("entity.therizinosaurus.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.therizinosaurus.hurt")));
    public static final SimpleHolder<SoundEvent> THERIZINOSAURUS_DEATH = SOUND_EVENTS.register("entity.therizinosaurus.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.therizinosaurus.death")));
    public static final SimpleHolder<SoundEvent> TRICERATOPS_AMBIENT = SOUND_EVENTS.register("entity.triceratops.ambient", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.triceratops.ambient")));
    public static final SimpleHolder<SoundEvent> TRICERATOPS_HURT = SOUND_EVENTS.register("entity.triceratops.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.triceratops.hurt")));
    public static final SimpleHolder<SoundEvent> TRICERATOPS_DEATH = SOUND_EVENTS.register("entity.triceratops.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.triceratops.death")));
    public static final SimpleHolder<SoundEvent> TYRANNOSAURUS_AMBIENT = SOUND_EVENTS.register("entity.tyrannosaurus.ambient", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.tyrannosaurus.ambient")));
    public static final SimpleHolder<SoundEvent> TYRANNOSAURUS_ATTACK = SOUND_EVENTS.register("entity.tyrannosaurus.attack", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.tyrannosaurus.attack")));
    public static final SimpleHolder<SoundEvent> TYRANNOSAURUS_HURT = SOUND_EVENTS.register("entity.tyrannosaurus.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.tyrannosaurus.hurt")));
    public static final SimpleHolder<SoundEvent> TYRANNOSAURUS_DEATH = SOUND_EVENTS.register("entity.tyrannosaurus.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.tyrannosaurus.death")));
    public static final SimpleHolder<SoundEvent> VELOCIRAPTOR_AMBIENT_TAME = SOUND_EVENTS.register("entity.velociraptor.ambient.tame", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.velociraptor.ambient.tame")));
    public static final SimpleHolder<SoundEvent> VELOCIRAPTOR_AMBIENT_WILD = SOUND_EVENTS.register("entity.velociraptor.ambient.wild", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.velociraptor.ambient.wild")));
    public static final SimpleHolder<SoundEvent> VELOCIRAPTOR_ATTACK = SOUND_EVENTS.register("entity.velociraptor.attack", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.velociraptor.attack")));
    public static final SimpleHolder<SoundEvent> VELOCIRAPTOR_HURT = SOUND_EVENTS.register("entity.velociraptor.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.velociraptor.hurt")));
    public static final SimpleHolder<SoundEvent> VELOCIRAPTOR_DEATH = SOUND_EVENTS.register("entity.velociraptor.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.velociraptor.death")));

    public static final SimpleHolder<SoundEvent> DRUM_HIT = SOUND_EVENTS.register("block.drum.hit", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("block.drum.hit")));
    public static final SimpleHolder<SoundEvent> DRUM_TRIPLE_HIT = SOUND_EVENTS.register("block.drum.triple_hit", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("block.drum.triple_hit")));

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(SOUND_EVENTS);
    }
}
