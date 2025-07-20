package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.analyzer_result.AnalyzerResult;
import willatendo.fossilslegacy.server.analyzer_result.FAAnalyzerResults;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAAnalyzerResultTags;

import java.util.concurrent.CompletableFuture;

public class FAAnalyzerResultTagProvider extends DataDrivenTagsProvider<AnalyzerResult> {
    public FAAnalyzerResultTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, FARegistries.ANALYZER_RESULT, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FAAnalyzerResultTags.CENOZOIC_FOSSIL_RESULTS).add(FAAnalyzerResults.CENOZOIC_FOSSIL_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FAAnalyzerResultTags.MESOZOIC_FOSSIL_RESULTS).add(FAAnalyzerResults.MESOZOIC_FOSSIL_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FAAnalyzerResultTags.PALAEOZOIC_FOSSIL_RESULTS).add(FAAnalyzerResults.PALAEOZOIC_FOSSIL_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FAAnalyzerResultTags.MOSQUITO_IN_AMBER_RESULTS).add(FAAnalyzerResults.MOSQUITO_IN_AMBER_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FAAnalyzerResultTags.LEECH_IN_ICE_RESULTS).add(FAAnalyzerResults.LEECH_IN_ICE_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FAAnalyzerResultTags.PLANT_FOSSIL_RESULTS).add(FAAnalyzerResults.PLANT_FOSSIL_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FAAnalyzerResultTags.RELIC_SCRAP_RESULTS).add(FAAnalyzerResults.RELIC_SCRAP_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FAAnalyzerResultTags.FROZEN_MEAT_RESULTS).add(FAAnalyzerResults.FROZEN_MEAT_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FAAnalyzerResultTags.AXOLOTL_BUCKET_RESULTS).add(FAAnalyzerResults.AXOLOTL_DNA);
        this.tag(FAAnalyzerResultTags.TROPICAL_FISH_BUCKET_RESULTS).add(FAAnalyzerResults.AXOLOTL_DNA);
        this.tag(FAAnalyzerResultTags.PORKCHOP_RESULTS).add(FAAnalyzerResults.PIG_DNA);
        this.tag(FAAnalyzerResultTags.BEEF_RESULTS).add(FAAnalyzerResults.COW_DNA);
        this.tag(FAAnalyzerResultTags.CHICKEN_RESULTS).add(FAAnalyzerResults.CHICKEN_DNA);
        this.tag(FAAnalyzerResultTags.FEATHER_RESULTS).add(FAAnalyzerResults.FEATHER_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FAAnalyzerResultTags.BAMBOO_RESULTS).add(FAAnalyzerResults.PANDA_DNA);
        this.tag(FAAnalyzerResultTags.SLIME_BALL_RESULTS).add(FAAnalyzerResults.PANDA_DNA);
        this.tag(FAAnalyzerResultTags.MUTTON_RESULTS).add(FAAnalyzerResults.SHEEP_DNA);
        this.tag(FAAnalyzerResultTags.RAW_RABBIT_RESULTS).add(FAAnalyzerResults.RABBIT_DNA);
        this.tag(FAAnalyzerResultTags.BONE_RESULTS).add(FAAnalyzerResults.WOLF_DNA);
        this.tag(FAAnalyzerResultTags.EMERALD_RESULTS).add(FAAnalyzerResults.FOX_DNA);
        this.tag(FAAnalyzerResultTags.GOAT_HORN_RESULTS).add(FAAnalyzerResults.GOAT_DNA);
        this.tag(FAAnalyzerResultTags.FROGLIGHT_RESULTS).add(FAAnalyzerResults.FROG_DNA);
        this.tag(FAAnalyzerResultTags.LEATHER_RESULTS).add(FAAnalyzerResults.LEATHER_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FAAnalyzerResultTags.STRING_RESULTS).add(FAAnalyzerResults.STRING_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FAAnalyzerResultTags.COD_RESULTS).add(FAAnalyzerResults.COD_RESULTS.toArray(ResourceKey[]::new));
        this.tag(FAAnalyzerResultTags.SALMON_RESULTS).add(FAAnalyzerResults.POLAR_BEAR_DNA);
        this.tag(FAAnalyzerResultTags.WOOL_RESULTS).add(FAAnalyzerResults.SHEEP_DNA);
        this.tag(FAAnalyzerResultTags.ARMADILLO_SCUTE_RESULTS).add(FAAnalyzerResults.ARMADILLO_DNA);
        this.tag(FAAnalyzerResultTags.RAW_BRACHIOSAURUS_RESULTS).add(FAAnalyzerResults.BRACHIOSAURUS_DNA);
        this.tag(FAAnalyzerResultTags.RAW_DILOPHOSAURUS_RESULTS).add(FAAnalyzerResults.DILOPHOSAURUS_DNA);
        this.tag(FAAnalyzerResultTags.RAW_MAMMOTH_RESULTS).add(FAAnalyzerResults.MAMMOTH_DNA);
        this.tag(FAAnalyzerResultTags.RAW_MOSASAURUS_RESULTS).add(FAAnalyzerResults.MOSASAURUS_DNA);
        this.tag(FAAnalyzerResultTags.RAW_FUTABASAURUS_RESULTS).add(FAAnalyzerResults.FUTABASAURUS_DNA);
        this.tag(FAAnalyzerResultTags.RAW_PTERANODON_RESULTS).add(FAAnalyzerResults.PTERANODON_DNA);
        this.tag(FAAnalyzerResultTags.RAW_SMILODON_RESULTS).add(FAAnalyzerResults.SMILODON_DNA);
        this.tag(FAAnalyzerResultTags.RAW_STEGOSAURUS_RESULTS).add(FAAnalyzerResults.STEGOSAURUS_DNA);
        this.tag(FAAnalyzerResultTags.RAW_TRICERATOPS_RESULTS).add(FAAnalyzerResults.TRICERATOPS_DNA);
        this.tag(FAAnalyzerResultTags.RAW_TYRANNOSAURUS_RESULTS).add(FAAnalyzerResults.TYRANNOSAURUS_DNA);
        this.tag(FAAnalyzerResultTags.RAW_VELOCIRAPTOR_RESULTS).add(FAAnalyzerResults.VELOCIRAPTOR_DNA);
        this.tag(FAAnalyzerResultTags.RAW_CARNOTAURUS_RESULTS).add(FAAnalyzerResults.CARNOTAURUS_DNA);
        this.tag(FAAnalyzerResultTags.RAW_CRYOLOPHOSAURUS_RESULTS).add(FAAnalyzerResults.CRYOLOPHOSAURUS_DNA);
        this.tag(FAAnalyzerResultTags.RAW_THERIZINOSAURUS_RESULTS).add(FAAnalyzerResults.THERIZINOSAURUS_DNA);
        this.tag(FAAnalyzerResultTags.RAW_PACHYCEPHALOSAURUS_RESULTS).add(FAAnalyzerResults.PACHYCEPHALOSAURUS_DNA);
        this.tag(FAAnalyzerResultTags.RAW_COMPSOGNATHUS_RESULTS).add(FAAnalyzerResults.COMPSOGNATHUS_DNA);
        this.tag(FAAnalyzerResultTags.RAW_DODO_RESULTS).add(FAAnalyzerResults.DODO_DNA);
        this.tag(FAAnalyzerResultTags.RAW_MOA_RESULTS).add(FAAnalyzerResults.MOA_DNA);
        this.tag(FAAnalyzerResultTags.RAW_GALLIMIMUS_RESULTS).add(FAAnalyzerResults.GALLIMIMUS_DNA);
        this.tag(FAAnalyzerResultTags.RAW_SPINOSAURUS_RESULTS).add(FAAnalyzerResults.SPINOSAURUS_DNA);
        this.tag(FAAnalyzerResultTags.RAW_ANKYLOSAURUS_RESULTS).add(FAAnalyzerResults.ANKYLOSAURUS_DNA);
        this.tag(FAAnalyzerResultTags.RAW_DIMETRODON_RESULTS).add(FAAnalyzerResults.DIMETRODON_DNA);
        this.tag(FAAnalyzerResultTags.RAW_ICTHYOSAURUS_RESULTS).add(FAAnalyzerResults.ICHTHYOSAURUS_DNA);
        this.tag(FAAnalyzerResultTags.RAW_ELASMOTHERIUM_RESULTS).add(FAAnalyzerResults.ELASMOTHERIUM_DNA);
        this.tag(FAAnalyzerResultTags.RAW_DRYOSAURUS_RESULTS).add(FAAnalyzerResults.DRYOSAURUS_DNA);
        this.tag(FAAnalyzerResultTags.RAW_BARYONYX_RESULTS).add(FAAnalyzerResults.BARYONYX_DNA);
    }
}
