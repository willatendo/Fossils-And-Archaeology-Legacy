package willatendo.fossilslegacy.client.user_manual.loot;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.client.user_manual.draw.SlotPlacer;
import willatendo.fossilslegacy.client.user_manual.draw.SpriteDrawer;
import willatendo.fossilslegacy.client.user_manual.loot.type.DrawLootRecipeTypes;
import willatendo.fossilslegacy.server.tags.FABlockTags;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.platform.ModloaderHelper;
import willatendo.simplelibrary.server.util.Platform;

import java.util.List;

public record DrawBlockLootRecipe(Block block, List<Item> drops) implements DrawLootRecipe {
    public static DrawBlockLootRecipe dropSelf(Block block) {
        return new DrawBlockLootRecipe(block, List.of(block.asItem()));
    }

    public static DrawBlockLootRecipe dropOther(Block block, ItemLike drop) {
        return new DrawBlockLootRecipe(block, List.of(drop.asItem()));
    }

    @Override
    public void draw(Level level, SlotPlacer slotPlacer, SpriteDrawer spriteDrawer) {
        slotPlacer.place(1, 1, new ItemStack(this.block));
        for (int i = 0; i < this.drops.size(); i++) {
            slotPlacer.place(55 + (i * 18), 1, new ItemStack(this.drops.get(i)));
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
            spriteDrawer.drawCentered((176 / 2), 25, FAUtils.translation("item", "user_manual.drop.requirement." + text), 4210752);
        }
    }

    @Override
    public DrawLootRecipeTypes type() {
        return DrawLootRecipeTypes.BLOCK_LOOT;
    }
}
