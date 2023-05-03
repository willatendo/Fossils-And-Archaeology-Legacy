package fossilslegacy.server.event;

import fossilslegacy.server.block.FossilsLegacyBlocks;
import fossilslegacy.server.entity.StoneHieroglyphTypes;
import fossilslegacy.server.entity.DrownedPirate;
import fossilslegacy.server.entity.Egg;
import fossilslegacy.server.entity.FossilsLegacyEntities;
import fossilslegacy.server.entity.Mammoth;
import fossilslegacy.server.entity.Smilodon;
import fossilslegacy.server.entity.Triceratops;
import fossilslegacy.server.item.FossilsLegacyItems;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.MOD, modid = FossilsLegacyUtils.ID)
public class ModServerEvents {
	@SubscribeEvent
	public static void entityAttributes(EntityAttributeCreationEvent event) {
		event.put(FossilsLegacyEntities.MAMMOTH.get(), Mammoth.mammothAttributes());
		event.put(FossilsLegacyEntities.SMILODON.get(), Smilodon.smilodonAttributes());
		event.put(FossilsLegacyEntities.TRICERATOPS.get(), Triceratops.triceratopsAttributes());

		event.put(FossilsLegacyEntities.DROWNED_PIRATE.get(), DrownedPirate.createAttributes().build());

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

//	@SubscribeEvent
//	public static void commonSetup(FMLCommonSetupEvent event) {
//		VibrationListener.VIBRATION_FREQUENCY_FOR_EVENT.put(FossilLegacyGameEvents.CULTIVATOR_SHATTER.get(), 15);
//	

	@SubscribeEvent
	public static void creativeModTabModification(CreativeModeTabEvent.BuildContents event) {
		if (event.getTab() == CreativeModeTabs.SPAWN_EGGS) {
			event.accept(FossilsLegacyItems.MAMMOTH_SPAWN_EGG.get());
			event.accept(FossilsLegacyItems.SMILODON_SPAWN_EGG.get());
			event.accept(FossilsLegacyItems.TRICERATOPS_SPAWN_EGG.get());
		}
	}

	@SubscribeEvent
	public static void creativeModTabRegistry(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(FossilsLegacyUtils.resource(FossilsLegacyUtils.ID), builder -> builder.title(FossilsLegacyUtils.translation("itemGroup", FossilsLegacyUtils.ID)).icon(() -> FossilsLegacyItems.FOSSIL.get().getDefaultInstance()).displayItems((itemDisplayParameters, output) -> {
			output.accept(FossilsLegacyItems.FOSSIL.get());
			output.accept(FossilsLegacyItems.TRICERATOPS_DNA.get());
			output.accept(FossilsLegacyItems.UTAHRAPTOR_DNA.get());
			output.accept(FossilsLegacyItems.TYRANNOSAURUS_DNA.get());
			output.accept(FossilsLegacyItems.PTEROSAURUS_DNA.get());
			output.accept(FossilsLegacyItems.NAUTILUS_DNA.get());
			output.accept(FossilsLegacyItems.PLESIOSAURUS_DNA.get());
			output.accept(FossilsLegacyItems.MOSASAURUS_DNA.get());
			output.accept(FossilsLegacyItems.STEGOSAURUS_DNA.get());
			output.accept(FossilsLegacyItems.DILOPHOSAURUS_DNA.get());
			output.accept(FossilsLegacyItems.BRACHIOSAURUS_DNA.get());
			output.accept(FossilsLegacyItems.TRICERATOPS_EGG.get());
			output.accept(FossilsLegacyItems.UTAHRAPTOR_EGG.get());
			output.accept(FossilsLegacyItems.TYRANNOSAURUS_EGG.get());
			output.accept(FossilsLegacyItems.PTEROSAURUS_EGG.get());
			output.accept(FossilsLegacyItems.NAUTILUS_EGGS.get());
			output.accept(FossilsLegacyItems.PLESIOSAURUS_EGG.get());
			output.accept(FossilsLegacyItems.MOSASAURUS_EGG.get());
			output.accept(FossilsLegacyItems.STEGOSAURUS_EGG.get());
			output.accept(FossilsLegacyItems.DILOPHOSAURUS_EGG.get());
			output.accept(FossilsLegacyItems.BRACHIOSAURUS_EGG.get());
			output.accept(FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get());
			output.accept(FossilsLegacyItems.RAW_UTAHRAPTOR_MEAT.get());
			output.accept(FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get());
			output.accept(FossilsLegacyItems.RAW_PTEROSAURUS_MEAT.get());
			output.accept(FossilsLegacyItems.NAUTILUS.get());
			output.accept(FossilsLegacyItems.RAW_PLESIOSAURUS_MEAT.get());
			output.accept(FossilsLegacyItems.RAW_MOSASAURUS_MEAT.get());
			output.accept(FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get());
			output.accept(FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get());
			output.accept(FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get());
			output.accept(FossilsLegacyItems.RAW_SMILODON_MEAT.get());
			output.accept(FossilsLegacyItems.RAW_MAMMOTH_MEAT.get());
			output.accept(FossilsLegacyItems.COOKED_TRICERATOPS_MEAT.get());
			output.accept(FossilsLegacyItems.COOKED_UTAHRAPTOR_MEAT.get());
			output.accept(FossilsLegacyItems.COOKED_TYRANNOSAURUS_MEAT.get());
			output.accept(FossilsLegacyItems.COOKED_PTEROSAURUS_MEAT.get());
			output.accept(FossilsLegacyItems.SIO_CHIU_LE.get());
			output.accept(FossilsLegacyItems.COOKED_PLESIOSAURUS_MEAT.get());
			output.accept(FossilsLegacyItems.COOKED_MOSASAURUS_MEAT.get());
			output.accept(FossilsLegacyItems.COOKED_STEGOSAURUS_MEAT.get());
			output.accept(FossilsLegacyItems.COOKED_DILOPHOSAURUS_MEAT.get());
			output.accept(FossilsLegacyItems.COOKED_BRACHIOSAURUS_MEAT.get());
			output.accept(FossilsLegacyItems.COOKED_SMILODON_MEAT.get());
			output.accept(FossilsLegacyItems.COOKED_MAMMOTH_MEAT.get());
			output.accept(FossilsLegacyItems.TYRANNOSAURUS_TOOTH.get());
			output.accept(FossilsLegacyItems.TOOTH_DAGGER.get());
			output.accept(FossilsLegacyItems.SKULL_STICK.get());
			output.accept(FossilsLegacyItems.DINOSAUR_ENCYCLOPEDIA.get());
			output.accept(FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get());
			output.accept(FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get());
			output.accept(FossilsLegacyItems.CHICKEN_ESSENCE_BOTTLE.get());
			output.accept(FossilsLegacyItems.NAUTILUS_SHELL.get());
			output.accept(FossilsLegacyItems.SIO_CHIU_LE.get());
			for (int i = 0; i < 3; i++) {
				ItemStack magicConch = new ItemStack(FossilsLegacyItems.MAGIC_CONCH.get());
				CompoundTag compoundTag = magicConch.getOrCreateTag();
				compoundTag.putInt("Order", i);
				output.accept(magicConch);
			}
			output.accept(FossilsLegacyItems.FROZEN_MEAT.get());
			output.accept(FossilsLegacyItems.AXOLOTL_DNA.get());
			output.accept(FossilsLegacyItems.CAT_DNA.get());
			output.accept(FossilsLegacyItems.CHICKEN_DNA.get());
			output.accept(FossilsLegacyItems.COW_DNA.get());
			output.accept(FossilsLegacyItems.DOLPHIN_DNA.get());
			output.accept(FossilsLegacyItems.DONKEY_DNA.get());
			output.accept(FossilsLegacyItems.FOX_DNA.get());
			output.accept(FossilsLegacyItems.FROG_DNA.get());
			output.accept(FossilsLegacyItems.GOAT_DNA.get());
			output.accept(FossilsLegacyItems.HORSE_DNA.get());
			output.accept(FossilsLegacyItems.LLAMA_DNA.get());
			output.accept(FossilsLegacyItems.MULE_DNA.get());
			output.accept(FossilsLegacyItems.OCELOT_DNA.get());
			output.accept(FossilsLegacyItems.PANDA_DNA.get());
			output.accept(FossilsLegacyItems.PARROT_DNA.get());
			output.accept(FossilsLegacyItems.PIG_DNA.get());
			output.accept(FossilsLegacyItems.POLAR_BEAR_DNA.get());
			output.accept(FossilsLegacyItems.RABBIT_DNA.get());
			output.accept(FossilsLegacyItems.SHEEP_DNA.get());
			output.accept(FossilsLegacyItems.TURTLE_DNA.get());
			output.accept(FossilsLegacyItems.WOLF_DNA.get());
			output.accept(FossilsLegacyItems.SMILODON_DNA.get());
			output.accept(FossilsLegacyItems.MAMMOTH_DNA.get());
			output.accept(FossilsLegacyItems.AXOLOTL_EGGS.get());
			output.accept(FossilsLegacyItems.CAT_EMBRYO_SYRINGE.get());
			output.accept(FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get());
			output.accept(FossilsLegacyItems.COW_EMBRYO_SYRINGE.get());
			output.accept(FossilsLegacyItems.DOLPHIN_EMBRYO_SYRINGE.get());
			output.accept(FossilsLegacyItems.DONKEY_EMBRYO_SYRINGE.get());
			output.accept(FossilsLegacyItems.FOX_EMBRYO_SYRINGE.get());
			output.accept(FossilsLegacyItems.FROG_EGGS.get());
			output.accept(FossilsLegacyItems.GOAT_EMBRYO_SYRINGE.get());
			output.accept(FossilsLegacyItems.HORSE_EMBRYO_SYRINGE.get());
			output.accept(FossilsLegacyItems.LLAMA_EMBRYO_SYRINGE.get());
			output.accept(FossilsLegacyItems.MULE_EMBRYO_SYRINGE.get());
			output.accept(FossilsLegacyItems.OCELOT_EMBRYO_SYRINGE.get());
			output.accept(FossilsLegacyItems.PANDA_EMBRYO_SYRINGE.get());
			output.accept(FossilsLegacyItems.INCUBATED_PARROT_EGG.get());
			output.accept(FossilsLegacyItems.PIG_EMBRYO_SYRINGE.get());
			output.accept(FossilsLegacyItems.POLAR_BEAR_EMBRYO_SYRINGE.get());
			output.accept(FossilsLegacyItems.RABBIT_EMBRYO_SYRINGE.get());
			output.accept(FossilsLegacyItems.SHEEP_EMBRYO_SYRINGE.get());
			output.accept(FossilsLegacyItems.WOLF_EMBRYO_SYRINGE.get());
			output.accept(FossilsLegacyItems.SMILODON_EMBRYO_SYRINGE.get());
			output.accept(FossilsLegacyItems.MAMMOTH_EMBRYO_SYRINGE.get());
			output.accept(FossilsLegacyItems.JURASSIC_FERN_SPORES.get());
			output.accept(FossilsLegacyItems.RELIC_SCRAP.get());
			output.accept(FossilsLegacyItems.STONE_HIEROGLYPH.get());
			for (int i = 0; i < StoneHieroglyphTypes.values().length; i++) {
				ItemStack itemStack = new ItemStack(FossilsLegacyItems.STONE_HIEROGLYPH.get());
				CompoundTag compoundTag = itemStack.getOrCreateTagElement("EntityTag");
				compoundTag.putInt("Type", i);
				output.accept(itemStack);
			}
			output.accept(FossilsLegacyItems.SWORD_ARTIFACT.get());
			output.accept(FossilsLegacyItems.HELMET_ARTIFACT.get());
			output.accept(FossilsLegacyItems.GEM_ARTIFACT.get());
			output.accept(FossilsLegacyItems.ANCIENT_SWORD.get());
			output.accept(FossilsLegacyItems.ANCIENT_HELMET.get());
			output.accept(FossilsLegacyItems.GEM_SWORD.get());
			output.accept(FossilsLegacyItems.GEM_SHOVEL.get());
			output.accept(FossilsLegacyItems.GEM_PICKAXE.get());
			output.accept(FossilsLegacyItems.GEM_AXE.get());
			output.accept(FossilsLegacyItems.GEM_HOE.get());
			output.accept(FossilsLegacyItems.WOODEN_JAVELIN.get());
			output.accept(FossilsLegacyItems.STONE_JAVELIN.get());
			output.accept(FossilsLegacyItems.IRON_JAVELIN.get());
			output.accept(FossilsLegacyItems.GOLDEN_JAVELIN.get());
			output.accept(FossilsLegacyItems.DIAMOND_JAVELIN.get());
			output.accept(FossilsLegacyItems.NETHERITE_JAVELIN.get());
			output.accept(FossilsLegacyItems.GEM_JAVELIN.get());
			output.accept(FossilsLegacyBlocks.FOSSIL_ORE.get());
			output.accept(FossilsLegacyBlocks.SKULL_BLOCK.get());
			output.accept(FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get());
			output.accept(FossilsLegacyBlocks.ANALYZER.get());
			output.accept(FossilsLegacyBlocks.CULTIVATOR.get());
			output.accept(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get());
			output.accept(FossilsLegacyBlocks.DRUM.get());
			output.accept(FossilsLegacyBlocks.FEEDER.get());
			output.accept(FossilsLegacyBlocks.PERMAFROST.get());
			output.accept(FossilsLegacyBlocks.ICED_STONE.get());
			output.accept(FossilsLegacyItems.MAMMOTH_SPAWN_EGG.get());
			output.accept(FossilsLegacyItems.SMILODON_SPAWN_EGG.get());
			output.accept(FossilsLegacyItems.TRICERATOPS_SPAWN_EGG.get());
		}));
	}
}
