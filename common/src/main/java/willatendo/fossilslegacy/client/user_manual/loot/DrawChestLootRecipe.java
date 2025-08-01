package willatendo.fossilslegacy.client.user_manual.loot;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.client.screen.UserManualScreen;
import willatendo.fossilslegacy.client.user_manual.draw.SlotPlacer;
import willatendo.fossilslegacy.client.user_manual.draw.SpriteDrawer;
import willatendo.fossilslegacy.client.user_manual.loot.type.DrawLootRecipeTypes;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record DrawChestLootRecipe(Component name, List<List<Drop>> loot) implements DrawLootRecipe {
    public static DrawChestLootRecipe simple(Component name, List<Drop>... loot) {
        return new DrawChestLootRecipe(name, Arrays.asList(loot));
    }

    @Override
    public void draw(Level level, SlotPlacer slotPlacer, SpriteDrawer spriteDrawer) {
        int lootSlots = this.loot.size();
        int fullWidth = (18 * lootSlots) + 54;
        int leftPos = (176 / 2) - (fullWidth / 2);
        slotPlacer.place(leftPos + 1, 35, new ItemStack(Blocks.CHEST));
        for (int i = 0; i < lootSlots; i++) {
            int x = fullWidth - ((lootSlots - i) * 18) + leftPos;
            spriteDrawer.draw(x, 34, 18, 18, 0, 0, UserManualScreen.SLOT_SPRITE);
            slotPlacer.place(x + 1, 35, this.loot.get(i).stream().map(Drop::itemStack).toList());
            List<Optional<Component>> chances = this.loot.get(i).stream().map(Drop::description).toList();
            int extra = 0;
            if (i % 2 != 0) {
                extra += 10;
            }
            spriteDrawer.drawCentered(x + 9, 54 + extra, chances.stream().map(optionalComponent -> optionalComponent.orElse(Component.empty())).toList(), 4210752);
        }
        spriteDrawer.drawCentered(88, 25, this.name, 4210752);
    }

    @Override
    public int dropSize() {
        return this.loot.size();
    }

    @Override
    public DrawLootRecipeTypes type() {
        return DrawLootRecipeTypes.CHEST_LOOT;
    }
}
