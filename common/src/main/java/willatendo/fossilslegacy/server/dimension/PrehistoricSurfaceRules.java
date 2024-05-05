package willatendo.fossilslegacy.server.dimension;

import com.google.common.collect.ImmutableList;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import willatendo.fossilslegacy.server.biomes.FossilsLegacyBiomes;

public class PrehistoricSurfaceRules {
    private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.AIR);
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource WHITE_TERRACOTTA = makeStateRule(Blocks.WHITE_TERRACOTTA);
    private static final SurfaceRules.RuleSource ORANGE_TERRACOTTA = makeStateRule(Blocks.ORANGE_TERRACOTTA);
    private static final SurfaceRules.RuleSource TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
    private static final SurfaceRules.RuleSource RED_SAND = makeStateRule(Blocks.RED_SAND);
    private static final SurfaceRules.RuleSource RED_SANDSTONE = makeStateRule(Blocks.RED_SANDSTONE);
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource MYCELIUM = makeStateRule(Blocks.MYCELIUM);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource CALCITE = makeStateRule(Blocks.CALCITE);
    private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static final SurfaceRules.RuleSource PACKED_ICE = makeStateRule(Blocks.PACKED_ICE);
    private static final SurfaceRules.RuleSource SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
    private static final SurfaceRules.RuleSource MUD = makeStateRule(Blocks.MUD);
    private static final SurfaceRules.RuleSource POWDER_SNOW = makeStateRule(Blocks.POWDER_SNOW);
    private static final SurfaceRules.RuleSource ICE = makeStateRule(Blocks.ICE);
    private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);
    private static final SurfaceRules.RuleSource LAVA = makeStateRule(Blocks.LAVA);
    private static final SurfaceRules.RuleSource NETHERRACK = makeStateRule(Blocks.NETHERRACK);
    private static final SurfaceRules.RuleSource SOUL_SAND = makeStateRule(Blocks.SOUL_SAND);
    private static final SurfaceRules.RuleSource SOUL_SOIL = makeStateRule(Blocks.SOUL_SOIL);
    private static final SurfaceRules.RuleSource BASALT = makeStateRule(Blocks.BASALT);
    private static final SurfaceRules.RuleSource BLACKSTONE = makeStateRule(Blocks.BLACKSTONE);
    private static final SurfaceRules.RuleSource WARPED_WART_BLOCK = makeStateRule(Blocks.WARPED_WART_BLOCK);
    private static final SurfaceRules.RuleSource WARPED_NYLIUM = makeStateRule(Blocks.WARPED_NYLIUM);
    private static final SurfaceRules.RuleSource NETHER_WART_BLOCK = makeStateRule(Blocks.NETHER_WART_BLOCK);
    private static final SurfaceRules.RuleSource CRIMSON_NYLIUM = makeStateRule(Blocks.CRIMSON_NYLIUM);
    private static final SurfaceRules.RuleSource ENDSTONE = makeStateRule(Blocks.END_STONE);

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    public static SurfaceRules.RuleSource prehistoric() {
        SurfaceRules.ConditionSource y97 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(97), 2);
        SurfaceRules.ConditionSource y256 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(256), 0);
        SurfaceRules.ConditionSource y63 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(63), -1);
        SurfaceRules.ConditionSource y75 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(74), 1);
        SurfaceRules.ConditionSource y60 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(60), 0);
        SurfaceRules.ConditionSource y62 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
        SurfaceRules.ConditionSource y63Multi = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
        SurfaceRules.ConditionSource belowWater = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.ConditionSource inWater = SurfaceRules.waterBlockCheck(0, 0);
        SurfaceRules.ConditionSource aroundWater = SurfaceRules.waterStartCheck(-6, -1);
        SurfaceRules.ConditionSource hole = SurfaceRules.hole();
        SurfaceRules.ConditionSource isFrozenOcean = SurfaceRules.isBiome(new ResourceKey[]{Biomes.FROZEN_OCEAN, Biomes.DEEP_FROZEN_OCEAN});
        SurfaceRules.ConditionSource step = SurfaceRules.steep();
        SurfaceRules.RuleSource basicGrass = SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(inWater, GRASS_BLOCK), DIRT});
        SurfaceRules.RuleSource replaceCeilingSandWithSandstone = SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE), SAND});
        SurfaceRules.RuleSource replaceCeilingGravelWithStone = SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE), GRAVEL});
        SurfaceRules.ConditionSource isWarmOceanOrBeach = SurfaceRules.isBiome(new ResourceKey[]{Biomes.WARM_OCEAN, Biomes.BEACH, Biomes.SNOWY_BEACH});
        SurfaceRules.ConditionSource isDesert = SurfaceRules.isBiome(new ResourceKey[]{FossilsLegacyBiomes.PREHISTORIC_DESERT});
        SurfaceRules.RuleSource stoneNoiseInStonyAreas = SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.STONY_PEAKS}), SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CALCITE, -0.0125, 0.0125), CALCITE), STONE})), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.STONY_SHORE}), SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.GRAVEL, -0.05, 0.05), replaceCeilingGravelWithStone), STONE})), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.WINDSWEPT_HILLS}), SurfaceRules.ifTrue(surfaceNoiseAbove(1.0), STONE)), SurfaceRules.ifTrue(isWarmOceanOrBeach, replaceCeilingSandWithSandstone), SurfaceRules.ifTrue(isDesert, replaceCeilingSandWithSandstone), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.DRIPSTONE_CAVES}), STONE)});
        SurfaceRules.RuleSource powderSnowNoise1 = SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45, 0.58), SurfaceRules.ifTrue(inWater, POWDER_SNOW));
        SurfaceRules.RuleSource powderSnowNoise2 = SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.35, 0.6), SurfaceRules.ifTrue(inWater, POWDER_SNOW));
        SurfaceRules.RuleSource surface1 = SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.FROZEN_PEAKS}), SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(step, PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PACKED_ICE, -0.5, 0.2), PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.ICE, -0.0625, 0.025), ICE), SurfaceRules.ifTrue(inWater, SNOW_BLOCK)})), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.SNOWY_SLOPES}), SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(step, STONE), powderSnowNoise1, SurfaceRules.ifTrue(inWater, SNOW_BLOCK)})), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.JAGGED_PEAKS}), STONE), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.GROVE}), SurfaceRules.sequence(new SurfaceRules.RuleSource[]{powderSnowNoise1, DIRT})), stoneNoiseInStonyAreas, SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.WINDSWEPT_SAVANNA}), SurfaceRules.ifTrue(surfaceNoiseAbove(1.75), STONE)), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.WINDSWEPT_GRAVELLY_HILLS}), SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(surfaceNoiseAbove(2.0), replaceCeilingGravelWithStone), SurfaceRules.ifTrue(surfaceNoiseAbove(1.0), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-1.0), DIRT), replaceCeilingGravelWithStone})), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.MANGROVE_SWAMP}), MUD), DIRT});
        SurfaceRules.RuleSource surface2 = SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.FROZEN_PEAKS}), SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(step, PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PACKED_ICE, 0.0, 0.2), PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.ICE, 0.0, 0.025), ICE), SurfaceRules.ifTrue(inWater, SNOW_BLOCK)})), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.SNOWY_SLOPES}), SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(step, STONE), powderSnowNoise2, SurfaceRules.ifTrue(inWater, SNOW_BLOCK)})), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.JAGGED_PEAKS}), SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(step, STONE), SurfaceRules.ifTrue(inWater, SNOW_BLOCK)})), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.GROVE}), SurfaceRules.sequence(new SurfaceRules.RuleSource[]{powderSnowNoise2, SurfaceRules.ifTrue(inWater, SNOW_BLOCK)})), stoneNoiseInStonyAreas, SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.WINDSWEPT_SAVANNA}), SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(surfaceNoiseAbove(1.75), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5), COARSE_DIRT)})), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.WINDSWEPT_GRAVELLY_HILLS}), SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(surfaceNoiseAbove(2.0), replaceCeilingGravelWithStone), SurfaceRules.ifTrue(surfaceNoiseAbove(1.0), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-1.0), basicGrass), replaceCeilingGravelWithStone})), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA}), SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(surfaceNoiseAbove(1.75), COARSE_DIRT), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95), PODZOL)})), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.ICE_SPIKES}), SurfaceRules.ifTrue(inWater, SNOW_BLOCK)), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.MANGROVE_SWAMP}), MUD), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.MUSHROOM_FIELDS}), MYCELIUM), basicGrass});
        SurfaceRules.ConditionSource surfaceNoise1 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.909, -0.5454);
        SurfaceRules.ConditionSource surfaceNoise2 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.1818, 0.1818);
        SurfaceRules.ConditionSource surfaceNoise3 = SurfaceRules.noiseCondition(Noises.SURFACE, 0.5454, 0.909);
        SurfaceRules.RuleSource surface3 = SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.WOODED_BADLANDS}), SurfaceRules.ifTrue(y97, SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(surfaceNoise1, COARSE_DIRT), SurfaceRules.ifTrue(surfaceNoise2, COARSE_DIRT), SurfaceRules.ifTrue(surfaceNoise3, COARSE_DIRT), basicGrass}))), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.SWAMP}), SurfaceRules.ifTrue(y62, SurfaceRules.ifTrue(SurfaceRules.not(y63Multi), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0), WATER)))), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.MANGROVE_SWAMP}), SurfaceRules.ifTrue(y60, SurfaceRules.ifTrue(SurfaceRules.not(y63Multi), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0), WATER))))})), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.BADLANDS, Biomes.ERODED_BADLANDS, Biomes.WOODED_BADLANDS}), SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(y256, ORANGE_TERRACOTTA), SurfaceRules.ifTrue(y75, SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(surfaceNoise1, TERRACOTTA), SurfaceRules.ifTrue(surfaceNoise2, TERRACOTTA), SurfaceRules.ifTrue(surfaceNoise3, TERRACOTTA), SurfaceRules.bandlands()})), SurfaceRules.ifTrue(belowWater, SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, RED_SANDSTONE), RED_SAND})), SurfaceRules.ifTrue(SurfaceRules.not(hole), ORANGE_TERRACOTTA), SurfaceRules.ifTrue(aroundWater, WHITE_TERRACOTTA), replaceCeilingGravelWithStone})), SurfaceRules.ifTrue(y63, SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(y63Multi, SurfaceRules.ifTrue(SurfaceRules.not(y75), ORANGE_TERRACOTTA)), SurfaceRules.bandlands()})), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.ifTrue(aroundWater, WHITE_TERRACOTTA))})), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(belowWater, SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(isFrozenOcean, SurfaceRules.ifTrue(hole, SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(inWater, AIR), SurfaceRules.ifTrue(SurfaceRules.temperature(), ICE), WATER}))), surface2}))), SurfaceRules.ifTrue(aroundWater, SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(isFrozenOcean, SurfaceRules.ifTrue(hole, WATER))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, surface1), SurfaceRules.ifTrue(isWarmOceanOrBeach, SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SANDSTONE)), SurfaceRules.ifTrue(isDesert, SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SANDSTONE))})), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.FROZEN_PEAKS, Biomes.JAGGED_PEAKS}), STONE), SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{Biomes.WARM_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN}), replaceCeilingSandWithSandstone), replaceCeilingGravelWithStone}))});
        ImmutableList.Builder<SurfaceRules.RuleSource> surfaceRuleSource = ImmutableList.builder();
        surfaceRuleSource.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));
        surfaceRuleSource.add(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), surface3));
        surfaceRuleSource.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), DEEPSLATE));
        return SurfaceRules.sequence((SurfaceRules.RuleSource[]) surfaceRuleSource.build().toArray(($$0x) -> {
            return new SurfaceRules.RuleSource[$$0x];
        }));
    }

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double noise) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, noise / 8.25, Double.MAX_VALUE);
    }
}
