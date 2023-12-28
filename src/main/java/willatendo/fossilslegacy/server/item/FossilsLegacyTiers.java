package willatendo.fossilslegacy.server.item;

import java.util.function.Supplier;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public enum FossilsLegacyTiers implements Tier {
	ANCIENT(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.of()),
	DAGGER(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.of()),
	SCARAB_GEM(5, 4231, 10.0F, 5.0F, 17, () -> Ingredient.of()),
	ICED_MEAT(0, 4, 4.0F, 6.0F, 0, () -> Ingredient.of());

	private final int level;
	private final int uses;
	private final float speed;
	private final float damage;
	private final int enchantmentValue;
	private final Supplier<Ingredient> repairIngredient;

	private FossilsLegacyTiers(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
		this.level = level;
		this.uses = uses;
		this.speed = speed;
		this.damage = damage;
		this.enchantmentValue = enchantmentValue;
		this.repairIngredient = repairIngredient;
	}

	@Override
	public int getUses() {
		return this.uses;
	}

	@Override
	public float getSpeed() {
		return this.speed;
	}

	@Override
	public float getAttackDamageBonus() {
		return this.damage;
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}
}
