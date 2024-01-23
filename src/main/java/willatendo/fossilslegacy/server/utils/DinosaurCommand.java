package willatendo.fossilslegacy.server.utils;

import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;

public enum DinosaurCommand implements StringRepresentable {
	FOLLOW("follow"),
	STAY("stay"),
	FREE_MOVE("free_move");

	private final Component component;
	private final String order;

	private DinosaurCommand(String order) {
		this.order = order;
		this.component = FossilsLegacyUtils.translation("command", order);
	}

	public Component getComponent() {
		return this.component;
	}

	public String getOrder() {
		return this.order;
	}

	public static DinosaurCommand getOrderFromInteger(int id) {
		return DinosaurCommand.values()[id];
	}

	public static DinosaurCommand getNext(DinosaurCommand dinosaurOrder) {
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
