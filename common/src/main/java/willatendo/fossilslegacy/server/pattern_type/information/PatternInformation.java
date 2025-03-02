package willatendo.fossilslegacy.server.pattern_type.information;

import com.mojang.serialization.Codec;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;

public interface PatternInformation {
    Codec<PatternInformation> CODEC = FABuiltInRegistries.PATTERN_INFORMATION_TYPES.byNameCodec().dispatch(PatternInformation::type, PatternInformationType::codec);

    PatternInformationType<?> type();
}
