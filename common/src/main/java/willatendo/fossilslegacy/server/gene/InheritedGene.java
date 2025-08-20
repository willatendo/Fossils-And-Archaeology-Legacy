package willatendo.fossilslegacy.server.gene;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;
import willatendo.fossilslegacy.server.registry.FARegistries;

public interface InheritedGene {
     static ResourceKey<ModelGene> createModelGene(String name) {
        return ResourceKey.create(FARegistries.MODEL_GENE, ResourceLocation.parse(name));
    }

     static ResourceKey<SkinGene> createSkinGene(String name) {
        return ResourceKey.create(FARegistries.SKIN_GENE, ResourceLocation.parse(name));
    }

     static ResourceKey<PatternGene> createPatternGene(String name) {
        return ResourceKey.create(FARegistries.PATTERN_GENE, ResourceLocation.parse(name));
    }
}
