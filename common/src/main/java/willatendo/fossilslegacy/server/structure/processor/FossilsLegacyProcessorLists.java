package willatendo.fossilslegacy.server.structure.processor;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.rule.blockentity.AppendLoot;
import willatendo.fossilslegacy.server.item.FossilsLegacyLootTables;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public class FossilsLegacyProcessorLists {
    public static final ResourceKey<StructureProcessorList> HOLES = FossilsLegacyProcessorLists.createKey("holes");
    public static final ResourceKey<StructureProcessorList> MACHU_PICCHU_HOUSE_DEGRADATION = FossilsLegacyProcessorLists.createKey("machu_picchu_house_degradation");
    public static final ResourceKey<StructureProcessorList> MACHU_PICCHU_ROAD = FossilsLegacyProcessorLists.createKey("machu_picchu_road");
    public static final ResourceKey<StructureProcessorList> MAYAN_TEMPLE_DEGRADATION = FossilsLegacyProcessorLists.createKey("mayan_temple_degradation");
    public static final ResourceKey<StructureProcessorList> MOAI_DEGRADATION = FossilsLegacyProcessorLists.createKey("moai_degradation");

    private static ResourceKey<StructureProcessorList> createKey(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, FossilsLegacyUtils.resource(name));
    }

    private static void register(BootstrapContext<StructureProcessorList> bootstrapContext, ResourceKey<StructureProcessorList> resourceKey, List<StructureProcessor> structureProcessors) {
        bootstrapContext.register(resourceKey, new StructureProcessorList(structureProcessors));
    }

    public static void bootstrap(BootstrapContext<StructureProcessorList> bootstrapContext) {
        FossilsLegacyProcessorLists.register(bootstrapContext, HOLES, ImmutableList.of(new HolesProcessor(Blocks.AIR.defaultBlockState())));
        FossilsLegacyProcessorLists.register(bootstrapContext, MACHU_PICCHU_HOUSE_DEGRADATION, ImmutableList.of(new RuleProcessor(ImmutableList.of(new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICKS, 0.1F), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_STONE_BRICKS.defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICKS, 0.05F), AlwaysTrueTest.INSTANCE, Blocks.CRACKED_STONE_BRICKS.defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.COBBLESTONE, 0.5F), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.defaultBlockState())))));
        FossilsLegacyProcessorLists.register(bootstrapContext, MACHU_PICCHU_ROAD, ImmutableList.of(new RuleProcessor(ImmutableList.of(new ProcessorRule(new RandomBlockMatchTest(Blocks.SMOOTH_STONE, 0.1F), AlwaysTrueTest.INSTANCE, Blocks.GRAVEL.defaultBlockState()))), new CappedProcessor(new RuleProcessor(List.of(new ProcessorRule(new RandomBlockMatchTest(Blocks.SMOOTH_STONE, 0.05F), AlwaysTrueTest.INSTANCE, PosAlwaysTrueTest.INSTANCE, Blocks.SUSPICIOUS_GRAVEL.defaultBlockState(), new AppendLoot(FossilsLegacyLootTables.INCA_LOOT)))), ConstantInt.of(1))));
        FossilsLegacyProcessorLists.register(bootstrapContext, MAYAN_TEMPLE_DEGRADATION, ImmutableList.of(new RuleProcessor(ImmutableList.of(new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICKS, 0.1F), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_STONE_BRICKS.defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICKS, 0.05F), AlwaysTrueTest.INSTANCE, Blocks.CRACKED_STONE_BRICKS.defaultBlockState())))));
        FossilsLegacyProcessorLists.register(bootstrapContext, MOAI_DEGRADATION, ImmutableList.of(new RuleProcessor(ImmutableList.of(new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICKS, 0.2F), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_STONE_BRICKS.defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICKS, 0.1F), AlwaysTrueTest.INSTANCE, Blocks.CRACKED_STONE_BRICKS.defaultBlockState())))));
    }
}
