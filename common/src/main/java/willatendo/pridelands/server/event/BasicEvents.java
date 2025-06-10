package willatendo.pridelands.server.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.item.DispensibleContainerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import willatendo.pridelands.server.block.PridelandsBlocks;
import willatendo.pridelands.server.block.cauldron.PridelandsCauldronInteraction;
import willatendo.pridelands.server.item.PridelandsItems;
import willatendo.pridelands.server.item.items.JarItem;
import willatendo.simplelibrary.server.event.modification.FlammablesModification;

public final class BasicEvents {
    public static void commonSetup() {
        JarItem.FLUID_TO_JAR.put(Items.WATER_BUCKET, PridelandsItems.WATER_PRIDESTONE_JAR.get());
        JarItem.FLUID_TO_JAR.put(Items.LAVA_BUCKET, PridelandsItems.LAVA_PRIDESTONE_JAR.get());

        PridelandsCauldronInteraction.init();

        DispenseItemBehavior bucketLikeDispenseBehavior = new DefaultDispenseItemBehavior() {
            private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

            @Override
            public ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
                DispensibleContainerItem dispensibleContainerItem = (DispensibleContainerItem) itemStack.getItem();
                BlockPos blockPos = blockSource.pos().relative(blockSource.state().getValue(DispenserBlock.FACING));
                Level level = blockSource.level();
                if (dispensibleContainerItem.emptyContents(null, level, blockPos, null)) {
                    dispensibleContainerItem.checkExtraContent(null, level, itemStack, blockPos);
                    return this.consumeWithRemainder(blockSource, itemStack, new ItemStack(PridelandsItems.PRIDESTONE_JAR.get()));
                } else {
                    return this.defaultDispenseItemBehavior.dispense(blockSource, itemStack);
                }
            }
        };
        DispenserBlock.registerBehavior(PridelandsItems.LAVA_PRIDESTONE_JAR.get(), bucketLikeDispenseBehavior);
        DispenserBlock.registerBehavior(PridelandsItems.WATER_PRIDESTONE_JAR.get(), bucketLikeDispenseBehavior);

        FlammablesModification.register(PridelandsBlocks.FUR_RUG.get(), 60, 20);
        FlammablesModification.register(PridelandsBlocks.WHITE_FUR_RUG.get(), 60, 20);
        FlammablesModification.register(PridelandsBlocks.ORANGE_FUR_RUG.get(), 60, 20);
        FlammablesModification.register(PridelandsBlocks.MAGENTA_FUR_RUG.get(), 60, 20);
        FlammablesModification.register(PridelandsBlocks.LIGHT_BLUE_FUR_RUG.get(), 60, 20);
        FlammablesModification.register(PridelandsBlocks.YELLOW_FUR_RUG.get(), 60, 20);
        FlammablesModification.register(PridelandsBlocks.LIME_FUR_RUG.get(), 60, 20);
        FlammablesModification.register(PridelandsBlocks.PINK_FUR_RUG.get(), 60, 20);
        FlammablesModification.register(PridelandsBlocks.GRAY_FUR_RUG.get(), 60, 20);
        FlammablesModification.register(PridelandsBlocks.LIGHT_GRAY_FUR_RUG.get(), 60, 20);
        FlammablesModification.register(PridelandsBlocks.CYAN_FUR_RUG.get(), 60, 20);
        FlammablesModification.register(PridelandsBlocks.PURPLE_FUR_RUG.get(), 60, 20);
        FlammablesModification.register(PridelandsBlocks.BLUE_FUR_RUG.get(), 60, 20);
        FlammablesModification.register(PridelandsBlocks.BROWN_FUR_RUG.get(), 60, 20);
        FlammablesModification.register(PridelandsBlocks.GREEN_FUR_RUG.get(), 60, 20);
        FlammablesModification.register(PridelandsBlocks.RED_FUR_RUG.get(), 60, 20);
        FlammablesModification.register(PridelandsBlocks.BLACK_FUR_RUG.get(), 60, 20);
    }
}
