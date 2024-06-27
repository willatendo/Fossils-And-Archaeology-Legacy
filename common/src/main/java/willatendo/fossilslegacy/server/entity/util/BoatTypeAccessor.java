package willatendo.fossilslegacy.server.entity.util;

import net.minecraft.core.Holder;
import willatendo.fossilslegacy.server.entity.variants.BoatType;

public interface BoatTypeAccessor {
    Holder<BoatType> getBoatType();

    void setBoatType(Holder<BoatType> boatType);
}
