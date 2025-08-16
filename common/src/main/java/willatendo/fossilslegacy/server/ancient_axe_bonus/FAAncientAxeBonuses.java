package willatendo.fossilslegacy.server.ancient_axe_bonus;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.server.registry.FABlockRegistry;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FAAncientAxeBonuses {
    private static ResourceKey<AncientAxeBonus> create(String name) {
        return ResourceKey.create(FARegistries.ANCIENT_AXE_BONUS, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<AncientAxeBonus> bootstrapContext, Block input, ItemStack output, int minDrop, int maxDrop) {
        ResourceLocation inputId = BuiltInRegistries.BLOCK.getKey(input);
        bootstrapContext.register(FAAncientAxeBonuses.create(inputId.getPath() + "_to_" + BuiltInRegistries.ITEM.getKey(output.getItem()).getPath()), new AncientAxeBonus(inputId, output, minDrop, maxDrop));
    }

    private static void register(BootstrapContext<AncientAxeBonus> bootstrapContext, ResourceKey<AncientAxeBonus> resourceKey, Block input, ItemStack output, int minDrop, int maxDrop) {
        bootstrapContext.register(resourceKey, new AncientAxeBonus(BuiltInRegistries.BLOCK.getKey(input), output, minDrop, maxDrop));
    }

    public static void bootstrap(BootstrapContext<AncientAxeBonus> bootstrapContext) {
        FAAncientAxeBonuses.register(bootstrapContext, Blocks.OAK_LOG, new ItemStack(Blocks.OAK_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, Blocks.BIRCH_LOG, new ItemStack(Blocks.BIRCH_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, Blocks.JUNGLE_LOG, new ItemStack(Blocks.JUNGLE_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, Blocks.SPRUCE_LOG, new ItemStack(Blocks.SPRUCE_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, Blocks.ACACIA_LOG, new ItemStack(Blocks.ACACIA_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, Blocks.DARK_OAK_LOG, new ItemStack(Blocks.DARK_OAK_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, Blocks.MANGROVE_LOG, new ItemStack(Blocks.MANGROVE_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, Blocks.CRIMSON_STEM, new ItemStack(Blocks.CRIMSON_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, Blocks.WARPED_STEM, new ItemStack(Blocks.WARPED_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, Blocks.CHERRY_LOG, new ItemStack(Blocks.CHERRY_PLANKS), 1, 3);
        FAAncientAxeBonuses.register(bootstrapContext, Blocks.PALE_OAK_LOG, new ItemStack(Blocks.PALE_OAK_PLANKS), 1, 3);
        for (int i = 0; i < FABlockRegistry.woodSize(); i++) {
            FAAncientAxeBonuses.register(bootstrapContext, FABlockRegistry.getLog(i).get(), new ItemStack(FABlockRegistry.getPlanks(i).get()), 1, 3);
        }
    }
}
