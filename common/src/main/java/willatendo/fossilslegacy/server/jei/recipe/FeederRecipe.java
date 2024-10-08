package willatendo.fossilslegacy.server.jei.recipe;

import net.minecraft.world.item.ItemStack;

public record FeederRecipe(ItemStack itemStack, int foodLevel, boolean meat) {
}
