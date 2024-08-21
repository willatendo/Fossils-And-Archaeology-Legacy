package willatendo.fossilslegacy.client.model.dinosaur;// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.animation.FutabasaurusAnimations;
import willatendo.fossilslegacy.client.model.dinosaur.base.BaseFutabasaurusModel;
import willatendo.fossilslegacy.server.entity.Futabasaurus;

public class FutabasaurusModel extends BaseFutabasaurusModel {
    private final ModelPart neck;
    private final ModelPart middleNeck;
    private final ModelPart head;

    public FutabasaurusModel(ModelPart root) {
        super(root);
        this.neck = root.getChild("neck");
        this.middleNeck = this.neck.getChild("middle_neck");
        this.head = this.middleNeck.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(35, 33).addBox(-3.0F, -6.0F, -11.0F, 6.0F, 5.0F, 5.0F).texOffs(0, 0).addBox(-2.0F, -5.0F, -6.0F, 4.0F, 3.0F, 4.0F), PartPose.offset(0.0F, 24.0F, 17.0F));
        PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -2.5F, -10.0F, 6.0F, 5.0F, 10.0F), PartPose.offset(0.0F, 20.5F, -6.0F));
        PartDefinition middle_neck = neck.addOrReplaceChild("middle_neck", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.5F, -16.0F, 4.0F, 3.0F, 16.0F), PartPose.offset(0.0F, 0.0F, -10.0F));
        middle_neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 15).addBox(-3.0F, -2.5F, -8.0F, 6.0F, 5.0F, 8.0F), PartPose.offset(0.0F, 0.0F, -16.0F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -1.0F, -2.0F, 5.0F, 2.0F, 4.0F), PartPose.offset(-4.0F, 23.0F, -3.0F));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 43).addBox(0.0F, -1.0F, -2.0F, 5.0F, 2.0F, 4.0F), PartPose.offset(4.0F, 23.0F, -3.0F));
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(18, 39).addBox(-5.0F, -1.0F, -2.0F, 5.0F, 2.0F, 4.0F), PartPose.offset(-4.0F, 23.0F, 3.0F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 44).addBox(0.0F, -1.0F, -2.0F, 5.0F, 2.0F, 4.0F), PartPose.offset(4.0F, 23.0F, 3.0F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 19).addBox(-4.0F, -7.0F, -6.0F, 8.0F, 7.0F, 12.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }


    @Override
    public void setupAnim(Futabasaurus futabasaurus, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        netHeadYaw = Mth.clamp(netHeadYaw, -30.0F, 30.0F);
        headPitch = Mth.clamp(headPitch, -25.0F, 45.0F);

        this.neck.yRot = netHeadYaw * 0.017453292F;
        this.neck.xRot = headPitch * 0.017453292F;
        this.middleNeck.yRot = netHeadYaw * 0.017453292F;
        this.middleNeck.xRot = headPitch * 0.017453292F;
        this.head.yRot = netHeadYaw * 0.017453292F;
        this.head.xRot = headPitch * 0.017453292F;

        if (futabasaurus.isInWaterOrBubble()) {
            this.animateWalk(FutabasaurusAnimations.FUTABASAURUS_SWIM, limbSwing, limbSwingAmount, 2.0F, 2.5F);
        } else {
            this.animateWalk(FutabasaurusAnimations.FUTABASAURUS_WALK, limbSwing, limbSwingAmount, 2.0F, 2.5F);
        }
    }
}