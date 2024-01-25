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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.Heightmap;
import willatendo.fossilslegacy.server.biomes.FossilsLegacyPlacedFeatures;
import willatendo.fossilslegacy.server.entity.AncientLightningBolt;
import willatendo.fossilslegacy.server.entity.Anu;
import willatendo.fossilslegacy.server.entity.Brachiosaurus;
import willatendo.fossilslegacy.server.entity.Dilophosaurus;
import willatendo.fossilslegacy.server.entity.DrownedPirate;
import willatendo.fossilslegacy.server.entity.Egg;
import willatendo.fossilslegacy.server.entity.Failuresaurus;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;
import willatendo.fossilslegacy.server.entity.Mammoth;
import willatendo.fossilslegacy.server.entity.Mosasaurus;
import willatendo.fossilslegacy.server.entity.Nautilus;
import willatendo.fossilslegacy.server.entity.Plesiosaurus;
import willatendo.fossilslegacy.server.entity.Pteranodon;
import willatendo.fossilslegacy.server.entity.Smilodon;
import willatendo.fossilslegacy.server.entity.Stegosaurus;
import willatendo.fossilslegacy.server.entity.Triceratops;
import willatendo.fossilslegacy.server.entity.Tyrannosaurus;
import willatendo.fossilslegacy.server.entity.Velociraptor;
import willatendo.fossilslegacy.server.entity.TamedZombifiedPiglin;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.event.EntityStruckByLightningCallback;
import willatendo.simplelibrary.server.event.StruckByLightningCallback;

public class ModEvents {
	public static void lightning() {
		StruckByLightningCallback.EVENT.register((entity, lightningBolt) -> {
			if (lightningBolt instanceof AncientLightningBolt ancientLightningBolt) {
				if (entity instanceof Pig pig) {
					return false;
				}
				return true;
			}
			return true;
		});

		EntityStruckByLightningCallback.EVENT.register((entity, lightningBolt) -> {
			if (lightningBolt instanceof AncientLightningBolt ancientLightningBolt) {
				if (entity instanceof Pig pig) {
					Level level = ancientLightningBolt.level();
					TamedZombifiedPiglin zombifiedPigman = FossilsLegacyEntities.TAMED_ZOMBIFIED_PIGLIN.get().create(level);
					zombifiedPigman.tame(((Player) ancientLightningBolt.getOwner()));
					zombifiedPigman.sendMessageToPlayer(TamedZombifiedPiglin.TameZombifiedPiglinSpeaker.SUMMON, ((Player) ancientLightningBolt.getOwner()));
					zombifiedPigman.setItemInHand(InteractionHand.MAIN_HAND, FossilsLegacyItems.ANCIENT_SWORD.get().getDefaultInstance());
					zombifiedPigman.setItemSlot(EquipmentSlot.HEAD, FossilsLegacyItems.ANCIENT_HELMET.get().getDefaultInstance());
					zombifiedPigman.moveTo(pig.getX(), pig.getY(), pig.getZ());
					zombifiedPigman.setHealth(zombifiedPigman.getMaxHealth());
					level.addFreshEntity(zombifiedPigman);
					pig.discard();
				}
			}
		});
	}

	public static void addLegacyPack() {
		Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(FossilsLegacyUtils.ID);
		ResourceManagerHelper.registerBuiltinResourcePack(FossilsLegacyUtils.resource("fa_legacy_textures"), modContainer.get(), FossilsLegacyUtils.translation("pack", "fa_legacy_textures"), ResourcePackActivationType.NORMAL);
	}

	public static void entityAttributes() {
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.BRACHIOSAURUS.get(), Brachiosaurus.brachiosaurusAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.DILOPHOSAURUS.get(), Dilophosaurus.dilophosaurusAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.MAMMOTH.get(), Mammoth.mammothAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.MOSASAURUS.get(), Mosasaurus.mosasaurusAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.NAUTILUS.get(), Nautilus.nautilusAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PLESIOSAURUS.get(), Plesiosaurus.plesiosaurusAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PTERANODON.get(), Pteranodon.pteranodonAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.SMILODON.get(), Smilodon.smilodonAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.STEGOSAURUS.get(), Stegosaurus.stegosaurusAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.TRICERATOPS.get(), Triceratops.triceratopsAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.TYRANNOSAURUS.get(), Tyrannosaurus.tyrannosaurusAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.VELOCIRAPTOR.get(), Velociraptor.velociraptorAttributes());

		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.TAMED_ZOMBIFIED_PIGLIN.get(), ZombifiedPiglin.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.DROWNED_PIRATE.get(), DrownedPirate.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.FAILURESAURUS.get(), Failuresaurus.createAttributes().build());

		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.EGG.get(), Egg.eggAttributes());

		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PREGNANT_CAT.get(), Cat.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PREGNANT_COW.get(), Cow.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PREGNANT_DOLPHIN.get(), Dolphin.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PREGNANT_DONKEY.get(), Donkey.createBaseChestedHorseAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PREGNANT_FOX.get(), Fox.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PREGNANT_GOAT.get(), Goat.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PREGNANT_HORSE.get(), Horse.createBaseHorseAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PREGNANT_LLAMA.get(), Llama.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PREGNANT_MAMMOTH.get(), Mammoth.mammothAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PREGNANT_SMILODON.get(), Smilodon.smilodonAttributes());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PREGNANT_MULE.get(), Mule.createBaseChestedHorseAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PREGNANT_OCELOT.get(), Ocelot.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PREGNANT_PANDA.get(), Panda.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PREGNANT_PIG.get(), Pig.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PREGNANT_POLAR_BEAR.get(), PolarBear.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PREGNANT_RABBIT.get(), Rabbit.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PREGNANT_SHEEP.get(), Sheep.createAttributes().build());
		FabricDefaultAttributeRegistry.register(FossilsLegacyEntities.PREGNANT_WOLF.get(), Wolf.createAttributes().build());
	}

	public static void entitySpawns() {
		SpawnPlacements.register(FossilsLegacyEntities.ANU.get(), Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Anu::checkAnuSpawnRules);
	}

	public static void creativeModTabModification() {
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(content -> {
//			content.accept(FossilsLegacyItems.DROWNED_PIRATE_SPAWN_EGG.get());
//			content.accept(FossilsLegacyItems.ZOMBIFIED_PIGMAN_SPAWN_EGG.get());
//			content.accept(FossilsLegacyItems.FAILURESAURUS_SPAWN_EGG.get());
//			content.accept(FossilsLegacyItems.MAMMOTH_SPAWN_EGG.get());
//			content.accept(FossilsLegacyItems.SMILODON_SPAWN_EGG.get());
//			content.accept(FossilsLegacyItems.TRICERATOPS_SPAWN_EGG.get());
		});
	}

	public static void addToBiomes() {
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FossilsLegacyPlacedFeatures.ORE_FOSSIL);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Decoration.UNDERGROUND_ORES, FossilsLegacyPlacedFeatures.ORE_PERMAFROST);
	}
}
