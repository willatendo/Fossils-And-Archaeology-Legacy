package willatendo.fossilslegacy.client.user_manual.loot.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import willatendo.fossilslegacy.client.user_manual.loot.DrawEntityLootRecipe;
import willatendo.fossilslegacy.client.user_manual.loot.Drop;

public final class DrawEntityLootRecipeType {
    public static final MapCodec<DrawEntityLootRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(BuiltInRegistries.ITEM.byNameCodec().fieldOf("spawn_egg").forGetter(DrawEntityLootRecipe::spawnEgg), Codec.list(Codec.list(Drop.CODEC)).fieldOf("loot").forGetter(DrawEntityLootRecipe::drops)).apply(instance, DrawEntityLootRecipe::new));

    private DrawEntityLootRecipeType() {
    }
}
