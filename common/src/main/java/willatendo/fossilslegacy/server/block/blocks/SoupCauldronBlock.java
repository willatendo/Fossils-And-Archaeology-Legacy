package willatendo.fossilslegacy.server.block.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;

public abstract class SoupCauldronBlock extends AbstractCauldronBlock {
    public static final IntegerProperty LEVEL = IntegerProperty.create("level", 1, 8);

    public SoupCauldronBlock(CauldronInteraction.InteractionMap interactionMap, Properties properties) {
        super(properties, interactionMap);
        this.registerDefaultState(this.stateDefinition.any().setValue(LEVEL, Integer.valueOf(1)));
    }

    @Override
    public int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos blockPos) {
        return blockState.getValue(LEVEL);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LEVEL);
    }

    @Override
    public boolean isFull(BlockState blockState) {
        return blockState.getValue(LEVEL) == 8;
    }


    public static void lowerFillLevel(BlockState blockStaet, Level level, BlockPos blockPos) {
        int below = blockStaet.getValue(LEVEL) - 1;
        BlockState newBlockState = below == 0 ? Blocks.CAULDRON.defaultBlockState() : blockStaet.setValue(LEVEL, below);
        level.setBlockAndUpdate(blockPos, newBlockState);
        level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(newBlockState));
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean includeData) {
        return new ItemStack(Blocks.CAULDRON);
    }
}
