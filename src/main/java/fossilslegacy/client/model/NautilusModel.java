package fossilslegacy.client.model;

import fossilslegacy.server.entity.Nautilus;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class NautilusModel extends HierarchicalModel<Nautilus> {
	private final ModelPart root;

	public NautilusModel(ModelPart root) {
		this.root = root;
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("tentacle_1", CubeListBuilder.create().texOffs(26, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 21.0F, -4.5F));

		partdefinition.addOrReplaceChild("tentacle_2", CubeListBuilder.create().texOffs(22, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 20.0F, -5.5F));

		partdefinition.addOrReplaceChild("tentacle_3", CubeListBuilder.create().texOffs(24, 20).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 19.0F, -6.5F));

		partdefinition.addOrReplaceChild("tentacle_4", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 21.0F, -4.5F));

		partdefinition.addOrReplaceChild("tentacle_5", CubeListBuilder.create().texOffs(4, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 20.0F, -5.5F));

		partdefinition.addOrReplaceChild("tentacle_6", CubeListBuilder.create().texOffs(18, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 19.0F, -6.5F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -10.0F, -4.0F, 4.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		body.addOrReplaceChild("cap", CubeListBuilder.create().texOffs(0, 20).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -2.0F, -0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}

	@Override
	public void setupAnim(Nautilus nautilus, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}