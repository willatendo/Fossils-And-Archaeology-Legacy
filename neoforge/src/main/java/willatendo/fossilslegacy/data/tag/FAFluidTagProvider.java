package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.world.level.material.Fluids;
import willatendo.fossilslegacy.server.tags.FAFluidTags;

import java.util.concurrent.CompletableFuture;

public class FAFluidTagProvider extends FluidTagsProvider {
    public FAFluidTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FAFluidTags.PERMAFROST_FREEZABLE).add(Fluids.WATER, Fluids.FLOWING_WATER);
    }
}
