package willatendo.fossilslegacy.server.item;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.FossilsLegacyBuiltInRegistries;
import willatendo.fossilslegacy.server.entity.Fossil;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.entity.FossilsLegacyFossilVariantTags;

public class FossilItem extends PlaceEntityItem {
	public FossilItem(Properties properties) {
		super(() -> FossilsLegacyEntityTypes.FOSSIL.get(), properties);
	}

	@Override
	public void entityModification(Entity entity) {
		Level level = entity.level();
		RandomSource randomSource = level.getRandom();
		FossilsLegacyBuiltInRegistries.FOSSIL_VARIANTS.getTag(FossilsLegacyFossilVariantTags.PLACEABLE_FROM_FOSSIL).flatMap(named -> named.getRandomElement(randomSource)).ifPresent(holder -> ((Fossil) entity).setFossilVariant(holder.value()));
		((Fossil) entity).setSize(0);
	}
}
