package willatendo.fossilslegacy.client;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.geom.ModelLayerLocation;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyModelLayers {
    public static final ModelLayerLocation ANU = FossilsLegacyModelLayers.create("anu");
    public static final Pair<ModelLayerLocation, ModelLayerLocation> BRACHIOSAURUS = FossilsLegacyModelLayers.createLegacyPair("brachiosaurus");
    public static final Pair<ModelLayerLocation, ModelLayerLocation> BRACHIOSAURUS_SKELETON = FossilsLegacyModelLayers.createLegacyPair("brachiosaurs_skeleton");
    public static final ModelLayerLocation CARNOTAURUS = FossilsLegacyModelLayers.create("carnotaurus");
    public static final ModelLayerLocation COMPSOGNATHUS = FossilsLegacyModelLayers.create("compsognathus");
    public static final ModelLayerLocation COMPSOGNATHUS_SKELETON = FossilsLegacyModelLayers.create("compsognathus_skeleton");
    public static final ModelLayerLocation CRYOLOPHOSAURUS = FossilsLegacyModelLayers.create("cryolophosaurus");
    public static final ModelLayerLocation DILOPHOSAURUS = FossilsLegacyModelLayers.create("dilophosaurus");
    public static final ModelLayerLocation DODO = FossilsLegacyModelLayers.create("dodo");
    public static final ModelLayerLocation EGG = FossilsLegacyModelLayers.create("egg");
    public static final ModelLayerLocation FAILURESAURUS = FossilsLegacyModelLayers.create("failuresaurus");
    public static final Pair<ModelLayerLocation, ModelLayerLocation> FUTABASAURUS = FossilsLegacyModelLayers.createLegacyPair("futabasaurus");
    public static final Pair<ModelLayerLocation, ModelLayerLocation> FUTABASAURUS_SKELETON = FossilsLegacyModelLayers.createLegacyPair("futabasaurus_skeleton");
    public static final ModelLayerLocation MAMMOTH = FossilsLegacyModelLayers.create("mammoth");
    public static final ModelLayerLocation MOSASAURUS = FossilsLegacyModelLayers.create("mosasaurus");
    public static final ModelLayerLocation NAUTILUS = FossilsLegacyModelLayers.create("nautilus");
    public static final ModelLayerLocation PACHYCEPHALOSAURUS = FossilsLegacyModelLayers.create("pachycephalosaurus");
    public static final ModelLayerLocation PACHYCEPHALOSAURUS_SKELETON = FossilsLegacyModelLayers.create("pachycephalosaurus_skeleton");
    public static final ModelLayerLocation PTERANODON_GROUND = FossilsLegacyModelLayers.create("pteranodon_ground");
    public static final ModelLayerLocation PTERANODON_FLYING = FossilsLegacyModelLayers.create("pteranodon_flying");
    public static final ModelLayerLocation PTERANODON_LANDING = FossilsLegacyModelLayers.create("pteranodon_landing");
    public static final ModelLayerLocation PTERANODON_SKELETON = FossilsLegacyModelLayers.create("pteranodon_skeleton");
    public static final ModelLayerLocation SMILODON = FossilsLegacyModelLayers.create("smilodon");
    public static final ModelLayerLocation STEGOSAURUS = FossilsLegacyModelLayers.create("stegosaurus");
    public static final ModelLayerLocation THERIZINOSAURUS = FossilsLegacyModelLayers.create("therizinosaurus");
    public static final ModelLayerLocation TIME_MACHINE_CLOCK = FossilsLegacyModelLayers.create("time_machine_clock");
    public static final ModelLayerLocation TRICERATOPS = FossilsLegacyModelLayers.create("triceratops");
    public static final ModelLayerLocation TRICERATOPS_SKELETON = FossilsLegacyModelLayers.create("triceratops_skeleton");
    public static final ModelLayerLocation TYRANNOSAURUS = FossilsLegacyModelLayers.create("tyrannosaurus");
    public static final ModelLayerLocation TYRANNOSAURUS_KNOCKED_OUT = FossilsLegacyModelLayers.create("tyrannosaurus_knocked_out");
    public static final Pair<ModelLayerLocation, ModelLayerLocation> VELOCIRAPTOR = FossilsLegacyModelLayers.createLegacyPair("velociraptor");
    public static final ModelLayerLocation VELOCIRAPTOR_SKELETON = FossilsLegacyModelLayers.create("velociraptor_skeleton");
    
    private static Pair<ModelLayerLocation, ModelLayerLocation> createLegacyPair(String layerName) {
        return Pair.of(FossilsLegacyModelLayers.create(layerName), FossilsLegacyModelLayers.create("legacy_" + layerName));
    }

    private static ModelLayerLocation create(String layerName) {
        return FossilsLegacyModelLayers.create(layerName, "main");
    }

    private static ModelLayerLocation create(String layerName, String layer) {
        return new ModelLayerLocation(FossilsLegacyUtils.resource(layerName), layer);
    }
}
