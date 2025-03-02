package willatendo.fossilslegacy.server.pattern_type.information;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import willatendo.fossilslegacy.server.pattern_type.FAPatternInformationTypes;
import willatendo.fossilslegacy.server.pattern_type.TextureType;

import java.util.List;
import java.util.Map;

public record CompositePatternInformation(String texturePath, int layer, List<TextureType> requiredTextures) implements PatternInformation {
    public static final MapCodec<CompositePatternInformation> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.STRING.fieldOf("texture_path").forGetter(CompositePatternInformation::texturePath), Codec.intRange(0, 1).fieldOf("layer").forGetter(CompositePatternInformation::layer), Codec.list(TextureType.CODEC).fieldOf("required_textures").forGetter(CompositePatternInformation::requiredTextures)).apply(instance, CompositePatternInformation::new));

    @Override
    public PatternInformationType<?> type() {
        return FAPatternInformationTypes.COMPOSITE.get();
    }
}
