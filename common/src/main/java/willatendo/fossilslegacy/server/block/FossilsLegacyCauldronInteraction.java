package willatendo.fossilslegacy.server.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

import java.util.Map;
import java.util.function.Predicate;

public class FossilsLegacyCauldronInteraction {
    public static final CauldronInteraction.InteractionMap RAW_CHICKEN_SOUP = CauldronInteraction.newInteractionMap("raw_chicken_soup");
    public static final CauldronInteraction.InteractionMap COOKED_CHICKEN_SOUP = CauldronInteraction.newInteractionMap("cooked_chicken_soup");
    public static final CauldronInteraction.InteractionMap RAW_BERRY_MEDLEY = CauldronInteraction.newInteractionMap("raw_berry_medley_soup");
    public static final CauldronInteraction.InteractionMap COOKED_BERRY_MEDLEY = CauldronInteraction.newInteractionMap("cooked_berry_medley_soup");

    public static final CauldronInteraction FILL_RAW_CHICKEN_SOUP = (blockState, level, blockPos, player, interactionHand, itemStack) -> CauldronInteraction.emptyBucket(level, blockPos, player, interactionHand, itemStack, FossilsLegacyBlocks.RAW_CHICKEN_SOUP_CAULDRON.get().defaultBlockState().setValue(SoupCauldronBlock.LEVEL, 8), SoundEvents.BUCKET_EMPTY);
    public static final CauldronInteraction FILL_COOKED_CHICKEN_SOUP = (blockState, level, blockPos, player, interactionHand, itemStack) -> CauldronInteraction.emptyBucket(level, blockPos, player, interactionHand, itemStack, FossilsLegacyBlocks.COOKED_CHICKEN_SOUP_CAULDRON.get().defaultBlockState().setValue(SoupCauldronBlock.LEVEL, 8), SoundEvents.BUCKET_EMPTY);
    public static final CauldronInteraction FILL_RAW_BERRY_MEDLEY = (blockState, level, blockPos, player, interactionHand, itemStack) -> CauldronInteraction.emptyBucket(level, blockPos, player, interactionHand, itemStack, FossilsLegacyBlocks.RAW_BERRY_MEDLEY_CAULDRON.get().defaultBlockState().setValue(SoupCauldronBlock.LEVEL, 8), SoundEvents.BUCKET_EMPTY);
    public static final CauldronInteraction FILL_COOKED_BERRY_MEDLEY = (blockState, level, blockPos, player, interactionHand, itemStack) -> CauldronInteraction.emptyBucket(level, blockPos, player, interactionHand, itemStack, FossilsLegacyBlocks.COOKED_BERRY_MEDLEY_CAULDRON.get().defaultBlockState().setValue(SoupCauldronBlock.LEVEL, 8), SoundEvents.BUCKET_EMPTY);

