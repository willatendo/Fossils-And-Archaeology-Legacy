package willatendo.fossilslegacy.server.gene.cosmetics.texture.type;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.state.ChromosomedEntityRenderState;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.CompositeTextureRules;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.TextureInformation;

public record CompositeTextureType(CompositeTextureRules.RuleSource textureRules) implements TextureType {
    public static final MapCodec<CompositeTextureType> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(CompositeTextureRules.RuleSource.CODEC.fieldOf("texture_rules").forGetter(CompositeTextureType::textureRules)).apply(instance, CompositeTextureType::new));

    @Override
    public MapCodec<? extends TextureType> codec() {
        return CODEC;
    }

    @Override
    public TextureInformation apply(ChromosomedEntityRenderState chromosomedEntityRenderState, ResourceLocation path) {
        return this.textureRules.apply(chromosomedEntityRenderState).tryApply(chromosomedEntityRenderState, path);
    }
}
