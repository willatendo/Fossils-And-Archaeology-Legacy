package willatendo.fossilslegacy.server.level;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import willatendo.fossilslegacy.server.biome.biomes.IceAgeBiomes;

public final class IceAgeSurfaceRules {
    private static final SurfaceRules.RuleSource BEDROCK = IceAgeSurfaceRules.makeStateRule(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource STONE = IceAgeSurfaceRules.makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource DEEPSLATE = IceAgeSurfaceRules.makeStateRule(Blocks.DEEPSLATE);
    private static final SurfaceRules.RuleSource DIRT = IceAgeSurfaceRules.makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = IceAgeSurfaceRules.makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource GRAVEL = IceAgeSurfaceRules.makeStateRule(Blocks.GRAVEL);
    private static final SurfaceRules.RuleSource SAND = IceAgeSurfaceRules.makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource SANDSTONE = IceAgeSurfaceRules.makeStateRule(Blocks.SANDSTONE);

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    public static SurfaceRules.RuleSource iceAge() {
        SurfaceRules.ConditionSource y62 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
        SurfaceRules.ConditionSource y63Multi = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
        SurfaceRules.ConditionSource belowWater = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.ConditionSource notInWater = SurfaceRules.waterBlockCheck(0, 0);
        SurfaceRules.ConditionSource aroundWater = SurfaceRules.waterStartCheck(-6, -1);
        SurfaceRules.RuleSource noGrassInWater = SurfaceRules.sequence(SurfaceRules.ifTrue(notInWater, GRASS_BLOCK), DIRT);
        SurfaceRules.RuleSource noFallingSand = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE), SAND);
        SurfaceRules.RuleSource noFallingGravel = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE), GRAVEL);
        SurfaceRules.ConditionSource isSandy = SurfaceRules.isBiome(IceAgeBiomes.BEACH);
        SurfaceRules.RuleSource addSand = SurfaceRules.sequence(SurfaceRules.ifTrue(isSandy, noFallingSand));
        SurfaceRules.RuleSource addDirt = SurfaceRules.sequence(addSand, DIRT);
        SurfaceRules.RuleSource addGrass = SurfaceRules.sequence(addSand, noGrassInWater);
        SurfaceRules.RuleSource surface = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(belowWater, SurfaceRules.sequence(addGrass))), SurfaceRules.ifTrue(aroundWater, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, addDirt))), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(noFallingSand, noFallingGravel)));
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
