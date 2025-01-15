package willatendo.fossilslegacy.server.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;

public record AnalyzerResult(ItemStack output, int weight) {
    public static final Codec<AnalyzerResult> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(ItemStack.STRICT_SINGLE_ITEM_CODEC.fieldOf("output").forGetter(AnalyzerResult::output), ExtraCodecs.NON_NEGATIVE_INT.fieldOf("weight").forGetter(AnalyzerResult::weight)).apply(instance, AnalyzerResult::new));
}
