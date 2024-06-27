package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.entity.ThrownJavelin;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.Map;

public class ThrownJavelinRenderer extends ArrowRenderer<ThrownJavelin> {
	public static final Map<Integer, ResourceLocation> TEXTURES = Map.of(0, FossilsLegacyUtils.resource("textures/entity/wooden_javelin.png"), 1, FossilsLegacyUtils.resource("textures/entity/stone_javelin.png"), 2, FossilsLegacyUtils.resource("textures/entity/iron_javelin.png"), 3, FossilsLegacyUtils.resource("textures/entity/golden_javelin.png"), 4, FossilsLegacyUtils.resource("textures/entity/diamond_javelin.png"), 5, FossilsLegacyUtils.resource("textures/entity/netherite_javelin.png"), 6, FossilsLegacyUtils.resource("textures/entity/scarab_gem_javelin.png"));

	public ThrownJavelinRenderer(Context context) {
		super(context);
	}

	@Override
	public void render(ThrownJavelin thrownJavelin, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
		poseStack.scale(2.0F, 2.0F, 2.0F);
		super.render(thrownJavelin, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
	}

	@Override
	public ResourceLocation getTextureLocation(ThrownJavelin thrownJavelin) {
		return TEXTURES.get(thrownJavelin.getVariant());
	}
}
