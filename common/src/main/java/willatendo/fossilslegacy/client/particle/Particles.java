package willatendo.fossilslegacy.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.DripParticle;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import willatendo.fossilslegacy.server.fluid.FAFluids;
import willatendo.fossilslegacy.server.particles.FAParticleTypes;

public final class Particles {
    public static TextureSheetParticle createTarHangParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        DripParticle dripParticle = new DripParticle.DripHangParticle(clientLevel, x, y, z, FAFluids.TAR.get(), FAParticleTypes.FALLING_TAR.get());
        dripParticle.setColor(0.01F, 0.01F, 0.0F);
        return dripParticle;
    }

    public static TextureSheetParticle createTarFallParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        DripParticle dripParticle = new DripParticle.FallAndLandParticle(clientLevel, x, y, z, FAFluids.TAR.get(), FAParticleTypes.LANDING_TAR.get());
        dripParticle.setColor(0.01F, 0.01F, 0.0F);
        return dripParticle;
    }

    public static TextureSheetParticle createTarLandParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        DripParticle dripParticle = new DripParticle.DripLandParticle(clientLevel, x, y, z, FAFluids.TAR.get());
        dripParticle.setColor(0.01F, 0.01F, 0.0F);
        return dripParticle;
    }
}
