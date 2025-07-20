package willatendo.fossilslegacy.server.item.items;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.data_components.CosmeticGeneticInformation;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;

import java.util.Optional;

public class GeneticCodeItem extends Item {
    public static GeneticCodeItem modelGeneticCode(TagKey<ModelType> carriedModelInformation, Properties properties) {
        return new GeneticCodeItem(Optional.of(carriedModelInformation), Optional.empty(), Optional.empty(), properties);
    }

    public static GeneticCodeItem patternGeneticCode(TagKey<Pattern> carriedSkinInformation, TagKey<Pattern> carriedPatternInformation, Properties properties) {
        return new GeneticCodeItem(Optional.empty(), Optional.of(carriedSkinInformation), Optional.of(carriedPatternInformation), properties);
    }

    public static GeneticCodeItem create(TagKey<ModelType> carriedModelInformation, TagKey<Pattern> carriedPatternInformation, Properties properties) {
        return new GeneticCodeItem(Optional.of(carriedModelInformation), Optional.of(carriedPatternInformation), Optional.empty(), properties);
    }

    private GeneticCodeItem(Optional<TagKey<ModelType>> carriedModelInformation, Optional<TagKey<Pattern>> carriedSkinInformation, Optional<TagKey<Pattern>> carriedPatternInformation, Properties properties) {
        super(properties.component(FADataComponents.COSMETIC_GENETIC_INFORMATION.get(), new CosmeticGeneticInformation(carriedModelInformation, carriedSkinInformation, carriedPatternInformation)));
    }
}
