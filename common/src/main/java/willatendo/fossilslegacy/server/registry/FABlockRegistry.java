package willatendo.fossilslegacy.server.registry;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.blocks.*;
import willatendo.fossilslegacy.server.item.FAHeadTypes;
import willatendo.fossilslegacy.server.tags.FABlockTags;
import willatendo.fossilslegacy.server.tags.FAItemTags;
import willatendo.simplelibrary.server.registry.BlockRegistry;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.util.BlockUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public record FABlockRegistry(BlockRegistry blockRegistry) {
    public static final TagKey<Block>[] LOG_TAGS = new TagKey[]{FABlockTags.LEPIDODENDRON_LOGS, FABlockTags.SIGILLARIA_LOGS, FABlockTags.CALAMITES_LOGS, FABlockTags.ARCHAEOPTERIS_LOGS, FABlockTags.GINKGO_LOGS, FABlockTags.ARAUCARIA_LOGS, FABlockTags.ARAUCARIOXYLON_LOGS, FABlockTags.CORDAITES_LOGS, FABlockTags.WOLLEMIA_LOGS, FABlockTags.METASEQUOIA_LOGS};
    public static final TagKey<Item>[] ITEM_LOG_TAGS = new TagKey[]{FAItemTags.LEPIDODENDRON_LOGS, FAItemTags.SIGILLARIA_LOGS, FAItemTags.CALAMITES_LOGS, FAItemTags.ARCHAEOPTERIS_LOGS, FAItemTags.GINKGO_LOGS, FAItemTags.ARAUCARIA_LOGS, FAItemTags.ARAUCARIOXYLON_LOGS, FAItemTags.CORDAITES_LOGS, FAItemTags.WOLLEMIA_LOGS, FAItemTags.METASEQUOIA_LOGS};
    public static final List<SimpleHolder<Block>> PLANKS = new ArrayList<>();
    public static final List<SimpleHolder<SaplingBlock>> SAPLINGS = new ArrayList<>();
    public static final List<SimpleHolder<RotatedPillarBlock>> LOGS = new ArrayList<>();
    public static final List<SimpleHolder<RotatedPillarBlock>> STRIPPED_LOGS = new ArrayList<>();
    public static final List<SimpleHolder<RotatedPillarBlock>> WOOD = new ArrayList<>();
    public static final List<SimpleHolder<RotatedPillarBlock>> STRIPPED_WOOD = new ArrayList<>();
    public static final List<SimpleHolder<LeavesBlock>> LEAVES = new ArrayList<>();
    public static final List<SimpleHolder<StairBlock>> STAIRS = new ArrayList<>();
    public static final List<SimpleHolder<? extends Block>> ALL_SIGNS = new ArrayList<>();
    public static final List<SimpleHolder<FossilsStandingSignBlock>> SIGNS = new ArrayList<>();
    public static final List<SimpleHolder<FossilsWallSignBlock>> WALL_SIGNS = new ArrayList<>();
    public static final List<SimpleHolder<DoorBlock>> DOORS = new ArrayList<>();
    public static final List<SimpleHolder<? extends Block>> ALL_HANGING_SIGNS = new ArrayList<>();
    public static final List<SimpleHolder<FossilsCeilingHangingSignBlock>> HANGING_SIGNS = new ArrayList<>();
    public static final List<SimpleHolder<FossilsWallHangingSignBlock>> WALL_HANGING_SIGNS = new ArrayList<>();
    public static final List<SimpleHolder<PressurePlateBlock>> PRESSURE_PLATES = new ArrayList<>();
    public static final List<SimpleHolder<FenceBlock>> FENCES = new ArrayList<>();
    public static final List<SimpleHolder<TrapDoorBlock>> TRAPDOORS = new ArrayList<>();
    public static final List<SimpleHolder<FenceGateBlock>> FENCE_GATES = new ArrayList<>();
    public static final List<SimpleHolder<FlowerPotBlock>> POTTED_SAPLINGS = new ArrayList<>();
    public static final List<SimpleHolder<ButtonBlock>> BUTTONS = new ArrayList<>();
    public static final List<SimpleHolder<SlabBlock>> SLABS = new ArrayList<>();
    public static final List<SimpleHolder<? extends AbstractHeadBlock>> ALL_HEADS = new ArrayList<>();
    public static final List<SimpleHolder<HeadBlock>> HEADS = new ArrayList<>();
    public static final List<SimpleHolder<WallHeadBlock>> WALL_HEADS = new ArrayList<>();

    public static int woodSize() {
        return 10;
    }

    public static int headSize() {
        return ALL_HEADS.size() / 2;
    }

    public static SimpleHolder<Block> getPlanks(int i) {
        return PLANKS.get(i);
    }

    public static Block[] getPlanks() {
        return PLANKS.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<SaplingBlock> getSapling(int i) {
        return SAPLINGS.get(i);
    }

    public static Block[] getSaplings() {
        return SAPLINGS.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<RotatedPillarBlock> getLog(int i) {
        return LOGS.get(i);
    }

    public static Block[] getLogs() {
        return LOGS.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<RotatedPillarBlock> getStrippedLog(int i) {
        return STRIPPED_LOGS.get(i);
    }

    public static Block[] getStrippedLogs() {
        return STRIPPED_LOGS.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<RotatedPillarBlock> getWood(int i) {
        return WOOD.get(i);
    }

    public static Block[] getWood() {
        return WOOD.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<RotatedPillarBlock> getStrippedWood(int i) {
        return STRIPPED_WOOD.get(i);
    }

    public static Block[] getStrippedWood() {
        return STRIPPED_WOOD.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<LeavesBlock> getLeaves(int i) {
        return LEAVES.get(i);
    }

    public static Block[] getLeaves() {
        return LEAVES.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<StairBlock> getStairs(int i) {
        return STAIRS.get(i);
    }

    public static Block[] getStairs() {
        return STAIRS.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<FossilsStandingSignBlock> getSign(int i) {
        return SIGNS.get(i);
    }

    public static Block[] getSigns() {
        return SIGNS.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<FossilsWallSignBlock> getWallSign(int i) {
        return WALL_SIGNS.get(i);
    }

    public static Block[] getWallSigns() {
        return WALL_SIGNS.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static Block[] getAllSigns() {
        return ALL_SIGNS.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<DoorBlock> getDoor(int i) {
        return DOORS.get(i);
    }

    public static Block[] getDoors() {
        return DOORS.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<FossilsCeilingHangingSignBlock> getHangingSign(int i) {
        return HANGING_SIGNS.get(i);
    }

    public static Block[] getHangingSigns() {
        return HANGING_SIGNS.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<FossilsWallHangingSignBlock> getWallHangingSign(int i) {
        return WALL_HANGING_SIGNS.get(i);
    }

    public static Block[] getWallHangingSigns() {
        return WALL_HANGING_SIGNS.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static Block[] getAllHangingSigns() {
        return ALL_HANGING_SIGNS.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<PressurePlateBlock> getPressurePlate(int i) {
        return PRESSURE_PLATES.get(i);
    }

    public static Block[] getPressurePlates() {
        return PRESSURE_PLATES.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<FenceBlock> getFence(int i) {
        return FENCES.get(i);
    }

    public static Block[] getFences() {
        return FENCES.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<TrapDoorBlock> getTrapdoor(int i) {
        return TRAPDOORS.get(i);
    }

    public static Block[] getTrapdoors() {
        return TRAPDOORS.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<FenceGateBlock> getFenceGate(int i) {
        return FENCE_GATES.get(i);
    }

    public static Block[] getFenceGates() {
        return FENCE_GATES.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<FlowerPotBlock> getPottedSapling(int i) {
        return POTTED_SAPLINGS.get(i);
    }

    public static Block[] getPottedSaplings() {
        return POTTED_SAPLINGS.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<ButtonBlock> getButton(int i) {
        return BUTTONS.get(i);
    }

    public static Block[] getButtons() {
        return BUTTONS.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<SlabBlock> getSlab(int i) {
        return SLABS.get(i);
    }

    public static Block[] getSlabs() {
        return SLABS.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<HeadBlock> getHeads(int i) {
        return HEADS.get(i);
    }

    public static Block[] getHeads() {
        return HEADS.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public static SimpleHolder<WallHeadBlock> getWallHeads(int i) {
        return WALL_HEADS.get(i);
    }

    public static Block[] getAllHeads() {
        return ALL_HEADS.stream().map(SimpleHolder::get).toArray(Block[]::new);
    }

    public SimpleHolder<Block> registerPlanks(String name, MapColor mapColor) {
        SimpleHolder<Block> planks = this.registerBlock(name, BlockBehaviour.Properties.of().mapColor(mapColor).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava());
        PLANKS.add(planks);
        return planks;
    }

    public SimpleHolder<SaplingBlock> registerSapling(String name, TreeGrower treeGrower) {
        SimpleHolder<SaplingBlock> sapling = this.registerBlock(name, properties -> new SaplingBlock(treeGrower, properties), () -> BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY));
        SAPLINGS.add(sapling);
        return sapling;
    }

    public SimpleHolder<RotatedPillarBlock> registerLog(String name, MapColor topColor, MapColor sideColor) {
        SimpleHolder<RotatedPillarBlock> log = this.registerBlock(name, RotatedPillarBlock::new, () -> FABlocks.logProperties(topColor, sideColor));
        LOGS.add(log);
        return log;
    }

    public SimpleHolder<RotatedPillarBlock> registerStrippedLog(String name, MapColor mapColor) {
        SimpleHolder<RotatedPillarBlock> strippedLog = this.registerBlock(name, RotatedPillarBlock::new, () -> FABlocks.logProperties(mapColor, mapColor));
        STRIPPED_LOGS.add(strippedLog);
        return strippedLog;
    }

    public SimpleHolder<RotatedPillarBlock> registerWood(String name, MapColor mapColor) {
        SimpleHolder<RotatedPillarBlock> wood = this.registerBlock(name, RotatedPillarBlock::new, () -> BlockBehaviour.Properties.of().mapColor(mapColor).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava());
        WOOD.add(wood);
        return wood;
    }

    public SimpleHolder<RotatedPillarBlock> registerStrippedWood(String name, MapColor mapColor) {
        SimpleHolder<RotatedPillarBlock> strippedWood = this.registerBlock(name, RotatedPillarBlock::new, () -> BlockBehaviour.Properties.of().mapColor(mapColor).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava());
        STRIPPED_WOOD.add(strippedWood);
        return strippedWood;
    }

    public SimpleHolder<LeavesBlock> registerLeaves(String name) {
        SimpleHolder<LeavesBlock> leaves = this.registerBlock(name, LeavesBlock::new, () -> FABlocks.leavesProperties(SoundType.GRASS));
        LEAVES.add(leaves);
        return leaves;
    }

    public SimpleHolder<StairBlock> registerStairs(String name, Supplier<Block> planks) {
        SimpleHolder<StairBlock> stairs = this.registerBlock(name, properties -> new StairBlock(planks.get().defaultBlockState(), properties), () -> BlockBehaviour.Properties.ofFullCopy(planks.get()));
        STAIRS.add(stairs);
        return stairs;
    }

    public SimpleHolder<FossilsStandingSignBlock> registerSign(String name, WoodType woodType, MapColor mapColor) {
        SimpleHolder<FossilsStandingSignBlock> sign = this.registerBlock(name, properties -> new FossilsStandingSignBlock(woodType, properties), () -> BlockBehaviour.Properties.of().mapColor(mapColor).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava());
        SIGNS.add(sign);
        ALL_SIGNS.add(sign);
        return sign;
    }

    public SimpleHolder<FossilsWallSignBlock> registerWallSign(String name, Supplier<FossilsStandingSignBlock> signBlock) {
        SimpleHolder<FossilsWallSignBlock> wallSign = this.registerBlock(name, properties -> new FossilsWallSignBlock(signBlock.get().type(), properties), () -> FABlocks.wallVariant(signBlock.get(), signBlock.get().properties(), false));
        WALL_SIGNS.add(wallSign);
        ALL_SIGNS.add(wallSign);
        return wallSign;
    }

    public SimpleHolder<DoorBlock> registerDoor(String name, BlockSetType blockSetType, Supplier<Block> planks) {
        SimpleHolder<DoorBlock> door = this.registerBlock(name, properties -> new DoorBlock(blockSetType, properties), () -> BlockBehaviour.Properties.of().mapColor(planks.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
        DOORS.add(door);
        return door;
    }

    public SimpleHolder<FossilsCeilingHangingSignBlock> registerHangingSign(String name, WoodType woodType, Supplier<RotatedPillarBlock> logBlock) {
        SimpleHolder<FossilsCeilingHangingSignBlock> hangingSign = this.registerBlock(name, properties -> new FossilsCeilingHangingSignBlock(woodType, properties), () -> BlockBehaviour.Properties.of().mapColor(logBlock.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava());
        HANGING_SIGNS.add(hangingSign);
        ALL_HANGING_SIGNS.add(hangingSign);
        return hangingSign;
    }

    public SimpleHolder<FossilsWallHangingSignBlock> registerWallHangingSign(String name, Supplier<FossilsCeilingHangingSignBlock> hangingSign) {
        SimpleHolder<FossilsWallHangingSignBlock> wallHangingSign = this.registerBlock(name, properties -> new FossilsWallHangingSignBlock(hangingSign.get().type(), properties), () -> FABlocks.wallVariant(hangingSign.get(), hangingSign.get().properties(), false));
        WALL_HANGING_SIGNS.add(wallHangingSign);
        ALL_HANGING_SIGNS.add(wallHangingSign);
        return wallHangingSign;
    }

    public SimpleHolder<PressurePlateBlock> registerPressurePlate(String name, BlockSetType blockSetType, Supplier<Block> planks) {
        SimpleHolder<PressurePlateBlock> pressurePlate = this.registerBlock(name, properties -> new PressurePlateBlock(blockSetType, properties), () -> BlockBehaviour.Properties.of().mapColor(planks.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY));
        PRESSURE_PLATES.add(pressurePlate);
        return pressurePlate;
    }

    public SimpleHolder<FenceBlock> registerFence(String name, Supplier<Block> planks) {
        SimpleHolder<FenceBlock> fence = this.registerBlock(name, FenceBlock::new, () -> BlockBehaviour.Properties.of().mapColor(planks.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava());
        FENCES.add(fence);
        return fence;
    }

    public SimpleHolder<TrapDoorBlock> registerTrapdoor(String name, BlockSetType blockSetType, MapColor mapColor) {
        SimpleHolder<TrapDoorBlock> trapDoor = this.registerBlock(name, properties -> new TrapDoorBlock(blockSetType, properties), () -> BlockBehaviour.Properties.of().mapColor(mapColor).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(BlockUtils::never).ignitedByLava());
        TRAPDOORS.add(trapDoor);
        return trapDoor;
    }

    public SimpleHolder<FenceGateBlock> registerFenceGate(String name, WoodType woodType, Supplier<Block> planks) {
        SimpleHolder<FenceGateBlock> fenceGate = this.registerBlock(name, properties -> new FenceGateBlock(woodType, properties), () -> BlockBehaviour.Properties.of().mapColor(planks.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava());
        FENCE_GATES.add(fenceGate);
        return fenceGate;
    }

    public SimpleHolder<FlowerPotBlock> registerPottedSapling(String name, Supplier<SaplingBlock> sapling) {
        SimpleHolder<FlowerPotBlock> flowerPot = this.registerBlock(name, properties -> new FlowerPotBlock(sapling.get(), properties), FABlocks::flowerPotProperties);
        POTTED_SAPLINGS.add(flowerPot);
        return flowerPot;
    }

    public SimpleHolder<ButtonBlock> registerButton(String name, BlockSetType blockSetType) {
        SimpleHolder<ButtonBlock> button = this.registerBlock(name, properties -> new ButtonBlock(blockSetType, 30, properties), FABlocks::buttonProperties);
        BUTTONS.add(button);
        return button;
    }

    public SimpleHolder<SlabBlock> registerSlab(String name, MapColor mapColor) {
        SimpleHolder<SlabBlock> slab = this.registerBlock(name, SlabBlock::new, () -> BlockBehaviour.Properties.of().mapColor(mapColor).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava());
        SLABS.add(slab);
        return slab;
    }

    public SimpleHolder<HeadBlock> registerHead(FAHeadTypes faHeadTypes) {
        SimpleHolder<HeadBlock> head = this.registerBlock(faHeadTypes.getSerializedName() + "_head", properties -> new HeadBlock(faHeadTypes, properties), () -> BlockBehaviour.Properties.of().strength(1.0F).pushReaction(PushReaction.DESTROY));
        HEADS.add(head);
        ALL_HEADS.add(head);
        return head;
    }

    public SimpleHolder<WallHeadBlock> registerWallHead(SimpleHolder<HeadBlock> holder) {
        SimpleHolder<WallHeadBlock> wallHead = this.registerBlock("wall_" + holder.getRegisteredName().replace("fossilslegacy:", ""), properties -> new WallHeadBlock(holder.get().getType(), properties), () -> FABlocks.wallVariant(holder.get(), true).strength(1.0F).pushReaction(PushReaction.DESTROY));
        WALL_HEADS.add(wallHead);
        ALL_HEADS.add(wallHead);
        return wallHead;
    }

    public SimpleHolder<Block> registerBlock(String name, BlockBehaviour.Properties properties) {
        return this.blockRegistry.registerBlock(name, properties);
    }

    public SimpleHolder<Block> registerBlock(String name, Supplier<BlockBehaviour.Properties> properties) {
        return this.blockRegistry.registerBlock(name, properties);
    }

    public <T extends Block> SimpleHolder<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> block, Supplier<BlockBehaviour.Properties> properties) {
        return this.blockRegistry.registerBlock(name, block, properties);
    }
}
