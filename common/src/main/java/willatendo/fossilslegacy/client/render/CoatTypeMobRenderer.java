package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.util.interfaces.CoatTypeEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.WetFurEntity;

import java.util.Optional;

public class CoatTypeMobRenderer<T extends Dinosaur & CoatTypeEntity> extends MobRenderer<T, EntityModel<T>> {
    public CoatTypeMobRenderer(EntityRendererProvider.Context context, float shadowSize) {
        super(context, null, shadowSize);
    }

    private void setModel(EntityModel<T> entityModel) {
        if (this.model != entityModel) {
            this.model = entityModel;
        }
    }

    public EntityModel<T> getModel(T dinosaur, ResourceLocation id) {
        if (JsonModelLoader.isJsonModel(id)) {
            return JsonModelLoader.getModel(id);
        } else if (JsonModelLoader.isBuiltInModel(id)) {
            return JsonModelLoader.getBuiltInModel(id, false);
        } else {
            return null;
        }
    }

    protected Optional<EntityModel<T>> additionalModel(T dinosaur, Optional<ResourceLocation> additionalModel, CoatType.Models models) {
        return additionalModel.isPresent() ? Optional.of(this.getModel(dinosaur, additionalModel.get())) : Optional.of(this.getModel(dinosaur, models.model()));
    }

    @Override
    protected void scale(T dinosaur, PoseStack poseStack, float packedOverlay) {
        poseStack.scale(dinosaur.renderScaleWidth(), dinosaur.renderScaleHeight(), dinosaur.renderScaleWidth());
    }

    public Optional<EntityModel<T>> getAdditionalModel(T mob, CoatType coatType) {
        return Optional.empty();
    }

    @Override
    public void render(T dinosaur, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        CoatType coatType = dinosaur.getCoatType().value();
        if (this.getAdditionalModel(dinosaur, coatType).isPresent()) {
            this.setModel(this.getAdditionalModel(dinosaur, coatType).get());
        } else {
            this.setModel(this.getModel(dinosaur, coatType.models().model()));
        }
        CoatType.AgeScaleInfo ageScaleInfo = coatType.ageScaleInfo();
        this.shadowRadius = ageScaleInfo.shadowSize() + (ageScaleInfo.shadowGrowth() * dinosaur.getGrowthStage());

        if (dinosaur instanceof WetFurEntity wetFurEntity) {
            if (wetFurEntity.isWet()) {
                if (this.model instanceof JsonModel jsonModel) {
                    float wetShade = wetFurEntity.getWetShade(partialTicks);
                    jsonModel.setColor(FastColor.ARGB32.colorFromFloat(1.0F, wetShade, wetShade, wetShade));
                }
            }
        }

        super.render(dinosaur, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);

        if (dinosaur instanceof WetFurEntity wetFurEntity) {
            if (wetFurEntity.isWet()) {
                if (this.model instanceof JsonModel jsonModel) {
                    jsonModel.setColor(-1);
                }
            }
        }
    }

    protected Optional<ResourceLocation> getAdditionalTexture(T mob, CoatType coatType) {
        return Optional.empty();
    }

    @Override
    public ResourceLocation getTextureLocation(T mob) {
        CoatType coatType = mob.getCoatType().value();
        return this.getAdditionalTexture(mob, coatType).isPresent() ? this.getAdditionalTexture(mob, coatType).get() : mob.isBaby() ? coatType.patterns().getFirst().textures().babyTexture().isPresent() ? coatType.patterns().getFirst().textures().babyTexture().get() : coatType.patterns().getFirst().textures().texture() : coatType.patterns().getFirst().textures().texture();
    }
}
