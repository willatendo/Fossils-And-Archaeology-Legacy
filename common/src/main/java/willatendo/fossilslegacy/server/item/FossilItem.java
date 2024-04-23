package willatendo.fossilslegacy.server.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.FossilsLegacyBuiltInRegistries;
import willatendo.fossilslegacy.server.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FossilItem extends PlaceEntityItem {
    public FossilItem(Properties properties) {
        super(() -> FossilsLegacyEntityTypes.FOSSIL.get(), properties);
    }

    @Override
    public void entityModification(Entity entity) {
        Level level = entity.level();
        RandomSource randomSource = level.getRandom();
        List<Holder<FossilVariant>> fossilVariants = new ArrayList<>();
        FossilsLegacyBuiltInRegistries.FOSSIL_VARIANTS.getTagOrEmpty(FossilsLegacyFossilVariantTags.PLACEABLE_FROM_FOSSIL).forEach(fossilVariants::add);
        Optional<Holder<FossilVariant>> optional = Util.getRandomSafe(fossilVariants, entity.level().getRandom());
        ((Fossil) entity).setFossilVariant(optional.get().value());
        ((Fossil) entity).setSize(0);
    }
}