package willatendo.fossilslegacy.server.pattern.pattern;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.entity.genetics.GeneticType;
import willatendo.fossilslegacy.server.pattern.information.PatternInformation;
import willatendo.fossilslegacy.server.pattern.information.TextureType;
import willatendo.fossilslegacy.server.pattern.information.type.BlankPatternInformation;
import willatendo.fossilslegacy.server.pattern.information.type.CompositePatternInformation;
import willatendo.fossilslegacy.server.pattern.information.type.PackagePatternInformation;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record Pattern(Component patternName, int geneColor, GeneticType geneticType, PatternInformation patternInformation) {
    public static final Codec<Pattern> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(ComponentSerialization.CODEC.fieldOf("pattern_name").forGetter(Pattern::patternName), Codec.INT.fieldOf("gene_color").forGetter(Pattern::geneColor), GeneticType.CODEC.fieldOf("genetic_type").forGetter(Pattern::geneticType), PatternInformation.CODEC.fieldOf("pattern_information").forGetter(Pattern::patternInformation)).apply(instance, Pattern::new));
    public static final Codec<Holder<Pattern>> CODEC = RegistryFileCodec.create(FARegistries.PATTERN, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<Pattern>> STREAM_CODEC = ByteBufCodecs.holderRegistry(FARegistries.PATTERN);

    public Pattern() {
        this(Component.empty(), 0x000000, GeneticType.DOMINANT, new BlankPatternInformation());
    }

    public ResourceLocation getTexture(TextureType textureType, String textureName, List<TextureType> requiredTextures) {
        return this.patternInformation().getTextures(textureName, requiredTextures).get(textureType);
    }

    public ResourceLocation getTexture(String textureName, List<TextureType> requiredTextures) {
        return this.getTexture(TextureType.BASE, textureName, requiredTextures);
    }

    public ResourceLocation getBabyTexture(String textureName, List<TextureType> requiredTextures) {
        return this.getTexture(TextureType.BABY, textureName, requiredTextures);
    }

    public ResourceLocation getAggressiveTexture(String textureName, List<TextureType> requiredTextures) {
        return this.getTexture(TextureType.AGGRESSIVE, textureName, requiredTextures);
    }

    public ResourceLocation getAggressiveBabyTexture(String textureName, List<TextureType> requiredTextures) {
        return this.getTexture(TextureType.AGGRESSIVE_BABY, textureName, requiredTextures);
    }

    public ResourceLocation getKnockedOutTexture(String textureName, List<TextureType> requiredTextures) {
        return this.getTexture(TextureType.KNOCKED_OUT, textureName, requiredTextures);
    }

    public ResourceLocation getFurTexture(String textureName, List<TextureType> requiredTextures) {
        return this.getTexture(TextureType.FUR, textureName, requiredTextures);
    }

    public ResourceLocation getBabyFurTexture(String textureName, List<TextureType> requiredTextures) {
        return this.getTexture(TextureType.BABY_FUR, textureName, requiredTextures);
    }

    public ResourceLocation getShearedTexture(String textureName, List<TextureType> requiredTextures) {
        return this.getTexture(TextureType.SHEARED, textureName, requiredTextures);
    }

    public ResourceLocation getEyeTexture(String textureName, List<TextureType> requiredTextures) {
        return this.getTexture(TextureType.EYE, textureName, requiredTextures);
    }

    public boolean hasTexture(TextureType textureType, String textureName, List<TextureType> requiredTextures) {
        return this.patternInformation().getTextures(textureName, requiredTextures).containsKey(textureType);
    }

    public boolean hasBabyTexture(String textureName, List<TextureType> requiredTextures) {
        return this.hasTexture(TextureType.BABY, textureName, requiredTextures);
    }

    public boolean hasAggressiveBabyTexture(String textureName, List<TextureType> requiredTextures) {
        return this.hasTexture(TextureType.AGGRESSIVE_BABY, textureName, requiredTextures);
    }

    public boolean hasAggressiveTexture(String textureName, List<TextureType> requiredTextures) {
        return this.hasTexture(TextureType.AGGRESSIVE, textureName, requiredTextures);
    }

    public boolean hasKnockedOutTexture(String textureName, List<TextureType> requiredTextures) {
        return this.hasTexture(TextureType.KNOCKED_OUT, textureName, requiredTextures);
    }

    public boolean hasFurTexture(String textureName, List<TextureType> requiredTextures) {
        return this.hasTexture(TextureType.FUR, textureName, requiredTextures);
    }

    public boolean hasBabyFurTexture(String textureName, List<TextureType> requiredTextures) {
        return this.hasTexture(TextureType.BABY_FUR, textureName, requiredTextures);
    }

    public boolean hasShearedTexture(String textureName, List<TextureType> requiredTextures) {
        return this.hasTexture(TextureType.SHEARED, textureName, requiredTextures);
    }

    public boolean hasEyeTexture(String textureName, List<TextureType> requiredTextures) {
        return this.hasTexture(TextureType.EYE, textureName, requiredTextures);
    }

    public static Pattern.Builder builder(ResourceLocation texture, Component name, int geneColor, GeneticType geneticType) {
        return new Pattern.Builder(name, geneColor, geneticType).withBaseTexture(texture);
    }

    public static Pattern.Builder builder(Component name, int geneColor, GeneticType geneticType) {
        return new Pattern.Builder(name, geneColor, geneticType);
    }

    public static final class Builder {
        private final Map<TextureType, ResourceLocation> textures = new HashMap<>();
        private final Component patternName;
        private final int geneColor;
        private final GeneticType geneticType;

        private Builder(Component patternName, int geneColor, GeneticType geneticType) {
            this.patternName = patternName;
            this.geneColor = geneColor;
            this.geneticType = geneticType;
        }

        Pattern.Builder withBaseTexture(ResourceLocation baseTexture) {
            this.textures.put(TextureType.BASE, baseTexture);
            return this;
        }

        public Pattern.Builder withBabyTexture(ResourceLocation babyTexture) {
            this.textures.put(TextureType.BABY, babyTexture);
            return this;
        }

        public Pattern.Builder withFurTexture(ResourceLocation furTexture) {
            this.textures.put(TextureType.FUR, furTexture);
            return this;
        }

        public Pattern.Builder withBabyFurTexture(ResourceLocation babyFurTexture) {
            this.textures.put(TextureType.BABY_FUR, babyFurTexture);
            return this;
        }

        public Pattern.Builder withShearedTexture(ResourceLocation shearedTexture) {
            this.textures.put(TextureType.SHEARED, shearedTexture);
            return this;
        }

        public Pattern.Builder withAggressiveTexture(ResourceLocation aggressiveTexture) {
            this.textures.put(TextureType.AGGRESSIVE, aggressiveTexture);
            return this;
        }

        public Pattern.Builder withAggressiveTexture(ResourceLocation aggressiveTexture, ResourceLocation aggressiveBabyTexture) {
            this.textures.put(TextureType.AGGRESSIVE, aggressiveTexture);
            this.textures.put(TextureType.AGGRESSIVE_BABY, aggressiveBabyTexture);
            return this;
        }

        public Pattern.Builder withKnockedOutTexture(ResourceLocation knockedOutTexture) {
            this.textures.put(TextureType.KNOCKED_OUT, knockedOutTexture);
            return this;
        }

        public Pattern.Builder withEyeLayerTexture(ResourceLocation eyeLayerTexture) {
            this.textures.put(TextureType.EYE, eyeLayerTexture);
            return this;
        }

        public Pattern buildComposite(String texturePath, int layer) {
            return new Pattern(this.patternName, this.geneColor, this.geneticType, new CompositePatternInformation(texturePath, layer));
        }

        public Pattern buildPackage() {
            return new Pattern(this.patternName, this.geneColor, this.geneticType, new PackagePatternInformation(this.textures));
        }
    }
}