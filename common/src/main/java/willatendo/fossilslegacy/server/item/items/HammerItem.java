package willatendo.fossilslegacy.server.item.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;

public class HammerItem extends Item {
    public HammerItem(ToolMaterial material, float attackDamage, float attackSpeed, Properties properties) {
        super(material.applySwordProperties(properties, attackDamage, attackSpeed));
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        return true;
    }
}
