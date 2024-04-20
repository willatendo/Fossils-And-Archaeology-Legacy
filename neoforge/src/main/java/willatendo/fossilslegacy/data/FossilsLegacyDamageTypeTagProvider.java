package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.world.damagesource.DamageTypes;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.entity.FossilsLegacyDamgeTypeTags;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyDamageTypeTagProvider extends DamageTypeTagsProvider {
    public FossilsLegacyDamageTypeTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, provider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FossilsLegacyDamgeTypeTags.TYRANNOSAURUS_IMMUNE).add(DamageTypes.ARROW, DamageTypes.TRIDENT);
    }
}
