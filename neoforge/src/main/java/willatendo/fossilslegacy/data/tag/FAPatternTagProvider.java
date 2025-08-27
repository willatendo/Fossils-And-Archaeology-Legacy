package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import willatendo.fossilslegacy.server.gene.cosmetics.FAPatternGenes;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAPatternGeneTags;

import java.util.concurrent.CompletableFuture;

public class FAPatternTagProvider extends DataDrivenTagsProvider<PatternGene> {
    public FAPatternTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, FARegistries.PATTERN_GENE, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FAPatternGeneTags.ANKYLOSAURUS_2024_PATTERNS).add(FAPatternGenes.BLANK, FAPatternGenes.CHALCORANA, FAPatternGenes.LITHOBATES, FAPatternGenes.PAPURANA, FAPatternGenes.PELOPHYLAX, FAPatternGenes.PULCHRANA, FAPatternGenes.RANA);
        this.tag(FAPatternGeneTags.BARYONYX_2025_PATTERNS).add(FAPatternGenes.BLANK, FAPatternGenes.CHALCORANA, FAPatternGenes.LITHOBATES, FAPatternGenes.PAPURANA, FAPatternGenes.PELOPHYLAX, FAPatternGenes.PULCHRANA, FAPatternGenes.RANA);
        this.tag(FAPatternGeneTags.BRACHIOSAURUS_2024_PATTERNS);
        this.tag(FAPatternGeneTags.BRACHIOSAURUS_2011_PATTERNS);
        this.tag(FAPatternGeneTags.CARNOTAURUS_2024_PATTERNS);
        this.tag(FAPatternGeneTags.CARNOTAURUS_2011_PATTERNS);
        this.tag(FAPatternGeneTags.COMPSOGNATHUS_2024_PATTERNS);
        this.tag(FAPatternGeneTags.CRYOLOPHOSAURUS_2024_PATTERNS);
        this.tag(FAPatternGeneTags.CRYOLOPHOSAURUS_2011_PATTERNS);
        this.tag(FAPatternGeneTags.DILOPHOSAURUS_2024_PATTERNS);
        this.tag(FAPatternGeneTags.DILOPHOSAURUS_2011_PATTERNS);
        this.tag(FAPatternGeneTags.DODO_2024_PATTERNS);
        this.tag(FAPatternGeneTags.DRYOSAURUS_2025_PATTERNS);
        this.tag(FAPatternGeneTags.DIMETRODON_2024_PATTERNS);
        this.tag(FAPatternGeneTags.DISTORTUS_REX_2025_PATTERNS);
        this.tag(FAPatternGeneTags.ELASMOTHERIUM_2025_PATTERNS);
        this.tag(FAPatternGeneTags.FUTABASAURUS_2024_PATTERNS);
        this.tag(FAPatternGeneTags.FUTABASAURUS_2011_PATTERNS);
        this.tag(FAPatternGeneTags.GALLIMIMUS_2024_PATTERNS);
        this.tag(FAPatternGeneTags.ICHTHYOSAURUS_2025_PATTERNS);
        this.tag(FAPatternGeneTags.ISOTELUS_2025_PATTERNS);
        this.tag(FAPatternGeneTags.ISOTELUS_LARVA_2025_PATTERNS);
        this.tag(FAPatternGeneTags.MAMMOTH_2024_PATTERNS);
        this.tag(FAPatternGeneTags.MAMMOTH_2011_PATTERNS);
        this.tag(FAPatternGeneTags.MOA_2024_PATTERNS);
        this.tag(FAPatternGeneTags.MOSASAURUS_2024_PATTERNS);
        this.tag(FAPatternGeneTags.MOSASAURUS_2011_PATTERNS);
        this.tag(FAPatternGeneTags.PACHYCEPHALOSAURUS_2024_PATTERNS);
        this.tag(FAPatternGeneTags.PTERANODON_2024_PATTERNS);
        this.tag(FAPatternGeneTags.PTERANODON_2011_PATTERNS);
        this.tag(FAPatternGeneTags.SMILODON_2024_PATTERNS);
        this.tag(FAPatternGeneTags.SMILODON_2011_PATTERNS);
        this.tag(FAPatternGeneTags.SPINOSAURUS_2024_PATTERNS);
        this.tag(FAPatternGeneTags.STEGOSAURUS_2024_PATTERNS);
        this.tag(FAPatternGeneTags.STEGOSAURUS_2011_PATTERNS);
        this.tag(FAPatternGeneTags.THERIZINOSAURUS_2024_PATTERNS);
        this.tag(FAPatternGeneTags.THERIZINOSAURUS_2011_PATTERNS);
        this.tag(FAPatternGeneTags.TRICERATOPS_2024_PATTERNS);
        this.tag(FAPatternGeneTags.TRICERATOPS_2011_PATTERNS);
        this.tag(FAPatternGeneTags.TYRANNOSAURUS_2024_PATTERNS);
        this.tag(FAPatternGeneTags.TYRANNOSAURUS_2011_PATTERNS);
        this.tag(FAPatternGeneTags.VELOCIRAPTOR_2024_PATTERNS);
        this.tag(FAPatternGeneTags.VELOCIRAPTOR_2011_PATTERNS);
    }
}
