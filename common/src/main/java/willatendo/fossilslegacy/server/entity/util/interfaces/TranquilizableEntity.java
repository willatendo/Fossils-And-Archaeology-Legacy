package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;

public interface TranquilizableEntity {
    void setTranquilizeTime(int time);

    int getTranquilizeTime();

    void setTranquilized(boolean tranquilized);

    boolean isTranquilized();

    default void addTranquilizeData(CompoundTag compoundTag, HolderLookup.Provider provider) {
        compoundTag.putBoolean("tranquilized", this.isTranquilized());
        compoundTag.putInt("tranquilize_time", this.getTranquilizeTime());
    }

    default void readTranquilizeData(CompoundTag compoundTag, HolderLookup.Provider provider) {
        this.setTranquilized(compoundTag.getBoolean("tranquilized"));
        this.setTranquilizeTime(compoundTag.getInt("tranquilize_time"));
    }

    default void tranquilizedTick() {
        if (this.getTranquilizeTime() > 0) {
            if (!this.isTranquilized()) {
                this.setTranquilized(true);
            }
            this.setTranquilizeTime(this.getTranquilizeTime() - 1);
        } else {
            if (this.isTranquilized()) {
                this.setTranquilized(false);
            }
        }
    }
}
