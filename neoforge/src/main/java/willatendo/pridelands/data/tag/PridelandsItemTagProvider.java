package willatendo.pridelands.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import willatendo.pridelands.server.item.PridelandsItems;

import java.util.concurrent.CompletableFuture;

public class PridelandsItemTagProvider extends ItemTagsProvider {
    public PridelandsItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries, CompletableFuture<TagLookup<Block>> blockTags, String modId) {
        super(packOutput, registries, blockTags, modId);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.MEAT).add(PridelandsItems.LION.get(), PridelandsItems.COOKED_LION.get(), PridelandsItems.ZEBRA.get(), PridelandsItems.COOKED_ZEBRA.get(), PridelandsItems.RHINO.get(), PridelandsItems.COOKED_RHINO.get(), PridelandsItems.OUTLANDER.get(), PridelandsItems.CROCODILE.get());
        this.tag(ItemTags.PIG_FOOD).add(PridelandsItems.YAM.get());
        this.tag(ItemTags.VILLAGER_PLANTABLE_SEEDS).add(PridelandsItems.YAM.get());

        this.tag(Tags.Items.FOODS_FRUIT).add(PridelandsItems.MANGO.get(), PridelandsItems.KIWANO_SLICE.get());
        this.tag(Tags.Items.FOODS_COOKED_MEAT).add(PridelandsItems.COOKED_LION.get(), PridelandsItems.COOKED_ZEBRA.get(), PridelandsItems.COOKED_RHINO.get());
        this.tag(Tags.Items.FOODS_RAW_MEAT).add(PridelandsItems.LION.get(), PridelandsItems.ZEBRA.get(), PridelandsItems.RHINO.get(), PridelandsItems.OUTLANDER.get(), PridelandsItems.CROCODILE.get());
    }
}
