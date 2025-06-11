package willatendo.missinglinks.data;

import net.minecraft.data.PackOutput;
import willatendo.missinglinks.server.block.MissingBlocks;
import willatendo.missinglinks.server.item.MissingCreativeModeTabs;
import willatendo.simplelibrary.data.SimpleLanguageProvider;

public class MissingLanguageProvider extends SimpleLanguageProvider {
    public MissingLanguageProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        // Blocks
        this.add(MissingBlocks.ANDESITE_BUTTON.get());
        this.add(MissingBlocks.ANDESITE_PRESSURE_PLATE.get());
        this.add(MissingBlocks.ANDESITE_LEVER.get());
        this.add(MissingBlocks.CALCITE_SLAB.get());
        this.add(MissingBlocks.CALCITE_STAIRS.get());
        this.add(MissingBlocks.CALCITE_WALL.get());
        this.add(MissingBlocks.CALCITE_BUTTON.get());
        this.add(MissingBlocks.CALCITE_PRESSURE_PLATE.get());
        this.add(MissingBlocks.CALCITE_LEVER.get());
        this.add(MissingBlocks.COBBLED_DEEPSLATE_BUTTON.get());
        this.add(MissingBlocks.COBBLED_DEEPSLATE_PRESSURE_PLATE.get());
        this.add(MissingBlocks.COBBLED_DEEPSLATE_LEVER.get());
        this.add(MissingBlocks.COBBLESTONE_BUTTON.get());
        this.add(MissingBlocks.COBBLESTONE_PRESSURE_PLATE.get());
        this.add(MissingBlocks.DIORITE_BUTTON.get());
        this.add(MissingBlocks.DIORITE_PRESSURE_PLATE.get());
        this.add(MissingBlocks.DIORITE_LEVER.get());
        this.add(MissingBlocks.GRANITE_BUTTON.get());
        this.add(MissingBlocks.GRANITE_PRESSURE_PLATE.get());
        this.add(MissingBlocks.GRANITE_LEVER.get());
        this.add(MissingBlocks.TUFF_BUTTON.get());
        this.add(MissingBlocks.TUFF_PRESSURE_PLATE.get());
        this.add(MissingBlocks.TUFF_LEVER.get());
        this.add(MissingBlocks.STONE_LEVER.get());
        this.add(MissingBlocks.STONE_WALL.get());

        // Creative Mode Tabs
        this.add(MissingCreativeModeTabs.MISSING_BLOCKS.get(), "Missing Blocks");
    }
}
