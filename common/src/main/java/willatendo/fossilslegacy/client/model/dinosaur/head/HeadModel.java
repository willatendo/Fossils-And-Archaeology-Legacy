package willatendo.fossilslegacy.client.model.dinosaur.head;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;

public abstract class HeadModel extends Model {
    protected final ModelPart head;

    public HeadModel(ModelPart root, String head) {
        super(root, RenderType::entityTranslucent);
        this.head = root.getChild(head);
    }

    public void setupAnim(float mouthAnimation, float yRot, float xRot) {
        this.head.yRot = yRot * 0.017453292F;
        this.head.xRot = xRot * 0.017453292F;
    }
}
