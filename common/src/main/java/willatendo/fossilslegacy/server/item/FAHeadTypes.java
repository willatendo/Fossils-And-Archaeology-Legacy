package willatendo.fossilslegacy.server.item;

import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.util.StringRepresentable;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.CompositeTextureRules;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.FACompositeTextureRuleSources;
import willatendo.fossilslegacy.server.tags.FAModelGeneTags;

public enum FAHeadTypes implements StringRepresentable {
    ANKYLOSAURUS("ankylosaurus", FAModelGeneTags.ANKYLOSAURUS, FACompositeTextureRuleSources.ANKYLOSAURUS_SKIN, FACompositeTextureRuleSources.ANKYLOSAURUS_PATTERN),
    BARYONYX("baryonyx", FAModelGeneTags.BARYONYX, FACompositeTextureRuleSources.BARYONYX_SKIN, FACompositeTextureRuleSources.BARYONYX_PATTERN),
    BRACHIOSAURUS("brachiosaurus", FAModelGeneTags.BRACHIOSAURUS, FACompositeTextureRuleSources.BRACHIOSAURUS_SKIN, FACompositeTextureRuleSources.BRACHIOSAURUS_PATTERN),
    CARNOTAURUS("carnotaurus", FAModelGeneTags.CARNOTAURUS, FACompositeTextureRuleSources.CARNOTAURUS_SKIN, FACompositeTextureRuleSources.CARNOTAURUS_PATTERN),
    COMPSOGNATHUS("compsognathus", FAModelGeneTags.COMPSOGNATHUS, FACompositeTextureRuleSources.COMPSOGNATHUS_SKIN, FACompositeTextureRuleSources.COMPSOGNATHUS_PATTERN),
    CRYOLOPHOSAURUS("cryolophosaurus", FAModelGeneTags.CRYOLOPHOSAURUS, FACompositeTextureRuleSources.CRYOLOPHOSAURUS_SKIN, FACompositeTextureRuleSources.CRYOLOPHOSAURUS_PATTERN),
    DILOPHOSAURUS("dilophosaurus", FAModelGeneTags.DILOPHOSAURUS, FACompositeTextureRuleSources.DILOPHOSAURUS_SKIN, FACompositeTextureRuleSources.DILOPHOSAURUS_PATTERN),
    DIMETRODON("dimetrodon", FAModelGeneTags.DIMETRODON, FACompositeTextureRuleSources.DIMETRODON_SKIN, FACompositeTextureRuleSources.DIMETRODON_PATTERN),
    DISTORTUS_REX("distortus_rex", FAModelGeneTags.DISTORTUS_REX, FACompositeTextureRuleSources.DISTORTUS_REX_SKIN, FACompositeTextureRuleSources.DISTORTUS_REX_PATTERN),
    DODO("dodo", FAModelGeneTags.DODO, FACompositeTextureRuleSources.DODO_SKIN, FACompositeTextureRuleSources.DODO_PATTERN),
    DRYOSAURUS("dryosaurus", FAModelGeneTags.DRYOSAURUS, FACompositeTextureRuleSources.DRYOSAURUS_SKIN, FACompositeTextureRuleSources.DRYOSAURUS_PATTERN),
    ELASMOTHERIUM("elasmotherium", FAModelGeneTags.ELASMOTHERIUM, FACompositeTextureRuleSources.ELASMOTHERIUM_SKIN, FACompositeTextureRuleSources.ELASMOTHERIUM_PATTERN),
    FUTABASAURUS("futabasaurus", FAModelGeneTags.FUTABASAURUS, FACompositeTextureRuleSources.FUTABASAURUS_SKIN, FACompositeTextureRuleSources.FUTABASAURUS_PATTERN),
    GALLIMIMUS("gallimimus", FAModelGeneTags.GALLIMIMUS, FACompositeTextureRuleSources.GALLIMIMUS_SKIN, FACompositeTextureRuleSources.GALLIMIMUS_PATTERN),
    ICHTHYOSAURUS("ichthyosaurus", FAModelGeneTags.ICHTHYOSAURUS, FACompositeTextureRuleSources.ICHTHYOSAURUS_SKIN, FACompositeTextureRuleSources.ICHTHYOSAURUS_PATTERN),
    MAMMOTH("mammoth", FAModelGeneTags.MAMMOTH, FACompositeTextureRuleSources.MAMMOTH_SKIN, FACompositeTextureRuleSources.MAMMOTH_PATTERN),
    MOA("moa", FAModelGeneTags.MOA, FACompositeTextureRuleSources.MOA_SKIN, FACompositeTextureRuleSources.MOA_PATTERN),
    MOSASAURUS("mosasaurus", FAModelGeneTags.MOSASAURUS, FACompositeTextureRuleSources.MOSASAURUS_SKIN, FACompositeTextureRuleSources.MOSASAURUS_PATTERN),
    PACHYCEPHALOSAURUS("pachycephalosaurus", FAModelGeneTags.PACHYCEPHALOSAURUS, FACompositeTextureRuleSources.PACHYCEPHALOSAURUS_SKIN, FACompositeTextureRuleSources.PACHYCEPHALOSAURUS_PATTERN),
    PTERANODON("pteranodon", FAModelGeneTags.PTERANODON, FACompositeTextureRuleSources.PTERANODON_SKIN, FACompositeTextureRuleSources.PTERANODON_PATTERN),
    SMILODON("smilodon", FAModelGeneTags.SMILODON, FACompositeTextureRuleSources.SMILODON_SKIN, FACompositeTextureRuleSources.SMILODON_PATTERN),
    SPINOSAURUS("spinosaurus", FAModelGeneTags.SPINOSAURUS, FACompositeTextureRuleSources.SPINOSAURUS_SKIN, FACompositeTextureRuleSources.SPINOSAURUS_PATTERN),
    STEGOSAURUS("stegosaurus", FAModelGeneTags.STEGOSAURUS, FACompositeTextureRuleSources.STEGOSAURUS_SKIN, FACompositeTextureRuleSources.STEGOSAURUS_PATTERN),
    THERIZINOSAURUS("therizinosaurus", FAModelGeneTags.THERIZINOSAURUS, FACompositeTextureRuleSources.THERIZINOSAURUS_SKIN, FACompositeTextureRuleSources.THERIZINOSAURUS_PATTERN),
    TRICERATOPS("triceratops", FAModelGeneTags.TRICERATOPS, FACompositeTextureRuleSources.TRICERATOPS_SKIN, FACompositeTextureRuleSources.TRICERATOPS_PATTERN),
    TYRANNOSAURUS("tyrannosaurus", FAModelGeneTags.TYRANNOSAURUS, FACompositeTextureRuleSources.TYRANNOSAURUS_SKIN, FACompositeTextureRuleSources.TYRANNOSAURUS_PATTERN),
    VELOCIRAPTOR("velociraptor", FAModelGeneTags.VELOCIRAPTOR, FACompositeTextureRuleSources.VELOCIRAPTOR_SKIN, FACompositeTextureRuleSources.VELOCIRAPTOR_PATTERN);

