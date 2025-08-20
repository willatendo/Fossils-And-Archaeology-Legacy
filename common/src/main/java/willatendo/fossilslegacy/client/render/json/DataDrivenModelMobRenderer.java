package willatendo.fossilslegacy.client.render.json;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.client.state.ChromosomedEntityRenderState;
import willatendo.fossilslegacy.server.entity.util.interfaces.ChromosomedEntity;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.TextureInformation;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

public abstract class DataDrivenModelMobRenderer<T extends Mob & ChromosomedEntity, S extends ChromosomedEntityRenderState> extends MobRenderer<T, S, EntityModel<S>> {
    private ResourceLocation modelId;

    public DataDrivenModelMobRenderer(EntityRendererProvider.Context context, float shadowSize) {
        super(context, null, shadowSize);
    }

    public abstract ResourceLocation getBasePath();

    protected ResourceLocation createPath(String name) {
        return FAUtils.resource("textures/entity/" + name);
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
    public void extractRenderState(T mob, S chromosomedEntityRenderState, float partialTick) {
        super.extractRenderState(mob, chromosomedEntityRenderState, partialTick);
        chromosomedEntityRenderState.type = mob.getType();
        chromosomedEntityRenderState.modelGene = mob.getModelGene(mob.registryAccess().lookupOrThrow(FARegistries.MODEL_GENE));
        chromosomedEntityRenderState.skinGene = mob.getSkinGene(mob.registryAccess().lookupOrThrow(FARegistries.SKIN_GENE));
        chromosomedEntityRenderState.patternGene = mob.getPatternGene(mob.registryAccess().lookupOrThrow(FARegistries.PATTERN_GENE));
    }

    @Override
    public void render(S dataDrivenRenderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        ModelGene modelGene = dataDrivenRenderState.modelGene.value();
        this.setModel(modelGene.models().model());
        super.render(dataDrivenRenderState, poseStack, multiBufferSource, partialTicks);
    }

    @Override
    public ResourceLocation getTextureLocation(S dinosaurRenderState) {
        SkinGene skinGene = dinosaurRenderState.skinGene.value();
        TextureInformation textureInformation = skinGene.textures().apply(dinosaurRenderState, this.getBasePath());
        return textureInformation.texture().isPresent() ? textureInformation.texture().get() : null;
    }
}
