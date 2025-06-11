package willatendo.fossilslegacy.client.render;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FAModelLayers;
import willatendo.fossilslegacy.client.model.EggModel;
import willatendo.fossilslegacy.client.state.EggRenderState;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class EggRenderer extends MobRenderer<Egg, EggRenderState, EggModel> {
    private final ResourceLocation texture;

    public EggRenderer(Context context, ModelLayerLocation modelLayerLocation, ResourceLocation texture) {
        super(context, null, 0.3F);
        this.model = new EggModel(context.bakeLayer(modelLayerLocation));
        this.texture = texture;
    }

    public static EggRenderer regular(Context context, String texture) {
        return new EggRenderer(context, FAModelLayers.REGULAR_EGG, FAUtils.resource("textures/entity/egg/" + texture + ".png"));
    }

    public static EggRenderer small(Context context, String texture) {
        return new EggRenderer(context, FAModelLayers.SMALL_EGG, FAUtils.resource("textures/entity/egg/" + texture + ".png"));
    }

    @Override
    public EggRenderState createRenderState() {
        return new EggRenderState();
    }

    @Override
    public ResourceLocation getTextureLocation(EggRenderState eggRenderState) {
        return this.texture;
    }
}
