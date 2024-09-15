package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.SmilodonModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.Smilodon;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class SmilodonRenderer extends CoatTypeMobRenderer<Smilodon> {
    public SmilodonRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    public void render(Smilodon smilodon, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        if (smilodon.isWet()) {
            float f = smilodon.getWetShade(packedOverlay);
            if (this.model instanceof SmilodonModel<Smilodon> smilodonModel) {
                smilodonModel.setColor(f, f, f);
            }
        }

        super.render(smilodon, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
    }
}
