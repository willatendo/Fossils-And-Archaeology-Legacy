
package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.FossilsLegacyStoneTabletVariantTags;
import willatendo.fossilslegacy.server.entity.FossilsLegacyStoneTabletVariants;
import willatendo.fossilslegacy.server.entity.variants.StoneTabletVariant;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyStoneTabletVariantTagProvider extends TagsProvider<StoneTabletVariant> {
    public FossilsLegacyStoneTabletVariantTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, FossilsLegacyRegistries.STONE_TABLET_VARIANTS, provider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FossilsLegacyStoneTabletVariantTags.PLACEABLE).add(FossilsLegacyStoneTabletVariants.LIGHTING.getKey(), FossilsLegacyStoneTabletVariants.SOCIAL.getKey(), FossilsLegacyStoneTabletVariants.GREAT_WAR.getKey(), FossilsLegacyStoneTabletVariants.ANU_DEATH.getKey(), FossilsLegacyStoneTabletVariants.PORTAL.getKey(), FossilsLegacyStoneTabletVariants.HEROBRINE.getKey(), FossilsLegacyStoneTabletVariants.SKELETON_AND_CREEPER.getKey(), FossilsLegacyStoneTabletVariants.ZOMBIE_AND_SPIDER.getKey(), FossilsLegacyStoneTabletVariants.TYRANNOSAURUS_IN_ICEBERG.getKey(), FossilsLegacyStoneTabletVariants.TYRANNOSAURUS_TRANSPORT.getKey(), FossilsLegacyStoneTabletVariants.TYRANNOSAURUS_MELT.getKey(), FossilsLegacyStoneTabletVariants.TYRANNOSAURUS_ATTACK.getKey(), FossilsLegacyStoneTabletVariants.TYRANNOSAURUS_DEATH.getKey(), FossilsLegacyStoneTabletVariants.TYRANNOSAURUS_CORPSE.getKey(), FossilsLegacyStoneTabletVariants.PRINCESS.getKey(), FossilsLegacyStoneTabletVariants.MOSASAURUS.getKey(), FossilsLegacyStoneTabletVariants.HOLY_MOSASAURUS.getKey(), FossilsLegacyStoneTabletVariants.PAST.getKey(), FossilsLegacyStoneTabletVariants.TIME_MACHINE.getKey(), FossilsLegacyStoneTabletVariants.FUTURE.getKey());
    }
}
