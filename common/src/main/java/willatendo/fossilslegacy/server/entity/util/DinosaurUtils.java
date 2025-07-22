package willatendo.fossilslegacy.server.entity.util;

public class DinosaurUtils {
    public static float[] getStepHeights(int growthStages, float minStepHeight, float maxStepHeight) {
        float[] stepHeights = new float[growthStages + 1];
        float diff = maxStepHeight - minStepHeight;
        float change = diff / growthStages;
        for (int i = 0; i < (growthStages + 1); i++) {
            stepHeights[i] = minStepHeight + (change * ((float) i));
        }
        return stepHeights;
    }

    public static float[] getHealths(int growthStages, float minHealth, float maxHealth) {
        float[] healths = new float[growthStages + 1];
        float diff = maxHealth - minHealth;
        float change = (float) Math.floor(diff / growthStages);
        for (int i = 0; i < growthStages + 1; i++) {
            if (i != growthStages + 1) {
                healths[i] = minHealth + (change * ((float) i));
            } else {
                healths[i] = maxHealth;
            }
        }
        return healths;
    }
}
