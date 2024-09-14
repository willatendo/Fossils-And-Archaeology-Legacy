package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.DodoModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.Dodo;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class DodoRenderer extends MobRenderer<Dinosaur, DodoModel> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entity/dodo/dodo.png");

    public DodoRenderer(EntityRendererProvider.Context context) {
        super(context, new DodoModel(context.bakeLayer(FossilsLegacyModelLayers.DODO)), 0.15F);
    }

    @Override
    protected void scale(Dinosaur dinosaur, PoseStack poseStack, float f) {
        if (dinosaur.isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        }
        super.scale(dinosaur, poseStack, f);
    }

    @Override
    public ResourceLocation getTextureLocation(Dinosaur dinosaur) {
        return TEXTURE;
    }
}
