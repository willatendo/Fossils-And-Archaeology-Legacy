package willatendo.fossilslegacy.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FAModelLayers {
    public static final ModelLayerLocation ANIMAL_FETUS = FAModelLayers.create("animal_fetus");
    public static final ModelLayerLocation ARAUCARIA_BOAT = FAModelLayers.create("boat/araucaria");
    public static final ModelLayerLocation ARAUCARIA_CHEST_BOAT = FAModelLayers.create("chest_boat/araucaria");
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
    public static final ModelLayerLocation NAUTILUS = FAModelLayers.create("nautilus");
    public static final ModelLayerLocation PLANT_EMBRYO = FAModelLayers.create("plant_embryo");
    public static final ModelLayerLocation REGULAR_EGG = FAModelLayers.create("regular_egg");
    public static final ModelLayerLocation SIGILLARIA_BOAT = FAModelLayers.create("boat/sigillaria");
    public static final ModelLayerLocation SIGILLARIA_CHEST_BOAT = FAModelLayers.create("chest_boat/sigillaria");
    public static final ModelLayerLocation SMALL_EGG = FAModelLayers.create("small_egg");
    public static final ModelLayerLocation THROWN_JAVELIN = FAModelLayers.create("thrown_javelin");
    public static final ModelLayerLocation TIME_MACHINE_CLOCK = FAModelLayers.create("time_machine_clock");

    private static ModelLayerLocation create(String layerName) {
        return FAModelLayers.create(layerName, "main");
    }

    private static ModelLayerLocation create(String layerName, String layer) {
        return new ModelLayerLocation(FAUtils.resource(layerName), layer);
    }
}
