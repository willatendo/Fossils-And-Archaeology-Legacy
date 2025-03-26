package willatendo.fossilslegacy.server.item.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.item.FAItems;

import java.util.List;

public class FrozenMeatItem extends Item {
    public FrozenMeatItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(FrozenMeatItem.applyFrozenMeatProperties(toolMaterial, properties, attackDamage, attackSpeed));
    }

    public static Item.Properties applyFrozenMeatProperties(ToolMaterial toolMaterial, Item.Properties properties, float attackDamage, float attackSpeed) {
        HolderGetter<Block> blockHolderGetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);
        return properties.repairable(toolMaterial.repairItems()).enchantable(toolMaterial.enchantmentValue()).component(DataComponents.TOOL, new Tool(List.of(Tool.Rule.minesAndDrops(HolderSet.direct(Blocks.COBWEB.builtInRegistryHolder()), 15.0F), Tool.Rule.overrideSpeed(blockHolderGetter.getOrThrow(BlockTags.SWORD_EFFICIENT), 1.5F)), 1.0F, 2)).attributes(FrozenMeatItem.createSwordAttributes(toolMaterial, attackDamage, attackSpeed));
    }

    private static ItemAttributeModifiers createSwordAttributes(ToolMaterial toolMaterial, float attackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, attackDamage + toolMaterial.attackDamageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }

    @Override
    public boolean canAttackBlock(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        return !player.isCreative();
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity victem, LivingEntity attacker) {
        if (attacker instanceof Player player && !player.isCreative()) {
            if (itemStack.getCount() > 1) {
                ItemStack brokenItemStack = new ItemStack(FAItems.BROKEN_FROZEN_MEAT.get());
                if (player instanceof ServerPlayer) {
                    brokenItemStack.setDamageValue(1);
                }
                player.addItem(brokenItemStack);
                itemStack.shrink(1);
            } else {
                ItemStack brokenItemStack = new ItemStack(FAItems.BROKEN_FROZEN_MEAT.get());
                if (player instanceof ServerPlayer) {
                    brokenItemStack.setDamageValue(1);
                }
                player.setItemInHand(player.getUsedItemHand(), brokenItemStack);
            }
            return true;
        }
        return true;
    }
}
