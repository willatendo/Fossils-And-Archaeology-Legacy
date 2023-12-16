package willatendo.fossilslegacy.server.entity;

public interface GrowingEntity {
	void setGrowthStage(int growthStage);

	int getGrowthStage();

	int maxGrowthStage();

	double getMinHealth();
}
