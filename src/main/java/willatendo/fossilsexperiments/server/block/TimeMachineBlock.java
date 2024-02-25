package willatendo.fossilsexperiments.server.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import willatendo.fossilslegacy.server.ConfigHelper;

public class TimeMachineBlock extends Block {
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
}
