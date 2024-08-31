package willatendo.fossilslegacy.client.model;

import com.google.common.collect.Maps;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.*;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.*;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.tyrannosaurus.TyrannosaurusModel;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.Map;
import java.util.function.Function;

public class ModelRegistry {
    private static final Map<ResourceLocation, ModelProvider<? extends Entity>> ENTITY_MODELS = Maps.newHashMap();
    private static final Map<ResourceLocation, ModelLayerLocation> MODEL_LAYERS = Maps.newHashMap();

    public static Map<ResourceLocation, EntityModel<? extends Entity>> registerAllModels(Function<ModelLayerLocation, ModelPart> root) {
        Map<ResourceLocation, EntityModel<? extends Entity>> maps = Maps.newHashMap();
        ENTITY_MODELS.forEach(((resourceLocation, modelProvider) -> {
            EntityModel<? extends Entity> entityModel = modelProvider.create(root.apply(MODEL_LAYERS.get(resourceLocation)));
            maps.put(resourceLocation, entityModel);
        }));
        return maps;
    }

    public static <T extends Entity> ModelProvider<T> getModel(ResourceLocation id) {
        return (ModelProvider<T>) ENTITY_MODELS.get(id);
    }

    public static <T extends Entity> void register(ResourceLocation id, ModelProvider<T> modelProvider, ModelLayerLocation modelLayerLocation) {
        ENTITY_MODELS.put(id, modelProvider);
        MODEL_LAYERS.put(id, modelLayerLocation);
    }

    private static <T extends Entity> void register(String id, ModelProvider<T> modelProvider, ModelLayerLocation modelLayerLocation) {
        ModelRegistry.register(FossilsLegacyUtils.resource(id), modelProvider, modelLayerLocation);
    }

    public static void init() {
        ModelRegistry.register("brachiosaurus", BrachiosaurusModel::new, FossilsLegacyModelLayers.BRACHIOSAURUS.getFirst());
        ModelRegistry.register("legacy_brachiosaurus", LegacyBrachiosaurusModel::new, FossilsLegacyModelLayers.BRACHIOSAURUS.getSecond());
        ModelRegistry.register("dilophosaurus", DilophosaurusModel::new, FossilsLegacyModelLayers.DILOPHOSAURUS);
        ModelRegistry.register("dodo", DodoModel::new, FossilsLegacyModelLayers.DODO);
        ModelRegistry.register("mammoth", MammothModel::new, FossilsLegacyModelLayers.MAMMOTH);
        ModelRegistry.register("mosasaurus", MosasaurusModel::new, FossilsLegacyModelLayers.MOSASAURUS);
        ModelRegistry.register("futabasaurus", FutabasaurusModel::new, FossilsLegacyModelLayers.FUTABASAURUS.getFirst());
        ModelRegistry.register("legacy_futabasaurus", LegacyFutabasaurusModel::new, FossilsLegacyModelLayers.FUTABASAURUS.getSecond());
        ModelRegistry.register("smilodon", SmilodonModel::new, FossilsLegacyModelLayers.SMILODON);
        ModelRegistry.register("stegosaurus", StegosaurusModel::new, FossilsLegacyModelLayers.STEGOSAURUS);
        ModelRegistry.register("triceratops", TriceratopsModel::new, FossilsLegacyModelLayers.TRICERATOPS.getFirst());
        ModelRegistry.register("legacy_triceratops", LegacyTriceratopsModel::new, FossilsLegacyModelLayers.TRICERATOPS.getSecond());
        ModelRegistry.register("tyrannosaurus", TyrannosaurusModel::new, FossilsLegacyModelLayers.TYRANNOSAURUS);
        ModelRegistry.register("velociraptor", VelociraptorModel::new, FossilsLegacyModelLayers.VELOCIRAPTOR.getFirst());
        ModelRegistry.register("legacy_velociraptor", LegacyVelociraptorModel::new, FossilsLegacyModelLayers.VELOCIRAPTOR.getSecond());
        ModelRegistry.register("carnotaurus", CarnotaurusModel::new, FossilsLegacyModelLayers.CARNOTAURUS);
        ModelRegistry.register("cryolophosaurus", CryolophosaurusModel::new, FossilsLegacyModelLayers.CRYOLOPHOSAURUS);
        ModelRegistry.register("therizinosaurus", TherizinosaurusModel::new, FossilsLegacyModelLayers.THERIZINOSAURUS);
        ModelRegistry.register("pachycephalosaurus", PachycephalosaurusModel::new, FossilsLegacyModelLayers.PACHYCEPHALOSAURUS);
        ModelRegistry.register("compsognathus", CompsognathusModel::new, FossilsLegacyModelLayers.COMPSOGNATHUS);
    }
}
