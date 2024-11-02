package willatendo.fossilslegacy.server.structure.processor;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.AlwaysTrueTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProcessorRule;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import willatendo.fossilslegacy.server.structure.processor.rule.RandomBlockTest;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public class FossilsLegacyProcessorLists {
    public static final ResourceKey<StructureProcessorList> HOLES = FossilsLegacyProcessorLists.createKey("holes");

    private static ResourceKey<StructureProcessorList> createKey(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, FossilsLegacyUtils.resource(name));
    }

    private static void register(BootstrapContext<StructureProcessorList> bootstrapContext, ResourceKey<StructureProcessorList> resourceKey, List<StructureProcessor> structureProcessors) {
        bootstrapContext.register(resourceKey, new StructureProcessorList(structureProcessors));
    }

    public static void bootstrap(BootstrapContext<StructureProcessorList> bootstrapContext) {
        FossilsLegacyProcessorLists.register(bootstrapContext, HOLES, ImmutableList.of(new HolesProcessor(ImmutableList.of(new ProcessorRule(new RandomBlockTest(0.1F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState())))));
    }
}
