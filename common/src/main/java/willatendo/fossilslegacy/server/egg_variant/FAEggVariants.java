package willatendo.fossilslegacy.server.egg_variant;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.FALootTables;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.function.Function;
import java.util.function.Supplier;

public final class FAEggVariants {
    public static final SimpleRegistry<EggVariant> EGG_VARIANTS = SimpleRegistry.create(FARegistries.EGG_VARIANTS, FAUtils.ID);

    public static final SimpleHolder<EggVariant> ANKYLOSAURUS = register("ankylosaurus", FAEntityTypes.ANKYLOSAURUS::get, FAItems.ANKYLOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> BRACHIOSAURUS = register("brachiosaurus", FAEntityTypes.BRACHIOSAURUS::get, FAItems.BRACHIOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> CARNOTAURUS = register("carnotaurus", FAEntityTypes.CARNOTAURUS::get, FAItems.CARNOTAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> COMPSOGNATHUS = register("compsognathus", EggVariant.EggSize.SMALL, FAEntityTypes.COMPSOGNATHUS::get, FAItems.COMPSOGNATHUS_EGG::get);
    public static final SimpleHolder<EggVariant> CRYOLOPHOSAURUS = register("cryolophosaurus", FAEntityTypes.CRYOLOPHOSAURUS::get, FAItems.CRYOLOPHOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> DILOPHOSAURUS = register("dilophosaurus", FAEntityTypes.DILOPHOSAURUS::get, FAItems.DILOPHOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> DIMETRODON = register("dimetrodon", FAEntityTypes.DIMETRODON::get, FAItems.DIMETRODON_EGG::get);
    public static final SimpleHolder<EggVariant> FUTABASAURUS = register("futabasaurus", FAEntityTypes.FUTABASAURUS::get, FAItems.FUTABASAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> GALLIMIMUS = register("gallimimus", FAEntityTypes.GALLIMIMUS::get, FAItems.GALLIMIMUS_EGG::get);
    public static final SimpleHolder<EggVariant> MOSASAURUS = register("mosasaurus", EggVariant.EggSize.REGULAR, true, Entity::isInWaterOrBubble, FAEntityTypes.MOSASAURUS::get, FAItems.MOSASAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> PACHYCEPHALOSAURUS = register("pachycephalosaurus", FAEntityTypes.PACHYCEPHALOSAURUS::get, FAItems.PACHYCEPHALOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> PTERANODON = register("pteranodon", FAEntityTypes.PTERANODON::get, FAItems.PTERANODON_EGG::get);
    public static final SimpleHolder<EggVariant> SPINOSAURUS = register("spinosaurus", FAEntityTypes.SPINOSAURUS::get, FAItems.SPINOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> STEGOSAURUS = register("stegosaurus", FAEntityTypes.STEGOSAURUS::get, FAItems.STEGOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> THERIZINOSAURUS = register("therizinosaurus", FAEntityTypes.THERIZINOSAURUS::get, FAItems.THERIZINOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> TRICERATOPS = register("triceratops", FAEntityTypes.TRICERATOPS::get, FAItems.TRICERATOPS_EGG::get);
    public static final SimpleHolder<EggVariant> TYRANNOSAURUS = register("tyrannosaurus", FAEntityTypes.TYRANNOSAURUS::get, FAItems.TYRANNOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> VELOCIRAPTOR = register("velociraptor", FAEntityTypes.VELOCIRAPTOR::get, FAItems.VELOCIRAPTOR_EGG::get);

    public static SimpleHolder<EggVariant> register(String id, Supplier<EntityType> entityType, Supplier<Item> pick) {
        return FAEggVariants.register(id, EggVariant.EggSize.REGULAR, entityType, pick);
    }

    public static SimpleHolder<EggVariant> register(String id, EggVariant.EggSize eggSize, Supplier<EntityType> entityType, Supplier<Item> pick) {
        return FAEggVariants.register(id, eggSize, false, EggVariant::isWarm, entityType, pick);
    }

    public static SimpleHolder<EggVariant> register(String id, EggVariant.EggSize eggSize, boolean wet, Function<Egg, Boolean> incubate, Supplier<EntityType> entityType, Supplier<Item> pick) {
        return EGG_VARIANTS.register(id, () -> new EggVariant(eggSize, FAUtils.resource("textures/entity/egg/" + id + ".png"), wet, incubate, FALootTables.create("entities/egg/" + id), entityType, pick));
    }
}
