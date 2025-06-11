package willatendo.fossilslegacy.server.pattern.pattern;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.entity.genetics.GeneticType;
import willatendo.fossilslegacy.server.pattern.FATextures;
import willatendo.fossilslegacy.server.pattern.information.PatternInformation;
import willatendo.fossilslegacy.server.pattern.information.type.BlankPatternInformation;
import willatendo.fossilslegacy.server.pattern.information.type.CompositePatternInformation;
import willatendo.fossilslegacy.server.pattern.information.type.PackagePatternInformation;
import willatendo.fossilslegacy.server.pattern.texture.Texture;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record Pattern(Component patternName, int geneColor, GeneticType geneticType, PatternInformation patternInformation) {
    public static final Codec<Pattern> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(ComponentSerialization.CODEC.fieldOf("pattern_name").forGetter(Pattern::patternName), Codec.INT.fieldOf("gene_color").forGetter(Pattern::geneColor), GeneticType.CODEC.fieldOf("genetic_type").forGetter(Pattern::geneticType), PatternInformation.CODEC.fieldOf("pattern_information").forGetter(Pattern::patternInformation)).apply(instance, Pattern::new));
    public static final Codec<Holder<Pattern>> CODEC = RegistryFileCodec.create(FARegistries.PATTERN, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<Pattern>> STREAM_CODEC = ByteBufCodecs.holderRegistry(FARegistries.PATTERN);

    public Pattern() {
        this(FAUtils.translation("pattern", "blank"), 0xFFFFFF, GeneticType.DOMINANT, new BlankPatternInformation());
    }

    public ResourceLocation getTexture(Registry<Texture> textureRegistry, ResourceKey<Texture> texture, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.patternInformation().getTextures(textureRegistry, textureName, requiredTextures).get(texture);
    }

    public ResourceLocation getTexture(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.getTexture(textureRegistry, FATextures.BASE, textureName, requiredTextures);
    }

    public ResourceLocation getBabyTexture(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.getTexture(textureRegistry, FATextures.BABY, textureName, requiredTextures);
    }

    public ResourceLocation getAggressiveTexture(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.getTexture(textureRegistry, FATextures.AGGRESSIVE, textureName, requiredTextures);
    }

    public ResourceLocation getAggressiveBabyTexture(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.getTexture(textureRegistry, FATextures.AGGRESSIVE_BABY, textureName, requiredTextures);
    }

    public ResourceLocation getKnockedOutTexture(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.getTexture(textureRegistry, FATextures.KNOCKED_OUT, textureName, requiredTextures);
    }

    public ResourceLocation getFurTexture(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.getTexture(textureRegistry, FATextures.FUR, textureName, requiredTextures);
    }

    public ResourceLocation getBabyFurTexture(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.getTexture(textureRegistry, FATextures.BABY_FUR, textureName, requiredTextures);
    }

    public ResourceLocation getShearedTexture(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.getTexture(textureRegistry, FATextures.SHEARED, textureName, requiredTextures);
    }

    public ResourceLocation getEyeTexture(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.getTexture(textureRegistry, FATextures.EYE_LAYER, textureName, requiredTextures);
    }

    public boolean hasTexture(Registry<Texture> textureRegistry, ResourceKey<Texture> texture, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.patternInformation().getTextures(textureRegistry, textureName, requiredTextures).containsKey(textureRegistry.getValue(texture));
    }

    public boolean hasBabyTexture(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.hasTexture(textureRegistry, FATextures.BABY, textureName, requiredTextures);
    }

    public boolean hasAggressiveBabyTexture(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.hasTexture(textureRegistry, FATextures.AGGRESSIVE_BABY, textureName, requiredTextures);
    }

    public boolean hasAggressiveTexture(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.hasTexture(textureRegistry, FATextures.AGGRESSIVE, textureName, requiredTextures);
    }

    public boolean hasKnockedOutTexture(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.hasTexture(textureRegistry, FATextures.KNOCKED_OUT, textureName, requiredTextures);
    }

    public boolean hasFurTexture(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.hasTexture(textureRegistry, FATextures.FUR, textureName, requiredTextures);
    }

    public boolean hasBabyFurTexture(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.hasTexture(textureRegistry, FATextures.BABY_FUR, textureName, requiredTextures);
    }

    public boolean hasShearedTexture(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.hasTexture(textureRegistry, FATextures.SHEARED, textureName, requiredTextures);
    }

    public boolean hasEyeTexture(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.hasTexture(textureRegistry, FATextures.EYE_LAYER, textureName, requiredTextures);
    }

    public static Pattern.Builder builder(ResourceLocation texture, Component name, int geneColor, GeneticType geneticType) {
        return new Pattern.Builder(name, geneColor, geneticType).withBaseTexture(texture);
    }

    public static Pattern.Builder builder(Component name, int geneColor, GeneticType geneticType) {
        return new Pattern.Builder(name, geneColor, geneticType);
    }

    public static final class Builder {
        private final Map<ResourceKey<Texture>, ResourceLocation> textures = new HashMap<>();
        private final Component patternName;
        private final int geneColor;
        private final GeneticType geneticType;

        private Builder(Component patternName, int geneColor, GeneticType geneticType) {
            this.patternName = patternName;
            this.geneColor = geneColor;
            this.geneticType = geneticType;
        }

        public Pattern.Builder withTexture(ResourceKey<Texture> texture, ResourceLocation baseLocation) {
            this.textures.put(texture, baseLocation);
            return this;
        }

        Pattern.Builder withBaseTexture(ResourceLocation baseTexture) {
            this.withTexture(FATextures.BASE, baseTexture);
            return this;
        }

        public Pattern.Builder withBabyTexture(ResourceLocation babyTexture) {
            this.textures.put(FATextures.BABY, babyTexture);
            return this;
        }

        public Pattern.Builder withFurTexture(ResourceLocation furTexture) {
            this.textures.put(FATextures.FUR, furTexture);
            return this;
        }

        public Pattern.Builder withBabyFurTexture(ResourceLocation babyFurTexture) {
            this.textures.put(FATextures.BABY_FUR, babyFurTexture);
            return this;
        }

        public Pattern.Builder withShearedTexture(ResourceLocation shearedTexture) {
            this.textures.put(FATextures.SHEARED, shearedTexture);
            return this;
        }

        public Pattern.Builder withAggressiveTexture(ResourceLocation aggressiveTexture) {
            this.textures.put(FATextures.AGGRESSIVE, aggressiveTexture);
            return this;
        }

        public Pattern.Builder withAggressiveTexture(ResourceLocation aggressiveTexture, ResourceLocation aggressiveBabyTexture) {
            this.textures.put(FATextures.AGGRESSIVE, aggressiveTexture);
            this.textures.put(FATextures.AGGRESSIVE_BABY, aggressiveBabyTexture);
            return this;
        }

        public Pattern.Builder withKnockedOutTexture(ResourceLocation knockedOutTexture) {
            this.textures.put(FATextures.KNOCKED_OUT, knockedOutTexture);
            return this;
        }

        public Pattern.Builder withEyeLayerTexture(ResourceLocation eyeLayerTexture) {
            this.textures.put(FATextures.EYE_LAYER, eyeLayerTexture);
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