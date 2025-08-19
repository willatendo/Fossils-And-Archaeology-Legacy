package willatendo.fossilslegacy.server.gene.cosmetics.information.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.gene.cosmetics.FATextureInformationTypes;
import willatendo.fossilslegacy.server.gene.cosmetics.FATextures;
import willatendo.fossilslegacy.server.gene.cosmetics.information.TextureInformation;
import willatendo.fossilslegacy.server.gene.cosmetics.information.TextureInformationType;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record CompositeTextureInformation(String texturePath, int layer) implements TextureInformation {
    public static final MapCodec<CompositeTextureInformation> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.STRING.fieldOf("texture_path").forGetter(CompositeTextureInformation::texturePath), Codec.intRange(0, 1).fieldOf("layer").forGetter(CompositeTextureInformation::layer)).apply(instance, CompositeTextureInformation::new));

    @Override
    public TextureInformationType<?> type() {
        return FATextureInformationTypes.COMPOSITE.get();
    }

    @Override
    public Map<ResourceKey<Texture>, ResourceLocation> getTextures(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        Map<ResourceKey<Texture>, ResourceLocation> textures = new HashMap<>();
        requiredTextures.forEach(textureResourceKey -> {
            String texture = textureRegistry.getValue(textureResourceKey).getTextureName(textureRegistry, this.texturePath, requiredTextures.contains(FATextures.BABY));
            textures.put(textureResourceKey, FAUtils.resource("textures/entity/" + textureName + "/layer" + this.layer + "/" + texture + ".png"));
        });
        return textures;
    }
}
