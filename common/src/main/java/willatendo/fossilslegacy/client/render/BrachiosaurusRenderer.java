package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.BrachiosaurusModel;
import willatendo.fossilslegacy.server.entity.Brachiosaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class BrachiosaurusRenderer extends MobRenderer<Brachiosaurus, BrachiosaurusModel> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entity/animals/brachiosaurus/brachiosaurus_skeleton.png");

    public BrachiosaurusRenderer(Context context) {
        super(context, new BrachiosaurusModel(context.bakeLayer(FossilsLegacyModels.BRACHIOSAURUS)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(Brachiosaurus brachiosaurus) {
        return TEXTURE;
    }
}
