package willatendo.fossilslegacy.server.hologram;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;

public record HologramType(ResourceLocation modelId, ResourceLocation texture) {
    public static final Codec<HologramType> CODEC = RecordCodecBuilder.create(instance -> instance.group(ResourceLocation.CODEC.fieldOf("model_id").forGetter(HologramType::modelId), ResourceLocation.CODEC.fieldOf("texture").forGetter(HologramType::texture)).apply(instance, HologramType::new));
}
