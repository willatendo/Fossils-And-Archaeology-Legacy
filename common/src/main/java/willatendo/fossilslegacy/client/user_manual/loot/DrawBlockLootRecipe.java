package willatendo.fossilslegacy.client.user_manual.loot;

import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.client.screen.UserManualScreen;
import willatendo.fossilslegacy.client.user_manual.draw.SlotPlacer;
import willatendo.fossilslegacy.client.user_manual.draw.SpriteDrawer;
import willatendo.fossilslegacy.client.user_manual.loot.type.DrawLootRecipeTypes;
import willatendo.fossilslegacy.server.tags.FABlockTags;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.platform.ModloaderHelper;
import willatendo.simplelibrary.server.util.Platform;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record DrawBlockLootRecipe(Block block, List<List<Drop>> drops) implements DrawLootRecipe {
    public static DrawBlockLootRecipe dropSelf(Block block) {
        return new DrawBlockLootRecipe(block, List.of(List.of(Drop.drop(block.asItem()))));
    }

    public static DrawBlockLootRecipe dropOther(Block block, ItemLike drop) {
        return new DrawBlockLootRecipe(block, List.of(List.of(Drop.drop(drop.asItem()))));
    }

    public static DrawBlockLootRecipe dropMany(Block block, List<Drop>... drops) {
        return new DrawBlockLootRecipe(block, Arrays.asList(drops));
    }

    @Override
    public void draw(Level level, SlotPlacer slotPlacer, SpriteDrawer spriteDrawer) {
        int dropSlots = this.drops.size();
        int fullWidth = (18 * dropSlots) + 54;
        int leftPos = (176 / 2) - (fullWidth / 2);
        slotPlacer.place(leftPos - 31, 1, new ItemStack(this.block));
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
        String text = "";
        boolean addition = false;
        if (ModloaderHelper.INSTANCE.getPlatform() == Platform.NEOFORGE) {
            if (this.block.defaultBlockState().is(FABlockTags.NEEDS_WOOD_TOOL)) {
                text = "wood";
                addition = true;
            } else if (this.block.defaultBlockState().is(FABlockTags.NEEDS_GOLD_TOOL)) {
                text = "gold";
                addition = true;
            } else if (this.block.defaultBlockState().is(FABlockTags.NEEDS_NETHERITE_TOOL)) {
                text = "netherite";
                addition = true;
            }
        }
        if (this.block.defaultBlockState().is(BlockTags.NEEDS_STONE_TOOL)) {
            text = "stone";
            addition = true;
        } else if (this.block.defaultBlockState().is(BlockTags.NEEDS_IRON_TOOL)) {
            text = "iron";
            addition = true;
        } else if (this.block.defaultBlockState().is(BlockTags.NEEDS_DIAMOND_TOOL)) {
            text = "diamond";
            addition = true;
        } else if (this.block.defaultBlockState().is(FABlockTags.NEEDS_SCARAB_GEM_TOOL)) {
            text = "scarab";
            addition = true;
        }
        if (addition) {
            text += "_";
        }
        if (this.block.defaultBlockState().is(BlockTags.MINEABLE_WITH_PICKAXE)) {
            text += "pickaxe";
        } else if (this.block.defaultBlockState().is(BlockTags.MINEABLE_WITH_SHOVEL)) {
            text += "shovel";
        } else if (this.block.defaultBlockState().is(BlockTags.MINEABLE_WITH_AXE)) {
            text += "axe";
        } else if (this.block.defaultBlockState().is(BlockTags.MINEABLE_WITH_HOE)) {
            text += "hoe";
        }
        if (!text.isEmpty()) {
            spriteDrawer.drawCentered(88, 25, FAUtils.translation("item", "user_manual.drop.requirement." + text), 4210752);
        }
    }

    @Override
    public DrawLootRecipeTypes type() {
        return DrawLootRecipeTypes.BLOCK_LOOT;
    }

    @Override
    public int dropSize() {
        return this.drops.size();
    }
}
