package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.world.damagesource.DamageTypes;
import willatendo.fossilslegacy.server.tags.FADamageTypeTags;

import java.util.concurrent.CompletableFuture;

public class FADamageTypeTagProvider extends DamageTypeTagsProvider {
    public FADamageTypeTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FADamageTypeTags.SPINOSAURUS_IMMUNE).add(DamageTypes.ARROW, DamageTypes.TRIDENT);
        this.tag(FADamageTypeTags.TYRANNOSAURUS_IMMUNE).add(DamageTypes.ARROW, DamageTypes.TRIDENT);
    }
}
