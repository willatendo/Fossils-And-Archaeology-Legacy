package willatendo.fossilslegacy.server.gene;

import net.minecraft.core.Holder;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import willatendo.fossilslegacy.server.entity.util.interfaces.ChromosomedEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.PregnantAnimal;
import willatendo.fossilslegacy.server.gene.attributes.AttributeGeneHolder;
import willatendo.fossilslegacy.server.gene.cosmetics.CosmeticGeneHolder;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;

public final class ChromosomeUtils {
    public static void createRandomChromosomes(ChromosomedEntity chromosomedEntity, RandomSource randomSource, TagKey<ModelGene> applicableModelGenes) {
        Holder<ModelGene> modelGeneHolder = chromosomedEntity.getModelGeneRegistry().getOrThrow(applicableModelGenes).getRandomElement(randomSource).orElseThrow();
        ModelGene modelGene = modelGeneHolder.value();
        Holder<SkinGene> skinGene1 = chromosomedEntity.getSkinGeneRegistry().getOrThrow(modelGene.skinGenes()).getRandomElement(randomSource).orElseThrow();
        Holder<SkinGene> skinGene2 = chromosomedEntity.getSkinGeneRegistry().getOrThrow(modelGene.skinGenes()).getRandomElement(randomSource).orElseThrow();
        Holder<PatternGene> patternGene1 = chromosomedEntity.getPatternGeneRegistry().getOrThrow(modelGene.patternGenes()).getRandomElement(randomSource).orElseThrow();
        Holder<PatternGene> patternGene2 = chromosomedEntity.getPatternGeneRegistry().getOrThrow(modelGene.patternGenes()).getRandomElement(randomSource).orElseThrow();
        boolean skinGene1Dominant = skinGene1.value().inheritanceRules().apply(skinGene1).tryApply(randomSource, skinGene1.value(), skinGene2.value());
        boolean patternGene1Dominant = patternGene1.value().inheritanceRules().apply(patternGene1).tryApply(randomSource, patternGene1.value(), patternGene2.value());
        chromosomedEntity.setChromosome1(new Chromosome(new CosmeticGeneHolder(InheritedGene.createModelGene(modelGeneHolder.getRegisteredName()), InheritedGene.createSkinGene(skinGene1Dominant ? skinGene1.getRegisteredName() : skinGene2.getRegisteredName()), InheritedGene.createPatternGene(patternGene1Dominant ? patternGene1.getRegisteredName() : patternGene2.getRegisteredName())), new AttributeGeneHolder()));
        chromosomedEntity.setChromosome2(new Chromosome(new CosmeticGeneHolder(InheritedGene.createModelGene(modelGeneHolder.getRegisteredName()), InheritedGene.createSkinGene(skinGene1Dominant ? skinGene2.getRegisteredName() : skinGene1.getRegisteredName()), InheritedGene.createPatternGene(patternGene1Dominant ? patternGene2.getRegisteredName() : patternGene1.getRegisteredName())), new AttributeGeneHolder()));
    }

    public static void createRandomChromosomes(PregnantAnimal<?> pregnantAnimal, RandomSource randomSource, TagKey<ModelGene> applicableModelGenes) {
        Holder<ModelGene> modelGeneHolder = pregnantAnimal.getModelGeneRegistry().getOrThrow(applicableModelGenes).getRandomElement(randomSource).orElseThrow();
        ModelGene modelGene = modelGeneHolder.value();
        Holder<SkinGene> skinGene1 = pregnantAnimal.getSkinGeneRegistry().getOrThrow(modelGene.skinGenes()).getRandomElement(randomSource).orElseThrow();
        Holder<SkinGene> skinGene2 = pregnantAnimal.getSkinGeneRegistry().getOrThrow(modelGene.skinGenes()).getRandomElement(randomSource).orElseThrow();
        Holder<PatternGene> patternGene1 = pregnantAnimal.getPatternGeneRegistry().getOrThrow(modelGene.patternGenes()).getRandomElement(randomSource).orElseThrow();
        Holder<PatternGene> patternGene2 = pregnantAnimal.getPatternGeneRegistry().getOrThrow(modelGene.patternGenes()).getRandomElement(randomSource).orElseThrow();
        boolean skinGene1Dominant = skinGene1.value().inheritanceRules().apply(skinGene1).tryApply(randomSource, skinGene1.value(), skinGene2.value());
        boolean patternGene1Dominant = patternGene1.value().inheritanceRules().apply(patternGene1).tryApply(randomSource, patternGene1.value(), patternGene2.value());
        pregnantAnimal.setOffspringChromosome1(new Chromosome(new CosmeticGeneHolder(InheritedGene.createModelGene(modelGeneHolder.getRegisteredName()), InheritedGene.createSkinGene(skinGene1Dominant ? skinGene1.getRegisteredName() : skinGene2.getRegisteredName()), InheritedGene.createPatternGene(patternGene1Dominant ? patternGene1.getRegisteredName() : patternGene2.getRegisteredName())), new AttributeGeneHolder()));
        pregnantAnimal.setOffspringChromosome2(new Chromosome(new CosmeticGeneHolder(InheritedGene.createModelGene(modelGeneHolder.getRegisteredName()), InheritedGene.createSkinGene(skinGene1Dominant ? skinGene2.getRegisteredName() : skinGene1.getRegisteredName()), InheritedGene.createPatternGene(patternGene1Dominant ? patternGene2.getRegisteredName() : patternGene1.getRegisteredName())), new AttributeGeneHolder()));
    }

    public static void createChildChromosomes(ChromosomedEntity baby, ChromosomedEntity mom, ChromosomedEntity dad, RandomSource randomSource) {
        Chromosome chromosome1 = randomSource.nextInt(2) == 0 ? mom.getChromosome1() : mom.getChromosome2();
        Chromosome chromosome2 = randomSource.nextInt(2) == 0 ? dad.getChromosome1() : dad.getChromosome2();
        boolean chromosome1First = randomSource.nextInt(2) == 0;
        baby.setChromosome1(chromosome1First ? chromosome1 : chromosome2);
        baby.setChromosome2(chromosome1First ? chromosome2 : chromosome1);
    }
}
