package willatendo.fossilslegacy.server.pattern_type.information;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import willatendo.fossilslegacy.server.pattern_type.FAPatternInformationTypes;
import willatendo.fossilslegacy.server.pattern_type.TextureType;

import java.util.List;

public record PackagePatternInformation(String texturePath, List<TextureType> requiredTextures) implements PatternInformation {
    public static final MapCodec<PackagePatternInformation> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.STRING.fieldOf("texture_path").forGetter(PackagePatternInformation::texturePath), Codec.list(TextureType.CODEC).fieldOf("required_textures").forGetter(PackagePatternInformation::requiredTextures)).apply(instance, PackagePatternInformation::new));

    @Override
    public PatternInformationType<?> type() {
        return FAPatternInformationTypes.PACKAGE.get();
    }
}
