package willatendo.fossilslegacy.client.model;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.world.entity.Entity;
import willatendo.fossilslegacy.api.client.ModelIdentifierRegistry;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyModelIdentifiers {
    private static <T extends Entity> void register(String id, ModelIdentifierRegistry.ModelProvider<T> modelProvider, ModelLayerLocation modelLayerLocation) {
        ModelIdentifierRegistry.register(FossilsLegacyUtils.resource(id), modelProvider, modelLayerLocation);
    }

    public static void init() {
        /*FossilsLegacyModelIdentifiers.register("brachiosaurus", BrachiosaurusModel::new, FossilsLegacyModelLayers.BRACHIOSAURUS.getFirst());
        FossilsLegacyModelIdentifiers.register("legacy_brachiosaurus", LegacyBrachiosaurusModel::new, FossilsLegacyModelLayers.BRACHIOSAURUS.getSecond());
        FossilsLegacyModelIdentifiers.register("carnotaurus", CarnotaurusModel::new, FossilsLegacyModelLayers.CARNOTAURUS);
        FossilsLegacyModelIdentifiers.register("compsognathus", CompsognathusModel::new, FossilsLegacyModelLayers.COMPSOGNATHUS);
        FossilsLegacyModelIdentifiers.register("cryolophosaurus", CryolophosaurusModel::new, FossilsLegacyModelLayers.CRYOLOPHOSAURUS);
        FossilsLegacyModelIdentifiers.register("dilophosaurus", DilophosaurusModel::new, FossilsLegacyModelLayers.DILOPHOSAURUS);
        FossilsLegacyModelIdentifiers.register("dodo", DodoModel::new, FossilsLegacyModelLayers.DODO);
        FossilsLegacyModelIdentifiers.register("futabasaurus", FutabasaurusModel::new, FossilsLegacyModelLayers.FUTABASAURUS.getFirst());
        FossilsLegacyModelIdentifiers.register("legacy_futabasaurus", LegacyFutabasaurusModel::new, FossilsLegacyModelLayers.FUTABASAURUS.getSecond());
        FossilsLegacyModelIdentifiers.register("mammoth", MammothModel::new, FossilsLegacyModelLayers.MAMMOTH);
        FossilsLegacyModelIdentifiers.register("mosasaurus", MosasaurusModel::new, FossilsLegacyModelLayers.MOSASAURUS);
        FossilsLegacyModelIdentifiers.register("pachycephalosaurus", PachycephalosaurusModel::new, FossilsLegacyModelLayers.PACHYCEPHALOSAURUS);
        FossilsLegacyModelIdentifiers.register("pteranodon", GroundPteranodonModel::new, FossilsLegacyModelLayers.PTERANODON_GROUND);
        FossilsLegacyModelIdentifiers.register("flying_pteranodon", FlyingPteranodonModel::new, FossilsLegacyModelLayers.PTERANODON_FLYING);
        FossilsLegacyModelIdentifiers.register("landing_pteranodon", LandingPteranodonModel::new, FossilsLegacyModelLayers.PTERANODON_LANDING);
        FossilsLegacyModelIdentifiers.register("smilodon", SmilodonModel::new, FossilsLegacyModelLayers.SMILODON);
        FossilsLegacyModelIdentifiers.register("stegosaurus", StegosaurusModel::new, FossilsLegacyModelLayers.STEGOSAURUS);
        FossilsLegacyModelIdentifiers.register("therizinosaurus", TherizinosaurusModel::new, FossilsLegacyModelLayers.THERIZINOSAURUS);
        FossilsLegacyModelIdentifiers.register("triceratops", TriceratopsModel::new, FossilsLegacyModelLayers.TRICERATOPS.getFirst());
        FossilsLegacyModelIdentifiers.register("legacy_triceratops", LegacyTriceratopsModel::new, FossilsLegacyModelLayers.TRICERATOPS.getSecond());
        FossilsLegacyModelIdentifiers.register("tyrannosaurus", TyrannosaurusModel::new, FossilsLegacyModelLayers.TYRANNOSAURUS);
        FossilsLegacyModelIdentifiers.register("knocked_out_tyrannosaurus", KnockedOutTyrannosaurusModel::new, FossilsLegacyModelLayers.TYRANNOSAURUS_KNOCKED_OUT);
        FossilsLegacyModelIdentifiers.register("velociraptor", VelociraptorModel::new, FossilsLegacyModelLayers.VELOCIRAPTOR.getFirst());
        FossilsLegacyModelIdentifiers.register("legacy_velociraptor", LegacyVelociraptorModel::new, FossilsLegacyModelLayers.VELOCIRAPTOR.getSecond());*/
    }
}
