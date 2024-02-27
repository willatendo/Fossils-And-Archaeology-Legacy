package willatendo.fossilslegacy.server.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import willatendo.fossilslegacy.experiments.server.block.FossilsExperimentsBlocks;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.FabricRegister;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class FossilsLegacyBlocks {
	public static final SimpleRegistry<Block> BLOCKS = SimpleRegistry.create(Registries.BLOCK, FossilsLegacyUtils.ID);

	public static final SimpleHolder<Block> FOSSIL_ORE = BLOCKS.register("fossil_ore", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final SimpleHolder<Block> DEEPSLATE_FOSSIL_ORE = BLOCKS.register("deepslate_fossil_ore", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
	public static final SimpleHolder<SkullBlock> SKULL_BLOCK = BLOCKS.register("skull_block", () -> new SkullBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.XYLOPHONE).strength(1.0F)));
	public static final SimpleHolder<SkullBlock> SKULL_LANTURN_BLOCK = BLOCKS.register("skull_lanturn_block", () -> new SkullBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.XYLOPHONE).strength(1.0F).lightLevel(blockState -> 15)));
	public static final SimpleHolder<AnalyzerBlock> ANALYZER = BLOCKS.register("analyzer", () -> new AnalyzerBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final SimpleHolder<CultivatorBlock> CULTIVATOR = BLOCKS.register("cultivator", () -> new CultivatorBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(SimpleUtils::never).isRedstoneConductor(SimpleUtils::never).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).lightLevel(blockState -> 13)));
	public static final SimpleHolder<ArchaeologyWorkbenchBlock> ARCHAEOLOGY_WORKBENCH = BLOCKS.register("archaeology_workbench", () -> new ArchaeologyWorkbenchBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final SimpleHolder<JurassicFernBlock> JURASSIC_FERN = BLOCKS.register("jurassic_fern", () -> new JurassicFernBlock(BlockBehaviour.Properties.of().noCollission().instabreak().randomTicks().sound(SoundType.GRASS)));
	public static final SimpleHolder<DrumBlock> DRUM = BLOCKS.register("drum", () -> new DrumBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final SimpleHolder<FeederBlock> FEEDER = BLOCKS.register("feeder", () -> new FeederBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final SimpleHolder<PermafrostBlock> PERMAFROST = BLOCKS.register("permafrost", () -> new PermafrostBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.CHIME).strength(0.5F).randomTicks().noOcclusion().sound(SoundType.GRAVEL)));
	public static final SimpleHolder<IcedStoneBlock> ICED_STONE = BLOCKS.register("iced_stone", () -> new IcedStoneBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.CHIME).requiresCorrectToolForDrops().strength(1.5F, 6.0F).randomTicks().noOcclusion()));
	public static final SimpleHolder<AxolotlspawnBlock> AXOLOTLSPAWN = BLOCKS.register("axolotlspawn", () -> new AxolotlspawnBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WATER).instabreak().noOcclusion().noCollission().sound(SoundType.FROGSPAWN).pushReaction(PushReaction.DESTROY)));

	public static void init() {
		FossilsExperimentsBlocks.init();

		FabricRegister.register(BLOCKS);
	}
}
