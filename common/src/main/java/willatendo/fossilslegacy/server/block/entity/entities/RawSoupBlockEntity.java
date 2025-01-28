package willatendo.fossilslegacy.server.block.entity.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.blocks.RawSoupCauldronBlock;
import willatendo.fossilslegacy.server.block.blocks.SoupCauldronBlock;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;

public class RawSoupBlockEntity extends BlockEntity {
    private int cookingTick;

    public RawSoupBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FABlockEntityTypes.RAW_SOUP.get(), blockPos, blockState);
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.cookingTick = compoundTag.getInt("CookingTime");
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        compoundTag.putInt("CookingTime", this.cookingTick);
    }

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, RawSoupBlockEntity rawSoupBlockEntity) {
        if (level.getBlockState(blockPos.below()).is(BlockTags.FIRE)) {
            if (rawSoupBlockEntity.cookingTick < 200) {
                if (level.getBlockState(blockPos.below()).is(Blocks.SOUL_FIRE)) {
                    rawSoupBlockEntity.cookingTick += 2;
                } else {
                    rawSoupBlockEntity.cookingTick++;
                }
            } else {
                BlockState cookedState = blockState.is(FABlocks.RAW_CHICKEN_SOUP_CAULDRON.get()) ? FABlocks.COOKED_CHICKEN_SOUP_CAULDRON.get().defaultBlockState() : FABlocks.COOKED_BERRY_MEDLEY_CAULDRON.get().defaultBlockState();
                level.setBlock(blockPos, cookedState.setValue(SoupCauldronBlock.LEVEL, blockState.getValue(RawSoupCauldronBlock.LEVEL)), 3);
            }
        }
    }
}
