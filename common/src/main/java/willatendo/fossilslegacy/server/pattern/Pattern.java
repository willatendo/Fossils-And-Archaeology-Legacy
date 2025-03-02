package willatendo.fossilslegacy.server.pattern;

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
import willatendo.fossilslegacy.server.pattern_type.PatternType;
import willatendo.fossilslegacy.server.pattern_type.TextureType;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.HashMap;
import java.util.Map;

public record Pattern(Holder<PatternType> patternType, Map<TextureType, ResourceLocation> textures, Component patternName, int geneColor) {
    public static final Codec<Pattern> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(PatternType.CODEC.fieldOf("pattern_type").forGetter(Pattern::patternType), Codec.unboundedMap(TextureType.CODEC, ResourceLocation.CODEC).fieldOf("textures").forGetter(Pattern::textures), ComponentSerialization.CODEC.fieldOf("pattern_name").forGetter(Pattern::patternName), Codec.INT.fieldOf("gene_color").forGetter(Pattern::geneColor)).apply(instance, Pattern::new));
    public static final Codec<Holder<Pattern>> CODEC = RegistryFileCodec.create(FARegistries.PATTERN, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<Pattern>> STREAM_CODEC = ByteBufCodecs.holderRegistry(FARegistries.PATTERN);

    public ResourceLocation getTexture(TextureType textureType) {
        return this.textures.get(textureType);
    }

    public ResourceLocation getTexture() {
        return this.getTexture(TextureType.BASE);
    }

    public ResourceLocation getBabyTexture() {
        return this.getTexture(TextureType.BABY);
    }

    public ResourceLocation getAggressiveTexture() {
        return this.getTexture(TextureType.AGGRESSIVE);
    }

    public ResourceLocation getAggressiveBabyTexture() {
        return this.getTexture(TextureType.AGGRESSIVE_BABY);
    }

    public ResourceLocation getKnockedOutTexture() {
        return this.getTexture(TextureType.KNOCKED_OUT);
    }

    public ResourceLocation getFurTexture() {
        return this.getTexture(TextureType.FUR);
    }

    public ResourceLocation getBabyFurTexture() {
        return this.getTexture(TextureType.BABY_FUR);
    }

    public ResourceLocation getShearedTexture() {
        return this.getTexture(TextureType.SHEARED);
    }

    public ResourceLocation getEyeTexture() {
        return this.getTexture(TextureType.EYE);
    }

    public boolean hasTexture(TextureType textureType) {
        return this.textures.containsKey(textureType);
    }

    public boolean hasBabyTexture() {
        return this.hasTexture(TextureType.BABY);
    }

    public boolean hasAggressiveBabyTexture() {
        return this.hasTexture(TextureType.AGGRESSIVE_BABY);
    }

    public boolean hasAggressiveTexture() {
        return this.hasTexture(TextureType.AGGRESSIVE);
    }

    public boolean hasKnockedOutTexture() {
        return this.hasTexture(TextureType.KNOCKED_OUT);
    }

    public boolean hasFurTexture() {
        return this.hasTexture(TextureType.FUR);
    }

    public boolean hasBabyFurTexture() {
        return this.hasTexture(TextureType.BABY_FUR);
    }

    public boolean hasShearedTexture() {
        return this.hasTexture(TextureType.SHEARED);
    }

    public boolean hasEyeTexture() {
        return this.hasTexture(TextureType.EYE);
    }

    public static Pattern.Builder builder(ResourceLocation texture, Component name, int geneColor) {
        return new Pattern.Builder(texture, name, geneColor);
    }

    public static class Builder {
        private final Map<TextureType, ResourceLocation> textures = new HashMap<>();
        private final Component patternName;
        private final int geneColor;

        private Builder(ResourceLocation baseTexture, Component patternName, int geneColor) {
            this.textures.put(TextureType.BASE, baseTexture);
            this.patternName = patternName;
            this.geneColor = geneColor;
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

        public Pattern build(Holder<PatternType> patternType) {
            return new Pattern(patternType, this.textures, this.patternName, this.geneColor);
        }
    }
}