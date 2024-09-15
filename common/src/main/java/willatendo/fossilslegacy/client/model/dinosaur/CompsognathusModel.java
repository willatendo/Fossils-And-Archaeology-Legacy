package willatendo.fossilslegacy.client.model.dinosaur;

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
import willatendo.fossilslegacy.client.animation.CompsognathusAnimations;
import willatendo.fossilslegacy.server.entity.Dinosaur;

public class CompsognathusModel extends HierarchicalModel<Dinosaur> {
    private final ModelPart head;
    private final ModelPart root;

    public CompsognathusModel(ModelPart root) {
        this.head = root.getChild("head");
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, 4.0F, 2.0F, 2.0F, 8.0F).texOffs(12, 0).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 3.0F, 4.0F), PartPose.offset(0.0F, 18.0F, 1.0F));
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F).texOffs(14, 10).addBox(0.0F, 3.0F, 1.0F, 1.0F, 3.0F, 0.0F).texOffs(5, 0).addBox(0.0F, 6.0F, 0.0F, 1.0F, 0.0F, 1.0F), PartPose.offset(-2.0F, 18.0F, -1.0F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F).texOffs(5, 1).addBox(-1.0F, 6.0F, 0.0F, 1.0F, 0.0F, 1.0F).texOffs(12, 10).addBox(-1.0F, 3.0F, 1.0F, 1.0F, 3.0F, 0.0F), PartPose.offset(2.0F, 18.0F, -1.0F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 10).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F), PartPose.offset(-1.5F, 18.5F, -4.5F));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(12, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F), PartPose.offset(1.5F, 18.5F, -4.5F));
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(20, 13).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F).texOffs(12, 14).addBox(-1.0F, -3.0F, -5.0F, 2.0F, 3.0F, 4.0F), PartPose.offset(0.0F, 16.0F, -5.0F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 10).addBox(-2.0F, -8.0F, -3.0F, 4.0F, 4.0F, 4.0F).texOffs(17, 7).addBox(-1.0F, -8.0F, -6.0F, 2.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(Dinosaur dinosaur, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        netHeadYaw = Mth.clamp(netHeadYaw, -30.0F, 30.0F);
        headPitch = Mth.clamp(headPitch, -25.0F, 45.0F);

        this.head.yRot = netHeadYaw * 0.017453292F;
        this.head.xRot = headPitch * 0.017453292F;

        this.animateWalk(CompsognathusAnimations.COMPSOGNATHUS_WALK, limbSwing, limbSwingAmount, 2.0F, 2.5F);
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
