package willatendo.fossilslegacy.server.item.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.jewel_recovery.JewelRecovery;
import willatendo.fossilslegacy.server.registry.FARegistries;

public class AncientPickaxeItem extends PickaxeItem {
    public AncientPickaxeItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Properties properties) {
        super(toolMaterial, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState blockState, BlockPos blockPos, LivingEntity livingEntity) {
        if (!level.isClientSide()) {
            RandomSource randomSource = level.getRandom();
            if (randomSource.nextInt(5) == 0) {
                Registry<JewelRecovery> registry = level.registryAccess().lookupOrThrow(FARegistries.JEWEL_RECOVERY);
                registry.forEach(jewelRecoveryRecipe -> {
                    if (jewelRecoveryRecipe.block().equals(BuiltInRegistries.BLOCK.getKey(blockState.getBlock()))) {
                        Block.popResource(level, blockPos, jewelRecoveryRecipe.getJewels().getRandomValue(randomSource).get());
                    }
                });
            }
        }
        return super.mineBlock(itemStack, level, blockState, blockPos, livingEntity);
    }
}
