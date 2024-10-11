package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.FossilsLegacyFossilVariants;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.tags.FossilsLegacyFossilVariantTags;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyFossilVariantTagProvider extends DataDrivenTagsProvider<FossilVariant> {
    public FossilsLegacyFossilVariantTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, FossilsLegacyRegistries.FOSSIL_VARIANTS, provider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FossilsLegacyFossilVariantTags.PLACEABLE_FROM_FOSSIL).add(FossilsLegacyFossilVariants.BRACHIOSAURUS, FossilsLegacyFossilVariants.FUTABASAURUS, FossilsLegacyFossilVariants.PTERANODON, FossilsLegacyFossilVariants.TRICERATOPS, FossilsLegacyFossilVariants.PACHYCEPHALOSAURUS, FossilsLegacyFossilVariants.COMPSOGNATHUS, FossilsLegacyFossilVariants.VELOCIRAPTOR);
    }
}
