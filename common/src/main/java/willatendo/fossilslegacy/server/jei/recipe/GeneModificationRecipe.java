package willatendo.fossilslegacy.server.jei.recipe;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.crafting.Ingredient;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;

import java.util.List;

public record GeneModificationRecipe(Component type, List<CoatType> coatTypes, Ingredient ingredient, boolean hasLegacy) {
}
