package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import willatendo.fossilslegacy.server.gene.cosmetics.FAPatternGenes;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAPatternTags;

import java.util.concurrent.CompletableFuture;

public class FAPatternTagProvider extends DataDrivenTagsProvider<PatternGene> {
    public FAPatternTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, FARegistries.PATTERN_GENE, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FAPatternTags.ANKYLOSAURUS_2024_PATTERNS).add(FAPatternGenes.BLANK, FAPatternGenes.CHALCORANA, FAPatternGenes.LITHOBATES, FAPatternGenes.PAPURANA, FAPatternGenes.PELOPHYLAX, FAPatternGenes.PULCHRANA, FAPatternGenes.RANA);
        this.tag(FAPatternTags.BARYONYX_2025_PATTERNS);
        this.tag(FAPatternTags.BRACHIOSAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.BRACHIOSAURUS_2011_PATTERNS);
        this.tag(FAPatternTags.CARNOTAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.CARNOTAURUS_2011_PATTERNS);
        this.tag(FAPatternTags.COMPSOGNATHUS_2024_PATTERNS);
        this.tag(FAPatternTags.CRYOLOPHOSAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.CRYOLOPHOSAURUS_2011_PATTERNS);
        this.tag(FAPatternTags.DILOPHOSAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.DILOPHOSAURUS_2011_PATTERNS);
        this.tag(FAPatternTags.DODO_2024_PATTERNS);
        this.tag(FAPatternTags.DRYOSAURUS_2025_PATTERNS);
        this.tag(FAPatternTags.DIMETRODON_2024_PATTERNS);
        this.tag(FAPatternTags.DISTORTUS_REX_2025_PATTERNS);
        this.tag(FAPatternTags.ELASMOTHERIUM_2025_PATTERNS);
        this.tag(FAPatternTags.FUTABASAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.FUTABASAURUS_2011_PATTERNS);
        this.tag(FAPatternTags.GALLIMIMUS_2024_PATTERNS);
        this.tag(FAPatternTags.ICHTHYOSAURUS_2025_PATTERNS);
        this.tag(FAPatternTags.ISOTELUS_2025_PATTERNS);
        this.tag(FAPatternTags.ISOTELUS_LARVA_2025_PATTERNS);
        this.tag(FAPatternTags.MAMMOTH_2024_PATTERNS);
        this.tag(FAPatternTags.MAMMOTH_2011_PATTERNS);
        this.tag(FAPatternTags.MOA_2024_PATTERNS);
        this.tag(FAPatternTags.MOSASAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.MOSASAURUS_2011_PATTERNS);
        this.tag(FAPatternTags.PACHYCEPHALOSAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.PTERANODON_2024_PATTERNS);
        this.tag(FAPatternTags.PTERANODON_2011_PATTERNS);
        this.tag(FAPatternTags.SMILODON_2024_PATTERNS);
        this.tag(FAPatternTags.SMILODON_2011_PATTERNS);
        this.tag(FAPatternTags.SPINOSAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.STEGOSAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.STEGOSAURUS_2011_PATTERNS);
        this.tag(FAPatternTags.THERIZINOSAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.THERIZINOSAURUS_2011_PATTERNS);
        this.tag(FAPatternTags.TRICERATOPS_2024_PATTERNS);
        this.tag(FAPatternTags.TRICERATOPS_2011_PATTERNS);
        this.tag(FAPatternTags.TYRANNOSAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.TYRANNOSAURUS_2011_PATTERNS);
        this.tag(FAPatternTags.VELOCIRAPTOR_2024_PATTERNS);
        this.tag(FAPatternTags.VELOCIRAPTOR_2011_PATTERNS);
    }
}
