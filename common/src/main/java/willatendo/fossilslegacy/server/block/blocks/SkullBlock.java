package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.criteria.FACriteriaTriggers;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Anu;

import java.util.function.Predicate;

public class SkullBlock extends Block {
    public static final MapCodec<SkullBlock> CODEC = Block.simpleCodec(SkullBlock::new);
    private BlockPattern anuBase;
    private BlockPattern anuFull;
    private static final Predicate<BlockState> SKULLS_PREDICATE = blockState -> blockState != null && (blockState.is(FABlocks.SKULL_BLOCK.get()) || blockState.is(FABlocks.SKULL_LANTERN_BLOCK.get()));

    public static final EnumProperty<Direction> HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;

    public SkullBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(HORIZONTAL_FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(HORIZONTAL_FACING, rotation.rotate(blockState.getValue(HORIZONTAL_FACING)));
    }

    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(HORIZONTAL_FACING)));
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING);
    }

    public boolean canSpawnAnu(LevelReader levelReader, BlockPos blockPos) {
        return this.getOrCreateAnuBase().find(levelReader, blockPos) != null;
    }

    private void trySpawnAnu(Level level, BlockPos blockPos) {
        BlockPattern.BlockPatternMatch blockPatternMatch = this.getOrCreateAnuFull().find(level, blockPos);
        if (blockPatternMatch != null) {
            Anu anu = FAEntityTypes.ANU.get().create(level, EntitySpawnReason.TRIGGERED);
            if (anu != null) {
                spawnAnuInWorld(level, blockPatternMatch, anu, blockPatternMatch.getBlock(0, 2, 0).getPos());
            }
        }
    }

    private static void spawnAnuInWorld(Level level, BlockPattern.BlockPatternMatch blockPatternMatch, Entity entity, BlockPos blockPos) {
        clearPatternBlocks(level, blockPatternMatch);
        entity.moveTo((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.05D, (double) blockPos.getZ() + 0.5D, 0.0F, 0.0F);
        level.addFreshEntity(entity);

        for (ServerPlayer serverplayer : level.getEntitiesOfClass(ServerPlayer.class, entity.getBoundingBox().inflate(5.0))) {
            CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayer, entity);
            FACriteriaTriggers.SUMMON_ANU.get().trigger(serverplayer, (Anu) entity);
        }

        updatePatternBlocks(level, blockPatternMatch);
    }

    public static void clearPatternBlocks(Level level, BlockPattern.BlockPatternMatch blockPatternMatch) {
        for (int x = 0; x < blockPatternMatch.getWidth(); ++x) {
            for (int y = 0; y < blockPatternMatch.getHeight(); ++y) {
                BlockInWorld blockInWorld = blockPatternMatch.getBlock(x, y, 0);
                level.setBlock(blockInWorld.getPos(), Blocks.AIR.defaultBlockState(), 2);
                level.levelEvent(2001, blockInWorld.getPos(), Block.getId(blockInWorld.getState()));
            }
        }
    }

    public static void updatePatternBlocks(Level level, BlockPattern.BlockPatternMatch blockPatternMatch) {
        for (int x = 0; x < blockPatternMatch.getWidth(); ++x) {
            for (int y = 0; y < blockPatternMatch.getHeight(); ++y) {
                BlockInWorld blockInWorld = blockPatternMatch.getBlock(x, y, 0);
                level.blockUpdated(blockInWorld.getPos(), Blocks.AIR);
            }
        }
    }

    private BlockPattern getOrCreateAnuBase() {
        if (this.anuBase == null) {
            this.anuBase = BlockPatternBuilder.start().aisle(" ", "#", "#").where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.NETHER_BRICKS))).build();
        }

        return this.anuBase;
    }

    private BlockPattern getOrCreateAnuFull() {
        if (this.anuFull == null) {
            this.anuFull = BlockPatternBuilder.start().aisle("^", "#", "#").where('^', BlockInWorld.hasState(SKULLS_PREDICATE)).where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.NETHER_BRICKS))).build();
        }

        return this.anuFull;
    }

    @Override
    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState neighbourBlockState, boolean bl) {
        if (!neighbourBlockState.is(blockState.getBlock())) {
            this.trySpawnAnu(level, blockPos);
        }
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return super.getShape(state, level, pos, context);
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }
}
