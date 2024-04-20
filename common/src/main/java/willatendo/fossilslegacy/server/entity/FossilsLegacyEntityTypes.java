package willatendo.fossilslegacy.server.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.server.entity.pregnant.*;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;

public class FossilsLegacyEntityTypes {
    public static final SimpleRegistry<EntityType<?>> ENTITY_TYPES = SimpleRegistry.create(Registries.ENTITY_TYPE, FossilsLegacyUtils.ID);

    public static final SimpleHolder<EntityType<AncientLightningBolt>> ANCIENT_LIGHTNING_BOLT = ENTITY_TYPES.register("ancient_lightning_bolt", () -> EntityType.Builder.<AncientLightningBolt>of(AncientLightningBolt::new, MobCategory.MISC).noSave().sized(0.0F, 0.0F).build("ancient_lightning_bolt"));

    public static final SimpleHolder<EntityType<Brachiosaurus>> BRACHIOSAURUS = ENTITY_TYPES.register("brachiosaurus", () -> EntityType.Builder.<Brachiosaurus>of(Brachiosaurus::new, MobCategory.CREATURE).sized(1.0F, 1.5F).build("brachiosaurus"));
    public static final SimpleHolder<EntityType<Dilophosaurus>> DILOPHOSAURUS = ENTITY_TYPES.register("dilophosaurus", () -> EntityType.Builder.<Dilophosaurus>of(Dilophosaurus::new, MobCategory.CREATURE).sized(0.5F, 0.5F).build("dilophosaurus"));
    public static final SimpleHolder<EntityType<Mammoth>> MAMMOTH = ENTITY_TYPES.register("mammoth", () -> EntityType.Builder.<Mammoth>of(Mammoth::new, MobCategory.CREATURE).sized(1.0F, 1.0F).build("mammoth"));
    public static final SimpleHolder<EntityType<Mosasaurus>> MOSASAURUS = ENTITY_TYPES.register("mosasaurus", () -> EntityType.Builder.<Mosasaurus>of(Mosasaurus::new, MobCategory.WATER_CREATURE).sized(0.5F, 0.5F).build("mosasaurus"));
    public static final SimpleHolder<EntityType<Nautilus>> NAUTILUS = ENTITY_TYPES.register("nautilus", () -> EntityType.Builder.<Nautilus>of(Nautilus::new, MobCategory.WATER_AMBIENT).sized(1.0F, 0.75F).build("nautilus"));
    public static final SimpleHolder<EntityType<Futabasaurus>> FUTABASAURUS = ENTITY_TYPES.register("futabasaurus", () -> EntityType.Builder.<Futabasaurus>of(Futabasaurus::new, MobCategory.WATER_CREATURE).sized(1.0F, 0.65F).build("futabasaurus"));
    public static final SimpleHolder<EntityType<Pteranodon>> PTERANODON = ENTITY_TYPES.register("pteranodon", () -> EntityType.Builder.<Pteranodon>of(Pteranodon::new, MobCategory.CREATURE).sized(0.5F, 0.5F).build("pteranodon"));
    public static final SimpleHolder<EntityType<Smilodon>> SMILODON = ENTITY_TYPES.register("smilodon", () -> EntityType.Builder.<Smilodon>of(Smilodon::new, MobCategory.CREATURE).sized(1.5F, 1.5F).build("smilodon"));
    public static final SimpleHolder<EntityType<Stegosaurus>> STEGOSAURUS = ENTITY_TYPES.register("stegosaurus", () -> EntityType.Builder.<Stegosaurus>of(Stegosaurus::new, MobCategory.CREATURE).sized(0.5F, 0.5F).build("stegosaurus"));
    public static final SimpleHolder<EntityType<Triceratops>> TRICERATOPS = ENTITY_TYPES.register("triceratops", () -> EntityType.Builder.<Triceratops>of(Triceratops::new, MobCategory.CREATURE).sized(0.5F, 0.5F).build("triceratops"));
    public static final SimpleHolder<EntityType<Tyrannosaurus>> TYRANNOSAURUS = ENTITY_TYPES.register("tyrannosaurus", () -> EntityType.Builder.<Tyrannosaurus>of(Tyrannosaurus::new, MobCategory.CREATURE).sized(0.5F, 0.75F).build("tyrannosaurus"));
    public static final SimpleHolder<EntityType<Velociraptor>> VELOCIRAPTOR = ENTITY_TYPES.register("velociraptor", () -> EntityType.Builder.<Velociraptor>of(Velociraptor::new, MobCategory.CREATURE).sized(0.25F, 0.5F).build("velociraptor"));

