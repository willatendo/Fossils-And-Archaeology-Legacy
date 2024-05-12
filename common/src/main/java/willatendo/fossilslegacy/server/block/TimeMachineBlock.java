package willatendo.fossilslegacy.server.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import willatendo.fossilslegacy.server.block.entity.BlockEntityHelper;
import willatendo.fossilslegacy.server.block.entity.FossilsLegacyBlockEntities;
import willatendo.fossilslegacy.server.block.entity.TimeMachineBlockEntity;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.List;

public class TimeMachineBlock extends Block implements EntityBlock {
    public static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);
    public static final List<BlockPos> PARTICLE_SPAWN_OFFSETS = BlockPos.betweenClosedStream(-2, 0, -2, 2, 1, 2).filter(blockPos -> Math.abs(blockPos.getX()) == 2 || Math.abs(blockPos.getZ()) == 2).map(BlockPos::immutable).toList();

    public TimeMachineBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    @Override
    public boolean triggerEvent(BlockState blockState, Level level, BlockPos blockPos, int a, int b) {
        super.triggerEvent(blockState, level, blockPos, a, b);
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        return blockEntity == null ? false : blockEntity.triggerEvent(a, b);
    }

    @Override
    public MenuProvider getMenuProvider(BlockState blockState, Level level, BlockPos blockPos) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        return blockEntity instanceof MenuProvider ? (MenuProvider) blockEntity : null;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, LivingEntity livingEntity, ItemStack itemStack) {
        if (itemStack.hasCustomHoverName()) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof TimeMachineBlockEntity timeMachineBlockEntity) {
                timeMachineBlockEntity.setCustomName(itemStack.getHoverName());
            }
        }
    }

    @Override
    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState newBlockState, boolean flag) {
        if (!blockState.is(newBlockState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof TimeMachineBlockEntity timeMachineBlockEntity) {
                if (level instanceof ServerLevel) {
                    Containers.dropContents(level, blockPos, timeMachineBlockEntity);
                }
                level.updateNeighbourForOutputSignal(blockPos, this);
            }

            super.onRemove(blockState, level, blockPos, newBlockState, flag);
        }
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof TimeMachineBlockEntity && player instanceof ServerPlayer serverPlayer) {
                SimpleUtils.openContainer(blockEntity, blockPos, serverPlayer);
            }
            return InteractionResult.CONSUME;
        }
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return level.isClientSide() ? BlockEntityHelper.createTickerHelper(blockEntityType, FossilsLegacyBlockEntities.TIME_MACHINE.get(), TimeMachineBlockEntity::clockTick) : BlockEntityHelper.createTickerHelper(blockEntityType, FossilsLegacyBlockEntities.TIME_MACHINE.get(), TimeMachineBlockEntity::serverTick);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new TimeMachineBlockEntity(blockPos, blockState);
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (level.getBlockEntity(blockPos) instanceof TimeMachineBlockEntity timeMachineBlockEntity) {
            if (timeMachineBlockEntity.isTimeTravelling()) {
                if (randomSource.nextInt(100) == 0) {
                    level.playLocalSound((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.5, (double) blockPos.getZ() + 0.5, SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 0.5F, randomSource.nextFloat() * 0.4F + 0.8F, false);
                }

                for (BlockPos particleSpawnPos : PARTICLE_SPAWN_OFFSETS) {
                    if (randomSource.nextInt(16) == 0) {
                        level.addParticle(ParticleTypes.PORTAL, (double) blockPos.getX() + 0.5, (double) blockPos.getY() + 2.0, (double) blockPos.getZ() + 0.5, (double) ((float) particleSpawnPos.getX() + randomSource.nextFloat()) - 0.5, (double) ((float) particleSpawnPos.getY() - randomSource.nextFloat() - 1.0F), (double) ((float) particleSpawnPos.getZ() + randomSource.nextFloat()) - 0.5);
                    }
                }
            }
        }
    }
}
