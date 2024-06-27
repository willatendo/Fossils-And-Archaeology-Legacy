package willatendo.fossilslegacy.server.block.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;

public class FossilsLegacyBlockEntities {
    public static final SimpleRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPES = SimpleRegistry.create(Registries.BLOCK_ENTITY_TYPE, FossilsLegacyUtils.ID);

    public static final SimpleHolder<BlockEntityType<AnalyzerBlockEntity>> ANALYZER = BLOCK_ENTITY_TYPES.register("analyzer", () -> BlockEntityType.Builder.<AnalyzerBlockEntity>of(AnalyzerBlockEntity::new, FossilsLegacyBlocks.ANALYZER.get()).build(null));
    public static final SimpleHolder<BlockEntityType<CultivatorBlockEntity>> CULTIVATOR = BLOCK_ENTITY_TYPES.register("cultivator", () -> BlockEntityType.Builder.<CultivatorBlockEntity>of(CultivatorBlockEntity::new, FossilsLegacyBlocks.RED_CULTIVATOR.get(), FossilsLegacyBlocks.BLACK_CULTIVATOR.get(), FossilsLegacyBlocks.BLUE_CULTIVATOR.get(), FossilsLegacyBlocks.BROWN_CULTIVATOR.get(), FossilsLegacyBlocks.CYAN_CULTIVATOR.get(), FossilsLegacyBlocks.GRAY_CULTIVATOR.get(), FossilsLegacyBlocks.GREEN_CULTIVATOR.get(), FossilsLegacyBlocks.LIGHT_BLUE_CULTIVATOR.get(), FossilsLegacyBlocks.LIGHT_GRAY_CULTIVATOR.get(), FossilsLegacyBlocks.LIME_CULTIVATOR.get(), FossilsLegacyBlocks.MAGENTA_CULTIVATOR.get(), FossilsLegacyBlocks.ORANGE_CULTIVATOR.get(), FossilsLegacyBlocks.PINK_CULTIVATOR.get(), FossilsLegacyBlocks.PURPLE_CULTIVATOR.get(), FossilsLegacyBlocks.WHITE_CULTIVATOR.get(), FossilsLegacyBlocks.YELLOW_CULTIVATOR.get()).build(null));
    public static final SimpleHolder<BlockEntityType<ArchaeologyWorkbenchBlockEntity>> ARCHAEOLOGY_WORKBENCH = BLOCK_ENTITY_TYPES.register("archaeology_workbench", () -> BlockEntityType.Builder.<ArchaeologyWorkbenchBlockEntity>of(ArchaeologyWorkbenchBlockEntity::new, FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get()).build(null));
    public static final SimpleHolder<BlockEntityType<FeederBlockEntity>> FEEDER = BLOCK_ENTITY_TYPES.register("feeder", () -> BlockEntityType.Builder.<FeederBlockEntity>of(FeederBlockEntity::new, FossilsLegacyBlocks.FEEDER.get()).build(null));
    public static final SimpleHolder<BlockEntityType<TimeMachineBlockEntity>> TIME_MACHINE = BLOCK_ENTITY_TYPES.register("time_machine", () -> BlockEntityType.Builder.<TimeMachineBlockEntity>of(TimeMachineBlockEntity::new, FossilsLegacyBlocks.TIME_MACHINE.get()).build(null));
    public static final SimpleHolder<BlockEntityType<RawSoupBlockEntity>> RAW_SOUP = BLOCK_ENTITY_TYPES.register("raw_soup", () -> BlockEntityType.Builder.<RawSoupBlockEntity>of(RawSoupBlockEntity::new, FossilsLegacyBlocks.RAW_CHICKEN_SOUP_CAULDRON.get(), FossilsLegacyBlocks.RAW_BERRY_MEDLEY_CAULDRON.get()).build(null));
    public static final SimpleHolder<BlockEntityType<LepidodendronSignBlockEntity>> LEPIDODENDRON_SIGN = BLOCK_ENTITY_TYPES.register("lepidodendron_sign", () -> BlockEntityType.Builder.<LepidodendronSignBlockEntity>of(LepidodendronSignBlockEntity::new, FossilsLegacyBlocks.LEPIDODENDRON_SIGN.get(), FossilsLegacyBlocks.LEPIDODENDRON_WALL_SIGN.get()).build(null));
    public static final SimpleHolder<BlockEntityType<LepidodendronHangingSignBlockEntity>> LEPIDODENDRON_HANGING_SIGN = BLOCK_ENTITY_TYPES.register("lepidodendron_hanging_sign", () -> BlockEntityType.Builder.<LepidodendronHangingSignBlockEntity>of(LepidodendronHangingSignBlockEntity::new, FossilsLegacyBlocks.LEPIDODENDRON_HANGING_SIGN.get(), FossilsLegacyBlocks.LEPIDODENDRON_WALL_HANGING_SIGN.get()).build(null));

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(BLOCK_ENTITY_TYPES);
    }
}
