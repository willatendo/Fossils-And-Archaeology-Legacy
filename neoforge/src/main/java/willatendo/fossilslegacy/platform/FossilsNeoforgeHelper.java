package willatendo.fossilslegacy.platform;

import net.minecraft.core.BlockPos;
import net.minecraft.core.IdMap;
import net.minecraft.core.Registry;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.RegistryBuilder;
import willatendo.fossilslegacy.FossilsLegacyNeoforgeMod;
import willatendo.fossilslegacy.server.RegistryHolder;
import willatendo.fossilslegacy.server.config.FossilsLegacyConfig;
import willatendo.fossilslegacy.server.item.DeferredDinosaurSpawnEggItem;
import willatendo.fossilslegacy.server.menu.ExtendedMenuSupplier;

import java.util.Optional;
import java.util.function.Supplier;

public class FossilsNeoforgeHelper implements FossilsModloaderHelper {
    @Override
    public <T extends Entity> EntityType<T> entityTypeBuilder(String name, EntityType.EntityFactory<T> entityFactory, MobCategory mobCategory, boolean noSave, boolean fireImmune, Optional<Block> immuneTo, float width, float height) {
        EntityType.Builder<T> builder = EntityType.Builder.of(entityFactory, mobCategory).sized(width, height);
        if (noSave) {
            builder.noSave();
        }
        if (fireImmune) {
            builder.fireImmune();
        }
        if (!immuneTo.isEmpty()) {
            builder.immuneTo(immuneTo.get());
        }
        return builder.build(name);
    }

    @Override
    public <T extends AbstractContainerMenu> MenuType<T> createMenuType(ExtendedMenuSupplier<T> extendedMenuSupplier) {
        return IMenuTypeExtension.create((windowId, inventory, friendlyByteBuf) -> extendedMenuSupplier.create(windowId, inventory, friendlyByteBuf));
    }

    @Override
    public <T> Supplier<EntityDataSerializer<T>> registerDataSerializer(String id, IdMap<T> idMap) {
        return FossilsLegacyNeoforgeMod.ENTITY_DATA_SERIALIZER.register(id, () -> EntityDataSerializer.simpleId(idMap));
    }

    @Override
    public <T> RegistryHolder<T> createRegistry(ResourceKey<Registry<T>> resourceKey) {
        return new RegistryHolder.BasicRegistryHolder<>(new RegistryBuilder<T>(resourceKey).create());
    }

    @Override
    public SpawnEggItem createSpawnEgg(Supplier<EntityType<? extends Mob>> entityType, int primaryColor, int secondaryColor, Item.Properties properties) {
        return new DeferredSpawnEggItem(entityType, primaryColor, secondaryColor, properties);
    }

    @Override
    public SpawnEggItem createDinosaurSpawnEgg(Supplier<EntityType<? extends Mob>> entityType, int primaryColor, int secondaryColor, Item.Properties properties) {
        return new DeferredDinosaurSpawnEggItem(entityType, primaryColor, secondaryColor, properties);
    }

    @Override
    public void openContainer(BlockEntity blockEntity, BlockPos blockPos, ServerPlayer serverPlayer) {
        serverPlayer.openMenu((MenuProvider) blockEntity, blockPos);
    }

    @Override
    public boolean featheredDinosaurs() {
        return FossilsLegacyConfig.CLIENT_CONFIG.featheredDinosaurs();
    }

    @Override
    public boolean willAnimalsStarve() {
        return FossilsLegacyConfig.COMMON_CONFIG.willAnimalsStarve();
    }

    @Override
    public boolean willAnimalsBreakBlocks() {
        return FossilsLegacyConfig.COMMON_CONFIG.willAnimalsStarve();
    }

    @Override
    public boolean willAnimalsGrow() {
        return FossilsLegacyConfig.COMMON_CONFIG.willAnimalsGrow();
    }

    @Override
    public boolean shouldAnuSpawn() {
        return FossilsLegacyConfig.COMMON_CONFIG.shouldAnuSpawn();
    }
}
