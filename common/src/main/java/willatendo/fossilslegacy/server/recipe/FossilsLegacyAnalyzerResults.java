package willatendo.fossilslegacy.server.recipe;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;

public class FossilsLegacyAnalyzerResults {
    public static final List<ResourceKey<AnalyzerResult>> FOSSIL_RESULTS = new ArrayList<>();
    public static final List<ResourceKey<AnalyzerResult>> RELIC_SCRAP_RESULTS = new ArrayList<>();
    public static final List<ResourceKey<AnalyzerResult>> FROZEN_MEAT_RESULTS = new ArrayList<>();
    public static final ResourceKey<AnalyzerResult> AXOLOTL_DNA = FossilsLegacyAnalyzerResults.create("axolotl_dna");
    public static final ResourceKey<AnalyzerResult> PIG_DNA = FossilsLegacyAnalyzerResults.create("pig_dna");
    public static final ResourceKey<AnalyzerResult> COW_DNA = FossilsLegacyAnalyzerResults.create("cow_dna");
    public static final ResourceKey<AnalyzerResult> CHICKEN_DNA = FossilsLegacyAnalyzerResults.create("chicken_dna");
    public static final List<ResourceKey<AnalyzerResult>> FEATHER_RESULTS = new ArrayList<>();
    public static final ResourceKey<AnalyzerResult> PANDA_DNA = FossilsLegacyAnalyzerResults.create("panda_dna");
    public static final ResourceKey<AnalyzerResult> SHEEP_DNA = FossilsLegacyAnalyzerResults.create("sheep_dna");
    public static final ResourceKey<AnalyzerResult> RABBIT_DNA = FossilsLegacyAnalyzerResults.create("rabbit_dna");
    public static final ResourceKey<AnalyzerResult> WOLF_DNA = FossilsLegacyAnalyzerResults.create("wolf_dna");
    public static final ResourceKey<AnalyzerResult> FOX_DNA = FossilsLegacyAnalyzerResults.create("fox_dna");
    public static final ResourceKey<AnalyzerResult> GOAT_DNA = FossilsLegacyAnalyzerResults.create("goat_dna");
    public static final ResourceKey<AnalyzerResult> FROG_DNA = FossilsLegacyAnalyzerResults.create("frog_dna");
    public static final List<ResourceKey<AnalyzerResult>> LEATHER_RESULTS = new ArrayList<>();
    public static final List<ResourceKey<AnalyzerResult>> STRING_RESULTS = new ArrayList<>();
    public static final List<ResourceKey<AnalyzerResult>> COD_RESULTS = new ArrayList<>();
    public static final ResourceKey<AnalyzerResult> POLAR_BEAR_DNA = FossilsLegacyAnalyzerResults.create("polar_bear_dna");
    public static final ResourceKey<AnalyzerResult> ARMADILLO_DNA = FossilsLegacyAnalyzerResults.create("armadilo_dna");
    public static final ResourceKey<AnalyzerResult> BRACHIOSAURUS_DNA = FossilsLegacyAnalyzerResults.create("brachiosaurus_dna");
    public static final ResourceKey<AnalyzerResult> DILOPHOSAURUS_DNA = FossilsLegacyAnalyzerResults.create("dilophosaurus_dna");
    public static final ResourceKey<AnalyzerResult> MAMMOTH_DNA = FossilsLegacyAnalyzerResults.create("mammoth_dna");
    public static final ResourceKey<AnalyzerResult> MOSASAURUS_DNA = FossilsLegacyAnalyzerResults.create("mosasaurus_dna");
    public static final ResourceKey<AnalyzerResult> FUTABASAURUS_DNA = FossilsLegacyAnalyzerResults.create("futabasaurus_dna");
    public static final ResourceKey<AnalyzerResult> PTERANODON_DNA = FossilsLegacyAnalyzerResults.create("pteranodon_dna");
    public static final ResourceKey<AnalyzerResult> SMILODON_DNA = FossilsLegacyAnalyzerResults.create("smilodon_dna");
    public static final ResourceKey<AnalyzerResult> STEGOSAURUS_DNA = FossilsLegacyAnalyzerResults.create("stegosaurus_dna");
    public static final ResourceKey<AnalyzerResult> TRICERATOPS_DNA = FossilsLegacyAnalyzerResults.create("triceratops_dna");
    public static final ResourceKey<AnalyzerResult> TYRANNOSAURUS_DNA = FossilsLegacyAnalyzerResults.create("tyrannosaurus_dna");
    public static final ResourceKey<AnalyzerResult> VELOCIRAPTOR_DNA = FossilsLegacyAnalyzerResults.create("velociraptor_dna");
    public static final ResourceKey<AnalyzerResult> CARNOTAURUS_DNA = FossilsLegacyAnalyzerResults.create("carnotaurus_dna");
    public static final ResourceKey<AnalyzerResult> CRYOLOPHOSAURUS_DNA = FossilsLegacyAnalyzerResults.create("cryolophosaurus_dna");
    public static final ResourceKey<AnalyzerResult> THERIZINOSAURUS_DNA = FossilsLegacyAnalyzerResults.create("therizinosaurus_dna");
    public static final ResourceKey<AnalyzerResult> PACHYCEPHALOSAURUS_DNA = FossilsLegacyAnalyzerResults.create("pachycephalosaurus_dna");
    public static final ResourceKey<AnalyzerResult> COMPSOGNATHUS_DNA = FossilsLegacyAnalyzerResults.create("compsognathus_dna");
    public static final ResourceKey<AnalyzerResult> DODO_DNA = FossilsLegacyAnalyzerResults.create("dodo_dna");
    public static final ResourceKey<AnalyzerResult> MOA_DNA = FossilsLegacyAnalyzerResults.create("moa_dna");
    public static final ResourceKey<AnalyzerResult> GALLIMIMUS_DNA = FossilsLegacyAnalyzerResults.create("gallimimus_dna");
    public static final ResourceKey<AnalyzerResult> SPINOSAURUS_DNA = FossilsLegacyAnalyzerResults.create("spinosaurus_dna");
    public static final ResourceKey<AnalyzerResult> ANKYLOSAURUS_DNA = FossilsLegacyAnalyzerResults.create("ankylosaurus_dna");
    public static final ResourceKey<AnalyzerResult> DIMETRODON_DNA = FossilsLegacyAnalyzerResults.create("dimetrodon_dna");

