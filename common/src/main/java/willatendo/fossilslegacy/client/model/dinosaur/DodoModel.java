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
import willatendo.fossilslegacy.client.animation.DodoAnimations;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.Dodo;

public class DodoModel extends HierarchicalModel<Dinosaur> {
    private final ModelPart root;
    private final ModelPart head;

    public DodoModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -12.0F, 8.0F, 8.0F, 8.0F).texOffs(24, 0).addBox(-2.0F, -5.0F, -5.0F, 4.0F, 5.0F, 3.0F), PartPose.offset(0.0F, 17.0F, 8.0F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(2, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 0.0F).texOffs(22, 16).addBox(-1.0F, 3.0F, -3.0F, 3.0F, 0.0F, 3.0F), PartPose.offset(1.0F, 21.0F, 1.0F));
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(9, 16).addBox(-2.0F, 3.0F, -3.0F, 3.0F, 0.0F, 3.0F).texOffs(0, 0).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 0.0F), PartPose.offset(-1.0F, 21.0F, 1.0F));
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F).texOffs(16, 16).addBox(-1.0F, -5.0F, -7.0F, 2.0F, 3.0F, 5.0F), PartPose.offset(0.0F, 15.0F, -4.0F));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(22, 24).addBox(0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 4.0F), PartPose.offset(4.0F, 15.0F, -2.0F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(12, 24).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 4.0F), PartPose.offset(-4.0F, 15.0F, -2.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Dinosaur dinosaur, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        netHeadYaw = Mth.clamp(netHeadYaw, -30.0F, 30.0F);
        headPitch = Mth.clamp(headPitch, -25.0F, 45.0F);

        this.head.yRot = netHeadYaw * 0.017453292F;
        this.head.xRot = headPitch * 0.017453292F;

        this.animateWalk(DodoAnimations.DODO_WALK, limbSwing, limbSwingAmount, 2.0F, 2.5F);
        if (dinosaur instanceof Dodo dodo) {
            this.animate(dodo.fallAnimationState, DodoAnimations.DODO_FALL, ageInTicks);
        }
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