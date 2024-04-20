package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import willatendo.fossilslegacy.server.entity.SpeakerType;

public class FossilsLegacyLanguageProvider extends LanguageProvider implements FossilsDataProvider.BasicTranslationsProvider {
    private final String modId;

    public FossilsLegacyLanguageProvider(PackOutput packOutput, String modId, String local) {
        super(packOutput, modId, local);
        this.modId = modId;
    }

    @Override
    protected void addTranslations() {
        FossilsDataProvider.addTranslations(this);
    }

    @Override
    public String getModId() {
        return this.modId;
    }
}
