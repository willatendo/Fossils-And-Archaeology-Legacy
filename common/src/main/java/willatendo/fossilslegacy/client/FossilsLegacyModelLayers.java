package willatendo.fossilslegacy.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import willatendo.fossilslegacy.server.entity.variants.BoatType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyModelLayers {
    public static final ModelLayerLocation BRACHIOSAURUS = new ModelLayerLocation(FossilsLegacyUtils.resource("brachiosaurus"), "main");
    public static final ModelLayerLocation LEGACY_BRACHIOSAURUS = new ModelLayerLocation(FossilsLegacyUtils.resource("legacy_brachiosaurus"), "main");
    public static final ModelLayerLocation DILOPHOSAURUS = new ModelLayerLocation(FossilsLegacyUtils.resource("dilophosaurus"), "main");
    public static final ModelLayerLocation FUTABASAURUS = new ModelLayerLocation(FossilsLegacyUtils.resource("futabasaurus"), "main");
    public static final ModelLayerLocation LEGACY_FUTABASAURUS = new ModelLayerLocation(FossilsLegacyUtils.resource("legacy_futabasaurus"), "main");
    public static final ModelLayerLocation MAMMOTH = new ModelLayerLocation(FossilsLegacyUtils.resource("mammoth"), "main");
    public static final ModelLayerLocation MOSASAURUS = new ModelLayerLocation(FossilsLegacyUtils.resource("mosasaurus"), "main");
    public static final ModelLayerLocation NAUTILUS = new ModelLayerLocation(FossilsLegacyUtils.resource("nautilus"), "main");
    public static final ModelLayerLocation GROUND_PTERANODON = new ModelLayerLocation(FossilsLegacyUtils.resource("ground_pteranodon"), "main");
    public static final ModelLayerLocation FLYING_PTERANODON = new ModelLayerLocation(FossilsLegacyUtils.resource("flying_pteranodon"), "main");
    public static final ModelLayerLocation LANDING_PTERANODON = new ModelLayerLocation(FossilsLegacyUtils.resource("landing_pteranodon"), "main");
    public static final ModelLayerLocation SMILODON = new ModelLayerLocation(FossilsLegacyUtils.resource("smilodon"), "main");
    public static final ModelLayerLocation STEGOSAURUS = new ModelLayerLocation(FossilsLegacyUtils.resource("stegosaurus"), "main");
    public static final ModelLayerLocation TRICERATOPS = new ModelLayerLocation(FossilsLegacyUtils.resource("triceratops"), "main");
    public static final ModelLayerLocation TYRANNOSAURUS = new ModelLayerLocation(FossilsLegacyUtils.resource("tyrannosaurus"), "main");
    public static final ModelLayerLocation KNOCKED_OUT_TYRANNOSAURUS = new ModelLayerLocation(FossilsLegacyUtils.resource("knocked_out_tyrannosaurus"), "main");
    public static final ModelLayerLocation VELOCIRAPTOR = new ModelLayerLocation(FossilsLegacyUtils.resource("velociraptor"), "main");
    public static final ModelLayerLocation LEGACY_VELOCIRAPTOR = new ModelLayerLocation(FossilsLegacyUtils.resource("legacy_velociraptor"), "main");
    public static final ModelLayerLocation CARNOTAURUS = new ModelLayerLocation(FossilsLegacyUtils.resource("carnotaurus"), "main");
    public static final ModelLayerLocation CRYOLOPHOSAURUS = new ModelLayerLocation(FossilsLegacyUtils.resource("cryolophosaurus"), "main");
    public static final ModelLayerLocation THERIZINOSAURUS = new ModelLayerLocation(FossilsLegacyUtils.resource("therizinosaurus"), "main");
    public static final ModelLayerLocation PACHYCEPHALOSAURUS = new ModelLayerLocation(FossilsLegacyUtils.resource("pachycephalosaurus"), "main");
    public static final ModelLayerLocation COMPSOGNATHUS = new ModelLayerLocation(FossilsLegacyUtils.resource("compsognathus"), "main");

    public static final ModelLayerLocation BRACHIOSAURUS_SKELETON = new ModelLayerLocation(FossilsLegacyUtils.resource("brachiosaurs_skeleton"), "main");
    public static final ModelLayerLocation COMPSOGNATHUS_SKELETON = new ModelLayerLocation(FossilsLegacyUtils.resource("compsognathus_skeleton"), "main");
    public static final ModelLayerLocation FUTABASAURUS_SKELETON = new ModelLayerLocation(FossilsLegacyUtils.resource("futabasaurus_skeleton"), "main");
    public static final ModelLayerLocation LEGACY_FUTABASAURUS_SKELETON = new ModelLayerLocation(FossilsLegacyUtils.resource("legacy_futabasaurus_skeleton"), "main");
    public static final ModelLayerLocation PTERANODON_SKELETON = new ModelLayerLocation(FossilsLegacyUtils.resource("pteranodon_skeleton"), "main");
    public static final ModelLayerLocation PACHYCEPHALOSAURUS_SKELETON = new ModelLayerLocation(FossilsLegacyUtils.resource("pachycephalosaurus_skeleton"), "main");
    public static final ModelLayerLocation TRICERATOPS_SKELETON = new ModelLayerLocation(FossilsLegacyUtils.resource("triceratops_skeleton"), "main");
    public static final ModelLayerLocation VELOCIRAPTOR_SKELETON = new ModelLayerLocation(FossilsLegacyUtils.resource("velociraptor_skeleton"), "main");

    public static final ModelLayerLocation ANU = new ModelLayerLocation(FossilsLegacyUtils.resource("anu"), "main");
    public static final ModelLayerLocation FAILURESAURUS = new ModelLayerLocation(FossilsLegacyUtils.resource("failuresaurus"), "main");

    public static final ModelLayerLocation EGG = new ModelLayerLocation(FossilsLegacyUtils.resource("egg"), "main");

    public static final ModelLayerLocation TIME_MACHINE_CLOCK = new ModelLayerLocation(FossilsLegacyUtils.resource("time_machine_clock"), "main");

    public static ModelLayerLocation createBoatModelName(BoatType boatType) {
        return new ModelLayerLocation(FossilsLegacyUtils.resource("boat/" + boatType.name()), "main");
    }

    public static ModelLayerLocation createChestBoatModelName(BoatType boatType) {
        return new ModelLayerLocation(FossilsLegacyUtils.resource("chest_boat/" + boatType.name()), "main");
    }
}
