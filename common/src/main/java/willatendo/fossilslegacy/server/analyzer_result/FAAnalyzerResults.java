package willatendo.fossilslegacy.server.analyzer_result;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.ArrayList;
import java.util.List;

public final class FAAnalyzerResults {
    public static final List<ResourceKey<AnalyzerResult>> FOSSIL_RESULTS = new ArrayList<>();
    public static final List<ResourceKey<AnalyzerResult>> RELIC_SCRAP_RESULTS = new ArrayList<>();
    public static final List<ResourceKey<AnalyzerResult>> FROZEN_MEAT_RESULTS = new ArrayList<>();
    public static final ResourceKey<AnalyzerResult> AXOLOTL_DNA = FAAnalyzerResults.create("axolotl_dna");
    public static final ResourceKey<AnalyzerResult> PIG_DNA = FAAnalyzerResults.create("pig_dna");
    public static final ResourceKey<AnalyzerResult> COW_DNA = FAAnalyzerResults.create("cow_dna");
    public static final ResourceKey<AnalyzerResult> CHICKEN_DNA = FAAnalyzerResults.create("chicken_dna");
    public static final List<ResourceKey<AnalyzerResult>> FEATHER_RESULTS = new ArrayList<>();
    public static final ResourceKey<AnalyzerResult> PANDA_DNA = FAAnalyzerResults.create("panda_dna");
    public static final ResourceKey<AnalyzerResult> SHEEP_DNA = FAAnalyzerResults.create("sheep_dna");
    public static final ResourceKey<AnalyzerResult> RABBIT_DNA = FAAnalyzerResults.create("rabbit_dna");
    public static final ResourceKey<AnalyzerResult> WOLF_DNA = FAAnalyzerResults.create("wolf_dna");
    public static final ResourceKey<AnalyzerResult> FOX_DNA = FAAnalyzerResults.create("fox_dna");
    public static final ResourceKey<AnalyzerResult> GOAT_DNA = FAAnalyzerResults.create("goat_dna");
    public static final ResourceKey<AnalyzerResult> FROG_DNA = FAAnalyzerResults.create("frog_dna");
    public static final List<ResourceKey<AnalyzerResult>> LEATHER_RESULTS = new ArrayList<>();
    public static final List<ResourceKey<AnalyzerResult>> STRING_RESULTS = new ArrayList<>();
    public static final List<ResourceKey<AnalyzerResult>> COD_RESULTS = new ArrayList<>();
    public static final ResourceKey<AnalyzerResult> POLAR_BEAR_DNA = FAAnalyzerResults.create("polar_bear_dna");
    public static final ResourceKey<AnalyzerResult> ARMADILLO_DNA = FAAnalyzerResults.create("armadilo_dna");
    public static final ResourceKey<AnalyzerResult> BRACHIOSAURUS_DNA = FAAnalyzerResults.create("brachiosaurus_dna");
    public static final ResourceKey<AnalyzerResult> DILOPHOSAURUS_DNA = FAAnalyzerResults.create("dilophosaurus_dna");
    public static final ResourceKey<AnalyzerResult> MAMMOTH_DNA = FAAnalyzerResults.create("mammoth_dna");
    public static final ResourceKey<AnalyzerResult> MOSASAURUS_DNA = FAAnalyzerResults.create("mosasaurus_dna");
    public static final ResourceKey<AnalyzerResult> FUTABASAURUS_DNA = FAAnalyzerResults.create("futabasaurus_dna");
    public static final ResourceKey<AnalyzerResult> PTERANODON_DNA = FAAnalyzerResults.create("pteranodon_dna");
    public static final ResourceKey<AnalyzerResult> SMILODON_DNA = FAAnalyzerResults.create("smilodon_dna");
    public static final ResourceKey<AnalyzerResult> STEGOSAURUS_DNA = FAAnalyzerResults.create("stegosaurus_dna");
    public static final ResourceKey<AnalyzerResult> TRICERATOPS_DNA = FAAnalyzerResults.create("triceratops_dna");
    public static final ResourceKey<AnalyzerResult> TYRANNOSAURUS_DNA = FAAnalyzerResults.create("tyrannosaurus_dna");
    public static final ResourceKey<AnalyzerResult> VELOCIRAPTOR_DNA = FAAnalyzerResults.create("velociraptor_dna");
    public static final ResourceKey<AnalyzerResult> CARNOTAURUS_DNA = FAAnalyzerResults.create("carnotaurus_dna");
    public static final ResourceKey<AnalyzerResult> CRYOLOPHOSAURUS_DNA = FAAnalyzerResults.create("cryolophosaurus_dna");
    public static final ResourceKey<AnalyzerResult> THERIZINOSAURUS_DNA = FAAnalyzerResults.create("therizinosaurus_dna");
    public static final ResourceKey<AnalyzerResult> PACHYCEPHALOSAURUS_DNA = FAAnalyzerResults.create("pachycephalosaurus_dna");
    public static final ResourceKey<AnalyzerResult> COMPSOGNATHUS_DNA = FAAnalyzerResults.create("compsognathus_dna");
    public static final ResourceKey<AnalyzerResult> DODO_DNA = FAAnalyzerResults.create("dodo_dna");
    public static final ResourceKey<AnalyzerResult> MOA_DNA = FAAnalyzerResults.create("moa_dna");
    public static final ResourceKey<AnalyzerResult> GALLIMIMUS_DNA = FAAnalyzerResults.create("gallimimus_dna");
    public static final ResourceKey<AnalyzerResult> SPINOSAURUS_DNA = FAAnalyzerResults.create("spinosaurus_dna");
    public static final ResourceKey<AnalyzerResult> ANKYLOSAURUS_DNA = FAAnalyzerResults.create("ankylosaurus_dna");
    public static final ResourceKey<AnalyzerResult> DIMETRODON_DNA = FAAnalyzerResults.create("dimetrodon_dna");
    public static final ResourceKey<AnalyzerResult> ICHTHYOSAURUS_DNA = FAAnalyzerResults.create("ichthyosaurus_dna");
    public static final ResourceKey<AnalyzerResult> ELASMOTHERIUM_DNA = FAAnalyzerResults.create("elasmotherium_dna");
    public static final ResourceKey<AnalyzerResult> DRYOSAURUS_DNA = FAAnalyzerResults.create("dryosaurus_dna");
    public static final ResourceKey<AnalyzerResult> BARYONYX_DNA = FAAnalyzerResults.create("baryonyx_dna");

