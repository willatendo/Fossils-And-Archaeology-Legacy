package willatendo.fossilslegacy.server.entity;

public interface HungryAnimal {
	void setHunger(int hunger);

	int getHunger();

	int getMaxHunger();

	default void decreaseHunger() {
		this.decreaseHunger(1);
	}

	default void decreaseHunger(int value) {
		this.setHunger(this.getMaxHunger() - value);
	}

	default void increaseHunger() {
		this.increaseHunger(1);
	}

	default void increaseHunger(int value) {
		if (this.getHunger() + value > this.getMaxHunger()) {
			this.setHunger(this.getMaxHunger());
		} else {
			this.setHunger(this.getHunger() + value);
		}
	}
}
