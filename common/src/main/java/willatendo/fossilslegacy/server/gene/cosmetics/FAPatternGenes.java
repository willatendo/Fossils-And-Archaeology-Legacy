package willatendo.fossilslegacy.server.gene.cosmetics;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.entity.FAEntityTypeReferences;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.CompositeTextureRules;
import willatendo.fossilslegacy.server.gene.inheritance.InheritanceRules;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FAPatternGenes {
    public static final ResourceKey<PatternGene> BLANK = FAPatternGenes.create("blank");
    public static final ResourceKey<PatternGene> CHALCORANA = FAPatternGenes.create("chalcorana");
    public static final ResourceKey<PatternGene> LITHOBATES = FAPatternGenes.create("lithobates");
    public static final ResourceKey<PatternGene> PAPURANA = FAPatternGenes.create("papurana");
    public static final ResourceKey<PatternGene> PELOPHYLAX = FAPatternGenes.create("pelophylax");
    public static final ResourceKey<PatternGene> PULCHRANA = FAPatternGenes.create("pulchrana");
    public static final ResourceKey<PatternGene> RANA = FAPatternGenes.create("rana");

    private static ResourceKey<PatternGene> create(String name) {
        return ResourceKey.create(FARegistries.PATTERN_GENE, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<PatternGene> bootstrapContext, ResourceKey<PatternGene> resourceKey, PatternGene patternGene) {
        bootstrapContext.register(resourceKey, patternGene);
    }

    public static void bootstrap(BootstrapContext<PatternGene> bootstrapContext) {
        FAPatternGenes.register(bootstrapContext, BLANK, PatternGene.BLANK);
        FAPatternGenes.register(
                bootstrapContext,
                CHALCORANA,
                PatternGene.create(
                        FAUtils.translation("pattern_gene", "chalcorana"),
                        0x72A03C,
                        InheritanceRules.always(),
                        "chalcorana"
                )
        );
        FAPatternGenes.register(
                bootstrapContext, 
                LITHOBATES,
                PatternGene.create(
                        FAUtils.translation("pattern_gene", "lithobates"), 
                        0x38220B,
                        InheritanceRules.always(),
                        "lithobates"
                )
        );
        FAPatternGenes.register(
                bootstrapContext, 
                PAPURANA, 
                PatternGene.create(
                        FAUtils.translation("pattern_gene", "papurana"),
                        0xBD5F1C,
                        InheritanceRules.always(),
                        "papurana"
                )
        );
        FAPatternGenes.register(
                bootstrapContext, 
                PELOPHYLAX, 
                PatternGene.create(
                        FAUtils.translation("pattern_gene", "pelophylax"), 
                        0x45B58F,
                        InheritanceRules.always(),
                        "pelophylax"
                )
        );
        FAPatternGenes.register(
                bootstrapContext, 
                PULCHRANA, 
                PatternGene.create(
                        FAUtils.translation("pattern_gene", "pulchrana"), 
                        0x241D16,
                        InheritanceRules.always(),
                        "pulchrana"
                )
        );
        FAPatternGenes.register(
                bootstrapContext,
                RANA, 
                PatternGene.create(
                        FAUtils.translation("pattern_gene", "rana"), 
                        0x48290A,
                        InheritanceRules.always(),
                        "rana"
                )
        );
    }
}
