package willatendo.fossilslegacy.server.tags;

import net.minecraft.tags.TagKey;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FACoatTypeTags {
    private static final TagRegister<CoatType> COAT_TYPE_TAGS = TagRegister.create(FARegistries.COAT_TYPES, FossilsLegacyUtils.ID);

    public static final TagKey<CoatType> ANKYLOSAURUS = COAT_TYPE_TAGS.register("ankylosaurus");
    public static final TagKey<CoatType> BRACHIOSAURUS = COAT_TYPE_TAGS.register("brachiosaurus");
    public static final TagKey<CoatType> NON_LEGACY_BRACHIOSAURUS = COAT_TYPE_TAGS.register("non_legacy/brachiosaurus");
    public static final TagKey<CoatType> CARNOTAURUS = COAT_TYPE_TAGS.register("carnotaurus");
    public static final TagKey<CoatType> NON_LEGACY_CARNOTAURUS = COAT_TYPE_TAGS.register("non_legacy/carnotaurus");
    public static final TagKey<CoatType> COMPSOGNATHUS = COAT_TYPE_TAGS.register("compsognathus");
    public static final TagKey<CoatType> CRYOLOPHOSAURUS = COAT_TYPE_TAGS.register("cryolophosaurus");
    public static final TagKey<CoatType> NON_LEGACY_CRYOLOPHOSAURUS = COAT_TYPE_TAGS.register("non_legacy/cryolophosaurus");
    public static final TagKey<CoatType> DILOPHOSAURUS = COAT_TYPE_TAGS.register("dilophosaurus");
    public static final TagKey<CoatType> NON_LEGACY_DILOPHOSAURUS = COAT_TYPE_TAGS.register("non_legacy/dilophosaurus");
    public static final TagKey<CoatType> DIMETRODON = COAT_TYPE_TAGS.register("dimetrodon");
    public static final TagKey<CoatType> DODO = COAT_TYPE_TAGS.register("dodo");
    public static final TagKey<CoatType> FUTABASAURUS = COAT_TYPE_TAGS.register("futabasaurus");
    public static final TagKey<CoatType> NON_LEGACY_FUTABASAURUS = COAT_TYPE_TAGS.register("non_legacy/futabasaurus");
    public static final TagKey<CoatType> GALLIMIMUS = COAT_TYPE_TAGS.register("gallimimus");
    public static final TagKey<CoatType> LEGACY = COAT_TYPE_TAGS.register("legacy");
    public static final TagKey<CoatType> MAMMOTH = COAT_TYPE_TAGS.register("mammoth");
    public static final TagKey<CoatType> NON_LEGACY_MAMMOTH = COAT_TYPE_TAGS.register("non_legacy/mammoth");
    public static final TagKey<CoatType> MOA = COAT_TYPE_TAGS.register("moa");
    public static final TagKey<CoatType> MOSASAURUS = COAT_TYPE_TAGS.register("mosasaurus");
    public static final TagKey<CoatType> NON_LEGACY_MOSASAURUS = COAT_TYPE_TAGS.register("non_legacy/mosasaurus");
    public static final TagKey<CoatType> PACHYCEPHALOSAURUS = COAT_TYPE_TAGS.register("pachycephalosaurus");
    public static final TagKey<CoatType> PTERANODON = COAT_TYPE_TAGS.register("pteranodon");
    public static final TagKey<CoatType> NON_LEGACY_PTERANODON = COAT_TYPE_TAGS.register("non_legacy/pteranodon");
    public static final TagKey<CoatType> SMILODON = COAT_TYPE_TAGS.register("smilodon");
    public static final TagKey<CoatType> NON_LEGACY_SMILODON = COAT_TYPE_TAGS.register("non_legacy/smilodon");
    public static final TagKey<CoatType> SPINOSAURUS = COAT_TYPE_TAGS.register("spinosaurus");
    public static final TagKey<CoatType> STEGOSAURUS = COAT_TYPE_TAGS.register("stegosaurus");
    public static final TagKey<CoatType> NON_LEGACY_STEGOSAURUS = COAT_TYPE_TAGS.register("non_legacy/stegosaurus");
    public static final TagKey<CoatType> THERIZINOSAURUS = COAT_TYPE_TAGS.register("therizinosaurus");
    public static final TagKey<CoatType> NON_LEGACY_THERIZINOSAURUS = COAT_TYPE_TAGS.register("non_legacy/therizinosaurus");
    public static final TagKey<CoatType> TRICERATOPS = COAT_TYPE_TAGS.register("triceratops");
    public static final TagKey<CoatType> NON_LEGACY_TRICERATOPS = COAT_TYPE_TAGS.register("non_legacy/triceratops");
    public static final TagKey<CoatType> TYRANNOSAURUS = COAT_TYPE_TAGS.register("tyrannosaurus");
    public static final TagKey<CoatType> NON_LEGACY_TYRANNOSAURUS = COAT_TYPE_TAGS.register("non_legacy/tyrannosaurus");
    public static final TagKey<CoatType> VELOCIRAPTOR = COAT_TYPE_TAGS.register("velociraptor");
    public static final TagKey<CoatType> LEGACY_VELOCIRAPTOR = COAT_TYPE_TAGS.register("legacy_velociraptor");
    public static final TagKey<CoatType> NON_LEGACY_VELOCIRAPTOR = COAT_TYPE_TAGS.register("non_legacy/velociraptor");
}
