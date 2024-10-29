package willatendo.fossilslegacy.server.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.item.FossilsLegacyLootTables;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.function.Function;
import java.util.function.Supplier;

public class FossilsLegacyEggVariants {
    public static final SimpleRegistry<EggVariant> EGG_VARIANTS = SimpleRegistry.create(FossilsLegacyRegistries.EGG_VARIANTS, FossilsLegacyUtils.ID);

    public static final SimpleHolder<EggVariant> ANKYLOSAURUS = register("ankylosaurus", FossilsLegacyEntityTypes.ANKYLOSAURUS::get, FossilsLegacyItems.ANKYLOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> BRACHIOSAURUS = register("brachiosaurus", FossilsLegacyEntityTypes.BRACHIOSAURUS::get, FossilsLegacyItems.BRACHIOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> CARNOTAURUS = register("carnotaurus", FossilsLegacyEntityTypes.CARNOTAURUS::get, FossilsLegacyItems.CARNOTAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> COMPSOGNATHUS = register("compsognathus", FossilsLegacyEntityTypes.COMPSOGNATHUS::get, FossilsLegacyItems.COMPSOGNATHUS_EGG::get);
    public static final SimpleHolder<EggVariant> CRYOLOPHOSAURUS = register("cryolophosaurus", FossilsLegacyEntityTypes.CRYOLOPHOSAURUS::get, FossilsLegacyItems.CRYOLOPHOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> DILOPHOSAURUS = register("dilophosaurus", FossilsLegacyEntityTypes.DILOPHOSAURUS::get, FossilsLegacyItems.DILOPHOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> DIMETRODON = register("dimetrodon", FossilsLegacyEntityTypes.DILOPHOSAURUS::get, FossilsLegacyItems.DILOPHOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> FUTABASAURUS = register("futabasaurus", FossilsLegacyEntityTypes.FUTABASAURUS::get, FossilsLegacyItems.FUTABASAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> GALLIMIMUS = register("gallimimus", FossilsLegacyEntityTypes.GALLIMIMUS::get, FossilsLegacyItems.GALLIMIMUS_EGG::get);
    public static final SimpleHolder<EggVariant> MOSASAURUS = register("mosasaurus", true, Entity::isInWaterOrBubble, FossilsLegacyEntityTypes.MOSASAURUS::get, FossilsLegacyItems.MOSASAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> PACHYCEPHALOSAURUS = register("pachycephalosaurus", FossilsLegacyEntityTypes.PACHYCEPHALOSAURUS::get, FossilsLegacyItems.PACHYCEPHALOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> PTERANODON = register("pteranodon", FossilsLegacyEntityTypes.PTERANODON::get, FossilsLegacyItems.PTERANODON_EGG::get);
    public static final SimpleHolder<EggVariant> SPINOSAURUS = register("spinosaurus", FossilsLegacyEntityTypes.SPINOSAURUS::get, FossilsLegacyItems.SPINOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> STEGOSAURUS = register("stegosaurus", FossilsLegacyEntityTypes.STEGOSAURUS::get, FossilsLegacyItems.STEGOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> THERIZINOSAURUS = register("therizinosaurus", FossilsLegacyEntityTypes.THERIZINOSAURUS::get, FossilsLegacyItems.THERIZINOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> TRICERATOPS = register("triceratops", FossilsLegacyEntityTypes.TRICERATOPS::get, FossilsLegacyItems.TRICERATOPS_EGG::get);
    public static final SimpleHolder<EggVariant> TYRANNOSAURUS = register("tyrannosaurus", FossilsLegacyEntityTypes.TYRANNOSAURUS::get, FossilsLegacyItems.TYRANNOSAURUS_EGG::get);
    public static final SimpleHolder<EggVariant> VELOCIRAPTOR = register("velociraptor", FossilsLegacyEntityTypes.VELOCIRAPTOR::get, FossilsLegacyItems.VELOCIRAPTOR_EGG::get);

    public static SimpleHolder<EggVariant> register(String id, Supplier<EntityType> entityType, Supplier<Item> pick) {
        return register(id, false, EggVariant::isWarm, entityType, pick);
    }

    public static SimpleHolder<EggVariant> register(String id, boolean wet, Function<Egg, Boolean> incubate, Supplier<EntityType> entityType, Supplier<Item> pick) {
        return EGG_VARIANTS.register(id, () -> new EggVariant(FossilsLegacyUtils.resource("textures/entity/egg/" + id + ".png"), wet, incubate, FossilsLegacyLootTables.create("entities/egg/" + id), entityType, pick));
    }
}
