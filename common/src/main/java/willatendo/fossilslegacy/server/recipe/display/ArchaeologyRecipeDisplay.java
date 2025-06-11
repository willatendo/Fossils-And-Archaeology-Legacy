package willatendo.fossilslegacy.server.recipe.display;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;

public record ArchaeologyRecipeDisplay(SlotDisplay ingredient, SlotDisplay fuel, SlotDisplay result, SlotDisplay craftingStation, int duration) implements RecipeDisplay {
    public static final MapCodec<ArchaeologyRecipeDisplay> MAP_CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(SlotDisplay.CODEC.fieldOf("ingredient").forGetter(ArchaeologyRecipeDisplay::ingredient), SlotDisplay.CODEC.fieldOf("fuel").forGetter(ArchaeologyRecipeDisplay::fuel), SlotDisplay.CODEC.fieldOf("result").forGetter(ArchaeologyRecipeDisplay::result), SlotDisplay.CODEC.fieldOf("crafting_station").forGetter(ArchaeologyRecipeDisplay::craftingStation), Codec.INT.fieldOf("duration").forGetter(ArchaeologyRecipeDisplay::duration)).apply(instance, ArchaeologyRecipeDisplay::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, ArchaeologyRecipeDisplay> STREAM_CODEC = StreamCodec.composite(SlotDisplay.STREAM_CODEC, ArchaeologyRecipeDisplay::ingredient, SlotDisplay.STREAM_CODEC, ArchaeologyRecipeDisplay::fuel, SlotDisplay.STREAM_CODEC, ArchaeologyRecipeDisplay::result, SlotDisplay.STREAM_CODEC, ArchaeologyRecipeDisplay::craftingStation, ByteBufCodecs.VAR_INT, ArchaeologyRecipeDisplay::duration, ArchaeologyRecipeDisplay::new);
    public static final Type<ArchaeologyRecipeDisplay> TYPE = new Type<>(ArchaeologyRecipeDisplay.MAP_CODEC, ArchaeologyRecipeDisplay.STREAM_CODEC);

    @Override
    public Type<? extends RecipeDisplay> type() {
        return ArchaeologyRecipeDisplay.TYPE;
    }
}
