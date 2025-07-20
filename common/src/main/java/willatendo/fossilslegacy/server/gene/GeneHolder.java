package willatendo.fossilslegacy.server.gene;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;

import java.util.ArrayList;
import java.util.List;

public final class GeneHolder {
    public static final Codec<GeneHolder> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.list(Gene.CODEC).fieldOf("genes").forGetter(gene -> gene.genes)).apply(instance, GeneHolder::new));
    private List<Holder<Gene>> genes;

    public GeneHolder(int slots) {
        this.genes = new ArrayList<>(slots);
    }

    private GeneHolder(List<Holder<Gene>> genes) {
        this.genes = genes;
    }

    public void applyGenes() {

    }
}
