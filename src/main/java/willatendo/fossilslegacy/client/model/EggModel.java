package willatendo.fossilslegacy.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import willatendo.fossilslegacy.server.entity.Egg;

public class EggModel extends EntityModel<Egg> {
	private final ModelPart root;

	public EggModel(ModelPart root) {
		this.root = root;
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();

		partDefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(15, 13).addBox(-2.75F, -1.0F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 11).addBox(-2.75F, -8.0F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-3.25F, -6.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 18).addBox(-1.75F, -9.0F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 64, 64);
	}

	@Override
	public void setupAnim(Egg egg, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}