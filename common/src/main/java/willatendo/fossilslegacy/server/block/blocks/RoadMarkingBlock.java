package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RoadMarkingBlock extends Block {
    public static final MapCodec<RoadMarkingBlock> CODEC = Block.simpleCodec(RoadMarkingBlock::new);
    public static final VoxelShape SHAPE = Block.box(0.0F, 0.0F, 0.0F, 16.0F, 1.0F, 16.0F);
    public static final EnumProperty<RoadMarkingBlock.RoadMarkingShape> ROAD_MARKING_SHAPE = EnumProperty.create("shape", RoadMarkingBlock.RoadMarkingShape.class);

    public RoadMarkingBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(ROAD_MARKING_SHAPE, RoadMarkingBlock.RoadMarkingShape.NORTH_SOUTH));
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos poblockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        RoadMarkingBlock.RoadMarkingShape shape = switch (blockPlaceContext.getHorizontalDirection()) {
            default -> RoadMarkingShape.NORTH_SOUTH;
            case EAST, WEST -> RoadMarkingShape.EAST_WEST;
        };
        return this.defaultBlockState().setValue(ROAD_MARKING_SHAPE, shape);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ROAD_MARKING_SHAPE);
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }

    public enum RoadMarkingShape implements StringRepresentable {
        NORTH_SOUTH("north_south"),
        EAST_WEST("east_west");

        private final String name;

        RoadMarkingShape(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }
}
