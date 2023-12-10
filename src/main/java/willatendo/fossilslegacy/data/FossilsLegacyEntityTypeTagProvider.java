package willatendo.fossilslegacy.data;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;

public class FossilsLegacyEntityTypeTagProvider extends EntityTypeTagsProvider {
	public FossilsLegacyEntityTypeTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
		super(packOutput, provider, modId, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(EntityTypeTags.FALL_DAMAGE_IMMUNE).add(FossilsLegacyEntities.PTERANODON.get());
	}
}
