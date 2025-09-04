package willatendo.fossilslegacy.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FAModelLayers;
import willatendo.fossilslegacy.client.model.DrownedPirateModel;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class DrownedPirateOuterLayer extends RenderLayer<SkeletonRenderState, DrownedPirateModel<SkeletonRenderState>> {
    private static final ResourceLocation DROWNED_OUTER_LAYER_LOCATION = FAUtils.resource("textures/entity/drowned_pirate/drowned_pirate_outer_layer.png");
    private final DrownedPirateModel<SkeletonRenderState> model;

    public DrownedPirateOuterLayer(RenderLayerParent<SkeletonRenderState, DrownedPirateModel<SkeletonRenderState>> renderLayerParent, EntityModelSet entityModelSet) {
        super(renderLayerParent);
        this.model = new DrownedPirateModel<>(entityModelSet.bakeLayer(FAModelLayers.DROWNED_PIRATE_OUTER_LAYER));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int p_116915_, SkeletonRenderState skeletonRenderState, float p_116917_, float p_116918_) {
        RenderLayer.coloredCutoutModelCopyLayerRender(this.model, DROWNED_OUTER_LAYER_LOCATION, poseStack, multiBufferSource, p_116915_, skeletonRenderState, -1);
    }
}
