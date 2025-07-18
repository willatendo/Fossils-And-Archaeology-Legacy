package willatendo.fossilslegacy.server.stats;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.HashMap;
import java.util.Map;

public final class FAStats {
    public static final Map<ResourceLocation, StatFormatter> STAT_FORMATTERS = new HashMap<>();
    public static final SimpleRegistry<ResourceLocation> STATS = SimpleRegistry.create(Registries.CUSTOM_STAT, FAUtils.ID);

    public static final ResourceLocation INTERACT_WITH_ANALYZER = FAStats.makeCustomStat("interact_with_analyzer", StatFormatter.DEFAULT);
    public static final ResourceLocation INTERACT_WITH_ARCHAEOLOGY_WORKBENCH = FAStats.makeCustomStat("interact_with_archaeology_workbench", StatFormatter.DEFAULT);
    public static final ResourceLocation INTERACT_WITH_DNA_CODER = FAStats.makeCustomStat("interact_with_dna_coder", StatFormatter.DEFAULT);
    public static final ResourceLocation INTERACT_WITH_DNA_HYBRIDIZER= FAStats.makeCustomStat("interact_with_dna_hybridizer", StatFormatter.DEFAULT);
    public static final ResourceLocation INTERACT_WITH_CULTIVATOR = FAStats.makeCustomStat("interact_with_cultivator", StatFormatter.DEFAULT);
    public static final ResourceLocation INTERACT_WITH_FEEDER = FAStats.makeCustomStat("interact_with_feeder", StatFormatter.DEFAULT);
    public static final ResourceLocation INTERACT_WITH_GENE_MODIFICATION_TABLE = FAStats.makeCustomStat("interact_with_gene_modification_table", StatFormatter.DEFAULT);
    public static final ResourceLocation INTERACT_WITH_PALAEONTOLOGY_TABLE = FAStats.makeCustomStat("interact_with_palaeontology_table", StatFormatter.DEFAULT);

    private static ResourceLocation makeCustomStat(String name, StatFormatter statFormatter) {
        ResourceLocation stat = FAUtils.resource(name);
        STATS.register(name, () -> stat);
        FAStats.STAT_FORMATTERS.put(stat, statFormatter);
        return stat;
    }
}
