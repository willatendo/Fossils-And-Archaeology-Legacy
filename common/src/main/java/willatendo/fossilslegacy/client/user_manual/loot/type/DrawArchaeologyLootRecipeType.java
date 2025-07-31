package willatendo.fossilslegacy.client.user_manual.loot.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.ComponentSerialization;
import willatendo.fossilslegacy.client.user_manual.loot.DrawArchaeologyLootRecipe;
import willatendo.fossilslegacy.client.user_manual.loot.Drop;

public final class DrawArchaeologyLootRecipeType {
    public static final MapCodec<DrawArchaeologyLootRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(ComponentSerialization.CODEC.fieldOf("structure_name").forGetter(DrawArchaeologyLootRecipe::structureName), BuiltInRegistries.BLOCK.byNameCodec().fieldOf("suspicious_block").forGetter(DrawArchaeologyLootRecipe::suspiciousBlock), Codec.list(Codec.list(Drop.CODEC)).fieldOf("loot").forGetter(DrawArchaeologyLootRecipe::loot)).apply(instance, DrawArchaeologyLootRecipe::new));

    private DrawArchaeologyLootRecipeType() {
    }
}
