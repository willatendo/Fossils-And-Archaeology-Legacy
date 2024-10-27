package willatendo.fossilslegacy.platform;

import net.minecraft.client.RecipeBookCategories;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import willatendo.fossilslegacy.FossilsLegacyForgeMod;
import willatendo.fossilslegacy.network.ClientboundAlertUnlockedCoatTypesPacket;
import willatendo.fossilslegacy.network.ForgePacketHelper;
import willatendo.fossilslegacy.network.ServerboundApplyGenePacket;
import willatendo.fossilslegacy.network.ServerboundTimeMachineUpdatePacket;
import willatendo.fossilslegacy.server.item.ArticulatedFossilItem;
import willatendo.fossilslegacy.server.item.ForgeArticulatedFossilItem;
import willatendo.fossilslegacy.server.item.ForgeDinosaurSpawnEggItem;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.fossilslegacy.server.utils.Platform;

import java.util.List;
import java.util.function.Supplier;

public class FossilsForgeHelper implements FossilsModloaderHelper {
    @Override
    public Platform getPlatform() {
        return Platform.FORGE;
    }

    @Override
    public void sendAlertUnlockedCoatTypesPacket(ServerPlayer serverPlayer, List<String> coatTypes) {
        ForgePacketHelper.sendToClient(new ClientboundAlertUnlockedCoatTypesPacket(coatTypes));
    }

    @Override
    public void sendApplyGenePacket(BlockPos blockPos, String coatType) {
        ForgePacketHelper.sendToServer(new ServerboundApplyGenePacket(blockPos, coatType));
    }

    @Override
    public void sendTimeMachinePacket(BlockPos blockPos) {
        ForgePacketHelper.sendToServer(new ServerboundTimeMachineUpdatePacket(blockPos));
    }

    @Override
    public CompoundTag getPlayerData(Player player) {
        return player.getPersistentData();
    }

    @Override
    public void setPlayerData(CompoundTag compoundTag, CompoundTag data) {
        compoundTag.put(FossilsLegacyUtils.PERSISTED_NBT_TAG, data);
    }

    @Override
    public <T> Supplier<EntityDataSerializer<Holder<T>>> registerDataSerializer(String id, StreamCodec<RegistryFriendlyByteBuf, Holder<T>> streamCodec) {
        return FossilsLegacyForgeMod.ENTITY_DATA_SERIALIZER.register(id, () -> EntityDataSerializer.forValueType(streamCodec));
    }

    @Override
    public SpawnEggItem createDinosaurSpawnEgg(Supplier<EntityType<? extends Mob>> entityType, int primaryColor, int secondaryColor, Item.Properties properties) {
        return new ForgeDinosaurSpawnEggItem(entityType, primaryColor, secondaryColor, properties);
    }

    @Override
    public ArticulatedFossilItem getArticulatedFossilItem(Item.Properties properties) {
        return new ForgeArticulatedFossilItem(properties);
    }

    @Override
    public RecipeBookType createRecipeBookType(String name) {
        return RecipeBookType.create(FossilsLegacyUtils.ID + name);
    }

    @Override
    public RecipeBookCategories createRecipeBookCategory(String name, ItemStack... icons) {
        return RecipeBookCategories.create(FossilsLegacyUtils.ID + name, icons);
    }
}
