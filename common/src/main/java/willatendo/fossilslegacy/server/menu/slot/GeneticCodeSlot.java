package willatendo.fossilslegacy.server.menu.slot;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import willatendo.fossilslegacy.client.screen.GeneModificationTableScreen;
import willatendo.fossilslegacy.server.item.items.GeneticCodeItem;

public class GeneticCodeSlot extends Slot {
    public GeneticCodeSlot(Container container, int slot, int x, int y) {
        super(container, slot, x, y);
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }

    @Override
    public boolean mayPlace(ItemStack itemStack) {
        return itemStack.getItem() instanceof GeneticCodeItem;
    }

    @Nullable
    @Override
    public ResourceLocation getNoItemIcon() {
        return GeneModificationTableScreen.EMPTY_SLOT_GENETIC_CODE;
    }
}
