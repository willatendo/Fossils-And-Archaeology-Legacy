package fossilslegacy.server.item;

import fossilslegacy.server.entity.HungryAnimal;
import fossilslegacy.server.entity.TameAccessor;
import fossilslegacy.server.entity.pregnant.PregnantAnimal;
import fossilslegacy.server.utils.SyringeAnimals;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SyringeItem extends Item {
	private final SyringeAnimals syringeAnimals;

	public SyringeItem(SyringeAnimals syringeAnimals, Properties properties) {
		super(properties);
		this.syringeAnimals = syringeAnimals;
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
		if (PregnantAnimal.getFromLivingEntity(livingEntity, player.level()) != null) {
			PregnantAnimal<?> pregnantAnimal = PregnantAnimal.createFromLiving(livingEntity, player.level());
			pregnantAnimal.setPregnancy(this.getSyringeAnimals());
			pregnantAnimal.setRemainingPregnancyTime(6000);
			if (pregnantAnimal instanceof HungryAnimal hungryAnimal) {
				hungryAnimal.setHunger(((HungryAnimal) pregnantAnimal).getHunger());
			}
			if (pregnantAnimal instanceof TameAccessor tameAccessor) {
				tameAccessor.setOwnerUUID(((TameAccessor) pregnantAnimal).getOwnerUUID());
			}
			itemStack.shrink(1);
			return InteractionResult.sidedSuccess(player.level().isClientSide());
		}
		return super.interactLivingEntity(itemStack, player, livingEntity, interactionHand);
	}

	public SyringeAnimals getSyringeAnimals() {
		return this.syringeAnimals;
	}
}
