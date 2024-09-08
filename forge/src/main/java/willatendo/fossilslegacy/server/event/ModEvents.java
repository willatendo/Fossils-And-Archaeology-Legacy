package willatendo.fossilslegacy.server.event;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DataPackRegistryEvent;
import net.minecraftforge.registries.NewRegistryEvent;
import willatendo.fossilslegacy.network.ForgePacketHelper;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.event.registry.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = FossilsLegacyUtils.ID)
public class ModEvents {
    @SubscribeEvent
    public static void fmlCommonSetupEvent(FMLCommonSetupEvent event) {
        BasicEvents.commonSetup();
        event.enqueueWork(ForgePacketHelper::register);
    }

    @SubscribeEvent
    public static void buildCreativeModeTabContentsEvent(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.OP_BLOCKS) {
            if (event.hasPermissions()) {
                event.accept(FossilsLegacyItems.DEBUG_MAX_HUNGER.get());
                event.accept(FossilsLegacyItems.DEBUG_MAX_HEALTH.get());
                event.accept(FossilsLegacyItems.DEBUG_FULL_GROWN.get());
                event.accept(FossilsLegacyItems.DEBUG_BABY.get());
                event.accept(FossilsLegacyItems.DEBUG_TAME.get());
                event.accept(FossilsLegacyItems.DEBUG_CHANGE_GENETICS.get());
            }
        }
    }

    @SubscribeEvent
    public static void addPackFindersEvent(AddPackFindersEvent event) {
        BasicEvents.resourcePackEvent(new ForgeResourcePackRegister(event));
    }

    @SubscribeEvent
    public static void newRegistryEvent(NewRegistryEvent event) {
        BasicEvents.newRegistryEvent(new ForgeNewRegistryRegister(event));
    }

    @SubscribeEvent
    public static void dataPackRegistryEvent_newRegistry(DataPackRegistryEvent.NewRegistry event) {
        BasicEvents.newDynamicRegistryEvent(new ForgeDynamicRegistryRegister(event));
    }

    @SubscribeEvent
    public static void entityAttributeCreationEvent(EntityAttributeCreationEvent event) {
        BasicEvents.attributeEvent(new ForgeAttributeRegister(event));
    }

    @SubscribeEvent
    public static void spawnPlacementRegisterEvent(SpawnPlacementRegisterEvent event) {
        BasicEvents.spawnPlacementEvent(new ForgeSpawnPlacementRegister(event));
    }
}
