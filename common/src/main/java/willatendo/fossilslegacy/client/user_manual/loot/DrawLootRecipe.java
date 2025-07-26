package willatendo.fossilslegacy.client.user_manual.loot;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.client.user_manual.draw.SlotPlacer;
import willatendo.fossilslegacy.client.user_manual.draw.SpriteDrawer;
import willatendo.fossilslegacy.client.user_manual.loot.type.DrawLootRecipeTypes;

public interface DrawLootRecipe {
    Codec<DrawLootRecipe> CODEC = DrawLootRecipeTypes.CODEC.dispatch(DrawLootRecipe::type, DrawLootRecipeTypes::getCodec);

    DrawLootRecipeTypes type();

    void draw(Level level, SlotPlacer slotPlacer, SpriteDrawer spriteDrawer);
}
