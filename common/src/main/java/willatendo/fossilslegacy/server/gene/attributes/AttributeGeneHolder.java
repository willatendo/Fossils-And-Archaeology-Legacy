package willatendo.fossilslegacy.server.gene.attributes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;
import java.util.Optional;

public final class AttributeGeneHolder {
    public static final Codec<AttributeGeneHolder> CODEC = RecordCodecBuilder.create(instance -> instance.group(AttributeGene.CODEC.optionalFieldOf("gene_1").forGetter(AttributeGeneHolder::getGene1), AttributeGene.CODEC.optionalFieldOf("gene_2").forGetter(AttributeGeneHolder::getGene2), AttributeGene.CODEC.optionalFieldOf("gene_3").forGetter(AttributeGeneHolder::getGene3), AttributeGene.CODEC.optionalFieldOf("gene_4").forGetter(AttributeGeneHolder::getGene4), AttributeGene.CODEC.optionalFieldOf("gene_5").forGetter(AttributeGeneHolder::getGene5), AttributeGene.CODEC.optionalFieldOf("gene_6").forGetter(AttributeGeneHolder::getGene6), AttributeGene.CODEC.optionalFieldOf("gene_7").forGetter(AttributeGeneHolder::getGene7), AttributeGene.CODEC.optionalFieldOf("gene_7").forGetter(AttributeGeneHolder::getGene8)).apply(instance, AttributeGeneHolder::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, AttributeGeneHolder> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.optional(AttributeGene.STREAM_CODEC), AttributeGeneHolder::getGene1, ByteBufCodecs.optional(AttributeGene.STREAM_CODEC), AttributeGeneHolder::getGene2, ByteBufCodecs.optional(AttributeGene.STREAM_CODEC), AttributeGeneHolder::getGene3, ByteBufCodecs.optional(AttributeGene.STREAM_CODEC), AttributeGeneHolder::getGene4, ByteBufCodecs.optional(AttributeGene.STREAM_CODEC), AttributeGeneHolder::getGene5, ByteBufCodecs.optional(AttributeGene.STREAM_CODEC), AttributeGeneHolder::getGene6, ByteBufCodecs.optional(AttributeGene.STREAM_CODEC), AttributeGeneHolder::getGene7, ByteBufCodecs.optional(AttributeGene.STREAM_CODEC), AttributeGeneHolder::getGene8, AttributeGeneHolder::new);
    private Holder<AttributeGene>[] genes = new Holder[8];

    public AttributeGeneHolder() {
    }

    public AttributeGeneHolder(Optional<Holder<AttributeGene>> gene1, Optional<Holder<AttributeGene>> gene2, Optional<Holder<AttributeGene>> gene3, Optional<Holder<AttributeGene>> gene4, Optional<Holder<AttributeGene>> gene5, Optional<Holder<AttributeGene>> gene6, Optional<Holder<AttributeGene>> gene7, Optional<Holder<AttributeGene>> gene8) {
        gene1.ifPresent(geneHolder -> this.genes[0] = geneHolder);
        gene2.ifPresent(geneHolder -> this.genes[1] = geneHolder);
        gene3.ifPresent(geneHolder -> this.genes[2] = geneHolder);
        gene4.ifPresent(geneHolder -> this.genes[3] = geneHolder);
        gene5.ifPresent(geneHolder -> this.genes[4] = geneHolder);
        gene6.ifPresent(geneHolder -> this.genes[5] = geneHolder);
        gene7.ifPresent(geneHolder -> this.genes[6] = geneHolder);
        gene8.ifPresent(geneHolder -> this.genes[7] = geneHolder);
    }

    public boolean isEmpty() {
        for (Holder<AttributeGene> gene : this.genes) {
            if (gene == null) {
                return true;
            }
        }
        return false;
    }

    public void set(int i, Holder<AttributeGene> gene) {
        this.genes[i] = gene;
    }

    public void addTooltips(List<Component> tooltipComponents) {
        int[] boosts = new int[FABuiltInRegistries.GENE.size()];
        for (Holder<AttributeGene> gene : this.genes) {
            if (gene != null) {
                boosts[FABuiltInRegistries.GENE.getId(gene.value())]++;
            }
        }
        for (int i = 0; i < boosts.length; i++) {
            int boost = boosts[i];
            if (boost > 0) {
                AttributeGene attributeGene = FABuiltInRegistries.GENE.get(i).orElseThrow().value();
                MutableComponent information = Component.literal("+" + (100 + (boosts[i] * 5)) + "%").withStyle(attributeGene.displayColor());
                tooltipComponents.add(FAUtils.translation("item", "dna.gene", attributeGene.getDisplayName(), information).withStyle(ChatFormatting.GRAY));
            }
        }
    }

    private Optional<Holder<AttributeGene>> getGene1() {
        Holder<AttributeGene> gene = this.genes[0];
        return gene != null ? Optional.of(gene) : Optional.empty();
    }

    private Optional<Holder<AttributeGene>> getGene2() {
        Holder<AttributeGene> gene = this.genes[1];
        return gene != null ? Optional.of(gene) : Optional.empty();
    }

    private Optional<Holder<AttributeGene>> getGene3() {
        Holder<AttributeGene> gene = this.genes[2];
        return gene != null ? Optional.of(gene) : Optional.empty();
    }

    private Optional<Holder<AttributeGene>> getGene4() {
        Holder<AttributeGene> gene = this.genes[3];
        return gene != null ? Optional.of(gene) : Optional.empty();
    }

    private Optional<Holder<AttributeGene>> getGene5() {
        Holder<AttributeGene> gene = this.genes[4];
        return gene != null ? Optional.of(gene) : Optional.empty();
    }

    private Optional<Holder<AttributeGene>> getGene6() {
        Holder<AttributeGene> gene = this.genes[5];
        return gene != null ? Optional.of(gene) : Optional.empty();
    }

    private Optional<Holder<AttributeGene>> getGene7() {
        Holder<AttributeGene> gene = this.genes[6];
        return gene != null ? Optional.of(gene) : Optional.empty();
    }

    private Optional<Holder<AttributeGene>> getGene8() {
        Holder<AttributeGene> gene = this.genes[7];
        return gene != null ? Optional.of(gene) : Optional.empty();
    }

    public float apply(Holder<Attribute> attribute, float value) {
        float multiplication = 0.0F;
        for (Holder<AttributeGene> geneHolder : this.genes) {
            if (geneHolder != null) {
                AttributeGene attributeGene = geneHolder.value();
                if (attribute.is(attributeGene.geneEffect())) {
                    multiplication += attributeGene.multiplication();

                }
            }
        }
        return value + (multiplication * value);
    }

    public void saveAdditional(CompoundTag compoundTag) {
        for (int i = 0; i < 8; i++) {
            if (this.genes[i] != null) {
                compoundTag.putString("gene_" + i, this.genes[i].getRegisteredName());
            }
        }
    }

    public static AttributeGeneHolder loadAdditional(CompoundTag compoundTag) {
        Optional<Holder<AttributeGene>>[] genes = new Optional[8];
        for (int i = 0; i < 8; i++) {
            if (compoundTag.contains(compoundTag.getString("gene_" + i))) {
                genes[i] = Optional.of(FABuiltInRegistries.GENE.get(ResourceLocation.parse(compoundTag.getString("gene_" + i))).orElseThrow());
            } else {
                genes[i] = Optional.empty();
            }
        }
        return new AttributeGeneHolder(genes[0], genes[1], genes[2], genes[3], genes[4], genes[5], genes[6], genes[7]);
    }

    @Override
    public int hashCode() {
        return this.genes.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AttributeGeneHolder attributeGeneHolder) {
            return this.genes == attributeGeneHolder.genes;
        }
        return false;
    }
}
