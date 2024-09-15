package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.CryolophosaurusModel;
import willatendo.fossilslegacy.server.entity.Cryolophosaurus;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class CryolophosaurusRenderer extends CoatTypeMobRenderer<Cryolophosaurus> {
    public CryolophosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.15F);
    }
}
