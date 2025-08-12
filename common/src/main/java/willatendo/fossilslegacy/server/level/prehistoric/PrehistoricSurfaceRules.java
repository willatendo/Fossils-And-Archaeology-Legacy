package willatendo.fossilslegacy.server.level.prehistoric;

import com.google.common.collect.ImmutableList;
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
    private static final SurfaceRules.RuleSource COARSE_DIRT = PrehistoricSurfaceRules.makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource SAND = PrehistoricSurfaceRules.makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource SANDSTONE = PrehistoricSurfaceRules.makeStateRule(Blocks.SANDSTONE);
    private static final SurfaceRules.RuleSource WATER = PrehistoricSurfaceRules.makeStateRule(Blocks.WATER);

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    public static SurfaceRules.RuleSource prehistoric() {
        SurfaceRules.ConditionSource y62 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
        SurfaceRules.ConditionSource y63Multi = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
        SurfaceRules.ConditionSource belowWater = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.ConditionSource notInWater = SurfaceRules.waterBlockCheck(0, 0);
        SurfaceRules.ConditionSource aroundWater = SurfaceRules.waterStartCheck(-6, -1);
        SurfaceRules.RuleSource noPodzolInWater = SurfaceRules.sequence(SurfaceRules.ifTrue(notInWater, PODZOL), DIRT);
        SurfaceRules.RuleSource noFallingSand = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE), SAND);
        SurfaceRules.RuleSource noFallingRedSand = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, RED_SANDSTONE), RED_SAND);
        SurfaceRules.RuleSource noFallingGravel = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE), GRAVEL);
        SurfaceRules.ConditionSource isSandy = SurfaceRules.isBiome(FABiomes.WARM_PREHISTORIC_BEACH, FABiomes.WARM_PREHISTORIC_RIVER);
        SurfaceRules.ConditionSource isColdDesert = SurfaceRules.isBiome(FABiomes.COLD_DESERT);
        SurfaceRules.ConditionSource isRedDesert = SurfaceRules.isBiome(FABiomes.RED_DESERT);
        SurfaceRules.ConditionSource isGravelly = SurfaceRules.isBiome(FABiomes.COLD_PREHISTORIC_RIVER, FABiomes.COLD_PREHISTORIC_BEACH);
        SurfaceRules.RuleSource stoneNoiseInStonyAreas = SurfaceRules.sequence(SurfaceRules.ifTrue(isSandy, noFallingSand), SurfaceRules.ifTrue(isGravelly, noFallingGravel), SurfaceRules.ifTrue(SurfaceRules.isBiome(FABiomes.PREHISTORIC_BEACH), COARSE_DIRT), SurfaceRules.ifTrue(isColdDesert, SurfaceRules.sequence(SurfaceRules.ifTrue(PrehistoricSurfaceRules.surfaceNoiseAbove(0.5), COARSE_DIRT), noFallingSand)), SurfaceRules.ifTrue(isRedDesert, SurfaceRules.sequence(SurfaceRules.ifTrue(PrehistoricSurfaceRules.surfaceNoiseAbove(0.5), SAND), noFallingRedSand)));
        SurfaceRules.RuleSource addDirt = SurfaceRules.sequence(stoneNoiseInStonyAreas, DIRT);
        SurfaceRules.RuleSource addPodzol = SurfaceRules.sequence(stoneNoiseInStonyAreas, noPodzolInWater);
        SurfaceRules.RuleSource swamp = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(FABiomes.PREHISTORIC_SWAMP), SurfaceRules.ifTrue(y62, SurfaceRules.ifTrue(SurfaceRules.not(y63Multi), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0), WATER)))));
        SurfaceRules.RuleSource sandyBeach = SurfaceRules.ifTrue(isSandy, SurfaceRules.ifTrue(SurfaceRules.not(PrehistoricSurfaceRules.surfaceNoiseAbove(0.5)), SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SANDSTONE)));
        SurfaceRules.RuleSource coldDesert = SurfaceRules.ifTrue(isColdDesert, SurfaceRules.ifTrue(SurfaceRules.not(PrehistoricSurfaceRules.surfaceNoiseAbove(0.5)), SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SANDSTONE)));
        SurfaceRules.RuleSource redDesert = SurfaceRules.ifTrue(isRedDesert, SurfaceRules.ifTrue(SurfaceRules.not(PrehistoricSurfaceRules.surfaceNoiseAbove(0.5)), SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, RED_SANDSTONE)));
        SurfaceRules.RuleSource surface = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(swamp)), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(belowWater, SurfaceRules.sequence(addPodzol))), SurfaceRules.ifTrue(aroundWater, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, addDirt), sandyBeach, coldDesert, redDesert)), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(noFallingSand, noFallingGravel)));
        ImmutableList.Builder<SurfaceRules.RuleSource> surfaceRuleSource = ImmutableList.builder();
        surfaceRuleSource.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));
        surfaceRuleSource.add(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), surface));
        surfaceRuleSource.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), DEEPSLATE));
        return SurfaceRules.sequence(surfaceRuleSource.build().toArray(SurfaceRules.RuleSource[]::new));
    }

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double value) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, value / 8.25, Double.MAX_VALUE);
    }
}
