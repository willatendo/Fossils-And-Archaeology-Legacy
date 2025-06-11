package willatendo.fossilslegacy.server.item.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;
import willatendo.fossilslegacy.server.entity.entities.DecorationPlaque;

import java.util.Optional;

public class DecorationPlaqueItem extends BlockItem {
    public DecorationPlaqueItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        BlockPos blockPos = useOnContext.getClickedPos();
        Direction direction = useOnContext.getClickedFace();
        BlockPos relativePos = blockPos.relative(direction);
        Player player = useOnContext.getPlayer();
        ItemStack itemStack = useOnContext.getItemInHand();
        if (player != null && !this.mayPlace(player, direction, itemStack, relativePos)) {
            if (direction.getAxis().isVertical() && player.mayUseItemAt(blockPos, direction, itemStack)) {
                return super.useOn(useOnContext);
            }
            return InteractionResult.FAIL;
        } else {
            Level level = useOnContext.getLevel();
            DecorationPlaque decorationPlaque = null;
            Optional<DecorationPlaque> optionalDecorationPlaque = DecorationPlaque.create(level, relativePos, new ItemStack(this), direction);
            if (!optionalDecorationPlaque.isEmpty()) {
                decorationPlaque = optionalDecorationPlaque.get();
            }

            CustomData customData = itemStack.getOrDefault(DataComponents.ENTITY_DATA, CustomData.EMPTY);
            if (!customData.isEmpty()) {
                EntityType.updateCustomEntityTag(level, player, decorationPlaque, customData);
            }

            if (decorationPlaque != null) {
                if (decorationPlaque.survives()) {
                    if (!level.isClientSide()) {
                        decorationPlaque.playPlacementSound();
                        level.gameEvent(player, GameEvent.ENTITY_PLACE, decorationPlaque.position());
                        level.addFreshEntity(decorationPlaque);
                    }

                    itemStack.shrink(1);
                    return InteractionResult.SUCCESS;
                } else {
                    return InteractionResult.CONSUME;
                }
            } else {
                return InteractionResult.CONSUME;
            }
        }
    }

    protected boolean mayPlace(Player player, Direction direction, ItemStack itemStack, BlockPos blockPos) {
        return !direction.getAxis().isVertical() && player.mayUseItemAt(blockPos, direction, itemStack);
    }
}
