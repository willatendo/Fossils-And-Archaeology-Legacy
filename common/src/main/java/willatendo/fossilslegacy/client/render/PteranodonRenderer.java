package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.pteranodon.AbstractPteranodonModel;
import willatendo.fossilslegacy.client.model.pteranodon.FlyingPteranodonModel;
import willatendo.fossilslegacy.client.model.pteranodon.GroundPteranodonModel;
import willatendo.fossilslegacy.client.model.pteranodon.LandingPteranodonModel;
import willatendo.fossilslegacy.server.entity.Pteranodon;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class PteranodonRenderer extends DinosaurRenderer<Pteranodon, AbstractPteranodonModel> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/animals/pteranodon/pteranodon.png");
    private final GroundPteranodonModel groundPteranodonLegacyModel;
    private final FlyingPteranodonModel flyingPteranodonLegacyModel;
    private final LandingPteranodonModel landingPteranodonModel;

    public PteranodonRenderer(Context context) {
        super(context, new GroundPteranodonModel(context.bakeLayer(FossilsLegacyModels.GROUND_PTERANODON)), 0.5F);
        this.groundPteranodonLegacyModel = new GroundPteranodonModel(context.bakeLayer(FossilsLegacyModels.GROUND_PTERANODON));
        this.flyingPteranodonLegacyModel = new FlyingPteranodonModel(context.bakeLayer(FossilsLegacyModels.FLYING_PTERANODON));
        this.landingPteranodonModel = new LandingPteranodonModel(context.bakeLayer(FossilsLegacyModels.LANDING_PTERANODON));

        this.shadowModification = 0.125F;
    }

    @Override
    public void render(Pteranodon pteranodon, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        this.model = pteranodon.landing ? this.landingPteranodonModel : pteranodon.shouldFly() ? this.flyingPteranodonLegacyModel : this.groundPteranodonLegacyModel;
        super.render(pteranodon, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
    }

    @Override
    public ResourceLocation getTextureLocation(Pteranodon pteranodon) {
        return TEXTURE;
    }
}
