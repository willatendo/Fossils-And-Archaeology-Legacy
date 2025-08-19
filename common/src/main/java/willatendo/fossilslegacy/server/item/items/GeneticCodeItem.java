package willatendo.fossilslegacy.server.item.items;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.data_components.CosmeticGeneticInformation;

import java.util.Optional;

public class GeneticCodeItem extends Item {
    public static GeneticCodeItem modelGeneticCode(TagKey<ModelGene> carriedModelInformation, Properties properties) {
        return new GeneticCodeItem(Optional.of(carriedModelInformation), Optional.empty(), Optional.empty(), properties);
    }

    public static GeneticCodeItem patternGeneticCode(TagKey<PatternGene> carriedSkinInformation, TagKey<PatternGene> carriedPatternInformation, Properties properties) {
        return new GeneticCodeItem(Optional.empty(), Optional.of(carriedSkinInformation), Optional.of(carriedPatternInformation), properties);
    }

    public static GeneticCodeItem create(TagKey<ModelGene> carriedModelInformation, TagKey<PatternGene> carriedPatternInformation, Properties properties) {
        return new GeneticCodeItem(Optional.of(carriedModelInformation), Optional.of(carriedPatternInformation), Optional.empty(), properties);
    }

    private GeneticCodeItem(Optional<TagKey<ModelGene>> carriedModelInformation, Optional<TagKey<PatternGene>> carriedSkinInformation, Optional<TagKey<PatternGene>> carriedPatternInformation, Properties properties) {
        super(properties.component(FADataComponents.COSMETIC_GENETIC_INFORMATION.get(), new CosmeticGeneticInformation(carriedModelInformation, carriedSkinInformation, carriedPatternInformation)));
    }
}
