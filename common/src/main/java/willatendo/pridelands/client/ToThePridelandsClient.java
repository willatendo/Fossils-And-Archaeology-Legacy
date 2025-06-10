package willatendo.pridelands.client;

import willatendo.pridelands.client.particle.PridelandsPortalParticle;
import willatendo.pridelands.server.particles.PridelandsParticles;
import willatendo.simplelibrary.client.event.registry.ParticleRegistry;

public final class ToThePridelandsClient {
    public static void particleRegisterEvent(ParticleRegistry particleRegistry) {
        particleRegistry.registerSprite(PridelandsParticles.PRIDELANDS_PORTAL.get(), spriteSet -> new PridelandsPortalParticle.Provider(spriteSet, true));
    }
}
