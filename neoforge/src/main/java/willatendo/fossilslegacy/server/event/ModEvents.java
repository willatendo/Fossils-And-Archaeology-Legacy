package willatendo.fossilslegacy.server.event;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import willatendo.fossilslegacy.network.NeoforgePacketHelper;
import willatendo.fossilslegacy.network.ServerboundSinkPacket;
import willatendo.fossilslegacy.network.ServerboundTimeMachineUpdatePacket;
import willatendo.fossilslegacy.server.FossilsLegacyBuiltInRegistries;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.variants.StoneTabletVariant;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.event.*;
import willatendo.simplelibrary.server.event.modification.NeoforgeCreativeModeTabModification;
import willatendo.simplelibrary.server.event.registry.*;

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
        BasicEvents.buildCreativeModeTabEvent(new NeoforgeCreativeModeTabModification(event));
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
    public static void dataPackRegistryEvent_newRegistry(DataPackRegistryEvent.NewRegistry event) {
        BasicEvents.newDynamicRegistryEvent(new NeoforgeDynamicRegistryRegister(event));
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
