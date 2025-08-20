package willatendo.fossilslegacy.server.gene.cosmetics.pattern;

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
import willatendo.fossilslegacy.server.gene.cosmetics.texture.CompositeTextureRules;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.type.CompositeTextureType;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.type.TextureType;
import willatendo.fossilslegacy.server.gene.inheritance.InheritanceRules;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

public record PatternGene(Component patternName, int geneColor, InheritanceRules.RuleSource inheritanceRules, TextureType textures) implements InheritedGene {
    public static final PatternGene BLANK = new PatternGene();
    public static final Codec<PatternGene> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(ComponentSerialization.CODEC.fieldOf("pattern_name").forGetter(PatternGene::patternName), Codec.INT.fieldOf("gene_color").forGetter(PatternGene::geneColor), InheritanceRules.RuleSource.CODEC.fieldOf("inheritance_rules").forGetter(PatternGene::inheritanceRules), TextureType.CODEC.fieldOf("textures").forGetter(PatternGene::textures)).apply(instance, PatternGene::new));
    public static final Codec<Holder<PatternGene>> CODEC = RegistryFileCodec.create(FARegistries.PATTERN_GENE, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<PatternGene>> STREAM_CODEC = ByteBufCodecs.holderRegistry(FARegistries.PATTERN_GENE);

    private PatternGene() {
        this(FAUtils.translation("pattern_gene", "blank"), 0xFFFFFF, InheritanceRules.always(), new CompositeTextureType(CompositeTextureRules.blank()));
    }

    public static PatternGene create(Component skinName, int geneColor, InheritanceRules.RuleSource inheritanceRules, CompositeTextureRules.RuleSource compositeTextureRules) {
        return new PatternGene(skinName, geneColor, inheritanceRules, new CompositeTextureType(compositeTextureRules));
    }
}