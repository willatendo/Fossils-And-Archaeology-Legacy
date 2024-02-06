package willatendo.fossilslegacy.server.entity;

public interface GrowingEntity {
	void setGrowthStage(int growthStage);

	int getGrowthStage();

	int maxGrowthStage();

	default double getMinHealth() {
		return 0.0D;
	}
}
