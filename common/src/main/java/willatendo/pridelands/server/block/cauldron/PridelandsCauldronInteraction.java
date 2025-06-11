package willatendo.pridelands.server.block.cauldron;

import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import willatendo.pridelands.server.item.PridelandsItems;

import java.util.Map;

public final class PridelandsCauldronInteraction {
    public static void init() {
        Map<Item, CauldronInteraction> emptyMap = CauldronInteraction.EMPTY.map();
        PridelandsCauldronInteraction.addDefaultInteractions(emptyMap);

        Map<Item, CauldronInteraction> waterMap = CauldronInteraction.WATER.map();
        waterMap.put(PridelandsItems.PRIDESTONE_JAR.get(), (blockState, level, blockPos, player, interactionHand, itemStack) -> CauldronInteraction.fillBucket(blockState, level, blockPos, player, interactionHand, itemStack, new ItemStack(PridelandsItems.WATER_PRIDESTONE_JAR.get()), cauldronBlockState -> cauldronBlockState.getValue(LayeredCauldronBlock.LEVEL) == 3, SoundEvents.BUCKET_FILL));
        PridelandsCauldronInteraction.addDefaultInteractions(waterMap);

        Map<Item, CauldronInteraction> lavaMap = CauldronInteraction.LAVA.map();
        lavaMap.put(PridelandsItems.PRIDESTONE_JAR.get(), (blockState, level, blockPos, player, interactionHand, itemStack) -> CauldronInteraction.fillBucket(blockState, level, blockPos, player, interactionHand, itemStack, new ItemStack(PridelandsItems.LAVA_PRIDESTONE_JAR.get()), cauldronBlockState -> true, SoundEvents.BUCKET_FILL));
        PridelandsCauldronInteraction.addDefaultInteractions(lavaMap);
    }

    private static void addDefaultInteractions(Map<Item, CauldronInteraction> interactionsMap) {
        interactionsMap.put(PridelandsItems.LAVA_PRIDESTONE_JAR.get(), PridelandsCauldronInteraction::fillLavaInteraction);
        interactionsMap.put(PridelandsItems.WATER_PRIDESTONE_JAR.get(), PridelandsCauldronInteraction::fillWaterInteraction);
    }

    private static InteractionResult fillWaterInteraction(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, ItemStack filledStack) {
        return PridelandsCauldronInteraction.emptyPridestoneJar(level, pos, player, hand, filledStack, Blocks.WATER_CAULDRON.defaultBlockState().setValue(LayeredCauldronBlock.LEVEL, 3), SoundEvents.BUCKET_EMPTY);
    }

    private static InteractionResult fillLavaInteraction(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, ItemStack filledStack) {
        return PridelandsCauldronInteraction.isUnderWater(level, pos) ? InteractionResult.CONSUME : PridelandsCauldronInteraction.emptyPridestoneJar(level, pos, player, hand, filledStack, Blocks.LAVA_CAULDRON.defaultBlockState(), SoundEvents.BUCKET_EMPTY_LAVA);
    }

    private static InteractionResult emptyPridestoneJar(Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, ItemStack filledItemStack, BlockState blockState, SoundEvent emptySound) {
        if (!level.isClientSide) {
            Item item = filledItemStack.getItem();
            player.setItemInHand(interactionHand, ItemUtils.createFilledResult(filledItemStack, player, new ItemStack(PridelandsItems.PRIDESTONE_JAR.get())));
            player.awardStat(Stats.FILL_CAULDRON);
            player.awardStat(Stats.ITEM_USED.get(item));
            level.setBlockAndUpdate(blockPos, blockState);
            level.playSound(null, blockPos, emptySound, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.gameEvent(null, GameEvent.FLUID_PLACE, blockPos);
        }

        return InteractionResult.SUCCESS;
    }

    private static boolean isUnderWater(Level level, BlockPos blockPos) {
        FluidState fluidstate = level.getFluidState(blockPos.above());
        return fluidstate.is(FluidTags.WATER);
    }
}
