package willatendo.fossilslegacy.client.user_manual.draw;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class SlotPlacer {
    private final Map<Coordinate, List<ItemStack>> data = new HashMap<>();

    public void place(int x, int y, Ingredient ingredient) {
        this.data.put(new Coordinate(x, y), ingredient.items().map(ItemStack::new).toList());
    }

    public void place(int x, int y, ItemStack itemStack) {
        this.data.put(new Coordinate(x, y), List.of(itemStack));
    }

    public void place(int x, int y, List<ItemStack> itemStacks) {
        this.data.put(new Coordinate(x, y), itemStacks);
    }

    public Set<Map.Entry<Coordinate, List<ItemStack>>> forEach() {
        return this.data.entrySet();
    }
}
