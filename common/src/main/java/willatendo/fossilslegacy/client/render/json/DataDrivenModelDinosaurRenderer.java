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
import willatendo.fossilslegacy.server.entity.util.interfaces.ChromosomedEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.ShakingEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.WetFurEntity;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.FATextures;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.List;
import java.util.Optional;

public abstract class DataDrivenModelDinosaurRenderer<T extends Dinosaur & ChromosomedEntity, S extends DinosaurRenderState> extends MobRenderer<T, S, EntityModel<S>> {
    private ResourceLocation modelId;

    public DataDrivenModelDinosaurRenderer(EntityRendererProvider.Context context, float shadowSize) {
        super(context, null, shadowSize);
        this.addLayer(new PatternLayer<>(this));
    }

    public abstract String baseTextureName();

    public abstract List<ResourceKey<Texture>> requiredTextures();

    public Optional<ResourceLocation> getAdditionalModel(S dinosaurRenderState, ModelGene modelGene) {
        return Optional.empty();
    }

    protected Optional<ResourceLocation> getAdditionalTexture(Registry<Texture> textureRegistry, S dinosaurRenderState, SkinGene skinGene) {
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
        dinosaurRenderState.modelGene = dinosaur.getModelGene(dinosaur.modelGeneRegistry);
        dinosaurRenderState.skinGene = dinosaur.getSkinGene(dinosaur.skinGeneRegistry);
        dinosaurRenderState.patternGene = dinosaur.getPatternGene(dinosaur.patternGeneRegistry);
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
        ModelGene.AgeScaleInfo ageScaleInfo = dinosaurRenderState.modelGene.value().ageScaleInfo();
        return ageScaleInfo.shadowSize() + (ageScaleInfo.shadowGrowth() * dinosaurRenderState.growthStage);
    }

    protected Optional<ResourceLocation> additionalModel(Optional<ResourceLocation> additionalModel, ModelGene.Models models) {
        return additionalModel.isPresent() ? Optional.of(additionalModel.get()) : Optional.of(models.model());
    }

    @Override
    public void render(S dinosaurRenderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        ModelGene modelGene = dinosaurRenderState.modelGene.value();
        if (this.getAdditionalModel(dinosaurRenderState, modelGene).isPresent()) {
            this.setModel(this.getAdditionalModel(dinosaurRenderState, modelGene).get());
        } else {
            this.setModel(modelGene.models().model());
        }
        super.render(dinosaurRenderState, poseStack, multiBufferSource, partialTicks);
    }

    @Override
    public ResourceLocation getTextureLocation(S dinosaurRenderState) {
        SkinGene skin = dinosaurRenderState.skinGene.value();
        return this.getAdditionalTexture(dinosaurRenderState.textureRegistry, dinosaurRenderState, skin).isPresent() ? this.getAdditionalTexture(dinosaurRenderState.textureRegistry, dinosaurRenderState, skin).get() : dinosaurRenderState.isBaby ? this.hasBabyTexture(dinosaurRenderState.textureRegistry, skin) ? this.getBabyTexture(dinosaurRenderState.textureRegistry, skin) : this.getBaseTexture(dinosaurRenderState.textureRegistry, skin) : this.getBaseTexture(dinosaurRenderState.textureRegistry, skin);
    }

    public ResourceLocation getTexture(Registry<Texture> textureRegistry, ResourceKey<Texture> texture, PatternGene patternGene) {
        return patternGene.getTexture(textureRegistry, texture, this.baseTextureName(), this.requiredTextures());
    }

    public ResourceLocation getBaseTexture(Registry<Texture> textureRegistry, PatternGene patternGene) {
        return patternGene.getTexture(textureRegistry, FATextures.BASE, this.baseTextureName(), this.requiredTextures());
    }

    public ResourceLocation getBabyTexture(Registry<Texture> textureRegistry, PatternGene patternGene) {
        return patternGene.getBabyTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public ResourceLocation getAggressiveTexture(Registry<Texture> textureRegistry, PatternGene patternGene) {
        return patternGene.getAggressiveTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public ResourceLocation getAggressiveBabyTexture(Registry<Texture> textureRegistry, PatternGene patternGene) {
        return patternGene.getAggressiveBabyTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public ResourceLocation getKnockedOutTexture(Registry<Texture> textureRegistry, PatternGene patternGene) {
        return patternGene.getKnockedOutTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public ResourceLocation getFurTexture(Registry<Texture> textureRegistry, PatternGene patternGene) {
        return patternGene.getFurTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public ResourceLocation getBabyFurTexture(Registry<Texture> textureRegistry, PatternGene patternGene) {
        return patternGene.getBabyFurTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public ResourceLocation getShearedTexture(Registry<Texture> textureRegistry, PatternGene patternGene) {
        return patternGene.getShearedTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public ResourceLocation getEyeTexture(Registry<Texture> textureRegistry, PatternGene patternGene) {
        return patternGene.getEyeTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public boolean hasBabyTexture(Registry<Texture> textureRegistry, PatternGene patternGene) {
        return patternGene.hasBabyTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public boolean hasAggressiveBabyTexture(Registry<Texture> textureRegistry, PatternGene patternGene) {
        return patternGene.hasAggressiveBabyTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public boolean hasAggressiveTexture(Registry<Texture> textureRegistry, PatternGene patternGene) {
        return patternGene.hasAggressiveTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public boolean hasKnockedOutTexture(Registry<Texture> textureRegistry, PatternGene patternGene) {
        return patternGene.hasKnockedOutTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public boolean hasFurTexture(Registry<Texture> textureRegistry, PatternGene patternGene) {
        return patternGene.hasFurTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public boolean hasBabyFurTexture(Registry<Texture> textureRegistry, PatternGene patternGene) {
        return patternGene.hasBabyFurTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public boolean hasShearedTexture(Registry<Texture> textureRegistry, PatternGene patternGene) {
        return patternGene.hasShearedTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }

    public boolean hasEyeTexture(Registry<Texture> textureRegistry, PatternGene patternGene) {
        return patternGene.hasEyeTexture(textureRegistry, this.baseTextureName(), this.requiredTextures());
    }
}
