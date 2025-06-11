package willatendo.pridelands.data;

import net.minecraft.data.PackOutput;
import willatendo.pridelands.server.block.PridelandsBlocks;
import willatendo.pridelands.server.item.PridelandsCreativeModeTabs;
import willatendo.pridelands.server.item.PridelandsItems;
import willatendo.simplelibrary.data.SimpleLanguageProvider;

public class PridelandsLanguageProvider extends SimpleLanguageProvider {
    public PridelandsLanguageProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        // Blocks
        this.add(PridelandsBlocks.OUTSTONE.get());
        this.add(PridelandsBlocks.OUTSTONE_SLAB.get());
        this.add(PridelandsBlocks.OUTSTONE_STAIRS.get());
        this.add(PridelandsBlocks.OUTSTONE_PRESSURE_PLATE.get());
        this.add(PridelandsBlocks.OUTSTONE_BUTTON.get());
        this.add(PridelandsBlocks.OUTSTONE_BRICKS.get());
        this.add(PridelandsBlocks.OUTSTONE_BRICK_SLAB.get());
        this.add(PridelandsBlocks.OUTSTONE_BRICK_STAIRS.get());
        this.add(PridelandsBlocks.OUTSTONE_BRICK_WALL.get());
        this.add(PridelandsBlocks.PRIDESTONE.get());
        this.add(PridelandsBlocks.PRIDESTONE_SLAB.get());
        this.add(PridelandsBlocks.PRIDESTONE_STAIRS.get());
        this.add(PridelandsBlocks.PRIDESTONE_PRESSURE_PLATE.get());
        this.add(PridelandsBlocks.PRIDESTONE_BUTTON.get());
        this.add(PridelandsBlocks.PRIDESTONE_BRICKS.get());
        this.add(PridelandsBlocks.PRIDESTONE_BRICK_SLAB.get());
        this.add(PridelandsBlocks.PRIDESTONE_BRICK_STAIRS.get());
        this.add(PridelandsBlocks.PRIDESTONE_BRICK_WALL.get());
        this.add(PridelandsBlocks.CRACKED_PRIDESTONE_BRICKS.get());
        this.add(PridelandsBlocks.MOSSY_PRIDESTONE_BRICKS.get());
        this.add(PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_SLAB.get());
        this.add(PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_STAIRS.get());
        this.add(PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_WALL.get());
        this.add(PridelandsBlocks.PRIDESTONE_COAL_ORE.get());
        this.add(PridelandsBlocks.PRIDESTONE_SILVER_ORE.get());
        this.add(PridelandsBlocks.PRIDESTONE_PEACOCK_ORE.get());
        this.add(PridelandsBlocks.OUTSTONE_NUKA_ORE.get());
        this.add(PridelandsBlocks.OUTSTONE_KIVULITE_ORE.get());
        this.add(PridelandsBlocks.PRIDELANDS_PORTAL_FRAME.get());
        this.add(PridelandsBlocks.OUTLANDS_PORTAL_FRAME.get());
        this.add(PridelandsBlocks.RAFIKI_TREE_WOOD.get());
        this.add(PridelandsBlocks.RAFIKI_TREE_BARK.get());
        this.add(PridelandsBlocks.RAFIKI_TREE_LOG.get());
        this.add(PridelandsBlocks.FUR_RUG.get());
        this.add(PridelandsBlocks.WHITE_FUR_RUG.get());
        this.add(PridelandsBlocks.ORANGE_FUR_RUG.get());
        this.add(PridelandsBlocks.MAGENTA_FUR_RUG.get());
        this.add(PridelandsBlocks.LIGHT_BLUE_FUR_RUG.get());
        this.add(PridelandsBlocks.YELLOW_FUR_RUG.get());
        this.add(PridelandsBlocks.LIME_FUR_RUG.get());
        this.add(PridelandsBlocks.PINK_FUR_RUG.get());
        this.add(PridelandsBlocks.GRAY_FUR_RUG.get());
        this.add(PridelandsBlocks.LIGHT_GRAY_FUR_RUG.get());
        this.add(PridelandsBlocks.CYAN_FUR_RUG.get());
        this.add(PridelandsBlocks.PURPLE_FUR_RUG.get());
        this.add(PridelandsBlocks.BLUE_FUR_RUG.get());
        this.add(PridelandsBlocks.BROWN_FUR_RUG.get());
        this.add(PridelandsBlocks.GREEN_FUR_RUG.get());
        this.add(PridelandsBlocks.RED_FUR_RUG.get());
        this.add(PridelandsBlocks.BLACK_FUR_RUG.get());
        this.add(PridelandsBlocks.BANANA_CAKE.get());
        this.add(PridelandsBlocks.HYENA_BONE_TORCH.get());
        this.add(PridelandsBlocks.ACACIA_BONGO.get());
        this.add(PridelandsBlocks.BANANA_BONGO.get());
        this.add(PridelandsBlocks.DEAD_WOOD_BONGO.get());
        this.add(PridelandsBlocks.MANGO_BONGO.get());
        this.add(PridelandsBlocks.PASSION_BONGO.get());
        this.add(PridelandsBlocks.RAINFOREST_BONGO.get());

