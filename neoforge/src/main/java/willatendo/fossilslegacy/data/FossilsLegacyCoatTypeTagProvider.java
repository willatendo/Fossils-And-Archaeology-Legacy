package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.genetics.cosmetics.FossilsLegacyCoatTypes;
import willatendo.fossilslegacy.server.tags.FossilsLegacyCoatTypeTags;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyCoatTypeTagProvider extends DataDrivenTagsProvider<CoatType> {
    public FossilsLegacyCoatTypeTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, FossilsLegacyRegistries.COAT_TYPES, provider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FossilsLegacyCoatTypeTags.ANKYLOSAURUS).add(FossilsLegacyCoatTypes.ANKYLOSAURUS);
        this.tag(FossilsLegacyCoatTypeTags.BRACHIOSAURUS).add(FossilsLegacyCoatTypes.BRACHIOSAURUS, FossilsLegacyCoatTypes.LEGACY_BRACHIOSAURUS);
        this.tag(FossilsLegacyCoatTypeTags.CARNOTAURUS).add(FossilsLegacyCoatTypes.GREEN_CARNOTAURUS, FossilsLegacyCoatTypes.RED_CARNOTAURUS);
        this.tag(FossilsLegacyCoatTypeTags.COMPSOGNATHUS).add(FossilsLegacyCoatTypes.COMPSOGNATHUS);
        this.tag(FossilsLegacyCoatTypeTags.CRYOLOPHOSAURUS).add(FossilsLegacyCoatTypes.CRYOLOPHOSAURUS, FossilsLegacyCoatTypes.LEGACY_CRYOLOPHOSAURUS);
        this.tag(FossilsLegacyCoatTypeTags.DILOPHOSAURUS).add(FossilsLegacyCoatTypes.DILOPHOSAURUS);
        this.tag(FossilsLegacyCoatTypeTags.DODO).add(FossilsLegacyCoatTypes.DODO);
        this.tag(FossilsLegacyCoatTypeTags.FUTABASAURUS).add(FossilsLegacyCoatTypes.FUTABASAURUS, FossilsLegacyCoatTypes.LEGACY_FUTABASAURUS);
        this.tag(FossilsLegacyCoatTypeTags.NON_LEGACY_FUTABASAURUS).add(FossilsLegacyCoatTypes.FUTABASAURUS);
        this.tag(FossilsLegacyCoatTypeTags.GALLIMIMUS).add(FossilsLegacyCoatTypes.GALLIMIMUS);
        this.tag(FossilsLegacyCoatTypeTags.MAMMOTH).add(FossilsLegacyCoatTypes.MAMMOTH);
        this.tag(FossilsLegacyCoatTypeTags.MOA).add(FossilsLegacyCoatTypes.MOA);
        this.tag(FossilsLegacyCoatTypeTags.MOSASAURUS).add(FossilsLegacyCoatTypes.LEGACY_MOSASAURUS);
        this.tag(FossilsLegacyCoatTypeTags.PACHYCEPHALOSAURUS).add(FossilsLegacyCoatTypes.PACHYCEPHALOSAURUS);
        this.tag(FossilsLegacyCoatTypeTags.PTERANODON).add(FossilsLegacyCoatTypes.LEGACY_PTERANODON);
        this.tag(FossilsLegacyCoatTypeTags.SMILODON).add(FossilsLegacyCoatTypes.SMILODON);
        this.tag(FossilsLegacyCoatTypeTags.SPINOSAURUS).add(FossilsLegacyCoatTypes.SPINOSAURUS);
        this.tag(FossilsLegacyCoatTypeTags.STEGOSAURUS).add(FossilsLegacyCoatTypes.STEGOSAURUS);
        this.tag(FossilsLegacyCoatTypeTags.THERIZINOSAURUS).add(FossilsLegacyCoatTypes.FEATHERED_THERIZINOSAURUS, FossilsLegacyCoatTypes.FEATHERLESS_THERIZINOSAURUS);
        this.tag(FossilsLegacyCoatTypeTags.TRICERATOPS).add(FossilsLegacyCoatTypes.BROWN_TRICERATOPS, FossilsLegacyCoatTypes.GREEN_TRICERATOPS, FossilsLegacyCoatTypes.LEGACY_BROWN_TRICERATOPS, FossilsLegacyCoatTypes.LEGACY_GREEN_TRICERATOPS);
        this.tag(FossilsLegacyCoatTypeTags.NON_LEGACY_TRICERATOPS).add(FossilsLegacyCoatTypes.BROWN_TRICERATOPS, FossilsLegacyCoatTypes.GREEN_TRICERATOPS);
        this.tag(FossilsLegacyCoatTypeTags.TYRANNOSAURUS).add(FossilsLegacyCoatTypes.LEGACY_TYRANNOSAURUS);
        this.tag(FossilsLegacyCoatTypeTags.VELOCIRAPTOR).add(FossilsLegacyCoatTypes.GREEN_VELOCIRAPTOR, FossilsLegacyCoatTypes.SANDY_VELOCIRAPTOR, FossilsLegacyCoatTypes.WHITE_VELOCIRAPTOR, FossilsLegacyCoatTypes.LEGACY_GREEN_VELOCIRAPTOR, FossilsLegacyCoatTypes.LEGACY_SANDY_VELOCIRAPTOR, FossilsLegacyCoatTypes.LEGACY_WHITE_VELOCIRAPTOR);
        this.tag(FossilsLegacyCoatTypeTags.LEGACY_VELOCIRAPTOR).add(FossilsLegacyCoatTypes.LEGACY_GREEN_VELOCIRAPTOR, FossilsLegacyCoatTypes.LEGACY_SANDY_VELOCIRAPTOR, FossilsLegacyCoatTypes.LEGACY_WHITE_VELOCIRAPTOR);
        this.tag(FossilsLegacyCoatTypeTags.NON_LEGACY_VELOCIRAPTOR).add(FossilsLegacyCoatTypes.GREEN_VELOCIRAPTOR, FossilsLegacyCoatTypes.SANDY_VELOCIRAPTOR, FossilsLegacyCoatTypes.WHITE_VELOCIRAPTOR);
    }
}
