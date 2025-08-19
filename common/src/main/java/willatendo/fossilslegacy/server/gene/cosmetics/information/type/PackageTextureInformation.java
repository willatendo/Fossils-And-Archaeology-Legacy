package willatendo.fossilslegacy.server.gene.cosmetics.information.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.gene.cosmetics.FATextureInformationTypes;
import willatendo.fossilslegacy.server.gene.cosmetics.information.TextureInformation;
import willatendo.fossilslegacy.server.gene.cosmetics.information.TextureInformationType;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.List;
import java.util.Map;

public record PackageTextureInformation(Map<ResourceKey<Texture>, ResourceLocation> textures) implements TextureInformation {
    public static final MapCodec<PackageTextureInformation> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.unboundedMap(ResourceKey.codec(FARegistries.TEXTURE), ResourceLocation.CODEC).fieldOf("textures").forGetter(PackageTextureInformation::textures)).apply(instance, PackageTextureInformation::new));

    @Override
    public TextureInformationType<?> type() {
        return FATextureInformationTypes.PACKAGE.get();
    }

    @Override
    public Map<ResourceKey<Texture>, ResourceLocation> getTextures(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.textures;
    }
}
