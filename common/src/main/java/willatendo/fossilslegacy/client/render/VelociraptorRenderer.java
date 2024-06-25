package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.dinosaur.VelociraptorModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.LegacyVelociraptorModel;
import willatendo.fossilslegacy.client.render.layer.VelociraptorHoldItemInMouthLayer;
import willatendo.fossilslegacy.server.entity.Velociraptor;

public class VelociraptorRenderer extends LegacyEntityRenderer<Velociraptor> {
    public VelociraptorRenderer(Context context) {
        super(context, new VelociraptorModel(context.bakeLayer(FossilsLegacyModels.VELOCIRAPTOR)), new LegacyVelociraptorModel(context.bakeLayer(FossilsLegacyModels.LEGACY_VELOCIRAPTOR)), 0.3F);
        this.addLayer(new VelociraptorHoldItemInMouthLayer(this, context.getItemInHandRenderer()) {
            @Override
            public void pose(PoseStack poseStack) {
                if (VelociraptorRenderer.this.legacyModels()) {
                    if (Math.abs(((LegacyVelociraptorModel) this.getParentModel()).leftThigh.xRot) >= 0.174532F) {
                        poseStack.translate(0.0F, 0.15F, -0.95F);
                    } else {
                        poseStack.translate(0.0F, 0.4F, -0.75F);
                    }
                }
            }
        });
    }

    @Override
    protected ResourceLocation legacyTextureLocation(Velociraptor velociraptor) {
        return velociraptor.legacyTextures()[velociraptor.getSubSpecies()][velociraptor.isBaby() ? 1 : 0];
    }

    @Override
    protected ResourceLocation textureLocation(Velociraptor velociraptor) {
        return velociraptor.textures()[velociraptor.getSubSpecies()][velociraptor.isBaby() ? 1 : 0];
    }
}
