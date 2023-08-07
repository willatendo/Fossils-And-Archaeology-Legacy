package willatendo.fossilslegacy.server.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FossilsLegacyUtils.ID);

	public static final RegistryObject<BlockEntityType<AnalyzerBlockEntity>> ANALYZER = BLOCK_ENTITY_TYPES.register("analyzer", () -> BlockEntityType.Builder.<AnalyzerBlockEntity>of(AnalyzerBlockEntity::new, FossilsLegacyBlocks.ANALYZER.get()).build(null));
	public static final RegistryObject<BlockEntityType<CultivatorBlockEntity>> CULTIVATOR = BLOCK_ENTITY_TYPES.register("cultivator", () -> BlockEntityType.Builder.<CultivatorBlockEntity>of(CultivatorBlockEntity::new, FossilsLegacyBlocks.CULTIVATOR.get()).build(null));
	public static final RegistryObject<BlockEntityType<ArchaeologyWorkbenchBlockEntity>> ARCHAEOLOGY_WORKBENCH = BLOCK_ENTITY_TYPES.register("archaeology_workbench", () -> BlockEntityType.Builder.<ArchaeologyWorkbenchBlockEntity>of(ArchaeologyWorkbenchBlockEntity::new, FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get()).build(null));
	public static final RegistryObject<BlockEntityType<FeederBlockEntity>> FEEDER = BLOCK_ENTITY_TYPES.register("feeder", () -> BlockEntityType.Builder.<FeederBlockEntity>of(FeederBlockEntity::new, FossilsLegacyBlocks.FEEDER.get()).build(null));
}
