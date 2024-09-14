package willatendo.fossilslegacy.server.entity.genetics;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;

import java.util.Optional;

public record CoatType(Component name, Component pattern, int color, ResourceLocation model, ResourceLocation texture, Optional<ResourceLocation> babyTexture, float boundingBoxWidth, float boundingBoxHeight, float boundingBoxGrowth, float baseScaleWidth, float baseScaleHeight, float ageScale) {
    public static final Codec<CoatType> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(ComponentSerialization.CODEC.fieldOf("name").forGetter(CoatType::name),ComponentSerialization.CODEC.fieldOf("pattern").forGetter(CoatType::pattern), ExtraCodecs.POSITIVE_INT.fieldOf("color").forGetter(CoatType::color), ResourceLocation.CODEC.fieldOf("model").forGetter(CoatType::model), ResourceLocation.CODEC.fieldOf("texture").forGetter(CoatType::texture), ResourceLocation.CODEC.optionalFieldOf("baby_texture").forGetter(CoatType::babyTexture), ExtraCodecs.POSITIVE_FLOAT.fieldOf("bounding_box_width").forGetter(CoatType::boundingBoxWidth), ExtraCodecs.POSITIVE_FLOAT.fieldOf("bounding_box_height").forGetter(CoatType::boundingBoxWidth), ExtraCodecs.POSITIVE_FLOAT.fieldOf("bounding_box_growth").forGetter(CoatType::boundingBoxGrowth), ExtraCodecs.POSITIVE_FLOAT.fieldOf("base_scale_width").forGetter(CoatType::baseScaleWidth), ExtraCodecs.POSITIVE_FLOAT.fieldOf("base_scale_height").forGetter(CoatType::baseScaleHeight), ExtraCodecs.POSITIVE_FLOAT.fieldOf("age_scale").forGetter(CoatType::ageScale)).apply(instance, CoatType::new));
    public static final Codec<Holder<CoatType>> CODEC = RegistryFileCodec.create(FossilsLegacyRegistries.COAT_TYPES, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<CoatType>> STREAM_CODEC = ByteBufCodecs.holderRegistry(FossilsLegacyRegistries.COAT_TYPES);
}
