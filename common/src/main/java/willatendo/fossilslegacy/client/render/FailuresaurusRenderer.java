package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FAModelLayers;
import willatendo.fossilslegacy.client.model.FailuresaurusModel;
import willatendo.fossilslegacy.server.entity.entities.Failuresaurus;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class FailuresaurusRenderer extends MobRenderer<Failuresaurus, LivingEntityRenderState, FailuresaurusModel> {
    public static final ResourceLocation TEXTURE = FAUtils.resource("textures/entity/failuresaurus.png");

    public FailuresaurusRenderer(Context context) {
        super(context, new FailuresaurusModel(context.bakeLayer(FAModelLayers.FAILURESAURUS)), 0.5F);
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    public ResourceLocation getTextureLocation(LivingEntityRenderState livingEntityRenderState) {
        return TEXTURE;
    }
}
