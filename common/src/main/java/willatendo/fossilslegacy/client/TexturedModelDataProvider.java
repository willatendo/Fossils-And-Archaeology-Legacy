package willatendo.fossilslegacy.client;

import net.minecraft.client.model.geom.builders.LayerDefinition;

@FunctionalInterface
public interface TexturedModelDataProvider {
    LayerDefinition createModelData();
}
