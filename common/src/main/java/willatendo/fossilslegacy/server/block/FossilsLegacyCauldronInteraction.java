package willatendo.fossilslegacy.server.block;

import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.gameevent.GameEvent;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

import java.util.Map;

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
        FossilsLegacyCauldronInteraction.defaultFill(rawChickenSoup);
        Map<Item, CauldronInteraction> cookedChickenSoup = COOKED_CHICKEN_SOUP.map();
        cookedChickenSoup.put(Items.GLASS_BOTTLE, (blockState, level, blockPos, player, interactionHand, itemStack) -> {
            if (!level.isClientSide) {
                Item $$6 = itemStack.getItem();
                player.setItemInHand(interactionHand, ItemUtils.createFilledResult(itemStack, player, new ItemStack(FossilsLegacyItems.CHICKEN_ESSENCE_BOTTLE.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get($$6));
                SoupCauldronBlock.lowerFillLevel(blockState, level, blockPos);
                level.playSound(null, blockPos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent(null, GameEvent.FLUID_PICKUP, blockPos);
            }

            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        });
        FossilsLegacyCauldronInteraction.defaultFill(cookedChickenSoup);
        Map<Item, CauldronInteraction> rawBerryMedley = RAW_BERRY_MEDLEY.map();
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
        FossilsLegacyCauldronInteraction.defaultFill(cookedBerryMedley);
        FossilsLegacyCauldronInteraction.modFill(CauldronInteraction.EMPTY.map());
        FossilsLegacyCauldronInteraction.modFill(CauldronInteraction.WATER.map());
        FossilsLegacyCauldronInteraction.modFill(CauldronInteraction.LAVA.map());
        FossilsLegacyCauldronInteraction.modFill(CauldronInteraction.POWDER_SNOW.map());
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
