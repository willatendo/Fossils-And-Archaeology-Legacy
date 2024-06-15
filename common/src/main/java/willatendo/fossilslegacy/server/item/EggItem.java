package willatendo.fossilslegacy.server.item;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import willatendo.fossilslegacy.server.entity.Egg;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;

public class EggItem extends PlaceEntityItem {
    private final Holder<EggVariant> eggVariant;

    public EggItem(Holder<EggVariant> eggVariant, Properties properties) {
        super(() -> FossilsLegacyEntityTypes.EGG.get(), properties);
        this.eggVariant = eggVariant;
        FossilsLegacyItems.EGGS.add(this);
    }

    public Holder<EggVariant> getEggVariant() {
        return this.eggVariant;
    }

    @Override
    public void entityModification(Entity entity) {
        ((Egg) entity).setEggVariant(this.eggVariant);
    }
}
