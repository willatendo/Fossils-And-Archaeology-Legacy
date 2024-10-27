package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.FastColor;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.server.entity.dinosaur.quaternary.Smilodon;

public class SmilodonRenderer extends CoatTypeMobRenderer<Smilodon> {
    public SmilodonRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    public void render(Smilodon smilodon, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        if (smilodon.isWet()) {
            float wetShade = smilodon.getWetShade(packedOverlay);
            if (this.model instanceof JsonModel jsonModel) {
                if (jsonModel.isColored()) {
                    jsonModel.setColor(FastColor.ARGB32.colorFromFloat(1.0F, wetShade, wetShade, wetShade));
                }
            }
        }

        super.render(smilodon, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
    }
}
