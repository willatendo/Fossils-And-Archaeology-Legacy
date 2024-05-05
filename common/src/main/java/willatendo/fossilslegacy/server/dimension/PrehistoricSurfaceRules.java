package willatendo.fossilslegacy.server.dimension;

import com.google.common.collect.ImmutableList;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import willatendo.fossilslegacy.server.biomes.FossilsLegacyBiomes;

public class PrehistoricSurfaceRules {
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);

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
        SurfaceRules.RuleSource basicGrass = SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(inWater, GRASS_BLOCK), DIRT});
        SurfaceRules.RuleSource replaceCeilingSandWithSandstone = SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE), SAND});
        SurfaceRules.RuleSource replaceCeilingGravelWithStone = SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE), GRAVEL});
        SurfaceRules.ConditionSource isWarmOceanOrBeach = SurfaceRules.isBiome(new ResourceKey[]{FossilsLegacyBiomes.PREHISTORIC_BEACH});
        SurfaceRules.ConditionSource isDesert = SurfaceRules.isBiome(new ResourceKey[]{FossilsLegacyBiomes.PREHISTORIC_DESERT});
        SurfaceRules.RuleSource stoneNoiseInStonyAreas = SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(isWarmOceanOrBeach, replaceCeilingSandWithSandstone), SurfaceRules.ifTrue(isDesert, replaceCeilingSandWithSandstone)});
        SurfaceRules.RuleSource surface1 = SurfaceRules.sequence(new SurfaceRules.RuleSource[]{stoneNoiseInStonyAreas, DIRT});
        SurfaceRules.RuleSource surface2 = SurfaceRules.sequence(new SurfaceRules.RuleSource[]{stoneNoiseInStonyAreas, basicGrass});
        SurfaceRules.RuleSource surface3 = SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.isBiome(new ResourceKey[]{FossilsLegacyBiomes.PREHISTORIC_SWAMP}), SurfaceRules.ifTrue(y62, SurfaceRules.ifTrue(SurfaceRules.not(y63Multi), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0), WATER))))})), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(belowWater, SurfaceRules.sequence(new SurfaceRules.RuleSource[]{surface2}))), SurfaceRules.ifTrue(aroundWater, SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, surface1), SurfaceRules.ifTrue(isWarmOceanOrBeach, SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SANDSTONE)), SurfaceRules.ifTrue(isDesert, SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SANDSTONE))})), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(new SurfaceRules.RuleSource[]{replaceCeilingSandWithSandstone, replaceCeilingGravelWithStone}))});
        ImmutableList.Builder<SurfaceRules.RuleSource> surfaceRuleSource = ImmutableList.builder();
        surfaceRuleSource.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));
        surfaceRuleSource.add(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), surface3));
        surfaceRuleSource.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), DEEPSLATE));
        return SurfaceRules.sequence((SurfaceRules.RuleSource[]) surfaceRuleSource.build().toArray((i) -> {
            return new SurfaceRules.RuleSource[i];
        }));
    }

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double noise) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, noise / 8.25, Double.MAX_VALUE);
    }
}
