package willatendo.fossilslegacy.server.pattern.information.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.pattern.FAPatternInformationTypes;
import willatendo.fossilslegacy.server.pattern.information.PatternInformation;
import willatendo.fossilslegacy.server.pattern.information.PatternInformationType;
import willatendo.fossilslegacy.server.pattern.texture.Texture;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.List;
import java.util.Map;

public record PackagePatternInformation(Map<ResourceKey<Texture>, ResourceLocation> textures) implements PatternInformation {
    public static final MapCodec<PackagePatternInformation> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.unboundedMap(ResourceKey.codec(FARegistries.TEXTURE), ResourceLocation.CODEC).fieldOf("textures").forGetter(PackagePatternInformation::textures)).apply(instance, PackagePatternInformation::new));

    @Override
    public PatternInformationType<?> type() {
        return FAPatternInformationTypes.PACKAGE.get();
    }

    @Override
    public Map<ResourceKey<Texture>, ResourceLocation> getTextures(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.textures;
    }
}
