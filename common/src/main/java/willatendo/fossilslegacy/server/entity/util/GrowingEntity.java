package willatendo.fossilslegacy.server.entity.util;

public interface GrowingEntity {
	void setGrowthStage(int growthStage);

	int getGrowthStage();

	int getMaxGrowthStage();

	default double getMinHealth() {
		return 0.0D;
	}
}
