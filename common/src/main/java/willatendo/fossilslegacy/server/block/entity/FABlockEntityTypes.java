package willatendo.fossilslegacy.server.block.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.entity.entities.*;
import willatendo.fossilslegacy.server.registry.FABlockRegistry;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.Set;

public class FABlockEntityTypes {
    public static final SimpleRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPES = SimpleRegistry.create(Registries.BLOCK_ENTITY_TYPE, FAUtils.ID);

    public static final SimpleHolder<BlockEntityType<AnalyzerBlockEntity>> DNA_ANALYZER = BLOCK_ENTITY_TYPES.register("dna_analyzer", () -> new BlockEntityType<>(AnalyzerBlockEntity::new, Set.of(FABlocks.DNA_ANALYZER.get())));
    public static final SimpleHolder<BlockEntityType<DNACoderBlockEntity>> DNA_CODER = BLOCK_ENTITY_TYPES.register("dna_coder", () -> new BlockEntityType<>(DNACoderBlockEntity::new, Set.of(FABlocks.DNA_CODER.get())));
    public static final SimpleHolder<BlockEntityType<DNAHybridizerBlockEntity>> DNA_HYBRIDIZER = BLOCK_ENTITY_TYPES.register("dna_hybridizer", () -> new BlockEntityType<>(DNAHybridizerBlockEntity::new, Set.of(FABlocks.DNA_HYBRIDIZER.get())));
    public static final SimpleHolder<BlockEntityType<CageBlockEntity>> CAGE = BLOCK_ENTITY_TYPES.register("cage", () -> new BlockEntityType<>(CageBlockEntity::new, Set.of(FABlocks.SMALL_CAGE.get())));
    public static final SimpleHolder<BlockEntityType<CultivatorBlockEntity>> CULTIVATOR = BLOCK_ENTITY_TYPES.register("cultivator", () -> new BlockEntityType<>(CultivatorBlockEntity::new, Set.of(FABlocks.RED_CULTIVATOR.get(), FABlocks.BLACK_CULTIVATOR.get(), FABlocks.BLUE_CULTIVATOR.get(), FABlocks.BROWN_CULTIVATOR.get(), FABlocks.CYAN_CULTIVATOR.get(), FABlocks.GRAY_CULTIVATOR.get(), FABlocks.GREEN_CULTIVATOR.get(), FABlocks.LIGHT_BLUE_CULTIVATOR.get(), FABlocks.LIGHT_GRAY_CULTIVATOR.get(), FABlocks.LIME_CULTIVATOR.get(), FABlocks.MAGENTA_CULTIVATOR.get(), FABlocks.ORANGE_CULTIVATOR.get(), FABlocks.PINK_CULTIVATOR.get(), FABlocks.PURPLE_CULTIVATOR.get(), FABlocks.WHITE_CULTIVATOR.get(), FABlocks.YELLOW_CULTIVATOR.get())));
    public static final SimpleHolder<BlockEntityType<DecorationPostBlockEntity>> DECORATION_POST = BLOCK_ENTITY_TYPES.register("decoration_post", () -> new BlockEntityType<>(DecorationPostBlockEntity::new, Set.of(FABlocks.RED_DECORATION_POST.get(), FABlocks.BLACK_DECORATION_POST.get(), FABlocks.BLUE_DECORATION_POST.get(), FABlocks.BROWN_DECORATION_POST.get(), FABlocks.CYAN_DECORATION_POST.get(), FABlocks.GRAY_DECORATION_POST.get(), FABlocks.GREEN_DECORATION_POST.get(), FABlocks.LIGHT_BLUE_DECORATION_POST.get(), FABlocks.LIGHT_GRAY_DECORATION_POST.get(), FABlocks.LIME_DECORATION_POST.get(), FABlocks.MAGENTA_DECORATION_POST.get(), FABlocks.ORANGE_DECORATION_POST.get(), FABlocks.PINK_DECORATION_POST.get(), FABlocks.PURPLE_DECORATION_POST.get(), FABlocks.WHITE_DECORATION_POST.get(), FABlocks.YELLOW_DECORATION_POST.get())));
    public static final SimpleHolder<BlockEntityType<DNARecombinatorBlockEntity>> DNA_RECOMBINATOR = BLOCK_ENTITY_TYPES.register("dna_recombinator", () -> new BlockEntityType<>(DNARecombinatorBlockEntity::new, Set.of(FABlocks.DNA_RECOMBINATOR.get())));
    public static final SimpleHolder<BlockEntityType<ArchaeologyWorkbenchBlockEntity>> ARCHAEOLOGY_WORKBENCH = BLOCK_ENTITY_TYPES.register("archaeology_workbench", () -> new BlockEntityType<>(ArchaeologyWorkbenchBlockEntity::new, Set.of(FABlocks.ARCHAEOLOGY_WORKBENCH.get())));
    public static final SimpleHolder<BlockEntityType<FeederBlockEntity>> FEEDER = BLOCK_ENTITY_TYPES.register("feeder", () -> new BlockEntityType<>(FeederBlockEntity::new, Set.of(FABlocks.FEEDER.get())));
    public static final SimpleHolder<BlockEntityType<HeadBlockEntity>> HEAD = BLOCK_ENTITY_TYPES.register("head", () -> new BlockEntityType<>(HeadBlockEntity::new, Set.of(FABlocks.ANKYLOSAURUS_HEAD.get(), FABlocks.WALL_ANKYLOSAURUS_HEAD.get(), FABlocks.BARYONYX_HEAD.get(), FABlocks.WALL_BARYONYX_HEAD.get())));
    public static final SimpleHolder<BlockEntityType<TimeMachineBlockEntity>> TIME_MACHINE = BLOCK_ENTITY_TYPES.register("time_machine", () -> new BlockEntityType<>(TimeMachineBlockEntity::new, Set.of(FABlocks.TIME_MACHINE.get())));
    public static final SimpleHolder<BlockEntityType<RawSoupBlockEntity>> RAW_SOUP = BLOCK_ENTITY_TYPES.register("raw_soup", () -> new BlockEntityType<>(RawSoupBlockEntity::new, Set.of(FABlocks.RAW_CHICKEN_SOUP_CAULDRON.get(), FABlocks.RAW_BERRY_MEDLEY_CAULDRON.get())));
    public static final SimpleHolder<BlockEntityType<FossilsSignBlockEntity>> FOSSILS_SIGN = BLOCK_ENTITY_TYPES.register("fossils_sign", () -> new BlockEntityType<>(FossilsSignBlockEntity::new, Set.of(FABlockRegistry.ALL_SIGNS.stream().map(SimpleHolder::get).toArray(Block[]::new))));
    public static final SimpleHolder<BlockEntityType<FossilsHangingSignBlockEntity>> FOSSILS_HANGING_SIGN = BLOCK_ENTITY_TYPES.register("fossils_hanging_sign", () -> new BlockEntityType<>(FossilsHangingSignBlockEntity::new, Set.of(FABlockRegistry.ALL_HANGING_SIGNS.stream().map(SimpleHolder::get).toArray(Block[]::new))));
    public static final SimpleHolder<BlockEntityType<VaseBlockEntity>> VASE = BLOCK_ENTITY_TYPES.register("vase", () -> new BlockEntityType<>(VaseBlockEntity::new, Set.of(FABlocks.MAYAN_VASE.get(), FABlocks.MAYAN_JADE_VASE.get(), FABlocks.MAYAN_OCELOT_VASE.get(), FABlocks.MAYAN_VILLAGER_VASE.get())));
}
