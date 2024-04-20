package willatendo.fossilslegacy.server.entity.pregnant;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.animal.horse.Mule;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.entity.HungryAnimal;
import willatendo.fossilslegacy.server.entity.Mammoth;
import willatendo.fossilslegacy.server.entity.Smilodon;
import willatendo.fossilslegacy.server.entity.TameAccessor;
import willatendo.fossilslegacy.server.entity.TicksToBirth;
import willatendo.fossilslegacy.server.utils.SyringeAnimals;

public interface PregnantAnimal<T extends Entity> extends TicksToBirth<T> {
	int getRemainingPregnancyTime();

	void setRemainingPregnancyTime(int remainingPregnancyTime);

	@Override
	default int getRemainingTime() {
		return this.getRemainingPregnancyTime();
	}

	@Override
	default void setRemainingTime(int remainingPregnancyTime) {
		this.setRemainingPregnancyTime(remainingPregnancyTime);
	}

	SyringeAnimals getPregnancy();

	void setPregnancy(SyringeAnimals syringeAnimals);

	T getBaseEntity(Level level);

	static <T extends Entity> T getFromLivingEntity(LivingEntity livingEntity, Level level) {
		T finalEntity = null;
		if (livingEntity instanceof PregnantAnimal) {
			return null;
		}
		if (livingEntity instanceof Cat) {
			finalEntity = (T) EntityType.CAT.create(level);
		}
		if (livingEntity instanceof Cow) {
			finalEntity = (T) EntityType.COW.create(level);
		}
		if (livingEntity instanceof Dolphin) {
			finalEntity = (T) EntityType.DOLPHIN.create(level);
		}
		if (livingEntity instanceof Donkey) {
			finalEntity = (T) EntityType.DONKEY.create(level);
		}
		if (livingEntity instanceof Fox) {
			finalEntity = (T) EntityType.FOX.create(level);
		}
		if (livingEntity instanceof Goat) {
			finalEntity = (T) EntityType.GOAT.create(level);
		}
		if (livingEntity instanceof Horse) {
			finalEntity = (T) EntityType.HORSE.create(level);
		}
		if (livingEntity instanceof Llama) {
			finalEntity = (T) EntityType.LLAMA.create(level);
		}
		if (livingEntity instanceof Mule) {
			finalEntity = (T) EntityType.MULE.create(level);
		}
		if (livingEntity instanceof Ocelot) {
			finalEntity = (T) EntityType.OCELOT.create(level);
		}
		if (livingEntity instanceof Panda) {
			finalEntity = (T) EntityType.PANDA.create(level);
		}
		if (livingEntity instanceof Pig) {
			finalEntity = (T) EntityType.PIG.create(level);
		}
		if (livingEntity instanceof PolarBear) {
			finalEntity = (T) EntityType.POLAR_BEAR.create(level);
		}
		if (livingEntity instanceof Rabbit) {
			finalEntity = (T) EntityType.RABBIT.create(level);
		}
		if (livingEntity instanceof Sheep) {
			finalEntity = (T) EntityType.SHEEP.create(level);
		}
		if (livingEntity instanceof Wolf) {
			finalEntity = (T) EntityType.WOLF.create(level);
		}
		if (livingEntity instanceof Mammoth) {
			finalEntity = (T) FossilsLegacyEntityTypes.MAMMOTH.get().create(level);
		}
		if (livingEntity instanceof Smilodon) {
			finalEntity = (T) FossilsLegacyEntityTypes.SMILODON.get().create(level);
		}
		return finalEntity;
	}

	static PregnantAnimal createFromLiving(LivingEntity livingEntity, Level level) {
		livingEntity.remove(RemovalReason.DISCARDED);
		Entity toCreate = null;
		if (livingEntity instanceof Cat) {
			toCreate = FossilsLegacyEntityTypes.PREGNANT_CAT.get().create(level);
		}
		if (livingEntity instanceof Cow) {
			toCreate = FossilsLegacyEntityTypes.PREGNANT_COW.get().create(level);
		}
		if (livingEntity instanceof Dolphin) {
			toCreate = FossilsLegacyEntityTypes.PREGNANT_DOLPHIN.get().create(level);
		}
		if (livingEntity instanceof Donkey) {
			toCreate = FossilsLegacyEntityTypes.PREGNANT_DONKEY.get().create(level);
		}
		if (livingEntity instanceof Fox) {
			toCreate = FossilsLegacyEntityTypes.PREGNANT_FOX.get().create(level);
		}
		if (livingEntity instanceof Goat) {
			toCreate = FossilsLegacyEntityTypes.PREGNANT_GOAT.get().create(level);
		}
		if (livingEntity instanceof Horse) {
			toCreate = FossilsLegacyEntityTypes.PREGNANT_HORSE.get().create(level);
		}
		if (livingEntity instanceof Llama) {
			toCreate = FossilsLegacyEntityTypes.PREGNANT_LLAMA.get().create(level);
		}
		if (livingEntity instanceof Mule) {
			toCreate = FossilsLegacyEntityTypes.PREGNANT_MULE.get().create(level);
		}
		if (livingEntity instanceof Ocelot) {
			toCreate = FossilsLegacyEntityTypes.PREGNANT_OCELOT.get().create(level);
		}
		if (livingEntity instanceof Panda) {
			toCreate = FossilsLegacyEntityTypes.PREGNANT_PANDA.get().create(level);
		}
		if (livingEntity instanceof Pig) {
			toCreate = FossilsLegacyEntityTypes.PREGNANT_PIG.get().create(level);
		}
		if (livingEntity instanceof PolarBear) {
			toCreate = FossilsLegacyEntityTypes.PREGNANT_POLAR_BEAR.get().create(level);
		}
		if (livingEntity instanceof Rabbit) {
			toCreate = FossilsLegacyEntityTypes.PREGNANT_RABBIT.get().create(level);
		}
		if (livingEntity instanceof Sheep sheep) {
			toCreate = FossilsLegacyEntityTypes.PREGNANT_SHEEP.get().create(level);
			((PregnantSheep) toCreate).setColor(sheep.getColor());
		}
		if (livingEntity instanceof Wolf) {
			toCreate = FossilsLegacyEntityTypes.PREGNANT_WOLF.get().create(level);
		}
		if (livingEntity instanceof Mammoth) {
			toCreate = FossilsLegacyEntityTypes.PREGNANT_MAMMOTH.get().create(level);
		}
		if (livingEntity instanceof Smilodon) {
			toCreate = FossilsLegacyEntityTypes.PREGNANT_SMILODON.get().create(level);
		}
		toCreate.moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), livingEntity.getYRot(), livingEntity.getXRot());
		level.addFreshEntity(toCreate);
		return (PregnantAnimal) toCreate;
	}

	default void onRemove(Mob original, Entity replaced) {
	}

	@Override
	default void onEntityTicksComplete(Mob mob, Level level) {
		Entity replaced = this.getBaseEntity(level);
		replaced.moveTo(mob.getX(), mob.getY(), mob.getZ(), mob.getYRot(), mob.getXRot());
		level.addFreshEntity(replaced);
		if (replaced instanceof TameAccessor tameAccessor) {
			tameAccessor.setOwnerUUID(((TameAccessor) mob).getOwnerUUID());
		}
		if (replaced instanceof HungryAnimal hungryAnimal) {
			hungryAnimal.setHunger(((HungryAnimal) mob).getHunger());
		}
		this.onRemove(mob, replaced);
	}
}
