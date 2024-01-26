package willatendo.fossilslegacy.server.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import willatendo.fossilslegacy.server.entity.Egg;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;

public class EggItem extends PlaceEntityItem {
	private final Egg.EggType eggs;

	public EggItem(Egg.EggType eggs, Properties properties) {
		super(() -> FossilsLegacyEntities.EGG.get(), properties);
		this.eggs = eggs;
	}
	
	@Override
	public void entityModification(Entity entity) {
		if(entity instanceof Egg egg) {
			egg.setEgg(this.eggs);
			egg.setRemainingTime(0);
		}
	}

	@Override
	public InteractionResult useOn(UseOnContext useOnContext) {
		Level level = useOnContext.getLevel();
		if (!(level instanceof ServerLevel)) {
			return InteractionResult.SUCCESS;
		} else {
			ItemStack itemStack = useOnContext.getItemInHand();
			BlockPos blockPos = useOnContext.getClickedPos();
			Direction direction = useOnContext.getClickedFace();
			BlockState blockState = level.getBlockState(blockPos);
			BlockPos placePos;
			if (blockState.getCollisionShape(level, blockPos).isEmpty()) {
				placePos = blockPos;
			} else {
				placePos = blockPos.relative(direction);
			}

			Egg egg = FossilsLegacyEntities.EGG.get().create(level);
			egg.setEgg(this.eggs);
			;
			egg.moveTo(placePos.getX() + 0.5F, placePos.getY(), placePos.getZ() + 0.5F);
			level.addFreshEntity(egg);
			itemStack.shrink(1);
			level.gameEvent(useOnContext.getPlayer(), GameEvent.ENTITY_PLACE, blockPos);

			return InteractionResult.CONSUME;
		}
	}
}
