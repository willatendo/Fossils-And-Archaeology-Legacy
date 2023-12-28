package willatendo.fossilslegacy.data;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.level.material.Fluids;
import willatendo.fossilslegacy.server.fluid.FossilsLegacyFluidTags;
import willatendo.simplelibrary.data.SimpleFluidTagsProvider;
import willatendo.simplelibrary.data.util.ExistingFileHelper;

public class FossilsLegacyFluidTagProvider extends SimpleFluidTagsProvider {
	public FossilsLegacyFluidTagProvider(FabricDataOutput fabricDataOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
		super(fabricDataOutput, provider, modId, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(FossilsLegacyFluidTags.PERMAFROST_FREEZABLE).add(Fluids.WATER);
	}
}
