package willatendo.fossilslegacy.server.pattern.texture.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import willatendo.fossilslegacy.server.pattern.texture.FATextureTypes;
import willatendo.fossilslegacy.server.pattern.texture.Texture;
import willatendo.fossilslegacy.server.pattern.texture.TextureType;

public record EyeTexture(String textureName) implements Texture {
    public static final MapCodec<EyeTexture> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.STRING.fieldOf("texture_name").forGetter(EyeTexture::textureName)).apply(instance, EyeTexture::new));

    @Override
    public String getTextureName(Registry<Texture> textureRegistry, String root, boolean containsBaby) {
        return root + "/eyes/" + this.textureName();
    }

    @Override
    public TextureType<?> type() {
        return FATextureTypes.EYE.get();
    }
}
