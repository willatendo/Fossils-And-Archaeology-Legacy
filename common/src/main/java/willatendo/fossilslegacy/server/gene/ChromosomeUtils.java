package willatendo.fossilslegacy.server.gene;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import willatendo.fossilslegacy.server.entity.util.interfaces.ChromosomedEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.PregnantAnimal;
import willatendo.fossilslegacy.server.gene.attributes.AttributeGeneHolder;
import willatendo.fossilslegacy.server.gene.cosmetics.CosmeticGeneHolder;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;
import willatendo.fossilslegacy.server.tags.FASkinGeneTags;

import java.util.Optional;

public final class ChromosomeUtils {
    public static void createRandomChromosomes(ChromosomedEntity chromosomedEntity, RandomSource randomSource, TagKey<ModelGene> applicableModelGenes) {
        ChromosomeUtils.createRandomChromosomes(new EntityIn() {
            @Override
            public Registry<ModelGene> getModelGeneRegistry() {
                return chromosomedEntity.getModelGeneRegistry();
            }

            @Override
            public Registry<SkinGene> getSkinGeneRegistry() {
                return chromosomedEntity.getSkinGeneRegistry();
            }

            @Override
            public Registry<PatternGene> getPatternGeneRegistry() {
                return chromosomedEntity.getPatternGeneRegistry();
            }

            @Override
            public void setChromosome1(Chromosome chromosome) {
                chromosomedEntity.setChromosome1(chromosome);
            }

            @Override
            public void setChromosome2(Chromosome chromosome) {
                chromosomedEntity.setChromosome2(chromosome);
            }
        }, randomSource, applicableModelGenes);
    }

    public static void createRandomChromosomes(PregnantAnimal<?> pregnantAnimal, RandomSource randomSource, TagKey<ModelGene> applicableModelGenes) {
        ChromosomeUtils.createRandomChromosomes(new EntityIn() {
            @Override
            public Registry<ModelGene> getModelGeneRegistry() {
                return pregnantAnimal.getModelGeneRegistry();
            }

            @Override
            public Registry<SkinGene> getSkinGeneRegistry() {
                return pregnantAnimal.getSkinGeneRegistry();
            }

            @Override
            public Registry<PatternGene> getPatternGeneRegistry() {
                return pregnantAnimal.getPatternGeneRegistry();
            }

            @Override
            public void setChromosome1(Chromosome chromosome) {
                pregnantAnimal.setOffspringChromosome1(chromosome);
            }

            @Override
            public void setChromosome2(Chromosome chromosome) {
                pregnantAnimal.setOffspringChromosome2(chromosome);
            }
        }, randomSource, applicableModelGenes);
    }

