package willatendo.fossilslegacy.server.gene.cosmetics.information;

import com.mojang.serialization.MapCodec;

public interface TextureInformationType<T extends TextureInformation> {
    MapCodec<T> codec();
}
