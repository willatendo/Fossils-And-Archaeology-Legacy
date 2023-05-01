package fossilslegacy.server.entity;

import fossilslegacy.server.entity.pregnant.PregnantCat;
import fossilslegacy.server.entity.pregnant.PregnantCow;
import fossilslegacy.server.entity.pregnant.PregnantDolphin;
import fossilslegacy.server.entity.pregnant.PregnantDonkey;
import fossilslegacy.server.entity.pregnant.PregnantFox;
import fossilslegacy.server.entity.pregnant.PregnantGoat;
import fossilslegacy.server.entity.pregnant.PregnantHorse;
import fossilslegacy.server.entity.pregnant.PregnantLlama;
import fossilslegacy.server.entity.pregnant.PregnantMammoth;
import fossilslegacy.server.entity.pregnant.PregnantMule;
import fossilslegacy.server.entity.pregnant.PregnantOcelot;
import fossilslegacy.server.entity.pregnant.PregnantPanda;
import fossilslegacy.server.entity.pregnant.PregnantPig;
import fossilslegacy.server.entity.pregnant.PregnantPolarBear;
import fossilslegacy.server.entity.pregnant.PregnantRabbit;
import fossilslegacy.server.entity.pregnant.PregnantSheep;
import fossilslegacy.server.entity.pregnant.PregnantSmilodon;
import fossilslegacy.server.entity.pregnant.PregnantWolf;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FossilsLegacyEntities {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FossilsLegacyUtils.ID);

	public static final RegistryObject<EntityType<Mammoth>> MAMMOTH = ENTITY_TYPES.register("mammoth", () -> EntityType.Builder.<Mammoth>of(Mammoth::new, MobCategory.CREATURE).sized(2.5F, 2.5F).build("mammoth"));
	public static final RegistryObject<EntityType<Smilodon>> SMILODON = ENTITY_TYPES.register("smilodon", () -> EntityType.Builder.<Smilodon>of(Smilodon::new, MobCategory.CREATURE).sized(2.5F, 2.5F).build("smilodon"));
	public static final RegistryObject<EntityType<Triceratops>> TRICERATOPS = ENTITY_TYPES.register("triceratops", () -> EntityType.Builder.<Triceratops>of(Triceratops::new, MobCategory.CREATURE).sized(0.5F, 0.5F).build("triceratops"));

	public static final RegistryObject<EntityType<Egg>> EGG = ENTITY_TYPES.register("egg", () -> EntityType.Builder.<Egg>of(Egg::new, MobCategory.CREATURE).sized(0.5F, 0.5F).build("egg"));

	public static final RegistryObject<EntityType<PregnantCat>> PREGNANT_CAT = ENTITY_TYPES.register("pregnant_cat", () -> EntityType.Builder.<PregnantCat>of(PregnantCat::new, MobCategory.CREATURE).sized(0.6F, 0.7F).build("pregnant_cat"));
	public static final RegistryObject<EntityType<PregnantCow>> PREGNANT_COW = ENTITY_TYPES.register("pregnant_cow", () -> EntityType.Builder.<PregnantCow>of(PregnantCow::new, MobCategory.CREATURE).sized(0.9F, 1.4F).build("pregnant_cow"));
	public static final RegistryObject<EntityType<PregnantDolphin>> PREGNANT_DOLPHIN = ENTITY_TYPES.register("pregnant_dolphin", () -> EntityType.Builder.<PregnantDolphin>of(PregnantDolphin::new, MobCategory.WATER_CREATURE).sized(0.9F, 0.6F).build("pregnant_dolphin"));
	public static final RegistryObject<EntityType<PregnantDonkey>> PREGNANT_DONKEY = ENTITY_TYPES.register("pregnant_donkey", () -> EntityType.Builder.<PregnantDonkey>of(PregnantDonkey::new, MobCategory.CREATURE).sized(1.3964844F, 1.5F).build("pregnant_donkey"));
	public static final RegistryObject<EntityType<PregnantFox>> PREGNANT_FOX = ENTITY_TYPES.register("pregnant_fox", () -> EntityType.Builder.<PregnantFox>of(PregnantFox::new, MobCategory.CREATURE).sized(0.6F, 0.7F).build("pregnant_fox"));
	public static final RegistryObject<EntityType<PregnantGoat>> PREGNANT_GOAT = ENTITY_TYPES.register("pregnant_goat", () -> EntityType.Builder.<PregnantGoat>of(PregnantGoat::new, MobCategory.CREATURE).sized(0.9F, 1.3F).build("pregnant_goat"));
	public static final RegistryObject<EntityType<PregnantHorse>> PREGNANT_HORSE = ENTITY_TYPES.register("pregnant_horse", () -> EntityType.Builder.<PregnantHorse>of(PregnantHorse::new, MobCategory.CREATURE).sized(1.3964844F, 1.6F).build("pregnant_horse"));
	public static final RegistryObject<EntityType<PregnantLlama>> PREGNANT_LLAMA = ENTITY_TYPES.register("pregnant_llama", () -> EntityType.Builder.<PregnantLlama>of(PregnantLlama::new, MobCategory.CREATURE).sized(0.9F, 1.87F).build("pregnant_llama"));
	public static final RegistryObject<EntityType<PregnantMammoth>> PREGNANT_MAMMOTH = ENTITY_TYPES.register("pregnant_mammoth", () -> EntityType.Builder.<PregnantMammoth>of(PregnantMammoth::new, MobCategory.CREATURE).sized(2.5F, 2.5F).build("pregnant_mammoth"));
	public static final RegistryObject<EntityType<PregnantMule>> PREGNANT_MULE = ENTITY_TYPES.register("pregnant_mule", () -> EntityType.Builder.<PregnantMule>of(PregnantMule::new, MobCategory.CREATURE).sized(1.3964844F, 1.6F).build("pregnant_mule"));
	public static final RegistryObject<EntityType<PregnantOcelot>> PREGNANT_OCELOT = ENTITY_TYPES.register("pregnant_ocelot", () -> EntityType.Builder.<PregnantOcelot>of(PregnantOcelot::new, MobCategory.CREATURE).sized(0.6F, 0.7F).build("pregnant_ocelot"));
	public static final RegistryObject<EntityType<PregnantPanda>> PREGNANT_PANDA = ENTITY_TYPES.register("pregnant_panada", () -> EntityType.Builder.<PregnantPanda>of(PregnantPanda::new, MobCategory.CREATURE).sized(1.3F, 1.25F).build("pregnant_panada"));
	public static final RegistryObject<EntityType<PregnantPig>> PREGNANT_PIG = ENTITY_TYPES.register("pregnant_pig", () -> EntityType.Builder.<PregnantPig>of(PregnantPig::new, MobCategory.CREATURE).sized(0.9F, 0.9F).build("pregnant_pig"));
	public static final RegistryObject<EntityType<PregnantPolarBear>> PREGNANT_POLAR_BEAR = ENTITY_TYPES.register("pregnant_polar_bear", () -> EntityType.Builder.<PregnantPolarBear>of(PregnantPolarBear::new, MobCategory.CREATURE).immuneTo(Blocks.POWDER_SNOW).sized(1.4F, 1.4F).build("pregnant_polar_bear"));
	public static final RegistryObject<EntityType<PregnantRabbit>> PREGNANT_RABBIT = ENTITY_TYPES.register("pregnant_rabbit", () -> EntityType.Builder.<PregnantRabbit>of(PregnantRabbit::new, MobCategory.CREATURE).sized(0.4F, 0.5F).build("pregnant_rabbit"));
	public static final RegistryObject<EntityType<PregnantSheep>> PREGNANT_SHEEP = ENTITY_TYPES.register("pregnant_sheep", () -> EntityType.Builder.<PregnantSheep>of(PregnantSheep::new, MobCategory.CREATURE).sized(0.9F, 1.3F).build("pregnant_sheep"));
	public static final RegistryObject<EntityType<PregnantSmilodon>> PREGNANT_SMILODON = ENTITY_TYPES.register("pregnant_smilodon", () -> EntityType.Builder.<PregnantSmilodon>of(PregnantSmilodon::new, MobCategory.CREATURE).sized(2.5F, 2.5F).build("pregnant_smilodon"));
	public static final RegistryObject<EntityType<PregnantWolf>> PREGNANT_WOLF = ENTITY_TYPES.register("pregnant_wolf", () -> EntityType.Builder.<PregnantWolf>of(PregnantWolf::new, MobCategory.CREATURE).sized(0.6F, 0.85F).build("pregnant_wolf"));

	public static final RegistryObject<EntityType<DrownedPirate>> DROWNED_PIRATE = ENTITY_TYPES.register("drowned_pirate", () -> EntityType.Builder.<DrownedPirate>of(DrownedPirate::new, MobCategory.CREATURE).sized(0.6F, 1.99F).build("drowned_pirate"));

	public static final RegistryObject<EntityType<ThrownJavelin>> THROWN_JAVELIN = ENTITY_TYPES.register("thrown_javelin", () -> EntityType.Builder.<ThrownJavelin>of(ThrownJavelin::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("thrown_javelin"));
	public static final RegistryObject<EntityType<CavePainting>> CAVE_PAINTING = ENTITY_TYPES.register("cave_painting", () -> EntityType.Builder.<CavePainting>of(CavePainting::new, MobCategory.MISC).sized(0.5F, 0.5F).build("cave_painting"));
}
