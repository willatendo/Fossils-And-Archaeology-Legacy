package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import willatendo.fossilslegacy.api.ModelIdentifierRegistry;
import willatendo.fossilslegacy.client.model.FossilsLegacyModelIdentifiers;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.genetics.CoatType;
import willatendo.fossilslegacy.server.entity.util.CoatTypeEntity;

import java.util.Map;

public class CoatTypeMobRenderer<T extends Dinosaur & CoatTypeEntity> extends MobRenderer<T, EntityModel<T>> {
    private final Map<ResourceLocation, EntityModel<? extends Entity>> models;

    public CoatTypeMobRenderer(EntityRendererProvider.Context context, EntityModel<T> baseModel, float shadowSize) {
        super(context, baseModel, shadowSize);
        this.models = ModelIdentifierRegistry.registerAllModels(context::bakeLayer);
    }

    @Override
    protected void scale(T dinosaur, PoseStack poseStack, float packedOverlay) {
        poseStack.scale(dinosaur.renderScaleWidth(), dinosaur.renderScaleHeight(), dinosaur.renderScaleWidth());
    }

    @Override
    public void render(T dinosaur, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        this.model = (EntityModel<T>) this.models.get(dinosaur.getCoatType().value().model());
        super.render(dinosaur, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
    }

    @Override
    public ResourceLocation getTextureLocation(T mob) {
        CoatType coatType = mob.getCoatType().value();
        return mob.isBaby() ? coatType.babyTexture().isPresent() ? coatType.babyTexture().get() : coatType.texture() : coatType.texture();
    }
}
