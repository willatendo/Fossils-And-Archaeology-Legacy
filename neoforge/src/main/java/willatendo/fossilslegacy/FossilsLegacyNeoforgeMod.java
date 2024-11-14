package willatendo.fossilslegacy;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.event.registry.NeoforgeSimpleRegistryRegister;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

@Mod(FossilsLegacyUtils.ID)
public class FossilsLegacyNeoforgeMod {
    public static final SimpleRegistry<EntityDataSerializer<?>> ENTITY_DATA_SERIALIZER = SimpleRegistry.create(NeoForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, FossilsLegacyUtils.ID);
    public static final DeferredRegister<MapDecorationType> MAP_DECORATION_TYPES = DeferredRegister.create(Registries.MAP_DECORATION_TYPE, FossilsLegacyUtils.ID);

    public FossilsLegacyNeoforgeMod(IEventBus iEventBus) {
        NeoforgeSimpleRegistryRegister neoforgeSimpleRegistryRegister = new NeoforgeSimpleRegistryRegister(iEventBus);
        FossilsLegacyMod.onInitialize(neoforgeSimpleRegistryRegister);
        neoforgeSimpleRegistryRegister.register(FossilsLegacyNeoforgeMod.ENTITY_DATA_SERIALIZER);
        MAP_DECORATION_TYPES.register(iEventBus);
    }
}
