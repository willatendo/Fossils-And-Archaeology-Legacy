package willatendo.fossilslegacy.experiments.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import willatendo.fossilslegacy.experiments.server.entity.Carnotaurus;

public class CarnotaurusModel extends EntityModel<Carnotaurus> {
    private final ModelPart root;

    public CarnotaurusModel(ModelPart root) {
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offset(-4.5F, 2.5F, -27.0F));
        partDefinition.addOrReplaceChild("horn_1", CubeListBuilder.create().texOffs(24, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-6.5F, 1.5F, -23.0F, 0.0F, -0.0F, 0.3490658503988659F));
        partDefinition.addOrReplaceChild("horn_2", CubeListBuilder.create().texOffs(24, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(2.5F, 2.5F, -23.0F, 0.0F, -0.0F, -0.3490658503988659F));
        partDefinition.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 15).addBox(0.0F, 0.0F, 0.0F, 6.0F, 1.0F, 7.0F), PartPose.offset(-3.5F, 9.0F, -26.0F));
        partDefinition.addOrReplaceChild("teeth", CubeListBuilder.create().texOffs(34, 59).addBox(0.0F, 0.0F, 0.0F, 8.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-4.5F, 10.4F, -27.0F, 1.5707963267948966F, -0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(20, 4).addBox(0.0F, 0.0F, 0.0F, 5.0F, 6.0F, 12.0F), PartPose.offsetAndRotation(-3.0F, 2.5F, -20.0F, -0.4363323129985824F, -0.0F, 0.0F));
        partDefinition.addOrReplaceChild("upper_body", CubeListBuilder.create().texOffs(0, 23).addBox(0.0F, 0.0F, 0.0F, 7.0F, 9.0F, 10.0F), PartPose.offsetAndRotation(-4.0F, 5.5F, -13.0F, -0.001549108791234052F, -0.0F, 0.0F));
        partDefinition.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(0, 43).addBox(0.0F, 0.0F, 0.0F, 9.0F, 10.0F, 8.0F), PartPose.offsetAndRotation(-5.0F, 5.5F, -6.0F, -0.03490658503988659F, -0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(-6.0F, 11.5F, -13.0F, 0.8726646259971648F, -0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(3.0F, 11.5F, -13.0F, 0.8726646259971648F, -0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_thigh", CubeListBuilder.create().texOffs(44, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(-9.0F, 9.5F, -4.0F, -0.17453292519943295F, -0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(52, 51).addBox(0.0F, 0.0F, 0.0F, 2.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(-7.0F, 15.5F, 0.0F, -0.2617993877991494F, -0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(34, 51).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 6.0F), PartPose.offset(-8.0F, 22.0F, -4.5F));
        partDefinition.addOrReplaceChild("left_thigh", CubeListBuilder.create().texOffs(44, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(4.0F, 9.5F, -4.0F, -0.17453292519943295F, -0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(52, 51).addBox(0.0F, 0.0F, 0.0F, 2.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(4.0F, 15.5F, 0.0F, -0.2617993877991494F, -0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(34, 51).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 6.0F), PartPose.offset(4.0F, 22.0F, -4.5F));
        partDefinition.addOrReplaceChild("tail_1", CubeListBuilder.create().texOffs(26, 36).addBox(0.0F, 0.0F, -1.0F, 7.0F, 6.0F, 9.0F), PartPose.offsetAndRotation(-4.0F, 6.0F, 1.0F, -0.03717861098961725F, -0.0F, 0.0F));
        partDefinition.addOrReplaceChild("tail_2", CubeListBuilder.create().texOffs(34, 22).addBox(0.0F, 0.0F, -1.0F, 5.0F, 5.0F, 9.0F), PartPose.offset(-3.0F, 6.5F, 9.5F));
        partDefinition.addOrReplaceChild("tail_3", CubeListBuilder.create().texOffs(25, 22).addBox(0.0F, 0.0F, -1.0F, 3.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 18.5F, -0.03717861098961725F, -0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void setupAnim(Carnotaurus carnotaurus, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
