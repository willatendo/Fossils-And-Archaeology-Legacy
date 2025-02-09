package willatendo.fossilslegacy.server.recipe.display;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;

public record CultivationRecipeDisplay(SlotDisplay ingredient, SlotDisplay fuel, SlotDisplay result, SlotDisplay craftingStation, int duration) implements RecipeDisplay {
    public static final MapCodec<CultivationRecipeDisplay> MAP_CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(SlotDisplay.CODEC.fieldOf("ingredient").forGetter(CultivationRecipeDisplay::ingredient), SlotDisplay.CODEC.fieldOf("fuel").forGetter(CultivationRecipeDisplay::fuel), SlotDisplay.CODEC.fieldOf("result").forGetter(CultivationRecipeDisplay::result), SlotDisplay.CODEC.fieldOf("crafting_station").forGetter(CultivationRecipeDisplay::craftingStation), Codec.INT.fieldOf("duration").forGetter(CultivationRecipeDisplay::duration)).apply(instance, CultivationRecipeDisplay::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, CultivationRecipeDisplay> STREAM_CODEC = StreamCodec.composite(SlotDisplay.STREAM_CODEC, CultivationRecipeDisplay::ingredient, SlotDisplay.STREAM_CODEC, CultivationRecipeDisplay::fuel, SlotDisplay.STREAM_CODEC, CultivationRecipeDisplay::result, SlotDisplay.STREAM_CODEC, CultivationRecipeDisplay::craftingStation, ByteBufCodecs.VAR_INT, CultivationRecipeDisplay::duration, CultivationRecipeDisplay::new);
    public static final Type<CultivationRecipeDisplay> TYPE = new Type<>(CultivationRecipeDisplay.MAP_CODEC, CultivationRecipeDisplay.STREAM_CODEC);

    @Override
    public Type<? extends RecipeDisplay> type() {
        return CultivationRecipeDisplay.TYPE;
    }
}
