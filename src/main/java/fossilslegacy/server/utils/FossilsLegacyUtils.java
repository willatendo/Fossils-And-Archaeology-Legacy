package fossilslegacy.server.utils;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;

public class FossilsLegacyUtils {
	public static final String ID = "fossilslegacy";

	public static ResourceLocation resource(String path) {
		return new ResourceLocation(ID, path);
	}

	public static MutableComponent translation(String type, String name) {
		return Component.translatable(type + "." + ID + "." + name);
	}

	public static MutableComponent translation(String type, String name, Object... args) {
		return Component.translatable(type + "." + ID + "." + name, args);
	}
}
