package willatendo.fossilslegacy.server.pattern;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.pattern.texture.Texture;
import willatendo.fossilslegacy.server.pattern.texture.TextureAffixType;
import willatendo.fossilslegacy.server.pattern.texture.type.BasicTexture;
import willatendo.fossilslegacy.server.pattern.texture.type.EyeTexture;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FATextures {
    public static final ResourceKey<Texture> ADULT_EYE = FATextures.create("adult_eye");
    public static final ResourceKey<Texture> BABY_EYE = FATextures.create("baby_eye");
    public static final ResourceKey<Texture> AGGRESSIVE_EYE = FATextures.create("aggressive_eye");
    public static final ResourceKey<Texture> CLOSED_EYE = FATextures.create("closed_eye");

    public static final ResourceKey<Texture> BASE = FATextures.create("base");
    public static final ResourceKey<Texture> BABY = FATextures.create("baby");
    public static final ResourceKey<Texture> FUR = FATextures.create("fur");
    public static final ResourceKey<Texture> BABY_FUR = FATextures.create("baby_fur");
    public static final ResourceKey<Texture> SHEARED = FATextures.create("sheared");
    public static final ResourceKey<Texture> AGGRESSIVE = FATextures.create("aggressive");
    public static final ResourceKey<Texture> AGGRESSIVE_BABY = FATextures.create("aggressive_baby");
    public static final ResourceKey<Texture> KNOCKED_OUT = FATextures.create("knocked_out_baby");
    public static final ResourceKey<Texture> EYE_LAYER = FATextures.create("eye_layer");

    private static ResourceKey<Texture> create(String name) {
        return ResourceKey.create(FARegistries.TEXTURE, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<Texture> bootstrapContext, ResourceKey<Texture> resourceKey, Texture texture) {
        bootstrapContext.register(resourceKey, texture);
    }

    public static void bootstrap(BootstrapContext<Texture> bootstrapContext) {
        FATextures.register(bootstrapContext, FATextures.ADULT_EYE, new EyeTexture("adult"));
        FATextures.register(bootstrapContext, FATextures.BABY_EYE, new EyeTexture("baby"));
        FATextures.register(bootstrapContext, FATextures.AGGRESSIVE_EYE, new EyeTexture("aggressive"));
        FATextures.register(bootstrapContext, FATextures.CLOSED_EYE, new EyeTexture("closed"));

        FATextures.register(bootstrapContext, FATextures.BASE, new BasicTexture("base", "adult", TextureAffixType.SUFFIX));
        FATextures.register(bootstrapContext, FATextures.BABY, new BasicTexture("baby", TextureAffixType.SUFFIX));
        FATextures.register(bootstrapContext, FATextures.FUR, new BasicTexture("fur", TextureAffixType.SUFFIX));
        FATextures.register(bootstrapContext, FATextures.BABY_FUR, new BasicTexture("baby_fur", TextureAffixType.SUFFIX));
        FATextures.register(bootstrapContext, FATextures.SHEARED, new BasicTexture("sheared", TextureAffixType.SUFFIX));
        FATextures.register(bootstrapContext, FATextures.AGGRESSIVE, new BasicTexture("aggressive", TextureAffixType.SUFFIX));
        FATextures.register(bootstrapContext, FATextures.AGGRESSIVE_BABY, new BasicTexture("aggressive_baby", TextureAffixType.SUFFIX));
        FATextures.register(bootstrapContext, FATextures.KNOCKED_OUT, new BasicTexture("knocked_out", TextureAffixType.SUFFIX));
        FATextures.register(bootstrapContext, FATextures.EYE_LAYER, new BasicTexture("eye", "eyes", TextureAffixType.SUFFIX));
    }
}
