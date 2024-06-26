package willatendo.fossilslegacy.client.model.dinosaur.legacy;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.server.entity.Futabasaurus;

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

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 9.0F, -15.0F, 0.49723F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_1", CubeListBuilder.create().texOffs(20, 23).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 17.0F, 0.0F, -0.99446F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_2", CubeListBuilder.create().texOffs(47, 23).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 16.0F, -4.0F, -0.88974F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_3", CubeListBuilder.create().texOffs(35, 3).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 12.73333F, -8.0F, -0.58764F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_4", CubeListBuilder.create().texOffs(35, 3).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 10.0F, -11.0F, -0.13561F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 6.0F, 8.0F), PartPose.offset(0.0F, 20.0F, 0.0F));
        partDefinition.addOrReplaceChild("front_right_flipper", CubeListBuilder.create().texOffs(44, 13).addBox(0.0F, 0.0F, 0.0F, 6.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-3.0F, 21.0F, -3.0F, -0.5236F, -2.35619F, 0.0F));
        partDefinition.addOrReplaceChild("front_left_flipper", CubeListBuilder.create().texOffs(44, 18).addBox(0.0F, 0.0F, -4.0F, 6.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(3.0F, 21.0F, -3.0F, 0.5236F, -0.7854F, 0.0F));
        partDefinition.addOrReplaceChild("back_right_flipper", CubeListBuilder.create().texOffs(48, 0).addBox(0.0F, 0.0F, 0.0F, 5.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-3.0F, 21.0F, 4.0F, -0.5236F, -2.0944F, 0.0F));
        partDefinition.addOrReplaceChild("back_left_flipper", CubeListBuilder.create().texOffs(48, 4).addBox(0.0F, 0.0F, -3.0F, 5.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(3.0F, 21.0F, 4.0F, 0.5236F, -1.0472F, 0.0F));
        partDefinition.addOrReplaceChild("tail_1", CubeListBuilder.create().texOffs(0, 14).addBox(-3.0F, -5.0F, 2.0F, 6.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 20.0F, 0.0F, -0.45203F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("tail_2", CubeListBuilder.create().texOffs(18, 14).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 20.0F, 5.0F, -0.27122F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("tail_3", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 21.0F, 11.0F, -0.18081F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
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

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int red, int green, int blue) {
        this.root.render(poseStack, vertexConsumer, red, green, blue);
    }

    public boolean divePose(int steps) {
        boolean result = true;
        if (this.neck1.xRot < -0.453F) {
            this.neck1.xRot += (0.541F / steps);
            result &= false;
        } else {
            this.neck1.xRot = -0.453F;
        }

        if (this.neck2.xRot < -0.174F) {
            this.neck2.xRot += (0.716F / steps);
            result &= false;
        } else {
            this.neck2.xRot = -0.174F;
        }

        if (this.neck2.y < 18.0F) {
            this.neck2.y += (2.0F / steps);
            result &= false;
        } else {
            this.neck2.y = 18.0F;
        }

        if (this.neck2.z < -3.0F) {
            this.neck2.z += (1.0F / steps);
            result &= false;
        } else {
            this.neck2.z = -3.0F;
        }

        if (this.neck3.xRot < -0.116F) {
            this.neck3.xRot += (0.472F / steps);
            result &= false;
        } else {
            this.neck3.xRot = -0.116F;
        }

        if (this.neck3.y < 17.7F) {
            this.neck3.y += (5.0F / steps);
            result &= false;
        } else {
            this.neck3.y = 17.7F;
        }

        if (this.neck3.z > -9F) {
            this.neck3.z -= (1.0F / steps);
            result &= false;
        } else {
            this.neck3.z = -9F;
        }

        if (this.neck4.xRot < -0.013F) {
            this.neck4.xRot += (0.123F / steps);
            result &= false;
        } else {
            this.neck4.xRot = -0.013F;
        }

        if (this.neck4.y < 17.0F) {
            this.neck4.y += (7.0F / steps);
            result &= false;
        } else {
            this.neck4.y = 17.0F;
        }

        if (this.neck4.z > -13.0F) {
            this.neck4.z -= (2.0F / steps);
            result &= false;
        } else {
            this.neck4.z = -13.0F;
        }

        if (this.head.xRot > 0.009F) {
            this.head.xRot -= (0.488F / steps);
            result &= false;
        } else {
            this.head.xRot = 0.009F;
        }

        if (this.head.y < 16.0F) {
            this.head.y += (7.0F / steps);
            result &= false;
        } else {
            this.head.y = 16.0F;
        }

        if (this.head.z > -18.0F) {
            this.head.z -= (3.0F / steps);
            result &= false;
        } else {
            this.head.z = -18.0F;
        }

        return result;
    }

    public boolean surfacePose(int steps) {
        boolean result = true;
        if (this.neck1.xRot > -0.994F) {
            this.neck1.xRot -= (0.541F / steps);
            result &= false;
        } else {
            this.neck1.xRot = -0.994F;
        }

        if (this.neck2.xRot > -0.890F) {
            this.neck2.xRot -= (0.716F / steps);
            result &= false;
        } else {
            this.neck2.xRot = -0.890F;
        }

        if (this.neck2.y > 16.0F) {
            this.neck2.y -= (2.0F / steps);
            result &= false;
        } else {
            this.neck2.y = 16.0F;
        }

        if (this.neck2.z > -4.0F) {
            this.neck2.z -= (1.0F / steps);
            result &= false;
        } else {
            this.neck2.z = -4.0F;
        }

        if (this.neck3.xRot > -0.588F) {
            this.neck3.xRot -= (0.472F / steps);
            result &= false;
        } else {
            this.neck3.xRot = -0.588F;
        }

        if (this.neck3.y > 12.7F) {
            this.neck3.y -= (5.0F / steps);
            result &= false;
        } else {
            this.neck3.y = 12.7F;
        }

        if (this.neck3.z < -8.0F) {
            this.neck3.z += (1.0F / steps);
            result &= false;
        } else {
            this.neck3.z = -8.0F;
        }

        if (this.neck4.xRot > -0.136F) {
            this.neck4.xRot -= (0.123F / steps);
            result &= false;
        } else {
            this.neck4.xRot = -0.136F;
        }

        if (this.neck4.y > 10.0F) {
            this.neck4.y -= (7.0F / steps);
            result &= false;
        } else {
            this.neck4.y = 10.0F;
        }

        if (this.neck4.z < -11.0F) {
            this.neck4.z += (2.0F / steps);
            result &= false;
        } else {
            this.neck4.z = -11.0F;
        }

        if (this.head.xRot < 0.497F) {
            this.head.xRot += (0.488F / steps);
            result &= false;
        } else {
            this.head.xRot = 0.497F;
        }

        if (this.head.y > 9.0F) {
            this.head.y -= (7.0F / steps);
            result &= false;
        } else {
            this.head.y = 9.0F;
        }

        if (this.head.z < -15.0F) {
            this.head.z += (3.0F / steps);
            result &= false;
        } else {
            this.head.z = -15.0F;
        }

        return result;
    }
}
