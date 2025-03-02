package willatendo.fossilslegacy.server.tags;

import net.minecraft.tags.TagKey;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FAModelTypeTags {
    private static final TagRegister<ModelType> COAT_TYPE_TAGS = TagRegister.create(FARegistries.MODEL_TYPES, FAUtils.ID);

    public static final TagKey<ModelType> ANKYLOSAURUS = COAT_TYPE_TAGS.register("ankylosaurus");
    public static final TagKey<ModelType> BRACHIOSAURUS = COAT_TYPE_TAGS.register("brachiosaurus");
    public static final TagKey<ModelType> NON_LEGACY_BRACHIOSAURUS = COAT_TYPE_TAGS.register("non_legacy/brachiosaurus");
    public static final TagKey<ModelType> CARNOTAURUS = COAT_TYPE_TAGS.register("carnotaurus");
    public static final TagKey<ModelType> NON_LEGACY_CARNOTAURUS = COAT_TYPE_TAGS.register("non_legacy/carnotaurus");
    public static final TagKey<ModelType> COMPSOGNATHUS = COAT_TYPE_TAGS.register("compsognathus");
    public static final TagKey<ModelType> CRYOLOPHOSAURUS = COAT_TYPE_TAGS.register("cryolophosaurus");
    public static final TagKey<ModelType> NON_LEGACY_CRYOLOPHOSAURUS = COAT_TYPE_TAGS.register("non_legacy/cryolophosaurus");
    public static final TagKey<ModelType> DILOPHOSAURUS = COAT_TYPE_TAGS.register("dilophosaurus");
    public static final TagKey<ModelType> NON_LEGACY_DILOPHOSAURUS = COAT_TYPE_TAGS.register("non_legacy/dilophosaurus");
    public static final TagKey<ModelType> DIMETRODON = COAT_TYPE_TAGS.register("dimetrodon");
    public static final TagKey<ModelType> DODO = COAT_TYPE_TAGS.register("dodo");
    public static final TagKey<ModelType> FUTABASAURUS = COAT_TYPE_TAGS.register("futabasaurus");
    public static final TagKey<ModelType> NON_LEGACY_FUTABASAURUS = COAT_TYPE_TAGS.register("non_legacy/futabasaurus");
    public static final TagKey<ModelType> GALLIMIMUS = COAT_TYPE_TAGS.register("gallimimus");
    public static final TagKey<ModelType> ICHTHYOSAURUS = COAT_TYPE_TAGS.register("ichthyosaurus");
    public static final TagKey<ModelType> LEGACY = COAT_TYPE_TAGS.register("legacy");
    public static final TagKey<ModelType> MAMMOTH = COAT_TYPE_TAGS.register("mammoth");
    public static final TagKey<ModelType> NON_LEGACY_MAMMOTH = COAT_TYPE_TAGS.register("non_legacy/mammoth");
    public static final TagKey<ModelType> MOA = COAT_TYPE_TAGS.register("moa");
    public static final TagKey<ModelType> MOSASAURUS = COAT_TYPE_TAGS.register("mosasaurus");
    public static final TagKey<ModelType> NON_LEGACY_MOSASAURUS = COAT_TYPE_TAGS.register("non_legacy/mosasaurus");
    public static final TagKey<ModelType> PACHYCEPHALOSAURUS = COAT_TYPE_TAGS.register("pachycephalosaurus");
    public static final TagKey<ModelType> PTERANODON = COAT_TYPE_TAGS.register("pteranodon");
    public static final TagKey<ModelType> NON_LEGACY_PTERANODON = COAT_TYPE_TAGS.register("non_legacy/pteranodon");
    public static final TagKey<ModelType> SMILODON = COAT_TYPE_TAGS.register("smilodon");
    public static final TagKey<ModelType> NON_LEGACY_SMILODON = COAT_TYPE_TAGS.register("non_legacy/smilodon");
    public static final TagKey<ModelType> SPINOSAURUS = COAT_TYPE_TAGS.register("spinosaurus");
    public static final TagKey<ModelType> STEGOSAURUS = COAT_TYPE_TAGS.register("stegosaurus");
    public static final TagKey<ModelType> NON_LEGACY_STEGOSAURUS = COAT_TYPE_TAGS.register("non_legacy/stegosaurus");
    public static final TagKey<ModelType> THERIZINOSAURUS = COAT_TYPE_TAGS.register("therizinosaurus");
    public static final TagKey<ModelType> NON_LEGACY_THERIZINOSAURUS = COAT_TYPE_TAGS.register("non_legacy/therizinosaurus");
    public static final TagKey<ModelType> TRICERATOPS = COAT_TYPE_TAGS.register("triceratops");
    public static final TagKey<ModelType> NON_LEGACY_TRICERATOPS = COAT_TYPE_TAGS.register("non_legacy/triceratops");
    public static final TagKey<ModelType> TYRANNOSAURUS = COAT_TYPE_TAGS.register("tyrannosaurus");
    public static final TagKey<ModelType> NON_LEGACY_TYRANNOSAURUS = COAT_TYPE_TAGS.register("non_legacy/tyrannosaurus");
    public static final TagKey<ModelType> VELOCIRAPTOR = COAT_TYPE_TAGS.register("velociraptor");
    public static final TagKey<ModelType> LEGACY_VELOCIRAPTOR = COAT_TYPE_TAGS.register("legacy_velociraptor");
    public static final TagKey<ModelType> NON_LEGACY_VELOCIRAPTOR = COAT_TYPE_TAGS.register("non_legacy/velociraptor");
}