    private static ResourceKey<AnalyzerResult> create(String name) {
        return ResourceKey.create(FARegistries.ANALYZER_RESULT, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<AnalyzerResult> bootstrapContext, List<ResourceKey<AnalyzerResult>> results, String path, ItemStack result, int weight) {
        ResourceKey<AnalyzerResult> resourceKey = FAAnalyzerResults.create(path + "/" + BuiltInRegistries.ITEM.getKey(result.getItem()).getPath());
        FAAnalyzerResults.register(bootstrapContext, resourceKey, result, weight);
        results.add(resourceKey);
    }

    private static void register(BootstrapContext<AnalyzerResult> bootstrapContext, ResourceKey<AnalyzerResult> resourceKey, ItemStack result, int weight) {
        bootstrapContext.register(resourceKey, new AnalyzerResult(result, weight));
    }

    public static void bootstrap(BootstrapContext<AnalyzerResult> bootstrapContext) {
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(Items.BONE_MEAL), 60);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.JURASSIC_FERN_DNA.get()), 20);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.LEPIDODENDRON_DNA.get()), 10);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.SIGILLARIA_DNA.get()), 10);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.CALAMITES_DNA.get()), 10);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.ARCHAEOPTERIS_DNA.get()), 10);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.BARYONYX_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.BRACHIOSAURUS_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.DILOPHOSAURUS_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.MOSASAURUS_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.NAUTILUS_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.FUTABASAURUS_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.GALLIMIMUS_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.PTERANODON_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.STEGOSAURUS_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.TRICERATOPS_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.ANKYLOSAURUS_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.DIMETRODON_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.DRYOSAURUS_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.ICHTHYOSAURUS_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.TYRANNOSAURUS_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.VELOCIRAPTOR_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.CARNOTAURUS_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.CRYOLOPHOSAURUS_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.THERIZINOSAURUS_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.PACHYCEPHALOSAURUS_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.COMPSOGNATHUS_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FAItems.SPINOSAURUS_DNA.get()), 2);
        FAAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(Blocks.GRAVEL), 40);
        FAAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FAItems.STONE_TABLET.get()), 30);
        FAAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(Items.FLINT), 20);
        FAAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FAItems.ANCIENT_SWORD_ARTIFACT.get()), 5);
        FAAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FAItems.ANCIENT_SHOVEL_ARTIFACT.get()), 5);
        FAAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FAItems.ANCIENT_PICKAXE_ARTIFACT.get()), 5);
        FAAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FAItems.ANCIENT_AXE_ARTIFACT.get()), 5);
        FAAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FAItems.ANCIENT_HOE_ARTIFACT.get()), 5);
        FAAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FAItems.ANCIENT_HELMET_ARTIFACT.get()), 5);
        FAAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FAItems.ANCIENT_CHESTPLATE_ARTIFACT.get()), 5);
        FAAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FAItems.ANCIENT_LEGGINGS_ARTIFACT.get()), 5);
        FAAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FAItems.ANCIENT_BOOTS_ARTIFACT.get()), 5);
        FAAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FAItems.PREHISTORIC_COIN.get()), 1);
        FAAnalyzerResults.register(bootstrapContext, FROZEN_MEAT_RESULTS, "frozen_meat_results", new ItemStack(FAItems.SMILODON_DNA.get()), 33);
        FAAnalyzerResults.register(bootstrapContext, FROZEN_MEAT_RESULTS, "frozen_meat_results", new ItemStack(FAItems.MAMMOTH_DNA.get()), 33);
        FAAnalyzerResults.register(bootstrapContext, FROZEN_MEAT_RESULTS, "frozen_meat_results", new ItemStack(FAItems.DODO_DNA.get()), 33);
        FAAnalyzerResults.register(bootstrapContext, FROZEN_MEAT_RESULTS, "frozen_meat_results", new ItemStack(FAItems.MOA_DNA.get()), 33);
        FAAnalyzerResults.register(bootstrapContext, FROZEN_MEAT_RESULTS, "frozen_meat_results", new ItemStack(FAItems.ELASMOTHERIUM_DNA.get()), 33);
        FAAnalyzerResults.register(bootstrapContext, FROZEN_MEAT_RESULTS, "frozen_meat_results", new ItemStack(Items.BEEF), 33);
        FAAnalyzerResults.register(bootstrapContext, AXOLOTL_DNA, new ItemStack(FAItems.AXOLOTL_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, PIG_DNA, new ItemStack(FAItems.PIG_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, COW_DNA, new ItemStack(FAItems.COW_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, CHICKEN_DNA, new ItemStack(FAItems.CHICKEN_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, FEATHER_RESULTS, "feather_results", new ItemStack(FAItems.CHICKEN_DNA.get()), 50);
        FAAnalyzerResults.register(bootstrapContext, FEATHER_RESULTS, "feather_results", new ItemStack(FAItems.PARROT_DNA.get()), 50);
        FAAnalyzerResults.register(bootstrapContext, PANDA_DNA, new ItemStack(FAItems.PANDA_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, SHEEP_DNA, new ItemStack(FAItems.SHEEP_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, RABBIT_DNA, new ItemStack(FAItems.RABBIT_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, WOLF_DNA, new ItemStack(FAItems.WOLF_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, FOX_DNA, new ItemStack(FAItems.FOX_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, GOAT_DNA, new ItemStack(FAItems.GOAT_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, FROG_DNA, new ItemStack(FAItems.FROG_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, LEATHER_RESULTS, "leather_results", new ItemStack(FAItems.COW_DNA.get()), 20);
        FAAnalyzerResults.register(bootstrapContext, LEATHER_RESULTS, "leather_results", new ItemStack(FAItems.LLAMA_DNA.get()), 20);
        FAAnalyzerResults.register(bootstrapContext, LEATHER_RESULTS, "leather_results", new ItemStack(FAItems.HORSE_DNA.get()), 20);
        FAAnalyzerResults.register(bootstrapContext, LEATHER_RESULTS, "leather_results", new ItemStack(FAItems.DONKEY_DNA.get()), 20);
        FAAnalyzerResults.register(bootstrapContext, LEATHER_RESULTS, "leather_results", new ItemStack(FAItems.MULE_DNA.get()), 20);
        FAAnalyzerResults.register(bootstrapContext, STRING_RESULTS, "string_results", new ItemStack(FAItems.CAT_DNA.get()), 33);
        FAAnalyzerResults.register(bootstrapContext, STRING_RESULTS, "string_results", new ItemStack(FAItems.OCELOT_DNA.get()), 33);
        FAAnalyzerResults.register(bootstrapContext, STRING_RESULTS, "string_results", new ItemStack(FAItems.FOX_DNA.get()), 33);
        FAAnalyzerResults.register(bootstrapContext, COD_RESULTS, "cod_results", new ItemStack(FAItems.POLAR_BEAR_DNA.get()), 50);
        FAAnalyzerResults.register(bootstrapContext, COD_RESULTS, "cod_results", new ItemStack(FAItems.DOLPHIN_DNA.get()), 50);
        FAAnalyzerResults.register(bootstrapContext, POLAR_BEAR_DNA, new ItemStack(FAItems.POLAR_BEAR_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, ARMADILLO_DNA, new ItemStack(FAItems.ARMADILLO_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, BRACHIOSAURUS_DNA, new ItemStack(FAItems.BRACHIOSAURUS_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, DILOPHOSAURUS_DNA, new ItemStack(FAItems.DILOPHOSAURUS_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, MAMMOTH_DNA, new ItemStack(FAItems.MAMMOTH_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, MOSASAURUS_DNA, new ItemStack(FAItems.MOSASAURUS_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, FUTABASAURUS_DNA, new ItemStack(FAItems.FUTABASAURUS_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, PTERANODON_DNA, new ItemStack(FAItems.PTERANODON_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, SMILODON_DNA, new ItemStack(FAItems.SMILODON_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, STEGOSAURUS_DNA, new ItemStack(FAItems.STEGOSAURUS_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, TRICERATOPS_DNA, new ItemStack(FAItems.TRICERATOPS_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, TYRANNOSAURUS_DNA, new ItemStack(FAItems.TYRANNOSAURUS_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, VELOCIRAPTOR_DNA, new ItemStack(FAItems.VELOCIRAPTOR_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, CARNOTAURUS_DNA, new ItemStack(FAItems.CARNOTAURUS_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, CRYOLOPHOSAURUS_DNA, new ItemStack(FAItems.CRYOLOPHOSAURUS_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, THERIZINOSAURUS_DNA, new ItemStack(FAItems.THERIZINOSAURUS_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, PACHYCEPHALOSAURUS_DNA, new ItemStack(FAItems.PACHYCEPHALOSAURUS_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, COMPSOGNATHUS_DNA, new ItemStack(FAItems.COMPSOGNATHUS_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, DODO_DNA, new ItemStack(FAItems.DODO_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, MOA_DNA, new ItemStack(FAItems.MOA_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, GALLIMIMUS_DNA, new ItemStack(FAItems.GALLIMIMUS_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, SPINOSAURUS_DNA, new ItemStack(FAItems.SPINOSAURUS_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, ANKYLOSAURUS_DNA, new ItemStack(FAItems.ANKYLOSAURUS_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, DIMETRODON_DNA, new ItemStack(FAItems.DIMETRODON_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, ICHTHYOSAURUS_DNA, new ItemStack(FAItems.ICHTHYOSAURUS_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, ELASMOTHERIUM_DNA, new ItemStack(FAItems.ELASMOTHERIUM_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, DRYOSAURUS_DNA, new ItemStack(FAItems.DRYOSAURUS_DNA.get()), 100);
        FAAnalyzerResults.register(bootstrapContext, BARYONYX_DNA, new ItemStack(FAItems.BARYONYX_DNA.get()), 100);
    }
}
