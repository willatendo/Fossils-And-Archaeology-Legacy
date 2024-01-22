package willatendo.fossilslegacy.data;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.tags.EntityTypeTags;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;
import willatendo.simplelibrary.data.tags.SimpleEntityTypeTagsProvider;
import willatendo.simplelibrary.data.util.ExistingFileHelper;

public class FossilsLegacyEntityTypeTagProvider extends SimpleEntityTypeTagsProvider {
	public FossilsLegacyEntityTypeTagProvider(FabricDataOutput fabricDataOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
		super(fabricDataOutput, provider, modId, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(EntityTypeTags.FALL_DAMAGE_IMMUNE).add(FossilsLegacyEntities.PTERANODON.get());
		this.tag(EntityTypeTags.CAN_BREATHE_UNDER_WATER).add(FossilsLegacyEntities.MOSASAURUS.get());
	}
}
