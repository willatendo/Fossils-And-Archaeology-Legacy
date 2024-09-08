package willatendo.fossilslegacy.platform;

import net.minecraft.client.RecipeBookCategories;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.function.Supplier;

public interface FossilsModloaderHelper {
    public static final FossilsModloaderHelper INSTANCE = SimpleUtils.loadModloaderHelper(FossilsModloaderHelper.class);

    // Platform
    void sendTimeMachinePacket(BlockPos blockPos);

    <T> Supplier<EntityDataSerializer<Holder<T>>> registerDataSerializer(String id, StreamCodec<RegistryFriendlyByteBuf, Holder<T>> streamCodec);

    SpawnEggItem createDinosaurSpawnEgg(Supplier<EntityType<? extends Mob>> entityType, int primaryColor, int secondaryColor, Item.Properties properties);

    RecipeBookType createRecipeBookType(String name);

    RecipeBookCategories createRecipeBookCategory(String name, ItemStack... icons);

    // Config
    boolean featheredDinosaurs();

    boolean legacyModels();

    boolean willAnimalsStarve();

    boolean willAnimalsBreakBlocks();

    boolean willAnimalsGrow();
}
