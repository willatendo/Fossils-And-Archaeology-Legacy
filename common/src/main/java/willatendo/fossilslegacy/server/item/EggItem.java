package willatendo.fossilslegacy.server.item;

import net.minecraft.world.entity.Entity;
import willatendo.fossilslegacy.server.entity.Egg;
import willatendo.fossilslegacy.server.entity.EggVariant;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;

import java.util.function.Supplier;

public class EggItem extends PlaceEntityItem {
    private final Supplier<EggVariant> eggVariant;

    public EggItem(Supplier<EggVariant> eggVariant, Properties properties) {
        super(() -> FossilsLegacyEntityTypes.EGG.get(), properties);
        this.eggVariant = eggVariant;
        FossilsLegacyItems.EGGS.add(this);
    }

    public EggVariant getEggVariant() {
        return this.eggVariant.get();
    }

    @Override
    public void entityModification(Entity entity) {
        ((Egg) entity).setEggVariant(this.eggVariant.get());
    }
}
