package willatendo.fossilslegacy.server.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.entity.pregnant.*;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;
import java.util.Optional;

public class FossilsLegacyEntityTypes {
    public static final SimpleRegistry<EntityType<?>> ENTITY_TYPES = SimpleRegistry.create(Registries.ENTITY_TYPE, FossilsLegacyUtils.ID);

    public static final SimpleHolder<EntityType<AncientLightningBolt>> ANCIENT_LIGHTNING_BOLT = ENTITY_TYPES.register("ancient_lightning_bolt", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("ancient_lightning_bolt", AncientLightningBolt::new, MobCategory.MISC, true, false, Optional.empty(), 0.0F, 0.0F));

    public static final SimpleHolder<EntityType<Brachiosaurus>> BRACHIOSAURUS = ENTITY_TYPES.register("brachiosaurus", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("brachiosaurus", Brachiosaurus::new, MobCategory.CREATURE, 1.0F, 1.5F));
    public static final SimpleHolder<EntityType<Dilophosaurus>> DILOPHOSAURUS = ENTITY_TYPES.register("dilophosaurus", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("dilophosaurus", Dilophosaurus::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Mammoth>> MAMMOTH = ENTITY_TYPES.register("mammoth", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("mammoth", Mammoth::new, MobCategory.CREATURE, 1.0F, 1.0F));
    public static final SimpleHolder<EntityType<Mosasaurus>> MOSASAURUS = ENTITY_TYPES.register("mosasaurus", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("mosasaurus", Mosasaurus::new, MobCategory.WATER_CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Nautilus>> NAUTILUS = ENTITY_TYPES.register("nautilus", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("nautilus", Nautilus::new, MobCategory.WATER_AMBIENT, 1.0F, 0.75F));
    public static final SimpleHolder<EntityType<Futabasaurus>> FUTABASAURUS = ENTITY_TYPES.register("futabasaurus", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("futabasaurus", Futabasaurus::new, MobCategory.WATER_CREATURE, 1.0F, 0.65F));
    public static final SimpleHolder<EntityType<Pteranodon>> PTERANODON = ENTITY_TYPES.register("pteranodon", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pteranodon", Pteranodon::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Smilodon>> SMILODON = ENTITY_TYPES.register("smilodon", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("smilodon", Smilodon::new, MobCategory.CREATURE, 1.5F, 1.5F));
    public static final SimpleHolder<EntityType<Stegosaurus>> STEGOSAURUS = ENTITY_TYPES.register("stegosaurus", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("stegosaurus", Stegosaurus::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Triceratops>> TRICERATOPS = ENTITY_TYPES.register("triceratops", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("triceratops", Triceratops::new, MobCategory.CREATURE, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<Tyrannosaurus>> TYRANNOSAURUS = ENTITY_TYPES.register("tyrannosaurus", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("tyrannosaurus", Tyrannosaurus::new, MobCategory.CREATURE, 0.5F, 0.75F));
    public static final SimpleHolder<EntityType<Velociraptor>> VELOCIRAPTOR = ENTITY_TYPES.register("velociraptor", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("velociraptor", Velociraptor::new, MobCategory.CREATURE, 0.25F, 0.5F));
    public static final SimpleHolder<EntityType<Carnotaurus>> CARNOTAURUS = FossilsLegacyEntityTypes.ENTITY_TYPES.register("carnotaurus", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("carnotaurus", Carnotaurus::new, MobCategory.CREATURE, 0.5F, 0.75F));
    public static final SimpleHolder<EntityType<Cryolophosaurus>> CRYOLOPHOSAURUS = FossilsLegacyEntityTypes.ENTITY_TYPES.register("cryolophosaurus", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("cryolophosaurus", Cryolophosaurus::new, MobCategory.CREATURE, 0.5F, 0.75F));
    public static final SimpleHolder<EntityType<Therizinosaurus>> THERIZINOSAURUS = FossilsLegacyEntityTypes.ENTITY_TYPES.register("therizinosaurus", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("therizinosaurus", Therizinosaurus::new, MobCategory.CREATURE, 0.5F, 0.75F));

    public static final SimpleHolder<EntityType<Fossil>> FOSSIL = ENTITY_TYPES.register("fossil", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("fossil", Fossil::new, MobCategory.MISC, 0.5F, 0.5F));

    public static final SimpleHolder<EntityType<Egg>> EGG = ENTITY_TYPES.register("egg", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("egg", Egg::new, MobCategory.CREATURE, 0.5F, 0.5F));

    public static final SimpleHolder<EntityType<PregnantCat>> PREGNANT_CAT = ENTITY_TYPES.register("pregnant_cat", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pregnant_cat", PregnantCat::new, MobCategory.CREATURE, 0.6F, 0.7F));
    public static final SimpleHolder<EntityType<PregnantCow>> PREGNANT_COW = ENTITY_TYPES.register("pregnant_cow", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pregnant_cow", PregnantCow::new, MobCategory.CREATURE, 0.9F, 1.4F));
    public static final SimpleHolder<EntityType<PregnantDolphin>> PREGNANT_DOLPHIN = ENTITY_TYPES.register("pregnant_dolphin", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pregnant_dolphin", PregnantDolphin::new, MobCategory.WATER_CREATURE, 0.9F, 0.6F));
    public static final SimpleHolder<EntityType<PregnantDonkey>> PREGNANT_DONKEY = ENTITY_TYPES.register("pregnant_donkey", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pregnant_donkey", PregnantDonkey::new, MobCategory.CREATURE, 1.3964844F, 1.5F));
    public static final SimpleHolder<EntityType<PregnantFox>> PREGNANT_FOX = ENTITY_TYPES.register("pregnant_fox", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pregnant_fox", PregnantFox::new, MobCategory.CREATURE, 0.6F, 0.7F));
    public static final SimpleHolder<EntityType<PregnantGoat>> PREGNANT_GOAT = ENTITY_TYPES.register("pregnant_goat", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pregnant_goat", PregnantGoat::new, MobCategory.CREATURE, 0.9F, 1.3F));
    public static final SimpleHolder<EntityType<PregnantHorse>> PREGNANT_HORSE = ENTITY_TYPES.register("pregnant_horse", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pregnant_horse", PregnantHorse::new, MobCategory.CREATURE, 1.3964844F, 1.6F));
    public static final SimpleHolder<EntityType<PregnantLlama>> PREGNANT_LLAMA = ENTITY_TYPES.register("pregnant_llama", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pregnant_llama", PregnantLlama::new, MobCategory.CREATURE, 0.9F, 1.87F));
    public static final SimpleHolder<EntityType<PregnantMammoth>> PREGNANT_MAMMOTH = ENTITY_TYPES.register("pregnant_mammoth", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pregnant_mammoth", PregnantMammoth::new, MobCategory.CREATURE, 2.5F, 2.5F));
    public static final SimpleHolder<EntityType<PregnantMule>> PREGNANT_MULE = ENTITY_TYPES.register("pregnant_mule", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pregnant_mule", PregnantMule::new, MobCategory.CREATURE, 1.3964844F, 1.6F));
    public static final SimpleHolder<EntityType<PregnantOcelot>> PREGNANT_OCELOT = ENTITY_TYPES.register("pregnant_ocelot", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pregnant_ocelot", PregnantOcelot::new, MobCategory.CREATURE, 0.6F, 0.7F));
    public static final SimpleHolder<EntityType<PregnantPanda>> PREGNANT_PANDA = ENTITY_TYPES.register("pregnant_panada", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pregnant_panada", PregnantPanda::new, MobCategory.CREATURE, 1.3F, 1.25F));
    public static final SimpleHolder<EntityType<PregnantPig>> PREGNANT_PIG = ENTITY_TYPES.register("pregnant_pig", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pregnant_pig", PregnantPig::new, MobCategory.CREATURE, 0.9F, 0.9F));
    public static final SimpleHolder<EntityType<PregnantPolarBear>> PREGNANT_POLAR_BEAR = ENTITY_TYPES.register("pregnant_polar_bear", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pregnant_polar_bear", PregnantPolarBear::new, MobCategory.CREATURE, false, false, Optional.of(Blocks.POWDER_SNOW), 1.4F, 1.4F));
    public static final SimpleHolder<EntityType<PregnantRabbit>> PREGNANT_RABBIT = ENTITY_TYPES.register("pregnant_rabbit", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pregnant_rabbit", PregnantRabbit::new, MobCategory.CREATURE, 0.4F, 0.5F));
    public static final SimpleHolder<EntityType<PregnantSheep>> PREGNANT_SHEEP = ENTITY_TYPES.register("pregnant_sheep", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pregnant_sheep", PregnantSheep::new, MobCategory.CREATURE, 0.9F, 1.3F));
    public static final SimpleHolder<EntityType<PregnantSmilodon>> PREGNANT_SMILODON = ENTITY_TYPES.register("pregnant_smilodon", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pregnant_smilodon", PregnantSmilodon::new, MobCategory.CREATURE, 2.5F, 2.5F));
    public static final SimpleHolder<EntityType<PregnantWolf>> PREGNANT_WOLF = ENTITY_TYPES.register("pregnant_wolf", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("pregnant_wolf", PregnantWolf::new, MobCategory.CREATURE, 0.6F, 0.85F));

    public static final SimpleHolder<EntityType<Anu>> ANU = ENTITY_TYPES.register("anu", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("anu", Anu::new, MobCategory.MONSTER, false, true, Optional.empty(), 0.6F, 1.95F));
    public static final SimpleHolder<EntityType<TamedZombifiedPiglin>> TAMED_ZOMBIFIED_PIGLIN = ENTITY_TYPES.register("tamed_zombified_piglin", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("tamed_zombified_piglin", TamedZombifiedPiglin::new, MobCategory.MONSTER, 0.6F, 1.95F));
    public static final SimpleHolder<EntityType<Failuresaurus>> FAILURESAURUS = ENTITY_TYPES.register("failuresaurus", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("failuresaurus", Failuresaurus::new, MobCategory.MONSTER, 1.0F, 1.0F));

    public static final SimpleHolder<EntityType<ThrownJavelin>> THROWN_JAVELIN = ENTITY_TYPES.register("thrown_javelin", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("thrown_javelin", ThrownJavelin::new, MobCategory.MISC, 0.5F, 0.5F));
    public static final SimpleHolder<EntityType<ThrownIncubatedEgg>> THROWN_INCUBATED_EGG = ENTITY_TYPES.register("thrown_incubated_egg", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("thrown_incubated_egg", ThrownIncubatedEgg::new, MobCategory.MISC, 0.25F, 0.25F));
    public static final SimpleHolder<EntityType<DilophosaurusVenom>> DILOPHOSAURUS_VENOM = ENTITY_TYPES.register("dilophosaurus_venom", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("dilophosaurus_venom", DilophosaurusVenom::new, MobCategory.MISC, 0.5F, 0.5F));

    public static final SimpleHolder<EntityType<StoneTablet>> STONE_TABLET = ENTITY_TYPES.register("stone_tablet", () -> FossilsModloaderHelper.INSTANCE.entityTypeBuilder("stone_tablet", StoneTablet::new, MobCategory.MISC, 0.5F, 0.5F));

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(ENTITY_TYPES);
    }
}
