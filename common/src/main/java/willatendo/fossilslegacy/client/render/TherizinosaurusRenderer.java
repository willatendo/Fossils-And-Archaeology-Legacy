package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.TherizinosaurusModel;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.entity.Therizinosaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class TherizinosaurusRenderer extends MobRenderer<Therizinosaurus, TherizinosaurusModel> {
    public static final ResourceLocation FEATHERED = FossilsLegacyUtils.resource("textures/entities/animals/therizinosaurus/feathered_therizinosaurus.png");
    public static final ResourceLocation FEATHERLESS = FossilsLegacyUtils.resource("textures/entities/animals/therizinosaurus/featherless_therizinosaurus.png");

    public TherizinosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, new TherizinosaurusModel(context.bakeLayer(FossilsLegacyModels.THERIZINOSAURUS)), 0.15F);
    }

    @Override
    public ResourceLocation getTextureLocation(Therizinosaurus therizinosaurus) {
        return FossilsModloaderHelper.INSTANCE.featheredDinosaurs() ? FEATHERED : FEATHERLESS;
    }
}
