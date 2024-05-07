package willatendo.fossilslegacy.platform;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.core.BlockPos;
import net.minecraft.core.IdMap;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import willatendo.fossilslegacy.network.FossilsLegacyPackets;
import willatendo.fossilslegacy.server.config.FabricConfigHelper;
import willatendo.fossilslegacy.server.item.DinosaurSpawnEggItem;

import java.util.function.Supplier;

public class FossilsFabricHelper implements FossilsModloaderHelper {
    @Override
    public void sendTimeMachinePacket(BlockPos blockPos, boolean timeTravelling) {
        ClientPlayNetworking.send(FossilsLegacyPackets.TIME_MACHINE_UPDATE, PacketByteBufs.create().writeBlockPos(blockPos).writeBoolean(timeTravelling));
    }

    @Override
    public <T> Supplier<EntityDataSerializer<T>> registerDataSerializer(String id, IdMap<T> idMap) {
        EntityDataSerializer entityDataSerializer = EntityDataSerializer.simpleId(idMap);
        EntityDataSerializers.registerSerializer(entityDataSerializer);
        return () -> entityDataSerializer;
    }

    @Override
    public SpawnEggItem createDinosaurSpawnEgg(Supplier<EntityType<? extends Mob>> entityType, int primaryColor, int secondaryColor, Item.Properties properties) {
        return new DinosaurSpawnEggItem(entityType.get(), primaryColor, secondaryColor, properties);
    }

    @Override
    public boolean featheredDinosaurs() {
        return FabricConfigHelper.featheredDinosaurs();
    }

    @Override
    public boolean willAnimalsStarve() {
        return FabricConfigHelper.willAnimalsStarve();
    }

    @Override
    public boolean willAnimalsBreakBlocks() {
        return FabricConfigHelper.willAnimalsStarve();
    }

    @Override
    public boolean willAnimalsGrow() {
        return FabricConfigHelper.willAnimalsGrow();
    }

    @Override
    public boolean shouldAnuSpawn() {
        return FabricConfigHelper.shouldAnuSpawn();
    }
}
