package willatendo.fossilslegacy.server.structure.processor;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import willatendo.fossilslegacy.server.structure.processor.rule.RandomBlockTest;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public class FossilsLegacyProcessorLists {
    public static final ResourceKey<StructureProcessorList> HOLES = FossilsLegacyProcessorLists.createKey("holes");
    public static final ResourceKey<StructureProcessorList> MAYAN_TEMPLE_DEGRADATION = FossilsLegacyProcessorLists.createKey("mayan_temple_degradation");
    public static final ResourceKey<StructureProcessorList> MOAI_DEGRADATION = FossilsLegacyProcessorLists.createKey("moai_degradation");

    private static ResourceKey<StructureProcessorList> createKey(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, FossilsLegacyUtils.resource(name));
    }

    private static void register(BootstrapContext<StructureProcessorList> bootstrapContext, ResourceKey<StructureProcessorList> resourceKey, List<StructureProcessor> structureProcessors) {
        bootstrapContext.register(resourceKey, new StructureProcessorList(structureProcessors));
    }

    public static void bootstrap(BootstrapContext<StructureProcessorList> bootstrapContext) {
        FossilsLegacyProcessorLists.register(bootstrapContext, HOLES, ImmutableList.of(new HolesProcessor(ImmutableList.of(new ProcessorRule(new RandomBlockTest(0.1F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState())))));
        FossilsLegacyProcessorLists.register(bootstrapContext, MAYAN_TEMPLE_DEGRADATION, ImmutableList.of(new RuleProcessor(ImmutableList.of(new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICKS, 0.1F), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_STONE_BRICKS.defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICKS, 0.05F), AlwaysTrueTest.INSTANCE, Blocks.CRACKED_STONE_BRICKS.defaultBlockState())))));
        FossilsLegacyProcessorLists.register(bootstrapContext, MOAI_DEGRADATION, ImmutableList.of(new RuleProcessor(ImmutableList.of(new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICKS, 0.2F), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_STONE_BRICKS.defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICKS, 0.1F), AlwaysTrueTest.INSTANCE, Blocks.CRACKED_STONE_BRICKS.defaultBlockState())))));
    }
}
