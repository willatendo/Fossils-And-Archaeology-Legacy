package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.NautilusModel;
import willatendo.fossilslegacy.server.entity.dinosaur.quaternary.Nautilus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class NautilusRenderer extends MobRenderer<Nautilus, NautilusModel> {
	public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entity/nautilus/nautilus.png");

	public NautilusRenderer(Context context) {
		super(context, new NautilusModel(context.bakeLayer(FossilsLegacyModelLayers.NAUTILUS)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Nautilus nautilus) {
		return TEXTURE;
	}
}