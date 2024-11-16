package willatendo.fossilslegacy.server.event;

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
import willatendo.fossilslegacy.network.*;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.event.modification.*;
import willatendo.simplelibrary.server.event.registry.*;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = FossilsLegacyUtils.ID)
public class ModEvents {
    public static final NeoforgeCompostablesModification NEOFORGE_COMPOSTABLES_MODIFICATION = new NeoforgeCompostablesModification();
    public static final NeoforgeHeroOfTheVillageGiftModification NEOFORGE_HERO_OF_THE_VILLAGE_GIFT_MODIFICATION = new NeoforgeHeroOfTheVillageGiftModification();
    public static final NeoforgeOxidationModification NEOFORGE_OXIDATION_MODIFICATION = new NeoforgeOxidationModification();
    public static final NeoforgeWaxableModification NEOFORGE_WAXABLE_MODIFICATION = new NeoforgeWaxableModification();

    @SubscribeEvent
    public static void fmlCommonSetupEvent(FMLCommonSetupEvent event) {
        BasicEvents.commonSetup();
        BasicEvents.strippablesSetup(new NeoforgeStrippablesModification());
        ModEvents.setupDataMaps();
    }

    public static void setupDataMaps() {
        BasicEvents.compostablesSetup(NEOFORGE_COMPOSTABLES_MODIFICATION);
        BasicEvents.heroOfTheVillageGiftSetup(NEOFORGE_HERO_OF_THE_VILLAGE_GIFT_MODIFICATION);
        BasicEvents.oxidationSetup(NEOFORGE_OXIDATION_MODIFICATION);
        BasicEvents.waxableSetup(NEOFORGE_WAXABLE_MODIFICATION);
    }

    @SubscribeEvent
    public static void registerPayloadHandlersEvent(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar payloadRegistrar = event.registrar(FossilsLegacyUtils.ID).versioned("1.0.0").optional();

        payloadRegistrar.playToClient(ClientboundAlertUnlockedCoatTypesPacket.TYPE, ClientboundAlertUnlockedCoatTypesPacket.STREAM_CODEC, NeoforgePacketHelper::handleAlertUnlockedCoatTypes);

        payloadRegistrar.playToServer(ServerboundApplyGenePacket.TYPE, ServerboundApplyGenePacket.STREAM_CODEC, NeoforgePacketHelper::handleApplyGenePacket);
        payloadRegistrar.playToServer(ServerboundSinkPacket.TYPE, ServerboundSinkPacket.STREAM_CODEC, NeoforgePacketHelper::handleSinkPacket);
        payloadRegistrar.playToServer(ServerboundTimeMachineUpdatePacket.TYPE, ServerboundTimeMachineUpdatePacket.STREAM_CODEC, NeoforgePacketHelper::handleTimeMachineUpdatePacket);
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
