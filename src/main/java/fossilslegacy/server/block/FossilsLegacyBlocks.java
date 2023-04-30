package fossilslegacy.server.block;

import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FossilsLegacyBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FossilsLegacyUtils.ID);

	public static final RegistryObject<Block> FOSSIL_ORE = BLOCKS.register("fossil_ore", () -> new FossilOreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
	public static final RegistryObject<Block> SKULL_BLOCK = BLOCKS.register("skull_block", () -> new SkullBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.0F)));
	public static final RegistryObject<Block> SKULL_LANTURN_BLOCK = BLOCKS.register("skull_lanturn_block", () -> new SkullBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.0F).lightLevel(blockState -> 15)));
	public static final RegistryObject<Block> ANALYZER = BLOCKS.register("analyzer", () -> new AnalyzerBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryObject<Block> CULTIVATOR = BLOCKS.register("cultivator", () -> new CultivatorBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(FossilsLegacyBlocks::never).isRedstoneConductor(FossilsLegacyBlocks::never).isSuffocating(FossilsLegacyBlocks::never).isViewBlocking(FossilsLegacyBlocks::never).lightLevel(blockState -> 13)));
	public static final RegistryObject<Block> ARCHAEOLOGY_WORKBENCH = BLOCKS.register("archaeology_workbench", () -> new ArchaeologyWorkbenchBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	// Ferns
	public static final RegistryObject<Block> DRUM = BLOCKS.register("drum", () -> new DrumBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> FEEDER = BLOCKS.register("feeder", () -> new FeederBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryObject<Block> PERMAFROST = BLOCKS.register("permafrost", () -> new PermafrostBlock(BlockBehaviour.Properties.of(Material.DIRT).strength(0.5F).randomTicks().sound(SoundType.GRAVEL)));
	public static final RegistryObject<Block> ICED_STONE = BLOCKS.register("iced_stone", () -> new IcedStoneBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).randomTicks()));

	private static Boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
		return (boolean) false;
	}

	private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
		return false;
	}
}
