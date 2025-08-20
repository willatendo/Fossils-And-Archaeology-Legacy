package willatendo.fossilslegacy.server.tags;

import net.minecraft.tags.TagKey;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FASkinTags {
    private static final TagRegister<SkinGene> SKIN_TAGS = TagRegister.create(FARegistries.SKIN_GENE, FAUtils.ID);

    public static final TagKey<SkinGene> LOCKED = SKIN_TAGS.register("locked");
    public static final TagKey<SkinGene> HAS_PATTERNS = SKIN_TAGS.register("has_patterns");

    public static final TagKey<SkinGene> ANKYLOSAURUS_2024_SKINS = SKIN_TAGS.register("ankylosaurus_2024");
    public static final TagKey<SkinGene> BARYONYX_2025_SKINS = SKIN_TAGS.register("baryonyx_2025");
    public static final TagKey<SkinGene> BRACHIOSAURUS_2024_SKINS = SKIN_TAGS.register("brachiosaurus_2024");
    public static final TagKey<SkinGene> BRACHIOSAURUS_2011_SKINS = SKIN_TAGS.register("brachiosaurus_2011");
    public static final TagKey<SkinGene> CARNOTAURUS_2024_SKINS = SKIN_TAGS.register("carnotaurus_2024");
    public static final TagKey<SkinGene> CARNOTAURUS_2011_SKINS = SKIN_TAGS.register("carnotaurus_2011");
    public static final TagKey<SkinGene> COMPSOGNATHUS_2024_SKINS = SKIN_TAGS.register("compsognathus_2024");
    public static final TagKey<SkinGene> CRYOLOPHOSAURUS_2024_SKINS = SKIN_TAGS.register("cryolophosaurus_2024");
    public static final TagKey<SkinGene> CRYOLOPHOSAURUS_2011_SKINS = SKIN_TAGS.register("cryolophosaurus_2011");
    public static final TagKey<SkinGene> DILOPHOSAURUS_2024_SKINS = SKIN_TAGS.register("dilophosaurus_2024");
    public static final TagKey<SkinGene> DILOPHOSAURUS_2011_SKINS = SKIN_TAGS.register("dilophosaurus_2011");
    public static final TagKey<SkinGene> DIMETRODON_2024_SKINS = SKIN_TAGS.register("dimetrodon_2024");
    public static final TagKey<SkinGene> DISTORTUS_REX_2025_SKINS = SKIN_TAGS.register("distortus_rex_2025");
    public static final TagKey<SkinGene> DODO_2024_SKINS = SKIN_TAGS.register("dodo_2024");
    public static final TagKey<SkinGene> DRYOSAURUS_2025_SKINS = SKIN_TAGS.register("dryosaurus_2025");
    public static final TagKey<SkinGene> ELASMOTHERIUM_2025_SKINS = SKIN_TAGS.register("elasmotherium_2025");
    public static final TagKey<SkinGene> FUTABASAURUS_2024_SKINS = SKIN_TAGS.register("futabasaurus_2024");
    public static final TagKey<SkinGene> FUTABASAURUS_2011_SKINS = SKIN_TAGS.register("futabasaurus_2011");
    public static final TagKey<SkinGene> GALLIMIMUS_2024_SKINS = SKIN_TAGS.register("gallimimus_2024");
    public static final TagKey<SkinGene> ICHTHYOSAURUS_2025_SKINS = SKIN_TAGS.register("ichthyosaurus_2025");
    public static final TagKey<SkinGene> ISOTELUS_2025_SKINS = SKIN_TAGS.register("isotelus_2025");
    public static final TagKey<SkinGene> ISOTELUS_LARVA_2025_SKINS = SKIN_TAGS.register("isotelus_larva_2025");
    public static final TagKey<SkinGene> MAMMOTH_2024_SKINS = SKIN_TAGS.register("mammoth_2024");
    public static final TagKey<SkinGene> MAMMOTH_2011_SKINS = SKIN_TAGS.register("mammoth_2011");
    public static final TagKey<SkinGene> MOA_2024_SKINS = SKIN_TAGS.register("moa_2024");
    public static final TagKey<SkinGene> MOSASAURUS_2024_SKINS = SKIN_TAGS.register("mosasaurus_2024");
    public static final TagKey<SkinGene> MOSASAURUS_2011_SKINS = SKIN_TAGS.register("mosasaurus_2011");
    public static final TagKey<SkinGene> PACHYCEPHALOSAURUS_2024_SKINS = SKIN_TAGS.register("pachycephalosaurus_2024");
    public static final TagKey<SkinGene> PTERANODON_2024_SKINS = SKIN_TAGS.register("pteranodon_2024");
    public static final TagKey<SkinGene> PTERANODON_2011_SKINS = SKIN_TAGS.register("pteranodon_2011");
    public static final TagKey<SkinGene> SMILODON_2024_SKINS = SKIN_TAGS.register("smilodon_2024");
    public static final TagKey<SkinGene> SMILODON_2011_SKINS = SKIN_TAGS.register("smilodon_2011");
    public static final TagKey<SkinGene> SPINOSAURUS_2024_SKINS = SKIN_TAGS.register("spinosaurus_2024");
    public static final TagKey<SkinGene> STEGOSAURUS_2024_SKINS = SKIN_TAGS.register("stegosaurus_2024");
    public static final TagKey<SkinGene> STEGOSAURUS_2011_SKINS = SKIN_TAGS.register("stegosaurus_2011");
    public static final TagKey<SkinGene> THERIZINOSAURUS_2024_SKINS = SKIN_TAGS.register("therizinosaurus_2024");
    public static final TagKey<SkinGene> THERIZINOSAURUS_2011_SKINS = SKIN_TAGS.register("therizinosaurus_2011");
    public static final TagKey<SkinGene> TRICERATOPS_2024_SKINS = SKIN_TAGS.register("triceratops_2024");
    public static final TagKey<SkinGene> TRICERATOPS_2011_SKINS = SKIN_TAGS.register("triceratops_2011");
    public static final TagKey<SkinGene> TYRANNOSAURUS_2024_SKINS = SKIN_TAGS.register("tyrannosaurus_2024");
    public static final TagKey<SkinGene> TYRANNOSAURUS_2011_SKINS = SKIN_TAGS.register("tyrannosaurus_2011");
    public static final TagKey<SkinGene> VELOCIRAPTOR_2024_SKINS = SKIN_TAGS.register("velociraptor_2024");
    public static final TagKey<SkinGene> VELOCIRAPTOR_2011_SKINS = SKIN_TAGS.register("velociraptor_2011");
}
