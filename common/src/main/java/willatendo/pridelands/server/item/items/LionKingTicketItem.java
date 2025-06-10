package willatendo.pridelands.server.item.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import willatendo.pridelands.server.block.portal.PridelandsPortalShape;

import java.util.Optional;

public class LionKingTicketItem extends Item {
    public LionKingTicketItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Player player = useOnContext.getPlayer();
        Level level = useOnContext.getLevel();
        BlockPos blockPos = useOnContext.getClickedPos();
        BlockPos placeBlockPos = blockPos.relative(useOnContext.getClickedFace());
        if (LionKingTicketItem.inPortalDimension(level)) {
            Optional<PridelandsPortalShape> optional = PridelandsPortalShape.findEmptyPortalShape(level, placeBlockPos, Direction.Axis.X);
            if (optional.isPresent()) {
                level.playSound(player, placeBlockPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
                level.gameEvent(player, GameEvent.BLOCK_PLACE, placeBlockPos);
                ItemStack itemStack = useOnContext.getItemInHand();
                if (player instanceof ServerPlayer serverPlayer) {
                    CriteriaTriggers.PLACED_BLOCK.trigger(serverPlayer, placeBlockPos, itemStack);
                    if (!player.isCreative()) {
                        itemStack.shrink(1);
                    }
                }
                optional.get().createPortalBlocks(level);
                return InteractionResult.SUCCESS;
            }
        }
        return super.useOn(useOnContext);
    }

    private static boolean inPortalDimension(Level level) {
        return level.dimension() == Level.OVERWORLD || level.dimension() == Level.NETHER;
    }
}
