package willatendo.fossilslegacy.server.jei.recipe;

import net.minecraft.world.item.ItemStack;

import java.util.List;

public record BiomatterRecipe(List<ItemStack> itemStacks, int biomatterUseTime) {
    public BiomatterRecipe(ItemStack itemStack, int biomatterUseTime) {
        this(List.of(itemStack), biomatterUseTime);
    }
}
