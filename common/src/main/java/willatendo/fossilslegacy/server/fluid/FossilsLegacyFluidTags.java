package willatendo.fossilslegacy.server.fluid;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.TagRegister;

public class FossilsLegacyFluidTags {
	public static final TagRegister<Fluid> FLUID_TAGS = TagRegister.create(Registries.FLUID, FossilsLegacyUtils.ID);

	public static final TagKey<Fluid> PERMAFROST_FREEZABLE = FLUID_TAGS.register("permafrost_freezable");
}
