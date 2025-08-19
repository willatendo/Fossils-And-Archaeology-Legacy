package willatendo.fossilslegacy.server.gene;

import net.minecraft.core.Holder;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import willatendo.fossilslegacy.server.entity.util.interfaces.ChromosomedEntity;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;

public final class ChromosomeUtils {
    public static void createChromosomes(ChromosomedEntity chromosomedEntity, RandomSource randomSource, TagKey<ModelGene> applicableModelGenes) {
        Holder<ModelGene> modelGeneHolder = chromosomedEntity.getModelGeneRegistry().getOrThrow(applicableModelGenes).getRandomElement(randomSource).orElseThrow();
        ModelGene modelGene = modelGeneHolder.value();
        Holder<SkinGene> skinGene = chromosomedEntity.getSkinGeneRegistry().getOrThrow(modelGene.skinGenes()).getRandomElement(randomSource).orElseThrow();

    }
}
