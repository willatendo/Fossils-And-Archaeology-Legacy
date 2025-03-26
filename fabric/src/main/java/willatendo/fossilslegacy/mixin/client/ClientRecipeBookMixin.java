package willatendo.fossilslegacy.mixin.client;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.gui.screens.recipebook.RecipeCollection;
import net.minecraft.world.item.crafting.ExtendedRecipeBookCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import willatendo.fossilslegacy.client.FASearchRecipeBookCategory;

import java.util.List;
import java.util.Map;

@Mixin(ClientRecipeBook.class)
public class ClientRecipeBookMixin {
    @Shadow
    private Map<ExtendedRecipeBookCategory, List<RecipeCollection>> collectionsByTab;

    @Inject(method = "getCollection", at = @At(value = "HEAD"), cancellable = true)
    private void fossilslegacy_getCollection(ExtendedRecipeBookCategory extendedRecipeBookCategory, CallbackInfoReturnable<List<RecipeCollection>> cir) {
        for (FASearchRecipeBookCategory faSearchRecipeBookCategory : FASearchRecipeBookCategory.values()) {
            if (extendedRecipeBookCategory == faSearchRecipeBookCategory) {
                cir.setReturnValue(faSearchRecipeBookCategory.includedCategories().stream().flatMap(recipeBookCategory -> this.collectionsByTab.getOrDefault(recipeBookCategory, List.of()).stream()).collect(ImmutableList.toImmutableList()));
            }
        }
    }
}
