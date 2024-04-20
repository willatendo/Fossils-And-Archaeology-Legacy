package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacySoundDefinitionsProvider extends SoundDefinitionsProvider implements FossilsDataProvider.BasicSoundDefinitionsProvider {
    public FossilsLegacySoundDefinitionsProvider(PackOutput packOutput, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, modId, existingFileHelper);
    }

    @Override
    public void registerSounds() {
        FossilsDataProvider.addSounds(this);
    }

    @Override
    public void addSounds(SoundEvent soundEvent, String subtitle, String... sounds) {
        SoundDefinition soundDefinition = SoundDefinition.definition().subtitle(FossilsLegacyUtils.translation("sound", subtitle).getString());
        for (int i = 0; i < sounds.length; i++) {
            String file = sounds[i];
            soundDefinition.with(SoundDefinition.Sound.sound(FossilsLegacyUtils.resource(file), SoundDefinition.SoundType.SOUND));
        }
        this.add(soundEvent, soundDefinition);
    }

    @Override
    public String getName() {
        return "fossilslegacy: Sound Defs";
    }
}
