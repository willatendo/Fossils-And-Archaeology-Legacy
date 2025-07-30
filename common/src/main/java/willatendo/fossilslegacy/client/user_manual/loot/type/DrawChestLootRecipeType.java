package willatendo.fossilslegacy.client.user_manual.loot.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.chat.ComponentSerialization;
import willatendo.fossilslegacy.client.user_manual.loot.DrawChestLootRecipe;
import willatendo.fossilslegacy.client.user_manual.loot.Drop;

public final class DrawChestLootRecipeType {
    public static final MapCodec<DrawChestLootRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(ComponentSerialization.CODEC.fieldOf("name").forGetter(DrawChestLootRecipe::name), Codec.list(Codec.list(Drop.CODEC)).fieldOf("loot").forGetter(DrawChestLootRecipe::loot)).apply(instance, DrawChestLootRecipe::new));

    private DrawChestLootRecipeType() {
    }
}
