package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.fossil_variant.FAFossilVariants;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAFossilVariantTags;

import java.util.concurrent.CompletableFuture;

public class FAFossilVariantTagProvider extends DataDrivenTagsProvider<FossilVariant> {
    public FAFossilVariantTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, FARegistries.FOSSIL_VARIANTS, provider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FAFossilVariantTags.PLACEABLE_FROM_FOSSIL).add(FAFossilVariants.ANKYLOSAURUS, FAFossilVariants.BRACHIOSAURUS, FAFossilVariants.LEGACY_BRACHIOSAURUS, FAFossilVariants.CARNOTAURUS, FAFossilVariants.COMPSOGNATHUS, FAFossilVariants.CRYOLOPHOSAURUS, FAFossilVariants.DILOPHOSAURUS, FAFossilVariants.DIMETRODON, FAFossilVariants.FUTABASAURUS, FAFossilVariants.LEGACY_FUTABASAURUS, FAFossilVariants.GALLIMIMUS, FAFossilVariants.PACHYCEPHALOSAURUS, FAFossilVariants.PTERANODON, FAFossilVariants.LEGACY_PTERANODON, FAFossilVariants.SPINOSAURUS, FAFossilVariants.STEGOSAURUS, FAFossilVariants.THERIZINOSAURUS, FAFossilVariants.TRICERATOPS, FAFossilVariants.LEGACY_TRICERATOPS, FAFossilVariants.TYRANNOSAURUS, FAFossilVariants.VELOCIRAPTOR);
    }
}
