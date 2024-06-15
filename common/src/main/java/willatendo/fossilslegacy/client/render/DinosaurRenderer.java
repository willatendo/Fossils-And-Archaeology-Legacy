package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import willatendo.fossilslegacy.server.entity.Dinosaur;

public abstract class DinosaurRenderer<T extends Dinosaur, M extends EntityModel<T>> extends MobRenderer<T, M> {
    protected float shadowModification = 0.15F;

    public DinosaurRenderer(EntityRendererProvider.Context context, M entityModel, float shadowScale) {
        super(context, entityModel, shadowScale);
    }

    @Override
    public void render(T dinosaur, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        this.shadowRadius = this.shadowModification * (float) dinosaur.getGrowthStage();
        super.render(dinosaur, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
    }

    @Override
    protected void scale(T dinosaur, PoseStack poseStack, float packedOverlay) {
        poseStack.scale(dinosaur.getXScaling(dinosaur), dinosaur.getYScaling(dinosaur), dinosaur.getXScaling(dinosaur));
        super.scale(dinosaur, poseStack, packedOverlay);
    }
}
