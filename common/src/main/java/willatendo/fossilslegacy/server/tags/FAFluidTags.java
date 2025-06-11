package willatendo.fossilslegacy.server.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FAFluidTags {
    private static final TagRegister<Fluid> FLUID_TAGS = TagRegister.create(Registries.FLUID, FAUtils.ID);

    public static final TagKey<Fluid> PERMAFROST_FREEZABLE = FLUID_TAGS.register("permafrost_freezable");
    public static final TagKey<Fluid> TAR = FLUID_TAGS.register("tar");
}
