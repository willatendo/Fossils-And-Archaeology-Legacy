package willatendo.fossilslegacy.server.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.server.entity.entities.*;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.*;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.guadalupian.Dimetrodon;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.hybrid.DistortusRex;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.*;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.ordovician.Isotelus;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.ordovician.IsotelusLarva;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.*;
import willatendo.fossilslegacy.server.entity.entities.pregnant.*;
import willatendo.fossilslegacy.server.entity.entities.projectile.Dart;
import willatendo.fossilslegacy.server.entity.entities.projectile.ThrownJavelin;
import willatendo.fossilslegacy.server.entity.entities.vehicle.Jeep;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.EntityTypeRegistry;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public final class FAEntityTypes {
    public static final EntityTypeRegistry ENTITY_TYPES = SimpleRegistry.createEntityType(FAUtils.ID);
    public static final List<SimpleHolder<EntityType<Boat>>> BOATS = new ArrayList<>();

    public static final SimpleHolder<EntityType<AncientLightningBolt>> ANCIENT_LIGHTNING_BOLT = ENTITY_TYPES.register("ancient_lightning_bolt", FAEntityTypes.simple(AncientLightningBolt::new, MobCategory.MISC, 0.0F, 0.0F).noSave().noLootTable());

    public static final SimpleHolder<EntityType<Brachiosaurus>> BRACHIOSAURUS = ENTITY_TYPES.register("brachiosaurus", FAEntityTypes.simple(Brachiosaurus::new, MobCategory.CREATURE, 1.0F, 1.5F));
    public static final SimpleHolder<EntityType<Dilophosaurus>> DILOPHOSAURUS = ENTITY_TYPES.register("dilophosaurus", FAEntityTypes.simple(Dilophosaurus::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Dimetrodon>> DIMETRODON = ENTITY_TYPES.register("dimetrodon", FAEntityTypes.simple(Dimetrodon::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<DistortusRex>> DISTORTUS_REX = ENTITY_TYPES.register("distortus_rex", FAEntityTypes.simple(DistortusRex::new, MobCategory.CREATURE, 0.75F, 2.0F));
    public static final SimpleHolder<EntityType<Mammoth>> MAMMOTH = ENTITY_TYPES.register("mammoth", FAEntityTypes.simple(Mammoth::new, MobCategory.CREATURE, 1.0F, 1.0F));
    public static final SimpleHolder<EntityType<Mosasaurus>> MOSASAURUS = ENTITY_TYPES.register("mosasaurus", FAEntityTypes.simple(Mosasaurus::new, MobCategory.WATER_CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Nautilidae>> NAUTILUS = ENTITY_TYPES.register("nautilus", FAEntityTypes.simple(Nautilidae::nautilus, MobCategory.WATER_AMBIENT, 1.0F, 0.75F));
    public static final SimpleHolder<EntityType<Nautilidae>> CENOCERAS = ENTITY_TYPES.register("cenoceras", FAEntityTypes.simple(Nautilidae::cenoceras, MobCategory.WATER_AMBIENT, 1.0F, 0.75F));
    public static final SimpleHolder<EntityType<Futabasaurus>> FUTABASAURUS = ENTITY_TYPES.register("futabasaurus", FAEntityTypes.simple(Futabasaurus::new, MobCategory.WATER_CREATURE, 1.0F, 0.65F));
    public static final SimpleHolder<EntityType<Pteranodon>> PTERANODON = ENTITY_TYPES.register("pteranodon", FAEntityTypes.simple(Pteranodon::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Smilodon>> SMILODON = ENTITY_TYPES.register("smilodon", FAEntityTypes.simple(Smilodon::new, MobCategory.CREATURE, 1.5F, 1.5F));
    public static final SimpleHolder<EntityType<Stegosaurus>> STEGOSAURUS = ENTITY_TYPES.register("stegosaurus", FAEntityTypes.simple(Stegosaurus::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Triceratops>> TRICERATOPS = ENTITY_TYPES.register("triceratops", FAEntityTypes.simple(Triceratops::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Tyrannosaurus>> TYRANNOSAURUS = ENTITY_TYPES.register("tyrannosaurus", FAEntityTypes.simple(Tyrannosaurus::new, MobCategory.CREATURE, 0.5F, 0.75F));
    public static final SimpleHolder<EntityType<Velociraptor>> VELOCIRAPTOR = ENTITY_TYPES.register("velociraptor", FAEntityTypes.simple(Velociraptor::new, MobCategory.CREATURE, 0.5F, 0.65F));
    public static final SimpleHolder<EntityType<Carnotaurus>> CARNOTAURUS = ENTITY_TYPES.register("carnotaurus", FAEntityTypes.simple(Carnotaurus::new, MobCategory.CREATURE, 0.5F, 0.75F));
    public static final SimpleHolder<EntityType<Cryolophosaurus>> CRYOLOPHOSAURUS = ENTITY_TYPES.register("cryolophosaurus", FAEntityTypes.simple(Cryolophosaurus::new, MobCategory.CREATURE, 0.5F, 0.75F));
    public static final SimpleHolder<EntityType<Therizinosaurus>> THERIZINOSAURUS = ENTITY_TYPES.register("therizinosaurus", FAEntityTypes.simple(Therizinosaurus::new, MobCategory.CREATURE, 0.5F, 0.75F));
    public static final SimpleHolder<EntityType<Pachycephalosaurus>> PACHYCEPHALOSAURUS = ENTITY_TYPES.register("pachycephalosaurus", FAEntityTypes.simple(Pachycephalosaurus::new, MobCategory.CREATURE, 1.0F, 1.0F));
    public static final SimpleHolder<EntityType<Compsognathus>> COMPSOGNATHUS = ENTITY_TYPES.register("compsognathus", FAEntityTypes.simple(Compsognathus::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Dodo>> DODO = ENTITY_TYPES.register("dodo", FAEntityTypes.simple(Dodo::new, MobCategory.CREATURE, 0.75F, 0.75F));
    public static final SimpleHolder<EntityType<Moa>> MOA = ENTITY_TYPES.register("moa", FAEntityTypes.simple(Moa::new, MobCategory.CREATURE, 0.75F, 0.75F));
    public static final SimpleHolder<EntityType<Gallimimus>> GALLIMIMUS = ENTITY_TYPES.register("gallimimus", FAEntityTypes.simple(Gallimimus::new, MobCategory.CREATURE, 0.4F, 0.7F));
    public static final SimpleHolder<EntityType<Spinosaurus>> SPINOSAURUS = ENTITY_TYPES.register("spinosaurus", FAEntityTypes.simple(Spinosaurus::new, MobCategory.CREATURE, 0.4F, 0.7F));
    public static final SimpleHolder<EntityType<Ankylosaurus>> ANKYLOSAURUS = ENTITY_TYPES.register("ankylosaurus", FAEntityTypes.simple(Ankylosaurus::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Ichthyosaurus>> ICHTHYOSAURUS = ENTITY_TYPES.register("ichthyosaurus", FAEntityTypes.simple(Ichthyosaurus::new, MobCategory.WATER_CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Elasmotherium>> ELASMOTHERIUM = ENTITY_TYPES.register("elasmotherium", FAEntityTypes.simple(Elasmotherium::new, MobCategory.CREATURE, 1.0F, 1.0F));
    public static final SimpleHolder<EntityType<Dryosaurus>> DRYOSAURUS = ENTITY_TYPES.register("dryosaurus", FAEntityTypes.simple(Dryosaurus::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Baryonyx>> BARYONYX = ENTITY_TYPES.register("baryonyx", FAEntityTypes.simple(Baryonyx::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Isotelus>> ISOTELUS = ENTITY_TYPES.register("isotelus", FAEntityTypes.simple(Isotelus::new, MobCategory.WATER_AMBIENT, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<IsotelusLarva>> ISOTELUS_LARVA = ENTITY_TYPES.register("isotelus_larva", FAEntityTypes.simple(IsotelusLarva::new, MobCategory.WATER_AMBIENT, 0.15F, 0.15F));

    public static final SimpleHolder<EntityType<Fossil>> FOSSIL = ENTITY_TYPES.register("fossil", FAEntityTypes.simple(Fossil::new, MobCategory.MISC, 0.5F, 0.5F).noLootTable());

    public static final SimpleHolder<EntityType<Egg>> ANKYLOSAURUS_EGG = FAEntityTypes.registerLandEgg("ankylosaurus_egg", FAItems.ANKYLOSAURUS_EGG::get, FAEntityTypes.ANKYLOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> BARYONYX_EGG = FAEntityTypes.registerLandEgg("baryonyx_egg", FAItems.BRACHIOSAURUS_EGG::get, FAEntityTypes.BARYONYX);
    public static final SimpleHolder<EntityType<Egg>> BRACHIOSAURUS_EGG = FAEntityTypes.registerLandEgg("brachiosaurus_egg", FAItems.BRACHIOSAURUS_EGG::get, FAEntityTypes.BRACHIOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> CARNOTAURUS_EGG = FAEntityTypes.registerLandEgg("carnotaurus_egg", FAItems.CARNOTAURUS_EGG::get, FAEntityTypes.CARNOTAURUS);
    public static final SimpleHolder<EntityType<Egg>> COMPSOGNATHUS_EGG = FAEntityTypes.registerLandEgg("compsognathus_egg", FAItems.COMPSOGNATHUS_EGG::get, FAEntityTypes.COMPSOGNATHUS);
    public static final SimpleHolder<EntityType<Egg>> CRYOLOPHOSAURUS_EGG = FAEntityTypes.registerLandEgg("cryolophosaurus_egg", FAItems.CRYOLOPHOSAURUS_EGG::get, FAEntityTypes.CRYOLOPHOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> DILOPHOSAURUS_EGG = FAEntityTypes.registerLandEgg("dilophosaurus_egg", FAItems.DILOPHOSAURUS_EGG::get, FAEntityTypes.DILOPHOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> DIMETRODON_EGG = FAEntityTypes.registerLandEgg("dimetrodon_egg", FAItems.DIMETRODON_EGG::get, FAEntityTypes.DIMETRODON);
    public static final SimpleHolder<EntityType<Egg>> DRYOSAURUS_EGG = FAEntityTypes.registerLandEgg("dryosaurus_egg", FAItems.DRYOSAURUS_EGG::get, FAEntityTypes.DRYOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> FUTABASAURUS_EGG = FAEntityTypes.registerLandEgg("futabasaurus_egg", FAItems.FUTABASAURUS_EGG::get, FAEntityTypes.FUTABASAURUS);
    public static final SimpleHolder<EntityType<Egg>> GALLIMIMUS_EGG = FAEntityTypes.registerLandEgg("gallimimus_egg", FAItems.GALLIMIMUS_EGG::get, FAEntityTypes.GALLIMIMUS);
    public static final SimpleHolder<EntityType<Egg>> ICHTHYOSAURUS_EGG = FAEntityTypes.registerWaterEgg("ichthyosaurus_egg", FAItems.ICHTHYOSAURUS_EGG::get, FAEntityTypes.ICHTHYOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> MOSASAURUS_EGG = FAEntityTypes.registerWaterEgg("mosasaurus_egg", FAItems.MOSASAURUS_EGG::get, FAEntityTypes.MOSASAURUS);
    public static final SimpleHolder<EntityType<Egg>> PACHYCEPHALOSAURUS_EGG = FAEntityTypes.registerLandEgg("pachycephalosaurus_egg", FAItems.PACHYCEPHALOSAURUS_EGG::get, FAEntityTypes.PACHYCEPHALOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> PTERANODON_EGG = FAEntityTypes.registerLandEgg("pteranodon_egg", FAItems.PTERANODON_EGG::get, FAEntityTypes.PTERANODON);
    public static final SimpleHolder<EntityType<Egg>> SPINOSAURUS_EGG = FAEntityTypes.registerLandEgg("spinosaurus_egg", FAItems.SPINOSAURUS_EGG::get, FAEntityTypes.SPINOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> STEGOSAURUS_EGG = FAEntityTypes.registerLandEgg("stegosaurus_egg", FAItems.STEGOSAURUS_EGG::get, FAEntityTypes.STEGOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> THERIZINOSAURUS_EGG = FAEntityTypes.registerLandEgg("therizinosaurus_egg", FAItems.THERIZINOSAURUS_EGG::get, FAEntityTypes.THERIZINOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> TRICERATOPS_EGG = FAEntityTypes.registerLandEgg("triceratops_egg", FAItems.TRICERATOPS_EGG::get, FAEntityTypes.TRICERATOPS);
    public static final SimpleHolder<EntityType<Egg>> TYRANNOSAURUS_EGG = FAEntityTypes.registerLandEgg("tyrannosaurus_egg", FAItems.TYRANNOSAURUS_EGG::get, FAEntityTypes.TYRANNOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> VELOCIRAPTOR_EGG = FAEntityTypes.registerLandEgg("velociraptor_egg", FAItems.VELOCIRAPTOR_EGG::get, FAEntityTypes.VELOCIRAPTOR);

    public static final SimpleHolder<EntityType<PregnantArmadillo>> PREGNANT_ARMADILLO = ENTITY_TYPES.register("pregnant_armadillo", FAEntityTypes.simple(PregnantArmadillo::new, MobCategory.CREATURE, 0.7F, 0.65F));
    public static final SimpleHolder<EntityType<PregnantBat>> PREGNANT_BAT = ENTITY_TYPES.register("pregnant_bat", FAEntityTypes.simple(PregnantBat::new, MobCategory.AMBIENT, 0.5F, 0.9F).eyeHeight(0.45F).clientTrackingRange(5));
    public static final SimpleHolder<EntityType<PregnantCamel>> PREGNANT_CAMEL = ENTITY_TYPES.register("pregnant_camel", FAEntityTypes.simple(PregnantCamel::new, MobCategory.CREATURE, 1.7F, 2.375F).eyeHeight(2.275F).clientTrackingRange(10));
    public static final SimpleHolder<EntityType<PregnantCat>> PREGNANT_CAT = ENTITY_TYPES.register("pregnant_cat", FAEntityTypes.simple(PregnantCat::new, MobCategory.CREATURE, 0.6F, 0.7F));
    public static final SimpleHolder<EntityType<PregnantCow>> PREGNANT_COW = ENTITY_TYPES.register("pregnant_cow", FAEntityTypes.simple(PregnantCow::new, MobCategory.CREATURE, 0.9F, 1.4F));
    public static final SimpleHolder<EntityType<PregnantDolphin>> PREGNANT_DOLPHIN = ENTITY_TYPES.register("pregnant_dolphin", FAEntityTypes.simple(PregnantDolphin::new, MobCategory.WATER_CREATURE, 0.9F, 0.6F));
    public static final SimpleHolder<EntityType<PregnantDonkey>> PREGNANT_DONKEY = ENTITY_TYPES.register("pregnant_donkey", FAEntityTypes.simple(PregnantDonkey::new, MobCategory.CREATURE, 1.3964844F, 1.5F));
    public static final SimpleHolder<EntityType<PregnantElasmotherium>> PREGNANT_ELASMOTHERIUM = ENTITY_TYPES.register("pregnant_elasmotherium", FAEntityTypes.simple(PregnantElasmotherium::new, MobCategory.CREATURE, 1.0F, 1.0F));
    public static final SimpleHolder<EntityType<PregnantFox>> PREGNANT_FOX = ENTITY_TYPES.register("pregnant_fox", FAEntityTypes.simple(PregnantFox::new, MobCategory.CREATURE, 0.6F, 0.7F));
    public static final SimpleHolder<EntityType<PregnantGoat>> PREGNANT_GOAT = ENTITY_TYPES.register("pregnant_goat", FAEntityTypes.simple(PregnantGoat::new, MobCategory.CREATURE, 0.9F, 1.3F));
    public static final SimpleHolder<EntityType<PregnantHorse>> PREGNANT_HORSE = ENTITY_TYPES.register("pregnant_horse", FAEntityTypes.simple(PregnantHorse::new, MobCategory.CREATURE, 1.3964844F, 1.6F));
    public static final SimpleHolder<EntityType<PregnantLlama>> PREGNANT_LLAMA = ENTITY_TYPES.register("pregnant_llama", FAEntityTypes.simple(PregnantLlama::new, MobCategory.CREATURE, 0.9F, 1.87F));
    public static final SimpleHolder<EntityType<PregnantMammoth>> PREGNANT_MAMMOTH = ENTITY_TYPES.register("pregnant_mammoth", FAEntityTypes.simple(PregnantMammoth::new, MobCategory.CREATURE, 2.5F, 2.5F));
    public static final SimpleHolder<EntityType<PregnantMule>> PREGNANT_MULE = ENTITY_TYPES.register("pregnant_mule", FAEntityTypes.simple(PregnantMule::new, MobCategory.CREATURE, 1.3964844F, 1.6F));
    public static final SimpleHolder<EntityType<PregnantOcelot>> PREGNANT_OCELOT = ENTITY_TYPES.register("pregnant_ocelot", FAEntityTypes.simple(PregnantOcelot::new, MobCategory.CREATURE, 0.6F, 0.7F));
    public static final SimpleHolder<EntityType<PregnantPanda>> PREGNANT_PANDA = ENTITY_TYPES.register("pregnant_panada", FAEntityTypes.simple(PregnantPanda::new, MobCategory.CREATURE, 1.3F, 1.25F));
    public static final SimpleHolder<EntityType<PregnantPig>> PREGNANT_PIG = ENTITY_TYPES.register("pregnant_pig", FAEntityTypes.simple(PregnantPig::new, MobCategory.CREATURE, 0.9F, 0.9F));
    public static final SimpleHolder<EntityType<PregnantPolarBear>> PREGNANT_POLAR_BEAR = ENTITY_TYPES.register("pregnant_polar_bear", FAEntityTypes.simple(PregnantPolarBear::new, MobCategory.CREATURE, 1.4F, 1.4F).immuneTo(Blocks.POWDER_SNOW));
    public static final SimpleHolder<EntityType<PregnantRabbit>> PREGNANT_RABBIT = ENTITY_TYPES.register("pregnant_rabbit", FAEntityTypes.simple(PregnantRabbit::new, MobCategory.CREATURE, 0.4F, 0.5F));
    public static final SimpleHolder<EntityType<PregnantSheep>> PREGNANT_SHEEP = ENTITY_TYPES.register("pregnant_sheep", FAEntityTypes.simple(PregnantSheep::new, MobCategory.CREATURE, 0.9F, 1.3F));
    public static final SimpleHolder<EntityType<PregnantSmilodon>> PREGNANT_SMILODON = ENTITY_TYPES.register("pregnant_smilodon", FAEntityTypes.simple(PregnantSmilodon::new, MobCategory.CREATURE, 2.5F, 2.5F));
    public static final SimpleHolder<EntityType<PregnantWolf>> PREGNANT_WOLF = ENTITY_TYPES.register("pregnant_wolf", FAEntityTypes.simple(PregnantWolf::new, MobCategory.CREATURE, 0.6F, 0.85F));

    public static final SimpleHolder<EntityType<Anu>> ANU = ENTITY_TYPES.register("anu", FAEntityTypes.simple(Anu::new, MobCategory.MONSTER, 0.6F, 1.95F).fireImmune());
    public static final SimpleHolder<EntityType<TamedZombifiedPiglin>> TAMED_ZOMBIFIED_PIGLIN = ENTITY_TYPES.register("tamed_zombified_piglin", FAEntityTypes.simple(TamedZombifiedPiglin::new, MobCategory.MONSTER, 0.6F, 1.95F));
    public static final SimpleHolder<EntityType<Failuresaurus>> FAILURESAURUS = ENTITY_TYPES.register("failuresaurus", FAEntityTypes.simple(Failuresaurus::new, MobCategory.MONSTER, 1.0F, 1.0F));
    public static final SimpleHolder<EntityType<Bones>> BONES = ENTITY_TYPES.register("bones", FAEntityTypes.simple(Bones::new, MobCategory.MONSTER, 0.6F, 1.99F).eyeHeight(1.74F).ridingOffset(-0.7F).clientTrackingRange(8));
    public static final SimpleHolder<EntityType<PirateCaptain>> PIRATE_CAPTAIN = ENTITY_TYPES.register("pirate_captain", FAEntityTypes.simple(PirateCaptain::new, MobCategory.MONSTER, 0.6F, 1.99F).eyeHeight(1.74F).ridingOffset(-0.7F).clientTrackingRange(8));

    public static final SimpleHolder<EntityType<Dart>> DART = ENTITY_TYPES.register("dart", FAEntityTypes.<Dart>simple(Dart::new, MobCategory.MISC, 0.5F, 0.5F).noLootTable());
    public static final SimpleHolder<EntityType<ThrownJavelin>> THROWN_JAVELIN = ENTITY_TYPES.register("thrown_javelin", FAEntityTypes.<ThrownJavelin>simple(ThrownJavelin::new, MobCategory.MISC, 0.5F, 0.5F).noLootTable());
    public static final SimpleHolder<EntityType<ThrownAnimalEgg>> THROWN_INCUBATED_EGG = ENTITY_TYPES.register("thrown_incubated_egg", FAEntityTypes.<ThrownAnimalEgg>simple(ThrownAnimalEgg::new, MobCategory.MISC, 0.25F, 0.25F).noLootTable());
    public static final SimpleHolder<EntityType<DilophosaurusVenom>> DILOPHOSAURUS_VENOM = ENTITY_TYPES.register("dilophosaurus_venom", FAEntityTypes.<DilophosaurusVenom>simple(DilophosaurusVenom::new, MobCategory.MISC, 0.5F, 0.5F).noLootTable());

    public static final SimpleHolder<EntityType<DecorationPlaque>> DECORATION_PLAQUE = ENTITY_TYPES.register("decoration_plaque", FAEntityTypes.<DecorationPlaque>simple(DecorationPlaque::new, MobCategory.MISC, 0.5F, 0.5F).noLootTable());
    public static final SimpleHolder<EntityType<StoneTablet>> STONE_TABLET = ENTITY_TYPES.register("stone_tablet", FAEntityTypes.simple(StoneTablet::new, MobCategory.MISC, 0.5F, 0.5F).noLootTable());

    public static final SimpleHolder<EntityType<Jeep>> JEEP = FAEntityTypes.registerJeep("jeep", FAItems.JEEP_1993::get);

    public static final SimpleHolder<EntityType<Boat>> ARAUCARIA_BOAT = FAEntityTypes.registerBoat("araucaria_boat", FAItems.ARAUCARIA_BOAT::get);
    public static final SimpleHolder<EntityType<ChestBoat>> ARAUCARIA_CHEST_BOAT = FAEntityTypes.registerChestBoat("araucaria_chest_boat", FAItems.ARAUCARIA_CHEST_BOAT::get);
    public static final SimpleHolder<EntityType<Boat>> ARCHAEOPTERIS_BOAT = FAEntityTypes.registerBoat("archaeopteris_boat", FAItems.ARCHAEOPTERIS_BOAT::get);
    public static final SimpleHolder<EntityType<ChestBoat>> ARCHAEOPTERIS_CHEST_BOAT = FAEntityTypes.registerChestBoat("archaeopteris_chest_boat", FAItems.ARCHAEOPTERIS_CHEST_BOAT::get);
    public static final SimpleHolder<EntityType<Boat>> CALAMITES_BOAT = FAEntityTypes.registerBoat("calamites_boat", FAItems.CALAMITES_BOAT::get);
    public static final SimpleHolder<EntityType<ChestBoat>> CALAMITES_CHEST_BOAT = FAEntityTypes.registerChestBoat("calamites_chest_boat", FAItems.CALAMITES_CHEST_BOAT::get);
    public static final SimpleHolder<EntityType<Boat>> CORDAITES_BOAT = FAEntityTypes.registerBoat("cordaites_boat", FAItems.CORDAITES_BOAT::get);
    public static final SimpleHolder<EntityType<ChestBoat>> CORDAITES_CHEST_BOAT = FAEntityTypes.registerChestBoat("cordaites_chest_boat", FAItems.CORDAITES_CHEST_BOAT::get);
    public static final SimpleHolder<EntityType<Boat>> GINKGO_BOAT = FAEntityTypes.registerBoat("ginkgo_boat", FAItems.GINKGO_BOAT::get);
    public static final SimpleHolder<EntityType<ChestBoat>> GINKGO_CHEST_BOAT = FAEntityTypes.registerChestBoat("ginkgo_chest_boat", FAItems.GINKGO_CHEST_BOAT::get);
    public static final SimpleHolder<EntityType<Boat>> LEPIDODENDRON_BOAT = FAEntityTypes.registerBoat("lepidodendron_boat", FAItems.LEPIDODENDRON_BOAT::get);
    public static final SimpleHolder<EntityType<ChestBoat>> LEPIDODENDRON_CHEST_BOAT = FAEntityTypes.registerChestBoat("lepidodendron_chest_boat", FAItems.LEPIDODENDRON_CHEST_BOAT::get);
    public static final SimpleHolder<EntityType<Boat>> SIGILLARIA_BOAT = FAEntityTypes.registerBoat("sigillaria_boat", FAItems.SIGILLARIA_BOAT::get);
    public static final SimpleHolder<EntityType<ChestBoat>> SIGILLARIA_CHEST_BOAT = FAEntityTypes.registerChestBoat("sigillaria_chest_boat", FAItems.SIGILLARIA_CHEST_BOAT::get);
    public static final SimpleHolder<EntityType<Boat>> WOLLEMIA_BOAT = FAEntityTypes.registerBoat("wollemia_boat", FAItems.WOLLEMIA_BOAT::get);
    public static final SimpleHolder<EntityType<ChestBoat>> WOLLEMIA_CHEST_BOAT = FAEntityTypes.registerChestBoat("wollemia_chest_boat", FAItems.WOLLEMIA_CHEST_BOAT::get);
    public static final SimpleHolder<EntityType<Boat>> ARAUCARIOXYLON_BOAT = FAEntityTypes.registerBoat("araucarioxylon_boat", FAItems.ARAUCARIOXYLON_BOAT::get);
    public static final SimpleHolder<EntityType<ChestBoat>> ARAUCARIOXYLON_CHEST_BOAT = FAEntityTypes.registerChestBoat("araucarioxylon_chest_boat", FAItems.ARAUCARIOXYLON_CHEST_BOAT::get);
    public static final SimpleHolder<EntityType<Boat>> METASEQUOIA_BOAT = FAEntityTypes.registerBoat("metasequoia_boat", FAItems.METASEQUOIA_BOAT::get);
    public static final SimpleHolder<EntityType<ChestBoat>> METASEQUOIA_CHEST_BOAT = FAEntityTypes.registerChestBoat("metasequoia_chest_boat", FAItems.METASEQUOIA_CHEST_BOAT::get);

    private static SimpleHolder<EntityType<Jeep>> registerJeep(String id, Supplier<Item> item) {
        return ENTITY_TYPES.register(id, FAEntityTypes.<Jeep>simple((entityType, level) -> new Jeep(entityType, level, item), MobCategory.MISC, 2.0F, 2.0F).noLootTable());
    }

    private static SimpleHolder<EntityType<Boat>> registerBoat(String id, Supplier<Item> boatItem) {
        SimpleHolder<EntityType<Boat>> boat = ENTITY_TYPES.register(id, FAEntityTypes.<Boat>simple((entityType, level) -> new Boat(entityType, level, boatItem), MobCategory.MISC, 1.375F, 0.5625F).noLootTable().eyeHeight(0.5625F).clientTrackingRange(10));
        BOATS.add(boat);
        return boat;
    }

    private static SimpleHolder<EntityType<ChestBoat>> registerChestBoat(String id, Supplier<Item> boatItem) {
        return ENTITY_TYPES.register(id, FAEntityTypes.<ChestBoat>simple((entityType, level) -> new ChestBoat(entityType, level, boatItem), MobCategory.MISC, 1.375F, 0.5625F).noLootTable().eyeHeight(0.5625F).clientTrackingRange(10));
    }

    private static <I extends Item, E extends Entity> SimpleHolder<EntityType<Egg>> registerLandEgg(String id, Supplier<I> item, Supplier<EntityType<E>> offspring) {
        return ENTITY_TYPES.register(id, FAEntityTypes.simple((entityType, level) -> Egg.createLand(entityType, level, item, offspring), MobCategory.MISC, 0.5F, 0.5F));
    }

    private static <I extends Item, E extends Entity> SimpleHolder<EntityType<Egg>> registerWaterEgg(String id, Supplier<I> item, Supplier<EntityType<E>> offspring) {
        return ENTITY_TYPES.register(id, FAEntityTypes.simple((entityType, level) -> Egg.createWater(entityType, level, item, offspring), MobCategory.MISC, 0.5F, 0.5F));
    }

    private static <T extends Entity> EntityType.Builder<T> simple(EntityType.EntityFactory<T> entityFactory, MobCategory mobCategory, float width, float height) {
        return EntityType.Builder.of(entityFactory, mobCategory).sized(width, height);
    }

    private static <T extends Entity> SimpleHolder<EntityType<T>> register(String id, EntityType.Builder<T> builder) {
        return FAEntityTypes.ENTITY_TYPES.register(id, () -> builder.build(ResourceKey.create(Registries.ENTITY_TYPE, FAUtils.resource(id))));
    }
}
