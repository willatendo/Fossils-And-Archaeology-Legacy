package willatendo.fossilslegacy.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.resources.ResourceLocation;

public class DrownedPirateOuterLayer extends RenderLayer<SkeletonRenderState, SkeletonModel<SkeletonRenderState>> {
    private static final ResourceLocation DROWNED_OUTER_LAYER_LOCATION = ResourceLocation.withDefaultNamespace("textures/entity/zombie/drowned_outer_layer.png");
    private final SkeletonModel<SkeletonRenderState> model;
    private final SkeletonModel<SkeletonRenderState> babyModel;

    public DrownedPirateOuterLayer(RenderLayerParent<SkeletonRenderState, SkeletonModel<SkeletonRenderState>> renderLayerParent, EntityModelSet entityModelSet) {
        super(renderLayerParent);
        this.model = new SkeletonModel<>(entityModelSet.bakeLayer(ModelLayers.SKELETON_OUTER_ARMOR));
        this.babyModel = new SkeletonModel<>(entityModelSet.bakeLayer(ModelLayers.DROWNED_BABY_OUTER_LAYER));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int p_116915_, SkeletonRenderState skeletonRenderState, float p_116917_, float p_116918_) {
        SkeletonModel<SkeletonRenderState> skeletonModel = skeletonRenderState.isBaby ? this.babyModel : this.model;
        RenderLayer.coloredCutoutModelCopyLayerRender(skeletonModel, DROWNED_OUTER_LAYER_LOCATION, poseStack, multiBufferSource, p_116915_, skeletonRenderState, -1);
    }
}
