package willatendo.fossilslegacy.mixin.client;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.gui.screens.recipebook.RecipeCollection;
import net.minecraft.world.item.crafting.ExtendedRecipeBookCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import willatendo.fossilslegacy.client.FASearchRecipeBookCategory;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mixin(ClientRecipeBook.class)
public class ClientRecipeBookMixin {
    @Shadow
    private Map<ExtendedRecipeBookCategory, List<RecipeCollection>> collectionsByTab;

    @Inject(method = "rebuildCollections", at = @At(value = "RETURN"))
    private void fossilslegacy_addModCollections(CallbackInfo ci) {
        Map<ExtendedRecipeBookCategory, List<RecipeCollection>> searchTabs = new HashMap<>();
        Map<ExtendedRecipeBookCategory, List<RecipeCollection>> saved = Map.copyOf(this.collectionsByTab);
        for (FASearchRecipeBookCategory faSearchRecipeBookCategory : FASearchRecipeBookCategory.values()) {
            searchTabs.put(faSearchRecipeBookCategory, faSearchRecipeBookCategory.includedCategories().stream().flatMap(recipeBookCategory -> searchTabs.getOrDefault(recipeBookCategory, List.of()).stream()).collect(ImmutableList.toImmutableList()));
        }
        this.collectionsByTab = new HashMap<>(saved);
        this.collectionsByTab.putAll(searchTabs);
        FAUtils.LOGGER.info("{}", this.collectionsByTab);
    }
}
