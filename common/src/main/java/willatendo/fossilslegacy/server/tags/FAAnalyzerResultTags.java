package willatendo.fossilslegacy.server.tags;

import net.minecraft.tags.TagKey;
import willatendo.fossilslegacy.server.analyzer_result.AnalyzerResult;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FAAnalyzerResultTags {
    private static final TagRegister<AnalyzerResult> ANALYZER_RESULT_TAGS = TagRegister.create(FARegistries.ANALYZER_RESULT, FossilsLegacyUtils.ID);

    public static final TagKey<AnalyzerResult> FOSSIL_RESULTS = ANALYZER_RESULT_TAGS.register("results/fossil");
    public static final TagKey<AnalyzerResult> RELIC_SCRAP_RESULTS = ANALYZER_RESULT_TAGS.register("results/relic_scrap");
    public static final TagKey<AnalyzerResult> FROZEN_MEAT_RESULTS = ANALYZER_RESULT_TAGS.register("results/frozen_meat");
    public static final TagKey<AnalyzerResult> AXOLOTL_BUCKET_RESULTS = ANALYZER_RESULT_TAGS.register("results/axolotl_bucket");
    public static final TagKey<AnalyzerResult> TROPICAL_FISH_BUCKET_RESULTS = ANALYZER_RESULT_TAGS.register("results/tropical_fish_bucket");
    public static final TagKey<AnalyzerResult> PORKCHOP_RESULTS = ANALYZER_RESULT_TAGS.register("results/porkchop");
    public static final TagKey<AnalyzerResult> BEEF_RESULTS = ANALYZER_RESULT_TAGS.register("results/beef");
    public static final TagKey<AnalyzerResult> CHICKEN_RESULTS = ANALYZER_RESULT_TAGS.register("results/chicken");
    public static final TagKey<AnalyzerResult> FEATHER_RESULTS = ANALYZER_RESULT_TAGS.register("results/feather");
    public static final TagKey<AnalyzerResult> BAMBOO_RESULTS = ANALYZER_RESULT_TAGS.register("results/bamboo");
    public static final TagKey<AnalyzerResult> SLIME_BALL_RESULTS = ANALYZER_RESULT_TAGS.register("results/slime_ball");
    public static final TagKey<AnalyzerResult> MUTTON_RESULTS = ANALYZER_RESULT_TAGS.register("results/mutton");
    public static final TagKey<AnalyzerResult> RAW_RABBIT_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_rabbit");
    public static final TagKey<AnalyzerResult> BONE_RESULTS = ANALYZER_RESULT_TAGS.register("results/bone");
    public static final TagKey<AnalyzerResult> EMERALD_RESULTS = ANALYZER_RESULT_TAGS.register("results/emerald");
    public static final TagKey<AnalyzerResult> GOAT_HORN_RESULTS = ANALYZER_RESULT_TAGS.register("results/goat_horn");
    public static final TagKey<AnalyzerResult> FROGLIGHT_RESULTS = ANALYZER_RESULT_TAGS.register("results/froglight");
    public static final TagKey<AnalyzerResult> LEATHER_RESULTS = ANALYZER_RESULT_TAGS.register("results/leather");
    public static final TagKey<AnalyzerResult> STRING_RESULTS = ANALYZER_RESULT_TAGS.register("results/string");
    public static final TagKey<AnalyzerResult> COD_RESULTS = ANALYZER_RESULT_TAGS.register("results/cod");
    public static final TagKey<AnalyzerResult> SALMON_RESULTS = ANALYZER_RESULT_TAGS.register("results/salmon");
    public static final TagKey<AnalyzerResult> WOOL_RESULTS = ANALYZER_RESULT_TAGS.register("results/wool");
    public static final TagKey<AnalyzerResult> ARMADILLO_SCUTE_RESULTS = ANALYZER_RESULT_TAGS.register("results/armadilo_scute");
    public static final TagKey<AnalyzerResult> RAW_BRACHIOSAURUS_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_brachiosaurus_meat");
    public static final TagKey<AnalyzerResult> RAW_DILOPHOSAURUS_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_dilophosaurus_meat");
    public static final TagKey<AnalyzerResult> RAW_MAMMOTH_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_mammoth_meat");
    public static final TagKey<AnalyzerResult> RAW_MOSASAURUS_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_mosasaurus_meat");
    public static final TagKey<AnalyzerResult> RAW_FUTABASAURUS_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_futabasaurus_meat");
    public static final TagKey<AnalyzerResult> RAW_PTERANODON_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_pteranodon_meat");
    public static final TagKey<AnalyzerResult> RAW_SMILODON_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_smilodon_meat");
    public static final TagKey<AnalyzerResult> RAW_STEGOSAURUS_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_stegosaurus_meat");
    public static final TagKey<AnalyzerResult> RAW_TRICERATOPS_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_triceratops_meat");
    public static final TagKey<AnalyzerResult> RAW_TYRANNOSAURUS_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_tyrannosaurus_meat");
    public static final TagKey<AnalyzerResult> RAW_VELOCIRAPTOR_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_velociraptor_meat");
    public static final TagKey<AnalyzerResult> RAW_CARNOTAURUS_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_carnotaurus_meat");
    public static final TagKey<AnalyzerResult> RAW_CRYOLOPHOSAURUS_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_cryolophosaurus_meat");
    public static final TagKey<AnalyzerResult> RAW_THERIZINOSAURUS_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_therizinosaurus_meat");
    public static final TagKey<AnalyzerResult> RAW_PACHYCEPHALOSAURUS_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_pachycephalosaurus_meat");
    public static final TagKey<AnalyzerResult> RAW_COMPSOGNATHUS_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_compsognathus_meat");
    public static final TagKey<AnalyzerResult> RAW_DODO_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_dodo_meat");
    public static final TagKey<AnalyzerResult> RAW_MOA_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_moa_meat");
    public static final TagKey<AnalyzerResult> RAW_GALLIMIMUS_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_gallimimus_meat");
    public static final TagKey<AnalyzerResult> RAW_SPINOSAURUS_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_spinosaurus_meat");
    public static final TagKey<AnalyzerResult> RAW_ANKYLOSAURUS_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_ankylosaurus_meat");
    public static final TagKey<AnalyzerResult> RAW_DIMETRODON_RESULTS = ANALYZER_RESULT_TAGS.register("results/raw_dimetrodon_meat");
}
