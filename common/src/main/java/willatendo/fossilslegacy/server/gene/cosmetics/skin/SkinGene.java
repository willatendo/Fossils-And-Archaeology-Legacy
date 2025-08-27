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
import willatendo.fossilslegacy.server.gene.InheritedGene;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.PackageTextureRules;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.type.CompositeTextureType;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.type.PackageTextureType;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.type.TextureType;
import willatendo.fossilslegacy.server.gene.inheritance.InheritanceRules;
import willatendo.fossilslegacy.server.registry.FARegistries;

public record SkinGene(Component skinName, int geneColor, InheritanceRules.RuleSource inheritanceRules, TextureType textures) implements InheritedGene {
    public static final Codec<SkinGene> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(ComponentSerialization.CODEC.fieldOf("skin_name").forGetter(SkinGene::skinName), Codec.INT.fieldOf("gene_color").forGetter(SkinGene::geneColor), InheritanceRules.RuleSource.CODEC.fieldOf("inheritance_rule").forGetter(SkinGene::inheritanceRules), TextureType.CODEC.fieldOf("textures").forGetter(SkinGene::textures)).apply(instance, SkinGene::new));
    public static final Codec<Holder<SkinGene>> CODEC = RegistryFileCodec.create(FARegistries.SKIN_GENE, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<SkinGene>> STREAM_CODEC = ByteBufCodecs.holderRegistry(FARegistries.SKIN_GENE);

    public static SkinGene createComposite(Component skinName, int geneColor, InheritanceRules.RuleSource inheritanceRules, String textureName) {
        return new SkinGene(skinName, geneColor, inheritanceRules, new CompositeTextureType(0, textureName));
    }

    public static SkinGene createPackage(Component skinName, int geneColor, InheritanceRules.RuleSource inheritanceRules, PackageTextureRules.RuleSource packageTextureRules) {
        return new SkinGene(skinName, geneColor, inheritanceRules, new PackageTextureType(packageTextureRules));
    }
}
