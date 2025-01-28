package willatendo.fossilslegacy.server.structure;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTestType;
import willatendo.fossilslegacy.server.structure.processor.rule.RandomBlockTest;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FARuleTestTypes {
    public static final SimpleRegistry<RuleTestType<?>> RULE_TEST_TYPES = SimpleRegistry.create(Registries.RULE_TEST, FossilsLegacyUtils.ID);
    public static final SimpleHolder<RuleTestType<RandomBlockTest>> RANDOM_BLOCK_TEST = RULE_TEST_TYPES.register("random_block_test", () -> () -> RandomBlockTest.CODEC);
}
