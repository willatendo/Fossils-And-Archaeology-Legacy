package willatendo.fossilslegacy.client.user_manual.loot.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import willatendo.fossilslegacy.client.user_manual.loot.DrawBlockLootRecipe;

public final class DrawBlockLootRecipeType {
    public static final MapCodec<DrawBlockLootRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(BuiltInRegistries.BLOCK.byNameCodec().fieldOf("display").forGetter(DrawBlockLootRecipe::block), Codec.list(BuiltInRegistries.ITEM.byNameCodec()).fieldOf("drops").forGetter(DrawBlockLootRecipe::drops)).apply(instance, DrawBlockLootRecipe::new));

    private DrawBlockLootRecipeType() {
    }
}
