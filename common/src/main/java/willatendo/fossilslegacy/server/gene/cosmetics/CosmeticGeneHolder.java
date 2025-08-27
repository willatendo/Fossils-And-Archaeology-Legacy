package willatendo.fossilslegacy.server.gene.cosmetics;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Optional;

public record CosmeticGeneHolder(ResourceKey<ModelGene> modelGene, ResourceKey<SkinGene> skinGene, Optional<ResourceKey<PatternGene>> patternGene) {
    public static final Codec<CosmeticGeneHolder> CODEC = RecordCodecBuilder.create(instance -> instance.group(ResourceKey.codec(FARegistries.MODEL_GENE).fieldOf("model_gene").forGetter(CosmeticGeneHolder::modelGene), ResourceKey.codec(FARegistries.SKIN_GENE).fieldOf("skin_gene").forGetter(CosmeticGeneHolder::skinGene), ResourceKey.codec(FARegistries.PATTERN_GENE).optionalFieldOf("pattern_gene").forGetter(CosmeticGeneHolder::patternGene)).apply(instance, CosmeticGeneHolder::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, CosmeticGeneHolder> STREAM_CODEC = StreamCodec.composite(ResourceKey.streamCodec(FARegistries.MODEL_GENE), CosmeticGeneHolder::modelGene, ResourceKey.streamCodec(FARegistries.SKIN_GENE), CosmeticGeneHolder::skinGene, ByteBufCodecs.optional(ResourceKey.streamCodec(FARegistries.PATTERN_GENE)), CosmeticGeneHolder::patternGene, CosmeticGeneHolder::new);

    public CosmeticGeneHolder(ResourceKey<ModelGene> modelGene, ResourceKey<SkinGene> skinGene, ResourceKey<PatternGene> patternGene) {
        this(modelGene, skinGene, Optional.of(patternGene));
    }

    public CosmeticGeneHolder(ResourceKey<ModelGene> modelGene, ResourceKey<SkinGene> skinGene) {
        this(modelGene, skinGene, Optional.empty());
    }

    public Holder<ModelGene> modelGene(HolderLookup.Provider registries) {
        return registries.lookupOrThrow(FARegistries.MODEL_GENE).getOrThrow(this.modelGene());
    }

    public Holder<SkinGene> skinGene(HolderLookup.Provider registries) {
        return registries.lookupOrThrow(FARegistries.SKIN_GENE).getOrThrow(this.skinGene());
    }

    public Holder<PatternGene> patternGene(HolderLookup.Provider registries) {
        HolderLookup<PatternGene> patternRegistry = registries.lookupOrThrow(FARegistries.PATTERN_GENE);
        return this.patternGene().isPresent() ? patternRegistry.getOrThrow(this.patternGene().get()) : patternRegistry.getOrThrow(FAPatternGenes.BLANK);
    }

    public Optional<Holder<PatternGene>> optionalPatternGene(HolderLookup.Provider registries) {
        HolderLookup<PatternGene> patternRegistry = registries.lookupOrThrow(FARegistries.PATTERN_GENE);
        return this.patternGene().isPresent() ? Optional.of(patternRegistry.getOrThrow(this.patternGene().get())) : Optional.empty();
    }

    public boolean hasPattern() {
        return this.patternGene.isPresent() && this.patternGene.get() != (FAPatternGenes.BLANK);
    }

    public Component getDisplayName(HolderLookup.Provider registries) {
        if (this.hasPattern()) {
            return FAUtils.translation("cosmetics_holder", "composite", this.skinGene(registries).value().skinName(), this.patternGene(registries).value().patternName());
        } else {
            return this.skinGene(registries).value().skinName();
        }
    }

    public static CosmeticGeneHolder loadAdditional(CompoundTag compoundTag) {
        ResourceKey<ModelGene> modelGene = ResourceKey.create(FARegistries.MODEL_GENE, ResourceLocation.parse(compoundTag.getString("model_gene")));
        ResourceKey<SkinGene> skinGene = ResourceKey.create(FARegistries.SKIN_GENE, ResourceLocation.parse(compoundTag.getString("skin_gene")));
        Optional<ResourceKey<PatternGene>> patternGene = Optional.empty();
        if (compoundTag.contains("pattern_gene")) {
            patternGene = Optional.of(ResourceKey.create(FARegistries.PATTERN_GENE, ResourceLocation.parse(compoundTag.getString("pattern_gene"))));
        }
        return new CosmeticGeneHolder(modelGene, skinGene, patternGene);
    }

    public void saveAdditional(CompoundTag compoundTag) {
        compoundTag.putString("model_gene", this.modelGene().location().toString());
        compoundTag.putString("skin_gene", this.skinGene().location().toString());
        if (!this.patternGene().isEmpty()) {
            compoundTag.putString("pattern_gene", this.patternGene().get().location().toString());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CosmeticGeneHolder cosmeticGeneHolder) {
            return (this.hasPattern() && cosmeticGeneHolder.hasPattern()) ? this.patternGene.get() == cosmeticGeneHolder.patternGene.get() && this.skinGene() == cosmeticGeneHolder.skinGene() : (!this.hasPattern() && !cosmeticGeneHolder.hasPattern()) && this.skinGene() == cosmeticGeneHolder.skinGene();
        }
        return false;
    }
}
