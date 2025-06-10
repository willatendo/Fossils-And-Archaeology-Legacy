package willatendo.pridelands.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import willatendo.pridelands.server.block.PridelandsBlocks;

import java.util.concurrent.CompletableFuture;

public class PridelandsBlockTagProvider extends BlockTagsProvider {
    public PridelandsBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId) {
        super(output, lookupProvider, modId);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.CANDLE_CAKES).add(PridelandsBlocks.BANANA_CANDLE_CAKE.get(), PridelandsBlocks.WHITE_BANANA_CANDLE_CAKE.get(), PridelandsBlocks.ORANGE_BANANA_CANDLE_CAKE.get(), PridelandsBlocks.MAGENTA_BANANA_CANDLE_CAKE.get(), PridelandsBlocks.LIGHT_BLUE_BANANA_CANDLE_CAKE.get(), PridelandsBlocks.YELLOW_BANANA_CANDLE_CAKE.get(), PridelandsBlocks.LIME_BANANA_CANDLE_CAKE.get(), PridelandsBlocks.PINK_BANANA_CANDLE_CAKE.get(), PridelandsBlocks.GRAY_BANANA_CANDLE_CAKE.get(), PridelandsBlocks.LIGHT_GRAY_BANANA_CANDLE_CAKE.get(), PridelandsBlocks.CYAN_BANANA_CANDLE_CAKE.get(), PridelandsBlocks.PURPLE_BANANA_CANDLE_CAKE.get(), PridelandsBlocks.BLUE_BANANA_CANDLE_CAKE.get(), PridelandsBlocks.BROWN_BANANA_CANDLE_CAKE.get(), PridelandsBlocks.GREEN_BANANA_CANDLE_CAKE.get(), PridelandsBlocks.RED_BANANA_CANDLE_CAKE.get(), PridelandsBlocks.BLACK_BANANA_CANDLE_CAKE.get());
        this.tag(BlockTags.DRAGON_IMMUNE).add(PridelandsBlocks.PRIDELANDS_PORTAL_FRAME.get(), PridelandsBlocks.RAFIKI_TREE_WOOD.get(), PridelandsBlocks.RAFIKI_TREE_BARK.get(), PridelandsBlocks.RAFIKI_TREE_LOG.get());
        this.tag(BlockTags.LOGS).add(PridelandsBlocks.RAFIKI_TREE_WOOD.get(), PridelandsBlocks.RAFIKI_TREE_BARK.get(), PridelandsBlocks.RAFIKI_TREE_LOG.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(PridelandsBlocks.OUTSTONE.get(), PridelandsBlocks.OUTSTONE_SLAB.get(), PridelandsBlocks.OUTSTONE_STAIRS.get(), PridelandsBlocks.OUTSTONE_PRESSURE_PLATE.get(), PridelandsBlocks.OUTSTONE_BRICKS.get(), PridelandsBlocks.OUTSTONE_BRICK_SLAB.get(), PridelandsBlocks.OUTSTONE_BRICK_STAIRS.get(), PridelandsBlocks.OUTSTONE_BRICK_WALL.get(), PridelandsBlocks.PRIDESTONE.get(), PridelandsBlocks.PRIDESTONE_SLAB.get(), PridelandsBlocks.PRIDESTONE_STAIRS.get(), PridelandsBlocks.PRIDESTONE_PRESSURE_PLATE.get(), PridelandsBlocks.PRIDESTONE_BRICKS.get(), PridelandsBlocks.PRIDESTONE_BRICK_SLAB.get(), PridelandsBlocks.PRIDESTONE_BRICK_STAIRS.get(), PridelandsBlocks.PRIDESTONE_BRICK_WALL.get(), PridelandsBlocks.CRACKED_PRIDESTONE_BRICKS.get(), PridelandsBlocks.MOSSY_PRIDESTONE_BRICKS.get(), PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_SLAB.get(), PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_STAIRS.get(), PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_WALL.get(), PridelandsBlocks.PRIDESTONE_COAL_ORE.get(), PridelandsBlocks.PRIDESTONE_SILVER_ORE.get(), PridelandsBlocks.PRIDESTONE_PEACOCK_ORE.get(), PridelandsBlocks.OUTSTONE_NUKA_ORE.get(), PridelandsBlocks.OUTSTONE_KIVULITE_ORE.get());
        this.tag(BlockTags.PORTALS).add(PridelandsBlocks.PRIDELANDS_PORTAL.get());
        this.tag(BlockTags.SLABS).add(PridelandsBlocks.OUTSTONE_SLAB.get(), PridelandsBlocks.OUTSTONE_BRICK_SLAB.get(), PridelandsBlocks.PRIDESTONE_SLAB.get(), PridelandsBlocks.PRIDESTONE_BRICK_SLAB.get(), PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_SLAB.get());
        this.tag(BlockTags.STAIRS).add(PridelandsBlocks.OUTSTONE_STAIRS.get(), PridelandsBlocks.OUTSTONE_BRICK_STAIRS.get(), PridelandsBlocks.PRIDESTONE_STAIRS.get(), PridelandsBlocks.PRIDESTONE_BRICK_STAIRS.get(), PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_STAIRS.get());
        this.tag(BlockTags.STONE_BUTTONS).add(PridelandsBlocks.OUTSTONE_BUTTON.get(), PridelandsBlocks.PRIDESTONE_BUTTON.get());
        this.tag(BlockTags.STONE_PRESSURE_PLATES).add(PridelandsBlocks.OUTSTONE_PRESSURE_PLATE.get(), PridelandsBlocks.PRIDESTONE_PRESSURE_PLATE.get());
        this.tag(BlockTags.WALLS).add(PridelandsBlocks.OUTSTONE_BRICK_WALL.get(), PridelandsBlocks.PRIDESTONE_BRICK_WALL.get(), PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_WALL.get());
        this.tag(BlockTags.WALL_POST_OVERRIDE).add(PridelandsBlocks.OUTSTONE_PRESSURE_PLATE.get(), PridelandsBlocks.PRIDESTONE_PRESSURE_PLATE.get(), PridelandsBlocks.HYENA_BONE_TORCH.get());
        this.tag(BlockTags.WITHER_IMMUNE).add(PridelandsBlocks.PRIDELANDS_PORTAL_FRAME.get(), PridelandsBlocks.RAFIKI_TREE_WOOD.get(), PridelandsBlocks.RAFIKI_TREE_BARK.get(), PridelandsBlocks.RAFIKI_TREE_LOG.get());
        this.tag(BlockTags.WOOL_CARPETS).add(PridelandsBlocks.FUR_RUG.get(), PridelandsBlocks.WHITE_FUR_RUG.get(), PridelandsBlocks.ORANGE_FUR_RUG.get(), PridelandsBlocks.MAGENTA_FUR_RUG.get(), PridelandsBlocks.LIGHT_BLUE_FUR_RUG.get(), PridelandsBlocks.YELLOW_FUR_RUG.get(), PridelandsBlocks.LIME_FUR_RUG.get(), PridelandsBlocks.PINK_FUR_RUG.get(), PridelandsBlocks.GRAY_FUR_RUG.get(), PridelandsBlocks.LIGHT_GRAY_FUR_RUG.get(), PridelandsBlocks.CYAN_FUR_RUG.get(), PridelandsBlocks.PURPLE_FUR_RUG.get(), PridelandsBlocks.BLUE_FUR_RUG.get(), PridelandsBlocks.BROWN_FUR_RUG.get(), PridelandsBlocks.GREEN_FUR_RUG.get(), PridelandsBlocks.RED_FUR_RUG.get(), PridelandsBlocks.BLACK_FUR_RUG.get());

        this.tag(Tags.Blocks.STONES).add(PridelandsBlocks.OUTSTONE.get(), PridelandsBlocks.PRIDESTONE.get());
    }
}
