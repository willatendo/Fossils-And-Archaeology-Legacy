package willatendo.fossilslegacy.platform;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import willatendo.fossilslegacy.server.block.entity.CultivatorBlockEntity;
import willatendo.fossilslegacy.server.config.FossilsLegacyForgeConfig;
import willatendo.fossilslegacy.server.menu.ExtendedMenuSupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class FossilsForgeHelper implements FossilsModloaderHelper {
    public static final List<DeferredRegister<?>> DEFERRED_REGISTERS = new ArrayList<>();

    @Override
    public <T extends AbstractContainerMenu> MenuType<T> createMenuType(ExtendedMenuSupplier<T> extendedMenuSupplier) {
        return IForgeMenuType.create((windowId, inventory, friendlyByteBuf) -> extendedMenuSupplier.create(windowId, inventory, friendlyByteBuf));
    }

    @Override
    public <T> Registry<T> createRegistry(ResourceKey<Registry<T>> resourceKey) {
        RegistryBuilder<T> registryBuilder = new RegistryBuilder<T>().setName(resourceKey.location()).setMaxID(Integer.MAX_VALUE - 1).disableSync().disableSaving().hasTags();
        DeferredRegister<T> deferredRegister = DeferredRegister.create(resourceKey, resourceKey.location().getNamespace());
        Supplier<IForgeRegistry<T>> iForgeRegistry = deferredRegister.makeRegistry(() -> registryBuilder);
        DEFERRED_REGISTERS.add(deferredRegister);
        return (Registry<T>) BuiltInRegistries.REGISTRY.get(resourceKey.location());
    }

    @Override
    public void openContainer(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof CultivatorBlockEntity cultivatorBlockEntity && player instanceof ServerPlayer serverPlayer) {
            serverPlayer.openMenu(cultivatorBlockEntity, blockPos);
        }
    }

    @Override
    public boolean willAnimalsStarve() {
        return FossilsLegacyForgeConfig.COMMON_CONFIG.willAnimalsStarve();
    }

    @Override
    public boolean willAnimalsBreakBlocks() {
        return FossilsLegacyForgeConfig.COMMON_CONFIG.willAnimalsStarve();
    }

    @Override
    public boolean willAnimalsGrow() {
        return FossilsLegacyForgeConfig.COMMON_CONFIG.willAnimalsGrow();
    }

    @Override
    public boolean shouldAnuSpawn() {
        return FossilsLegacyForgeConfig.COMMON_CONFIG.shouldAnuSpawn();
    }

    @Override
    public boolean shouldEnableExperiments() {
        return FossilsLegacyForgeConfig.SERVER_CONFIG.shouldEnableExperiments();
    }
}
