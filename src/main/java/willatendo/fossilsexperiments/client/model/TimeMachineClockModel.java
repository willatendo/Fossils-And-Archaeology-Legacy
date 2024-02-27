package willatendo.fossilsexperiments.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;

public class TimeMachineClockModel extends Model {
	private final ModelPart root;
	private final ModelPart arm1;
	private final ModelPart arm2;

	public TimeMachineClockModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		ModelPart face = root.getChild("face");
		this.arm1 = face.getChild("arm_1");
		this.arm2 = face.getChild("arm_2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("clock_outline_1", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -6.0F, -1.0F, 9.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 17.5F, 0.0F));
		partdefinition.addOrReplaceChild("clock_outline_2", CubeListBuilder.create().texOffs(0, 0).addBox(-3.7929F, -5.9142F, -1.0F, 9.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 17.5F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition face = partdefinition.addOrReplaceChild("face", CubeListBuilder.create().texOffs(0, 11).addBox(-4.5F, -5.5F, 0.25F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(16, 11).addBox(-1.5F, -2.5F, -0.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 17.5F, -0.25F));
		face.addOrReplaceChild("arm_1", CubeListBuilder.create().texOffs(18, 14).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -1.5F, 0.25F));
		face.addOrReplaceChild("arm_2", CubeListBuilder.create().texOffs(16, 14).addBox(-0.5F, -3.0F, -0.7F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -1.5F, 0.25F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int u, int v, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, u, v, red, green, blue, alpha);
	}

	public void setTime(float hourAngle, float minuteAngle) {
		if (hourAngle <= Math.PI) {
			this.arm2.zRot = hourAngle;
		} else {
			this.arm2.zRot = (float) (hourAngle - 2 * Math.PI);
		}
		if (minuteAngle <= Math.PI) {
			this.arm1.zRot = minuteAngle;
		} else {
			this.arm1.zRot = (float) (minuteAngle - 2 * Math.PI);
		}
	}
}