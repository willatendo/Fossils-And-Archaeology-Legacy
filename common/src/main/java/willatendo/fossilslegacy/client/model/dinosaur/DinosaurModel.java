package willatendo.fossilslegacy.client.model.dinosaur;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;

public abstract class DinosaurModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart root;

    public DinosaurModel(ModelPart root) {
        this.root = root;
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public abstract void setupAnim(T dinosaur, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch);

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}
