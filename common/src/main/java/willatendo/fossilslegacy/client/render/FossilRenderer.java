package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.fossils.*;
import willatendo.fossilslegacy.server.entity.Fossil;
import willatendo.fossilslegacy.server.entity.FossilsLegacyFossilVariants;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant.FossilScaleFactor;

import java.util.HashMap;
import java.util.Map;

public class FossilRenderer extends MobRenderer<Fossil, AbstractSkeletonModel> {
    public static final Map<FossilVariant, AbstractSkeletonModel> MODELS = new HashMap<FossilVariant, AbstractSkeletonModel>();

    public FossilRenderer(Context context) {
        super(context, new BrachiosaurusSkeletonModel(context.bakeLayer(FossilsLegacyModels.BRACHIOSAURUS_SKELETON)), 0.5F);
        MODELS.put(FossilsLegacyFossilVariants.BRACHIOSAURUS.get(), new BrachiosaurusSkeletonModel(context.bakeLayer(FossilsLegacyModels.BRACHIOSAURUS_SKELETON)));
        MODELS.put(FossilsLegacyFossilVariants.FUTABASAURUS.get(), new FutabasaurusSkeletonModel(context.bakeLayer(FossilsLegacyModels.PLESIOSAURUS_SKELETON)));
        MODELS.put(FossilsLegacyFossilVariants.PTERANODON.get(), new PteranodonSkeletonModel(context.bakeLayer(FossilsLegacyModels.PTERANODON_SKELETON)));
        MODELS.put(FossilsLegacyFossilVariants.TRICERATOPS.get(), new TriceratopsSkeletonModel(context.bakeLayer(FossilsLegacyModels.TRICERATOPS_SKELETON)));
    }

    @Override
    public void render(Fossil fossil, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        this.shadowRadius = 0.15F * (float) fossil.getSize();
        this.model = MODELS.get(fossil.getFossilVariant());

        super.render(fossil, packedOverlay, packedLight, poseStack, multiBufferSource, partialTicks);
    }

    @Override
    protected void scale(Fossil fossil, PoseStack poseStack, float packedOverlay) {
        FossilVariant fossilVariant = fossil.getFossilVariant().value();
        FossilScaleFactor scaleFactor = fossilVariant.getScaleFactor(fossil);

        poseStack.scale(scaleFactor.x(), scaleFactor.y(), scaleFactor.z());

        super.scale(fossil, poseStack, packedOverlay);
    }

    @Override
    public ResourceLocation getTextureLocation(Fossil fossil) {
        return fossil.getFossilVariant().value().fossilTexture();
    }
}
