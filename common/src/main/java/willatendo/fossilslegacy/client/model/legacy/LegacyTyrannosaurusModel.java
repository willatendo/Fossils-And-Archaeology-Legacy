package willatendo.fossilslegacy.client.model.legacy;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.server.entity.dinosaur.cretaceous.Tyrannosaurus;

public class LegacyTyrannosaurusModel extends EntityModel<Tyrannosaurus> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart snout;
    private final ModelPart jaw;
    private final ModelPart neck;
    private final ModelPart body;
    private final ModelPart tailBase;
    private final ModelPart tailMid;
    private final ModelPart tailEnd;
    private final ModelPart rightFoot;
    private final ModelPart rightLeg;
    private final ModelPart rightThigh;
    private final ModelPart leftFoot;
    private final ModelPart leftLeg;
    private final ModelPart leftThigh;
    private final ModelPart rightArm;
    private final ModelPart leftArm;

    public LegacyTyrannosaurusModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("head");
        this.snout = root.getChild("snout");
        this.jaw = root.getChild("jaw");
        this.neck = root.getChild("neck");
        this.body = root.getChild("body");
        this.tailBase = root.getChild("tail_base");
        this.tailMid = root.getChild("tail_mid");
        this.tailEnd = root.getChild("tail_end");
        this.rightThigh = root.getChild("right_thigh");
        this.rightLeg = root.getChild("right_leg");
        this.rightFoot = root.getChild("right_foot");
        this.leftThigh = root.getChild("left_thigh");
        this.leftLeg = root.getChild("left_leg");
        this.leftFoot = root.getChild("left_foot");
        this.rightArm = root.getChild("right_arm");
        this.leftArm = root.getChild("left_arm");
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public void setupAnim(Tyrannosaurus tyrannosaurus, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yRot = -netHeadYaw / 57.29578F;
        this.snout.yRot = -netHeadYaw / 57.29578F;
        this.jaw.yRot = -netHeadYaw / 57.29578F;

        this.rightThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.6108652F;
        this.rightFoot.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftThigh.xRot = Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount;
        this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.6108652F;
        this.leftFoot.xRot = Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount;

        if (Math.abs(this.rightThigh.xRot) >= 0.174532F) {
            this.runPose();
        } else {
            this.standPose();
        }
    }

    private void runPose() {
        if (this.body.y > 7) {
            this.body.y -= (2.0F / 20.0F);
        } else {
            this.body.y = 7;
        }

        if (this.body.z > -4) {
            this.body.z -= (3.0F / 20.0F);
        } else {
            this.body.z = -4;
        }

        if (this.body.xRot < 0) {
            this.body.xRot += (0.9948377F / 20.0F);
        } else {
            this.body.xRot = 0;
        }

        if (this.neck.z > 0) {
            this.neck.z -= (2.0F / 20.0F);
        } else {
            this.neck.z = 0;
        }

        if (this.neck.xRot < 0) {
            this.neck.xRot += (0.4068249F / 20.0F);
        } else {
            this.neck.xRot = 0;
        }

        if (this.rightArm.y < 14) {
            this.rightArm.y += (4.0F / 20.0F);
        } else {
            this.rightArm.y = 14;
        }

        if (this.leftArm.y < 14) {
            this.leftArm.y += (4.0F / 20.0F);
        } else {
            this.leftArm.y = 14;
        }

        if (this.tailBase.xRot < -0.2260139F) {
            this.tailBase.xRot += ((0.7684471F - 0.2260139F) / 20.0F);
        } else {
            this.tailBase.xRot = -0.2260139F;
        }

        if (this.tailMid.y > 11) {
            this.tailMid.y -= (4.0F / 20.0F);
        } else {
            this.tailMid.y = 11;
        }

        if (this.tailMid.z < 14) {
            this.tailMid.z += (2.0F / 20.0F);
        } else {
            this.tailMid.z = 14;
        }

        if (this.tailMid.xRot < -0.1356083F) {
            this.tailMid.xRot += ((0.5424333F - 0.1356083F) / 20.0F);
        } else {
            this.tailMid.xRot = -0.1356083F;
        }

        if (this.tailEnd.y > 13) {
            this.tailEnd.y -= (7.0F / 20.0F);
        } else {
            this.tailEnd.y = 13;
        }

        if (this.tailEnd.z < 22) {
            this.tailEnd.z += (3.0F / 20.0F);
        } else {
            this.tailEnd.z = 22;
        }

        if (this.tailEnd.xRot < 0) {
            this.tailEnd.xRot += (0.3616222F / 20.0F);
        } else {
            this.tailEnd.xRot = 0;
        }

        if (this.head.y < 7) {
            this.head.y += (7.0F / 20.0F);
        } else {
            this.head.y = 7;
        }

        if (this.head.z > -14) {
            this.head.z -= (6.0F / 20.0F);
        } else {
            this.head.z = -14;
        }

        if (this.snout.y < 7) {
            this.snout.y += (7.0F / 20.0F);
        } else {
            this.snout.y = 7;
        }

        if (this.snout.z > -14) {
            this.snout.z -= (6.0F / 20.0F);
        } else {
            this.snout.z = -14;
        }

        if (this.jaw.y < 7) {
            this.jaw.y += (6.0F / 20.0F);
        } else {
            this.jaw.y = 7;
        }

        if (this.jaw.z > -14) {
            this.jaw.z -= (6.0F / 20.0F);
        } else {
            this.jaw.z = -14;
        }
    }

    private void standPose() {
        if (this.body.y < 9) {
            this.body.y += (2.0F / 20.0F);
        } else {
            this.body.y = 9;
        }

        if (this.body.z < -1) {
            this.body.z += (3.0F / 20.0F);
        } else {
            this.body.z = -1;
        }

        if (this.body.xRot > -0.9948377F) {
            this.body.xRot -= (0.9948377F / 20.0F);
        } else {
            this.body.xRot = -0.9948377F;
        }

        if (this.neck.z < 2) {
            this.neck.z += (2.0F / 20.0F);
        } else {
            this.neck.z = 2;
        }

        if (this.neck.xRot > -0.4068249F) {
            this.neck.xRot -= (0.4068249F / 20.0F);
        } else {
            this.neck.xRot = -0.4068249F;
        }

        if (this.rightArm.y > 10) {
            this.rightArm.y -= (4.0F / 20.0F);
        } else {
            this.rightArm.y = 10;
        }

        if (this.leftArm.y > 10) {
            this.leftArm.y -= (4.0F / 20.0F);
        } else {
            this.leftArm.y = 10;
        }

        if (this.tailBase.xRot > -0.7684471F) {
            this.tailBase.xRot -= ((0.7684471F - 0.2260139F) / 20.0F);
        } else {
            this.tailBase.xRot = -0.7684471F;
        }

        if (this.tailMid.y < 15) {
            this.tailMid.y += (4.0F / 20.0F);
        } else {
            this.tailMid.y = 15;
        }

        if (this.tailMid.z > 12) {
            this.tailMid.z -= (2.0F / 20.0F);
        } else {
            this.tailMid.z = 12;
        }

        if (this.tailMid.xRot > -0.5424333F) {
            this.tailMid.xRot -= ((0.5424333F - 0.1356083F) / 20.0F);
        } else {
            this.tailMid.xRot = -0.5424333F;
        }

        if (this.tailEnd.y < 20) {
            this.tailEnd.y += (7.0F / 20.0F);
        } else {
            this.tailEnd.y = 20;
        }

        if (this.tailEnd.z > 19) {
            this.tailEnd.z -= (3.0F / 20.0F);
        } else {
            this.tailEnd.z = 19;
        }

        if (this.tailEnd.xRot < -0.3616222F) {
            this.tailEnd.xRot += ((0.3616222F - 2.8368E-15F) / 20.0F);
        } else {
            this.tailEnd.xRot = -0.3616222F;
        }

        if (this.head.y > 0) {
            this.head.y -= (7.0F / 20.0F);
        } else {
            this.head.y = 0;
        }

        if (this.head.z < -8) {
            this.head.z += (6.0F / 20.0F);
        } else {
            this.head.z = -8;
        }

        if (this.snout.y > 1) {
            this.snout.y -= (7.0F / 20.0F);
        } else {
            this.snout.y = 1;
        }

        if (this.snout.z < -8) {
            this.snout.z += (6.0F / 20.0F);
        } else {
            this.snout.z = -8;
        }

        if (this.jaw.y > 1) {
            this.jaw.y -= (6.0F / 20.0F);
        } else {
            this.jaw.y = 1;
        }

        if (this.jaw.z < -8) {
            this.jaw.z += (6.0F / 20.0F);
        } else {
            this.jaw.z = -8;
        }
    }
}
