package willatendo.fossilslegacy.client.user_manual;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.Recipe;
import willatendo.fossilslegacy.client.user_manual.loot.DrawLootRecipe;

import java.util.List;

public record UserManualItemDisplayData(List<ResourceKey<Recipe<?>>> displayedRecipes, List<DrawLootRecipe> displayedLootRecipes, List<Component> displayedParagraphs) {
    public static final Codec<UserManualItemDisplayData> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.list(ResourceKey.codec(Registries.RECIPE)).fieldOf("displayed_recipes").forGetter(userManualItemDisplayData -> userManualItemDisplayData.displayedRecipes), Codec.list(DrawLootRecipe.CODEC).fieldOf("displayed_loot_tables").forGetter(userManualItemDisplayData -> userManualItemDisplayData.displayedLootRecipes), Codec.list(ComponentSerialization.CODEC).fieldOf("displayed_paragraphs").forGetter(userManualItemDisplayData -> userManualItemDisplayData.displayedParagraphs)).apply(instance, UserManualItemDisplayData::new));
    public static final UserManualItemDisplayData EMPTY = new UserManualItemDisplayData(List.of(), List.of(), List.of());

    public static UserManualItemDisplayData create(List<ResourceKey<Recipe<?>>> displayedRecipes, List<DrawLootRecipe> displayedLootRecipes, List<Component> displayedParagraphs) {
        return new UserManualItemDisplayData(displayedRecipes, displayedLootRecipes, displayedParagraphs);
    }
}
