package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ARGB;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Dilophosaurus;
import willatendo.fossilslegacy.server.entity.util.interfaces.ModelTypeEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.ShakingEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.WetFurEntity;

import java.util.Optional;

public abstract class DataDrivenModelMobRenderer<T extends Dinosaur & ModelTypeEntity, S extends DinosaurRenderState> extends MobRenderer<T, S, EntityModel<S>> {
    private ResourceLocation modelId;

    public DataDrivenModelMobRenderer(EntityRendererProvider.Context context, float shadowSize) {
        super(context, null, shadowSize);
    }

    public Optional<ResourceLocation> getAdditionalModel(S dinosaurRenderState, ModelType modelType) {
        return Optional.empty();
    }

    protected Optional<ResourceLocation> getAdditionalTexture(S dinosaurRenderState, ModelType modelType) {
        return Optional.empty();
    }

    private void setModel(ResourceLocation model) {
        if (this.modelId != model) {
            this.modelId = model;
            this.model = this.getModel(model);
        }
    }

    public EntityModel<S> getModel(ResourceLocation id) {
        if (JsonModelLoader.isJsonModel(id)) {
            return JsonModelLoader.getModel(id);
        } else {
            return null;
        }
    }

    @Override
    public void extractRenderState(T dinosaur, S dinosaurRenderState, float partialTick) {
        super.extractRenderState(dinosaur, dinosaurRenderState, partialTick);
        dinosaurRenderState.modelType = dinosaur.getModelType();
        dinosaurRenderState.growthStage = dinosaur.getGrowthStage();
        dinosaurRenderState.isTame = dinosaur.isTame();
        dinosaurRenderState.isOrderedToSit = dinosaur.isOrderedToSit();
        dinosaurRenderState.inWater = dinosaur.isInWaterOrBubble();
        dinosaurRenderState.renderScaleWidth = dinosaur.renderScaleWidth();
        dinosaurRenderState.renderScaleHeight = dinosaur.renderScaleHeight();
        dinosaurRenderState.isMoving = dinosaur.getDeltaMovement().horizontalDistanceSqr() > 1.0E-7;
        if (dinosaur instanceof WetFurEntity wetFurEntity) {
            dinosaurRenderState.isWet = wetFurEntity.isWet();
            dinosaurRenderState.wetShade = wetFurEntity.getWetShade(partialTick);
        }
        if (dinosaur instanceof ShakingEntity shakingEntity) {
            dinosaurRenderState.interestedAngle = shakingEntity.getInterestedAngle();
            dinosaurRenderState.interestedAngleO = shakingEntity.getInterestedAngleO();
            dinosaurRenderState.shakeAnim = shakingEntity.shakeAnim();
            dinosaurRenderState.shakeAnimO = shakingEntity.shakeAnim0();
        }
        if (dinosaur instanceof Dilophosaurus dilophosaurus) {
            dinosaurRenderState.isAttacking = dilophosaurus.isAttacking();
        }
    }

    @Override
    protected int getModelTint(S dinosaurRenderState) {
        if (dinosaurRenderState.isWet) {
            float wetShade = dinosaurRenderState.wetShade;
            return wetShade == 1.0F ? -1 : ARGB.colorFromFloat(1.0F, wetShade, wetShade, wetShade);
        }
        return super.getModelTint(dinosaurRenderState);
    }

    @Override
    protected void scale(S dinosaurRenderState, PoseStack poseStack) {
        poseStack.scale(dinosaurRenderState.renderScaleWidth, dinosaurRenderState.renderScaleHeight, dinosaurRenderState.renderScaleWidth);
    }

    @Override
    protected float getShadowRadius(S dinosaurRenderState) {
        ModelType.AgeScaleInfo ageScaleInfo = dinosaurRenderState.modelType.value().ageScaleInfo();
        return ageScaleInfo.shadowSize() + (ageScaleInfo.shadowGrowth() * dinosaurRenderState.growthStage);
    }

    protected Optional<ResourceLocation> additionalModel(Optional<ResourceLocation> additionalModel, ModelType.Models models) {
        return additionalModel.isPresent() ? Optional.of(additionalModel.get()) : Optional.of(models.model());
    }

    @Override
    public void render(S dinosaurRenderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        ModelType modelType = dinosaurRenderState.modelType.value();
        if (this.getAdditionalModel(dinosaurRenderState, modelType).isPresent()) {
            this.setModel(this.getAdditionalModel(dinosaurRenderState, modelType).get());
        } else {
            this.setModel(modelType.models().model());
        }
        super.render(dinosaurRenderState, poseStack, multiBufferSource, partialTicks);
    }

    @Override
    public ResourceLocation getTextureLocation(S dinosaurRenderState) {
        ModelType modelType = dinosaurRenderState.modelType.value();
        return this.getAdditionalTexture(dinosaurRenderState, modelType).isPresent() ? this.getAdditionalTexture(dinosaurRenderState, modelType).get() : dinosaurRenderState.isBaby ? modelType.patterns().getFirst().hasBabyTexture() ? modelType.patterns().getFirst().getBabyTexture() : modelType.patterns().getFirst().getTexture() : modelType.patterns().getFirst().getTexture();
    }
}
