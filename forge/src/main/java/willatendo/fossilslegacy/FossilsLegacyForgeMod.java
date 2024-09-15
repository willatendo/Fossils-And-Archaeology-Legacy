package willatendo.fossilslegacy;

import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.ForgeRegistries;
import willatendo.fossilslegacy.server.config.FossilsLegacyConfig;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.event.registry.ForgeSimpleRegistryRegister;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

@Mod(FossilsLegacyUtils.ID)
public class FossilsLegacyForgeMod {
    public static final SimpleRegistry<EntityDataSerializer<?>> ENTITY_DATA_SERIALIZER = SimpleRegistry.create(ForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, FossilsLegacyUtils.ID);

    public FossilsLegacyForgeMod() {
        ForgeSimpleRegistryRegister forgeSimpleRegistryRegister = new ForgeSimpleRegistryRegister();
        FossilsLegacyMod.onInitialize(forgeSimpleRegistryRegister);
        forgeSimpleRegistryRegister.register(FossilsLegacyForgeMod.ENTITY_DATA_SERIALIZER);

        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, FossilsLegacyConfig.COMMON_SPEC);
    }
}
