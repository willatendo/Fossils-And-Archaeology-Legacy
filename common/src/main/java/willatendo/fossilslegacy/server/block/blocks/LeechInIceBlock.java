package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.item.FAItems;

public class LeechInIceBlock extends HalfTransparentBlock {
    public static final MapCodec<LeechInIceBlock> CODEC = Block.simpleCodec(LeechInIceBlock::new);

    public LeechInIceBlock(Properties properties) {
        super(properties);
    }

    public static BlockState meltsInto() {
        return Blocks.WATER.defaultBlockState();
    }

    @Override
    protected boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        return adjacentBlockState.is(this) || adjacentBlockState.is(Blocks.ICE) || super.skipRendering(state, adjacentBlockState, side);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos blockPos, BlockState blockState, BlockEntity blockEntity, ItemStack itemStack) {
        super.playerDestroy(level, player, blockPos, blockState, blockEntity, itemStack);
        if (!EnchantmentHelper.hasTag(itemStack, EnchantmentTags.PREVENTS_ICE_MELTING)) {
            if (level.dimensionType().ultraWarm()) {
                level.removeBlock(blockPos, false);
                return;
            }

            BlockState blockStateBelow = level.getBlockState(blockPos.below());
            if (blockStateBelow.blocksMotion() || blockStateBelow.liquid()) {
                level.setBlockAndUpdate(blockPos, meltsInto());
            }
        }
    }

    @Override
    protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (serverLevel.getBrightness(LightLayer.BLOCK, blockPos) > 11 - blockState.getLightBlock()) {
            this.melt(blockState, serverLevel, blockPos);
        }
    }

    protected void melt(BlockState blockState, Level level, BlockPos blockPos) {
        Block.popResource(level, blockPos, new ItemStack(FAItems.FROZEN_LEECH.get()));
        if (level.dimensionType().ultraWarm()) {
            level.removeBlock(blockPos, false);
        } else {
            level.setBlockAndUpdate(blockPos, LeechInIceBlock.meltsInto());
            level.neighborChanged(blockPos, LeechInIceBlock.meltsInto().getBlock(), null);
        }
    }

    @Override
    protected MapCodec<? extends HalfTransparentBlock> codec() {
        return CODEC;
    }
}
