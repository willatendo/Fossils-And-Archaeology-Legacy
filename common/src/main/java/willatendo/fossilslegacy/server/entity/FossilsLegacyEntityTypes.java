package willatendo.fossilslegacy.server.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.server.entity.pregnant.*;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.List;
import java.util.Optional;

public class FossilsLegacyEntityTypes {
    public static final SimpleRegistry<EntityType<?>> ENTITY_TYPES = SimpleRegistry.create(Registries.ENTITY_TYPE, FossilsLegacyUtils.ID);

    public static final SimpleHolder<EntityType<AncientLightningBolt>> ANCIENT_LIGHTNING_BOLT = ENTITY_TYPES.register("ancient_lightning_bolt", () -> SimpleUtils.entityTypeBuilder("ancient_lightning_bolt", AncientLightningBolt::new, MobCategory.MISC, true, false, Optional.empty(), 0.0F, 0.0F));

    public static final SimpleHolder<EntityType<Brachiosaurus>> BRACHIOSAURUS = ENTITY_TYPES.register("brachiosaurus", () -> SimpleUtils.entityTypeBuilder("brachiosaurus", Brachiosaurus::new, MobCategory.CREATURE, 1.0F, 1.5F));
    public static final SimpleHolder<EntityType<Dilophosaurus>> DILOPHOSAURUS = ENTITY_TYPES.register("dilophosaurus", () -> SimpleUtils.entityTypeBuilder("dilophosaurus", Dilophosaurus::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Mammoth>> MAMMOTH = ENTITY_TYPES.register("mammoth", () -> SimpleUtils.entityTypeBuilder("mammoth", Mammoth::new, MobCategory.CREATURE, 1.0F, 1.0F));
    public static final SimpleHolder<EntityType<Mosasaurus>> MOSASAURUS = ENTITY_TYPES.register("mosasaurus", () -> SimpleUtils.entityTypeBuilder("mosasaurus", Mosasaurus::new, MobCategory.WATER_CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Nautilus>> NAUTILUS = ENTITY_TYPES.register("nautilus", () -> SimpleUtils.entityTypeBuilder("nautilus", Nautilus::new, MobCategory.WATER_AMBIENT, 1.0F, 0.75F));
    public static final SimpleHolder<EntityType<Futabasaurus>> FUTABASAURUS = ENTITY_TYPES.register("futabasaurus", () -> SimpleUtils.entityTypeBuilder("futabasaurus", Futabasaurus::new, MobCategory.WATER_CREATURE, 1.0F, 0.65F));
    public static final SimpleHolder<EntityType<Pteranodon>> PTERANODON = ENTITY_TYPES.register("pteranodon", () -> SimpleUtils.entityTypeBuilder("pteranodon", Pteranodon::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Smilodon>> SMILODON = ENTITY_TYPES.register("smilodon", () -> SimpleUtils.entityTypeBuilder("smilodon", Smilodon::new, MobCategory.CREATURE, 1.5F, 1.5F));
    public static final SimpleHolder<EntityType<Stegosaurus>> STEGOSAURUS = ENTITY_TYPES.register("stegosaurus", () -> SimpleUtils.entityTypeBuilder("stegosaurus", Stegosaurus::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Triceratops>> TRICERATOPS = ENTITY_TYPES.register("triceratops", () -> SimpleUtils.entityTypeBuilder("triceratops", Triceratops::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Tyrannosaurus>> TYRANNOSAURUS = ENTITY_TYPES.register("tyrannosaurus", () -> SimpleUtils.entityTypeBuilder("tyrannosaurus", Tyrannosaurus::new, MobCategory.CREATURE, 0.5F, 0.75F));
    public static final SimpleHolder<EntityType<Velociraptor>> VELOCIRAPTOR = ENTITY_TYPES.register("velociraptor", () -> SimpleUtils.entityTypeBuilder("velociraptor", Velociraptor::new, MobCategory.CREATURE, 0.25F, 0.5F));
    public static final SimpleHolder<EntityType<Carnotaurus>> CARNOTAURUS = FossilsLegacyEntityTypes.ENTITY_TYPES.register("carnotaurus", () -> SimpleUtils.entityTypeBuilder("carnotaurus", Carnotaurus::new, MobCategory.CREATURE, 0.5F, 0.75F));
    public static final SimpleHolder<EntityType<Cryolophosaurus>> CRYOLOPHOSAURUS = FossilsLegacyEntityTypes.ENTITY_TYPES.register("cryolophosaurus", () -> SimpleUtils.entityTypeBuilder("cryolophosaurus", Cryolophosaurus::new, MobCategory.CREATURE, 0.5F, 0.75F));
    public static final SimpleHolder<EntityType<Therizinosaurus>> THERIZINOSAURUS = FossilsLegacyEntityTypes.ENTITY_TYPES.register("therizinosaurus", () -> SimpleUtils.entityTypeBuilder("therizinosaurus", Therizinosaurus::new, MobCategory.CREATURE, 0.5F, 0.75F));
    public static final SimpleHolder<EntityType<Pachycephalosaurus>> PACHYCEPHALOSAURUS = ENTITY_TYPES.register("pachycephalosaurus", () -> SimpleUtils.entityTypeBuilder("packycephalosaurus", Pachycephalosaurus::new, MobCategory.CREATURE, 1.0F, 1.0F));
    public static final SimpleHolder<EntityType<Compsognathus>> COMPSOGNATHUS = ENTITY_TYPES.register("compsognathus", () -> SimpleUtils.entityTypeBuilder("compsognathus", Compsognathus::new, MobCategory.CREATURE, 0.4F, 0.7F));
    public static final SimpleHolder<EntityType<Dodo>> DODO = ENTITY_TYPES.register("dodo", () -> SimpleUtils.entityTypeBuilder("dodo", Dodo::new, MobCategory.CREATURE, 0.75F, 0.75F));

    public static final SimpleHolder<EntityType<Fossil>> FOSSIL = ENTITY_TYPES.register("fossil", () -> SimpleUtils.entityTypeBuilder("fossil", Fossil::new, MobCategory.MISC, 0.5F, 0.5F));

    public static final SimpleHolder<EntityType<Egg>> EGG = ENTITY_TYPES.register("egg", () -> SimpleUtils.entityTypeBuilder("egg", Egg::new, MobCategory.CREATURE, 0.5F, 0.5F));

    public static final SimpleHolder<EntityType<PregnantArmadillo>> PREGNANT_ARMADILLO = ENTITY_TYPES.register("pregnant_armadillo", () -> SimpleUtils.entityTypeBuilder("pregnant_armadillo", PregnantArmadillo::new, MobCategory.CREATURE, 0.7F, 0.65F));
    public static final SimpleHolder<EntityType<PregnantCat>> PREGNANT_CAT = ENTITY_TYPES.register("pregnant_cat", () -> SimpleUtils.entityTypeBuilder("pregnant_cat", PregnantCat::new, MobCategory.CREATURE, 0.6F, 0.7F));
    public static final SimpleHolder<EntityType<PregnantCow>> PREGNANT_COW = ENTITY_TYPES.register("pregnant_cow", () -> SimpleUtils.entityTypeBuilder("pregnant_cow", PregnantCow::new, MobCategory.CREATURE, 0.9F, 1.4F));
    public static final SimpleHolder<EntityType<PregnantDolphin>> PREGNANT_DOLPHIN = ENTITY_TYPES.register("pregnant_dolphin", () -> SimpleUtils.entityTypeBuilder("pregnant_dolphin", PregnantDolphin::new, MobCategory.WATER_CREATURE, 0.9F, 0.6F));
    public static final SimpleHolder<EntityType<PregnantDonkey>> PREGNANT_DONKEY = ENTITY_TYPES.register("pregnant_donkey", () -> SimpleUtils.entityTypeBuilder("pregnant_donkey", PregnantDonkey::new, MobCategory.CREATURE, 1.3964844F, 1.5F));
    public static final SimpleHolder<EntityType<PregnantFox>> PREGNANT_FOX = ENTITY_TYPES.register("pregnant_fox", () -> SimpleUtils.entityTypeBuilder("pregnant_fox", PregnantFox::new, MobCategory.CREATURE, 0.6F, 0.7F));
    public static final SimpleHolder<EntityType<PregnantGoat>> PREGNANT_GOAT = ENTITY_TYPES.register("pregnant_goat", () -> SimpleUtils.entityTypeBuilder("pregnant_goat", PregnantGoat::new, MobCategory.CREATURE, 0.9F, 1.3F));
    public static final SimpleHolder<EntityType<PregnantHorse>> PREGNANT_HORSE = ENTITY_TYPES.register("pregnant_horse", () -> SimpleUtils.entityTypeBuilder("pregnant_horse", PregnantHorse::new, MobCategory.CREATURE, 1.3964844F, 1.6F));
    public static final SimpleHolder<EntityType<PregnantLlama>> PREGNANT_LLAMA = ENTITY_TYPES.register("pregnant_llama", () -> SimpleUtils.entityTypeBuilder("pregnant_llama", PregnantLlama::new, MobCategory.CREATURE, 0.9F, 1.87F));
    public static final SimpleHolder<EntityType<PregnantMammoth>> PREGNANT_MAMMOTH = ENTITY_TYPES.register("pregnant_mammoth", () -> SimpleUtils.entityTypeBuilder("pregnant_mammoth", PregnantMammoth::new, MobCategory.CREATURE, 2.5F, 2.5F));
    public static final SimpleHolder<EntityType<PregnantMule>> PREGNANT_MULE = ENTITY_TYPES.register("pregnant_mule", () -> SimpleUtils.entityTypeBuilder("pregnant_mule", PregnantMule::new, MobCategory.CREATURE, 1.3964844F, 1.6F));
    public static final SimpleHolder<EntityType<PregnantOcelot>> PREGNANT_OCELOT = ENTITY_TYPES.register("pregnant_ocelot", () -> SimpleUtils.entityTypeBuilder("pregnant_ocelot", PregnantOcelot::new, MobCategory.CREATURE, 0.6F, 0.7F));
    public static final SimpleHolder<EntityType<PregnantPanda>> PREGNANT_PANDA = ENTITY_TYPES.register("pregnant_panada", () -> SimpleUtils.entityTypeBuilder("pregnant_panada", PregnantPanda::new, MobCategory.CREATURE, 1.3F, 1.25F));
    public static final SimpleHolder<EntityType<PregnantPig>> PREGNANT_PIG = ENTITY_TYPES.register("pregnant_pig", () -> SimpleUtils.entityTypeBuilder("pregnant_pig", PregnantPig::new, MobCategory.CREATURE, 0.9F, 0.9F));
    public static final SimpleHolder<EntityType<PregnantPolarBear>> PREGNANT_POLAR_BEAR = ENTITY_TYPES.register("pregnant_polar_bear", () -> SimpleUtils.entityTypeBuilder("pregnant_polar_bear", PregnantPolarBear::new, MobCategory.CREATURE, false, false, Optional.of(Blocks.POWDER_SNOW), 1.4F, 1.4F));
    public static final SimpleHolder<EntityType<PregnantRabbit>> PREGNANT_RABBIT = ENTITY_TYPES.register("pregnant_rabbit", () -> SimpleUtils.entityTypeBuilder("pregnant_rabbit", PregnantRabbit::new, MobCategory.CREATURE, 0.4F, 0.5F));
    public static final SimpleHolder<EntityType<PregnantSheep>> PREGNANT_SHEEP = ENTITY_TYPES.register("pregnant_sheep", () -> SimpleUtils.entityTypeBuilder("pregnant_sheep", PregnantSheep::new, MobCategory.CREATURE, 0.9F, 1.3F));
    public static final SimpleHolder<EntityType<PregnantSmilodon>> PREGNANT_SMILODON = ENTITY_TYPES.register("pregnant_smilodon", () -> SimpleUtils.entityTypeBuilder("pregnant_smilodon", PregnantSmilodon::new, MobCategory.CREATURE, 2.5F, 2.5F));
    public static final SimpleHolder<EntityType<PregnantWolf>> PREGNANT_WOLF = ENTITY_TYPES.register("pregnant_wolf", () -> SimpleUtils.entityTypeBuilder("pregnant_wolf", PregnantWolf::new, MobCategory.CREATURE, 0.6F, 0.85F));

    public static final SimpleHolder<EntityType<Anu>> ANU = ENTITY_TYPES.register("anu", () -> SimpleUtils.entityTypeBuilder("anu", Anu::new, MobCategory.MONSTER, false, true, Optional.empty(), 0.6F, 1.95F));
    public static final SimpleHolder<EntityType<TamedZombifiedPiglin>> TAMED_ZOMBIFIED_PIGLIN = ENTITY_TYPES.register("tamed_zombified_piglin", () -> SimpleUtils.entityTypeBuilder("tamed_zombified_piglin", TamedZombifiedPiglin::new, MobCategory.MONSTER, 0.6F, 1.95F));
    public static final SimpleHolder<EntityType<Failuresaurus>> FAILURESAURUS = ENTITY_TYPES.register("failuresaurus", () -> SimpleUtils.entityTypeBuilder("failuresaurus", Failuresaurus::new, MobCategory.MONSTER, 1.0F, 1.0F));

    public static final SimpleHolder<EntityType<ThrownJavelin>> THROWN_JAVELIN = ENTITY_TYPES.register("thrown_javelin", () -> SimpleUtils.entityTypeBuilder("thrown_javelin", ThrownJavelin::new, MobCategory.MISC, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<ThrownAnimalEgg>> THROWN_INCUBATED_EGG = ENTITY_TYPES.register("thrown_incubated_egg", () -> SimpleUtils.entityTypeBuilder("thrown_incubated_egg", ThrownAnimalEgg::new, MobCategory.MISC, 0.25F, 0.25F));
    public static final SimpleHolder<EntityType<DilophosaurusVenom>> DILOPHOSAURUS_VENOM = ENTITY_TYPES.register("dilophosaurus_venom", () -> SimpleUtils.entityTypeBuilder("dilophosaurus_venom", DilophosaurusVenom::new, MobCategory.MISC, 0.5F, 0.5F));

    public static final SimpleHolder<EntityType<StoneTablet>> STONE_TABLET = ENTITY_TYPES.register("stone_tablet", () -> SimpleUtils.entityTypeBuilder("stone_tablet", StoneTablet::new, MobCategory.MISC, 0.5F, 0.5F));

    public static final SimpleHolder<EntityType<LepidodendronBoat>> LEPIDODENDRON_BOAT = ENTITY_TYPES.register("lepidodendron_boat", () -> SimpleUtils.entityTypeBuilder("lepidodendron_boat", LepidodendronBoat::new, MobCategory.MISC, 1.375F, 0.5625F));
    public static final SimpleHolder<EntityType<LepidodendronChestBoat>> LEPIDODENDRON_CHEST_BOAT = ENTITY_TYPES.register("lepidodendron_chest_boat", () -> SimpleUtils.entityTypeBuilder("lepidodendron_chest_boat", LepidodendronChestBoat::new, MobCategory.MISC, 1.375F, 0.5625F));

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(ENTITY_TYPES);
    }
}