    private static void createRandomChromosomes(EntityIn entityIn, RandomSource randomSource, TagKey<ModelGene> applicableModelGenes) {
        Holder<ModelGene> modelGeneHolder = entityIn.getModelGeneRegistry().getOrThrow(applicableModelGenes).getRandomElement(randomSource).orElseThrow();
        ModelGene modelGene = modelGeneHolder.value();
        Holder<SkinGene> skinGene1 = entityIn.getSkinGeneRegistry().getOrThrow(modelGene.skinGenes()).getRandomElement(randomSource).orElseThrow();
        Holder<SkinGene> skinGene2 = entityIn.getSkinGeneRegistry().getOrThrow(modelGene.skinGenes()).getRandomElement(randomSource).orElseThrow();
        Optional<Holder<PatternGene>> patternGene1 = Optional.empty();
        Optional<Holder<PatternGene>> patternGene2 = Optional.empty();
        if (skinGene1.is(FASkinGeneTags.HAS_PATTERNS)) {
            if (randomSource.nextInt(4) == 1) {
                patternGene1 = Optional.of(entityIn.getPatternGeneRegistry().getOrThrow(modelGene.patternGenes()).getRandomElement(randomSource).orElseThrow());
            }
        }
        if (skinGene2.is(FASkinGeneTags.HAS_PATTERNS)) {
            if (randomSource.nextInt(4) == 1) {
                patternGene2 = Optional.of(entityIn.getPatternGeneRegistry().getOrThrow(modelGene.patternGenes()).getRandomElement(randomSource).orElseThrow());
            }
        }
        boolean skinGene1Dominant = skinGene1.value().inheritanceRules().apply(skinGene1).tryApply(randomSource, skinGene1.value(), skinGene2.value());
        if (patternGene1.isPresent() && patternGene2.isPresent()) {
            boolean patternGene1Dominant = patternGene1.get().value().inheritanceRules().apply(patternGene1.get()).tryApply(randomSource, patternGene1.get().value(), patternGene2.get().value());
            entityIn.setChromosome1(new Chromosome(new CosmeticGeneHolder(InheritedGene.createModelGene(modelGeneHolder.getRegisteredName()), InheritedGene.createSkinGene(skinGene1Dominant ? skinGene1.getRegisteredName() : skinGene2.getRegisteredName()), InheritedGene.createPatternGene(patternGene1Dominant ? patternGene1.get().getRegisteredName() : patternGene2.get().getRegisteredName())), new AttributeGeneHolder()));
            entityIn.setChromosome2(new Chromosome(new CosmeticGeneHolder(InheritedGene.createModelGene(modelGeneHolder.getRegisteredName()), InheritedGene.createSkinGene(skinGene1Dominant ? skinGene2.getRegisteredName() : skinGene1.getRegisteredName()), InheritedGene.createPatternGene(patternGene1Dominant ? patternGene2.get().getRegisteredName() : patternGene1.get().getRegisteredName())), new AttributeGeneHolder()));
            return;
        }
        if (patternGene1.isPresent()) {
            entityIn.setChromosome1(new Chromosome(new CosmeticGeneHolder(InheritedGene.createModelGene(modelGeneHolder.getRegisteredName()), InheritedGene.createSkinGene(skinGene1Dominant ? skinGene1.getRegisteredName() : skinGene2.getRegisteredName()), InheritedGene.createPatternGene(patternGene1.get().getRegisteredName())), new AttributeGeneHolder()));
            entityIn.setChromosome2(new Chromosome(new CosmeticGeneHolder(InheritedGene.createModelGene(modelGeneHolder.getRegisteredName()), InheritedGene.createSkinGene(skinGene1Dominant ? skinGene2.getRegisteredName() : skinGene1.getRegisteredName()), Optional.empty()), new AttributeGeneHolder()));
            return;
        }
        entityIn.setChromosome1(new Chromosome(new CosmeticGeneHolder(InheritedGene.createModelGene(modelGeneHolder.getRegisteredName()), InheritedGene.createSkinGene(skinGene1Dominant ? skinGene1.getRegisteredName() : skinGene2.getRegisteredName()), Optional.empty()), new AttributeGeneHolder()));
        entityIn.setChromosome2(new Chromosome(new CosmeticGeneHolder(InheritedGene.createModelGene(modelGeneHolder.getRegisteredName()), InheritedGene.createSkinGene(skinGene1Dominant ? skinGene2.getRegisteredName() : skinGene1.getRegisteredName()), Optional.empty()), new AttributeGeneHolder()));
    }

    public static void createChildChromosomes(ChromosomedEntity baby, ChromosomedEntity mom, ChromosomedEntity dad, RandomSource randomSource) {
        Chromosome chromosome1 = randomSource.nextInt(2) == 0 ? mom.getChromosome1() : mom.getChromosome2();
        Chromosome chromosome2 = randomSource.nextInt(2) == 0 ? dad.getChromosome1() : dad.getChromosome2();
        boolean chromosome1First = randomSource.nextInt(2) == 0;
        baby.setChromosome1(chromosome1First ? chromosome1 : chromosome2);
        baby.setChromosome2(chromosome1First ? chromosome2 : chromosome1);
    }

    private interface EntityIn {
        Registry<ModelGene> getModelGeneRegistry();

        Registry<SkinGene> getSkinGeneRegistry();

        Registry<PatternGene> getPatternGeneRegistry();

        void setChromosome1(Chromosome chromosome);

        void setChromosome2(Chromosome chromosome);
    }
}
