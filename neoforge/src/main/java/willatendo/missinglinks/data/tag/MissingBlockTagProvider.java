package willatendo.missinglinks.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import willatendo.missinglinks.server.block.MissingBlocks;

import java.util.concurrent.CompletableFuture;

public class MissingBlockTagProvider extends BlockTagsProvider {
    public MissingBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId) {
        super(output, lookupProvider, modId);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.button(MissingBlocks.ANDESITE_BUTTON.get(), MissingBlocks.COBBLESTONE_BUTTON.get(), MissingBlocks.DIORITE_BUTTON.get(), MissingBlocks.GRANITE_BUTTON.get(), MissingBlocks.COBBLED_DEEPSLATE_BUTTON.get(), MissingBlocks.TUFF_BUTTON.get());
        this.pressurePlate(MissingBlocks.ANDESITE_PRESSURE_PLATE.get(), MissingBlocks.COBBLESTONE_PRESSURE_PLATE.get(), MissingBlocks.DIORITE_PRESSURE_PLATE.get(), MissingBlocks.GRANITE_PRESSURE_PLATE.get(), MissingBlocks.COBBLED_DEEPSLATE_PRESSURE_PLATE.get(), MissingBlocks.TUFF_PRESSURE_PLATE.get());
        this.slab(MissingBlocks.CALCITE_SLAB.get());
        this.stair(MissingBlocks.CALCITE_STAIRS.get());
        this.wall(MissingBlocks.CALCITE_WALL.get(), MissingBlocks.STONE_WALL.get());
    }

    private void button(Block... buttons) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(buttons);
        this.tag(BlockTags.STONE_BUTTONS).add(buttons);
    }

    private void pressurePlate(Block... pressurePlates) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(pressurePlates);
        this.tag(BlockTags.STONE_PRESSURE_PLATES).add(pressurePlates);
        this.tag(BlockTags.WALL_POST_OVERRIDE).add(pressurePlates);
    }

    private void slab(Block... slabs) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(slabs);
        this.tag(BlockTags.SLABS).add(slabs);
    }

    private void stair(Block... stairs) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(stairs);
        this.tag(BlockTags.STAIRS).add(stairs);
    }

    private void wall(Block... walls) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(walls);
        this.tag(BlockTags.WALLS).add(walls);
    }
}
