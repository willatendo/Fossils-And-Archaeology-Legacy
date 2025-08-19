package willatendo.fossilslegacy.server.gene.cosmetics.information;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;

import java.util.List;
import java.util.Map;

public interface TextureInformation {
    Codec<TextureInformation> CODEC = FABuiltInRegistries.TEXTURE_INFORMATION_TYPES.byNameCodec().dispatch(TextureInformation::type, TextureInformationType::codec);

    TextureInformationType<?> type();

    Map<ResourceKey<Texture>, ResourceLocation> getTextures(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures);
}
