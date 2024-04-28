package willatendo.fossilslegacy;

import net.minecraft.network.syncher.EntityDataSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import willatendo.fossilslegacy.server.config.FossilsLegacyConfig;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod(FossilsLegacyUtils.ID)
public class FossilsLegacyNeoforgeMod {
    public static final List<SimpleRegistry<?>> REGISTRIES = new ArrayList<SimpleRegistry<?>>();
    public static final SimpleRegistry<EntityDataSerializer<?>> ENTITY_DATA_SERIALIZER = SimpleRegistry.create(NeoForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, FossilsLegacyUtils.ID);

    public FossilsLegacyNeoforgeMod(IEventBus modEventBus) {
        FossilsLegacyMod.onInitialize(REGISTRIES);
        REGISTRIES.add(FossilsLegacyNeoforgeMod.ENTITY_DATA_SERIALIZER);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, FossilsLegacyConfig.CLIENT_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FossilsLegacyConfig.COMMON_SPEC);
    }
}
