package fossilslegacy.client.model.triceratops;

import fossilslegacy.server.entity.Triceratops;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

public abstract class AbstractTriceratopsModel extends HierarchicalModel<Triceratops> {
	protected final ModelPart root;
	protected final ModelPart head;

	public AbstractTriceratopsModel(ModelPart root, ModelPart head) {
		this.root = root;
		this.head = head;
	}

	@Override
	public ModelPart root() {
		return this.root;
	}

	protected void applyHeadRotation(Triceratops triceratops, float x, float y, float z) {
		x = Mth.clamp(x, -30.0F, 30.0F);
		y = Mth.clamp(y, -25.0F, 45.0F);

		this.head.yRot = x * ((float) Math.PI / 180F);
		this.head.xRot = y * ((float) Math.PI / 180F);
	}
}
