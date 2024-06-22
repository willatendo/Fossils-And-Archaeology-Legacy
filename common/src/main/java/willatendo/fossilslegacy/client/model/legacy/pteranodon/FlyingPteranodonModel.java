package willatendo.fossilslegacy.client.model.legacy.pteranodon;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import willatendo.fossilslegacy.server.entity.Pteranodon;

public class FlyingPteranodonModel extends AbstractPteranodonModel {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart crown;
    private final ModelPart lowerMouth;
    private final ModelPart upperMouth;
    private final ModelPart neck1;
    private final ModelPart neck2;
    private final ModelPart body;
    private final ModelPart rightWing1;
    private final ModelPart rightWing2;
    private final ModelPart leftWing1;
    private final ModelPart leftWing2;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart tail;

    public FlyingPteranodonModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("head");
        this.crown = root.getChild("crown");
        this.lowerMouth = root.getChild("lower_mouth");
        this.upperMouth = root.getChild("upper_mouth");
        this.neck1 = root.getChild("neck_1");
        this.neck2 = root.getChild("neck_2");
        this.body = root.getChild("body");
        this.rightLeg = root.getChild("right_leg");
        this.leftLeg = root.getChild("left_leg");
        this.rightWing1 = root.getChild("right_wing_1");
        this.rightWing2 = root.getChild("right_wing_2");
        this.leftWing1 = root.getChild("left_wing_1");
        this.leftWing2 = root.getChild("left_wing_2");
        this.tail = root.getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 23).addBox(-2.0F, -13.0F, -1.0F, 4.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("crown", CubeListBuilder.create().texOffs(16, 22).addBox(-1.0F, -10.0F, -9.0F, 2.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 0.4859298F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("lower_mouth", CubeListBuilder.create().texOffs(44, 9).addBox(-1.0F, -2.0F, -20.0F, 2.0F, 1.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 0.1356083F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("upper_mouth", CubeListBuilder.create().texOffs(44, 0).addBox(-1.0F, -1.0F, -21.0F, 2.0F, 1.0F, 8.0F), PartPose.offset(0.0F, 23.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_1", CubeListBuilder.create().texOffs(8, 16).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_2", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.5F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_wing_1", CubeListBuilder.create().texOffs(16, 7).addBox(2.0F, -3.0F, -1.0F, 8.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 1.0F, 1.570796F, 0.0F, -2.792527F));
        partDefinition.addOrReplaceChild("right_wing_2", CubeListBuilder.create().texOffs(46, 18).addBox(9.0F, -3.0F, -4.0F, 8.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, -1.570796F, 3.141593F, -3.002F));
        partDefinition.addOrReplaceChild("left_wing_1", CubeListBuilder.create().texOffs(16, 0).addBox(2.0F, -3.0F, 0.0F, 8.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, -1.570796F, 3.141593F, 2.792527F));
        partDefinition.addOrReplaceChild("left_wing_2", CubeListBuilder.create().texOffs(46, 23).addBox(9.0F, -3.0F, 3.0F, 8.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(40, 4).addBox(-2.0F, 3.0F, -2.0F, 1.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(40, 0).addBox(1.0F, 3.0F, -2.0F, 1.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 11).addBox(-2.0F, 2.0F, 0.0F, 4.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    @Override
    public void setupAnim(Pteranodon pteranodon, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float airPitch = (float) -(pteranodon.airPitch * (Math.PI / 180.0F));
        float airAngle = (float) -(pteranodon.airAngle * (Math.PI / 180.0F));

        this.leftWing1.xRot = -1.570796F + airPitch;
        this.leftWing2.xRot = 1.570796F + airPitch;
        this.rightWing1.xRot = 1.570796F - airPitch;
        this.rightWing2.xRot = -1.570796F - airPitch;
        this.body.xRot = 1.570796F + airPitch;
        this.neck1.xRot = 1.570796F + airPitch;
        this.neck2.xRot = 1.570796F + airPitch;
        this.tail.xRot = 1.570796F + airPitch;
        this.crown.xRot = 0.4859298F + airPitch;
        this.head.xRot = 1.570796F + airPitch;
        this.upperMouth.xRot = airPitch;
        this.lowerMouth.xRot = 0.1356083F + airPitch;
        this.leftLeg.xRot = this.rightLeg.xRot = 1.570796F + airPitch;

        this.body.zRot = airAngle;
        this.neck1.zRot = airAngle;
        this.neck2.zRot = airAngle;
        this.leftWing1.zRot = 2.792527F + airAngle;
        this.leftWing2.zRot = airAngle;
        this.rightWing1.zRot = -2.792527F + airAngle;
        this.rightWing2.zRot = airAngle;
        this.tail.zRot = airAngle;
        this.crown.zRot = airAngle;
        this.head.zRot = airAngle;
        this.upperMouth.zRot = airAngle;
        this.lowerMouth.zRot = airAngle;
        this.leftLeg.zRot = this.rightLeg.zRot = airAngle;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int red, int green, int blue) {
        this.root.render(poseStack, vertexConsumer, red, green, blue);
    }
}
