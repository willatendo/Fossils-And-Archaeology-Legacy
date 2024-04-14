package willatendo.fossilslegacy.server.event;

import java.util.Optional;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.Util;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.SpawnPlacements.Type;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.animal.horse.Mule;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.Heightmap;
import willatendo.fossilslegacy.server.biomes.FossilsLegacyPlacedFeatures;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.dispenser.DispenseEntityItemBehavior;
import willatendo.fossilslegacy.server.entity.Anu;
import willatendo.fossilslegacy.server.entity.Brachiosaurus;
import willatendo.fossilslegacy.server.entity.Dilophosaurus;
import willatendo.fossilslegacy.server.entity.Egg;
import willatendo.fossilslegacy.server.entity.Failuresaurus;
import willatendo.fossilslegacy.server.entity.Fossil;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.entity.Futabasaurus;
import willatendo.fossilslegacy.server.entity.Mammoth;
import willatendo.fossilslegacy.server.entity.Mosasaurus;
import willatendo.fossilslegacy.server.entity.Nautilus;
import willatendo.fossilslegacy.server.entity.Pteranodon;
import willatendo.fossilslegacy.server.entity.Smilodon;
import willatendo.fossilslegacy.server.entity.Stegosaurus;
import willatendo.fossilslegacy.server.entity.ThrownIncubatedEgg;
import willatendo.fossilslegacy.server.entity.Triceratops;
import willatendo.fossilslegacy.server.entity.Tyrannosaurus;
import willatendo.fossilslegacy.server.entity.Velociraptor;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;

public class ModEvents {
	public static void events() {
		addToCreativeModeTabs();
		addToMaps();
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

	public static void addToMaps() {
		ComposterBlock.COMPOSTABLES.put(FossilsLegacyBlocks.JURASSIC_FERN.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(FossilsLegacyItems.JURASSIC_FERN_SPORES.get(), 0.65F);

		FossilsLegacyItems.EGGS.forEach(eggItem -> DispenserBlock.registerBehavior(eggItem.get(), new DispenseEntityItemBehavior(entity -> ((Egg) entity).setEggVariant(eggItem.get().getEggVariant()))));
		DispenserBlock.registerBehavior(FossilsLegacyItems.NAUTILUS_EGGS.get(), new DispenseEntityItemBehavior());
		DispenserBlock.registerBehavior(FossilsLegacyItems.NAUTILUS.get(), new DispenseEntityItemBehavior());
		DispenserBlock.registerBehavior(FossilsLegacyItems.FOSSIL.get(), new DispenseEntityItemBehavior());
		DispenserBlock.registerBehavior(FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get(), new AbstractProjectileDispenseBehavior() {
			@Override
			protected Projectile getProjectile(Level level, Position position, ItemStack itemStack) {
				return Util.make(new ThrownIncubatedEgg(level, position.x(), position.y(), position.z()), thrownIncubatedEgg -> {
					thrownIncubatedEgg.setItem(itemStack);
					thrownIncubatedEgg.setEggType(0);
				});
			}
		});
		DispenserBlock.registerBehavior(FossilsLegacyItems.INCUBATED_PARROT_EGG.get(), new AbstractProjectileDispenseBehavior() {
			@Override
			protected Projectile getProjectile(Level level, Position position, ItemStack itemStack) {
				return Util.make(new ThrownIncubatedEgg(level, position.x(), position.y(), position.z()), thrownIncubatedEgg -> {
					thrownIncubatedEgg.setItem(itemStack);
					thrownIncubatedEgg.setEggType(1);
				});
			}
		});
	}

	public static void addToBiomes() {
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FossilsLegacyPlacedFeatures.ORE_FOSSIL);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FossilsLegacyPlacedFeatures.ORE_PERMAFROST);
		BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.HAS_OCEAN_RUIN_WARM), MobCategory.WATER_AMBIENT, FossilsLegacyEntityTypes.NAUTILUS.get(), 1, 1, 1);
		BiomeModifications.addSpawn(BiomeSelectors.foundInTheNether(), MobCategory.MONSTER, FossilsLegacyEntityTypes.ANU.get(), 1, 1, 1);
	}

	public static void addEntityAttributes() {
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.ANU.get(), Anu.anuAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), Brachiosaurus.brachiosaurusAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), Dilophosaurus.dilophosaurusAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.EGG.get(), Egg.eggAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.FAILURESAURUS.get(), Failuresaurus.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.FOSSIL.get(), Fossil.fossilAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.MAMMOTH.get(), Mammoth.mammothAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.MOSASAURUS.get(), Mosasaurus.mosasaurusAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.NAUTILUS.get(), Nautilus.nautilusAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.FUTABASAURUS.get(), Futabasaurus.plesiosaurusAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PREGNANT_CAT.get(), Cat.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PREGNANT_COW.get(), Cow.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PREGNANT_DOLPHIN.get(), Dolphin.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PREGNANT_DONKEY.get(), Donkey.createBaseChestedHorseAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PREGNANT_FOX.get(), Fox.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PREGNANT_GOAT.get(), Goat.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PREGNANT_HORSE.get(), Horse.createBaseHorseAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PREGNANT_LLAMA.get(), Llama.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PREGNANT_MAMMOTH.get(), Mammoth.mammothAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PREGNANT_SMILODON.get(), Smilodon.smilodonAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PREGNANT_MULE.get(), Mule.createBaseChestedHorseAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PREGNANT_OCELOT.get(), Ocelot.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PREGNANT_PANDA.get(), Panda.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PREGNANT_PIG.get(), Pig.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PREGNANT_POLAR_BEAR.get(), PolarBear.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PREGNANT_RABBIT.get(), Rabbit.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), Sheep.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PREGNANT_WOLF.get(), Wolf.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.PTERANODON.get(), Pteranodon.pteranodonAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.SMILODON.get(), Smilodon.smilodonAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.STEGOSAURUS.get(), Stegosaurus.stegosaurusAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get(), ZombifiedPiglin.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.TRICERATOPS.get(), Triceratops.triceratopsAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), Tyrannosaurus.tyrannosaurusAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntityTypes.VELOCIRAPTOR.get(), Velociraptor.velociraptorAttributes());
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
