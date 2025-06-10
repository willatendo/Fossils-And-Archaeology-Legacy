package willatendo.pridelands.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class PridelandsPortalParticle extends TextureSheetParticle {
    private final double xStart;
    private final double yStart;
    private final double zStart;

    public PridelandsPortalParticle(ClientLevel clientLevel, double x, double y, double z, double xD, double yD, double zD, boolean isPridelands) {
        super(clientLevel, x, y, z);
        this.xd = xD;
        this.yd = yD;
        this.zd = zD;
        this.x = x;
        this.y = y;
        this.z = z;
        this.xStart = this.x;
        this.yStart = this.y;
        this.zStart = this.z;
        this.quadSize = 0.1F * (this.random.nextFloat() * 0.2F + 0.5F);
        float f = this.random.nextFloat() * 0.6F + 0.4F;
        this.rCol = this.gCol = this.bCol = f;
        if (isPridelands) {
            this.rCol *= 1.0F;
            this.gCol *= 0.7F;
            this.bCol *= 0.1F;
        }
        this.lifetime = (int) (Math.random() * 10.0) + 40;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void move(double x, double y, double z) {
        this.setBoundingBox(this.getBoundingBox().move(x, y, z));
        this.setLocationFromBoundingbox();
    }

    @Override
    public float getQuadSize(float scaleFactor) {
        float remaining = ((float) this.age + scaleFactor) / (float) this.lifetime;
        remaining = 1.0F - remaining;
        remaining *= remaining;
        remaining = 1.0F - remaining;
        return this.quadSize * remaining;
    }

    @Override
    public int getLightColor(float partialTick) {
        int lightColor = super.getLightColor(partialTick);
        float remaning = (float) this.age / (float) this.lifetime;
        remaning *= remaning;
        remaning *= remaning;
        int j = lightColor & 255;
        int k = lightColor >> 16 & 255;
        k += (int) (remaning * 15.0F * 16.0F);
        if (k > 240) {
            k = 240;
        }

        return j | k << 16;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            float f = (float) this.age / (float) this.lifetime;
            float f1 = -f + f * f * 2.0F;
            float f2 = 1.0F - f1;
            this.x = this.xStart + this.xd * (double) f2;
            this.y = this.yStart + this.yd * (double) f2 + (double) (1.0F - f);
            this.z = this.zStart + this.zd * (double) f2;
            this.setPos(this.x, this.y, this.z);
        }
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;
        private final boolean isPridelands;

        public Provider(SpriteSet sprite, boolean isPridelands) {
            this.sprite = sprite;
            this.isPridelands = isPridelands;
        }

        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            PridelandsPortalParticle pridelandsPortalParticle = new PridelandsPortalParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, this.isPridelands);
            pridelandsPortalParticle.pickSprite(this.sprite);
            return pridelandsPortalParticle;
        }
    }
}
