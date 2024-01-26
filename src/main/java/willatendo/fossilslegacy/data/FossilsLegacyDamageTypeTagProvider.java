package willatendo.fossilslegacy.data;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.damagesource.DamageTypes;
import willatendo.fossilslegacy.server.entity.FossilsLegacyDamgeTypeTags;
import willatendo.simplelibrary.data.tags.SimpleDamageTypeTagsProvider;
import willatendo.simplelibrary.data.util.ExistingFileHelper;

public class FossilsLegacyDamageTypeTagProvider extends SimpleDamageTypeTagsProvider {
	public FossilsLegacyDamageTypeTagProvider(FabricDataOutput fabricDataOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
		super(fabricDataOutput, provider, modId, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(FossilsLegacyDamgeTypeTags.TYRANNOSAURUS_IMMUNE).add(DamageTypes.ARROW, DamageTypes.TRIDENT);
	}
}
