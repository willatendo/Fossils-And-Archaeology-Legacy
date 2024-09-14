package willatendo.fossilslegacy.client.model.dinosaur.legacy;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.model.dinosaur.base.DinosaurModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.Velociraptor;

public class LegacyVelociraptorModel extends DinosaurModel<Dinosaur> {
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart snout;
    private final ModelPart jaw;
    private final ModelPart upperBody;
    private final ModelPart lowerBody;
    private final ModelPart tail;
    public final ModelPart leftThigh;
    private final ModelPart leftLeg;
    private final ModelPart leftFoot;
    private final ModelPart leftHook1;
    private final ModelPart leftHook2;
    private final ModelPart leftBicep;
    private final ModelPart leftHand;
    private final ModelPart rightThigh;
    private final ModelPart rightLeg;
    private final ModelPart rightFoot;
    private final ModelPart rightHook1;
    private final ModelPart rightHook2;
    private final ModelPart rightBicep;
    private final ModelPart rightHand;

    public LegacyVelociraptorModel(ModelPart root) {
        super(root);
        this.neck = root.getChild("neck");
        this.head = root.getChild("head");
        this.snout = root.getChild("snout");
        this.jaw = root.getChild("jaw");
        this.upperBody = root.getChild("upper_body");
        this.lowerBody = root.getChild("lower_body");
        this.tail = root.getChild("tail");
        this.rightThigh = root.getChild("right_thigh");
        this.rightLeg = root.getChild("right_leg");
        this.rightFoot = root.getChild("right_foot");
        this.rightHook1 = root.getChild("right_hook_1");
        this.rightHook2 = root.getChild("right_hook_2");
        this.rightBicep = root.getChild("right_bicep");
        this.rightHand = root.getChild("right_hand");
        this.leftThigh = root.getChild("left_thigh");
        this.leftLeg = root.getChild("left_leg");
        this.leftFoot = root.getChild("left_foot");
        this.leftHook1 = root.getChild("left_hook_1");
        this.leftHook2 = root.getChild("left_hook_2");
        this.leftBicep = root.getChild("left_bicep");
        this.leftHand = root.getChild("left_hand");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 17).addBox(-3.0F, -7.0F, -8.0F, 6.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 5.0F, -3.0F, 0.08726646F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(44, 22).addBox(-2.0F, -4.0F, -6.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 5.0F, -11.0F, 0.08726646F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(23, 0).addBox(-2.0F, 0.0F, -5.0F, 4.0F, 1.0F, 6.0F), PartPose.offset(0.0F, 5.0F, -10.0F));
        partDefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(3, 1).addBox(-2.0F, 0.0F, -6.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 10.0F, -5.0F, -2.094395F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("upper_body", CubeListBuilder.create().texOffs(3, 2).addBox(-3.0F, -6.0F, -5.0F, 6.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 16.0F, -4.0F, -0.5235988F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -6.0F, 8.0F, 6.0F, 7.0F), PartPose.offset(-1.0F, 13.0F, 3.0F));
        partDefinition.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(3, 1).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 10.0F, 4.0F, -0.5235988F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(20, 11).addBox(-1.0F, 0.0F, 6.0F, 2.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 10.0F, 4.0F, -0.6981317F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_thigh", CubeListBuilder.create().texOffs(48, 12).addBox(-3.0F, -1.0F, -2.0F, 3.0F, 5.0F, 5.0F), PartPose.offset(-4.0F, 14.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(14, 8).addBox(-2.0F, 4.0F, -7.0F, 2.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(-4.0F, 14.0F, 0.0F, 0.994461F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(30, 26).addBox(-3.0F, 8.0F, -3.0F, 3.0F, 2.0F, 4.0F), PartPose.offset(-4.0F, 14.0F, 1.0F));
        partDefinition.addOrReplaceChild("right_hook_1", CubeListBuilder.create().texOffs(32, 7).addBox(-1.0F, 5.0F, 3.0F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-4.0F, 14.0F, 0.0F, -0.8726646F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_hook_2", CubeListBuilder.create().texOffs(32, 7).addBox(-1.0F, -5.0F, 5.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-4.0F, 14.0F, 0.0F, -2.6529F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_bicep", CubeListBuilder.create().texOffs(43, 11).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 3.0F, 3.0F), PartPose.offset(-3.0F, 12.0F, -6.0F));
        partDefinition.addOrReplaceChild("right_hand", CubeListBuilder.create().texOffs(20, 18).addBox(-2.0F, 2.0F, -4.0F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-3.0F, 12.0F, -6.0F, 0.994461F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_thigh", CubeListBuilder.create().texOffs(48, 1).addBox(0.0F, -1.0F, -2.0F, 3.0F, 5.0F, 5.0F), PartPose.offset(4.0F, 14.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(14, 8).addBox(0.0F, 4.0F, -7.0F, 2.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(4.0F, 14.0F, 0.0F, 0.994461F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(30, 26).addBox(0.0F, 8.0F, -3.0F, 3.0F, 2.0F, 4.0F), PartPose.offset(4.0F, 14.0F, 1.0F));
        partDefinition.addOrReplaceChild("left_hook_1", CubeListBuilder.create().texOffs(32, 7).addBox(0.0F, 5.0F, 3.0F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(4.0F, 14.0F, 0.0F, -0.8726646F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_hook_2", CubeListBuilder.create().texOffs(32, 7).addBox(0.0F, -5.0F, 5.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(4.0F, 14.0F, 0.0F, -2.6529F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_bicep", CubeListBuilder.create().texOffs(43, 0).addBox(0.0F, -1.0F, -1.0F, 2.0F, 3.0F, 3.0F), PartPose.offset(3.0F, 12.0F, -6.0F));
        partDefinition.addOrReplaceChild("left_hand", CubeListBuilder.create().texOffs(20, 18).addBox(0.0F, 2.0F, -4.0F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(3.0F, 12.0F, -6.0F, 0.994461F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    @Override
    public void setupAnim(Dinosaur dinosaur, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.rightThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 0.9948377F;
        this.rightFoot.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightHook1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.8726646F;
        this.rightHook2.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 2.617994F;
        this.leftThigh.xRot = Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount;
        this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount + 0.9948377F;
        this.leftFoot.xRot = Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount;
        this.leftHook1.xRot = Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.8726646F;
        this.leftHook2.xRot = Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 2.617994F;
        this.rightBicep.xRot = Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount;
        this.rightHand.xRot = Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount + 0.994461F;
        this.leftBicep.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftHand.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 0.994461F;

        if (Math.abs(this.leftThigh.xRot) >= 0.174532F) {
            this.tailUpper();
        } else {
            this.tailLower();
        }

        if (Math.abs(this.leftThigh.xRot) >= 0.174532F) {
            this.headLower();
        } else {
            this.headUpper();
        }
    }

    private void tailUpper() {
        if (this.lowerBody.xRot < 0) {
            this.lowerBody.xRot += (0.5235988F / 10);
        } else {
            this.lowerBody.xRot = 0F;
        }
        if (this.tail.xRot < 0) {
            this.tail.xRot += (0.6981317F / 10);
        } else {
            this.tail.xRot = 0F;
        }
    }

    private void tailLower() {
        if (this.lowerBody.xRot > -0.5235988F) {
            this.lowerBody.xRot -= (0.5235988F / 10);
        } else {
            this.lowerBody.xRot = -0.5235988F;
        }
        if (this.tail.xRot > -0.6981317F) {
            this.tail.xRot -= (0.6981317F / 10);
        } else {
            this.tail.xRot = -0.6981317F;
        }
    }

    private void headLower() {
        if (this.upperBody.z < -3) {
            this.upperBody.z += 0.1;
        } else {
            this.upperBody.z = -3;
        }

        if (this.upperBody.xRot < 0) {
            this.upperBody.xRot += (0.5235988F / 10);
        } else {
            this.upperBody.xRot = 0F;
        }

        if (this.neck.z > -8) {
            this.neck.z -= (3 / 10);
        } else {
            this.neck.z = -8;
        }

        if (this.neck.xRot < 0) {
            this.neck.xRot += (2.094395F / 10);
        } else {
            this.neck.xRot = 0F;
        }

        if (this.head.y < 15) {
            this.head.y += 1;
        } else {
            this.head.y = 15;
        }

        if (this.head.z > -12) {
            this.head.z -= (9 / 10);
        } else {
            this.head.z = -12;
        }

        if (this.snout.y < 15) {
            this.snout.y += 1;
        } else {
            this.snout.y = 15;
        }

        if (this.snout.z > -20) {
            this.snout.z -= (9 / 10);
        } else {
            this.snout.z = -20;
        }

        if (this.jaw.y < 15) {
            this.jaw.y += 1;
        } else {
            this.jaw.y = 15;
        }

        if (this.jaw.z > -19) {
            this.jaw.z -= (9 / 10);
        } else {
            this.jaw.z = -19;
        }
    }

    private void headUpper() {
        if (this.upperBody.z > -4) {
            this.upperBody.z -= 0.1;
        } else {
            this.upperBody.z = -4;
        }

        if (this.upperBody.xRot > -0.5235988F) {
            this.upperBody.xRot -= (0.5235988F / 10);
        } else {
            this.upperBody.xRot = -0.5235988F;
        }

        if (this.neck.z < -5) {
            this.neck.z += (3 / 10);
        } else {
            this.neck.z = -5;
        }

        if (this.neck.xRot > -2.094395F) {
            this.neck.xRot -= (2.094395F / 10);
        } else {
            this.neck.xRot = -2.094395F;
        }

        if (this.head.y > 5) {
            this.head.y -= 1;
        } else {
            this.head.y = 5;
        }

        if (this.head.z < -3) {
            this.head.z += (9 / 10);
        } else {
            this.head.z = -3;
        }

        if (this.snout.y > 5) {
            this.snout.y -= 1;
        } else {
            this.snout.y = 5;
        }

        if (this.snout.z < -11) {
            this.snout.z += (9 / 10);
        } else {
            this.snout.z = -11;
        }

        if (this.jaw.y > 5) {
            this.jaw.y -= 1;
        } else {
            this.jaw.y = 5;
        }

        if (this.jaw.z < -10) {
            this.jaw.z += (9 / 10);
        } else {
            this.jaw.z = -10;
        }
    }
}
