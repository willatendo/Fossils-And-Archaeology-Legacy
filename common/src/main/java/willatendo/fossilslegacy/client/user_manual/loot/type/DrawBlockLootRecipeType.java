package willatendo.fossilslegacy.client.user_manual.loot.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.client.user_manual.loot.DrawBlockLootRecipe;
import willatendo.fossilslegacy.client.user_manual.loot.Drop;

public final class DrawBlockLootRecipeType {
    public static final MapCodec<DrawBlockLootRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(ItemStack.STRICT_SINGLE_ITEM_CODEC.fieldOf("display").forGetter(DrawBlockLootRecipe::itemStack), Codec.list(Codec.list(Drop.CODEC)).fieldOf("loot").forGetter(DrawBlockLootRecipe::drops)).apply(instance, DrawBlockLootRecipe::new));

    private DrawBlockLootRecipeType() {
    }
}
