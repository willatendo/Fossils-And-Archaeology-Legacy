package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityDimensions;
import willatendo.fossilslegacy.server.gene.Chromosome;
import willatendo.fossilslegacy.server.gene.cosmetics.FAPatternGenes;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;

import java.util.Optional;

public interface ChromosomedEntity {
    Registry<ModelGene> getModelGeneRegistry();

    Registry<SkinGene> getSkinGeneRegistry();

    Registry<PatternGene> getPatternGeneRegistry();

    Chromosome getChromosome1();

    void setChromosome1(Chromosome chromosome);

    Chromosome getChromosome2();

    void setChromosome2(Chromosome chromosome);

    default Holder<ModelGene> getModelGene(Registry<ModelGene> modelGeneRegistry) {
        return modelGeneRegistry.getOrThrow(this.getChromosome1().cosmeticGeneHolder().modelGene());
    }

    default Holder<SkinGene> getSkinGene(Registry<SkinGene> skinGeneRegistry) {
        return skinGeneRegistry.getOrThrow(this.getChromosome1().cosmeticGeneHolder().skinGene());
    }

    default Holder<PatternGene> getPatternGene(Registry<PatternGene> modelGeneRegistry) {
        return this.getChromosome1().cosmeticGeneHolder().patternGene().map(modelGeneRegistry::getOrThrow).orElse(modelGeneRegistry.getOrThrow(FAPatternGenes.BLANK));
    }

    default void saveChromosomes(CompoundTag compoundTag) {
        CompoundTag chromosome1 = new CompoundTag();
        this.getChromosome1().saveAdditional(chromosome1);
        compoundTag.put("chromosome_1", chromosome1);
        CompoundTag chromosome2 = new CompoundTag();
        this.getChromosome2().saveAdditional(chromosome2);
        compoundTag.put("chromosome_2", chromosome2);
    }

    default void loadChromosomes(CompoundTag compoundTag) {
        this.setChromosome1(Chromosome.loadAdditional(compoundTag.getCompound("chromosome_1")));
        this.setChromosome2(Chromosome.loadAdditional(compoundTag.getCompound("chromosome_2")));
    }

    default Component getOverridenName(Component defaultName, HolderLookup.Provider registries) {
        ModelGene modelGene = this.getChromosome1().cosmeticGeneHolder().modelGene(registries).value();
        Optional<ModelGene.OverrideInfo> overrideInfo = modelGene.overrideInfo();
        return (overrideInfo.isPresent() && overrideInfo.get().animalName().isPresent()) ? overrideInfo.get().animalName().get() : defaultName;
    }

    default SoundEvent getOverridenSoundEvent(SoundEvent defaultSoundEvent, ModelGene.OverrideInfo.OverridenSoundType overridenSoundType, HolderLookup.Provider registries) {
        ModelGene modelGene = this.getChromosome1().cosmeticGeneHolder().modelGene(registries).value();
        Optional<ModelGene.OverrideInfo> overrideInfoOptional = modelGene.overrideInfo();
        if (overrideInfoOptional.isEmpty()) {
            return defaultSoundEvent;
        }
        ModelGene.OverrideInfo overrideInfo = overrideInfoOptional.get();
        if (overridenSoundType == ModelGene.OverrideInfo.OverridenSoundType.AMBIENT) {
            Optional<SoundEvent> soundEvent = overrideInfo.getAmbientSound();
            return soundEvent.orElse(defaultSoundEvent);
        }
        if (overridenSoundType == ModelGene.OverrideInfo.OverridenSoundType.HURT) {
            Optional<SoundEvent> soundEvent = overrideInfo.getHurtSound();
            return soundEvent.orElse(defaultSoundEvent);
        }
        if (overridenSoundType == ModelGene.OverrideInfo.OverridenSoundType.DEATH) {
            Optional<SoundEvent> soundEvent = overrideInfo.getDeathSound();
            return soundEvent.orElse(defaultSoundEvent);
        }
        return defaultSoundEvent;
    }

    default EntityDimensions getEntityDimensions(int growthStage, HolderLookup.Provider registries) {
        ModelGene modelGene = this.getChromosome1().cosmeticGeneHolder().modelGene(registries).value();
        ModelGene.BoundingBoxInfo boundingBoxInfo = modelGene.boundingBoxInfo();
        return EntityDimensions.scalable(boundingBoxInfo.boundingBoxWidth() + (boundingBoxInfo.boundingBoxGrowth() * growthStage), boundingBoxInfo.boundingBoxHeight() + (boundingBoxInfo.boundingBoxGrowth() * growthStage));
    }
}
