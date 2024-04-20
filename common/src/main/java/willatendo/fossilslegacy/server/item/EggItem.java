package willatendo.fossilslegacy.server.item;

import net.minecraft.world.entity.Entity;
import willatendo.fossilslegacy.server.entity.Egg;
import willatendo.fossilslegacy.server.entity.EggVariant;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;

public class EggItem extends PlaceEntityItem {
	private final EggVariant eggVariant;

	public EggItem(EggVariant eggVariant, Properties properties) {
		super(() -> FossilsLegacyEntityTypes.EGG.get(), properties);
		this.eggVariant = eggVariant;
	}

	public EggVariant getEggVariant() {
		return this.eggVariant;
	}

	@Override
	public void entityModification(Entity entity) {
		((Egg) entity).setEggVariant(this.eggVariant);
	}
}
