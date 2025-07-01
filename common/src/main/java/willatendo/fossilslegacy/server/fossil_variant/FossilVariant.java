package willatendo.fossilslegacy.server.fossil_variant;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.Item;
import willatendo.fossilslegacy.server.registry.FARegistries;

public record FossilVariant(int maxSize, boolean canArticulate, ResourceLocation texture, ResourceLocation model, int fossilCount, TagKey<Item> fossilIngredient, float scale, int yOffset, float boundingBoxWidth, float boundingBoxHeight, float boundingBoxGrowth, float baseScaleWidth, float baseScaleHeight, float sizeScale, float shadowSize, float shadowGrowth) {
    public static final Codec<FossilVariant> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(ExtraCodecs.POSITIVE_INT.fieldOf("max_size").forGetter(FossilVariant::maxSize), Codec.BOOL.fieldOf("can_articulate").forGetter(FossilVariant::canArticulate), ResourceLocation.CODEC.fieldOf("texture").forGetter(FossilVariant::texture), ResourceLocation.CODEC.fieldOf("model").forGetter(FossilVariant::model), Codec.intRange(1, 9).fieldOf("fossil_count").forGetter(FossilVariant::fossilCount), TagKey.codec(Registries.ITEM).fieldOf("fossil_ingredient").forGetter(FossilVariant::fossilIngredient), ExtraCodecs.POSITIVE_FLOAT.fieldOf("scale").forGetter(FossilVariant::scale), Codec.INT.fieldOf("y_offset").forGetter(FossilVariant::yOffset), ExtraCodecs.POSITIVE_FLOAT.fieldOf("bounding_box_width").forGetter(FossilVariant::boundingBoxWidth), ExtraCodecs.POSITIVE_FLOAT.fieldOf("bounding_box_height").forGetter(FossilVariant::boundingBoxHeight), ExtraCodecs.POSITIVE_FLOAT.fieldOf("bounding_box_growth").forGetter(FossilVariant::boundingBoxGrowth), ExtraCodecs.POSITIVE_FLOAT.fieldOf("base_scale_width").forGetter(FossilVariant::baseScaleWidth), ExtraCodecs.POSITIVE_FLOAT.fieldOf("base_scale_height").forGetter(FossilVariant::baseScaleHeight), ExtraCodecs.POSITIVE_FLOAT.fieldOf("size_scale").forGetter(FossilVariant::sizeScale), ExtraCodecs.POSITIVE_FLOAT.fieldOf("shadow_size").forGetter(FossilVariant::shadowSize), ExtraCodecs.POSITIVE_FLOAT.fieldOf("shadow_growth").forGetter(FossilVariant::shadowGrowth)).apply(instance, FossilVariant::new));
    public static final Codec<Holder<FossilVariant>> CODEC = RegistryFileCodec.create(FARegistries.FOSSIL_VARIANTS, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<FossilVariant>> STREAM_CODEC = ByteBufCodecs.holderRegistry(FARegistries.FOSSIL_VARIANTS);
    public static final MapCodec<Holder<FossilVariant>> VARIANT_MAP_CODEC = FossilVariant.CODEC.fieldOf("variant");
}
