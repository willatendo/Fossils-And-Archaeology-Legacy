package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.api.client.ModelIdentifierRegistry;
import willatendo.fossilslegacy.server.block.entity.PalaeontologyTableBlockEntity;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.Map;

public class PalaeontologyTableRenderer implements BlockEntityRenderer<PalaeontologyTableBlockEntity> {
    protected final Map<ResourceLocation, EntityModel> models;

    public PalaeontologyTableRenderer(BlockEntityRendererProvider.Context context) {
        this.models = ModelIdentifierRegistry.registerAllModels(context::bakeLayer);
    }

    @Override
    public void render(PalaeontologyTableBlockEntity palaeontologyTableBlockEntity, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        FossilVariant fossilVariant = palaeontologyTableBlockEntity.selected;
        if (palaeontologyTableBlockEntity.selected != null) {
            FossilsLegacyUtils.LOGGER.info("HAS FOSSIL");
            poseStack.pushPose();
            poseStack.scale(1.0F, -1.0F, -1.0F);
            poseStack.translate(0.0F, 16.0F, 0.0F);
            this.models.get(fossilVariant.model()).renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.entityCutout(fossilVariant.texture())), packedLight, packedOverlay);
            poseStack.popPose();
        }
    }
}
