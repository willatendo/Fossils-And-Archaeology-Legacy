package willatendo.fossilslegacy.server.pattern.information.type;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.pattern.FAPatternInformationTypes;
import willatendo.fossilslegacy.server.pattern.information.PatternInformation;
import willatendo.fossilslegacy.server.pattern.information.PatternInformationType;
import willatendo.fossilslegacy.server.pattern.texture.Texture;

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
    public Map<ResourceKey<Texture>, ResourceLocation> getTextures(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return Map.of();
    }
}
