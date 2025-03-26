package willatendo.fossilslegacy.server.decoration_plaque_type;

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
import willatendo.fossilslegacy.server.registry.FARegistries;

public record DecorationPlaqueType(int width, int height, ResourceLocation assetId) {
    public static final Codec<DecorationPlaqueType> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(ExtraCodecs.intRange(1, 16).fieldOf("width").forGetter(DecorationPlaqueType::width), ExtraCodecs.intRange(1, 16).fieldOf("height").forGetter(DecorationPlaqueType::height), ResourceLocation.CODEC.fieldOf("asset_id").forGetter(DecorationPlaqueType::assetId)).apply(instance, DecorationPlaqueType::new));
    public static final StreamCodec<ByteBuf, DecorationPlaqueType> DIRECT_STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, DecorationPlaqueType::width, ByteBufCodecs.VAR_INT, DecorationPlaqueType::height, ResourceLocation.STREAM_CODEC, DecorationPlaqueType::assetId, DecorationPlaqueType::new);
    public static final Codec<Holder<DecorationPlaqueType>> CODEC = RegistryFileCodec.create(FARegistries.DECORATION_PLAQUE_TYPE, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<DecorationPlaqueType>> STREAM_CODEC = ByteBufCodecs.holder(FARegistries.DECORATION_PLAQUE_TYPE, DIRECT_STREAM_CODEC);

    public int area() {
        return this.width() * this.height();
    }
}
