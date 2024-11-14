package willatendo.fossilslegacy.server.event;

import net.minecraft.world.entity.ai.behavior.GiveGiftToHero;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DataPackRegistryEvent;
import net.minecraftforge.registries.NewRegistryEvent;
import willatendo.fossilslegacy.network.ForgePacketHelper;
import willatendo.fossilslegacy.server.entity.FossilsLegacyVillagerProfessions;
import willatendo.fossilslegacy.server.item.FossilsLegacyLootTables;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.event.modification.ForgeCreativeModeTabModification;
import willatendo.simplelibrary.server.event.modification.ForgeVillagerTradeModification;
import willatendo.simplelibrary.server.event.registry.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = FossilsLegacyUtils.ID)
public class ModEvents {
    @SubscribeEvent
    public static void fmlCommonSetupEvent(FMLCommonSetupEvent event) {
        BasicEvents.commonSetup();
        event.enqueueWork(ForgePacketHelper::register);
        BasicEvents.compostablesSetup();

        GiveGiftToHero.GIFTS.put(FossilsLegacyVillagerProfessions.ARCHAEOLOGIST.get(), FossilsLegacyLootTables.ARCHAEOLOGIST_GIFT);
        GiveGiftToHero.GIFTS.put(FossilsLegacyVillagerProfessions.PALAEONTOLOGIST.get(), FossilsLegacyLootTables.PALAEONTOLOGIST_GIFT);
    }

    @SubscribeEvent
    public static void buildCreativeModeTabContentsEvent(BuildCreativeModeTabContentsEvent event) {
        BasicEvents.buildCreativeModeTabEvent(new ForgeCreativeModeTabModification(event));
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
