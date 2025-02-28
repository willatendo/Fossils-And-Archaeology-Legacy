package willatendo.fossilslegacy.server.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.server.entity.entities.*;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.*;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.guadalupian.Dimetrodon;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.*;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.*;
import willatendo.fossilslegacy.server.entity.entities.pregnant.*;
import willatendo.fossilslegacy.server.entity.entities.vehicle.Jeep;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.function.Supplier;

public final class FAEntityTypes {
    public static final SimpleRegistry<EntityType<?>> ENTITY_TYPES = SimpleRegistry.create(Registries.ENTITY_TYPE, FAUtils.ID);

    public static final SimpleHolder<EntityType<AncientLightningBolt>> ANCIENT_LIGHTNING_BOLT = FAEntityTypes.register("ancient_lightning_bolt", FAEntityTypes.simple(AncientLightningBolt::new, MobCategory.MISC, 0.0F, 0.0F).noSave().noLootTable());

    public static final SimpleHolder<EntityType<Brachiosaurus>> BRACHIOSAURUS = FAEntityTypes.register("brachiosaurus", FAEntityTypes.simple(Brachiosaurus::new, MobCategory.CREATURE, 1.0F, 1.5F));
    public static final SimpleHolder<EntityType<Dilophosaurus>> DILOPHOSAURUS = FAEntityTypes.register("dilophosaurus", FAEntityTypes.simple(Dilophosaurus::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Dimetrodon>> DIMETRODON = FAEntityTypes.register("dimetrodon", FAEntityTypes.simple(Dimetrodon::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Mammoth>> MAMMOTH = FAEntityTypes.register("mammoth", FAEntityTypes.simple(Mammoth::new, MobCategory.CREATURE, 1.0F, 1.0F));
    public static final SimpleHolder<EntityType<Mosasaurus>> MOSASAURUS = FAEntityTypes.register("mosasaurus", FAEntityTypes.simple(Mosasaurus::new, MobCategory.WATER_CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Nautilus>> NAUTILUS = FAEntityTypes.register("nautilus", FAEntityTypes.simple(Nautilus::new, MobCategory.WATER_AMBIENT, 1.0F, 0.75F));
    public static final SimpleHolder<EntityType<Futabasaurus>> FUTABASAURUS = FAEntityTypes.register("futabasaurus", FAEntityTypes.simple(Futabasaurus::new, MobCategory.WATER_CREATURE, 1.0F, 0.65F));
    public static final SimpleHolder<EntityType<Pteranodon>> PTERANODON = FAEntityTypes.register("pteranodon", FAEntityTypes.simple(Pteranodon::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Smilodon>> SMILODON = FAEntityTypes.register("smilodon", FAEntityTypes.simple(Smilodon::new, MobCategory.CREATURE, 1.5F, 1.5F));
    public static final SimpleHolder<EntityType<Stegosaurus>> STEGOSAURUS = FAEntityTypes.register("stegosaurus", FAEntityTypes.simple(Stegosaurus::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Triceratops>> TRICERATOPS = FAEntityTypes.register("triceratops", FAEntityTypes.simple(Triceratops::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Tyrannosaurus>> TYRANNOSAURUS = FAEntityTypes.register("tyrannosaurus", FAEntityTypes.simple(Tyrannosaurus::new, MobCategory.CREATURE, 0.5F, 0.75F));
    public static final SimpleHolder<EntityType<Velociraptor>> VELOCIRAPTOR = FAEntityTypes.register("velociraptor", FAEntityTypes.simple(Velociraptor::new, MobCategory.CREATURE, 0.5F, 0.65F));
    public static final SimpleHolder<EntityType<Carnotaurus>> CARNOTAURUS = FAEntityTypes.register("carnotaurus", FAEntityTypes.simple(Carnotaurus::new, MobCategory.CREATURE, 0.5F, 0.75F));
    public static final SimpleHolder<EntityType<Cryolophosaurus>> CRYOLOPHOSAURUS = FAEntityTypes.register("cryolophosaurus", FAEntityTypes.simple(Cryolophosaurus::new, MobCategory.CREATURE, 0.5F, 0.75F));
    public static final SimpleHolder<EntityType<Therizinosaurus>> THERIZINOSAURUS = FAEntityTypes.register("therizinosaurus", FAEntityTypes.simple(Therizinosaurus::new, MobCategory.CREATURE, 0.5F, 0.75F));
    public static final SimpleHolder<EntityType<Pachycephalosaurus>> PACHYCEPHALOSAURUS = FAEntityTypes.register("pachycephalosaurus", FAEntityTypes.simple(Pachycephalosaurus::new, MobCategory.CREATURE, 1.0F, 1.0F));
    public static final SimpleHolder<EntityType<Compsognathus>> COMPSOGNATHUS = FAEntityTypes.register("compsognathus", FAEntityTypes.simple(Compsognathus::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Dodo>> DODO = FAEntityTypes.register("dodo", FAEntityTypes.simple(Dodo::new, MobCategory.CREATURE, 0.75F, 0.75F));
    public static final SimpleHolder<EntityType<Moa>> MOA = FAEntityTypes.register("moa", FAEntityTypes.simple(Moa::new, MobCategory.CREATURE, 0.75F, 0.75F));
    public static final SimpleHolder<EntityType<Gallimimus>> GALLIMIMUS = FAEntityTypes.register("gallimimus", FAEntityTypes.simple(Gallimimus::new, MobCategory.CREATURE, 0.4F, 0.7F));
    public static final SimpleHolder<EntityType<Spinosaurus>> SPINOSAURUS = FAEntityTypes.register("spinosaurus", FAEntityTypes.simple(Spinosaurus::new, MobCategory.CREATURE, 0.4F, 0.7F));
    public static final SimpleHolder<EntityType<Ankylosaurus>> ANKYLOSAURUS = FAEntityTypes.register("ankylosaurus", FAEntityTypes.simple(Ankylosaurus::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Ichthyosaurus>> ICHTHYOSAURUS = FAEntityTypes.register("ichthyosaurus", FAEntityTypes.simple(Ichthyosaurus::new, MobCategory.WATER_CREATURE, 0.5F, 0.5F));

    public static final SimpleHolder<EntityType<Fossil>> FOSSIL = FAEntityTypes.register("fossil", FAEntityTypes.simple(Fossil::new, MobCategory.MISC, 0.5F, 0.5F).noLootTable());

    public static final SimpleHolder<EntityType<Egg>> ANKYLOSAURUS_EGG = FAEntityTypes.registerLandEgg("ankylosaurus_egg", FAItems.ANKYLOSAURUS_EGG, FAEntityTypes.ANKYLOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> BRACHIOSAURUS_EGG = FAEntityTypes.registerLandEgg("brachiosaurus_egg", FAItems.BRACHIOSAURUS_EGG, FAEntityTypes.BRACHIOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> CARNOTAURUS_EGG = FAEntityTypes.registerLandEgg("carnotaurus_egg", FAItems.CARNOTAURUS_EGG, FAEntityTypes.CARNOTAURUS);
    public static final SimpleHolder<EntityType<Egg>> COMPSOGNATHUS_EGG = FAEntityTypes.registerLandEgg("compsognathus_egg", FAItems.COMPSOGNATHUS_EGG, FAEntityTypes.COMPSOGNATHUS);
    public static final SimpleHolder<EntityType<Egg>> CRYOLOPHOSAURUS_EGG = FAEntityTypes.registerLandEgg("cryolophosaurus_egg", FAItems.CRYOLOPHOSAURUS_EGG, FAEntityTypes.CRYOLOPHOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> DILOPHOSAURUS_EGG = FAEntityTypes.registerLandEgg("dilophosaurus_egg", FAItems.DILOPHOSAURUS_EGG, FAEntityTypes.DILOPHOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> DIMETRODON_EGG = FAEntityTypes.registerLandEgg("dimetrodon_egg", FAItems.DIMETRODON_EGG, FAEntityTypes.DIMETRODON);
    public static final SimpleHolder<EntityType<Egg>> FUTABASAURUS_EGG = FAEntityTypes.registerLandEgg("futabasaurus_egg", FAItems.FUTABASAURUS_EGG, FAEntityTypes.FUTABASAURUS);
    public static final SimpleHolder<EntityType<Egg>> GALLIMIMUS_EGG = FAEntityTypes.registerLandEgg("gallimimus_egg", FAItems.GALLIMIMUS_EGG, FAEntityTypes.GALLIMIMUS);
    public static final SimpleHolder<EntityType<Egg>> ICHTHYOSAURUS_EGG = FAEntityTypes.registerLandEgg("ichthyosaurus_egg", FAItems.ICHTHYOSAURUS_EGG, FAEntityTypes.ICHTHYOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> MOSASAURUS_EGG = FAEntityTypes.registerWaterEgg("mosasaurus_egg", FAItems.MOSASAURUS_EGG, FAEntityTypes.MOSASAURUS);
    public static final SimpleHolder<EntityType<Egg>> PACHYCEPHALOSAURUS_EGG = FAEntityTypes.registerLandEgg("pachycephalosaurus_egg", FAItems.PACHYCEPHALOSAURUS_EGG, FAEntityTypes.PACHYCEPHALOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> PTERANODON_EGG = FAEntityTypes.registerLandEgg("pteranodon_egg", FAItems.PTERANODON_EGG, FAEntityTypes.PTERANODON);
    public static final SimpleHolder<EntityType<Egg>> SPINOSAURUS_EGG = FAEntityTypes.registerLandEgg("spinosaurus_egg", FAItems.SPINOSAURUS_EGG, FAEntityTypes.SPINOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> STEGOSAURUS_EGG = FAEntityTypes.registerLandEgg("stegosaurus_egg", FAItems.STEGOSAURUS_EGG, FAEntityTypes.STEGOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> THERIZINOSAURUS_EGG = FAEntityTypes.registerLandEgg("therizinosaurus_egg", FAItems.THERIZINOSAURUS_EGG, FAEntityTypes.THERIZINOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> TRICERATOPS_EGG = FAEntityTypes.registerLandEgg("triceratops_egg", FAItems.TRICERATOPS_EGG, FAEntityTypes.TRICERATOPS);
    public static final SimpleHolder<EntityType<Egg>> TYRANNOSAURUS_EGG = FAEntityTypes.registerLandEgg("tyrannosaurus_egg", FAItems.TYRANNOSAURUS_EGG, FAEntityTypes.TYRANNOSAURUS);
    public static final SimpleHolder<EntityType<Egg>> VELOCIRAPTOR_EGG = FAEntityTypes.registerLandEgg("velociraptor_egg", FAItems.VELOCIRAPTOR_EGG, FAEntityTypes.VELOCIRAPTOR);

    public static final SimpleHolder<EntityType<PregnantArmadillo>> PREGNANT_ARMADILLO = FAEntityTypes.register("pregnant_armadillo", FAEntityTypes.simple(PregnantArmadillo::new, MobCategory.CREATURE, 0.7F, 0.65F));
    public static final SimpleHolder<EntityType<PregnantCat>> PREGNANT_CAT = FAEntityTypes.register("pregnant_cat", FAEntityTypes.simple(PregnantCat::new, MobCategory.CREATURE, 0.6F, 0.7F));
    public static final SimpleHolder<EntityType<PregnantCow>> PREGNANT_COW = FAEntityTypes.register("pregnant_cow", FAEntityTypes.simple(PregnantCow::new, MobCategory.CREATURE, 0.9F, 1.4F));
    public static final SimpleHolder<EntityType<PregnantDolphin>> PREGNANT_DOLPHIN = FAEntityTypes.register("pregnant_dolphin", FAEntityTypes.simple(PregnantDolphin::new, MobCategory.WATER_CREATURE, 0.9F, 0.6F));
    public static final SimpleHolder<EntityType<PregnantDonkey>> PREGNANT_DONKEY = FAEntityTypes.register("pregnant_donkey", FAEntityTypes.simple(PregnantDonkey::new, MobCategory.CREATURE, 1.3964844F, 1.5F));
    public static final SimpleHolder<EntityType<PregnantFox>> PREGNANT_FOX = FAEntityTypes.register("pregnant_fox", FAEntityTypes.simple(PregnantFox::new, MobCategory.CREATURE, 0.6F, 0.7F));
    public static final SimpleHolder<EntityType<PregnantGoat>> PREGNANT_GOAT = FAEntityTypes.register("pregnant_goat", FAEntityTypes.simple(PregnantGoat::new, MobCategory.CREATURE, 0.9F, 1.3F));
    public static final SimpleHolder<EntityType<PregnantHorse>> PREGNANT_HORSE = FAEntityTypes.register("pregnant_horse", FAEntityTypes.simple(PregnantHorse::new, MobCategory.CREATURE, 1.3964844F, 1.6F));
    public static final SimpleHolder<EntityType<PregnantLlama>> PREGNANT_LLAMA = FAEntityTypes.register("pregnant_llama", FAEntityTypes.simple(PregnantLlama::new, MobCategory.CREATURE, 0.9F, 1.87F));
    public static final SimpleHolder<EntityType<PregnantMammoth>> PREGNANT_MAMMOTH = FAEntityTypes.register("pregnant_mammoth", FAEntityTypes.simple(PregnantMammoth::new, MobCategory.CREATURE, 2.5F, 2.5F));
    public static final SimpleHolder<EntityType<PregnantMule>> PREGNANT_MULE = FAEntityTypes.register("pregnant_mule", FAEntityTypes.simple(PregnantMule::new, MobCategory.CREATURE, 1.3964844F, 1.6F));
    public static final SimpleHolder<EntityType<PregnantOcelot>> PREGNANT_OCELOT = FAEntityTypes.register("pregnant_ocelot", FAEntityTypes.simple(PregnantOcelot::new, MobCategory.CREATURE, 0.6F, 0.7F));
    public static final SimpleHolder<EntityType<PregnantPanda>> PREGNANT_PANDA = FAEntityTypes.register("pregnant_panada", FAEntityTypes.simple(PregnantPanda::new, MobCategory.CREATURE, 1.3F, 1.25F));
    public static final SimpleHolder<EntityType<PregnantPig>> PREGNANT_PIG = FAEntityTypes.register("pregnant_pig", FAEntityTypes.simple(PregnantPig::new, MobCategory.CREATURE, 0.9F, 0.9F));
    public static final SimpleHolder<EntityType<PregnantPolarBear>> PREGNANT_POLAR_BEAR = FAEntityTypes.register("pregnant_polar_bear", FAEntityTypes.simple(PregnantPolarBear::new, MobCategory.CREATURE, 1.4F, 1.4F).immuneTo(Blocks.POWDER_SNOW));
    public static final SimpleHolder<EntityType<PregnantRabbit>> PREGNANT_RABBIT = FAEntityTypes.register("pregnant_rabbit", FAEntityTypes.simple(PregnantRabbit::new, MobCategory.CREATURE, 0.4F, 0.5F));
    public static final SimpleHolder<EntityType<PregnantSheep>> PREGNANT_SHEEP = FAEntityTypes.register("pregnant_sheep", FAEntityTypes.simple(PregnantSheep::new, MobCategory.CREATURE, 0.9F, 1.3F));
    public static final SimpleHolder<EntityType<PregnantSmilodon>> PREGNANT_SMILODON = FAEntityTypes.register("pregnant_smilodon", FAEntityTypes.simple(PregnantSmilodon::new, MobCategory.CREATURE, 2.5F, 2.5F));
    public static final SimpleHolder<EntityType<PregnantWolf>> PREGNANT_WOLF = FAEntityTypes.register("pregnant_wolf", FAEntityTypes.simple(PregnantWolf::new, MobCategory.CREATURE, 0.6F, 0.85F));

    public static final SimpleHolder<EntityType<Anu>> ANU = FAEntityTypes.register("anu", FAEntityTypes.simple(Anu::new, MobCategory.MONSTER, 0.6F, 1.95F).fireImmune());
    public static final SimpleHolder<EntityType<TamedZombifiedPiglin>> TAMED_ZOMBIFIED_PIGLIN = FAEntityTypes.register("tamed_zombified_piglin", FAEntityTypes.simple(TamedZombifiedPiglin::new, MobCategory.MONSTER, 0.6F, 1.95F));
    public static final SimpleHolder<EntityType<Failuresaurus>> FAILURESAURUS = FAEntityTypes.register("failuresaurus", FAEntityTypes.simple(Failuresaurus::new, MobCategory.MONSTER, 1.0F, 1.0F));

    public static final SimpleHolder<EntityType<ThrownJavelin>> THROWN_JAVELIN = FAEntityTypes.register("thrown_javelin", FAEntityTypes.<ThrownJavelin>simple(ThrownJavelin::new, MobCategory.MISC, 0.5F, 0.5F).noLootTable());
    public static final SimpleHolder<EntityType<ThrownAnimalEgg>> THROWN_INCUBATED_EGG = FAEntityTypes.register("thrown_incubated_egg", FAEntityTypes.<ThrownAnimalEgg>simple(ThrownAnimalEgg::new, MobCategory.MISC, 0.25F, 0.25F).noLootTable());
    public static final SimpleHolder<EntityType<DilophosaurusVenom>> DILOPHOSAURUS_VENOM = FAEntityTypes.register("dilophosaurus_venom", FAEntityTypes.<DilophosaurusVenom>simple(DilophosaurusVenom::new, MobCategory.MISC, 0.5F, 0.5F).noLootTable());

    public static final SimpleHolder<EntityType<StoneTablet>> STONE_TABLET = FAEntityTypes.register("stone_tablet", FAEntityTypes.simple(StoneTablet::new, MobCategory.MISC, 0.5F, 0.5F).noLootTable());

    public static final SimpleHolder<EntityType<Jeep>> JEEP = FAEntityTypes.registerJeep("jeep", FAItems.JEEP_1993::get);

    public static final SimpleHolder<EntityType<Boat>> CALAMITES_BOAT = FAEntityTypes.registerBoat("calamites_boat", FAItems.CALAMITES_BOAT::get);
    public static final SimpleHolder<EntityType<ChestBoat>> CALAMITES_CHEST_BOAT = FAEntityTypes.registerChestBoat("calamites_chest_boat", FAItems.CALAMITES_CHEST_BOAT::get);
    public static final SimpleHolder<EntityType<Boat>> LEPIDODENDRON_BOAT = FAEntityTypes.registerBoat("lepidodendron_boat", FAItems.LEPIDODENDRON_BOAT::get);
    public static final SimpleHolder<EntityType<ChestBoat>> LEPIDODENDRON_CHEST_BOAT = FAEntityTypes.registerChestBoat("lepidodendron_chest_boat", FAItems.LEPIDODENDRON_CHEST_BOAT::get);
    public static final SimpleHolder<EntityType<Boat>> SIGILLARIA_BOAT = FAEntityTypes.registerBoat("sigillaria_boat", FAItems.SIGILLARIA_BOAT::get);
    public static final SimpleHolder<EntityType<ChestBoat>> SIGILLARIA_CHEST_BOAT = FAEntityTypes.registerChestBoat("sigillaria_chest_boat", FAItems.SIGILLARIA_CHEST_BOAT::get);

    private static SimpleHolder<EntityType<Jeep>> registerJeep(String id, Supplier<Item> item) {
        return FAEntityTypes.register(id, FAEntityTypes.<Jeep>simple((entityType, level) -> new Jeep(entityType, level, item), MobCategory.MISC, 2.0F, 2.0F).noLootTable());
    }

    private static SimpleHolder<EntityType<Boat>> registerBoat(String id, Supplier<Item> boatItem) {
        return FAEntityTypes.register(id, FAEntityTypes.<Boat>simple((entityType, level) -> new Boat(entityType, level, boatItem), MobCategory.MISC, 1.375F, 0.5625F).noLootTable().eyeHeight(0.5625F).clientTrackingRange(10));
    }

    private static SimpleHolder<EntityType<ChestBoat>> registerChestBoat(String id, Supplier<Item> boatItem) {
        return FAEntityTypes.register(id, FAEntityTypes.<ChestBoat>simple((entityType, level) -> new ChestBoat(entityType, level, boatItem), MobCategory.MISC, 1.375F, 0.5625F).noLootTable().eyeHeight(0.5625F).clientTrackingRange(10));
    }

    private static <I extends Item, E extends Entity> SimpleHolder<EntityType<Egg>> registerLandEgg(String id, Supplier<I> item, Supplier<EntityType<E>> offspring) {
        return FAEntityTypes.register(id, FAEntityTypes.simple((entityType, level) -> Egg.createLand(entityType, level, item, offspring), MobCategory.MISC, 0.5F, 0.5F));
    }

    private static <I extends Item, E extends Entity> SimpleHolder<EntityType<Egg>> registerWaterEgg(String id, Supplier<I> item, Supplier<EntityType<E>> offspring) {
        return FAEntityTypes.register(id, FAEntityTypes.simple((entityType, level) -> Egg.createWater(entityType, level, item, offspring), MobCategory.MISC, 0.5F, 0.5F));
    }

    private static <T extends Entity> EntityType.Builder<T> simple(EntityType.EntityFactory<T> entityFactory, MobCategory mobCategory, float width, float height) {
        return EntityType.Builder.of(entityFactory, mobCategory).sized(width, height);
    }

    private static <T extends Entity> SimpleHolder<EntityType<T>> register(String id, EntityType.Builder<T> builder) {
        return FAEntityTypes.ENTITY_TYPES.register(id, () -> builder.build(ResourceKey.create(Registries.ENTITY_TYPE, FAUtils.resource(id))));
    }
}
