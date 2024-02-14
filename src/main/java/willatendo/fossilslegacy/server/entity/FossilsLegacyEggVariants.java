package willatendo.fossilslegacy.server.entity;

import java.util.function.Function;
import java.util.function.Supplier;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.FabricRegister;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyEggVariants {
	public static final SimpleRegistry<EggVariant> EGG_VARIANTS = SimpleRegistry.create(FossilsLegacyRegistries.EGG_VARIANTS, FossilsLegacyUtils.ID);

	public static final SimpleHolder<EggVariant> TRICERATOPS = register("triceratops", () -> FossilsLegacyEntities.TRICERATOPS.get(), () -> FossilsLegacyItems.TRICERATOPS_EGG.get());
	public static final SimpleHolder<EggVariant> VELOCIRAPTOR = register("velociraptor", () -> FossilsLegacyEntities.VELOCIRAPTOR.get(), () -> FossilsLegacyItems.VELOCIRAPTOR_EGG.get());
	public static final SimpleHolder<EggVariant> TYRANNOSAURUS = register("tyrannosaurus", () -> FossilsLegacyEntities.TYRANNOSAURUS.get(), () -> FossilsLegacyItems.TYRANNOSAURUS_EGG.get());
	public static final SimpleHolder<EggVariant> PTERANODON = register("pteranodon", () -> FossilsLegacyEntities.PTERANODON.get(), () -> FossilsLegacyItems.PTERANODON_EGG.get());
	public static final SimpleHolder<EggVariant> PLESIOSAURUS = register("plesiosaurus", () -> EntityType.COW, () -> FossilsLegacyItems.PLESIOSAURUS_EGG.get());
	public static final SimpleHolder<EggVariant> MOSASAURUS = register("mosasaurus", true, egg -> egg.isInWaterOrBubble(), () -> FossilsLegacyEntities.MOSASAURUS.get(), () -> FossilsLegacyItems.MOSASAURUS_EGG.get());
	public static final SimpleHolder<EggVariant> STEGOSAURUS = register("stegosaurus", () -> FossilsLegacyEntities.BRACHIOSAURUS.get(), () -> FossilsLegacyItems.STEGOSAURUS_EGG.get());
	public static final SimpleHolder<EggVariant> DILOPHOSAURUS = register("dilophosaurus", () -> FossilsLegacyEntities.DILOPHOSAURUS.get(), () -> FossilsLegacyItems.DILOPHOSAURUS_EGG.get());
	public static final SimpleHolder<EggVariant> BRACHIOSAURUS = register("brachiosaurus", () -> FossilsLegacyEntities.BRACHIOSAURUS.get(), () -> FossilsLegacyItems.BRACHIOSAURUS_EGG.get());

	public static SimpleHolder<EggVariant> register(String id, Supplier<EntityType> entityType, Supplier<Item> pick) {
		return register(id, false, egg -> EggVariant.isWarm(egg), entityType, pick);
	}

	public static SimpleHolder<EggVariant> register(String id, boolean wet, Function<Egg, Boolean> incubate, Supplier<EntityType> entityType, Supplier<Item> pick) {
		return EGG_VARIANTS.register(id, () -> new EggVariant(FossilsLegacyUtils.resource("textures/entities/egg/" + id + ".png"), wet, incubate, FossilsLegacyUtils.resource("entities/egg/" + id), entityType, pick));
	}

	public static void init() {
		FabricRegister.register(EGG_VARIANTS);
	}
}
