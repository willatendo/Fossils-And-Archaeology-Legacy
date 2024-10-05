package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.tags.FossilsLegacyStoneTabletVariantTags;
import willatendo.fossilslegacy.server.tags.FossilsLegacyStoneTabletVariants;
import willatendo.fossilslegacy.server.entity.variants.StoneTabletVariant;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyStoneTabletVariantTagProvider extends DataDrivenTagsProvider<StoneTabletVariant> {
    public FossilsLegacyStoneTabletVariantTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, FossilsLegacyRegistries.STONE_TABLET_VARIANTS, provider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FossilsLegacyStoneTabletVariantTags.PLACEABLE).add(FossilsLegacyStoneTabletVariants.LIGHTING, FossilsLegacyStoneTabletVariants.SOCIAL, FossilsLegacyStoneTabletVariants.GREAT_WAR, FossilsLegacyStoneTabletVariants.ANU_DEATH, FossilsLegacyStoneTabletVariants.PORTAL, FossilsLegacyStoneTabletVariants.HEROBRINE, FossilsLegacyStoneTabletVariants.SKELETON_AND_CREEPER, FossilsLegacyStoneTabletVariants.ZOMBIE_AND_SPIDER, FossilsLegacyStoneTabletVariants.TYRANNOSAURUS_IN_ICEBERG, FossilsLegacyStoneTabletVariants.TYRANNOSAURUS_TRANSPORT, FossilsLegacyStoneTabletVariants.TYRANNOSAURUS_MELT, FossilsLegacyStoneTabletVariants.TYRANNOSAURUS_ATTACK, FossilsLegacyStoneTabletVariants.TYRANNOSAURUS_DEATH, FossilsLegacyStoneTabletVariants.TYRANNOSAURUS_CORPSE, FossilsLegacyStoneTabletVariants.PRINCESS, FossilsLegacyStoneTabletVariants.MOSASAURUS, FossilsLegacyStoneTabletVariants.HOLY_MOSASAURUS, FossilsLegacyStoneTabletVariants.PAST, FossilsLegacyStoneTabletVariants.TIME_MACHINE, FossilsLegacyStoneTabletVariants.FUTURE, FossilsLegacyStoneTabletVariants.ANU_TOTEM);
    }
}
