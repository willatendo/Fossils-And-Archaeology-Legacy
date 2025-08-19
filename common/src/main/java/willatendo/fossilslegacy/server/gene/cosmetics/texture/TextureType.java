package willatendo.fossilslegacy.server.gene.cosmetics.texture;

import com.mojang.serialization.MapCodec;

public interface TextureType<T extends Texture> {
    MapCodec<T> codec();
}
