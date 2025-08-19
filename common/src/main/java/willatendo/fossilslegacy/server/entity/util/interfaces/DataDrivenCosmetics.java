package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityDimensions;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.Optional;

public interface DataDrivenCosmetics {
    void setModelType(Holder<ModelGene> modelType);

    Holder<ModelGene> getModelType();

    void setSkin(Holder<PatternGene> pattern);

    Holder<PatternGene> getSkin();

    void setPattern(Holder<PatternGene> pattern);

    Holder<PatternGene> getPattern();

    default void addCosmeticsData(CompoundTag compoundTag, HolderLookup.Provider provider) {
        this.getModelType().unwrapKey().ifPresent(modelType -> compoundTag.putString("model_type", modelType.location().toString()));
        this.getSkin().unwrapKey().ifPresent(skin -> compoundTag.putString("skinGenes", skin.location().toString()));
        if (this.getPattern() != null) {
            this.getPattern().unwrapKey().ifPresent(pattern -> compoundTag.putString("patternGenes", pattern.location().toString()));
        }
    }

    default void readCosmeticsData(CompoundTag compoundTag, HolderLookup.Provider provider) {
        Optional.ofNullable(ResourceLocation.tryParse(compoundTag.getString("model_type"))).map(id -> ResourceKey.create(FARegistries.MODEL_GENE, id)).flatMap(resourceKey -> provider.lookupOrThrow(FARegistries.MODEL_GENE).get(resourceKey)).ifPresent(this::setModelType);
        Optional.ofNullable(ResourceLocation.tryParse(compoundTag.getString("skinGenes"))).map(id -> ResourceKey.create(FARegistries.PATTERN_GENE, id)).flatMap(resourceKey -> provider.lookupOrThrow(FARegistries.PATTERN_GENE).get(resourceKey)).ifPresent(this::setSkin);
        if (compoundTag.contains("patternGenes")) {
            Optional.ofNullable(ResourceLocation.tryParse(compoundTag.getString("patternGenes"))).map(id -> ResourceKey.create(FARegistries.PATTERN_GENE, id)).flatMap(resourceKey -> provider.lookupOrThrow(FARegistries.PATTERN_GENE).get(resourceKey)).ifPresent(this::setPattern);
        }
    }

}
