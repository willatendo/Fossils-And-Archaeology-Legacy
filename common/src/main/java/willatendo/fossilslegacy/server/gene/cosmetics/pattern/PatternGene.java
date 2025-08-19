package willatendo.fossilslegacy.server.gene.cosmetics.pattern;

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
import willatendo.fossilslegacy.server.gene.InheritedGene;
import willatendo.fossilslegacy.server.gene.cosmetics.FATextures;
import willatendo.fossilslegacy.server.gene.cosmetics.information.TextureInformation;
import willatendo.fossilslegacy.server.gene.cosmetics.information.type.BlankTextureInformation;
import willatendo.fossilslegacy.server.gene.cosmetics.information.type.CompositeTextureInformation;
import willatendo.fossilslegacy.server.gene.cosmetics.information.type.PackageTextureInformation;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;
import willatendo.fossilslegacy.server.gene.inheritance.InheritanceRules;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record PatternGene(Component patternName, int geneColor, InheritanceRules.RuleSource inheritanceRule, TextureInformation textureInformation) implements InheritedGene {
    public static final Codec<PatternGene> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(ComponentSerialization.CODEC.fieldOf("pattern_name").forGetter(PatternGene::patternName), Codec.INT.fieldOf("gene_color").forGetter(PatternGene::geneColor), InheritanceRules.RuleSource.CODEC.fieldOf("inheritance_rule").forGetter(PatternGene::inheritanceRule), TextureInformation.CODEC.fieldOf("texture_information").forGetter(PatternGene::textureInformation)).apply(instance, PatternGene::new));
    public static final Codec<Holder<PatternGene>> CODEC = RegistryFileCodec.create(FARegistries.PATTERN_GENE, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<PatternGene>> STREAM_CODEC = ByteBufCodecs.holderRegistry(FARegistries.PATTERN_GENE);

    public PatternGene() {
        this(FAUtils.translation("patternGenes", "blank"), 0xFFFFFF, InheritanceRules.always(), new BlankTextureInformation());
    }

    public ResourceLocation getTexture(Registry<Texture> textureRegistry, ResourceKey<Texture> texture, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return this.textureInformation().getTextures(textureRegistry, textureName, requiredTextures).get(texture);
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
        return this.textureInformation().getTextures(textureRegistry, textureName, requiredTextures).containsKey(textureRegistry.getValue(texture));
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

    public static PatternGene.Builder builder(ResourceLocation texture, Component name, int geneColor) {
        return new PatternGene.Builder(name, geneColor).withBaseTexture(texture);
    }

    public static PatternGene.Builder builder(Component name, int geneColor) {
        return new PatternGene.Builder(name, geneColor);
    }

    public static final class Builder {
        private final Map<ResourceKey<Texture>, ResourceLocation> textures = new HashMap<>();
        private final Component patternName;
        private final int geneColor;

        private Builder(Component patternName, int geneColor) {
            this.patternName = patternName;
            this.geneColor = geneColor;
        }

        public PatternGene.Builder withTexture(ResourceKey<Texture> texture, ResourceLocation baseLocation) {
            this.textures.put(texture, baseLocation);
            return this;
        }

        PatternGene.Builder withBaseTexture(ResourceLocation baseTexture) {
            this.withTexture(FATextures.BASE, baseTexture);
            return this;
        }

        public PatternGene.Builder withBabyTexture(ResourceLocation babyTexture) {
            this.textures.put(FATextures.BABY, babyTexture);
            return this;
        }

        public PatternGene.Builder withFurTexture(ResourceLocation furTexture) {
            this.textures.put(FATextures.FUR, furTexture);
            return this;
        }

        public PatternGene.Builder withBabyFurTexture(ResourceLocation babyFurTexture) {
            this.textures.put(FATextures.BABY_FUR, babyFurTexture);
            return this;
        }

        public PatternGene.Builder withShearedTexture(ResourceLocation shearedTexture) {
            this.textures.put(FATextures.SHEARED, shearedTexture);
            return this;
        }

        public PatternGene.Builder withAggressiveTexture(ResourceLocation aggressiveTexture) {
            this.textures.put(FATextures.AGGRESSIVE, aggressiveTexture);
            return this;
        }

        public PatternGene.Builder withAggressiveTexture(ResourceLocation aggressiveTexture, ResourceLocation aggressiveBabyTexture) {
            this.textures.put(FATextures.AGGRESSIVE, aggressiveTexture);
            this.textures.put(FATextures.AGGRESSIVE_BABY, aggressiveBabyTexture);
            return this;
        }

        public PatternGene.Builder withKnockedOutTexture(ResourceLocation knockedOutTexture) {
            this.textures.put(FATextures.KNOCKED_OUT, knockedOutTexture);
            return this;
        }

        public PatternGene.Builder withEyeLayerTexture(ResourceLocation eyeLayerTexture) {
            this.textures.put(FATextures.EYE_LAYER, eyeLayerTexture);
            return this;
        }

        public PatternGene buildComposite(String texturePath) {
            return new PatternGene(this.patternName, this.geneColor, InheritanceRules.always(), new CompositeTextureInformation(texturePath, 1));
        }

        public PatternGene buildPackage() {
            return new PatternGene(this.patternName, this.geneColor, InheritanceRules.always(), new PackageTextureInformation(this.textures));
        }
    }
}