package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.recipe.AnalyzerResult;
import willatendo.fossilslegacy.server.recipe.FossilsLegacyAnalyzerResults;
import willatendo.fossilslegacy.server.tags.FossilsLegacyAnalyzerResultTags;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyAnalyzerResultTagProvider extends DataDrivenTagsProvider<AnalyzerResult> {
    public FossilsLegacyAnalyzerResultTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, FossilsLegacyRegistries.ANALYZER_RESULT, provider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FossilsLegacyAnalyzerResultTags.FOSSIL_RESULTS).add(FossilsLegacyAnalyzerResults.FOSSIL_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FossilsLegacyAnalyzerResultTags.RELIC_SCRAP_RESULTS).add(FossilsLegacyAnalyzerResults.RELIC_SCRAP_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FossilsLegacyAnalyzerResultTags.FROZEN_MEAT_RESULTS).add(FossilsLegacyAnalyzerResults.FROZEN_MEAT_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FossilsLegacyAnalyzerResultTags.AXOLOTL_BUCKET_RESULTS).add(FossilsLegacyAnalyzerResults.AXOLOTL_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.TROPICAL_FISH_BUCKET_RESULTS).add(FossilsLegacyAnalyzerResults.AXOLOTL_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.PORKCHOP_RESULTS).add(FossilsLegacyAnalyzerResults.PIG_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.BEEF_RESULTS).add(FossilsLegacyAnalyzerResults.COW_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.CHICKEN_RESULTS).add(FossilsLegacyAnalyzerResults.CHICKEN_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.FEATHER_RESULTS).add(FossilsLegacyAnalyzerResults.FEATHER_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FossilsLegacyAnalyzerResultTags.BAMBOO_RESULTS).add(FossilsLegacyAnalyzerResults.PANDA_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.SLIME_BALL_RESULTS).add(FossilsLegacyAnalyzerResults.PANDA_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.MUTTON_RESULTS).add(FossilsLegacyAnalyzerResults.SHEEP_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_RABBIT_RESULTS).add(FossilsLegacyAnalyzerResults.RABBIT_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.BONE_RESULTS).add(FossilsLegacyAnalyzerResults.WOLF_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.EMERALD_RESULTS).add(FossilsLegacyAnalyzerResults.FOX_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.GOAT_HORN_RESULTS).add(FossilsLegacyAnalyzerResults.GOAT_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.FROGLIGHT_RESULTS).add(FossilsLegacyAnalyzerResults.FROG_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.LEATHER_RESULTS).add(FossilsLegacyAnalyzerResults.LEATHER_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FossilsLegacyAnalyzerResultTags.STRING_RESULTS).add(FossilsLegacyAnalyzerResults.STRING_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FossilsLegacyAnalyzerResultTags.COD_RESULTS).add(FossilsLegacyAnalyzerResults.COD_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FossilsLegacyAnalyzerResultTags.SALMON_RESULTS).add(FossilsLegacyAnalyzerResults.POLAR_BEAR_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.WOOL_RESULTS).add(FossilsLegacyAnalyzerResults.SHEEP_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.ARMADILLO_SCUTE_RESULTS).add(FossilsLegacyAnalyzerResults.ARMADILLO_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_BRACHIOSAURUS_RESULTS).add(FossilsLegacyAnalyzerResults.BRACHIOSAURUS_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_DILOPHOSAURUS_RESULTS).add(FossilsLegacyAnalyzerResults.DILOPHOSAURUS_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_MAMMOTH_RESULTS).add(FossilsLegacyAnalyzerResults.MAMMOTH_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_MOSASAURUS_RESULTS).add(FossilsLegacyAnalyzerResults.MOSASAURUS_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_FUTABASAURUS_RESULTS).add(FossilsLegacyAnalyzerResults.FUTABASAURUS_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_PTERANODON_RESULTS).add(FossilsLegacyAnalyzerResults.PTERANODON_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_SMILODON_RESULTS).add(FossilsLegacyAnalyzerResults.SMILODON_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_STEGOSAURUS_RESULTS).add(FossilsLegacyAnalyzerResults.STEGOSAURUS_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_TRICERATOPS_RESULTS).add(FossilsLegacyAnalyzerResults.TRICERATOPS_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_TYRANNOSAURUS_RESULTS).add(FossilsLegacyAnalyzerResults.TYRANNOSAURUS_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_VELOCIRAPTOR_RESULTS).add(FossilsLegacyAnalyzerResults.VELOCIRAPTOR_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_CARNOTAURUS_RESULTS).add(FossilsLegacyAnalyzerResults.CARNOTAURUS_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_CRYOLOPHOSAURUS_RESULTS).add(FossilsLegacyAnalyzerResults.CRYOLOPHOSAURUS_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_THERIZINOSAURUS_RESULTS).add(FossilsLegacyAnalyzerResults.THERIZINOSAURUS_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_PACHYCEPHALOSAURUS_RESULTS).add(FossilsLegacyAnalyzerResults.PACHYCEPHALOSAURUS_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_COMPSOGNATHUS_RESULTS).add(FossilsLegacyAnalyzerResults.COMPSOGNATHUS_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_DODO_RESULTS).add(FossilsLegacyAnalyzerResults.DODO_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_MOA_RESULTS).add(FossilsLegacyAnalyzerResults.MOA_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_GALLIMIMUS_RESULTS).add(FossilsLegacyAnalyzerResults.GALLIMIMUS_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_SPINOSAURUS_RESULTS).add(FossilsLegacyAnalyzerResults.SPINOSAURUS_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_ANKYLOSAURUS_RESULTS).add(FossilsLegacyAnalyzerResults.ANKYLOSAURUS_DNA);
        this.tag(FossilsLegacyAnalyzerResultTags.RAW_DIMETRODON_RESULTS).add(FossilsLegacyAnalyzerResults.DIMETRODON_DNA);
    }
}
