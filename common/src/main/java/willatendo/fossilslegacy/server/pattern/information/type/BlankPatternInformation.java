package willatendo.fossilslegacy.server.pattern.information.type;

import com.mojang.serialization.MapCodec;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.pattern.FAPatternInformationTypes;
import willatendo.fossilslegacy.server.pattern.information.PatternInformation;
import willatendo.fossilslegacy.server.pattern.information.PatternInformationType;
import willatendo.fossilslegacy.server.pattern.information.TextureType;

import java.util.List;
import java.util.Map;

public final class BlankPatternInformation implements PatternInformation {
    private static final BlankPatternInformation INSTANCE = new BlankPatternInformation();
    public static final MapCodec<BlankPatternInformation> CODEC = MapCodec.unit(() -> BlankPatternInformation.INSTANCE);

    @Override
    public PatternInformationType<?> type() {
        return FAPatternInformationTypes.BLANK.get();
    }

    @Override
    public Map<TextureType, ResourceLocation> getTextures(String textureName, List<TextureType> requiredTextures) {
        return Map.of();
    }
}
