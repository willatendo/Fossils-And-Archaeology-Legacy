package willatendo.fossilslegacy.platform;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.IdMap;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.Nullable;
import willatendo.fossilslegacy.server.RegistryHolder;
import willatendo.fossilslegacy.server.config.FabricConfigHelper;
import willatendo.fossilslegacy.server.item.DinosaurSpawnEggItem;
import willatendo.fossilslegacy.server.menu.ExtendedMenuSupplier;
import willatendo.simplelibrary.server.util.FabricUtils;

import java.util.function.Supplier;

public class FossilsFabricHelper implements FossilsModloaderHelper {
    @Override
    public <T extends AbstractContainerMenu> MenuType<T> createMenuType(ExtendedMenuSupplier<T> extendedMenuSupplier) {
        return FabricUtils.createMenuType((windowId, inventory, friendlyByteBuf) -> extendedMenuSupplier.create(windowId, inventory, friendlyByteBuf));
    }

    @Override
    public <T> Supplier<EntityDataSerializer<T>> registerDataSerializer(String id, IdMap<T> idMap) {
        EntityDataSerializer entityDataSerializer = EntityDataSerializer.simpleId(idMap);
        EntityDataSerializers.registerSerializer(entityDataSerializer);
        return () -> entityDataSerializer;
    }

    @Override
    public <T> RegistryHolder<T> createRegistry(ResourceKey<Registry<T>> resourceKey) {
        return new RegistryHolder.BasicRegistryHolder<>(FabricRegistryBuilder.createSimple(resourceKey).buildAndRegister());
    }

    @Override
    public SpawnEggItem createSpawnEgg(Supplier<EntityType<? extends Mob>> entityType, int primaryColor, int secondaryColor, Item.Properties properties) {
        return new SpawnEggItem(entityType.get(), primaryColor, secondaryColor, properties);
    }

    @Override
    public SpawnEggItem createDinosaurSpawnEgg(Supplier<EntityType<? extends Mob>> entityType, int primaryColor, int secondaryColor, Item.Properties properties) {
        return new DinosaurSpawnEggItem(entityType.get(), primaryColor, secondaryColor, properties);
    }

    @Override
    public void openContainer(BlockEntity blockEntity, BlockPos blockPos, ServerPlayer serverPlayer) {
        serverPlayer.openMenu(new ExtendedScreenHandlerFactory() {
            @Override
            public void writeScreenOpeningData(ServerPlayer serverPlayer, FriendlyByteBuf friendlyByteBuf) {
                friendlyByteBuf.writeBlockPos(blockEntity.getBlockPos());
            }

            @Override
            public Component getDisplayName() {
                return ((MenuProvider) blockEntity).getDisplayName();
            }

            @Nullable
            @Override
            public AbstractContainerMenu createMenu(int windowId, Inventory inventory, Player player) {
                return ((MenuProvider) blockEntity).createMenu(windowId, inventory, player);
            }
        });
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

    @Override
    public boolean shouldEnableExperiments() {
        return FabricConfigHelper.shouldEnableExperiments();
    }
}
