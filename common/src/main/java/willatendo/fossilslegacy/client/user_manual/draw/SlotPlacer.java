package willatendo.fossilslegacy.client.user_manual.draw;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import willatendo.fossilslegacy.client.screen.user_manual.UserManualGhostSlots;

import java.util.List;

public interface SlotPlacer {
    static SlotPlacer.SimpleSlotPlacer simple(UserManualGhostSlots slots, int leftPos, int topPos) {
        return new SlotPlacer.SimpleSlotPlacer(slots, leftPos, topPos);
    }

    void place(int x, int y, List<ItemStack> itemStacks);

    default void place(int x, int y, ItemStack itemStack) {
        this.place(x, y, List.of(itemStack));
    }

    default void place(int x, int y, Ingredient ingredient) {
        this.place(x, y, ingredient.items().map(Holder::value).map(ItemStack::new).toList());
    }

    final class SimpleSlotPlacer implements SlotPlacer {
        private final UserManualGhostSlots slots;
        private final int leftPos;
        private final int topPos;

        private SimpleSlotPlacer(UserManualGhostSlots slots, int leftPos, int topPos) {
            this.slots = slots;
            this.leftPos = leftPos;
            this.topPos = topPos;
        }

        @Override
        public void place(int x, int y, List<ItemStack> itemStacks) {
            this.slots.add(itemStacks, this.leftPos + x, this.topPos + y, 16, 16);
        }
    }
}
