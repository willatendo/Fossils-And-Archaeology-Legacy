package willatendo.fossilslegacy.server.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyDamageTypes {
    public static final ResourceKey<DamageType> ANIMAL_STARVE = create("animal_starve");
    public static final ResourceKey<DamageType> DILOPHOSAURUS_ENVENOMATION = create("dilophosaurus_envenomation");
    public static final ResourceKey<DamageType> JAVELIN = create("javelin");

    public static ResourceKey<DamageType> create(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, FossilsLegacyUtils.resource(name));
    }

    public static void bootstrap(BootstrapContext<DamageType> bootstrapContext) {
        bootstrapContext.register(ANIMAL_STARVE, new DamageType("animal_starve", 0.1F));
        bootstrapContext.register(DILOPHOSAURUS_ENVENOMATION, new DamageType("dilophosaurus_envenomation", 0.1F));
        bootstrapContext.register(JAVELIN, new DamageType("javelin", 0.1F));
    }
}
