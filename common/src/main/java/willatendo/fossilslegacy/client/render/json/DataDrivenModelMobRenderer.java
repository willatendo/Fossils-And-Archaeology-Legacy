package willatendo.fossilslegacy.client.render.json;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.client.state.DataDrivenRenderState;
import willatendo.fossilslegacy.server.entity.util.interfaces.DataDrivenCosmetics;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.FATextures;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.List;

public abstract class DataDrivenModelMobRenderer<T extends Mob & DataDrivenCosmetics, S extends DataDrivenRenderState> extends MobRenderer<T, S, EntityModel<S>> {
    private ResourceLocation modelId;

    public DataDrivenModelMobRenderer(EntityRendererProvider.Context context, float shadowSize) {
        super(context, null, shadowSize);
    }

    public abstract String baseTextureName();

    public abstract List<ResourceKey<Texture>> requiredTextures();

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
    public void extractRenderState(T mob, S dataDrivenRenderState, float partialTick) {
        super.extractRenderState(mob, dataDrivenRenderState, partialTick);
        dataDrivenRenderState.textureRegistry = mob.registryAccess().lookupOrThrow(FARegistries.TEXTURE);
        dataDrivenRenderState.modelType = mob.getModelType();
        dataDrivenRenderState.skin = mob.getSkin();
        dataDrivenRenderState.pattern = mob.getPattern();
    }

    @Override
    public void render(S dataDrivenRenderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        ModelGene modelGene = dataDrivenRenderState.modelType.value();
        this.setModel(modelGene.models().model());
        super.render(dataDrivenRenderState, poseStack, multiBufferSource, partialTicks);
    }

    @Override
    public ResourceLocation getTextureLocation(S dataDrivenRenderState) {
        PatternGene skin = dataDrivenRenderState.skin.value();
        return this.getBaseTexture(dataDrivenRenderState.textureRegistry, skin);
    }

    public ResourceLocation getBaseTexture(Registry<Texture> textureRegistry, PatternGene patternGene) {
        return patternGene.getTexture(textureRegistry, FATextures.BASE, this.baseTextureName(), this.requiredTextures());
    }
}
