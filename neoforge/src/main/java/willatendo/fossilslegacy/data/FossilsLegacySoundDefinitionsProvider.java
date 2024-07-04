package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;
import willatendo.fossilslegacy.server.entity.Fossil;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacySoundDefinitionsProvider extends SoundDefinitionsProvider {
    public FossilsLegacySoundDefinitionsProvider(PackOutput packOutput, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, modId, existingFileHelper);
    }

    @Override
    public void registerSounds() {
        this.entity(FossilsLegacySoundEvents.BRACHIOSAURUS_AMBIENT.get(), "brachiosaurus", "ambient", "brachiosaurus_ambient_1", "brachiosaurus_ambient_2");
        this.entity(FossilsLegacySoundEvents.BRACHIOSAURUS_HURT.get(), "brachiosaurus", "hurt", "brachiosaurus_hurt_1", "brachiosaurus_hurt_2");
        this.entity(FossilsLegacySoundEvents.BRACHIOSAURUS_DEATH.get(), "brachiosaurus", "death", "brachiosaurus_death");
        this.entity(FossilsLegacySoundEvents.CARNOTAURUS_AMBIENT.get(), "carnotaurus", "ambient", "carnotaurus_ambient_1", "carnotaurus_ambient_2");
        this.entity(FossilsLegacySoundEvents.CARNOTAURUS_HURT.get(), "carnotaurus", "hurt", "carnotaurus_hurt");
        this.entity(FossilsLegacySoundEvents.CARNOTAURUS_DEATH.get(), "carnotaurus", "death", "carnotaurus_death");
        this.entity(FossilsLegacySoundEvents.COMPSOGNATHUS_AMBIENT.get(), "compsognathus", "ambient", "compsognathus_ambient_1", "compsognathus_ambient_2", "compsognathus_ambient_3");
        this.entity(FossilsLegacySoundEvents.COMPSOGNATHUS_HURT.get(), "compsognathus", "hurt", "compsognathus_hurt");
        this.entity(FossilsLegacySoundEvents.COMPSOGNATHUS_DEATH.get(), "compsognathus", "death", "compsognathus_death_1", "compsognathus_death_2");
        this.entity(FossilsLegacySoundEvents.CRYOLOPHOSAURUS_AMBIENT.get(), "cryolophosaurus", "ambient", "cryolophosaurus_ambient_1", "cryolophosaurus_ambient_2", "cryolophosaurus_ambient_3");
        this.entity(FossilsLegacySoundEvents.CRYOLOPHOSAURUS_HURT.get(), "cryolophosaurus", "hurt", "cryolophosaurus_hurt");
        this.entity(FossilsLegacySoundEvents.CRYOLOPHOSAURUS_DEATH.get(), "cryolophosaurus", "death", "cryolophosaurus_death");
        this.entity(FossilsLegacySoundEvents.DILOPHOSAURUS_AMBIENT.get(), "dilophosaurus", "ambient", "dilophosaurus_ambient");
        this.entity(FossilsLegacySoundEvents.DILOPHOSAURUS_CALL.get(), "dilophosaurus", "call", "dilophosaurus_call_1", "dilophosaurus_call_2");
        this.entity(FossilsLegacySoundEvents.DILOPHOSAURUS_HURT.get(), "dilophosaurus", "hurt", "dilophosaurus_hurt");
        this.entity(FossilsLegacySoundEvents.DILOPHOSAURUS_DEATH.get(), "dilophosaurus", "death", "dilophosaurus_death");
        this.entity(FossilsLegacySoundEvents.DODO_AMBIENT.get(), "dodo", "ambient", "dodo_ambient_1", "dodo_ambient_2", "dodo_ambient_3");
        this.entity(FossilsLegacySoundEvents.DODO_HURT.get(), "dodo", "hurt", "dodo_hurt_1", "dodo_hurt_2");
        this.entity(FossilsLegacySoundEvents.DODO_DEATH.get(), "dodo", "death", "dodo_death");
        this.add(FossilsLegacySoundEvents.DODO_STEP.get(), SoundDefinition.definition().subtitle("subtitles.block.generic.footsteps").with(SoundDefinition.Sound.sound(FossilsLegacyUtils.resource("dodo_step"), SoundDefinition.SoundType.SOUND)));
        this.entity(FossilsLegacySoundEvents.MAMMOTH_AMBIENT.get(), "mammoth", "ambient", "mammoth_ambient");
        this.entity(FossilsLegacySoundEvents.MAMMOTH_HURT.get(), "mammoth", "hurt", "mammoth_hurt");
        this.entity(FossilsLegacySoundEvents.MAMMOTH_DEATH.get(), "mammoth", "death", "mammoth_death");
        this.entity(FossilsLegacySoundEvents.FUTABASAURUS_AMBIENT.get(), "futabasaurus", "ambient", "futabasaurus_ambient");
        this.entity(FossilsLegacySoundEvents.FUTABASAURUS_HURT.get(), "futabasaurus", "hurt", "futabasaurus_hurt");
        this.entity(FossilsLegacySoundEvents.FUTABASAURUS_DEATH.get(), "futabasaurus", "death", "futabasaurus_death");
        this.entity(FossilsLegacySoundEvents.PACHYCEPHALOSAURUS_AMBIENT.get(), "pachycephalosaurus", "ambient", "pachycephalosaurus_ambient_1", "pachycephalosaurus_ambient_2");
        this.entity(FossilsLegacySoundEvents.PACHYCEPHALOSAURUS_HURT.get(), "pachycephalosaurus", "hurt", "pachycephalosaurus_hurt_1", "pachycephalosaurus_hurt_2");
        this.entity(FossilsLegacySoundEvents.PACHYCEPHALOSAURUS_DEATH.get(), "pachycephalosaurus", "death", "pachycephalosaurus_death");
        this.entity(FossilsLegacySoundEvents.PTERANODON_AMBIENT.get(), "pteranodon", "ambient", "pteranodon_ambient_1", "pteranodon_ambient_2");
        this.entity(FossilsLegacySoundEvents.PTERANODON_HURT.get(), "pteranodon", "hurt", "pteranodon_hurt");
        this.entity(FossilsLegacySoundEvents.PTERANODON_DEATH.get(), "pteranodon", "death", "pteranodon_death");
        this.entity(FossilsLegacySoundEvents.SMILODON_AMBIENT.get(), "smilodon", "ambient", "smilodon_ambient_1", "smilodon_ambient_2", "smilodon_ambient_3");
        this.entity(FossilsLegacySoundEvents.SMILODON_HURT.get(), "smilodon", "hurt", "smilodon_hurt");
        this.entity(FossilsLegacySoundEvents.SMILODON_DEATH.get(), "smilodon", "death", "smilodon_death");
        this.entity(FossilsLegacySoundEvents.STEGOSAURUS_AMBIENT.get(), "stegosaurus", "ambient", "stegosaurus_ambient_1", "stegosaurus_ambient_2", "stegosaurus_ambient_3");
        this.entity(FossilsLegacySoundEvents.STEGOSAURUS_HURT.get(), "stegosaurus", "hurt", "stegosaurus_hurt");
        this.entity(FossilsLegacySoundEvents.STEGOSAURUS_DEATH.get(), "stegosaurus", "death", "stegosaurus_death");
        this.entity(FossilsLegacySoundEvents.TRICERATOPS_AMBIENT.get(), "triceratops", "ambient", "triceratops_ambient_1", "triceratops_ambient_2", "triceratops_ambient_3");
        this.entity(FossilsLegacySoundEvents.TRICERATOPS_HURT.get(), "triceratops", "hurt", "triceratops_hurt_1", "triceratops_hurt_2");
        this.entity(FossilsLegacySoundEvents.TRICERATOPS_DEATH.get(), "triceratops", "death", "triceratops_death");
        this.entity(FossilsLegacySoundEvents.THERIZINOSAURUS_AMBIENT.get(), "therizinosaurus", "ambient", "therizinosaurus_ambient_1", "therizinosaurus_ambient_2");
        this.entity(FossilsLegacySoundEvents.THERIZINOSAURUS_HURT.get(), "therizinosaurus", "hurt", "therizinosaurus_hurt");
        this.entity(FossilsLegacySoundEvents.THERIZINOSAURUS_DEATH.get(), "therizinosaurus", "death", "therizinosaurus_death");
        this.entity(FossilsLegacySoundEvents.TYRANNOSAURUS_AMBIENT.get(), "tyrannosaurus", "ambient", "tyrannosaurus_ambient_1", "tyrannosaurus_ambient_2", "tyrannosaurus_ambient_3");
        this.entity(FossilsLegacySoundEvents.TYRANNOSAURUS_ATTACK.get(), "tyrannosaurus", "attack", "tyrannosaurus_attack_1", "tyrannosaurus_attack_2", "tyrannosaurus_attack_3");
        this.entity(FossilsLegacySoundEvents.TYRANNOSAURUS_HURT.get(), "tyrannosaurus", "hurt", "tyrannosaurus_hurt");
        this.entity(FossilsLegacySoundEvents.TYRANNOSAURUS_DEATH.get(), "tyrannosaurus", "death", "tyrannosaurus_death");
        this.entity(FossilsLegacySoundEvents.VELOCIRAPTOR_AMBIENT_TAME.get(), "velociraptor", "ambient.tame", "velociraptor_ambient_tame_1", "velociraptor_ambient_tame_2");
        this.entity(FossilsLegacySoundEvents.VELOCIRAPTOR_AMBIENT_WILD.get(), "velociraptor", "ambient.wild", "velociraptor_ambient_wild_1", "velociraptor_ambient_wild_2");
        this.entity(FossilsLegacySoundEvents.VELOCIRAPTOR_ATTACK.get(), "velociraptor", "attack", "velociraptor_attack_1", "velociraptor_attack_2");
        this.entity(FossilsLegacySoundEvents.VELOCIRAPTOR_HURT.get(), "velociraptor", "hurt", "velociraptor_hurt_1", "velociraptor_hurt_2", "velociraptor_hurt_3");
        this.entity(FossilsLegacySoundEvents.VELOCIRAPTOR_DEATH.get(), "velociraptor", "death", "velociraptor_death");

        this.block(FossilsLegacySoundEvents.DRUM_HIT.get(), "drum", "hit", "drum_hit");
        this.block(FossilsLegacySoundEvents.DRUM_TRIPLE_HIT.get(), "drum", "triple_hit", "drum_triple_hit");
    }

    private void add(SoundEvent soundEvent, String base, String type, String event, String... sounds) {
        SoundDefinition soundDefinition = SoundDefinition.definition().subtitle("subtitles." + type + "." + base + "." + event);
        for (String sound : sounds) {
            soundDefinition.with(SoundDefinition.Sound.sound(FossilsLegacyUtils.resource(sound), SoundDefinition.SoundType.SOUND));
        }
        this.add(soundEvent, soundDefinition);
    }

    private void entity(SoundEvent soundEvent, String base, String event, String... sounds) {
        this.add(soundEvent, base, "entity", event, sounds);
    }

    private void block(SoundEvent soundEvent, String base, String event, String... sounds) {
        this.add(soundEvent, base, "block", event, sounds);
    }

    @Override
    public String getName() {
        return "fossilslegacy: Sound Defs";
    }
}
