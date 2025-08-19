package willatendo.fossilslegacy.server.gene.cosmetics.texture;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;

public interface Texture {
    Codec<Texture> CODEC = FABuiltInRegistries.TEXTURE_TYPES.byNameCodec().dispatch(Texture::type, TextureType::codec);

    String getTextureName(Registry<Texture> textureRegistry, String root, boolean containsBaby);

    TextureType<?> type();
}
