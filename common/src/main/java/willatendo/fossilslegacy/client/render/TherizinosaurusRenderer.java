package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.TherizinosaurusModel;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.Therizinosaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class TherizinosaurusRenderer extends MobRenderer<Dinosaur, TherizinosaurusModel> {
    public static final ResourceLocation FEATHERED = FossilsLegacyUtils.resource("textures/entity/therizinosaurus/feathered_therizinosaurus.png");
    public static final ResourceLocation FEATHERLESS = FossilsLegacyUtils.resource("textures/entity/therizinosaurus/featherless_therizinosaurus.png");

    public TherizinosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, new TherizinosaurusModel(context.bakeLayer(FossilsLegacyModelLayers.THERIZINOSAURUS)), 0.15F);
    }

    @Override
    public ResourceLocation getTextureLocation(Dinosaur dinosaur) {
        return FossilsModloaderHelper.INSTANCE.featheredDinosaurs() ? FEATHERED : FEATHERLESS;
    }
}
