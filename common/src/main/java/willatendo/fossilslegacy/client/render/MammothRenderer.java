package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.MammothModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.Mammoth;
import willatendo.fossilslegacy.server.entity.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.Optional;

public class MammothRenderer extends CoatTypeMobRenderer<Mammoth> {
    public MammothRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    protected void scale(Mammoth mammoth, PoseStack poseStack, float f) {
        if (!mammoth.isBaby()) {
            poseStack.scale(6.0F, 6.0F, 6.0F);
        }
        super.scale(mammoth, poseStack, f);
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(Mammoth mammoth, CoatType coatType) {
        return mammoth.isSheared() ? coatType.textures().shearedTexture() : Optional.empty();
    }
}
