package willatendo.fossilslegacy.server.pattern.texture;

import com.mojang.serialization.MapCodec;
import willatendo.fossilslegacy.server.pattern.texture.type.BasicTexture;
import willatendo.fossilslegacy.server.pattern.texture.type.EyeTexture;
import willatendo.fossilslegacy.server.pattern.texture.type.NoneTexture;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FATextureTypes {
    public static final SimpleRegistry<TextureType<?>> TEXTURE_TYPES = SimpleRegistry.create(FARegistries.TEXTURE_TYPE, FAUtils.ID);

    public static final SimpleHolder<TextureType<BasicTexture>> BASIC = FATextureTypes.register("blank", BasicTexture.CODEC);
    public static final SimpleHolder<TextureType<EyeTexture>> EYE = FATextureTypes.register("eye", EyeTexture.CODEC);
    public static final SimpleHolder<TextureType<NoneTexture>> NONE = FATextureTypes.register("none", NoneTexture.CODEC);

    private static <T extends Texture> SimpleHolder<TextureType<T>> register(String id, MapCodec<T> codec) {
        return TEXTURE_TYPES.register(id, () -> () -> codec);
    }
}
