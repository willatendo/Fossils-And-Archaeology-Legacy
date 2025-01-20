package willatendo.fossilslegacy.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;

public class FetusModel extends Model {
    private final ModelPart root;

    public FetusModel(ModelPart root) {
        super(RenderType::entityCutoutNoCull);
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("fetus", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -11.0F, 0.0F, 2.0F, 11.0F, 3.0F).texOffs(10, 6).addBox(-1.0F, -11.0F, -3.0F, 2.0F, 3.0F, 3.0F).texOffs(10, 12).addBox(1.0F, -4.0F, -2.0F, 2.0F, 2.0F, 3.0F).texOffs(0, 14).addBox(1.0F, -7.0F, -2.0F, 2.0F, 2.0F, 3.0F).texOffs(10, 17).addBox(-3.0F, -4.0F, -2.0F, 2.0F, 2.0F, 3.0F).texOffs(0, 19).addBox(-3.0F, -7.0F, -2.0F, 2.0F, 2.0F, 3.0F).texOffs(10, 0).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}
