
package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.entity.FossilsLegacyFossilVariantTags;
import willatendo.fossilslegacy.server.entity.FossilsLegacyFossilVariants;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyFossilVariantTagProvider extends TagsProvider<FossilVariant> {
    public FossilsLegacyFossilVariantTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, FossilsLegacyRegistries.FOSSIL_VARIANTS, provider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FossilsLegacyFossilVariantTags.PLACEABLE_FROM_FOSSIL).add(FossilsLegacyFossilVariants.BRACHIOSAURUS.getKey(), FossilsLegacyFossilVariants.FUTABASAURUS.getKey(), FossilsLegacyFossilVariants.PTERANODON.getKey(), FossilsLegacyFossilVariants.TRICERATOPS.getKey());
    }
}
