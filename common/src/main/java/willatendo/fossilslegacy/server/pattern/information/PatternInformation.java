package willatendo.fossilslegacy.server.pattern.information;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.pattern.texture.Texture;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;

import java.util.List;
import java.util.Map;

public interface PatternInformation {
    Codec<PatternInformation> CODEC = FABuiltInRegistries.PATTERN_INFORMATION_TYPES.byNameCodec().dispatch(PatternInformation::type, PatternInformationType::codec);

    PatternInformationType<?> type();

    Map<ResourceKey<Texture>, ResourceLocation> getTextures(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures);
}
