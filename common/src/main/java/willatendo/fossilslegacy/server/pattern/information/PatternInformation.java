package willatendo.fossilslegacy.server.pattern.information;

import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;

import java.util.List;
import java.util.Map;

public interface PatternInformation {
    Codec<PatternInformation> CODEC = FABuiltInRegistries.PATTERN_INFORMATION_TYPES.byNameCodec().dispatch(PatternInformation::type, PatternInformationType::codec);

    PatternInformationType<?> type();

    Map<TextureType, ResourceLocation> getTextures(String textureName, List<TextureType> requiredTextures);
}
