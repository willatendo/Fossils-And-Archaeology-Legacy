package willatendo.fossilslegacy.server.entity.variants;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;

public record StoneTabletVariant(int width, int height, ResourceLocation assetId) {
    public static final Codec<StoneTabletVariant> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(ExtraCodecs.intRange(1, 16).fieldOf("width").forGetter(StoneTabletVariant::width), ExtraCodecs.intRange(1, 16).fieldOf("height").forGetter(StoneTabletVariant::height), ResourceLocation.CODEC.fieldOf("asset_id").forGetter(StoneTabletVariant::assetId)).apply(instance, StoneTabletVariant::new));
    public static final StreamCodec<ByteBuf, StoneTabletVariant> DIRECT_STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, StoneTabletVariant::width, ByteBufCodecs.VAR_INT, StoneTabletVariant::height, ResourceLocation.STREAM_CODEC, StoneTabletVariant::assetId, StoneTabletVariant::new);
    public static final Codec<Holder<StoneTabletVariant>> CODEC = RegistryFileCodec.create(FossilsLegacyRegistries.STONE_TABLET_VARIANTS, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<StoneTabletVariant>> STREAM_CODEC = ByteBufCodecs.holder(FossilsLegacyRegistries.STONE_TABLET_VARIANTS, DIRECT_STREAM_CODEC);

    public int area() {
        return this.width() * this.height();
    }
}
