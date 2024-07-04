package willatendo.fossilslegacy.platform;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import willatendo.fossilslegacy.network.ServerboundTimeMachineUpdatePacket;
import willatendo.fossilslegacy.server.config.FabricConfigHelper;
import willatendo.fossilslegacy.server.item.DinosaurSpawnEggItem;
import willatendo.simplelibrary.client.util.FabricClientUtils;
import willatendo.simplelibrary.server.util.FabricUtils;

import java.util.function.Supplier;

public class FossilsFabricHelper implements FossilsModloaderHelper {
    @Override
    public void sendTimeMachinePacket(BlockPos blockPos) {
        FriendlyByteBuf friendlyByteBuf = PacketByteBufs.create();
        friendlyByteBuf.writeBlockPos(blockPos);
        ClientPlayNetworking.send(new ServerboundTimeMachineUpdatePacket(blockPos));
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
    public RecipeBookCategories createRecipeBookCategory(String name) {
        return FabricClientUtils.createRecipeBookCategory(name);
    }

    @Override
    public boolean featheredDinosaurs() {
        return FabricConfigHelper.featheredDinosaurs();
    }

    @Override
    public boolean legacyModels() {
        return FabricConfigHelper.legacyModels();
    }

    @Override
    public boolean willAnimalsStarve() {
        return FabricConfigHelper.willAnimalsStarve();
    }

    @Override
    public boolean willAnimalsBreakBlocks() {
        return FabricConfigHelper.willAnimalsBreakBlocks();
    }

    @Override
    public boolean willAnimalsGrow() {
        return FabricConfigHelper.willAnimalsGrow();
    }
}