    public static final SimpleHolder<EntityType<Fossil>> FOSSIL = ENTITY_TYPES.register("fossil", () -> EntityType.Builder.<Fossil>of(Fossil::new, MobCategory.MISC).sized(0.5F, 0.5F).build("fossil"));

    public static final SimpleHolder<EntityType<Egg>> EGG = ENTITY_TYPES.register("egg", () -> EntityType.Builder.<Egg>of(Egg::new, MobCategory.CREATURE).sized(0.5F, 0.5F).build("egg"));

    public static final SimpleHolder<EntityType<PregnantCat>> PREGNANT_CAT = ENTITY_TYPES.register("pregnant_cat", () -> EntityType.Builder.<PregnantCat>of(PregnantCat::new, MobCategory.CREATURE).sized(0.6F, 0.7F).build("pregnant_cat"));
    public static final SimpleHolder<EntityType<PregnantCow>> PREGNANT_COW = ENTITY_TYPES.register("pregnant_cow", () -> EntityType.Builder.<PregnantCow>of(PregnantCow::new, MobCategory.CREATURE).sized(0.9F, 1.4F).build("pregnant_cow"));
    public static final SimpleHolder<EntityType<PregnantDolphin>> PREGNANT_DOLPHIN = ENTITY_TYPES.register("pregnant_dolphin", () -> EntityType.Builder.<PregnantDolphin>of(PregnantDolphin::new, MobCategory.WATER_CREATURE).sized(0.9F, 0.6F).build("pregnant_dolphin"));
    public static final SimpleHolder<EntityType<PregnantDonkey>> PREGNANT_DONKEY = ENTITY_TYPES.register("pregnant_donkey", () -> EntityType.Builder.<PregnantDonkey>of(PregnantDonkey::new, MobCategory.CREATURE).sized(1.3964844F, 1.5F).build("pregnant_donkey"));
    public static final SimpleHolder<EntityType<PregnantFox>> PREGNANT_FOX = ENTITY_TYPES.register("pregnant_fox", () -> EntityType.Builder.<PregnantFox>of(PregnantFox::new, MobCategory.CREATURE).sized(0.6F, 0.7F).build("pregnant_fox"));
    public static final SimpleHolder<EntityType<PregnantGoat>> PREGNANT_GOAT = ENTITY_TYPES.register("pregnant_goat", () -> EntityType.Builder.<PregnantGoat>of(PregnantGoat::new, MobCategory.CREATURE).sized(0.9F, 1.3F).build("pregnant_goat"));
    public static final SimpleHolder<EntityType<PregnantHorse>> PREGNANT_HORSE = ENTITY_TYPES.register("pregnant_horse", () -> EntityType.Builder.<PregnantHorse>of(PregnantHorse::new, MobCategory.CREATURE).sized(1.3964844F, 1.6F).build("pregnant_horse"));
    public static final SimpleHolder<EntityType<PregnantLlama>> PREGNANT_LLAMA = ENTITY_TYPES.register("pregnant_llama", () -> EntityType.Builder.<PregnantLlama>of(PregnantLlama::new, MobCategory.CREATURE).sized(0.9F, 1.87F).build("pregnant_llama"));
    public static final SimpleHolder<EntityType<PregnantMammoth>> PREGNANT_MAMMOTH = ENTITY_TYPES.register("pregnant_mammoth", () -> EntityType.Builder.<PregnantMammoth>of(PregnantMammoth::new, MobCategory.CREATURE).sized(2.5F, 2.5F).build("pregnant_mammoth"));
    public static final SimpleHolder<EntityType<PregnantMule>> PREGNANT_MULE = ENTITY_TYPES.register("pregnant_mule", () -> EntityType.Builder.<PregnantMule>of(PregnantMule::new, MobCategory.CREATURE).sized(1.3964844F, 1.6F).build("pregnant_mule"));
    public static final SimpleHolder<EntityType<PregnantOcelot>> PREGNANT_OCELOT = ENTITY_TYPES.register("pregnant_ocelot", () -> EntityType.Builder.<PregnantOcelot>of(PregnantOcelot::new, MobCategory.CREATURE).sized(0.6F, 0.7F).build("pregnant_ocelot"));
    public static final SimpleHolder<EntityType<PregnantPanda>> PREGNANT_PANDA = ENTITY_TYPES.register("pregnant_panada", () -> EntityType.Builder.<PregnantPanda>of(PregnantPanda::new, MobCategory.CREATURE).sized(1.3F, 1.25F).build("pregnant_panada"));
    public static final SimpleHolder<EntityType<PregnantPig>> PREGNANT_PIG = ENTITY_TYPES.register("pregnant_pig", () -> EntityType.Builder.<PregnantPig>of(PregnantPig::new, MobCategory.CREATURE).sized(0.9F, 0.9F).build("pregnant_pig"));
    public static final SimpleHolder<EntityType<PregnantPolarBear>> PREGNANT_POLAR_BEAR = ENTITY_TYPES.register("pregnant_polar_bear", () -> EntityType.Builder.<PregnantPolarBear>of(PregnantPolarBear::new, MobCategory.CREATURE).immuneTo(Blocks.POWDER_SNOW).sized(1.4F, 1.4F).build("pregnant_polar_bear"));
    public static final SimpleHolder<EntityType<PregnantRabbit>> PREGNANT_RABBIT = ENTITY_TYPES.register("pregnant_rabbit", () -> EntityType.Builder.<PregnantRabbit>of(PregnantRabbit::new, MobCategory.CREATURE).sized(0.4F, 0.5F).build("pregnant_rabbit"));
    public static final SimpleHolder<EntityType<PregnantSheep>> PREGNANT_SHEEP = ENTITY_TYPES.register("pregnant_sheep", () -> EntityType.Builder.<PregnantSheep>of(PregnantSheep::new, MobCategory.CREATURE).sized(0.9F, 1.3F).build("pregnant_sheep"));
    public static final SimpleHolder<EntityType<PregnantSmilodon>> PREGNANT_SMILODON = ENTITY_TYPES.register("pregnant_smilodon", () -> EntityType.Builder.<PregnantSmilodon>of(PregnantSmilodon::new, MobCategory.CREATURE).sized(2.5F, 2.5F).build("pregnant_smilodon"));
    public static final SimpleHolder<EntityType<PregnantWolf>> PREGNANT_WOLF = ENTITY_TYPES.register("pregnant_wolf", () -> EntityType.Builder.<PregnantWolf>of(PregnantWolf::new, MobCategory.CREATURE).sized(0.6F, 0.85F).build("pregnant_wolf"));

