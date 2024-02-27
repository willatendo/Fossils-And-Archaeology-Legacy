package willatendo.fossilslegacy.experiments.server.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlagSet;
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
import willatendo.fossilslegacy.experiments.server.block.entity.FossilsExperimentsBlockEntities;
import willatendo.fossilslegacy.experiments.server.block.entity.TimeMachineBlockEntity;
import willatendo.fossilslegacy.server.ConfigHelper;
import willatendo.fossilslegacy.server.block.entity.BlockEntityHelper;

public class TimeMachineBlock extends Block implements EntityBlock {
	public static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);

	public TimeMachineBlock(Properties properties) {
		super(properties);
	}

	@Override
	public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return SHAPE;
	}

	@Override
	public boolean isEnabled(FeatureFlagSet featureFlagSet) {
		return ConfigHelper.shouldEnableExperiments();
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
			if (blockEntity instanceof TimeMachineBlockEntity timeMachineBlockEntity && player instanceof ServerPlayer serverPlayer) {
				serverPlayer.openMenu(timeMachineBlockEntity);
			}
			return InteractionResult.CONSUME;
		}
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
		return level.isClientSide() ? BlockEntityHelper.createTickerHelper(blockEntityType, FossilsExperimentsBlockEntities.TIME_MACHINE.get(), TimeMachineBlockEntity::clockTick) : BlockEntityHelper.createTickerHelper(blockEntityType, FossilsExperimentsBlockEntities.TIME_MACHINE.get(), TimeMachineBlockEntity::serverTick);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return new TimeMachineBlockEntity(blockPos, blockState);
	}
}
