package willatendo.fossilslegacy.client.model.dinosaur;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import willatendo.fossilslegacy.server.entity.Dinosaur;

public class MoaModel extends HierarchicalModel<Dinosaur> {
    private final ModelPart root;

    public MoaModel(ModelPart root) {
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(34, 19).addBox(-2.0F, 3.0F, -0.5F, 2.0F, 5.0F, 2.0F).texOffs(34, 7).addBox(-2.0F, -1.0F, -1.5F, 2.0F, 4.0F, 3.0F), PartPose.offset(-1.0F, 16.0F, 1.5F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(34, 0).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 4.0F, 3.0F).texOffs(16, 31).addBox(-1.0F, 3.0F, -0.5F, 2.0F, 5.0F, 2.0F), PartPose.offset(2.0F, 16.0F, 1.5F));
        PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(24, 17).addBox(-1.0F, -13.0F, -2.5F, 2.0F, 15.0F, 3.0F), PartPose.offset(0.0F, 9.0F, -4.5F));
        neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 31).addBox(-2.0F, -3.0F, -3.25F, 4.0F, 4.0F, 4.0F).texOffs(34, 14).addBox(-1.0F, -2.0F, -6.25F, 2.0F, 2.0F, 3.0F), PartPose.offset(0.0F, -12.0F, -1.25F));
        partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -17.0F, -5.0F, 8.0F, 8.0F, 9.0F).texOffs(0, 17).addBox(-3.0F, -16.0F, 3.0F, 6.0F, 8.0F, 6.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Dinosaur dinosaur, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int red, int green, int blue) {
        this.root.render(poseStack, vertexConsumer, red, green, blue);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}