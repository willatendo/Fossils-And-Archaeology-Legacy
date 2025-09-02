package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import willatendo.fossilslegacy.server.fossil_variant.FAFossilVariants;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAFossilVariantTags;

import java.util.concurrent.CompletableFuture;

public class FAFossilVariantTagProvider extends TagsProvider<FossilVariant> {
    public FAFossilVariantTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, FARegistries.FOSSIL_VARIANTS, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FAFossilVariantTags.CENOZOIC).add(FAFossilVariants.DODO, FAFossilVariants.ELASMOTHERIUM, FAFossilVariants.MAMMOTH, FAFossilVariants.MOA, FAFossilVariants.SMILODON);
        this.tag(FAFossilVariantTags.MESOZOIC).add(FAFossilVariants.ANKYLOSAURUS, FAFossilVariants.BARYONYX, FAFossilVariants.BRACHIOSAURUS, FAFossilVariants.LEGACY_BRACHIOSAURUS, FAFossilVariants.CARNOTAURUS, FAFossilVariants.COMPSOGNATHUS, FAFossilVariants.CRYOLOPHOSAURUS, FAFossilVariants.DILOPHOSAURUS, FAFossilVariants.DRYOSAURUS, FAFossilVariants.FUTABASAURUS, FAFossilVariants.LEGACY_FUTABASAURUS, FAFossilVariants.GALLIMIMUS, FAFossilVariants.ICHTHYOSAURUS, FAFossilVariants.MOSASAURUS, FAFossilVariants.PACHYCEPHALOSAURUS, FAFossilVariants.PTERANODON, FAFossilVariants.LEGACY_PTERANODON, FAFossilVariants.SPINOSAURUS, FAFossilVariants.STEGOSAURUS, FAFossilVariants.THERIZINOSAURUS, FAFossilVariants.TRICERATOPS, FAFossilVariants.LEGACY_TRICERATOPS, FAFossilVariants.TYRANNOSAURUS, FAFossilVariants.VELOCIRAPTOR);
        this.tag(FAFossilVariantTags.PALAEOZOIC).add(FAFossilVariants.DIMETRODON, FAFossilVariants.ISOTELUS);
    }
}
