package willatendo.fossilslegacy.platform;

import net.minecraft.core.BlockPos;
import net.minecraft.core.IdMap;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import willatendo.fossilslegacy.FossilsLegacyForgeMod;
import willatendo.fossilslegacy.network.FossilsLegacyPackets;
import willatendo.fossilslegacy.network.ServerboundTimeMachineUpdatePacket;
import willatendo.fossilslegacy.server.config.FossilsLegacyConfig;
import willatendo.fossilslegacy.server.item.ForgeDinosaurSpawnEggItem;

import java.util.function.Supplier;

public class FossilsForgeHelper implements FossilsModloaderHelper {
    @Override
    public void sendTimeMachinePacket(BlockPos blockPos, boolean timeTravelling) {
        FossilsLegacyPackets.sendToServer(new ServerboundTimeMachineUpdatePacket(blockPos, timeTravelling));
    }

    @Override
    public <T> Supplier<EntityDataSerializer<T>> registerDataSerializer(String id, IdMap<T> idMap) {
        return FossilsLegacyForgeMod.ENTITY_DATA_SERIALIZER.register(id, () -> EntityDataSerializer.simpleId(idMap));
    }

    @Override
    public SpawnEggItem createDinosaurSpawnEgg(Supplier<EntityType<? extends Mob>> entityType, int primaryColor, int secondaryColor, Item.Properties properties) {
        return new ForgeDinosaurSpawnEggItem(entityType, primaryColor, secondaryColor, properties);
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
