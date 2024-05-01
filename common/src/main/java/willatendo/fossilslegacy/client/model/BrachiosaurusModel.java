package willatendo.fossilslegacy.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import willatendo.fossilslegacy.server.entity.Brachiosaurus;

public class BrachiosaurusModel extends EntityModel<Brachiosaurus> {
    private final ModelPart root;
    private final ModelPart head;

    public BrachiosaurusModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("upper_body").getChild("neck_base").getChild("neck").getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("right_forearm", CubeListBuilder.create().texOffs(20, 94).addBox(-2.0F, 10.0F, -4.0F, 4.0F, 10.0F, 6.0F).texOffs(28, 60).addBox(-3.0F, -4.0F, -4.0F, 6.0F, 14.0F, 8.0F), PartPose.offset(-9.0F, 4.0F, -4.0F));
        partDefinition.addOrReplaceChild("left_forearm", CubeListBuilder.create().texOffs(96, 0).addBox(-2.0F, 10.0F, -4.0F, 4.0F, 10.0F, 6.0F).texOffs(56, 60).addBox(-3.0F, -4.0F, -4.0F, 6.0F, 14.0F, 8.0F), PartPose.offset(9.0F, 4.0F, -4.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(64, 92).addBox(-2.0F, 7.0F, -2.0F, 4.0F, 10.0F, 6.0F).texOffs(0, 64).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 10.0F, 8.0F), PartPose.offset(-8.0F, 7.0F, 12.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(84, 92).addBox(-2.0F, 7.0F, -2.0F, 4.0F, 10.0F, 6.0F).texOffs(76, 74).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 10.0F, 8.0F), PartPose.offset(8.0F, 7.0F, 12.0F));
        PartDefinition upper_body = partDefinition.addOrReplaceChild("upper_body", CubeListBuilder.create().texOffs(38, 38).addBox(-6.0F, -6.0F, -5.0F, 12.0F, 12.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -3.0F, -8.0F, -0.3927F, 0.0F, 0.0F));
        PartDefinition neck_base = upper_body.addOrReplaceChild("neck_base", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.75F, -1.5F, 0.3927F, 0.0F, 0.0F));
        PartDefinition neck = neck_base.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 82).addBox(-3.0F, -12.0F, -2.0F, 6.0F, 16.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -16.0F, -6.25F, 0.2182F, 0.0F, 0.0F));
        neck.addOrReplaceChild("neck_bottom", CubeListBuilder.create().texOffs(84, 66).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, 0.3054F, 0.0F, 0.0F));
        neck.addOrReplaceChild("neck_middle", CubeListBuilder.create().texOffs(84, 26).addBox(-3.0F, -4.1971F, -3.3997F, 6.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.4363F, 0.0F, 0.0F));
        neck.addOrReplaceChild("neck_top", CubeListBuilder.create().texOffs(44, 0).addBox(-3.0F, -5.1875F, -4.6627F, 6.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -20.0F, 0.0F, 0.9599F, 0.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(56, 0).addBox(-4.0F, -4.5F, -7.5F, 8.0F, 6.0F, 8.0F).texOffs(48, 82).addBox(-2.0F, -8.5F, -9.5F, 4.0F, 8.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -20.0F, -5.0F, -0.2182F, 0.0F, 0.0F));
        head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(76, 14).addBox(-3.0F, -0.9569F, -9.7225F, 6.0F, 4.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, 0.1745F, 0.0F, 0.0F));
        neck_base.addOrReplaceChild("neck_front", CubeListBuilder.create().texOffs(76, 54).addBox(-4.0F, -3.0F, -5.0F, 8.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -8.0F, -4.75F, -1.3963F, 0.0F, 0.0F));
        neck_base.addOrReplaceChild("base_neck_bottom", CubeListBuilder.create().texOffs(0, 48).addBox(-5.0F, -4.0F, -8.0F, 10.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -2.0F, -0.25F, -0.9599F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("mid_body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -7.0F, -6.0F, 16.0F, 14.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -1.0F, 2.0F, -0.1309F, 0.0F, 0.0F));
        PartDefinition lower_body = partDefinition.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(0, 26).addBox(-7.0F, -5.0F, -1.0F, 14.0F, 12.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -2.0F, 5.0F, -0.3491F, 0.0F, 0.0F));
        PartDefinition tail = lower_body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 1.5F, 7.0F, 0.3927F, 0.0F, 0.0F));
        PartDefinition upper_tail = tail.addOrReplaceChild("upper_tail", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, -0.9599F, 0.0F, 0.0F));
        upper_tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(48, 18).addBox(-5.0F, -4.5F, -4.0F, 10.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 0.1745F, 0.0F, 0.0F));
        tail.addOrReplaceChild("middle_tail", CubeListBuilder.create().texOffs(72, 34).addBox(-4.0F, -3.0F, 0.0F, 8.0F, 6.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 3.0F, 4.25F, -0.6545F, 0.0F, 0.0F));
        tail.addOrReplaceChild("lower_tail", CubeListBuilder.create().texOffs(20, 82).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 4.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 7.75F, 9.5F, -0.2618F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    public void setupAnim(Brachiosaurus brachiosaurus, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.xRot = headPitch * (float) (Math.PI / 180.0);
        this.head.yRot = headPitch * (float) (Math.PI / 180.0);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
