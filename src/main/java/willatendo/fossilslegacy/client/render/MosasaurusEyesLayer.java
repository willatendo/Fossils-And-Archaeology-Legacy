package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import willatendo.fossilslegacy.client.model.legacy.MosasaurusLegacyModel;
import willatendo.fossilslegacy.server.entity.Mosasaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class MosasaurusEyesLayer extends EyesLayer<Mosasaurus, MosasaurusLegacyModel> {
	private static final RenderType MOSASAURUS_EYES = RenderType.eyes(FossilsLegacyUtils.resource("textures/entities/legacy/mosasaurus/mosasaurus_eyes.png"));

	public MosasaurusEyesLayer(RenderLayerParent<Mosasaurus, MosasaurusLegacyModel> renderLayerParent) {
		super(renderLayerParent);
	}

	public RenderType renderType() {
		return MOSASAURUS_EYES;
	}
}
