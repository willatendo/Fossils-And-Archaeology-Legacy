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

public record CoatType(Component name, ResourceLocation model, ResourceLocation texture, Optional<ResourceLocation> babyTexture, float boundingBoxGrowth, float baseScale, float ageScale) {
    public static final Codec<CoatType> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(ComponentSerialization.CODEC.fieldOf("name").forGetter(CoatType::name), ResourceLocation.CODEC.fieldOf("model").forGetter(CoatType::model), ResourceLocation.CODEC.fieldOf("texture").forGetter(CoatType::texture), ResourceLocation.CODEC.optionalFieldOf("baby_texture").forGetter(CoatType::babyTexture), ExtraCodecs.POSITIVE_FLOAT.fieldOf("bounding_box_growth").forGetter(CoatType::boundingBoxGrowth), ExtraCodecs.POSITIVE_FLOAT.fieldOf("base_scale").forGetter(CoatType::baseScale), ExtraCodecs.POSITIVE_FLOAT.fieldOf("age_scale").forGetter(CoatType::ageScale)).apply(instance, CoatType::new));
    public static final Codec<Holder<CoatType>>  CODEC = RegistryFileCodec.create(FossilsLegacyRegistries.COAT_TYPES, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<CoatType>> STREAM_CODEC = ByteBufCodecs.holderRegistry(FossilsLegacyRegistries.COAT_TYPES);
}
