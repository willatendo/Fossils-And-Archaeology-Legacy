package willatendo.fossilslegacy.client.screen.user_manuel;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManuelData {
    private static final Map<Item, ItemPage> ITEM_INFORMATION = new HashMap<>();

    public static ItemPage getItemInformation(ItemStack itemStack) {
        Item item = itemStack.getItem();
        if (!ITEM_INFORMATION.containsKey(item)) {
            return ItemPage.EMPTY;
        }
        return ITEM_INFORMATION.get(item);
    }

    public static void init() {
        UserManuelData.add(FAItems.CENOZOIC_FOSSIL.get(), List.of(FAUtils.resource("")), Component.literal("Fossils from the Cenozoic. From Cenozoic Fossil Ore, which can be found from y128-y50."), Component.literal("Can be used in some recipes and can give DNA from the cenozoic."), Component.literal("For more information, look to the recipes."));
    }

    public static void add(Item item, Component... informaiton) {
        UserManuelData.add(item, List.of(), informaiton);
    }

    public static void add(Item item, List<ResourceLocation> recipes, Component... informaiton) {
        ITEM_INFORMATION.put(item, new ItemPage(recipes, Arrays.asList(informaiton)));
    }

    public record ItemPage(List<ResourceLocation> recipes, List<Component> information) {
        public static final ItemPage EMPTY = new ItemPage(List.of(), List.of());
    }
}
