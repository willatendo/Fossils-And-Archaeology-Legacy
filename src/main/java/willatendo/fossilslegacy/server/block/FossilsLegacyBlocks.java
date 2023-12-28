package willatendo.fossilslegacy.server.block;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.RegistryHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class FossilsLegacyBlocks {
	public static final SimpleRegistry<Block> BLOCKS = SimpleRegistry.create(BuiltInRegistries.BLOCK, FossilsLegacyUtils.ID);

	public static final RegistryHolder<Block> FOSSIL_ORE = BLOCKS.register("fossil_ore", () -> new FossilOreBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryHolder<Block> SKULL_BLOCK = BLOCKS.register("skull_block", () -> new SkullBlock(BlockBehaviour.Properties.of().strength(1.0F)));
	public static final RegistryHolder<Block> SKULL_LANTURN_BLOCK = BLOCKS.register("skull_lanturn_block", () -> new SkullBlock(BlockBehaviour.Properties.of().strength(1.0F).lightLevel(blockState -> 15)));
	public static final RegistryHolder<Block> ANALYZER = BLOCKS.register("analyzer", () -> new AnalyzerBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryHolder<Block> CULTIVATOR = BLOCKS.register("cultivator", () -> new CultivatorBlock(BlockBehaviour.Properties.of().strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(SimpleUtils::never).isRedstoneConductor(SimpleUtils::never).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).lightLevel(blockState -> 13)));
	public static final RegistryHolder<Block> ARCHAEOLOGY_WORKBENCH = BLOCKS.register("archaeology_workbench", () -> new ArchaeologyWorkbenchBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryHolder<Block> JURASSIC_FERN = BLOCKS.register("jurassic_fern", () -> new JurassicFernBlock(BlockBehaviour.Properties.of().noCollission().instabreak().randomTicks().sound(SoundType.GRASS)));
	public static final RegistryHolder<Block> DRUM = BLOCKS.register("drum", () -> new DrumBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryHolder<Block> FEEDER = BLOCKS.register("feeder", () -> new FeederBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryHolder<Block> PERMAFROST = BLOCKS.register("permafrost", () -> new PermafrostBlock(BlockBehaviour.Properties.of().strength(0.5F).randomTicks().noOcclusion().sound(SoundType.GRAVEL)));
	public static final RegistryHolder<Block> ICED_STONE = BLOCKS.register("iced_stone", () -> new IcedStoneBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).randomTicks()));

	public static void init() {
	}
}
