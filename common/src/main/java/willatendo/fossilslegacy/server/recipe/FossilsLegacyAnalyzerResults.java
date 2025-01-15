package willatendo.fossilslegacy.server.recipe;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FossilsLegacyAnalyzerResults {
    public static final List<ResourceKey<AnalyzerResult>> FOSSIL_RESULTS = new ArrayList<>();
    public static final List<ResourceKey<AnalyzerResult>> RELIC_SCRAP_RESULTS = new ArrayList<>();
    public static final List<ResourceKey<AnalyzerResult>> FROZEN_MEAT_RESULTS = new ArrayList<>();

    private static void register(BootstrapContext<AnalyzerResult> bootstrapContext, List<ResourceKey<AnalyzerResult>> results, ItemStack result, int weight, List<ResourceKey<AnalyzerResult>>... otherResults) {
        ResourceKey<AnalyzerResult> resourceKey = ResourceKey.create(FossilsLegacyRegistries.ANALYZER_RESULT, FossilsLegacyUtils.resource(BuiltInRegistries.ITEM.getKey(result.getItem()).getPath()));
        FossilsLegacyAnalyzerResults.register(bootstrapContext, resourceKey, result, weight);
        results.add(resourceKey);
        for (List<ResourceKey<AnalyzerResult>> otherResultsList : otherResults) {
            otherResultsList.add(resourceKey);
        }
    }

    private static void register(BootstrapContext<AnalyzerResult> bootstrapContext, ResourceKey<AnalyzerResult> resourceKey, ItemStack result, int weight) {
        bootstrapContext.register(resourceKey, new AnalyzerResult(result, weight));
    }

    public static void bootstrap(BootstrapContext<AnalyzerResult> bootstrapContext) {
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(Items.BONE_MEAL), 60);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.JURASSIC_FERN_SPORES.get()), 20);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.PETRIFIED_LEPIDODENDRON_SAPLING.get()), 10);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.PETRIFIED_SIGILLARIA_SAPLING.get()), 10);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.PETRIFIED_CALAMITES_SAPLING.get()), 10);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.BRACHIOSAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.DILOPHOSAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.MOSASAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.NAUTILUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.FUTABASAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.GALLIMIMUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.PTERANODON_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.STEGOSAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.TRICERATOPS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.ANKYLOSAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.DIMETRODON_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.TYRANNOSAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.VELOCIRAPTOR_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.CARNOTAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.CRYOLOPHOSAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.THERIZINOSAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.PACHYCEPHALOSAURUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.COMPSOGNATHUS_DNA.get()), 2);
        FossilsLegacyAnalyzerResults.register(bootstrapContext, FOSSIL_RESULTS, new ItemStack(FossilsLegacyItems.SPINOSAURUS_DNA.get()), 2);
    }
}
