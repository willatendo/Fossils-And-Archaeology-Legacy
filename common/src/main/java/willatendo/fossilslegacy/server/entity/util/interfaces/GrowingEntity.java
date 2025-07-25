package willatendo.fossilslegacy.server.entity.util.interfaces;

public interface GrowingEntity {
	void setGrowthStage(int growthStage, boolean resetHealth);

	int getGrowthStage();

	int getMaxGrowthStage();

	default double getMinHealth() {
		return 0.0D;
	}
}
