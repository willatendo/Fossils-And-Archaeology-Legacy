package willatendo.fossilslegacy;

import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.event.registry.ForgeSimpleRegistryRegister;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

@Mod(FAUtils.ID)
public class FossilsLegacyForgeMod {
    public static final SimpleRegistry<EntityDataSerializer<?>> ENTITY_DATA_SERIALIZER = SimpleRegistry.create(ForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, FAUtils.ID);

    public FossilsLegacyForgeMod() {
        ForgeSimpleRegistryRegister forgeSimpleRegistryRegister = new ForgeSimpleRegistryRegister();
        FossilsLegacyMod.onInitialize(forgeSimpleRegistryRegister);
        forgeSimpleRegistryRegister.register(FossilsLegacyForgeMod.ENTITY_DATA_SERIALIZER);
    }
}