        // Creative Mode Tabs
        this.add(PridelandsCreativeModeTabs.PRIDELANDS_BLOCKS.get(), "Pridelands Blocks");
        this.add(PridelandsCreativeModeTabs.PRIDELANDS_ITEMS.get(), "Pridelands Items");

        // Items
        this.add(PridelandsItems.LION.get());
        this.add(PridelandsItems.COOKED_LION.get());
        this.add(PridelandsItems.MANGO.get());
        this.add(PridelandsItems.CHOCOLATE_MUFASA.get());
        this.add(PridelandsItems.ZEBRA.get());
        this.add(PridelandsItems.COOKED_ZEBRA.get());
        this.add(PridelandsItems.RHINO.get());
        this.add(PridelandsItems.COOKED_RHINO.get());
        this.add(PridelandsItems.MANGO_JUICE_PRIDESTONE_JAR.get());
        this.add(PridelandsItems.CORN.get());
        this.add(PridelandsItems.POPCORN.get());
        this.add(PridelandsItems.OUTLANDER.get());
        this.add(PridelandsItems.BUG_STEW.get());
        this.add(PridelandsItems.CROCODILE.get());
        this.add(PridelandsItems.KIWANO_SLICE.get());
        this.add(PridelandsItems.YAM.get());
        this.add(PridelandsItems.ROASTED_YAM.get());
        this.add(PridelandsItems.BANANA.get());
        this.add(PridelandsItems.BANANA_BREAD.get());
        this.add(PridelandsItems.HYENA_BONE.get());
        this.add(PridelandsItems.BLUE_FEATHER.get());
        this.add(PridelandsItems.YELLOW_FEATHER.get());
        this.add(PridelandsItems.RED_FEATHER.get());
        this.add(PridelandsItems.HYENA_BONE_SHARD.get());
        this.add(PridelandsItems.ZEBRA_HIDE.get());
        this.add(PridelandsItems.SILVER_INGOT.get());
        this.add(PridelandsItems.GROUND_TERMITE.get());
        this.add(PridelandsItems.LION_FUR.get());
        this.add(PridelandsItems.RHINO_HORN.get());
        this.add(PridelandsItems.GROUND_RHINO_HORN.get());
        this.add(PridelandsItems.GEMSBOK_HIDE.get());
        this.add(PridelandsItems.GEMSBOK_HORN.get());
        this.add(PridelandsItems.PEACOCK_GEM.get());
        this.add(PridelandsItems.MAIZE_STALKS.get());
        this.add(PridelandsItems.NUKA_SHARD.get());
        this.add(PridelandsItems.OUTLANDER_FUR.get());
        this.add(PridelandsItems.KIVULITE_INGOT.get());
        this.add(PridelandsItems.POISON_POWDER.get());
        this.add(PridelandsItems.ZAZU_EGG.get());
        this.add(PridelandsItems.KIWANO_SEEDS.get());
        this.add(PridelandsItems.FLAMINGO_FEATHER.get());
        this.add(PridelandsItems.HYENA_MEAL.get());
        this.add(PridelandsItems.CORN_KERNELS.get());
        this.add(PridelandsItems.DRIED_MAIZE.get());
        this.add(PridelandsItems.PRIDESTONE_JAR.get());
        this.add(PridelandsItems.WATER_PRIDESTONE_JAR.get());
        this.add(PridelandsItems.LAVA_PRIDESTONE_JAR.get());
        this.add(PridelandsItems.ZEBRA_MILK_PRIDESTONE_JAR.get());
        this.add(PridelandsItems.C_NOTE.get());
        this.add(PridelandsItems.D_NOTE.get());
        this.add(PridelandsItems.E_NOTE.get());
        this.add(PridelandsItems.F_NOTE.get());
        this.add(PridelandsItems.G_NOTE.get());
        this.add(PridelandsItems.A_NOTE.get());
        this.add(PridelandsItems.B_NOTE.get());
        this.add(PridelandsItems.PRIDESTONE_SWORD.get());
        this.add(PridelandsItems.PRIDESTONE_SHOVEL.get());
        this.add(PridelandsItems.PRIDESTONE_PICKAXE.get());
        this.add(PridelandsItems.PRIDESTONE_AXE.get());
        this.add(PridelandsItems.PRIDESTONE_HOE.get());
        this.add(PridelandsItems.SILVER_SWORD.get());
        this.add(PridelandsItems.SILVER_SHOVEL.get());
        this.add(PridelandsItems.SILVER_PICKAXE.get());
        this.add(PridelandsItems.SILVER_AXE.get());
        this.add(PridelandsItems.SILVER_HOE.get());
        this.add(PridelandsItems.PEACOCK_SWORD.get());
        this.add(PridelandsItems.PEACOCK_SHOVEL.get());
        this.add(PridelandsItems.PEACOCK_PICKAXE.get());
        this.add(PridelandsItems.PEACOCK_AXE.get());
        this.add(PridelandsItems.PEACOCK_HOE.get());
        this.add(PridelandsItems.LION_KING_TICKET.get());

        // Sounds
        this.add("subtitles.block.bongo.hit", "Bongo hit");
    }
}
