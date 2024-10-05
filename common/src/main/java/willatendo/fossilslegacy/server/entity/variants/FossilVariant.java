package willatendo.fossilslegacy.server.entity.variants;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;

public record FossilVariant(int maxSize, ResourceLocation texture, ResourceLocation model, float shadowSize, float boundingBoxWidth, float boundingBoxHeight, float baseScale, float sizeScale) {
    public static final Codec<FossilVariant> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(ExtraCodecs.POSITIVE_INT.fieldOf("max_size").forGetter(FossilVariant::maxSize), ResourceLocation.CODEC.fieldOf("texture").forGetter(FossilVariant::texture), ResourceLocation.CODEC.fieldOf("model").forGetter(FossilVariant::model), ExtraCodecs.POSITIVE_FLOAT.fieldOf("shadow_size").forGetter(FossilVariant::shadowSize), ExtraCodecs.POSITIVE_FLOAT.fieldOf("bounding_box_height").forGetter(FossilVariant::boundingBoxHeight), ExtraCodecs.POSITIVE_FLOAT.fieldOf("bounding_box_width").forGetter(FossilVariant::boundingBoxHeight), ExtraCodecs.POSITIVE_FLOAT.fieldOf("base_scale").forGetter(FossilVariant::baseScale), ExtraCodecs.POSITIVE_FLOAT.fieldOf("size_scale").forGetter(FossilVariant::sizeScale)).apply(instance, FossilVariant::new));
    public static final Codec<Holder<FossilVariant>> CODEC = RegistryFileCodec.create(FossilsLegacyRegistries.FOSSIL_VARIANTS, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<FossilVariant>> STREAM_CODEC = ByteBufCodecs.holderRegistry(FossilsLegacyRegistries.FOSSIL_VARIANTS);
}
