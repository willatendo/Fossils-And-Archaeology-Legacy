package willatendo.fossilslegacy;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.event.registry.ForgeSimpleRegistryRegister;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

@Mod(FossilsLegacyUtils.ID)
public class FossilsLegacyForgeMod {
    public static final SimpleRegistry<EntityDataSerializer<?>> ENTITY_DATA_SERIALIZER = SimpleRegistry.create(ForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, FossilsLegacyUtils.ID);
    public static final DeferredRegister<MapDecorationType> MAP_DECORATION_TYPES = DeferredRegister.create(Registries.MAP_DECORATION_TYPE, FossilsLegacyUtils.ID);

    public FossilsLegacyForgeMod(IEventBus iEventBus) {
        ForgeSimpleRegistryRegister forgeSimpleRegistryRegister = new ForgeSimpleRegistryRegister();
        FossilsLegacyMod.onInitialize(forgeSimpleRegistryRegister);
        forgeSimpleRegistryRegister.register(FossilsLegacyForgeMod.ENTITY_DATA_SERIALIZER);
        MAP_DECORATION_TYPES.register(iEventBus);
    }
}
