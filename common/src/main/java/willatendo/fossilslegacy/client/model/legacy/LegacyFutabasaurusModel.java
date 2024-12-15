package willatendo.fossilslegacy.client.model.legacy;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.server.entity.dinosaur.cretaceous.Futabasaurus;

public class LegacyFutabasaurusModel extends EntityModel<Futabasaurus> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart neck1;
    private final ModelPart neck2;
    private final ModelPart neck3;
    private final ModelPart neck4;
    private final ModelPart frontRightFlipper;
    private final ModelPart frontLeftFlipper;
    private final ModelPart backRightFlipper;
    private final ModelPart backLeftFlipper;

    public LegacyFutabasaurusModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("head");
        this.neck1 = root.getChild("neck_1");
        this.neck2 = root.getChild("neck_2");
        this.neck3 = root.getChild("neck_3");
        this.neck4 = root.getChild("neck_4");
        this.frontRightFlipper = root.getChild("front_right_flipper");
        this.frontLeftFlipper = root.getChild("front_left_flipper");
        this.backRightFlipper = root.getChild("back_right_flipper");
        this.backLeftFlipper = root.getChild("back_left_flipper");
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public void prepareMobModel(Futabasaurus entity, float limbSwing, float limbSwingAmount, float packedOverlay) {
        this.frontRightFlipper.yRot = (float) (Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.785398163397448 * limbSwingAmount + -2.35619449019234);
        this.backRightFlipper.yRot = (float) (Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.785398163397448 * limbSwingAmount + -2.0943951023932);
        this.frontLeftFlipper.yRot = (float) (Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.785398163397448 * limbSwingAmount + -0.785398163397448);
        this.backLeftFlipper.yRot = (float) (Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.785398163397448 * limbSwingAmount + -1.0471975511966);
    }

    @Override
    public void setupAnim(Futabasaurus futabasaurus, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        int steps = 16 + futabasaurus.getGrowthStage();
        if (futabasaurus.divePose() && futabasaurus.hasControllingPassenger()) {
            this.divePose(steps);
        } else {
            this.surfacePose(steps);
        }
    }

    public void divePose(int steps) {
        if (this.neck1.xRot < -0.453F) {
            this.neck1.xRot += (0.541F / steps);
        } else {
            this.neck1.xRot = -0.453F;
        }

        if (this.neck2.xRot < -0.174F) {
            this.neck2.xRot += (0.716F / steps);
        } else {
            this.neck2.xRot = -0.174F;
        }

        if (this.neck2.y < 18.0F) {
            this.neck2.y += (2.0F / steps);
        } else {
            this.neck2.y = 18.0F;
        }

        if (this.neck2.z < -3.0F) {
            this.neck2.z += (1.0F / steps);
        } else {
            this.neck2.z = -3.0F;
        }

        if (this.neck3.xRot < -0.116F) {
            this.neck3.xRot += (0.472F / steps);
        } else {
            this.neck3.xRot = -0.116F;
        }

        if (this.neck3.y < 17.7F) {
            this.neck3.y += (5.0F / steps);
        } else {
            this.neck3.y = 17.7F;
        }

        if (this.neck3.z > -9F) {
            this.neck3.z -= (1.0F / steps);
        } else {
            this.neck3.z = -9F;
        }

        if (this.neck4.xRot < -0.013F) {
            this.neck4.xRot += (0.123F / steps);
        } else {
            this.neck4.xRot = -0.013F;
        }

        if (this.neck4.y < 17.0F) {
            this.neck4.y += (7.0F / steps);
        } else {
            this.neck4.y = 17.0F;
        }

        if (this.neck4.z > -13.0F) {
            this.neck4.z -= (2.0F / steps);
        } else {
            this.neck4.z = -13.0F;
        }

        if (this.head.xRot > 0.009F) {
            this.head.xRot -= (0.488F / steps);
        } else {
            this.head.xRot = 0.009F;
        }

        if (this.head.y < 16.0F) {
            this.head.y += (7.0F / steps);
        } else {
            this.head.y = 16.0F;
        }

        if (this.head.z > -18.0F) {
            this.head.z -= (3.0F / steps);
        } else {
            this.head.z = -18.0F;
        }
    }

    public void surfacePose(int steps) {
        if (this.neck1.xRot > -0.994F) {
            this.neck1.xRot -= (0.541F / steps);
        } else {
            this.neck1.xRot = -0.994F;
        }

        if (this.neck2.xRot > -0.890F) {
            this.neck2.xRot -= (0.716F / steps);
        } else {
            this.neck2.xRot = -0.890F;
        }

        if (this.neck2.y > 16.0F) {
            this.neck2.y -= (2.0F / steps);
        } else {
            this.neck2.y = 16.0F;
        }

        if (this.neck2.z > -4.0F) {
            this.neck2.z -= (1.0F / steps);
        } else {
            this.neck2.z = -4.0F;
        }

        if (this.neck3.xRot > -0.588F) {
            this.neck3.xRot -= (0.472F / steps);
        } else {
            this.neck3.xRot = -0.588F;
        }

        if (this.neck3.y > 12.7F) {
            this.neck3.y -= (5.0F / steps);
        } else {
            this.neck3.y = 12.7F;
        }

        if (this.neck3.z < -8.0F) {
            this.neck3.z += (1.0F / steps);
        } else {
            this.neck3.z = -8.0F;
        }

        if (this.neck4.xRot > -0.136F) {
            this.neck4.xRot -= (0.123F / steps);
        } else {
            this.neck4.xRot = -0.136F;
        }

        if (this.neck4.y > 10.0F) {
            this.neck4.y -= (7.0F / steps);
        } else {
            this.neck4.y = 10.0F;
        }

        if (this.neck4.z < -11.0F) {
            this.neck4.z += (2.0F / steps);
        } else {
            this.neck4.z = -11.0F;
        }

        if (this.head.xRot < 0.497F) {
            this.head.xRot += (0.488F / steps);
        } else {
            this.head.xRot = 0.497F;
        }

        if (this.head.y > 9.0F) {
            this.head.y -= (7.0F / steps);
        } else {
            this.head.y = 9.0F;
        }

        if (this.head.z < -15.0F) {
            this.head.z += (3.0F / steps);
        } else {
            this.head.z = -15.0F;
        }
    }
}
