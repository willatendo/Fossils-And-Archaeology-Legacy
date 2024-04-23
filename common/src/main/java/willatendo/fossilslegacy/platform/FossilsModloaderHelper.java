package willatendo.fossilslegacy.platform;

import net.minecraft.core.BlockPos;
import net.minecraft.core.IdMap;
import net.minecraft.core.Registry;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.entity.BlockEntity;
import willatendo.fossilslegacy.server.RegistryHolder;
import willatendo.fossilslegacy.server.menu.ExtendedMenuSupplier;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.function.Supplier;

public interface FossilsModloaderHelper {
    public static final FossilsModloaderHelper INSTANCE = SimpleUtils.loadModloaderHelper(FossilsModloaderHelper.class);

    <T extends AbstractContainerMenu> MenuType<T> createMenuType(ExtendedMenuSupplier<T> extendedMenuSupplier);

    <T> Supplier<EntityDataSerializer<T>> registerDataSerializer(String id, IdMap<T> idMap);

    <T> RegistryHolder<T> createRegistry(ResourceKey<Registry<T>> resourceKey);

    SpawnEggItem createSpawnEgg(Supplier<EntityType<? extends Mob>> entityType, int primaryColor, int secondaryColor, Item.Properties properties);

    SpawnEggItem createDinosaurSpawnEgg(Supplier<EntityType<? extends Mob>> entityType, int primaryColor, int secondaryColor, Item.Properties properties);

    void openContainer(BlockEntity blockEntity, BlockPos blockPos, ServerPlayer serverPlayer);

    boolean willAnimalsStarve();

    boolean willAnimalsBreakBlocks();

    boolean willAnimalsGrow();

    boolean shouldAnuSpawn();

    boolean shouldEnableExperiments();
}