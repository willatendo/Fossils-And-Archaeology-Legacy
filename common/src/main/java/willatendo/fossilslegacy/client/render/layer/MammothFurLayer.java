package willatendo.fossilslegacy.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.DyeColor;
import willatendo.fossilslegacy.client.render.CoatTypeMobRenderer;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Mammoth;

public class MammothFurLayer extends RenderLayer<Mammoth, EntityModel<Mammoth>> {
    private EntityModel<Mammoth> model;
    private CoatTypeMobRenderer<Mammoth> coatTypeMobRenderer;

    public MammothFurLayer(CoatTypeMobRenderer<Mammoth> coatTypeMobRenderer) {
        super(coatTypeMobRenderer);
        this.coatTypeMobRenderer = coatTypeMobRenderer;
    }

    private void setModel(EntityModel<Mammoth> entityModel) {
        if (this.model != entityModel) {
            this.model = entityModel;
        }
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, Mammoth mammoth, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        CoatType coatType = mammoth.getCoatType().value();
        if (this.coatTypeMobRenderer.getAdditionalModel(mammoth, coatType).isPresent()) {
            this.setModel(this.coatTypeMobRenderer.getAdditionalModel(mammoth, coatType).get());
        } else {
            this.setModel(this.coatTypeMobRenderer.getModel(mammoth, coatType.models().model()));
        }
        CoatType.Textures textures = coatType.patterns().getFirst().textures();
        if (textures.furTexture().isPresent()) {
            ResourceLocation texture = textures.furTexture().get();
            if (mammoth.isSheared()) {
                if (textures.shearedTexture().isPresent()) {
                    texture = textures.shearedTexture().get();
                }
            } else {
                if (mammoth.isBaby()) {
                    if (textures.babyFurTexture().isPresent()) {
                        texture = textures.babyFurTexture().get();
                    }
                }
            }

            int color;
            if (mammoth.hasCustomName() && "jeb_".equals(mammoth.getName().getString())) {
                int tickCount = mammoth.tickCount / 25 + mammoth.getId();
                int dyeColors = DyeColor.values().length;
                int dyeColorForTick = tickCount % dyeColors;
                int nextDyeColorForTick = (tickCount + 1) % dyeColors;
                float delta = ((float) (mammoth.tickCount % 25) + partialTicks) / 25.0F;
                int min = Mammoth.getColor(DyeColor.byId(dyeColorForTick));
                int max = Mammoth.getColor(DyeColor.byId(nextDyeColorForTick));
                color = FastColor.ARGB32.lerp(delta, min, max);
            } else {
                color = Mammoth.getColor(mammoth.getColor());
            }

            RenderLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, texture, poseStack, multiBufferSource, packedLight, mammoth, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, partialTicks, color);
        }
    }
}
