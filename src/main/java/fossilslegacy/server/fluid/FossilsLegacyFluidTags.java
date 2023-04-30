package fossilslegacy.server.fluid;

import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public class FossilsLegacyFluidTags {
	public static final TagKey<Fluid> PERMAFROST_FREEZABLE = create("permafrost_freezable");

	public static TagKey<Fluid> create(String name) {
		return TagKey.create(Registries.FLUID, FossilsLegacyUtils.resource(name));
	}
}
