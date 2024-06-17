package willatendo.fossilslegacy.client.model.fossils;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import willatendo.fossilslegacy.server.entity.Fossil;

public abstract class AbstractSkeletonModel extends EntityModel<Fossil> {
    private final ModelPart root;

    public AbstractSkeletonModel(ModelPart root) {
        this.root = root;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int red, int green, int blue) {
        this.root.render(poseStack, vertexConsumer, red, green, blue);
    }

    @Override
    public void setupAnim(Fossil fossil, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}
