package willatendo.fossilslegacy.client.user_manual.loot;

import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
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

public record DrawBlockLootRecipe(ItemStack itemStack, List<List<Drop>> drops) implements DrawLootRecipe {
    public static DrawBlockLootRecipe dropSelf(ItemStack itemStack) {
        return new DrawBlockLootRecipe(itemStack, List.of(List.of(Drop.drop(itemStack))));
    }

    public static DrawBlockLootRecipe dropSelf(ItemLike itemLike) {
        return DrawBlockLootRecipe.dropSelf(new ItemStack(itemLike));
    }

    public static DrawBlockLootRecipe dropSelf(ItemStack itemStack, Component description) {
        return new DrawBlockLootRecipe(itemStack, List.of(List.of(Drop.drop(itemStack, description))));
    }

    public static DrawBlockLootRecipe dropSelf(ItemLike itemLike, Component description) {
        return DrawBlockLootRecipe.dropSelf(new ItemStack(itemLike), description);
    }

    public static DrawBlockLootRecipe dropOther(ItemStack itemStack, ItemLike drop) {
        return new DrawBlockLootRecipe(itemStack, List.of(List.of(Drop.drop(drop.asItem()))));
    }

    public static DrawBlockLootRecipe dropOther(ItemLike itemLike, ItemLike drop) {
        return DrawBlockLootRecipe.dropOther(new ItemStack(itemLike), drop);
    }

    public static DrawBlockLootRecipe dropMany(ItemStack itemStack, List<Drop>... drops) {
        return new DrawBlockLootRecipe(itemStack, Arrays.asList(drops));
    }

    public static DrawBlockLootRecipe dropMany(ItemLike itemLike, List<Drop>... drops) {
        return DrawBlockLootRecipe.dropMany(new ItemStack(itemLike), drops);
    }

    @Override
    public void draw(Level level, SlotPlacer slotPlacer, SpriteDrawer spriteDrawer) {
        int dropSlots = this.drops.size();
        int fullWidth = (18 * dropSlots) + 54;
        int leftPos = (176 / 2) - (fullWidth / 2);
        slotPlacer.place(leftPos + 1, 35, this.itemStack);
        for (int i = 0; i < dropSlots; i++) {
            int x = fullWidth - ((dropSlots - i) * 18) + leftPos;
            spriteDrawer.draw(x, 34, 18, 18, 0, 0, UserManualScreen.SLOT_SPRITE);
            slotPlacer.place(x + 1, 35, this.drops.get(i).stream().map(Drop::itemStack).toList());
            List<Optional<Component>> chances = this.drops.get(i).stream().map(Drop::description).toList();
            int extra = 0;
            if (i % 2 != 0) {
                extra += 10;
            }
            spriteDrawer.drawCentered(x + 9, 54 + extra, chances.stream().map(optionalComponent -> optionalComponent.orElse(Component.empty())).toList(), 4210752);
        }
        if (this.itemStack.getItem() instanceof BlockItem blockItem) {
            Block block = blockItem.getBlock();
            String text = "";
            boolean addition = false;
            if (ModloaderHelper.INSTANCE.getPlatform() == Platform.NEOFORGE) {
                if (block.defaultBlockState().is(FABlockTags.NEEDS_WOOD_TOOL)) {
                    text = "wood";
                    addition = true;
                } else if (block.defaultBlockState().is(FABlockTags.NEEDS_GOLD_TOOL)) {
                    text = "gold";
                    addition = true;
                } else if (block.defaultBlockState().is(FABlockTags.NEEDS_NETHERITE_TOOL)) {
                    text = "netherite";
                    addition = true;
                }
            }
            if (block.defaultBlockState().is(BlockTags.NEEDS_STONE_TOOL)) {
                text = "stone";
                addition = true;
            } else if (block.defaultBlockState().is(BlockTags.NEEDS_IRON_TOOL)) {
                text = "iron";
                addition = true;
            } else if (block.defaultBlockState().is(BlockTags.NEEDS_DIAMOND_TOOL)) {
                text = "diamond";
                addition = true;
            } else if (block.defaultBlockState().is(FABlockTags.NEEDS_SCARAB_GEM_TOOL)) {
                text = "scarab";
                addition = true;
            }
            if (addition) {
                text += "_";
            }
            if (block.defaultBlockState().is(BlockTags.MINEABLE_WITH_PICKAXE)) {
                text += "pickaxe";
            } else if (block.defaultBlockState().is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                text += "shovel";
            } else if (block.defaultBlockState().is(BlockTags.MINEABLE_WITH_AXE)) {
                text += "axe";
            } else if (block.defaultBlockState().is(BlockTags.MINEABLE_WITH_HOE)) {
                text += "hoe";
            }
            if (!text.isEmpty()) {
                spriteDrawer.drawCentered(88, 25, FAUtils.translation("item", "user_manual.drop.requirement." + text), 4210752);
            }
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
