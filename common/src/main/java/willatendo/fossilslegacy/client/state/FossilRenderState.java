package willatendo.fossilslegacy.client.state;

import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.core.Holder;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;

public class FossilRenderState extends EntityRenderState {
    public Holder<FossilVariant> variant;
    public int size;
    public float renderScaleWidth;
    public float renderScaleHeight;
    public boolean isInvisibleToPlayer;
    public boolean appearsGlowing;
}
