package willatendo.fossilslegacy.client.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.state.ThrownJavelinRenderState;

public class JavelinModel extends EntityModel<ThrownJavelinRenderState> {
    public JavelinModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("cross_2", CubeListBuilder.create().texOffs(0, 0).addBox(-20.0F, -5.0F, -0.5F, 36.0F, 10.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 20.5F, -4.0F, -0.7854F, 1.5708F, 0.0F));
        partDefinition.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -4.5F, -5.0F, 0.0F, 10.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 20.5F, 7.0F, -2.3562F, 1.5708F, 0.0F));
        partDefinition.addOrReplaceChild("cross_1", CubeListBuilder.create().texOffs(0, 0).addBox(-20.0F, -4.5F, 0.0F, 36.0F, 10.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 20.5F, -4.0F, -2.3562F, 1.5708F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    public void setupAnim(ThrownJavelinRenderState thrownJavelinRenderState) {
        super.setupAnim(thrownJavelinRenderState);
        if (thrownJavelinRenderState.shake > 0.0F) {
            this.root.zRot += -Mth.sin(thrownJavelinRenderState.shake * 3.0F) * thrownJavelinRenderState.shake * 0.017453292F;
        }
    }
}
