package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.MosasaurusModel;
import willatendo.fossilslegacy.client.render.layer.MosasaurusEyesLayer;
import willatendo.fossilslegacy.server.entity.Mosasaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class MosasaurusRenderer extends MobRenderer<Mosasaurus, MosasaurusModel> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entity/mosasaurus/mosasaurus.png");

    public MosasaurusRenderer(Context context) {
        super(context, new MosasaurusModel(context.bakeLayer(FossilsLegacyModelLayers.MOSASAURUS)), 0.3F);
        this.addLayer(new MosasaurusEyesLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Mosasaurus mosasaurus) {
        return TEXTURE;
    }
}
