package willatendo.fossilslegacy.server.ancient_axe_bonus;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FAAncientAxeBonuses {
    public static final ResourceKey<AncientAxeBonus> OAK_LOG_TO_OAK_PLANKS = FAAncientAxeBonuses.create("oak_log_to_oak_planks");
    public static final ResourceKey<AncientAxeBonus> BIRCH_LOG_TO_BIRCH_PLANKS = FAAncientAxeBonuses.create("birch_log_to_birch_planks");
    public static final ResourceKey<AncientAxeBonus> JUNGLE_LOG_TO_JUNGLE_PLANKS = FAAncientAxeBonuses.create("jungle_log_to_jungle_planks");
    public static final ResourceKey<AncientAxeBonus> SPRUCE_LOG_TO_SPRUCE_PLANKS = FAAncientAxeBonuses.create("spruce_log_to_spruce_planks");
    public static final ResourceKey<AncientAxeBonus> ACACIA_LOG_TO_ACACIA_PLANKS = FAAncientAxeBonuses.create("acacia_log_to_acacia_planks");
    public static final ResourceKey<AncientAxeBonus> DARK_OAK_LOG_TO_DARK_OAK_PLANKS = FAAncientAxeBonuses.create("dark_oak_log_to_dark_oak_planks");
    public static final ResourceKey<AncientAxeBonus> CRIMSON_STEM_TO_CRIMSON_PLANKS = FAAncientAxeBonuses.create("crimson_log_to_crimson_planks");
    public static final ResourceKey<AncientAxeBonus> WARPED_STEM_TO_WARPED_PLANKS = FAAncientAxeBonuses.create("warped_log_to_warped_planks");
    public static final ResourceKey<AncientAxeBonus> MANGROVE_LOG_TO_MANGROVE_PLANKS = FAAncientAxeBonuses.create("mangrove_log_to_mangrove_planks");
    public static final ResourceKey<AncientAxeBonus> CHERRY_LOG_TO_CHERRY_PLANKS = FAAncientAxeBonuses.create("cherry_log_to_cherry_planks");
    public static final ResourceKey<AncientAxeBonus> ARAUCARIA_LOG_TO_ARAUCARIA_PLANKS = FAAncientAxeBonuses.create("araucaria_log_to_araucaria_planks");
    public static final ResourceKey<AncientAxeBonus> ARCHAEOPTERIS_LOG_TO_ARCHAEOPTERIS_PLANKS = FAAncientAxeBonuses.create("archaeopteris_log_to_archaeopteris_planks");
    public static final ResourceKey<AncientAxeBonus> CALAMITES_LOG_TO_CALAMITES_PLANKS = FAAncientAxeBonuses.create("calamites_log_to_calamites_planks");
    public static final ResourceKey<AncientAxeBonus> GINKGO_LOG_TO_GINKGO_PLANKS = FAAncientAxeBonuses.create("ginkgo_log_to_ginkgo_planks");
    public static final ResourceKey<AncientAxeBonus> LEPIDODENDRON_LOG_TO_LEPIDODENDRON_PLANKS = FAAncientAxeBonuses.create("lepidodendron_log_to_lepidodendron_planks");
    public static final ResourceKey<AncientAxeBonus> SIGILLARIA_LOG_TO_SIGILLARIA_PLANKS = FAAncientAxeBonuses.create("sigillaria_log_to_sigillaria_planks");
    public static final ResourceKey<AncientAxeBonus> ARAUCARIOXYLON_LOG_TO_ARAUCARIOXYLON_PLANKS = FAAncientAxeBonuses.create("araucarioxylon_log_to_araucarioxylon_planks");
    public static final ResourceKey<AncientAxeBonus> CORDAITES_LOG_TO_CORDAITES_PLANKS = FAAncientAxeBonuses.create("cordaites_log_to_cordaites_planks");
    public static final ResourceKey<AncientAxeBonus> WOLLEMIA_LOG_TO_WOLLEMIA_PLANKS = FAAncientAxeBonuses.create("wollemia_log_to_wollemia_planks");

    private static ResourceKey<AncientAxeBonus> create(String name) {
        return ResourceKey.create(FARegistries.ANCIENT_AXE_BONUS, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<AncientAxeBonus> bootstrapContext, ResourceKey<AncientAxeBonus> resourceKey, Block input, ItemStack output, int minDrop, int maxDrop) {
        bootstrapContext.register(resourceKey, new AncientAxeBonus(BuiltInRegistries.BLOCK.getKey(input), output, minDrop, maxDrop));
    }

    public static void bootstrap(BootstrapContext<AncientAxeBonus> bootstrapContext) {
        FAAncientAxeBonuses.register(bootstrapContext, OAK_LOG_TO_OAK_PLANKS, Blocks.OAK_LOG, new ItemStack(Blocks.OAK_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, BIRCH_LOG_TO_BIRCH_PLANKS, Blocks.BIRCH_LOG, new ItemStack(Blocks.BIRCH_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, JUNGLE_LOG_TO_JUNGLE_PLANKS, Blocks.JUNGLE_LOG, new ItemStack(Blocks.JUNGLE_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, SPRUCE_LOG_TO_SPRUCE_PLANKS, Blocks.SPRUCE_LOG, new ItemStack(Blocks.SPRUCE_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, ACACIA_LOG_TO_ACACIA_PLANKS, Blocks.ACACIA_LOG, new ItemStack(Blocks.ACACIA_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, DARK_OAK_LOG_TO_DARK_OAK_PLANKS, Blocks.DARK_OAK_LOG, new ItemStack(Blocks.DARK_OAK_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, MANGROVE_LOG_TO_MANGROVE_PLANKS, Blocks.MANGROVE_LOG, new ItemStack(Blocks.MANGROVE_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, CRIMSON_STEM_TO_CRIMSON_PLANKS, Blocks.CRIMSON_STEM, new ItemStack(Blocks.CRIMSON_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, WARPED_STEM_TO_WARPED_PLANKS, Blocks.WARPED_STEM, new ItemStack(Blocks.WARPED_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, CHERRY_LOG_TO_CHERRY_PLANKS, Blocks.CHERRY_LOG, new ItemStack(Blocks.CHERRY_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, ARAUCARIA_LOG_TO_ARAUCARIA_PLANKS, FABlocks.ARAUCARIA_LOG.get(), new ItemStack(FABlocks.ARAUCARIA_PLANKS.get()), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, ARCHAEOPTERIS_LOG_TO_ARCHAEOPTERIS_PLANKS, FABlocks.ARCHAEOPTERIS_LOG.get(), new ItemStack(FABlocks.ARCHAEOPTERIS_PLANKS.get()), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, CALAMITES_LOG_TO_CALAMITES_PLANKS, FABlocks.CALAMITES_LOG.get(), new ItemStack(FABlocks.CALAMITES_PLANKS.get()), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, GINKGO_LOG_TO_GINKGO_PLANKS, FABlocks.GINKGO_LOG.get(), new ItemStack(FABlocks.GINKGO_PLANKS.get()), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, LEPIDODENDRON_LOG_TO_LEPIDODENDRON_PLANKS, FABlocks.LEPIDODENDRON_LOG.get(), new ItemStack(FABlocks.LEPIDODENDRON_PLANKS.get()), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, SIGILLARIA_LOG_TO_SIGILLARIA_PLANKS, FABlocks.SIGILLARIA_LOG.get(), new ItemStack(FABlocks.SIGILLARIA_PLANKS.get()), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, ARAUCARIOXYLON_LOG_TO_ARAUCARIOXYLON_PLANKS, FABlocks.ARAUCARIOXYLON_LOG.get(), new ItemStack(FABlocks.ARAUCARIOXYLON_PLANKS.get()), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, CORDAITES_LOG_TO_CORDAITES_PLANKS, FABlocks.CORDAITES_LOG.get(), new ItemStack(FABlocks.CORDAITES_PLANKS.get()), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, WOLLEMIA_LOG_TO_WOLLEMIA_PLANKS, FABlocks.WOLLEMIA_LOG.get(), new ItemStack(FABlocks.WOLLEMIA_PLANKS.get()), 1, 3);
    }
}
