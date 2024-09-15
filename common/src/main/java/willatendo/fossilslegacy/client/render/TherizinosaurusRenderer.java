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

public class TherizinosaurusRenderer extends CoatTypeMobRenderer<Therizinosaurus> {
    public TherizinosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.15F);
    }
}
