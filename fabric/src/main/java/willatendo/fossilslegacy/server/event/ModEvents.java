package willatendo.fossilslegacy.server.event;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.SpawnPlacements.Type;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.Heightmap;
import willatendo.fossilslegacy.server.biomes.FossilsLegacyPlacedFeatures;
import willatendo.fossilslegacy.server.entity.Anu;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.entity.Nautilus;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;

import java.util.Optional;

public class ModEvents {
    public static void events() {
        BasicEvents.addToMaps();
        addToCreativeModeTabs();
        addToBiomes();
        addEntityAttributes();
        addEntitySpawnPlacements();
        addResourcePacks();
    }

    public static void addToCreativeModeTabs() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.OP_BLOCKS).register(fabricItemGroupEntries -> {
            for (SimpleHolder<? extends Item> items : FossilsLegacyItems.DEBUG_ITEMS.getEntriesView()) {
                fabricItemGroupEntries.accept(items.get());
            }
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.addAfter(Items.ALLAY_SPAWN_EGG, FossilsLegacyItems.ANU_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.BLAZE_SPAWN_EGG, FossilsLegacyItems.BRACHIOSAURUS_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.CREEPER_SPAWN_EGG, FossilsLegacyItems.DILOPHOSAURUS_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.EVOKER_SPAWN_EGG, FossilsLegacyItems.FAILURESAURUS_SPAWN_EGG.get(), FossilsLegacyItems.FUTABASAURUS_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.MAGMA_CUBE_SPAWN_EGG, FossilsLegacyItems.MAMMOTH_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.MOOSHROOM_SPAWN_EGG, FossilsLegacyItems.MOSASAURUS_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.MULE_SPAWN_EGG, FossilsLegacyItems.NAUTILUS_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.POLAR_BEAR_SPAWN_EGG, FossilsLegacyItems.PTERANODON_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.SLIME_SPAWN_EGG, FossilsLegacyItems.SMILODON_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.SQUID_SPAWN_EGG, FossilsLegacyItems.STEGOSAURUS_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.TRADER_LLAMA_SPAWN_EGG, FossilsLegacyItems.TRICERATOPS_SPAWN_EGG.get());
            fabricItemGroupEntries.addAfter(Items.TURTLE_SPAWN_EGG, FossilsLegacyItems.TYRANNOSAURUS_SPAWN_EGG.get());
        });
    }

    public static void addToBiomes() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FossilsLegacyPlacedFeatures.ORE_FOSSIL);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FossilsLegacyPlacedFeatures.ORE_PERMAFROST);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.HAS_OCEAN_RUIN_WARM), MobCategory.WATER_AMBIENT, FossilsLegacyEntityTypes.NAUTILUS.get(), 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.foundInTheNether(), MobCategory.MONSTER, FossilsLegacyEntityTypes.ANU.get(), 1, 1, 1);
    }

    public static void addEntityAttributes() {
        BasicEvents.ATTRIBUTES.forEach(attributes -> {
            FabricDefaultAttributeRegistry.register(attributes.entityType(), attributes.attributeSupplier());
        });
    }

    public static void addEntitySpawnPlacements() {
        SpawnPlacements.register(FossilsLegacyEntityTypes.ANU.get(), Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Anu::checkAnuSpawnRules);
        SpawnPlacements.register(FossilsLegacyEntityTypes.NAUTILUS.get(), Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Nautilus::checkNautilusSpawnRules);
    }

    public static void addResourcePacks() {
        Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(FossilsLegacyUtils.ID);
        ResourceManagerHelper.registerBuiltinResourcePack(FossilsLegacyUtils.resource("fa_legacy_textures"), modContainer.get(), FossilsLegacyUtils.translation("pack", "fa_legacy_textures"), ResourcePackActivationType.NORMAL);
    }
}