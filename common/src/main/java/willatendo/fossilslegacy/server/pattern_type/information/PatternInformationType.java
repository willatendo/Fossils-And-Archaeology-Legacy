package willatendo.fossilslegacy.server.pattern_type.information;

import com.mojang.serialization.MapCodec;

public interface PatternInformationType<T extends PatternInformation> {
    MapCodec<T> codec();
}
