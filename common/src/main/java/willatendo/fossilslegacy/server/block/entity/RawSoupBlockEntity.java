package willatendo.fossilslegacy.server.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.block.RawSoupCauldronBlock;
import willatendo.fossilslegacy.server.block.SoupCauldronBlock;

public class RawSoupBlockEntity extends BlockEntity {
    private int cookingTick;

    public RawSoupBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FossilsLegacyBlockEntities.RAW_SOUP.get(), blockPos, blockState);
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.cookingTick = compoundTag.getInt("CookingTime");
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
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
                BlockState cookedState = blockState.is(FossilsLegacyBlocks.RAW_CHICKEN_SOUP_CAULDRON.get()) ? FossilsLegacyBlocks.COOKED_CHICKEN_SOUP_CAULDRON.get().defaultBlockState() : FossilsLegacyBlocks.COOKED_BERRY_MEDLEY_CAULDRON.get().defaultBlockState();
                level.setBlock(blockPos, cookedState.setValue(SoupCauldronBlock.LEVEL, blockState.getValue(RawSoupCauldronBlock.LEVEL)), 3);
            }
        }
    }
}
