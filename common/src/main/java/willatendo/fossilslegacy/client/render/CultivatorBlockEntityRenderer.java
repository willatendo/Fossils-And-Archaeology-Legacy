package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.FetusModel;
import willatendo.fossilslegacy.server.block.entity.CultivatorBlockEntity;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class CultivatorBlockEntityRenderer implements BlockEntityRenderer<CultivatorBlockEntity> {
    private static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entity/fetus.png");
    private final FetusModel fetusModel;

    public CultivatorBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.fetusModel = new FetusModel(context.bakeLayer(FossilsLegacyModelLayers.FETUS));
    }

    @Override
    public void render(CultivatorBlockEntity cultivatorBlockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        if (cultivatorBlockEntity.cultivationProgress > 0) {
            poseStack.pushPose();
            poseStack.scale(1.0F, -1.0F, -1.0F);
            poseStack.translate(0.5F, -1.35F, -0.5F);
            poseStack.scale(0.75F, 0.75F, 0.75F);
            float tick = (float) cultivatorBlockEntity.time + partialTicks;
            poseStack.translate(0.0F, 0.1F + Mth.sin(tick * 0.1F) * 0.01F, 0.0F);

            float rot;
            for (rot = cultivatorBlockEntity.rot - cultivatorBlockEntity.oRot; rot >= 3.1415927F; rot -= 6.2831855F) {
            }

            while (rot < -3.1415927F) {
                rot += 6.2831855F;
            }

            poseStack.mulPose(Axis.YP.rotation(-(cultivatorBlockEntity.oRot + rot * partialTicks)));
            this.fetusModel.renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(TEXTURE)), packedLight, packedOverlay);
            poseStack.popPose();
        }
    }
}
