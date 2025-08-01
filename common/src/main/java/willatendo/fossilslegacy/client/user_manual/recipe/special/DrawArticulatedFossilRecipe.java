package willatendo.fossilslegacy.client.user_manual.recipe.special;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.client.user_manual.draw.SlotPlacer;
import willatendo.fossilslegacy.client.user_manual.draw.SpriteDrawer;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class DrawArticulatedFossilRecipe implements DrawSpecialRecipe {
    private static final ResourceLocation SPRITE = FAUtils.resource("container/user_manual/crafting");
    private static final ResourceLocation SHAPELESS = FAUtils.resource("container/user_manual/shapeless");

    @Override
    public void draw(ItemStack input, Level level, SlotPlacer slotPlacer, SpriteDrawer spriteDrawer) {
        spriteDrawer.draw(29, 16, 116, 54, 0, 0, SPRITE);
        slotPlacer.place(124, 35, input);
        if (input.has(FADataComponents.FOSSIL_VARIANT.get())) {
            FossilVariant fossilVariant = input.get(FADataComponents.FOSSIL_VARIANT.get()).value();
            Registry<Item> itemRegistry = level.registryAccess().lookupOrThrow(Registries.ITEM);
            placeTable:
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    int index = x + (y * 3);
                    if (index < fossilVariant.fossilCount()) {
                        slotPlacer.place((x * 18) + 30, (y * 18) + 17, itemRegistry.get(fossilVariant.fossilIngredient()).get().stream().map(Holder::value).map(ItemStack::new).toList());
                    } else {
                        break placeTable;
                    }
                }
            }
        }
        spriteDrawer.draw(93, 16, 16, 16, 16, 16, SHAPELESS);
    }
}
