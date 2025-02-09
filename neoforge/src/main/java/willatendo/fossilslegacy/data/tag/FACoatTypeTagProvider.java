package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.coat_type.FACoatTypes;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FACoatTypeTags;

import java.util.concurrent.CompletableFuture;

public class FACoatTypeTagProvider extends TagsProvider<CoatType> {
    public FACoatTypeTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, FARegistries.COAT_TYPES, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FACoatTypeTags.ANKYLOSAURUS).add(FACoatTypes.ANKYLOSAURUS);
        this.tag(FACoatTypeTags.BRACHIOSAURUS).add(FACoatTypes.BRACHIOSAURUS, FACoatTypes.LEGACY_BRACHIOSAURUS);
        this.tag(FACoatTypeTags.NON_LEGACY_BRACHIOSAURUS).add(FACoatTypes.BRACHIOSAURUS);
        this.tag(FACoatTypeTags.CARNOTAURUS).add(FACoatTypes.GREEN_CARNOTAURUS, FACoatTypes.RED_CARNOTAURUS, FACoatTypes.LEGACY_GREEN_CARNOTAURUS, FACoatTypes.LEGACY_RED_CARNOTAURUS);
        this.tag(FACoatTypeTags.NON_LEGACY_CARNOTAURUS).add(FACoatTypes.GREEN_CARNOTAURUS, FACoatTypes.RED_CARNOTAURUS);
        this.tag(FACoatTypeTags.COMPSOGNATHUS).add(FACoatTypes.COMPSOGNATHUS);
        this.tag(FACoatTypeTags.CRYOLOPHOSAURUS).add(FACoatTypes.CRYOLOPHOSAURUS, FACoatTypes.LEGACY_CRYOLOPHOSAURUS);
        this.tag(FACoatTypeTags.NON_LEGACY_CRYOLOPHOSAURUS).add(FACoatTypes.CRYOLOPHOSAURUS);
        this.tag(FACoatTypeTags.DILOPHOSAURUS).add(FACoatTypes.DILOPHOSAURUS, FACoatTypes.LEGACY_DILOPHOSAURUS);
        this.tag(FACoatTypeTags.NON_LEGACY_DILOPHOSAURUS).add(FACoatTypes.DILOPHOSAURUS);
        this.tag(FACoatTypeTags.DODO).add(FACoatTypes.DODO);
        this.tag(FACoatTypeTags.DIMETRODON).add(FACoatTypes.DIMETRODON);
        this.tag(FACoatTypeTags.FUTABASAURUS).add(FACoatTypes.FUTABASAURUS, FACoatTypes.LEGACY_FUTABASAURUS);
        this.tag(FACoatTypeTags.NON_LEGACY_FUTABASAURUS).add(FACoatTypes.FUTABASAURUS);
        this.tag(FACoatTypeTags.GALLIMIMUS).add(FACoatTypes.GALLIMIMUS);
        this.tag(FACoatTypeTags.LEGACY).add(FACoatTypes.LEGACY_BRACHIOSAURUS, FACoatTypes.LEGACY_GREEN_CARNOTAURUS, FACoatTypes.LEGACY_RED_CARNOTAURUS, FACoatTypes.LEGACY_CRYOLOPHOSAURUS, FACoatTypes.LEGACY_DILOPHOSAURUS, FACoatTypes.LEGACY_FUTABASAURUS, FACoatTypes.LEGACY_MAMMOTH, FACoatTypes.LEGACY_MOSASAURUS, FACoatTypes.LEGACY_PTERANODON, FACoatTypes.LEGACY_SMILODON, FACoatTypes.LEGACY_STEGOSAURUS, FACoatTypes.LEGACY_FEATHERED_THERIZINOSAURUS, FACoatTypes.LEGACY_FEATHERLESS_THERIZINOSAURUS, FACoatTypes.LEGACY_GREEN_TRICERATOPS, FACoatTypes.LEGACY_BROWN_TRICERATOPS, FACoatTypes.LEGACY_TYRANNOSAURUS, FACoatTypes.LEGACY_GREEN_VELOCIRAPTOR, FACoatTypes.LEGACY_SANDY_VELOCIRAPTOR, FACoatTypes.LEGACY_WHITE_VELOCIRAPTOR);
        this.tag(FACoatTypeTags.MAMMOTH).add(FACoatTypes.MAMMOTH, FACoatTypes.LEGACY_MAMMOTH);
        this.tag(FACoatTypeTags.NON_LEGACY_MAMMOTH).add(FACoatTypes.MAMMOTH);
        this.tag(FACoatTypeTags.MOA).add(FACoatTypes.MOA);
        this.tag(FACoatTypeTags.MOSASAURUS).add(FACoatTypes.MOSASAURUS, FACoatTypes.LEGACY_MOSASAURUS);
        this.tag(FACoatTypeTags.NON_LEGACY_MOSASAURUS).add(FACoatTypes.MOSASAURUS);
        this.tag(FACoatTypeTags.PACHYCEPHALOSAURUS).add(FACoatTypes.PACHYCEPHALOSAURUS);
        this.tag(FACoatTypeTags.PTERANODON).add(FACoatTypes.PTERANODON, FACoatTypes.LEGACY_PTERANODON);
        this.tag(FACoatTypeTags.NON_LEGACY_PTERANODON).add(FACoatTypes.PTERANODON);
        this.tag(FACoatTypeTags.SMILODON).add(FACoatTypes.SMILODON, FACoatTypes.LEGACY_SMILODON);
        this.tag(FACoatTypeTags.NON_LEGACY_SMILODON).add(FACoatTypes.SMILODON);
        this.tag(FACoatTypeTags.SPINOSAURUS).add(FACoatTypes.SPINOSAURUS);
        this.tag(FACoatTypeTags.STEGOSAURUS).add(FACoatTypes.STEGOSAURUS, FACoatTypes.LEGACY_STEGOSAURUS);
        this.tag(FACoatTypeTags.NON_LEGACY_STEGOSAURUS).add(FACoatTypes.STEGOSAURUS);
        this.tag(FACoatTypeTags.THERIZINOSAURUS).add(FACoatTypes.THERIZINOSAURUS, FACoatTypes.LEGACY_FEATHERED_THERIZINOSAURUS, FACoatTypes.LEGACY_FEATHERLESS_THERIZINOSAURUS);
        this.tag(FACoatTypeTags.NON_LEGACY_THERIZINOSAURUS).add(FACoatTypes.THERIZINOSAURUS);
        this.tag(FACoatTypeTags.TRICERATOPS).add(FACoatTypes.BROWN_TRICERATOPS, FACoatTypes.GREEN_TRICERATOPS, FACoatTypes.LEGACY_BROWN_TRICERATOPS, FACoatTypes.LEGACY_GREEN_TRICERATOPS);
        this.tag(FACoatTypeTags.NON_LEGACY_TRICERATOPS).add(FACoatTypes.BROWN_TRICERATOPS, FACoatTypes.GREEN_TRICERATOPS);
        this.tag(FACoatTypeTags.TYRANNOSAURUS).add(FACoatTypes.TYRANNOSAURUS, FACoatTypes.LEGACY_TYRANNOSAURUS);
        this.tag(FACoatTypeTags.NON_LEGACY_TYRANNOSAURUS).add(FACoatTypes.TYRANNOSAURUS);
        this.tag(FACoatTypeTags.VELOCIRAPTOR).add(FACoatTypes.GREEN_VELOCIRAPTOR, FACoatTypes.SANDY_VELOCIRAPTOR, FACoatTypes.WHITE_VELOCIRAPTOR, FACoatTypes.LEGACY_GREEN_VELOCIRAPTOR, FACoatTypes.LEGACY_SANDY_VELOCIRAPTOR, FACoatTypes.LEGACY_WHITE_VELOCIRAPTOR);
        this.tag(FACoatTypeTags.LEGACY_VELOCIRAPTOR).add(FACoatTypes.LEGACY_GREEN_VELOCIRAPTOR, FACoatTypes.LEGACY_SANDY_VELOCIRAPTOR, FACoatTypes.LEGACY_WHITE_VELOCIRAPTOR);
        this.tag(FACoatTypeTags.NON_LEGACY_VELOCIRAPTOR).add(FACoatTypes.GREEN_VELOCIRAPTOR, FACoatTypes.SANDY_VELOCIRAPTOR, FACoatTypes.WHITE_VELOCIRAPTOR);
    }
}
