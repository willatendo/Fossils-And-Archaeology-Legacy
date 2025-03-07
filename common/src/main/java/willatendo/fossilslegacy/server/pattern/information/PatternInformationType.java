package willatendo.fossilslegacy.server.pattern.information;

import com.mojang.serialization.MapCodec;

public interface PatternInformationType<T extends PatternInformation> {
    MapCodec<T> codec();
}
