package willatendo.missinglinks.data.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;
import willatendo.missinglinks.server.block.MissingBlocks;
import willatendo.missinglinks.server.util.MissingLinks2Utils;
import willatendo.simplelibrary.data.loot.SimpleBlockLootSubProvider;

public class MissingBlockLootSubProvider extends SimpleBlockLootSubProvider {
    public MissingBlockLootSubProvider(HolderLookup.Provider registries) {
        super(registries, MissingLinks2Utils.ID);
    }

    @Override
    protected void generate() {
        this.dropSelf(MissingBlocks.ANDESITE_BUTTON.get());
        this.dropSelf(MissingBlocks.ANDESITE_PRESSURE_PLATE.get());
        this.dropSelf(MissingBlocks.ANDESITE_LEVER.get());
        this.slabDropSelf(MissingBlocks.CALCITE_SLAB.get());
        this.dropSelf(MissingBlocks.CALCITE_STAIRS.get());
        this.dropSelf(MissingBlocks.CALCITE_WALL.get());
        this.dropSelf(MissingBlocks.CALCITE_BUTTON.get());
        this.dropSelf(MissingBlocks.CALCITE_PRESSURE_PLATE.get());
        this.dropSelf(MissingBlocks.CALCITE_LEVER.get());
        this.dropSelf(MissingBlocks.COBBLED_DEEPSLATE_BUTTON.get());
        this.dropSelf(MissingBlocks.COBBLED_DEEPSLATE_PRESSURE_PLATE.get());
        this.dropSelf(MissingBlocks.COBBLED_DEEPSLATE_LEVER.get());
        this.dropSelf(MissingBlocks.COBBLESTONE_BUTTON.get());
        this.dropSelf(MissingBlocks.COBBLESTONE_PRESSURE_PLATE.get());
        this.dropSelf(MissingBlocks.DIORITE_BUTTON.get());
        this.dropSelf(MissingBlocks.DIORITE_PRESSURE_PLATE.get());
        this.dropSelf(MissingBlocks.DIORITE_LEVER.get());
        this.dropSelf(MissingBlocks.GRANITE_BUTTON.get());
        this.dropSelf(MissingBlocks.GRANITE_PRESSURE_PLATE.get());
        this.dropSelf(MissingBlocks.GRANITE_LEVER.get());
        this.dropSelf(MissingBlocks.TUFF_BUTTON.get());
        this.dropSelf(MissingBlocks.TUFF_PRESSURE_PLATE.get());
        this.dropSelf(MissingBlocks.TUFF_LEVER.get());
        this.dropSelf(MissingBlocks.STONE_LEVER.get());
        this.dropSelf(MissingBlocks.STONE_WALL.get());
    }

    private void slabDropSelf(Block slab) {
        this.add(slab, this::createSlabItemTable);
    }
}
