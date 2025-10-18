package willatendo.fossilslegacy.client.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.util.Mth;

public class CaptainsHatModel extends EntityModel<HumanoidRenderState> {
    public final ModelPart head;

    public CaptainsHatModel(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition root = meshDefinition.getRoot();

        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(40, 0).addBox(-6.0F, -11.0F, -6.0F, 12.0F, 6.0F, 0.0F).texOffs(0, 12).addBox(-5.0F, -9.0F, -5.0F, 10.0F, 4.0F, 11.0F).texOffs(-2, 0).addBox(-6.0F, -5.0F, -6.0F, 12.0F, 0.0F, 12.0F).texOffs(0, 23).addBox(-6.0F, -10.0F, -6.0F, 0.0F, 5.0F, 12.0F).texOffs(24, 23).addBox(6.0F, -10.0F, -6.0F, 0.0F, 5.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void setupAnim(HumanoidRenderState humanoidRenderState) {
        super.setupAnim(humanoidRenderState);
        float swimAmount = humanoidRenderState.swimAmount;
        boolean isFallFlying = humanoidRenderState.isFallFlying;
        this.head.xRot = humanoidRenderState.xRot * 0.017453292F;
        this.head.yRot = humanoidRenderState.yRot * 0.017453292F;
        if (isFallFlying) {
            this.head.xRot = -0.7853982F;
        } else if (swimAmount > 0.0F) {
            this.head.xRot = Mth.rotLerpRad(swimAmount, this.head.xRot, -0.7853982F);
        }
        if (humanoidRenderState.isCrouching) {
            this.head.y += 4.2F;
        }
    }

    public <M extends HumanoidModel<HumanoidRenderState>> void copyPropertiesTo(M model) {
        this.head.copyFrom(model.head);
    }
}
