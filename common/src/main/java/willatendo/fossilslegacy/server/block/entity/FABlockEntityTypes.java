package willatendo.fossilslegacy.server.block.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.entity.entities.*;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class FABlockEntityTypes {
    public static final SimpleRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPES = SimpleRegistry.create(Registries.BLOCK_ENTITY_TYPE, FAUtils.ID);

    public static final SimpleHolder<BlockEntityType<AnalyzerBlockEntity>> ANALYZER = BLOCK_ENTITY_TYPES.register("analyzer", () -> new BlockEntityType<>(AnalyzerBlockEntity::new, Set.of(FABlocks.ANALYZER.get())));
    public static final SimpleHolder<BlockEntityType<CultivatorBlockEntity>> CULTIVATOR = BLOCK_ENTITY_TYPES.register("cultivator", () -> new BlockEntityType<>(CultivatorBlockEntity::new, Set.of(FABlocks.RED_CULTIVATOR.get(), FABlocks.BLACK_CULTIVATOR.get(), FABlocks.BLUE_CULTIVATOR.get(), FABlocks.BROWN_CULTIVATOR.get(), FABlocks.CYAN_CULTIVATOR.get(), FABlocks.GRAY_CULTIVATOR.get(), FABlocks.GREEN_CULTIVATOR.get(), FABlocks.LIGHT_BLUE_CULTIVATOR.get(), FABlocks.LIGHT_GRAY_CULTIVATOR.get(), FABlocks.LIME_CULTIVATOR.get(), FABlocks.MAGENTA_CULTIVATOR.get(), FABlocks.ORANGE_CULTIVATOR.get(), FABlocks.PINK_CULTIVATOR.get(), FABlocks.PURPLE_CULTIVATOR.get(), FABlocks.WHITE_CULTIVATOR.get(), FABlocks.YELLOW_CULTIVATOR.get())));
    public static final SimpleHolder<BlockEntityType<GeneModificationTableBlockEntity>> GENE_MODIFICATION_TABLE = BLOCK_ENTITY_TYPES.register("gene_modification_table", () -> new BlockEntityType<>(GeneModificationTableBlockEntity::new, Set.of(FABlocks.GENE_MODIFICATION_TABLE.get())));
    public static final SimpleHolder<BlockEntityType<ArchaeologyWorkbenchBlockEntity>> ARCHAEOLOGY_WORKBENCH = BLOCK_ENTITY_TYPES.register("archaeology_workbench", () -> new BlockEntityType<>(ArchaeologyWorkbenchBlockEntity::new, Set.of(FABlocks.ARCHAEOLOGY_WORKBENCH.get())));
    public static final SimpleHolder<BlockEntityType<FeederBlockEntity>> FEEDER = BLOCK_ENTITY_TYPES.register("feeder", () -> new BlockEntityType<>(FeederBlockEntity::new, Set.of(FABlocks.FEEDER.get())));
    public static final SimpleHolder<BlockEntityType<TimeMachineBlockEntity>> TIME_MACHINE = BLOCK_ENTITY_TYPES.register("time_machine", () -> new BlockEntityType<>(TimeMachineBlockEntity::new, Set.of(FABlocks.TIME_MACHINE.get())));
    public static final SimpleHolder<BlockEntityType<RawSoupBlockEntity>> RAW_SOUP = BLOCK_ENTITY_TYPES.register("raw_soup", () -> new BlockEntityType<>(RawSoupBlockEntity::new, Set.of(FABlocks.RAW_CHICKEN_SOUP_CAULDRON.get(), FABlocks.RAW_BERRY_MEDLEY_CAULDRON.get())));
    public static final SimpleHolder<BlockEntityType<FossilsSignBlockEntity>> FOSSILS_SIGN = BLOCK_ENTITY_TYPES.register("fossils_sign", () -> new BlockEntityType<>(FossilsSignBlockEntity::new, Set.of(FABlocks.LEPIDODENDRON_SIGN.get(), FABlocks.LEPIDODENDRON_WALL_SIGN.get(), FABlocks.SIGILLARIA_SIGN.get(), FABlocks.SIGILLARIA_WALL_SIGN.get(), FABlocks.CALAMITES_SIGN.get(), FABlocks.CALAMITES_WALL_SIGN.get())));
    public static final SimpleHolder<BlockEntityType<FossilsHangingSignBlockEntity>> FOSSILS_HANGING_SIGN = BLOCK_ENTITY_TYPES.register("fossils_hanging_sign", () -> new BlockEntityType<>(FossilsHangingSignBlockEntity::new, Set.of(FABlocks.LEPIDODENDRON_HANGING_SIGN.get(), FABlocks.LEPIDODENDRON_WALL_HANGING_SIGN.get(), FABlocks.SIGILLARIA_HANGING_SIGN.get(), FABlocks.SIGILLARIA_WALL_HANGING_SIGN.get(), FABlocks.CALAMITES_HANGING_SIGN.get(), FABlocks.CALAMITES_WALL_HANGING_SIGN.get())));
    public static final SimpleHolder<BlockEntityType<VaseBlockEntity>> VASE = BLOCK_ENTITY_TYPES.register("vase", () -> new BlockEntityType<>(VaseBlockEntity::new, Set.of(FABlocks.MAYAN_VASE.get(), FABlocks.MAYAN_JADE_VASE.get(), FABlocks.MAYAN_OCELOT_VASE.get(), FABlocks.MAYAN_VILLAGER_VASE.get())));
}
