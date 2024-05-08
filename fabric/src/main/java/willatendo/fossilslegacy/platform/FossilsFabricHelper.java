package willatendo.fossilslegacy.platform;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.core.BlockPos;
import net.minecraft.core.IdMap;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.portal.PortalInfo;
import willatendo.fossilslegacy.network.FossilsLegacyPackets;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.block.entity.TimeMachineBlockEntity;
import willatendo.fossilslegacy.server.config.FabricConfigHelper;
import willatendo.fossilslegacy.server.item.CoinItem;
import willatendo.fossilslegacy.server.item.DinosaurSpawnEggItem;

import java.util.function.Supplier;

public class FossilsFabricHelper implements FossilsModloaderHelper {
    @Override
    public void sendTimeMachinePacket(BlockPos blockPos, boolean timeTravelling) {
        FriendlyByteBuf friendlyByteBuf = PacketByteBufs.create();
        friendlyByteBuf.writeBlockPos(blockPos);
        friendlyByteBuf.writeBoolean(timeTravelling);
        ClientPlayNetworking.send(FossilsLegacyPackets.TIME_MACHINE_UPDATE, friendlyByteBuf);
    }

    @Override
    public void changeDimensions(Player player, ServerLevel serverLevel, PortalInfo portalInfo, BlockPos timeMachineBlockPos) {
        serverLevel.setBlock(timeMachineBlockPos, FossilsLegacyBlocks.TIME_MACHINE.get().defaultBlockState(), 3);
        BlockEntity blockEntity = serverLevel.getBlockEntity(timeMachineBlockPos);
        if (blockEntity instanceof TimeMachineBlockEntity timeMachineBlockEntity) {
            timeMachineBlockEntity.setItem(0, new ItemStack(CoinItem.ITEM_MAP.get(serverLevel.dimension())));
        }
        FabricDimensions.teleport(player, serverLevel, portalInfo);
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
