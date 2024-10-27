package willatendo.fossilslegacy.platform;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import willatendo.fossilslegacy.network.ClientboundAlertUnlockedCoatTypesPacket;
import willatendo.fossilslegacy.network.ServerboundApplyGenePacket;
import willatendo.fossilslegacy.network.ServerboundTimeMachineUpdatePacket;
import willatendo.fossilslegacy.server.entity.PersistentDataEntity;
import willatendo.fossilslegacy.server.item.DinosaurSpawnEggItem;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.fossilslegacy.server.utils.Platform;
import willatendo.simplelibrary.client.util.FabricClientUtils;
import willatendo.simplelibrary.server.util.FabricUtils;

import java.util.List;
import java.util.function.Supplier;

public class FossilsFabricHelper implements FossilsModloaderHelper {
    @Override
    public Platform getPlatform() {
        return Platform.FABRIC;
    }

    @Override
    public void sendAlertUnlockedCoatTypesPacket(ServerPlayer serverPlayer, List<String> coatTypes) {
        FriendlyByteBuf friendlyByteBuf = PacketByteBufs.create();
        friendlyByteBuf.writeInt(coatTypes.size());
        coatTypes.forEach(friendlyByteBuf::writeUtf);
        ServerPlayNetworking.send(serverPlayer, new ClientboundAlertUnlockedCoatTypesPacket(coatTypes));
    }

    @Override
    public void sendApplyGenePacket(BlockPos blockPos, String coatType) {
        FriendlyByteBuf friendlyByteBuf = PacketByteBufs.create();
        friendlyByteBuf.writeBlockPos(blockPos);
        friendlyByteBuf.writeUtf(coatType);
        ClientPlayNetworking.send(new ServerboundApplyGenePacket(blockPos, coatType));
    }

    @Override
    public void sendTimeMachinePacket(BlockPos blockPos) {
        FriendlyByteBuf friendlyByteBuf = PacketByteBufs.create();
        friendlyByteBuf.writeBlockPos(blockPos);
        ClientPlayNetworking.send(new ServerboundTimeMachineUpdatePacket(blockPos));
    }

    @Override
    public CompoundTag getPlayerData(Player player) {
        return ((PersistentDataEntity) player).getPersistentData();
    }

    @Override
    public void setPlayerData(CompoundTag compoundTag, CompoundTag data) {
        compoundTag.put(FossilsLegacyUtils.ID + "." + FossilsLegacyUtils.PERSISTED_NBT_TAG, data);
    }

    @Override
    public <T> Supplier<EntityDataSerializer<Holder<T>>> registerDataSerializer(String id, StreamCodec<RegistryFriendlyByteBuf, Holder<T>> streamCodec) {
        EntityDataSerializer entityDataSerializer = EntityDataSerializer.forValueType(streamCodec);
        EntityDataSerializers.registerSerializer(entityDataSerializer);
        return () -> entityDataSerializer;
    }

    @Override
    public SpawnEggItem createDinosaurSpawnEgg(Supplier<EntityType<? extends Mob>> entityType, int primaryColor, int secondaryColor, Item.Properties properties) {
        return new DinosaurSpawnEggItem(entityType.get(), primaryColor, secondaryColor, properties);
    }

    @Override
    public RecipeBookType createRecipeBookType(String name) {
        return FabricUtils.createRecipeBookType(name);
    }

    @Override
    public RecipeBookCategories createRecipeBookCategory(String name, ItemStack... icons) {
        return FabricClientUtils.createRecipeBookCategory(name);
    }
}
