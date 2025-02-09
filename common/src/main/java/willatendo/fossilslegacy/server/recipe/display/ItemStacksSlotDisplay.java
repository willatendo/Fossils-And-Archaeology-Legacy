package willatendo.fossilslegacy.server.recipe.display;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.tags.TagKey;
import net.minecraft.util.context.ContextMap;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.display.DisplayContentsFactory;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplayContext;
import willatendo.fossilslegacy.server.analyzer_result.AnalyzerResult;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.stream.Stream;

public record ItemStacksSlotDisplay(TagKey<AnalyzerResult> results) implements SlotDisplay {
    public static final MapCodec<ItemStacksSlotDisplay> MAP_CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(TagKey.codec(FARegistries.ANALYZER_RESULT).fieldOf("tag").forGetter(ItemStacksSlotDisplay::results)).apply(instance, ItemStacksSlotDisplay::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, ItemStacksSlotDisplay> STREAM_CODEC = StreamCodec.composite(TagKey.streamCodec(FARegistries.ANALYZER_RESULT), ItemStacksSlotDisplay::results, ItemStacksSlotDisplay::new);
    public static final Type<ItemStacksSlotDisplay> TYPE = new Type<>(ItemStacksSlotDisplay.MAP_CODEC, ItemStacksSlotDisplay.STREAM_CODEC);

    @Override
    public <T> Stream<T> resolve(ContextMap contextMap, DisplayContentsFactory<T> displayContentsFactory) {
        if (displayContentsFactory instanceof DisplayContentsFactory.ForStacks<T> forStacks) {
            HolderLookup.Provider provider = contextMap.getOptional(SlotDisplayContext.REGISTRIES);
            if (provider != null) {
                Stream<ItemStack> results = provider.lookupOrThrow(FARegistries.ANALYZER_RESULT).get(this.results).map(analyzerResult -> analyzerResult.stream().map(analyzerResultHolder -> analyzerResultHolder.value().output())).get();
                return results.map(forStacks::forStack);
            }
        }
        return Stream.empty();
    }

    @Override
    public Type<? extends SlotDisplay> type() {
        return ItemStacksSlotDisplay.TYPE;
    }
}
