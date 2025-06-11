package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FAModelLayers;
import willatendo.fossilslegacy.client.model.AnuModel;
import willatendo.fossilslegacy.client.render.layer.AnuOverlayLayer;
import willatendo.fossilslegacy.client.state.AnuRenderState;
import willatendo.fossilslegacy.server.entity.entities.Anu;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class AnuRenderer extends HumanoidMobRenderer<Anu, AnuRenderState, AnuModel> {
    public static final ResourceLocation TEXTURE = FAUtils.resource("textures/entity/anu/anu.png");
    public static final ResourceLocation CHARGING = FAUtils.resource("textures/entity/anu/anu_charging.png");

    public AnuRenderer(Context context) {
        super(context, new AnuModel(context.bakeLayer(FAModelLayers.ANU)), 0.3F);
        this.addLayer(new AnuOverlayLayer(this));
    }

    @Override
    public AnuRenderState createRenderState() {
        return new AnuRenderState();
    }

    @Override
    public void extractRenderState(Anu anu, AnuRenderState anuRenderState, float partialTicks) {
        super.extractRenderState(anu, anuRenderState, partialTicks);
        anuRenderState.isCharging = anu.isCharging();
    }

    @Override
    public ResourceLocation getTextureLocation(AnuRenderState anuRenderState) {
        return anuRenderState.isCharging ? CHARGING : TEXTURE;
    }
}
