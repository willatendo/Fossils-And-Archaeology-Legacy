package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import willatendo.fossilslegacy.server.block.entity.entities.VaseBlockEntity;

public class MayanVaseBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final MapCodec<MayanVaseBlock> CODEC = simpleCodec(MayanVaseBlock::new);
    private static final VoxelShape SHAPE = Block.box(3.0F, 0.0F, 3.0F, 13.0F, 12.0F, 13.0F);
    public static final BooleanProperty CRACKED = BlockStateProperties.CRACKED;
    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public MayanVaseBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Override
    protected BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos neighborBlockPos, BlockState neighborBlockState, RandomSource randomSource) {
        if (blockState.getValue(WATERLOGGED)) {
            scheduledTickAccess.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelReader));
        }
        return super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, neighborBlockPos, neighborBlockState, randomSource);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER).setValue(CRACKED, false);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof VaseBlockEntity vaseBlockEntity) {
            if (level.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                ItemStack itemStackInside = vaseBlockEntity.getTheItem();
                if (itemStack.isEmpty() || !itemStackInside.isEmpty() && (!ItemStack.isSameItemSameComponents(itemStackInside, itemStack) || itemStackInside.getCount() >= itemStackInside.getMaxStackSize())) {
                    return InteractionResult.TRY_WITH_EMPTY_HAND;
                } else {
                    player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
                    ItemStack consumedItemStack = itemStack.consumeAndReturn(1, player);
                    float pitch;
                    if (vaseBlockEntity.isEmpty()) {
                        vaseBlockEntity.setTheItem(consumedItemStack);
                        vaseBlockEntity.setCount(1);
                        pitch = (float) consumedItemStack.getCount() / (float) consumedItemStack.getMaxStackSize();
                    } else {
                        itemStackInside.grow(1);
                        vaseBlockEntity.setCount(vaseBlockEntity.getCount() + 1);
                        pitch = (float) itemStackInside.getCount() / (float) itemStackInside.getMaxStackSize();
                    }

                    level.playSound(null, blockPos, SoundEvents.DECORATED_POT_INSERT, SoundSource.BLOCKS, 1.0F, 0.7F + 0.5F * pitch);
                    if (level instanceof ServerLevel serverLevel) {
                        serverLevel.sendParticles(ParticleTypes.DUST_PLUME, (double) blockPos.getX() + 0.5, (double) blockPos.getY() + 1.2, (double) blockPos.getZ() + 0.5, 7, 0.0, 0.0, 0.0, 0.0);
                    }

                    vaseBlockEntity.setChanged();
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
                    return InteractionResult.SUCCESS;
                }
            }
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        BlockEntity var7 = level.getBlockEntity(blockPos);
        if (var7 instanceof VaseBlockEntity vaseBlockEntity) {
            level.playSound(null, blockPos, SoundEvents.DECORATED_POT_INSERT_FAIL, SoundSource.BLOCKS, 1.0F, 1.0F);
            vaseBlockEntity.wobble(DecoratedPotBlockEntity.WobbleStyle.NEGATIVE);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    protected boolean isPathfindable(BlockState blockState, PathComputationType pathComputationType) {
        return false;
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, CRACKED);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new VaseBlockEntity(blockPos, blockState);
    }

    @Override
    protected void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState newBlockState, boolean flag) {
        Containers.dropContentsOnDestroy(blockState, newBlockState, level, blockPos);
        super.onRemove(blockState, level, blockPos, newBlockState, flag);
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        ItemStack itemStack = player.getMainHandItem();
        BlockState finalBlockState = blockState;
        if (itemStack.is(ItemTags.BREAKS_DECORATED_POTS) && !EnchantmentHelper.hasTag(itemStack, EnchantmentTags.PREVENTS_DECORATED_POT_SHATTERING)) {
            finalBlockState = blockState.setValue(CRACKED, true);
            level.setBlock(blockPos, finalBlockState, 4);
        }

        return super.playerWillDestroy(level, blockPos, finalBlockState, player);
    }

    @Override
    protected FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @Override
    protected SoundType getSoundType(BlockState blockState) {
        return blockState.getValue(CRACKED) ? SoundType.DECORATED_POT_CRACKED : SoundType.DECORATED_POT;
    }

    @Override
    protected void onProjectileHit(Level level, BlockState blockState, BlockHitResult blockHitResult, Projectile projectile) {
        BlockPos blockPos = blockHitResult.getBlockPos();
        if (level instanceof ServerLevel serverLevel && projectile.mayInteract(serverLevel, blockPos) && projectile.mayBreak(serverLevel)) {
            level.setBlock(blockPos, blockState.setValue(CRACKED, true), 4);
            level.destroyBlock(blockPos, true, projectile);
        }
    }

    @Override
    protected int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos blockPos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(blockPos));
    }
}
