package fossilslegacy.server.item;

import java.util.Optional;

import fossilslegacy.server.entity.CavePainting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class CavePaintingItem extends Item {
	public CavePaintingItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext useOnContext) {
		BlockPos blockpos = useOnContext.getClickedPos();
		Direction direction = useOnContext.getClickedFace();
		BlockPos blockpos1 = blockpos.relative(direction);
		Player player = useOnContext.getPlayer();
		ItemStack itemstack = useOnContext.getItemInHand();
		if (player != null && !this.mayPlace(player, direction, itemstack, blockpos1)) {
			return InteractionResult.FAIL;
		} else {
			Level level = useOnContext.getLevel();
			HangingEntity hangingentity = null;
			Optional<CavePainting> cavePainting = CavePainting.create(level, blockpos1, direction);
			if (!cavePainting.isEmpty()) {
				hangingentity = cavePainting.get();
			}

			CompoundTag compoundtag = itemstack.getTag();
			if (compoundtag != null) {
				EntityType.updateCustomEntityTag(level, player, hangingentity, compoundtag);
			}

			if (hangingentity.survives()) {
				if (!level.isClientSide()) {
					hangingentity.playPlacementSound();
					level.gameEvent(player, GameEvent.ENTITY_PLACE, hangingentity.position());
					level.addFreshEntity(hangingentity);
				}

				itemstack.shrink(1);
				return InteractionResult.sidedSuccess(level.isClientSide);
			} else {
				return InteractionResult.CONSUME;
			}
		}
	}

	protected boolean mayPlace(Player player, Direction direction, ItemStack itemStack, BlockPos blockPos) {
		return !direction.getAxis().isVertical() && player.mayUseItemAt(blockPos, direction, itemStack);
	}
}
