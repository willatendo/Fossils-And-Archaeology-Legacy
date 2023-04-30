package fossilslegacy.server.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class AncientSwordItem extends SwordItem {
	public AncientSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
		super(tier, attackDamage, attackSpeed, properties);
	}

	@Override
	public boolean hurtEnemy(ItemStack itemStack, LivingEntity victim, LivingEntity user) {
		Level level = victim.level;
		LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(level);
		lightningBolt.moveTo(Vec3.atBottomCenterOf(victim.blockPosition()));
		level.addFreshEntity(lightningBolt);
		if (level.isClientSide()) {
			level.playSound(user, victim.blockPosition(), SoundEvents.LIGHTNING_BOLT_THUNDER, SoundSource.BLOCKS, 1.0F, 1.0F);
		}
		return super.hurtEnemy(itemStack, victim, user);
	}
}
