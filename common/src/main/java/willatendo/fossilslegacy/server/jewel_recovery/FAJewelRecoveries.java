package willatendo.fossilslegacy.server.jewel_recovery;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public final class FAJewelRecoveries {
    private static ResourceKey<JewelRecovery> create(String name) {
        return ResourceKey.create(FARegistries.JEWEL_RECOVERY, FossilsLegacyUtils.resource(name));
    }

    private static void register(BootstrapContext<JewelRecovery> bootstrapContext, Block input, JewelRecovery.JewelEntry... jewelEntries) {
        ResourceLocation id = BuiltInRegistries.BLOCK.getKey(input);
        bootstrapContext.register(FAJewelRecoveries.create(id.getPath()), new JewelRecovery(id, List.of(jewelEntries)));
    }

    public static void bootstrap(BootstrapContext<JewelRecovery> bootstrapContext) {
        FAJewelRecoveries.register(bootstrapContext, Blocks.DEEPSLATE, new JewelRecovery.JewelEntry(new ItemStack(Items.REDSTONE), 8), new JewelRecovery.JewelEntry(new ItemStack(Items.EMERALD), 7), new JewelRecovery.JewelEntry(new ItemStack(Items.DIAMOND), 5));
        FAJewelRecoveries.register(bootstrapContext, Blocks.STONE, new JewelRecovery.JewelEntry(new ItemStack(Items.RAW_IRON), 25), new JewelRecovery.JewelEntry(new ItemStack(Items.RAW_GOLD), 20), new JewelRecovery.JewelEntry(new ItemStack(Items.REDSTONE), 5), new JewelRecovery.JewelEntry(new ItemStack(Items.EMERALD), 3), new JewelRecovery.JewelEntry(new ItemStack(Items.DIAMOND), 1));
        FAJewelRecoveries.register(bootstrapContext, Blocks.ANDESITE, new JewelRecovery.JewelEntry(new ItemStack(Items.RAW_IRON), 25), new JewelRecovery.JewelEntry(new ItemStack(Items.RAW_GOLD), 20), new JewelRecovery.JewelEntry(new ItemStack(Items.REDSTONE), 5), new JewelRecovery.JewelEntry(new ItemStack(Items.EMERALD), 3), new JewelRecovery.JewelEntry(new ItemStack(Items.DIAMOND), 1));
        FAJewelRecoveries.register(bootstrapContext, Blocks.GRANITE, new JewelRecovery.JewelEntry(new ItemStack(Items.RAW_IRON), 25), new JewelRecovery.JewelEntry(new ItemStack(Items.RAW_GOLD), 20), new JewelRecovery.JewelEntry(new ItemStack(Items.REDSTONE), 5), new JewelRecovery.JewelEntry(new ItemStack(Items.EMERALD), 3), new JewelRecovery.JewelEntry(new ItemStack(Items.DIAMOND), 1));
        FAJewelRecoveries.register(bootstrapContext, Blocks.DIORITE, new JewelRecovery.JewelEntry(new ItemStack(Items.RAW_IRON), 25), new JewelRecovery.JewelEntry(new ItemStack(Items.RAW_GOLD), 20), new JewelRecovery.JewelEntry(new ItemStack(Items.REDSTONE), 5), new JewelRecovery.JewelEntry(new ItemStack(Items.EMERALD), 3), new JewelRecovery.JewelEntry(new ItemStack(Items.DIAMOND), 1));
        FAJewelRecoveries.register(bootstrapContext, Blocks.TUFF, new JewelRecovery.JewelEntry(new ItemStack(Items.RAW_IRON), 25), new JewelRecovery.JewelEntry(new ItemStack(Items.RAW_GOLD), 20), new JewelRecovery.JewelEntry(new ItemStack(Items.REDSTONE), 5), new JewelRecovery.JewelEntry(new ItemStack(Items.EMERALD), 3), new JewelRecovery.JewelEntry(new ItemStack(Items.DIAMOND), 1));
    }
}
