package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FAModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.NautilusModel;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Nautilus;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class NautilusRenderer extends MobRenderer<Nautilus, LivingEntityRenderState, NautilusModel> {
    public static final ResourceLocation TEXTURE = FAUtils.resource("textures/entity/nautilus/nautilus.png");

    public NautilusRenderer(Context context) {
        super(context, new NautilusModel(context.bakeLayer(FAModelLayers.NAUTILUS)), 0.5F);
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