package willatendo.fossilslegacy.server.structure.processor.rule;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTestType;

public class RandomBlockTest extends RuleTest {
    public static final MapCodec<RandomBlockTest> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.FLOAT.fieldOf("probability").forGetter(randomBlockTest -> randomBlockTest.probability)).apply(instance, RandomBlockTest::new));
    private final float probability;

    public RandomBlockTest(float probability) {
        this.probability = probability;
    }

    @Override
    public boolean test(BlockState blockState, RandomSource randomSource) {
        return randomSource.nextFloat() < this.probability;
    }

    @Override
    protected RuleTestType<?> getType() {
        return FossilsLegacyRuleTestTypes.RANDOM_BLOCK_TEST.get();
    }
}
