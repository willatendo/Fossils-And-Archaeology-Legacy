package willatendo.fossilslegacy.server.entity;

public interface HungryAnimal {
	void setHunger(int hunger);

	void decreaseHunger();

	int getHunger();

	int getMaxHunger();
}
