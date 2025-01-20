package willatendo.fossilslegacy.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public final class FossilsLegacyModelLayers {
    public static final ModelLayerLocation ANU = FossilsLegacyModelLayers.create("anu");
    public static final ModelLayerLocation EGG = FossilsLegacyModelLayers.create("egg");
    public static final ModelLayerLocation FAILURESAURUS = FossilsLegacyModelLayers.create("failuresaurus");
    public static final ModelLayerLocation FETUS = FossilsLegacyModelLayers.create("fetus");
    public static final ModelLayerLocation NAUTILUS = FossilsLegacyModelLayers.create("nautilus");
    public static final ModelLayerLocation TIME_MACHINE_CLOCK = FossilsLegacyModelLayers.create("time_machine_clock");

    private static ModelLayerLocation create(String layerName) {
        return FossilsLegacyModelLayers.create(layerName, "main");
    }

    private static ModelLayerLocation create(String layerName, String layer) {
        return new ModelLayerLocation(FossilsLegacyUtils.resource(layerName), layer);
    }
}
