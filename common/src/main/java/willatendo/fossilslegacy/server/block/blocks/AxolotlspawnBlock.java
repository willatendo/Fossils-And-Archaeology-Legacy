package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.animal.frog.Tadpole;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AxolotlspawnBlock extends Block {
	public static final MapCodec<AxolotlspawnBlock> CODEC = AxolotlspawnBlock.simpleCodec(AxolotlspawnBlock::new);
	protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 1.5, 16.0);
	private static int minHatchTickDelay = 3600;
	private static int maxHatchTickDelay = 12000;

	public AxolotlspawnBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return SHAPE;
	}

	@Override
	public MapCodec<AxolotlspawnBlock> codec() {
		return CODEC;
	}

	@Override
	public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
		return AxolotlspawnBlock.mayPlaceOn(levelReader, blockPos.below());
	}

	@Override
	public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
		level.scheduleTick(blockPos, this, AxolotlspawnBlock.getFrogspawnHatchDelay(level.getRandom()));
	}

	private static int getFrogspawnHatchDelay(RandomSource randomSource) {
		return randomSource.nextInt(minHatchTickDelay, maxHatchTickDelay);
	}

	@Override
	public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
		if (!this.canSurvive(blockState, levelAccessor, blockPos)) {
			return Blocks.AIR.defaultBlockState();
		}
		return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
	}

	@Override
	public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
		if (!this.canSurvive(blockState, serverLevel, blockPos)) {
			this.destroyBlock(serverLevel, blockPos);
			return;
		}
		this.hatchFrogspawn(serverLevel, blockPos, randomSource);
	}

	@Override
	public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
		if (entity.getType().equals(EntityType.FALLING_BLOCK)) {
			this.destroyBlock(level, blockPos);
		}
	}

	private static boolean mayPlaceOn(BlockGetter blockGetter, BlockPos blockPos) {
		FluidState fluidState = blockGetter.getFluidState(blockPos);
		FluidState fluidState2 = blockGetter.getFluidState(blockPos.above());
		return fluidState.getType() == Fluids.WATER && fluidState2.getType() == Fluids.EMPTY;
	}

	private void hatchFrogspawn(ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
		this.destroyBlock(serverLevel, blockPos);
		serverLevel.playSound(null, blockPos, SoundEvents.FROGSPAWN_HATCH, SoundSource.BLOCKS, 1.0f, 1.0f);
		this.spawnTadpoles(serverLevel, blockPos, randomSource);
	}

	private void destroyBlock(Level level, BlockPos blockPos) {
		level.destroyBlock(blockPos, false);
	}

	private void spawnTadpoles(ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
		int i = randomSource.nextInt(2, 6);
		for (int j = 1; j <= i; ++j) {
			Axolotl axolotl = EntityType.AXOLOTL.create(serverLevel);
			if (axolotl == null) {
				continue;
			}

			double x = (double) blockPos.getX() + this.getRandomTadpolePositionOffset(randomSource);
			double z = (double) blockPos.getZ() + this.getRandomTadpolePositionOffset(randomSource);
			int yRot = randomSource.nextInt(1, 361);
			axolotl.moveTo(x, (double) blockPos.getY() - 0.5, z, yRot, 0.0f);
			axolotl.setPersistenceRequired();
			axolotl.setBaby(true);
			serverLevel.addFreshEntity(axolotl);
		}
	}

	private double getRandomTadpolePositionOffset(RandomSource randomSource) {
		double d = Tadpole.HITBOX_WIDTH / 2.0f;
		return Mth.clamp(randomSource.nextDouble(), d, 1.0 - d);
	}

}
