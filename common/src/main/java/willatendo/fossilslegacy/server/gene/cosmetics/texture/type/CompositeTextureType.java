package willatendo.fossilslegacy.server.gene.cosmetics.texture.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import willatendo.fossilslegacy.client.state.ChromosomedEntityRenderState;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.TextureInformation;

public record CompositeTextureType(int layer, String baseTextureName) implements TextureType {
    public static final MapCodec<CompositeTextureType> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.intRange(0, 1).fieldOf("layer").forGetter(CompositeTextureType::layer), Codec.STRING.fieldOf("base_texture_name").forGetter(CompositeTextureType::baseTextureName)).apply(instance, CompositeTextureType::new));

    @Override
    public MapCodec<? extends TextureType> codec() {
        return CODEC;
    }

    @Override
    public TextureInformation apply(ChromosomedEntityRenderState chromosomedEntityRenderState, ResourceLocation texturePath) {
        return (this.layer == 0 ? chromosomedEntityRenderState.skinCompositeTextureRuleSource : chromosomedEntityRenderState.patternCompositeTextureRuleSource).value().apply(chromosomedEntityRenderState).tryApply(chromosomedEntityRenderState, texturePath, this.baseTextureName);
    }
}
