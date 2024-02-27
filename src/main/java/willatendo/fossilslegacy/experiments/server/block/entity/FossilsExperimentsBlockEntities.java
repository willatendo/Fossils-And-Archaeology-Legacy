package willatendo.fossilslegacy.experiments.server.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import willatendo.fossilslegacy.experiments.server.block.FossilsExperimentsBlocks;
import willatendo.fossilslegacy.server.block.entity.FossilsLegacyBlockEntities;
import willatendo.simplelibrary.server.registry.SimpleHolder;

public class FossilsExperimentsBlockEntities {
	public static final SimpleHolder<BlockEntityType<TimeMachineBlockEntity>> TIME_MACHINE = FossilsLegacyBlockEntities.BLOCK_ENTITY_TYPES.register("time_machine", () -> BlockEntityType.Builder.<TimeMachineBlockEntity>of(TimeMachineBlockEntity::new, FossilsExperimentsBlocks.TIME_MACHINE.get()).build(null));

	public static void init() {
	}
}
