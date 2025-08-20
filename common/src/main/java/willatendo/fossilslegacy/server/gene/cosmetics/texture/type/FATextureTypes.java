package willatendo.fossilslegacy.server.gene.cosmetics.texture.type;

import com.mojang.serialization.MapCodec;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FATextureTypes {
    public static final SimpleRegistry<MapCodec<? extends TextureType>> TEXTURE_TYPES = SimpleRegistry.create(FARegistries.TEXTURE_TYPE, FAUtils.ID);

    public static final SimpleHolder<MapCodec<? extends TextureType>> COMPOSITE = TEXTURE_TYPES.register("composite", () -> CompositeTextureType.CODEC);
    public static final SimpleHolder<MapCodec<? extends TextureType>> PACKAGE = TEXTURE_TYPES.register("package", () -> PackageTextureType.CODEC);
}
