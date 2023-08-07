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
import willatendo.fossilslegacy.client.animation.MammothAnimations;
import willatendo.fossilslegacy.server.entity.Mammoth;

public class MammothModel extends HierarchicalModel<Mammoth> {
	private final ModelPart root;
	private final ModelPart head;

	public MammothModel(ModelPart root) {
		this.root = root;
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();

		partDefinition.addOrReplaceChild("back_left_foot", CubeListBuilder.create().texOffs(52, 69).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F), PartPose.offset(3.0F, 12.0F, 9.0F));
		partDefinition.addOrReplaceChild("back_right_foot", CubeListBuilder.create().texOffs(16, 69).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F), PartPose.offset(-3.0F, 12.0F, 9.0F));
		partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 27).addBox(-14.0F, 0.5F, 8.0F, 14.0F, 5.0F, 14.0F).texOffs(0, 0).addBox(-14.0F, -12.5F, 8.0F, 14.0F, 13.0F, 14.0F).texOffs(56, 32).addBox(-13.0F, -7.5F, 22.0F, 12.0F, 8.0F, 6.0F).texOffs(0, 59).addBox(-13.0F, 0.5F, 22.0F, 12.0F, 4.0F, 6.0F), PartPose.offset(7.0F, 14.5F, -16.0F));
		partDefinition.addOrReplaceChild("front_left_foot", CubeListBuilder.create().texOffs(0, 69).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F), PartPose.offset(3.0F, 12.0F, -4.0F));
		partDefinition.addOrReplaceChild("front_right_foot", CubeListBuilder.create().texOffs(36, 59).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F), PartPose.offset(-3.0F, 12.0F, -4.0F));
		PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(54, 49).addBox(-4.0F, -8.0F, -6.0F, 8.0F, 10.0F, 10.0F).texOffs(44, 15).addBox(-5.0F, -9.0F, -7.0F, 10.0F, 5.0F, 12.0F).texOffs(42, 0).addBox(-5.0F, -4.0F, -7.0F, 10.0F, 2.0F, 12.0F), PartPose.offset(0.0F, 6.0F, -5.0F));
		head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(42, 32).addBox(-5.0F, -2.5F, 0.0F, 10.0F, 5.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -11.5F, -1.0F, 0.0F, 0.7854F, 0.0F));
		head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(76, 14).addBox(-5.0F, -2.5F, 0.0F, 10.0F, 5.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -11.5F, -1.0F, 0.0F, -0.7854F, 0.0F));
		head.addOrReplaceChild("right_tusk", CubeListBuilder.create().texOffs(0, 30).addBox(0.0F, 0.0F, -14.0F, 0.0F, 13.0F, 16.0F), PartPose.offsetAndRotation(-3.0F, 2.0F, -5.0F, 0.0F, 0.0F, 0.2182F));
		head.addOrReplaceChild("left_tusk", CubeListBuilder.create().texOffs(32, 30).addBox(0.0F, 0.0F, -14.0F, 0.0F, 13.0F, 16.0F), PartPose.offsetAndRotation(3.0F, 2.0F, -5.0F, 0.0F, 0.0F, -0.2182F));
		PartDefinition trunk = head.addOrReplaceChild("trunk", CubeListBuilder.create().texOffs(68, 69).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F), PartPose.offset(0.0F, 2.0F, -5.0F));
		trunk.addOrReplaceChild("lower_trunk", CubeListBuilder.create().texOffs(74, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F), PartPose.offset(0.0F, 7.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 128, 128);
	}

	@Override
	public void setupAnim(Mammoth mammoth, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(mammoth, netHeadYaw, headPitch, ageInTicks);
		float f = (float) mammoth.getDeltaMovement().horizontalDistanceSqr();
		float f1 = Mth.clamp(f * 400.0F, 0.3F, 2.0F);
		this.animate(mammoth.walkAnimationState, MammothAnimations.MAMMOTH_WALK, ageInTicks, f1);
		this.animate(mammoth.eatGrassAnimationState, MammothAnimations.MAMMOTH_EAT_GRASS, ageInTicks, 1.0F);
		this.animate(mammoth.attackAnimationState, MammothAnimations.MAMMOTH_ATTACK, ageInTicks, 1.0F);
	}

	private void applyHeadRotation(Mammoth mammoth, float x, float y, float z) {
		x = Mth.clamp(x, -30.0F, 30.0F);
		y = Mth.clamp(y, -25.0F, 45.0F);

		this.head.yRot = x * ((float) Math.PI / 180F);
		this.head.xRot = y * ((float) Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		if (this.young) {
			this.root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		} else {
			poseStack.pushPose();
			poseStack.scale(2.0F, 2.0F, 2.0F);
			poseStack.translate(0.0F, -0.75F, 0.0F);
			this.root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			poseStack.popPose();
		}
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}