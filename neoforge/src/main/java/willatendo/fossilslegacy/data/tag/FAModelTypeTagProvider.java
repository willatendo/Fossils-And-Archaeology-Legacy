package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import willatendo.fossilslegacy.server.gene.cosmetics.FAModelGenes;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAModelTypeTags;

import java.util.concurrent.CompletableFuture;

public class FAModelTypeTagProvider extends DataDrivenTagsProvider<ModelGene> {
    public FAModelTypeTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, FARegistries.MODEL_GENE, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FAModelTypeTags.LOCKED).addTag(FAModelTypeTags.LEGACY);

        this.tag(FAModelTypeTags.ANKYLOSAURUS).add(FAModelGenes.ANKYLOSAURUS);
        this.tag(FAModelTypeTags.BARYONYX).add(FAModelGenes.BARYONYX);
        this.tag(FAModelTypeTags.BRACHIOSAURUS).add(FAModelGenes.BRACHIOSAURUS, FAModelGenes.LEGACY_BRACHIOSAURUS);
        this.tag(FAModelTypeTags.NON_LEGACY_BRACHIOSAURUS).add(FAModelGenes.BRACHIOSAURUS);
        this.tag(FAModelTypeTags.CARNOTAURUS).add(FAModelGenes.CARNOTAURUS, FAModelGenes.LEGACY_CARNOTAURUS);
        this.tag(FAModelTypeTags.NON_LEGACY_CARNOTAURUS).add(FAModelGenes.CARNOTAURUS);
        this.tag(FAModelTypeTags.COMPSOGNATHUS).add(FAModelGenes.COMPSOGNATHUS);
        this.tag(FAModelTypeTags.CRYOLOPHOSAURUS).add(FAModelGenes.CRYOLOPHOSAURUS, FAModelGenes.LEGACY_CRYOLOPHOSAURUS);
        this.tag(FAModelTypeTags.NON_LEGACY_CRYOLOPHOSAURUS).add(FAModelGenes.CRYOLOPHOSAURUS);
        this.tag(FAModelTypeTags.DILOPHOSAURUS).add(FAModelGenes.DILOPHOSAURUS, FAModelGenes.LEGACY_DILOPHOSAURUS);
        this.tag(FAModelTypeTags.NON_LEGACY_DILOPHOSAURUS).add(FAModelGenes.DILOPHOSAURUS);
        this.tag(FAModelTypeTags.DODO).add(FAModelGenes.DODO);
        this.tag(FAModelTypeTags.DIMETRODON).add(FAModelGenes.DIMETRODON);
        this.tag(FAModelTypeTags.DISTORTUS_REX).add(FAModelGenes.DISTORTUS_REX);
        this.tag(FAModelTypeTags.DRYOSAURUS).add(FAModelGenes.DRYOSAURUS);
        this.tag(FAModelTypeTags.ELASMOTHERIUM).add(FAModelGenes.ELASMOTHERIUM);
        this.tag(FAModelTypeTags.FUTABASAURUS).add(FAModelGenes.FUTABASAURUS, FAModelGenes.LEGACY_FUTABASAURUS);
        this.tag(FAModelTypeTags.NON_LEGACY_FUTABASAURUS).add(FAModelGenes.FUTABASAURUS);
        this.tag(FAModelTypeTags.GALLIMIMUS).add(FAModelGenes.GALLIMIMUS);
        this.tag(FAModelTypeTags.ICHTHYOSAURUS).add(FAModelGenes.ICHTHYOSAURUS);
        this.tag(FAModelTypeTags.ISOTELUS).add(FAModelGenes.ISOTELUS);
        this.tag(FAModelTypeTags.ISOTELUS_LARVA).add(FAModelGenes.ISOTELUS_LARVA);
        this.tag(FAModelTypeTags.LEGACY).add(FAModelGenes.LEGACY_BRACHIOSAURUS, FAModelGenes.LEGACY_CARNOTAURUS, FAModelGenes.LEGACY_CRYOLOPHOSAURUS, FAModelGenes.LEGACY_DILOPHOSAURUS, FAModelGenes.LEGACY_FUTABASAURUS, FAModelGenes.LEGACY_MAMMOTH, FAModelGenes.LEGACY_MOSASAURUS, FAModelGenes.LEGACY_PTERANODON, FAModelGenes.LEGACY_SMILODON, FAModelGenes.LEGACY_STEGOSAURUS, FAModelGenes.LEGACY_THERIZINOSAURUS, FAModelGenes.LEGACY_TRICERATOPS, FAModelGenes.LEGACY_TYRANNOSAURUS, FAModelGenes.LEGACY_VELOCIRAPTOR);
        this.tag(FAModelTypeTags.MAMMOTH).add(FAModelGenes.MAMMOTH, FAModelGenes.LEGACY_MAMMOTH);
        this.tag(FAModelTypeTags.NON_LEGACY_MAMMOTH).add(FAModelGenes.MAMMOTH);
        this.tag(FAModelTypeTags.MOA).add(FAModelGenes.MOA);
        this.tag(FAModelTypeTags.MOSASAURUS).add(FAModelGenes.MOSASAURUS, FAModelGenes.LEGACY_MOSASAURUS);
        this.tag(FAModelTypeTags.NON_LEGACY_MOSASAURUS).add(FAModelGenes.MOSASAURUS);
        this.tag(FAModelTypeTags.PACHYCEPHALOSAURUS).add(FAModelGenes.PACHYCEPHALOSAURUS);
        this.tag(FAModelTypeTags.PTERANODON).add(FAModelGenes.PTERANODON, FAModelGenes.LEGACY_PTERANODON);
        this.tag(FAModelTypeTags.NON_LEGACY_PTERANODON).add(FAModelGenes.PTERANODON);
        this.tag(FAModelTypeTags.SMILODON).add(FAModelGenes.SMILODON, FAModelGenes.LEGACY_SMILODON);
        this.tag(FAModelTypeTags.NON_LEGACY_SMILODON).add(FAModelGenes.SMILODON);
        this.tag(FAModelTypeTags.SPINOSAURUS).add(FAModelGenes.SPINOSAURUS);
        this.tag(FAModelTypeTags.STEGOSAURUS).add(FAModelGenes.STEGOSAURUS, FAModelGenes.LEGACY_STEGOSAURUS);
        this.tag(FAModelTypeTags.NON_LEGACY_STEGOSAURUS).add(FAModelGenes.STEGOSAURUS);
        this.tag(FAModelTypeTags.THERIZINOSAURUS).add(FAModelGenes.THERIZINOSAURUS, FAModelGenes.LEGACY_THERIZINOSAURUS);
        this.tag(FAModelTypeTags.NON_LEGACY_THERIZINOSAURUS).add(FAModelGenes.THERIZINOSAURUS);
        this.tag(FAModelTypeTags.TRICERATOPS).add(FAModelGenes.TRICERATOPS, FAModelGenes.LEGACY_TRICERATOPS);
        this.tag(FAModelTypeTags.NON_LEGACY_TRICERATOPS).add(FAModelGenes.TRICERATOPS);
        this.tag(FAModelTypeTags.TYRANNOSAURUS).add(FAModelGenes.TYRANNOSAURUS, FAModelGenes.LEGACY_TYRANNOSAURUS);
        this.tag(FAModelTypeTags.NON_LEGACY_TYRANNOSAURUS).add(FAModelGenes.TYRANNOSAURUS);
        this.tag(FAModelTypeTags.VELOCIRAPTOR).add(FAModelGenes.VELOCIRAPTOR, FAModelGenes.LEGACY_VELOCIRAPTOR);
        this.tag(FAModelTypeTags.LEGACY_VELOCIRAPTOR).add(FAModelGenes.LEGACY_VELOCIRAPTOR);
        this.tag(FAModelTypeTags.NON_LEGACY_VELOCIRAPTOR).add(FAModelGenes.VELOCIRAPTOR);
    }
}