    private static ResourceKey<AnalyzerResult> create(String name) {
        return ResourceKey.create(FossilsLegacyRegistries.ANALYZER_RESULT, FossilsLegacyUtils.resource(name));
    }

    private static void register(BootstrapContext<AnalyzerResult> bootstrapContext, List<ResourceKey<AnalyzerResult>> results, String path, ItemStack result, int weight) {
        ResourceKey<AnalyzerResult> resourceKey = FossilsLegacyAnalyzerResults.create(path + "/" + BuiltInRegistries.ITEM.getKey(result.getItem()).getPath());
        FossilsLegacyAnalyzerResults.register(bootstrapContext, resourceKey, result, weight);
        results.add(resourceKey);
    }

    private static void register(BootstrapContext<AnalyzerResult> bootstrapContext, ResourceKey<AnalyzerResult> resourceKey, ItemStack result, int weight) {
        bootstrapContext.register(resourceKey, new AnalyzerResult(result, weight));
    }

    public static void bootstrap(BootstrapContext<AnalyzerResult> bootstrapContext) {
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(Items.BONE_MEAL), 60);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.JURASSIC_FERN_DNA.get()), 20);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.LEPIDODENDRON_DNA.get()), 10);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.SIGILLARIA_DNA.get()), 10);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.CALAMITES_DNA.get()), 10);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.BRACHIOSAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.DILOPHOSAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.MOSASAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.NAUTILUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.FUTABASAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.GALLIMIMUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.PTERANODON_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.STEGOSAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.TRICERATOPS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.ANKYLOSAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.DIMETRODON_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.TYRANNOSAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.VELOCIRAPTOR_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.CARNOTAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.CRYOLOPHOSAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.THERIZINOSAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.PACHYCEPHALOSAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.COMPSOGNATHUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, "fossil_results", new ItemStack(FossilsLegacyItems.SPINOSAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(Blocks.GRAVEL), 40);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FossilsLegacyItems.STONE_TABLET.get()), 30);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(Items.FLINT), 20);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get()), 5);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FossilsLegacyItems.ANCIENT_SHOVEL_ARTIFACT.get()), 5);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FossilsLegacyItems.ANCIENT_PICKAXE_ARTIFACT.get()), 5);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FossilsLegacyItems.ANCIENT_AXE_ARTIFACT.get()), 5);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FossilsLegacyItems.ANCIENT_HOE_ARTIFACT.get()), 5);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get()), 5);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FossilsLegacyItems.ANCIENT_CHESTPLATE_ARTIFACT.get()), 5);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FossilsLegacyItems.ANCIENT_LEGGINGS_ARTIFACT.get()), 5);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FossilsLegacyItems.ANCIENT_BOOTS_ARTIFACT.get()), 5);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, RELIC_SCRAP_RESULTS, "relic_scarp_results", new ItemStack(FossilsLegacyItems.PREHISTORIC_COIN.get()), 1);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FROZEN_MEAT_RESULTS, "relic_scarp_results", new ItemStack(FossilsLegacyItems.SMILODON_DNA.get()), 33);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FROZEN_MEAT_RESULTS, "relic_scarp_results", new ItemStack(FossilsLegacyItems.MAMMOTH_DNA.get()), 33);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FROZEN_MEAT_RESULTS, "relic_scarp_results", new ItemStack(FossilsLegacyItems.DODO_DNA.get()), 33);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FROZEN_MEAT_RESULTS, "relic_scarp_results", new ItemStack(FossilsLegacyItems.MOA_DNA.get()), 33);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FROZEN_MEAT_RESULTS, "relic_scarp_results", new ItemStack(Items.BEEF), 33);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, AXOLOTL_DNA, new ItemStack(FossilsLegacyItems.AXOLOTL_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, PIG_DNA, new ItemStack(FossilsLegacyItems.PIG_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, COW_DNA, new ItemStack(FossilsLegacyItems.COW_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, CHICKEN_DNA, new ItemStack(FossilsLegacyItems.CHICKEN_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FEATHER_RESULTS, "feather_results", new ItemStack(FossilsLegacyItems.CHICKEN_DNA.get()), 50);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FEATHER_RESULTS, "feather_results", new ItemStack(FossilsLegacyItems.PARROT_DNA.get()), 50);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, PANDA_DNA, new ItemStack(FossilsLegacyItems.PANDA_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, SHEEP_DNA, new ItemStack(FossilsLegacyItems.SHEEP_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, RABBIT_DNA, new ItemStack(FossilsLegacyItems.RABBIT_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, WOLF_DNA, new ItemStack(FossilsLegacyItems.WOLF_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOX_DNA, new ItemStack(FossilsLegacyItems.FOX_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, GOAT_DNA, new ItemStack(FossilsLegacyItems.GOAT_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FROG_DNA, new ItemStack(FossilsLegacyItems.FROG_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, LEATHER_RESULTS, "leather_results", new ItemStack(FossilsLegacyItems.COW_DNA.get()), 20);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, LEATHER_RESULTS, "leather_results", new ItemStack(FossilsLegacyItems.LLAMA_DNA.get()), 20);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, LEATHER_RESULTS, "leather_results", new ItemStack(FossilsLegacyItems.HORSE_DNA.get()), 20);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, LEATHER_RESULTS, "leather_results", new ItemStack(FossilsLegacyItems.DONKEY_DNA.get()), 20);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, LEATHER_RESULTS, "leather_results", new ItemStack(FossilsLegacyItems.MULE_DNA.get()), 20);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, STRING_RESULTS, "string_results", new ItemStack(FossilsLegacyItems.CAT_DNA.get()), 33);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, STRING_RESULTS, "string_results", new ItemStack(FossilsLegacyItems.OCELOT_DNA.get()), 33);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, STRING_RESULTS, "string_results", new ItemStack(FossilsLegacyItems.FOX_DNA.get()), 33);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, COD_RESULTS, "cod_results", new ItemStack(FossilsLegacyItems.POLAR_BEAR_DNA.get()), 50);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, COD_RESULTS, "cod_results", new ItemStack(FossilsLegacyItems.DOLPHIN_DNA.get()), 50);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, POLAR_BEAR_DNA, new ItemStack(FossilsLegacyItems.POLAR_BEAR_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, ARMADILLO_DNA, new ItemStack(FossilsLegacyItems.ARMADILLO_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, BRACHIOSAURUS_DNA, new ItemStack(FossilsLegacyItems.BRACHIOSAURUS_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, DILOPHOSAURUS_DNA, new ItemStack(FossilsLegacyItems.DILOPHOSAURUS_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, MAMMOTH_DNA, new ItemStack(FossilsLegacyItems.MAMMOTH_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, MOSASAURUS_DNA, new ItemStack(FossilsLegacyItems.MOSASAURUS_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FUTABASAURUS_DNA, new ItemStack(FossilsLegacyItems.FUTABASAURUS_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, PTERANODON_DNA, new ItemStack(FossilsLegacyItems.PTERANODON_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, SMILODON_DNA, new ItemStack(FossilsLegacyItems.SMILODON_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, STEGOSAURUS_DNA, new ItemStack(FossilsLegacyItems.STEGOSAURUS_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, TRICERATOPS_DNA, new ItemStack(FossilsLegacyItems.TRICERATOPS_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, TYRANNOSAURUS_DNA, new ItemStack(FossilsLegacyItems.TYRANNOSAURUS_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, VELOCIRAPTOR_DNA, new ItemStack(FossilsLegacyItems.VELOCIRAPTOR_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, CARNOTAURUS_DNA, new ItemStack(FossilsLegacyItems.CARNOTAURUS_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, CRYOLOPHOSAURUS_DNA, new ItemStack(FossilsLegacyItems.CRYOLOPHOSAURUS_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, THERIZINOSAURUS_DNA, new ItemStack(FossilsLegacyItems.THERIZINOSAURUS_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, PACHYCEPHALOSAURUS_DNA, new ItemStack(FossilsLegacyItems.PACHYCEPHALOSAURUS_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, COMPSOGNATHUS_DNA, new ItemStack(FossilsLegacyItems.COMPSOGNATHUS_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, DODO_DNA, new ItemStack(FossilsLegacyItems.DODO_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, MOA_DNA, new ItemStack(FossilsLegacyItems.MOA_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, GALLIMIMUS_DNA, new ItemStack(FossilsLegacyItems.GALLIMIMUS_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, SPINOSAURUS_DNA, new ItemStack(FossilsLegacyItems.SPINOSAURUS_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, ANKYLOSAURUS_DNA, new ItemStack(FossilsLegacyItems.ANKYLOSAURUS_DNA.get()), 100);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, DIMETRODON_DNA, new ItemStack(FossilsLegacyItems.DIMETRODON_DNA.get()), 100);
    }
}
