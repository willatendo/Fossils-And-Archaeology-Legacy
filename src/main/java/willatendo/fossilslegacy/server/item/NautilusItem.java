package willatendo.fossilslegacy.server.item;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.HitResult;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;
import willatendo.fossilslegacy.server.entity.Nautilus;

public class NautilusItem extends Item {
	public NautilusItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
		ItemStack itemStack = player.getItemInHand(interactionHand);
		HitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);
		if (hitResult.getType() == HitResult.Type.MISS) {
			return InteractionResultHolder.pass(itemStack);
		} else {
			if (hitResult.getType() == HitResult.Type.BLOCK) {
				Nautilus nautilus = FossilsLegacyEntities.NAUTILUS.get().create(level);
				if (!level.noCollision(nautilus, nautilus.getBoundingBox())) {
					return InteractionResultHolder.fail(itemStack);
				} else {
					if (!level.isClientSide()) {
						nautilus.moveTo(hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z, (float) level.getRandom().nextInt(180), 0.0F);
						level.addFreshEntity(nautilus);
						level.gameEvent(player, GameEvent.ENTITY_PLACE, hitResult.getLocation());
						if (!player.getAbilities().instabuild) {
							itemStack.shrink(1);
						}
					}

					player.awardStat(Stats.ITEM_USED.get(this));
					return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
				}
			} else {
				return InteractionResultHolder.pass(itemStack);
			}
		}
	}
}
