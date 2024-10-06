package willatendo.fossilslegacy.platform;

import net.minecraft.client.RecipeBookCategories;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import willatendo.fossilslegacy.server.utils.Platform;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.function.Supplier;

public interface FossilsModloaderHelper {
    FossilsModloaderHelper INSTANCE = SimpleUtils.loadModloaderHelper(FossilsModloaderHelper.class);

    // Platform
    Platform getPlatform();

    void sendTimeMachinePacket(BlockPos blockPos);

    void sendApplyGenePacket(BlockPos blockPos, String coatType);

    <T> Supplier<EntityDataSerializer<Holder<T>>> registerDataSerializer(String id, StreamCodec<RegistryFriendlyByteBuf, Holder<T>> streamCodec);

    SpawnEggItem createDinosaurSpawnEgg(Supplier<EntityType<? extends Mob>> entityType, int primaryColor, int secondaryColor, Item.Properties properties);

    RecipeBookType createRecipeBookType(String name);

    RecipeBookCategories createRecipeBookCategory(String name, ItemStack... icons);
}
