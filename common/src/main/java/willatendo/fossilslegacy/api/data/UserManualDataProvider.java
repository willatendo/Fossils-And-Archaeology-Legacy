package willatendo.fossilslegacy.api.data;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import willatendo.fossilslegacy.client.user_manual.UserManualItemDisplayData;
import willatendo.fossilslegacy.client.user_manual.loot.DrawLootRecipe;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class UserManualDataProvider implements DataProvider {
    private final PackOutput packOutput;
    private final String modId;
    protected final Map<ResourceLocation, UserManualItemDisplayData> userManualItemData = new HashMap<>();

    public UserManualDataProvider(PackOutput packOutput, String modId) {
        this.packOutput = packOutput;
        this.modId = modId;
    }

    protected void add(ItemLike itemLike, List<ResourceLocation> displayedRecipes, List<DrawLootRecipe> displayedLootTables, Component... displayedParagraphs) {
        Item item = itemLike.asItem();

        this.add(this.mod(BuiltInRegistries.ITEM.getKey(item).getPath()), UserManualItemDisplayData.create(displayedRecipes.stream().map(this::createRecipeKey).toList(), displayedLootTables, Arrays.asList(displayedParagraphs)));
    }

    protected void add(ResourceLocation modelId, UserManualItemDisplayData userManualItemDisplayData) {
        this.userManualItemData.put(modelId, userManualItemDisplayData);
    }

    private ResourceKey<Recipe<?>> createRecipeKey(ResourceLocation id) {
        return ResourceKey.create(Registries.RECIPE, id);
    }

    protected abstract void getAll();

    protected ResourceLocation mod(String name) {
        return SimpleUtils.resource(this.modId, name);
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        this.userManualItemData.clear();
        this.getAll();
        return DataProvider.saveAll(cachedOutput, UserManualItemDisplayData.CODEC, this.packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "fossilslegacy/user_manual/item_data"), this.userManualItemData);
    }

    @Override
    public String getName() {
        return "User Manual Data: " + this.modId;
    }
}
