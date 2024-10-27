package willatendo.fossilslegacy.client.model.dinosaur;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.server.entity.dinosaur.quaternary.Nautilus;

public class NautilusModel extends EntityModel<Nautilus> {
    private final ModelPart root;
    private final ModelPart tentacle1;
    private final ModelPart tentacle2;
    private final ModelPart tentacle3;
    private final ModelPart tentacle4;
    private final ModelPart tentacle5;
    private final ModelPart tentacle6;

    public NautilusModel(ModelPart root) {
        this.root = root;
        this.tentacle1 = root.getChild("tentacle_1");
        this.tentacle2 = root.getChild("tentacle_2");
        this.tentacle3 = root.getChild("tentacle_3");
        this.tentacle4 = root.getChild("tentacle_4");
        this.tentacle5 = root.getChild("tentacle_5");
        this.tentacle6 = root.getChild("tentacle_6");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(0, 12).addBox(-2.0F, -5.0F, -5.0F, 4.0F, 10.0F, 10.0F), PartPose.offset(0.0F, 19.0F, 0.0F));
        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 1.0F, -7.0F, 6.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 19.0F, 0.0F, -0.829F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("tentacle_1", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -3.0F, -3.0F, 1.0F, 8.0F, 1.0F), PartPose.offset(-1.0F, 22.0F, -6.0F));
        partDefinition.addOrReplaceChild("tentacle_2", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 8.0F, 1.0F), PartPose.offset(-1.0F, 22.0F, -6.0F));
        partDefinition.addOrReplaceChild("tentacle_3", CubeListBuilder.create().texOffs(0, 12).addBox(2.0F, -1.0F, -1.0F, 1.0F, 8.0F, 1.0F), PartPose.offset(-1.0F, 22.0F, -6.0F));
        partDefinition.addOrReplaceChild("tentacle_4", CubeListBuilder.create().texOffs(0, 12).addBox(3.0F, -2.0F, -2.0F, 1.0F, 8.0F, 1.0F), PartPose.offset(-2.0F, 22.0F, -6.0F));
        partDefinition.addOrReplaceChild("tentacle_5", CubeListBuilder.create().texOffs(0, 12).addBox(2.0F, -3.0F, -3.0F, 1.0F, 8.0F, 1.0F), PartPose.offset(-2.0F, 22.0F, -6.0F));
        partDefinition.addOrReplaceChild("tentacle_6", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, -1.0F, -1.0F, 1.0F, 8.0F, 1.0F), PartPose.offset(-2.0F, 22.0F, -6.0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    @Override
    public void setupAnim(Nautilus nautilus, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.tentacle1.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F + (float) 1) + 0.4F;
        this.tentacle2.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F + (float) 2) + 0.4F;
        this.tentacle3.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F + (float) 3) + 0.4F;
        this.tentacle4.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F + (float) 4) + 0.4F;
        this.tentacle5.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F + (float) 5) + 0.4F;
        this.tentacle6.xRot = 0.2F * Mth.sin(ageInTicks * 0.3F + (float) 6) + 0.4F;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int red, int green, int blue) {
        this.root.render(poseStack, vertexConsumer, red, green, blue);
    }
}
