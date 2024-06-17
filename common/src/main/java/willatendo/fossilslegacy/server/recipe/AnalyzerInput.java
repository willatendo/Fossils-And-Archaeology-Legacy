package willatendo.fossilslegacy.server.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

import java.util.List;

public record AnalyzerInput(ItemStack itemStack, List<ItemStack> items) implements RecipeInput {
    @Override
    public ItemStack getItem(int slotIndex) {
        return this.items.get(slotIndex);
    }

    @Override
    public int size() {
        return this.items.size();
    }
}
