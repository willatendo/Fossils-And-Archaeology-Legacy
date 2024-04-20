
package willatendo.fossilslegacy.data;

import java.util.concurrent.CompletableFuture;

import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.tags.EntityTypeTags;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.simplelibrary.data.tags.SimpleEntityTypeTagsProvider;

public class FossilsLegacyEntityTypeTagProvider extends SimpleEntityTypeTagsProvider {
	public FossilsLegacyEntityTypeTagProvider(FabricDataOutput fabricDataOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
		super(fabricDataOutput, provider, modId, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(EntityTypeTags.FALL_DAMAGE_IMMUNE).add(FossilsLegacyEntityTypes.PTERANODON.get());
		this.tag(EntityTypeTags.CAN_BREATHE_UNDER_WATER).add(FossilsLegacyEntityTypes.MOSASAURUS.get(), FossilsLegacyEntityTypes.FUTABASAURUS.get());
	}
}
