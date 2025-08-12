package willatendo.fossilslegacy.server.dimension;

import net.minecraft.world.level.storage.DerivedLevelData;
import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraft.world.level.storage.WorldData;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class DayCycleLevelData extends DerivedLevelData {
    private final ServerLevelData wrapped;

    public DayCycleLevelData(WorldData worldData, ServerLevelData wrapped) {
        super(worldData, wrapped);
        this.wrapped = wrapped;
    }

    @Override
    public void setDayTime(long time) {
        FAUtils.LOGGER.info("SET DAY TIME");
        this.wrapped.setDayTime(time);
    }
}
