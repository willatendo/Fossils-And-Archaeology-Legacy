package willatendo.fossilslegacy.server.menu;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.menu.ExtendedMenuSupplier;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.List;

public class FossilsLegacyMenuTypes {
    public static final SimpleRegistry<MenuType<?>> MENU_TYPES = SimpleRegistry.create(Registries.MENU, FossilsLegacyUtils.ID);

    public static final SimpleHolder<MenuType<ArchaeologyWorkbenchMenu>> ARCHAEOLOGY_WORKBENCH = MENU_TYPES.register("archaeology_workbench", () -> SimpleUtils.createMenuType(new ExtendedMenuSupplier<ArchaeologyWorkbenchMenu>() {
        @Override
        public ArchaeologyWorkbenchMenu create(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
            return new ArchaeologyWorkbenchMenu(windowId, inventory, friendlyByteBuf);
        }

        @Override
        public ArchaeologyWorkbenchMenu create(int windowId, Inventory inventory, BlockPos blockPos) {
            return new ArchaeologyWorkbenchMenu(windowId, inventory, blockPos);
        }
    }));
    public static final SimpleHolder<MenuType<AnalyzerMenu>> ANALYZER = MENU_TYPES.register("analyzer", () -> SimpleUtils.createMenuType(new ExtendedMenuSupplier<AnalyzerMenu>() {
        @Override
        public AnalyzerMenu create(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
            return new AnalyzerMenu(windowId, inventory, friendlyByteBuf);
        }

        @Override
        public AnalyzerMenu create(int windowId, Inventory inventory, BlockPos blockPos) {
            return new AnalyzerMenu(windowId, inventory, blockPos);
        }
    }));
    public static final SimpleHolder<MenuType<CultivatorMenu>> CULTIVATOR = MENU_TYPES.register("cultivator", () -> SimpleUtils.createMenuType(new ExtendedMenuSupplier<CultivatorMenu>() {
        @Override
        public CultivatorMenu create(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
            return new CultivatorMenu(windowId, inventory, friendlyByteBuf);
        }

        @Override
        public CultivatorMenu create(int windowId, Inventory inventory, BlockPos blockPos) {
            return new CultivatorMenu(windowId, inventory, blockPos);
        }
    }));
    public static final SimpleHolder<MenuType<FeederMenu>> FEEDER = MENU_TYPES.register("feeder", () -> SimpleUtils.createMenuType(new ExtendedMenuSupplier<FeederMenu>() {
        @Override
        public FeederMenu create(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
            return new FeederMenu(windowId, inventory, friendlyByteBuf);
        }

        @Override
        public FeederMenu create(int windowId, Inventory inventory, BlockPos blockPos) {
            return new FeederMenu(windowId, inventory, blockPos);
        }
    }));
    public static final SimpleHolder<MenuType<TimeMachineMenu>> TIME_MACHINE = MENU_TYPES.register("time_machine", () -> SimpleUtils.createMenuType(new ExtendedMenuSupplier<TimeMachineMenu>() {
        @Override
        public TimeMachineMenu create(int windowId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
            return new TimeMachineMenu(windowId, inventory, friendlyByteBuf);
        }

        @Override
        public TimeMachineMenu create(int windowId, Inventory inventory, BlockPos blockPos) {
            return new TimeMachineMenu(windowId, inventory, blockPos);
        }
    }));
    ;

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(MENU_TYPES);
    }
}
