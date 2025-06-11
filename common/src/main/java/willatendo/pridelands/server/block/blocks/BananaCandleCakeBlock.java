package willatendo.pridelands.server.block.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import willatendo.pridelands.server.block.PridelandsBlocks;

import java.util.HashMap;
import java.util.Map;

public class BananaCandleCakeBlock extends CandleCakeBlock {
    private static final Map<CandleBlock, CandleCakeBlock> BY_CANDLE = new HashMap<>();

    public BananaCandleCakeBlock(Block block, Properties properties) {
        super(block, properties);
        if (block instanceof CandleBlock candleBlock) {
            BY_CANDLE.put(candleBlock, this);
        } else {
            throw new IllegalArgumentException("Expected block to be of " + CandleBlock.class + " was " + block.getClass());
        }
    }

    public static BlockState byCandle(CandleBlock candleBlock) {
        return BY_CANDLE.get(candleBlock).defaultBlockState();
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        InteractionResult interactionresult = BananaCakeBlock.eat(level, blockPos, PridelandsBlocks.BANANA_CAKE.get().defaultBlockState(), player);
        if (interactionresult.consumesAction()) {
            dropResources(blockState, level, blockPos);
        }

        return interactionresult;
    }

    @Override
    protected ItemStack getCloneItemStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean includeData) {
        return new ItemStack(PridelandsBlocks.BANANA_CAKE.get());
    }
}
