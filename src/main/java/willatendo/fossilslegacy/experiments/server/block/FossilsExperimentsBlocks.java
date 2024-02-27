package willatendo.fossilslegacy.experiments.server.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.simplelibrary.server.registry.SimpleHolder;

public class FossilsExperimentsBlocks {
	public static final SimpleHolder<TimeMachineBlock> TIME_MACHINE = FossilsLegacyBlocks.BLOCKS.register("time_machine", () -> new TimeMachineBlock(BlockBehaviour.Properties.of().strength(0.3F).lightLevel(blockState -> 14).sound(SoundType.GLASS)));

	public static void init() {
	}
}
