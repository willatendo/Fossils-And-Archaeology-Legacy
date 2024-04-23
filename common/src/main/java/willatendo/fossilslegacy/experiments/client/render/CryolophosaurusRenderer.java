package willatendo.fossilslegacy.experiments.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.experiments.client.FossilsExperimentsModels;
import willatendo.fossilslegacy.experiments.client.model.CarnotaurusModel;
import willatendo.fossilslegacy.experiments.client.model.CryolophosaurusModel;
import willatendo.fossilslegacy.experiments.server.entity.Carnotaurus;
import willatendo.fossilslegacy.experiments.server.entity.Cryolophosaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class CryolophosaurusRenderer extends MobRenderer<Cryolophosaurus, CryolophosaurusModel> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/animals/cryolophosaurus/cryolophosaurus.png");

    public CryolophosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, new CryolophosaurusModel(context.bakeLayer(FossilsExperimentsModels.CRYOLOPHOSAURUS)), 0.15F);
    }

    @Override
    public void render(Cryolophosaurus cryolophosaurus, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        this.shadowRadius = 0.15F * (float) cryolophosaurus.getGrowthStage();
        super.render(cryolophosaurus, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
    }

    @Override
    protected void scale(Cryolophosaurus cryolophosaurus, PoseStack poseStack, float packedOverlay) {
        poseStack.scale(0.25F + (0.2F * (float) cryolophosaurus.getGrowthStage()), 0.25F + (0.2F * (float) cryolophosaurus.getGrowthStage()), 0.25F + (0.2F * (float) cryolophosaurus.getGrowthStage()));
        super.scale(cryolophosaurus, poseStack, packedOverlay);
    }

    @Override
    public ResourceLocation getTextureLocation(Cryolophosaurus cryolophosaurus) {
        return TEXTURE;
    }
}
