package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.api.client.ModelIdentifierRegistry;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.entity.util.CoatTypeEntity;

import java.util.Map;
import java.util.Optional;

public class CoatTypeMobRenderer<T extends Dinosaur & CoatTypeEntity> extends MobRenderer<T, EntityModel<T>> {
    protected final Map<ResourceLocation, EntityModel> models;

    public CoatTypeMobRenderer(EntityRendererProvider.Context context, float shadowSize) {
        super(context, null, shadowSize);
        this.models = ModelIdentifierRegistry.registerAllModels(context::bakeLayer);
    }

    private boolean hasModel(ResourceLocation id) {
        return this.models.keySet().contains(id);
    }

    private void setModel(EntityModel<T> entityModel) {
        if (this.model != entityModel) {
            this.model = entityModel;
        }
    }

    private EntityModel<T> getModel(ResourceLocation id) {
        if (this.hasModel(id)) {
            return this.models.getOrDefault(id, this.models.values().stream().toList().get(0));
        } else if (JsonModelLoader.isJsonModel(id)) {
            return JsonModelLoader.getModel(id);
        } else {
            return null;
        }
    }

    @Override
    protected void scale(T dinosaur, PoseStack poseStack, float packedOverlay) {
        poseStack.scale(dinosaur.renderScaleWidth(), dinosaur.renderScaleHeight(), dinosaur.renderScaleWidth());
    }

    protected Optional<EntityModel<T>> getAdditionalModel(T mob, CoatType coatType) {
        return Optional.empty();
    }

    @Override
    public void render(T dinosaur, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        CoatType coatType = dinosaur.getCoatType().value();
        if (this.getAdditionalModel(dinosaur, coatType).isPresent()) {
            this.setModel(this.getAdditionalModel(dinosaur, coatType).get());
        } else {
            this.setModel(this.getModel(coatType.models().model()));
        }

        super.render(dinosaur, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
    }

    protected Optional<ResourceLocation> getAdditionalTexture(T mob, CoatType coatType) {
        return Optional.empty();
    }

    @Override
    public ResourceLocation getTextureLocation(T mob) {
        CoatType coatType = mob.getCoatType().value();
        return this.getAdditionalTexture(mob, coatType).isPresent() ? this.getAdditionalTexture(mob, coatType).get() : mob.isBaby() ? coatType.textures().babyTexture().isPresent() ? coatType.textures().babyTexture().get() : coatType.textures().texture() : coatType.textures().texture();
    }
}
