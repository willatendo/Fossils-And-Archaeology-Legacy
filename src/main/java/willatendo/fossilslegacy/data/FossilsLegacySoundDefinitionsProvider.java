package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinition.Sound;
import net.minecraftforge.common.data.SoundDefinition.SoundType;
import willatendo.fossilslegacy.client.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class FossilsLegacySoundDefinitionsProvider extends SoundDefinitionsProvider {
	public FossilsLegacySoundDefinitionsProvider(PackOutput packOutput, String modId, ExistingFileHelper existringFileHelper) {
		super(packOutput, modId, existringFileHelper);
	}

	@Override
	public void registerSounds() {
		this.add(FossilsLegacySoundEvents.MAMMOTH_AMBIENT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "mammoth.ambient").getString()).with(Sound.sound(FossilsLegacyUtils.resource("mammoth_ambient"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.MAMMOTH_HURT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "mammoth.hurt").getString()).with(Sound.sound(FossilsLegacyUtils.resource("mammoth_hurt"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.MAMMOTH_DEATH.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "mammoth.death").getString()).with(Sound.sound(FossilsLegacyUtils.resource("mammoth_death"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.PTERANODON_AMBIENT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "pteranodon.ambient").getString()).with(Sound.sound(FossilsLegacyUtils.resource("pteranodon_ambient_1"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("pteranodon_ambient_2"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.PTERANODON_HURT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "pteranodon.hurt").getString()).with(Sound.sound(FossilsLegacyUtils.resource("pteranodon_hurt"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.PTERANODON_DEATH.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "pteranodon.death").getString()).with(Sound.sound(FossilsLegacyUtils.resource("pteranodon_death"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.SMILODON_AMBIENT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "smilodon.ambient").getString()).with(Sound.sound(FossilsLegacyUtils.resource("smilodon_ambient_1"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("smilodon_ambient_2"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("smilodon_ambient_3"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.SMILODON_HURT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "smilodon.hurt").getString()).with(Sound.sound(FossilsLegacyUtils.resource("smilodon_hurt"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.SMILODON_DEATH.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "smilodon.death").getString()).with(Sound.sound(FossilsLegacyUtils.resource("smilodon_death"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.TRICERATOPS_AMBIENT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "triceratops.ambient").getString()).with(Sound.sound(FossilsLegacyUtils.resource("triceratops_ambient_1"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("triceratops_ambient_2"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("triceratops_ambient_3"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.TRICERATOPS_HURT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "triceratops.hurt").getString()).with(Sound.sound(FossilsLegacyUtils.resource("triceratops_hurt_1"), SoundType.SOUND)).with(Sound.sound(FossilsLegacyUtils.resource("triceratops_hurt_2"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.TRICERATOPS_DEATH.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "triceratops.death").getString()).with(Sound.sound(FossilsLegacyUtils.resource("triceratops_death"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.DRUM_HIT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "drum.hit").getString()).with(Sound.sound(FossilsLegacyUtils.resource("drum_hit"), SoundType.SOUND)));
		this.add(FossilsLegacySoundEvents.DRUM_TRIPLE_HIT.get(), SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", "drum.triple_hit").getString()).with(Sound.sound(FossilsLegacyUtils.resource("drum_triple_hit"), SoundType.SOUND)));
	}
}
