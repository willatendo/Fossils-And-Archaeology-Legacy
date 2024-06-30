package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyEntityTypeTagProvider extends EntityTypeTagsProvider {
    public FossilsLegacyEntityTypeTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, provider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(EntityTypeTags.FALL_DAMAGE_IMMUNE).add(FossilsLegacyEntityTypes.DODO.get(), FossilsLegacyEntityTypes.PTERANODON.get());
        this.tag(EntityTypeTags.CAN_BREATHE_UNDER_WATER).add(FossilsLegacyEntityTypes.MOSASAURUS.get(), FossilsLegacyEntityTypes.FUTABASAURUS.get());
    }
}
