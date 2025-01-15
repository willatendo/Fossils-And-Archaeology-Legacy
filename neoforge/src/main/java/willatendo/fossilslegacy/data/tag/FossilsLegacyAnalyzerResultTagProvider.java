package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.genetics.cosmetics.FossilsLegacyCoatTypes;
import willatendo.fossilslegacy.server.recipe.AnalyzerResult;
import willatendo.fossilslegacy.server.recipe.FossilsLegacyAnalyzerResults;
import willatendo.fossilslegacy.server.tags.FossilsLegacyAnalyzerResultTags;
import willatendo.fossilslegacy.server.tags.FossilsLegacyCoatTypeTags;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyAnalyzerResultTagProvider extends DataDrivenTagsProvider<AnalyzerResult> {
    public FossilsLegacyAnalyzerResultTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, FossilsLegacyRegistries.ANALYZER_RESULT, provider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FossilsLegacyAnalyzerResultTags.FOSSIL_RESULTS).add(FossilsLegacyAnalyzerResults.FOSSIL_RESULTS.toArray(ResourceKey[]::new));
    }
}
