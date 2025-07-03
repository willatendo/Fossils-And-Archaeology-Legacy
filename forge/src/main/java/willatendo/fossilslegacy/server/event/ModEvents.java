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
import willatendo.fossilslegacy.network.ClientboundPacketRegistry;
import willatendo.fossilslegacy.network.ForgePacketHelper;
import willatendo.fossilslegacy.network.ServerboundPacketRegistry;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.event.modification.ForgeCompostablesModification;
import willatendo.simplelibrary.server.event.modification.ForgeCreativeModeTabModification;
import willatendo.simplelibrary.server.event.modification.ForgeHeroOfTheVillageGiftModification;
import willatendo.simplelibrary.server.event.modification.ForgeStrippablesModification;
import willatendo.simplelibrary.server.event.registry.*;

import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = FAUtils.ID)
public class ModEvents {
    @SubscribeEvent
    public static void fmlCommonSetupEvent(FMLCommonSetupEvent event) {
        BasicEvents.commonSetup();
        event.enqueueWork(() -> {
            ForgePacketRegister forgePacketRegister = new ForgePacketRegister(FAUtils.resource("main"));
            ServerboundPacketRegistry.serverboundPacketSetup(forgePacketRegister);
            ClientboundPacketRegistry.clientboundPacketSetup(forgePacketRegister);
        });
        BasicEvents.strippablesSetup(new ForgeStrippablesModification());
        BasicEvents.compostablesSetup(new ForgeCompostablesModification());
        GiveGiftToHero.GIFTS = new HashMap<>(GiveGiftToHero.GIFTS);
        BasicEvents.heroOfTheVillageGiftSetup(new ForgeHeroOfTheVillageGiftModification());
        //     BasicEvents.oxidationSetup(new ForgeOxidationModification());
        //  BasicEvents.waxableSetup(new ForgeWaxableModification());
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
