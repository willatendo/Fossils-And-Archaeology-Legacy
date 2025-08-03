package willatendo.fossilslegacy.server.item.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class LowSecurityFenceItem extends Item {
    public LowSecurityFenceItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Direction direction = useOnContext.getHorizontalDirection();
        Level level = useOnContext.getLevel();
        BlockPos blockPos = useOnContext.getClickedPos().above();
        if (!level.isClientSide()) {
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 3; y++) {
                    level.setBlock(blockPos.relative(direction, x).above(y), Blocks.STONE.defaultBlockState(), 3);
                }
            }
            return InteractionResult.SUCCESS_SERVER;
        }

        return super.useOn(useOnContext);
    }
}
