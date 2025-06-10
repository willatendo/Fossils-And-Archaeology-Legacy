package willatendo.pridelands.server.item;

import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ClearAllStatusEffectsConsumeEffect;

public final class PridelandsConsumables {
    public static final Consumable ZEBRA_MILK_PRIDESTONE_JAR = Consumables.defaultDrink().onConsume(ClearAllStatusEffectsConsumeEffect.INSTANCE).build();
}
