package willatendo.fossilslegacy.server.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantCat;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantCow;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantDolphin;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantDonkey;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantFox;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantGoat;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantHorse;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantLlama;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantMammoth;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantMule;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantOcelot;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantPanda;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantPig;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantPolarBear;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantRabbit;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantSheep;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantSmilodon;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantWolf;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.FabricRegister;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyEntities {
	public static final SimpleRegistry<EntityType<?>> ENTITY_TYPES = SimpleRegistry.create(Registries.ENTITY_TYPE, FossilsLegacyUtils.ID);

	public static final SimpleHolder<EntityType<AncientLightningBolt>> ANCIENT_LIGHTNING_BOLT = ENTITY_TYPES.register("ancient_lightning_bolt", () -> FabricEntityTypeBuilder.<AncientLightningBolt>create(MobCategory.MISC, AncientLightningBolt::new).disableSaving().dimensions(EntityDimensions.fixed(0.0F, 0.0F)).build());

	public static final SimpleHolder<EntityType<Brachiosaurus>> BRACHIOSAURUS = ENTITY_TYPES.register("brachiosaurus", () -> FabricEntityTypeBuilder.<Brachiosaurus>create(MobCategory.CREATURE, Brachiosaurus::new).dimensions(EntityDimensions.scalable(1.0F, 1.5F)).build());
	public static final SimpleHolder<EntityType<Dilophosaurus>> DILOPHOSAURUS = ENTITY_TYPES.register("dilophosaurus", () -> FabricEntityTypeBuilder.<Dilophosaurus>create(MobCategory.CREATURE, Dilophosaurus::new).dimensions(EntityDimensions.scalable(0.5F, 0.5F)).build());
	public static final SimpleHolder<EntityType<Mammoth>> MAMMOTH = ENTITY_TYPES.register("mammoth", () -> FabricEntityTypeBuilder.<Mammoth>create(MobCategory.CREATURE, Mammoth::new).dimensions(EntityDimensions.scalable(1.0F, 1.0F)).build());
	public static final SimpleHolder<EntityType<Mosasaurus>> MOSASAURUS = ENTITY_TYPES.register("mosasaurus", () -> FabricEntityTypeBuilder.<Mosasaurus>create(MobCategory.WATER_CREATURE, Mosasaurus::new).dimensions(EntityDimensions.scalable(0.5F, 0.5F)).build());
	public static final SimpleHolder<EntityType<Nautilus>> NAUTILUS = ENTITY_TYPES.register("nautilus", () -> FabricEntityTypeBuilder.<Nautilus>create(MobCategory.WATER_AMBIENT, Nautilus::new).dimensions(EntityDimensions.scalable(1.0F, 0.75F)).build());
	public static final SimpleHolder<EntityType<Plesiosaurus>> PLESIOSAURUS = ENTITY_TYPES.register("plesiosaurus", () -> FabricEntityTypeBuilder.<Plesiosaurus>create(MobCategory.WATER_CREATURE, Plesiosaurus::new).dimensions(EntityDimensions.scalable(1.0F, 1.0F)).build());
	public static final SimpleHolder<EntityType<Pteranodon>> PTERANODON = ENTITY_TYPES.register("pteranodon", () -> FabricEntityTypeBuilder.<Pteranodon>create(MobCategory.CREATURE, Pteranodon::new).dimensions(EntityDimensions.scalable(0.5F, 0.5F)).build());
	public static final SimpleHolder<EntityType<Smilodon>> SMILODON = ENTITY_TYPES.register("smilodon", () -> FabricEntityTypeBuilder.<Smilodon>create(MobCategory.CREATURE, Smilodon::new).dimensions(EntityDimensions.scalable(1.5F, 1.5F)).build());
	public static final SimpleHolder<EntityType<Stegosaurus>> STEGOSAURUS = ENTITY_TYPES.register("stegosaurus", () -> FabricEntityTypeBuilder.<Stegosaurus>create(MobCategory.CREATURE, Stegosaurus::new).dimensions(EntityDimensions.scalable(0.5F, 0.5F)).build());
	public static final SimpleHolder<EntityType<Triceratops>> TRICERATOPS = ENTITY_TYPES.register("triceratops", () -> FabricEntityTypeBuilder.<Triceratops>create(MobCategory.CREATURE, Triceratops::new).dimensions(EntityDimensions.scalable(0.5F, 0.5F)).build());
	public static final SimpleHolder<EntityType<Tyrannosaurus>> TYRANNOSAURUS = ENTITY_TYPES.register("tyrannosaurus", () -> FabricEntityTypeBuilder.<Tyrannosaurus>create(MobCategory.CREATURE, Tyrannosaurus::new).dimensions(EntityDimensions.scalable(0.5F, 0.75F)).build());
	public static final SimpleHolder<EntityType<Velociraptor>> VELOCIRAPTOR = ENTITY_TYPES.register("velociraptor", () -> FabricEntityTypeBuilder.<Velociraptor>create(MobCategory.CREATURE, Velociraptor::new).dimensions(EntityDimensions.scalable(0.25F, 0.5F)).build());

	public static final SimpleHolder<EntityType<Fossil>> FOSSIL = ENTITY_TYPES.register("fossil", () -> FabricEntityTypeBuilder.<Fossil>create(MobCategory.MISC, Fossil::new).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build());

	public static final SimpleHolder<EntityType<Egg>> EGG = ENTITY_TYPES.register("egg", () -> FabricEntityTypeBuilder.<Egg>create(MobCategory.CREATURE, Egg::new).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build());

	public static final SimpleHolder<EntityType<PregnantCat>> PREGNANT_CAT = ENTITY_TYPES.register("pregnant_cat", () -> FabricEntityTypeBuilder.<PregnantCat>create(MobCategory.CREATURE, PregnantCat::new).dimensions(EntityDimensions.fixed(0.6F, 0.7F)).build());
	public static final SimpleHolder<EntityType<PregnantCow>> PREGNANT_COW = ENTITY_TYPES.register("pregnant_cow", () -> FabricEntityTypeBuilder.<PregnantCow>create(MobCategory.CREATURE, PregnantCow::new).dimensions(EntityDimensions.fixed(0.9F, 1.4F)).build());
	public static final SimpleHolder<EntityType<PregnantDolphin>> PREGNANT_DOLPHIN = ENTITY_TYPES.register("pregnant_dolphin", () -> FabricEntityTypeBuilder.<PregnantDolphin>create(MobCategory.WATER_CREATURE, PregnantDolphin::new).dimensions(EntityDimensions.fixed(0.9F, 0.6F)).build());
	public static final SimpleHolder<EntityType<PregnantDonkey>> PREGNANT_DONKEY = ENTITY_TYPES.register("pregnant_donkey", () -> FabricEntityTypeBuilder.<PregnantDonkey>create(MobCategory.CREATURE, PregnantDonkey::new).dimensions(EntityDimensions.fixed(1.3964844F, 1.5F)).build());
	public static final SimpleHolder<EntityType<PregnantFox>> PREGNANT_FOX = ENTITY_TYPES.register("pregnant_fox", () -> FabricEntityTypeBuilder.<PregnantFox>create(MobCategory.CREATURE, PregnantFox::new).dimensions(EntityDimensions.fixed(0.6F, 0.7F)).build());
	public static final SimpleHolder<EntityType<PregnantGoat>> PREGNANT_GOAT = ENTITY_TYPES.register("pregnant_goat", () -> FabricEntityTypeBuilder.<PregnantGoat>create(MobCategory.CREATURE, PregnantGoat::new).dimensions(EntityDimensions.fixed(0.9F, 1.3F)).build());
	public static final SimpleHolder<EntityType<PregnantHorse>> PREGNANT_HORSE = ENTITY_TYPES.register("pregnant_horse", () -> FabricEntityTypeBuilder.<PregnantHorse>create(MobCategory.CREATURE, PregnantHorse::new).dimensions(EntityDimensions.fixed(1.3964844F, 1.6F)).build());
	public static final SimpleHolder<EntityType<PregnantLlama>> PREGNANT_LLAMA = ENTITY_TYPES.register("pregnant_llama", () -> FabricEntityTypeBuilder.<PregnantLlama>create(MobCategory.CREATURE, PregnantLlama::new).dimensions(EntityDimensions.fixed(0.9F, 1.87F)).build());
	public static final SimpleHolder<EntityType<PregnantMammoth>> PREGNANT_MAMMOTH = ENTITY_TYPES.register("pregnant_mammoth", () -> FabricEntityTypeBuilder.<PregnantMammoth>create(MobCategory.CREATURE, PregnantMammoth::new).dimensions(EntityDimensions.fixed(2.5F, 2.5F)).build());
	public static final SimpleHolder<EntityType<PregnantMule>> PREGNANT_MULE = ENTITY_TYPES.register("pregnant_mule", () -> FabricEntityTypeBuilder.<PregnantMule>create(MobCategory.CREATURE, PregnantMule::new).dimensions(EntityDimensions.fixed(1.3964844F, 1.6F)).build());
	public static final SimpleHolder<EntityType<PregnantOcelot>> PREGNANT_OCELOT = ENTITY_TYPES.register("pregnant_ocelot", () -> FabricEntityTypeBuilder.<PregnantOcelot>create(MobCategory.CREATURE, PregnantOcelot::new).dimensions(EntityDimensions.fixed(0.6F, 0.7F)).build());
	public static final SimpleHolder<EntityType<PregnantPanda>> PREGNANT_PANDA = ENTITY_TYPES.register("pregnant_panada", () -> FabricEntityTypeBuilder.<PregnantPanda>create(MobCategory.CREATURE, PregnantPanda::new).dimensions(EntityDimensions.fixed(1.3F, 1.25F)).build());
	public static final SimpleHolder<EntityType<PregnantPig>> PREGNANT_PIG = ENTITY_TYPES.register("pregnant_pig", () -> FabricEntityTypeBuilder.<PregnantPig>create(MobCategory.CREATURE, PregnantPig::new).dimensions(EntityDimensions.fixed(0.9F, 0.9F)).build());
	public static final SimpleHolder<EntityType<PregnantPolarBear>> PREGNANT_POLAR_BEAR = ENTITY_TYPES.register("pregnant_polar_bear", () -> FabricEntityTypeBuilder.<PregnantPolarBear>create(MobCategory.CREATURE, PregnantPolarBear::new).specificSpawnBlocks(Blocks.POWDER_SNOW).dimensions(EntityDimensions.fixed(1.4F, 1.4F)).build());
	public static final SimpleHolder<EntityType<PregnantRabbit>> PREGNANT_RABBIT = ENTITY_TYPES.register("pregnant_rabbit", () -> FabricEntityTypeBuilder.<PregnantRabbit>create(MobCategory.CREATURE, PregnantRabbit::new).dimensions(EntityDimensions.fixed(0.4F, 0.5F)).build());
	public static final SimpleHolder<EntityType<PregnantSheep>> PREGNANT_SHEEP = ENTITY_TYPES.register("pregnant_sheep", () -> FabricEntityTypeBuilder.<PregnantSheep>create(MobCategory.CREATURE, PregnantSheep::new).dimensions(EntityDimensions.fixed(0.9F, 1.3F)).build());
	public static final SimpleHolder<EntityType<PregnantSmilodon>> PREGNANT_SMILODON = ENTITY_TYPES.register("pregnant_smilodon", () -> FabricEntityTypeBuilder.<PregnantSmilodon>create(MobCategory.CREATURE, PregnantSmilodon::new).dimensions(EntityDimensions.fixed(2.5F, 2.5F)).build());
	public static final SimpleHolder<EntityType<PregnantWolf>> PREGNANT_WOLF = ENTITY_TYPES.register("pregnant_wolf", () -> FabricEntityTypeBuilder.<PregnantWolf>create(MobCategory.CREATURE, PregnantWolf::new).dimensions(EntityDimensions.fixed(0.6F, 0.85F)).build());

	public static final SimpleHolder<EntityType<Anu>> ANU = ENTITY_TYPES.register("anu", () -> FabricEntityTypeBuilder.<Anu>create(MobCategory.MONSTER, Anu::new).dimensions(EntityDimensions.fixed(0.6F, 1.95F)).build());
	public static final SimpleHolder<EntityType<TamedZombifiedPiglin>> TAMED_ZOMBIFIED_PIGLIN = ENTITY_TYPES.register("tamed_zombified_piglin", () -> FabricEntityTypeBuilder.<TamedZombifiedPiglin>create(MobCategory.MONSTER, TamedZombifiedPiglin::new).dimensions(EntityDimensions.fixed(.6F, 1.95F)).build());
	public static final SimpleHolder<EntityType<Failuresaurus>> FAILURESAURUS = ENTITY_TYPES.register("failuresaurus", () -> FabricEntityTypeBuilder.<Failuresaurus>create(MobCategory.MONSTER, Failuresaurus::new).dimensions(EntityDimensions.fixed(1.0F, 1.0F)).build());

	public static final SimpleHolder<EntityType<ThrownJavelin>> THROWN_JAVELIN = ENTITY_TYPES.register("thrown_javelin", () -> FabricEntityTypeBuilder.<ThrownJavelin>create(MobCategory.MISC, ThrownJavelin::new).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build());
	public static final SimpleHolder<EntityType<ThrownIncubatedEgg>> THROWN_INCUBATED_EGG = ENTITY_TYPES.register("thrown_incubated_egg", () -> FabricEntityTypeBuilder.<ThrownIncubatedEgg>create(MobCategory.MISC, ThrownIncubatedEgg::new).dimensions(EntityDimensions.fixed(0.25F, 0.25F)).build());
	public static final SimpleHolder<EntityType<DilophosaurusVenom>> DILOPHOSAURUS_VENOM = ENTITY_TYPES.register("dilophosaurus_venom", () -> FabricEntityTypeBuilder.<DilophosaurusVenom>create(MobCategory.MISC, DilophosaurusVenom::new).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build());

	public static final SimpleHolder<EntityType<StoneTablet>> STONE_TABLET = ENTITY_TYPES.register("stone_tablet", () -> FabricEntityTypeBuilder.<StoneTablet>create(MobCategory.MISC, StoneTablet::new).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build());

	public static void init() {
		FabricRegister.register(ENTITY_TYPES);
	}
}
