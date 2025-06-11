package willatendo.fossilslegacy.dual;

import willatendo.fossilslegacy.client.animation.json.JsonAnimationLoader;
import willatendo.fossilslegacy.client.model.json.JsonLayerDefinitionResourceManager;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.client.resources.DecorationPlaqueTextureManager;
import willatendo.fossilslegacy.client.resources.StoneTabletTextureManager;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.event.registry.ClientReloadListenerRegister;

public class FossilsLegacyDualEvents {
    public static void clientReloadListenersEvent(ClientReloadListenerRegister clientReloadListenerRegister) {
        clientReloadListenerRegister.register(FAUtils.resource("decoration_plaque_texture_manager"), DecorationPlaqueTextureManager.INSTANCE);
        clientReloadListenerRegister.register(FAUtils.resource("stone_table_texture_manager"), StoneTabletTextureManager.INSTANCE);
        clientReloadListenerRegister.register(FAUtils.resource("json_models_loader"), JsonModelLoader.INSTANCE);
        clientReloadListenerRegister.register(FAUtils.resource("json_animations_loader"), JsonAnimationLoader.INSTANCE);
        clientReloadListenerRegister.register(FAUtils.resource("json_layers_loader"), JsonLayerDefinitionResourceManager.INSTANCE);
    }
}
