package willatendo.fossilslegacy.client.state;

import net.minecraft.util.Mth;

public class DinosaurRenderState extends ChromosomedEntityRenderState {
    public int growthStage;
    public boolean isTame;
    public boolean isOrderedToSit;
    public boolean inWater;
    public boolean isAttacking = false;
    public float renderScaleWidth;
    public float renderScaleHeight;
    public boolean isWet = false;
    public float wetShade;
    public float interestedAngle;
    public float interestedAngleO;
    public float shakeAnim;
    public float shakeAnimO;
    public boolean isMoving;
    public boolean isTranquilized;

    public float getHeadRollAngle(float partialTicks) {
        return Mth.lerp(partialTicks, this.interestedAngleO, this.interestedAngle) * 0.15f * (float) Math.PI;
    }

    public float getBodyRollAngle(float ageInTicks, float max) {
        float f = (Mth.lerp(ageInTicks, this.shakeAnimO, this.shakeAnim) + max) / 1.8F;
        if (f < 0.0F) {
            f = 0.0F;
        } else if (f > 1.0F) {
            f = 1.0F;
        }

        return Mth.sin(f * (float) Math.PI) * Mth.sin(f * (float) Math.PI * 11.0F) * 0.15F * (float) Math.PI;
    }
}
