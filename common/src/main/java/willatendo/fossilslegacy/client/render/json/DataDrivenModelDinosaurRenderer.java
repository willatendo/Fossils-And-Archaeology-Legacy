package willatendo.fossilslegacy.client.render.json;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ARGB;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.client.render.layer.PatternLayer;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Dilophosaurus;
import willatendo.fossilslegacy.server.entity.util.interfaces.DataDrivenCosmetics;
import willatendo.fossilslegacy.server.entity.util.interfaces.ShakingEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.WetFurEntity;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.FATextures;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;
import willatendo.fossilslegacy.server.pattern.texture.Texture;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.List;
import java.util.Optional;

public abstract class DataDrivenModelDinosaurRenderer<T extends Dinosaur & DataDrivenCosmetics, S extends DinosaurRenderState> extends MobRenderer<T, S, EntityModel<S>> {
    private ResourceLocation modelId;

    public DataDrivenModelDinosaurRenderer(EntityRendererProvider.Context context, float shadowSize) {
        super(context, null, shadowSize);
        this.addLayer(new PatternLayer<>(this));
    }

    public abstract String baseTextureName();

    public abstract List<ResourceKey<Texture>> requiredTextures();

    public Optional<ResourceLocation> getAdditionalModel(S dinosaurRenderState, ModelType modelType) {
        return Optional.empty();
    }

    protected Optional<ResourceLocation> getAdditionalTexture(Registry<Texture> textureRegistry, S dinosaurRenderState, Pattern pattern) {
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
        dinosaurRenderState.textureRegistry = dinosaur.registryAccess().lookupOrThrow(FARegistries.TEXTURE);
        dinosaurRenderState.modelType = dinosaur.getModelType();
        dinosaurRenderState.skin = dinosaur.getSkin();
        dinosaurRenderState.pattern = dinosaur.getPattern();
        dinosaurRenderState.growthStage = dinosaur.getGrowthStage();
        dinosaurRenderState.isTame = dinosaur.isTame();
        dinosaurRenderState.isOrderedToSit = dinosaur.isOrderedToSit();
        dinosaurRenderState.inWater = dinosaur.isInWaterOrBubble();
        dinosaurRenderState.renderScaleWidth = dinosaur.renderScaleWidth();
        dinosaurRenderState.renderScaleHeight = dinosaur.renderScaleHeight();
        dinosaurRenderState.isMoving = dinosaur.getDeltaMovement().horizontalDistanceSqr() > 1.0E-7;
        dinosaurRenderState.isTranquilized = dinosaur.isTranquilized();
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
        Pattern skin = dinosaurRenderState.skin.value();
        return this.getAdditionalTexture(dinosaurRenderState.textureRegistry, dinosaurRenderState, skin).isPresent() ? this.getAdditionalTexture(dinosaurRenderState.textureRegistry, dinosaurRenderState, skin).get() : dinosaurRenderState.isBaby ? this.hasBabyTexture(dinosaurRenderState.textureRegistry, skin) ? this.getBabyTexture(dinosaurRenderState.textureRegistry, skin) : this.getBaseTexture(dinosaurRenderState.textureRegistry, skin) : this.getBaseTexture(dinosaurRenderState.textureRegistry, skin);
    }

    public ResourceLocation getTexture(Registry<Texture> textureRegistry, ResourceKey<Texture> texture, Pattern pattern) {
        return pattern.getTexture(textureRegistry, texture, this.baseTextureName(), this.requiredTextures());
    }

    public ResourceLocation getBaseTexture(Registry<Texture> textureRegistry, Pattern pattern) {
        return pattern.getTexture(textureRegistry, FATextures.BASE, this.baseTextureName(), this.requiredTextures());
    }

    public ResourceLocation getBabyTexture(Registry<Texture> textureRegistry, Pattern pattern) {
        return pattern.getBabyTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public ResourceLocation getAggressiveTexture(Registry<Texture> textureRegistry, Pattern pattern) {
        return pattern.getAggressiveTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public ResourceLocation getAggressiveBabyTexture(Registry<Texture> textureRegistry, Pattern pattern) {
        return pattern.getAggressiveBabyTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public ResourceLocation getKnockedOutTexture(Registry<Texture> textureRegistry, Pattern pattern) {
        return pattern.getKnockedOutTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public ResourceLocation getFurTexture(Registry<Texture> textureRegistry, Pattern pattern) {
        return pattern.getFurTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public ResourceLocation getBabyFurTexture(Registry<Texture> textureRegistry, Pattern pattern) {
        return pattern.getBabyFurTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public ResourceLocation getShearedTexture(Registry<Texture> textureRegistry, Pattern pattern) {
        return pattern.getShearedTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public ResourceLocation getEyeTexture(Registry<Texture> textureRegistry, Pattern pattern) {
        return pattern.getEyeTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public boolean hasBabyTexture(Registry<Texture> textureRegistry, Pattern pattern) {
        return pattern.hasBabyTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public boolean hasAggressiveBabyTexture(Registry<Texture> textureRegistry, Pattern pattern) {
        return pattern.hasAggressiveBabyTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public boolean hasAggressiveTexture(Registry<Texture> textureRegistry, Pattern pattern) {
        return pattern.hasAggressiveTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public boolean hasKnockedOutTexture(Registry<Texture> textureRegistry, Pattern pattern) {
        return pattern.hasKnockedOutTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public boolean hasFurTexture(Registry<Texture> textureRegistry, Pattern pattern) {
        return pattern.hasFurTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public boolean hasBabyFurTexture(Registry<Texture> textureRegistry, Pattern pattern) {
        return pattern.hasBabyFurTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public boolean hasShearedTexture(Registry<Texture> textureRegistry, Pattern pattern) {
        return pattern.hasShearedTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public boolean hasEyeTexture(Registry<Texture> textureRegistry, Pattern pattern) {
        return pattern.hasEyeTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }
}
