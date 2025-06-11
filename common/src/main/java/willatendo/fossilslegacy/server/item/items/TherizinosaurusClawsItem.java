package willatendo.fossilslegacy.server.item.items;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class TherizinosaurusClawsItem extends SwordItem {
    public static final ResourceLocation BASE_SWEEPING_RATIO_ID = ResourceLocation.withDefaultNamespace("base_sweeping_ratio");

    public TherizinosaurusClawsItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(toolMaterial, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean canAttackBlock(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        return !player.isCreative();
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity targetLivingEntity, LivingEntity attackingLivingEntity) {
        return true;
    }

    @Override
    public void postHurtEnemy(ItemStack itemStack, LivingEntity targetLivingEntity, LivingEntity attackingLivingEntity) {
        itemStack.hurtAndBreak(1, attackingLivingEntity, EquipmentSlot.MAINHAND);
    }
}
