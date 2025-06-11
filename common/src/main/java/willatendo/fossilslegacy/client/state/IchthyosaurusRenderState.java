package willatendo.fossilslegacy.client.state;

import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.item.ItemDisplayContext;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Ichthyosaurus;

public class IchthyosaurusRenderState extends DinosaurRenderState {
    public final ItemStackRenderState heldItem = new ItemStackRenderState();
    public boolean isMoving;

    public static void extractHeldItemRenderState(Ichthyosaurus ichthyosaurus, IchthyosaurusRenderState reusedState, ItemModelResolver itemModelResolver) {
        itemModelResolver.updateForLiving(reusedState.heldItem, ichthyosaurus.getMainHandItem(), ItemDisplayContext.GROUND, false, ichthyosaurus);
    }
}
