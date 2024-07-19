package willatendo.fossilslegacy.server.event;

import net.minecraft.stats.RecipeBookSettings;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import willatendo.fossilslegacy.network.NeoforgePacketHelper;
import willatendo.fossilslegacy.network.ServerboundSinkPacket;
import willatendo.fossilslegacy.network.ServerboundTimeMachineUpdatePacket;
import willatendo.fossilslegacy.server.inventory.FossilsLegacyRecipeBookTypes;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.event.NeoforgeAttributeRegister;
import willatendo.simplelibrary.server.event.NeoforgeNewRegistryRegister;
import willatendo.simplelibrary.server.event.NeoforgeResourcePackRegister;
import willatendo.simplelibrary.server.event.NeoforgeSpawnPlacementRegister;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = FossilsLegacyUtils.ID)
public class ModEvents {
    @SubscribeEvent
    public static void fmlCommonSetupEvent(FMLCommonSetupEvent event) {
        BasicEvents.commonSetup();
    }

    @SubscribeEvent
    public static void registerPayloadHandlersEvent(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar payloadRegistrar = event.registrar(FossilsLegacyUtils.ID).versioned("1.0.0").optional();

        payloadRegistrar.playToServer(ServerboundTimeMachineUpdatePacket.TYPE, ServerboundTimeMachineUpdatePacket.STREAM_CODEC, NeoforgePacketHelper::handleTimeMachineUpdatePacket);
        payloadRegistrar.playToServer(ServerboundSinkPacket.TYPE, ServerboundSinkPacket.STREAM_CODEC, NeoforgePacketHelper::handleSinkPacket);
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
            }
        }
    }

    @SubscribeEvent
    public static void addPackFindersEvent(AddPackFindersEvent event) {
        BasicEvents.resourcePackEvent(new NeoforgeResourcePackRegister(event));
    }

    @SubscribeEvent
    public static void newRegistryEvent(NewRegistryEvent event) {
        BasicEvents.newRegistryEvent(new NeoforgeNewRegistryRegister(event));
    }

    @SubscribeEvent
    public static void entityAttributeCreationEvent(EntityAttributeCreationEvent event) {
        BasicEvents.attributeEvent(new NeoforgeAttributeRegister(event));
    }

    @SubscribeEvent
    public static void spawnPlacementRegisterEvent(RegisterSpawnPlacementsEvent event) {
        BasicEvents.spawnPlacementEvent(new NeoforgeSpawnPlacementRegister(event));
    }
}
