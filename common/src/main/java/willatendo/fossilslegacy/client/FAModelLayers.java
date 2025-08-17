package willatendo.fossilslegacy.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FAModelLayers {
    public static final ModelLayerLocation ANIMAL_FETUS = FAModelLayers.create("animal_fetus");
    public static final ModelLayerLocation ARAUCARIA_BOAT = FAModelLayers.create("boat/araucaria");
    public static final ModelLayerLocation ARAUCARIA_CHEST_BOAT = FAModelLayers.create("chest_boat/araucaria");
    public static final ModelLayerLocation ARAUCARIOXYLON_BOAT = FAModelLayers.create("boat/araucarioxylon");
    public static final ModelLayerLocation ARAUCARIOXYLON_CHEST_BOAT = FAModelLayers.create("chest_boat/araucarioxylon");
    public static final ModelLayerLocation ARCHAEOPTERIS_BOAT = FAModelLayers.create("boat/archaeopteris");
    public static final ModelLayerLocation ARCHAEOPTERIS_CHEST_BOAT = FAModelLayers.create("chest_boat/archaeopteris");
    public static final ModelLayerLocation ANU = FAModelLayers.create("anu");
    public static final ModelLayerLocation CALAMITES_BOAT = FAModelLayers.create("boat/calamites");
    public static final ModelLayerLocation CALAMITES_CHEST_BOAT = FAModelLayers.create("chest_boat/calamites");
    public static final ModelLayerLocation CORDAITES_BOAT = FAModelLayers.create("boat/cordaites");
    public static final ModelLayerLocation CORDAITES_CHEST_BOAT = FAModelLayers.create("chest_boat/cordaites");
    public static final ModelLayerLocation GINKGO_BOAT = FAModelLayers.create("boat/ginkgo");
    public static final ModelLayerLocation GINKGO_CHEST_BOAT = FAModelLayers.create("chest_boat/ginkgo");
    public static final ModelLayerLocation FAILURESAURUS = FAModelLayers.create("failuresaurus");
    public static final ModelLayerLocation JEEP = FAModelLayers.create("jeep");
    public static final ModelLayerLocation LEPIDODENDRON_BOAT = FAModelLayers.create("boat/lepidodendron");
    public static final ModelLayerLocation LEPIDODENDRON_CHEST_BOAT = FAModelLayers.create("chest_boat/lepidodendron");
    public static final ModelLayerLocation METASEQUOIA_BOAT = FAModelLayers.create("boat/metasequoia");
    public static final ModelLayerLocation METASEQUOIA_CHEST_BOAT = FAModelLayers.create("chest_boat/metasequoia");
    public static final ModelLayerLocation NAUTILUS = FAModelLayers.create("nautilus");
    public static final ModelLayerLocation PLANT_EMBRYO = FAModelLayers.create("plant_embryo");
    public static final ModelLayerLocation REGULAR_EGG = FAModelLayers.create("regular_egg");
    public static final ModelLayerLocation SIGILLARIA_BOAT = FAModelLayers.create("boat/sigillaria");
    public static final ModelLayerLocation SIGILLARIA_CHEST_BOAT = FAModelLayers.create("chest_boat/sigillaria");
    public static final ModelLayerLocation SMALL_EGG = FAModelLayers.create("small_egg");
    public static final ModelLayerLocation THROWN_JAVELIN = FAModelLayers.create("thrown_javelin");
    public static final ModelLayerLocation TIME_MACHINE_CLOCK = FAModelLayers.create("time_machine_clock");
    public static final ModelLayerLocation WOLLEMIA_BOAT = FAModelLayers.create("boat/wollemia");
    public static final ModelLayerLocation WOLLEMIA_CHEST_BOAT = FAModelLayers.create("chest_boat/wollemia");

    public static final ModelLayerLocation ANKYLOSAURUS_HEAD = FAModelLayers.create("ankylosaurus_head");
    public static final ModelLayerLocation BARYONYX_HEAD = FAModelLayers.create("baryonyx_head");
    public static final ModelLayerLocation BRACHIOSAURUS_HEAD = FAModelLayers.create("brachiosaurus_head");
    public static final ModelLayerLocation CARNOTAURUS_HEAD = FAModelLayers.create("carnotaurus_head");
    public static final ModelLayerLocation COMPSOGNATHUS_HEAD = FAModelLayers.create("compsognathus_head");
    public static final ModelLayerLocation CRYOLOPHOSAURUS_HEAD = FAModelLayers.create("cryolophosaurus_head");
    public static final ModelLayerLocation DILOPHOSAURUS_HEAD = FAModelLayers.create("dilophosaurus_head");
    public static final ModelLayerLocation DIMETRODON_HEAD = FAModelLayers.create("dimetrodon_head");
    public static final ModelLayerLocation DISTORTUS_REX_HEAD = FAModelLayers.create("distortus_rex_head");
    public static final ModelLayerLocation DODO_HEAD = FAModelLayers.create("dodo_head");
    public static final ModelLayerLocation DRYOSAURUS_HEAD = FAModelLayers.create("dryosaurus_head");
    public static final ModelLayerLocation ELASMOTHERIUM_HEAD = FAModelLayers.create("elasmotherium_head");
    public static final ModelLayerLocation FUTABASAURUS_HEAD = FAModelLayers.create("futabasaurus_head");
    public static final ModelLayerLocation GALLIMIMUS_HEAD = FAModelLayers.create("gallimimus_head");
    public static final ModelLayerLocation ICHTHYOSAURUS_HEAD = FAModelLayers.create("ichthyosaurus_head");
    public static final ModelLayerLocation MAMMOTH_HEAD = FAModelLayers.create("mammoth_head");
    public static final ModelLayerLocation MOA_HEAD = FAModelLayers.create("moa_head");
    public static final ModelLayerLocation MOSASAURUS_HEAD = FAModelLayers.create("mosasaurus_head");
    public static final ModelLayerLocation PACHYCEPHALOSAURUS_HEAD = FAModelLayers.create("pachycephalosaurus_head");
    public static final ModelLayerLocation PTERANODON_HEAD = FAModelLayers.create("pteranodon_head");
    public static final ModelLayerLocation SMILODON_HEAD = FAModelLayers.create("smilodon_head");
    public static final ModelLayerLocation SPINOSAURUS_HEAD = FAModelLayers.create("spinosaurus_head");
    public static final ModelLayerLocation STEGOSAURUS_HEAD = FAModelLayers.create("stegosaurus_head");
    public static final ModelLayerLocation THERIZINOSAURUS_HEAD = FAModelLayers.create("therizinosaurus_head");
    public static final ModelLayerLocation TRICERATOPS_HEAD = FAModelLayers.create("triceratops_head");
    public static final ModelLayerLocation TYRANNOSAURUS_HEAD = FAModelLayers.create("tyrannosaurus_head");
    public static final ModelLayerLocation VELOCIRAPTOR_HEAD = FAModelLayers.create("velociraptor_head");

    private static ModelLayerLocation create(String layerName) {
        return FAModelLayers.create(layerName, "main");
    }

    private static ModelLayerLocation create(String layerName, String layer) {
        return new ModelLayerLocation(FAUtils.resource(layerName), layer);
    }
}
