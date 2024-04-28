package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.TherizinosaurusModel;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.entity.Therizinosaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class TherizinosaurusRenderer extends MobRenderer<Therizinosaurus, TherizinosaurusModel> {
    public static final ResourceLocation FEATHERED = FossilsLegacyUtils.resource("textures/entities/animals/therizinosaurus/feathered_therizinosaurus.png");
    public static final ResourceLocation FEATHERLESS = FossilsLegacyUtils.resource("textures/entities/animals/therizinosaurus/featherless_therizinosaurus.png");

    public TherizinosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, new TherizinosaurusModel(context.bakeLayer(FossilsLegacyModels.THERIZINOSAURUS)), 0.15F);
    }

    @Override
    public void render(Therizinosaurus therizinosaurus, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        this.shadowRadius = 0.15F * (float) therizinosaurus.getGrowthStage();
        super.render(therizinosaurus, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
    }

    @Override
    protected void scale(Therizinosaurus therizinosaurus, PoseStack poseStack, float packedOverlay) {
        poseStack.scale(0.5F + (0.3F * (float) therizinosaurus.getGrowthStage()), 0.5F + (0.3F * (float) therizinosaurus.getGrowthStage()), 0.5F + (0.3F * (float) therizinosaurus.getGrowthStage()));
        super.scale(therizinosaurus, poseStack, packedOverlay);
    }

    @Override
    public ResourceLocation getTextureLocation(Therizinosaurus therizinosaurus) {
        return FossilsModloaderHelper.INSTANCE.featheredDinosaurs() ? FEATHERED : FEATHERLESS;
    }
}
