package willatendo.fossilslegacy.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.animation.PachycephalosaurusAnimations;
import willatendo.fossilslegacy.server.entity.Pachycephalosaurus;

public class PachycephalosaurusModel extends HierarchicalModel<Pachycephalosaurus> {
    private final ModelPart head;
    private final ModelPart root;

    public PachycephalosaurusModel(ModelPart root) {
        this.head = root.getChild("head");
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(21, 9).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 5.0F, 7.0F).texOffs(0, 16).addBox(-1.0F, -2.0F, 7.0F, 2.0F, 3.0F, 11.0F), PartPose.offset(0.0F, 12.0F, 4.0F));
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(21, 25).addBox(-2.0F, -5.0F, -7.0F, 4.0F, 6.0F, 5.0F).texOffs(14, 36).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 8.0F, 2.0F).texOffs(0, 23).addBox(-1.5F, -2.0F, -8.0F, 3.0F, 3.0F, 1.0F).texOffs(0, 30).addBox(-2.0F, -6.0F, -5.0F, 4.0F, 1.0F, 5.0F).texOffs(20, 0).addBox(-3.0F, -5.0F, -4.0F, 6.0F, 1.0F, 5.0F), PartPose.offset(0.0F, 12.0F, -7.0F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(36, 6).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F).texOffs(0, 0).addBox(-1.0F, 3.0F, 1.0F, 2.0F, 4.0F, 2.0F).texOffs(34, 21).addBox(-1.0F, 7.0F, -1.0F, 3.0F, 2.0F, 4.0F), PartPose.offset(3.0F, 15.0F, 1.0F));
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(42, 0).addBox(-2.0F, 7.0F, -1.0F, 3.0F, 2.0F, 4.0F).texOffs(35, 32).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F).texOffs(15, 19).addBox(-1.0F, 3.0F, 1.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(-3.0F, 15.0F, 1.0F));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(39, 27).addBox(0.0F, 3.0F, -1.0F, 2.0F, 3.0F, 2.0F).texOffs(26, 39).addBox(0.0F, -1.0F, -2.0F, 2.0F, 4.0F, 3.0F), PartPose.offset(2.0F, 15.0F, -5.0F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(13, 30).addBox(-2.0F, 3.0F, -1.0F, 2.0F, 3.0F, 2.0F).texOffs(0, 16).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 4.0F, 3.0F), PartPose.offset(-2.0F, 15.0F, -5.0F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -14.0F, -4.0F, 6.0F, 8.0F, 8.0F).texOffs(0, 36).addBox(-2.0F, -14.0F, -7.0F, 4.0F, 7.0F, 3.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Pachycephalosaurus pachycephalosaurus, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        netHeadYaw = Mth.clamp(netHeadYaw, -30.0F, 30.0F);
        headPitch = Mth.clamp(headPitch, -25.0F, 45.0F);

        this.head.yRot = netHeadYaw * 0.017453292F;
        this.head.xRot = headPitch * 0.017453292F;

        this.animateWalk(PachycephalosaurusAnimations.PACHYCEPHALOSAURUS_WALK, limbSwing, limbSwingAmount, 2.0F, 2.5F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int red, int green, int blue) {
        this.root.render(poseStack, vertexConsumer, red, green, blue);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}