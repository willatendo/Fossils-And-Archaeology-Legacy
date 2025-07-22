package willatendo.fossilslegacy.server.gene;

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

public final class GeneHolder {
    public static final Codec<GeneHolder> CODEC = RecordCodecBuilder.create(instance -> instance.group(Gene.CODEC.optionalFieldOf("gene_1").forGetter(GeneHolder::getGene1), Gene.CODEC.optionalFieldOf("gene_2").forGetter(GeneHolder::getGene2), Gene.CODEC.optionalFieldOf("gene_3").forGetter(GeneHolder::getGene3), Gene.CODEC.optionalFieldOf("gene_4").forGetter(GeneHolder::getGene4), Gene.CODEC.optionalFieldOf("gene_5").forGetter(GeneHolder::getGene5), Gene.CODEC.optionalFieldOf("gene_6").forGetter(GeneHolder::getGene6), Gene.CODEC.optionalFieldOf("gene_7").forGetter(GeneHolder::getGene7), Gene.CODEC.optionalFieldOf("gene_7").forGetter(GeneHolder::getGene8)).apply(instance, GeneHolder::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, GeneHolder> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.optional(Gene.STREAM_CODEC), GeneHolder::getGene1, ByteBufCodecs.optional(Gene.STREAM_CODEC), GeneHolder::getGene2, ByteBufCodecs.optional(Gene.STREAM_CODEC), GeneHolder::getGene3, ByteBufCodecs.optional(Gene.STREAM_CODEC), GeneHolder::getGene4, ByteBufCodecs.optional(Gene.STREAM_CODEC), GeneHolder::getGene5, ByteBufCodecs.optional(Gene.STREAM_CODEC), GeneHolder::getGene6, ByteBufCodecs.optional(Gene.STREAM_CODEC), GeneHolder::getGene7, ByteBufCodecs.optional(Gene.STREAM_CODEC), GeneHolder::getGene8, GeneHolder::new);
    private Holder<Gene>[] genes = new Holder[8];

    public GeneHolder() {
    }

    public GeneHolder(Optional<Holder<Gene>> gene1, Optional<Holder<Gene>> gene2, Optional<Holder<Gene>> gene3, Optional<Holder<Gene>> gene4, Optional<Holder<Gene>> gene5, Optional<Holder<Gene>> gene6, Optional<Holder<Gene>> gene7, Optional<Holder<Gene>> gene8) {
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
        boolean empty = true;
        for (Holder<Gene> gene : this.genes) {
            if (gene != null) {
                empty = false;
                break;
            }
        }
        return empty;
    }

    public void set(int i, Holder<Gene> gene) {
        this.genes[i] = gene;
    }

    public void addTooltips(List<Component> tooltipComponents) {
        int[] boosts = new int[FABuiltInRegistries.GENE.size()];
        for (Holder<Gene> gene : this.genes) {
            if (gene != null) {
                boosts[FABuiltInRegistries.GENE.getId(gene.value())]++;
            }
        }
        for (int i = 0; i < boosts.length; i++) {
            int boost = boosts[i];
            if (boost > 0) {
                Gene gene = FABuiltInRegistries.GENE.get(i).orElseThrow().value();
                MutableComponent information = Component.literal("+" + (100 + (boosts[i] * 5)) + "%").withStyle(gene.displayColor());
                tooltipComponents.add(FAUtils.translation("item", "dna.gene", gene.getDisplayName(), information).withStyle(ChatFormatting.GRAY));
            }
        }
    }

    private Optional<Holder<Gene>> getGene1() {
        Holder<Gene> gene = this.genes[0];
        return gene != null ? Optional.of(gene) : Optional.empty();
    }

    private Optional<Holder<Gene>> getGene2() {
        Holder<Gene> gene = this.genes[1];
        return gene != null ? Optional.of(gene) : Optional.empty();
    }

    private Optional<Holder<Gene>> getGene3() {
        Holder<Gene> gene = this.genes[2];
        return gene != null ? Optional.of(gene) : Optional.empty();
    }

    private Optional<Holder<Gene>> getGene4() {
        Holder<Gene> gene = this.genes[3];
        return gene != null ? Optional.of(gene) : Optional.empty();
    }

    private Optional<Holder<Gene>> getGene5() {
        Holder<Gene> gene = this.genes[4];
        return gene != null ? Optional.of(gene) : Optional.empty();
    }

    private Optional<Holder<Gene>> getGene6() {
        Holder<Gene> gene = this.genes[5];
        return gene != null ? Optional.of(gene) : Optional.empty();
    }

    private Optional<Holder<Gene>> getGene7() {
        Holder<Gene> gene = this.genes[6];
        return gene != null ? Optional.of(gene) : Optional.empty();
    }

    private Optional<Holder<Gene>> getGene8() {
        Holder<Gene> gene = this.genes[7];
        return gene != null ? Optional.of(gene) : Optional.empty();
    }

    public float apply(Holder<Attribute> attribute, float value) {
        float multiplication = 0.0F;
        for (Holder<Gene> geneHolder : this.genes) {
            if (geneHolder != null) {
                Gene gene = geneHolder.value();
                if (attribute.is(gene.geneEffect())) {
                    multiplication += gene.multiplication();

                }
            }
        }
        return value + (multiplication * value);
    }

    public void save(CompoundTag compoundTag) {
        for (int i = 0; i < 8; i++) {
            if (this.genes[i] != null) {
                compoundTag.putString("gene_" + i, this.genes[i].getRegisteredName());
            }
        }
    }

    public void load(CompoundTag compoundTag) {
        for (int i = 0; i < 8; i++) {
            if (compoundTag.contains(compoundTag.getString("gene_" + i))) {
                this.genes[i] = FABuiltInRegistries.GENE.get(ResourceLocation.parse(compoundTag.getString("gene_" + i))).orElseThrow();
            }
        }
    }

    @Override
    public int hashCode() {
        return this.genes.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GeneHolder geneHolder) {
            return this.genes == geneHolder.genes;
        }
        return false;
    }
}
