package willatendo.fossilslegacy.experiments.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.experiments.client.FossilsExperimentsModels;
import willatendo.fossilslegacy.experiments.client.model.CarnotaurusModel;
import willatendo.fossilslegacy.experiments.server.entity.Carnotaurus;
import willatendo.fossilslegacy.server.entity.Triceratops;

public class CarnotaurusRenderer extends MobRenderer<Carnotaurus, CarnotaurusModel> {
    public CarnotaurusRenderer(EntityRendererProvider.Context context) {
        super(context, new CarnotaurusModel(context.bakeLayer(FossilsExperimentsModels.CARNOTAURUS)), 0.15F);
    }

    @Override
    public void render(Carnotaurus carnotaurus, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        this.shadowRadius = 0.15F * (float) carnotaurus.getGrowthStage();
        super.render(carnotaurus, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
    }

    @Override
    protected void scale(Carnotaurus carnotaurus, PoseStack poseStack, float packedOverlay) {
        poseStack.scale(0.5F + (0.3F * (float) carnotaurus.getGrowthStage()), 0.5F + (0.3F * (float) carnotaurus.getGrowthStage()), 0.5F + (0.3F * (float) carnotaurus.getGrowthStage()));
        super.scale(carnotaurus, poseStack, packedOverlay);
    }

    @Override
    public ResourceLocation getTextureLocation(Carnotaurus carnotaurus) {
        return carnotaurus.textures()[carnotaurus.getSubSpecies()][0];
    }
}
