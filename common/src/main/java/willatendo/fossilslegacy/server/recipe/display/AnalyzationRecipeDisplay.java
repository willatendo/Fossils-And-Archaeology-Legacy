package willatendo.fossilslegacy.server.recipe.display;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;

public record AnalyzationRecipeDisplay(SlotDisplay ingredient, SlotDisplay result, SlotDisplay craftingStation, int duration) implements RecipeDisplay {
    public static final MapCodec<AnalyzationRecipeDisplay> MAP_CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(SlotDisplay.CODEC.fieldOf("ingredient").forGetter(AnalyzationRecipeDisplay::ingredient), SlotDisplay.CODEC.fieldOf("result").forGetter(AnalyzationRecipeDisplay::result), SlotDisplay.CODEC.fieldOf("crafting_station").forGetter(AnalyzationRecipeDisplay::craftingStation), Codec.INT.fieldOf("duration").forGetter(AnalyzationRecipeDisplay::duration)).apply(instance, AnalyzationRecipeDisplay::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, AnalyzationRecipeDisplay> STREAM_CODEC = StreamCodec.composite(SlotDisplay.STREAM_CODEC, AnalyzationRecipeDisplay::ingredient, SlotDisplay.STREAM_CODEC, AnalyzationRecipeDisplay::result, SlotDisplay.STREAM_CODEC, AnalyzationRecipeDisplay::craftingStation, ByteBufCodecs.VAR_INT, AnalyzationRecipeDisplay::duration, AnalyzationRecipeDisplay::new);
    public static final RecipeDisplay.Type<AnalyzationRecipeDisplay> TYPE = new RecipeDisplay.Type<>(AnalyzationRecipeDisplay.MAP_CODEC, AnalyzationRecipeDisplay.STREAM_CODEC);

    @Override
    public Type<? extends RecipeDisplay> type() {
        return AnalyzationRecipeDisplay.TYPE;
    }
}
