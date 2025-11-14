package willatendo.fossilslegacy.server.block.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.entity.entities.*;
import willatendo.fossilslegacy.server.registry.FABlockRegistry;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FABlockEntityTypes {
    public static final SimpleRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPES = SimpleRegistry.create(Registries.BLOCK_ENTITY_TYPE, FAUtils.ID);

    public static final SimpleHolder<BlockEntityType<AnalyzerBlockEntity>> DNA_ANALYZER = BLOCK_ENTITY_TYPES.register("dna_analyzer", () -> new BlockEntityType<>(AnalyzerBlockEntity::new, Set.of(FABlocks.DNA_ANALYZER.get())));
    public static final SimpleHolder<BlockEntityType<DNACoderBlockEntity>> DNA_CODER = BLOCK_ENTITY_TYPES.register("dna_coder", () -> new BlockEntityType<>(DNACoderBlockEntity::new, Set.of(FABlocks.DNA_CODER.get())));
    public static final SimpleHolder<BlockEntityType<DNAHybridizerBlockEntity>> DNA_HYBRIDIZER = BLOCK_ENTITY_TYPES.register("dna_hybridizer", () -> new BlockEntityType<>(DNAHybridizerBlockEntity::new, Set.of(FABlocks.DNA_HYBRIDIZER.get())));
    public static final SimpleHolder<BlockEntityType<CageBlockEntity>> CAGE = BLOCK_ENTITY_TYPES.register("cage", () -> new BlockEntityType<>(CageBlockEntity::new, Set.of(FABlocks.SMALL_CAGE.get())));
    public static final SimpleHolder<BlockEntityType<CultivatorBlockEntity>> CULTIVATOR = BLOCK_ENTITY_TYPES.register("cultivator", () -> new BlockEntityType<>(CultivatorBlockEntity::new, Set.of(FABlocks.RED_CULTIVATOR.get(), FABlocks.BLACK_CULTIVATOR.get(), FABlocks.BLUE_CULTIVATOR.get(), FABlocks.BROWN_CULTIVATOR.get(), FABlocks.CYAN_CULTIVATOR.get(), FABlocks.GRAY_CULTIVATOR.get(), FABlocks.GREEN_CULTIVATOR.get(), FABlocks.LIGHT_BLUE_CULTIVATOR.get(), FABlocks.LIGHT_GRAY_CULTIVATOR.get(), FABlocks.LIME_CULTIVATOR.get(), FABlocks.MAGENTA_CULTIVATOR.get(), FABlocks.ORANGE_CULTIVATOR.get(), FABlocks.PINK_CULTIVATOR.get(), FABlocks.PURPLE_CULTIVATOR.get(), FABlocks.WHITE_CULTIVATOR.get(), FABlocks.YELLOW_CULTIVATOR.get())));
    public static final SimpleHolder<BlockEntityType<ShatteredCultivatorBlockEntity>> SHATTERED_CULTIVATOR = BLOCK_ENTITY_TYPES.register("shattered_cultivator", () -> new BlockEntityType<>(ShatteredCultivatorBlockEntity::new, Set.of(FABlocks.RED_SHATTERED_CULTIVATOR.get(), FABlocks.BLACK_SHATTERED_CULTIVATOR.get(), FABlocks.BLUE_SHATTERED_CULTIVATOR.get(), FABlocks.BROWN_SHATTERED_CULTIVATOR.get(), FABlocks.CYAN_SHATTERED_CULTIVATOR.get(), FABlocks.GRAY_SHATTERED_CULTIVATOR.get(), FABlocks.GREEN_SHATTERED_CULTIVATOR.get(), FABlocks.LIGHT_BLUE_SHATTERED_CULTIVATOR.get(), FABlocks.LIGHT_GRAY_SHATTERED_CULTIVATOR.get(), FABlocks.LIME_SHATTERED_CULTIVATOR.get(), FABlocks.MAGENTA_SHATTERED_CULTIVATOR.get(), FABlocks.ORANGE_SHATTERED_CULTIVATOR.get(), FABlocks.PINK_SHATTERED_CULTIVATOR.get(), FABlocks.PURPLE_SHATTERED_CULTIVATOR.get(), FABlocks.WHITE_SHATTERED_CULTIVATOR.get(), FABlocks.YELLOW_SHATTERED_CULTIVATOR.get())));
    public static final SimpleHolder<BlockEntityType<DecorationPostBlockEntity>> DECORATION_POST = BLOCK_ENTITY_TYPES.register("decoration_post", () -> new BlockEntityType<>(DecorationPostBlockEntity::new, Set.of(FABlocks.RED_POST.get(), FABlocks.BLACK_POST.get(), FABlocks.BLUE_POST.get(), FABlocks.BROWN_POST.get(), FABlocks.CYAN_POST.get(), FABlocks.GRAY_POST.get(), FABlocks.GREEN_POST.get(), FABlocks.LIGHT_BLUE_POST.get(), FABlocks.LIGHT_GRAY_POST.get(), FABlocks.LIME_POST.get(), FABlocks.MAGENTA_POST.get(), FABlocks.ORANGE_POST.get(), FABlocks.PINK_POST.get(), FABlocks.PURPLE_POST.get(), FABlocks.WHITE_POST.get(), FABlocks.YELLOW_POST.get())));
    public static final SimpleHolder<BlockEntityType<DNARecombinatorBlockEntity>> DNA_RECOMBINATOR = BLOCK_ENTITY_TYPES.register("dna_recombinator", () -> new BlockEntityType<>(DNARecombinatorBlockEntity::new, Set.of(FABlocks.DNA_RECOMBINATOR.get())));
    public static final SimpleHolder<BlockEntityType<ArchaeologyWorkbenchBlockEntity>> ARCHAEOLOGY_WORKBENCH = BLOCK_ENTITY_TYPES.register("archaeology_workbench", () -> new BlockEntityType<>(ArchaeologyWorkbenchBlockEntity::new, Set.of(FABlocks.ARCHAEOLOGY_WORKBENCH.get())));
    public static final SimpleHolder<BlockEntityType<FeederBlockEntity>> FEEDER = BLOCK_ENTITY_TYPES.register("feeder", () -> new BlockEntityType<>(FeederBlockEntity::new, Set.of(FABlocks.FEEDER.get())));
    public static final SimpleHolder<BlockEntityType<HeadBlockEntity>> HEAD = BLOCK_ENTITY_TYPES.register("head", () -> new BlockEntityType<>(HeadBlockEntity::new, Set.of(FABlockRegistry.getAllHeads())));
    public static final SimpleHolder<BlockEntityType<TimeMachineBlockEntity>> TIME_MACHINE = BLOCK_ENTITY_TYPES.register("time_machine", () -> new BlockEntityType<>(TimeMachineBlockEntity::new, Set.of(FABlocks.TIME_MACHINE.get())));
    public static final SimpleHolder<BlockEntityType<HologramProjectorBlockEntity>> HOLOGRAM_PROJECTOR = BLOCK_ENTITY_TYPES.register("hologram_projector", () -> new BlockEntityType<>(HologramProjectorBlockEntity::new, Stream.concat(Stream.of(FABlocks.HOLOGRAM_PROJECTOR.get()), Arrays.stream(FABlockRegistry.getColoredHologramProjectors())).collect(Collectors.toSet())));
    public static final SimpleHolder<BlockEntityType<RawSoupBlockEntity>> RAW_SOUP = BLOCK_ENTITY_TYPES.register("raw_soup", () -> new BlockEntityType<>(RawSoupBlockEntity::new, Set.of(FABlocks.RAW_CHICKEN_SOUP_CAULDRON.get(), FABlocks.RAW_BERRY_MEDLEY_CAULDRON.get())));
    public static final SimpleHolder<BlockEntityType<FossilsSignBlockEntity>> FOSSILS_SIGN = BLOCK_ENTITY_TYPES.register("fossils_sign", () -> new BlockEntityType<>(FossilsSignBlockEntity::new, Set.of(FABlockRegistry.getAllSigns())));
    public static final SimpleHolder<BlockEntityType<FossilsHangingSignBlockEntity>> FOSSILS_HANGING_SIGN = BLOCK_ENTITY_TYPES.register("fossils_hanging_sign", () -> new BlockEntityType<>(FossilsHangingSignBlockEntity::new, Set.of(FABlockRegistry.getAllHangingSigns())));
    public static final SimpleHolder<BlockEntityType<VaseBlockEntity>> VASE = BLOCK_ENTITY_TYPES.register("vase", () -> new BlockEntityType<>(VaseBlockEntity::new, Set.of(FABlocks.MAYAN_VASE.get(), FABlocks.MAYAN_JADE_VASE.get(), FABlocks.MAYAN_OCELOT_VASE.get(), FABlocks.MAYAN_VILLAGER_VASE.get())));
}
