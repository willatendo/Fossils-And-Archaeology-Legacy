package willatendo.fossilslegacy;

import net.minecraft.network.syncher.EntityDataSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import willatendo.fossilslegacy.server.config.FossilsLegacyConfig;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.event.registry.NeoforgeSimpleRegistryRegister;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

@Mod(FossilsLegacyUtils.ID)
public class FossilsLegacyNeoforgeMod {
    public static final SimpleRegistry<EntityDataSerializer<?>> ENTITY_DATA_SERIALIZER = SimpleRegistry.create(NeoForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, FossilsLegacyUtils.ID);

    public FossilsLegacyNeoforgeMod(ModContainer modContainer, IEventBus iEventBus) {
        NeoforgeSimpleRegistryRegister neoforgeSimpleRegistryRegister = new NeoforgeSimpleRegistryRegister(iEventBus);
        FossilsLegacyMod.onInitialize(neoforgeSimpleRegistryRegister);
        neoforgeSimpleRegistryRegister.register(FossilsLegacyNeoforgeMod.ENTITY_DATA_SERIALIZER);

        modContainer.registerConfig(ModConfig.Type.COMMON, FossilsLegacyConfig.COMMON_SPEC);
    }
}
