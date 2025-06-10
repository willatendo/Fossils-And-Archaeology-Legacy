package willatendo.pridelands.data;

import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;
import willatendo.pridelands.server.sound.PridelandsSoundEvents;
import willatendo.pridelands.server.utils.PridelandsUtils;

public class PridelandsSoundDefinitionsProvider extends SoundDefinitionsProvider {
    public PridelandsSoundDefinitionsProvider(PackOutput output, String modId) {
        super(output, modId);
    }

    @Override
    public void registerSounds() {
        this.block(PridelandsSoundEvents.BONGO_HIT.get(), "bongo", "hit", "bongo_hit");
    }

    private void add(SoundEvent soundEvent, String base, String type, String event, String... sounds) {
        SoundDefinition soundDefinition = SoundDefinition.definition().subtitle("subtitles." + type + "." + base + "." + event);
        for (String sound : sounds) {
            soundDefinition.with(SoundDefinition.Sound.sound(PridelandsUtils.resource(sound), SoundDefinition.SoundType.SOUND));
        }
        this.add(soundEvent, soundDefinition);
    }

    private void block(SoundEvent soundEvent, String base, String event, String... sounds) {
        this.add(soundEvent, base, "block", event, sounds);
    }
}