    public static final Codec<FAHeadTypes> CODEC = StringRepresentable.fromValues(FAHeadTypes::values);

    private final String name;
    private final TagKey<ModelGene> applicableModelGenes;
    private final ResourceKey<CompositeTextureRules.RuleSource> skinCompositeTextureRuleSource;
    private final ResourceKey<CompositeTextureRules.RuleSource> patternCompositeTextureRuleSource;

    FAHeadTypes(String name, TagKey<ModelGene> applicableModelGenes, ResourceKey<CompositeTextureRules.RuleSource> skinCompositeTextureRuleSource, ResourceKey<CompositeTextureRules.RuleSource> patternCompositeTextureRuleSource) {
        this.name = name;
        this.applicableModelGenes = applicableModelGenes;
        this.skinCompositeTextureRuleSource = skinCompositeTextureRuleSource;
        this.patternCompositeTextureRuleSource = patternCompositeTextureRuleSource;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    public TagKey<ModelGene> getApplicableModelGenes() {
        return this.applicableModelGenes;
    }

    public ResourceKey<CompositeTextureRules.RuleSource> getSkinCompositeTextureRuleSource() {
        return this.skinCompositeTextureRuleSource;
    }

    public ResourceKey<CompositeTextureRules.RuleSource> getPatternCompositeTextureRuleSource() {
        return this.patternCompositeTextureRuleSource;
    }
}