    public static final SimpleHolder<EntityType<Anu>> ANU = ENTITY_TYPES.register("anu", () -> EntityType.Builder.<Anu>of(Anu::new, MobCategory.MONSTER).fireImmune().sized(0.6F, 1.95F).build("anu"));
    public static final SimpleHolder<EntityType<TamedZombifiedPiglin>> TAMED_ZOMBIFIED_PIGLIN = ENTITY_TYPES.register("tamed_zombified_piglin", () -> EntityType.Builder.<TamedZombifiedPiglin>of(TamedZombifiedPiglin::new, MobCategory.MONSTER).sized(.6F, 1.95F).build("tamed_zombified_piglin"));
    public static final SimpleHolder<EntityType<Failuresaurus>> FAILURESAURUS = ENTITY_TYPES.register("failuresaurus", () -> EntityType.Builder.<Failuresaurus>of(Failuresaurus::new, MobCategory.MONSTER).sized(1.0F, 1.0F).build("failuresaurus"));

    public static final SimpleHolder<EntityType<ThrownJavelin>> THROWN_JAVELIN = ENTITY_TYPES.register("thrown_javelin", () -> EntityType.Builder.<ThrownJavelin>of(ThrownJavelin::new, MobCategory.MISC).sized(0.5F, 0.5F).build("thrown_javelin"));
    public static final SimpleHolder<EntityType<ThrownIncubatedEgg>> THROWN_INCUBATED_EGG = ENTITY_TYPES.register("thrown_incubated_egg", () -> EntityType.Builder.<ThrownIncubatedEgg>of(ThrownIncubatedEgg::new, MobCategory.MISC).sized(0.25F, 0.25F).build("thrown_incubated_egg"));
    public static final SimpleHolder<EntityType<DilophosaurusVenom>> DILOPHOSAURUS_VENOM = ENTITY_TYPES.register("dilophosaurus_venom", () -> EntityType.Builder.<DilophosaurusVenom>of(DilophosaurusVenom::new, MobCategory.MISC).sized(0.5F, 0.5F).build("dilophosaurus_venom"));

    public static final SimpleHolder<EntityType<StoneTablet>> STONE_TABLET = ENTITY_TYPES.register("stone_tablet", () -> EntityType.Builder.<StoneTablet>of(StoneTablet::new, MobCategory.MISC).sized(0.5F, 0.5F).build("stone_tablet"));

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(ENTITY_TYPES);
    }
}
