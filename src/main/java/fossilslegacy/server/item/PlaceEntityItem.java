package fossilslegacy.server.item;

import java.util.Objects;
import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class PlaceEntityItem extends Item {
	private final Supplier<EntityType<?>> entityType;

	public PlaceEntityItem(Supplier<EntityType<?>> eggs, Properties properties) {
		super(properties);
		this.entityType = eggs;
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

			if (this.entityType.get() != null) {
				this.entityType.get().spawn((ServerLevel) level, itemStack, useOnContext.getPlayer(), placePos, MobSpawnType.SPAWN_EGG, true, !Objects.equals(blockPos, placePos) && direction == Direction.UP);
				itemStack.shrink(1);
				level.gameEvent(useOnContext.getPlayer(), GameEvent.ENTITY_PLACE, blockPos);
			}

			return InteractionResult.CONSUME;
		}
	}
}
