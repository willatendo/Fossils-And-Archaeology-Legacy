package willatendo.fossilslegacy.server.menu;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import willatendo.fossilslegacy.server.menu.menus.*;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.menu.ExtendedMenuSupplier;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.SimpleUtils;

public final class FAMenuTypes {
    public static final SimpleRegistry<MenuType<?>> MENU_TYPES = SimpleRegistry.create(Registries.MENU, FAUtils.ID);

    public static final SimpleHolder<MenuType<ArchaeologyWorkbenchMenu>> ARCHAEOLOGY_WORKBENCH = FAMenuTypes.register("archaeology_workbench", ArchaeologyWorkbenchMenu::new, ArchaeologyWorkbenchMenu::new);
    public static final SimpleHolder<MenuType<PalaeontologyTableMenu>> PALAEONTOLOGY_TABLE = FAMenuTypes.register("palaeontology_table", PalaeontologyTableMenu::new);
    public static final SimpleHolder<MenuType<AnalyzerMenu>> ANALYZER = FAMenuTypes.register("analyzer", AnalyzerMenu::new, AnalyzerMenu::new);
    public static final SimpleHolder<MenuType<CultivatorMenu>> CULTIVATOR = FAMenuTypes.register("cultivator", CultivatorMenu::new, CultivatorMenu::new);
    public static final SimpleHolder<MenuType<FeederMenu>> FEEDER = FAMenuTypes.register("feeder", FeederMenu::new, FeederMenu::new);
    public static final SimpleHolder<MenuType<TimeMachineMenu>> TIME_MACHINE = FAMenuTypes.register("time_machine", TimeMachineMenu::new, TimeMachineMenu::new);
    public static final SimpleHolder<MenuType<GeneModificationTableMenu>> GENE_MODIFICATION = FAMenuTypes.register("gene_modification", GeneModificationTableMenu::new, GeneModificationTableMenu::new);

    private static <T extends AbstractContainerMenu> SimpleHolder<MenuType<T>> register(String id, CreateSimple<T> createSimple) {
        return MENU_TYPES.register(id, () -> SimpleUtils.createMenuType(new ExtendedMenuSupplier<T>() {
            @Override
            public T create(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
                return createSimple.create(windowId, inventory);
            }

            @Override
            public T create(int windowId, Inventory inventory, BlockPos blockPos) {
                return createSimple.create(windowId, inventory);
            }
        }));
    }

    private static <T extends AbstractContainerMenu> SimpleHolder<MenuType<T>> register(String id, CreateFromServer<T> createFromServer, CreateFromBlockPos<T> createFromBlockPos) {
        return MENU_TYPES.register(id, () -> SimpleUtils.createMenuType(new ExtendedMenuSupplier<T>() {
            @Override
            public T create(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
                return createFromServer.create(windowId, inventory, friendlyByteBuf);
            }

            @Override
            public T create(int windowId, Inventory inventory, BlockPos blockPos) {
                return createFromBlockPos.create(windowId, inventory, blockPos);
            }
        }));
    }

    public interface CreateSimple<T extends AbstractContainerMenu> {
        T create(int windowId, Inventory inventory);
    }

    public interface CreateFromServer<T extends AbstractContainerMenu> {
        T create(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf);
    }

    public interface CreateFromBlockPos<T extends AbstractContainerMenu> {
        T create(int windowId, Inventory inventory, BlockPos blockPos);
    }
}
