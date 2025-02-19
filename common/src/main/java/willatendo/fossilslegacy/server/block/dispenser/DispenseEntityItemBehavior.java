package willatendo.fossilslegacy.server.block.dispenser;

import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import willatendo.fossilslegacy.server.item.items.PlaceEntityItem;

public class DispenseEntityItemBehavior extends DefaultDispenseItemBehavior {
    @Override
    public ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
        Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
        if (itemStack.getItem() instanceof PlaceEntityItem placeEntityItem) {
            EntityType entityType = (EntityType) placeEntityItem.getEntityType().get();
            try {
                Entity entity = entityType.spawn(blockSource.level(), itemStack, null, blockSource.pos().relative(direction), EntitySpawnReason.DISPENSER, direction != Direction.UP, false);
                placeEntityItem.entityModification(itemStack, entity);
            } catch (Exception exception) {
                LOGGER.error("Error while dispensing entity from dispenser at {}", blockSource.pos(), exception);
                return ItemStack.EMPTY;
            }
        }
        itemStack.shrink(1);
        blockSource.level().gameEvent(null, GameEvent.ENTITY_PLACE, blockSource.pos());
        return itemStack;
    }
}
