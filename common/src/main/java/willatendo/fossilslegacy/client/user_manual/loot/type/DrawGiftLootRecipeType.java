package willatendo.fossilslegacy.client.user_manual.loot.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import willatendo.fossilslegacy.client.user_manual.loot.DrawGiftLootRecipe;
import willatendo.fossilslegacy.client.user_manual.loot.Drop;

public final class DrawGiftLootRecipeType {
    public static final MapCodec<DrawGiftLootRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(BuiltInRegistries.VILLAGER_PROFESSION.byNameCodec().fieldOf("display").forGetter(DrawGiftLootRecipe::villagerProfession), Codec.list(Codec.list(Drop.CODEC)).fieldOf("loot").forGetter(DrawGiftLootRecipe::drops)).apply(instance, DrawGiftLootRecipe::new));

    private DrawGiftLootRecipeType() {
    }
}
