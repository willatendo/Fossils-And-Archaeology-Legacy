package willatendo.fossilslegacy.server.item.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.ancient_axe_bonus.AncientAxeBonus;
import willatendo.fossilslegacy.server.registry.FARegistries;

public class AncientAxeItem extends AxeItem {
    public AncientAxeItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Properties properties) {
        super(toolMaterial, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState blockState, BlockPos blockPos, LivingEntity livingEntity) {
        if (!level.isClientSide()) {
            RandomSource randomSource = level.getRandom();
            if (randomSource.nextInt(5) == 0) {
                Registry<AncientAxeBonus> registry = level.registryAccess().lookupOrThrow(FARegistries.ANCIENT_AXE_BONUS);
                registry.forEach(ancientAxeCrafting -> {
                    if (ancientAxeCrafting.input().equals(BuiltInRegistries.BLOCK.getKey(blockState.getBlock()))) {
                        ItemStack output = ancientAxeCrafting.output();
                        output.setCount(ancientAxeCrafting.minDrop() + (randomSource.nextInt(ancientAxeCrafting.maxDrop())));
                        Block.popResource(level, blockPos, output);
                    }
                });
            }
        }
        return super.mineBlock(itemStack, level, blockState, blockPos, livingEntity);
    }
}
