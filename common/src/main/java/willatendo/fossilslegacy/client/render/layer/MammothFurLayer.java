package willatendo.fossilslegacy.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.MammothRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Mammoth;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;

public class MammothFurLayer extends RenderLayer<MammothRenderState, EntityModel<MammothRenderState>> {
    private EntityModel<MammothRenderState> model;
    private DataDrivenModelDinosaurRenderer<Mammoth, MammothRenderState> dataDrivenModelDinosaurRenderer;
    private ResourceLocation modelId;

    public MammothFurLayer(DataDrivenModelDinosaurRenderer<Mammoth, MammothRenderState> dataDrivenModelDinosaurRenderer) {
        super(dataDrivenModelDinosaurRenderer);
        this.dataDrivenModelDinosaurRenderer = dataDrivenModelDinosaurRenderer;
    }

    private void setModel(ResourceLocation model) {
        if (this.modelId != model) {
            this.modelId = model;
            this.model = this.dataDrivenModelDinosaurRenderer.getModel(model);
        }
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks, MammothRenderState mammothRenderState, float packedLight, float packedOverlay) {
        ModelGene modelGene = mammothRenderState.modelGene.value();
        if (this.dataDrivenModelDinosaurRenderer.getAdditionalModel(mammothRenderState, modelGene).isPresent()) {
            this.setModel(this.dataDrivenModelDinosaurRenderer.getAdditionalModel(mammothRenderState, modelGene).get());
        } else {
            this.setModel(modelGene.models().model());
        }
        PatternGene skin = mammothRenderState.skinGene.value();
        if (this.dataDrivenModelDinosaurRenderer.hasFurTexture(mammothRenderState.textureRegistry, skin)) {
            ResourceLocation texture = this.dataDrivenModelDinosaurRenderer.getFurTexture(mammothRenderState.textureRegistry, skin);
            if (mammothRenderState.isSheared) {
                if (this.dataDrivenModelDinosaurRenderer.hasShearedTexture(mammothRenderState.textureRegistry, skin)) {
                    texture = this.dataDrivenModelDinosaurRenderer.getShearedTexture(mammothRenderState.textureRegistry, skin);
                }
            } else {
                if (mammothRenderState.isBaby) {
                    if (this.dataDrivenModelDinosaurRenderer.hasBabyFurTexture(mammothRenderState.textureRegistry, skin)) {
                        texture = this.dataDrivenModelDinosaurRenderer.getBabyFurTexture(mammothRenderState.textureRegistry, skin);
                    }
                }
            }

            int color;
            if (mammothRenderState.customName != null && "jeb_".equals(mammothRenderState.customName.getString())) {
                int ageInTicks = Mth.floor(mammothRenderState.ageInTicks);
                int offset = ageInTicks / 25 + mammothRenderState.id;
                int colors = DyeColor.values().length;
                int minColor = offset % colors;
                int maxColor = (offset + 1) % colors;
                float delta = ((float) (ageInTicks % 25) + Mth.frac(mammothRenderState.ageInTicks)) / 25.0F;
                int min = Sheep.getColor(DyeColor.byId(minColor));
                int max = Sheep.getColor(DyeColor.byId(maxColor));
                color = ARGB.lerp(delta, min, max);
            } else {
                color = Mammoth.getColor(mammothRenderState.woolColor);
            }

            RenderLayer.coloredCutoutModelCopyLayerRender(this.model, texture, poseStack, multiBufferSource, partialTicks, mammothRenderState, color);
        }
    }
}
