package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.state.ThrownJavelinArrowRenderState;
import willatendo.fossilslegacy.server.entity.entities.ThrownJavelin;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Map;

public class ThrownJavelinRenderer extends ArrowRenderer<ThrownJavelin, ThrownJavelinArrowRenderState> {
    public static final Map<Integer, ResourceLocation> TEXTURES = Map.of(0, FAUtils.resource("textures/entity/javelin/wooden_javelin.png"), 1, FAUtils.resource("textures/entity/javelin/stone_javelin.png"), 2, FAUtils.resource("textures/entity/javelin/iron_javelin.png"), 3, FAUtils.resource("textures/entity/javelin/golden_javelin.png"), 4, FAUtils.resource("textures/entity/javelin/diamond_javelin.png"), 5, FAUtils.resource("textures/entity/javelin/netherite_javelin.png"), 6, FAUtils.resource("textures/entity/javelin/scarab_gem_javelin.png"));

    public ThrownJavelinRenderer(Context context) {
        super(context);
    }

    @Override
    public void extractRenderState(ThrownJavelin thrownJavelin, ThrownJavelinArrowRenderState thrownJavelinArrowRenderState, float partialTicks) {
        super.extractRenderState(thrownJavelin, thrownJavelinArrowRenderState, partialTicks);
        thrownJavelinArrowRenderState.variant = thrownJavelin.getVariant();
    }

    @Override
    public ThrownJavelinArrowRenderState createRenderState() {
        return new ThrownJavelinArrowRenderState();
    }

    @Override
    public void render(ThrownJavelinArrowRenderState thrownJavelinArrowRenderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        poseStack.scale(2.0F, 2.0F, 2.0F);
        super.render(thrownJavelinArrowRenderState, poseStack, multiBufferSource, partialTicks);
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownJavelinArrowRenderState thrownJavelinArrowRenderState) {
        return TEXTURES.get(thrownJavelinArrowRenderState.variant);
    }
}
