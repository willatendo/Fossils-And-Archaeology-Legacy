package willatendo.fossilslegacy.server.event;

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
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import willatendo.fossilslegacy.server.entity.Brachiosaurus;
import willatendo.fossilslegacy.server.entity.DrownedPirate;
import willatendo.fossilslegacy.server.entity.Egg;
import willatendo.fossilslegacy.server.entity.Failuresaurus;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;
import willatendo.fossilslegacy.server.entity.Mammoth;
import willatendo.fossilslegacy.server.entity.Nautilus;
import willatendo.fossilslegacy.server.entity.Pteranodon;
import willatendo.fossilslegacy.server.entity.Smilodon;
import willatendo.fossilslegacy.server.entity.Stegosaurus;
import willatendo.fossilslegacy.server.entity.Triceratops;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

@EventBusSubscriber(bus = Bus.MOD, modid = FossilsLegacyUtils.ID)
public class ModServerEvents {
	@SubscribeEvent
	public static void entityAttributes(EntityAttributeCreationEvent event) {
		event.put(FossilsLegacyEntities.BRACHIOSAURUS.get(), Brachiosaurus.brachiosaurusAttributes());
		event.put(FossilsLegacyEntities.MAMMOTH.get(), Mammoth.mammothAttributes());
		event.put(FossilsLegacyEntities.NAUTILUS.get(), Nautilus.nautilusAttributes());
		event.put(FossilsLegacyEntities.PTERANODON.get(), Pteranodon.triceratopsAttributes());
		event.put(FossilsLegacyEntities.SMILODON.get(), Smilodon.smilodonAttributes());
		event.put(FossilsLegacyEntities.STEGOSAURUS.get(), Stegosaurus.stegosaurusAttributes());
		event.put(FossilsLegacyEntities.TRICERATOPS.get(), Triceratops.triceratopsAttributes());

		event.put(FossilsLegacyEntities.ZOMBIFIED_PIGMAN.get(), ZombifiedPiglin.createAttributes().build());
		event.put(FossilsLegacyEntities.DROWNED_PIRATE.get(), DrownedPirate.createAttributes().build());
		event.put(FossilsLegacyEntities.FAILURESAURUS.get(), Failuresaurus.createAttributes().build());

		event.put(FossilsLegacyEntities.EGG.get(), Egg.eggAttributes());

		event.put(FossilsLegacyEntities.PREGNANT_CAT.get(), Cat.createAttributes().build());
		event.put(FossilsLegacyEntities.PREGNANT_COW.get(), Cow.createAttributes().build());
		event.put(FossilsLegacyEntities.PREGNANT_DOLPHIN.get(), Dolphin.createAttributes().build());
		event.put(FossilsLegacyEntities.PREGNANT_DONKEY.get(), Donkey.createBaseChestedHorseAttributes().build());
		event.put(FossilsLegacyEntities.PREGNANT_FOX.get(), Fox.createAttributes().build());
		event.put(FossilsLegacyEntities.PREGNANT_GOAT.get(), Goat.createAttributes().build());
		event.put(FossilsLegacyEntities.PREGNANT_HORSE.get(), Horse.createBaseHorseAttributes().build());
		event.put(FossilsLegacyEntities.PREGNANT_LLAMA.get(), Llama.createAttributes().build());
		event.put(FossilsLegacyEntities.PREGNANT_MAMMOTH.get(), Mammoth.mammothAttributes());
		event.put(FossilsLegacyEntities.PREGNANT_SMILODON.get(), Smilodon.smilodonAttributes());
		event.put(FossilsLegacyEntities.PREGNANT_MULE.get(), Mule.createBaseChestedHorseAttributes().build());
		event.put(FossilsLegacyEntities.PREGNANT_OCELOT.get(), Ocelot.createAttributes().build());
		event.put(FossilsLegacyEntities.PREGNANT_PANDA.get(), Panda.createAttributes().build());
		event.put(FossilsLegacyEntities.PREGNANT_PIG.get(), Pig.createAttributes().build());
		event.put(FossilsLegacyEntities.PREGNANT_POLAR_BEAR.get(), PolarBear.createAttributes().build());
		event.put(FossilsLegacyEntities.PREGNANT_RABBIT.get(), Rabbit.createAttributes().build());
		event.put(FossilsLegacyEntities.PREGNANT_SHEEP.get(), Sheep.createAttributes().build());
		event.put(FossilsLegacyEntities.PREGNANT_WOLF.get(), Wolf.createAttributes().build());
	}

	@SubscribeEvent
	public static void creativeModTabModification(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			event.accept(FossilsLegacyItems.DROWNED_PIRATE_SPAWN_EGG.get());
			event.accept(FossilsLegacyItems.ZOMBIFIED_PIGMAN_SPAWN_EGG.get());
			event.accept(FossilsLegacyItems.FAILURESAURUS_SPAWN_EGG.get());
			event.accept(FossilsLegacyItems.MAMMOTH_SPAWN_EGG.get());
			event.accept(FossilsLegacyItems.SMILODON_SPAWN_EGG.get());
			event.accept(FossilsLegacyItems.TRICERATOPS_SPAWN_EGG.get());
		}
	}
}
