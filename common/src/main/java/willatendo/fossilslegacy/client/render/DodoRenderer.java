package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.server.entity.Dodo;

public class DodoRenderer extends CoatTypeMobRenderer<Dodo> {
    public DodoRenderer(EntityRendererProvider.Context context) {
        super(context, 0.15F);
    }

    @Override
    protected void scale(Dodo dodo, PoseStack poseStack, float f) {
        if (dodo.isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        }
        super.scale(dodo, poseStack, f);
    }
}
