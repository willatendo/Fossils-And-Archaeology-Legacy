package willatendo.fossilslegacy.client.user_manual.loot;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.client.screen.UserManualScreen;
import willatendo.fossilslegacy.client.user_manual.draw.SlotPlacer;
import willatendo.fossilslegacy.client.user_manual.draw.SpriteDrawer;
import willatendo.fossilslegacy.client.user_manual.loot.type.DrawLootRecipeTypes;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record DrawGiftLootRecipe(VillagerProfession villagerProfession, List<List<Drop>> drops) implements DrawLootRecipe {
    public static DrawGiftLootRecipe simple(VillagerProfession villagerProfession, List<Drop>... drops) {
        return new DrawGiftLootRecipe(villagerProfession, Arrays.asList(drops));
    }

    @Override
    public void draw(Level level, SlotPlacer slotPlacer, SpriteDrawer spriteDrawer) {
        int dropSlots = this.drops.size();
        int fullWidth = (18 * dropSlots) + 54;
        int leftPos = (176 / 2) - (fullWidth / 2);
        slotPlacer.place(leftPos - 31, 1, new ItemStack(Items.VILLAGER_SPAWN_EGG));
        for (int i = 0; i < dropSlots; i++) {
            int x = fullWidth - ((dropSlots - i) * 18) + leftPos;
            spriteDrawer.draw(x, 34, 18, 18, 0, 0, UserManualScreen.SLOT_SPRITE);
            slotPlacer.place(x - 31, 1, this.drops.get(i).stream().map(itemFloatPair -> new ItemStack(itemFloatPair.drop())).toList());
            List<Optional<Component>> chances = this.drops.get(i).stream().map(Drop::description).toList();
            int extra = 0;
            if (i % 2 != 0) {
                extra += 10;
            }
            spriteDrawer.drawCentered(x + 9, 54 + extra, chances.stream().map(optionalComponent -> optionalComponent.orElse(Component.empty())).toList(), 4210752);
        }
        spriteDrawer.drawCentered(88, 25, FAUtils.translation("item", "user_manual.gift.requirement.hero_of_the_village"), 4210752);
        spriteDrawer.drawCentered(88, 15, FAUtils.fullTranslation("entity.minecraft.villager.fossilslegacy." + this.villagerProfession.name()), 4210752);
    }

    @Override
    public DrawLootRecipeTypes type() {
        return DrawLootRecipeTypes.GIFT_LOOT;
    }

    @Override
    public int dropSize() {
        return this.drops.size();
    }
}
