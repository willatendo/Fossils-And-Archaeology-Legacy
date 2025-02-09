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
import willatendo.fossilslegacy.client.render.CoatTypeMobRenderer;
import willatendo.fossilslegacy.client.state.MammothRenderState;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Mammoth;

public class MammothFurLayer extends RenderLayer<MammothRenderState, EntityModel<MammothRenderState>> {
    private EntityModel<MammothRenderState> model;
    private CoatTypeMobRenderer<Mammoth, MammothRenderState> coatTypeMobRenderer;

    public MammothFurLayer(CoatTypeMobRenderer<Mammoth, MammothRenderState> coatTypeMobRenderer) {
        super(coatTypeMobRenderer);
        this.coatTypeMobRenderer = coatTypeMobRenderer;
    }

    private void setModel(EntityModel<MammothRenderState> entityModel) {
        if (this.model != entityModel) {
            this.model = entityModel;
        }
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int partialticks, MammothRenderState mammothRenderState, float packedLight, float packedOverlay) {
        CoatType coatType = mammothRenderState.coatType.value();
        if (this.coatTypeMobRenderer.getAdditionalModel(mammothRenderState, coatType).isPresent()) {
            this.setModel(this.coatTypeMobRenderer.getAdditionalModel(mammothRenderState, coatType).get());
        } else {
            this.setModel(this.coatTypeMobRenderer.getModel(coatType.models().model()));
        }
        CoatType.Textures textures = coatType.patterns().getFirst().textures();
        if (textures.furTexture().isPresent()) {
            ResourceLocation texture = textures.furTexture().get();
            if (mammothRenderState.isSheared) {
                if (textures.shearedTexture().isPresent()) {
                    texture = textures.shearedTexture().get();
                }
            } else {
                if (mammothRenderState.isBaby) {
                    if (textures.babyFurTexture().isPresent()) {
                        texture = textures.babyFurTexture().get();
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

            RenderLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), texture, poseStack, multiBufferSource, partialticks, mammothRenderState, color);
        }
    }
}
