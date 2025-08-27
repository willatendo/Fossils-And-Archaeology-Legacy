package willatendo.fossilslegacy.server.gene.cosmetics.texture.type;

import com.mojang.serialization.MapCodec;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FATextureTypes {
    public static final SimpleRegistry<MapCodec<? extends TextureType>> TEXTURE_TYPES = SimpleRegistry.create(FARegistries.TEXTURE_TYPE, FAUtils.ID);

    static {
        TEXTURE_TYPES.register("blank", () -> BlankTextureType.CODEC);
        TEXTURE_TYPES.register("composite", () -> CompositeTextureType.CODEC);
        TEXTURE_TYPES.register("package", () -> PackageTextureType.CODEC);
    }
}
