package willatendo.fossilslegacy.server.block.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.entity.entities.*;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FABlockEntityTypes {
    public static final SimpleRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPES = SimpleRegistry.create(Registries.BLOCK_ENTITY_TYPE, FossilsLegacyUtils.ID);

    public static final SimpleHolder<BlockEntityType<AnalyzerBlockEntity>> ANALYZER = BLOCK_ENTITY_TYPES.register("analyzer", () -> BlockEntityType.Builder.of(AnalyzerBlockEntity::new, FABlocks.ANALYZER.get()).build(null));
    public static final SimpleHolder<BlockEntityType<CultivatorBlockEntity>> CULTIVATOR = BLOCK_ENTITY_TYPES.register("cultivator", () -> BlockEntityType.Builder.of(CultivatorBlockEntity::new, FABlocks.RED_CULTIVATOR.get(), FABlocks.BLACK_CULTIVATOR.get(), FABlocks.BLUE_CULTIVATOR.get(), FABlocks.BROWN_CULTIVATOR.get(), FABlocks.CYAN_CULTIVATOR.get(), FABlocks.GRAY_CULTIVATOR.get(), FABlocks.GREEN_CULTIVATOR.get(), FABlocks.LIGHT_BLUE_CULTIVATOR.get(), FABlocks.LIGHT_GRAY_CULTIVATOR.get(), FABlocks.LIME_CULTIVATOR.get(), FABlocks.MAGENTA_CULTIVATOR.get(), FABlocks.ORANGE_CULTIVATOR.get(), FABlocks.PINK_CULTIVATOR.get(), FABlocks.PURPLE_CULTIVATOR.get(), FABlocks.WHITE_CULTIVATOR.get(), FABlocks.YELLOW_CULTIVATOR.get()).build(null));
    public static final SimpleHolder<BlockEntityType<GeneModificationTableBlockEntity>> GENE_MODIFICATION_TABLE = BLOCK_ENTITY_TYPES.register("gene_modification_table", () -> BlockEntityType.Builder.of(GeneModificationTableBlockEntity::new, FABlocks.GENE_MODIFICATION_TABLE.get()).build(null));
    public static final SimpleHolder<BlockEntityType<ArchaeologyWorkbenchBlockEntity>> ARCHAEOLOGY_WORKBENCH = BLOCK_ENTITY_TYPES.register("archaeology_workbench", () -> BlockEntityType.Builder.of(ArchaeologyWorkbenchBlockEntity::new, FABlocks.ARCHAEOLOGY_WORKBENCH.get()).build(null));
    public static final SimpleHolder<BlockEntityType<FeederBlockEntity>> FEEDER = BLOCK_ENTITY_TYPES.register("feeder", () -> BlockEntityType.Builder.of(FeederBlockEntity::new, FABlocks.FEEDER.get()).build(null));
    public static final SimpleHolder<BlockEntityType<TimeMachineBlockEntity>> TIME_MACHINE = BLOCK_ENTITY_TYPES.register("time_machine", () -> BlockEntityType.Builder.of(TimeMachineBlockEntity::new, FABlocks.TIME_MACHINE.get()).build(null));
    public static final SimpleHolder<BlockEntityType<RawSoupBlockEntity>> RAW_SOUP = BLOCK_ENTITY_TYPES.register("raw_soup", () -> BlockEntityType.Builder.of(RawSoupBlockEntity::new, FABlocks.RAW_CHICKEN_SOUP_CAULDRON.get(), FABlocks.RAW_BERRY_MEDLEY_CAULDRON.get()).build(null));
    public static final SimpleHolder<BlockEntityType<FossilsSignBlockEntity>> FOSSILS_SIGN = BLOCK_ENTITY_TYPES.register("fossils_sign", () -> BlockEntityType.Builder.of(FossilsSignBlockEntity::new, FABlocks.LEPIDODENDRON_SIGN.get(), FABlocks.LEPIDODENDRON_WALL_SIGN.get(), FABlocks.SIGILLARIA_SIGN.get(), FABlocks.SIGILLARIA_WALL_SIGN.get(), FABlocks.CALAMITES_SIGN.get(), FABlocks.CALAMITES_WALL_SIGN.get()).build(null));
    public static final SimpleHolder<BlockEntityType<FossilsHangingSignBlockEntity>> FOSSILS_HANGING_SIGN = BLOCK_ENTITY_TYPES.register("fossils_hanging_sign", () -> BlockEntityType.Builder.of(FossilsHangingSignBlockEntity::new, FABlocks.LEPIDODENDRON_HANGING_SIGN.get(), FABlocks.LEPIDODENDRON_WALL_HANGING_SIGN.get(), FABlocks.SIGILLARIA_HANGING_SIGN.get(), FABlocks.SIGILLARIA_WALL_HANGING_SIGN.get(), FABlocks.CALAMITES_HANGING_SIGN.get(), FABlocks.CALAMITES_WALL_HANGING_SIGN.get()).build(null));
    public static final SimpleHolder<BlockEntityType<VaseBlockEntity>> VASE = BLOCK_ENTITY_TYPES.register("vase", () -> BlockEntityType.Builder.of(VaseBlockEntity::new, FABlocks.MAYAN_VASE.get(), FABlocks.MAYAN_JADE_VASE.get(), FABlocks.MAYAN_OCELOT_VASE.get(), FABlocks.MAYAN_VILLAGER_VASE.get()).build(null));
}
