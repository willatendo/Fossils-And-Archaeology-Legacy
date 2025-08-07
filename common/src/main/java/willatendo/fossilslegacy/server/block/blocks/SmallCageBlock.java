package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import willatendo.fossilslegacy.server.block.entity.entities.CageBlockEntity;
import willatendo.fossilslegacy.server.item.items.BoltCutterItem;
import willatendo.fossilslegacy.server.tags.FAItemTags;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class SmallCageBlock extends Block implements EntityBlock {
    public static final MapCodec<SmallCageBlock> CODEC = Block.simpleCodec(SmallCageBlock::new);
    public static final EnumProperty<Direction> HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public SmallCageBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(HORIZONTAL_FACING, Direction.NORTH).setValue(OPEN, false).setValue(POWERED, false));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        ItemStack itemStack = player.getMainHandItem();
        if (((CageBlockEntity) level.getBlockEntity(blockPos)).canOpen(itemStack)) {
            blockState = blockState.cycle(OPEN);
            level.setBlock(blockPos, blockState, 10);
            this.playSound(player, level, blockPos, blockState.getValue(OPEN));
            level.gameEvent(player, this.isOpen(blockState) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, blockPos);
            player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
            return InteractionResult.SUCCESS;
        } else if (itemStack.is(FAItemTags.KEY)) {
            player.displayClientMessage(FAUtils.translation("block", "cage.incorrect_key"), true);
            return InteractionResult.SUCCESS;
        } else if (!(itemStack.getItem() instanceof BoltCutterItem)) {
            player.displayClientMessage(FAUtils.translation("block", "cage.locked"), true);
            return InteractionResult.SUCCESS;
        } else {
            return super.useWithoutItem(blockState, level, blockPos, player, blockHitResult);
        }
    }

    public boolean isOpen(BlockState blockState) {
        return blockState.getValue(OPEN);
    }

    private void playSound(Entity source, Level level, BlockPos blockPos, boolean isOpening) {
        level.playSound(source, blockPos, isOpening ? SoundEvents.IRON_DOOR_OPEN : SoundEvents.IRON_DOOR_CLOSE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        boolean flag = level.hasNeighborSignal(blockPos);
        return this.defaultBlockState().setValue(HORIZONTAL_FACING, blockPlaceContext.getHorizontalDirection().getOpposite()).setValue(POWERED, flag).setValue(OPEN, flag);
    }

    @Override
    protected BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(HORIZONTAL_FACING, rotation.rotate(blockState.getValue(HORIZONTAL_FACING)));
    }

    @Override
    protected BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(HORIZONTAL_FACING)));
    }

    @Override
    protected void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, Orientation orientation, boolean movedByPiston) {
        boolean flag = level.hasNeighborSignal(blockPos);
        if (!this.defaultBlockState().is(block) && flag != blockState.getValue(POWERED)) {
            if (flag != blockState.getValue(OPEN)) {
                this.playSound(null, level, blockPos, flag);
                level.gameEvent(null, flag ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, blockPos);
            }

            level.setBlock(blockPos, blockState.setValue(POWERED, flag).setValue(OPEN, flag), 2);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, OPEN, POWERED);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CageBlockEntity(blockPos, blockState);
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }
}
