package willatendo.missinglinks.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import willatendo.missinglinks.server.block.MissingBlocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class MissingItemTagProvider extends ItemTagsProvider {
    public MissingItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries, CompletableFuture<TagLookup<Block>> blockTags, String modId) {
        super(packOutput, registries, blockTags, modId);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.button(MissingBlocks.ANDESITE_BUTTON.get());
    }

    private void button(Block... buttons) {
        this.tag(ItemTags.STONE_BUTTONS).add(this.toItems(buttons));
    }

    private void pressurePlate(Block... buttons) {
        for (Block button : buttons) {
        }
    }

    private Item[] toItems(Block... blocks) {
        return Stream.of(blocks).map(Block::asItem).toArray(Item[]::new);
    }
}
