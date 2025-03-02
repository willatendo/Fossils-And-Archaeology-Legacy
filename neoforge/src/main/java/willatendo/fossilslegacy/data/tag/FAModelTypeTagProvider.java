package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.model_type.FAModelTypes;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAModelTypeTags;

import java.util.concurrent.CompletableFuture;

public class FAModelTypeTagProvider extends DataDrivenTagsProvider<ModelType> {
    public FAModelTypeTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, FARegistries.MODEL_TYPES, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FAModelTypeTags.ANKYLOSAURUS).add(FAModelTypes.ANKYLOSAURUS);
        this.tag(FAModelTypeTags.BRACHIOSAURUS).add(FAModelTypes.BRACHIOSAURUS, FAModelTypes.LEGACY_BRACHIOSAURUS);
        this.tag(FAModelTypeTags.NON_LEGACY_BRACHIOSAURUS).add(FAModelTypes.BRACHIOSAURUS);
        this.tag(FAModelTypeTags.CARNOTAURUS).add(FAModelTypes.CARNOTAURUS, FAModelTypes.RED_CARNOTAURUS, FAModelTypes.LEGACY_CARNOTAURUS, FAModelTypes.LEGACY_RED_CARNOTAURUS);
        this.tag(FAModelTypeTags.NON_LEGACY_CARNOTAURUS).add(FAModelTypes.CARNOTAURUS, FAModelTypes.RED_CARNOTAURUS);
        this.tag(FAModelTypeTags.COMPSOGNATHUS).add(FAModelTypes.COMPSOGNATHUS);
        this.tag(FAModelTypeTags.CRYOLOPHOSAURUS).add(FAModelTypes.CRYOLOPHOSAURUS, FAModelTypes.LEGACY_CRYOLOPHOSAURUS);
        this.tag(FAModelTypeTags.NON_LEGACY_CRYOLOPHOSAURUS).add(FAModelTypes.CRYOLOPHOSAURUS);
        this.tag(FAModelTypeTags.DILOPHOSAURUS).add(FAModelTypes.DILOPHOSAURUS, FAModelTypes.LEGACY_DILOPHOSAURUS);
        this.tag(FAModelTypeTags.NON_LEGACY_DILOPHOSAURUS).add(FAModelTypes.DILOPHOSAURUS);
        this.tag(FAModelTypeTags.DODO).add(FAModelTypes.DODO);
        this.tag(FAModelTypeTags.DIMETRODON).add(FAModelTypes.DIMETRODON);
        this.tag(FAModelTypeTags.FUTABASAURUS).add(FAModelTypes.FUTABASAURUS, FAModelTypes.LEGACY_FUTABASAURUS);
        this.tag(FAModelTypeTags.NON_LEGACY_FUTABASAURUS).add(FAModelTypes.FUTABASAURUS);
        this.tag(FAModelTypeTags.GALLIMIMUS).add(FAModelTypes.GALLIMIMUS);
        this.tag(FAModelTypeTags.ICHTHYOSAURUS).add(FAModelTypes.ICHTHYOSAURUS);
        this.tag(FAModelTypeTags.LEGACY).add(FAModelTypes.LEGACY_BRACHIOSAURUS, FAModelTypes.LEGACY_CARNOTAURUS, FAModelTypes.LEGACY_RED_CARNOTAURUS, FAModelTypes.LEGACY_CRYOLOPHOSAURUS, FAModelTypes.LEGACY_DILOPHOSAURUS, FAModelTypes.LEGACY_FUTABASAURUS, FAModelTypes.LEGACY_MAMMOTH, FAModelTypes.LEGACY_MOSASAURUS, FAModelTypes.LEGACY_PTERANODON, FAModelTypes.LEGACY_SMILODON, FAModelTypes.LEGACY_STEGOSAURUS, FAModelTypes.LEGACY_THERIZINOSAURUS, FAModelTypes.LEGACY_FEATHERLESS_THERIZINOSAURUS, FAModelTypes.LEGACY_TRICERATOPS, FAModelTypes.LEGACY_BROWN_TRICERATOPS, FAModelTypes.LEGACY_TYRANNOSAURUS, FAModelTypes.LEGACY_VELOCIRAPTOR, FAModelTypes.LEGACY_SANDY_VELOCIRAPTOR, FAModelTypes.LEGACY_WHITE_VELOCIRAPTOR);
        this.tag(FAModelTypeTags.MAMMOTH).add(FAModelTypes.MAMMOTH, FAModelTypes.LEGACY_MAMMOTH);
        this.tag(FAModelTypeTags.NON_LEGACY_MAMMOTH).add(FAModelTypes.MAMMOTH);
        this.tag(FAModelTypeTags.MOA).add(FAModelTypes.MOA);
        this.tag(FAModelTypeTags.MOSASAURUS).add(FAModelTypes.MOSASAURUS, FAModelTypes.LEGACY_MOSASAURUS);
        this.tag(FAModelTypeTags.NON_LEGACY_MOSASAURUS).add(FAModelTypes.MOSASAURUS);
        this.tag(FAModelTypeTags.PACHYCEPHALOSAURUS).add(FAModelTypes.PACHYCEPHALOSAURUS);
        this.tag(FAModelTypeTags.PTERANODON).add(FAModelTypes.PTERANODON, FAModelTypes.LEGACY_PTERANODON);
        this.tag(FAModelTypeTags.NON_LEGACY_PTERANODON).add(FAModelTypes.PTERANODON);
        this.tag(FAModelTypeTags.SMILODON).add(FAModelTypes.SMILODON, FAModelTypes.LEGACY_SMILODON);
        this.tag(FAModelTypeTags.NON_LEGACY_SMILODON).add(FAModelTypes.SMILODON);
        this.tag(FAModelTypeTags.SPINOSAURUS).add(FAModelTypes.SPINOSAURUS);
        this.tag(FAModelTypeTags.STEGOSAURUS).add(FAModelTypes.STEGOSAURUS, FAModelTypes.LEGACY_STEGOSAURUS);
        this.tag(FAModelTypeTags.NON_LEGACY_STEGOSAURUS).add(FAModelTypes.STEGOSAURUS);
        this.tag(FAModelTypeTags.THERIZINOSAURUS).add(FAModelTypes.THERIZINOSAURUS, FAModelTypes.LEGACY_THERIZINOSAURUS, FAModelTypes.LEGACY_FEATHERLESS_THERIZINOSAURUS);
        this.tag(FAModelTypeTags.NON_LEGACY_THERIZINOSAURUS).add(FAModelTypes.THERIZINOSAURUS);
        this.tag(FAModelTypeTags.TRICERATOPS).add(FAModelTypes.BROWN_TRICERATOPS, FAModelTypes.TRICERATOPS, FAModelTypes.LEGACY_BROWN_TRICERATOPS, FAModelTypes.LEGACY_TRICERATOPS);
        this.tag(FAModelTypeTags.NON_LEGACY_TRICERATOPS).add(FAModelTypes.BROWN_TRICERATOPS, FAModelTypes.TRICERATOPS);
        this.tag(FAModelTypeTags.TYRANNOSAURUS).add(FAModelTypes.TYRANNOSAURUS, FAModelTypes.LEGACY_TYRANNOSAURUS);
        this.tag(FAModelTypeTags.NON_LEGACY_TYRANNOSAURUS).add(FAModelTypes.TYRANNOSAURUS);
        this.tag(FAModelTypeTags.VELOCIRAPTOR).add(FAModelTypes.VELOCIRAPTOR, FAModelTypes.SANDY_VELOCIRAPTOR, FAModelTypes.WHITE_VELOCIRAPTOR, FAModelTypes.LEGACY_VELOCIRAPTOR, FAModelTypes.LEGACY_SANDY_VELOCIRAPTOR, FAModelTypes.LEGACY_WHITE_VELOCIRAPTOR);
        this.tag(FAModelTypeTags.LEGACY_VELOCIRAPTOR).add(FAModelTypes.LEGACY_VELOCIRAPTOR, FAModelTypes.LEGACY_SANDY_VELOCIRAPTOR, FAModelTypes.LEGACY_WHITE_VELOCIRAPTOR);
        this.tag(FAModelTypeTags.NON_LEGACY_VELOCIRAPTOR).add(FAModelTypes.VELOCIRAPTOR, FAModelTypes.SANDY_VELOCIRAPTOR, FAModelTypes.WHITE_VELOCIRAPTOR);
    }
}
