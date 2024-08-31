package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.FossilsLegacyStoneTabletVariantTags;
import willatendo.fossilslegacy.server.entity.FossilsLegacyStoneTabletVariants;
import willatendo.fossilslegacy.server.entity.genetics.CoatType;
import willatendo.fossilslegacy.server.entity.genetics.FossilsLegacyCoatTypeTags;
import willatendo.fossilslegacy.server.entity.genetics.FossilsLegacyCoatTypes;
import willatendo.fossilslegacy.server.entity.variants.StoneTabletVariant;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyCoatTypeTagProvider extends DataDrivenTagsProvider<CoatType> {
    public FossilsLegacyCoatTypeTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, FossilsLegacyRegistries.COAT_TYPES, provider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FossilsLegacyCoatTypeTags.BRACHIOSAURUS).add(FossilsLegacyCoatTypes.BRACHIOSAURUS, FossilsLegacyCoatTypes.LEGACY_BRACHIOSAURUS);
        this.tag(FossilsLegacyCoatTypeTags.CARNOTAURUS).add(FossilsLegacyCoatTypes.GREEN_CARNOTAURUS, FossilsLegacyCoatTypes.RED_CARNOTAURUS);
        this.tag(FossilsLegacyCoatTypeTags.COMPSOGNATHUS).add(FossilsLegacyCoatTypes.COMPSOGNATHUS);
        this.tag(FossilsLegacyCoatTypeTags.CRYOLOPHOSAURUS).add(FossilsLegacyCoatTypes.CRYOLOPHOSAURUS);
        this.tag(FossilsLegacyCoatTypeTags.DILOPHOSAURUS).add(FossilsLegacyCoatTypes.DILOPHOSAURUS);
        this.tag(FossilsLegacyCoatTypeTags.DODO).add(FossilsLegacyCoatTypes.DODO);
        this.tag(FossilsLegacyCoatTypeTags.FUTABASAURUS).add(FossilsLegacyCoatTypes.FUTABASAURUS, FossilsLegacyCoatTypes.LEGACY_FUTABASAURUS);
        this.tag(FossilsLegacyCoatTypeTags.MAMMOTH).add(FossilsLegacyCoatTypes.MAMMOTH);
        this.tag(FossilsLegacyCoatTypeTags.MOSASAURUS).add(FossilsLegacyCoatTypes.MOSASAURUS);
        this.tag(FossilsLegacyCoatTypeTags.PACHYCEPHALOSAURUS).add(FossilsLegacyCoatTypes.PACHYCEPHALOSAURUS);
        this.tag(FossilsLegacyCoatTypeTags.PTERANODON).add(FossilsLegacyCoatTypes.PTERANODON);
        this.tag(FossilsLegacyCoatTypeTags.SMILODON).add(FossilsLegacyCoatTypes.SMILODON);
        this.tag(FossilsLegacyCoatTypeTags.STEGOSAURUS).add(FossilsLegacyCoatTypes.STEGOSAURUS);
        this.tag(FossilsLegacyCoatTypeTags.THERIZINOSAURUS).add(FossilsLegacyCoatTypes.FEATHERED_THERIZINOSAURUS, FossilsLegacyCoatTypes.FEATHERLESS_THERIZINOSAURUS);
        this.tag(FossilsLegacyCoatTypeTags.TRICERATOPS).add(FossilsLegacyCoatTypes.BROWN_TRICERATOPS, FossilsLegacyCoatTypes.GREEN_TRICERATOPS, FossilsLegacyCoatTypes.LEGACY_BROWN_TRICERATOPS, FossilsLegacyCoatTypes.LEGACY_GREEN_TRICERATOPS);
        this.tag(FossilsLegacyCoatTypeTags.TYRANNOSAURUS).add(FossilsLegacyCoatTypes.TYRANNOSAURUS);
        this.tag(FossilsLegacyCoatTypeTags.VELOCIRAPTOR).add(FossilsLegacyCoatTypes.GREEN_VELOCIRAPTOR, FossilsLegacyCoatTypes.SANDY_VELOCIRAPTOR, FossilsLegacyCoatTypes.WHITE_VELOCIRAPTOR, FossilsLegacyCoatTypes.LEGACY_GREEN_VELOCIRAPTOR, FossilsLegacyCoatTypes.LEGACY_SANDY_VELOCIRAPTOR, FossilsLegacyCoatTypes.LEGACY_WHITE_VELOCIRAPTOR);
    }
}