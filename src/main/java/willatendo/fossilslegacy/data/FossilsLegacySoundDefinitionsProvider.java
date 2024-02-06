package willatendo.fossilslegacy.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.data.SimpleSoundDefinitionsProvider;
import willatendo.simplelibrary.data.sounds.SoundDefinition;
import willatendo.simplelibrary.data.sounds.SoundDefinition.Sound;
import willatendo.simplelibrary.data.sounds.SoundDefinition.SoundType;

public class FossilsLegacySoundDefinitionsProvider extends SimpleSoundDefinitionsProvider {
	public FossilsLegacySoundDefinitionsProvider(FabricDataOutput fabricDataOutput) {
		super(fabricDataOutput);
	}

	@Override
	public void registerSounds() {
		this.add(FossilsLegacySoundEvents.BRACHIOSAURUS_AMBIENT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "brachiosaurus.ambient").getString()).with(Sound.sound(FossilsLegacyUtils.resource("brachiosaurus_ambient_1"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("brachiosaurus_ambient_2"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.BRACHIOSAURUS_HURT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "brachiosaurus.hurt").getString()).with(Sound.sound(FossilsLegacyUtils.resource("brachiosaurus_hurt_1"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("brachiosaurus_hurt_2"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.BRACHIOSAURUS_DEATH.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "brachiosaurus.death").getString()).with(Sound.sound(FossilsLegacyUtils.resource("brachiosaurus_death"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.DILOPHOSAURUS_AMBIENT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "dilophosaurus.ambient").getString()).with(Sound.sound(FossilsLegacyUtils.resource("dilophosaurus_ambient"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.DILOPHOSAURUS_CALL.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "dilophosaurus.call").getString()).with(Sound.sound(FossilsLegacyUtils.resource("dilophosaurus_call_1"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("dilophosaurus_call_2"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.DILOPHOSAURUS_HURT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "dilophosaurus.hurt").getString()).with(Sound.sound(FossilsLegacyUtils.resource("dilophosaurus_hurt"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.DILOPHOSAURUS_DEATH.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "dilophosaurus.death").getString()).with(Sound.sound(FossilsLegacyUtils.resource("dilophosaurus_death"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.MAMMOTH_AMBIENT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "mammoth.ambient").getString()).with(Sound.sound(FossilsLegacyUtils.resource("mammoth_ambient"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.MAMMOTH_HURT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "mammoth.hurt").getString()).with(Sound.sound(FossilsLegacyUtils.resource("mammoth_hurt"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.MAMMOTH_DEATH.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "mammoth.death").getString()).with(Sound.sound(FossilsLegacyUtils.resource("mammoth_death"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.PLESIOSAURUS_AMBIENT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "plesiosaurus.ambient").getString()).with(Sound.sound(FossilsLegacyUtils.resource("plesiosaurus_ambient"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.PLESIOSAURUS_HURT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "plesiosaurus.hurt").getString()).with(Sound.sound(FossilsLegacyUtils.resource("plesiosaurus_hurt"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.PLESIOSAURUS_DEATH.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "plesiosaurus.death").getString()).with(Sound.sound(FossilsLegacyUtils.resource("plesiosaurus_death"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.PTERANODON_AMBIENT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "pteranodon.ambient").getString()).with(Sound.sound(FossilsLegacyUtils.resource("pteranodon_ambient_1"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("pteranodon_ambient_2"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.PTERANODON_HURT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "pteranodon.hurt").getString()).with(Sound.sound(FossilsLegacyUtils.resource("pteranodon_hurt"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.PTERANODON_DEATH.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "pteranodon.death").getString()).with(Sound.sound(FossilsLegacyUtils.resource("pteranodon_death"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.SMILODON_AMBIENT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "smilodon.ambient").getString()).with(Sound.sound(FossilsLegacyUtils.resource("smilodon_ambient_1"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("smilodon_ambient_2"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("smilodon_ambient_3"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.SMILODON_HURT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "smilodon.hurt").getString()).with(Sound.sound(FossilsLegacyUtils.resource("smilodon_hurt"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.SMILODON_DEATH.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "smilodon.death").getString()).with(Sound.sound(FossilsLegacyUtils.resource("smilodon_death"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.STEGOSAURUS_AMBIENT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "stegosaurus.ambient").getString()).with(Sound.sound(FossilsLegacyUtils.resource("stegosaurus_ambient_1"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("stegosaurus_ambient_2"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("stegosaurus_ambient_3"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.STEGOSAURUS_HURT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "stegosaurus.hurt").getString()).with(Sound.sound(FossilsLegacyUtils.resource("stegosaurus_hurt"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.STEGOSAURUS_DEATH.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "stegosaurus.death").getString()).with(Sound.sound(FossilsLegacyUtils.resource("stegosaurus_death"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.TRICERATOPS_AMBIENT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "triceratops.ambient").getString()).with(Sound.sound(FossilsLegacyUtils.resource("triceratops_ambient_1"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("triceratops_ambient_2"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("triceratops_ambient_3"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.TRICERATOPS_HURT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "triceratops.hurt").getString()).with(Sound.sound(FossilsLegacyUtils.resource("triceratops_hurt_1"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("triceratops_hurt_2"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.TRICERATOPS_DEATH.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "triceratops.death").getString()).with(Sound.sound(FossilsLegacyUtils.resource("triceratops_death"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.TYRANNOSAURUS_AMBIENT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "tyrannosaurus.ambient").getString()).with(Sound.sound(FossilsLegacyUtils.resource("tyrannosaurus_ambient_1"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("tyrannosaurus_ambient_2"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("tyrannosaurus_ambient_3"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.TYRANNOSAURUS_ATTACK.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "tyrannosaurus.attack").getString()).with(Sound.sound(FossilsLegacyUtils.resource("tyrannosaurus_attack_1"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("tyrannosaurus_attack_2"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("tyrannosaurus_attack_3"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.TYRANNOSAURUS_HURT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "tyrannosaurus.hurt").getString()).with(Sound.sound(FossilsLegacyUtils.resource("tyrannosaurus_hurt"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.TYRANNOSAURUS_DEATH.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "tyrannosaurus.death").getString()).with(Sound.sound(FossilsLegacyUtils.resource("tyrannosaurus_death"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.VELOCIRAPTOR_AMBIENT_TAME.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "velociraptor.ambient.tame").getString()).with(Sound.sound(FossilsLegacyUtils.resource("velociraptor_ambient_tame_1"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("velociraptor_ambient_tame_2"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.VELOCIRAPTOR_AMBIENT_WILD.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "velociraptor.ambient.wild").getString()).with(Sound.sound(FossilsLegacyUtils.resource("velociraptor_ambient_wild_1"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("velociraptor_ambient_wild_2"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.VELOCIRAPTOR_ATTACK.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "velociraptor.attack").getString()).with(Sound.sound(FossilsLegacyUtils.resource("velociraptor_attack_1"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("velociraptor_attack_2"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.VELOCIRAPTOR_HURT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "velociraptor.hurt").getString()).with(Sound.sound(FossilsLegacyUtils.resource("velociraptor_hurt_1"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("velociraptor_hurt_2"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("velociraptor_hurt_3"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.VELOCIRAPTOR_DEATH.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "velociraptor.death").getString()).with(Sound.sound(FossilsLegacyUtils.resource("velociraptor_death"), SoundType.SOUND)));

		this.add(FossilsLegacySoundEvents.DRUM_HIT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "drum.hit").getString()).with(Sound.sound(FossilsLegacyUtils.resource("drum_hit"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.DRUM_TRIPLE_HIT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "drum.triple_hit").getString()).with(Sound.sound(FossilsLegacyUtils.resource("drum_triple_hit"), SoundType.SOUND)));
	}

	@Override
	public String getName() {
		return "fossilslegacy: Sound Defs";
	}
}
