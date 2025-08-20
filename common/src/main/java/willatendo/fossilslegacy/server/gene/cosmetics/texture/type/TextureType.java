package willatendo.fossilslegacy.server.gene.cosmetics.texture.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.state.ChromosomedEntityRenderState;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.TextureInformation;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;

import java.util.function.Function;

public interface TextureType {
    Codec<TextureType> CODEC = FABuiltInRegistries.TEXTURE_TYPE.byNameCodec().dispatch(TextureType::codec, Function.identity());

    MapCodec<? extends TextureType> codec();

    TextureInformation apply(ChromosomedEntityRenderState chromosomedEntityRenderState, ResourceLocation path);
}
