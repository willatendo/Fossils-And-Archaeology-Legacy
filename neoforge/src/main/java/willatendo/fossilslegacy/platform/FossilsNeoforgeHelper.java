package willatendo.fossilslegacy.platform;

import net.minecraft.core.IdMap;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import willatendo.fossilslegacy.FossilsLegacyNeoforgeMod;
import willatendo.fossilslegacy.server.config.FossilsLegacyConfig;
import willatendo.fossilslegacy.server.item.DeferredDinosaurSpawnEggItem;

import java.util.function.Supplier;

public class FossilsNeoforgeHelper implements FossilsModloaderHelper {
    @Override
    public <T> Supplier<EntityDataSerializer<T>> registerDataSerializer(String id, IdMap<T> idMap) {
        return FossilsLegacyNeoforgeMod.ENTITY_DATA_SERIALIZER.register(id, () -> EntityDataSerializer.simpleId(idMap));
    }

    @Override
    public SpawnEggItem createDinosaurSpawnEgg(Supplier<EntityType<? extends Mob>> entityType, int primaryColor, int secondaryColor, Item.Properties properties) {
        return new DeferredDinosaurSpawnEggItem(entityType, primaryColor, secondaryColor, properties);
    }

    @Override
    public boolean featheredDinosaurs() {
        return FossilsLegacyConfig.CLIENT_CONFIG.featheredDinosaurs();
    }

    @Override
    public boolean willAnimalsStarve() {
        return FossilsLegacyConfig.COMMON_CONFIG.willAnimalsStarve();
    }

    @Override
    public boolean willAnimalsBreakBlocks() {
        return FossilsLegacyConfig.COMMON_CONFIG.willAnimalsStarve();
    }

    @Override
    public boolean willAnimalsGrow() {
        return FossilsLegacyConfig.COMMON_CONFIG.willAnimalsGrow();
    }

    @Override
    public boolean shouldAnuSpawn() {
        return FossilsLegacyConfig.COMMON_CONFIG.shouldAnuSpawn();
    }
}
