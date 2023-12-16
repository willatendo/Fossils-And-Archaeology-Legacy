package willatendo.fossilslegacy.server.entity;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import willatendo.fossilslegacy.server.utils.DinosaurCommand;

public interface PlayerCommandableAccess {
	DinosaurCommand getCommand();

	void setCommand(DinosaurCommand dinosaurOrder);

	TagKey<Item> commandItems();

	default boolean isOrderedToSit() {
		return this.getCommand() == DinosaurCommand.STAY;
	}
}
