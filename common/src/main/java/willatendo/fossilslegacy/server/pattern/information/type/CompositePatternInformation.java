package willatendo.fossilslegacy.server.pattern.information.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.pattern.FAPatternInformationTypes;
import willatendo.fossilslegacy.server.pattern.information.PatternInformation;
import willatendo.fossilslegacy.server.pattern.information.PatternInformationType;
import willatendo.fossilslegacy.server.pattern.information.TextureType;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record CompositePatternInformation(String texturePath, int layer) implements PatternInformation {
    public static final MapCodec<CompositePatternInformation> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.STRING.fieldOf("texture_path").forGetter(CompositePatternInformation::texturePath), Codec.intRange(0, 1).fieldOf("layer").forGetter(CompositePatternInformation::layer)).apply(instance, CompositePatternInformation::new));

    @Override
    public PatternInformationType<?> type() {
        return FAPatternInformationTypes.COMPOSITE.get();
    }

    @Override
    public Map<TextureType, ResourceLocation> getTextures(String textureName, List<TextureType> requiredTextures) {
        Map<TextureType, ResourceLocation> textures = new HashMap<>();
        for (TextureType textureType : requiredTextures) {
            String texture = requiredTextures.contains(TextureType.BABY) ? this.texturePath + "_" + textureType.getSuffix() : this.texturePath;
            textures.put(textureType, FAUtils.resource("textures/entity/" + textureName + "/layer" + this.layer + "/" + texture + ".png"));
        }
        return textures;
    }
}
