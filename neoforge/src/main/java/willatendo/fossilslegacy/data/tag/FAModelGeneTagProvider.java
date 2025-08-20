package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import willatendo.fossilslegacy.server.gene.cosmetics.FAModelGenes;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAModelGeneTags;

import java.util.concurrent.CompletableFuture;

public class FAModelGeneTagProvider extends DataDrivenTagsProvider<ModelGene> {
    public FAModelGeneTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, FARegistries.MODEL_GENE, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FAModelGeneTags.LOCKED).addTag(FAModelGeneTags.LEGACY);

        this.tag(FAModelGeneTags.ANKYLOSAURUS).add(FAModelGenes.ANKYLOSAURUS);
        this.tag(FAModelGeneTags.BARYONYX).add(FAModelGenes.BARYONYX);
        this.tag(FAModelGeneTags.BRACHIOSAURUS).add(FAModelGenes.BRACHIOSAURUS, FAModelGenes.LEGACY_BRACHIOSAURUS);
        this.tag(FAModelGeneTags.NON_LEGACY_BRACHIOSAURUS).add(FAModelGenes.BRACHIOSAURUS);
        this.tag(FAModelGeneTags.CARNOTAURUS).add(FAModelGenes.CARNOTAURUS, FAModelGenes.LEGACY_CARNOTAURUS);
        this.tag(FAModelGeneTags.NON_LEGACY_CARNOTAURUS).add(FAModelGenes.CARNOTAURUS);
        this.tag(FAModelGeneTags.COMPSOGNATHUS).add(FAModelGenes.COMPSOGNATHUS);
        this.tag(FAModelGeneTags.CRYOLOPHOSAURUS).add(FAModelGenes.CRYOLOPHOSAURUS, FAModelGenes.LEGACY_CRYOLOPHOSAURUS);
        this.tag(FAModelGeneTags.NON_LEGACY_CRYOLOPHOSAURUS).add(FAModelGenes.CRYOLOPHOSAURUS);
        this.tag(FAModelGeneTags.DILOPHOSAURUS).add(FAModelGenes.DILOPHOSAURUS, FAModelGenes.LEGACY_DILOPHOSAURUS);
        this.tag(FAModelGeneTags.NON_LEGACY_DILOPHOSAURUS).add(FAModelGenes.DILOPHOSAURUS);
        this.tag(FAModelGeneTags.DODO).add(FAModelGenes.DODO);
        this.tag(FAModelGeneTags.DIMETRODON).add(FAModelGenes.DIMETRODON);
        this.tag(FAModelGeneTags.DISTORTUS_REX).add(FAModelGenes.DISTORTUS_REX);
        this.tag(FAModelGeneTags.DRYOSAURUS).add(FAModelGenes.DRYOSAURUS);
        this.tag(FAModelGeneTags.ELASMOTHERIUM).add(FAModelGenes.ELASMOTHERIUM);
        this.tag(FAModelGeneTags.FUTABASAURUS).add(FAModelGenes.FUTABASAURUS, FAModelGenes.LEGACY_FUTABASAURUS);
        this.tag(FAModelGeneTags.NON_LEGACY_FUTABASAURUS).add(FAModelGenes.FUTABASAURUS);
        this.tag(FAModelGeneTags.GALLIMIMUS).add(FAModelGenes.GALLIMIMUS);
        this.tag(FAModelGeneTags.ICHTHYOSAURUS).add(FAModelGenes.ICHTHYOSAURUS);
        this.tag(FAModelGeneTags.ISOTELUS).add(FAModelGenes.ISOTELUS);
        this.tag(FAModelGeneTags.ISOTELUS_LARVA).add(FAModelGenes.ISOTELUS_LARVA);
        this.tag(FAModelGeneTags.LEGACY).add(FAModelGenes.LEGACY_BRACHIOSAURUS, FAModelGenes.LEGACY_CARNOTAURUS, FAModelGenes.LEGACY_CRYOLOPHOSAURUS, FAModelGenes.LEGACY_DILOPHOSAURUS, FAModelGenes.LEGACY_FUTABASAURUS, FAModelGenes.LEGACY_MAMMOTH, FAModelGenes.LEGACY_MOSASAURUS, FAModelGenes.LEGACY_PTERANODON, FAModelGenes.LEGACY_SMILODON, FAModelGenes.LEGACY_STEGOSAURUS, FAModelGenes.LEGACY_THERIZINOSAURUS, FAModelGenes.LEGACY_TRICERATOPS, FAModelGenes.LEGACY_TYRANNOSAURUS, FAModelGenes.LEGACY_VELOCIRAPTOR);
        this.tag(FAModelGeneTags.MAMMOTH).add(FAModelGenes.MAMMOTH, FAModelGenes.LEGACY_MAMMOTH);
        this.tag(FAModelGeneTags.NON_LEGACY_MAMMOTH).add(FAModelGenes.MAMMOTH);
        this.tag(FAModelGeneTags.MOA).add(FAModelGenes.MOA);
        this.tag(FAModelGeneTags.MOSASAURUS).add(FAModelGenes.MOSASAURUS, FAModelGenes.LEGACY_MOSASAURUS);
        this.tag(FAModelGeneTags.NON_LEGACY_MOSASAURUS).add(FAModelGenes.MOSASAURUS);
        this.tag(FAModelGeneTags.PACHYCEPHALOSAURUS).add(FAModelGenes.PACHYCEPHALOSAURUS);
        this.tag(FAModelGeneTags.PTERANODON).add(FAModelGenes.PTERANODON, FAModelGenes.LEGACY_PTERANODON);
        this.tag(FAModelGeneTags.NON_LEGACY_PTERANODON).add(FAModelGenes.PTERANODON);
        this.tag(FAModelGeneTags.SMILODON).add(FAModelGenes.SMILODON, FAModelGenes.LEGACY_SMILODON);
        this.tag(FAModelGeneTags.NON_LEGACY_SMILODON).add(FAModelGenes.SMILODON);
        this.tag(FAModelGeneTags.SPINOSAURUS).add(FAModelGenes.SPINOSAURUS);
        this.tag(FAModelGeneTags.STEGOSAURUS).add(FAModelGenes.STEGOSAURUS, FAModelGenes.LEGACY_STEGOSAURUS);
        this.tag(FAModelGeneTags.NON_LEGACY_STEGOSAURUS).add(FAModelGenes.STEGOSAURUS);
        this.tag(FAModelGeneTags.THERIZINOSAURUS).add(FAModelGenes.THERIZINOSAURUS, FAModelGenes.LEGACY_THERIZINOSAURUS);
        this.tag(FAModelGeneTags.NON_LEGACY_THERIZINOSAURUS).add(FAModelGenes.THERIZINOSAURUS);
        this.tag(FAModelGeneTags.TRICERATOPS).add(FAModelGenes.TRICERATOPS, FAModelGenes.LEGACY_TRICERATOPS);
        this.tag(FAModelGeneTags.NON_LEGACY_TRICERATOPS).add(FAModelGenes.TRICERATOPS);
        this.tag(FAModelGeneTags.TYRANNOSAURUS).add(FAModelGenes.TYRANNOSAURUS, FAModelGenes.LEGACY_TYRANNOSAURUS);
        this.tag(FAModelGeneTags.NON_LEGACY_TYRANNOSAURUS).add(FAModelGenes.TYRANNOSAURUS);
        this.tag(FAModelGeneTags.VELOCIRAPTOR).add(FAModelGenes.VELOCIRAPTOR, FAModelGenes.LEGACY_VELOCIRAPTOR);
        this.tag(FAModelGeneTags.LEGACY_VELOCIRAPTOR).add(FAModelGenes.LEGACY_VELOCIRAPTOR);
        this.tag(FAModelGeneTags.NON_LEGACY_VELOCIRAPTOR).add(FAModelGenes.VELOCIRAPTOR);
    }
}
