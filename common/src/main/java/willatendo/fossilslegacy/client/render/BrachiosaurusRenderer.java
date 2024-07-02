package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.BrachiosaurusModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.LegacyBrachiosaurusModel;
import willatendo.fossilslegacy.server.entity.Brachiosaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class BrachiosaurusRenderer extends LegacyEntityRenderer<Brachiosaurus> {
    public static final ResourceLocation ADULT_TEXTURE = FossilsLegacyUtils.resource("textures/entity/brachiosaurus/brachiosaurus_adult.png");
    public static final ResourceLocation BABY_TEXTURE = FossilsLegacyUtils.resource("textures/entity/brachiosaurus/brachiosaurus_baby.png");
    public static final ResourceLocation LEGACY_TEXTURE = FossilsLegacyUtils.resource("textures/entity/brachiosaurus/legacy/brachiosaurus.png");

    public BrachiosaurusRenderer(Context context) {
        super(context, new BrachiosaurusModel(context.bakeLayer(FossilsLegacyModelLayers.BRACHIOSAURUS.getFirst())), new LegacyBrachiosaurusModel(context.bakeLayer(FossilsLegacyModelLayers.BRACHIOSAURUS.getSecond())), 0.3F);
    }

    @Override
    protected ResourceLocation legacyTextureLocation(Brachiosaurus brachiosaurus) {
        return LEGACY_TEXTURE;
    }

    @Override
    protected ResourceLocation textureLocation(Brachiosaurus brachiosaurus) {
        return brachiosaurus.isBaby() ? BABY_TEXTURE : ADULT_TEXTURE;
    }
}
