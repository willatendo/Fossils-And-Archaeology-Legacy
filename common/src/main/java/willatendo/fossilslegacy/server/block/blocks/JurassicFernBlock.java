package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.tags.FABlockTags;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class JurassicFernBlock extends BushBlock implements BonemealableBlock {
    public static final MapCodec<JurassicFernBlock> CODEC = Block.simpleCodec(JurassicFernBlock::new);
    public static final IntegerProperty GROWTH = IntegerProperty.create("growth", 0, 5);
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final VoxelShape GROWTH_LOWER_0 = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D);
    public static final VoxelShape GROWTH_LOWER_1 = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D);
    public static final VoxelShape GROWTH_LOWER_2 = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 14.0D, 12.0D);
    public static final VoxelShape GROWTH_LOWER_3 = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);
    public static final VoxelShape GROWTH_LOWER_4 = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    public static final VoxelShape GROWTH_LOWER_5 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    public static final VoxelShape GROWTH_UPPER_4 = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 2.0D, 14.0D);
    public static final VoxelShape GROWTH_UPPER_5 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D);
    public static final VoxelShape[] LOWER_SHAPES = new VoxelShape[]{GROWTH_LOWER_0, GROWTH_LOWER_1, GROWTH_LOWER_2, GROWTH_LOWER_3, GROWTH_LOWER_4, GROWTH_LOWER_5};
    public static final VoxelShape[] UPPER_SHAPES = new VoxelShape[]{GROWTH_UPPER_4, GROWTH_UPPER_4, GROWTH_UPPER_4, GROWTH_UPPER_4, GROWTH_UPPER_4, GROWTH_UPPER_5};

    public JurassicFernBlock(Properties properties) {
        super(properties);
        this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(GROWTH, 0);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return super.getStateForPlacement(blockPlaceContext).setValue(HALF, DoubleBlockHalf.LOWER);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean includeData) {
        return new ItemStack(BuiltInRegistries.ITEM.getValue(FAUtils.resource("jurassic_fern")));
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (blockState.getValue(HALF) == DoubleBlockHalf.LOWER) {
            return LOWER_SHAPES[blockState.getValue(GROWTH)];
        } else if (blockState.getValue(HALF) == DoubleBlockHalf.UPPER) {
            return UPPER_SHAPES[blockState.getValue(GROWTH)];
        }
        return super.getShape(blockState, blockGetter, blockPos, collisionContext);
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        super.randomTick(blockState, serverLevel, blockPos, randomSource);
        int growth = blockState.getValue(GROWTH);
        if (blockState.getValue(HALF) == DoubleBlockHalf.LOWER && growth < 5) {
            if (randomSource.nextInt(10) > 1) {
                this.grow(blockState, blockPos, serverLevel, growth);
            }
        }

        if (blockState.getValue(HALF) == DoubleBlockHalf.UPPER) {
            if (serverLevel.getBlockState(blockPos.below()).is(this)) {
                serverLevel.setBlockAndUpdate(blockPos, FABlocks.JURASSIC_FERN.get().defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(GROWTH, serverLevel.getBlockState(blockPos.below()).getValue(GROWTH)));
            }
        }

        if (growth >= 3) {
            this.spread(blockState, blockPos, serverLevel, randomSource);
        }
    }

    public void grow(BlockState blockState, BlockPos blockPos, ServerLevel serverLevel, int growth) {
        growth++;
        if (growth > 3) {
            if (serverLevel.getBlockState(blockPos.above()).is(Blocks.AIR) || serverLevel.getBlockState(blockPos.above()).is(this)) {
                serverLevel.setBlockAndUpdate(blockPos.above(), FABlocks.JURASSIC_FERN.get().defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(GROWTH, growth));
            }

        }
        serverLevel.setBlockAndUpdate(blockPos, FABlocks.JURASSIC_FERN.get().defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER).setValue(GROWTH, growth));
    }

    public void spread(BlockState blockState, BlockPos blockPos, ServerLevel serverLevel, RandomSource randomSource) {
        if (blockState.getValue(HALF) == DoubleBlockHalf.LOWER) {
            for (int xShift = -1; xShift <= 1; xShift++) {
                for (int yShift = -1; yShift <= 1; yShift++) {
                    for (int zShift = -1; zShift <= 1; zShift++) {
                        if (xShift != 0 || zShift != 0 || yShift != 0) {
                            if (!(serverLevel.getBlockState(new BlockPos(blockPos.getX() + xShift, blockPos.getY() + yShift, blockPos.getZ() + zShift)).is(this)) && serverLevel.getBlockState(new BlockPos(blockPos.getX() + xShift, blockPos.getY() + yShift - 1, blockPos.getZ() + zShift)).is(FABlockTags.JURASSIC_FERN_PLANTABLE_ON) && ((serverLevel.getBlockState(new BlockPos(blockPos.getX() + xShift, blockPos.getY() + yShift, blockPos.getZ() + zShift)).isAir() || serverLevel.getBlockState(new BlockPos(blockPos.getX() + xShift, blockPos.getY() + yShift, blockPos.getZ() + zShift)).is(BlockTags.REPLACEABLE))) && this.isUnderTree(serverLevel, new BlockPos(blockPos.getX() + xShift, blockPos.getY() + yShift, blockPos.getZ() + zShift)) && (randomSource.nextInt(10) <= 5)) {
                                serverLevel.setBlockAndUpdate(new BlockPos(blockPos.getX() + xShift, blockPos.getY() + yShift, blockPos.getZ() + zShift), FABlocks.JURASSIC_FERN.get().defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER).setValue(GROWTH, 0));
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        if (this.isUnderTree(levelReader, blockPos)) {
            if (blockState.getValue(HALF) != DoubleBlockHalf.UPPER) {
                return super.canSurvive(blockState, levelReader, blockPos);
            } else {
                BlockState blockStateBelow = levelReader.getBlockState(blockPos.below());
                if (blockState.getBlock() != this) {
                    return super.canSurvive(blockState, levelReader, blockPos);
                }
                return blockStateBelow.is(this) && blockStateBelow.getValue(HALF) == DoubleBlockHalf.LOWER;
            }
        } else {
            return false;
        }
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        if (!level.isClientSide) {
            if (player.isCreative()) {
                preventCreativeDropFromBottomPart(level, blockPos, blockState, player);
            } else {
                dropResources(blockState, level, blockPos, (BlockEntity) null, player, player.getMainHandItem());
            }
        }

        return super.playerWillDestroy(level, blockPos, blockState, player);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos blockPos, BlockState blockState, BlockEntity blockEntity, ItemStack itemStack) {
        super.playerDestroy(level, player, blockPos, Blocks.AIR.defaultBlockState(), blockEntity, itemStack);
    }

    protected static void preventCreativeDropFromBottomPart(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        DoubleBlockHalf doubleBlockHalf = blockState.getValue(HALF);
        if (doubleBlockHalf == DoubleBlockHalf.UPPER) {
            BlockPos blockPosBelow = blockPos.below();
            BlockState blockStateBelow = level.getBlockState(blockPosBelow);
            if (blockStateBelow.is(blockState.getBlock()) && blockStateBelow.getValue(HALF) == DoubleBlockHalf.LOWER) {
                BlockState replaced = blockStateBelow.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                level.setBlock(blockPosBelow, replaced, 35);
                level.levelEvent(player, 2001, blockPosBelow, Block.getId(blockStateBelow));
            }
        }

    }

    public boolean isUnderTree(LevelReader levelReader, BlockPos blockPos) {
        for (int y = blockPos.getY(); y <= 384; y++) {
            if (levelReader.getBlockState(new BlockPos(blockPos.getX(), y, blockPos.getZ())).is(BlockTags.LEAVES)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(GROWTH, HALF);
        super.createBlockStateDefinition(builder);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        if (blockState.getValue(HALF) == DoubleBlockHalf.LOWER) {
            if (blockState.getValue(GROWTH) < 5) {
                this.grow(blockState, blockPos, serverLevel, blockState.getValue(GROWTH));
            } else {
                this.spread(blockState, blockPos, serverLevel, randomSource);
            }
        } else {
            popResource(serverLevel, blockPos, new ItemStack(BuiltInRegistries.ITEM.getValue(FAUtils.resource("jurassic_fern"))));
        }
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }
}
