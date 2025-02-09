package willatendo.fossilslegacy.server.item.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class AncientShovelItem extends ShovelItem {
    public AncientShovelItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Properties properties) {
        super(toolMaterial, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState blockState, BlockPos blockPos, LivingEntity livingEntity) {
        if (level.getRandom().nextInt(5) == 0) {
            Block.dropResources(blockState, level, blockPos);
        }
        return super.mineBlock(itemStack, level, blockState, blockPos, livingEntity);
    }
}
