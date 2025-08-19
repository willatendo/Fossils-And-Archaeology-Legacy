package willatendo.fossilslegacy.server.gene.cosmetics.skin;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
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
import willatendo.fossilslegacy.server.gene.cosmetics.information.type.CompositeTextureInformation;
import willatendo.fossilslegacy.server.gene.cosmetics.information.type.PackageTextureInformation;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;
import willatendo.fossilslegacy.server.gene.inheritance.InheritanceRules;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.HashMap;
import java.util.Map;

public record SkinGene(Component skinName, int geneColor, InheritanceRules.RuleSource inheritanceRule, TextureInformation textureInformation) implements InheritedGene {
    public static final Codec<SkinGene> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(ComponentSerialization.CODEC.fieldOf("skin_name").forGetter(SkinGene::skinName), Codec.INT.fieldOf("gene_color").forGetter(SkinGene::geneColor), InheritanceRules.RuleSource.CODEC.fieldOf("inheritance_rule").forGetter(SkinGene::inheritanceRule), TextureInformation.CODEC.fieldOf("texture_information").forGetter(SkinGene::textureInformation)).apply(instance, SkinGene::new));
    public static final Codec<Holder<SkinGene>> CODEC = RegistryFileCodec.create(FARegistries.SKIN_GENE, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<SkinGene>> STREAM_CODEC = ByteBufCodecs.holderRegistry(FARegistries.SKIN_GENE);

    public static SkinGene.Builder builder(ResourceLocation texture, Component name, int geneColor) {
        return new SkinGene.Builder(name, geneColor).withBaseTexture(texture);
    }

    public static SkinGene.Builder builder(Component name, int geneColor) {
        return new SkinGene.Builder(name, geneColor);
    }

    public static final class Builder {
        private final Map<ResourceKey<Texture>, ResourceLocation> textures = new HashMap<>();
        private final Component patternName;
        private final int geneColor;

        private Builder(Component patternName, int geneColor) {
            this.patternName = patternName;
            this.geneColor = geneColor;
        }

        public SkinGene.Builder withTexture(ResourceKey<Texture> texture, ResourceLocation baseLocation) {
            this.textures.put(texture, baseLocation);
            return this;
        }

        SkinGene.Builder withBaseTexture(ResourceLocation baseTexture) {
            this.withTexture(FATextures.BASE, baseTexture);
            return this;
        }

        public SkinGene.Builder withBabyTexture(ResourceLocation babyTexture) {
            this.textures.put(FATextures.BABY, babyTexture);
            return this;
        }

        public SkinGene.Builder withFurTexture(ResourceLocation furTexture) {
            this.textures.put(FATextures.FUR, furTexture);
            return this;
        }

        public SkinGene.Builder withBabyFurTexture(ResourceLocation babyFurTexture) {
            this.textures.put(FATextures.BABY_FUR, babyFurTexture);
            return this;
        }

        public SkinGene.Builder withShearedTexture(ResourceLocation shearedTexture) {
            this.textures.put(FATextures.SHEARED, shearedTexture);
            return this;
        }

        public SkinGene.Builder withAggressiveTexture(ResourceLocation aggressiveTexture) {
            this.textures.put(FATextures.AGGRESSIVE, aggressiveTexture);
            return this;
        }

        public SkinGene.Builder withAggressiveTexture(ResourceLocation aggressiveTexture, ResourceLocation aggressiveBabyTexture) {
            this.textures.put(FATextures.AGGRESSIVE, aggressiveTexture);
            this.textures.put(FATextures.AGGRESSIVE_BABY, aggressiveBabyTexture);
            return this;
        }

        public SkinGene.Builder withKnockedOutTexture(ResourceLocation knockedOutTexture) {
            this.textures.put(FATextures.KNOCKED_OUT, knockedOutTexture);
            return this;
        }

        public SkinGene.Builder withEyeLayerTexture(ResourceLocation eyeLayerTexture) {
            this.textures.put(FATextures.EYE_LAYER, eyeLayerTexture);
            return this;
        }

        public SkinGene buildComposite(String texturePath) {
            return new SkinGene(this.patternName, this.geneColor, InheritanceRules.always(), new CompositeTextureInformation(texturePath, 0));
        }

        public SkinGene buildPackage() {
            return new SkinGene(this.patternName, this.geneColor, InheritanceRules.always(), new PackageTextureInformation(this.textures));
        }
    }
}
