package willatendo.fossilslegacy.server.gene.cosmetics.texture.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.FATextureTypes;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.TextureAffixType;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.TextureType;

public record BasicTexture(String name, String affix, TextureAffixType textureAffixType) implements Texture {
    public static final MapCodec<BasicTexture> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.STRING.fieldOf("name").forGetter(BasicTexture::name), Codec.STRING.fieldOf("affix").forGetter(BasicTexture::affix), TextureAffixType.CODEC.fieldOf("affix_type").forGetter(BasicTexture::textureAffixType)).apply(instance, BasicTexture::new));

    public BasicTexture(String name, TextureAffixType textureAffixType) {
        this(name, name, textureAffixType);
    }

    @Override
    public String getTextureName(Registry<Texture> textureRegistry, String root, boolean containsBaby) {
        if (this.textureAffixType == TextureAffixType.SUFFIX) {
            return containsBaby ? root + "_" + this.affix : root;
        } else {
            return containsBaby ? this.affix + "_" + root : root;
        }
    }

    @Override
    public TextureType<?> type() {
        return FATextureTypes.BASIC.get();
    }
}
