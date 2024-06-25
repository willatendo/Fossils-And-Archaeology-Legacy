package willatendo.fossilslegacy.server.event;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.SpawnPlacementRegisterEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import willatendo.fossilslegacy.FossilsLegacyNeoforgeMod;
import willatendo.fossilslegacy.network.NeoforgePacketHelper;
import willatendo.fossilslegacy.network.ServerboundSinkPacket;
import willatendo.fossilslegacy.network.ServerboundTimeMachineUpdatePacket;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.event.NeoforgeAttributeRegister;
import willatendo.simplelibrary.server.event.NeoforgeNewRegistryRegister;
import willatendo.simplelibrary.server.event.NeoforgeResourcePackRegister;
import willatendo.simplelibrary.server.event.NeoforgeSpawnPlacementRegister;
import willatendo.simplelibrary.server.registry.NeoForgeRegister;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = FossilsLegacyUtils.ID)
public class ModEvents {
    @SubscribeEvent
    public static void fmlCommonSetupEvent(FMLCommonSetupEvent event) {
        BasicEvents.commonSetup();
    }

    @SubscribeEvent
    public static void registerEvent(RegisterEvent event) {
        NeoForgeRegister.register(event, FossilsLegacyNeoforgeMod.REGISTRIES.toArray(SimpleRegistry[]::new));
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
            for (SimpleHolder<? extends Item> items : FossilsLegacyItems.DEBUG_ITEMS.getEntriesView()) {
                if (event.hasPermissions()) {
                    event.accept(items.get());
                }
            }
        }
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.getEntries().putAfter(new ItemStack(Items.ALLAY_SPAWN_EGG), new ItemStack(FossilsLegacyItems.ANU_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.BLAZE_SPAWN_EGG), new ItemStack(FossilsLegacyItems.BRACHIOSAURUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.CAT_SPAWN_EGG), new ItemStack(FossilsLegacyItems.CARNOTAURUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(FossilsLegacyItems.CARNOTAURUS_SPAWN_EGG.get()), new ItemStack(FossilsLegacyItems.CRYOLOPHOSAURUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.CREEPER_SPAWN_EGG), new ItemStack(FossilsLegacyItems.DILOPHOSAURUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.EVOKER_SPAWN_EGG), new ItemStack(FossilsLegacyItems.FAILURESAURUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(FossilsLegacyItems.FAILURESAURUS_SPAWN_EGG.get()), new ItemStack(FossilsLegacyItems.FUTABASAURUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.MAGMA_CUBE_SPAWN_EGG), new ItemStack(FossilsLegacyItems.MAMMOTH_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.MOOSHROOM_SPAWN_EGG), new ItemStack(FossilsLegacyItems.MOSASAURUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.MULE_SPAWN_EGG), new ItemStack(FossilsLegacyItems.NAUTILUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.POLAR_BEAR_SPAWN_EGG), new ItemStack(FossilsLegacyItems.PTERANODON_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.SLIME_SPAWN_EGG), new ItemStack(FossilsLegacyItems.SMILODON_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.SQUID_SPAWN_EGG), new ItemStack(FossilsLegacyItems.STEGOSAURUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.TADPOLE_SPAWN_EGG), new ItemStack(FossilsLegacyItems.THERIZINOSAURUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.TRADER_LLAMA_SPAWN_EGG), new ItemStack(FossilsLegacyItems.TRICERATOPS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.TURTLE_SPAWN_EGG), new ItemStack(FossilsLegacyItems.TYRANNOSAURUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(FossilsLegacyItems.TYRANNOSAURUS_SPAWN_EGG.get()), new ItemStack(FossilsLegacyItems.VELOCIRAPTOR_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
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
    public static void spawnPlacementRegisterEvent(SpawnPlacementRegisterEvent event) {
        BasicEvents.spawnPlacementEvent(new NeoforgeSpawnPlacementRegister(event));
    }
}
