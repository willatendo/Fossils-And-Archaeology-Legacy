package willatendo.fossilslegacy.server.particles;

import net.minecraft.core.particles.SimpleParticleType;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.ParticleTypeRegistry;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FAParticleTypes {
    public static final ParticleTypeRegistry PARTICLE_TYPES = SimpleRegistry.createParticle(FAUtils.ID);

    public static final SimpleHolder<SimpleParticleType> DRIPPING_TAR = PARTICLE_TYPES.registerSimple("dripping_tar", false);
    public static final SimpleHolder<SimpleParticleType> FALLING_TAR = PARTICLE_TYPES.registerSimple("falling_tar", false);
    public static final SimpleHolder<SimpleParticleType> LANDING_TAR = PARTICLE_TYPES.registerSimple("landing_tar", false);
}
