package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import willatendo.fossilslegacy.server.block.entity.entities.HologramProjectorBlockEntity;

public class ColoredHologramProjectorBlock extends HologramProjectorBlock {
    public static final MapCodec<ColoredHologramProjectorBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(DyeColor.CODEC.fieldOf("color").forGetter(ColoredHologramProjectorBlock::getColor), ColoredHologramProjectorBlock.propertiesCodec()).apply(instance, ColoredHologramProjectorBlock::new));
    private final DyeColor color;

    public ColoredHologramProjectorBlock(DyeColor color, Properties properties) {
        super(properties);
        this.color = color;
        this.registerDefaultState(this.getStateDefinition().any().setValue(ON, false).setValue(HORIZONTAL_FACING, Direction.NORTH));
    }

@Override
    public DyeColor getColor() {
        return this.color;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new HologramProjectorBlockEntity(blockPos, blockState, this.color);
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }
}
