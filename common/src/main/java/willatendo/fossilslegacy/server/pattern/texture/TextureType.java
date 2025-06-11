package willatendo.fossilslegacy.server.pattern.texture;

import com.mojang.serialization.MapCodec;

public interface TextureType<T extends Texture> {
    MapCodec<T> codec();
}
