package willatendo.fossilslegacy.client.model.vehicle;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import willatendo.fossilslegacy.client.state.JeepRenderState;

public class JeepModel extends EntityModel<JeepRenderState> {
    public JeepModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("front", CubeListBuilder.create().texOffs(142, 57).addBox(-14.0F, -5.5F, -4.1429F, 4.0F, 8.0F, 2.0F).texOffs(44, 97).addBox(-10.0F, -5.5F, -4.1429F, 20.0F, 10.0F, 2.0F).texOffs(98, 142).addBox(10.0F, -5.5F, -4.1429F, 4.0F, 8.0F, 2.0F).texOffs(0, 26).addBox(-14.0F, -5.5F, -2.1429F, 28.0F, 6.0F, 10.0F).texOffs(0, 54).addBox(-10.0F, 0.5F, -2.1429F, 20.0F, 4.0F, 10.0F).texOffs(108, 4).addBox(-14.0F, 3.5F, -6.1429F, 28.0F, 2.0F, 2.0F).texOffs(88, 68).addBox(-14.0F, -5.5F, 7.8571F, 28.0F, 9.0F, 2.0F), PartPose.offset(0.0F, 14.5F, -20.8571F));
        partDefinition.addOrReplaceChild("back", CubeListBuilder.create().texOffs(44, 109).addBox(12.8F, -6.25F, -9.2F, 2.0F, 6.0F, 15.0F).texOffs(88, 79).addBox(-11.2F, -2.25F, 0.8F, 24.0F, 6.0F, 5.0F).texOffs(78, 112).addBox(-13.2F, -6.25F, -9.2F, 2.0F, 6.0F, 15.0F).texOffs(0, 42).addBox(-11.2F, -2.25F, -9.2F, 24.0F, 2.0F, 10.0F).texOffs(98, 133).addBox(12.8F, -0.25F, 0.8F, 2.0F, 4.0F, 5.0F).texOffs(28, 119).addBox(-13.2F, -0.25F, 0.8F, 2.0F, 4.0F, 5.0F).texOffs(60, 54).addBox(-9.2F, -0.25F, -9.2F, 20.0F, 4.0F, 10.0F).texOffs(120, 57).addBox(-8.2F, 3.75F, 0.8F, 2.0F, 2.0F, 9.0F).texOffs(76, 26).addBox(-13.2F, -6.25F, -11.2F, 28.0F, 9.0F, 2.0F).texOffs(68, 42).addBox(-13.2F, -6.25F, 5.8F, 28.0F, 10.0F, 2.0F), PartPose.offset(-0.8F, 15.25F, 20.2F));
        partDefinition.addOrReplaceChild("right_door", CubeListBuilder.create().texOffs(0, 68).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 20.0F), PartPose.offset(13.0F, 18.0F, -10.0F));
        partDefinition.addOrReplaceChild("left_door", CubeListBuilder.create().texOffs(44, 68).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 20.0F), PartPose.offset(-13.0F, 18.0F, -10.0F));
        partDefinition.addOrReplaceChild("back_axel", CubeListBuilder.create().texOffs(28, 130).addBox(-15.0F, -4.0F, -4.0F, 4.0F, 8.0F, 8.0F).texOffs(108, 19).addBox(-11.0F, -1.0F, -1.0F, 22.0F, 2.0F, 2.0F).texOffs(128, 41).addBox(11.0F, -4.0F, -4.0F, 4.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 20.0F, 16.0F));
        partDefinition.addOrReplaceChild("back_tire", CubeListBuilder.create().texOffs(132, 90).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 8.0F, 4.0F), PartPose.offset(0.0F, 13.0F, 30.0F));
        PartDefinition frame = partDefinition.addOrReplaceChild("frame", CubeListBuilder.create().texOffs(16, 145).addBox(-14.0F, -2.0F, 16.0F, 2.0F, 8.0F, 2.0F).texOffs(76, 145).addBox(12.0F, -2.0F, 16.0F, 2.0F, 8.0F, 2.0F).texOffs(0, 119).addBox(12.0F, -7.0F, 1.0F, 2.0F, 2.0F, 12.0F).texOffs(112, 116).addBox(-14.0F, -7.0F, 1.0F, 2.0F, 2.0F, 12.0F).texOffs(0, 145).addBox(-14.0F, -5.0F, -1.0F, 2.0F, 11.0F, 2.0F).texOffs(108, 0).addBox(-14.0F, -7.0F, -1.0F, 28.0F, 2.0F, 2.0F).texOffs(88, 90).addBox(-14.0F, -7.0F, -21.0F, 2.0F, 2.0F, 20.0F).texOffs(0, 97).addBox(12.0F, -7.0F, -21.0F, 2.0F, 2.0F, 20.0F).texOffs(8, 145).addBox(12.0F, -5.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offset(0.0F, 3.0F, 10.0F));
        frame.addOrReplaceChild("tilted_frame", CubeListBuilder.create().texOffs(140, 116).addBox(3.0F, -5.8247F, -4.4287F, 2.0F, 2.0F, 7.0F).texOffs(132, 102).addBox(-23.0F, -5.8247F, -4.4287F, 2.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(9.0F, 0.325F, 12.05F, -0.7854F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("windshield", CubeListBuilder.create().texOffs(144, 142).addBox(-14.0F, -11.0F, -1.0F, 2.0F, 11.0F, 2.0F).texOffs(76, 37).addBox(-14.0F, -13.0F, -1.0F, 28.0F, 2.0F, 2.0F).texOffs(136, 142).addBox(12.0F, -11.0F, -1.0F, 2.0F, 11.0F, 2.0F).texOffs(108, 8).addBox(-12.0F, -11.0F, 0.0F, 24.0F, 11.0F, 0.0F), PartPose.offset(0.0F, 9.0F, -12.0F));
        partDefinition.addOrReplaceChild("front_axel", CubeListBuilder.create().texOffs(112, 130).addBox(11.0F, -4.0F, -4.0F, 4.0F, 8.0F, 8.0F).texOffs(112, 112).addBox(-11.0F, -1.0F, -1.0F, 22.0F, 2.0F, 2.0F).texOffs(52, 130).addBox(-15.0F, -4.0F, -4.0F, 4.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 20.0F, -18.0F));
        partDefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(142, 35).addBox(14.0F, -6.0F, -24.0F, 1.0F, 4.0F, 2.0F).texOffs(136, 23).addBox(14.0F, -6.0F, -22.0F, 1.0F, 2.0F, 10.0F).texOffs(30, 146).addBox(14.0F, -6.0F, -12.0F, 1.0F, 5.0F, 2.0F).texOffs(36, 146).addBox(14.0F, -6.0F, 10.0F, 1.0F, 5.0F, 2.0F).texOffs(136, 130).addBox(14.0F, -6.0F, 12.0F, 1.0F, 2.0F, 10.0F).texOffs(84, 145).addBox(14.0F, -6.0F, 22.0F, 1.0F, 6.0F, 2.0F).texOffs(0, 0).addBox(-15.0F, -1.0F, -12.0F, 30.0F, 2.0F, 24.0F).texOffs(24, 146).addBox(-15.0F, -6.0F, 10.0F, 1.0F, 5.0F, 2.0F).texOffs(76, 133).addBox(-15.0F, -6.0F, 12.0F, 1.0F, 2.0F, 10.0F).texOffs(22, 133).addBox(-15.0F, -6.0F, 22.0F, 1.0F, 6.0F, 2.0F).texOffs(0, 133).addBox(-15.0F, -6.0F, -22.0F, 1.0F, 2.0F, 10.0F).texOffs(136, 35).addBox(-15.0F, -6.0F, -24.0F, 1.0F, 4.0F, 2.0F).texOffs(90, 145).addBox(-15.0F, -6.0F, -12.0F, 1.0F, 5.0F, 2.0F), PartPose.offset(0.0F, 19.0F, -1.0F));

        return LayerDefinition.create(meshDefinition, 256, 256);
    }
}
