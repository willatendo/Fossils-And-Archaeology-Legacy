package willatendo.fossilslegacy.server.fluid;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyFluidTags {
	public static final TagKey<Fluid> PERMAFROST_FREEZABLE = create("permafrost_freezable");

	public static TagKey<Fluid> create(String name) {
		return TagKey.create(Registries.FLUID, FossilsLegacyUtils.resource(name));
	}
}
