package willatendo.fossilslegacy.client;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

import java.util.Arrays;
import java.util.List;

public enum FossilsLegacyRecipeBookCategories {
    ARCHAEOLOGY_WORKBENCH_SEARCH(new ItemStack(Items.COMPASS)),
    ARCHAEOLOGY_WORKBENCH_REPAIR(new ItemStack(FossilsLegacyItems.STONE_TABLET.get()));
    private final List<ItemStack> itemIcons;

    private FossilsLegacyRecipeBookCategories(ItemStack... itemIcons) {
        this.itemIcons = Arrays.asList(itemIcons);
    }
}