    public static void init() {
        Map<Item, CauldronInteraction> rawChickenSoup = RAW_CHICKEN_SOUP.map();
        rawChickenSoup.put(Items.BUCKET, (blockState, level, blockPos, player, interactionHand, itemStack) -> FossilsLegacyCauldronInteraction.fillBucket(blockState, level, blockPos, player, interactionHand, itemStack, new ItemStack(FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get()), passBlockState -> passBlockState.getValue(SoupCauldronBlock.LEVEL) == 8, SoundEvents.BUCKET_FILL));
        FossilsLegacyCauldronInteraction.defaultFill(rawChickenSoup);
        Map<Item, CauldronInteraction> cookedChickenSoup = COOKED_CHICKEN_SOUP.map();
        cookedChickenSoup.put(Items.GLASS_BOTTLE, (blockState, level, blockPos, player, interactionHand, itemStack) -> {
            if (!level.isClientSide) {
                Item item = itemStack.getItem();
                player.setItemInHand(interactionHand, ItemUtils.createFilledResult(itemStack, player, new ItemStack(FossilsLegacyItems.CHICKEN_ESSENCE_BOTTLE.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                SoupCauldronBlock.lowerFillLevel(blockState, level, blockPos);
                level.playSound(null, blockPos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent(null, GameEvent.FLUID_PICKUP, blockPos);
            }

            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        });
        cookedChickenSoup.put(Items.BUCKET, (blockState, level, blockPos, player, interactionHand, itemStack) -> FossilsLegacyCauldronInteraction.fillBucket(blockState, level, blockPos, player, interactionHand, itemStack, new ItemStack(FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get()), passBlockState -> passBlockState.getValue(SoupCauldronBlock.LEVEL) == 8, SoundEvents.BUCKET_FILL));
        FossilsLegacyCauldronInteraction.defaultFill(cookedChickenSoup);
        Map<Item, CauldronInteraction> rawBerryMedley = RAW_BERRY_MEDLEY.map();
        rawBerryMedley.put(Items.BUCKET, (blockState, level, blockPos, player, interactionHand, itemStack) -> FossilsLegacyCauldronInteraction.fillBucket(blockState, level, blockPos, player, interactionHand, itemStack, new ItemStack(FossilsLegacyItems.RAW_BERRY_MEDLEY_BUCKET.get()), passBlockState -> passBlockState.getValue(SoupCauldronBlock.LEVEL) == 8, SoundEvents.BUCKET_FILL));
        FossilsLegacyCauldronInteraction.defaultFill(rawBerryMedley);
        Map<Item, CauldronInteraction> cookedBerryMedley = COOKED_BERRY_MEDLEY.map();
        cookedBerryMedley.put(Items.GLASS_BOTTLE, (blockState, level, blockPos, player, interactionHand, itemStack) -> {
            if (!level.isClientSide) {
                Item $$6 = itemStack.getItem();
                player.setItemInHand(interactionHand, ItemUtils.createFilledResult(itemStack, player, new ItemStack(FossilsLegacyItems.ROMANTIC_CONCOCTION_BOTTLE.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get($$6));
                SoupCauldronBlock.lowerFillLevel(blockState, level, blockPos);
                level.playSound(null, blockPos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent(null, GameEvent.FLUID_PICKUP, blockPos);
            }

            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        });
        cookedBerryMedley.put(Items.BUCKET, (blockState, level, blockPos, player, interactionHand, itemStack) -> FossilsLegacyCauldronInteraction.fillBucket(blockState, level, blockPos, player, interactionHand, itemStack, new ItemStack(FossilsLegacyItems.COOKED_BERRY_MEDLEY_BUCKET.get()), passBlockState -> passBlockState.getValue(SoupCauldronBlock.LEVEL) == 8, SoundEvents.BUCKET_FILL));
        FossilsLegacyCauldronInteraction.defaultFill(cookedBerryMedley);
        FossilsLegacyCauldronInteraction.modFill(CauldronInteraction.EMPTY.map());
        FossilsLegacyCauldronInteraction.modFill(CauldronInteraction.WATER.map());
        FossilsLegacyCauldronInteraction.modFill(CauldronInteraction.LAVA.map());
        FossilsLegacyCauldronInteraction.modFill(CauldronInteraction.POWDER_SNOW.map());
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
        map.put(FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get(), FILL_RAW_CHICKEN_SOUP);
        map.put(FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get(), FILL_COOKED_CHICKEN_SOUP);
        map.put(FossilsLegacyItems.RAW_BERRY_MEDLEY_BUCKET.get(), FILL_RAW_BERRY_MEDLEY);
        map.put(FossilsLegacyItems.COOKED_BERRY_MEDLEY_BUCKET.get(), FILL_COOKED_BERRY_MEDLEY);
    }

    private static void defaultFill(Map<Item, CauldronInteraction> map) {
        FossilsLegacyCauldronInteraction.modFill(map);
        CauldronInteraction.addDefaultInteractions(map);
    }
}
