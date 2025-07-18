package willatendo.fossilslegacy.server.tags;

import net.minecraft.tags.TagKey;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FAModelTypeTags {
    private static final TagRegister<ModelType> MODEL_TYPE_TAGS = TagRegister.create(FARegistries.MODEL_TYPES, FAUtils.ID);

    public static final TagKey<ModelType> LOCKED = MODEL_TYPE_TAGS.register("locked");

    public static final TagKey<ModelType> ANKYLOSAURUS = MODEL_TYPE_TAGS.register("ankylosaurus");
    public static final TagKey<ModelType> BARYONYX = MODEL_TYPE_TAGS.register("baryonyx");
    public static final TagKey<ModelType> BRACHIOSAURUS = MODEL_TYPE_TAGS.register("brachiosaurus");
    public static final TagKey<ModelType> NON_LEGACY_BRACHIOSAURUS = MODEL_TYPE_TAGS.register("non_legacy/brachiosaurus");
    public static final TagKey<ModelType> CARNOTAURUS = MODEL_TYPE_TAGS.register("carnotaurus");
    public static final TagKey<ModelType> NON_LEGACY_CARNOTAURUS = MODEL_TYPE_TAGS.register("non_legacy/carnotaurus");
    public static final TagKey<ModelType> COMPSOGNATHUS = MODEL_TYPE_TAGS.register("compsognathus");
    public static final TagKey<ModelType> CRYOLOPHOSAURUS = MODEL_TYPE_TAGS.register("cryolophosaurus");
    public static final TagKey<ModelType> NON_LEGACY_CRYOLOPHOSAURUS = MODEL_TYPE_TAGS.register("non_legacy/cryolophosaurus");
    public static final TagKey<ModelType> DILOPHOSAURUS = MODEL_TYPE_TAGS.register("dilophosaurus");
    public static final TagKey<ModelType> NON_LEGACY_DILOPHOSAURUS = MODEL_TYPE_TAGS.register("non_legacy/dilophosaurus");
    public static final TagKey<ModelType> DIMETRODON = MODEL_TYPE_TAGS.register("dimetrodon");
    public static final TagKey<ModelType> DISTORTUS_REX = MODEL_TYPE_TAGS.register("distortus_rex");
    public static final TagKey<ModelType> DODO = MODEL_TYPE_TAGS.register("dodo");
    public static final TagKey<ModelType> DRYOSAURUS = MODEL_TYPE_TAGS.register("dryosaurus");
    public static final TagKey<ModelType> ELASMOTHERIUM = MODEL_TYPE_TAGS.register("elasmotherium");
    public static final TagKey<ModelType> FUTABASAURUS = MODEL_TYPE_TAGS.register("futabasaurus");
    public static final TagKey<ModelType> NON_LEGACY_FUTABASAURUS = MODEL_TYPE_TAGS.register("non_legacy/futabasaurus");
    public static final TagKey<ModelType> GALLIMIMUS = MODEL_TYPE_TAGS.register("gallimimus");
    public static final TagKey<ModelType> ICHTHYOSAURUS = MODEL_TYPE_TAGS.register("ichthyosaurus");
    public static final TagKey<ModelType> ISOTELUS = MODEL_TYPE_TAGS.register("isotelus");
    public static final TagKey<ModelType> LEGACY = MODEL_TYPE_TAGS.register("legacy");
    public static final TagKey<ModelType> MAMMOTH = MODEL_TYPE_TAGS.register("mammoth");
    public static final TagKey<ModelType> NON_LEGACY_MAMMOTH = MODEL_TYPE_TAGS.register("non_legacy/mammoth");
    public static final TagKey<ModelType> MOA = MODEL_TYPE_TAGS.register("moa");
    public static final TagKey<ModelType> MOSASAURUS = MODEL_TYPE_TAGS.register("mosasaurus");
    public static final TagKey<ModelType> NON_LEGACY_MOSASAURUS = MODEL_TYPE_TAGS.register("non_legacy/mosasaurus");
    public static final TagKey<ModelType> PACHYCEPHALOSAURUS = MODEL_TYPE_TAGS.register("pachycephalosaurus");
    public static final TagKey<ModelType> PTERANODON = MODEL_TYPE_TAGS.register("pteranodon");
    public static final TagKey<ModelType> NON_LEGACY_PTERANODON = MODEL_TYPE_TAGS.register("non_legacy/pteranodon");
    public static final TagKey<ModelType> SMILODON = MODEL_TYPE_TAGS.register("smilodon");
    public static final TagKey<ModelType> NON_LEGACY_SMILODON = MODEL_TYPE_TAGS.register("non_legacy/smilodon");
    public static final TagKey<ModelType> SPINOSAURUS = MODEL_TYPE_TAGS.register("spinosaurus");
    public static final TagKey<ModelType> STEGOSAURUS = MODEL_TYPE_TAGS.register("stegosaurus");
    public static final TagKey<ModelType> NON_LEGACY_STEGOSAURUS = MODEL_TYPE_TAGS.register("non_legacy/stegosaurus");
    public static final TagKey<ModelType> THERIZINOSAURUS = MODEL_TYPE_TAGS.register("therizinosaurus");
    public static final TagKey<ModelType> NON_LEGACY_THERIZINOSAURUS = MODEL_TYPE_TAGS.register("non_legacy/therizinosaurus");
    public static final TagKey<ModelType> TRICERATOPS = MODEL_TYPE_TAGS.register("triceratops");
    public static final TagKey<ModelType> NON_LEGACY_TRICERATOPS = MODEL_TYPE_TAGS.register("non_legacy/triceratops");
    public static final TagKey<ModelType> TYRANNOSAURUS = MODEL_TYPE_TAGS.register("tyrannosaurus");
    public static final TagKey<ModelType> NON_LEGACY_TYRANNOSAURUS = MODEL_TYPE_TAGS.register("non_legacy/tyrannosaurus");
    public static final TagKey<ModelType> VELOCIRAPTOR = MODEL_TYPE_TAGS.register("velociraptor");
    public static final TagKey<ModelType> LEGACY_VELOCIRAPTOR = MODEL_TYPE_TAGS.register("legacy_velociraptor");
    public static final TagKey<ModelType> NON_LEGACY_VELOCIRAPTOR = MODEL_TYPE_TAGS.register("non_legacy/velociraptor");
}
