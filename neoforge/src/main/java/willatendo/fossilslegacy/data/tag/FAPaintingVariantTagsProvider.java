package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.tags.PaintingVariantTags;
import willatendo.fossilslegacy.server.painting.FAPaintingVariants;

import java.util.concurrent.CompletableFuture;

public class FAPaintingVariantTagsProvider extends PaintingVariantTagsProvider {
    public FAPaintingVariantTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider, String modId) {
        super(packOutput, provider, modId);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(PaintingVariantTags.PLACEABLE).add(FAPaintingVariants.AGE_OF_REPTILES);
    }
}
