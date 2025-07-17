package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;
import willatendo.fossilslegacy.server.sound.FASoundEvents;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class FASoundDefinitionsProvider extends SoundDefinitionsProvider {
    public FASoundDefinitionsProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    @Override
    public void registerSounds() {
        this.block(FASoundEvents.DRUM_HIT.get(), "drum", "hit", "drum_hit");
        this.block(FASoundEvents.DRUM_TRIPLE_HIT.get(), "drum", "triple_hit", "drum_triple_hit");

        this.item(FASoundEvents.FLARE_START.get(), "flare", "start", "flare_start");
        this.item(FASoundEvents.FLARE_IGNITE.get(), "flare", "ignite", "flare_ignite");

        this.entity(FASoundEvents.ANKYLOSAURUS_AMBIENT.get(), "ankylosaurus", "ambient", "ankylosaurus_ambient_1", "ankylosaurus_ambient_2");
        this.entity(FASoundEvents.ANKYLOSAURUS_HURT.get(), "ankylosaurus", "hurt", "ankylosaurus_hurt");
        this.entity(FASoundEvents.ANKYLOSAURUS_DEATH.get(), "ankylosaurus", "death", "ankylosaurus_death");
        this.entity(FASoundEvents.BARYONYX_AMBIENT.get(), "baryonyx", "ambient", "baryonyx_ambient_1", "baryonyx_ambient_2");
        this.entity(FASoundEvents.BARYONYX_HURT.get(), "baryonyx", "hurt", "baryonyx_hurt");
        this.entity(FASoundEvents.BARYONYX_DEATH.get(), "baryonyx", "death", "baryonyx_death");
        this.entity(FASoundEvents.BRACHIOSAURUS_AMBIENT.get(), "brachiosaurus", "ambient", "brachiosaurus_ambient_1", "brachiosaurus_ambient_2");
        this.entity(FASoundEvents.BRACHIOSAURUS_HURT.get(), "brachiosaurus", "hurt", "brachiosaurus_hurt_1", "brachiosaurus_hurt_2");
        this.entity(FASoundEvents.BRACHIOSAURUS_DEATH.get(), "brachiosaurus", "death", "brachiosaurus_death");
        this.entity(FASoundEvents.CARNOTAURUS_AMBIENT.get(), "carnotaurus", "ambient", "carnotaurus_ambient_1", "carnotaurus_ambient_2");
        this.entity(FASoundEvents.CARNOTAURUS_HURT.get(), "carnotaurus", "hurt", "carnotaurus_hurt");
        this.entity(FASoundEvents.CARNOTAURUS_DEATH.get(), "carnotaurus", "death", "carnotaurus_death");
        this.entity(FASoundEvents.COMPSOGNATHUS_AMBIENT.get(), "compsognathus", "ambient", "compsognathus_ambient_1", "compsognathus_ambient_2", "compsognathus_ambient_3");
        this.entity(FASoundEvents.COMPSOGNATHUS_HURT.get(), "compsognathus", "hurt", "compsognathus_hurt");
        this.entity(FASoundEvents.COMPSOGNATHUS_DEATH.get(), "compsognathus", "death", "compsognathus_death_1", "compsognathus_death_2");
        this.entity(FASoundEvents.CRYOLOPHOSAURUS_AMBIENT.get(), "cryolophosaurus", "ambient", "cryolophosaurus_ambient_1", "cryolophosaurus_ambient_2", "cryolophosaurus_ambient_3");
        this.entity(FASoundEvents.CRYOLOPHOSAURUS_HURT.get(), "cryolophosaurus", "hurt", "cryolophosaurus_hurt");
        this.entity(FASoundEvents.CRYOLOPHOSAURUS_DEATH.get(), "cryolophosaurus", "death", "cryolophosaurus_death");
        this.entity(FASoundEvents.DILOPHOSAURUS_AMBIENT.get(), "dilophosaurus", "ambient", "dilophosaurus_ambient");
        this.entity(FASoundEvents.DILOPHOSAURUS_CALL.get(), "dilophosaurus", "call", "dilophosaurus_call_1", "dilophosaurus_call_2");
        this.entity(FASoundEvents.DILOPHOSAURUS_HURT.get(), "dilophosaurus", "hurt", "dilophosaurus_hurt");
        this.entity(FASoundEvents.DILOPHOSAURUS_DEATH.get(), "dilophosaurus", "death", "dilophosaurus_death");
        this.entity(FASoundEvents.DIMETRODON_AMBIENT.get(), "dimetrodon", "ambient", "dimetrodon_ambient");
        this.entity(FASoundEvents.DIMETRODON_HURT.get(), "dimetrodon", "hurt", "dimetrodon_hurt_1", "dimetrodon_hurt_2");
        this.entity(FASoundEvents.DIMETRODON_DEATH.get(), "dimetrodon", "death", "dimetrodon_death");
        this.entity(FASoundEvents.DODO_AMBIENT.get(), "dodo", "ambient", "dodo_ambient_1", "dodo_ambient_2", "dodo_ambient_3");
        this.entity(FASoundEvents.DODO_HURT.get(), "dodo", "hurt", "dodo_hurt_1", "dodo_hurt_2");
        this.entity(FASoundEvents.DODO_DEATH.get(), "dodo", "death", "dodo_death");
        this.add(FASoundEvents.DODO_STEP.get(), SoundDefinition.definition().subtitle("subtitles.block.generic.footsteps").with(SoundDefinition.Sound.sound(FAUtils.resource("dodo_step"), SoundDefinition.SoundType.SOUND)));
        this.entity(FASoundEvents.DRYOSAURUS_AMBIENT.get(), "dryosaurus", "ambient", "dryosaurus_ambient_1", "dryosaurus_ambient_2");
        this.entity(FASoundEvents.DRYOSAURUS_HURT.get(), "dryosaurus", "hurt", "dryosaurus_hurt");
        this.entity(FASoundEvents.DRYOSAURUS_DEATH.get(), "dryosaurus", "death", "dryosaurus_death");
        this.entity(FASoundEvents.ELASMOTHERIUM_AMBIENT.get(), "elasmotherium", "ambient", "elasmotherium_ambient_1", "elasmotherium_ambient_2");
        this.entity(FASoundEvents.ELASMOTHERIUM_HURT.get(), "elasmotherium", "hurt", "elasmotherium_hurt_1", "elasmotherium_hurt_2");
        this.entity(FASoundEvents.ELASMOTHERIUM_DEATH.get(), "elasmotherium", "death", "elasmotherium_death");
        this.entity(FASoundEvents.MAMMOTH_AMBIENT.get(), "mammoth", "ambient", "mammoth_ambient");
        this.entity(FASoundEvents.MAMMOTH_HURT.get(), "mammoth", "hurt", "mammoth_hurt");
        this.entity(FASoundEvents.MAMMOTH_DEATH.get(), "mammoth", "death", "mammoth_death");
        this.entity(FASoundEvents.MOA_AMBIENT.get(), "moa", "ambient", "moa_ambient");
        this.entity(FASoundEvents.MOA_HURT.get(), "moa", "hurt", "moa_hurt");
        this.entity(FASoundEvents.MOA_DEATH.get(), "moa", "death", "moa_death");
        this.entity(FASoundEvents.FUTABASAURUS_AMBIENT.get(), "futabasaurus", "ambient", "futabasaurus_ambient");
        this.entity(FASoundEvents.FUTABASAURUS_HURT.get(), "futabasaurus", "hurt", "futabasaurus_hurt");
        this.entity(FASoundEvents.FUTABASAURUS_DEATH.get(), "futabasaurus", "death", "futabasaurus_death");
        this.entity(FASoundEvents.GALLIMIMUS_AMBIENT.get(), "gallimimus", "ambient", "gallimimus_ambient_1", "gallimimus_ambient_2");
        this.entity(FASoundEvents.GALLIMIMUS_HURT.get(), "gallimimus", "hurt", "gallimimus_hurt");
        this.entity(FASoundEvents.GALLIMIMUS_DEATH.get(), "gallimimus", "death", "gallimimus_death");
        this.entity(FASoundEvents.PACHYCEPHALOSAURUS_AMBIENT.get(), "pachycephalosaurus", "ambient", "pachycephalosaurus_ambient_1", "pachycephalosaurus_ambient_2");
        this.entity(FASoundEvents.PACHYCEPHALOSAURUS_HURT.get(), "pachycephalosaurus", "hurt", "pachycephalosaurus_hurt_1", "pachycephalosaurus_hurt_2");
        this.entity(FASoundEvents.PACHYCEPHALOSAURUS_DEATH.get(), "pachycephalosaurus", "death", "pachycephalosaurus_death");
        this.entity(FASoundEvents.PTERANODON_AMBIENT.get(), "pteranodon", "ambient", "pteranodon_ambient_1", "pteranodon_ambient_2");
        this.entity(FASoundEvents.PTERANODON_HURT.get(), "pteranodon", "hurt", "pteranodon_hurt");
        this.entity(FASoundEvents.PTERANODON_DEATH.get(), "pteranodon", "death", "pteranodon_death");
        this.entity(FASoundEvents.SMILODON_AMBIENT.get(), "smilodon", "ambient", "smilodon_ambient_1", "smilodon_ambient_2", "smilodon_ambient_3");
        this.entity(FASoundEvents.SMILODON_HURT.get(), "smilodon", "hurt", "smilodon_hurt");
        this.entity(FASoundEvents.SMILODON_DEATH.get(), "smilodon", "death", "smilodon_death");
        this.entity(FASoundEvents.SPINOSAURUS_AMBIENT.get(), "spinosaurus", "ambient", "spinosaurus_ambient_1", "spinosaurus_ambient_2");
        this.entity(FASoundEvents.SPINOSAURUS_HURT.get(), "spinosaurus", "hurt", "spinosaurus_hurt");
        this.entity(FASoundEvents.SPINOSAURUS_DEATH.get(), "spinosaurus", "death", "spinosaurus_death");
        this.entity(FASoundEvents.STEGOSAURUS_AMBIENT.get(), "stegosaurus", "ambient", "stegosaurus_ambient_1", "stegosaurus_ambient_2", "stegosaurus_ambient_3");
        this.entity(FASoundEvents.STEGOSAURUS_HURT.get(), "stegosaurus", "hurt", "stegosaurus_hurt");
        this.entity(FASoundEvents.STEGOSAURUS_DEATH.get(), "stegosaurus", "death", "stegosaurus_death");
        this.entity(FASoundEvents.TRICERATOPS_AMBIENT.get(), "triceratops", "ambient", "triceratops_ambient_1", "triceratops_ambient_2", "triceratops_ambient_3");
        this.entity(FASoundEvents.TRICERATOPS_HURT.get(), "triceratops", "hurt", "triceratops_hurt_1", "triceratops_hurt_2");
        this.entity(FASoundEvents.TRICERATOPS_DEATH.get(), "triceratops", "death", "triceratops_death");
        this.entity(FASoundEvents.THERIZINOSAURUS_AMBIENT.get(), "therizinosaurus", "ambient", "therizinosaurus_ambient_1", "therizinosaurus_ambient_2");
        this.entity(FASoundEvents.THERIZINOSAURUS_HURT.get(), "therizinosaurus", "hurt", "therizinosaurus_hurt");
        this.entity(FASoundEvents.THERIZINOSAURUS_DEATH.get(), "therizinosaurus", "death", "therizinosaurus_death");
        this.entity(FASoundEvents.TYRANNOSAURUS_AMBIENT.get(), "tyrannosaurus", "ambient", "tyrannosaurus_ambient_1", "tyrannosaurus_ambient_2", "tyrannosaurus_ambient_3");
        this.entity(FASoundEvents.TYRANNOSAURUS_ATTACK.get(), "tyrannosaurus", "attack", "tyrannosaurus_attack_1", "tyrannosaurus_attack_2", "tyrannosaurus_attack_3");
        this.entity(FASoundEvents.TYRANNOSAURUS_HURT.get(), "tyrannosaurus", "hurt", "tyrannosaurus_hurt");
        this.entity(FASoundEvents.TYRANNOSAURUS_DEATH.get(), "tyrannosaurus", "death", "tyrannosaurus_death");
        this.entity(FASoundEvents.VELOCIRAPTOR_AMBIENT_TAME.get(), "velociraptor", "ambient.tame", "velociraptor_ambient_tame_1", "velociraptor_ambient_tame_2");
        this.entity(FASoundEvents.VELOCIRAPTOR_AMBIENT_WILD.get(), "velociraptor", "ambient.wild", "velociraptor_ambient_wild_1", "velociraptor_ambient_wild_2");
        this.entity(FASoundEvents.VELOCIRAPTOR_ATTACK.get(), "velociraptor", "attack", "velociraptor_attack_1", "velociraptor_attack_2");
        this.entity(FASoundEvents.VELOCIRAPTOR_HURT.get(), "velociraptor", "hurt", "velociraptor_hurt_1", "velociraptor_hurt_2", "velociraptor_hurt_3");
        this.entity(FASoundEvents.VELOCIRAPTOR_DEATH.get(), "velociraptor", "death", "velociraptor_death");

        this.item(FASoundEvents.MAGIC_CONCH_BLOW.get(), "magic_conch", "blow", "magic_conch_blow");
    }

    private void add(SoundEvent soundEvent, String base, String type, String event, String... sounds) {
        SoundDefinition soundDefinition = SoundDefinition.definition().subtitle("subtitles." + type + "." + base + "." + event);
        for (String sound : sounds) {
            soundDefinition.with(SoundDefinition.Sound.sound(FAUtils.resource(sound), SoundDefinition.SoundType.SOUND));
        }
        this.add(soundEvent, soundDefinition);
    }

    private void block(SoundEvent soundEvent, String base, String event, String... sounds) {
        this.add(soundEvent, base, "block", event, sounds);
    }

    private void entity(SoundEvent soundEvent, String base, String event, String... sounds) {
        this.add(soundEvent, base, "entity", event, sounds);
    }

    private void item(SoundEvent soundEvent, String base, String event, String... sounds) {
        this.add(soundEvent, base, "item", event, sounds);
    }

    @Override
    public String getName() {
        return "F/A: Sound Defs";
    }
}
