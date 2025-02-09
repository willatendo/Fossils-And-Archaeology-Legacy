package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FAModelLayers;
import willatendo.fossilslegacy.client.model.EggModel;
import willatendo.fossilslegacy.client.state.EggRenderState;
import willatendo.fossilslegacy.server.egg_variant.EggVariant;
import willatendo.fossilslegacy.server.entity.entities.Egg;

public class EggRenderer extends MobRenderer<Egg, EggRenderState, EggModel> {
    private final EggModel regularEggModel;
    private final EggModel smallEggModel;

    public EggRenderer(Context context) {
        super(context, null, 0.3F);
        this.regularEggModel = new EggModel(context.bakeLayer(FAModelLayers.REGULAR_EGG));
        this.smallEggModel = new EggModel(context.bakeLayer(FAModelLayers.SMALL_EGG));
    }

    @Override
    public void extractRenderState(Egg egg, EggRenderState eggRenderState, float partialTicks) {
        super.extractRenderState(egg, eggRenderState, partialTicks);
        eggRenderState.variant = egg.getEggVariant();
    }

    @Override
    public EggRenderState createRenderState() {
        return new EggRenderState();
    }

    @Override
    public void render(EggRenderState eggRenderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        if (eggRenderState.variant.value().eggSize() == EggVariant.EggSize.SMALL) {
            this.model = this.smallEggModel;
        } else {
            this.model = this.regularEggModel;
        }
        super.render(eggRenderState, poseStack, multiBufferSource, partialTicks);
    }

    @Override
    public ResourceLocation getTextureLocation(EggRenderState eggRenderState) {
        return eggRenderState.variant.value().texture();
    }
}
