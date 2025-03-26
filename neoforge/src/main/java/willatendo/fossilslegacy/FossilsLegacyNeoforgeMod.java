package willatendo.fossilslegacy;

import net.minecraft.network.syncher.EntityDataSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.event.registry.NeoforgeSimpleRegistryRegister;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

@Mod(FAUtils.ID)
public class FossilsLegacyNeoforgeMod {
    public static final SimpleRegistry<EntityDataSerializer<?>> ENTITY_DATA_SERIALIZER = SimpleRegistry.create(NeoForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, FAUtils.ID);

    public FossilsLegacyNeoforgeMod(IEventBus iEventBus) {
        NeoforgeSimpleRegistryRegister neoforgeSimpleRegistryRegister = new NeoforgeSimpleRegistryRegister(iEventBus);
        FossilsLegacyMod.onInitialize(neoforgeSimpleRegistryRegister);
        neoforgeSimpleRegistryRegister.register(FossilsLegacyNeoforgeMod.ENTITY_DATA_SERIALIZER);
    }
}
