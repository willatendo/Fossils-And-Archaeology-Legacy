package willatendo.fossilslegacy.server.jei.recipe;

import net.minecraft.world.item.ItemStack;

import java.util.List;

public record FuelRecipe(List<ItemStack> itemStacks, int time) {
    public FuelRecipe(ItemStack itemStack, int time) {
        this(List.of(itemStack), time);
    }
}
