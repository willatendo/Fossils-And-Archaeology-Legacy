package willatendo.fossilslegacy.client.state;

import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.core.Holder;
import willatendo.fossilslegacy.server.entity.util.FossilPositions;
import willatendo.fossilslegacy.server.entity.util.FossilRotations;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;

public class FossilRenderState extends EntityRenderState {
    public FossilRotations fossilRotations;
    public FossilPositions fossilPositions;
    public Holder<FossilVariant> variant;
    public int size;
    public float bodyRot;
    public float renderScaleWidth;
    public float renderScaleHeight;
    public boolean isInvisibleToPlayer;
    public boolean appearsGlowing;
    public boolean isUpsideDown;
}
