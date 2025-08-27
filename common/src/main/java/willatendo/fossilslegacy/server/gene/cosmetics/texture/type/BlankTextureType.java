package willatendo.fossilslegacy.server.gene.cosmetics.texture.type;

import com.mojang.serialization.MapCodec;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.state.ChromosomedEntityRenderState;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.TextureInformation;

public enum BlankTextureType implements TextureType {
    INSTANCE;
    public static final MapCodec<BlankTextureType> CODEC = MapCodec.unit(BlankTextureType.INSTANCE);

    @Override
    public MapCodec<? extends TextureType> codec() {
        return CODEC;
    }

    @Override
    public TextureInformation apply(ChromosomedEntityRenderState chromosomedEntityRenderState, ResourceLocation path) {
        return TextureInformation.empty();
    }
}
