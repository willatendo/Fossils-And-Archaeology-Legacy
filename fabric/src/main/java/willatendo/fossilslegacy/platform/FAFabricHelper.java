package willatendo.fossilslegacy.platform;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.level.GameRules;
import willatendo.fossilslegacy.network.*;
import willatendo.fossilslegacy.server.entity.util.FossilRotations;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.FabricUtils;

import java.util.Optional;
import java.util.function.Supplier;

public class FAFabricHelper implements FAModloaderHelper {
    @Override
    public void sendApplyGenePacket(BlockPos blockPos, String modelType, String skin, Optional<String> pattern) {
        FriendlyByteBuf friendlyByteBuf = PacketByteBufs.create();
        friendlyByteBuf.writeBlockPos(blockPos);
        friendlyByteBuf.writeUtf(modelType);
        friendlyByteBuf.writeUtf(skin);
        friendlyByteBuf.writeBoolean(pattern.isPresent());
        pattern.ifPresent(friendlyByteBuf::writeUtf);
        ClientPlayNetworking.send(new ServerboundApplyGenePacket(blockPos, modelType, skin, pattern));
    }

    @Override
    public void sendAddRotation(int id, String part, float xRot, float yRot, float zRot) {
        FriendlyByteBuf friendlyByteBuf = PacketByteBufs.create();
        friendlyByteBuf.writeInt(id);
        friendlyByteBuf.writeUtf(part);
        friendlyByteBuf.writeFloat(xRot);
        friendlyByteBuf.writeFloat(yRot);
        friendlyByteBuf.writeFloat(zRot);
        ClientPlayNetworking.send(new ServerboundAddRotationsPacket(id, part, xRot, yRot, zRot));
    }

    @Override
    public void sendSetRotation(int id, String part, float xRot, float yRot, float zRot) {
        FriendlyByteBuf friendlyByteBuf = PacketByteBufs.create();
        friendlyByteBuf.writeInt(id);
        friendlyByteBuf.writeUtf(part);
        friendlyByteBuf.writeFloat(xRot);
        friendlyByteBuf.writeFloat(yRot);
        friendlyByteBuf.writeFloat(zRot);
        ClientPlayNetworking.send(new ServerboundSetRotationsPacket(id, part, xRot, yRot, zRot));
    }

    @Override
    public void sendTimeMachinePacket(BlockPos blockPos) {
        FriendlyByteBuf friendlyByteBuf = PacketByteBufs.create();
        friendlyByteBuf.writeBlockPos(blockPos);
        ClientPlayNetworking.send(new ServerboundTimeMachineUpdatePacket(blockPos));
    }

    @Override
    public void sendFossilMenuPacket(ServerPlayer serverPlayer, int id, FossilRotations fossilRotations, String fossilVariant) {
        FriendlyByteBuf friendlyByteBuf = PacketByteBufs.create();
        friendlyByteBuf.writeUtf(fossilVariant);
        ServerPlayNetworking.send(serverPlayer, new ClientboundFossilMenuPacket(id, fossilRotations, fossilVariant));
    }

    @Override
    public <T> Supplier<EntityDataSerializer<T>> registerDataSerializer(String id, EntityDataSerializer<T> entityDataSerializer) {
        EntityDataSerializers.registerSerializer(entityDataSerializer);
        return () -> entityDataSerializer;
    }

    @Override
    public void registerPOI(SimpleRegistry<PoiType> simpleRegistry, String id, Supplier<PoiType> poiType) {
        PointOfInterestHelper.register(FAUtils.resource(id), poiType.get().maxTickets(), poiType.get().validRange(), poiType.get().matchingStates());
    }

    @Override
    public GameRules.Key<GameRules.BooleanValue> createBooleanGameRule(String name, GameRules.Category category, boolean defaultValue) {
        return GameRuleRegistry.register(name, category, GameRuleFactory.createBooleanRule(defaultValue));
    }

    @Override
    public RecipeBookType createRecipeBookType(String name) {
        return FabricUtils.createRecipeBookType(name);
    }
}
