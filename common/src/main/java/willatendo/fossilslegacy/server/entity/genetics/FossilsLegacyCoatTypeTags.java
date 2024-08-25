package willatendo.fossilslegacy.server.entity.genetics;

import net.minecraft.tags.TagKey;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FossilsLegacyCoatTypeTags {
    public static final TagRegister<CoatType> COAT_TYPE_TAGS = TagRegister.create(FossilsLegacyRegistries.COAT_TYPES, FossilsLegacyUtils.ID);

    public static final TagKey<CoatType> BRACHIOSAURUS = COAT_TYPE_TAGS.register("brachiosaurus");
    public static final TagKey<CoatType> CARNOTAURUS = COAT_TYPE_TAGS.register("carnotaurus");
    public static final TagKey<CoatType> COMPSOGNATHUS = COAT_TYPE_TAGS.register("compsognathus");
    public static final TagKey<CoatType> CRYOLOPHOSAURUS = COAT_TYPE_TAGS.register("cryolophosaurus");
    public static final TagKey<CoatType> DILOPHOSAURUS = COAT_TYPE_TAGS.register("dilophosaurus");
    public static final TagKey<CoatType> DODO = COAT_TYPE_TAGS.register("dodo");
    public static final TagKey<CoatType> FUTABASAURUS = COAT_TYPE_TAGS.register("futabasaurus");
    public static final TagKey<CoatType> MAMMOTH = COAT_TYPE_TAGS.register("mammoth");
    public static final TagKey<CoatType> MOSASAURUS = COAT_TYPE_TAGS.register("mosasaurus");
    public static final TagKey<CoatType> PACHYCEPHALOSAURUS = COAT_TYPE_TAGS.register("pachycephalosaurus");
    public static final TagKey<CoatType> PTERANODON = COAT_TYPE_TAGS.register("pteranodon");
    public static final TagKey<CoatType> SMILODON = COAT_TYPE_TAGS.register("smilodon");
    public static final TagKey<CoatType> STEGOSAURUS = COAT_TYPE_TAGS.register("stegosaurus");
    public static final TagKey<CoatType> THERIZINOSAURUS = COAT_TYPE_TAGS.register("therizinosaurus");
    public static final TagKey<CoatType> TRICERATOPS = COAT_TYPE_TAGS.register("triceratops");
    public static final TagKey<CoatType> TYRANNOSAURUS = COAT_TYPE_TAGS.register("tyrannosaurus");
    public static final TagKey<CoatType> VELOCIRAPTOR = COAT_TYPE_TAGS.register("velociraptor");
}
