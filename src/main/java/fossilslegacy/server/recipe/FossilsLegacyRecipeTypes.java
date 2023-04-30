package fossilslegacy.server.recipe;

import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FossilsLegacyRecipeTypes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, FossilsLegacyUtils.ID);

	public static final RegistryObject<ModRecipeType<ArchaeologyRecipe>> ARCHAEOLOGY = RECIPE_TYPES.register("archaeology", () -> new ModRecipeType<ArchaeologyRecipe>());
	public static final RegistryObject<ModRecipeType<CultivationRecipe>> CULTIVATION = RECIPE_TYPES.register("cultivation", () -> new ModRecipeType<CultivationRecipe>());
}
