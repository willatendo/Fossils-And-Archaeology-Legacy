package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.stone_tablet_variant.FAStoneTabletVariants;
import willatendo.fossilslegacy.server.stone_tablet_variant.StoneTabletVariant;
import willatendo.fossilslegacy.server.tags.FAStoneTabletVariantTags;

import java.util.concurrent.CompletableFuture;

public class FAStoneTabletVariantTagProvider extends DataDrivenTagsProvider<StoneTabletVariant> {
    public FAStoneTabletVariantTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, FARegistries.STONE_TABLET_VARIANTS, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FAStoneTabletVariantTags.PLACEABLE).add(FAStoneTabletVariants.LIGHTING, FAStoneTabletVariants.SOCIAL, FAStoneTabletVariants.GREAT_WAR, FAStoneTabletVariants.ANU_DEATH, FAStoneTabletVariants.PORTAL, FAStoneTabletVariants.HEROBRINE, FAStoneTabletVariants.SKELETON_AND_CREEPER, FAStoneTabletVariants.ZOMBIE_AND_SPIDER, FAStoneTabletVariants.TYRANNOSAURUS_IN_ICEBERG, FAStoneTabletVariants.TYRANNOSAURUS_TRANSPORT, FAStoneTabletVariants.TYRANNOSAURUS_MELT, FAStoneTabletVariants.TYRANNOSAURUS_ATTACK, FAStoneTabletVariants.TYRANNOSAURUS_DEATH, FAStoneTabletVariants.TYRANNOSAURUS_CORPSE, FAStoneTabletVariants.PRINCESS, FAStoneTabletVariants.MOSASAURUS, FAStoneTabletVariants.HOLY_MOSASAURUS, FAStoneTabletVariants.PAST, FAStoneTabletVariants.TIME_MACHINE, FAStoneTabletVariants.FUTURE, FAStoneTabletVariants.ANU_TOTEM);
    }
}
