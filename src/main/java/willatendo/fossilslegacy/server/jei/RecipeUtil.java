package willatendo.fossilslegacy.server.jei;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;

public class RecipeUtil {
	public static ItemStack getResultItem(Recipe<?> recipe) {
		Minecraft minecraft = Minecraft.getInstance();
		ClientLevel clientLevel = minecraft.level;
		if (clientLevel == null) {
			throw new NullPointerException("level must not be null.");
		}
		RegistryAccess registryAccess = clientLevel.registryAccess();
		return recipe.getResultItem(registryAccess);
	}

}
