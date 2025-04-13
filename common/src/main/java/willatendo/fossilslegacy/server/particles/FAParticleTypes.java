package willatendo.fossilslegacy.server.particles;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FAParticleTypes {
    public static final SimpleRegistry<ParticleType<?>> PARTICLE_TYPES = SimpleRegistry.create(Registries.PARTICLE_TYPE, FAUtils.ID);

    public static final SimpleHolder<SimpleParticleType> DRIPPING_TAR = FAParticleTypes.register("dripping_tar", false);
    public static final SimpleHolder<SimpleParticleType> FALLING_TAR = FAParticleTypes.register("falling_tar", false);
    public static final SimpleHolder<SimpleParticleType> LANDING_TAR = register("landing_tar", false);

    private static SimpleHolder<SimpleParticleType> register(String id, boolean overrideLimiter) {
        return PARTICLE_TYPES.register(id, () -> new SimpleParticleType(overrideLimiter));
    }
}
