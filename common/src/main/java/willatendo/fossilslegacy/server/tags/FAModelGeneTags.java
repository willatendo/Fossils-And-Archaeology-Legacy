package willatendo.fossilslegacy.server.tags;

import net.minecraft.tags.TagKey;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FAModelGeneTags {
    private static final TagRegister<ModelGene> MODEL_GENE_TAGS = TagRegister.create(FARegistries.MODEL_GENE, FAUtils.ID);

    public static final TagKey<ModelGene> LOCKED = MODEL_GENE_TAGS.register("locked");

    public static final TagKey<ModelGene> ANKYLOSAURUS = MODEL_GENE_TAGS.register("ankylosaurus");
    public static final TagKey<ModelGene> BARYONYX = MODEL_GENE_TAGS.register("baryonyx");
    public static final TagKey<ModelGene> BRACHIOSAURUS = MODEL_GENE_TAGS.register("brachiosaurus");
    public static final TagKey<ModelGene> NON_LEGACY_BRACHIOSAURUS = MODEL_GENE_TAGS.register("non_legacy/brachiosaurus");
    public static final TagKey<ModelGene> CARNOTAURUS = MODEL_GENE_TAGS.register("carnotaurus");
    public static final TagKey<ModelGene> NON_LEGACY_CARNOTAURUS = MODEL_GENE_TAGS.register("non_legacy/carnotaurus");
    public static final TagKey<ModelGene> COMPSOGNATHUS = MODEL_GENE_TAGS.register("compsognathus");
    public static final TagKey<ModelGene> CRYOLOPHOSAURUS = MODEL_GENE_TAGS.register("cryolophosaurus");
    public static final TagKey<ModelGene> NON_LEGACY_CRYOLOPHOSAURUS = MODEL_GENE_TAGS.register("non_legacy/cryolophosaurus");
    public static final TagKey<ModelGene> DILOPHOSAURUS = MODEL_GENE_TAGS.register("dilophosaurus");
    public static final TagKey<ModelGene> NON_LEGACY_DILOPHOSAURUS = MODEL_GENE_TAGS.register("non_legacy/dilophosaurus");
    public static final TagKey<ModelGene> DIMETRODON = MODEL_GENE_TAGS.register("dimetrodon");
    public static final TagKey<ModelGene> DISTORTUS_REX = MODEL_GENE_TAGS.register("distortus_rex");
    public static final TagKey<ModelGene> DODO = MODEL_GENE_TAGS.register("dodo");
    public static final TagKey<ModelGene> DRYOSAURUS = MODEL_GENE_TAGS.register("dryosaurus");
    public static final TagKey<ModelGene> ELASMOTHERIUM = MODEL_GENE_TAGS.register("elasmotherium");
    public static final TagKey<ModelGene> FUTABASAURUS = MODEL_GENE_TAGS.register("futabasaurus");
    public static final TagKey<ModelGene> NON_LEGACY_FUTABASAURUS = MODEL_GENE_TAGS.register("non_legacy/futabasaurus");
    public static final TagKey<ModelGene> GALLIMIMUS = MODEL_GENE_TAGS.register("gallimimus");
    public static final TagKey<ModelGene> ICHTHYOSAURUS = MODEL_GENE_TAGS.register("ichthyosaurus");
    public static final TagKey<ModelGene> ISOTELUS = MODEL_GENE_TAGS.register("isotelus");
    public static final TagKey<ModelGene> ISOTELUS_LARVA = MODEL_GENE_TAGS.register("isotelus_larva");
    public static final TagKey<ModelGene> LEGACY = MODEL_GENE_TAGS.register("legacy");
    public static final TagKey<ModelGene> MAMMOTH = MODEL_GENE_TAGS.register("mammoth");
    public static final TagKey<ModelGene> NON_LEGACY_MAMMOTH = MODEL_GENE_TAGS.register("non_legacy/mammoth");
    public static final TagKey<ModelGene> MOA = MODEL_GENE_TAGS.register("moa");
    public static final TagKey<ModelGene> MOSASAURUS = MODEL_GENE_TAGS.register("mosasaurus");
    public static final TagKey<ModelGene> NON_LEGACY_MOSASAURUS = MODEL_GENE_TAGS.register("non_legacy/mosasaurus");
    public static final TagKey<ModelGene> PACHYCEPHALOSAURUS = MODEL_GENE_TAGS.register("pachycephalosaurus");
    public static final TagKey<ModelGene> PTERANODON = MODEL_GENE_TAGS.register("pteranodon");
    public static final TagKey<ModelGene> NON_LEGACY_PTERANODON = MODEL_GENE_TAGS.register("non_legacy/pteranodon");
    public static final TagKey<ModelGene> SMILODON = MODEL_GENE_TAGS.register("smilodon");
    public static final TagKey<ModelGene> NON_LEGACY_SMILODON = MODEL_GENE_TAGS.register("non_legacy/smilodon");
    public static final TagKey<ModelGene> SPINOSAURUS = MODEL_GENE_TAGS.register("spinosaurus");
    public static final TagKey<ModelGene> STEGOSAURUS = MODEL_GENE_TAGS.register("stegosaurus");
    public static final TagKey<ModelGene> NON_LEGACY_STEGOSAURUS = MODEL_GENE_TAGS.register("non_legacy/stegosaurus");
    public static final TagKey<ModelGene> THERIZINOSAURUS = MODEL_GENE_TAGS.register("therizinosaurus");
    public static final TagKey<ModelGene> NON_LEGACY_THERIZINOSAURUS = MODEL_GENE_TAGS.register("non_legacy/therizinosaurus");
    public static final TagKey<ModelGene> TRICERATOPS = MODEL_GENE_TAGS.register("triceratops");
    public static final TagKey<ModelGene> NON_LEGACY_TRICERATOPS = MODEL_GENE_TAGS.register("non_legacy/triceratops");
    public static final TagKey<ModelGene> TYRANNOSAURUS = MODEL_GENE_TAGS.register("tyrannosaurus");
    public static final TagKey<ModelGene> NON_LEGACY_TYRANNOSAURUS = MODEL_GENE_TAGS.register("non_legacy/tyrannosaurus");
    public static final TagKey<ModelGene> VELOCIRAPTOR = MODEL_GENE_TAGS.register("velociraptor");
    public static final TagKey<ModelGene> LEGACY_VELOCIRAPTOR = MODEL_GENE_TAGS.register("legacy_velociraptor");
    public static final TagKey<ModelGene> NON_LEGACY_VELOCIRAPTOR = MODEL_GENE_TAGS.register("non_legacy/velociraptor");
}
