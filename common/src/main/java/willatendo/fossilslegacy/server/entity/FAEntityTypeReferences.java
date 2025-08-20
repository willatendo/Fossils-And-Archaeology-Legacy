package willatendo.fossilslegacy.server.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class FAEntityTypeReferences {
    public static final ResourceKey<EntityType<?>> ANKYLOSAURUS = FAEntityTypeReferences.reference("ankylosaurus");
    public static final ResourceKey<EntityType<?>> BARYONYX = FAEntityTypeReferences.reference("baryonyx");
    public static final ResourceKey<EntityType<?>> BRACHIOSAURUS = FAEntityTypeReferences.reference("brachiosaurus");
    public static final ResourceKey<EntityType<?>> CARNOTAURUS = FAEntityTypeReferences.reference("carnotaurus");
    public static final ResourceKey<EntityType<?>> COMPSOGNATHUS = FAEntityTypeReferences.reference("compsognathus");
    public static final ResourceKey<EntityType<?>> CRYOLOPHOSAURUS = FAEntityTypeReferences.reference("cryolophosaurus");
    public static final ResourceKey<EntityType<?>> DILOPHOSAURUS = FAEntityTypeReferences.reference("dilophosaurus");
    public static final ResourceKey<EntityType<?>> DIMETRODON = FAEntityTypeReferences.reference("dimetrodon");
    public static final ResourceKey<EntityType<?>> DISTORTUS_REX = FAEntityTypeReferences.reference("distortus_rex");
    public static final ResourceKey<EntityType<?>> DODO = FAEntityTypeReferences.reference("dodo");
    public static final ResourceKey<EntityType<?>> DRYOSAURUS = FAEntityTypeReferences.reference("dryosaurus");
    public static final ResourceKey<EntityType<?>> ELASMOTHERIUM = FAEntityTypeReferences.reference("elasmotherium");
    public static final ResourceKey<EntityType<?>> FUTABASAURUS = FAEntityTypeReferences.reference("futabasaurus");
    public static final ResourceKey<EntityType<?>> GALLIMIMUS = FAEntityTypeReferences.reference("gallimimus");
    public static final ResourceKey<EntityType<?>> ICHTHYOSAURUS = FAEntityTypeReferences.reference("ichthyosaurus");
    public static final ResourceKey<EntityType<?>> ISOTELUS = FAEntityTypeReferences.reference("isotelus");
    public static final ResourceKey<EntityType<?>> ISOTELUS_LARVA = FAEntityTypeReferences.reference("isotelus_larva");
    public static final ResourceKey<EntityType<?>> MAMMOTH = FAEntityTypeReferences.reference("mammoth");
    public static final ResourceKey<EntityType<?>> MOA = FAEntityTypeReferences.reference("moa");
    public static final ResourceKey<EntityType<?>> MOSASAURUS = FAEntityTypeReferences.reference("mosasaurus");
    public static final ResourceKey<EntityType<?>> NAUTILUS = FAEntityTypeReferences.reference("nautilus");
    public static final ResourceKey<EntityType<?>> PACHYCEPHALOSAURUS = FAEntityTypeReferences.reference("pachycephalosaurus");
    public static final ResourceKey<EntityType<?>> PTERANODON = FAEntityTypeReferences.reference("pteranodon");
    public static final ResourceKey<EntityType<?>> SMILODON = FAEntityTypeReferences.reference("smilodon");
    public static final ResourceKey<EntityType<?>> SPINOSAURUS = FAEntityTypeReferences.reference("spinosaurus");
    public static final ResourceKey<EntityType<?>> STEGOSAURUS = FAEntityTypeReferences.reference("stegosaurus");
    public static final ResourceKey<EntityType<?>> THERIZINOSAURUS = FAEntityTypeReferences.reference("therizinosaurus");
    public static final ResourceKey<EntityType<?>> TRICERATOPS = FAEntityTypeReferences.reference("triceratops");
    public static final ResourceKey<EntityType<?>> TYRANNOSAURUS = FAEntityTypeReferences.reference("tyrannosaurus");
    public static final ResourceKey<EntityType<?>> VELOCIRAPTOR = FAEntityTypeReferences.reference("velociraptor");

    public static ResourceKey<EntityType<?>> reference(String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(FAUtils.ID, name));
    }
}
