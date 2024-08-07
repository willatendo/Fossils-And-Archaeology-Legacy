package willatendo.fossilslegacy.client.render.layer;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.MosasaurusModel;
import willatendo.fossilslegacy.server.entity.Mosasaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class MosasaurusEyesLayer extends EyesLayer<Mosasaurus, MosasaurusModel> {
	private static final RenderType MOSASAURUS_EYES = RenderType.eyes(FossilsLegacyUtils.resource("textures/entity/mosasaurus/mosasaurus_eyes.png"));

	public MosasaurusEyesLayer(RenderLayerParent<Mosasaurus, MosasaurusModel> renderLayerParent) {
		super(renderLayerParent);
	}

	@Override
	public RenderType renderType() {
		return MOSASAURUS_EYES;
	}
}
