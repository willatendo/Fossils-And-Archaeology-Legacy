package willatendo.fossilslegacy.server.pattern;

import com.mojang.serialization.MapCodec;
import willatendo.fossilslegacy.server.pattern.information.type.BlankPatternInformation;
import willatendo.fossilslegacy.server.pattern.information.type.CompositePatternInformation;
import willatendo.fossilslegacy.server.pattern.information.type.PackagePatternInformation;
import willatendo.fossilslegacy.server.pattern.information.PatternInformation;
import willatendo.fossilslegacy.server.pattern.information.PatternInformationType;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FAPatternInformationTypes {
    public static final SimpleRegistry<PatternInformationType<?>> PATTERN_INFORMATION_TYPES = SimpleRegistry.create(FARegistries.PATTERN_INFORMATION_TYPE, FAUtils.ID);

    public static final SimpleHolder<PatternInformationType<BlankPatternInformation>> BLANK = FAPatternInformationTypes.register("blank", BlankPatternInformation.CODEC);
    public static final SimpleHolder<PatternInformationType<CompositePatternInformation>> COMPOSITE = FAPatternInformationTypes.register("composite", CompositePatternInformation.CODEC);
    public static final SimpleHolder<PatternInformationType<PackagePatternInformation>> PACKAGE = FAPatternInformationTypes.register("package", PackagePatternInformation.CODEC);

    private static <T extends PatternInformation> SimpleHolder<PatternInformationType<T>> register(String id, MapCodec<T> codec) {
        return PATTERN_INFORMATION_TYPES.register(id, () -> () -> codec);
    }
}
