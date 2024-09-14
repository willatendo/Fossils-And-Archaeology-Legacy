package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.pteranodon.AbstractPteranodonModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.pteranodon.FlyingPteranodonModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.pteranodon.GroundPteranodonModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.pteranodon.LandingPteranodonModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.Pteranodon;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class PteranodonRenderer extends MobRenderer<Dinosaur, AbstractPteranodonModel> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entity/pteranodon/pteranodon.png");
    private final GroundPteranodonModel groundPteranodonLegacyModel;
    private final FlyingPteranodonModel flyingPteranodonLegacyModel;
    private final LandingPteranodonModel landingPteranodonModel;

    public PteranodonRenderer(Context context) {
        super(context, new GroundPteranodonModel(context.bakeLayer(FossilsLegacyModelLayers.PTERANODON_GROUND)), 0.5F);
        this.groundPteranodonLegacyModel = new GroundPteranodonModel(context.bakeLayer(FossilsLegacyModelLayers.PTERANODON_GROUND));
        this.flyingPteranodonLegacyModel = new FlyingPteranodonModel(context.bakeLayer(FossilsLegacyModelLayers.PTERANODON_FLYING));
        this.landingPteranodonModel = new LandingPteranodonModel(context.bakeLayer(FossilsLegacyModelLayers.PTERANODON_LANDING));

    }

    @Override
    public void render(Dinosaur dinosaur, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        Pteranodon pteranodon = (Pteranodon) dinosaur;
        this.model = pteranodon.landing ? this.landingPteranodonModel : pteranodon.shouldFly() ? this.flyingPteranodonLegacyModel : this.groundPteranodonLegacyModel;
        super.render(dinosaur, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
    }

    @Override
    public ResourceLocation getTextureLocation(Dinosaur dinosaur) {
        return TEXTURE;
    }
}
