package willatendo.fossilslegacy.server.event;

import net.minecraft.world.entity.ai.behavior.GiveGiftToHero;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DataPackRegistryEvent;
import net.minecraftforge.registries.NewRegistryEvent;
import willatendo.fossilslegacy.network.ForgePacketHelper;
import willatendo.fossilslegacy.server.entity.FAVillagerProfessions;
import willatendo.fossilslegacy.server.item.FALootTables;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.event.modification.*;
import willatendo.simplelibrary.server.event.registry.ForgeAttributeRegister;
import willatendo.simplelibrary.server.event.registry.ForgeDynamicRegistryRegister;
import willatendo.simplelibrary.server.event.registry.ForgeNewRegistryRegister;
import willatendo.simplelibrary.server.event.registry.ForgeResourcePackRegister;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = FAUtils.ID)
public class ModEvents {
    @SubscribeEvent
    public static void fmlCommonSetupEvent(FMLCommonSetupEvent event) {
        BasicEvents.commonSetup();
        event.enqueueWork(ForgePacketHelper::register);
        BasicEvents.strippablesSetup(new ForgeStrippablesModification());
        BasicEvents.compostablesSetup(new ForgeCompostablesModification());
        BasicEvents.heroOfTheVillageGiftSetup(new ForgeHeroOfTheVillageGiftModification());
        BasicEvents.oxidationSetup(new ForgeOxidationModification());
        BasicEvents.waxableSetup(new ForgeWaxableModification());

        GiveGiftToHero.GIFTS.put(FAVillagerProfessions.ARCHAEOLOGIST.get(), FALootTables.ARCHAEOLOGIST_GIFT);
        GiveGiftToHero.GIFTS.put(FAVillagerProfessions.PALAEONTOLOGIST.get(), FALootTables.PALAEONTOLOGIST_GIFT);
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
}
