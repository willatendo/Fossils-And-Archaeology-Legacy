package willatendo.fossilslegacy.server.entity.util.interfaces;

public interface HungerAccessor {
    void setHunger(int hunger);

    int getHunger();

    int getMaxHunger();

    default void decreaseHunger() {
        this.decreaseHunger(1);
    }

    default void decreaseHunger(int value) {
        int newHunger = this.getHunger() - value;
        if (!(newHunger < 0)) {
            this.setHunger(newHunger);
        } else {
            this.setHunger(0);
        }
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
