package willatendo.fossilslegacy.server.tags;

import net.minecraft.tags.TagKey;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.recipe.AnalyzerResult;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FossilsLegacyAnalyzerResultTags {
    private static final TagRegister<AnalyzerResult> ANALYZER_RESULT_TAGS = TagRegister.create(FossilsLegacyRegistries.ANALYZER_RESULT, FossilsLegacyUtils.ID);

    public static final TagKey<AnalyzerResult> FOSSIL_RESULTS = ANALYZER_RESULT_TAGS.register("fossil_results");
}
