package fossilslegacy.server.utils;

import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;

public enum DinosaurOrder implements StringRepresentable {
	FOLLOW("follow"),
	STAY("stay"),
	FREE_MOVE("free_move");

	private final Component component;
	private final String order;

	private DinosaurOrder(String order) {
		this.order = order;
		this.component = FossilsLegacyUtils.translation("order", order);
	}

	public Component getComponent() {
		return this.component;
	}

	public String getOrder() {
		return this.order;
	}

	public Component getName() {
		return FossilsLegacyUtils.translation("order", this.getOrder());
	}

	public static DinosaurOrder getOrderFromInteger(int id) {
		return DinosaurOrder.values()[id];
	}

	public static DinosaurOrder getNext(DinosaurOrder dinosaurOrder) {
		if (dinosaurOrder == STAY) {
			return FOLLOW;
		} else if (dinosaurOrder == FOLLOW) {
			return FREE_MOVE;
		} else if (dinosaurOrder == FREE_MOVE) {
			return STAY;
		} else {
			return null;
		}
	}

	@Override
	public String getSerializedName() {
		return this.order;
	}
}
