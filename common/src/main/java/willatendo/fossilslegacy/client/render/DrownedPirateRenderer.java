package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.FAModelLayers;
import willatendo.fossilslegacy.client.model.DrownedPirateModel;
import willatendo.fossilslegacy.client.render.layer.DrownedPirateOuterLayer;
import willatendo.fossilslegacy.server.entity.entities.Bones;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class DrownedPirateRenderer extends HumanoidMobRenderer<Bones, SkeletonRenderState, DrownedPirateModel<SkeletonRenderState>> {
    private static final ResourceLocation TEXTURE = FAUtils.resource("textures/entity/drowned_pirate/drowned_pirate.png");

    public DrownedPirateRenderer(EntityRendererProvider.Context context) {
        super(context, new DrownedPirateModel<>(context.bakeLayer(FAModelLayers.DROWNED_PIRATE)), 0.5F);
        this.addLayer(new HumanoidArmorLayer<>(this, new SkeletonModel<>(context.bakeLayer(FAModelLayers.DROWNED_PIRATE_INNER_ARMOR)), new SkeletonModel<>(context.bakeLayer(FAModelLayers.DROWNED_PIRATE_OUTER_ARMOR)), context.getEquipmentRenderer()));
        this.addLayer(new DrownedPirateOuterLayer(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(SkeletonRenderState skeletonRenderState) {
        return TEXTURE;
    }

    @Override
    public SkeletonRenderState createRenderState() {
        return new SkeletonRenderState();
    }

    @Override
    protected void setupRotations(SkeletonRenderState skeletonRenderState, PoseStack poseStack, float bodyRot, float scale) {
        super.setupRotations(skeletonRenderState, poseStack, bodyRot, scale);
        float swimAmount = skeletonRenderState.swimAmount;
        if (swimAmount > 0.0F) {
            float xRot = -10.0F - skeletonRenderState.xRot;
            float rotation = Mth.lerp(swimAmount, 0.0F, xRot);
            poseStack.rotateAround(Axis.XP.rotationDegrees(rotation), 0.0F, skeletonRenderState.boundingBoxHeight / 2.0F / scale, 0.0F);
        }
    }
}
