package willatendo.fossilslegacy.server.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FAEntityTypeTags {
    private static final TagRegister<EntityType<?>> ENTITY_TYPE_TAGS = TagRegister.create(Registries.ENTITY_TYPE, FossilsLegacyUtils.ID);

    public static final TagKey<EntityType<?>> CARNOTAURUS_VICTIMS = ENTITY_TYPE_TAGS.register("victims/carnotaurus");
    public static final TagKey<EntityType<?>> COMPSOGNATHUS_VICTIMS = ENTITY_TYPE_TAGS.register("victims/compsognathus");
    public static final TagKey<EntityType<?>> CRYOLOPHOSAURUS_VICTIMS = ENTITY_TYPE_TAGS.register("victims/cryolophosaurus");
    public static final TagKey<EntityType<?>> DILOPHOSAURUS_VICTIMS = ENTITY_TYPE_TAGS.register("victims/dilophosaurus");
    public static final TagKey<EntityType<?>> DIMETRODON_VICTIMS = ENTITY_TYPE_TAGS.register("victims/dimetrodon");
    public static final TagKey<EntityType<?>> MAGIC_CONCH_COMMANDABLE = ENTITY_TYPE_TAGS.register("commandable/magic_conch");
    public static final TagKey<EntityType<?>> MOSASAURUS_VICTIMS = ENTITY_TYPE_TAGS.register("victims/mosasaurus");
    public static final TagKey<EntityType<?>> SPINOSAURUS_VICTIMS = ENTITY_TYPE_TAGS.register("victims/spinosaurus");
    public static final TagKey<EntityType<?>> TYRANNOSAURUS_VICTIMS = ENTITY_TYPE_TAGS.register("victims/tyrannosaurus");
    public static final TagKey<EntityType<?>> VELOCIRAPTOR_VICTIMS = ENTITY_TYPE_TAGS.register("victims/velociraptor");
}
