package willatendo.fossilslegacy.server.item.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class TherizinosaurusClawsItem extends SwordItem {
    public static final ResourceLocation BASE_SWEEPING_RATIO_ID = ResourceLocation.withDefaultNamespace("base_sweeping_ratio");

    public TherizinosaurusClawsItem(Tier tier, Item.Properties properties) {
        super(tier, properties.component(DataComponents.TOOL, TherizinosaurusClawsItem.createToolProperties(tier)));
    }

    private static Tool createToolProperties(Tier tier) {
        return new Tool(List.of(Tool.Rule.deniesDrops(tier.getIncorrectBlocksForDrops())), 1.0F, 1);
    }

    public static ItemAttributeModifiers createAttributes(Tier tier, int attackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, attackDamage + tier.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.SWEEPING_DAMAGE_RATIO, new AttributeModifier(BASE_SWEEPING_RATIO_ID, 1.0F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
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
