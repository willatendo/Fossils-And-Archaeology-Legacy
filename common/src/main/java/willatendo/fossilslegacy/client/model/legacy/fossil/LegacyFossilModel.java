package willatendo.fossilslegacy.client.model.legacy.fossil;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import willatendo.fossilslegacy.server.entity.entities.Fossil;

public class LegacyFossilModel extends EntityModel<Fossil> {
    private final ModelPart root;

    public LegacyFossilModel(ModelPart root) {
        this.root = root;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public void setupAnim(Fossil fossil, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}