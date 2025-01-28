package willatendo.fossilslegacy.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.server.entity.entities.Failuresaurus;

public class FailuresaurusModel extends EntityModel<Failuresaurus> {
    private final ModelPart root;
    private final ModelPart head;

    public FailuresaurusModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -6.0F, -8.0F, 8.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 0.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 1).addBox(-5.0F, -1.0F, -7.0F, 10.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(2, 3).addBox(-7.0F, -3.0F, -5.0F, 14.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(18, 6).addBox(-5.0F, -7.0F, -2.0F, 10.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    @Override
    public void setupAnim(Failuresaurus failuresaurus, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.applyHeadRotation(failuresaurus, netHeadYaw, headPitch, ageInTicks);
    }

    private void applyHeadRotation(Failuresaurus failuresaurus, float x, float y, float z) {
        x = Mth.clamp(x, -30.0F, 30.0F);
        y = Mth.clamp(y, -25.0F, 45.0F);

        this.head.yRot = x * ((float) Math.PI / 180F);
        this.head.xRot = y * ((float) Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}
