package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.client.render.layer.IchthyosaurusCarryingItemLayer;
import willatendo.fossilslegacy.client.state.IchthyosaurusRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Ichthyosaurus;

public class IchthyosaurusRenderer extends DataDrivenModelMobRenderer<Ichthyosaurus, IchthyosaurusRenderState> {
    public IchthyosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.5F);
        this.addLayer(new IchthyosaurusCarryingItemLayer(this));
    }

    @Override
    public IchthyosaurusRenderState createRenderState() {
        return new IchthyosaurusRenderState();
    }

    @Override
    public void extractRenderState(Ichthyosaurus ichthyosaurus, IchthyosaurusRenderState ichthyosaurusRenderState, float partialTick) {
        super.extractRenderState(ichthyosaurus, ichthyosaurusRenderState, partialTick);
        IchthyosaurusRenderState.extractHeldItemRenderState(ichthyosaurus, ichthyosaurusRenderState, this.itemModelResolver);
        ichthyosaurusRenderState.isMoving = ichthyosaurus.getDeltaMovement().horizontalDistanceSqr() > 1.0E-7;
    }
}
