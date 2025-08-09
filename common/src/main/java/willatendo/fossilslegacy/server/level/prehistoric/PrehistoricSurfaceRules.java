package willatendo.fossilslegacy.server.level.prehistoric;

import com.google.common.collect.ImmutableList;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import willatendo.fossilslegacy.server.biome.FABiomes;

public class PrehistoricSurfaceRules {
    private static final SurfaceRules.RuleSource BEDROCK = PrehistoricSurfaceRules.makeStateRule(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource STONE = PrehistoricSurfaceRules.makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource DEEPSLATE = PrehistoricSurfaceRules.makeStateRule(Blocks.DEEPSLATE);
    private static final SurfaceRules.RuleSource DIRT = PrehistoricSurfaceRules.makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource PODZOL = PrehistoricSurfaceRules.makeStateRule(Blocks.PODZOL);
    private static final SurfaceRules.RuleSource GRAVEL = PrehistoricSurfaceRules.makeStateRule(Blocks.GRAVEL);
    private static final SurfaceRules.RuleSource RED_SAND = PrehistoricSurfaceRules.makeStateRule(Blocks.RED_SAND);
    private static final SurfaceRules.RuleSource RED_SANDSTONE = PrehistoricSurfaceRules.makeStateRule(Blocks.RED_SANDSTONE);
    private static final SurfaceRules.RuleSource WHITE_TERRACOTTA = PrehistoricSurfaceRules.makeStateRule(Blocks.WHITE_TERRACOTTA);
    private static final SurfaceRules.RuleSource ORANGE_TERRACOTTA = PrehistoricSurfaceRules.makeStateRule(Blocks.ORANGE_TERRACOTTA);
    private static final SurfaceRules.RuleSource TERRACOTTA = PrehistoricSurfaceRules.makeStateRule(Blocks.TERRACOTTA);
    private static final SurfaceRules.RuleSource SAND = PrehistoricSurfaceRules.makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource SANDSTONE = PrehistoricSurfaceRules.makeStateRule(Blocks.SANDSTONE);
    private static final SurfaceRules.RuleSource WATER = PrehistoricSurfaceRules.makeStateRule(Blocks.WATER);

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    public static SurfaceRules.RuleSource prehistoric() {
        SurfaceRules.ConditionSource y256 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(256), 0);
        SurfaceRules.ConditionSource y74 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(74), 1);
        SurfaceRules.ConditionSource y62 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
        SurfaceRules.ConditionSource y63Multi = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
        SurfaceRules.ConditionSource belowWater = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.ConditionSource inWater = SurfaceRules.waterBlockCheck(0, 0);
        SurfaceRules.ConditionSource aroundWater = SurfaceRules.waterStartCheck(-6, -1);
        SurfaceRules.ConditionSource hole = SurfaceRules.hole();
        SurfaceRules.RuleSource basicPodzol = SurfaceRules.sequence(SurfaceRules.ifTrue(inWater, PODZOL), DIRT);
        SurfaceRules.RuleSource replaceCeilingSandWithSandstone = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE), SAND);
        SurfaceRules.RuleSource replaceCeilingRedSandWithRedSandstone = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, RED_SANDSTONE), RED_SAND);
        SurfaceRules.RuleSource replaceCeilingGravelWithStone = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE), GRAVEL);
        SurfaceRules.ConditionSource isWarmOceanOrBeach = SurfaceRules.isBiome(FABiomes.PREHISTORIC_BEACH);
        SurfaceRules.ConditionSource isDjadochtaFormation = SurfaceRules.isBiome(FABiomes.DJADOCHTA_FORMATION);
        SurfaceRules.ConditionSource isFlamingCliffs = SurfaceRules.isBiome(FABiomes.FLAMING_CLIFFS);
        SurfaceRules.RuleSource stoneNoiseInStonyAreas = SurfaceRules.sequence(SurfaceRules.ifTrue(isWarmOceanOrBeach, replaceCeilingSandWithSandstone), SurfaceRules.ifTrue(isDjadochtaFormation, replaceCeilingSandWithSandstone), SurfaceRules.ifTrue(isFlamingCliffs, replaceCeilingRedSandWithRedSandstone));
        SurfaceRules.RuleSource surface1 = SurfaceRules.sequence(stoneNoiseInStonyAreas, DIRT);
        SurfaceRules.RuleSource surface2 = SurfaceRules.sequence(stoneNoiseInStonyAreas, basicPodzol);
        SurfaceRules.ConditionSource band1 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.909, -0.5454);
        SurfaceRules.ConditionSource band2 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.1818, 0.1818);
        SurfaceRules.ConditionSource band3 = SurfaceRules.noiseCondition(Noises.SURFACE, 0.5454, 0.909);
        SurfaceRules.RuleSource flamingCliffs = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(FABiomes.FLAMING_CLIFFS), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(y256, ORANGE_TERRACOTTA), SurfaceRules.ifTrue(y74, SurfaceRules.sequence(SurfaceRules.ifTrue(band1, TERRACOTTA), SurfaceRules.ifTrue(band2, TERRACOTTA), SurfaceRules.ifTrue(band3, TERRACOTTA), SurfaceRules.bandlands())), SurfaceRules.ifTrue(belowWater, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, RED_SANDSTONE), RED_SAND)), SurfaceRules.ifTrue(SurfaceRules.not(hole), ORANGE_TERRACOTTA), SurfaceRules.ifTrue(aroundWater, WHITE_TERRACOTTA), replaceCeilingGravelWithStone)), SurfaceRules.ifTrue(y63Multi, SurfaceRules.sequence(SurfaceRules.ifTrue(y63Multi, SurfaceRules.ifTrue(SurfaceRules.not(y74), ORANGE_TERRACOTTA)), SurfaceRules.bandlands())), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.ifTrue(aroundWater, WHITE_TERRACOTTA)))))));
        SurfaceRules.RuleSource surface3 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(flamingCliffs, SurfaceRules.ifTrue(SurfaceRules.isBiome(FABiomes.PREHISTORIC_SWAMP), SurfaceRules.ifTrue(y62, SurfaceRules.ifTrue(SurfaceRules.not(y63Multi), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0), WATER)))))), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(belowWater, SurfaceRules.sequence(surface2))), SurfaceRules.ifTrue(aroundWater, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, surface1), SurfaceRules.ifTrue(isWarmOceanOrBeach, SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SANDSTONE)), SurfaceRules.ifTrue(isDjadochtaFormation, SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SANDSTONE)), SurfaceRules.ifTrue(isFlamingCliffs, SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, RED_SANDSTONE)))), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(replaceCeilingSandWithSandstone, replaceCeilingGravelWithStone)));
        ImmutableList.Builder<SurfaceRules.RuleSource> surfaceRuleSource = ImmutableList.builder();
        surfaceRuleSource.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));
        surfaceRuleSource.add(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), surface3));
        surfaceRuleSource.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), DEEPSLATE));
        return SurfaceRules.sequence(surfaceRuleSource.build().toArray(SurfaceRules.RuleSource[]::new));
    }
}
