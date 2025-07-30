package willatendo.fossilslegacy.client.user_manual.loot.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.util.StringRepresentable;
import willatendo.fossilslegacy.client.user_manual.loot.DrawLootRecipe;

public enum DrawLootRecipeTypes implements StringRepresentable {
    BLOCK_LOOT("block_loot", DrawBlockLootRecipeType.CODEC),
    CHEST_LOOT("chest_loot", DrawChestLootRecipeType.CODEC),
    GIFT_LOOT("gift_loot", DrawGiftLootRecipeType.CODEC);

    public static final Codec<DrawLootRecipeTypes> CODEC = StringRepresentable.fromValues(DrawLootRecipeTypes::values);
    private final String name;
    private final MapCodec<? extends DrawLootRecipe> codec;

    DrawLootRecipeTypes(String name, MapCodec<? extends DrawLootRecipe> codec) {
        this.name = name;
        this.codec = codec;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    public MapCodec<? extends DrawLootRecipe> getCodec() {
        return this.codec;
    }
}
