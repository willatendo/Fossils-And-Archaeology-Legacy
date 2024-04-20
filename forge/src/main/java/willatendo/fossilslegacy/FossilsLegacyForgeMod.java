package willatendo.fossilslegacy;

import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import willatendo.fossilslegacy.platform.FossilsForgeHelper;
import willatendo.fossilslegacy.server.config.FossilsLegacyConfig;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod(FossilsLegacyUtils.ID)
public class FossilsLegacyForgeMod {
    public static final List<SimpleRegistry<?>> REGISTRIES = new ArrayList<SimpleRegistry<?>>();
    public static final SimpleRegistry<EntityDataSerializer<?>> ENTITY_DATA_SERIALIZER = SimpleRegistry.create(ForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, FossilsLegacyUtils.ID);

    public FossilsLegacyForgeMod() {
        IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FossilsForgeHelper.DEFERRED_REGISTERS.forEach(deferredRegister -> deferredRegister.register(iEventBus));

        FossilsLegacyMod.onInitialize(REGISTRIES);
        REGISTRIES.add(FossilsLegacyForgeMod.ENTITY_DATA_SERIALIZER);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FossilsLegacyConfig.COMMON_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, FossilsLegacyConfig.SERVER_SPEC);
    }
}
