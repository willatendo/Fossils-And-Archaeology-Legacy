package willatendo.fossilslegacy.server.event;

import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterRecipeBookSearchCategoriesEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import willatendo.fossilslegacy.client.FASearchRecipeBookCategory;
import willatendo.fossilslegacy.network.ClientboundPacketRegistry;
import willatendo.fossilslegacy.network.ServerboundPacketRegistry;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.event.modification.*;
import willatendo.simplelibrary.server.event.registry.*;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = FAUtils.ID)
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
        BasicEvents.idModification(new NeoforgeIdModification(FAUtils.ID, event));
    }

    public static void setupDataMaps() {
        BasicEvents.compostablesSetup(NEOFORGE_COMPOSTABLES_MODIFICATION);
        BasicEvents.heroOfTheVillageGiftSetup(NEOFORGE_HERO_OF_THE_VILLAGE_GIFT_MODIFICATION);
        BasicEvents.oxidationSetup(NEOFORGE_OXIDATION_MODIFICATION);
        BasicEvents.waxableSetup(NEOFORGE_WAXABLE_MODIFICATION);
    }

    @SubscribeEvent
    public static void registerPayloadHandlersEvent(RegisterPayloadHandlersEvent event) {
        NeoforgePacketRegister neoforgePacketRegister = new NeoforgePacketRegister(event, FAUtils.ID, "1.0.0");
        ServerboundPacketRegistry.serverboundPacketSetup(neoforgePacketRegister);
        ClientboundPacketRegistry.clientboundPacketSetup(neoforgePacketRegister);
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

    @SubscribeEvent
    public static void registerRecipeBookSearchCategoriesEvent(RegisterRecipeBookSearchCategoriesEvent event) {
        for (FASearchRecipeBookCategory category : FASearchRecipeBookCategory.values()) {
            event.register(category, category.includedCategories().toArray(RecipeBookCategory[]::new));
        }
    }

    @SubscribeEvent
    public static void syncDatapack(OnDatapackSyncEvent event) {
        event.sendRecipes(RecipeType.CRAFTING, RecipeType.SMELTING, RecipeType.SMOKING, RecipeType.BLASTING, RecipeType.SMITHING);
    }
}
