package willatendo.pridelands.data.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.level.block.Blocks;
import willatendo.pridelands.server.block.PridelandsBlocks;
import willatendo.pridelands.server.utils.PridelandsUtils;
import willatendo.simplelibrary.data.loot.SimpleBlockLootSubProvider;

public class PridelandsBlockLootSubProvider extends SimpleBlockLootSubProvider {
    public PridelandsBlockLootSubProvider(HolderLookup.Provider registries) {
        super(registries, PridelandsUtils.ID);
    }

    @Override
    protected void generate() {
        this.dropSelf(PridelandsBlocks.OUTSTONE.get());
        this.add(PridelandsBlocks.OUTSTONE_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(PridelandsBlocks.OUTSTONE_STAIRS.get());
        this.dropSelf(PridelandsBlocks.OUTSTONE_PRESSURE_PLATE.get());
        this.dropSelf(PridelandsBlocks.OUTSTONE_BUTTON.get());
        this.dropSelf(PridelandsBlocks.OUTSTONE_BRICKS.get());
        this.add(PridelandsBlocks.OUTSTONE_BRICK_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(PridelandsBlocks.OUTSTONE_BRICK_STAIRS.get());
        this.dropSelf(PridelandsBlocks.OUTSTONE_BRICK_WALL.get());
        this.dropSelf(PridelandsBlocks.PRIDESTONE.get());
        this.add(PridelandsBlocks.PRIDESTONE_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(PridelandsBlocks.PRIDESTONE_STAIRS.get());
        this.dropSelf(PridelandsBlocks.PRIDESTONE_PRESSURE_PLATE.get());
        this.dropSelf(PridelandsBlocks.PRIDESTONE_BUTTON.get());
        this.dropSelf(PridelandsBlocks.PRIDESTONE_BRICKS.get());
        this.add(PridelandsBlocks.PRIDESTONE_BRICK_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(PridelandsBlocks.PRIDESTONE_BRICK_STAIRS.get());
        this.dropSelf(PridelandsBlocks.PRIDESTONE_BRICK_WALL.get());
        this.dropSelf(PridelandsBlocks.CRACKED_PRIDESTONE_BRICKS.get());
        this.dropSelf(PridelandsBlocks.MOSSY_PRIDESTONE_BRICKS.get());
        this.add(PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_STAIRS.get());
        this.dropSelf(PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_WALL.get());
        this.dropSelf(PridelandsBlocks.PRIDESTONE_COAL_ORE.get());
        this.dropSelf(PridelandsBlocks.PRIDESTONE_SILVER_ORE.get());
        this.dropSelf(PridelandsBlocks.PRIDESTONE_PEACOCK_ORE.get());
        this.dropSelf(PridelandsBlocks.OUTSTONE_NUKA_ORE.get());
        this.dropSelf(PridelandsBlocks.OUTSTONE_KIVULITE_ORE.get());
        this.add(PridelandsBlocks.PRIDELANDS_PORTAL.get(), BlockLootSubProvider.noDrop());
        this.dropSelf(PridelandsBlocks.FUR_RUG.get());
        this.dropSelf(PridelandsBlocks.WHITE_FUR_RUG.get());
        this.dropSelf(PridelandsBlocks.ORANGE_FUR_RUG.get());
        this.dropSelf(PridelandsBlocks.MAGENTA_FUR_RUG.get());
        this.dropSelf(PridelandsBlocks.LIGHT_BLUE_FUR_RUG.get());
        this.dropSelf(PridelandsBlocks.YELLOW_FUR_RUG.get());
        this.dropSelf(PridelandsBlocks.LIME_FUR_RUG.get());
        this.dropSelf(PridelandsBlocks.PINK_FUR_RUG.get());
        this.dropSelf(PridelandsBlocks.GRAY_FUR_RUG.get());
        this.dropSelf(PridelandsBlocks.LIGHT_GRAY_FUR_RUG.get());
        this.dropSelf(PridelandsBlocks.CYAN_FUR_RUG.get());
        this.dropSelf(PridelandsBlocks.PURPLE_FUR_RUG.get());
        this.dropSelf(PridelandsBlocks.BLUE_FUR_RUG.get());
        this.dropSelf(PridelandsBlocks.BROWN_FUR_RUG.get());
        this.dropSelf(PridelandsBlocks.GREEN_FUR_RUG.get());
        this.dropSelf(PridelandsBlocks.RED_FUR_RUG.get());
        this.dropSelf(PridelandsBlocks.BLACK_FUR_RUG.get());
        this.add(PridelandsBlocks.BANANA_CAKE.get(), BlockLootSubProvider.noDrop());
        this.add(PridelandsBlocks.BANANA_CANDLE_CAKE.get(), BlockLootSubProvider.createCandleCakeDrops(Blocks.CANDLE));
        this.add(PridelandsBlocks.WHITE_BANANA_CANDLE_CAKE.get(), BlockLootSubProvider.createCandleCakeDrops(Blocks.WHITE_CANDLE));
        this.add(PridelandsBlocks.ORANGE_BANANA_CANDLE_CAKE.get(), BlockLootSubProvider.createCandleCakeDrops(Blocks.ORANGE_CANDLE));
        this.add(PridelandsBlocks.MAGENTA_BANANA_CANDLE_CAKE.get(), BlockLootSubProvider.createCandleCakeDrops(Blocks.MAGENTA_CANDLE));
        this.add(PridelandsBlocks.LIGHT_BLUE_BANANA_CANDLE_CAKE.get(), BlockLootSubProvider.createCandleCakeDrops(Blocks.LIGHT_BLUE_CANDLE));
        this.add(PridelandsBlocks.YELLOW_BANANA_CANDLE_CAKE.get(), BlockLootSubProvider.createCandleCakeDrops(Blocks.YELLOW_CANDLE));
        this.add(PridelandsBlocks.LIME_BANANA_CANDLE_CAKE.get(), BlockLootSubProvider.createCandleCakeDrops(Blocks.LIME_CANDLE));
        this.add(PridelandsBlocks.PINK_BANANA_CANDLE_CAKE.get(), BlockLootSubProvider.createCandleCakeDrops(Blocks.PINK_CANDLE));
        this.add(PridelandsBlocks.GRAY_BANANA_CANDLE_CAKE.get(), BlockLootSubProvider.createCandleCakeDrops(Blocks.GRAY_CANDLE));
        this.add(PridelandsBlocks.LIGHT_GRAY_BANANA_CANDLE_CAKE.get(), BlockLootSubProvider.createCandleCakeDrops(Blocks.LIGHT_GRAY_CANDLE));
        this.add(PridelandsBlocks.CYAN_BANANA_CANDLE_CAKE.get(), BlockLootSubProvider.createCandleCakeDrops(Blocks.CYAN_CANDLE));
        this.add(PridelandsBlocks.PURPLE_BANANA_CANDLE_CAKE.get(), BlockLootSubProvider.createCandleCakeDrops(Blocks.PURPLE_CANDLE));
        this.add(PridelandsBlocks.BLUE_BANANA_CANDLE_CAKE.get(), BlockLootSubProvider.createCandleCakeDrops(Blocks.BLUE_CANDLE));
        this.add(PridelandsBlocks.BROWN_BANANA_CANDLE_CAKE.get(), BlockLootSubProvider.createCandleCakeDrops(Blocks.BROWN_CANDLE));
        this.add(PridelandsBlocks.GREEN_BANANA_CANDLE_CAKE.get(), BlockLootSubProvider.createCandleCakeDrops(Blocks.GREEN_CANDLE));
        this.add(PridelandsBlocks.RED_BANANA_CANDLE_CAKE.get(), BlockLootSubProvider.createCandleCakeDrops(Blocks.RED_CANDLE));
        this.add(PridelandsBlocks.BLACK_BANANA_CANDLE_CAKE.get(), BlockLootSubProvider.createCandleCakeDrops(Blocks.BLACK_CANDLE));
        this.dropSelf(PridelandsBlocks.ACACIA_BONGO.get());
        this.dropSelf(PridelandsBlocks.BANANA_BONGO.get());
        this.dropSelf(PridelandsBlocks.DEAD_WOOD_BONGO.get());
        this.dropSelf(PridelandsBlocks.MANGO_BONGO.get());
        this.dropSelf(PridelandsBlocks.PASSION_BONGO.get());
        this.dropSelf(PridelandsBlocks.RAINFOREST_BONGO.get());
        this.dropSelf(PridelandsBlocks.HYENA_BONE_TORCH.get());
    }
}
