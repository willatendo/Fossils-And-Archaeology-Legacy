package willatendo.fossilslegacy.server.utils;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;

public enum DinosaurCommand implements StringRepresentable {
	FOLLOW("follow"),
	STAY("stay"),
	FREE_MOVE("free_move");

	public static final Map<String, DinosaurCommand> COMMANDS = new HashMap<String, DinosaurCommand>();
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

	public static DinosaurCommand getRandom() {
		RandomSource randomSource = RandomSource.create();
		return DinosaurCommand.values()[randomSource.nextInt(3)];
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

	public static void save(CompoundTag compoundTag, DinosaurCommand dinosaurCommand) {
		compoundTag.putString("Command", dinosaurCommand.getOrder());
	}

	public static DinosaurCommand load(CompoundTag compoundTag) {
		return COMMANDS.get(compoundTag.getString("Command"));
	}

	@Override
	public String getSerializedName() {
		return this.order;
	}

	static {
		COMMANDS.put("follow", FOLLOW);
		COMMANDS.put("stay", STAY);
		COMMANDS.put("free_move", FREE_MOVE);
	}
}
