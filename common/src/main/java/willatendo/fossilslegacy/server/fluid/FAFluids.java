package willatendo.fossilslegacy.server.fluid;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import willatendo.fossilslegacy.platform.FAModloaderHelper;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FAFluids {
    public static final SimpleRegistry<Fluid> FLUIDS = SimpleRegistry.create(Registries.FLUID, FAUtils.ID);

    public static final SimpleHolder<TarFluid> FLOWING_TAR = FLUIDS.register("flowing_tar", FAModloaderHelper.INSTANCE::getFlowingTar);
    public static final SimpleHolder<TarFluid> TAR = FLUIDS.register("tar", FAModloaderHelper.INSTANCE::getTar);
}
