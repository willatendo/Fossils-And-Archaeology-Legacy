package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.dinosaur.FutabasaurusModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.LegacyFutabasaurusModel;
import willatendo.fossilslegacy.server.entity.Futabasaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FutabasaurusRenderer extends LegacyEntityRenderer<Futabasaurus> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entity/animals/futabasaurus/futabasaurus.png");
    public static final ResourceLocation LEGACY_TEXTURE = FossilsLegacyUtils.resource("textures/entity/animals/futabasaurus/legacy/futabasaurus.png");

    public FutabasaurusRenderer(Context context) {
        super(context, new FutabasaurusModel(context.bakeLayer(FossilsLegacyModels.FUTABASAURUS)), new LegacyFutabasaurusModel(context.bakeLayer(FossilsLegacyModels.LEGACY_FUTABASAURUS)), 0.3F);
    }

    @Override
    protected ResourceLocation legacyTextureLocation(Futabasaurus futabasaurus) {
        return LEGACY_TEXTURE;
    }

    @Override
    protected ResourceLocation textureLocation(Futabasaurus futabasaurus) {
        return TEXTURE;
    }
}
