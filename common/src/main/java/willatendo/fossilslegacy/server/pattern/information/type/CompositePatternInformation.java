package willatendo.fossilslegacy.server.pattern.information.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.pattern.FAPatternInformationTypes;
import willatendo.fossilslegacy.server.pattern.FATextures;
import willatendo.fossilslegacy.server.pattern.information.PatternInformation;
import willatendo.fossilslegacy.server.pattern.information.PatternInformationType;
import willatendo.fossilslegacy.server.pattern.texture.Texture;
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
    public Map<ResourceKey<Texture>, ResourceLocation> getTextures(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        Map<ResourceKey<Texture>, ResourceLocation> textures = new HashMap<>();
        requiredTextures.forEach(textureResourceKey -> {
            String texture = textureRegistry.getValue(textureResourceKey).getTextureName(textureRegistry, this.texturePath, requiredTextures.contains(FATextures.BABY));
            textures.put(textureResourceKey, FAUtils.resource("textures/entity/" + textureName + "/layer" + this.layer + "/" + texture + ".png"));
        });
        return textures;
    }
}
