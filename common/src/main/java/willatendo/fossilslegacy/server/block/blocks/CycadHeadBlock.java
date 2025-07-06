package willatendo.fossilslegacy.server.block.blocks;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.tags.FABlockTags;

public class CycadHeadBlock extends Block implements BonemealableBlock {
    private static final VoxelShape SHAPE_CONE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    private static final VoxelShape SHAPE_NO_CONE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 10.0D, 14.0D);
    public static final BooleanProperty HAS_CONE = BooleanProperty.create("has_cone");

    public CycadHeadBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(HAS_CONE, false));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        BlockPos aboveBlockPos = blockPlaceContext.getClickedPos().above();
        BlockState blockState = level.getBlockState(blockPos);
        if (level.getBlockState(blockPos).is(this) && level.getBlockState(aboveBlockPos).isAir() && aboveBlockPos.getY() < level.getHeight()) {
            level.setBlock(blockPos.above(), blockState, 3);
            return FABlocks.CYCAD_LOG.get().defaultBlockState();
        } else {
            return super.getStateForPlacement(blockPlaceContext);
        }
    }

    @Override
    protected boolean canBeReplaced(BlockState blockState, BlockPlaceContext blockPlaceContext) {
        return blockPlaceContext.getItemInHand().is(this.asItem());
    }

    @Override
    protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(20) == 0) {
            serverLevel.setBlock(blockPos, blockState.setValue(HAS_CONE, true), 3);
        }

        if (randomSource.nextInt(100) == 0 && !serverLevel.getBlockState(blockPos.below(3)).is(FABlocks.CYCAD_LOG.get())) {
            serverLevel.setBlock(blockPos.above(), blockState, 3);
            serverLevel.setBlock(blockPos, FABlocks.CYCAD_LOG.get().defaultBlockState(), 3);
        }
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return blockState.getValue(HAS_CONE) ? SHAPE_CONE : SHAPE_NO_CONE;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (itemStack.getItem() instanceof AxeItem) {
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, blockPos, itemStack);
            }

            Block.popResource(level, blockPos.above(), new ItemStack(FAItems.CYCAD_CONE.get()));
            level.setBlock(blockPos, blockState.setValue(HAS_CONE, false), 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, blockState.setValue(HAS_CONE, false)));
            itemStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(interactionHand));
            return InteractionResult.SUCCESS;
        }
        return super.useItemOn(itemStack, blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState blockState) {
        return true;
    }

    @Override
    protected boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return levelReader.getBlockState(blockPos.below()).is(FABlocks.CYCAD_LOG.get()) || levelReader.getBlockState(blockPos.below()).is(FABlockTags.CYCAD_PLANTABLE_ON);
    }

    @Override
    protected BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos neighbourBlockPos, BlockState neighbourBlockState, RandomSource randomSource) {
        return !blockState.canSurvive(levelReader, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, neighbourBlockPos, neighbourBlockState, randomSource);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        BlockPos abovePos = blockPos.above();
        return level.getBlockState(abovePos).isAir() && abovePos.getY() < level.getHeight();
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        serverLevel.setBlock(blockPos.above(), blockState, 3);
        serverLevel.setBlock(blockPos, FABlocks.CYCAD_LOG.get().defaultBlockState(), 3);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HAS_CONE);
    }
}
