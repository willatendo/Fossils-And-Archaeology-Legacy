
package willatendo.fossilslegacy.data;

import java.util.concurrent.CompletableFuture;

import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup.Provider;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.FossilsLegacyStoneTabletVariants;
import willatendo.fossilslegacy.server.entity.StoneTabletVariant;
import willatendo.fossilslegacy.server.entity.StoneTabletVariantTags;
import willatendo.simplelibrary.data.tags.SimpleTagsProvider;

public class FossilsLegacyStoneTabletVariantTagProvider extends SimpleTagsProvider<StoneTabletVariant> {
	public FossilsLegacyStoneTabletVariantTagProvider(FabricDataOutput fabricDataOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
		super(fabricDataOutput, FossilsLegacyRegistries.STONE_TABLET_VARIANTS, provider, modId, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(StoneTabletVariantTags.PLACEABLE).add(FossilsLegacyStoneTabletVariants.LIGHTING.getKey(), FossilsLegacyStoneTabletVariants.SOCIAL.getKey(), FossilsLegacyStoneTabletVariants.GREAT_WAR.getKey(), FossilsLegacyStoneTabletVariants.ANU_DEATH.getKey(), FossilsLegacyStoneTabletVariants.PORTAL.getKey(), FossilsLegacyStoneTabletVariants.HEROBRINE.getKey(), FossilsLegacyStoneTabletVariants.SKELETON_AND_CREEPER.getKey(), FossilsLegacyStoneTabletVariants.ZOMBIE_AND_SPIDER.getKey(), FossilsLegacyStoneTabletVariants.TYRANNOSAURUS_IN_ICEBERG.getKey(), FossilsLegacyStoneTabletVariants.TYRANNOSAURUS_TRANSPORT.getKey(), FossilsLegacyStoneTabletVariants.TYRANNOSAURUS_MELT.getKey(), FossilsLegacyStoneTabletVariants.TYRANNOSAURUS_ATTACK.getKey(), FossilsLegacyStoneTabletVariants.TYRANNOSAURUS_DEATH.getKey(), FossilsLegacyStoneTabletVariants.TYRANNOSAURUS_CORPSE.getKey(), FossilsLegacyStoneTabletVariants.PRINCESS.getKey(), FossilsLegacyStoneTabletVariants.MOSASAURUS.getKey(), FossilsLegacyStoneTabletVariants.HOLY_MOSASAURUS.getKey(), FossilsLegacyStoneTabletVariants.PAST.getKey(), FossilsLegacyStoneTabletVariants.TIME_MACHINE.getKey(), FossilsLegacyStoneTabletVariants.FUTURE.getKey());
	}
}
