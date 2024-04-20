
package willatendo.fossilslegacy.data;

import java.util.concurrent.CompletableFuture;

import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup.Provider;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.FossilVariant;
import willatendo.fossilslegacy.server.entity.FossilsLegacyFossilVariantTags;
import willatendo.fossilslegacy.server.entity.FossilsLegacyFossilVariants;
import willatendo.simplelibrary.data.tags.SimpleTagsProvider;

public class FossilsLegacyFossilVariantTagProvider extends SimpleTagsProvider<FossilVariant> {
	public FossilsLegacyFossilVariantTagProvider(FabricDataOutput fabricDataOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
		super(fabricDataOutput, FossilsLegacyRegistries.FOSSIL_VARIANTS, provider, modId, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(FossilsLegacyFossilVariantTags.PLACEABLE_FROM_FOSSIL).add(FossilsLegacyFossilVariants.BRACHIOSAURUS.getKey(), FossilsLegacyFossilVariants.FUTABASAURUS.getKey(), FossilsLegacyFossilVariants.PTERANODON.getKey(), FossilsLegacyFossilVariants.TRICERATOPS.getKey());
	}
}
