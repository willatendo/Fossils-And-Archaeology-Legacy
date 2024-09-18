package willatendo.fossilslegacy.client.model.json;

import com.google.common.collect.Maps;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;

import java.util.Map;

public class JsonLayerDefinitionResourceManager implements ResourceManagerReloadListener {
    private Map<ModelLayerLocation, LayerDefinition> modelParts = Maps.newHashMap();
    public static final JsonLayerDefinitionResourceManager INSTANCE = new JsonLayerDefinitionResourceManager();

    public ModelPart bakeLayer(ModelLayerLocation modelLayerLocation) {
        LayerDefinition layerdefinition = modelParts.get(modelLayerLocation);
        if (layerdefinition == null) {
            throw new IllegalArgumentException("No model for layer " + modelLayerLocation);
        } else {
            return layerdefinition.bakeRoot();
        }
    }

    @Override
    public void onResourceManagerReload(ResourceManager resourceManager) {
        JsonModelLoader.getModels().forEach((modelLayerLocation, layerDefinition) -> this.modelParts.put(modelLayerLocation, layerDefinition));
    }
}
