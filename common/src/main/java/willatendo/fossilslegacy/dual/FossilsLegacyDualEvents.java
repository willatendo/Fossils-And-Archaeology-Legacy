package willatendo.fossilslegacy.dual;

import willatendo.fossilslegacy.client.model.json.JsonAnimationLoader;
import willatendo.fossilslegacy.client.model.json.JsonLayerDefinitionResourceManager;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.client.resources.StoneTabletTextureManager;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.event.registry.ClientReloadListenerRegister;

public class FossilsLegacyDualEvents {
    public static void clientReloadListenersEvent(ClientReloadListenerRegister clientReloadListenerRegister) {
        clientReloadListenerRegister.register(FossilsLegacyUtils.resource("stone_table_texture_manager"), StoneTabletTextureManager.INSTANCE);
        clientReloadListenerRegister.register(FossilsLegacyUtils.resource("json_models_loader"), JsonModelLoader.INSTANCE);
        clientReloadListenerRegister.register(FossilsLegacyUtils.resource("json_animations_loader"), JsonAnimationLoader.INSTANCE);
        clientReloadListenerRegister.register(FossilsLegacyUtils.resource("json_layers_loader"), JsonLayerDefinitionResourceManager.INSTANCE);
    }
}
