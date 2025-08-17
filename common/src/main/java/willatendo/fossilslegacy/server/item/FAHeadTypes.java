package willatendo.fossilslegacy.server.item;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;

public enum FAHeadTypes implements StringRepresentable {
    ANKYLOSAURUS("ankylosaurus"),
    BARYONYX("baryonyx"),
    BRACHIOSAURUS("brachiosaurus"),
    CARNOTAURUS("carnotaurus"),
    COMPSOGNATHUS("compsognathus"),
    CRYOLOPHOSAURUS("cryolophosaurus"),
    DILOPHOSAURUS("dilophosaurus"),
    DIMETRODON("dimetrodon"),
    DISTORTUS_REX("distortus_rex"),
    DODO("dodo"),
    DRYOSAURUS("dryosaurus"),
    ELASMOTHERIUM("elasmotherium"),
    FUTABASAURUS("futabasaurus"),
    GALLIMIMUS("gallimimus"),
    ICHTHYOSAURUS("ichthyosaurus"),
    MAMMOTH("mammoth"),
    MOA("moa"),
    MOSASAURUS("mosasaurus"),
    PACHYCEPHALOSAURUS("pachycephalosaurus"),
    PTERANODON("pteranodon"),
    SMILODON("smilodon"),
    SPINOSAURUS("spinosaurus"),
    STEGOSAURUS("stegosaurus"),
    THERIZINOSAURUS("therizinosaurus"),
    TRICERATOPS("triceratops"),
    TYRANNOSAURUS("tyrannosaurus"),
    VELOCIRAPTOR("velociraptor");

    public static final Codec<FAHeadTypes> CODEC = StringRepresentable.fromValues(FAHeadTypes::values);

    private final String name;

    FAHeadTypes(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
