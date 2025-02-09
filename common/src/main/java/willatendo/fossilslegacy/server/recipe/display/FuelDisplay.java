package willatendo.fossilslegacy.server.recipe.display;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.context.ContextMap;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.display.DisplayContentsFactory;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplayContext;
import willatendo.fossilslegacy.server.fuel.FuelEntry;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.stream.Stream;

public record FuelDisplay(TagKey<FuelEntry> fuels) implements SlotDisplay {
    @Override
    public <T> Stream<T> resolve(ContextMap contextMap, DisplayContentsFactory<T> displayContentsFactory) {
        if (displayContentsFactory instanceof DisplayContentsFactory.ForStacks<T> forStacks) {
            HolderLookup.Provider provider = contextMap.getOptional(SlotDisplayContext.REGISTRIES);
            if (provider != null) {
                Stream<ItemStack> results = provider.lookupOrThrow(FARegistries.FUEL_ENTRY).get(this.fuels).map(analyzerResult -> analyzerResult.stream().map(fuelEntryHolder -> new ItemStack(BuiltInRegistries.ITEM.getValue(fuelEntryHolder.value().fuel())))).get();
                return results.map(forStacks::forStack);
            }
        }

        return Stream.empty();
    }

    @Override
    public Type<? extends SlotDisplay> type() {
        return null;
    }
}
