package willatendo.fossilslegacy.server.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import willatendo.fossilslegacy.server.recipe.display.FuelDisplay;
import willatendo.fossilslegacy.server.recipe.display.ItemStacksSlotDisplay;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FASlotDisplays {
    public static final SimpleRegistry<SlotDisplay.Type<?>> SLOT_DISPLAY_TYPES = SimpleRegistry.create(Registries.SLOT_DISPLAY, FAUtils.ID);

    public static final SimpleHolder<SlotDisplay.Type<FuelDisplay>> FUEL = SLOT_DISPLAY_TYPES.register("fuel", () -> FuelDisplay.TYPE);
    public static final SimpleHolder<SlotDisplay.Type<ItemStacksSlotDisplay>> ITEM_STACKS = SLOT_DISPLAY_TYPES.register("item_stacks", () -> ItemStacksSlotDisplay.TYPE);
}
