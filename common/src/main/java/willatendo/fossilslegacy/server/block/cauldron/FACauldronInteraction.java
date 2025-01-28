package willatendo.fossilslegacy.server.block.cauldron;

import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.blocks.SoupCauldronBlock;
import willatendo.fossilslegacy.server.item.FAItems;

import java.util.Map;
import java.util.function.Predicate;

public class FACauldronInteraction {
    public static final CauldronInteraction.InteractionMap RAW_CHICKEN_SOUP = CauldronInteraction.newInteractionMap("raw_chicken_soup");
    public static final CauldronInteraction.InteractionMap COOKED_CHICKEN_SOUP = CauldronInteraction.newInteractionMap("cooked_chicken_soup");
    public static final CauldronInteraction.InteractionMap RAW_BERRY_MEDLEY = CauldronInteraction.newInteractionMap("raw_berry_medley_soup");
    public static final CauldronInteraction.InteractionMap COOKED_BERRY_MEDLEY = CauldronInteraction.newInteractionMap("cooked_berry_medley_soup");

    public static final CauldronInteraction FILL_RAW_CHICKEN_SOUP = (blockState, level, blockPos, player, interactionHand, itemStack) -> CauldronInteraction.emptyBucket(level, blockPos, player, interactionHand, itemStack, FABlocks.RAW_CHICKEN_SOUP_CAULDRON.get().defaultBlockState().setValue(SoupCauldronBlock.LEVEL, 8), SoundEvents.BUCKET_EMPTY);
    public static final CauldronInteraction FILL_COOKED_CHICKEN_SOUP = (blockState, level, blockPos, player, interactionHand, itemStack) -> CauldronInteraction.emptyBucket(level, blockPos, player, interactionHand, itemStack, FABlocks.COOKED_CHICKEN_SOUP_CAULDRON.get().defaultBlockState().setValue(SoupCauldronBlock.LEVEL, 8), SoundEvents.BUCKET_EMPTY);
    public static final CauldronInteraction FILL_RAW_BERRY_MEDLEY = (blockState, level, blockPos, player, interactionHand, itemStack) -> CauldronInteraction.emptyBucket(level, blockPos, player, interactionHand, itemStack, FABlocks.RAW_BERRY_MEDLEY_CAULDRON.get().defaultBlockState().setValue(SoupCauldronBlock.LEVEL, 8), SoundEvents.BUCKET_EMPTY);
    public static final CauldronInteraction FILL_COOKED_BERRY_MEDLEY = (blockState, level, blockPos, player, interactionHand, itemStack) -> CauldronInteraction.emptyBucket(level, blockPos, player, interactionHand, itemStack, FABlocks.COOKED_BERRY_MEDLEY_CAULDRON.get().defaultBlockState().setValue(SoupCauldronBlock.LEVEL, 8), SoundEvents.BUCKET_EMPTY);

