package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.FailuresaurusModel;
import willatendo.fossilslegacy.server.entity.Failuresaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FailuresaurusRenderer extends MobRenderer<Failuresaurus, FailuresaurusModel> {
	public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/failuresaurus.png");

	public FailuresaurusRenderer(Context context) {
		super(context, new FailuresaurusModel(context.bakeLayer(FossilsLegacyModels.FAILURESAURUS)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Failuresaurus failuresaurus) {
		return TEXTURE;
	}
}
