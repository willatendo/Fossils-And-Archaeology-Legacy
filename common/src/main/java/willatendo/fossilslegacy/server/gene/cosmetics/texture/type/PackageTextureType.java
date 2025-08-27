package willatendo.fossilslegacy.server.gene.cosmetics.texture.type;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.state.ChromosomedEntityRenderState;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.PackageTextureRules;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.TextureInformation;

public record PackageTextureType(PackageTextureRules.RuleSource textureRules) implements TextureType {
    public static final MapCodec<PackageTextureType> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(PackageTextureRules.RuleSource.CODEC.fieldOf("texture_rules").forGetter(PackageTextureType::textureRules)).apply(instance, PackageTextureType::new));

    @Override
    public MapCodec<? extends TextureType> codec() {
        return CODEC;
    }

    @Override
    public TextureInformation apply(ChromosomedEntityRenderState chromosomedEntityRenderState, ResourceLocation texturePath) {
        return this.textureRules.apply(chromosomedEntityRenderState).tryApply(chromosomedEntityRenderState);
    }
}
