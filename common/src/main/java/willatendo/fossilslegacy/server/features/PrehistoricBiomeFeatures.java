package willatendo.fossilslegacy.server.features;

import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class PrehistoricBiomeFeatures {
    public static void addPrehistoricPlainVegetation(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FossilsLegacyPlacedFeatures.TREES_PREHISTORIC_PLAINS);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_PLAINS);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_PLAIN);
    }

    public static void addOtherBirchTrees(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FossilsLegacyPlacedFeatures.TREES_PREHISTORIC_FOREST);
    }
}
