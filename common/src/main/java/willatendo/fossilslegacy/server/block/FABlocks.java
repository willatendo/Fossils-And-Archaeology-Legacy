package willatendo.fossilslegacy.server.block;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import willatendo.fossilslegacy.server.block.blocks.SkullBlock;
import willatendo.fossilslegacy.server.block.blocks.*;
import willatendo.fossilslegacy.server.block.cauldron.FACauldronInteraction;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.SimpleUtils;

public final class FABlocks {
    public static final SimpleRegistry<Block> BLOCKS = SimpleRegistry.create(Registries.BLOCK, FossilsLegacyUtils.ID);

    public static final SimpleHolder<Block> FOSSIL_ORE = BLOCKS.register("fossil_ore", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
    public static final SimpleHolder<Block> DEEPSLATE_FOSSIL_ORE = BLOCKS.register("deepslate_fossil_ore", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
    public static final SimpleHolder<SkullBlock> SKULL_BLOCK = BLOCKS.register("skull_block", () -> new SkullBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.XYLOPHONE).sound(SoundType.BONE_BLOCK).strength(1.0F)));
    public static final SimpleHolder<GenericSkullBlock> SKULL_LANTERN_BLOCK = BLOCKS.register("skull_lantern_block", () -> new GenericSkullBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.XYLOPHONE).sound(SoundType.BONE_BLOCK).strength(1.0F).lightLevel(blockState -> 15)));
    public static final SimpleHolder<AnalyzerBlock> ANALYZER = BLOCKS.register("analyzer", () -> new AnalyzerBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final SimpleHolder<CultivatorBlock> WHITE_CULTIVATOR = BLOCKS.register("white_cultivator", () -> new CultivatorBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(SimpleUtils::never).isRedstoneConductor(SimpleUtils::never).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).lightLevel(blockState -> 13)));
    public static final SimpleHolder<CultivatorBlock> ORANGE_CULTIVATOR = BLOCKS.register("orange_cultivator", () -> new CultivatorBlock(DyeColor.ORANGE, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(SimpleUtils::never).isRedstoneConductor(SimpleUtils::never).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).lightLevel(blockState -> 13)));
    public static final SimpleHolder<CultivatorBlock> MAGENTA_CULTIVATOR = BLOCKS.register("magenta_cultivator", () -> new CultivatorBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(SimpleUtils::never).isRedstoneConductor(SimpleUtils::never).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).lightLevel(blockState -> 13)));
    public static final SimpleHolder<CultivatorBlock> LIGHT_BLUE_CULTIVATOR = BLOCKS.register("light_blue_cultivator", () -> new CultivatorBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(SimpleUtils::never).isRedstoneConductor(SimpleUtils::never).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).lightLevel(blockState -> 13)));
    public static final SimpleHolder<CultivatorBlock> YELLOW_CULTIVATOR = BLOCKS.register("yellow_cultivator", () -> new CultivatorBlock(DyeColor.YELLOW, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(SimpleUtils::never).isRedstoneConductor(SimpleUtils::never).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).lightLevel(blockState -> 13)));
    public static final SimpleHolder<CultivatorBlock> LIME_CULTIVATOR = BLOCKS.register("lime_cultivator", () -> new CultivatorBlock(DyeColor.LIME, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(SimpleUtils::never).isRedstoneConductor(SimpleUtils::never).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).lightLevel(blockState -> 13)));
    public static final SimpleHolder<CultivatorBlock> PINK_CULTIVATOR = BLOCKS.register("pink_cultivator", () -> new CultivatorBlock(DyeColor.PINK, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(SimpleUtils::never).isRedstoneConductor(SimpleUtils::never).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).lightLevel(blockState -> 13)));
    public static final SimpleHolder<CultivatorBlock> GRAY_CULTIVATOR = BLOCKS.register("gray_cultivator", () -> new CultivatorBlock(DyeColor.GRAY, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(SimpleUtils::never).isRedstoneConductor(SimpleUtils::never).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).lightLevel(blockState -> 13)));
    public static final SimpleHolder<CultivatorBlock> LIGHT_GRAY_CULTIVATOR = BLOCKS.register("light_gray_cultivator", () -> new CultivatorBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(SimpleUtils::never).isRedstoneConductor(SimpleUtils::never).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).lightLevel(blockState -> 13)));
    public static final SimpleHolder<CultivatorBlock> CYAN_CULTIVATOR = BLOCKS.register("cyan_cultivator", () -> new CultivatorBlock(DyeColor.CYAN, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(SimpleUtils::never).isRedstoneConductor(SimpleUtils::never).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).lightLevel(blockState -> 13)));
    public static final SimpleHolder<CultivatorBlock> PURPLE_CULTIVATOR = BLOCKS.register("purple_cultivator", () -> new CultivatorBlock(DyeColor.PURPLE, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(SimpleUtils::never).isRedstoneConductor(SimpleUtils::never).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).lightLevel(blockState -> 13)));
    public static final SimpleHolder<CultivatorBlock> BLUE_CULTIVATOR = BLOCKS.register("blue_cultivator", () -> new CultivatorBlock(DyeColor.BLUE, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(SimpleUtils::never).isRedstoneConductor(SimpleUtils::never).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).lightLevel(blockState -> 13)));
    public static final SimpleHolder<CultivatorBlock> BROWN_CULTIVATOR = BLOCKS.register("brown_cultivator", () -> new CultivatorBlock(DyeColor.BROWN, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(SimpleUtils::never).isRedstoneConductor(SimpleUtils::never).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).lightLevel(blockState -> 13)));
    public static final SimpleHolder<CultivatorBlock> GREEN_CULTIVATOR = BLOCKS.register("green_cultivator", () -> new CultivatorBlock(DyeColor.GREEN, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(SimpleUtils::never).isRedstoneConductor(SimpleUtils::never).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).lightLevel(blockState -> 13)));
    public static final SimpleHolder<CultivatorBlock> RED_CULTIVATOR = BLOCKS.register("red_cultivator", () -> new CultivatorBlock(DyeColor.RED, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(SimpleUtils::never).isRedstoneConductor(SimpleUtils::never).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).lightLevel(blockState -> 13)));
    public static final SimpleHolder<CultivatorBlock> BLACK_CULTIVATOR = BLOCKS.register("black_cultivator", () -> new CultivatorBlock(DyeColor.BLACK, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(SimpleUtils::never).isRedstoneConductor(SimpleUtils::never).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).lightLevel(blockState -> 13)));
    public static final SimpleHolder<ArchaeologyWorkbenchBlock> ARCHAEOLOGY_WORKBENCH = BLOCKS.register("archaeology_workbench", () -> new ArchaeologyWorkbenchBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final SimpleHolder<PalaeontologyTableBlock> PALAEONTOLOGY_TABLE = BLOCKS.register("palaeontology_table", () -> new PalaeontologyTableBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final SimpleHolder<GeneModificationBlock> GENE_MODIFICATION_TABLE = BLOCKS.register("gene_modification_table", () -> new GeneModificationBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final SimpleHolder<JurassicFernBlock> JURASSIC_FERN = BLOCKS.register("jurassic_fern", () -> new JurassicFernBlock(BlockBehaviour.Properties.of().noCollission().instabreak().randomTicks().sound(SoundType.GRASS)));
    public static final SimpleHolder<DrumBlock> DRUM = BLOCKS.register("drum", () -> new DrumBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final SimpleHolder<FeederBlock> FEEDER = BLOCKS.register("feeder", () -> new FeederBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final SimpleHolder<PermafrostBlock> PERMAFROST = BLOCKS.register("permafrost", () -> new PermafrostBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.CHIME).strength(0.5F).randomTicks().noOcclusion().sound(SoundType.GRAVEL)));
    public static final SimpleHolder<IcedStoneBlock> ICED_STONE = BLOCKS.register("iced_stone", () -> new IcedStoneBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.CHIME).requiresCorrectToolForDrops().strength(1.5F, 6.0F).randomTicks().noOcclusion()));
    public static final SimpleHolder<AxolotlspawnBlock> AXOLOTLSPAWN = BLOCKS.register("axolotlspawn", () -> new AxolotlspawnBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WATER).instabreak().noOcclusion().noCollission().sound(SoundType.FROGSPAWN).pushReaction(PushReaction.DESTROY)));
    public static final SimpleHolder<TimeMachineBlock> TIME_MACHINE = BLOCKS.register("time_machine", () -> new TimeMachineBlock(BlockBehaviour.Properties.of().strength(0.3F).lightLevel(blockState -> 14).sound(SoundType.GLASS)));
    public static final SimpleHolder<RawSoupCauldronBlock> RAW_CHICKEN_SOUP_CAULDRON = BLOCKS.register("raw_chicken_soup_cauldron", () -> new RawSoupCauldronBlock(FACauldronInteraction.RAW_CHICKEN_SOUP, BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON)));
    public static final SimpleHolder<SoupCauldronBlock> COOKED_CHICKEN_SOUP_CAULDRON = BLOCKS.register("cooked_chicken_soup_cauldron", () -> new SoupCauldronBlock(FACauldronInteraction.COOKED_CHICKEN_SOUP, BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON)));
    public static final SimpleHolder<RawSoupCauldronBlock> RAW_BERRY_MEDLEY_CAULDRON = BLOCKS.register("raw_berry_medley_cauldron", () -> new RawSoupCauldronBlock(FACauldronInteraction.RAW_BERRY_MEDLEY, BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON)));
    public static final SimpleHolder<SoupCauldronBlock> COOKED_BERRY_MEDLEY_CAULDRON = BLOCKS.register("cooked_berry_medley_cauldron", () -> new SoupCauldronBlock(FACauldronInteraction.COOKED_BERRY_MEDLEY, BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON)));
    public static final SimpleHolder<MayanVaseBlock> MAYAN_VASE = BLOCKS.register("mayan_vase", () -> new MayanVaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).strength(0.0F, 0.0F).pushReaction(PushReaction.DESTROY).noOcclusion()));
    public static final SimpleHolder<MayanVaseBlock> MAYAN_JADE_VASE = BLOCKS.register("mayan_jade_vase", () -> new MayanVaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).strength(0.0F, 0.0F).pushReaction(PushReaction.DESTROY).noOcclusion()));
    public static final SimpleHolder<MayanVaseBlock> MAYAN_OCELOT_VASE = BLOCKS.register("mayan_ocelot_vase", () -> new MayanVaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).strength(0.0F, 0.0F).pushReaction(PushReaction.DESTROY).noOcclusion()));
    public static final SimpleHolder<MayanVaseBlock> MAYAN_VILLAGER_VASE = BLOCKS.register("mayan_villager_vase", () -> new MayanVaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).strength(0.0F, 0.0F).pushReaction(PushReaction.DESTROY).noOcclusion()));
    public static final SimpleHolder<LlamaStatueBlock> IRON_LLAMA_STATUE = BLOCKS.register("iron_llama_statue", () -> new LlamaStatueBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instabreak().sound(SoundType.METAL)));
    public static final SimpleHolder<WeatheringCopperLlamaStatueBlock> COPPER_LLAMA_STATUE = BLOCKS.register("copper_llama_statue", () -> new WeatheringCopperLlamaStatueBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instabreak().sound(SoundType.METAL)));
    public static final SimpleHolder<WeatheringCopperLlamaStatueBlock> EXPOSED_COPPER_LLAMA_STATUE = BLOCKS.register("exposed_copper_llama_statue", () -> new WeatheringCopperLlamaStatueBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instabreak().sound(SoundType.METAL)));
    public static final SimpleHolder<WeatheringCopperLlamaStatueBlock> WEATHERED_COPPER_LLAMA_STATUE = BLOCKS.register("weathered_copper_llama_statue", () -> new WeatheringCopperLlamaStatueBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instabreak().sound(SoundType.METAL)));
    public static final SimpleHolder<WeatheringCopperLlamaStatueBlock> OXIDIZED_COPPER_LLAMA_STATUE = BLOCKS.register("oxidized_copper_llama_statue", () -> new WeatheringCopperLlamaStatueBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instabreak().sound(SoundType.METAL)));
    public static final SimpleHolder<LlamaStatueBlock> WAXED_COPPER_LLAMA_STATUE = BLOCKS.register("waxed_copper_llama_statue", () -> new LlamaStatueBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instabreak().sound(SoundType.METAL)));
    public static final SimpleHolder<LlamaStatueBlock> WAXED_EXPOSED_COPPER_LLAMA_STATUE = BLOCKS.register("waxed_exposed_copper_llama_statue", () -> new LlamaStatueBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instabreak().sound(SoundType.METAL)));
    public static final SimpleHolder<LlamaStatueBlock> WAXED_WEATHERED_COPPER_LLAMA_STATUE = BLOCKS.register("waxed_weathered_copper_llama_statue", () -> new LlamaStatueBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instabreak().sound(SoundType.METAL)));
    public static final SimpleHolder<LlamaStatueBlock> WAXED_OXIDIZED_COPPER_LLAMA_STATUE = BLOCKS.register("waxed_oxidized_copper_llama_statue", () -> new LlamaStatueBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instabreak().sound(SoundType.METAL)));
    public static final SimpleHolder<Block> LEPIDODENDRON_PLANKS = BLOCKS.register("lepidodendron_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final SimpleHolder<SaplingBlock> LEPIDODENDRON_SAPLING = BLOCKS.register("lepidodendron_sapling", () -> new SaplingBlock(FATreeGrowers.LEPIDODENDRON, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final SimpleHolder<RotatedPillarBlock> LEPIDODENDRON_LOG = BLOCKS.register("lepidodendron_log", () -> FABlocks.log(MapColor.TERRACOTTA_GREEN, MapColor.TERRACOTTA_BROWN));
    public static final SimpleHolder<RotatedPillarBlock> STRIPPED_LEPIDODENDRON_LOG = BLOCKS.register("stripped_lepidodendron_log", () -> FABlocks.log(MapColor.TERRACOTTA_GREEN, MapColor.TERRACOTTA_GREEN));
    public static final SimpleHolder<RotatedPillarBlock> LEPIDODENDRON_WOOD = BLOCKS.register("lepidodendron_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final SimpleHolder<RotatedPillarBlock> STRIPPED_LEPIDODENDRON_WOOD = BLOCKS.register("stripped_lepidodendron_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final SimpleHolder<LeavesBlock> LEPIDODENDRON_LEAVES = BLOCKS.register("lepidodendron_leaves", () -> FABlocks.leaves(SoundType.GRASS));
    public static final SimpleHolder<StairBlock> LEPIDODENDRON_STAIRS = BLOCKS.register("lepidodendron_stairs", () -> FABlocks.stair(FABlocks.LEPIDODENDRON_PLANKS.get()));
    public static final SimpleHolder<FossilsStandingSignBlock> LEPIDODENDRON_SIGN = BLOCKS.register("lepidodendron_sign", () -> new FossilsStandingSignBlock(FAWoodTypes.LEPIDODENDRON, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final SimpleHolder<FossilsWallSignBlock> LEPIDODENDRON_WALL_SIGN = BLOCKS.register("lepidodendron_wall_sign", () -> new FossilsWallSignBlock(FAWoodTypes.LEPIDODENDRON, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(FABlocks.LEPIDODENDRON_SIGN.get()).ignitedByLava()));
    public static final SimpleHolder<DoorBlock> LEPIDODENDRON_DOOR = BLOCKS.register("lepidodendron_door", () -> new DoorBlock(FABlockSetTypes.LEPIDODENDRON, BlockBehaviour.Properties.of().mapColor(FABlocks.LEPIDODENDRON_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final SimpleHolder<FossilsCeilingHangingSignBlock> LEPIDODENDRON_HANGING_SIGN = BLOCKS.register("lepidodendron_hanging_sign", () -> new FossilsCeilingHangingSignBlock(FAWoodTypes.LEPIDODENDRON, BlockBehaviour.Properties.of().mapColor(FABlocks.LEPIDODENDRON_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final SimpleHolder<FossilsWallHangingSignBlock> LEPIDODENDRON_WALL_HANGING_SIGN = BLOCKS.register("lepidodendron_wall_hanging_sign", () -> new FossilsWallHangingSignBlock(FAWoodTypes.LEPIDODENDRON, BlockBehaviour.Properties.of().mapColor(FABlocks.LEPIDODENDRON_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().dropsLike(FABlocks.LEPIDODENDRON_HANGING_SIGN.get())));
    public static final SimpleHolder<PressurePlateBlock> LEPIDODENDRON_PRESSURE_PLATE = BLOCKS.register("lepidodendron_pressure_plate", () -> new PressurePlateBlock(FABlockSetTypes.LEPIDODENDRON, BlockBehaviour.Properties.of().mapColor(FABlocks.LEPIDODENDRON_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final SimpleHolder<FenceBlock> LEPIDODENDRON_FENCE = BLOCKS.register("lepidodendron_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(FABlocks.LEPIDODENDRON_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final SimpleHolder<TrapDoorBlock> LEPIDODENDRON_TRAPDOOR = BLOCKS.register("lepidodendron_trapdoor", () -> new TrapDoorBlock(FABlockSetTypes.LEPIDODENDRON, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(SimpleUtils::never).ignitedByLava()));
    public static final SimpleHolder<FenceGateBlock> LEPIDODENDRON_FENCE_GATE = BLOCKS.register("lepidodendron_fence_gate", () -> new FenceGateBlock(FAWoodTypes.LEPIDODENDRON, BlockBehaviour.Properties.of().mapColor(FABlocks.LEPIDODENDRON_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava()));
    public static final SimpleHolder<FlowerPotBlock> POTTED_LEPIDODENDRON_SAPLING = BLOCKS.register("potted_lepidodendron_sapling", () -> FABlocks.flowerPot(FABlocks.LEPIDODENDRON_SAPLING.get()));
    public static final SimpleHolder<ButtonBlock> LEPIDODENDRON_BUTTON = BLOCKS.register("lepidodendron_button", () -> FABlocks.woodenButton(FABlockSetTypes.LEPIDODENDRON));
    public static final SimpleHolder<SlabBlock> LEPIDODENDRON_SLAB = BLOCKS.register("lepidodendron_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final SimpleHolder<Block> SIGILLARIA_PLANKS = BLOCKS.register("sigillaria_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final SimpleHolder<SaplingBlock> SIGILLARIA_SAPLING = BLOCKS.register("sigillaria_sapling", () -> new SaplingBlock(FATreeGrowers.SIGILLARIA, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final SimpleHolder<RotatedPillarBlock> SIGILLARIA_LOG = BLOCKS.register("sigillaria_log", () -> FABlocks.log(MapColor.TERRACOTTA_BLACK, MapColor.TERRACOTTA_GRAY));
    public static final SimpleHolder<RotatedPillarBlock> STRIPPED_SIGILLARIA_LOG = BLOCKS.register("stripped_sigillaria_log", () -> FABlocks.log(MapColor.TERRACOTTA_BLACK, MapColor.TERRACOTTA_BLACK));
    public static final SimpleHolder<RotatedPillarBlock> SIGILLARIA_WOOD = BLOCKS.register("sigillaria_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final SimpleHolder<RotatedPillarBlock> STRIPPED_SIGILLARIA_WOOD = BLOCKS.register("stripped_sigillaria_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final SimpleHolder<LeavesBlock> SIGILLARIA_LEAVES = BLOCKS.register("sigillaria_leaves", () -> FABlocks.leaves(SoundType.GRASS));
    public static final SimpleHolder<StairBlock> SIGILLARIA_STAIRS = BLOCKS.register("sigillaria_stairs", () -> FABlocks.stair(FABlocks.SIGILLARIA_PLANKS.get()));
    public static final SimpleHolder<FossilsStandingSignBlock> SIGILLARIA_SIGN = BLOCKS.register("sigillaria_sign", () -> new FossilsStandingSignBlock(FAWoodTypes.SIGILLARIA, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final SimpleHolder<FossilsWallSignBlock> SIGILLARIA_WALL_SIGN = BLOCKS.register("sigillaria_wall_sign", () -> new FossilsWallSignBlock(FAWoodTypes.SIGILLARIA, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(FABlocks.LEPIDODENDRON_SIGN.get()).ignitedByLava()));
    public static final SimpleHolder<DoorBlock> SIGILLARIA_DOOR = BLOCKS.register("sigillaria_door", () -> new DoorBlock(FABlockSetTypes.SIGILLARIA, BlockBehaviour.Properties.of().mapColor(FABlocks.SIGILLARIA_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final SimpleHolder<FossilsCeilingHangingSignBlock> SIGILLARIA_HANGING_SIGN = BLOCKS.register("sigillaria_hanging_sign", () -> new FossilsCeilingHangingSignBlock(FAWoodTypes.SIGILLARIA, BlockBehaviour.Properties.of().mapColor(FABlocks.SIGILLARIA_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final SimpleHolder<FossilsWallHangingSignBlock> SIGILLARIA_WALL_HANGING_SIGN = BLOCKS.register("sigillaria_wall_hanging_sign", () -> new FossilsWallHangingSignBlock(FAWoodTypes.SIGILLARIA, BlockBehaviour.Properties.of().mapColor(FABlocks.SIGILLARIA_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().dropsLike(FABlocks.SIGILLARIA_HANGING_SIGN.get())));
    public static final SimpleHolder<PressurePlateBlock> SIGILLARIA_PRESSURE_PLATE = BLOCKS.register("sigillaria_pressure_plate", () -> new PressurePlateBlock(FABlockSetTypes.SIGILLARIA, BlockBehaviour.Properties.of().mapColor(FABlocks.SIGILLARIA_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final SimpleHolder<FenceBlock> SIGILLARIA_FENCE = BLOCKS.register("sigillaria_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(FABlocks.SIGILLARIA_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final SimpleHolder<TrapDoorBlock> SIGILLARIA_TRAPDOOR = BLOCKS.register("sigillaria_trapdoor", () -> new TrapDoorBlock(FABlockSetTypes.SIGILLARIA, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(SimpleUtils::never).ignitedByLava()));
    public static final SimpleHolder<FenceGateBlock> SIGILLARIA_FENCE_GATE = BLOCKS.register("sigillaria_fence_gate", () -> new FenceGateBlock(FAWoodTypes.SIGILLARIA, BlockBehaviour.Properties.of().mapColor(FABlocks.SIGILLARIA_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava()));
    public static final SimpleHolder<FlowerPotBlock> POTTED_SIGILLARIA_SAPLING = BLOCKS.register("potted_sigillaria_sapling", () -> FABlocks.flowerPot(FABlocks.SIGILLARIA_SAPLING.get()));
    public static final SimpleHolder<ButtonBlock> SIGILLARIA_BUTTON = BLOCKS.register("sigillaria_button", () -> FABlocks.woodenButton(FABlockSetTypes.SIGILLARIA));
    public static final SimpleHolder<SlabBlock> SIGILLARIA_SLAB = BLOCKS.register("sigillaria_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final SimpleHolder<Block> CALAMITES_PLANKS = BLOCKS.register("calamites_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final SimpleHolder<SaplingBlock> CALAMITES_SAPLING = BLOCKS.register("calamites_sapling", () -> new SaplingBlock(FATreeGrowers.CALAMITES, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final SimpleHolder<RotatedPillarBlock> CALAMITES_LOG = BLOCKS.register("calamites_log", () -> FABlocks.log(MapColor.TERRACOTTA_BROWN, MapColor.TERRACOTTA_GREEN));
    public static final SimpleHolder<RotatedPillarBlock> STRIPPED_CALAMITES_LOG = BLOCKS.register("stripped_calamites_log", () -> FABlocks.log(MapColor.TERRACOTTA_BROWN, MapColor.TERRACOTTA_BROWN));
    public static final SimpleHolder<RotatedPillarBlock> CALAMITES_WOOD = BLOCKS.register("calamites_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final SimpleHolder<RotatedPillarBlock> STRIPPED_CALAMITES_WOOD = BLOCKS.register("stripped_calamites_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final SimpleHolder<LeavesBlock> CALAMITES_LEAVES = BLOCKS.register("calamites_leaves", () -> FABlocks.leaves(SoundType.GRASS));
    public static final SimpleHolder<StairBlock> CALAMITES_STAIRS = BLOCKS.register("calamites_stairs", () -> FABlocks.stair(FABlocks.CALAMITES_PLANKS.get()));
    public static final SimpleHolder<FossilsStandingSignBlock> CALAMITES_SIGN = BLOCKS.register("calamites_sign", () -> new FossilsStandingSignBlock(FAWoodTypes.CALAMITES, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final SimpleHolder<FossilsWallSignBlock> CALAMITES_WALL_SIGN = BLOCKS.register("calamites_wall_sign", () -> new FossilsWallSignBlock(FAWoodTypes.CALAMITES, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(FABlocks.LEPIDODENDRON_SIGN.get()).ignitedByLava()));
    public static final SimpleHolder<DoorBlock> CALAMITES_DOOR = BLOCKS.register("calamites_door", () -> new DoorBlock(FABlockSetTypes.CALAMITES, BlockBehaviour.Properties.of().mapColor(FABlocks.CALAMITES_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final SimpleHolder<FossilsCeilingHangingSignBlock> CALAMITES_HANGING_SIGN = BLOCKS.register("calamites_hanging_sign", () -> new FossilsCeilingHangingSignBlock(FAWoodTypes.CALAMITES, BlockBehaviour.Properties.of().mapColor(FABlocks.CALAMITES_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final SimpleHolder<FossilsWallHangingSignBlock> CALAMITES_WALL_HANGING_SIGN = BLOCKS.register("calamites_wall_hanging_sign", () -> new FossilsWallHangingSignBlock(FAWoodTypes.CALAMITES, BlockBehaviour.Properties.of().mapColor(FABlocks.CALAMITES_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().dropsLike(FABlocks.LEPIDODENDRON_HANGING_SIGN.get())));
    public static final SimpleHolder<PressurePlateBlock> CALAMITES_PRESSURE_PLATE = BLOCKS.register("calamites_pressure_plate", () -> new PressurePlateBlock(FABlockSetTypes.CALAMITES, BlockBehaviour.Properties.of().mapColor(FABlocks.CALAMITES_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final SimpleHolder<FenceBlock> CALAMITES_FENCE = BLOCKS.register("calamites_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(FABlocks.CALAMITES_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final SimpleHolder<TrapDoorBlock> CALAMITES_TRAPDOOR = BLOCKS.register("calamites_trapdoor", () -> new TrapDoorBlock(FABlockSetTypes.CALAMITES, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(SimpleUtils::never).ignitedByLava()));
    public static final SimpleHolder<FenceGateBlock> CALAMITES_FENCE_GATE = BLOCKS.register("calamites_fence_gate", () -> new FenceGateBlock(FAWoodTypes.CALAMITES, BlockBehaviour.Properties.of().mapColor(FABlocks.CALAMITES_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava()));
    public static final SimpleHolder<FlowerPotBlock> POTTED_CALAMITES_SAPLING = BLOCKS.register("potted_calamites_sapling", () -> FABlocks.flowerPot(FABlocks.CALAMITES_SAPLING.get()));
    public static final SimpleHolder<ButtonBlock> CALAMITES_BUTTON = BLOCKS.register("calamites_button", () -> FABlocks.woodenButton(FABlockSetTypes.CALAMITES));
    public static final SimpleHolder<SlabBlock> CALAMITES_SLAB = BLOCKS.register("calamites_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));

    private static FlowerPotBlock flowerPot(Block block) {
        return new FlowerPotBlock(block, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
    }

    private static ButtonBlock woodenButton(BlockSetType blockSetType) {
        return new ButtonBlock(blockSetType, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY));
    }

    private static RotatedPillarBlock log(MapColor topMapColor, MapColor sideMapColor) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(blockState -> blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava());
    }

    private static LeavesBlock leaves(SoundType soundType) {
        return new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F).randomTicks().sound(soundType).noOcclusion().isValidSpawn(SimpleUtils::ocelotOrParrot).isSuffocating(SimpleUtils::never).isViewBlocking(SimpleUtils::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(SimpleUtils::never));
    }

    private static StairBlock stair(Block block) {
        return new StairBlock(block.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(block));
    }
}
