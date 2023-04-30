package fossilslegacy.server.entity;

public interface GrowingEntity {
	void setGrowthStage(int growthStage);

	int getGrowthStage();

	void setRealAge(int realAge);

	int getRealAge();

	int[] getGrowthStages();

	int getAdultAge();
}
