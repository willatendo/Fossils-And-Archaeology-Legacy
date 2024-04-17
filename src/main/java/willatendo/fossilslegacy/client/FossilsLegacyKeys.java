package willatendo.fossilslegacy.client;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;

public class FossilsLegacyKeys {
	public static final KeyMapping SINK = new KeyMapping("key.fossilslegacy.sink", 66, "key.categories.movement");

	public static void init() {
		KeyBindingHelper.registerKeyBinding(SINK);
	}
}
