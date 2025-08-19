package willatendo.fossilslegacy.server.gene.cosmetics;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FAPatterns {
    public static final ResourceKey<PatternGene> BLANK = FAPatterns.create("blank");
    public static final ResourceKey<PatternGene> CHALCORANA = FAPatterns.create("chalcorana");
    public static final ResourceKey<PatternGene> LITHOBATES = FAPatterns.create("lithobates");
    public static final ResourceKey<PatternGene> PAPURANA = FAPatterns.create("papurana");
    public static final ResourceKey<PatternGene> PELOPHYLAX = FAPatterns.create("pelophylax");
    public static final ResourceKey<PatternGene> PULCHRANA = FAPatterns.create("pulchrana");
    public static final ResourceKey<PatternGene> RANA = FAPatterns.create("rana");

    private static ResourceKey<PatternGene> create(String name) {
        return ResourceKey.create(FARegistries.PATTERN_GENE, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<PatternGene> bootstrapContext, ResourceKey<PatternGene> resourceKey, PatternGene patternGene) {
        bootstrapContext.register(resourceKey, patternGene);
    }

    public static void bootstrap(BootstrapContext<PatternGene> bootstrapContext) {
        FAPatterns.register(bootstrapContext, BLANK, new PatternGene());
        FAPatterns.register(bootstrapContext, CHALCORANA, PatternGene.builder(FAUtils.translation("patternGenes", "chalcorana"), 0x72A03C).buildComposite("chalcorana"));
        FAPatterns.register(bootstrapContext, LITHOBATES, PatternGene.builder(FAUtils.translation("patternGenes", "lithobates"), 0x38220B).buildComposite("lithobates"));
        FAPatterns.register(bootstrapContext, PAPURANA, PatternGene.builder(FAUtils.translation("patternGenes", "papurana"), 0xBD5F1C).buildComposite("papurana"));
        FAPatterns.register(bootstrapContext, PELOPHYLAX, PatternGene.builder(FAUtils.translation("patternGenes", "pelophylax"), 0x45B58F).buildComposite("pelophylax"));
        FAPatterns.register(bootstrapContext, PULCHRANA, PatternGene.builder(FAUtils.translation("patternGenes", "pulchrana"), 0x241D16).buildComposite("pulchrana"));
        FAPatterns.register(bootstrapContext, RANA, PatternGene.builder(FAUtils.translation("patternGenes", "rana"), 0x48290A).buildComposite("rana"));
    }
}
