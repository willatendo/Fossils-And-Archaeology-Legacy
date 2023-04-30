package fossilslegacy.data;

import java.util.concurrent.CompletableFuture;

import fossilslegacy.server.fluid.FossilsLegacyFluidTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.data.ExistingFileHelper;

public class FossilsLegacyFluidTagProvider extends FluidTagsProvider {
	public FossilsLegacyFluidTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
		super(packOutput, provider, modId, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(FossilsLegacyFluidTags.PERMAFROST_FREEZABLE).add(Fluids.WATER);
	}
}
