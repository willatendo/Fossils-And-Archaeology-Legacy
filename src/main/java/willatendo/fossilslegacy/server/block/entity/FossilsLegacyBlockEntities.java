package willatendo.fossilslegacy.server.block.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.FabricRegister;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyBlockEntities {
	public static final SimpleRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPES = SimpleRegistry.create(Registries.BLOCK_ENTITY_TYPE, FossilsLegacyUtils.ID);

	public static final SimpleHolder<BlockEntityType<AnalyzerBlockEntity>> ANALYZER = BLOCK_ENTITY_TYPES.register("analyzer", () -> BlockEntityType.Builder.<AnalyzerBlockEntity>of(AnalyzerBlockEntity::new, FossilsLegacyBlocks.ANALYZER.get()).build(null));
	public static final SimpleHolder<BlockEntityType<CultivatorBlockEntity>> CULTIVATOR = BLOCK_ENTITY_TYPES.register("cultivator", () -> BlockEntityType.Builder.<CultivatorBlockEntity>of(CultivatorBlockEntity::new, FossilsLegacyBlocks.CULTIVATOR.get()).build(null));
	public static final SimpleHolder<BlockEntityType<ArchaeologyWorkbenchBlockEntity>> ARCHAEOLOGY_WORKBENCH = BLOCK_ENTITY_TYPES.register("archaeology_workbench", () -> BlockEntityType.Builder.<ArchaeologyWorkbenchBlockEntity>of(ArchaeologyWorkbenchBlockEntity::new, FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get()).build(null));
	public static final SimpleHolder<BlockEntityType<FeederBlockEntity>> FEEDER = BLOCK_ENTITY_TYPES.register("feeder", () -> BlockEntityType.Builder.<FeederBlockEntity>of(FeederBlockEntity::new, FossilsLegacyBlocks.FEEDER.get()).build(null));

	public static void init() {
		FabricRegister.register(BLOCK_ENTITY_TYPES);
	}
}
