package willatendo.fossilslegacy.platform;

import net.minecraft.client.RecipeBookCategories;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
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
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.item.ArticulatedFossilItem;
import willatendo.fossilslegacy.server.utils.Platform;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.List;
import java.util.function.Supplier;

public interface FossilsModloaderHelper {
    FossilsModloaderHelper INSTANCE = SimpleUtils.loadModloaderHelper(FossilsModloaderHelper.class);

    // Platform
    Platform getPlatform();

    void sendAlertUnlockedCoatTypesPacket(ServerPlayer serverPlayer, List<String> coatTypes);

    void sendApplyGenePacket(BlockPos blockPos, String coatType);

    void sendTimeMachinePacket(BlockPos blockPos);

    CompoundTag getPlayerData(Player player);

    void setPlayerData(CompoundTag compoundTag, CompoundTag data);

    <T> Supplier<EntityDataSerializer<Holder<T>>> registerDataSerializer(String id, StreamCodec<RegistryFriendlyByteBuf, Holder<T>> streamCodec);

    SpawnEggItem createDinosaurSpawnEgg(Supplier<EntityType<? extends Mob>> entityType, int primaryColor, int secondaryColor, Item.Properties properties);

    default ArticulatedFossilItem getArticulatedFossilItem(Item.Properties properties) {
        return new ArticulatedFossilItem(properties);
    }

    RecipeBookType createRecipeBookType(String name);

    RecipeBookCategories createRecipeBookCategory(String name, ItemStack... icons);
}
