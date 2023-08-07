package willatendo.fossilslegacy.server.item;

import java.util.Objects;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import willatendo.fossilslegacy.server.entity.Egg;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;

public class EggItem extends Item {
	private final Egg.Eggs eggs;

	public EggItem(Egg.Eggs eggs, Properties properties) {
		super(properties);
		this.eggs = eggs;
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

			Egg egg = FossilsLegacyEntities.EGG.get().spawn((ServerLevel) level, itemStack, useOnContext.getPlayer(), placePos, MobSpawnType.SPAWN_EGG, true, !Objects.equals(blockPos, placePos) && direction == Direction.UP);
			egg.setEgg(this.eggs);
			egg.setRemainingTime(0);
			itemStack.shrink(1);
			level.gameEvent(useOnContext.getPlayer(), GameEvent.ENTITY_PLACE, blockPos);

			return InteractionResult.CONSUME;
		}
	}
}
