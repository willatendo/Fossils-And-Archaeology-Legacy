package willatendo.fossilslegacy;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import willatendo.fossilslegacy.platform.FossilsForgeHelper;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod(FossilsLegacyUtils.ID)
public class FossilsLegacyForgeMod {
    public static final List<SimpleRegistry<?>> REGISTRIES = new ArrayList<SimpleRegistry<?>>();

    public FossilsLegacyForgeMod() {
        IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FossilsForgeHelper.DEFERRED_REGISTERS.forEach(deferredRegister -> deferredRegister.register(iEventBus));

        FossilsLegacyMod.onInitialize(REGISTRIES);
    }
}
