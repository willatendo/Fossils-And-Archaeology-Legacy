package willatendo.fossilslegacy.client.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.core.Holder;
import willatendo.fossilslegacy.server.egg_variant.EggVariant;

public class EggRenderState extends LivingEntityRenderState {
    public Holder<EggVariant> variant;
}

