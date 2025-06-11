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
}
