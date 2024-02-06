package willatendo.fossilslegacy.data;

import java.util.concurrent.CompletableFuture;

import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.level.biome.Biomes;
import willatendo.fossilslegacy.server.biomes.FossilsLegacyBiomeTags;
import willatendo.simplelibrary.data.tags.SimpleBiomeTagsProvider;

public class FossilsLegacyBiomeTagProvider extends SimpleBiomeTagsProvider {
	public FossilsLegacyBiomeTagProvider(FabricDataOutput fabricDataOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
		super(fabricDataOutput, provider, modId, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(FossilsLegacyBiomeTags.HAS_ACADEMY).add(Biomes.JUNGLE, Biomes.DESERT, Biomes.PLAINS);
		this.tag(FossilsLegacyBiomeTags.HAS_WEAPON_SHOP).add(Biomes.OCEAN, Biomes.PLAINS);
	}
}
