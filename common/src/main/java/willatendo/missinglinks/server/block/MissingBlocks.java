package willatendo.missinglinks.server.block;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import willatendo.missinglinks.server.util.MissingLinks2Utils;
import willatendo.simplelibrary.server.registry.BlockRegistry;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class MissingBlocks {
    public static final BlockRegistry BLOCKS = SimpleRegistry.createBlock(MissingLinks2Utils.ID);

    public static final SimpleHolder<ButtonBlock> ANDESITE_BUTTON = BLOCKS.registerBlock("andesite_button", properties -> new ButtonBlock(BlockSetType.STONE, 20, properties), MissingBlocks::buttonProperties);
    public static final SimpleHolder<PressurePlateBlock> ANDESITE_PRESSURE_PLATE = BLOCKS.registerBlock("andesite_pressure_plate", properties -> new PressurePlateBlock(BlockSetType.STONE, properties), MissingBlocks::stonePressurePlateProperties);
    public static final SimpleHolder<LeverBlock> ANDESITE_LEVER = BLOCKS.registerBlock("andesite_lever", LeverBlock::new, MissingBlocks::leverProperties);
    public static final SimpleHolder<SlabBlock> CALCITE_SLAB = BLOCKS.registerBlock("calcite_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE));
    public static final SimpleHolder<StairBlock> CALCITE_STAIRS = BLOCKS.registerBlock("calcite_stairs", properties -> new StairBlock(Blocks.CALCITE.defaultBlockState(), properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE));
    public static final SimpleHolder<WallBlock> CALCITE_WALL = BLOCKS.registerBlock("calcite_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE));
    public static final SimpleHolder<ButtonBlock> CALCITE_BUTTON = BLOCKS.registerBlock("calcite_button", properties -> new ButtonBlock(BlockSetType.STONE, 20, properties), MissingBlocks::buttonProperties);
    public static final SimpleHolder<PressurePlateBlock> CALCITE_PRESSURE_PLATE = BLOCKS.registerBlock("calcite_pressure_plate", properties -> new PressurePlateBlock(BlockSetType.STONE, properties), MissingBlocks::stonePressurePlateProperties);
    public static final SimpleHolder<LeverBlock> CALCITE_LEVER = BLOCKS.registerBlock("calcite_lever", LeverBlock::new, MissingBlocks::leverProperties);
    public static final SimpleHolder<ButtonBlock> COBBLED_DEEPSLATE_BUTTON = BLOCKS.registerBlock("cobbled_deepslate_button", properties -> new ButtonBlock(BlockSetType.STONE, 20, properties), MissingBlocks::buttonProperties);
    public static final SimpleHolder<PressurePlateBlock> COBBLED_DEEPSLATE_PRESSURE_PLATE = BLOCKS.registerBlock("cobbled_deepslate_pressure_plate", properties -> new PressurePlateBlock(BlockSetType.STONE, properties), MissingBlocks::stonePressurePlateProperties);
    public static final SimpleHolder<LeverBlock> COBBLED_DEEPSLATE_LEVER = BLOCKS.registerBlock("cobbled_deepslate_lever", LeverBlock::new, MissingBlocks::leverProperties);
    public static final SimpleHolder<ButtonBlock> COBBLESTONE_BUTTON = BLOCKS.registerBlock("cobblestone_button", properties -> new ButtonBlock(BlockSetType.STONE, 20, properties), MissingBlocks::buttonProperties);
    public static final SimpleHolder<PressurePlateBlock> COBBLESTONE_PRESSURE_PLATE = BLOCKS.registerBlock("cobblestone_pressure_plate", properties -> new PressurePlateBlock(BlockSetType.STONE, properties), MissingBlocks::stonePressurePlateProperties);
    public static final SimpleHolder<ButtonBlock> DIORITE_BUTTON = BLOCKS.registerBlock("diorite_button", properties -> new ButtonBlock(BlockSetType.STONE, 20, properties), MissingBlocks::buttonProperties);
    public static final SimpleHolder<PressurePlateBlock> DIORITE_PRESSURE_PLATE = BLOCKS.registerBlock("diorite_pressure_plate", properties -> new PressurePlateBlock(BlockSetType.STONE, properties), MissingBlocks::stonePressurePlateProperties);
    public static final SimpleHolder<LeverBlock> DIORITE_LEVER = BLOCKS.registerBlock("diorite_lever", LeverBlock::new, MissingBlocks::leverProperties);
    public static final SimpleHolder<ButtonBlock> GRANITE_BUTTON = BLOCKS.registerBlock("granite_button", properties -> new ButtonBlock(BlockSetType.STONE, 20, properties), MissingBlocks::buttonProperties);
    public static final SimpleHolder<PressurePlateBlock> GRANITE_PRESSURE_PLATE = BLOCKS.registerBlock("granite_pressure_plate", properties -> new PressurePlateBlock(BlockSetType.STONE, properties), MissingBlocks::stonePressurePlateProperties);
    public static final SimpleHolder<LeverBlock> GRANITE_LEVER = BLOCKS.registerBlock("granite_lever", LeverBlock::new, MissingBlocks::leverProperties);
    public static final SimpleHolder<ButtonBlock> TUFF_BUTTON = BLOCKS.registerBlock("tuff_button", properties -> new ButtonBlock(BlockSetType.STONE, 20, properties), MissingBlocks::buttonProperties);
    public static final SimpleHolder<PressurePlateBlock> TUFF_PRESSURE_PLATE = BLOCKS.registerBlock("tuff_pressure_plate", properties -> new PressurePlateBlock(BlockSetType.STONE, properties), MissingBlocks::stonePressurePlateProperties);
    public static final SimpleHolder<LeverBlock> TUFF_LEVER = BLOCKS.registerBlock("tuff_lever", LeverBlock::new, MissingBlocks::leverProperties);
    public static final SimpleHolder<LeverBlock> STONE_LEVER = BLOCKS.registerBlock("stone_lever", LeverBlock::new, MissingBlocks::leverProperties);
    public static final SimpleHolder<WallBlock> STONE_WALL = BLOCKS.registerBlock("stone_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));

    private static BlockBehaviour.Properties buttonProperties() {
        return BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties stonePressurePlateProperties() {
        return BlockBehaviour.Properties.of().mapColor(MapColor.STONE).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties leverProperties() {
        return BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.STONE).pushReaction(PushReaction.DESTROY);
    }
}
