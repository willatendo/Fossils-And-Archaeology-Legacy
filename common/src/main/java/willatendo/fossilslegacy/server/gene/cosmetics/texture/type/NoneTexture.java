package willatendo.fossilslegacy.server.gene.cosmetics.texture.type;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.FATextureTypes;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.TextureType;

public final class NoneTexture implements Texture {
    private static final NoneTexture INSTANCE = new NoneTexture();
    public static final MapCodec<NoneTexture> CODEC = MapCodec.unit(() -> NoneTexture.INSTANCE);

    @Override
    public String getTextureName(Registry<Texture> textureRegistry, String root, boolean containsBaby) {
        return "";
    }

    @Override
    public TextureType<?> type() {
        return FATextureTypes.NONE.get();
    }
}
