package willatendo.fossilslegacy.server.block.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyBlockEntityTypes {
    public static final SimpleRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPES = SimpleRegistry.create(Registries.BLOCK_ENTITY_TYPE, FossilsLegacyUtils.ID);

    public static final SimpleHolder<BlockEntityType<AnalyzerBlockEntity>> ANALYZER = BLOCK_ENTITY_TYPES.register("analyzer", () -> BlockEntityType.Builder.of(AnalyzerBlockEntity::new, FossilsLegacyBlocks.ANALYZER.get()).build(null));
    public static final SimpleHolder<BlockEntityType<CultivatorBlockEntity>> CULTIVATOR = BLOCK_ENTITY_TYPES.register("cultivator", () -> BlockEntityType.Builder.of(CultivatorBlockEntity::new, FossilsLegacyBlocks.RED_CULTIVATOR.get(), FossilsLegacyBlocks.BLACK_CULTIVATOR.get(), FossilsLegacyBlocks.BLUE_CULTIVATOR.get(), FossilsLegacyBlocks.BROWN_CULTIVATOR.get(), FossilsLegacyBlocks.CYAN_CULTIVATOR.get(), FossilsLegacyBlocks.GRAY_CULTIVATOR.get(), FossilsLegacyBlocks.GREEN_CULTIVATOR.get(), FossilsLegacyBlocks.LIGHT_BLUE_CULTIVATOR.get(), FossilsLegacyBlocks.LIGHT_GRAY_CULTIVATOR.get(), FossilsLegacyBlocks.LIME_CULTIVATOR.get(), FossilsLegacyBlocks.MAGENTA_CULTIVATOR.get(), FossilsLegacyBlocks.ORANGE_CULTIVATOR.get(), FossilsLegacyBlocks.PINK_CULTIVATOR.get(), FossilsLegacyBlocks.PURPLE_CULTIVATOR.get(), FossilsLegacyBlocks.WHITE_CULTIVATOR.get(), FossilsLegacyBlocks.YELLOW_CULTIVATOR.get()).build(null));
    public static final SimpleHolder<BlockEntityType<GeneModificationTableBlockEntity>> GENE_MODIFICATION_TABLE = BLOCK_ENTITY_TYPES.register("gene_modification_table", () -> BlockEntityType.Builder.of(GeneModificationTableBlockEntity::new, FossilsLegacyBlocks.GENE_MODIFICATION_TABLE.get()).build(null));
    public static final SimpleHolder<BlockEntityType<ArchaeologyWorkbenchBlockEntity>> ARCHAEOLOGY_WORKBENCH = BLOCK_ENTITY_TYPES.register("archaeology_workbench", () -> BlockEntityType.Builder.of(ArchaeologyWorkbenchBlockEntity::new, FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get()).build(null));
    public static final SimpleHolder<BlockEntityType<FeederBlockEntity>> FEEDER = BLOCK_ENTITY_TYPES.register("feeder", () -> BlockEntityType.Builder.of(FeederBlockEntity::new, FossilsLegacyBlocks.FEEDER.get()).build(null));
    public static final SimpleHolder<BlockEntityType<TimeMachineBlockEntity>> TIME_MACHINE = BLOCK_ENTITY_TYPES.register("time_machine", () -> BlockEntityType.Builder.of(TimeMachineBlockEntity::new, FossilsLegacyBlocks.TIME_MACHINE.get()).build(null));
    public static final SimpleHolder<BlockEntityType<RawSoupBlockEntity>> RAW_SOUP = BLOCK_ENTITY_TYPES.register("raw_soup", () -> BlockEntityType.Builder.of(RawSoupBlockEntity::new, FossilsLegacyBlocks.RAW_CHICKEN_SOUP_CAULDRON.get(), FossilsLegacyBlocks.RAW_BERRY_MEDLEY_CAULDRON.get()).build(null));
    public static final SimpleHolder<BlockEntityType<FossilsSignBlockEntity>> FOSSILS_SIGN = BLOCK_ENTITY_TYPES.register("fossils_sign", () -> BlockEntityType.Builder.of(FossilsSignBlockEntity::new, FossilsLegacyBlocks.LEPIDODENDRON_SIGN.get(), FossilsLegacyBlocks.LEPIDODENDRON_WALL_SIGN.get(), FossilsLegacyBlocks.SIGILLARIA_SIGN.get(), FossilsLegacyBlocks.SIGILLARIA_WALL_SIGN.get(), FossilsLegacyBlocks.CALAMITES_SIGN.get(), FossilsLegacyBlocks.CALAMITES_WALL_SIGN.get()).build(null));
    public static final SimpleHolder<BlockEntityType<FossilsHangingSignBlockEntity>> FOSSILS_HANGING_SIGN = BLOCK_ENTITY_TYPES.register("fossils_hanging_sign", () -> BlockEntityType.Builder.of(FossilsHangingSignBlockEntity::new, FossilsLegacyBlocks.LEPIDODENDRON_HANGING_SIGN.get(), FossilsLegacyBlocks.LEPIDODENDRON_WALL_HANGING_SIGN.get(), FossilsLegacyBlocks.SIGILLARIA_HANGING_SIGN.get(), FossilsLegacyBlocks.SIGILLARIA_WALL_HANGING_SIGN.get(), FossilsLegacyBlocks.CALAMITES_HANGING_SIGN.get(), FossilsLegacyBlocks.CALAMITES_WALL_HANGING_SIGN.get()).build(null));
    public static final SimpleHolder<BlockEntityType<VaseBlockEntity>> VASE = BLOCK_ENTITY_TYPES.register("vase", () -> BlockEntityType.Builder.of(VaseBlockEntity::new, FossilsLegacyBlocks.MAYAN_VASE.get(), FossilsLegacyBlocks.MAYAN_JADE_VASE.get(), FossilsLegacyBlocks.MAYAN_OCELOT_VASE.get(), FossilsLegacyBlocks.MAYAN_VILLAGER_VASE.get()).build(null));
}
