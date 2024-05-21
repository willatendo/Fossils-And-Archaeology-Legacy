package willatendo.fossilslegacy.server.item;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum FossilsLegacyArmorMaterials implements ArmorMaterial {
	ANCIENT("fossilslegacy:ancient", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (types) -> {
		types.put(ArmorItem.Type.BOOTS, 2);
		types.put(ArmorItem.Type.LEGGINGS, 5);
		types.put(ArmorItem.Type.CHESTPLATE, 6);
		types.put(ArmorItem.Type.HELMET, 2);
	}), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of());

	private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (types) -> {
		types.put(ArmorItem.Type.BOOTS, 13);
		types.put(ArmorItem.Type.LEGGINGS, 15);
		types.put(ArmorItem.Type.CHESTPLATE, 16);
		types.put(ArmorItem.Type.HELMET, 11);
	});

	private final String name;
	private final int durabilityMultiplier;
	private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final Supplier<Ingredient> repairIngredient;

	private FossilsLegacyArmorMaterials(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionFunctionForType, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.protectionFunctionForType = protectionFunctionForType;
		this.enchantmentValue = enchantmentValue;
		this.sound = sound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = repairIngredient;
	}

	@Override
	public int getDurabilityForType(Type type) {
		return HEALTH_FUNCTION_FOR_TYPE.get(type) * this.durabilityMultiplier;
	}

	@Override
	public int getDefenseForType(Type type) {
		return this.protectionFunctionForType.get(type);
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.sound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
