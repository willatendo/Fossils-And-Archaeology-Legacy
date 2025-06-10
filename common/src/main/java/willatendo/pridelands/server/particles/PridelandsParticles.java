package willatendo.pridelands.server.particles;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import willatendo.pridelands.server.utils.PridelandsUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class PridelandsParticles {
    public static final SimpleRegistry<ParticleType<?>> PARTICLE_TYPES = SimpleRegistry.create(Registries.PARTICLE_TYPE, PridelandsUtils.ID);

    public static final SimpleHolder<SimpleParticleType> PRIDELANDS_PORTAL = PridelandsParticles.register("pridelands_portal", false);

    private static SimpleHolder<SimpleParticleType> register(String id, boolean overrideLimiter) {
        return PARTICLE_TYPES.register(id, () -> new SimpleParticleType(overrideLimiter));
    }
}