    public static void init() {
        Map<Item, CauldronInteraction> rawChickenSoup = RAW_CHICKEN_SOUP.map();
        rawChickenSoup.put(Items.BUCKET, (blockState, level, blockPos, player, interactionHand, itemStack) -> FACauldronInteraction.fillBucket(blockState, level, blockPos, player, interactionHand, itemStack, new ItemStack(FAItems.RAW_CHICKEN_SOUP_BUCKET.get()), passBlockState -> passBlockState.getValue(SoupCauldronBlock.LEVEL) == 8, SoundEvents.BUCKET_FILL));
        FACauldronInteraction.defaultFill(rawChickenSoup);
        Map<Item, CauldronInteraction> cookedChickenSoup = COOKED_CHICKEN_SOUP.map();
        cookedChickenSoup.put(Items.GLASS_BOTTLE, (blockState, level, blockPos, player, interactionHand, itemStack) -> {
            if (!level.isClientSide) {
                Item item = itemStack.getItem();
                player.setItemInHand(interactionHand, ItemUtils.createFilledResult(itemStack, player, new ItemStack(FAItems.CHICKEN_ESSENCE_BOTTLE.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                SoupCauldronBlock.lowerFillLevel(blockState, level, blockPos);
                level.playSound(null, blockPos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent(null, GameEvent.FLUID_PICKUP, blockPos);
            }

            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        });
        cookedChickenSoup.put(Items.BUCKET, (blockState, level, blockPos, player, interactionHand, itemStack) -> FACauldronInteraction.fillBucket(blockState, level, blockPos, player, interactionHand, itemStack, new ItemStack(FAItems.COOKED_CHICKEN_SOUP_BUCKET.get()), passBlockState -> passBlockState.getValue(SoupCauldronBlock.LEVEL) == 8, SoundEvents.BUCKET_FILL));
        FACauldronInteraction.defaultFill(cookedChickenSoup);
        Map<Item, CauldronInteraction> rawBerryMedley = RAW_BERRY_MEDLEY.map();
        rawBerryMedley.put(Items.BUCKET, (blockState, level, blockPos, player, interactionHand, itemStack) -> FACauldronInteraction.fillBucket(blockState, level, blockPos, player, interactionHand, itemStack, new ItemStack(FAItems.RAW_BERRY_MEDLEY_BUCKET.get()), passBlockState -> passBlockState.getValue(SoupCauldronBlock.LEVEL) == 8, SoundEvents.BUCKET_FILL));
        FACauldronInteraction.defaultFill(rawBerryMedley);
        Map<Item, CauldronInteraction> cookedBerryMedley = COOKED_BERRY_MEDLEY.map();
        cookedBerryMedley.put(Items.GLASS_BOTTLE, (blockState, level, blockPos, player, interactionHand, itemStack) -> {
            if (!level.isClientSide) {
                Item $$6 = itemStack.getItem();
                player.setItemInHand(interactionHand, ItemUtils.createFilledResult(itemStack, player, new ItemStack(FAItems.ROMANTIC_CONCOCTION_BOTTLE.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get($$6));
                SoupCauldronBlock.lowerFillLevel(blockState, level, blockPos);
                level.playSound(null, blockPos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent(null, GameEvent.FLUID_PICKUP, blockPos);
            }

            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        });
        cookedBerryMedley.put(Items.BUCKET, (blockState, level, blockPos, player, interactionHand, itemStack) -> FACauldronInteraction.fillBucket(blockState, level, blockPos, player, interactionHand, itemStack, new ItemStack(FAItems.COOKED_BERRY_MEDLEY_BUCKET.get()), passBlockState -> passBlockState.getValue(SoupCauldronBlock.LEVEL) == 8, SoundEvents.BUCKET_FILL));
        FACauldronInteraction.defaultFill(cookedBerryMedley);
        FACauldronInteraction.modFill(CauldronInteraction.EMPTY.map());
        FACauldronInteraction.modFill(CauldronInteraction.WATER.map());
        FACauldronInteraction.modFill(CauldronInteraction.LAVA.map());
        FACauldronInteraction.modFill(CauldronInteraction.POWDER_SNOW.map());
    }

    private static ItemInteractionResult fillBucket(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, ItemStack emptyItemStack, ItemStack filledItemStack, Predicate<BlockState> blockStatePredicate, SoundEvent fillSound) {
        if (!blockStatePredicate.test(blockState)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        } else {
            if (!level.isClientSide) {
                Item item = emptyItemStack.getItem();
                player.setItemInHand(interactionHand, ItemUtils.createFilledResult(emptyItemStack, player, filledItemStack));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                level.setBlockAndUpdate(blockPos, Blocks.CAULDRON.defaultBlockState());
                level.playSound(null, blockPos, fillSound, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent(null, GameEvent.FLUID_PICKUP, blockPos);
            }

            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        }
    }

    private static void modFill(Map<Item, CauldronInteraction> map) {
        map.put(FAItems.RAW_CHICKEN_SOUP_BUCKET.get(), FILL_RAW_CHICKEN_SOUP);
        map.put(FAItems.COOKED_CHICKEN_SOUP_BUCKET.get(), FILL_COOKED_CHICKEN_SOUP);
        map.put(FAItems.RAW_BERRY_MEDLEY_BUCKET.get(), FILL_RAW_BERRY_MEDLEY);
        map.put(FAItems.COOKED_BERRY_MEDLEY_BUCKET.get(), FILL_COOKED_BERRY_MEDLEY);
    }

    private static void defaultFill(Map<Item, CauldronInteraction> map) {
        FACauldronInteraction.modFill(map);
        CauldronInteraction.addDefaultInteractions(map);
    }
}
