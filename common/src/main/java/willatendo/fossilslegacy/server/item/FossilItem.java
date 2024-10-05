package willatendo.fossilslegacy.server.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyBuiltInRegistries;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.Fossil;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.tags.FossilsLegacyFossilVariantTags;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FossilItem extends PlaceEntityItem {
    public FossilItem(Properties properties) {
        super(FossilsLegacyEntityTypes.FOSSIL::get, properties);
    }

    @Override
    public void entityModification(ItemStack itemStack, Entity entity) {
        Level level = entity.level();
        List<Holder<FossilVariant>> fossilVariants = new ArrayList<>();
        level.registryAccess().registryOrThrow(FossilsLegacyRegistries.FOSSIL_VARIANTS).getTagOrEmpty(FossilsLegacyFossilVariantTags.PLACEABLE_FROM_FOSSIL).forEach(fossilVariants::add);
        Optional<Holder<FossilVariant>> optional = Util.getRandomSafe(fossilVariants, entity.level().getRandom());
        ((Fossil) entity).setFossilVariant(optional.get());
        ((Fossil) entity).setSize(0);
    }
}
